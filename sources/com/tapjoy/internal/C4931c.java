package com.tapjoy.internal;

import android.app.Dialog;
import android.content.Context;

/* renamed from: com.tapjoy.internal.c */
public final class C4931c extends Dialog {

    /* renamed from: a */
    private boolean f13426a = false;

    public C4931c(Context context) {
        super(context, 16973835);
        requestWindowFeature(1);
        getWindow().setBackgroundDrawableResource(17170445);
    }

    public final void cancel() {
        this.f13426a = true;
        super.cancel();
    }

    public final void show() {
        this.f13426a = false;
        super.show();
    }
}
