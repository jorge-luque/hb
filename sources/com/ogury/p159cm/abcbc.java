package com.ogury.p159cm;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.applovin.sdk.AppLovinEventTypes;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;

/* renamed from: com.ogury.cm.abcbc */
public final class abcbc implements abcba {

    /* renamed from: a */
    public static final abcbc f12099a = new abcbc();

    /* renamed from: b */
    private static abcba f12100b = abcab.f12094a.mo29493a();

    private abcbc() {
    }

    /* renamed from: a */
    public static void m15166a() {
        Log.w("FairChoice", "FairChoice not available, switching to default implementation");
        abcab abcab = abcab.f12094a;
        abcab.m15161b();
        f12100b = abcab.f12094a.mo29493a();
    }

    public final void activateProduct(acaaa acaaa) {
        accbb.m15218b(acaaa, AppLovinEventTypes.USER_VIEWED_PRODUCT);
        f12100b.activateProduct(acaaa);
    }

    public final void endDataSourceConnections() {
        f12100b.endDataSourceConnections();
    }

    public final boolean isBillingDisabled() {
        return f12100b.isBillingDisabled();
    }

    public final boolean isProductActivated() {
        return f12100b.isProductActivated();
    }

    public final void launchBillingFlow(Activity activity) {
        accbb.m15218b(activity, "activity");
        f12100b.launchBillingFlow(activity);
    }

    public final void queryProductDetails() {
        f12100b.queryProductDetails();
    }

    public final void queryPurchase(acaac acaac) {
        accbb.m15218b(acaac, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        f12100b.queryPurchase(acaac);
    }

    public final void setBillingFinishedListener(abcac abcac) {
        f12100b.setBillingFinishedListener(abcac);
    }

    public final void setQueryProductDetailsListener(acaab acaab) {
        f12100b.setQueryProductDetailsListener(acaab);
    }

    public final void startDataSourceConnections(Context context) {
        accbb.m15218b(context, "context");
        f12100b.startDataSourceConnections(context);
    }

    public final boolean tokenExistsForActiveProduct() {
        return f12100b.tokenExistsForActiveProduct();
    }
}
