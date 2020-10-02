package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public abstract class zzamh extends zzgk implements zzame {
    public zzamh() {
        super("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
    }

    public static zzame zzae(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
        if (queryLocalInterface instanceof zzame) {
            return (zzame) queryLocalInterface;
        }
        return new zzamg(iBinder);
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
                String advertiser = getAdvertiser();
                parcel2.writeNoException();
                parcel2.writeString(advertiser);
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
                zzxl videoController = getVideoController();
                parcel2.writeNoException();
                zzgj.zza(parcel2, (IInterface) videoController);
                return true;
            case 12:
                zzack zzsb = zzsb();
                parcel2.writeNoException();
                zzgj.zza(parcel2, (IInterface) zzsb);
                return true;
            case 13:
                IObjectWrapper zztr = zztr();
                parcel2.writeNoException();
                zzgj.zza(parcel2, (IInterface) zztr);
                return true;
            case 14:
                IObjectWrapper zzts = zzts();
                parcel2.writeNoException();
                zzgj.zza(parcel2, (IInterface) zzts);
                return true;
            case 15:
                IObjectWrapper zzsc = zzsc();
                parcel2.writeNoException();
                zzgj.zza(parcel2, (IInterface) zzsc);
                return true;
            case 16:
                Bundle extras = getExtras();
                parcel2.writeNoException();
                zzgj.zzb(parcel2, extras);
                return true;
            case 17:
                boolean overrideImpressionRecording = getOverrideImpressionRecording();
                parcel2.writeNoException();
                zzgj.writeBoolean(parcel2, overrideImpressionRecording);
                return true;
            case 18:
                boolean overrideClickHandling = getOverrideClickHandling();
                parcel2.writeNoException();
                zzgj.writeBoolean(parcel2, overrideClickHandling);
                return true;
            case 19:
                recordImpression();
                parcel2.writeNoException();
                return true;
            case 20:
                zzu(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 21:
                zzc(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 22:
                zzw(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 23:
                float mediaContentAspectRatio = getMediaContentAspectRatio();
                parcel2.writeNoException();
                parcel2.writeFloat(mediaContentAspectRatio);
                return true;
            case 24:
                float videoDuration = getVideoDuration();
                parcel2.writeNoException();
                parcel2.writeFloat(videoDuration);
                return true;
            case 25:
                float videoCurrentTime = getVideoCurrentTime();
                parcel2.writeNoException();
                parcel2.writeFloat(videoCurrentTime);
                return true;
            default:
                return false;
        }
    }
}
