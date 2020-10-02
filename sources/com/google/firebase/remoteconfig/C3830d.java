package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* renamed from: com.google.firebase.remoteconfig.d */
/* compiled from: com.google.firebase:firebase-config@@19.1.4 */
final /* synthetic */ class C3830d implements Continuation {

    /* renamed from: a */
    private final C3833g f10576a;

    /* renamed from: b */
    private final Task f10577b;

    /* renamed from: c */
    private final Task f10578c;

    private C3830d(C3833g gVar, Task task, Task task2) {
        this.f10576a = gVar;
        this.f10577b = task;
        this.f10578c = task2;
    }

    /* renamed from: a */
    public static Continuation m12941a(C3833g gVar, Task task, Task task2) {
        return new C3830d(gVar, task, task2);
    }

    public Object then(Task task) {
        return C3833g.m12944a(this.f10576a, this.f10577b, this.f10578c, task);
    }
}
