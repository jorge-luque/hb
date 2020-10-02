package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzdek {
    public static <T> void zza(AtomicReference<T> atomicReference, zzdej<T> zzdej) {
        T t = atomicReference.get();
        if (t != null) {
            try {
                zzdej.zzr(t);
            } catch (RemoteException e) {
                zzazw.zze("#007 Could not call remote method.", e);
            }
        }
    }
}
