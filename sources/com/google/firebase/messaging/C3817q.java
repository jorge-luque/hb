package com.google.firebase.messaging;

import com.google.android.datatransport.cct.C2941a;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.C3637e;
import com.google.firebase.components.C3642g;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.installations.C3764h;
import com.google.firebase.messaging.FirebaseMessagingRegistrar;
import com.google.firebase.p073h.C3687h;
import com.google.firebase.p124e.C3666c;
import p093e.p101c.p102a.p103a.C3378b;
import p093e.p101c.p102a.p103a.C3383g;

/* renamed from: com.google.firebase.messaging.q */
/* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
final /* synthetic */ class C3817q implements C3642g {

    /* renamed from: a */
    static final C3642g f10558a = new C3817q();

    private C3817q() {
    }

    /* renamed from: a */
    public final Object mo27192a(C3637e eVar) {
        FirebaseApp firebaseApp = (FirebaseApp) eVar.mo27220a(FirebaseApp.class);
        FirebaseInstanceId firebaseInstanceId = (FirebaseInstanceId) eVar.mo27220a(FirebaseInstanceId.class);
        C3687h hVar = (C3687h) eVar.mo27220a(C3687h.class);
        C3666c cVar = (C3666c) eVar.mo27220a(C3666c.class);
        C3764h hVar2 = (C3764h) eVar.mo27220a(C3764h.class);
        C3383g gVar = (C3383g) eVar.mo27220a(C3383g.class);
        if (gVar == null || !C2941a.f8216g.mo12851a().contains(C3378b.m11260a("json"))) {
            gVar = new FirebaseMessagingRegistrar.C3795b();
        }
        return new FirebaseMessaging(firebaseApp, firebaseInstanceId, hVar, cVar, hVar2, gVar);
    }
}
