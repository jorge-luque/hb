package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzbnw<AdT> implements zzbnx<AdT> {
    private final Map<String, zzcnj<AdT>> zzfku;

    zzbnw(Map<String, zzcnj<AdT>> map) {
        this.zzfku = map;
    }

    public final zzcnj<AdT> zze(int i, String str) {
        return this.zzfku.get(str);
    }
}
