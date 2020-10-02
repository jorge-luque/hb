package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzbzs {
    private zzacr zzchr;

    public zzbzs(zzbzk zzbzk) {
        this.zzchr = zzbzk;
    }

    public final synchronized void zza(zzacr zzacr) {
        this.zzchr = zzacr;
    }

    public final synchronized zzacr zzsl() {
        return this.zzchr;
    }
}
