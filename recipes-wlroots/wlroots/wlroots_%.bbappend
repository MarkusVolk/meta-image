FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " \
	file://wlroots-hidpi.patch \
	file://0001-Revert-compositor-send-WL_SURFACE_ERROR_INVALID_SIZE.patch \
"
