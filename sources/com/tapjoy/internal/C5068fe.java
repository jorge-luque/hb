package com.tapjoy.internal;

import com.tapjoy.internal.C5003eh;

/* renamed from: com.tapjoy.internal.fe */
public final class C5068fe extends C5003eh {

    /* renamed from: c */
    public static final C5006ej f13831c = new C5070b();

    /* renamed from: d */
    public static final Long f13832d = 0L;

    /* renamed from: e */
    public static final Long f13833e = 0L;

    /* renamed from: f */
    public final String f13834f;

    /* renamed from: g */
    public final Long f13835g;

    /* renamed from: h */
    public final Long f13836h;

    /* renamed from: com.tapjoy.internal.fe$a */
    public static final class C5069a extends C5003eh.C5004a {

        /* renamed from: c */
        public String f13837c;

        /* renamed from: d */
        public Long f13838d;

        /* renamed from: e */
        public Long f13839e;

        /* renamed from: b */
        public final C5068fe mo31225b() {
            if (this.f13837c != null && this.f13838d != null) {
                return new C5068fe(this.f13837c, this.f13838d, this.f13839e, super.mo31101a());
            }
            throw C5026eo.m16984a(this.f13837c, "id", this.f13838d, "received");
        }
    }

    public C5068fe(String str, Long l) {
        this(str, l, (Long) null, C5212iu.f14313b);
    }

    /* renamed from: b */
    public final C5069a mo31222b() {
        C5069a aVar = new C5069a();
        aVar.f13837c = this.f13834f;
        aVar.f13838d = this.f13835g;
        aVar.f13839e = this.f13836h;
        aVar.mo31100a(mo31097a());
        return aVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C5068fe)) {
            return false;
        }
        C5068fe feVar = (C5068fe) obj;
        return mo31097a().equals(feVar.mo31097a()) && this.f13834f.equals(feVar.f13834f) && this.f13835g.equals(feVar.f13835g) && C5026eo.m16987a((Object) this.f13836h, (Object) feVar.f13836h);
    }

    public final int hashCode() {
        int i = this.f13578b;
        if (i != 0) {
            return i;
        }
        int hashCode = ((((mo31097a().hashCode() * 37) + this.f13834f.hashCode()) * 37) + this.f13835g.hashCode()) * 37;
        Long l = this.f13836h;
        int hashCode2 = hashCode + (l != null ? l.hashCode() : 0);
        this.f13578b = hashCode2;
        return hashCode2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", id=");
        sb.append(this.f13834f);
        sb.append(", received=");
        sb.append(this.f13835g);
        if (this.f13836h != null) {
            sb.append(", clicked=");
            sb.append(this.f13836h);
        }
        StringBuilder replace = sb.replace(0, 2, "Push{");
        replace.append('}');
        return replace.toString();
    }

    public C5068fe(String str, Long l, Long l2, C5212iu iuVar) {
        super(f13831c, iuVar);
        this.f13834f = str;
        this.f13835g = l;
        this.f13836h = l2;
    }

    /* renamed from: com.tapjoy.internal.fe$b */
    static final class C5070b extends C5006ej {
        C5070b() {
            super(C5001eg.LENGTH_DELIMITED, C5068fe.class);
        }

        /* renamed from: a */
        public final /* synthetic */ int mo31092a(Object obj) {
            C5068fe feVar = (C5068fe) obj;
            int a = C5006ej.f13596p.mo31102a(1, (Object) feVar.f13834f) + C5006ej.f13589i.mo31102a(2, (Object) feVar.f13835g);
            Long l = feVar.f13836h;
            return a + (l != null ? C5006ej.f13589i.mo31102a(3, (Object) l) : 0) + feVar.mo31097a().mo31425c();
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ void mo31095a(C5023el elVar, Object obj) {
            C5068fe feVar = (C5068fe) obj;
            C5006ej.f13596p.mo31106a(elVar, 1, feVar.f13834f);
            C5006ej.f13589i.mo31106a(elVar, 2, feVar.f13835g);
            Long l = feVar.f13836h;
            if (l != null) {
                C5006ej.f13589i.mo31106a(elVar, 3, l);
            }
            elVar.mo31118a(feVar.mo31097a());
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo31094a(C5022ek ekVar) {
            C5069a aVar = new C5069a();
            long a = ekVar.mo31109a();
            while (true) {
                int b = ekVar.mo31111b();
                if (b == -1) {
                    ekVar.mo31110a(a);
                    return aVar.mo31225b();
                } else if (b == 1) {
                    aVar.f13837c = (String) C5006ej.f13596p.mo31094a(ekVar);
                } else if (b == 2) {
                    aVar.f13838d = (Long) C5006ej.f13589i.mo31094a(ekVar);
                } else if (b != 3) {
                    C5001eg c = ekVar.mo31112c();
                    aVar.mo31099a(b, c, c.mo31096a().mo31094a(ekVar));
                } else {
                    aVar.f13839e = (Long) C5006ej.f13589i.mo31094a(ekVar);
                }
            }
        }
    }
}
