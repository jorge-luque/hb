package com.google.android.gms.internal.games;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzem extends zzel {
    private final zzek zzsv = new zzek();

    zzem() {
    }

    public final void zza(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        } else if (th2 != null) {
            this.zzsv.zza(th, true).add(th2);
        } else {
            throw new NullPointerException("The suppressed exception cannot be null.");
        }
    }
}
