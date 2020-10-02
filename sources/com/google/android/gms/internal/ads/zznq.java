package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zznq {
    public final zzna zzbfg;
    public final zznl zzbfh;
    public final Object zzbfi;
    public final zzhm[] zzbfj;

    public zznq(zzna zzna, zznl zznl, Object obj, zzhm[] zzhmArr) {
        this.zzbfg = zzna;
        this.zzbfh = zznl;
        this.zzbfi = obj;
        this.zzbfj = zzhmArr;
    }

    public final boolean zza(zznq zznq, int i) {
        if (zznq != null && zzov.zza(this.zzbfh.zzba(i), zznq.zzbfh.zzba(i)) && zzov.zza(this.zzbfj[i], zznq.zzbfj[i])) {
            return true;
        }
        return false;
    }
}
