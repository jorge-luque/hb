package com.google.android.gms.internal.games;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzen extends WeakReference<Throwable> {
    private final int zzsw;

    public zzen(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th != null) {
            this.zzsw = System.identityHashCode(th);
            return;
        }
        throw new NullPointerException("The referent cannot be null");
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == zzen.class) {
            if (this == obj) {
                return true;
            }
            zzen zzen = (zzen) obj;
            return this.zzsw == zzen.zzsw && get() == zzen.get();
        }
    }

    public final int hashCode() {
        return this.zzsw;
    }
}
