package com.applovin.impl.mediation.p047d;

import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.p050b.C1840b;
import com.applovin.impl.sdk.p050b.C1843e;
import com.applovin.impl.sdk.utils.C1992h;
import com.applovin.impl.sdk.utils.C1993i;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.d.b */
public class C1728b extends C1992h {

    /* renamed from: a */
    private static final String[] f5368a = {"ads", "settings", "auto_init_adapters", "test_mode_idfas", "test_mode_auto_init_adapters"};

    /* renamed from: b */
    private static final String[] f5369b = {"ads", "settings", "signal_providers"};

    /* renamed from: a */
    public static String m6614a(C1941j jVar) {
        return C1992h.m7847a((String) jVar.mo8549a(C1840b.f5765c), "1.0/mediate", jVar);
    }

    /* renamed from: a */
    public static void m6615a(JSONObject jSONObject, C1941j jVar) {
        if (C1993i.m7893a(jSONObject, "signal_providers")) {
            JSONObject d = C1993i.m7905d(jSONObject);
            C1993i.m7891a(d, f5368a);
            jVar.mo8556a(C1843e.f6109w, d.toString());
        }
    }

    /* renamed from: b */
    public static String m6616b(C1941j jVar) {
        return C1992h.m7847a((String) jVar.mo8549a(C1840b.f5766d), "1.0/mediate", jVar);
    }

    /* renamed from: b */
    public static void m6617b(JSONObject jSONObject, C1941j jVar) {
        if (C1993i.m7893a(jSONObject, "auto_init_adapters")) {
            JSONObject d = C1993i.m7905d(jSONObject);
            C1993i.m7891a(d, f5369b);
            jVar.mo8556a(C1843e.f6110x, d.toString());
        }
    }

    /* renamed from: c */
    public static String m6618c(C1941j jVar) {
        return C1992h.m7847a((String) jVar.mo8549a(C1840b.f5765c), "1.0/mediate_debug", jVar);
    }

    /* renamed from: d */
    public static String m6619d(C1941j jVar) {
        return C1992h.m7847a((String) jVar.mo8549a(C1840b.f5766d), "1.0/mediate_debug", jVar);
    }
}
