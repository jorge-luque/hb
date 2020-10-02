package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;

@TargetApi(21)
/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzbfn extends zzbfo {
    public zzbfn(zzbek zzbek, zzst zzst, boolean z) {
        super(zzbek, zzst, z);
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (webResourceRequest == null || webResourceRequest.getUrl() == null) {
            return null;
        }
        return zza(webView, webResourceRequest.getUrl().toString(), webResourceRequest.getRequestHeaders());
    }
}
