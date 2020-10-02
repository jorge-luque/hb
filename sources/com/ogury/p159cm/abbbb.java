package com.ogury.p159cm;

import org.json.JSONObject;

/* renamed from: com.ogury.cm.abbbb */
public final class abbbb extends abbba {

    /* renamed from: b */
    public static final aaaaa f12083b = new aaaaa((baaca) null);

    /* renamed from: c */
    private String f12084c = "response";

    /* renamed from: com.ogury.cm.abbbb$aaaaa */
    public static final class aaaaa {
        private aaaaa() {
        }

        public /* synthetic */ aaaaa(baaca baaca) {
            this();
        }
    }

    /* renamed from: a */
    public final String mo29479a() {
        return this.f12084c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo29481a(JSONObject jSONObject) {
        boolean a = super.mo29481a(jSONObject);
        if (a) {
            aacca aacca = aacca.f12035a;
            ababb ababb = (ababb) ababa.m15062f();
            if (jSONObject == null) {
                accbb.m15214a();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("response").optJSONObject(this.f12084c);
            ababb.mo29433a(optJSONObject.optBoolean("hasPaid"));
            String optString = optJSONObject.optString("purposes", "");
            accbb.m15215a((Object) optString, "consentResponse.optString(PURPOSES, \"\")");
            ababb.mo29441d(optString);
            String optString2 = optJSONObject.optString("specialFeatures", "");
            accbb.m15215a((Object) optString2, "consentResponse.optString(SPECIAL_FEATURES, \"\")");
            ababb.mo29442e(optString2);
            String optString3 = optJSONObject.optString("acceptedVendors", "");
            accbb.m15215a((Object) optString3, "consentResponse.optString(ACCEPTED_VENDORS, \"\")");
            ababb.mo29439b(optString3);
            String optString4 = optJSONObject.optString("refusedVendors", "");
            accbb.m15215a((Object) optString4, "consentResponse.optString(REFUSED_VENDORS, \"\")");
            ababb.mo29440c(optString4);
            String optString5 = optJSONObject.optString("iabString", "");
            accbb.m15215a((Object) optString5, "consentResponse.optString(IAB_STRING, \"\")");
            ababb.mo29432a(optString5);
        }
        return a;
    }
}
