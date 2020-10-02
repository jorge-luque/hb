package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzbit implements zzcue {
    private zzbqj zzept;
    private final /* synthetic */ zzbhw zzewb;
    private zzcuu zzfex;

    private zzbit(zzbhw zzbhw) {
        this.zzewb = zzbhw;
    }

    public final /* synthetic */ zzcue zza(zzcuu zzcuu) {
        this.zzfex = (zzcuu) zzehf.checkNotNull(zzcuu);
        return this;
    }

    public final zzcuf zzafv() {
        zzehf.zza(this.zzept, zzbqj.class);
        zzehf.zza(this.zzfex, zzcuu.class);
        return new zzbiw(this.zzewb, this.zzfex, new zzbox(), new zzcin(), this.zzept, new zzdie(), (zzdfa) null, (zzdee) null, (zzbhv) null);
    }

    @Deprecated
    public final /* synthetic */ zzcue zzf(zzbuj zzbuj) {
        zzehf.checkNotNull(zzbuj);
        return this;
    }

    public final /* synthetic */ zzcue zzf(zzbqj zzbqj) {
        this.zzept = (zzbqj) zzehf.checkNotNull(zzbqj);
        return this;
    }
}
