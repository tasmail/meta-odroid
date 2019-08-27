DESCRIPTION = "Linux Kernel"
SECTION = "kernel"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

KBASE_VERSION = "${@d.getVar('LINUX_VERSION').split('.')[0]}.${@d.getVar('LINUX_VERSION').split('.')[1]}"
MBRANCH ?= "yocto-5.2"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

PV = "${LINUX_VERSION}+git${SRCPV}"

KCONF_BSP_AUDIT_LEVEL = "2"
DEPENDS += "openssl-native util-linux-native"

KMETA = "kernel-meta"
KMACHINE_odroid-n2 = "odroid-n2"

KMETA_SRC_URI ?= " git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=${MBRANCH};destsuffix=${KMETA}"
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux.git"
SRC_URI_append = "${KMETA_SRC_URI}" 
SRC_URI_append = " file://odroid-kmeta;type=kmeta;name=odroid-kmeta;destsuffix=odroid-kmeta"
#SRC_URI_append = " file://odroid/odroid.scc"

COMPATIBLE_MACHINE = "(odroid-n2)"
