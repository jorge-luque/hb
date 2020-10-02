package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.remoteconfig.internal.C3852k;

/* renamed from: com.google.firebase.remoteconfig.internal.j */
/* compiled from: com.google.firebase:firebase-config@@19.1.4 */
final /* synthetic */ class C3851j implements SuccessContinuation {

    /* renamed from: a */
    private final C3852k.C3853a f10633a;

    private C3851j(C3852k.C3853a aVar) {
        this.f10633a = aVar;
    }

    /* renamed from: a */
    public static SuccessContinuation m13015a(C3852k.C3853a aVar) {
        return new C3851j(aVar);
    }

    public Task then(Object obj) {
        return Tasks.forResult(this.f10633a);
    }
}
