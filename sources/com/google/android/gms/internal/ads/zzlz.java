package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzlz implements Runnable {
    private final /* synthetic */ zzly zzbau;
    private final /* synthetic */ zzme zzbbv;

    zzlz(zzly zzly, zzme zzme) {
        this.zzbau = zzly;
        this.zzbbv = zzme;
    }

    public final void run() {
        this.zzbbv.release();
        int size = this.zzbau.zzbbg.size();
        for (int i = 0; i < size; i++) {
            ((zzms) this.zzbau.zzbbg.valueAt(i)).disable();
        }
    }
}
