package com.tapjoy.internal;

import com.tapjoy.internal.C5003eh;

/* renamed from: com.tapjoy.internal.fd */
public final class C5065fd extends C5003eh {

    /* renamed from: c */
    public static final C5006ej f13798c = new C5067b();

    /* renamed from: d */
    public static final Integer f13799d = 1;

    /* renamed from: e */
    public static final Double f13800e = Double.valueOf(0.0d);

    /* renamed from: f */
    public static final Integer f13801f = 0;

    /* renamed from: g */
    public static final Long f13802g = 0L;

    /* renamed from: h */
    public final String f13803h;

    /* renamed from: i */
    public final Integer f13804i;

    /* renamed from: j */
    public final Double f13805j;

    /* renamed from: k */
    public final String f13806k;

    /* renamed from: l */
    public final String f13807l;

    /* renamed from: m */
    public final String f13808m;

    /* renamed from: n */
    public final String f13809n;

    /* renamed from: o */
    public final String f13810o;

    /* renamed from: p */
    public final Integer f13811p;

    /* renamed from: q */
    public final Long f13812q;

    /* renamed from: r */
    public final String f13813r;

    /* renamed from: s */
    public final String f13814s;

    /* renamed from: t */
    public final String f13815t;

    /* renamed from: u */
    public final String f13816u;

    /* renamed from: com.tapjoy.internal.fd$a */
    public static final class C5066a extends C5003eh.C5004a {

        /* renamed from: c */
        public String f13817c;

        /* renamed from: d */
        public Integer f13818d;

        /* renamed from: e */
        public Double f13819e;

        /* renamed from: f */
        public String f13820f;

        /* renamed from: g */
        public String f13821g;

        /* renamed from: h */
        public String f13822h;

        /* renamed from: i */
        public String f13823i;

        /* renamed from: j */
        public String f13824j;

        /* renamed from: k */
        public Integer f13825k;

        /* renamed from: l */
        public Long f13826l;

        /* renamed from: m */
        public String f13827m;

        /* renamed from: n */
        public String f13828n;

        /* renamed from: o */
        public String f13829o;

        /* renamed from: p */
        public String f13830p;

        /* renamed from: b */
        public final C5065fd mo31221b() {
            String str = this.f13817c;
            if (str != null) {
                return new C5065fd(this.f13817c, this.f13818d, this.f13819e, this.f13820f, this.f13821g, this.f13822h, this.f13823i, this.f13824j, this.f13825k, this.f13826l, this.f13827m, this.f13828n, this.f13829o, this.f13830p, super.mo31101a());
            }
            throw C5026eo.m16984a(str, "productId");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C5065fd(String str, Integer num, Double d, String str2, String str3, String str4, String str5, String str6, Integer num2, Long l, String str7, String str8, String str9, String str10, C5212iu iuVar) {
        super(f13798c, iuVar);
        this.f13803h = str;
        this.f13804i = num;
        this.f13805j = d;
        this.f13806k = str2;
        this.f13807l = str3;
        this.f13808m = str4;
        this.f13809n = str5;
        this.f13810o = str6;
        this.f13811p = num2;
        this.f13812q = l;
        this.f13813r = str7;
        this.f13814s = str8;
        this.f13815t = str9;
        this.f13816u = str10;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C5065fd)) {
            return false;
        }
        C5065fd fdVar = (C5065fd) obj;
        return mo31097a().equals(fdVar.mo31097a()) && this.f13803h.equals(fdVar.f13803h) && C5026eo.m16987a((Object) this.f13804i, (Object) fdVar.f13804i) && C5026eo.m16987a((Object) this.f13805j, (Object) fdVar.f13805j) && C5026eo.m16987a((Object) this.f13806k, (Object) fdVar.f13806k) && C5026eo.m16987a((Object) this.f13807l, (Object) fdVar.f13807l) && C5026eo.m16987a((Object) this.f13808m, (Object) fdVar.f13808m) && C5026eo.m16987a((Object) this.f13809n, (Object) fdVar.f13809n) && C5026eo.m16987a((Object) this.f13810o, (Object) fdVar.f13810o) && C5026eo.m16987a((Object) this.f13811p, (Object) fdVar.f13811p) && C5026eo.m16987a((Object) this.f13812q, (Object) fdVar.f13812q) && C5026eo.m16987a((Object) this.f13813r, (Object) fdVar.f13813r) && C5026eo.m16987a((Object) this.f13814s, (Object) fdVar.f13814s) && C5026eo.m16987a((Object) this.f13815t, (Object) fdVar.f13815t) && C5026eo.m16987a((Object) this.f13816u, (Object) fdVar.f13816u);
    }

    public final int hashCode() {
        int i = this.f13578b;
        if (i != 0) {
            return i;
        }
        int hashCode = ((mo31097a().hashCode() * 37) + this.f13803h.hashCode()) * 37;
        Integer num = this.f13804i;
        int i2 = 0;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Double d = this.f13805j;
        int hashCode3 = (hashCode2 + (d != null ? d.hashCode() : 0)) * 37;
        String str = this.f13806k;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.f13807l;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.f13808m;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.f13809n;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.f13810o;
        int hashCode8 = (hashCode7 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Integer num2 = this.f13811p;
        int hashCode9 = (hashCode8 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l = this.f13812q;
        int hashCode10 = (hashCode9 + (l != null ? l.hashCode() : 0)) * 37;
        String str6 = this.f13813r;
        int hashCode11 = (hashCode10 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.f13814s;
        int hashCode12 = (hashCode11 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.f13815t;
        int hashCode13 = (hashCode12 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.f13816u;
        if (str9 != null) {
            i2 = str9.hashCode();
        }
        int i3 = hashCode13 + i2;
        this.f13578b = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", productId=");
        sb.append(this.f13803h);
        if (this.f13804i != null) {
            sb.append(", productQuantity=");
            sb.append(this.f13804i);
        }
        if (this.f13805j != null) {
            sb.append(", productPrice=");
            sb.append(this.f13805j);
        }
        if (this.f13806k != null) {
            sb.append(", productPriceCurrency=");
            sb.append(this.f13806k);
        }
        if (this.f13807l != null) {
            sb.append(", productType=");
            sb.append(this.f13807l);
        }
        if (this.f13808m != null) {
            sb.append(", productTitle=");
            sb.append(this.f13808m);
        }
        if (this.f13809n != null) {
            sb.append(", productDescription=");
            sb.append(this.f13809n);
        }
        if (this.f13810o != null) {
            sb.append(", transactionId=");
            sb.append(this.f13810o);
        }
        if (this.f13811p != null) {
            sb.append(", transactionState=");
            sb.append(this.f13811p);
        }
        if (this.f13812q != null) {
            sb.append(", transactionDate=");
            sb.append(this.f13812q);
        }
        if (this.f13813r != null) {
            sb.append(", campaignId=");
            sb.append(this.f13813r);
        }
        if (this.f13814s != null) {
            sb.append(", currencyPrice=");
            sb.append(this.f13814s);
        }
        if (this.f13815t != null) {
            sb.append(", receipt=");
            sb.append(this.f13815t);
        }
        if (this.f13816u != null) {
            sb.append(", signature=");
            sb.append(this.f13816u);
        }
        StringBuilder replace = sb.replace(0, 2, "Purchase{");
        replace.append('}');
        return replace.toString();
    }

    /* renamed from: com.tapjoy.internal.fd$b */
    static final class C5067b extends C5006ej {
        C5067b() {
            super(C5001eg.LENGTH_DELIMITED, C5065fd.class);
        }

        /* renamed from: a */
        public final /* synthetic */ int mo31092a(Object obj) {
            C5065fd fdVar = (C5065fd) obj;
            int a = C5006ej.f13596p.mo31102a(1, (Object) fdVar.f13803h);
            Integer num = fdVar.f13804i;
            int i = 0;
            int a2 = a + (num != null ? C5006ej.f13584d.mo31102a(2, (Object) num) : 0);
            Double d = fdVar.f13805j;
            int a3 = a2 + (d != null ? C5006ej.f13595o.mo31102a(3, (Object) d) : 0);
            String str = fdVar.f13806k;
            int a4 = a3 + (str != null ? C5006ej.f13596p.mo31102a(4, (Object) str) : 0);
            String str2 = fdVar.f13807l;
            int a5 = a4 + (str2 != null ? C5006ej.f13596p.mo31102a(5, (Object) str2) : 0);
            String str3 = fdVar.f13808m;
            int a6 = a5 + (str3 != null ? C5006ej.f13596p.mo31102a(6, (Object) str3) : 0);
            String str4 = fdVar.f13809n;
            int a7 = a6 + (str4 != null ? C5006ej.f13596p.mo31102a(7, (Object) str4) : 0);
            String str5 = fdVar.f13810o;
            int a8 = a7 + (str5 != null ? C5006ej.f13596p.mo31102a(8, (Object) str5) : 0);
            Integer num2 = fdVar.f13811p;
            int a9 = a8 + (num2 != null ? C5006ej.f13584d.mo31102a(9, (Object) num2) : 0);
            Long l = fdVar.f13812q;
            int a10 = a9 + (l != null ? C5006ej.f13589i.mo31102a(10, (Object) l) : 0);
            String str6 = fdVar.f13813r;
            int a11 = a10 + (str6 != null ? C5006ej.f13596p.mo31102a(11, (Object) str6) : 0);
            String str7 = fdVar.f13814s;
            int a12 = a11 + (str7 != null ? C5006ej.f13596p.mo31102a(12, (Object) str7) : 0);
            String str8 = fdVar.f13815t;
            int a13 = a12 + (str8 != null ? C5006ej.f13596p.mo31102a(13, (Object) str8) : 0);
            String str9 = fdVar.f13816u;
            if (str9 != null) {
                i = C5006ej.f13596p.mo31102a(14, (Object) str9);
            }
            return a13 + i + fdVar.mo31097a().mo31425c();
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ void mo31095a(C5023el elVar, Object obj) {
            C5065fd fdVar = (C5065fd) obj;
            C5006ej.f13596p.mo31106a(elVar, 1, fdVar.f13803h);
            Integer num = fdVar.f13804i;
            if (num != null) {
                C5006ej.f13584d.mo31106a(elVar, 2, num);
            }
            Double d = fdVar.f13805j;
            if (d != null) {
                C5006ej.f13595o.mo31106a(elVar, 3, d);
            }
            String str = fdVar.f13806k;
            if (str != null) {
                C5006ej.f13596p.mo31106a(elVar, 4, str);
            }
            String str2 = fdVar.f13807l;
            if (str2 != null) {
                C5006ej.f13596p.mo31106a(elVar, 5, str2);
            }
            String str3 = fdVar.f13808m;
            if (str3 != null) {
                C5006ej.f13596p.mo31106a(elVar, 6, str3);
            }
            String str4 = fdVar.f13809n;
            if (str4 != null) {
                C5006ej.f13596p.mo31106a(elVar, 7, str4);
            }
            String str5 = fdVar.f13810o;
            if (str5 != null) {
                C5006ej.f13596p.mo31106a(elVar, 8, str5);
            }
            Integer num2 = fdVar.f13811p;
            if (num2 != null) {
                C5006ej.f13584d.mo31106a(elVar, 9, num2);
            }
            Long l = fdVar.f13812q;
            if (l != null) {
                C5006ej.f13589i.mo31106a(elVar, 10, l);
            }
            String str6 = fdVar.f13813r;
            if (str6 != null) {
                C5006ej.f13596p.mo31106a(elVar, 11, str6);
            }
            String str7 = fdVar.f13814s;
            if (str7 != null) {
                C5006ej.f13596p.mo31106a(elVar, 12, str7);
            }
            String str8 = fdVar.f13815t;
            if (str8 != null) {
                C5006ej.f13596p.mo31106a(elVar, 13, str8);
            }
            String str9 = fdVar.f13816u;
            if (str9 != null) {
                C5006ej.f13596p.mo31106a(elVar, 14, str9);
            }
            elVar.mo31118a(fdVar.mo31097a());
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo31094a(C5022ek ekVar) {
            C5066a aVar = new C5066a();
            long a = ekVar.mo31109a();
            while (true) {
                int b = ekVar.mo31111b();
                if (b != -1) {
                    switch (b) {
                        case 1:
                            aVar.f13817c = (String) C5006ej.f13596p.mo31094a(ekVar);
                            break;
                        case 2:
                            aVar.f13818d = (Integer) C5006ej.f13584d.mo31094a(ekVar);
                            break;
                        case 3:
                            aVar.f13819e = (Double) C5006ej.f13595o.mo31094a(ekVar);
                            break;
                        case 4:
                            aVar.f13820f = (String) C5006ej.f13596p.mo31094a(ekVar);
                            break;
                        case 5:
                            aVar.f13821g = (String) C5006ej.f13596p.mo31094a(ekVar);
                            break;
                        case 6:
                            aVar.f13822h = (String) C5006ej.f13596p.mo31094a(ekVar);
                            break;
                        case 7:
                            aVar.f13823i = (String) C5006ej.f13596p.mo31094a(ekVar);
                            break;
                        case 8:
                            aVar.f13824j = (String) C5006ej.f13596p.mo31094a(ekVar);
                            break;
                        case 9:
                            aVar.f13825k = (Integer) C5006ej.f13584d.mo31094a(ekVar);
                            break;
                        case 10:
                            aVar.f13826l = (Long) C5006ej.f13589i.mo31094a(ekVar);
                            break;
                        case 11:
                            aVar.f13827m = (String) C5006ej.f13596p.mo31094a(ekVar);
                            break;
                        case 12:
                            aVar.f13828n = (String) C5006ej.f13596p.mo31094a(ekVar);
                            break;
                        case 13:
                            aVar.f13829o = (String) C5006ej.f13596p.mo31094a(ekVar);
                            break;
                        case 14:
                            aVar.f13830p = (String) C5006ej.f13596p.mo31094a(ekVar);
                            break;
                        default:
                            C5001eg c = ekVar.mo31112c();
                            aVar.mo31099a(b, c, c.mo31096a().mo31094a(ekVar));
                            break;
                    }
                } else {
                    ekVar.mo31110a(a);
                    return aVar.mo31221b();
                }
            }
        }
    }
}
