package com.chartboost.sdk.impl;

import android.os.Build;
import com.chartboost.sdk.C2099a;
import com.chartboost.sdk.C2100b;
import com.chartboost.sdk.C2239j;
import com.chartboost.sdk.C2242k;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.CBError;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.impl.z */
public class C2236z {
    /* renamed from: a */
    public static void m8883a(String str, String str2, int i) {
        if (Build.VERSION.SDK_INT < 21) {
            CBLogging.m8154b("OpenRTBCache", "OpenRTBCache not supported for this Android version");
            C2099a aVar = C2242k.f7604d;
            if (aVar != null) {
                aVar.didFailToLoadInterstitial(str, CBError.CBImpressionError.NO_AD_FOUND);
                return;
            }
            return;
        }
        C2239j n = C2239j.m8897n();
        if (n == null) {
            CBLogging.m8154b("OpenRTBCache", "OpenRTBCache cache: SDK is null");
        } else if (!C2119a0.m8427a(str, str2)) {
            C2119a0.m8429b(n, str, i);
        } else {
            C2181n nVar = n.f7576j.f7380a;
            if (nVar == null) {
                C2119a0.m8429b(n, str, i);
                return;
            }
            try {
                C2233y yVar = new C2233y(i, new JSONObject(str2));
                C2242k.f7618r = false;
                m8880a(n, i, str, nVar, yVar);
            } catch (JSONException unused) {
                C2119a0.m8429b(n, str, i);
            }
        }
    }

    /* renamed from: b */
    private static C2143g m8884b(C2239j jVar, int i, String str) {
        if (i == 0) {
            return jVar.mo9606d();
        }
        if (i == 1) {
            return jVar.mo9608f();
        }
        if (i != 3) {
            return null;
        }
        return m8876a(jVar, str);
    }

    /* renamed from: a */
    private static void m8880a(C2239j jVar, int i, String str, C2181n nVar, C2233y yVar) {
        m8878a(nVar, yVar, (C2167j) new C2150g2(jVar, i, str, yVar));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m8882a(C2239j jVar, int i, String str, C2233y yVar, boolean z, int i2, int i3) {
        if (z) {
            m8881a(jVar, i, str, yVar);
        } else {
            C2119a0.m8425a(jVar, str, i);
        }
    }

    /* renamed from: a */
    static void m8881a(C2239j jVar, int i, String str, C2233y yVar) {
        C2143g b = m8884b(jVar, i, str);
        if (b != null) {
            m8877a(b, str, yVar);
            m8879a(jVar, i, str);
            return;
        }
        C2119a0.m8429b(jVar, str, i);
    }

    /* renamed from: a */
    private static void m8878a(C2181n nVar, C2233y yVar, C2167j jVar) {
        nVar.mo9432a(1, yVar.mo9595a().mo9325b(), new AtomicInteger(), jVar);
    }

    /* renamed from: a */
    private static void m8879a(C2239j jVar, int i, String str) {
        if (i == 0) {
            Chartboost.cacheInterstitial(str);
        } else if (i == 1) {
            Chartboost.cacheRewardedVideo(str);
        } else if (i == 3) {
            jVar.f7574h.mo9184c(str);
        }
    }

    /* renamed from: a */
    private static C2143g m8876a(C2239j jVar, String str) {
        C2100b bVar = jVar.f7574h;
        if (bVar != null) {
            return bVar.mo9179a(str);
        }
        C2119a0.m8431d(jVar, str);
        return null;
    }

    /* renamed from: a */
    private static void m8877a(C2143g gVar, String str, C2233y yVar) {
        if (gVar.mo9342d(str) == null) {
            gVar.mo9338a(str, yVar);
        }
    }
}
