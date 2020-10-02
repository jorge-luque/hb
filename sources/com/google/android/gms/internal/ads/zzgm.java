package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public abstract class zzgm extends zzgk implements zzgn {
    public static zzgn zza(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.clearcut.IClearcut");
        if (queryLocalInterface instanceof zzgn) {
            return (zzgn) queryLocalInterface;
        }
        return new zzgo(iBinder);
    }
}
