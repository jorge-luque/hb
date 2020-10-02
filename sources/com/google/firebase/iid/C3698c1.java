package com.google.firebase.iid;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.firebase.iid.c1 */
/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
final /* synthetic */ class C3698c1 implements Runnable {

    /* renamed from: a */
    private final C3700d1 f10296a;

    /* renamed from: b */
    private final String f10297b;

    /* renamed from: c */
    private final String f10298c;

    /* renamed from: d */
    private final String f10299d;

    /* renamed from: e */
    private final Bundle f10300e;

    /* renamed from: f */
    private final TaskCompletionSource f10301f;

    C3698c1(C3700d1 d1Var, String str, String str2, String str3, Bundle bundle, TaskCompletionSource taskCompletionSource) {
        this.f10296a = d1Var;
        this.f10297b = str;
        this.f10298c = str2;
        this.f10299d = str3;
        this.f10300e = bundle;
        this.f10301f = taskCompletionSource;
    }

    public final void run() {
        this.f10296a.mo27319a(this.f10297b, this.f10298c, this.f10299d, this.f10300e, this.f10301f);
    }
}
