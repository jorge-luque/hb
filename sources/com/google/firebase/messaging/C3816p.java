package com.google.firebase.messaging;

import com.google.android.gms.tasks.OnSuccessListener;

/* renamed from: com.google.firebase.messaging.p */
/* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
final /* synthetic */ class C3816p implements OnSuccessListener {

    /* renamed from: a */
    private final FirebaseMessaging f10557a;

    C3816p(FirebaseMessaging firebaseMessaging) {
        this.f10557a = firebaseMessaging;
    }

    public final void onSuccess(Object obj) {
        C3804d dVar = (C3804d) obj;
        if (this.f10557a.mo27473a()) {
            dVar.mo27494a();
        }
    }
}
