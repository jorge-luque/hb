package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzcjc implements Runnable {
    private final Object zzdel;
    private final String zzfya;
    private final zzciz zzfzv;
    private final zzbaj zzgag;
    private final long zzgah;

    zzcjc(zzciz zzciz, Object obj, zzbaj zzbaj, String str, long j) {
        this.zzfzv = zzciz;
        this.zzdel = obj;
        this.zzgag = zzbaj;
        this.zzfya = str;
        this.zzgah = j;
    }

    public final void run() {
        this.zzfzv.zza(this.zzdel, this.zzgag, this.zzfya, this.zzgah);
    }
}
