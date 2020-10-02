package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class zzapu extends zzgk implements zzapr {
    public static zzapr zzai(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManager");
        if (queryLocalInterface instanceof zzapr) {
            return (zzapr) queryLocalInterface;
        }
        return new zzapt(iBinder);
    }
}
