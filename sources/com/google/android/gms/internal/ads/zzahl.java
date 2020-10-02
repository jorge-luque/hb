package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.InitializationStatus;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class zzahl implements InitializationStatus {
    private final Map<String, AdapterStatus> zzdbl;

    public zzahl(Map<String, AdapterStatus> map) {
        this.zzdbl = map;
    }

    public final Map<String, AdapterStatus> getAdapterStatusMap() {
        return this.zzdbl;
    }
}
