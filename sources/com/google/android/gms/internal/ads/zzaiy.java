package com.google.android.gms.internal.ads;

import com.loopj.android.http.C4250c;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzaiy implements Runnable {
    private final /* synthetic */ String zzdch;
    private final /* synthetic */ zzaiu zzdci;

    zzaiy(zzaiu zzaiu, String str) {
        this.zzdci = zzaiu;
        this.zzdch = str;
    }

    public final void run() {
        this.zzdci.zzdce.loadData(this.zzdch, "text/html", C4250c.DEFAULT_CHARSET);
    }
}
