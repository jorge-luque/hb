package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public abstract class zzwo extends zzgk implements zzwp {
    public zzwo() {
        super("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                initialize();
                parcel2.writeNoException();
                return true;
            case 2:
                setAppVolume(parcel.readFloat());
                parcel2.writeNoException();
                return true;
            case 3:
                zzcf(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 4:
                setAppMuted(zzgj.zza(parcel));
                parcel2.writeNoException();
                return true;
            case 5:
                zzb(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                zza(parcel.readString(), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 7:
                float zzqb = zzqb();
                parcel2.writeNoException();
                parcel2.writeFloat(zzqb);
                return true;
            case 8:
                boolean zzqc = zzqc();
                parcel2.writeNoException();
                zzgj.writeBoolean(parcel2, zzqc);
                return true;
            case 9:
                String versionString = getVersionString();
                parcel2.writeNoException();
                parcel2.writeString(versionString);
                return true;
            case 10:
                zzcg(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 11:
                zza(zzalo.zzac(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 12:
                zza(zzahg.zzaa(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 13:
                List<zzaha> zzqd = zzqd();
                parcel2.writeNoException();
                parcel2.writeTypedList(zzqd);
                return true;
            case 14:
                zza((zzyy) zzgj.zza(parcel, zzyy.CREATOR));
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
