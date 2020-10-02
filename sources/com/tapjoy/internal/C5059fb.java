package com.tapjoy.internal;

import com.tapjoy.internal.C5003eh;

/* renamed from: com.tapjoy.internal.fb */
public final class C5059fb extends C5003eh {

    /* renamed from: c */
    public static final C5006ej f13784c = new C5061b();

    /* renamed from: d */
    public final C5056fa f13785d;

    /* renamed from: e */
    public final C5038eu f13786e;

    /* renamed from: f */
    public final C5077fh f13787f;

    /* renamed from: com.tapjoy.internal.fb$a */
    public static final class C5060a extends C5003eh.C5004a {

        /* renamed from: c */
        public C5056fa f13788c;

        /* renamed from: d */
        public C5038eu f13789d;

        /* renamed from: e */
        public C5077fh f13790e;

        /* renamed from: b */
        public final C5059fb mo31215b() {
            return new C5059fb(this.f13788c, this.f13789d, this.f13790e, super.mo31101a());
        }
    }

    public C5059fb(C5056fa faVar, C5038eu euVar, C5077fh fhVar) {
        this(faVar, euVar, fhVar, C5212iu.f14313b);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C5059fb)) {
            return false;
        }
        C5059fb fbVar = (C5059fb) obj;
        return mo31097a().equals(fbVar.mo31097a()) && C5026eo.m16987a((Object) this.f13785d, (Object) fbVar.f13785d) && C5026eo.m16987a((Object) this.f13786e, (Object) fbVar.f13786e) && C5026eo.m16987a((Object) this.f13787f, (Object) fbVar.f13787f);
    }

    public final int hashCode() {
        int i = this.f13578b;
        if (i != 0) {
            return i;
        }
        int hashCode = mo31097a().hashCode() * 37;
        C5056fa faVar = this.f13785d;
        int i2 = 0;
        int hashCode2 = (hashCode + (faVar != null ? faVar.hashCode() : 0)) * 37;
        C5038eu euVar = this.f13786e;
        int hashCode3 = (hashCode2 + (euVar != null ? euVar.hashCode() : 0)) * 37;
        C5077fh fhVar = this.f13787f;
        if (fhVar != null) {
            i2 = fhVar.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.f13578b = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f13785d != null) {
            sb.append(", info=");
            sb.append(this.f13785d);
        }
        if (this.f13786e != null) {
            sb.append(", app=");
            sb.append(this.f13786e);
        }
        if (this.f13787f != null) {
            sb.append(", user=");
            sb.append(this.f13787f);
        }
        StringBuilder replace = sb.replace(0, 2, "InfoSet{");
        replace.append('}');
        return replace.toString();
    }

    public C5059fb(C5056fa faVar, C5038eu euVar, C5077fh fhVar, C5212iu iuVar) {
        super(f13784c, iuVar);
        this.f13785d = faVar;
        this.f13786e = euVar;
        this.f13787f = fhVar;
    }

    /* renamed from: com.tapjoy.internal.fb$b */
    static final class C5061b extends C5006ej {
        C5061b() {
            super(C5001eg.LENGTH_DELIMITED, C5059fb.class);
        }

        /* renamed from: a */
        public final /* synthetic */ int mo31092a(Object obj) {
            C5059fb fbVar = (C5059fb) obj;
            C5056fa faVar = fbVar.f13785d;
            int i = 0;
            int a = faVar != null ? C5056fa.f13744c.mo31102a(1, (Object) faVar) : 0;
            C5038eu euVar = fbVar.f13786e;
            int a2 = a + (euVar != null ? C5038eu.f13645c.mo31102a(2, (Object) euVar) : 0);
            C5077fh fhVar = fbVar.f13787f;
            if (fhVar != null) {
                i = C5077fh.f13846c.mo31102a(3, (Object) fhVar);
            }
            return a2 + i + fbVar.mo31097a().mo31425c();
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ void mo31095a(C5023el elVar, Object obj) {
            C5059fb fbVar = (C5059fb) obj;
            C5056fa faVar = fbVar.f13785d;
            if (faVar != null) {
                C5056fa.f13744c.mo31106a(elVar, 1, faVar);
            }
            C5038eu euVar = fbVar.f13786e;
            if (euVar != null) {
                C5038eu.f13645c.mo31106a(elVar, 2, euVar);
            }
            C5077fh fhVar = fbVar.f13787f;
            if (fhVar != null) {
                C5077fh.f13846c.mo31106a(elVar, 3, fhVar);
            }
            elVar.mo31118a(fbVar.mo31097a());
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo31094a(C5022ek ekVar) {
            C5060a aVar = new C5060a();
            long a = ekVar.mo31109a();
            while (true) {
                int b = ekVar.mo31111b();
                if (b == -1) {
                    ekVar.mo31110a(a);
                    return aVar.mo31215b();
                } else if (b == 1) {
                    aVar.f13788c = (C5056fa) C5056fa.f13744c.mo31094a(ekVar);
                } else if (b == 2) {
                    aVar.f13789d = (C5038eu) C5038eu.f13645c.mo31094a(ekVar);
                } else if (b != 3) {
                    C5001eg c = ekVar.mo31112c();
                    aVar.mo31099a(b, c, c.mo31096a().mo31094a(ekVar));
                } else {
                    aVar.f13790e = (C5077fh) C5077fh.f13846c.mo31094a(ekVar);
                }
            }
        }
    }
}
