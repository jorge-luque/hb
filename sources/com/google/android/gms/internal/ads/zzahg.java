package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public abstract class zzahg extends zzgk implements zzahh {
    public zzahg() {
        super("com.google.android.gms.ads.internal.initialization.IInitializationCallback");
    }

    public static zzahh zzaa(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.initialization.IInitializationCallback");
        if (queryLocalInterface instanceof zzahh) {
            return (zzahh) queryLocalInterface;
        }
        return new zzahj(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zzd(parcel.createTypedArrayList(zzaha.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
