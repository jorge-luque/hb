package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public abstract class zzdlh extends zzgk implements zzdli {
    public static zzdli zzas(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.omid.IOmid");
        if (queryLocalInterface instanceof zzdli) {
            return (zzdli) queryLocalInterface;
        }
        return new zzdlj(iBinder);
    }
}
