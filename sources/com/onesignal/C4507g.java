package com.onesignal;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.util.Log;

/* renamed from: com.onesignal.g */
/* compiled from: AndroidSupportV4Compat */
class C4507g {
    /* renamed from: a */
    static int m15529a(Context context, String str) {
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        } catch (Throwable unused) {
            Log.e("OneSignal", "checkSelfPermission failed, returning PERMISSION_DENIED");
            return -1;
        }
    }

    /* renamed from: a */
    static int m15528a(Context context, int i) {
        if (Build.VERSION.SDK_INT > 22) {
            return context.getColor(i);
        }
        return context.getResources().getColor(i);
    }
}
