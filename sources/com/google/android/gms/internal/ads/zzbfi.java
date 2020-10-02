package com.google.android.gms.internal.ads;

import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzbfi implements zzbfk {
    private final zzbek zzelg;

    zzbfi(zzbek zzbek) {
        this.zzelg = zzbek;
    }

    public final void zzh(Uri uri) {
        zzbfw zzabj = this.zzelg.zzabj();
        if (zzabj == null) {
            zzazw.zzfa("Unable to pass GMSG, no AdWebViewClient for AdWebView!");
        } else {
            zzabj.zzh(uri);
        }
    }
}
