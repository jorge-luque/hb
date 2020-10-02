package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class zzapv extends zzgk implements zzapw {
    public static zzapw zzaj(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IPlayStorePurchaseListener");
        if (queryLocalInterface instanceof zzapw) {
            return (zzapw) queryLocalInterface;
        }
        return new zzapy(iBinder);
    }
}
