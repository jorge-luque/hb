package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.formats.ShouldDelayBannerRenderingListener;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class zzzc extends zzaep {
    private final ShouldDelayBannerRenderingListener zzcid;

    public zzzc(ShouldDelayBannerRenderingListener shouldDelayBannerRenderingListener) {
        this.zzcid = shouldDelayBannerRenderingListener;
    }

    public final boolean zzm(IObjectWrapper iObjectWrapper) throws RemoteException {
        return this.zzcid.shouldDelayBannerRendering((Runnable) ObjectWrapper.unwrap(iObjectWrapper));
    }
}
