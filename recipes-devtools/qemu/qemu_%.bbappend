DEPENDS:append:class-target = " libcacard gtk-vnc"
RDEPENDS:${PN}-common:class-target = "gtk-vnc"
PACKAGECONFIG:append:class-target = " gtk+ xkbcommon gnutls vte nettle libusb spice vhost attr nss usb-redir libudev libcurl libnfs png libcap-ng virtfs bzip2 aio vnc-jpeg vnc-sasl dbus-display fuse"

EXTRA_OECONF += "--enable-gtk-clipboard"
