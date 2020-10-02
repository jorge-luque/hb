package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

/* renamed from: com.google.firebase.remoteconfig.a */
/* compiled from: com.google.firebase:firebase-config@@19.1.4 */
final /* synthetic */ class C3827a implements SuccessContinuation {

    /* renamed from: a */
    private static final C3827a f10573a = new C3827a();

    private C3827a() {
    }

    /* renamed from: a */
    public static SuccessContinuation m12938a() {
        return f10573a;
    }

    public Task then(Object obj) {
        return Tasks.forResult(null);
    }
}
