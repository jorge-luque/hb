package com.tapjoy.internal;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collection;
import java.util.Map;

/* renamed from: com.tapjoy.internal.bh */
public final class C4910bh implements C4916bl {

    /* renamed from: a */
    private final StringWriter f13375a;

    /* renamed from: b */
    private final C4924bt f13376b;

    public C4910bh() {
        StringWriter stringWriter = new StringWriter();
        this.f13375a = stringWriter;
        this.f13376b = new C4924bt(stringWriter);
    }

    /* renamed from: a */
    public final void mo30993a(Writer writer) {
        try {
            this.f13376b.f13418a.flush();
            writer.write(this.f13375a.toString());
        } catch (IOException e) {
            throw C3167jr.m10437a(e);
        }
    }

    /* renamed from: b */
    public final C4910bh mo30994b() {
        try {
            this.f13376b.mo31011b();
            return this;
        } catch (IOException e) {
            throw C3167jr.m10437a(e);
        }
    }

    /* renamed from: c */
    public final C4910bh mo30996c() {
        try {
            this.f13376b.mo31013c();
            return this;
        } catch (IOException e) {
            throw C3167jr.m10437a(e);
        }
    }

    /* renamed from: d */
    public final C4910bh mo30997d() {
        try {
            this.f13376b.mo31015d();
            return this;
        } catch (IOException e) {
            throw C3167jr.m10437a(e);
        }
    }

    public final String toString() {
        try {
            this.f13376b.f13418a.flush();
            return this.f13375a.toString();
        } catch (IOException e) {
            throw C3167jr.m10437a(e);
        }
    }

    /* renamed from: b */
    public final C4910bh mo30995b(String str) {
        try {
            this.f13376b.mo31012b(str);
            return this;
        } catch (IOException e) {
            throw C3167jr.m10437a(e);
        }
    }

    /* renamed from: b */
    private C4910bh m16697b(Object obj) {
        try {
            this.f13376b.mo31007a(obj);
            return this;
        } catch (IOException e) {
            throw C3167jr.m10437a(e);
        }
    }

    /* renamed from: a */
    public final C4910bh mo30986a() {
        try {
            this.f13376b.mo31003a();
            return this;
        } catch (IOException e) {
            throw C3167jr.m10437a(e);
        }
    }

    /* renamed from: a */
    public final C4910bh mo30990a(String str) {
        try {
            this.f13376b.mo31008a(str);
            return this;
        } catch (IOException e) {
            throw C3167jr.m10437a(e);
        }
    }

    /* renamed from: a */
    public final C4910bh mo30988a(C4916bl blVar) {
        try {
            this.f13376b.mo31005a(blVar);
            return this;
        } catch (IOException e) {
            throw C3167jr.m10437a(e);
        }
    }

    /* renamed from: a */
    public final C4910bh mo30987a(long j) {
        try {
            this.f13376b.mo31004a(j);
            return this;
        } catch (IOException e) {
            throw C3167jr.m10437a(e);
        }
    }

    /* renamed from: a */
    public final C4910bh mo30989a(Number number) {
        try {
            this.f13376b.mo31006a(number);
            return this;
        } catch (IOException e) {
            throw C3167jr.m10437a(e);
        }
    }

    /* renamed from: a */
    public final C4910bh mo30991a(Collection collection) {
        try {
            this.f13376b.mo31009a(collection);
            return this;
        } catch (IOException e) {
            throw C3167jr.m10437a(e);
        }
    }

    /* renamed from: a */
    public final C4910bh mo30992a(Map map) {
        try {
            this.f13376b.mo31010a(map);
            return this;
        } catch (IOException e) {
            throw C3167jr.m10437a(e);
        }
    }

    /* renamed from: a */
    public static String m16696a(Object obj) {
        return new C4910bh().m16697b(obj).toString();
    }
}
