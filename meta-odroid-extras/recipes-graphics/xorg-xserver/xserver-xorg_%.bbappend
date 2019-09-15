PACKAGECONFIG_remove_meson-gx  = "glamor"
XSERVER_RRECOMMENDS_remove_odroid = "${@bb.utils.contains('MACHINE_FEATURES', 'mali', 'xf86-input-libinput', '', d)}"
