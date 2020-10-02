package com.ogury.p159cm;

import android.util.Log;
import com.applovin.sdk.AppLovinEventParameters;

/* renamed from: com.ogury.cm.acaaa */
public final class acaaa {

    /* renamed from: a */
    private String f12126a = "";

    /* renamed from: b */
    private final String f12127b;

    public acaaa(String str, String str2) {
        accbb.m15218b(str, AppLovinEventParameters.PRODUCT_IDENTIFIER);
        accbb.m15218b(str2, "skuType");
        this.f12127b = str;
        int hashCode = str2.hashCode();
        if (hashCode != 505523517) {
            if (hashCode == 1741942868 && str2.equals("OneTimePurchase")) {
                this.f12126a = "inapp";
                return;
            }
        } else if (str2.equals("Subscription")) {
            this.f12126a = "subs";
            return;
        }
        Log.e("FairChoice", "Illegal SKU type");
    }

    /* renamed from: a */
    public final String mo29513a() {
        return this.f12126a;
    }

    /* renamed from: b */
    public final String mo29514b() {
        return this.f12127b;
    }
}
