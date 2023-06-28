do_install:append() {
    echo "vm.max_map_count=524288" >> ${D}${sysconfdir}/sysctl.conf
}
