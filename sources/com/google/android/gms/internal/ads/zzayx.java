package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzayx {
    private Map<Integer, Bitmap> zzdyd = new ConcurrentHashMap();
    private AtomicInteger zzdye = new AtomicInteger(0);

    public final Bitmap zza(Integer num) {
        return this.zzdyd.get(num);
    }
}
