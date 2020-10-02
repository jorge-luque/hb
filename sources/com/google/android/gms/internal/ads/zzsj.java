package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzsj extends zzgi implements zzsk {
    zzsj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.cache.ICacheService");
    }

    public final zzse zza(zzsf zzsf) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgj.zza(obtainAndWriteInterfaceToken, (Parcelable) zzsf);
        Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken);
        zzse zzse = (zzse) zzgj.zza(transactAndReadException, zzse.CREATOR);
        transactAndReadException.recycle();
        return zzse;
    }
}
