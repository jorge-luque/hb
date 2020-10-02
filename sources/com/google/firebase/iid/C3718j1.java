package com.google.firebase.iid;

import android.content.Intent;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.ExecutorService;

/* renamed from: com.google.firebase.iid.j1 */
/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
final class C3718j1 implements C3697c0 {

    /* renamed from: a */
    private final ExecutorService f10338a;

    C3718j1(ExecutorService executorService) {
        this.f10338a = executorService;
    }

    public final Task<Integer> zza(Intent intent) {
        return Tasks.call(this.f10338a, new C3715i1(intent));
    }
}
