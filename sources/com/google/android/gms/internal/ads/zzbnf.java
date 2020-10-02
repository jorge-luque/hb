package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzbnf implements Runnable {
    private final Runnable zzffu;
    private final zzbnd zzfka;

    zzbnf(zzbnd zzbnd, Runnable runnable) {
        this.zzfka = zzbnd;
        this.zzffu = runnable;
    }

    public final void run() {
        this.zzfka.zze(this.zzffu);
    }
}
