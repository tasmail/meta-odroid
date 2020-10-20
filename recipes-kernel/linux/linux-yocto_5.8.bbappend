FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-5.8:"


SRC_URI_append = " file://odroid-kmeta;type=kmeta;name=odroid-kmeta;destsuffix=odroid-kmeta"
SRC_URI_append = " file://odroid/odroid.scc"

KERNEL_FEATURES_append_odroid-c2 = "${@bb.utils.contains('MACHINE_FEATURES', 'lima', 'features/drm/drm.scc', '', d)}"

COMPATIBLE_MACHINE = "(odroid-c1|odroid-c2|odroid-xu3|odroid-xu4|odroid-xu3-lite|odroid-hc1|odroid-h2|odroid-n2)"
