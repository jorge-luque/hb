package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzbak<T> extends zzbaj<T> {
    private final T zzeac;

    private zzbak(T t) {
        this.zzeac = t;
    }

    public static <T> zzbak<T> zzl(T t) {
        return new zzbak<>(t);
    }

    public final void zzyj() {
        set(this.zzeac);
    }
}
