package com.tapjoy.internal;

import java.io.InputStream;
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.Map;
import p118io.fabric.sdk.android.p200m.p202b.C6078a;

/* renamed from: com.tapjoy.internal.bz */
public abstract class C3130bz extends C3131ca {
    /* renamed from: a */
    public abstract Object mo18504a(C3126bn bnVar);

    /* renamed from: a */
    public final Map mo18506a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(C6078a.HEADER_ACCEPT, C6078a.ACCEPT_JSON_VALUE);
        return linkedHashMap;
    }

    /* renamed from: a */
    public final Object mo18505a(URI uri, InputStream inputStream) {
        C3126bn a = C3126bn.m10229a(inputStream);
        a.mo18476a("BASE_URI", uri);
        int i = 0;
        try {
            a.mo18492h();
            Object obj = null;
            String str = null;
            while (a.mo18494j()) {
                String l = a.mo18496l();
                if ("status".equals(l)) {
                    i = a.mo18502r();
                } else if ("message".equals(l)) {
                    str = a.mo18497m();
                } else if ("data".equals(l)) {
                    obj = mo18504a(a);
                } else {
                    a.mo18503s();
                }
            }
            a.mo18493i();
            if (i == 200) {
                return obj;
            }
            throw new C4932cb(i, str);
        } finally {
            a.close();
        }
    }
}
