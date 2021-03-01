FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRC_URI += "file://odroidc4_defconfig"

KBRANCH = "odroidg12-4.9.y"

SRCREV = "f9de720d006b32db1a6265033fbff23b8648f0ff"
LINUX_VERSION ?= "4.9.241"

EXTRA_OEMAKE_append = " KBUILD=${B}"

KBUILD_DEFCONFIG = ""
KBUILD_DEFCONFIG_odroid-c4-hardkernel = "odroidc4_defconfig"
KBUILD_DEFCONFIG_odroid-n2-hardkernel = "odroidg12_defconfig"
KBUILD_DEFCONFIG_odroid-hc4-hardkernel = "odroidg12_defconfig"

inherit kernel
require linux-hardkernel.inc

KERNEL_EXTRA_FEATURES = ""

do_install_prepend() {
    bbnote "custom kernel_do_install customization"
    cp ${B}/arch/arm64/boot/dts/amlogic/*.dtb ${B}/arch/arm64/boot/dts/
}
