package com.chartboost.sdk;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import com.adcolony.sdk.AdColonyAppOptions;
import com.chartboost.sdk.C2239j;
import com.chartboost.sdk.Events.C2070b;
import com.chartboost.sdk.Libraries.C2072b;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.C2093h;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.impl.C2117a;
import com.chartboost.sdk.impl.C2143g;
import com.chartboost.sdk.impl.C2149g1;
import com.chartboost.sdk.impl.C2166i1;
import com.chartboost.sdk.impl.C2224x;
import com.chartboost.sdk.impl.C2236z;
import com.facebook.internal.AnalyticsEvents;
import com.ogury.p159cm.OguryChoiceManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Chartboost {

    public enum CBFramework {
        CBFrameworkUnity(AdColonyAppOptions.UNITY),
        CBFrameworkCorona(AdColonyAppOptions.CORONA),
        CBFrameworkAir("AIR"),
        CBFrameworkGameSalad("GameSalad"),
        CBFrameworkCordova("Cordova"),
        CBFrameworkCocoonJS("CocoonJS"),
        CBFrameworkCocos2dx("Cocos2dx"),
        CBFrameworkPrime31Unreal("Prime31Unreal"),
        CBFrameworkWeeby("Weeby"),
        CBFrameworkOther("Other");
        

        /* renamed from: a */
        private final String f6831a;

        private CBFramework(String str) {
            this.f6831a = str;
        }

        public static CBFramework fromString(String str) {
            if (str.equals(CBFrameworkUnity.toString())) {
                return CBFrameworkUnity;
            }
            if (str.equals(CBFrameworkCorona.toString())) {
                return CBFrameworkCorona;
            }
            if (str.equals(CBFrameworkAir.toString())) {
                return CBFrameworkAir;
            }
            if (str.equals(CBFrameworkGameSalad.toString())) {
                return CBFrameworkGameSalad;
            }
            if (str.equals(CBFrameworkCordova.toString())) {
                return CBFrameworkCordova;
            }
            if (str.equals(CBFrameworkCocoonJS.toString())) {
                return CBFrameworkCocoonJS;
            }
            if (str.equals(CBFrameworkCocos2dx.toString())) {
                return CBFrameworkCocos2dx;
            }
            if (str.equals(CBFrameworkPrime31Unreal.toString())) {
                return CBFrameworkPrime31Unreal;
            }
            if (str.equals(CBFrameworkWeeby.toString())) {
                return CBFrameworkWeeby;
            }
            if (str.equals(CBFrameworkOther.toString())) {
                return CBFrameworkOther;
            }
            return CBFrameworkOther;
        }

        public boolean doesWrapperUseCustomBackgroundingBehavior() {
            return this == CBFrameworkAir;
        }

        public boolean doesWrapperUseCustomShouldDisplayBehavior() {
            return this == CBFrameworkAir || this == CBFrameworkCocos2dx;
        }

        public String toString() {
            return this.f6831a;
        }
    }

    public enum CBMediation {
        CBMediationAdMarvel(AdColonyAppOptions.ADMARVEL),
        CBMediationAdMob(AdColonyAppOptions.ADMOB),
        CBMediationFuse("Fuse"),
        CBMediationFyber(AdColonyAppOptions.FYBER),
        CBMediationHeyZap("HeyZap"),
        CBMediationMoPub(AdColonyAppOptions.MOPUB),
        CBMediationironSource(AdColonyAppOptions.IRONSOURCE),
        CBMediationHyprMX("HyprMX"),
        CBMediationAerServ("AerServ"),
        CBMediationHelium("Helium"),
        CBMediationFairbid("Fairbid"),
        CBMediationMAX("MAX"),
        CBMediationOther("Other");
        

        /* renamed from: a */
        private final String f6833a;

        private CBMediation(String str) {
            this.f6833a = str;
        }

        public String toString() {
            return this.f6833a;
        }
    }

    public enum CBPIDataUseConsent {
        UNKNOWN(-1, AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN),
        NO_BEHAVIORAL(0, "Non behavioral"),
        YES_BEHAVIORAL(1, "Behavioral");
        

        /* renamed from: c */
        private static Map<Integer, CBPIDataUseConsent> f6834c;

        /* renamed from: d */
        private static List<CharSequence> f6835d;

        /* renamed from: a */
        private int f6837a;

        /* renamed from: b */
        private String f6838b;

        static {
            int i;
            f6834c = new HashMap();
            f6835d = new ArrayList();
            for (CBPIDataUseConsent cBPIDataUseConsent : values()) {
                f6834c.put(Integer.valueOf(cBPIDataUseConsent.f6837a), cBPIDataUseConsent);
                f6835d.add(cBPIDataUseConsent.f6838b);
            }
        }

        private CBPIDataUseConsent(int i, String str) {
            this.f6837a = i;
            this.f6838b = str;
        }

        public static CharSequence[] getAsCharsArray() {
            return (CharSequence[]) f6835d.toArray(new CharSequence[0]);
        }

        public static CBPIDataUseConsent getConsentByName(String str) {
            if (NO_BEHAVIORAL.f6838b.equals(str)) {
                return NO_BEHAVIORAL;
            }
            if (YES_BEHAVIORAL.f6838b.equals(str)) {
                return YES_BEHAVIORAL;
            }
            return UNKNOWN;
        }

        public int getValue() {
            return this.f6837a;
        }

        public static CBPIDataUseConsent valueOf(int i) {
            CBPIDataUseConsent cBPIDataUseConsent = f6834c.get(Integer.valueOf(i));
            return cBPIDataUseConsent == null ? UNKNOWN : cBPIDataUseConsent;
        }
    }

    private Chartboost() {
    }

    /* renamed from: a */
    private static void m8148a() {
        C2239j n = C2239j.m8897n();
        if (n != null) {
            n.mo9613k();
        }
    }

    public static void cacheInterstitial(String str) {
        C2166i1.m8611a("Chartboost.cacheInterstitial", str);
        if (Build.VERSION.SDK_INT < 21) {
            CBLogging.m8154b("Chartboost", "Interstitial not supported for this Android version");
            C2099a delegate = getDelegate();
            if (delegate != null) {
                delegate.didFailToLoadInterstitial(str, CBError.CBImpressionError.NO_AD_FOUND);
                return;
            }
            return;
        }
        C2239j n = C2239j.m8897n();
        if (n != null && C2101c.m8331c() && C2239j.m8899p()) {
            if (C2224x.m8805e().mo9549a((CharSequence) str)) {
                CBLogging.m8154b("Chartboost", "cacheInterstitial location cannot be empty");
                Handler handler = n.f7591y;
                C2117a aVar = n.f7584r;
                aVar.getClass();
                handler.post(new C2117a.C2118a(4, str, CBError.CBImpressionError.INVALID_LOCATION, (C2070b) null));
                return;
            }
            C2093h h = n.mo9610h();
            if ((!h.f7023w || !h.f7025y) && (!h.f7005e || !h.f7007g)) {
                Handler i = n.mo9611i();
                C2117a e = n.mo9607e();
                e.getClass();
                i.post(new C2117a.C2118a(4, str, CBError.CBImpressionError.END_POINT_DISABLED, (C2070b) null));
                return;
            }
            C2143g gVar = n.f7583q;
            gVar.getClass();
            n.f7579m.execute(new C2143g.C2145b(3, str, (C2151h) null, (CBError.CBImpressionError) null));
        }
    }

    public static void cacheMoreApps(String str) {
        C2239j n = C2239j.m8897n();
        if (n != null && C2101c.m8331c() && C2239j.m8899p()) {
            n.getClass();
            C2239j.C2241b bVar = new C2239j.C2241b(5);
            bVar.f7596b = str;
            n.f7591y.postDelayed(bVar, C2072b.f6854b);
        }
    }

    public static void cacheRewardedVideo(String str) {
        C2166i1.m8611a("Chartboost.cacheRewardedVideo", str);
        if (Build.VERSION.SDK_INT < 21) {
            CBLogging.m8154b("Chartboost", "Rewarded video not supported for this Android version");
            C2099a delegate = getDelegate();
            if (delegate != null) {
                delegate.didFailToLoadRewardedVideo(str, CBError.CBImpressionError.NO_AD_FOUND);
                return;
            }
            return;
        }
        C2239j n = C2239j.m8897n();
        if (n != null && C2101c.m8331c() && C2239j.m8899p()) {
            if (C2224x.m8805e().mo9549a((CharSequence) str)) {
                CBLogging.m8154b("Chartboost", "cacheRewardedVideo location cannot be empty");
                Handler handler = n.f7591y;
                C2117a aVar = n.f7588v;
                aVar.getClass();
                handler.post(new C2117a.C2118a(4, str, CBError.CBImpressionError.INVALID_LOCATION, (C2070b) null));
                return;
            }
            C2093h h = n.mo9610h();
            if ((!h.f7023w || !h.f6997B) && (!h.f7005e || !h.f7010j)) {
                Handler i = n.mo9611i();
                C2117a g = n.mo9609g();
                g.getClass();
                i.post(new C2117a.C2118a(4, str, CBError.CBImpressionError.END_POINT_DISABLED, (C2070b) null));
                return;
            }
            C2143g gVar = n.f7587u;
            gVar.getClass();
            n.f7579m.execute(new C2143g.C2145b(3, str, (C2151h) null, (CBError.CBImpressionError) null));
        }
    }

    @Deprecated
    public static void closeImpression() {
    }

    @Deprecated
    private static void forwardTouchEventsAIR(boolean z) {
    }

    public static boolean getAutoCacheAds() {
        return C2242k.f7618r;
    }

    public static String getCustomId() {
        if (!C2101c.m8325a()) {
            return "";
        }
        return C2242k.f7602b;
    }

    public static C2099a getDelegate() {
        return C2242k.f7604d;
    }

    public static CBLogging.Level getLoggingLevel() {
        C2101c.m8325a();
        return CBLogging.f6849a;
    }

    public static CBPIDataUseConsent getPIDataUseConsent() {
        return C2242k.f7622v;
    }

    public static String getSDKVersion() {
        return "8.0.3";
    }

    public static boolean hasInterstitial(String str) {
        C2166i1.m8611a("Chartboost.hasInterstitial", str);
        C2239j n = C2239j.m8897n();
        if (n == null || !C2101c.m8331c() || n.f7583q.mo9342d(str) == null) {
            return false;
        }
        return true;
    }

    public static boolean hasMoreApps(String str) {
        return false;
    }

    public static boolean hasRewardedVideo(String str) {
        C2166i1.m8611a("Chartboost.hasRewardedVideo", str);
        C2239j n = C2239j.m8897n();
        if (n == null || !C2101c.m8331c() || n.f7587u.mo9342d(str) == null) {
            return false;
        }
        return true;
    }

    public static boolean isAnyViewVisible() {
        C2166i1.m8609a("Chartboost.isAnyViewVisible");
        C2239j n = C2239j.m8897n();
        return n != null && n.f7592z.mo9203f();
    }

    public static boolean isWebViewEnabled() {
        C2239j n = C2239j.m8897n();
        return n == null || n.f7589w.get().f7023w;
    }

    public static boolean onBackPressed() {
        C2166i1.m8609a("Chartboost.onBackPressed");
        C2239j n = C2239j.m8897n();
        if (n == null) {
            return false;
        }
        return n.f7592z.mo9205g();
    }

    @Deprecated
    public static void restrictDataCollection(Context context, boolean z) {
        setPIDataUseConsent(context, z ? CBPIDataUseConsent.NO_BEHAVIORAL : CBPIDataUseConsent.UNKNOWN);
    }

    @TargetApi(28)
    public static void setActivityAttrs(Activity activity) {
        if (activity != null) {
            Window window = activity.getWindow();
            if (C2242k.f7608h) {
                if (Build.VERSION.SDK_INT >= 28) {
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.layoutInDisplayCutoutMode = 1;
                    window.setAttributes(attributes);
                }
                window.getDecorView().setSystemUiVisibility(5894);
            } else if ((window.getAttributes().flags & OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS) != 0) {
                CBLogging.m8159e("Chartboost", "Attempting to show Status and Navigation bars on a fullscreen activity. Please change your Chartboost activity theme to: \"@android:style/Theme.Translucent\"` in your Manifest file");
            }
        }
    }

    public static void setAutoCacheAds(boolean z) {
        C2166i1.m8612a("Chartboost.setAutoCacheAds", z);
        C2239j n = C2239j.m8897n();
        if (n != null) {
            n.getClass();
            C2239j.C2241b bVar = new C2239j.C2241b(1);
            bVar.f7597c = z;
            C2239j.m8896b((Runnable) bVar);
        }
    }

    public static void setChartboostWrapperVersion(String str) {
        C2166i1.m8611a("Chartboost.setChartboostWrapperVersion", str);
        C2115h hVar = new C2115h(5);
        hVar.f7092d = str;
        C2239j.m8896b((Runnable) hVar);
    }

    public static void setCustomId(String str) {
        C2166i1.m8611a("Chartboost.setCustomId", str);
        C2115h hVar = new C2115h(6);
        hVar.f7094f = str;
        C2239j.m8896b((Runnable) hVar);
    }

    public static void setDelegate(ChartboostDelegate chartboostDelegate) {
        C2166i1.m8610a("Chartboost.setDelegate", (Object) chartboostDelegate);
        C2115h hVar = new C2115h(8);
        hVar.f7096h = chartboostDelegate;
        C2239j.m8896b((Runnable) hVar);
    }

    public static void setFramework(CBFramework cBFramework, String str) {
        C2166i1.m8609a("Chartboost.setFramework");
        C2115h hVar = new C2115h(4);
        hVar.f7091c = cBFramework;
        hVar.f7092d = str;
        C2239j.m8896b((Runnable) hVar);
    }

    @Deprecated
    public static void setFrameworkVersion(String str) {
        C2166i1.m8611a("Chartboost.setFrameworkVersion", str);
        C2115h hVar = new C2115h(5);
        hVar.f7092d = str;
        C2239j.m8896b((Runnable) hVar);
    }

    public static void setLoggingLevel(CBLogging.Level level) {
        C2166i1.m8611a("Chartboost.setLoggingLevel", level.toString());
        C2115h hVar = new C2115h(7);
        hVar.f7095g = level;
        C2239j.m8896b((Runnable) hVar);
    }

    @Deprecated
    public static void setMediation(CBMediation cBMediation, String str) {
        C2166i1.m8609a("Chartboost.setMediation.deprecated");
        setMediation(cBMediation, str, (String) null);
    }

    public static void setPIDataUseConsent(Context context, CBPIDataUseConsent cBPIDataUseConsent) {
        C2239j.m8893a(context, cBPIDataUseConsent);
    }

    public static void setShouldDisplayLoadingViewForMoreApps(boolean z) {
    }

    public static void setShouldHideSystemUI(Boolean bool) {
        C2166i1.m8610a("Chartboost.setHideSystemUI", (Object) bool);
        C2242k.f7608h = bool.booleanValue();
    }

    public static void setShouldPrefetchVideoContent(boolean z) {
        C2166i1.m8612a("Chartboost.setShouldPrefetchVideoContent", z);
        C2239j n = C2239j.m8897n();
        if (n != null && C2101c.m8331c()) {
            n.getClass();
            C2239j.C2241b bVar = new C2239j.C2241b(2);
            bVar.f7598d = z;
            C2239j.m8896b((Runnable) bVar);
        }
    }

    public static void setShouldRequestInterstitialsInFirstSession(boolean z) {
        C2166i1.m8612a("Chartboost.setShouldRequestInterstitialsInFirstSession", z);
        if (C2101c.m8325a()) {
            C2115h hVar = new C2115h(1);
            hVar.f7090b = z;
            C2239j.m8896b((Runnable) hVar);
        }
    }

    public static void showInterstitial(String str) {
        C2166i1.m8611a("Chartboost.showInterstitial", str);
        if (Build.VERSION.SDK_INT < 21) {
            CBLogging.m8154b("Chartboost", "Interstitial not supported for this Android version");
            C2099a delegate = getDelegate();
            if (delegate != null) {
                delegate.didFailToLoadInterstitial(str, CBError.CBImpressionError.NO_AD_FOUND);
                return;
            }
            return;
        }
        C2239j n = C2239j.m8897n();
        if (n != null && C2101c.m8331c() && C2239j.m8899p()) {
            if (C2224x.m8805e().mo9549a((CharSequence) str)) {
                CBLogging.m8154b("Chartboost", "showInterstitial location cannot be empty");
                Handler handler = n.f7591y;
                C2117a aVar = n.f7584r;
                aVar.getClass();
                handler.post(new C2117a.C2118a(4, str, CBError.CBImpressionError.INVALID_LOCATION, (C2070b) null));
                return;
            }
            C2093h hVar = n.f7589w.get();
            if ((!hVar.f7023w || !hVar.f7025y) && (!hVar.f7005e || !hVar.f7007g)) {
                Handler handler2 = n.f7591y;
                C2117a aVar2 = n.f7584r;
                aVar2.getClass();
                handler2.post(new C2117a.C2118a(4, str, CBError.CBImpressionError.END_POINT_DISABLED, (C2070b) null));
                return;
            }
            C2143g gVar = n.f7583q;
            gVar.getClass();
            n.f7579m.execute(new C2143g.C2145b(4, str, (C2151h) null, (CBError.CBImpressionError) null));
        }
    }

    private static void showInterstitialAIR(String str, boolean z) {
        C2239j n = C2239j.m8897n();
        if (n != null && C2101c.m8331c() && C2239j.m8899p()) {
            C2093h hVar = n.f7589w.get();
            if ((!hVar.f7023w || !hVar.f7025y) && (!hVar.f7005e || !hVar.f7007g)) {
                C2242k.f7604d.didFailToLoadInterstitial(str, CBError.CBImpressionError.END_POINT_DISABLED);
                return;
            }
            Handler handler = n.f7591y;
            C2117a aVar = n.f7584r;
            aVar.getClass();
            handler.post(new C2117a.C2118a(4, str, CBError.CBImpressionError.INTERNAL, (C2070b) null));
        }
    }

    public static void showMoreApps(String str) {
        cacheMoreApps(str);
    }

    private static void showMoreAppsAIR(String str, boolean z) {
        cacheMoreApps(str);
    }

    public static void showRewardedVideo(String str) {
        C2166i1.m8611a("Chartboost.showRewardedVideo", str);
        if (Build.VERSION.SDK_INT < 21) {
            CBLogging.m8154b("Chartboost", "Rewarded video not supported for this Android version");
            C2099a delegate = getDelegate();
            if (delegate != null) {
                delegate.didFailToLoadRewardedVideo(str, CBError.CBImpressionError.NO_AD_FOUND);
                return;
            }
            return;
        }
        C2239j n = C2239j.m8897n();
        if (n != null && C2101c.m8331c() && C2239j.m8899p()) {
            if (C2224x.m8805e().mo9549a((CharSequence) str)) {
                CBLogging.m8154b("Chartboost", "showRewardedVideo location cannot be empty");
                Handler handler = n.f7591y;
                C2117a aVar = n.f7588v;
                aVar.getClass();
                handler.post(new C2117a.C2118a(4, str, CBError.CBImpressionError.INVALID_LOCATION, (C2070b) null));
                return;
            }
            C2093h hVar = n.f7589w.get();
            if ((!hVar.f7023w || !hVar.f6997B) && (!hVar.f7005e || !hVar.f7010j)) {
                Handler handler2 = n.f7591y;
                C2117a aVar2 = n.f7588v;
                aVar2.getClass();
                handler2.post(new C2117a.C2118a(4, str, CBError.CBImpressionError.END_POINT_DISABLED, (C2070b) null));
                return;
            }
            C2143g gVar = n.f7587u;
            gVar.getClass();
            n.f7579m.execute(new C2143g.C2145b(4, str, (C2151h) null, (CBError.CBImpressionError) null));
        }
    }

    private static void showRewardedVideoAIR(String str, boolean z) {
        C2239j n = C2239j.m8897n();
        if (n != null && C2101c.m8331c() && C2239j.m8899p()) {
            C2093h hVar = n.f7589w.get();
            if ((!hVar.f7023w || !hVar.f6997B) && (!hVar.f7005e || !hVar.f7010j)) {
                C2242k.f7604d.didFailToLoadRewardedVideo(str, CBError.CBImpressionError.END_POINT_DISABLED);
                return;
            }
            Handler handler = n.f7591y;
            C2117a aVar = n.f7584r;
            aVar.getClass();
            handler.post(new C2117a.C2118a(4, str, CBError.CBImpressionError.INTERNAL, (C2070b) null));
        }
    }

    @Deprecated
    public static void startWithAppId(Activity activity, String str, String str2) {
        if (activity == null) {
            CBLogging.m8154b("Chartboost", "Can't start SDK with null activity");
        } else {
            startWithAppId(activity.getApplicationContext(), str, str2);
        }
    }

    public static void setMediation(CBMediation cBMediation, String str, String str2) {
        C2166i1.m8609a("Chartboost.setMediation");
        C2115h hVar = new C2115h(3);
        hVar.f7092d = str;
        hVar.f7093e = new C2149g1(cBMediation.toString() + " " + str, str, str2);
        C2239j.m8896b((Runnable) hVar);
    }

    public static void startWithAppId(Context context, String str, String str2) {
        C2242k.f7601a = "​!SDK-VERSION-STRING!:​com.chartboost.sdk:android-sdk:8.0.3";
        C2166i1.m8610a("Chartboost.startWithAppId", (Object) context);
        C2115h hVar = new C2115h(0);
        hVar.f7097i = context;
        hVar.f7098j = str;
        hVar.f7099k = str2;
        C2239j.m8896b((Runnable) hVar);
        m8148a();
    }

    public static void cacheInterstitial(String str, String str2) {
        C2166i1.m8611a("Chartboost.cacheHeliumInterstitial", str);
        C2236z.m8883a(str, str2, 0);
    }

    public static void cacheRewardedVideo(String str, String str2) {
        C2166i1.m8611a("Chartboost.cacheHeliumRewardedVideo", str);
        C2236z.m8883a(str, str2, 1);
    }
}
