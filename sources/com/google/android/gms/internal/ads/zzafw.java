package com.google.android.gms.internal.ads;

import com.facebook.internal.NativeProtocol;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzafw implements zzaga<zzbek> {
    zzafw() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbek zzbek = (zzbek) obj;
        String str = (String) map.get(NativeProtocol.WEB_DIALOG_ACTION);
        if ("pause".equals(str)) {
            zzbek.zzkc();
        } else if ("resume".equals(str)) {
            zzbek.zzkd();
        }
    }
}
