package com.ogury.p159cm;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.api.SkuDetailsParams;
import com.android.billingclient.api.SkuDetailsResponseListener;
import com.applovin.sdk.AppLovinEventTypes;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vungle.warren.AdLoader;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ogury.cm.abcca */
public final class abcca implements BillingClientStateListener, PurchasesUpdatedListener, SkuDetailsResponseListener, abcba {

    /* renamed from: a */
    private acaaa f12101a;

    /* renamed from: b */
    private acaba f12102b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public acaac f12103c;

    /* renamed from: d */
    private acaab f12104d;

    /* renamed from: e */
    private abcac f12105e;

    /* renamed from: f */
    private int f12106f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public volatile boolean f12107g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public abccb f12108h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public BillingClient f12109i;

    /* renamed from: com.ogury.cm.abcca$aaaaa */
    static final class aaaaa {

        /* renamed from: a */
        public static final aaaaa f12110a = new aaaaa();

        /* renamed from: b */
        private static AtomicInteger f12111b = new AtomicInteger(1);

        /* renamed from: com.ogury.cm.abcca$aaaaa$aaaaa  reason: collision with other inner class name */
        static final class C6850aaaaa implements Runnable {

            /* renamed from: a */
            final /* synthetic */ accab f12112a;

            C6850aaaaa(accab accab) {
                this.f12112a = accab;
            }

            public final void run() {
                this.f12112a.mo29404a();
            }
        }

        /* renamed from: com.ogury.cm.abcca$aaaaa$aaaab */
        static final class aaaab implements Runnable {

            /* renamed from: a */
            final /* synthetic */ accab f12113a;

            aaaab(accab accab) {
                this.f12113a = accab;
            }

            public final void run() {
                this.f12113a.mo29404a();
            }
        }

        private aaaaa() {
        }

        /* renamed from: a */
        public static void m15170a() {
            f12111b.set(1);
        }

        /* renamed from: a */
        public static void m15171a(BillingClient billingClient, abcca abcca, accab<acbba> accab) {
            accbb.m15218b(billingClient, "billingClient");
            accbb.m15218b(abcca, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            accbb.m15218b(accab, "task");
            if (billingClient.isReady()) {
                accab.mo29404a();
                return;
            }
            billingClient.startConnection((BillingClientStateListener) abcca);
            new Handler(Looper.getMainLooper()).postDelayed(new aaaab(accab), AdLoader.RETRY_DELAY);
        }

        /* renamed from: a */
        public static void m15172a(accab<acbba> accab) {
            accbb.m15218b(accab, "block");
            int andIncrement = f12111b.getAndIncrement();
            if (andIncrement < 5) {
                new Handler(Looper.getMainLooper()).postDelayed(new C6850aaaaa(accab), (long) (((float) Math.pow(2.0d, (double) andIncrement)) * 500.0f));
            }
        }
    }

    /* renamed from: com.ogury.cm.abcca$aaaab */
    static final class aaaab extends accbc implements accab<acbba> {

        /* renamed from: a */
        final /* synthetic */ abcca f12114a;

        /* renamed from: b */
        final /* synthetic */ Activity f12115b;

        /* renamed from: c */
        final /* synthetic */ BillingFlowParams f12116c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        aaaab(abcca abcca, Activity activity, BillingFlowParams billingFlowParams) {
            super(0);
            this.f12114a = abcca;
            this.f12115b = activity;
            this.f12116c = billingFlowParams;
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo29404a() {
            abcca.access$getPlayStoreBillingClient$p(this.f12114a).launchBillingFlow(this.f12115b, this.f12116c);
            return acbba.f12137a;
        }
    }

    /* renamed from: com.ogury.cm.abcca$aaaac */
    static final class aaaac extends accbc implements accab<acbba> {

        /* renamed from: a */
        final /* synthetic */ abcca f12117a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        aaaac(abcca abcca) {
            super(0);
            this.f12117a = abcca;
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo29404a() {
            boolean unused = this.f12117a.m15169b();
            return acbba.f12137a;
        }
    }

    /* renamed from: com.ogury.cm.abcca$aaaba */
    static final class aaaba extends accbc implements accab<acbba> {

        /* renamed from: a */
        final /* synthetic */ abcca f12118a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        aaaba(abcca abcca) {
            super(0);
            this.f12118a = abcca;
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo29404a() {
            mo29512b();
            return acbba.f12137a;
        }

        /* renamed from: b */
        public final void mo29512b() {
            List purchasesList;
            List purchasesList2;
            this.f12118a.f12107g = false;
            HashSet hashSet = new HashSet();
            Purchase.PurchasesResult queryPurchases = abcca.access$getPlayStoreBillingClient$p(this.f12118a).queryPurchases("inapp");
            StringBuilder sb = new StringBuilder("queryPurchases INAPP results: ");
            List list = null;
            sb.append(queryPurchases != null ? queryPurchases.getPurchasesList() : null);
            sb.toString();
            if (!(queryPurchases == null || (purchasesList2 = queryPurchases.getPurchasesList()) == null)) {
                hashSet.addAll(purchasesList2);
            }
            if (abcca.access$isSubscriptionSupported(this.f12118a)) {
                Purchase.PurchasesResult queryPurchases2 = abcca.access$getPlayStoreBillingClient$p(this.f12118a).queryPurchases("subs");
                if (!(queryPurchases2 == null || (purchasesList = queryPurchases2.getPurchasesList()) == null)) {
                    hashSet.addAll(purchasesList);
                }
                StringBuilder sb2 = new StringBuilder("queryPurchases SUBS results: ");
                if (queryPurchases2 != null) {
                    list = queryPurchases2.getPurchasesList();
                }
                sb2.append(list);
                sb2.toString();
            }
            abcca.access$getSharedPreferences$p(this.f12118a);
            abccb.m15182a((HashSet<Purchase>) hashSet);
            acaac access$getPurchaseQueryListener$p = this.f12118a.f12103c;
            if (access$getPurchaseQueryListener$p != null) {
                access$getPurchaseQueryListener$p.mo29400a();
            }
        }
    }

    /* renamed from: com.ogury.cm.abcca$aaabb */
    static final class aaabb extends accbc implements accab<acbba> {

        /* renamed from: a */
        final /* synthetic */ aaaba f12119a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        aaabb(aaaba aaaba) {
            super(0);
            this.f12119a = aaaba;
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo29404a() {
            this.f12119a.mo29512b();
            return acbba.f12137a;
        }
    }

    /* renamed from: com.ogury.cm.abcca$aaabc */
    static final class aaabc extends accbc implements accab<acbba> {

        /* renamed from: a */
        final /* synthetic */ abcca f12120a;

        /* renamed from: b */
        final /* synthetic */ String f12121b;

        /* renamed from: c */
        final /* synthetic */ SkuDetailsParams.Builder f12122c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        aaabc(abcca abcca, String str, SkuDetailsParams.Builder builder) {
            super(0);
            this.f12120a = abcca;
            this.f12121b = str;
            this.f12122c = builder;
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo29404a() {
            "querySkuDetailsAsync for " + this.f12121b;
            abcca.access$getPlayStoreBillingClient$p(this.f12120a).querySkuDetailsAsync(this.f12122c.build(), this.f12120a);
            return acbba.f12137a;
        }
    }

    /* renamed from: a */
    private static String m15167a(SkuDetails skuDetails) {
        JSONObject jSONObject = new JSONObject();
        if (skuDetails != null) {
            try {
                jSONObject = new JSONObject(skuDetails.getOriginalJson());
            } catch (Exception e) {
                Log.w("FairChoice", "Error while parsing skuDetailsJson: ".concat(String.valueOf(e)));
            }
            jSONObject.remove("skuDetailsToken");
            jSONObject.remove("rewardToken");
        }
        String jSONObject2 = jSONObject.toString();
        accbb.m15215a((Object) jSONObject2, "billingJson.toString()");
        return jSONObject2;
    }

    /* renamed from: a */
    private final void m15168a() {
        aaaba aaaba2 = new aaaba(this);
        aaaaa aaaaa2 = aaaaa.f12110a;
        BillingClient billingClient = this.f12109i;
        if (billingClient == null) {
            accbb.m15216a("playStoreBillingClient");
        }
        aaaaa.m15171a(billingClient, this, new aaabb(aaaba2));
    }

    public static final /* synthetic */ BillingClient access$getPlayStoreBillingClient$p(abcca abcca) {
        BillingClient billingClient = abcca.f12109i;
        if (billingClient == null) {
            accbb.m15216a("playStoreBillingClient");
        }
        return billingClient;
    }

    public static final /* synthetic */ abccb access$getSharedPreferences$p(abcca abcca) {
        abccb abccb = abcca.f12108h;
        if (abccb == null) {
            accbb.m15216a("sharedPreferences");
        }
        return abccb;
    }

    public static final /* synthetic */ boolean access$isSubscriptionSupported(abcca abcca) {
        BillingClient billingClient = abcca.f12109i;
        if (billingClient == null) {
            accbb.m15216a("playStoreBillingClient");
        }
        BillingResult isFeatureSupported = billingClient.isFeatureSupported("subscriptions");
        accbb.m15215a((Object) isFeatureSupported, "playStoreBillingClient.i…eatureType.SUBSCRIPTIONS)");
        int responseCode = isFeatureSupported.getResponseCode();
        if (responseCode != 0) {
            Log.w("FairChoice", "isSubscriptionSupported() got an error response: ".concat(String.valueOf(responseCode)));
        }
        return responseCode == 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final boolean m15169b() {
        BillingClient billingClient = this.f12109i;
        if (billingClient == null) {
            accbb.m15216a("playStoreBillingClient");
        }
        if (billingClient.isReady()) {
            return false;
        }
        BillingClient billingClient2 = this.f12109i;
        if (billingClient2 == null) {
            accbb.m15216a("playStoreBillingClient");
        }
        billingClient2.startConnection((BillingClientStateListener) this);
        return true;
    }

    public final void activateProduct(acaaa acaaa) {
        accbb.m15218b(acaaa, AppLovinEventTypes.USER_VIEWED_PRODUCT);
        this.f12101a = acaaa;
        if (this.f12108h == null) {
            accbb.m15216a("sharedPreferences");
        }
        abccb.m15181a(acaaa);
    }

    public final void endDataSourceConnections() {
        BillingClient billingClient = this.f12109i;
        if (billingClient == null) {
            accbb.m15216a("playStoreBillingClient");
        }
        billingClient.endConnection();
    }

    public final boolean isBillingDisabled() {
        return false;
    }

    public final boolean isProductActivated() {
        return this.f12101a != null;
    }

    public final void launchBillingFlow(Activity activity) {
        accbb.m15218b(activity, "activity");
        BillingFlowParams.Builder newBuilder = BillingFlowParams.newBuilder();
        acaba acaba = this.f12102b;
        BillingFlowParams build = newBuilder.setSkuDetails(acaba != null ? acaba.mo29516b() : null).build();
        aaaaa aaaaa2 = aaaaa.f12110a;
        BillingClient billingClient = this.f12109i;
        if (billingClient == null) {
            accbb.m15216a("playStoreBillingClient");
        }
        aaaaa.m15171a(billingClient, this, new aaaab(this, activity, build));
    }

    public final void onBillingServiceDisconnected() {
        aaaaa aaaaa2 = aaaaa.f12110a;
        aaaaa.m15172a(new aaaac(this));
    }

    public final void onBillingSetupFinished(BillingResult billingResult) {
        accbb.m15218b(billingResult, "billingResult");
        int responseCode = billingResult.getResponseCode();
        if (responseCode == 0) {
            aaaaa aaaaa2 = aaaaa.f12110a;
            aaaaa.m15170a();
            if (this.f12107g) {
                m15168a();
                return;
            }
            return;
        }
        if (responseCode == 3) {
            abcbc abcbc = abcbc.f12099a;
            abcbc.m15166a();
        }
        abcbb abcbb = abcbb.f12098a;
        "onBillingSetupFinished with failure response code: ".concat(String.valueOf(abcbb.m15165a(responseCode)));
        this.f12106f = responseCode;
        acaac acaac = this.f12103c;
        if (acaac != null) {
            acaac.mo29400a();
        }
    }

    public final void onPurchasesUpdated(BillingResult billingResult, List<Purchase> list) {
        accbb.m15218b(billingResult, "billingResult");
        int responseCode = billingResult.getResponseCode();
        String str = null;
        if (responseCode != 0) {
            if (responseCode == 5) {
                Log.e("FairChoice", "Your app's configuration is incorrect. Review in the Google PlayConsole. Possible causes of this error include: APK is not signed with release key; SKU productId mismatch.");
            } else if (responseCode != 7) {
                StringBuilder sb = new StringBuilder("BillingClient.BillingResponse error code:");
                abcbb abcbb = abcbb.f12098a;
                sb.append(abcbb.m15165a(responseCode));
                sb.toString();
            }
        } else if (list != null) {
            String str2 = null;
            for (Purchase purchase : list) {
                if (purchase.getPurchaseState() == 1) {
                    String sku = purchase.getSku();
                    acaaa acaaa = this.f12101a;
                    if (accbb.m15217a((Object) sku, (Object) acaaa != null ? acaaa.mo29514b() : null)) {
                        str2 = purchase.getPurchaseToken();
                    }
                } else if (purchase.getPurchaseState() == 2) {
                    "Received a pending purchase of SKU: " + purchase.getSku();
                }
            }
            str = str2;
        }
        abcac abcac = this.f12105e;
        if (abcac != null) {
            JSONObject jSONObject = new JSONObject();
            if (responseCode == 0) {
                jSONObject.put("paid", true);
                jSONObject.put("token", str);
            } else {
                jSONObject.put("paid", false);
                abcbb abcbb2 = abcbb.f12098a;
                jSONObject.put("errorMessage", abcbb.m15165a(responseCode));
            }
            String jSONObject2 = jSONObject.toString();
            accbb.m15215a((Object) jSONObject2, "json.toString()");
            abcac.mo29426a(jSONObject2);
        }
    }

    public final void onSkuDetailsResponse(BillingResult billingResult, List<SkuDetails> list) {
        acaab acaab;
        String str;
        accbb.m15218b(billingResult, "billingResult");
        int responseCode = billingResult.getResponseCode();
        if (responseCode != 0) {
            int i = this.f12106f;
            if (i != 0) {
                abcbb abcbb = abcbb.f12098a;
                str = abcbb.m15165a(i);
            } else {
                abcbb abcbb2 = abcbb.f12098a;
                str = abcbb.m15165a(responseCode);
            }
            this.f12106f = 0;
            Log.w("FairChoice", "SkuDetails query failed with response: ".concat(String.valueOf(str)));
            acaab acaab2 = this.f12104d;
            if (acaab2 != null) {
                acaab2.mo29424a(str, "");
                return;
            }
            return;
        }
        "SkuDetails query responded with success. List: ".concat(String.valueOf(list));
        if (list == null || list.isEmpty()) {
            this.f12102b = new acaba("store-product-not-available", (SkuDetails) null);
        }
        if (list != null) {
            for (SkuDetails skuDetails : list) {
                String sku = skuDetails.getSku();
                acaaa acaaa = this.f12101a;
                if (accbb.m15217a((Object) sku, (Object) acaaa != null ? acaaa.mo29514b() : null)) {
                    this.f12102b = new acaba("ok", skuDetails);
                }
            }
        }
        acaba acaba = this.f12102b;
        if (acaba != null && (acaab = this.f12104d) != null) {
            acaab.mo29424a(acaba.mo29515a(), m15167a(acaba.mo29516b()));
        }
    }

    public final void queryProductDetails() {
        acaaa acaaa = this.f12101a;
        if (acaaa != null && acaaa != null) {
            String a = acaaa.mo29513a();
            List singletonList = Collections.singletonList(acaaa.mo29514b());
            accbb.m15215a((Object) singletonList, "java.util.Collections.singletonList(element)");
            SkuDetailsParams.Builder newBuilder = SkuDetailsParams.newBuilder();
            newBuilder.setSkusList(singletonList).setType(a);
            aaaaa aaaaa2 = aaaaa.f12110a;
            BillingClient billingClient = this.f12109i;
            if (billingClient == null) {
                accbb.m15216a("playStoreBillingClient");
            }
            aaaaa.m15171a(billingClient, this, new aaabc(this, a, newBuilder));
        }
    }

    public final void queryPurchase(acaac acaac) {
        accbb.m15218b(acaac, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f12103c = acaac;
        BillingClient billingClient = this.f12109i;
        if (billingClient == null) {
            accbb.m15216a("playStoreBillingClient");
        }
        if (billingClient.isReady()) {
            m15168a();
        } else {
            this.f12107g = true;
        }
    }

    public final void setBillingFinishedListener(abcac abcac) {
        this.f12105e = abcac;
    }

    public final void setPurchaseQueryListener(acaac acaac) {
        accbb.m15218b(acaac, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f12107g = true;
        this.f12103c = acaac;
    }

    public final void setQueryProductDetailsListener(acaab acaab) {
        this.f12104d = acaab;
        acaba acaba = this.f12102b;
        if (acaba != null && acaab != null) {
            acaab.mo29424a(acaba.mo29515a(), m15167a(acaba.mo29516b()));
        }
    }

    public final void startDataSourceConnections(Context context) {
        accbb.m15218b(context, "context");
        abcab abcab = abcab.f12094a;
        this.f12108h = abcab.m15160a(context);
        this.f12109i = abcab.f12094a.mo29492a(context, (PurchasesUpdatedListener) this);
        m15169b();
    }

    public final boolean tokenExistsForActiveProduct() {
        if (this.f12108h == null) {
            accbb.m15216a("sharedPreferences");
        }
        String b = abccb.m15183b();
        if (this.f12108h == null) {
            accbb.m15216a("sharedPreferences");
        }
        String a = abccb.m15179a();
        if (a != null) {
            try {
                JSONArray jSONArray = new JSONArray(a);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (accbb.m15217a((Object) jSONObject.getString("productId"), (Object) b) && jSONObject.has("purchaseToken")) {
                        return true;
                    }
                }
                acbba acbba = acbba.f12137a;
            } catch (JSONException e) {
                Log.e("FairChoice", "Error while parsing purchases json: " + e + ')');
            }
        }
        return false;
    }
}
