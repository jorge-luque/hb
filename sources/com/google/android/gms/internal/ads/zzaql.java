package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
final /* synthetic */ class zzaql implements Runnable {
    private final String zzdbv;
    private final zzbaa zzdln;

    zzaql(zzbaa zzbaa, String str) {
        this.zzdln = zzbaa;
        this.zzdbv = str;
    }

    public final void run() {
        this.zzdln.zzeq(this.zzdbv);
    }
}
