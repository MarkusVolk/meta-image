SUMMARY = "YQuake-2 Vulkan Renderer"
HOMEPAGE = "https://github.com/yquake2/ref_vk" 

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4195f7f4330e3c83787901522aa57bc4"


SRC_URI = " \
    git://github.com/yquake2/ref_vk.git;protocol=https;nobranch=1 \
    file://0001-Makefile-dont-use-sdl2-config.patch \
"

DEPENDS = "libsdl2 vulkan-headers"
RDEPENDS:${PN} = "yquake2"

inherit autotools-brokensep pkgconfig

S = "${WORKDIR}/git"
SRCREV = "bcd0cd9e56615dd774ad7e07e7a266be283ef84e"
PV = "1.0.5"

do_install() {
	install -d ${D}${libexecdir}/quake2
	install -m0644 ${S}/release/ref_vk.so ${D}${libexecdir}/quake2
}

FILES:${PN} = " \
	${libexecdir} \
"

EXTRA_OEMAKE = "YQ2_ARCH=${TARGET_ARCH} INCLUDE=-I${STAGING_INCDIR}"
