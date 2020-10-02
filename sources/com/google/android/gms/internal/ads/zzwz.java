package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public abstract class zzwz extends zzgk implements zzww {
    public zzwz() {
        super("com.google.android.gms.ads.internal.client.IMuteThisAdReason");
    }

    public static zzww zzg(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMuteThisAdReason");
        if (queryLocalInterface instanceof zzww) {
            return (zzww) queryLocalInterface;
        }
        return new zzwy(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            String description = getDescription();
            parcel2.writeNoException();
            parcel2.writeString(description);
        } else if (i != 2) {
            return false;
        } else {
            String zzqe = zzqe();
            parcel2.writeNoException();
            parcel2.writeString(zzqe);
        }
        return true;
    }
}
