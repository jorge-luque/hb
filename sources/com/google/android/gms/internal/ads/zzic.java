package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzic implements Runnable {
    private final /* synthetic */ zzhw zzail;
    private final /* synthetic */ int zzair;

    zzic(zzhw zzhw, int i) {
        this.zzail = zzhw;
        this.zzair = i;
    }

    public final void run() {
        this.zzail.zzaih.zzu(this.zzair);
    }
}
