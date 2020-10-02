package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class zzacy extends zzgi implements zzacw {
    zzacy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
    }

    public final void destroy() throws RemoteException {
        zza(4, obtainAndWriteInterfaceToken());
    }

    public final void zza(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zza(3, obtainAndWriteInterfaceToken);
    }

    public final void zzb(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zza(1, obtainAndWriteInterfaceToken);
    }

    public final void zzc(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        obtainAndWriteInterfaceToken.writeInt(i);
        zza(5, obtainAndWriteInterfaceToken);
    }

    public final IObjectWrapper zzcq(String str) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        Parcel transactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return asInterface;
    }

    public final void zze(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zza(6, obtainAndWriteInterfaceToken);
    }

    public final void zzf(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zza(7, obtainAndWriteInterfaceToken);
    }

    public final void zzg(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zza(9, obtainAndWriteInterfaceToken);
    }

    public final void zza(zzacr zzacr) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) zzacr);
        zza(8, obtainAndWriteInterfaceToken);
    }
}
