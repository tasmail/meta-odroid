#! /bin/bash

set -e

export SSTATE_CACHE_DIR=/home/build/sstate/master
./poky/scripts/sstate-cache-management.sh -d -y
