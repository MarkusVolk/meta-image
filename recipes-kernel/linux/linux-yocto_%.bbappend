FILESEXTRAPATHS:prepend := "${THISDIR}/linux-yocto:"

SRC_URI:append = " \
    file://fs.cfg \
    file://gamepad.cfg \
    file://nfsd.cfg \
    file://wlan.cfg \
    file://i2c.cfg \
    ${@bb.utils.contains('BUILD_APPLIANCE', '1', 'file://storage.cfg', '', d)} \
    file://touchpad.cfg \
    file://gfx.cfg \
"

