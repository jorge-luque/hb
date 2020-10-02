package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
final /* synthetic */ class zzaty implements zzazy {
    static final zzazy zzbvh = new zzaty();

    private zzaty() {
    }

    public final Object apply(Object obj) {
        IBinder iBinder = (IBinder) obj;
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCreator");
        if (queryLocalInterface instanceof zzatl) {
            return (zzatl) queryLocalInterface;
        }
        return new zzato(iBinder);
    }
}
