package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;

/* renamed from: com.google.firebase.remoteconfig.internal.b */
/* compiled from: com.google.firebase:firebase-config@@19.1.4 */
final /* synthetic */ class C3839b implements SuccessContinuation {

    /* renamed from: a */
    private final C3842e f10608a;

    /* renamed from: b */
    private final boolean f10609b;

    /* renamed from: c */
    private final C3845f f10610c;

    private C3839b(C3842e eVar, boolean z, C3845f fVar) {
        this.f10608a = eVar;
        this.f10609b = z;
        this.f10610c = fVar;
    }

    /* renamed from: a */
    public static SuccessContinuation m12986a(C3842e eVar, boolean z, C3845f fVar) {
        return new C3839b(eVar, z, fVar);
    }

    public Task then(Object obj) {
        return C3842e.m12989a(this.f10608a, this.f10609b, this.f10610c, (Void) obj);
    }
}
