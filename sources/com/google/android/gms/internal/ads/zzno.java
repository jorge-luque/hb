package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public abstract class zzno {
    private zznn zzbff;

    /* access modifiers changed from: protected */
    public final void invalidate() {
        zznn zznn = this.zzbff;
        if (zznn != null) {
            zznn.zzeo();
        }
    }

    public abstract zznq zza(zzhn[] zzhnArr, zzna zzna) throws zzgq;

    public final void zza(zznn zznn) {
        this.zzbff = zznn;
    }

    public abstract void zzd(Object obj);
}
