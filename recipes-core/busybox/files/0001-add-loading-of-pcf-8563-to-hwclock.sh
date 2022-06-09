diff --git a/hwclock.sh.orig b/hwclock.sh
index be5f94d..455c588 100644
--- a/files/hwclock.sh
+++ b/files/hwclock.sh
@@ -25,6 +25,12 @@
 [ "$UTC" = "yes" ] && tz="--utc" || tz="--localtime"
 case "$1" in
         start)
+                # Quick and dirty workaround for pcf8563. Should use device tree
+                if [ ! -d /sys/class/rtc/rtc0 ]
+                then
+                        echo pcf8563 0x51 > /sys/bus/i2c/devices/i2c-0/new_device
+                fi
+		
                 if [ "$VERBOSE" != no ]
                 then
                         echo "System time was `date`."
