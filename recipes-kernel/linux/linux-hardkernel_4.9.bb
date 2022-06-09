FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

KBRANCH = "odroidg12-4.9.y"

SRCREV = "f9de720d006b32db1a6265033fbff23b8648f0ff"
LINUX_VERSION ?= "4.9.241"
LINUX_VERSION_EXTENSION = "-maxcrc"

KBUILD_DEFCONFIG = "odroidg12_defconfig"

EXTRA_OEMAKE_append = " KBUILD=${B}"

require linux-hardkernel.inc

KERNEL_EXTRA_FEATURES = ""

do_install_prepend() {
    bbnote "custom kernel_do_install customization"
    cp ${B}/arch/arm64/boot/dts/amlogic/*.dtb ${B}/arch/arm64/boot/dts/
}

KERNEL_MODULE_AUTOLOAD += "rtc-pcf8563"