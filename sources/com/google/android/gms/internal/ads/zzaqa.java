package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public abstract class zzaqa extends zzgk implements zzapx {
    public zzaqa() {
        super("com.google.android.gms.ads.internal.query.IUpdateUrlsCallback");
    }

    public static zzapx zzak(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.query.IUpdateUrlsCallback");
        if (queryLocalInterface instanceof zzapx) {
            return (zzapx) queryLocalInterface;
        }
        return new zzapz(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            onSuccess(parcel.createTypedArrayList(Uri.CREATOR));
        } else if (i != 2) {
            return false;
        } else {
            onError(parcel.readString());
        }
        parcel2.writeNoException();
        return true;
    }
}
