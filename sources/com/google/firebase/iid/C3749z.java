package com.google.firebase.iid;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.firebase_messaging.zze;

/* renamed from: com.google.firebase.iid.z */
/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
final class C3749z extends zze {

    /* renamed from: a */
    private final /* synthetic */ C3743w f10400a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C3749z(C3743w wVar, Looper looper) {
        super(looper);
        this.f10400a = wVar;
    }

    public final void handleMessage(Message message) {
        this.f10400a.m12641a(message);
    }
}
