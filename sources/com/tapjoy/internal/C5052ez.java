package com.tapjoy.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.tapjoy.internal.C5003eh;

/* renamed from: com.tapjoy.internal.ez */
public final class C5052ez extends C5003eh {

    /* renamed from: c */
    public static final C5006ej f13731c = new C5054b();

    /* renamed from: d */
    public static final Long f13732d = 0L;

    /* renamed from: e */
    public final String f13733e;

    /* renamed from: f */
    public final Long f13734f;

    /* renamed from: com.tapjoy.internal.ez$a */
    public static final class C5053a extends C5003eh.C5004a {

        /* renamed from: c */
        public String f13735c;

        /* renamed from: d */
        public Long f13736d;

        /* renamed from: b */
        public final C5052ez mo31209b() {
            if (this.f13735c != null && this.f13736d != null) {
                return new C5052ez(this.f13735c, this.f13736d, super.mo31101a());
            }
            throw C5026eo.m16984a(this.f13735c, "name", this.f13736d, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        }
    }

    public C5052ez(String str, Long l) {
        this(str, l, C5212iu.f14313b);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C5052ez)) {
            return false;
        }
        C5052ez ezVar = (C5052ez) obj;
        return mo31097a().equals(ezVar.mo31097a()) && this.f13733e.equals(ezVar.f13733e) && this.f13734f.equals(ezVar.f13734f);
    }

    public final int hashCode() {
        int i = this.f13578b;
        if (i != 0) {
            return i;
        }
        int hashCode = (((mo31097a().hashCode() * 37) + this.f13733e.hashCode()) * 37) + this.f13734f.hashCode();
        this.f13578b = hashCode;
        return hashCode;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", name=");
        sb.append(this.f13733e);
        sb.append(", value=");
        sb.append(this.f13734f);
        StringBuilder replace = sb.replace(0, 2, "EventValue{");
        replace.append('}');
        return replace.toString();
    }

    public C5052ez(String str, Long l, C5212iu iuVar) {
        super(f13731c, iuVar);
        this.f13733e = str;
        this.f13734f = l;
    }

    /* renamed from: com.tapjoy.internal.ez$b */
    static final class C5054b extends C5006ej {
        C5054b() {
            super(C5001eg.LENGTH_DELIMITED, C5052ez.class);
        }

        /* renamed from: a */
        public final /* synthetic */ int mo31092a(Object obj) {
            C5052ez ezVar = (C5052ez) obj;
            return C5006ej.f13596p.mo31102a(1, (Object) ezVar.f13733e) + C5006ej.f13589i.mo31102a(2, (Object) ezVar.f13734f) + ezVar.mo31097a().mo31425c();
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ void mo31095a(C5023el elVar, Object obj) {
            C5052ez ezVar = (C5052ez) obj;
            C5006ej.f13596p.mo31106a(elVar, 1, ezVar.f13733e);
            C5006ej.f13589i.mo31106a(elVar, 2, ezVar.f13734f);
            elVar.mo31118a(ezVar.mo31097a());
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo31094a(C5022ek ekVar) {
            C5053a aVar = new C5053a();
            long a = ekVar.mo31109a();
            while (true) {
                int b = ekVar.mo31111b();
                if (b == -1) {
                    ekVar.mo31110a(a);
                    return aVar.mo31209b();
                } else if (b == 1) {
                    aVar.f13735c = (String) C5006ej.f13596p.mo31094a(ekVar);
                } else if (b != 2) {
                    C5001eg c = ekVar.mo31112c();
                    aVar.mo31099a(b, c, c.mo31096a().mo31094a(ekVar));
                } else {
                    aVar.f13736d = (Long) C5006ej.f13589i.mo31094a(ekVar);
                }
            }
        }
    }
}
