PACKAGECONFIG:append = " assrender ${@bb.utils.contains('LICENSE_FLAGS_ACCEPTED', 'commercial', 'faac faad fdkaac', '', d)} nettle kms lcms2 opusparse rsvg rtmp sbc v4l2codecs va webrtc webrtcdsp"
PACKAGECONFIG:append:x86-64 = " msdk"

PACKAGECONFIG[fdkaac] = "-Dfdkaac=enabled,-Dfdkaac=disabled,fdk-aac"

