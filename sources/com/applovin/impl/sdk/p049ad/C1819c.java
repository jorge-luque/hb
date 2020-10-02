package com.applovin.impl.sdk.p049ad;

import android.text.TextUtils;
import android.util.Base64;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.utils.C2025o;
import com.loopj.android.http.C4250c;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.ad.c */
public class C1819c {

    /* renamed from: a */
    private final C1941j f5659a;

    /* renamed from: b */
    private final String f5660b;

    /* renamed from: com.applovin.impl.sdk.ad.c$a */
    public enum C1820a {
        UNSPECIFIED("UNSPECIFIED"),
        REGULAR("REGULAR"),
        AD_RESPONSE_JSON("AD_RESPONSE_JSON");
        

        /* renamed from: d */
        private final String f5665d;

        private C1820a(String str) {
            this.f5665d = str;
        }

        public String toString() {
            return this.f5665d;
        }
    }

    public C1819c(String str, C1941j jVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Identifier is empty");
        } else if (jVar != null) {
            this.f5660b = str;
            this.f5659a = jVar;
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    /* renamed from: a */
    private String m6852a(C1841c<String> cVar) {
        for (String next : this.f5659a.mo8576b(cVar)) {
            if (this.f5660b.startsWith(next)) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: a */
    public String mo8166a() {
        return this.f5660b;
    }

    /* renamed from: b */
    public C1820a mo8167b() {
        return m6852a(C1841c.f5817aQ) != null ? C1820a.REGULAR : m6852a(C1841c.f5818aR) != null ? C1820a.AD_RESPONSE_JSON : C1820a.UNSPECIFIED;
    }

    /* renamed from: c */
    public String mo8168c() {
        String a = m6852a(C1841c.f5817aQ);
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        String a2 = m6852a(C1841c.f5818aR);
        if (!TextUtils.isEmpty(a2)) {
            return a2;
        }
        return null;
    }

    /* renamed from: d */
    public JSONObject mo8169d() {
        if (mo8167b() != C1820a.AD_RESPONSE_JSON) {
            return null;
        }
        try {
            try {
                JSONObject jSONObject = new JSONObject(new String(Base64.decode(this.f5660b.substring(mo8168c().length()), 0), C4250c.DEFAULT_CHARSET));
                C1977q v = this.f5659a.mo8602v();
                v.mo8742b("AdToken", "Decoded token into ad response: " + jSONObject);
                return jSONObject;
            } catch (JSONException e) {
                C1977q v2 = this.f5659a.mo8602v();
                v2.mo8743b("AdToken", "Unable to decode token '" + this.f5660b + "' into JSON", e);
                return null;
            }
        } catch (UnsupportedEncodingException e2) {
            C1977q v3 = this.f5659a.mo8602v();
            v3.mo8743b("AdToken", "Unable to process ad response from token '" + this.f5660b + "'", e2);
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1819c)) {
            return false;
        }
        String str = this.f5660b;
        String str2 = ((C1819c) obj).f5660b;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        String str = this.f5660b;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        String a = C2025o.m7955a(32, this.f5660b);
        return "AdToken{id=" + a + ", type=" + mo8167b() + '}';
    }
}
