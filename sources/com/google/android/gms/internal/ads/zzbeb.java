package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzbeb implements DialogInterface.OnCancelListener {
    private final /* synthetic */ JsResult zzeho;

    zzbeb(JsResult jsResult) {
        this.zzeho = jsResult;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.zzeho.cancel();
    }
}
