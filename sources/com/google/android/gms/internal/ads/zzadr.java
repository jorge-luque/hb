package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public abstract class zzadr extends zzgk implements zzado {
    public zzadr() {
        super("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    }

    public static zzado zzr(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
        if (queryLocalInterface instanceof zzado) {
            return (zzado) queryLocalInterface;
        }
        return new zzadq(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                String zzcv = zzcv(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(zzcv);
                return true;
            case 2:
                zzacs zzcw = zzcw(parcel.readString());
                parcel2.writeNoException();
                zzgj.zza(parcel2, (IInterface) zzcw);
                return true;
            case 3:
                List<String> availableAssetNames = getAvailableAssetNames();
                parcel2.writeNoException();
                parcel2.writeStringList(availableAssetNames);
                return true;
            case 4:
                String customTemplateId = getCustomTemplateId();
                parcel2.writeNoException();
                parcel2.writeString(customTemplateId);
                return true;
            case 5:
                performClick(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                recordImpression();
                parcel2.writeNoException();
                return true;
            case 7:
                zzxl videoController = getVideoController();
                parcel2.writeNoException();
                zzgj.zza(parcel2, (IInterface) videoController);
                return true;
            case 8:
                destroy();
                parcel2.writeNoException();
                return true;
            case 9:
                IObjectWrapper zzse = zzse();
                parcel2.writeNoException();
                zzgj.zza(parcel2, (IInterface) zzse);
                return true;
            case 10:
                boolean zzp = zzp(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgj.writeBoolean(parcel2, zzp);
                return true;
            case 11:
                IObjectWrapper zzrz = zzrz();
                parcel2.writeNoException();
                zzgj.zza(parcel2, (IInterface) zzrz);
                return true;
            case 12:
                boolean zzsf = zzsf();
                parcel2.writeNoException();
                zzgj.writeBoolean(parcel2, zzsf);
                return true;
            case 13:
                boolean zzsg = zzsg();
                parcel2.writeNoException();
                zzgj.writeBoolean(parcel2, zzsg);
                return true;
            case 14:
                zzq(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 15:
                zzsh();
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
