package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.Nullable;

@VisibleForTesting
/* renamed from: com.google.firebase.iid.d0 */
/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
final class C3100d0 extends BroadcastReceiver {
    @Nullable

    /* renamed from: a */
    private C3702e0 f8641a;

    public C3100d0(C3702e0 e0Var) {
        this.f8641a = e0Var;
    }

    /* renamed from: a */
    public final void mo18333a() {
        boolean l = FirebaseInstanceId.m12532l();
        this.f8641a.mo27324a().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public final void onReceive(Context context, Intent intent) {
        C3702e0 e0Var = this.f8641a;
        if (e0Var != null && e0Var.mo27325b()) {
            boolean l = FirebaseInstanceId.m12532l();
            FirebaseInstanceId.m12526a((Runnable) this.f8641a, 0);
            this.f8641a.mo27324a().unregisterReceiver(this);
            this.f8641a = null;
        }
    }
}
