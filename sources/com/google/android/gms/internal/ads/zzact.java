package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class zzact extends zzgi implements zzacr {
    zzact(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IMediaContent");
    }

    public final float getAspectRatio() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken());
        float readFloat = transactAndReadException.readFloat();
        transactAndReadException.recycle();
        return readFloat;
    }

    public final float getCurrentTime() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(6, obtainAndWriteInterfaceToken());
        float readFloat = transactAndReadException.readFloat();
        transactAndReadException.recycle();
        return readFloat;
    }

    public final float getDuration() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(5, obtainAndWriteInterfaceToken());
        float readFloat = transactAndReadException.readFloat();
        transactAndReadException.recycle();
        return readFloat;
    }

    public final zzxl getVideoController() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(7, obtainAndWriteInterfaceToken());
        zzxl zzk = zzxk.zzk(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return zzk;
    }

    public final boolean hasVideoContent() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(8, obtainAndWriteInterfaceToken());
        boolean zza = zzgj.zza(transactAndReadException);
        transactAndReadException.recycle();
        return zza;
    }

    public final void zza(zzaee zzaee) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) zzaee);
        zza(9, obtainAndWriteInterfaceToken);
    }

    public final void zzo(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zza(3, obtainAndWriteInterfaceToken);
    }

    public final IObjectWrapper zzry() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(4, obtainAndWriteInterfaceToken());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return asInterface;
    }
}
