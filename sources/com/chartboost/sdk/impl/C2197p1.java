package com.chartboost.sdk.impl;

import android.content.Context;
import android.view.View;
import com.chartboost.sdk.Model.C2086a;

/* renamed from: com.chartboost.sdk.impl.p1 */
public final class C2197p1 extends View {

    /* renamed from: a */
    private boolean f7423a = false;

    public C2197p1(Context context) {
        super(context);
        setFocusable(false);
        setBackgroundColor(-1442840576);
    }

    /* renamed from: a */
    public void mo9477a(C2193o1 o1Var, C2086a aVar) {
        if (!this.f7423a) {
            o1Var.mo9475a(true, (View) this, aVar);
            this.f7423a = true;
        }
    }
}
