package com.google.firebase.iid;

import admost.sdk.base.AdMost;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* renamed from: com.google.firebase.iid.p0 */
/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
final /* synthetic */ class C3730p0 implements Continuation {

    /* renamed from: a */
    static final Continuation f10362a = new C3730p0();

    private C3730p0() {
    }

    public final Object then(Task task) {
        return Integer.valueOf(AdMost.AD_ERROR_NOT_CACHABLE);
    }
}
