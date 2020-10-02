package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzbcf implements Runnable {
    private final String zzdbv;
    private final zzbce zzees;

    zzbcf(zzbce zzbce, String str) {
        this.zzees = zzbce;
        this.zzdbv = str;
    }

    public final void run() {
        this.zzees.zzfi(this.zzdbv);
    }
}
