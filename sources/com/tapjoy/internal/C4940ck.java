package com.tapjoy.internal;

import android.content.Context;
import android.os.Handler;

/* renamed from: com.tapjoy.internal.ck */
public final class C4940ck {

    /* renamed from: a */
    private static C4941cl f13432a = new C4941cl();

    /* renamed from: a */
    public static String m16778a() {
        return "1.2.19-Tapjoy";
    }

    /* renamed from: a */
    public static boolean m16779a(Context context) {
        C4941cl clVar = f13432a;
        Context applicationContext = context.getApplicationContext();
        C4975do.m16853a((Object) applicationContext, "Application Context cannot be null");
        if (!clVar.f13433a) {
            clVar.f13433a = true;
            C4966dh a = C4966dh.m16831a();
            a.f13501b = new C4945cp(new Handler(), applicationContext, new C4942cm(), a);
            C4960de.m16819a().f13487a = applicationContext.getApplicationContext();
            C4972dm.m16842a(applicationContext);
            C4963df.m16824a().f13494a = applicationContext != null ? applicationContext.getApplicationContext() : null;
        }
        return true;
    }

    /* renamed from: b */
    public static boolean m16780b() {
        return f13432a.f13433a;
    }
}
