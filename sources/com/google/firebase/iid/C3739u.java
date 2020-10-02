package com.google.firebase.iid;

import android.util.Pair;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* renamed from: com.google.firebase.iid.u */
/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
final /* synthetic */ class C3739u implements Continuation {

    /* renamed from: a */
    private final C3741v f10373a;

    /* renamed from: b */
    private final Pair f10374b;

    C3739u(C3741v vVar, Pair pair) {
        this.f10373a = vVar;
        this.f10374b = pair;
    }

    public final Object then(Task task) {
        this.f10373a.mo27369a(this.f10374b, task);
        return task;
    }
}
