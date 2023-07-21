SUMMARY = "Steam udev rules for game controllers"
HOMEPAGE = "https://github.com/ValveSoftware/steam-devices"
SECTION = "games"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9938a391463fd6513858b1d7c6835613"

SRC_URI = "git://github.com/ValveSoftware/steam-devices.git;protocol=https;nobranch=1"

SRCREV = "13443480a64fe8f10676606bd57da6de89f8ccb1"
S = "${WORKDIR}/git"

do_install() {
	install -d ${D}${libdir}/udev/rules.d
	install -m 644 ${S}/*.rules ${D}${libdir}/udev/rules.d
}

FILES:${PN} += "${libdir}"
