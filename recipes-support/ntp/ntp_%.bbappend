do_install:append() {
	sed -i -e 's|forking|oneshot|g' ${D}${systemd_system_unitdir}/ntpd.service
	sed -i -e '/PIDFile/d' ${D}${systemd_system_unitdir}/ntpd.service
	sed -i -e 's|-u ntp:ntp -p /run/ntpd.pid -g|-g -q -x|g' ${D}${systemd_system_unitdir}/ntpd.service
	echo "server de.pool.ntp.org" > ${D}${sysconfdir}/ntp.conf
}
