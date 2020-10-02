package com.ogury.p159cm;

import android.app.Activity;
import android.content.Context;
import com.applovin.sdk.AppLovinEventTypes;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;

/* renamed from: com.ogury.cm.abccc */
public final class abccc implements abcba {

    /* renamed from: a */
    private acaab f12125a;

    public final void activateProduct(acaaa acaaa) {
        accbb.m15218b(acaaa, AppLovinEventTypes.USER_VIEWED_PRODUCT);
    }

    public final void endDataSourceConnections() {
    }

    public final boolean isBillingDisabled() {
        return true;
    }

    public final boolean isProductActivated() {
        return false;
    }

    public final void launchBillingFlow(Activity activity) {
        accbb.m15218b(activity, "activity");
    }

    public final void queryProductDetails() {
        acaab acaab = this.f12125a;
        if (acaab != null) {
            acaab.mo29424a("ok", "");
        }
    }

    public final void queryPurchase(acaac acaac) {
        accbb.m15218b(acaac, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        acaac.mo29400a();
    }

    public final void setBillingFinishedListener(abcac abcac) {
    }

    public final void setQueryProductDetailsListener(acaab acaab) {
        this.f12125a = acaab;
        if (acaab != null) {
            acaab.mo29424a("ok", "");
        }
    }

    public final void startDataSourceConnections(Context context) {
        accbb.m15218b(context, "context");
        abcab abcab = abcab.f12094a;
        abcab.m15160a(context);
    }

    public final boolean tokenExistsForActiveProduct() {
        return false;
    }
}
