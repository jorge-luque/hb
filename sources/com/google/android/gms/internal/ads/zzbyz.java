package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzbyz implements zzaga<Object> {
    private WeakReference<zzbyx> zzfqq;

    private zzbyz(zzbyx zzbyx) {
        this.zzfqq = new WeakReference<>(zzbyx);
    }

    public final void zza(Object obj, Map<String, String> map) {
        zzbyx zzbyx = (zzbyx) this.zzfqq.get();
        if (zzbyx != null && "_ac".equals(map.get("eventName"))) {
            zzbyx.zzfqd.onAdClicked();
        }
    }
}
