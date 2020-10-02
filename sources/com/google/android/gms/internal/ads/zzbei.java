package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;
import android.widget.EditText;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzbei implements DialogInterface.OnClickListener {
    private final /* synthetic */ JsPromptResult zzehp;
    private final /* synthetic */ EditText zzehr;

    zzbei(JsPromptResult jsPromptResult, EditText editText) {
        this.zzehp = jsPromptResult;
        this.zzehr = editText;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzehp.confirm(this.zzehr.getText().toString());
    }
}
