package com.applovin.impl.mediation.p037a.p038a;

import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.utils.C1986c;
import com.applovin.impl.sdk.utils.C1992h;
import com.applovin.impl.sdk.utils.C1993i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.a.a.e */
public class C1653e {

    /* renamed from: a */
    private final boolean f5179a;

    /* renamed from: b */
    private final boolean f5180b;

    /* renamed from: c */
    private final boolean f5181c;

    /* renamed from: d */
    private final String f5182d;

    public C1653e(JSONObject jSONObject, C1941j jVar) {
        this.f5179a = C1986c.m7820a(jVar.mo8527E()).mo8770a();
        JSONObject b = C1993i.m7901b(jSONObject, "cleartext_traffic", (JSONObject) null, jVar);
        boolean z = false;
        if (b != null) {
            this.f5180b = true;
            this.f5182d = C1993i.m7896b(b, "description", "", jVar);
            if (C1992h.m7851a()) {
                this.f5181c = true;
                return;
            }
            List a = C1993i.m7876a(b, "domains", (List) new ArrayList(), jVar);
            if (a.size() > 0) {
                Iterator it = a.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!C1992h.m7854a((String) it.next())) {
                            break;
                        }
                    } else {
                        z = true;
                        break;
                    }
                }
            }
            this.f5181c = z;
            return;
        }
        this.f5180b = false;
        this.f5182d = "";
        this.f5181c = C1992h.m7851a();
    }

    /* renamed from: a */
    public boolean mo7668a() {
        return this.f5180b;
    }

    /* renamed from: b */
    public boolean mo7669b() {
        return this.f5181c;
    }

    /* renamed from: c */
    public String mo7670c() {
        return this.f5179a ? this.f5182d : "You must include an entry in your AndroidManifest.xml to point to your network_security_config.xml.\n\nFor more information, visit: https://developer.android.com/training/articles/security-config";
    }
}
