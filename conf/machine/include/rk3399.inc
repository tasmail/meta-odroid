# Copyright (C) 2017 Armin Kuster
# Released under the MIT license (see COPYING.MIT for the terms)

SOC_FAMILY = "rk3399"

require conf/machine/include/arm/arch-armv8.inc
require conf/machine/include/soc-family.inc

SERIAL_CONSOLES = "115200;ttyS2"

KERNEL_IMAGETYPE = "Image"

IMAGE_CLASSES += "image_types_odroid"
