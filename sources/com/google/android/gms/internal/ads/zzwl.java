package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public abstract class zzwl extends zzgk implements zzwi {
    public zzwl() {
        super("com.google.android.gms.ads.internal.client.IClientApi");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzvz zza = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzum) zzgj.zza(parcel, zzum.CREATOR), parcel.readString(), zzalo.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgj.zza(parcel2, (IInterface) zza);
                return true;
            case 2:
                zzvz zzb = zzb(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzum) zzgj.zza(parcel, zzum.CREATOR), parcel.readString(), zzalo.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgj.zza(parcel2, (IInterface) zzb);
                return true;
            case 3:
                zzvs zza2 = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), zzalo.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgj.zza(parcel2, (IInterface) zza2);
                return true;
            case 4:
                zzwp zzc = zzc(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgj.zza(parcel2, (IInterface) zzc);
                return true;
            case 5:
                zzacw zza3 = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgj.zza(parcel2, (IInterface) zza3);
                return true;
            case 6:
                zzask zza4 = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzalo.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgj.zza(parcel2, (IInterface) zza4);
                return true;
            case 7:
                zzapr zzd = zzd(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgj.zza(parcel2, (IInterface) zzd);
                return true;
            case 8:
                zzapg zzb2 = zzb(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgj.zza(parcel2, (IInterface) zzb2);
                return true;
            case 9:
                zzwp zza5 = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgj.zza(parcel2, (IInterface) zza5);
                return true;
            case 10:
                zzvz zza6 = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzum) zzgj.zza(parcel, zzum.CREATOR), parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                zzgj.zza(parcel2, (IInterface) zza6);
                return true;
            case 11:
                zzadd zza7 = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgj.zza(parcel2, (IInterface) zza7);
                return true;
            case 12:
                zzatf zzb3 = zzb(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), zzalo.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgj.zza(parcel2, (IInterface) zzb3);
                return true;
            case 13:
                zzvz zzc2 = zzc(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzum) zzgj.zza(parcel, zzum.CREATOR), parcel.readString(), zzalo.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgj.zza(parcel2, (IInterface) zzc2);
                return true;
            default:
                return false;
        }
    }
}
