package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzcfl implements zzbfv {
    private final zzbaj zzbsx;

    zzcfl(zzbaj zzbaj) {
        this.zzbsx = zzbaj;
    }

    public final void zzak(boolean z) {
        zzbaj zzbaj = this.zzbsx;
        if (z) {
            zzbaj.set(null);
        } else {
            zzbaj.setException(new Exception("Ad Web View failed to load."));
        }
    }
}
