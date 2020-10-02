package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public abstract class zzalo extends zzgk implements zzalp {
    public zzalo() {
        super("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    public static zzalp zzac(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        if (queryLocalInterface instanceof zzalp) {
            return (zzalp) queryLocalInterface;
        }
        return new zzalr(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzalq zzdg = zzdg(parcel.readString());
            parcel2.writeNoException();
            zzgj.zza(parcel2, (IInterface) zzdg);
        } else if (i == 2) {
            boolean zzdh = zzdh(parcel.readString());
            parcel2.writeNoException();
            zzgj.writeBoolean(parcel2, zzdh);
        } else if (i != 3) {
            return false;
        } else {
            zzanv zzdk = zzdk(parcel.readString());
            parcel2.writeNoException();
            zzgj.zza(parcel2, (IInterface) zzdk);
        }
        return true;
    }
}
