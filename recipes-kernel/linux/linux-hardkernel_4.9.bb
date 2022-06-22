FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

KBRANCH = "odroidg12-4.9.y"

SRCREV = "20d79ab6a52a20842a18dfb63d67cb66004fe0ea"
LINUX_VERSION ?= "4.9.241"
LINUX_VERSION_EXTENSION = "-maxcrc"


EXTRA_OEMAKE_append = " KBUILD=${B}"

require linux-hardkernel.inc
SRC_URI_append = " file://oe.scc"

KERNEL_EXTRA_FEATURES = ""

do_install_prepend() {
    bbnote "custom kernel_do_install customization"
    cp ${B}/arch/arm64/boot/dts/amlogic/*.dtb ${B}/arch/arm64/boot/dts/
}

SRC_URI += " \
	file://defconfig \
"

KERNEL_MODULE_AUTOLOAD += "rtc-pcf8563"
