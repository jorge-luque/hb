package com.google.firebase.iid;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* renamed from: com.google.firebase.iid.u0 */
/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
final /* synthetic */ class C3740u0 implements Continuation {

    /* renamed from: a */
    private final FirebaseInstanceId f10375a;

    /* renamed from: b */
    private final String f10376b;

    /* renamed from: c */
    private final String f10377c;

    C3740u0(FirebaseInstanceId firebaseInstanceId, String str, String str2) {
        this.f10375a = firebaseInstanceId;
        this.f10376b = str;
        this.f10377c = str2;
    }

    public final Object then(Task task) {
        return this.f10375a.mo27289a(this.f10376b, this.f10377c, task);
    }
}
