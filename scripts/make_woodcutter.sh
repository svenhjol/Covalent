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

# woodcutter recipes
copy_replace "woodcutter_boat" "${DATA}/recipes/${NAMESPACE}/${TYPE}_boat_from_woodcutting.json"
copy_replace "woodcutter_button" "${DATA}/recipes/${NAMESPACE}/${TYPE}_button_from_woodcutting.json"
copy_replace "woodcutter_door" "${DATA}/recipes/${NAMESPACE}/${TYPE}_door_from_woodcutting.json"
copy_replace "woodcutter_fence" "${DATA}/recipes/${NAMESPACE}/${TYPE}_fence_from_woodcutting.json"
copy_replace "woodcutter_fence_gate" "${DATA}/recipes/${NAMESPACE}/${TYPE}_fence_gate_from_woodcutting.json"
copy_replace "woodcutter_sign" "${DATA}/recipes/${NAMESPACE}/${TYPE}_sign_from_woodcutting.json"
copy_replace "woodcutter_slab" "${DATA}/recipes/${NAMESPACE}/${TYPE}_slab_from_woodcutting.json"
copy_replace "woodcutter_stairs" "${DATA}/recipes/${NAMESPACE}/${TYPE}_stairs_from_woodcutting.json"

echo "Done!"