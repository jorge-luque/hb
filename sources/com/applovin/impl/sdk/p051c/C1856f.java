package com.applovin.impl.sdk.p051c;

import android.text.TextUtils;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.p050b.C1843e;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.c.f */
public class C1856f {

    /* renamed from: a */
    private final List<C1858a> f6178a;

    /* renamed from: b */
    private final Object f6179b = new Object();

    /* renamed from: c */
    private final C1941j f6180c;

    /* renamed from: d */
    private final C1977q f6181d;

    /* renamed from: com.applovin.impl.sdk.c.f$a */
    private static class C1858a {

        /* renamed from: a */
        private final Long f6182a;

        /* renamed from: b */
        private final String f6183b;

        /* renamed from: c */
        private final String f6184c;

        /* renamed from: d */
        private final String f6185d;

        private C1858a(String str, Throwable th) {
            this.f6183b = str;
            this.f6182a = Long.valueOf(System.currentTimeMillis());
            String str2 = null;
            this.f6184c = th != null ? th.getClass().getName() : null;
            this.f6185d = th != null ? th.getMessage() : str2;
        }

        private C1858a(JSONObject jSONObject) throws JSONException {
            this.f6183b = jSONObject.getString("ms");
            this.f6182a = Long.valueOf(jSONObject.getLong("ts"));
            JSONObject optJSONObject = jSONObject.optJSONObject("ex");
            String str = null;
            this.f6184c = optJSONObject != null ? optJSONObject.getString("nm") : null;
            this.f6185d = optJSONObject != null ? optJSONObject.getString("rn") : str;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public JSONObject m7152a() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ms", this.f6183b);
            jSONObject.put("ts", this.f6182a);
            if (!TextUtils.isEmpty(this.f6184c)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("nm", this.f6184c);
                if (!TextUtils.isEmpty(this.f6185d)) {
                    jSONObject2.put("rn", this.f6185d);
                }
                jSONObject.put("ex", jSONObject2);
            }
            return jSONObject;
        }

        public String toString() {
            return "ErrorLog{timestampMillis=" + this.f6182a + ",message='" + this.f6183b + '\'' + ",throwableName='" + this.f6184c + '\'' + ",throwableReason='" + this.f6185d + '\'' + '}';
        }
    }

    public C1856f(C1941j jVar) {
        this.f6180c = jVar;
        this.f6181d = jVar.mo8602v();
        this.f6178a = new ArrayList();
    }

    /* renamed from: d */
    private void m7147d() {
        JSONArray jSONArray = new JSONArray();
        synchronized (this.f6179b) {
            for (C1858a next : this.f6178a) {
                try {
                    jSONArray.put(next.m7152a());
                } catch (JSONException e) {
                    this.f6181d.mo8739a("ErrorManager", false, "Failed to convert error log into json.", e);
                    this.f6178a.remove(next);
                }
            }
        }
        this.f6180c.mo8556a(C1843e.f6101o, jSONArray.toString());
    }

    /* renamed from: a */
    public JSONArray mo8381a() {
        JSONArray jSONArray;
        synchronized (this.f6179b) {
            jSONArray = new JSONArray();
            for (C1858a a : this.f6178a) {
                try {
                    jSONArray.put(a.m7152a());
                } catch (JSONException e) {
                    this.f6181d.mo8739a("ErrorManager", false, "Failed to convert error log into json.", e);
                }
            }
        }
        return jSONArray;
    }

    /* renamed from: a */
    public void mo8382a(String str, Throwable th) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.f6179b) {
                if (this.f6178a.size() < ((Integer) this.f6180c.mo8549a(C1841c.f6060ey)).intValue()) {
                    this.f6178a.add(new C1858a(str, th));
                    m7147d();
                }
            }
        }
    }

    /* renamed from: b */
    public void mo8383b() {
        String str = (String) this.f6180c.mo8574b(C1843e.f6101o, null);
        if (str != null) {
            synchronized (this.f6179b) {
                try {
                    this.f6178a.clear();
                    JSONArray jSONArray = new JSONArray(str);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            this.f6178a.add(new C1858a(jSONArray.getJSONObject(i)));
                        } catch (JSONException e) {
                            this.f6181d.mo8739a("ErrorManager", false, "Failed to convert error json into a log.", e);
                        }
                    }
                } catch (JSONException e2) {
                    this.f6181d.mo8743b("ErrorManager", "Unable to convert String to json.", e2);
                }
            }
        }
    }

    /* renamed from: c */
    public void mo8384c() {
        synchronized (this.f6179b) {
            this.f6178a.clear();
            this.f6180c.mo8578b(C1843e.f6101o);
        }
    }
}
