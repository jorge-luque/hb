package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzbed implements DialogInterface.OnClickListener {
    private final /* synthetic */ JsResult zzeho;

    zzbed(JsResult jsResult) {
        this.zzeho = jsResult;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzeho.confirm();
    }
}
