package com.tapjoy.internal;

import com.tapjoy.internal.C5003eh;
import com.tapjoy.internal.C5006ej;

/* renamed from: com.tapjoy.internal.ex */
public final class C5047ex extends C5003eh {

    /* renamed from: c */
    public static final C5006ej f13721c = new C5049b();

    /* renamed from: d */
    public static final C5050ey f13722d = C5050ey.APP;

    /* renamed from: e */
    public final C5050ey f13723e;

    /* renamed from: f */
    public final String f13724f;

    /* renamed from: g */
    public final String f13725g;

    /* renamed from: com.tapjoy.internal.ex$a */
    public static final class C5048a extends C5003eh.C5004a {

        /* renamed from: c */
        public C5050ey f13726c;

        /* renamed from: d */
        public String f13727d;

        /* renamed from: e */
        public String f13728e;

        /* renamed from: b */
        public final C5047ex mo31206b() {
            if (this.f13726c != null && this.f13727d != null) {
                return new C5047ex(this.f13726c, this.f13727d, this.f13728e, super.mo31101a());
            }
            throw C5026eo.m16984a(this.f13726c, "type", this.f13727d, "name");
        }
    }

    public C5047ex(C5050ey eyVar, String str, String str2, C5212iu iuVar) {
        super(f13721c, iuVar);
        this.f13723e = eyVar;
        this.f13724f = str;
        this.f13725g = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C5047ex)) {
            return false;
        }
        C5047ex exVar = (C5047ex) obj;
        return mo31097a().equals(exVar.mo31097a()) && this.f13723e.equals(exVar.f13723e) && this.f13724f.equals(exVar.f13724f) && C5026eo.m16987a((Object) this.f13725g, (Object) exVar.f13725g);
    }

    public final int hashCode() {
        int i = this.f13578b;
        if (i != 0) {
            return i;
        }
        int hashCode = ((((mo31097a().hashCode() * 37) + this.f13723e.hashCode()) * 37) + this.f13724f.hashCode()) * 37;
        String str = this.f13725g;
        int hashCode2 = hashCode + (str != null ? str.hashCode() : 0);
        this.f13578b = hashCode2;
        return hashCode2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", type=");
        sb.append(this.f13723e);
        sb.append(", name=");
        sb.append(this.f13724f);
        if (this.f13725g != null) {
            sb.append(", category=");
            sb.append(this.f13725g);
        }
        StringBuilder replace = sb.replace(0, 2, "EventGroup{");
        replace.append('}');
        return replace.toString();
    }

    /* renamed from: com.tapjoy.internal.ex$b */
    static final class C5049b extends C5006ej {
        C5049b() {
            super(C5001eg.LENGTH_DELIMITED, C5047ex.class);
        }

        /* renamed from: b */
        private static C5047ex m17141b(C5022ek ekVar) {
            C5048a aVar = new C5048a();
            long a = ekVar.mo31109a();
            while (true) {
                int b = ekVar.mo31111b();
                if (b == -1) {
                    ekVar.mo31110a(a);
                    return aVar.mo31206b();
                } else if (b == 1) {
                    try {
                        aVar.f13726c = (C5050ey) C5050ey.ADAPTER.mo31094a(ekVar);
                    } catch (C5006ej.C5021a e) {
                        aVar.mo31099a(b, C5001eg.VARINT, Long.valueOf((long) e.f13602a));
                    }
                } else if (b == 2) {
                    aVar.f13727d = (String) C5006ej.f13596p.mo31094a(ekVar);
                } else if (b != 3) {
                    C5001eg c = ekVar.mo31112c();
                    aVar.mo31099a(b, c, c.mo31096a().mo31094a(ekVar));
                } else {
                    aVar.f13728e = (String) C5006ej.f13596p.mo31094a(ekVar);
                }
            }
        }

        /* renamed from: a */
        public final /* synthetic */ int mo31092a(Object obj) {
            C5047ex exVar = (C5047ex) obj;
            int a = C5050ey.ADAPTER.mo31102a(1, (Object) exVar.f13723e) + C5006ej.f13596p.mo31102a(2, (Object) exVar.f13724f);
            String str = exVar.f13725g;
            return a + (str != null ? C5006ej.f13596p.mo31102a(3, (Object) str) : 0) + exVar.mo31097a().mo31425c();
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo31094a(C5022ek ekVar) {
            return m17141b(ekVar);
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ void mo31095a(C5023el elVar, Object obj) {
            C5047ex exVar = (C5047ex) obj;
            C5050ey.ADAPTER.mo31106a(elVar, 1, exVar.f13723e);
            C5006ej.f13596p.mo31106a(elVar, 2, exVar.f13724f);
            String str = exVar.f13725g;
            if (str != null) {
                C5006ej.f13596p.mo31106a(elVar, 3, str);
            }
            elVar.mo31118a(exVar.mo31097a());
        }
    }
}
