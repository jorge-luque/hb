package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzafv implements zzaga<Object> {
    zzafv() {
    }

    public final void zza(Object obj, Map<String, String> map) {
        String valueOf = String.valueOf(map.get("string"));
        zzazw.zzfb(valueOf.length() != 0 ? "Received log message: ".concat(valueOf) : new String("Received log message: "));
    }
}
