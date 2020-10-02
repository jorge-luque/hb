package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdpw;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzdrq extends zzdpw.zzj<Void> implements Runnable {
    private final Runnable zzhim;

    public zzdrq(Runnable runnable) {
        this.zzhim = (Runnable) zzdoj.checkNotNull(runnable);
    }

    public final void run() {
        try {
            this.zzhim.run();
        } catch (Throwable th) {
            setException(th);
            throw zzdom.zzh(th);
        }
    }
}
