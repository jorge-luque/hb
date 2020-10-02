package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzauh implements zzdqx<Void> {
    private final /* synthetic */ zzdri zzdsb;

    zzauh(zzaue zzaue, zzdri zzdri) {
        this.zzdsb = zzdri;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        Void voidR = (Void) obj;
        zzaue.zzdro.remove(this.zzdsb);
    }

    public final void zzb(Throwable th) {
        zzaue.zzdro.remove(this.zzdsb);
    }
}
