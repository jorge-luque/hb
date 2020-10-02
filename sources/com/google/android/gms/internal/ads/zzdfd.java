package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzdfd implements zzdej {
    private final String zzdbv;
    private final String zzdep;
    private final zzasd zzfnj;

    zzdfd(zzasd zzasd, String str, String str2) {
        this.zzfnj = zzasd;
        this.zzdbv = str;
        this.zzdep = str2;
    }

    public final void zzr(Object obj) {
        zzasd zzasd = this.zzfnj;
        ((zzats) obj).zza(new zzaub(zzasd.getType(), zzasd.getAmount()), this.zzdbv, this.zzdep);
    }
}
