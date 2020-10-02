package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.utils.C1993i;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.network.f */
public class C1968f {

    /* renamed from: a */
    private String f6587a;

    /* renamed from: b */
    private String f6588b;

    /* renamed from: c */
    private String f6589c;

    /* renamed from: d */
    private String f6590d;

    /* renamed from: e */
    private Map<String, String> f6591e;

    /* renamed from: f */
    private Map<String, String> f6592f;

    /* renamed from: g */
    private Map<String, Object> f6593g;

    /* renamed from: h */
    private boolean f6594h;

    /* renamed from: i */
    private String f6595i;

    /* renamed from: j */
    private int f6596j;

    /* renamed from: com.applovin.impl.sdk.network.f$a */
    public static class C1970a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public String f6597a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public String f6598b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public String f6599c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public String f6600d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public Map<String, String> f6601e;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public Map<String, String> f6602f;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public Map<String, Object> f6603g;
        /* access modifiers changed from: private */

        /* renamed from: h */
        public boolean f6604h;

        /* renamed from: a */
        public C1970a mo8697a(String str) {
            this.f6597a = str;
            return this;
        }

        /* renamed from: a */
        public C1970a mo8698a(Map<String, String> map) {
            this.f6601e = map;
            return this;
        }

        /* renamed from: a */
        public C1970a mo8699a(boolean z) {
            this.f6604h = z;
            return this;
        }

        /* renamed from: a */
        public C1968f mo8700a() {
            return new C1968f(this);
        }

        /* renamed from: b */
        public C1970a mo8701b(String str) {
            this.f6598b = str;
            return this;
        }

        /* renamed from: b */
        public C1970a mo8702b(Map<String, String> map) {
            this.f6602f = map;
            return this;
        }

        /* renamed from: c */
        public C1970a mo8703c(String str) {
            this.f6599c = str;
            return this;
        }

        /* renamed from: c */
        public C1970a mo8704c(Map<String, Object> map) {
            this.f6603g = map;
            return this;
        }

        /* renamed from: d */
        public C1970a mo8705d(String str) {
            this.f6600d = str;
            return this;
        }
    }

    private C1968f(C1970a aVar) {
        this.f6587a = UUID.randomUUID().toString();
        this.f6588b = aVar.f6598b;
        this.f6589c = aVar.f6599c;
        this.f6590d = aVar.f6600d;
        this.f6591e = aVar.f6601e;
        this.f6592f = aVar.f6602f;
        this.f6593g = aVar.f6603g;
        this.f6594h = aVar.f6604h;
        this.f6595i = aVar.f6597a;
        this.f6596j = 0;
    }

    C1968f(JSONObject jSONObject, C1941j jVar) throws Exception {
        String b = C1993i.m7896b(jSONObject, "uniqueId", UUID.randomUUID().toString(), jVar);
        String b2 = C1993i.m7896b(jSONObject, "communicatorRequestId", "", jVar);
        C1993i.m7896b(jSONObject, "httpMethod", "", jVar);
        String string = jSONObject.getString("targetUrl");
        String b3 = C1993i.m7896b(jSONObject, "backupUrl", "", jVar);
        int i = jSONObject.getInt("attemptNumber");
        Map<String, String> synchronizedMap = C1993i.m7893a(jSONObject, "parameters") ? Collections.synchronizedMap(C1993i.m7879a(jSONObject.getJSONObject("parameters"))) : Collections.emptyMap();
        Map<String, String> synchronizedMap2 = C1993i.m7893a(jSONObject, "httpHeaders") ? Collections.synchronizedMap(C1993i.m7879a(jSONObject.getJSONObject("httpHeaders"))) : Collections.emptyMap();
        Map<String, Object> synchronizedMap3 = C1993i.m7893a(jSONObject, "requestBody") ? Collections.synchronizedMap(C1993i.m7898b(jSONObject.getJSONObject("requestBody"))) : Collections.emptyMap();
        this.f6587a = b;
        this.f6595i = b2;
        this.f6589c = string;
        this.f6590d = b3;
        this.f6591e = synchronizedMap;
        this.f6592f = synchronizedMap2;
        this.f6593g = synchronizedMap3;
        this.f6594h = jSONObject.optBoolean("isEncodingEnabled", false);
        this.f6596j = i;
    }

    /* renamed from: m */
    public static C1970a m7656m() {
        return new C1970a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo8682a() {
        return this.f6588b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo8683b() {
        return this.f6589c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo8684c() {
        return this.f6590d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public Map<String, String> mo8685d() {
        return this.f6591e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public Map<String, String> mo8686e() {
        return this.f6592f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C1968f.class != obj.getClass()) {
            return false;
        }
        return this.f6587a.equals(((C1968f) obj).f6587a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public Map<String, Object> mo8688f() {
        return this.f6593g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo8689g() {
        return this.f6594h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public String mo8690h() {
        return this.f6595i;
    }

    public int hashCode() {
        return this.f6587a.hashCode();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public int mo8692i() {
        return this.f6596j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo8693j() {
        this.f6596j++;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public void mo8694k() {
        HashMap hashMap = new HashMap();
        Map<String, String> map = this.f6591e;
        if (map != null) {
            hashMap.putAll(map);
        }
        hashMap.put("postback_ts", String.valueOf(System.currentTimeMillis()));
        this.f6591e = hashMap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public JSONObject mo8695l() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("uniqueId", this.f6587a);
        jSONObject.put("communicatorRequestId", this.f6595i);
        jSONObject.put("httpMethod", this.f6588b);
        jSONObject.put("targetUrl", this.f6589c);
        jSONObject.put("backupUrl", this.f6590d);
        jSONObject.put("isEncodingEnabled", this.f6594h);
        jSONObject.put("attemptNumber", this.f6596j);
        if (this.f6591e != null) {
            jSONObject.put("parameters", new JSONObject(this.f6591e));
        }
        if (this.f6592f != null) {
            jSONObject.put("httpHeaders", new JSONObject(this.f6592f));
        }
        if (this.f6593g != null) {
            jSONObject.put("requestBody", new JSONObject(this.f6593g));
        }
        return jSONObject;
    }

    public String toString() {
        return "PostbackRequest{uniqueId='" + this.f6587a + '\'' + ", communicatorRequestId='" + this.f6595i + '\'' + ", httpMethod='" + this.f6588b + '\'' + ", targetUrl='" + this.f6589c + '\'' + ", backupUrl='" + this.f6590d + '\'' + ", attemptNumber=" + this.f6596j + ", isEncodingEnabled=" + this.f6594h + '}';
    }
}
