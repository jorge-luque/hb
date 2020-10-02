package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.C3731q;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.installations.C3764h;
import com.google.firebase.p073h.C3687h;
import com.google.firebase.p124e.C3666c;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import p093e.p101c.p102a.p103a.C3383g;

/* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
public class FirebaseMessaging {
    @SuppressLint({"FirebaseUnknownNullness"})

    /* renamed from: d */
    static C3383g f10497d;

    /* renamed from: a */
    private final Context f10498a;

    /* renamed from: b */
    private final FirebaseInstanceId f10499b;

    /* renamed from: c */
    private final Task<C3804d> f10500c;

    FirebaseMessaging(FirebaseApp firebaseApp, FirebaseInstanceId firebaseInstanceId, C3687h hVar, C3666c cVar, C3764h hVar2, C3383g gVar) {
        f10497d = gVar;
        this.f10499b = firebaseInstanceId;
        Context a = firebaseApp.mo27170a();
        this.f10498a = a;
        Task<C3804d> a2 = C3804d.m12850a(firebaseApp, firebaseInstanceId, new C3731q(a), hVar, cVar, hVar2, this.f10498a, C3814n.m12884a(), new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("Firebase-Messaging-Topics-Io")));
        this.f10500c = a2;
        a2.addOnSuccessListener(C3814n.m12886b(), (OnSuccessListener<? super C3804d>) new C3816p(this));
    }

    @Keep
    static synchronized FirebaseMessaging getInstance(FirebaseApp firebaseApp) {
        FirebaseMessaging firebaseMessaging;
        Class cls = FirebaseMessaging.class;
        synchronized (cls) {
            firebaseMessaging = (FirebaseMessaging) firebaseApp.mo27171a(cls);
        }
        return firebaseMessaging;
    }

    /* renamed from: a */
    public boolean mo27473a() {
        return this.f10499b.mo27304i();
    }
}
