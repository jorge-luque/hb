package com.ogury.p159cm;

import android.app.Activity;
import android.content.Context;

/* renamed from: com.ogury.cm.abcba */
public interface abcba {
    void activateProduct(acaaa acaaa);

    void endDataSourceConnections();

    boolean isBillingDisabled();

    boolean isProductActivated();

    void launchBillingFlow(Activity activity);

    void queryProductDetails();

    void queryPurchase(acaac acaac);

    void setBillingFinishedListener(abcac abcac);

    void setQueryProductDetailsListener(acaab acaab);

    void startDataSourceConnections(Context context);

    boolean tokenExistsForActiveProduct();
}
