package com.google.firebase.iid;

import android.content.Intent;
import android.util.Log;
import java.util.concurrent.Callable;

/* renamed from: com.google.firebase.iid.i1 */
/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
final /* synthetic */ class C3715i1 implements Callable {

    /* renamed from: a */
    private final Intent f10334a;

    C3715i1(Intent intent) {
        this.f10334a = intent;
    }

    public final Object call() {
        Intent intent = this.f10334a;
        String stringExtra = intent.getStringExtra("CMD");
        if (stringExtra != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(intent.getExtras());
                StringBuilder sb = new StringBuilder(String.valueOf(stringExtra).length() + 21 + String.valueOf(valueOf).length());
                sb.append("Received command: ");
                sb.append(stringExtra);
                sb.append(" - ");
                sb.append(valueOf);
                sb.toString();
            }
            if ("RST".equals(stringExtra) || "RST_FULL".equals(stringExtra)) {
                FirebaseInstanceId.m12531k().mo27301f();
            } else if ("SYNC".equals(stringExtra)) {
                FirebaseInstanceId.m12531k().mo27303h();
            }
        }
        return -1;
    }
}
