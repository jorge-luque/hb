package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzcch implements zzdqj {
    private final zzdri zzfvm;

    zzcch(zzdri zzdri) {
        this.zzfvm = zzdri;
    }

    public final zzdri zzf(Object obj) {
        zzdri zzdri = this.zzfvm;
        zzbek zzbek = (zzbek) obj;
        if (zzbek != null && zzbek.zzzf() != null) {
            return zzdri;
        }
        throw new zzcqm("Retrieve video view in instream ad response failed.", 0);
    }
}
