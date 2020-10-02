package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzcnz implements Runnable {
    private final zzbek zzfvt;
    private final zzcns zzget;

    zzcnz(zzcns zzcns, zzbek zzbek) {
        this.zzget = zzcns;
        this.zzfvt = zzbek;
    }

    public final void run() {
        this.zzget.zzo(this.zzfvt);
    }
}
