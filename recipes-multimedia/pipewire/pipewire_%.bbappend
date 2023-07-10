SYSTEMD_AUTO_ENABLE_${PN} = "disable"

PACKAGECONFIG:remove = "systemd-system-service"

inherit main-user

do_install:append() {
    ln -fs ${systemd_user_unitdir}/pipewire.service ${D}${MAIN_USER_DEFAULT_TARGET_WANTS}/pipewire.service
    ln -fs ${systemd_user_unitdir}/pipewire.socket ${D}${MAIN_USER_SOCKETS_TARGET_WANTS}/pipewire.socket
    if ${@bb.utils.contains('DISTRO_FEATURES', 'pulseaudio', 'true', 'false', d)}; then
        ln -fs ${systemd_user_unitdir}/pipewire-pulse.service ${D}${MAIN_USER_DEFAULT_TARGET_WANTS}/pipewire-pulse.service
        ln -fs ${systemd_user_unitdir}/pipewire-pulse.socket ${D}${MAIN_USER_SOCKETS_TARGET_WANTS}/pipewire-pulse.socket
    fi
}
