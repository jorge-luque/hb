package com.chartboost.sdk.impl;

import android.text.TextUtils;
import com.chartboost.sdk.Banner.C2061a;
import com.chartboost.sdk.C2239j;
import com.chartboost.sdk.Events.C2070b;
import com.chartboost.sdk.Events.ChartboostCacheError;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.impl.C2117a;

/* renamed from: com.chartboost.sdk.impl.a0 */
class C2119a0 {
    /* renamed from: a */
    static void m8425a(C2239j jVar, String str, int i) {
        if (i == 0) {
            m8428b(jVar, str);
        } else if (i == 1) {
            m8430c(jVar, str);
        } else if (i == 3) {
            m8424a(jVar, str);
        }
    }

    /* renamed from: b */
    private static void m8428b(C2239j jVar, String str) {
        C2117a aVar = jVar.f7584r;
        aVar.getClass();
        m8423a(jVar, new C2117a.C2118a(4, str, CBError.CBImpressionError.ASSETS_DOWNLOAD_FAILURE, (C2070b) null));
    }

    /* renamed from: c */
    private static void m8430c(C2239j jVar, String str) {
        C2117a aVar = jVar.f7588v;
        aVar.getClass();
        m8423a(jVar, new C2117a.C2118a(4, str, CBError.CBImpressionError.ASSETS_DOWNLOAD_FAILURE, (C2070b) null));
    }

    /* renamed from: d */
    static void m8431d(C2239j jVar, String str) {
        C2061a a = jVar.f7574h.mo9179a(str);
        if (a != null) {
            C2131d g = a.mo9003g();
            if (g != null) {
                g.getClass();
                m8423a(jVar, new C2117a.C2118a(6, str, (CBError.CBImpressionError) null, new ChartboostCacheError(0)));
                return;
            }
            CBLogging.m8152a("OpenRTBErrorsHelper", "Banner trait is null");
        }
    }

    /* renamed from: e */
    private static void m8432e(C2239j jVar, String str) {
        C2117a e = jVar.mo9607e();
        e.getClass();
        m8423a(jVar, new C2117a.C2118a(4, str, CBError.CBImpressionError.INTERNAL, (C2070b) null));
    }

    /* renamed from: f */
    private static void m8433f(C2239j jVar, String str) {
        C2117a g = jVar.mo9609g();
        g.getClass();
        m8423a(jVar, new C2117a.C2118a(4, str, CBError.CBImpressionError.INTERNAL, (C2070b) null));
    }

    /* renamed from: b */
    static void m8429b(C2239j jVar, String str, int i) {
        if (i == 0) {
            m8432e(jVar, str);
        } else if (i == 1) {
            m8433f(jVar, str);
        } else if (i == 3) {
            m8431d(jVar, str);
        }
    }

    /* renamed from: a */
    private static void m8424a(C2239j jVar, String str) {
        C2061a a = jVar.f7574h.mo9179a(str);
        if (a != null) {
            C2131d g = a.mo9003g();
            g.getClass();
            m8423a(jVar, new C2117a.C2118a(4, str, (CBError.CBImpressionError) null, new ChartboostCacheError(16)));
        }
    }

    /* renamed from: a */
    private static void m8423a(C2239j jVar, C2117a.C2118a aVar) {
        jVar.mo9611i().post(aVar);
    }

    /* renamed from: a */
    static boolean m8427a(String str, String str2) {
        return m8426a(str) && m8426a(str2);
    }

    /* renamed from: a */
    private static boolean m8426a(String str) {
        return !TextUtils.isEmpty(str);
    }
}
