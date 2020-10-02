package com.google.android.gms.internal.ads;

import com.tapjoy.TJAdUnitConstants;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzafz implements zzaga<zzbek> {
    zzafz() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbek zzbek = (zzbek) obj;
        if (map.keySet().contains(TJAdUnitConstants.String.VIDEO_START)) {
            zzbek.zzabj().zzaaw();
        } else if (map.keySet().contains("stop")) {
            zzbek.zzabj().zzaax();
        } else if (map.keySet().contains("cancel")) {
            zzbek.zzabj().zzaay();
        }
    }
}
