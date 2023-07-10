SYSTEMD_AUTO_ENABLE_${PN} = "disable"

inherit main-user

do_install:append() {
    ln -fs ${systemd_user_unitdir}/wireplumber.service ${D}${MAIN_USER_DEFAULT_TARGET_WANTS}/wireplumber.service
}

