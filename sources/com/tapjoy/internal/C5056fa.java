package com.tapjoy.internal;

import com.tapjoy.internal.C5003eh;

/* renamed from: com.tapjoy.internal.fa */
public final class C5056fa extends C5003eh {

    /* renamed from: c */
    public static final C5006ej f13744c = new C5058b();

    /* renamed from: d */
    public static final Integer f13745d = 0;

    /* renamed from: e */
    public static final Integer f13746e = 0;

    /* renamed from: f */
    public static final Integer f13747f = 0;

    /* renamed from: g */
    public final String f13748g;

    /* renamed from: h */
    public final String f13749h;

    /* renamed from: i */
    public final String f13750i;

    /* renamed from: j */
    public final String f13751j;

    /* renamed from: k */
    public final String f13752k;

    /* renamed from: l */
    public final String f13753l;

    /* renamed from: m */
    public final Integer f13754m;

    /* renamed from: n */
    public final Integer f13755n;

    /* renamed from: o */
    public final Integer f13756o;

    /* renamed from: p */
    public final String f13757p;

    /* renamed from: q */
    public final String f13758q;

    /* renamed from: r */
    public final String f13759r;

    /* renamed from: s */
    public final String f13760s;

    /* renamed from: t */
    public final String f13761t;

    /* renamed from: u */
    public final String f13762u;

    /* renamed from: v */
    public final String f13763v;

    /* renamed from: w */
    public final String f13764w;

    /* renamed from: x */
    public final String f13765x;

    /* renamed from: com.tapjoy.internal.fa$a */
    public static final class C5057a extends C5003eh.C5004a {

        /* renamed from: c */
        public String f13766c;

        /* renamed from: d */
        public String f13767d;

        /* renamed from: e */
        public String f13768e;

        /* renamed from: f */
        public String f13769f;

        /* renamed from: g */
        public String f13770g;

        /* renamed from: h */
        public String f13771h;

        /* renamed from: i */
        public Integer f13772i;

        /* renamed from: j */
        public Integer f13773j;

        /* renamed from: k */
        public Integer f13774k;

        /* renamed from: l */
        public String f13775l;

        /* renamed from: m */
        public String f13776m;

        /* renamed from: n */
        public String f13777n;

        /* renamed from: o */
        public String f13778o;

        /* renamed from: p */
        public String f13779p;

        /* renamed from: q */
        public String f13780q;

        /* renamed from: r */
        public String f13781r;

        /* renamed from: s */
        public String f13782s;

        /* renamed from: t */
        public String f13783t;

        /* renamed from: b */
        public final C5056fa mo31212b() {
            return new C5056fa(this.f13766c, this.f13767d, this.f13768e, this.f13769f, this.f13770g, this.f13771h, this.f13772i, this.f13773j, this.f13774k, this.f13775l, this.f13776m, this.f13777n, this.f13778o, this.f13779p, this.f13780q, this.f13781r, this.f13782s, this.f13783t, super.mo31101a());
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C5056fa(String str, String str2, String str3, String str4, String str5, String str6, Integer num, Integer num2, Integer num3, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, C5212iu iuVar) {
        super(f13744c, iuVar);
        this.f13748g = str;
        this.f13749h = str2;
        this.f13750i = str3;
        this.f13751j = str4;
        this.f13752k = str5;
        this.f13753l = str6;
        this.f13754m = num;
        this.f13755n = num2;
        this.f13756o = num3;
        this.f13757p = str7;
        this.f13758q = str8;
        this.f13759r = str9;
        this.f13760s = str10;
        this.f13761t = str11;
        this.f13762u = str12;
        this.f13763v = str13;
        this.f13764w = str14;
        this.f13765x = str15;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C5056fa)) {
            return false;
        }
        C5056fa faVar = (C5056fa) obj;
        return mo31097a().equals(faVar.mo31097a()) && C5026eo.m16987a((Object) this.f13748g, (Object) faVar.f13748g) && C5026eo.m16987a((Object) this.f13749h, (Object) faVar.f13749h) && C5026eo.m16987a((Object) this.f13750i, (Object) faVar.f13750i) && C5026eo.m16987a((Object) this.f13751j, (Object) faVar.f13751j) && C5026eo.m16987a((Object) this.f13752k, (Object) faVar.f13752k) && C5026eo.m16987a((Object) this.f13753l, (Object) faVar.f13753l) && C5026eo.m16987a((Object) this.f13754m, (Object) faVar.f13754m) && C5026eo.m16987a((Object) this.f13755n, (Object) faVar.f13755n) && C5026eo.m16987a((Object) this.f13756o, (Object) faVar.f13756o) && C5026eo.m16987a((Object) this.f13757p, (Object) faVar.f13757p) && C5026eo.m16987a((Object) this.f13758q, (Object) faVar.f13758q) && C5026eo.m16987a((Object) this.f13759r, (Object) faVar.f13759r) && C5026eo.m16987a((Object) this.f13760s, (Object) faVar.f13760s) && C5026eo.m16987a((Object) this.f13761t, (Object) faVar.f13761t) && C5026eo.m16987a((Object) this.f13762u, (Object) faVar.f13762u) && C5026eo.m16987a((Object) this.f13763v, (Object) faVar.f13763v) && C5026eo.m16987a((Object) this.f13764w, (Object) faVar.f13764w) && C5026eo.m16987a((Object) this.f13765x, (Object) faVar.f13765x);
    }

    public final int hashCode() {
        int i = this.f13578b;
        if (i != 0) {
            return i;
        }
        int hashCode = mo31097a().hashCode() * 37;
        String str = this.f13748g;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.f13749h;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.f13750i;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.f13751j;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.f13752k;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.f13753l;
        int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 37;
        Integer num = this.f13754m;
        int hashCode8 = (hashCode7 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.f13755n;
        int hashCode9 = (hashCode8 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.f13756o;
        int hashCode10 = (hashCode9 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str7 = this.f13757p;
        int hashCode11 = (hashCode10 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.f13758q;
        int hashCode12 = (hashCode11 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.f13759r;
        int hashCode13 = (hashCode12 + (str9 != null ? str9.hashCode() : 0)) * 37;
        String str10 = this.f13760s;
        int hashCode14 = (hashCode13 + (str10 != null ? str10.hashCode() : 0)) * 37;
        String str11 = this.f13761t;
        int hashCode15 = (hashCode14 + (str11 != null ? str11.hashCode() : 0)) * 37;
        String str12 = this.f13762u;
        int hashCode16 = (hashCode15 + (str12 != null ? str12.hashCode() : 0)) * 37;
        String str13 = this.f13763v;
        int hashCode17 = (hashCode16 + (str13 != null ? str13.hashCode() : 0)) * 37;
        String str14 = this.f13764w;
        int hashCode18 = (hashCode17 + (str14 != null ? str14.hashCode() : 0)) * 37;
        String str15 = this.f13765x;
        if (str15 != null) {
            i2 = str15.hashCode();
        }
        int i3 = hashCode18 + i2;
        this.f13578b = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f13748g != null) {
            sb.append(", mac=");
            sb.append(this.f13748g);
        }
        if (this.f13749h != null) {
            sb.append(", deviceId=");
            sb.append(this.f13749h);
        }
        if (this.f13750i != null) {
            sb.append(", deviceMaker=");
            sb.append(this.f13750i);
        }
        if (this.f13751j != null) {
            sb.append(", deviceModel=");
            sb.append(this.f13751j);
        }
        if (this.f13752k != null) {
            sb.append(", osName=");
            sb.append(this.f13752k);
        }
        if (this.f13753l != null) {
            sb.append(", osVer=");
            sb.append(this.f13753l);
        }
        if (this.f13754m != null) {
            sb.append(", displayD=");
            sb.append(this.f13754m);
        }
        if (this.f13755n != null) {
            sb.append(", displayW=");
            sb.append(this.f13755n);
        }
        if (this.f13756o != null) {
            sb.append(", displayH=");
            sb.append(this.f13756o);
        }
        if (this.f13757p != null) {
            sb.append(", locale=");
            sb.append(this.f13757p);
        }
        if (this.f13758q != null) {
            sb.append(", timezone=");
            sb.append(this.f13758q);
        }
        if (this.f13759r != null) {
            sb.append(", pkgId=");
            sb.append(this.f13759r);
        }
        if (this.f13760s != null) {
            sb.append(", pkgSign=");
            sb.append(this.f13760s);
        }
        if (this.f13761t != null) {
            sb.append(", sdk=");
            sb.append(this.f13761t);
        }
        if (this.f13762u != null) {
            sb.append(", countrySim=");
            sb.append(this.f13762u);
        }
        if (this.f13763v != null) {
            sb.append(", countryNet=");
            sb.append(this.f13763v);
        }
        if (this.f13764w != null) {
            sb.append(", imei=");
            sb.append(this.f13764w);
        }
        if (this.f13765x != null) {
            sb.append(", androidId=");
            sb.append(this.f13765x);
        }
        StringBuilder replace = sb.replace(0, 2, "Info{");
        replace.append('}');
        return replace.toString();
    }

    /* renamed from: com.tapjoy.internal.fa$b */
    static final class C5058b extends C5006ej {
        C5058b() {
            super(C5001eg.LENGTH_DELIMITED, C5056fa.class);
        }

        /* renamed from: a */
        public final /* synthetic */ int mo31092a(Object obj) {
            C5056fa faVar = (C5056fa) obj;
            String str = faVar.f13748g;
            int i = 0;
            int a = str != null ? C5006ej.f13596p.mo31102a(1, (Object) str) : 0;
            String str2 = faVar.f13749h;
            int a2 = a + (str2 != null ? C5006ej.f13596p.mo31102a(2, (Object) str2) : 0);
            String str3 = faVar.f13750i;
            int a3 = a2 + (str3 != null ? C5006ej.f13596p.mo31102a(3, (Object) str3) : 0);
            String str4 = faVar.f13751j;
            int a4 = a3 + (str4 != null ? C5006ej.f13596p.mo31102a(4, (Object) str4) : 0);
            String str5 = faVar.f13752k;
            int a5 = a4 + (str5 != null ? C5006ej.f13596p.mo31102a(5, (Object) str5) : 0);
            String str6 = faVar.f13753l;
            int a6 = a5 + (str6 != null ? C5006ej.f13596p.mo31102a(6, (Object) str6) : 0);
            Integer num = faVar.f13754m;
            int a7 = a6 + (num != null ? C5006ej.f13584d.mo31102a(7, (Object) num) : 0);
            Integer num2 = faVar.f13755n;
            int a8 = a7 + (num2 != null ? C5006ej.f13584d.mo31102a(8, (Object) num2) : 0);
            Integer num3 = faVar.f13756o;
            int a9 = a8 + (num3 != null ? C5006ej.f13584d.mo31102a(9, (Object) num3) : 0);
            String str7 = faVar.f13757p;
            int a10 = a9 + (str7 != null ? C5006ej.f13596p.mo31102a(10, (Object) str7) : 0);
            String str8 = faVar.f13758q;
            int a11 = a10 + (str8 != null ? C5006ej.f13596p.mo31102a(11, (Object) str8) : 0);
            String str9 = faVar.f13759r;
            int a12 = a11 + (str9 != null ? C5006ej.f13596p.mo31102a(12, (Object) str9) : 0);
            String str10 = faVar.f13760s;
            int a13 = a12 + (str10 != null ? C5006ej.f13596p.mo31102a(13, (Object) str10) : 0);
            String str11 = faVar.f13761t;
            int a14 = a13 + (str11 != null ? C5006ej.f13596p.mo31102a(14, (Object) str11) : 0);
            String str12 = faVar.f13762u;
            int a15 = a14 + (str12 != null ? C5006ej.f13596p.mo31102a(15, (Object) str12) : 0);
            String str13 = faVar.f13763v;
            int a16 = a15 + (str13 != null ? C5006ej.f13596p.mo31102a(16, (Object) str13) : 0);
            String str14 = faVar.f13764w;
            int a17 = a16 + (str14 != null ? C5006ej.f13596p.mo31102a(17, (Object) str14) : 0);
            String str15 = faVar.f13765x;
            if (str15 != null) {
                i = C5006ej.f13596p.mo31102a(18, (Object) str15);
            }
            return a17 + i + faVar.mo31097a().mo31425c();
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ void mo31095a(C5023el elVar, Object obj) {
            C5056fa faVar = (C5056fa) obj;
            String str = faVar.f13748g;
            if (str != null) {
                C5006ej.f13596p.mo31106a(elVar, 1, str);
            }
            String str2 = faVar.f13749h;
            if (str2 != null) {
                C5006ej.f13596p.mo31106a(elVar, 2, str2);
            }
            String str3 = faVar.f13750i;
            if (str3 != null) {
                C5006ej.f13596p.mo31106a(elVar, 3, str3);
            }
            String str4 = faVar.f13751j;
            if (str4 != null) {
                C5006ej.f13596p.mo31106a(elVar, 4, str4);
            }
            String str5 = faVar.f13752k;
            if (str5 != null) {
                C5006ej.f13596p.mo31106a(elVar, 5, str5);
            }
            String str6 = faVar.f13753l;
            if (str6 != null) {
                C5006ej.f13596p.mo31106a(elVar, 6, str6);
            }
            Integer num = faVar.f13754m;
            if (num != null) {
                C5006ej.f13584d.mo31106a(elVar, 7, num);
            }
            Integer num2 = faVar.f13755n;
            if (num2 != null) {
                C5006ej.f13584d.mo31106a(elVar, 8, num2);
            }
            Integer num3 = faVar.f13756o;
            if (num3 != null) {
                C5006ej.f13584d.mo31106a(elVar, 9, num3);
            }
            String str7 = faVar.f13757p;
            if (str7 != null) {
                C5006ej.f13596p.mo31106a(elVar, 10, str7);
            }
            String str8 = faVar.f13758q;
            if (str8 != null) {
                C5006ej.f13596p.mo31106a(elVar, 11, str8);
            }
            String str9 = faVar.f13759r;
            if (str9 != null) {
                C5006ej.f13596p.mo31106a(elVar, 12, str9);
            }
            String str10 = faVar.f13760s;
            if (str10 != null) {
                C5006ej.f13596p.mo31106a(elVar, 13, str10);
            }
            String str11 = faVar.f13761t;
            if (str11 != null) {
                C5006ej.f13596p.mo31106a(elVar, 14, str11);
            }
            String str12 = faVar.f13762u;
            if (str12 != null) {
                C5006ej.f13596p.mo31106a(elVar, 15, str12);
            }
            String str13 = faVar.f13763v;
            if (str13 != null) {
                C5006ej.f13596p.mo31106a(elVar, 16, str13);
            }
            String str14 = faVar.f13764w;
            if (str14 != null) {
                C5006ej.f13596p.mo31106a(elVar, 17, str14);
            }
            String str15 = faVar.f13765x;
            if (str15 != null) {
                C5006ej.f13596p.mo31106a(elVar, 18, str15);
            }
            elVar.mo31118a(faVar.mo31097a());
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo31094a(C5022ek ekVar) {
            C5057a aVar = new C5057a();
            long a = ekVar.mo31109a();
            while (true) {
                int b = ekVar.mo31111b();
                if (b != -1) {
                    switch (b) {
                        case 1:
                            aVar.f13766c = (String) C5006ej.f13596p.mo31094a(ekVar);
                            break;
                        case 2:
                            aVar.f13767d = (String) C5006ej.f13596p.mo31094a(ekVar);
                            break;
                        case 3:
                            aVar.f13768e = (String) C5006ej.f13596p.mo31094a(ekVar);
                            break;
                        case 4:
                            aVar.f13769f = (String) C5006ej.f13596p.mo31094a(ekVar);
                            break;
                        case 5:
                            aVar.f13770g = (String) C5006ej.f13596p.mo31094a(ekVar);
                            break;
                        case 6:
                            aVar.f13771h = (String) C5006ej.f13596p.mo31094a(ekVar);
                            break;
                        case 7:
                            aVar.f13772i = (Integer) C5006ej.f13584d.mo31094a(ekVar);
                            break;
                        case 8:
                            aVar.f13773j = (Integer) C5006ej.f13584d.mo31094a(ekVar);
                            break;
                        case 9:
                            aVar.f13774k = (Integer) C5006ej.f13584d.mo31094a(ekVar);
                            break;
                        case 10:
                            aVar.f13775l = (String) C5006ej.f13596p.mo31094a(ekVar);
                            break;
                        case 11:
                            aVar.f13776m = (String) C5006ej.f13596p.mo31094a(ekVar);
                            break;
                        case 12:
                            aVar.f13777n = (String) C5006ej.f13596p.mo31094a(ekVar);
                            break;
                        case 13:
                            aVar.f13778o = (String) C5006ej.f13596p.mo31094a(ekVar);
                            break;
                        case 14:
                            aVar.f13779p = (String) C5006ej.f13596p.mo31094a(ekVar);
                            break;
                        case 15:
                            aVar.f13780q = (String) C5006ej.f13596p.mo31094a(ekVar);
                            break;
                        case 16:
                            aVar.f13781r = (String) C5006ej.f13596p.mo31094a(ekVar);
                            break;
                        case 17:
                            aVar.f13782s = (String) C5006ej.f13596p.mo31094a(ekVar);
                            break;
                        case 18:
                            aVar.f13783t = (String) C5006ej.f13596p.mo31094a(ekVar);
                            break;
                        default:
                            C5001eg c = ekVar.mo31112c();
                            aVar.mo31099a(b, c, c.mo31096a().mo31094a(ekVar));
                            break;
                    }
                } else {
                    ekVar.mo31110a(a);
                    return aVar.mo31212b();
                }
            }
        }
    }
}
