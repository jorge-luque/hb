package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzaja implements Runnable {
    private final /* synthetic */ zzaiu zzdci;
    private final /* synthetic */ String zzdck;

    zzaja(zzaiu zzaiu, String str) {
        this.zzdci = zzaiu;
        this.zzdck = str;
    }

    public final void run() {
        this.zzdci.zzdce.loadUrl(this.zzdck);
    }
}
