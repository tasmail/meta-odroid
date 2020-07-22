#! /bin/bash

set -e

export SSTATE_CACHE_DIR=/home/srv/sstate/master
./sstate-cache-management.sh -d -y
