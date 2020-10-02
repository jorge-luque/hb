package com.google.android.gms.internal.measurement;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
final class zzdm extends WeakReference<Throwable> {
    private final int zza;

    public zzdm(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th != null) {
            this.zza = System.identityHashCode(th);
            return;
        }
        throw new NullPointerException("The referent cannot be null");
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == zzdm.class) {
            if (this == obj) {
                return true;
            }
            zzdm zzdm = (zzdm) obj;
            return this.zza == zzdm.zza && get() == zzdm.get();
        }
    }

    public final int hashCode() {
        return this.zza;
    }
}
