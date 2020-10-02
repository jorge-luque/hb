package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public abstract class zzbgw extends zzgk implements zzbgt {
    public static zzbgt zzar(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.measurement.IMeasurementManager");
        if (queryLocalInterface instanceof zzbgt) {
            return (zzbgt) queryLocalInterface;
        }
        return new zzbgv(iBinder);
    }
}
