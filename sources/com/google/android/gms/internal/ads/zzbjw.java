package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzbjw implements zzbjx {
    private zzawt zzduw;

    public zzbjw(zzawt zzawt) {
        this.zzduw = zzawt;
    }

    public final void zzl(Map<String, String> map) {
        this.zzduw.zzao(Boolean.parseBoolean(map.get("content_url_opted_out")));
    }
}
