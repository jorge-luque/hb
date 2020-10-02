package com.ogury.p159cm;

import com.ogury.p159cm.ConsentActivity;
import com.tapjoy.TJAdUnitConstants;
import org.json.JSONObject;

/* renamed from: com.ogury.cm.abbbc */
public final class abbbc extends abbba {

    /* renamed from: b */
    public static final aaaaa f12085b = new aaaaa((baaca) null);

    /* renamed from: c */
    private String f12086c = "userConsent";

    /* renamed from: com.ogury.cm.abbbc$aaaaa */
    public static final class aaaaa {
        private aaaaa() {
        }

        public /* synthetic */ aaaaa(baaca baaca) {
            this();
        }
    }

    /* renamed from: a */
    public final String mo29479a() {
        return this.f12086c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo29481a(JSONObject jSONObject) {
        boolean a = super.mo29481a(jSONObject);
        if (a) {
            aacca aacca = aacca.f12035a;
            ababc ababc = (ababc) ababa.m15062f();
            if (jSONObject == null) {
                accbb.m15214a();
            }
            ababc.mo29448a(jSONObject.optJSONObject("iabResponse"));
            JSONObject optJSONObject = jSONObject.optJSONObject("response");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject(this.f12086c);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("sdk");
            accbb.m15215a((Object) optJSONObject3, "jsonResponse.optJSONObject(SDK)");
            JSONObject optJSONObject4 = optJSONObject3.optJSONObject("unifiedVendors");
            accbb.m15215a((Object) optJSONObject4, "sdkObject.optJSONObject(UNIFIED_VENDORS)");
            ababc.mo29433a(optJSONObject.optBoolean("hasPaid"));
            ababc.mo29447a(optJSONObject2.optInt("purposes"));
            ababc.mo29453c(optJSONObject2.optInt("specialFeatures"));
            String optString = optJSONObject2.optString(TJAdUnitConstants.String.VENDORS, "");
            accbb.m15215a((Object) optString, "userConsent.optString(VENDORS, \"\")");
            Object[] array = ConsentActivity.aaaaa.m14881a(ConsentActivity.aaaaa.m14884b(optString)).toArray(new Integer[0]);
            if (array != null) {
                ababc.mo29449a((Integer[]) array);
                String optString2 = optJSONObject2.optString("vendorsLI", "");
                accbb.m15215a((Object) optString2, "userConsent.optString(VENDORS_LI, \"\")");
                Object[] array2 = ConsentActivity.aaaaa.m14881a(ConsentActivity.aaaaa.m14884b(optString2)).toArray(new Integer[0]);
                if (array2 != null) {
                    ababc.mo29452b((Integer[]) array2);
                    ababc.mo29450b(optJSONObject2.optInt("purposesLI"));
                    ababc.mo29451b(optJSONObject4.optJSONObject(TJAdUnitConstants.String.VENDORS));
                    ababc.mo29454d(optJSONObject2.optInt("maxVendorId"));
                    String optString3 = optJSONObject.optString("iabString", "");
                    accbb.m15215a((Object) optString3, "responseObject.optString(IAB_STRING, \"\")");
                    ababc.mo29432a(optString3);
                } else {
                    throw new acbab("null cannot be cast to non-null type kotlin.Array<T>");
                }
            } else {
                throw new acbab("null cannot be cast to non-null type kotlin.Array<T>");
            }
        }
        return a;
    }
}
