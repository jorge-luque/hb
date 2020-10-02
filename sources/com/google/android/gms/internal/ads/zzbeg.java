package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzbeg implements DialogInterface.OnCancelListener {
    private final /* synthetic */ JsPromptResult zzehp;

    zzbeg(JsPromptResult jsPromptResult) {
        this.zzehp = jsPromptResult;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.zzehp.cancel();
    }
}
