package com.tapjoy.internal;

import com.tapjoy.TapjoyConstants;
import java.util.Map;
import javax.annotation.Nullable;
import p118io.fabric.sdk.android.p200m.p202b.C6078a;

/* renamed from: com.tapjoy.internal.ii */
public abstract class C3164ii extends C3130bz {
    /* access modifiers changed from: protected */
    @Nullable
    /* renamed from: a */
    public Object mo18504a(C3126bn bnVar) {
        bnVar.mo18503s();
        return null;
    }

    /* renamed from: b */
    public final String mo18508b() {
        return "POST";
    }

    /* renamed from: d */
    public final String mo18510d() {
        return C6078a.ACCEPT_JSON_VALUE;
    }

    /* renamed from: e */
    public Map mo18511e() {
        Map e = super.mo18511e();
        C3145gz a = C3145gz.m10321a();
        e.put("sdk_ver", a.f8769m + "/Android");
        e.put(TapjoyConstants.TJC_API_KEY, a.f8768l);
        if (C5139gw.f14055a) {
            e.put("debug", true);
        }
        return e;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public Object mo18512f() {
        try {
            return super.mo18512f();
        } catch (Exception e) {
            throw e;
        }
    }
}
