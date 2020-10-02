package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzbfh implements Runnable {
    private final String zzdbv;
    private final zzbff zzelf;

    zzbfh(zzbff zzbff, String str) {
        this.zzelf = zzbff;
        this.zzdbv = str;
    }

    public final void run() {
        this.zzelf.zzfs(this.zzdbv);
    }
}
