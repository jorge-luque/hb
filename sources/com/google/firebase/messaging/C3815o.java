package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* renamed from: com.google.firebase.messaging.o */
/* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
final /* synthetic */ class C3815o implements OnCompleteListener {

    /* renamed from: a */
    private final C3811k f10555a;

    /* renamed from: b */
    private final Intent f10556b;

    C3815o(C3811k kVar, Intent intent) {
        this.f10555a = kVar;
        this.f10556b = intent;
    }

    public final void onComplete(Task task) {
        this.f10555a.mo27502a(this.f10556b, task);
    }
}
