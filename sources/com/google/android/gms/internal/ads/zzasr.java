package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class zzasr extends RemoteCreator<zzasl> {
    public zzasr() {
        super("com.google.android.gms.ads.reward.RewardedVideoAdCreatorImpl");
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
        if (queryLocalInterface instanceof zzasl) {
            return (zzasl) queryLocalInterface;
        }
        return new zzaso(iBinder);
    }

    public final zzask zza(Context context, zzalp zzalp) {
        try {
            IBinder zzb = ((zzasl) getRemoteCreatorInstance(context)).zzb(ObjectWrapper.wrap(context), zzalp, 201004000);
            if (zzb == null) {
                return null;
            }
            IInterface queryLocalInterface = zzb.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
            if (queryLocalInterface instanceof zzask) {
                return (zzask) queryLocalInterface;
            }
            return new zzasm(zzb);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e) {
            zzazw.zzd("Could not get remote RewardedVideoAd.", e);
            return null;
        }
    }
}
