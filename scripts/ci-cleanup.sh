#! /bin/bash

set -e

export SSTATE_CACHE_DIR=/home/build/sstate-cache/master
./poky/scripts/sstate-cache-management.sh -d -y
