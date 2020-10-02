package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.ExecutorService;
import javax.annotation.concurrent.GuardedBy;

/* renamed from: com.google.firebase.iid.c */
/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
public final class C3696c implements C3697c0 {

    /* renamed from: c */
    private static final Object f10292c = new Object();
    @GuardedBy("lock")

    /* renamed from: d */
    private static C3720k0 f10293d;

    /* renamed from: a */
    private final Context f10294a;

    /* renamed from: b */
    private final ExecutorService f10295b;

    public C3696c(Context context, ExecutorService executorService) {
        this.f10294a = context;
        this.f10295b = executorService;
    }

    /* renamed from: a */
    private static C3720k0 m12573a(Context context, String str) {
        C3720k0 k0Var;
        synchronized (f10292c) {
            if (f10293d == null) {
                f10293d = new C3720k0(context, str);
            }
            k0Var = f10293d;
        }
        return k0Var;
    }

    /* renamed from: b */
    private static Task<Integer> m12576b(Context context, Intent intent) {
        boolean isLoggable = Log.isLoggable("FirebaseInstanceId", 3);
        return m12573a(context, "com.google.firebase.MESSAGING_EVENT").mo27348a(intent).continueWith(C3736s0.m12634a(), C3732q0.f10368a);
    }

    public final Task<Integer> zza(Intent intent) {
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        boolean z = false;
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        Context context = this.f10294a;
        boolean z2 = PlatformVersion.isAtLeastO() && context.getApplicationInfo().targetSdkVersion >= 26;
        if ((intent.getFlags() & DriveFile.MODE_READ_ONLY) != 0) {
            z = true;
        }
        if (!z2 || z) {
            return Tasks.call(this.f10295b, new C3728o0(context, intent)).continueWithTask(this.f10295b, new C3726n0(context, intent));
        }
        return m12576b(context, intent);
    }

    /* renamed from: a */
    static final /* synthetic */ Integer m12575a(Task task) throws Exception {
        return -1;
    }

    /* renamed from: a */
    static final /* synthetic */ Task m12572a(Context context, Intent intent, Task task) throws Exception {
        return (!PlatformVersion.isAtLeastO() || ((Integer) task.getResult()).intValue() != 402) ? task : m12576b(context, intent).continueWith(C3736s0.m12634a(), C3730p0.f10362a);
    }
}
