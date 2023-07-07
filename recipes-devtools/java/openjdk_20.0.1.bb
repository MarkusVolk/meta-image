SUMMARY = "Oracle OpenJDK"
HOMEPAGE = "https://jdk.java.net/" 
LICENSE = "GPL-2.0-with-classpath-exception"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0-with-classpath-exception;md5=6133e6794362eff6641708cfcc075b80"
COMPATIBLE_HOST = "(aarch64|x86_64).*-linux"

arch = "${@bb.utils.contains('TARGET_ARCH', 'x86_64', 'x64', 'aarch64', d)}"
shasum:x86-64 = "4248a3af4602dbe2aefdb7010bc9086bf34a4155888e837649c90ff6d8e8cef9"
shasum:aarch64 = "f1935fb2046bf5cfb609522f243909ee8e47e6be3db925df40c46f0465b30434"
SRC_URI = "https://download.java.net/java/GA/jdk${PV}/b4887098932d415489976708ad6d1a4b/9/GPL/openjdk-${PV}_linux-${arch}_bin.tar.gz"
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
