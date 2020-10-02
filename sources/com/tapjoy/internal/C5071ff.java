package com.tapjoy.internal;

import com.tapjoy.internal.C5003eh;
import java.util.List;

/* renamed from: com.tapjoy.internal.ff */
public final class C5071ff extends C5003eh {

    /* renamed from: c */
    public static final C5006ej f13840c = new C5073b();

    /* renamed from: d */
    public final List f13841d;

    /* renamed from: com.tapjoy.internal.ff$a */
    public static final class C5072a extends C5003eh.C5004a {

        /* renamed from: c */
        public List f13842c = C5026eo.m16985a();

        /* renamed from: b */
        public final C5071ff mo31228b() {
            return new C5071ff(this.f13842c, super.mo31101a());
        }
    }

    public C5071ff(List list) {
        this(list, C5212iu.f14313b);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C5071ff)) {
            return false;
        }
        C5071ff ffVar = (C5071ff) obj;
        return mo31097a().equals(ffVar.mo31097a()) && this.f13841d.equals(ffVar.f13841d);
    }

    public final int hashCode() {
        int i = this.f13578b;
        if (i != 0) {
            return i;
        }
        int hashCode = (mo31097a().hashCode() * 37) + this.f13841d.hashCode();
        this.f13578b = hashCode;
        return hashCode;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f13841d.isEmpty()) {
            sb.append(", pushes=");
            sb.append(this.f13841d);
        }
        StringBuilder replace = sb.replace(0, 2, "PushList{");
        replace.append('}');
        return replace.toString();
    }

    public C5071ff(List list, C5212iu iuVar) {
        super(f13840c, iuVar);
        this.f13841d = C5026eo.m16986a("pushes", list);
    }

    /* renamed from: com.tapjoy.internal.ff$b */
    static final class C5073b extends C5006ej {
        C5073b() {
            super(C5001eg.LENGTH_DELIMITED, C5071ff.class);
        }

        /* renamed from: a */
        public final /* synthetic */ int mo31092a(Object obj) {
            C5071ff ffVar = (C5071ff) obj;
            return C5068fe.f13831c.mo31103a().mo31102a(1, (Object) ffVar.f13841d) + ffVar.mo31097a().mo31425c();
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ void mo31095a(C5023el elVar, Object obj) {
            C5071ff ffVar = (C5071ff) obj;
            C5068fe.f13831c.mo31103a().mo31106a(elVar, 1, ffVar.f13841d);
            elVar.mo31118a(ffVar.mo31097a());
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo31094a(C5022ek ekVar) {
            C5072a aVar = new C5072a();
            long a = ekVar.mo31109a();
            while (true) {
                int b = ekVar.mo31111b();
                if (b == -1) {
                    ekVar.mo31110a(a);
                    return aVar.mo31228b();
                } else if (b != 1) {
                    C5001eg c = ekVar.mo31112c();
                    aVar.mo31099a(b, c, c.mo31096a().mo31094a(ekVar));
                } else {
                    aVar.f13842c.add(C5068fe.f13831c.mo31094a(ekVar));
                }
            }
        }
    }
}
