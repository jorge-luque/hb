package com.google.firebase.iid;

import android.os.Binder;
import android.os.Process;
import android.util.Log;

/* renamed from: com.google.firebase.iid.f0 */
/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
public final class C3705f0 extends Binder {

    /* renamed from: a */
    private final C3711h0 f10325a;

    public C3705f0(C3711h0 h0Var) {
        this.f10325a = h0Var;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo27336a(C3717j0 j0Var) {
        if (Binder.getCallingUid() == Process.myUid()) {
            boolean isLoggable = Log.isLoggable("FirebaseInstanceId", 3);
            this.f10325a.zza(j0Var.f10336a).addOnCompleteListener(C3736s0.m12634a(), new C3714i0(j0Var));
            return;
        }
        throw new SecurityException("Binding only allowed within app");
    }
}
