package com.google.firebase.messaging;

import android.content.Context;
import com.google.firebase.iid.C3700d1;
import com.google.firebase.iid.C3731q;
import com.google.firebase.iid.FirebaseInstanceId;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;

/* renamed from: com.google.firebase.messaging.c */
/* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
final /* synthetic */ class C3803c implements Callable {

    /* renamed from: a */
    private final Context f10516a;

    /* renamed from: b */
    private final ScheduledExecutorService f10517b;

    /* renamed from: c */
    private final FirebaseInstanceId f10518c;

    /* renamed from: d */
    private final C3731q f10519d;

    /* renamed from: e */
    private final C3700d1 f10520e;

    C3803c(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseInstanceId firebaseInstanceId, C3731q qVar, C3700d1 d1Var) {
        this.f10516a = context;
        this.f10517b = scheduledExecutorService;
        this.f10518c = firebaseInstanceId;
        this.f10519d = qVar;
        this.f10520e = d1Var;
    }

    public final Object call() {
        return C3804d.m12851a(this.f10516a, this.f10517b, this.f10518c, this.f10519d, this.f10520e);
    }
}
