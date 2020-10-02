package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.p050b.C1841c;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.network.b */
public class C1960b<T> {

    /* renamed from: a */
    private String f6545a;

    /* renamed from: b */
    private String f6546b;

    /* renamed from: c */
    private Map<String, String> f6547c;

    /* renamed from: d */
    private Map<String, String> f6548d;

    /* renamed from: e */
    private final JSONObject f6549e;

    /* renamed from: f */
    private String f6550f;

    /* renamed from: g */
    private final T f6551g;

    /* renamed from: h */
    private final boolean f6552h;

    /* renamed from: i */
    private final int f6553i;

    /* renamed from: j */
    private int f6554j;

    /* renamed from: k */
    private final int f6555k;

    /* renamed from: l */
    private final int f6556l;

    /* renamed from: m */
    private final boolean f6557m;

    /* renamed from: n */
    private final boolean f6558n;

    /* renamed from: com.applovin.impl.sdk.network.b$a */
    public static class C1961a<T> {

        /* renamed from: a */
        String f6559a;

        /* renamed from: b */
        String f6560b;

        /* renamed from: c */
        String f6561c;

        /* renamed from: d */
        Map<String, String> f6562d;

        /* renamed from: e */
        Map<String, String> f6563e;

        /* renamed from: f */
        JSONObject f6564f;

        /* renamed from: g */
        T f6565g;

        /* renamed from: h */
        boolean f6566h = true;

        /* renamed from: i */
        int f6567i = 1;

        /* renamed from: j */
        int f6568j;

        /* renamed from: k */
        int f6569k;

        /* renamed from: l */
        boolean f6570l;

        /* renamed from: m */
        boolean f6571m;

        public C1961a(C1941j jVar) {
            this.f6568j = ((Integer) jVar.mo8549a(C1841c.f6000dq)).intValue();
            this.f6569k = ((Integer) jVar.mo8549a(C1841c.f5999dp)).intValue();
            this.f6570l = ((Boolean) jVar.mo8549a(C1841c.f6020eK)).booleanValue();
            this.f6562d = new HashMap();
        }

        /* renamed from: a */
        public C1961a<T> mo8661a(int i) {
            this.f6567i = i;
            return this;
        }

        /* renamed from: a */
        public C1961a<T> mo8662a(T t) {
            this.f6565g = t;
            return this;
        }

        /* renamed from: a */
        public C1961a<T> mo8663a(String str) {
            this.f6560b = str;
            return this;
        }

        /* renamed from: a */
        public C1961a<T> mo8664a(Map<String, String> map) {
            this.f6562d = map;
            return this;
        }

        /* renamed from: a */
        public C1961a<T> mo8665a(JSONObject jSONObject) {
            this.f6564f = jSONObject;
            return this;
        }

        /* renamed from: a */
        public C1961a<T> mo8666a(boolean z) {
            this.f6570l = z;
            return this;
        }

        /* renamed from: a */
        public C1960b<T> mo8667a() {
            return new C1960b<>(this);
        }

        /* renamed from: b */
        public C1961a<T> mo8668b(int i) {
            this.f6568j = i;
            return this;
        }

        /* renamed from: b */
        public C1961a<T> mo8669b(String str) {
            this.f6559a = str;
            return this;
        }

        /* renamed from: b */
        public C1961a<T> mo8670b(Map<String, String> map) {
            this.f6563e = map;
            return this;
        }

        /* renamed from: b */
        public C1961a<T> mo8671b(boolean z) {
            this.f6571m = z;
            return this;
        }

        /* renamed from: c */
        public C1961a<T> mo8672c(int i) {
            this.f6569k = i;
            return this;
        }

        /* renamed from: c */
        public C1961a<T> mo8673c(String str) {
            this.f6561c = str;
            return this;
        }
    }

    protected C1960b(C1961a<T> aVar) {
        this.f6545a = aVar.f6560b;
        this.f6546b = aVar.f6559a;
        this.f6547c = aVar.f6562d;
        this.f6548d = aVar.f6563e;
        this.f6549e = aVar.f6564f;
        this.f6550f = aVar.f6561c;
        this.f6551g = aVar.f6565g;
        this.f6552h = aVar.f6566h;
        int i = aVar.f6567i;
        this.f6553i = i;
        this.f6554j = i;
        this.f6555k = aVar.f6568j;
        this.f6556l = aVar.f6569k;
        this.f6557m = aVar.f6570l;
        this.f6558n = aVar.f6571m;
    }

    /* renamed from: a */
    public static <T> C1961a<T> m7596a(C1941j jVar) {
        return new C1961a<>(jVar);
    }

    /* renamed from: a */
    public String mo8641a() {
        return this.f6545a;
    }

    /* renamed from: a */
    public void mo8642a(int i) {
        this.f6554j = i;
    }

    /* renamed from: a */
    public void mo8643a(String str) {
        this.f6545a = str;
    }

    /* renamed from: b */
    public String mo8644b() {
        return this.f6546b;
    }

    /* renamed from: b */
    public void mo8645b(String str) {
        this.f6546b = str;
    }

    /* renamed from: c */
    public Map<String, String> mo8646c() {
        return this.f6547c;
    }

    /* renamed from: d */
    public Map<String, String> mo8647d() {
        return this.f6548d;
    }

    /* renamed from: e */
    public JSONObject mo8648e() {
        return this.f6549e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1960b)) {
            return false;
        }
        C1960b bVar = (C1960b) obj;
        String str = this.f6545a;
        if (str == null ? bVar.f6545a != null : !str.equals(bVar.f6545a)) {
            return false;
        }
        Map<String, String> map = this.f6547c;
        if (map == null ? bVar.f6547c != null : !map.equals(bVar.f6547c)) {
            return false;
        }
        Map<String, String> map2 = this.f6548d;
        if (map2 == null ? bVar.f6548d != null : !map2.equals(bVar.f6548d)) {
            return false;
        }
        String str2 = this.f6550f;
        if (str2 == null ? bVar.f6550f != null : !str2.equals(bVar.f6550f)) {
            return false;
        }
        String str3 = this.f6546b;
        if (str3 == null ? bVar.f6546b != null : !str3.equals(bVar.f6546b)) {
            return false;
        }
        JSONObject jSONObject = this.f6549e;
        if (jSONObject == null ? bVar.f6549e != null : !jSONObject.equals(bVar.f6549e)) {
            return false;
        }
        T t = this.f6551g;
        if (t == null ? bVar.f6551g == null : t.equals(bVar.f6551g)) {
            return this.f6552h == bVar.f6552h && this.f6553i == bVar.f6553i && this.f6554j == bVar.f6554j && this.f6555k == bVar.f6555k && this.f6556l == bVar.f6556l && this.f6557m == bVar.f6557m && this.f6558n == bVar.f6558n;
        }
        return false;
    }

    /* renamed from: f */
    public String mo8650f() {
        return this.f6550f;
    }

    /* renamed from: g */
    public T mo8651g() {
        return this.f6551g;
    }

    /* renamed from: h */
    public boolean mo8652h() {
        return this.f6552h;
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.f6545a;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f6550f;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f6546b;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        T t = this.f6551g;
        if (t != null) {
            i = t.hashCode();
        }
        int i2 = ((((((((((((((hashCode4 + i) * 31) + (this.f6552h ? 1 : 0)) * 31) + this.f6553i) * 31) + this.f6554j) * 31) + this.f6555k) * 31) + this.f6556l) * 31) + (this.f6557m ? 1 : 0)) * 31) + (this.f6558n ? 1 : 0);
        Map<String, String> map = this.f6547c;
        if (map != null) {
            i2 = (i2 * 31) + map.hashCode();
        }
        Map<String, String> map2 = this.f6548d;
        if (map2 != null) {
            i2 = (i2 * 31) + map2.hashCode();
        }
        JSONObject jSONObject = this.f6549e;
        if (jSONObject == null) {
            return i2;
        }
        char[] charArray = jSONObject.toString().toCharArray();
        Arrays.sort(charArray);
        return (i2 * 31) + new String(charArray).hashCode();
    }

    /* renamed from: i */
    public int mo8654i() {
        return this.f6553i - this.f6554j;
    }

    /* renamed from: j */
    public int mo8655j() {
        return this.f6554j;
    }

    /* renamed from: k */
    public int mo8656k() {
        return this.f6555k;
    }

    /* renamed from: l */
    public int mo8657l() {
        return this.f6556l;
    }

    /* renamed from: m */
    public boolean mo8658m() {
        return this.f6557m;
    }

    /* renamed from: n */
    public boolean mo8659n() {
        return this.f6558n;
    }

    public String toString() {
        return "HttpRequest {endpoint=" + this.f6545a + ", backupEndpoint=" + this.f6550f + ", httpMethod=" + this.f6546b + ", httpHeaders=" + this.f6548d + ", body=" + this.f6549e + ", emptyResponse=" + this.f6551g + ", requiresResponse=" + this.f6552h + ", initialRetryAttempts=" + this.f6553i + ", retryAttemptsLeft=" + this.f6554j + ", timeoutMillis=" + this.f6555k + ", retryDelayMillis=" + this.f6556l + ", encodingEnabled=" + this.f6557m + ", trackConnectionSpeed=" + this.f6558n + '}';
    }
}
