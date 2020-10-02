package com.onesignal;

import android.content.ComponentName;
import android.content.Context;
import android.util.Base64;
import com.google.firebase.C3628c;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/* renamed from: com.onesignal.k2 */
/* compiled from: PushRegistratorFCM */
class C4539k2 extends C4532j2 {

    /* renamed from: f */
    private FirebaseApp f12410f;

    C4539k2() {
    }

    /* renamed from: a */
    static void m15650a(Context context) {
        try {
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, FirebaseInstanceIdService.class), C4536k1.m15620a(context, "gcm_defaultSenderId", (String) null) == null ? 2 : 1, 1);
        } catch (IllegalArgumentException | NoClassDefFoundError unused) {
        }
    }

    /* renamed from: b */
    private void m15651b(String str) {
        if (this.f12410f == null) {
            C3628c.C3630b bVar = new C3628c.C3630b();
            bVar.mo27217c(str);
            bVar.mo27216b(m15653e());
            bVar.mo27214a(m15652d());
            bVar.mo27218d(m15654f());
            this.f12410f = FirebaseApp.m12292a(C4564n1.f12495e, bVar.mo27215a(), "ONESIGNAL_SDK_FCM_APP_NAME");
        }
    }

    /* renamed from: d */
    private static String m15652d() {
        String str = C4564n1.f12481M.f12835i.f12821c;
        if (str != null) {
            return str;
        }
        return new String(Base64.decode("QUl6YVN5QW5UTG41LV80TWMyYTJQLWRLVWVFLWFCdGd5Q3JqbFlV", 0));
    }

    /* renamed from: e */
    private static String m15653e() {
        String str = C4564n1.f12481M.f12835i.f12820b;
        return str != null ? str : "1:754795614042:android:c682b8144a8dd52bc1ad63";
    }

    /* renamed from: f */
    private static String m15654f() {
        String str = C4564n1.f12481M.f12835i.f12819a;
        return str != null ? str : "onesignal-shared-public";
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo29805a() {
        return "FCM";
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo29806a(String str) throws Throwable {
        m15651b(str);
        return FirebaseInstanceId.getInstance(this.f12410f).mo27293a(str, "FCM");
    }
}
