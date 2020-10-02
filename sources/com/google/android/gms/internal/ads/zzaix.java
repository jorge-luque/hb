package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzaix implements Runnable {
    private final String zzdbv;
    private final zzaiu zzdcg;

    zzaix(zzaiu zzaiu, String str) {
        this.zzdcg = zzaiu;
        this.zzdbv = str;
    }

    public final void run() {
        this.zzdcg.zzdf(this.zzdbv);
    }
}
