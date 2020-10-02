package com.tapjoy.internal;

import com.tapjoy.internal.C5003eh;
import java.util.List;

/* renamed from: com.tapjoy.internal.ew */
public final class C5044ew extends C5003eh {

    /* renamed from: c */
    public static final C5006ej f13718c = new C5046b();

    /* renamed from: d */
    public final List f13719d;

    /* renamed from: com.tapjoy.internal.ew$a */
    public static final class C5045a extends C5003eh.C5004a {

        /* renamed from: c */
        public List f13720c = C5026eo.m16985a();

        /* renamed from: b */
        public final C5044ew mo31203b() {
            return new C5044ew(this.f13720c, super.mo31101a());
        }
    }

    public C5044ew(List list, C5212iu iuVar) {
        super(f13718c, iuVar);
        this.f13719d = C5026eo.m16986a("events", list);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C5044ew)) {
            return false;
        }
        C5044ew ewVar = (C5044ew) obj;
        return mo31097a().equals(ewVar.mo31097a()) && this.f13719d.equals(ewVar.f13719d);
    }

    public final int hashCode() {
        int i = this.f13578b;
        if (i != 0) {
            return i;
        }
        int hashCode = (mo31097a().hashCode() * 37) + this.f13719d.hashCode();
        this.f13578b = hashCode;
        return hashCode;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f13719d.isEmpty()) {
            sb.append(", events=");
            sb.append(this.f13719d);
        }
        StringBuilder replace = sb.replace(0, 2, "EventBatch{");
        replace.append('}');
        return replace.toString();
    }

    /* renamed from: com.tapjoy.internal.ew$b */
    static final class C5046b extends C5006ej {
        C5046b() {
            super(C5001eg.LENGTH_DELIMITED, C5044ew.class);
        }

        /* renamed from: a */
        public final /* synthetic */ int mo31092a(Object obj) {
            C5044ew ewVar = (C5044ew) obj;
            return C5041ev.f13657c.mo31103a().mo31102a(1, (Object) ewVar.f13719d) + ewVar.mo31097a().mo31425c();
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ void mo31095a(C5023el elVar, Object obj) {
            C5044ew ewVar = (C5044ew) obj;
            C5041ev.f13657c.mo31103a().mo31106a(elVar, 1, ewVar.f13719d);
            elVar.mo31118a(ewVar.mo31097a());
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo31094a(C5022ek ekVar) {
            C5045a aVar = new C5045a();
            long a = ekVar.mo31109a();
            while (true) {
                int b = ekVar.mo31111b();
                if (b == -1) {
                    ekVar.mo31110a(a);
                    return aVar.mo31203b();
                } else if (b != 1) {
                    C5001eg c = ekVar.mo31112c();
                    aVar.mo31099a(b, c, c.mo31096a().mo31094a(ekVar));
                } else {
                    aVar.f13720c.add(C5041ev.f13657c.mo31094a(ekVar));
                }
            }
        }
    }
}
