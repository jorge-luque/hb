package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzbjy implements zzbjx {
    private zzawt zzduw;

    public zzbjy(zzawt zzawt) {
        this.zzduw = zzawt;
    }

    public final void zzl(Map<String, String> map) {
        this.zzduw.zzap(Boolean.parseBoolean(map.get("content_vertical_opted_out")));
    }
}
