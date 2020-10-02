package com.applovin.impl.mediation;

import android.os.Bundle;

/* renamed from: com.applovin.impl.mediation.f */
public class C1733f {

    /* renamed from: a */
    private final Bundle f5374a;

    /* renamed from: com.applovin.impl.mediation.f$a */
    public static class C1735a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final Bundle f5375a;

        public C1735a() {
            this((C1733f) null);
        }

        public C1735a(C1733f fVar) {
            this.f5375a = new Bundle();
            if (fVar != null) {
                for (String str : fVar.mo7879a().keySet()) {
                    mo7882a(str, fVar.mo7879a().getString(str));
                }
            }
        }

        /* renamed from: a */
        public C1735a mo7881a(String str) {
            if (str != null) {
                this.f5375a.remove(str);
                return this;
            }
            throw new IllegalArgumentException("No key specified.");
        }

        /* renamed from: a */
        public C1735a mo7882a(String str, String str2) {
            if (str != null) {
                this.f5375a.putString(str, str2);
                return this;
            }
            throw new IllegalArgumentException("No key specified");
        }

        /* renamed from: a */
        public C1733f mo7883a() {
            return new C1733f(this);
        }
    }

    private C1733f(C1735a aVar) {
        this.f5374a = new Bundle(aVar.f5375a);
    }

    /* renamed from: a */
    public Bundle mo7879a() {
        return this.f5374a;
    }

    public String toString() {
        return "MediatedRequestParameters{extraParameters=" + this.f5374a + '}';
    }
}
