package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzdrm implements Runnable {
    private final /* synthetic */ Runnable zzhii;
    private final /* synthetic */ zzdrj zzhij;

    zzdrm(zzdrj zzdrj, Runnable runnable) {
        this.zzhij = zzdrj;
        this.zzhii = runnable;
    }

    public final void run() {
        this.zzhij.zzhie = false;
        this.zzhii.run();
    }
}
