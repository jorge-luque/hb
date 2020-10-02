package admost.sdk.networkadapter;

import admost.sdk.base.AdMost;
import admost.sdk.base.AdMostAdNetwork;
import android.util.Log;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.api.SkuDetailsParams;
import com.android.billingclient.api.SkuDetailsResponseListener;
import java.util.ArrayList;
import java.util.List;

public class AdMostGoogleBillingAdapter {
    /* access modifiers changed from: private */
    public BillingClient billingClient;
    /* access modifiers changed from: private */
    public ArrayList<Purchase> purchases = new ArrayList<>();

    /* access modifiers changed from: private */
    public void querySkuDeatils(List<String> list) {
        SkuDetailsParams.Builder newBuilder = SkuDetailsParams.newBuilder();
        newBuilder.setSkusList(list).setType("subs");
        this.billingClient.querySkuDetailsAsync(newBuilder.build(), new SkuDetailsResponseListener() {
            public void onSkuDetailsResponse(BillingResult billingResult, List<SkuDetails> list) {
                if (list != null && list.size() > 0) {
                    for (int i = 0; i < AdMostGoogleBillingAdapter.this.purchases.size(); i++) {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (((Purchase) AdMostGoogleBillingAdapter.this.purchases.get(i)).getSku().equals(list.get(i2).getSku())) {
                                AdMost.getInstance().trackIAP(((Purchase) AdMostGoogleBillingAdapter.this.purchases.get(i)).getOriginalJson(), ((Purchase) AdMostGoogleBillingAdapter.this.purchases.get(i)).getSignature(), list.get(i2).getOriginalJson(), (String[]) null, false);
                                break;
                            } else {
                                i2++;
                            }
                        }
                    }
                }
            }
        });
    }

    public void connect() {
        BillingClient build = BillingClient.newBuilder(AdMost.getInstance().getActivity()).enablePendingPurchases().setListener(new PurchasesUpdatedListener() {
            public void onPurchasesUpdated(BillingResult billingResult, List<Purchase> list) {
            }
        }).build();
        this.billingClient = build;
        build.startConnection(new BillingClientStateListener() {
            public void onBillingServiceDisconnected() {
                Log.e(AdMostAdNetwork.ADMOST, "Billing Client could not be connected");
            }

            public void onBillingSetupFinished(BillingResult billingResult) {
                Purchase.PurchasesResult queryPurchases;
                "Billing Client Response : " + billingResult.getResponseCode();
                if (billingResult.getResponseCode() == 0 && (queryPurchases = AdMostGoogleBillingAdapter.this.billingClient.queryPurchases("subs")) != null && queryPurchases.getPurchasesList() != null && queryPurchases.getPurchasesList().size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < queryPurchases.getPurchasesList().size(); i++) {
                        Purchase purchase = (Purchase) queryPurchases.getPurchasesList().get(i);
                        if (purchase.getPurchaseState() == 1) {
                            AdMostGoogleBillingAdapter.this.purchases.add(purchase);
                            if (!arrayList.contains(purchase.getSku())) {
                                arrayList.add(purchase.getSku());
                            }
                        } else {
                            "Billing Client - Subscription status is not suitable !!! - State : " + purchase.getPurchaseState();
                        }
                    }
                    if (arrayList.size() > 0) {
                        AdMostGoogleBillingAdapter.this.querySkuDeatils(arrayList);
                    }
                }
            }
        });
    }
}
