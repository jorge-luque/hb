package com.google.firebase.iid;

import com.google.android.gms.tasks.Task;

/* renamed from: com.google.firebase.iid.z0 */
/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
final /* synthetic */ class C3750z0 implements C3745x {

    /* renamed from: a */
    private final FirebaseInstanceId f10401a;

    /* renamed from: b */
    private final String f10402b;

    /* renamed from: c */
    private final String f10403c;

    /* renamed from: d */
    private final String f10404d;

    C3750z0(FirebaseInstanceId firebaseInstanceId, String str, String str2, String str3) {
        this.f10401a = firebaseInstanceId;
        this.f10402b = str;
        this.f10403c = str2;
        this.f10404d = str3;
    }

    public final Task zza() {
        return this.f10401a.mo27290a(this.f10402b, this.f10403c, this.f10404d);
    }
}
