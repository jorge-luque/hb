package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.loopj.android.http.C4250c;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzcbc implements zzaga {
    private final zzcbb zzfuc;

    zzcbc(zzcbb zzcbb) {
        this.zzfuc = zzcbb;
    }

    public final void zza(Object obj, Map map) {
        zzbek zzbek = (zzbek) obj;
        zzbek.zzabj().zza((zzbfv) new zzcbh(this.zzfuc, map));
        String str = (String) map.get("overlayHtml");
        String str2 = (String) map.get("baseUrl");
        if (TextUtils.isEmpty(str2)) {
            zzbek.loadData(str, "text/html", C4250c.DEFAULT_CHARSET);
        } else {
            zzbek.loadDataWithBaseURL(str2, str, "text/html", C4250c.DEFAULT_CHARSET, (String) null);
        }
    }
}
