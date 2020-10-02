package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
final class zzeeq extends zzeew {
    private final /* synthetic */ zzeel zzicc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzeeq(zzeel zzeel) {
        super(zzeel, (zzeeo) null);
        this.zzicc = zzeel;
    }

    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzeen(this.zzicc, (zzeeo) null);
    }

    /* synthetic */ zzeeq(zzeel zzeel, zzeeo zzeeo) {
        this(zzeel);
    }
}
