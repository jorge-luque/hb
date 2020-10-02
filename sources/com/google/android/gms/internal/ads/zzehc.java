package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzehc<T> implements zzegt<T>, zzegz<T> {
    private static final zzehc<Object> zzijh = new zzehc<>((Object) null);
    private final T zzdyi;

    private zzehc(T t) {
        this.zzdyi = t;
    }

    public static <T> zzegz<T> zzbb(T t) {
        return new zzehc(zzehf.zza(t, "instance cannot be null"));
    }

    public static <T> zzegz<T> zzbc(T t) {
        if (t == null) {
            return zzijh;
        }
        return new zzehc(t);
    }

    public final T get() {
        return this.zzdyi;
    }
}
