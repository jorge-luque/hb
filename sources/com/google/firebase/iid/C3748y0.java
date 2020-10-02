package com.google.firebase.iid;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;

/* renamed from: com.google.firebase.iid.y0 */
/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
final /* synthetic */ class C3748y0 implements SuccessContinuation {

    /* renamed from: a */
    private final FirebaseInstanceId f10396a;

    /* renamed from: b */
    private final String f10397b;

    /* renamed from: c */
    private final String f10398c;

    /* renamed from: d */
    private final String f10399d;

    C3748y0(FirebaseInstanceId firebaseInstanceId, String str, String str2, String str3) {
        this.f10396a = firebaseInstanceId;
        this.f10397b = str;
        this.f10398c = str2;
        this.f10399d = str3;
    }

    public final Task then(Object obj) {
        return this.f10396a.mo27291a(this.f10397b, this.f10398c, this.f10399d, (String) obj);
    }
}
