package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Parcelable;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import p075d.p088f.p089a.C3217a;

/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
public final class FirebaseInstanceIdReceiver extends C3217a {

    /* renamed from: a */
    private final ExecutorService f10281a = C3736s0.m12635b();

    /* renamed from: a */
    static final /* synthetic */ void m12558a(boolean z, BroadcastReceiver.PendingResult pendingResult, Task task) {
        if (z) {
            pendingResult.setResultCode(task.isSuccessful() ? ((Integer) task.getResult()).intValue() : 500);
        }
        pendingResult.finish();
    }

    public final void onReceive(Context context, Intent intent) {
        C3697c0 c0Var;
        if (intent != null) {
            Parcelable parcelableExtra = intent.getParcelableExtra("wrapped_intent");
            Intent intent2 = parcelableExtra instanceof Intent ? (Intent) parcelableExtra : null;
            if (intent2 != null) {
                intent = intent2;
            }
            intent.setComponent((ComponentName) null);
            intent.setPackage(context.getPackageName());
            if (Build.VERSION.SDK_INT <= 18) {
                intent.removeCategory(context.getPackageName());
            }
            if ("google.com/iid".equals(intent.getStringExtra("from"))) {
                c0Var = new C3718j1(this.f10281a);
            } else {
                c0Var = new C3696c(context, this.f10281a);
            }
            c0Var.zza(intent).addOnCompleteListener((Executor) this.f10281a, new C3695b1(isOrderedBroadcast(), goAsync()));
        }
    }
}
