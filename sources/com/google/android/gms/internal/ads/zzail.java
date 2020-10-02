package com.google.android.gms.internal.ads;

import android.webkit.JavascriptInterface;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzail {
    private final zzaio zzdbx;

    private zzail(zzaio zzaio) {
        this.zzdbx = zzaio;
    }

    @JavascriptInterface
    public final void notify(String str) {
        this.zzdbx.zzde(str);
    }
}
