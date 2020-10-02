package com.applovin.impl.mediation.p037a.p040c.p043b.p044a;

import android.text.SpannedString;
import com.applovin.impl.mediation.p037a.p038a.C1649c;

/* renamed from: com.applovin.impl.mediation.a.c.b.a.a */
public class C1669a extends C1649c {

    /* renamed from: d */
    final String f5212d;

    /* renamed from: e */
    final int f5213e;

    /* renamed from: f */
    final int f5214f;

    /* renamed from: g */
    final boolean f5215g;

    /* renamed from: com.applovin.impl.mediation.a.c.b.a.a$a */
    public static class C1671a {

        /* renamed from: a */
        SpannedString f5216a;

        /* renamed from: b */
        SpannedString f5217b;

        /* renamed from: c */
        String f5218c;

        /* renamed from: d */
        C1649c.C1650a f5219d = C1649c.C1650a.DETAIL;

        /* renamed from: e */
        int f5220e;

        /* renamed from: f */
        int f5221f;

        /* renamed from: g */
        boolean f5222g = false;

        /* renamed from: a */
        public C1671a mo7707a(int i) {
            this.f5220e = i;
            return this;
        }

        /* renamed from: a */
        public C1671a mo7708a(SpannedString spannedString) {
            this.f5217b = spannedString;
            return this;
        }

        /* renamed from: a */
        public C1671a mo7709a(C1649c.C1650a aVar) {
            this.f5219d = aVar;
            return this;
        }

        /* renamed from: a */
        public C1671a mo7710a(String str) {
            this.f5216a = new SpannedString(str);
            return this;
        }

        /* renamed from: a */
        public C1671a mo7711a(boolean z) {
            this.f5222g = z;
            return this;
        }

        /* renamed from: a */
        public C1669a mo7712a() {
            return new C1669a(this);
        }

        /* renamed from: b */
        public C1671a mo7713b(int i) {
            this.f5221f = i;
            return this;
        }

        /* renamed from: b */
        public C1671a mo7714b(String str) {
            return mo7708a(new SpannedString(str));
        }

        /* renamed from: c */
        public C1671a mo7715c(String str) {
            this.f5218c = str;
            return this;
        }
    }

    private C1669a(C1671a aVar) {
        super(aVar.f5219d);
        this.f5147b = aVar.f5216a;
        this.f5148c = aVar.f5217b;
        this.f5212d = aVar.f5218c;
        this.f5213e = aVar.f5220e;
        this.f5214f = aVar.f5221f;
        this.f5215g = aVar.f5222g;
    }

    /* renamed from: l */
    public static C1671a m6360l() {
        return new C1671a();
    }

    /* renamed from: b */
    public boolean mo7640b() {
        return this.f5215g;
    }

    /* renamed from: i */
    public int mo7647i() {
        return this.f5213e;
    }

    /* renamed from: j */
    public int mo7648j() {
        return this.f5214f;
    }

    /* renamed from: k */
    public String mo7705k() {
        return this.f5212d;
    }

    public String toString() {
        return "NetworkDetailListItemViewModel{text=" + this.f5147b + ", detailText=" + this.f5147b + "}";
    }
}
