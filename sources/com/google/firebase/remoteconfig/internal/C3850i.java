package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.internal.C3852k;
import java.util.Date;

/* renamed from: com.google.firebase.remoteconfig.internal.i */
/* compiled from: com.google.firebase:firebase-config@@19.1.4 */
final /* synthetic */ class C3850i implements Continuation {

    /* renamed from: a */
    private final C3852k f10631a;

    /* renamed from: b */
    private final Date f10632b;

    private C3850i(C3852k kVar, Date date) {
        this.f10631a = kVar;
        this.f10632b = date;
    }

    /* renamed from: a */
    public static Continuation m13014a(C3852k kVar, Date date) {
        return new C3850i(kVar, date);
    }

    public Object then(Task task) {
        Task unused = this.f10631a.m13025a((Task<C3852k.C3853a>) task, this.f10632b);
        return task;
    }
}
