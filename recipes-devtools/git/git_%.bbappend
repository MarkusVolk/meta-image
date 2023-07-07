RRECOMMENDS:${PN}-perltools:class-target += "libio-socket-ssl-perl perl-module-mime-base64 libauthen-sasl-perl nano"

inherit main-user

do_install:append() {
    cat >${D}${MAIN_USER_HOMEDIR}/.gitconfig <<EOF
[user]
        email = ${MAIN_USER_EMAIL}
        name = ${MAIN_USER_REALNAME}

[sendemail]
        smtpEncryption = tls
        smtpServer = ${MAIN_USER_SMPT}
        smtpUser = ${MAIN_USER_EMAIL}
        smtpServerPort = 587
        suppresscc = self
[core]
        editor = nano -w
EOF
}
