package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public abstract class zzamb extends zzgk implements zzaly {
    public zzamb() {
        super("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 2:
                String headline = getHeadline();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                return true;
            case 3:
                List images = getImages();
                parcel2.writeNoException();
                parcel2.writeList(images);
                return true;
            case 4:
                String body = getBody();
                parcel2.writeNoException();
                parcel2.writeString(body);
                return true;
            case 5:
                zzacs zzsa = zzsa();
                parcel2.writeNoException();
                zzgj.zza(parcel2, (IInterface) zzsa);
                return true;
            case 6:
                String callToAction = getCallToAction();
                parcel2.writeNoException();
                parcel2.writeString(callToAction);
                return true;
            case 7:
                double starRating = getStarRating();
                parcel2.writeNoException();
                parcel2.writeDouble(starRating);
                return true;
            case 8:
                String store = getStore();
                parcel2.writeNoException();
                parcel2.writeString(store);
                return true;
            case 9:
                String price = getPrice();
                parcel2.writeNoException();
                parcel2.writeString(price);
                return true;
            case 10:
                recordImpression();
                parcel2.writeNoException();
                return true;
            case 11:
                zzu(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 12:
                zzv(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 13:
                boolean overrideImpressionRecording = getOverrideImpressionRecording();
                parcel2.writeNoException();
                zzgj.writeBoolean(parcel2, overrideImpressionRecording);
                return true;
            case 14:
                boolean overrideClickHandling = getOverrideClickHandling();
                parcel2.writeNoException();
                zzgj.writeBoolean(parcel2, overrideClickHandling);
                return true;
            case 15:
                Bundle extras = getExtras();
                parcel2.writeNoException();
                zzgj.zzb(parcel2, extras);
                return true;
            case 16:
                zzw(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 17:
                zzxl videoController = getVideoController();
                parcel2.writeNoException();
                zzgj.zza(parcel2, (IInterface) videoController);
                return true;
            case 18:
                IObjectWrapper zztr = zztr();
                parcel2.writeNoException();
                zzgj.zza(parcel2, (IInterface) zztr);
                return true;
            case 19:
                zzack zzsb = zzsb();
                parcel2.writeNoException();
                zzgj.zza(parcel2, (IInterface) zzsb);
                return true;
            case 20:
                IObjectWrapper zzts = zzts();
                parcel2.writeNoException();
                zzgj.zza(parcel2, (IInterface) zzts);
                return true;
            case 21:
                IObjectWrapper zzsc = zzsc();
                parcel2.writeNoException();
                zzgj.zza(parcel2, (IInterface) zzsc);
                return true;
            case 22:
                zzc(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
