inherit ccache

PACKAGECONFIG:append = " lcms gles2 bubblewrap media-recorder geoclue enchant libsecret webrtc journald gamepad"

PACKAGECONFIG[gamepad] = "-DENABLE_GAMEPAD=ON,-DENABLE_GAMEPAD=OFF,libmanette"
PACKAGECONFIG[webrtc] = "-DENABLE_WEB_RTC=ON,-DENABLE_WEB_RTC=OFF"
PACKAGECONFIG[lcms] = "-DUSE_LCMS=ON,-DUSE_LCMS=OFF,lcms"
PACKAGECONFIG[bubblewrap] = "-DENABLE_BUBBLEWRAP_SANDBOX=ON -DBWRAP_EXECUTABLE=${bindir}/bwrap -DDBUS_PROXY_EXECUTABLE=${bindir}/xdg-dbus-proxy,-DENABLE_BUBBLEWRAP_SANDBOX=OFF,,bubblewrap xdg-dbus-proxy"
