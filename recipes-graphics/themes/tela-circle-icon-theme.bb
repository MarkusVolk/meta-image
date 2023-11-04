SUMMARY = "Tela circle Icon Theme."
LICENSE = "GPL-3.0-only & Apache-2.0"
LIC_FILES_CHKSUM = " \
	file://${COREBASE}/meta/files/common-licenses/GPL-3.0-only;md5=c79ff39f19dfec6d293b95dea7b07891 \
	file://${COREBASE}/meta/files/common-licenses/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10 \
"

SRC_URI = " \
	git://github.com/vinceliuice/Tela-circle-icon-theme.git;protocol=https;branch=master \
	file://0001-install.sh-dont-rename-themes-using-spaces.patch \
"

PV = "2023-10-28"
SRCREV = "cb854a6287e200790566397c88f90e8f32c21cc6"
S = "${WORKDIR}/git"

inherit gtk-icon-cache

# Create selected color variant
# COLOR VARIANTS:
#  standard                 Standard color folder version
#  black                    Black color folder version
#  blue                     Blue color folder version
#  brown                    Brown color folder version
#  dracula                  Dracula color folder version
#  green                    Green color folder version
#  grey                     Grey color folder version
#  orange                   Orange color folder version
#  pink                     Pink color folder version
#  purple                   Purple color folder version
#  red                      Red color folder version
#  yellow                   Yellow color folder version
#  manjaro                  Manjaro default color folder version
#  ubuntu                   Ubuntu default color folder version
#  dracula                  Dracula color folder version
#
# Add one or more entries separated by spaces
TELA_COLOR_VARIANT ?= "blue"

# Create themes in all available colors. Increases creation time and disk usage!
TELA_COLORED_THEMES ?= "disabled"

# Install circular folder icons
TELA_CIRCULAR_FOLDERS ?= "enabled"

do_install() {
	install -d ${D}${datadir}/icons
	./install.sh -n Tela-circle \
	${@bb.utils.contains('TELA_COLORED_THEMES', 'enabled', '-a', '${TELA_COLOR_VARIANT}', d)} \
	${@bb.utils.contains('TELA_CIRCULAR_FOLDERS', 'enabled', '-c', '', d)} \
	-d ${D}${datadir}/icons
}

ALLOW_EMPTY:${PN} = "1"

PACKAGES += " \
	tela-circle \
	tela-circle-black \
	tela-circle-blue \
	tela-circle-brown \
	tela-circle-green \
	tela-circle-dracula \
	tela-circle-grey \
	tela-circle-manjaro \
	tela-circle-nord \
	tela-circle-orange \
	tela-circle-pink \
	tela-circle-purple \
	tela-circle-red \
	tela-circle-ubuntu \
	tela-circle-yellow \
"

FILES:tela-circle = "${datadir}/icons/Tela-circle ${datadir}/icons/Tela-circle-light ${datadir}/icons/Tela-circle-dark"
FILES:tela-circle-black = "${datadir}/icons/Tela-circle-black ${datadir}/icons/Tela-circle-black-light ${datadir}/icons/Tela-circle-black-dark"
FILES:tela-circle-blue = "${datadir}/icons/Tela-circle-blue ${datadir}/icons/Tela-circle-blue-light ${datadir}/icons/Tela-circle-blue-dark"
FILES:tela-circle-brown = "${datadir}/icons/Tela-circle-brown ${datadir}/icons/Tela-circle-brown-light ${datadir}/icons/Tela-circle-brown-dark"
FILES:tela-circle-dracula = "${datadir}/icons/Tela-circle-dracula ${datadir}/icons/Tela-circle-dracula-light ${datadir}/icons/Tela-circle-dracula-dark"
FILES:tela-circle-green = "${datadir}/icons/Tela-circle-green ${datadir}/icons/Tela-circle-green-light ${datadir}/icons/Tela-circle-green-dark"
FILES:tela-circle-grey = "${datadir}/icons/Tela-circle-grey ${datadir}/icons/Tela-circle-grey-light ${datadir}/icons/Tela-circle-grey-dark"
FILES:tela-circle-manjaro = "${datadir}/icons/Tela-circle-manjaro ${datadir}/icons/Tela-circle-manjaro-light ${datadir}/icons/Tela-circle-manjaro-dark"
FILES:tela-circle-nord = "${datadir}/icons/Tela-circle-nord ${datadir}/icons/Tela-circle-nord-light ${datadir}/icons/Tela-circle-nord-dark"
FILES:tela-circle-orange = "${datadir}/icons/Tela-circle-orange ${datadir}/icons/Tela-circle-orange-light ${datadir}/icons/Tela-circle-orange-dark"
FILES:tela-circle-pink = "${datadir}/icons/Tela-circle-pink ${datadir}/icons/Tela-circle-pink-light ${datadir}/icons/Tela-circle-pink-dark"
FILES:tela-circle-purple = "${datadir}/icons/Tela-circle-purple ${datadir}/icons/Tela-circle-purple-light ${datadir}/icons/Tela-circle-purple-dark"
FILES:tela-circle-red = "${datadir}/icons/Tela-circle-red ${datadir}/icons/Tela-circle-red-light ${datadir}/icons/Tela-circle-red-dark"
FILES:tela-circle-ubuntu = "${datadir}/icons/Tela-circle-ubuntu ${datadir}/icons/Tela-circle-ubuntu-light ${datadir}/icons/Tela-circle-ubuntu-dark"
FILES:tela-circle-yellow = "${datadir}/icons/Tela-circle-yellow ${datadir}/icons/Tela-circle-yellow-light ${datadir}/icons/Tela-circle-yellow-dark"

RRECOMMENDS:${PN} = " \
	tela-circle \
	tela-circle-black \
	tela-circle-blue \
	tela-circle-brown \
	tela-circle-green \
	tela-circle-dracula \
	tela-circle-grey \
	tela-circle-manjaro \
	tela-circle-nord \
	tela-circle-orange \
	tela-circle-pink \
	tela-circle-purple \
	tela-circle-red \
	tela-circle-ubuntu \
	tela-circle-yellow \
"
