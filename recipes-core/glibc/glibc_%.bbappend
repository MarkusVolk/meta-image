FILESEXTRAPATHS:prepend := "${THISDIR}/glibc:"

SRC_URI:append:aarch64 = " \
	file://glibc-HACK-Don-t-check-GLIBC_ABI_DT_RELR-support-for-Chrom.patch \
	file://0002-tls-libwidevinecdm.so-since-4.10.2252.0-has-TLS-with.patch \
"
