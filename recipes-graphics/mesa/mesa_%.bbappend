PACKAGECONFIG:append:x86-64 = " opencl"
PACKAGECONFIG:append:class-target = " gallium  gallium-llvm vulkan-beta glvnd virgl"
PACKAGECONFIG:append:rpi:class-target = " broadcom v3d vc4"
PACKAGECONFIG:append:aarch64:class-target = " panfrost"
PACKAGECONFIG:append:x86-64:class-target = " va r600"
