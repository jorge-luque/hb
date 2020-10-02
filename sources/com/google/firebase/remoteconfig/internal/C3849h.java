package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.Date;

/* renamed from: com.google.firebase.remoteconfig.internal.h */
/* compiled from: com.google.firebase:firebase-config@@19.1.4 */
final /* synthetic */ class C3849h implements Continuation {

    /* renamed from: a */
    private final C3852k f10629a;

    /* renamed from: b */
    private final Date f10630b;

    private C3849h(C3852k kVar, Date date) {
        this.f10629a = kVar;
        this.f10630b = date;
    }

    /* renamed from: a */
    public static Continuation m13013a(C3852k kVar, Date date) {
        return new C3849h(kVar, date);
    }

    public Object then(Task task) {
        return C3852k.m13020a(this.f10629a, this.f10630b, task);
    }
}
