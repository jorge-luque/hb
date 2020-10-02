package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

/* renamed from: com.google.firebase.remoteconfig.e */
/* compiled from: com.google.firebase:firebase-config@@19.1.4 */
final /* synthetic */ class C3831e implements SuccessContinuation {

    /* renamed from: a */
    private static final C3831e f10579a = new C3831e();

    private C3831e() {
    }

    /* renamed from: a */
    public static SuccessContinuation m12942a() {
        return f10579a;
    }

    public Task then(Object obj) {
        return Tasks.forResult(null);
    }
}
