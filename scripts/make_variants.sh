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

if [ ! -e "${DATA}/recipes/${NAMESPACE}" ]; then
  mkdir "${DATA}/recipes/${NAMESPACE}"
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
    echo "  \"block.${THISMOD}.${TYPE}_bookcase\": \"${NAME} Bookcase\","
    echo "  \"block.${THISMOD}.${TYPE}_crate\": \"${NAME} Crate\",";
    echo "}"
  } >> $LANGFILE
}

add_tags() {
  CONTAINER=$1

  # barrels
  for f in "${DATAROOT}/${CONTAINER}/tags/blocks/barrels.json" "${DATAROOT}/${CONTAINER}/tags/items/barrels.json"
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
  for f in "${DATAROOT}/${CONTAINER}/tags/blocks/bookshelves.json" "${DATAROOT}/${CONTAINER}/tags/items/bookshelves.json"
  do
    if [ -e "$f" ]; then
      remove_last_entry "${f}" "]" "}"

      {
        echo "    \"${THISMOD}:${TYPE}_bookcase\"";
        echo "  ]"
        echo "}"
      } >> $f
      strip_empty_lines $f
    fi
  done

  # crates
  for f in "${DATA}/${CONTAINER}tags/blocks/crates.json" "${DATA}/${CONTAINER}tags/items/crates.json"
  do
    if [ -e "$f" ]; then
      remove_last_entry "${f}" "]" "}"

      {
        echo "    \"${THISMOD}:${TYPE}_crate\"";
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
copy_replace "barrel_recipe" "${DATA}/recipes/${NAMESPACE}/${TYPE}_barrel.json"

# bookcases
copy_replace "bookcase_blockstate" "${ASSETS}/blockstates/${TYPE}_bookcase.json"
copy_replace "bookcase_item_model" "${ASSETS}/models/item/${TYPE}_bookcase.json"
copy_replace "bookcase_0_block_model" "${ASSETS}/models/block/${TYPE}_bookcase_0.json"
for i in {1..9}
do
  copy_replace "bookcase_x_block_model" "${ASSETS}/models/block/${TYPE}_bookcase_${i}.json" $i
done
copy_replace "bookcase_loot_table" "${DATA}/loot_tables/blocks/${TYPE}_bookcase.json"
copy_replace "bookcase_recipe" "${DATA}/recipes/${NAMESPACE}/${TYPE}_bookcase.json"

# crates
copy_replace "crate_blockstate" "${ASSETS}/blockstates/${TYPE}_crate.json"
copy_replace "crate_block_model" "${ASSETS}/models/block/${TYPE}_crate.json"
copy_replace "crate_item_model" "${ASSETS}/models/item/${TYPE}_crate.json"
copy_replace "crate_loot_table" "${DATA}/loot_tables/blocks/${TYPE}_crate.json"
copy_replace "crate_recipe" "${DATA}/recipes/${NAMESPACE}/${TYPE}_crate.json"

add_tags "charm"
add_tags "forge"
add_lang_strings

echo "Done!"