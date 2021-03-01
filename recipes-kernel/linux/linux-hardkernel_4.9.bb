FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRC_URI += "file://odroidc4_defconfig"

KBRANCH = "odroidg12-4.9.y"

KBUILD_DEFCONFIG = "odroidc4_defconfig"

SRCREV = "91116f8b27e498e99aa50429c2c921b60b4c1875s"
LINUX_VERSION ?= "4.9.241"

EXTRA_OEMAKE_append = " KBUILD=${B}"
require linux-hardkernel.inc

KERNEL_EXTRA_FEATURES = ""

do_install_prepend() {
    bbnote "custom kernel_do_install customization"
    cp ${B}/arch/arm64/boot/dts/amlogic/*.dtb ${B}/arch/arm64/boot/dts/
}

COMPATIBLE_MACHINE = "(odroid-n2-hardkernel|odroid-c4-hardkernel|odroid-hc4-hardkernel)"
