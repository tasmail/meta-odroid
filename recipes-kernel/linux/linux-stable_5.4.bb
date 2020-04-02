FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "5.4.30"
SRCREV ?= "ad13e142e024aa194016a32de8b9ba058fe9a6af"
MBRANCH = "yocto-5.4"
SRCREV_meta ?= "e2078dbee8c7b8c7fe9dbe91f2633755873376b6"

require linux-stable.inc
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"


KERNEL_FEATURES_append_odroid-c2 = "${@bb.utils.contains('MACHINE_FEATURES', 'lima', 'features/drm/drm.scc', '', d)}"

COMPATIBLE_MACHINE = "(odroid-c1|odroid-c2|odroid-xu3|odroid-xu4|odroid-xu3-lite|odroid-hc1|odroid-h2|odroid-n2)"
