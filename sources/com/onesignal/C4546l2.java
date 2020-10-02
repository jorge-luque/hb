package com.onesignal;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.stats.CodePackage;

/* renamed from: com.onesignal.l2 */
/* compiled from: PushRegistratorGCM */
class C4546l2 extends C4532j2 {
    C4546l2() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo29805a() {
        return CodePackage.GCM;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo29806a(String str) throws Throwable {
        return GoogleCloudMessaging.getInstance(C4564n1.f12495e).register(new String[]{str});
    }
}
