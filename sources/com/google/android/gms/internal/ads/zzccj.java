package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzccj implements zzdqj {
    private final zzdri zzfvm;

    zzccj(zzdri zzdri) {
        this.zzfvm = zzdri;
    }

    public final zzdri zzf(Object obj) {
        zzdri zzdri = this.zzfvm;
        if (obj != null) {
            return zzdri;
        }
        return zzdqw.immediateFailedFuture(new zzcqm("Retrieve required value in native ad response failed.", 0));
    }
}
