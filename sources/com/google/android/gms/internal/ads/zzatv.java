package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class zzatv {
    public static zzatf zzd(Context context, String str, zzalp zzalp) {
        try {
            IBinder zzd = ((zzatl) zzazv.zza(context, "com.google.android.gms.ads.rewarded.ChimeraRewardedAdCreatorImpl", zzaty.zzbvh)).zzd(ObjectWrapper.wrap(context), str, zzalp, 201004000);
            if (zzd == null) {
                return null;
            }
            IInterface queryLocalInterface = zzd.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
            if (queryLocalInterface instanceof zzatf) {
                return (zzatf) queryLocalInterface;
            }
            return new zzath(zzd);
        } catch (RemoteException | zzazx e) {
            zzazw.zze("#007 Could not call remote method.", e);
            return null;
        }
    }
}
