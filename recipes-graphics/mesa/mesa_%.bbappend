PACKAGECONFIG[gallium-llvm] = "-Dllvm=enabled -Dshared-llvm=enabled, -Dllvm=disabled, clang clang-native elfutils"

PACKAGECONFIG:append:class-target = " vulkan-beta glvnd"
PACKAGECONFIG:append:rpi:class-target = " broadcom"
PACKAGECONFIG:append:aarch64:class-target = " panfrost"
PACKAGECONFIG:append:x86-64:class-target = " va gallium gallium-llvm r600 dri3"

CFLAGS:append:x86-64 = " -Wno-error=missing-prototypes"

