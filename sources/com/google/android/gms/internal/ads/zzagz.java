package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzagz implements Runnable {
    private final /* synthetic */ zzagu zzdbf;

    zzagz(zzagu zzagu) {
        this.zzdbf = zzagu;
    }

    public final void run() {
        this.zzdbf.disconnect();
    }
}
