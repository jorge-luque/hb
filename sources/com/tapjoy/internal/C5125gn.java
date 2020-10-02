package com.tapjoy.internal;

import android.app.Activity;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Locale;

/* renamed from: com.tapjoy.internal.gn */
public final class C5125gn {
    /* renamed from: a */
    public static void m17284a(Activity activity) {
        C3145gz a = C3145gz.m10321a();
        if (C5139gw.m17326a((Object) activity, "onActivityStart: The given activity was null")) {
            C5139gw.m17330c("onActivityStart");
            C3123b.m10219a(activity.getApplication());
            C3123b.m10220b(activity);
            if (a.mo18555c("onActivityStart") && a.mo18558e()) {
                C5133gt.m17309b(activity);
            }
        }
    }

    /* renamed from: b */
    public static void m17289b(Activity activity) {
        C3145gz a = C3145gz.m10321a();
        if (C5139gw.m17326a((Object) activity, "onActivityStop: The given activity was null")) {
            C5139gw.m17330c("onActivityStop");
            C3123b.m10223c(activity);
            if (a.mo18555c("onActivityStop") && !C3123b.m10221b()) {
                a.f8764h.mo18609a();
            }
        }
    }

    /* renamed from: b */
    public static void m17288b() {
        C3145gz a = C3145gz.m10321a();
        if (a.mo18555c("endSession")) {
            a.f8764h.mo18609a();
        }
    }

    /* renamed from: a */
    public static void m17283a() {
        C3145gz a = C3145gz.m10321a();
        if (a.mo18555c("startSession") && a.mo18558e()) {
            C5133gt.m17309b((Activity) null);
        }
    }

    /* renamed from: a */
    public static void m17286a(String str, String str2, String str3, String str4, long j) {
        C3145gz a = C3145gz.m10321a();
        if (a.mo18557d("trackEvent") && C5139gw.m17326a((Object) str2, "trackEvent: name was null")) {
            LinkedHashMap linkedHashMap = null;
            if (j != 0) {
                linkedHashMap = C5246ju.m17611b();
                linkedHashMap.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, Long.valueOf(j));
            }
            a.f8763g.mo18542a(str, str2, str3, str4, linkedHashMap);
            C5139gw.m17325a("trackEvent category:{}, name:{}, p1:{}, p2:{}, values:{} called", str, str2, str3, str4, linkedHashMap);
        }
    }

    /* renamed from: a */
    public static void m17287a(String str, String str2, String str3, String str4, String str5, long j, String str6, long j2, String str7, long j3) {
        String str8 = str2;
        String str9 = str5;
        String str10 = str6;
        String str11 = str7;
        C3145gz a = C3145gz.m10321a();
        if (a.mo18557d("trackEvent") && C5139gw.m17326a((Object) str2, "trackEvent: name was null")) {
            LinkedHashMap b = C5246ju.m17611b();
            if (!(str9 == null || j == 0)) {
                b.put(str5, Long.valueOf(j));
            }
            if (!(str10 == null || j2 == 0)) {
                b.put(str10, Long.valueOf(j2));
            }
            if (!(str11 == null || j3 == 0)) {
                b.put(str11, Long.valueOf(j3));
            }
            if (b.isEmpty()) {
                b = null;
            }
            a.f8763g.mo18542a(str, str2, str3, str4, b);
            C5139gw.m17325a("trackEvent category:{}, name:{}, p1:{}, p2:{}, values:{} called", str, str8, str3, str4, b);
        }
    }

    /* renamed from: a */
    public static void m17285a(String str, String str2, String str3, String str4) {
        C3145gz a = C3145gz.m10321a();
        if (a.mo18555c("trackPurchase")) {
            try {
                C4994e eVar = new C4994e(str);
                String b = C5134gu.m17313b(eVar.f13557a);
                String b2 = C5134gu.m17313b(eVar.f13562f);
                if (b == null || b2 == null) {
                    C5139gw.m17324a("trackPurchase", "skuDetails", "insufficient fields");
                } else if (b2.length() != 3) {
                    C5139gw.m17324a("trackPurchase", "skuDetails", "invalid currency code");
                } else {
                    String b3 = C5134gu.m17313b(str2);
                    String b4 = C5134gu.m17313b(str3);
                    if (b3 != null) {
                        if (b4 != null) {
                            try {
                                C5055f fVar = new C5055f(b3);
                                if (C3166jq.m10436c(fVar.f13737a) || C3166jq.m10436c(fVar.f13738b) || C3166jq.m10436c(fVar.f13739c) || fVar.f13740d == 0) {
                                    C5139gw.m17324a("trackPurchase", "purchaseData", "insufficient fields");
                                }
                            } catch (IOException unused) {
                                C5139gw.m17324a("trackPurchase", "purchaseData", "invalid PurchaseData JSON");
                            }
                        } else {
                            C5139gw.m17324a("trackPurchase", "dataSignature", "is null, skipping purchase validation");
                        }
                    } else if (b4 != null) {
                        C5139gw.m17324a("trackPurchase", "purchaseData", "is null. skipping purchase validation");
                    }
                    String upperCase = b2.toUpperCase(Locale.US);
                    String b5 = C5134gu.m17313b(str4);
                    C3144gy gyVar = a.f8763g;
                    double d = (double) eVar.f13563g;
                    Double.isNaN(d);
                    gyVar.mo18540a(b, upperCase, d / 1000000.0d, b3, b4, b5);
                    if (b3 == null || b4 == null) {
                        C5139gw.m17323a("trackPurchase without purchaseData called");
                    } else {
                        C5139gw.m17323a("trackPurchase with purchaseData called");
                    }
                }
            } catch (IOException unused2) {
                C5139gw.m17324a("trackPurchase", "skuDetails", "invalid SkuDetails JSON");
            }
        }
    }
}
