#!/usr/bin/env bash

if [ -z `which sed` ]; then
  echo "Missing sed"
  exit 1
fi

if [ -z "$1" ]; then
  echo "Missing type"
  exit 1
fi

THISMOD="covalent"
DATAROOT="../src/main/resources/data"
ASSETS="../src/main/resources/assets/${THISMOD}"
DATA="${DATAROOT}/${THISMOD}"
A=(${1//:/ })

if [ -z "${A[1]}" ]; then
  NAMESPACE="minecraft"
  TYPE="${A[0]}"
else
  NAMESPACE="${A[0]}"
  TYPE="${A[1]}"
fi

copy_replace() {
  SRC=$1
  DEST=$2
  IT=$3

  cp "${SRC}" "${DEST}"
  sed -i "s/TYPE/${TYPE}/g" "${DEST}"
  sed -i "s/NAMESPACE/${NAMESPACE}/g" "${DEST}"
  sed -i "s/THISMOD/${THISMOD}/g" "${DEST}"

  if [ -n "${IT}" ]; then
    sed -i "s/?/${IT}/g" "${DEST}"
  fi
}

add_lang_strings() {
  NAME="$(tr '[:lower:]' '[:upper:]' <<< ${TYPE:0:1})${TYPE:1}"
  LANGFILE="${ASSETS}/lang/en_us.json"
  remove_last_entry "${LANGFILE}" "}"

  # add new lang entries
  {
    echo "  \"block.${THISMOD}.${TYPE}_barrel\": \"${NAME} Barrel\",";
    echo "  \"block.${THISMOD}.${TYPE}_bookshelf_chest\": \"${NAME} Bookshelf Chest\","
    echo "  \"block.${THISMOD}.${TYPE}_crate_open\": \"${NAME} Crate\",";
    echo "  \"block.${THISMOD}.${TYPE}_crate_sealed\": \"${NAME} Sealed Crate\""
    echo "}"
  } >> $LANGFILE
}

add_tags() {
  # barrels
  for f in "${DATAROOT}/forge/tags/blocks/barrels.json" "${DATAROOT}/forge/tags/items/barrels.json"
  do
    if [ -e "$f" ]; then
      remove_last_entry "${f}" "]" "}"

      {
        echo "    \"${THISMOD}:${TYPE}_barrel\"";
        echo "  ]"
        echo "}"
      } >> $f
      strip_empty_lines $f
    fi
  done

  # bookshelves
  for f in "${DATAROOT}/forge/tags/blocks/bookshelves.json" "${DATAROOT}/forge/tags/items/bookshelves.json"
  do
    if [ -e "$f" ]; then
      remove_last_entry "${f}" "]" "}"

      {
        echo "    \"${THISMOD}:${TYPE}_bookshelf_chest\"";
        echo "  ]"
        echo "}"
      } >> $f
      strip_empty_lines $f
    fi
  done

  # crates
  for f in "${DATA}/tags/blocks/crates.json" "${DATA}/tags/items/crates.json"
  do
    if [ -e "$f" ]; then
      remove_last_entry "${f}" "]" "}"

      {
        echo "    \"${THISMOD}:${TYPE}_crate_open\",";
        echo "    \"${THISMOD}:${TYPE}_crate_sealed\"";
        echo "  ]"
        echo "}"
      } >> $f
      strip_empty_lines $f
    fi
  done
}

remove_last_entry() {
  sed -i ':a;N;$!ba;s/"\n/",\n/g' "${1}" # add a comma after the last entry
  sed -i "s/${2}//g" "${1}" # remove bracket
  if [ -n "$3" ]; then
    sed -i "s/${3}//g" "${1}" # remove bracket
  fi
}

strip_empty_lines() {
  sed -i '/^ *$/d' "${1}"
}

# barrels
copy_replace "barrel_blockstate" "${ASSETS}/blockstates/${TYPE}_barrel.json"
copy_replace "barrel_item_model" "${ASSETS}/models/item/${TYPE}_barrel.json"
copy_replace "barrel_block_model" "${ASSETS}/models/block/${TYPE}_barrel.json"
copy_replace "barrel_open_block_model" "${ASSETS}/models/block/${TYPE}_barrel_open.json"
copy_replace "barrel_loot_table" "${DATA}/loot_tables/blocks/${TYPE}_barrel.json"
copy_replace "barrel_recipe" "${DATA}/recipes/crafting/${TYPE}_barrel.json"

# bookshelf chests
copy_replace "bookshelf_chest_blockstate" "${ASSETS}/blockstates/${TYPE}_bookshelf_chest.json"
copy_replace "bookshelf_chest_item_model" "${ASSETS}/models/item/${TYPE}_bookshelf_chest.json"
copy_replace "bookshelf_chest_0_block_model" "${ASSETS}/models/block/${TYPE}_bookshelf_chest_0.json"
for i in {1..9}
do
  copy_replace "bookshelf_chest_x_block_model" "${ASSETS}/models/block/${TYPE}_bookshelf_chest_${i}.json" $i
done
copy_replace "bookshelf_chest_loot_table" "${DATA}/loot_tables/blocks/${TYPE}_bookshelf_chest.json"
copy_replace "bookshelf_chest_recipe" "${DATA}/recipes/crafting/${TYPE}_bookshelf_chest.json"

# crates
copy_replace "crate_open_blockstate" "${ASSETS}/blockstates/${TYPE}_crate_open.json"
copy_replace "crate_open_block_model" "${ASSETS}/models/block/${TYPE}_crate_open.json"
copy_replace "crate_open_item_model" "${ASSETS}/models/item/${TYPE}_crate_open.json"
copy_replace "crate_sealed_blockstate" "${ASSETS}/blockstates/${TYPE}_crate_sealed.json"
copy_replace "crate_sealed_block_model" "${ASSETS}/models/block/${TYPE}_crate_sealed.json"
copy_replace "crate_sealed_item_model" "${ASSETS}/models/item/${TYPE}_crate_sealed.json"
copy_replace "crate_open_loot_table" "${DATA}/loot_tables/blocks/${TYPE}_crate_open.json"
copy_replace "crate_open_recipe" "${DATA}/recipes/crafting/${TYPE}_crate_open.json"

#add_tags
#add_lang_strings