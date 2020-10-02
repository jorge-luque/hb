package com.google.firebase;

import android.content.Context;
import com.google.firebase.p126f.C3680a;

/* renamed from: com.google.firebase.b */
/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
final /* synthetic */ class C3627b implements C3680a {

    /* renamed from: a */
    private final FirebaseApp f10165a;

    /* renamed from: b */
    private final Context f10166b;

    private C3627b(FirebaseApp firebaseApp, Context context) {
        this.f10165a = firebaseApp;
        this.f10166b = context;
    }

    /* renamed from: a */
    public static C3680a m12355a(FirebaseApp firebaseApp, Context context) {
        return new C3627b(firebaseApp, context);
    }

    public Object get() {
        return FirebaseApp.m12293a(this.f10165a, this.f10166b);
    }
}
