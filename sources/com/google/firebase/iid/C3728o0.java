package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import java.util.concurrent.Callable;

/* renamed from: com.google.firebase.iid.o0 */
/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
final /* synthetic */ class C3728o0 implements Callable {

    /* renamed from: a */
    private final Context f10356a;

    /* renamed from: b */
    private final Intent f10357b;

    C3728o0(Context context, Intent intent) {
        this.f10356a = context;
        this.f10357b = intent;
    }

    public final Object call() {
        return Integer.valueOf(C3747y.m12648b().mo27375a(this.f10356a, this.f10357b));
    }
}
