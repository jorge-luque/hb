package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.network.C1960b;
import com.applovin.impl.sdk.p050b.C1841c;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.network.g */
public class C1971g<T> extends C1960b {

    /* renamed from: a */
    private String f6605a;

    /* renamed from: com.applovin.impl.sdk.network.g$a */
    public static class C1972a<T> extends C1960b.C1961a<T> {
        /* access modifiers changed from: private */

        /* renamed from: n */
        public String f6606n;

        public C1972a(C1941j jVar) {
            super(jVar);
            this.f6566h = false;
            this.f6567i = ((Integer) jVar.mo8549a(C1841c.f5997dn)).intValue();
            this.f6568j = ((Integer) jVar.mo8549a(C1841c.f5996dm)).intValue();
            this.f6569k = ((Integer) jVar.mo8549a(C1841c.f5999dp)).intValue();
        }

        /* renamed from: b */
        public C1972a mo8662a(T t) {
            this.f6565g = t;
            return this;
        }

        /* renamed from: b */
        public C1972a mo8665a(JSONObject jSONObject) {
            this.f6564f = jSONObject;
            return this;
        }

        /* renamed from: b */
        public C1971g<T> mo8667a() {
            return new C1971g<>(this);
        }

        /* renamed from: c */
        public C1972a mo8664a(Map<String, String> map) {
            this.f6562d = map;
            return this;
        }

        /* renamed from: c */
        public C1972a mo8666a(boolean z) {
            this.f6570l = z;
            return this;
        }

        /* renamed from: d */
        public C1972a mo8661a(int i) {
            this.f6567i = i;
            return this;
        }

        /* renamed from: d */
        public C1972a mo8663a(String str) {
            this.f6560b = str;
            return this;
        }

        /* renamed from: d */
        public C1972a mo8670b(Map<String, String> map) {
            this.f6563e = map;
            return this;
        }

        /* renamed from: e */
        public C1972a mo8668b(int i) {
            this.f6568j = i;
            return this;
        }

        /* renamed from: e */
        public C1972a mo8673c(String str) {
            this.f6561c = str;
            return this;
        }

        /* renamed from: f */
        public C1972a mo8672c(int i) {
            this.f6569k = i;
            return this;
        }

        /* renamed from: f */
        public C1972a mo8669b(String str) {
            this.f6559a = str;
            return this;
        }

        /* renamed from: g */
        public C1972a mo8720g(String str) {
            this.f6606n = str;
            return this;
        }
    }

    protected C1971g(C1972a aVar) {
        super(aVar);
        this.f6605a = aVar.f6606n;
    }

    /* renamed from: b */
    public static C1972a m7686b(C1941j jVar) {
        return new C1972a(jVar);
    }

    /* renamed from: o */
    public boolean mo8706o() {
        return this.f6605a != null;
    }

    /* renamed from: p */
    public String mo8707p() {
        return this.f6605a;
    }
}
