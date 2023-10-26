SUMMARY = "Oracle OpenJDK"
HOMEPAGE = "https://jdk.java.net/" 
LICENSE = "GPL-2.0-with-classpath-exception"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0-with-classpath-exception;md5=6133e6794362eff6641708cfcc075b80"
COMPATIBLE_HOST = "(aarch64|x86_64).*-linux"

arch = "${@bb.utils.contains('TARGET_ARCH', 'x86_64', 'x64', 'aarch64', d)}"
shasum:x86-64 = "beaf61959c2953310595e1162b0c626aef33d58628771033ff2936609661956c"
shasum:aarch64 = "3238c93267c663dbca00f5d5b0e3fbba40e1eea2b4281612f40542d208b6dd9a"
SRC_URI = "https://download.java.net/java/GA/jdk${PV}/6e380f22cbe7469fa75fb448bd903d8e/9/GPL/openjdk-${PV}_linux-${arch}_bin.tar.gz"
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
