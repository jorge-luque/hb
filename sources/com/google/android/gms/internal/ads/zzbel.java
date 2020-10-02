package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzbel implements Runnable {
    private final String zzdcd;

    zzbel(String str) {
        this.zzdcd = str;
    }

    public final void run() {
        zzq.zzla().zzvv().zzct(this.zzdcd.substring(1));
    }
}
