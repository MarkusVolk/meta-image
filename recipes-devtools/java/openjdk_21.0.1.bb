SUMMARY = "Oracle OpenJDK"
HOMEPAGE = "https://jdk.java.net/" 
LICENSE = "GPL-2.0-with-classpath-exception"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0-with-classpath-exception;md5=6133e6794362eff6641708cfcc075b80"
COMPATIBLE_HOST = "(aarch64|x86_64).*-linux"

arch = "${@bb.utils.contains('TARGET_ARCH', 'x86_64', 'x64', 'aarch64', d)}"
shasum:x86-64 = "7e80146b2c3f719bf7f56992eb268ad466f8854d5d6ae11805784608e458343f"
shasum:aarch64 = "f5e4e4622756fafe05ac0105a8efefa1152c8aad085a2bbb9466df0721bf2ba4"
SRC_URI = "https://download.java.net/java/GA/jdk${PV}/415e3f918a1f4062a0074a2794853d0d/12/GPL/openjdk-${PV}_linux-${arch}_bin.tar.gz"
SRC_URI[sha256sum] = "${shasum}"

DEPENDS = "patchelf-native"
RDEPENDS:${PN} += "zlib freetype fontconfig libxi libxrender libxext libx11 libasound atk cairo gdk-pixbuf mesa gtk+ libcanberra libxtst libxi libgcc elfutils"

S = "${WORKDIR}"

inherit linuxloader

# Patch the binaries to avoid having to create symlinks to lib64 in userspace
do_install:prepend() {
	for file in ${S}/jdk-${PV}/bin/*; do
		patchelf --set-interpreter ${@get_linuxloader(d)} "$file"
	done
}

do_install() {
	install -d ${D}/opt ${D}${bindir}
	cp -r ${S}/jdk-${PV} ${D}/opt/java
	ln -sf /opt/java/bin/java ${D}${bindir}/java
}

FILES:${PN} = "/opt/java ${bindir}"

INSANE_SKIP:${PN} = "file-rdeps"
