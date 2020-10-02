package com.applovin.impl.mediation.p037a.p038a;

import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.utils.C1993i;
import com.applovin.impl.sdk.utils.C2029r;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.a.a.a */
public class C1647a {

    /* renamed from: a */
    private final String f5138a;

    /* renamed from: b */
    private final String f5139b;

    /* renamed from: c */
    private final boolean f5140c;

    C1647a(JSONObject jSONObject, C1941j jVar) {
        boolean z;
        this.f5138a = C1993i.m7896b(jSONObject, "name", "", jVar);
        this.f5139b = C1993i.m7896b(jSONObject, "description", "", jVar);
        List a = C1993i.m7876a(jSONObject, "existence_classes", (List) null, jVar);
        if (a != null) {
            z = false;
            Iterator it = a.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (C2029r.m8038e((String) it.next())) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        } else {
            z = C2029r.m8038e(C1993i.m7896b(jSONObject, "existence_class", "", jVar));
        }
        this.f5140c = z;
    }

    /* renamed from: a */
    public String mo7635a() {
        return this.f5138a;
    }

    /* renamed from: b */
    public String mo7636b() {
        return this.f5139b;
    }

    /* renamed from: c */
    public boolean mo7637c() {
        return this.f5140c;
    }
}
