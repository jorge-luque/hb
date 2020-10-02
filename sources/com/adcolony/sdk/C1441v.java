package com.adcolony.sdk;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.adcolony.sdk.v */
class C1441v {

    /* renamed from: e */
    static final SimpleDateFormat f4521e = new SimpleDateFormat("yyyyMMdd'T'HHmmss.SSSZ", Locale.US);

    /* renamed from: f */
    static final String f4522f = "message";

    /* renamed from: g */
    static final String f4523g = "timestamp";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Date f4524a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f4525b;

    /* renamed from: c */
    protected String f4526c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C1436r f4527d;

    /* renamed from: com.adcolony.sdk.v$a */
    static class C1442a {

        /* renamed from: a */
        protected C1441v f4528a = new C1441v();

        C1442a() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C1442a mo6812a(int i) {
            int unused = this.f4528a.f4525b = i;
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C1442a mo6813a(C1436r rVar) {
            C1436r unused = this.f4528a.f4527d = rVar;
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C1442a mo6814a(String str) {
            this.f4528a.f4526c = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C1442a mo6776a(Date date) {
            Date unused = this.f4528a.f4524a = date;
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C1441v mo6815a() {
            if (this.f4528a.f4524a == null) {
                Date unused = this.f4528a.f4524a = new Date(System.currentTimeMillis());
            }
            return this.f4528a;
        }
    }

    C1441v() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo6807b() {
        return this.f4525b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo6808c() {
        int i = this.f4525b;
        if (i == -1) {
            return "Fatal";
        }
        if (i == 0) {
            return "Error";
        }
        if (i == 1) {
            return "Warn";
        }
        if (i != 2) {
            return i != 3 ? "UNKNOWN LOG LEVEL" : "Debug";
        }
        return "Info";
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public String mo6809d() {
        return this.f4526c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public String mo6810e() {
        return f4521e.format(this.f4524a);
    }

    public String toString() {
        return mo6810e() + " " + mo6808c() + "/" + mo6804a().mo6792a() + ": " + mo6809d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6806a(C1436r rVar) {
        this.f4527d = rVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6805a(int i) {
        this.f4525b = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1436r mo6804a() {
        return this.f4527d;
    }
}
