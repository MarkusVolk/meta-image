do_install:append() {
	sed -i -e 's|-u ntp:ntp -n -g|-g -q -x|g' ${D}${systemd_system_unitdir}/ntpd.service
	echo "server de.pool.ntp.org" > ${D}${sysconfdir}/ntp.conf
}
