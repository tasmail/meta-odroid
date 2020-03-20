FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "5.4.26"
SRCREV ?= "257edc6db9432d6d9f19bd313b6b30406b431766"
MBRANCH = "yocto-5.4"
SRCREV_meta ?= "135cdb7251c82a024194223bdc3782b0c8533009"

require linux-stable.inc
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"


KERNEL_FEATURES_append_odroid-c2 = "${@bb.utils.contains('MACHINE_FEATURES', 'lima', 'features/drm/drm.scc', '', d)}"

COMPATIBLE_MACHINE = "(odroid-c1|odroid-c2|odroid-xu3|odroid-xu4|odroid-xu3-lite|odroid-hc1|odroid-h2|odroid-n2)"
