inherit image_types

#
# Create an image that can by written onto a SD card using dd for use
# with Odroid BSP family
#
#  -------------------------------------
# |  Binary   | Block offset| part type |
# |   name    | SD   | eMMC |(eMMC only)|
#  -------------------------------------
# | Bl1       | 1    | 0    |  1 (boot) |
# | Bl2       | 31   | 30   |  1 (boot) |
# | U-boot    | 63   | 62   |  1 (boot) |
# | Tzsw      | 2111 | 2110 |  1 (boot) |
# | Uboot Env | 2625 | 2560 |  0 (user) |
#  -------------------------------------
#
do_rootfs[depends] += " virtual/bootloader:do_packagedata"

generic_odroid_xu_wic_cmd() {
    dd if=${DEPLOY_DIR_IMAGE}/bl1.bin.hardkernel of=$out${IMAGE_NAME_SUFFIX}.wic conv=notrunc bs=512 seek=1
    dd if=${DEPLOY_DIR_IMAGE}/bl2.bin.hardkernel of=$out${IMAGE_NAME_SUFFIX}.wic conv=notrunc bs=512 seek=31
    dd if=${DEPLOY_DIR_IMAGE}/u-boot-dtb.bin of=$out${IMAGE_NAME_SUFFIX}.wic conv=notrunc bs=512 seek=63
    dd if=${DEPLOY_DIR_IMAGE}/tzsw.bin.hardkernel of=$out${IMAGE_NAME_SUFFIX}.wic conv=notrunc bs=512 seek=2111
    dd if=/dev/zero of=$out${IMAGE_NAME_SUFFIX}.wic conv=notrunc count=32 bs=512 seek="2625"
}

IMAGE_CMD_wic_append_odroid-xu3() {
    generic_odroid_xu_wic_cmd
}

IMAGE_CMD_wic_append_odroid-xu4() {
    generic_odroid_xu_wic_cmd
}

IMAGE_CMD_wic_append_odroid-xu3-lite() {
    generic_odroid_xu_wic_cmd
}

IMAGE_CMD_wic_append_odroid-hc1() {
    generic_odroid_xu_wic_cmd
}

IMAGE_CMD_wic_append_odroid-c1() {
    dd if=${DEPLOY_DIR_IMAGE}/bl1.bin.hardkernel   of=$out${IMAGE_NAME_SUFFIX}.wic conv=notrunc bs=1 count=442
    dd if=${DEPLOY_DIR_IMAGE}/bl1.bin.hardkernel   of=$out${IMAGE_NAME_SUFFIX}.wic conv=notrunc bs=512 skip=1 seek=1
    dd if=${DEPLOY_DIR_IMAGE}/u-boot-${MACHINE}.${UBOOT_SUFFIX} of=$out${IMAGE_NAME_SUFFIX}.wic conv=notrunc bs=512 seek=64
}

# Write U-Boot before wic generates compressed rootfs for odroid-c2 machine
IMAGE_CMD_wic_append_odroid-c2() {
    dd if=${DEPLOY_DIR_IMAGE}/bl1.bin.hardkernel   of=$out${IMAGE_NAME_SUFFIX}.wic conv=notrunc bs=1 count=442
    dd if=${DEPLOY_DIR_IMAGE}/bl1.bin.hardkernel   of=$out${IMAGE_NAME_SUFFIX}.wic conv=notrunc bs=512 skip=1 seek=1
    dd if=${DEPLOY_DIR_IMAGE}/u-boot-dtb.bin of=$out${IMAGE_NAME_SUFFIX}.wic conv=notrunc bs=512 seek=97
}

generic_odroid_n2_wic_cmd() {
    dd if=${DEPLOY_DIR_IMAGE}/${UBOOT_BINARY} of=$out${IMAGE_NAME_SUFFIX}.wic conv=notrunc bs=512 skip=1 seek=1
    dd if=${DEPLOY_DIR_IMAGE}/${UBOOT_BINARY} of=$out${IMAGE_NAME_SUFFIX}.wic conv=notrunc bs=1 count=444
}

generic_odroid_c4_wic_cmd() {
    dd if=${DEPLOY_DIR_IMAGE}/u-boot.bin of=$out${IMAGE_NAME_SUFFIX}.wic conv=fsync,notrunc bs=512 seek=1
}

IMAGE_CMD_wic_append_odroid-n2-hardkernel() {
    generic_odroid_c4_wic_cmd
}

IMAGE_CMD_wic_append_odroid-n2() {
    generic_odroid_n2_wic_cmd
}

IMAGE_CMD_wic_append_odroid-c4-hardkernel() {
    generic_odroid_c4_wic_cmd
}

IMAGE_CMD_wic_append_odroid-c4() {
    generic_odroid_c4_wic_cmd
}

