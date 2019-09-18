FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "5.3.0"
SRCREV ?= "4d856f72c10ecb060868ed10ff1b1453943fc6c8"
MBRANCH = "master"
SRCREV_meta ?= "e00e22588e19c8f97ed172de322e7d358f5bf89a"

KMACHINE_odroid-n2 = "odroid-n2"

require linux-stable.inc
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

COMPATIBLE_MACHINE = "(odroid-c1|odroid-c2|odroid-xu3|odroid-xu4|odroid-xu3-lite|odroid-hc1|odroid-h2|odroid-n2)"
