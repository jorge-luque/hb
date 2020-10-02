package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public abstract class zzegr {
    public static zzegr zzn(Class cls) {
        if (System.getProperty("java.vm.name").equalsIgnoreCase("Dalvik")) {
            return new zzego(cls.getSimpleName());
        }
        return new zzegq(cls.getSimpleName());
    }

    public abstract void zzig(String str);
}
