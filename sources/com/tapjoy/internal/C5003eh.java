package com.tapjoy.internal;

import java.io.IOException;
import java.io.Serializable;

/* renamed from: com.tapjoy.internal.eh */
public abstract class C5003eh implements Serializable {

    /* renamed from: a */
    transient int f13577a = 0;

    /* renamed from: b */
    protected transient int f13578b = 0;

    /* renamed from: c */
    private final transient C5006ej f13579c;

    /* renamed from: d */
    private final transient C5212iu f13580d;

    protected C5003eh(C5006ej ejVar, C5212iu iuVar) {
        if (ejVar == null) {
            throw new NullPointerException("adapter == null");
        } else if (iuVar != null) {
            this.f13579c = ejVar;
            this.f13580d = iuVar;
        } else {
            throw new NullPointerException("unknownFields == null");
        }
    }

    /* renamed from: a */
    public final C5212iu mo31097a() {
        C5212iu iuVar = this.f13580d;
        if (iuVar != null) {
            return iuVar;
        }
        return C5212iu.f14313b;
    }

    public String toString() {
        return C5006ej.m16906c(this);
    }

    /* renamed from: com.tapjoy.internal.eh$a */
    public static abstract class C5004a {

        /* renamed from: a */
        C5209ir f13581a;

        /* renamed from: b */
        C5023el f13582b;

        protected C5004a() {
        }

        /* renamed from: a */
        public final C5004a mo31100a(C5212iu iuVar) {
            if (iuVar.mo31425c() > 0) {
                if (this.f13582b == null) {
                    C5209ir irVar = new C5209ir();
                    this.f13581a = irVar;
                    this.f13582b = new C5023el(irVar);
                }
                try {
                    this.f13582b.mo31118a(iuVar);
                } catch (IOException unused) {
                    throw new AssertionError();
                }
            }
            return this;
        }

        /* renamed from: a */
        public final C5004a mo31099a(int i, C5001eg egVar, Object obj) {
            if (this.f13582b == null) {
                C5209ir irVar = new C5209ir();
                this.f13581a = irVar;
                this.f13582b = new C5023el(irVar);
            }
            try {
                egVar.mo31096a().mo31106a(this.f13582b, i, obj);
                return this;
            } catch (IOException unused) {
                throw new AssertionError();
            }
        }

        /* renamed from: a */
        public final C5212iu mo31101a() {
            C5209ir irVar = this.f13581a;
            if (irVar != null) {
                return new C5212iu(irVar.clone().mo31415g());
            }
            return C5212iu.f14313b;
        }
    }
}
