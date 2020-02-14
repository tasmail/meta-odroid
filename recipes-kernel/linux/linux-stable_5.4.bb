FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "5.4.19"
SRCREV ?= "d6591ea2dd1a44b1c72c5a3e3b6555d7585acdae"
MBRANCH = "yocto-5.4"
SRCREV_meta ?= "a48522779fae4887c47268e5f650bf10c94a165c"

require linux-stable.inc
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"


KERNEL_FEATURES_append_odroid-c2 = "${@bb.utils.contains('MACHINE_FEATURES', 'lima', 'features/drm/drm.scc', '', d)}"

COMPATIBLE_MACHINE = "(odroid-c1|odroid-c2|odroid-xu3|odroid-xu4|odroid-xu3-lite|odroid-hc1|odroid-h2|odroid-n2)"
