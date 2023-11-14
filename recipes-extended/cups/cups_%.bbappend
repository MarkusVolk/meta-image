PACKAGECONFIG:append = " gnutls acl webif"
PACKAGECONFIG:remove = " openssl"

do_install:append() {
    sed -i -e 's|SystemGroup lpadmin|SystemGroup sys root wheel|g' ${D}${sysconfdir}/cups/cups-files.conf
}
