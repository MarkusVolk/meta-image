SUMMARY = "Maximum Doom2 wad"
HOMEPAGE = "https://archive.org"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"


SRC_URI = "https://ia801900.us.archive.org/28/items/2020_03_22_DOOM/DOOM%20WADs/Maximum%20Doom%202.zip"

SRC_URI[sha256sum] = "9797ccca4ad630e46a3b5d5ee052d4f43b05f9e63f30821838b5c2d959fe173e"

do_install() {
	install -d ${D}${datadir}/games/doom
	for file in *.WAD; do
		install "$file" ${D}${datadir}/games/doom
	done
}

FILES:${PN} = "${datadir}"

