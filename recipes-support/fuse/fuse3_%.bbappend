do_install:append:class-target() {
    # We dont install fuse2. Make 'fusermount3' the default to satisfy flatpak
    ln -sf ${bindir}/fusermount3 ${D}${bindir}/fusermount
}
