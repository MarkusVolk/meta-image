SUMMARY = "SuperTuxKart is a free kart racing game."
HOMEPAGE = "https://github.com/supertuxkart/stk-code" 

LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=bcfdeb69518cfe348a07845ebba5c295" 

DEPENDS = " \
	bluez5 \
	curl \
	freetype \
	harfbuzz \
	jpeg \
	libogg \
	libpng \
	libsdl2 \
	libvorbis \
	openal-soft \
	openssl \
	shaderc \
	sqlite3 \
	virtual/egl \
	virtual/libgles2 \
	zlib \
"

RDEPENDS:${PN} = "openal-soft stk-assets"

inherit cmake pkgconfig

EXTRA_OECMAKE += "-DBUILD_RECORDER=0 -DCHECK_ASSETS=off -DSTK_INSTALL_DATA_DIR=${datadir}/games/supertuxkart"

SRC_URI = " \
    git://github.com/supertuxkart/stk-code.git;protocol=https;nobranch=1 \
"

PV = "1.4"
SRCREV = "fd12829e5b0c2f91fe522df5d8c74e3bb905b0cc"
S = "${WORKDIR}/git"

FILES:${PN} += "${datadir}"

