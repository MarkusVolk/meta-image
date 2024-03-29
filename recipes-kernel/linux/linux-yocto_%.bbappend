FILESEXTRAPATHS:prepend := "${THISDIR}/linux-yocto:"

SRC_URI:append = " \
    file://fs.cfg \
    file://gamepad.cfg \
    file://nfsd.cfg \
    file://wlan.cfg \
    file://i2c.cfg \
    ${@bb.utils.contains('BUILD_APPLIANCE', '1', 'file://storage.cfg', '', d)} \
    file://touchpad.cfg \
    ${@bb.utils.contains('HOST_ARCH', 'x86_64', 'file://virt.cfg', '', d)} \
    file://systemd.cfg \
"

SRC_URI:append:x86-64 = " \
    file://gfx.cfg \
"
