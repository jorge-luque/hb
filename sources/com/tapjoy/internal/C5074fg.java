package com.tapjoy.internal;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.tapjoy.internal.C5003eh;
import java.util.List;

/* renamed from: com.tapjoy.internal.fg */
public final class C5074fg extends C5003eh {

    /* renamed from: c */
    public static final C5006ej f13843c = new C5076b();

    /* renamed from: d */
    public final List f13844d;

    /* renamed from: com.tapjoy.internal.fg$a */
    public static final class C5075a extends C5003eh.C5004a {

        /* renamed from: c */
        public List f13845c = C5026eo.m16985a();

        /* renamed from: b */
        public final C5074fg mo31231b() {
            return new C5074fg(this.f13845c, super.mo31101a());
        }
    }

    public C5074fg(List list) {
        this(list, C5212iu.f14313b);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C5074fg)) {
            return false;
        }
        C5074fg fgVar = (C5074fg) obj;
        return mo31097a().equals(fgVar.mo31097a()) && this.f13844d.equals(fgVar.f13844d);
    }

    public final int hashCode() {
        int i = this.f13578b;
        if (i != 0) {
            return i;
        }
        int hashCode = (mo31097a().hashCode() * 37) + this.f13844d.hashCode();
        this.f13578b = hashCode;
        return hashCode;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f13844d.isEmpty()) {
            sb.append(", elements=");
            sb.append(this.f13844d);
        }
        StringBuilder replace = sb.replace(0, 2, "StringList{");
        replace.append('}');
        return replace.toString();
    }

    public C5074fg(List list, C5212iu iuVar) {
        super(f13843c, iuVar);
        this.f13844d = C5026eo.m16986a(MessengerShareContentUtility.ELEMENTS, list);
    }

    /* renamed from: com.tapjoy.internal.fg$b */
    static final class C5076b extends C5006ej {
        C5076b() {
            super(C5001eg.LENGTH_DELIMITED, C5074fg.class);
        }

        /* renamed from: a */
        public final /* synthetic */ int mo31092a(Object obj) {
            C5074fg fgVar = (C5074fg) obj;
            return C5006ej.f13596p.mo31103a().mo31102a(1, (Object) fgVar.f13844d) + fgVar.mo31097a().mo31425c();
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ void mo31095a(C5023el elVar, Object obj) {
            C5074fg fgVar = (C5074fg) obj;
            C5006ej.f13596p.mo31103a().mo31106a(elVar, 1, fgVar.f13844d);
            elVar.mo31118a(fgVar.mo31097a());
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo31094a(C5022ek ekVar) {
            C5075a aVar = new C5075a();
            long a = ekVar.mo31109a();
            while (true) {
                int b = ekVar.mo31111b();
                if (b == -1) {
                    ekVar.mo31110a(a);
                    return aVar.mo31231b();
                } else if (b != 1) {
                    C5001eg c = ekVar.mo31112c();
                    aVar.mo31099a(b, c, c.mo31096a().mo31094a(ekVar));
                } else {
                    aVar.f13845c.add(C5006ej.f13596p.mo31094a(ekVar));
                }
            }
        }
    }
}
