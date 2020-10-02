package com.google.android.gms.internal.ads;

import admost.sdk.listener.AdMostAdListener;
import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzagn extends zzb<zzags> {
    zzagn(Context context, Looper looper, BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        super(zzase.zzaa(context), looper, AdMostAdListener.STATUS_CHANGED, baseConnectionCallbacks, baseOnConnectionFailedListener, (String) null);
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService");
        if (queryLocalInterface instanceof zzags) {
            return (zzags) queryLocalInterface;
        }
        return new zzagv(iBinder);
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting
    public final String getServiceDescriptor() {
        return "com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService";
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting
    public final String getStartServiceAction() {
        return "com.google.android.gms.ads.service.HTTP";
    }

    public final zzags zzso() throws DeadObjectException {
        return (zzags) super.getService();
    }
}
