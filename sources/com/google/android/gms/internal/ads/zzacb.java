package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class zzacb {
    private static final AtomicReference<zzaby> zzcyd = new AtomicReference<>();
    static final AtomicBoolean zzcye = new AtomicBoolean();

    public static void zza(zzaby zzaby) {
        zzcyd.set(zzaby);
    }

    static zzaby zzrq() {
        return zzcyd.get();
    }
}
