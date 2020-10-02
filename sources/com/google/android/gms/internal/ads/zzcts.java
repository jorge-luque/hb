package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzcts implements zzctz<zzbns> {
    private final /* synthetic */ zzctt zzgjz;

    zzcts(zzctt zzctt) {
        this.zzgjz = zzctt;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzbns zzbns = (zzbns) obj;
        synchronized (this.zzgjz) {
            boolean unused = this.zzgjz.zzaef = false;
            zzxg unused2 = this.zzgjz.zzacv = zzbns.zzaia();
            zzbns.zzahk();
        }
    }

    public final void zzapn() {
        synchronized (this.zzgjz) {
            boolean unused = this.zzgjz.zzaef = false;
        }
    }
}
