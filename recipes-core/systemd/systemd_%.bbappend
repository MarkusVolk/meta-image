FILESEXTRAPATHS:prepend := "${THISDIR}/systemd:"

inherit main-user

SRC_URI:append = "file://0001-getty.service.in-configuration-patch-for-autologin.patch"

do_install:append() {
	sed -i "s|@MAIN_USER@|${MAIN_USER_NAME}|" ${D}${systemd_system_unitdir}/getty@.service
	echo "L! /root - - - - /home/root" >> ${D}${nonarch_libdir}/tmpfiles.d/00-create-volatile.conf
}

PACKAGECONFIG:remove = "timesyncd"
