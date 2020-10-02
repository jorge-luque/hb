package com.google.android.gms.internal.ads;

import com.tapjoy.TJAdUnitConstants;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzafi implements zzaga<Object> {
    private final zzafl zzczw;

    public zzafi(zzafl zzafl) {
        this.zzczw = zzafl;
    }

    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get("name");
        if (str == null) {
            zzazw.zzfc("App event with no name parameter.");
        } else {
            this.zzczw.onAppEvent(str, map.get(TJAdUnitConstants.String.VIDEO_INFO));
        }
    }
}
