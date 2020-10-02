package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.firebase.messaging.m */
/* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
final /* synthetic */ class C3813m implements Runnable {

    /* renamed from: a */
    private final C3811k f10552a;

    /* renamed from: b */
    private final Intent f10553b;

    /* renamed from: c */
    private final TaskCompletionSource f10554c;

    C3813m(C3811k kVar, Intent intent, TaskCompletionSource taskCompletionSource) {
        this.f10552a = kVar;
        this.f10553b = intent;
        this.f10554c = taskCompletionSource;
    }

    public final void run() {
        C3811k kVar = this.f10552a;
        Intent intent = this.f10553b;
        TaskCompletionSource taskCompletionSource = this.f10554c;
        try {
            kVar.mo27481c(intent);
        } finally {
            taskCompletionSource.setResult(null);
        }
    }
}
