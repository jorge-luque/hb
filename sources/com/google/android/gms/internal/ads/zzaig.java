package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzaig implements Runnable {
    private final zzaie zzdbu;
    private final String zzdbv;

    zzaig(zzaie zzaie, String str) {
        this.zzdbu = zzaie;
        this.zzdbv = str;
    }

    public final void run() {
        this.zzdbu.zzdc(this.zzdbv);
    }
}
