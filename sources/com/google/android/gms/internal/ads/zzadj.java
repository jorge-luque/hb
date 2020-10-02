package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public abstract class zzadj extends zzgk implements zzadg {
    public zzadj() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 2:
                IObjectWrapper zzrz = zzrz();
                parcel2.writeNoException();
                zzgj.zza(parcel2, (IInterface) zzrz);
                return true;
            case 3:
                String headline = getHeadline();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                return true;
            case 4:
                List images = getImages();
                parcel2.writeNoException();
                parcel2.writeList(images);
                return true;
            case 5:
                String body = getBody();
                parcel2.writeNoException();
                parcel2.writeString(body);
                return true;
            case 6:
                zzacs zzsa = zzsa();
                parcel2.writeNoException();
                zzgj.zza(parcel2, (IInterface) zzsa);
                return true;
            case 7:
                String callToAction = getCallToAction();
                parcel2.writeNoException();
                parcel2.writeString(callToAction);
                return true;
            case 8:
                double starRating = getStarRating();
                parcel2.writeNoException();
                parcel2.writeDouble(starRating);
                return true;
            case 9:
                String store = getStore();
                parcel2.writeNoException();
                parcel2.writeString(store);
                return true;
            case 10:
                String price = getPrice();
                parcel2.writeNoException();
                parcel2.writeString(price);
                return true;
            case 11:
                Bundle extras = getExtras();
                parcel2.writeNoException();
                zzgj.zzb(parcel2, extras);
                return true;
            case 12:
                destroy();
                parcel2.writeNoException();
                return true;
            case 13:
                zzxl videoController = getVideoController();
                parcel2.writeNoException();
                zzgj.zza(parcel2, (IInterface) videoController);
                return true;
            case 14:
                performClick((Bundle) zzgj.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 15:
                boolean recordImpression = recordImpression((Bundle) zzgj.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                zzgj.writeBoolean(parcel2, recordImpression);
                return true;
            case 16:
                reportTouchEvent((Bundle) zzgj.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 17:
                zzack zzsb = zzsb();
                parcel2.writeNoException();
                zzgj.zza(parcel2, (IInterface) zzsb);
                return true;
            case 18:
                IObjectWrapper zzsc = zzsc();
                parcel2.writeNoException();
                zzgj.zza(parcel2, (IInterface) zzsc);
                return true;
            case 19:
                String mediationAdapterClassName = getMediationAdapterClassName();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                return true;
            default:
                return false;
        }
    }
}
