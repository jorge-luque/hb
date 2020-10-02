package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* renamed from: com.google.firebase.iid.n0 */
/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
final /* synthetic */ class C3726n0 implements Continuation {

    /* renamed from: a */
    private final Context f10352a;

    /* renamed from: b */
    private final Intent f10353b;

    C3726n0(Context context, Intent intent) {
        this.f10352a = context;
        this.f10353b = intent;
    }

    public final Object then(Task task) {
        return C3696c.m12572a(this.f10352a, this.f10353b, task);
    }
}
