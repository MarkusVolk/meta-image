SUMMARY = "Freedoom Wad"
HOMEPAGE = "https://github.com/freedoom/freedoom"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING.adoc;md5=66191589ee6a586349a2ff27fafc16c5"

DEPENDS = "deutex-native python3-pillow-native"

inherit autotools-brokensep

SRC_URI = " \
    git://github.com/freedoom/freedoom.git;protocol=https;branch=master \
"

PV = "0.12.1"
SRCREV = "13f70d1e1113b198b8f79ba0d317de5d8fff2a1f"
S = "${WORKDIR}/git"

EXTRA_OEMAKE = "prefix='' waddir=${datadir}/games/doom"


do_install:append() {
	mv ${D}/share ${D}${prefix}/share
}

FILES:${PN} += "${datadir}"
