package com.google.android.gms.internal.games;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public abstract class zzef {
    private final AtomicReference<zzed> zzlj = new AtomicReference<>();

    public final void flush() {
        zzed zzed = this.zzlj.get();
        if (zzed != null) {
            zzed.flush();
        }
    }

    public final void zza(String str, int i) {
        zzed zzed = this.zzlj.get();
        if (zzed == null) {
            zzed = zzba();
            if (!this.zzlj.compareAndSet((Object) null, zzed)) {
                zzed = this.zzlj.get();
            }
        }
        zzed.zzg(str, i);
    }

    /* access modifiers changed from: protected */
    public abstract zzed zzba();
}
