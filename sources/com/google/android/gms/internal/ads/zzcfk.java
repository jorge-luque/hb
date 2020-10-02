package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzcfk implements zzapa {
    private final /* synthetic */ zzcfa zzfxh;

    zzcfk(zzcfa zzcfa) {
        this.zzfxh = zzcfa;
    }

    public final void zza(int i, int i2, int i3, int i4) {
        this.zzfxh.zzflh.onAdOpened();
    }

    public final void zzud() {
        this.zzfxh.zzflh.onAdClosed();
    }

    public final void zzue() {
        this.zzfxh.zzfxe.zzaho();
    }
}
