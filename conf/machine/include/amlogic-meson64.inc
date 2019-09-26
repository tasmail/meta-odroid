# Amlogic Meson64 Configurations

SOC_FAMILY = "amlogic:meson-gx"
require conf/machine/include/amlogic-meson.inc
require conf/machine/include/arm/arch-armv8a.inc

KERNEL_EXTRA_FEATURES = "${@bb.utils.contains('MACHINE_FEATURES', 'lima', 'features/drm/drm.scc', '', d)}"

