# Amlogic Meson64 Configurations

SOC_FAMILY = "amlogic:meson-gx"
require conf/machine/include/amlogic-meson.inc
require conf/machine/include/arm/arch-armv8a.inc

IMAGE_INSTALL_append = " kernel-image-image"

XSERVER_append = " xserver-xf86-config"
