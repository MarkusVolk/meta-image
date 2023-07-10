RRECOMMENDS:${PN} += "alsa-utils"

SYSTEMD_AUTO_ENABLE_${PN}-server = "disable"

inherit main-user

do_install:append() {
    if ${@bb.utils.contains('DISTRO_FEATURES', 'pipewire', 'false', 'true', d)}; then
        ln -fs ${systemd_user_unitdir}/pulseaudio.service ${D}${MAIN_USER_DEFAULT_TARGET_WANTS}/pulseaudio.service
        ln -fs ${systemd_user_unitdir}/pulseaudio.socket ${D}${MAIN_USER_SOCKETS_TARGET_WANTS}/pulseaudio.socket
    fi
}

