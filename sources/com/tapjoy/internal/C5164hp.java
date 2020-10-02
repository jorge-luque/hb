package com.tapjoy.internal;

import com.applovin.sdk.AppLovinEventParameters;
import com.qumpara.offerwall.sdk.core.QumparaOfferwallUtil;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import com.unity3d.services.purchasing.core.TransactionDetailsUtilities;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: com.tapjoy.internal.hp */
public final class C5164hp {

    /* renamed from: com.tapjoy.internal.hp$1 */
    static /* synthetic */ class C51651 {

        /* renamed from: a */
        static final /* synthetic */ int[] f14151a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.tapjoy.internal.ey[] r0 = com.tapjoy.internal.C5050ey.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f14151a = r0
                com.tapjoy.internal.ey r1 = com.tapjoy.internal.C5050ey.APP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f14151a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tapjoy.internal.ey r1 = com.tapjoy.internal.C5050ey.CAMPAIGN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f14151a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.tapjoy.internal.ey r1 = com.tapjoy.internal.C5050ey.CUSTOM     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f14151a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.tapjoy.internal.ey r1 = com.tapjoy.internal.C5050ey.USAGES     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C5164hp.C51651.<clinit>():void");
        }
    }

    /* renamed from: a */
    public static String m17393a(C5056fa faVar) {
        C4910bh b = new C4910bh().mo30996c().mo30990a("sdk").mo30995b(faVar.f13761t).mo30990a("os_name").mo30995b(faVar.f13752k).mo30990a("os_ver").mo30995b(faVar.f13753l).mo30990a("device_id").mo30995b(faVar.f13749h).mo30990a("device_maker").mo30995b(faVar.f13750i).mo30990a("device_model").mo30995b(faVar.f13751j).mo30990a(TapjoyConstants.TJC_PACKAGE_ID).mo30995b(faVar.f13759r).mo30990a(TapjoyConstants.TJC_PACKAGE_SIGN).mo30995b(faVar.f13760s).mo30990a("locale").mo30995b(faVar.f13757p).mo30990a(TapjoyConstants.TJC_DEVICE_TIMEZONE).mo30995b(faVar.f13758q);
        if (faVar.f13754m != null) {
            b.mo30990a(TapjoyConstants.TJC_DEVICE_DISPLAY_DENSITY).mo30989a((Number) faVar.f13754m);
        }
        if (faVar.f13755n != null) {
            b.mo30990a(TapjoyConstants.TJC_DEVICE_DISPLAY_WIDTH).mo30989a((Number) faVar.f13755n);
        }
        if (faVar.f13756o != null) {
            b.mo30990a(TapjoyConstants.TJC_DEVICE_DISPLAY_HEIGHT).mo30989a((Number) faVar.f13756o);
        }
        if (faVar.f13748g != null) {
            b.mo30990a("mac").mo30995b(faVar.f13748g);
        }
        if (faVar.f13762u != null) {
            b.mo30990a(TapjoyConstants.TJC_DEVICE_COUNTRY_SIM).mo30995b(faVar.f13762u);
        }
        if (faVar.f13763v != null) {
            b.mo30990a("country_net").mo30995b(faVar.f13763v);
        }
        if (faVar.f13764w != null) {
            b.mo30990a("imei").mo30995b(faVar.f13764w);
        }
        if (faVar.f13765x != null) {
            b.mo30990a(TapjoyConstants.TJC_ANDROID_ID).mo30995b(faVar.f13765x);
        }
        return b.mo30997d().toString();
    }

    /* renamed from: a */
    public static String m17389a(C5038eu euVar) {
        C4910bh c = new C4910bh().mo30996c();
        if (euVar.f13647e != null) {
            c.mo30990a(TapjoyConstants.TJC_PACKAGE_VERSION).mo30995b(euVar.f13647e);
        }
        if (euVar.f13648f != null) {
            c.mo30990a(TapjoyConstants.TJC_PACKAGE_REVISION).mo30989a((Number) euVar.f13648f);
        }
        if (euVar.f13649g != null) {
            c.mo30990a("data_ver").mo30995b(euVar.f13649g);
        }
        if (euVar.f13650h != null) {
            c.mo30990a(TapjoyConstants.TJC_INSTALLER).mo30995b(euVar.f13650h);
        }
        if (euVar.f13651i != null) {
            c.mo30990a("store").mo30995b(euVar.f13651i);
        }
        return c.mo30997d().toString();
    }

    /* renamed from: a */
    public static String m17394a(C5077fh fhVar) {
        return m17395a(fhVar, (C5041ev) null);
    }

    /* renamed from: a */
    private static String m17395a(C5077fh fhVar, C5041ev evVar) {
        String str;
        String b;
        C4910bh c = new C4910bh().mo30996c();
        if (fhVar.f13880s != null) {
            c.mo30990a(TapjoyConstants.TJC_INSTALLED).mo30989a((Number) fhVar.f13880s);
        }
        if (fhVar.f13881t != null) {
            c.mo30990a(TapjoyConstants.TJC_REFERRER).mo30995b(fhVar.f13881t);
        }
        if (fhVar.f13868G != null) {
            c.mo30990a(QumparaOfferwallUtil.COLUMN_IDFA).mo30995b(fhVar.f13868G);
            Boolean bool = fhVar.f13869H;
            if (bool != null && bool.booleanValue()) {
                c.mo30990a("idfa_optout").mo30987a(1);
            }
        } else if (!(evVar == null || (str = evVar.f13684r) == null || !C3149hc.f8780a.equals(str) || (b = C5162hn.m17387b()) == null)) {
            c.mo30990a(QumparaOfferwallUtil.COLUMN_IDFA).mo30995b(b);
            if (C5162hn.m17388c()) {
                c.mo30990a("idfa_optout").mo30987a(1);
            }
        }
        if (fhVar.f13882u != null) {
            c.mo30990a(TapjoyConstants.TJC_USER_WEEKLY_FREQUENCY).mo30987a((long) Math.max(fhVar.f13882u.intValue(), 1));
        }
        if (fhVar.f13883v != null) {
            c.mo30990a(TapjoyConstants.TJC_USER_MONTHLY_FREQUENCY).mo30987a((long) Math.max(fhVar.f13883v.intValue(), 1));
        }
        if (fhVar.f13884w.size() > 0) {
            ArrayList arrayList = new ArrayList(fhVar.f13884w.size());
            for (C5068fe feVar : fhVar.f13884w) {
                if (feVar.f13836h != null) {
                    arrayList.add(feVar.f13834f);
                }
            }
            if (!arrayList.isEmpty()) {
                c.mo30990a("push").mo30986a();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    c.mo30995b((String) it.next());
                }
                c.mo30994b();
            }
        }
        c.mo30990a("session").mo30996c();
        if (fhVar.f13885x != null) {
            c.mo30990a("total_count").mo30989a((Number) fhVar.f13885x);
        }
        if (fhVar.f13886y != null) {
            c.mo30990a("total_length").mo30989a((Number) fhVar.f13886y);
        }
        if (fhVar.f13887z != null) {
            c.mo30990a("last_at").mo30989a((Number) fhVar.f13887z);
        }
        if (fhVar.f13862A != null) {
            c.mo30990a("last_length").mo30989a((Number) fhVar.f13862A);
        }
        c.mo30997d();
        c.mo30990a("purchase").mo30996c();
        if (fhVar.f13863B != null) {
            c.mo30990a("currency").mo30995b(fhVar.f13863B);
        }
        if (fhVar.f13864C != null) {
            c.mo30990a("total_count").mo30989a((Number) fhVar.f13864C);
        }
        if (fhVar.f13865D != null) {
            c.mo30990a("total_price").mo30989a((Number) fhVar.f13865D);
        }
        if (fhVar.f13866E != null) {
            c.mo30990a("last_at").mo30989a((Number) fhVar.f13866E);
        }
        if (fhVar.f13867F != null) {
            c.mo30990a("last_price").mo30989a((Number) fhVar.f13867F);
        }
        c.mo30997d();
        if (fhVar.f13870I != null) {
            c.mo30990a("user_id").mo30995b(fhVar.f13870I);
        }
        if (fhVar.f13871J != null) {
            c.mo30990a(TapjoyConstants.TJC_USER_LEVEL).mo30989a((Number) fhVar.f13871J);
        }
        if (fhVar.f13872K != null) {
            c.mo30990a(TapjoyConstants.TJC_USER_FRIEND_COUNT).mo30989a((Number) fhVar.f13872K);
        }
        if (fhVar.f13873L != null) {
            c.mo30990a(TapjoyConstants.TJC_USER_VARIABLE_1).mo30995b(fhVar.f13873L);
        }
        if (fhVar.f13874M != null) {
            c.mo30990a(TapjoyConstants.TJC_USER_VARIABLE_2).mo30995b(fhVar.f13874M);
        }
        if (fhVar.f13875N != null) {
            c.mo30990a(TapjoyConstants.TJC_USER_VARIABLE_3).mo30995b(fhVar.f13875N);
        }
        if (fhVar.f13876O != null) {
            c.mo30990a(TapjoyConstants.TJC_USER_VARIABLE_4).mo30995b(fhVar.f13876O);
        }
        if (fhVar.f13877P != null) {
            c.mo30990a(TapjoyConstants.TJC_USER_VARIABLE_5).mo30995b(fhVar.f13877P);
        }
        if (fhVar.f13878Q.size() > 0) {
            c.mo30990a("tags").mo30991a((Collection) fhVar.f13878Q);
        }
        if (Boolean.TRUE.equals(fhVar.f13879R)) {
            c.mo30990a("push_optout").mo30987a(1);
        }
        return c.mo30997d().toString();
    }

    /* renamed from: a */
    private static String m17390a(C5041ev evVar, boolean z, boolean z2, boolean z3) {
        String str;
        C4910bh b = new C4910bh().mo30996c().mo30990a("type").mo30995b(m17392a(evVar.f13680n)).mo30990a("name").mo30995b(evVar.f13681o);
        b.mo30990a("time");
        if (evVar.f13683q != null) {
            b.mo30989a((Number) evVar.f13682p);
            b.mo30990a("systime").mo30989a((Number) evVar.f13683q);
        } else if (!C5271v.m17677c() || (str = evVar.f13684r) == null || evVar.f13685s == null || !C3149hc.f8780a.equals(str)) {
            b.mo30989a((Number) evVar.f13682p);
        } else {
            b.mo30987a(C5271v.m17673a(evVar.f13685s.longValue()));
            b.mo30990a("systime").mo30989a((Number) evVar.f13682p);
        }
        if (evVar.f13686t != null) {
            b.mo30990a("duration").mo30989a((Number) evVar.f13686t);
        }
        if (!z && evVar.f13687u != null) {
            b.mo30990a(TJAdUnitConstants.String.VIDEO_INFO).mo30988a((C4916bl) new C4917bm(m17393a(evVar.f13687u)));
        }
        if (!z2 && evVar.f13688v != null) {
            b.mo30990a(TapjoyConstants.TJC_APP_PLACEMENT).mo30988a((C4916bl) new C4917bm(m17389a(evVar.f13688v)));
        }
        if (!z3 && evVar.f13689w != null) {
            b.mo30990a(QumparaOfferwallUtil.TABLE_NAME).mo30988a((C4916bl) new C4917bm(m17395a(evVar.f13689w, evVar)));
        }
        if (evVar.f13691y != null) {
            b.mo30990a("event_seq").mo30989a((Number) evVar.f13691y);
        }
        if (evVar.f13692z != null) {
            C4910bh a = b.mo30990a("event_prev");
            C5047ex exVar = evVar.f13692z;
            C4910bh b2 = new C4910bh().mo30996c().mo30990a("type").mo30995b(m17392a(exVar.f13723e)).mo30990a("name").mo30995b(exVar.f13724f);
            if (exVar.f13725g != null) {
                b2.mo30990a("category").mo30995b(exVar.f13725g);
            }
            a.mo30988a((C4916bl) new C4917bm(b2.mo30997d().toString()));
        }
        if (evVar.f13668A != null) {
            C4910bh a2 = b.mo30990a("purchase");
            C5065fd fdVar = evVar.f13668A;
            C4910bh b3 = new C4910bh().mo30996c().mo30990a("product_id").mo30995b(fdVar.f13803h);
            if (fdVar.f13804i != null) {
                b3.mo30990a("product_quantity").mo30989a((Number) fdVar.f13804i);
            }
            if (fdVar.f13805j != null) {
                b3.mo30990a("product_price").mo30989a((Number) fdVar.f13805j);
            }
            if (fdVar.f13806k != null) {
                b3.mo30990a("product_price_currency").mo30995b(fdVar.f13806k);
            }
            if (fdVar.f13814s != null) {
                b3.mo30990a("currency_price").mo30995b(fdVar.f13814s);
            }
            if (fdVar.f13807l != null) {
                b3.mo30990a("product_type").mo30995b(fdVar.f13807l);
            }
            if (fdVar.f13808m != null) {
                b3.mo30990a("product_title").mo30995b(fdVar.f13808m);
            }
            if (fdVar.f13809n != null) {
                b3.mo30990a("product_description").mo30995b(fdVar.f13809n);
            }
            if (fdVar.f13810o != null) {
                b3.mo30990a(AppLovinEventParameters.CHECKOUT_TRANSACTION_IDENTIFIER).mo30995b(fdVar.f13810o);
            }
            if (fdVar.f13811p != null) {
                b3.mo30990a("transaction_state").mo30989a((Number) fdVar.f13811p);
            }
            if (fdVar.f13812q != null) {
                b3.mo30990a("transaction_date").mo30989a((Number) fdVar.f13812q);
            }
            if (fdVar.f13813r != null) {
                b3.mo30990a("campaign_id").mo30995b(fdVar.f13813r);
            }
            if (fdVar.f13815t != null) {
                b3.mo30990a(TransactionDetailsUtilities.RECEIPT).mo30995b(fdVar.f13815t);
            }
            if (fdVar.f13816u != null) {
                b3.mo30990a(InAppPurchaseMetaData.KEY_SIGNATURE).mo30995b(fdVar.f13816u);
            }
            a2.mo30988a((C4916bl) new C4917bm(b3.mo30997d().toString()));
        }
        if (evVar.f13669B != null) {
            b.mo30990a("exception").mo30995b(evVar.f13669B);
        }
        try {
            if (evVar.f13671D != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                if (evVar.f13670C != null) {
                    C3126bn.m10231b(evVar.f13670C).mo18479a((Map) linkedHashMap);
                }
                C5062fc fcVar = evVar.f13671D;
                if (fcVar.f13792d != null) {
                    linkedHashMap.put("fq7_change", fcVar.f13792d);
                }
                if (fcVar.f13793e != null) {
                    linkedHashMap.put("fq30_change", fcVar.f13793e);
                }
                if (fcVar.f13794f != null) {
                    linkedHashMap.put(TJAdUnitConstants.PARAM_PUSH_ID, fcVar.f13794f);
                }
                b.mo30990a("meta").mo30992a((Map) linkedHashMap);
            } else if (evVar.f13670C != null) {
                b.mo30990a("meta").mo30988a((C4916bl) new C4917bm(evVar.f13670C));
            }
        } catch (IOException unused) {
        }
        if (evVar.f13676I != null) {
            b.mo30990a(TJAdUnitConstants.String.USAGE_TRACKER_DIMENSIONS).mo30988a((C4916bl) new C4917bm(evVar.f13676I));
        }
        if (evVar.f13677J != null) {
            b.mo30990a("count").mo30989a((Number) evVar.f13677J);
        }
        if (evVar.f13678K != null) {
            b.mo30990a("first_time").mo30989a((Number) evVar.f13678K);
        }
        if (evVar.f13679L != null) {
            b.mo30990a("last_time").mo30989a((Number) evVar.f13679L);
        }
        if (evVar.f13672E != null) {
            b.mo30990a("category").mo30995b(evVar.f13672E);
        }
        if (evVar.f13673F != null) {
            b.mo30990a("p1").mo30995b(evVar.f13673F);
        }
        if (evVar.f13674G != null) {
            b.mo30990a("p2").mo30995b(evVar.f13674G);
        }
        if (evVar.f13675H.size() > 0) {
            b.mo30990a(TJAdUnitConstants.String.USAGE_TRACKER_VALUES).mo30996c();
            for (C5052ez ezVar : evVar.f13675H) {
                b.mo30990a(ezVar.f13733e).mo30989a((Number) ezVar.f13734f);
            }
            b.mo30997d();
        }
        return b.mo30997d().toString();
    }

    /* renamed from: a */
    public static String m17391a(C5044ew ewVar) {
        boolean z;
        boolean z2;
        C4910bh a = new C4910bh().mo30986a();
        C5056fa faVar = null;
        C5038eu euVar = null;
        C5077fh fhVar = null;
        for (C5041ev evVar : ewVar.f13719d) {
            boolean z3 = true;
            if (faVar == null || !faVar.equals(evVar.f13687u)) {
                faVar = evVar.f13687u;
                z = false;
            } else {
                z = true;
            }
            if (euVar == null || !euVar.equals(evVar.f13688v)) {
                euVar = evVar.f13688v;
                z2 = false;
            } else {
                z2 = true;
            }
            if (fhVar == null || !fhVar.equals(evVar.f13689w)) {
                fhVar = evVar.f13689w;
                z3 = false;
            }
            a.mo30988a((C4916bl) new C4917bm(m17390a(evVar, z, z2, z3)));
        }
        return a.mo30994b().toString();
    }

    /* renamed from: a */
    private static String m17392a(C5050ey eyVar) {
        int i = C51651.f14151a[eyVar.ordinal()];
        if (i == 1) {
            return TapjoyConstants.TJC_APP_PLACEMENT;
        }
        if (i == 2) {
            return "campaign";
        }
        if (i == 3) {
            return "custom";
        }
        if (i == 4) {
            return "usages";
        }
        throw new RuntimeException();
    }
}
