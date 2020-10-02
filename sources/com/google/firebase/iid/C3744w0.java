package com.google.firebase.iid;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.google.firebase.iid.w0 */
/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
final /* synthetic */ class C3744w0 implements OnCompleteListener {

    /* renamed from: a */
    private final CountDownLatch f10389a;

    C3744w0(CountDownLatch countDownLatch) {
        this.f10389a = countDownLatch;
    }

    public final void onComplete(Task task) {
        this.f10389a.countDown();
    }
}
