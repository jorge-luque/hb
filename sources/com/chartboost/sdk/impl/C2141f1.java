package com.chartboost.sdk.impl;

import com.chartboost.sdk.Model.C2092g;
import com.chartboost.sdk.Tracking.C2098a;
import com.chartboost.sdk.impl.C2128c1;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.places.model.PlaceFields;

/* renamed from: com.chartboost.sdk.impl.f1 */
public class C2141f1 extends C2128c1 {
    public C2141f1(String str, C2098a aVar, C2092g gVar, C2156h1 h1Var, C2128c1.C2129a aVar2) {
        super("https://live.chartboost.com", str, gVar, aVar, 2, aVar2);
        this.f7440i = 1;
        m8504a(h1Var);
    }

    /* renamed from: a */
    private void m8504a(C2156h1 h1Var) {
        mo9294a("cached", (Object) AppEventsConstants.EVENT_PARAM_VALUE_NO);
        mo9294a(PlaceFields.LOCATION, (Object) h1Var.mo9362b());
        String a = h1Var.mo9361a();
        if (!a.isEmpty()) {
            mo9294a("ad_id", (Object) a);
        }
    }
}
