package com.google.android.gms.internal.ads;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzbkd implements zzbjx {
    private final zzawt zzduw;

    public zzbkd(zzawt zzawt) {
        this.zzduw = zzawt;
    }

    public final void zzl(Map<String, String> map) {
        String str = map.get(AppMeasurementSdk.ConditionalUserProperty.VALUE);
        if ("auto_collect_location".equals(map.get("key"))) {
            this.zzduw.zzaq(Boolean.parseBoolean(str));
        }
    }
}
