FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "5.4.50"
SRCREV ?= "e75220890bf6b37c5f7b1dbd81d8292ed6d96643"
MBRANCH = "yocto-5.4"
SRCREV_meta ?= "e32057eca987b7abbe3eb47ba36f06af8711278a"

require linux-stable.inc
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"


KERNEL_FEATURES_append_odroid-c2 = "${@bb.utils.contains('MACHINE_FEATURES', 'lima', 'features/drm/drm.scc', '', d)}"

COMPATIBLE_MACHINE = "(odroid-c1|odroid-c2|odroid-xu3|odroid-xu4|odroid-xu3-lite|odroid-hc1|odroid-h2|odroid-n2)"
