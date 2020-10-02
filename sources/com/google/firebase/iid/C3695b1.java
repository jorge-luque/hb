package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* renamed from: com.google.firebase.iid.b1 */
/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
final /* synthetic */ class C3695b1 implements OnCompleteListener {

    /* renamed from: a */
    private final boolean f10290a;

    /* renamed from: b */
    private final BroadcastReceiver.PendingResult f10291b;

    C3695b1(boolean z, BroadcastReceiver.PendingResult pendingResult) {
        this.f10290a = z;
        this.f10291b = pendingResult;
    }

    public final void onComplete(Task task) {
        FirebaseInstanceIdReceiver.m12558a(this.f10290a, this.f10291b, task);
    }
}
