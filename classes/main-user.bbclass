MAIN_USER_ID ??= "1000"
MAIN_USER_GROUPS ??= "audio,dialout,disk,flatpak,i2c,input,netdev,plugdev,render,shutdown,sudo,users,video,wheel,lpadmin,lp"
MAIN_USER_NAME ??= "user"
MAIN_USER_GROUP ??= "${MAIN_USER_NAME}"
MAIN_USER_REALNAME ??= "${MAIN_USER_NAME}"
MAIN_USER_EMAIL ??= "johnnywalker@example.org"
MAIN_USER_SMTP ??= "smtp.example.org"
MAIN_USER_PASSWORD ??= "${MAIN_USER_NAME}"
MAIN_USER_PASSWORD_ENCRYPTED ??= "$(openssl passwd -5 ${MAIN_USER_PASSWORD})"

ROOT_PASSWORD ??= "root"
ROOT_PASSWORD_ENCRYPTED ??= "$(openssl passwd -5 ${ROOT_PASSWORD})"

MAIN_USER_HOMEDIR ?= "/home/${MAIN_USER_NAME}"

do_install:prepend() {
	install -d ${D}${MAIN_USER_HOMEDIR}
}

do_install:append() {
	chown ${MAIN_USER_NAME}:${MAIN_USER_NAME} -R ${D}${MAIN_USER_HOMEDIR}
}

FILES:${PN} += "${MAIN_USER_HOMEDIR}"

MAIN_USER_DEFAULT_TARGET_WANTS ?= "${MAIN_USER_HOMEDIR}/.config/systemd/user/default.target.wants"
MAIN_USER_SOCKETS_TARGET_WANTS ?= "${MAIN_USER_HOMEDIR}/.config/systemd/user/sockets.target.wants"

RDEPENDS:${PN} += "bash"

inherit useradd extrausers

GROUPADD_PARAM:${PN} += "i2c; netdev; lpadmin; flatpak"

USERADD_PACKAGES += "${PN}"
USERADD_PARAM:${PN} += " \
    --create-home \
    --user-group \
    --groups ${MAIN_USER_GROUPS} \
    --uid ${MAIN_USER_ID} \
    --home-dir ${MAIN_USER_HOMEDIR} \
    --shell /bin/bash \
    ${MAIN_USER_NAME} \
"

EXTRA_USERS_PARAMS += "usermod -p '${ROOT_PASSWORD_ENCRYPTED}' root;"
EXTRA_USERS_PARAMS += "usermod -p '${MAIN_USER_PASSWORD_ENCRYPTED}' ${MAIN_USER_NAME};"
