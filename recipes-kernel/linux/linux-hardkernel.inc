DESCRIPTION = "HardKernel Kernel"
SECTION = "kernel"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

DEPENDS = "lzop-native"

SRC_URI = "git://github.com/hardkernel/linux.git;branch=${KBRANCH} \
file://odroidc4_defconfig"

KBUILD_DEFCONFIG = ""
KBUILD_DEFCONFIG_odroid-c4-hardkernel = "odroidc4_defconfig"
KBUILD_DEFCONFIG_odroid-n2-hardkernel = "odroidg12_defconfig"
KBUILD_DEFCONFIG_odroid-hc4-hardkernel = "odroidg12_defconfig"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

PV = "${LINUX_VERSION}+git${SRCPV}"

KCONF_BSP_AUDIT_LEVEL = "0"

COMPATIBLE_MACHINE = "(odroid-n2-hardkernel|odroid-c4-hardkernel|odroid-hc4-hardkernel)"
