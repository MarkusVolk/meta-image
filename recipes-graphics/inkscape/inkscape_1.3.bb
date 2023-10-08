SUMMARY = "Inkscape is a Free and open source vector graphics editor"
HOMEPAGE = "https://inkscape.org/"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=46f815712c095f667139ef42f2270d57"

SRC_URI = "gitsm://gitlab.com/inkscape/inkscape.git;protocol=https;nobranch=1"
SRCREV = "0e150ed6c4dbbe4e84981434eb6226bb8ce2e39f"
S = "${WORKDIR}/git"

DEPENDS = " \
    bdwgc \
    boost \
    cairo \
    gdk-pixbuf \
    glib-2.0 \
    glib-2.0-native \
    gsl \
    gspell \
    gtkmm3 \
    gtksourceview4 \
    harfbuzz \
    lcms \
    libsoup-2.4 \
    libxslt \
    pango \
    poppler \
    \
    double-conversion \
    lib2geom \
    libcdr \
    librevenge \
    libvisio \
    libwpg \
    potrace \
"

inherit cmake pkgconfig gettext gtk-icon-cache bash-completion mime-xdg

FILES:${PN} += "${datadir}/metainfo"
FILES:${PN}-dev += "${libdir}/inkscape/libinkscape_base.so"
