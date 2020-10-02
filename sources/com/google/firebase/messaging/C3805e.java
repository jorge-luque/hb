package com.google.firebase.messaging;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: com.google.firebase.messaging.e */
/* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
final class C3805e extends BroadcastReceiver {

    /* renamed from: a */
    private C3806f f10530a;

    /* renamed from: b */
    final /* synthetic */ C3806f f10531b;

    public C3805e(C3806f fVar, C3806f fVar2) {
        this.f10531b = fVar;
        this.f10530a = fVar2;
    }

    public final synchronized void onReceive(Context context, Intent intent) {
        if (this.f10530a != null) {
            if (this.f10530a.m12866b()) {
                boolean a = C3806f.m12868c();
                this.f10530a.f10538d.mo27496a(this.f10530a, 0);
                context.unregisterReceiver(this);
                this.f10530a = null;
            }
        }
    }
}
