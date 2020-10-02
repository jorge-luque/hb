package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.util.Base64;
import com.adcolony.sdk.C1359k0;
import com.adcolony.sdk.C1439u;
import com.applovin.sdk.AppLovinEventParameters;
import com.ogury.p159cm.OguryChoiceManager;
import com.tapjoy.TapjoyConstants;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import org.json.JSONObject;

public class AdColony {

    /* renamed from: a */
    static ExecutorService f3234a = Executors.newSingleThreadExecutor();

    /* renamed from: com.adcolony.sdk.AdColony$a */
    static class C1184a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f3235a;

        /* renamed from: b */
        final /* synthetic */ AdColonyInterstitialListener f3236b;

        C1184a(String str, AdColonyInterstitialListener adColonyInterstitialListener) {
            this.f3235a = str;
            this.f3236b = adColonyInterstitialListener;
        }

        public void run() {
            AdColonyZone adColonyZone = C1199a.m4880c().mo6558y().get(this.f3235a);
            if (adColonyZone == null) {
                adColonyZone = new AdColonyZone(this.f3235a);
            }
            this.f3236b.onRequestNotFilled(adColonyZone);
        }
    }

    /* renamed from: com.adcolony.sdk.AdColony$b */
    static class C1185b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f3237a;

        /* renamed from: b */
        final /* synthetic */ AdColonyAdViewListener f3238b;

        C1185b(String str, AdColonyAdViewListener adColonyAdViewListener) {
            this.f3237a = str;
            this.f3238b = adColonyAdViewListener;
        }

        public void run() {
            AdColonyZone adColonyZone;
            if (!C1199a.m4882e()) {
                adColonyZone = null;
            } else {
                adColonyZone = C1199a.m4880c().mo6558y().get(this.f3237a);
            }
            if (adColonyZone == null) {
                adColonyZone = new AdColonyZone(this.f3237a);
            }
            this.f3238b.onRequestNotFilled(adColonyZone);
        }
    }

    /* renamed from: com.adcolony.sdk.AdColony$c */
    static class C1186c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ AdColonyInterstitial f3239a;

        C1186c(AdColonyInterstitial adColonyInterstitial) {
            this.f3239a = adColonyInterstitial;
        }

        public void run() {
            AdColonyInterstitialListener listener = this.f3239a.getListener();
            this.f3239a.mo6322a(true);
            if (listener != null) {
                listener.onExpiring(this.f3239a);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.AdColony$d */
    static class C1187d implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C1290h f3240a;

        C1187d(C1290h hVar) {
            this.f3240a = hVar;
        }

        public void run() {
            ArrayList arrayList = new ArrayList();
            Iterator<C1201a0> it = this.f3240a.mo6548n().mo6841b().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                C1201a0 a0Var = (C1201a0) it2.next();
                this.f3240a.mo6528a(a0Var.mo6390d());
                if (a0Var instanceof C1379m0) {
                    C1379m0 m0Var = (C1379m0) a0Var;
                    if (!m0Var.mo6731t()) {
                        m0Var.loadUrl("about:blank");
                        m0Var.clearCache(true);
                        m0Var.removeAllViews();
                        m0Var.mo6711a(true);
                    }
                }
            }
        }
    }

    /* renamed from: com.adcolony.sdk.AdColony$e */
    static class C1188e implements Runnable {

        /* renamed from: a */
        final /* synthetic */ double f3241a;

        /* renamed from: b */
        final /* synthetic */ String f3242b;

        /* renamed from: c */
        final /* synthetic */ String f3243c;

        /* renamed from: d */
        final /* synthetic */ String f3244d;

        C1188e(double d, String str, String str2, String str3) {
            this.f3241a = d;
            this.f3242b = str;
            this.f3243c = str2;
            this.f3244d = str3;
        }

        public void run() {
            AdColony.m4810b();
            JSONObject b = C1437s.m5599b();
            double d = this.f3241a;
            if (d >= 0.0d) {
                C1437s.m5590a(b, "price", d);
            }
            String str = this.f3242b;
            if (str != null && str.length() <= 3) {
                C1437s.m5592a(b, "currency_code", this.f3242b);
            }
            C1437s.m5592a(b, "product_id", this.f3243c);
            C1437s.m5592a(b, AppLovinEventParameters.CHECKOUT_TRANSACTION_IDENTIFIER, this.f3244d);
            new C1454x("AdColony.on_iap_report", 1, b).mo6834d();
        }
    }

    /* renamed from: com.adcolony.sdk.AdColony$f */
    static class C1189f implements Runnable {

        /* renamed from: a */
        final /* synthetic */ AdColonyAdViewListener f3245a;

        /* renamed from: b */
        final /* synthetic */ String f3246b;

        /* renamed from: c */
        final /* synthetic */ AdColonyAdSize f3247c;

        /* renamed from: d */
        final /* synthetic */ AdColonyAdOptions f3248d;

        C1189f(AdColonyAdViewListener adColonyAdViewListener, String str, AdColonyAdSize adColonyAdSize, AdColonyAdOptions adColonyAdOptions) {
            this.f3245a = adColonyAdViewListener;
            this.f3246b = str;
            this.f3247c = adColonyAdSize;
            this.f3248d = adColonyAdOptions;
        }

        public void run() {
            C1290h c = C1199a.m4880c();
            if (c.mo6516A() || c.mo6517B()) {
                AdColony.m4811c();
                AdColony.m4808a(this.f3245a, this.f3246b);
            }
            if (!AdColony.m4810b() && C1199a.m4881d()) {
                AdColony.m4808a(this.f3245a, this.f3246b);
            }
            c.mo6530b().mo6455a(this.f3246b, this.f3245a, this.f3247c, this.f3248d);
        }
    }

    /* renamed from: com.adcolony.sdk.AdColony$g */
    static class C1190g implements Runnable {

        /* renamed from: a */
        final /* synthetic */ AdColonyAppOptions f3249a;

        C1190g(AdColonyAppOptions adColonyAppOptions) {
            this.f3249a = adColonyAppOptions;
        }

        public void run() {
            AdColony.m4810b();
            JSONObject b = C1437s.m5599b();
            C1437s.m5594a(b, "options", this.f3249a.mo6272b());
            new C1454x("Options.set_options", 1, b).mo6834d();
        }
    }

    /* renamed from: com.adcolony.sdk.AdColony$h */
    static class C1191h implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f3250a;

        C1191h(String str) {
            this.f3250a = str;
        }

        public void run() {
            AdColony.m4810b();
            JSONObject b = C1437s.m5599b();
            C1437s.m5592a(b, "type", this.f3250a);
            new C1454x("CustomMessage.register", 1, b).mo6834d();
        }
    }

    /* renamed from: com.adcolony.sdk.AdColony$i */
    static class C1192i implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f3251a;

        C1192i(String str) {
            this.f3251a = str;
        }

        public void run() {
            AdColony.m4810b();
            JSONObject b = C1437s.m5599b();
            C1437s.m5592a(b, "type", this.f3251a);
            new C1454x("CustomMessage.unregister", 1, b).mo6834d();
        }
    }

    /* renamed from: com.adcolony.sdk.AdColony$j */
    static class C1193j implements Runnable {
        C1193j() {
        }

        public void run() {
            AdColony.m4810b();
            for (String a : C1199a.m4880c().mo6541g().keySet()) {
                JSONObject b = C1437s.m5599b();
                C1437s.m5592a(b, "type", a);
                new C1454x("CustomMessage.unregister", 1, b).mo6834d();
            }
        }
    }

    /* renamed from: com.adcolony.sdk.AdColony$k */
    static class C1194k implements Runnable {

        /* renamed from: a */
        final /* synthetic */ AdColonyInterstitialListener f3252a;

        /* renamed from: b */
        final /* synthetic */ String f3253b;

        /* renamed from: c */
        final /* synthetic */ AdColonyAdOptions f3254c;

        /* renamed from: com.adcolony.sdk.AdColony$k$a */
        class C1195a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ AdColonyZone f3255a;

            C1195a(AdColonyZone adColonyZone) {
                this.f3255a = adColonyZone;
            }

            public void run() {
                C1194k.this.f3252a.onRequestNotFilled(this.f3255a);
            }
        }

        C1194k(AdColonyInterstitialListener adColonyInterstitialListener, String str, AdColonyAdOptions adColonyAdOptions) {
            this.f3252a = adColonyInterstitialListener;
            this.f3253b = str;
            this.f3254c = adColonyAdOptions;
        }

        public void run() {
            C1290h c = C1199a.m4880c();
            if (c.mo6516A() || c.mo6517B()) {
                AdColony.m4811c();
                AdColony.m4809a(this.f3252a, this.f3253b);
            } else if (AdColony.m4810b() || !C1199a.m4881d()) {
                AdColonyZone adColonyZone = c.mo6558y().get(this.f3253b);
                if (adColonyZone == null) {
                    adColonyZone = new AdColonyZone(this.f3253b);
                }
                if (adColonyZone.getZoneType() == 2 || adColonyZone.getZoneType() == 1) {
                    C1359k0.m5309a((Runnable) new C1195a(adColonyZone));
                } else {
                    c.mo6530b().mo6456a(this.f3253b, this.f3252a, this.f3254c);
                }
            } else {
                AdColony.m4809a(this.f3252a, this.f3253b);
            }
        }
    }

    public static boolean addCustomMessageListener(AdColonyCustomMessageListener adColonyCustomMessageListener, String str) {
        if (!C1199a.m4883f()) {
            new C1439u.C1440a().mo6801a("Ignoring call to AdColony.addCustomMessageListener as AdColony ").mo6801a("has not yet been configured.").mo6803a(C1439u.f4514g);
            return false;
        } else if (!C1359k0.m5333g(str)) {
            new C1439u.C1440a().mo6801a("Ignoring call to AdColony.addCustomMessageListener.").mo6803a(C1439u.f4514g);
            return false;
        } else {
            try {
                C1199a.m4880c().mo6541g().put(str, adColonyCustomMessageListener);
                f3234a.execute(new C1191h(str));
                return true;
            } catch (RejectedExecutionException unused) {
                return false;
            }
        }
    }

    /* renamed from: b */
    static boolean m4810b() {
        C1359k0.C1361b bVar = new C1359k0.C1361b(15.0d);
        C1290h c = C1199a.m4880c();
        while (!c.mo6518C() && !bVar.mo6673a()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException unused) {
            }
        }
        return c.mo6518C();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static void m4811c() {
        new C1439u.C1440a().mo6801a("The AdColony API is not available while AdColony is disabled.").mo6803a(C1439u.f4516i);
    }

    public static boolean clearCustomMessageListeners() {
        if (!C1199a.m4883f()) {
            new C1439u.C1440a().mo6801a("Ignoring call to AdColony.clearCustomMessageListeners as AdColony").mo6801a(" has not yet been configured.").mo6803a(C1439u.f4514g);
            return false;
        }
        C1199a.m4880c().mo6541g().clear();
        f3234a.execute(new C1193j());
        return true;
    }

    public static String collectSignals() {
        if (!C1199a.m4883f()) {
            new C1439u.C1440a().mo6801a("Ignoring call to AdColony.collectSignals() as AdColony has not yet been configured.").mo6803a(C1439u.f4514g);
            return "";
        }
        C1290h c = C1199a.m4880c();
        C1286f0 u = c.mo6554u();
        u.mo6494b();
        JSONObject a = C1437s.m5585a(c.mo6542h().mo6612a(false), c.mo6552r().mo6272b());
        C1437s.m5602b(a, "signals_count", u.mo6491a());
        return Base64.encodeToString(a.toString().getBytes(StandardCharsets.UTF_8), 0);
    }

    public static boolean configure(Activity activity, String str, String... strArr) {
        return m4807a(activity, (AdColonyAppOptions) null, str, strArr);
    }

    public static boolean disable() {
        if (!C1199a.m4883f()) {
            return false;
        }
        Context b = C1199a.m4878b();
        if (b != null && (b instanceof C1202b)) {
            ((Activity) b).finish();
        }
        C1290h c = C1199a.m4880c();
        for (AdColonyInterstitial cVar : c.mo6530b().mo6453a().values()) {
            C1359k0.m5309a((Runnable) new C1186c(cVar));
        }
        C1359k0.m5309a((Runnable) new C1187d(c));
        C1199a.m4880c().mo6533b(true);
        return true;
    }

    public static AdColonyAppOptions getAppOptions() {
        if (!C1199a.m4883f()) {
            return null;
        }
        return C1199a.m4880c().mo6552r();
    }

    public static AdColonyCustomMessageListener getCustomMessageListener(String str) {
        if (!C1199a.m4883f()) {
            return null;
        }
        return C1199a.m4880c().mo6541g().get(str);
    }

    public static AdColonyRewardListener getRewardListener() {
        if (!C1199a.m4883f()) {
            return null;
        }
        return C1199a.m4880c().mo6553t();
    }

    public static String getSDKVersion() {
        if (!C1199a.m4883f()) {
            return "";
        }
        return C1199a.m4880c().mo6542h().mo6603C();
    }

    public static AdColonyZone getZone(String str) {
        if (!C1199a.m4883f()) {
            new C1439u.C1440a().mo6801a("Ignoring call to AdColony.getZone() as AdColony has not yet been ").mo6801a("configured.").mo6803a(C1439u.f4514g);
            return null;
        }
        HashMap<String, AdColonyZone> y = C1199a.m4880c().mo6558y();
        if (y.containsKey(str)) {
            return y.get(str);
        }
        AdColonyZone adColonyZone = new AdColonyZone(str);
        C1199a.m4880c().mo6558y().put(str, adColonyZone);
        return adColonyZone;
    }

    public static boolean notifyIAPComplete(String str, String str2) {
        return notifyIAPComplete(str, str2, (String) null, 0.0d);
    }

    public static boolean removeCustomMessageListener(String str) {
        if (!C1199a.m4883f()) {
            new C1439u.C1440a().mo6801a("Ignoring call to AdColony.removeCustomMessageListener as AdColony").mo6801a(" has not yet been configured.").mo6803a(C1439u.f4514g);
            return false;
        }
        C1199a.m4880c().mo6541g().remove(str);
        f3234a.execute(new C1192i(str));
        return true;
    }

    public static boolean removeRewardListener() {
        if (!C1199a.m4883f()) {
            new C1439u.C1440a().mo6801a("Ignoring call to AdColony.removeRewardListener() as AdColony has ").mo6801a("not yet been configured.").mo6803a(C1439u.f4514g);
            return false;
        }
        C1199a.m4880c().mo6525a((AdColonyRewardListener) null);
        return true;
    }

    public static boolean requestAdView(String str, AdColonyAdViewListener adColonyAdViewListener, AdColonyAdSize adColonyAdSize) {
        return requestAdView(str, adColonyAdViewListener, adColonyAdSize, (AdColonyAdOptions) null);
    }

    public static boolean requestInterstitial(String str, AdColonyInterstitialListener adColonyInterstitialListener) {
        return requestInterstitial(str, adColonyInterstitialListener, (AdColonyAdOptions) null);
    }

    public static boolean setAppOptions(AdColonyAppOptions adColonyAppOptions) {
        if (!C1199a.m4883f()) {
            new C1439u.C1440a().mo6801a("Ignoring call to AdColony.setAppOptions() as AdColony has not yet").mo6801a(" been configured.").mo6803a(C1439u.f4514g);
            return false;
        }
        C1199a.m4880c().mo6531b(adColonyAppOptions);
        Context b = C1199a.m4878b();
        if (b != null) {
            adColonyAppOptions.mo6273b(b);
        }
        try {
            f3234a.execute(new C1190g(adColonyAppOptions));
            return true;
        } catch (RejectedExecutionException unused) {
            return false;
        }
    }

    public static boolean setRewardListener(AdColonyRewardListener adColonyRewardListener) {
        if (!C1199a.m4883f()) {
            new C1439u.C1440a().mo6801a("Ignoring call to AdColony.setRewardListener() as AdColony has not").mo6801a(" yet been configured.").mo6803a(C1439u.f4514g);
            return false;
        }
        C1199a.m4880c().mo6525a(adColonyRewardListener);
        return true;
    }

    @SuppressLint({"ObsoleteSdkInt"})
    /* renamed from: a */
    private static boolean m4807a(Context context, AdColonyAppOptions adColonyAppOptions, String str, String... strArr) {
        if (C1251d0.m5026a(0, (Bundle) null)) {
            new C1439u.C1440a().mo6801a("Cannot configure AdColony; configuration mechanism requires 5 ").mo6801a("seconds between attempts.").mo6803a(C1439u.f4514g);
            return false;
        }
        if (context == null) {
            context = C1199a.m4878b();
        }
        if (context == null) {
            new C1439u.C1440a().mo6801a("Ignoring call to AdColony.configure() as the provided Activity or ").mo6801a("Application context is null and we do not currently hold a ").mo6801a("reference to either for our use.").mo6803a(C1439u.f4514g);
            return false;
        }
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        if (adColonyAppOptions == null) {
            adColonyAppOptions = new AdColonyAppOptions();
        }
        if (C1199a.m4882e() && !C1437s.m5608d(C1199a.m4880c().mo6552r().mo6272b(), "reconfigurable")) {
            C1290h c = C1199a.m4880c();
            if (!c.mo6552r().mo6271a().equals(str)) {
                new C1439u.C1440a().mo6801a("Ignoring call to AdColony.configure() as the app id does not ").mo6801a("match what was used during the initial configuration.").mo6803a(C1439u.f4514g);
                return false;
            } else if (C1359k0.m5312a(strArr, c.mo6552r().mo6274c())) {
                new C1439u.C1440a().mo6801a("Ignoring call to AdColony.configure() as the same zone ids ").mo6801a("were used during the previous configuration.").mo6803a(C1439u.f4514g);
                return true;
            }
        }
        adColonyAppOptions.mo6269a(str);
        adColonyAppOptions.mo6270a(strArr);
        adColonyAppOptions.mo6273b(context);
        new SimpleDateFormat("HH:mm:ss:SSS", Locale.US).format(new Date(System.currentTimeMillis()));
        boolean z = true;
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i] != null && !strArr[i].equals("")) {
                z = false;
            }
        }
        if (str.equals("") || z) {
            new C1439u.C1440a().mo6801a("AdColony.configure() called with an empty app or zone id String.").mo6803a(C1439u.f4516i);
            return false;
        }
        C1199a.f3338c = true;
        if (Build.VERSION.SDK_INT < 14) {
            new C1439u.C1440a().mo6801a("The minimum API level for the AdColony SDK is 14.").mo6803a(C1439u.f4514g);
            C1199a.m4875a(context, adColonyAppOptions, true);
        } else {
            C1199a.m4875a(context, adColonyAppOptions, false);
        }
        String str2 = C1199a.m4880c().mo6555v().mo6514f() + "/adc3/AppInfo";
        JSONObject b = C1437s.m5599b();
        if (new File(str2).exists()) {
            b = C1437s.m5605c(str2);
        }
        JSONObject b2 = C1437s.m5599b();
        if (C1437s.m5613h(b, "appId").equals(str)) {
            C1437s.m5593a(b2, "zoneIds", C1437s.m5581a(C1437s.m5604c(b, "zoneIds"), strArr, true));
            C1437s.m5592a(b2, "appId", str);
        } else {
            C1437s.m5593a(b2, "zoneIds", C1437s.m5582a(strArr));
            C1437s.m5592a(b2, "appId", str);
        }
        C1437s.m5614i(b2, str2);
        return true;
    }

    public static boolean configure(Activity activity, AdColonyAppOptions adColonyAppOptions, String str, String... strArr) {
        return m4807a(activity, adColonyAppOptions, str, strArr);
    }

    public static boolean notifyIAPComplete(String str, String str2, String str3, double d) {
        if (!C1199a.m4883f()) {
            new C1439u.C1440a().mo6801a("Ignoring call to notifyIAPComplete as AdColony has not yet been ").mo6801a("configured.").mo6803a(C1439u.f4514g);
            return false;
        } else if (!C1359k0.m5333g(str) || !C1359k0.m5333g(str2)) {
            new C1439u.C1440a().mo6801a("Ignoring call to notifyIAPComplete as one of the passed Strings ").mo6801a("is greater than ").mo6799a((int) OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE).mo6801a(" characters.").mo6803a(C1439u.f4514g);
            return false;
        } else {
            if (str3 != null && str3.length() > 3) {
                new C1439u.C1440a().mo6801a("You are trying to report an IAP event with a currency String ").mo6801a("containing more than 3 characters.").mo6803a(C1439u.f4514g);
            }
            f3234a.execute(new C1188e(d, str3, str, str2));
            return true;
        }
    }

    public static boolean requestAdView(String str, AdColonyAdViewListener adColonyAdViewListener, AdColonyAdSize adColonyAdSize, AdColonyAdOptions adColonyAdOptions) {
        if (!C1199a.m4883f()) {
            new C1439u.C1440a().mo6801a("Ignoring call to requestAdView as AdColony has not yet been").mo6801a(" configured.").mo6803a(C1439u.f4514g);
            m4808a(adColonyAdViewListener, str);
            return false;
        } else if (adColonyAdSize.getHeight() <= 0 || adColonyAdSize.getWidth() <= 0) {
            new C1439u.C1440a().mo6801a("Ignoring call to requestAdView as you've provided an AdColonyAdSize").mo6801a(" object with an invalid width or height.").mo6803a(C1439u.f4514g);
            return false;
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("zone_id", str);
            if (C1251d0.m5026a(1, bundle)) {
                m4808a(adColonyAdViewListener, str);
                return false;
            }
            try {
                f3234a.execute(new C1189f(adColonyAdViewListener, str, adColonyAdSize, adColonyAdOptions));
                return true;
            } catch (RejectedExecutionException unused) {
                m4808a(adColonyAdViewListener, str);
                return false;
            }
        }
    }

    public static boolean requestInterstitial(String str, AdColonyInterstitialListener adColonyInterstitialListener, AdColonyAdOptions adColonyAdOptions) {
        if (!C1199a.m4883f()) {
            new C1439u.C1440a().mo6801a("Ignoring call to AdColony.requestInterstitial as AdColony has not").mo6801a(" yet been configured.").mo6803a(C1439u.f4514g);
            adColonyInterstitialListener.onRequestNotFilled(new AdColonyZone(str));
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString("zone_id", str);
        if (C1251d0.m5026a(1, bundle)) {
            AdColonyZone adColonyZone = C1199a.m4880c().mo6558y().get(str);
            if (adColonyZone == null) {
                adColonyZone = new AdColonyZone(str);
            }
            adColonyInterstitialListener.onRequestNotFilled(adColonyZone);
            return false;
        }
        try {
            f3234a.execute(new C1194k(adColonyInterstitialListener, str, adColonyAdOptions));
            return true;
        } catch (RejectedExecutionException unused) {
            m4809a(adColonyInterstitialListener, str);
            return false;
        }
    }

    public static boolean configure(Application application, String str, String... strArr) {
        return configure(application, (AdColonyAppOptions) null, str, strArr);
    }

    public static boolean configure(Application application, AdColonyAppOptions adColonyAppOptions, String str, String... strArr) {
        return m4807a(application, adColonyAppOptions, str, strArr);
    }

    /* renamed from: a */
    static boolean m4809a(AdColonyInterstitialListener adColonyInterstitialListener, String str) {
        if (adColonyInterstitialListener == null || !C1199a.m4881d()) {
            return false;
        }
        C1359k0.m5309a((Runnable) new C1184a(str, adColonyInterstitialListener));
        return false;
    }

    /* renamed from: a */
    static boolean m4808a(AdColonyAdViewListener adColonyAdViewListener, String str) {
        if (adColonyAdViewListener == null || !C1199a.m4881d()) {
            return false;
        }
        C1359k0.m5309a((Runnable) new C1185b(str, adColonyAdViewListener));
        return false;
    }

    /* renamed from: a */
    static void m4806a(Context context, AdColonyAppOptions adColonyAppOptions) {
        C1290h c = C1199a.m4880c();
        C1336j h = c.mo6542h();
        if (adColonyAppOptions != null && context != null) {
            String c2 = C1359k0.m5321c(context);
            String e = C1359k0.m5328e();
            int f = C1359k0.m5330f();
            String h2 = h.mo6624h();
            String a = c.mo6549o().mo6396a();
            HashMap hashMap = new HashMap();
            hashMap.put("sessionId", "unknown");
            hashMap.put("advertiserId", "unknown");
            hashMap.put("countryLocale", Locale.getDefault().getDisplayLanguage() + " (" + Locale.getDefault().getDisplayCountry() + ")");
            hashMap.put("countryLocaleShort", C1199a.m4880c().mo6542h().mo6627k());
            hashMap.put("manufacturer", C1199a.m4880c().mo6542h().mo6639w());
            hashMap.put("model", C1199a.m4880c().mo6542h().mo6642z());
            hashMap.put("osVersion", C1199a.m4880c().mo6542h().mo6602B());
            hashMap.put("carrierName", h2);
            hashMap.put("networkType", a);
            hashMap.put(TapjoyConstants.TJC_PLATFORM, "android");
            hashMap.put("appName", c2);
            hashMap.put("appVersion", e);
            hashMap.put("appBuildNumber", Integer.valueOf(f));
            hashMap.put("appId", "" + adColonyAppOptions.mo6271a());
            hashMap.put("apiLevel", Integer.valueOf(Build.VERSION.SDK_INT));
            hashMap.put("sdkVersion", C1199a.m4880c().mo6542h().mo6603C());
            hashMap.put("controllerVersion", "unknown");
            hashMap.put("zoneIds", adColonyAppOptions.mo6275d());
            JSONObject mediationInfo = adColonyAppOptions.getMediationInfo();
            JSONObject pluginInfo = adColonyAppOptions.getPluginInfo();
            if (!C1437s.m5613h(mediationInfo, "mediation_network").equals("")) {
                hashMap.put("mediationNetwork", C1437s.m5613h(mediationInfo, "mediation_network"));
                hashMap.put("mediationNetworkVersion", C1437s.m5613h(mediationInfo, "mediation_network_version"));
            }
            if (!C1437s.m5613h(pluginInfo, TapjoyConstants.TJC_PLUGIN).equals("")) {
                hashMap.put(TapjoyConstants.TJC_PLUGIN, C1437s.m5613h(pluginInfo, TapjoyConstants.TJC_PLUGIN));
                hashMap.put("pluginVersion", C1437s.m5613h(pluginInfo, "plugin_version"));
            }
            c.mo6547m().mo6819a((HashMap<String, Object>) hashMap);
        }
    }
}
