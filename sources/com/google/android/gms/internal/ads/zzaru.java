package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.WeakHashMap;
import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzaru {
    /* access modifiers changed from: private */
    public WeakHashMap<Context, zzarw> zzdqs = new WeakHashMap<>();

    public final Future<zzars> zzx(Context context) {
        return zzbab.zzdzr.zzd(new zzart(this, context));
    }
}
