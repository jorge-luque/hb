package com.onesignal;

import com.onesignal.C4720x1;
import java.security.SecureRandom;

/* renamed from: com.onesignal.s1 */
/* compiled from: OneSignalChromeTabAndroidFrame */
class C4642s1 extends C4637r1 {

    /* renamed from: a */
    private static boolean f12647a;

    /* renamed from: a */
    static void m16089a(String str, String str2, String str3) {
        C4720x1.C4727f fVar;
        if (!f12647a && (fVar = C4564n1.f12481M) != null && !fVar.f12828b && str != null && str2 != null) {
            String str4 = "?app_id=" + str + "&user_id=" + str2;
            if (str3 != null) {
                str4 = str4 + "&ad_id=" + str3;
            }
            f12647a = C4637r1.m16078a("https://onesignal.com/android_frame.html" + (str4 + "&cbs_id=" + new SecureRandom().nextInt(Integer.MAX_VALUE)), false);
        }
    }
}
