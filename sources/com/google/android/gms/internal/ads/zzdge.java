package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzdge implements zzctz<zzcel> {
    private final /* synthetic */ zzdgc zzgsy;

    zzdge(zzdgc zzdgc) {
        this.zzgsy = zzdgc;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzcel zzcel = (zzcel) obj;
        synchronized (this.zzgsy) {
            zzcel unused = this.zzgsy.zzgtb = zzcel;
            this.zzgsy.zzgtb.zzahk();
        }
    }

    public final void zzapn() {
        synchronized (this.zzgsy) {
            zzcel unused = this.zzgsy.zzgtb = null;
        }
    }
}
