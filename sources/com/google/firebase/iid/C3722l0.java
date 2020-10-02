package com.google.firebase.iid;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.ScheduledFuture;

/* renamed from: com.google.firebase.iid.l0 */
/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
final /* synthetic */ class C3722l0 implements OnCompleteListener {

    /* renamed from: a */
    private final ScheduledFuture f10349a;

    C3722l0(ScheduledFuture scheduledFuture) {
        this.f10349a = scheduledFuture;
    }

    public final void onComplete(Task task) {
        this.f10349a.cancel(false);
    }
}
