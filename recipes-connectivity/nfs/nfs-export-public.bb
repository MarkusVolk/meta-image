SUMMARY = "Configuration script to export ~/Public"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

inherit main-user

S = "${WORKDIR}"

do_install() {
    install -d ${D}${sysconfdir}
    cat >${D}${sysconfdir}/exports <<EOF
${MAIN_USER_HOMEDIR}/Public *(rw,no_root_squash,async,no_subtree_check)
EOF
}

RDEPENDS:${PN} = "packagegroup-core-nfs-server"
