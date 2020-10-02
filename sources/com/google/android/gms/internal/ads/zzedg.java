package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class zzedg<K, V> {
    static <K, V> void zza(zzebk zzebk, zzedf<K, V> zzedf, K k, V v) throws IOException {
        zzebt.zza(zzebk, zzedf.zzhzw, 1, k);
        zzebt.zza(zzebk, zzedf.zzhzy, 2, v);
    }

    static <K, V> int zza(zzedf<K, V> zzedf, K k, V v) {
        return zzebt.zza(zzedf.zzhzw, 1, k) + zzebt.zza(zzedf.zzhzy, 2, v);
    }
}
