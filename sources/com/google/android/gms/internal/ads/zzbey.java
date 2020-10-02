package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzbey implements Runnable {
    private final IObjectWrapper zzeji;

    zzbey(IObjectWrapper iObjectWrapper) {
        this.zzeji = iObjectWrapper;
    }

    public final void run() {
        zzq.zzll().zzac(this.zzeji);
    }
}
