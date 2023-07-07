FILESEXTRAPATHS:prepend := "${THISDIR}/samba:"

RDEPENDS:${PN} += "glibc-gconv-ibm850"

inherit main-user

do_install:append() {
    install -d ${D}${sysconfdir}/pam.d
    cat >${D}${sysconfdir}/pam.d/samba <<EOF
##%PAM-1.0
 auth       required    /lib/security/pam_unix.so shadow nullok
 auth       required    /lib/security/pam_shells.so
 account    required    /lib/security/pam_unix.so
 session    required    /lib/security/pam_unix.so
EOF
    cat >${D}${sysconfdir}/samba/smb.conf <<EOF
[global]
workgroup = WORKGROUP
security = user
printcap name = /dev/null
guest account = ${MAIN_USER_NAME}
smb ports = 139 445
map to guest = Bad User
enable privileges = yes
obey pam restrictions = yes
unix password sync = yes
pam password change = yes
server multi channel support = yes
unix extensions = yes

[Public]
path = ${MAIN_USER_HOMEDIR}/Public
read only = no
force user = ${MAIN_USER_NAME}
guest ok = no
writeable = yes
available = yes
EOF
    sed -i "s|/var/run|/run|" ${D}/etc/tmpfiles.d/samba.conf
}

# The services get started on demand. Avoid to start with system
SYSTEMD_AUTO_ENABLE:${PN}-base = "disable"

# Add the main user to the Samba database if it does not already exist. Potentially unsafe, doesn't work with encrypted passwords
pkg_postinst_ontarget:${PN}() {
    pdbedit -L | grep ${MAIN_USER_NAME} > /dev/null 2>&1 || (echo ${MAIN_USER_PASSWORD}; echo ${MAIN_USER_PASSWORD}) | smbpasswd -s -a  ${MAIN_USER_NAME} > /dev/null 2>&1
}
