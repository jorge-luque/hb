package com.onesignal;

import android.annotation.TargetApi;
import android.app.Activity;

@TargetApi(23)
/* renamed from: com.onesignal.f */
/* compiled from: AndroidSupportV4Compat */
class C4503f {
    /* renamed from: a */
    static void m15520a(Activity activity, String[] strArr, int i) {
        if (activity instanceof C4514h) {
            ((C4514h) activity).validateRequestPermissionsRequestCode(i);
        }
        activity.requestPermissions(strArr, i);
    }
}
