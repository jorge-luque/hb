package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class zzavp extends zzgi implements zzavn {
    zzavp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.signals.ISignalGenerator");
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzavt zzavt, zzavm zzavm) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zzgj.zza(obtainAndWriteInterfaceToken, (Parcelable) zzavt);
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) zzavm);
        zza(1, obtainAndWriteInterfaceToken);
    }

    public final void zzan(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zza(2, obtainAndWriteInterfaceToken);
    }

    public final IObjectWrapper zzao(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        Parcel transactAndReadException = transactAndReadException(4, obtainAndWriteInterfaceToken);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return asInterface;
    }

    public final IObjectWrapper zzb(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper2);
        Parcel transactAndReadException = transactAndReadException(3, obtainAndWriteInterfaceToken);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return asInterface;
    }

    public final void zza(List<Uri> list, IObjectWrapper iObjectWrapper, zzapx zzapx) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeTypedList(list);
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) zzapx);
        zza(5, obtainAndWriteInterfaceToken);
    }

    public final void zzb(List<Uri> list, IObjectWrapper iObjectWrapper, zzapx zzapx) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeTypedList(list);
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) zzapx);
        zza(6, obtainAndWriteInterfaceToken);
    }

    public final void zza(zzaqh zzaqh) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgj.zza(obtainAndWriteInterfaceToken, (Parcelable) zzaqh);
        zza(7, obtainAndWriteInterfaceToken);
    }
}
