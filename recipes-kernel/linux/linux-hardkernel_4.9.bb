FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRC_URI += "file://odroidc4_defconfig"

KBRANCH = "odroidg12-4.9.y"
KBUILD_DEFCONFIG = "odroidg12_defconfig"
KBUILD_DEFCONFIG_odroid-c4-hardkernel ?= "odroidc4_defconfig"

SRCREV = "f9de720d006b32db1a6265033fbff23b8648f0ff"
LINUX_VERSION ?= "4.9.241"

EXTRA_OEMAKE_append = " KBUILD=${B}"
require linux-hardkernel.inc

KERNEL_EXTRA_FEATURES = ""

do_install_prepend() {
    bbnote "custom kernel_do_install customization"
    cp ${B}/arch/arm64/boot/dts/amlogic/*.dtb ${B}/arch/arm64/boot/dts/
}

COMPATIBLE_MACHINE = "(odroid-n2-hardkernel|odroid-c4-hardkernel|odroid-hc4-hardkernel)"
