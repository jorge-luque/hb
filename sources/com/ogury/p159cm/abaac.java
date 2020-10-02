package com.ogury.p159cm;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.facebook.appevents.AppEventsConstants;
import com.tapjoy.TapjoyAuctionFlags;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.ogury.cm.abaac */
public final class abaac extends abaaa {

    /* renamed from: b */
    public static final aaaaa f12047b = new aaaaa((baaca) null);

    /* renamed from: com.ogury.cm.abaac$aaaaa */
    public static final class aaaaa {
        private aaaaa() {
        }

        public /* synthetic */ aaaaa(baaca baaca) {
            this();
        }
    }

    /* renamed from: com.ogury.cm.abaac$aaaab */
    static final class aaaab extends accbc implements accab<acbba> {

        /* renamed from: a */
        final /* synthetic */ abaac f12048a;

        /* renamed from: b */
        final /* synthetic */ Context f12049b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        aaaab(abaac abaac, Context context) {
            super(0);
            this.f12048a = abaac;
            this.f12049b = context;
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo29404a() {
            JSONObject l = abaac.m15054a().mo29460l();
            if (l != null) {
                SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.f12049b.getApplicationContext()).edit();
                abaac abaac = this.f12048a;
                accbb.m15215a((Object) edit, "editor");
                String optString = l.optString("vendorConsents");
                accbb.m15215a((Object) optString, "it.optString(VENDOR_CONSENTS)");
                abaac.m15056a(abaac, edit, optString);
                abaac.m15057a(this.f12048a, edit, l.optJSONObject("publisherRestrictions"));
                abaac abaac2 = this.f12048a;
                String optString2 = l.optString("vendorLegitimateInterests");
                accbb.m15215a((Object) optString2, "it.optString(VENDOR_LEGITIMATE_INTERESTS)");
                abaac.m15059b(abaac2, edit, optString2);
                aabbc aabbc = aabbc.f12011a;
                edit.putString("IABTCF_PublisherConsent", aabbc.m15001a(l.optInt("publisherConsent")));
                edit.putInt("IABTCF_CmpSdkID", l.optInt("cmpSdkId"));
                edit.putInt("IABTCF_CmpSdkVersion", l.optInt("cmpSdkVersion"));
                edit.putInt("IABTCF_PolicyVersion", l.optInt("policyVersion"));
                aacca aacca = aacca.f12035a;
                edit.putInt("IABTCF_gdprApplies", aacca.m15034b().mo29437d() ? 1 : 0);
                edit.putString("IABTCF_PublisherCC", l.optString("publisherCC"));
                edit.putInt("IABTCF_PurposeOneTreatment", l.optInt("purposeOneTreatment"));
                edit.putInt("IABTCF_UseNonStandardStacks", l.optInt("useNonStandardStacks"));
                aacca aacca2 = aacca.f12035a;
                edit.putString("IABTCF_TCString", aacca.m15034b().mo29434b());
                aabbc aabbc2 = aabbc.f12011a;
                edit.putString("IABTCF_PurposeConsents", aabbc.m15001a(l.optInt("purposeConsents")));
                aabbc aabbc3 = aabbc.f12011a;
                edit.putString("IABTCF_PurposeLegitimateInterests", aabbc.m15001a(l.optInt("purposeLegitimateInterests")));
                aabbc aabbc4 = aabbc.f12011a;
                edit.putString("IABTCF_SpecialFeaturesOptIns", aabbc.m15001a(l.optInt("specialFeaturesOptIns")));
                aabbc aabbc5 = aabbc.f12011a;
                edit.putString("IABTCF_PublisherLegitimateInterests", aabbc.m15001a(l.optInt("publisherLegitimateInterests")));
                aabbc aabbc6 = aabbc.f12011a;
                edit.putString("IABTCF_PublisherCustomPurposesConsents", aabbc.m15001a(l.optInt("publisherCustomPurposesConsents")));
                aabbc aabbc7 = aabbc.f12011a;
                edit.putString("IABTCF_PublisherCustomPurposesLegitimateInterests", aabbc.m15001a(l.optInt("publisherCustomPurposesLegitimateInterests")));
                edit.apply();
            }
            return acbba.f12137a;
        }
    }

    /* renamed from: a */
    public static ababc m15054a() {
        aacca aacca = aacca.f12035a;
        return (ababc) ababa.m15062f();
    }

    /* renamed from: a */
    private static String m15055a(String str) {
        if (str != null) {
            String substring = str.substring(1);
            accbb.m15215a((Object) substring, "(this as java.lang.String).substring(startIndex)");
            return substring;
        }
        throw new acbab("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: a */
    public static final /* synthetic */ void m15056a(abaac abaac, SharedPreferences.Editor editor, String str) {
        aabbc aabbc = aabbc.f12011a;
        String a = aabbc.m15002a(str);
        editor.putString("IABTCF_VendorConsents", a.length() > 0 ? m15055a(a) : m15058b());
    }

    /* renamed from: a */
    public static final /* synthetic */ void m15057a(abaac abaac, SharedPreferences.Editor editor, JSONObject jSONObject) {
        if (jSONObject != null) {
            aabbc aabbc = aabbc.f12011a;
            accbb.m15218b(jSONObject, "jsonObject");
            HashMap hashMap = new HashMap();
            Iterator<String> keys = jSONObject.keys();
            accbb.m15215a((Object) keys, "purposeIds");
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                String optString = optJSONObject.optString(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                accbb.m15215a((Object) optString, "arrayOfValuesForPurpose.optString(\"0\")");
                String a = aabbc.m15002a(optString);
                int length = a.length();
                String optString2 = optJSONObject.optString("1");
                accbb.m15215a((Object) optString2, "arrayOfValuesForPurpose.optString(\"1\")");
                String a2 = aabbc.m15002a(optString2);
                if (a2.length() > length) {
                    length = a2.length();
                }
                String optString3 = optJSONObject.optString(TapjoyAuctionFlags.AUCTION_TYPE_SECOND_PRICE);
                accbb.m15215a((Object) optString3, "arrayOfValuesForPurpose.optString(\"2\")");
                String a3 = aabbc.m15002a(optString3);
                if (a3.length() > length) {
                    length = a3.length();
                }
                int i = 1;
                String str = "";
                while (i < length) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append((a.length() <= i || a.charAt(i) != '1') ? (a2.length() <= i || a2.charAt(i) != '1') ? (a3.length() <= i || a3.charAt(i) != '1') ? "3" : TapjoyAuctionFlags.AUCTION_TYPE_SECOND_PRICE : "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    str = sb.toString();
                    i++;
                }
                accbb.m15215a((Object) next, "purposeId");
                hashMap.put(next, str);
            }
            for (String str2 : hashMap.keySet()) {
                editor.putString("IABTCF_PublisherRestrictions".concat(String.valueOf(str2)), (String) hashMap.get(str2));
            }
        }
    }

    /* renamed from: b */
    private static String m15058b() {
        int n = m15054a().mo29462n();
        accbb.m15218b(AppEventsConstants.EVENT_PARAM_VALUE_NO, "receiver$0");
        int i = 1;
        if (!(n >= 0)) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + n + '.').toString());
        } else if (n == 0) {
            return "";
        } else {
            if (n == 1) {
                return AppEventsConstants.EVENT_PARAM_VALUE_NO.toString();
            }
            int length = AppEventsConstants.EVENT_PARAM_VALUE_NO.length();
            if (length == 0) {
                return "";
            }
            if (length != 1) {
                StringBuilder sb = new StringBuilder(AppEventsConstants.EVENT_PARAM_VALUE_NO.length() * n);
                if (n > 0) {
                    while (true) {
                        sb.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                        if (i == n) {
                            break;
                        }
                        i++;
                    }
                }
                String sb2 = sb.toString();
                accbb.m15215a((Object) sb2, "sb.toString()");
                return sb2;
            }
            char charAt = AppEventsConstants.EVENT_PARAM_VALUE_NO.charAt(0);
            char[] cArr = new char[n];
            for (int i2 = 0; i2 < n; i2++) {
                cArr[i2] = charAt;
            }
            return new String(cArr);
        }
    }

    /* renamed from: b */
    public static final /* synthetic */ void m15059b(abaac abaac, SharedPreferences.Editor editor, String str) {
        aabbc aabbc = aabbc.f12011a;
        String a = aabbc.m15002a(str);
        editor.putString("IABTCF_VendorLegitimateInterests", (!(a.length() > 0) || a.length() <= 1) ? m15058b() : m15055a(a));
    }

    /* renamed from: a */
    public final void mo29429a(Context context) {
        accbb.m15218b(context, "context");
        acbca.m15204a(false, false, (ClassLoader) null, (String) null, 0, new aaaab(this, context), 31, (Object) null);
    }
}
