package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.zzq;
import java.io.File;
import java.util.Collections;
import java.util.Map;

@TargetApi(11)
/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public class zzbfo extends zzbej {
    public zzbfo(zzbek zzbek, zzst zzst, boolean z) {
        super(zzbek, zzst, z);
    }

    /* access modifiers changed from: protected */
    public final WebResourceResponse zza(WebView webView, String str, Map<String, String> map) {
        String str2;
        if (!(webView instanceof zzbek)) {
            zzazw.zzfc("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return null;
        }
        zzbek zzbek = (zzbek) webView;
        zzaun zzaun = this.zzeid;
        if (zzaun != null) {
            zzaun.zza(str, map, 1);
        }
        if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
            if (map == null) {
                map = Collections.emptyMap();
            }
            return super.zzd(str, map);
        }
        if (zzbek.zzabj() != null) {
            zzbek.zzabj().zzui();
        }
        if (zzbek.zzabh().zzaco()) {
            str2 = (String) zzvj.zzpv().zzd(zzzz.zzcka);
        } else if (zzbek.zzabo()) {
            str2 = (String) zzvj.zzpv().zzd(zzzz.zzcjz);
        } else {
            str2 = (String) zzvj.zzpv().zzd(zzzz.zzcjy);
        }
        zzq.zzkw();
        return zzaxa.zzd(zzbek.getContext(), zzbek.zzzk().zzbnd, str2);
    }
}
