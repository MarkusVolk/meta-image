PACKAGECONFIG:append:class-target = " vulkan-beta glvnd"
PACKAGECONFIG:append:rpi:class-target = " broadcom"
PACKAGECONFIG:append:aarch64:class-target = " panfrost"
PACKAGECONFIG:append:x86-64 = " va gallium gallium-llvm r600 opencl virgl"
