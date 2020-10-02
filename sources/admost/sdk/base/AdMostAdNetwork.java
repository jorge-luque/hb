package admost.sdk.base;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AdMostAdNetwork {
    public static final String A4G = "A4G";
    public static final String ADCOLONY = "ADCOLONY";
    public static final String ADGEM = "ADGEM";
    public static final String ADMIXER = "ADMIXER";
    public static final String ADMOB = "ADMOB";
    public static final String ADMOST = "ADMOST";
    public static final String ADTIMING = "ADTIMING";
    public static final String ADTRIAL = "ADTRIAL";
    public static final String ADVIEW = "ADVIEW";
    public static final String ADX = "ADX";
    public static final String AIRPUSH = "AIRPUSH";
    public static final String AMAZON = "AMAZON";
    public static final String APPLOVIN = "APPLOVIN";
    public static final String APPNEXT = "APPNEXT";
    public static final String APPSAMURAI = "APPSAMURAI";
    public static final String AVAZU = "AVAZU";
    public static final String BAIDU = "BAIDU";
    public static final String CHARTBOOST = "CHARTBOOST";
    public static final String CRITEO = "CRITEO";
    public static final String CROSSPROMOTION = "CROSSPROMOTION";
    public static final String DISPLAYIO = "DISPLAYIO";
    public static final String FACEBOOK = "FACEBOOK";
    public static final String FLURRY = "FLURRY";
    public static final String FRECORP = "FRECORP";
    public static final String FYBER = "FYBER";
    public static final String GLISPA = "GLISPA";
    public static final String HUAWEI = "HUAWEI";
    public static final String HYPRMX = "HYPRMX";
    public static final String INMOBI = "INMOBI";
    public static final String INNERACTIVE = "INNERACTIVE";
    public static final String IRONSOURCE = "IRONSOURCE";
    public static final String KIDOZ = "KIDOZ";
    public static final String LOOPME = "LOOPME";
    public static final String MINTEGRAL = "MINTEGRAL";
    public static final String MOBFOX = "MOBFOX";
    public static final String MOBUPPS = "MOBUPPS";
    public static final String MOPUB = "MOPUB";
    public static final String MYTARGET = "MYTARGET";
    public static final String NATIVEX = "NATIVEX";
    public static final String NEND = "NEND";
    public static final String NEXAGE = "NEXTAGE";
    public static final String NO_NETWORK = "NO_NETWORK";
    public static final String OGURY = "OGURY";
    public static final String OPENX = "OPENX";
    public static final String OUTBID = "OUTBID";
    public static final String POKKT = "POKKT";
    public static final String POLLFISH = "POLLFISH";
    public static final String PREMIUM = "PREMIUM";
    public static final String PUBNATIVE = "PUBNATIVE";
    public static final String QUMPARA = "QUMPARA";
    public static final String REVMOB = "REVMOB";
    public static final String SMAATO = "SMAATO";
    public static final String STARTAPP = "STARTAPP";
    public static final String SVG = "SVG";
    public static final String TAPJOY = "TAPJOY";
    public static final String TAPPX = "TAPPX";
    public static final String TAPRESEARCH = "TAPRESEARCH";
    public static final String TIKTOK = "TIKTOK";
    public static final String UNITY = "UNITYAD";
    public static final String VERIZON = "VERIZON";
    public static final String VERVE = "VERVE";
    public static final String VUNGLE = "VUNGLE";
    public static final String YANDEX = "YANDEX";
    public static final String YOUAPPI = "YOUAPPI";
    static final String[] availableAdNetworks = getAvailableAdNetworks();
    static final String[] availableBidAdNetworks = getAvailableBidAdNetworks();
    public static final ConcurrentHashMap<String, String> childParentNetworkMap = new ConcurrentHashMap<String, String>() {
        {
            put(AdMostAdNetwork.A4G, AdMostAdNetwork.ADMOB);
            put(AdMostAdNetwork.ADX, AdMostAdNetwork.ADMOB);
            put(AdMostAdNetwork.CROSSPROMOTION, AdMostAdNetwork.ADMOST);
            put(AdMostAdNetwork.PREMIUM, AdMostAdNetwork.ADMOST);
        }
    };
    static final String[] network = {"com.adcolony.sdk.AdColony ADCOLONY admost.sdk.networkadapter.AdMostAdcolonyBiddingManager", "com.adgem.android.AdGem ADGEM", "net.admixer.sdk.AdView ADMIXER", "com.google.android.gms.ads.MobileAds ADMOB", "com.adtiming.mediationsdk.InitCallback ADTIMING", "com.adtrial.sdk.AdTrial ADTRIAL", "com.kuaiyou.loader.AdViewBannerManager ADVIEW", "com.ap.AirPush AIRPUSH", "com.amazon.device.ads.AdLayout AMAZON", "com.applovin.sdk.AppLovinSdk APPLOVIN", "com.appnext.ads.interstitial.Interstitial APPNEXT", "com.appsamurai.ads.interstitial.InterstitialAd APPSAMURAI", "nativesdk.ad.common.manager.PermissionManager AVAZU", "com.duapps.ad.base.DuAdNetwork BAIDU", "com.chartboost.sdk.Chartboost CHARTBOOST", "com.criteo.publisher.Criteo CRITEO com.criteo.publisher.BidResponse", "com.brandio.ads.Controller DISPLAYIO", "com.facebook.ads.InterstitialAd FACEBOOK admost.sdk.networkadapter.AdMostFacebookBiddingManager", "com.flurry.android.FlurryAgent FLURRY", "com.frecorp.AdView FRECORP", "com.fyber.requesters.RequestCallback FYBER", "com.avocarrot.sdk.Avocarrot GLISPA", "com.huawei.hms.ads.AdParam HUAWEI", "com.hyprmx.android.sdk.core.HyprMX HYPRMX", "com.inmobi.sdk.InMobiSdk INMOBI", "com.fyber.inneractive.sdk.external.InneractiveAdManager INNERACTIVE", "com.ironsource.mediationsdk.IronSource IRONSOURCE", "com.kidoz.sdk.api.KidozInterstitial KIDOZ", "com.loopme.LoopMeBanner LOOPME", "com.mintegral.msdk.MIntegralSDK MINTEGRAL com.mintegral.msdk.mtgbid.out.BidManager", "com.mobfox.android.MobfoxSDK MOBFOX", "com.smartadserver.android.library.model.SASAdStatus MOBUPPS", "com.mopub.common.MoPub MOPUB", "com.my.target.ads.MyTargetView MYTARGET", "com.nativex.monetization.MonetizationManager NATIVEX", "net.nend.android.NendAdListener NEND", "com.millennialmedia.InlineAd NEXTAGE", "io.presage.common.AdConfig OGURY", "com.openx.view.plugplay.views.AdView OPENX", "outbid.com.outbidsdk.OutbidManager OUTBID", "com.pokkt.PokktAds POKKT", "com.pollfish.main.PollFish POLLFISH", "net.pubnative.lite.sdk.PNLite PUBNATIVE", "com.qumpara.offerwall.sdk.core.QumparaOfferwall QUMPARA", "rm.com.android.sdk.Rm REVMOB", "com.smaato.soma.interstitial.Interstitial SMAATO", "com.startapp.sdk.adsbase.StartAppSDK STARTAPP", "seventynine.sdk.SeventynineAdSDK SVG", "com.tapjoy.Tapjoy TAPJOY", "com.tappx.sdk.android.AdRequest TAPPX", "com.tapr.sdk.TapResearch TAPRESEARCH", "com.bytedance.sdk.openadsdk.TTAdSdk TIKTOK", "com.unity3d.ads.UnityAds UNITYAD", "com.verizon.ads.edition.StandardEdition VERIZON", "com.vervewireless.advert.AdView VERVE", "com.vungle.warren.Vungle VUNGLE", "com.yandex.mobile.ads.MobileAds YANDEX", "com.youappi.sdk.YouAPPi YOUAPPI", "admost.adserver.ads.AdMostFullScreenAd ADMOST", "admost.adserver.ads.AdMostFullScreenAd CROSSPROMOTION", "admost.adserver.ads.AdMostFullScreenAd PREMIUM"};

    public static class AdapterHelper {
        public static final String ADMOB_17_2_SUFFIX = "1720";
        public static final String BANNER_ADAPTER_PREFIX = "Banner";
        public static final String DEFAULT_ADAPTER_PREFIX = "admost.sdk.networkadapter.AdMost";
        public static final String DEFAULT_ADAPTER_SUFFIX = "Adapter";
        public static final String FULLSCREEN_ADAPTER_PREFIX = "FullScreen";
        public static final String INIT_ADAPTER_PREFIX = "Init";
    }

    static String[] getAvailableAdNetworks() {
        ArrayList arrayList = new ArrayList();
        for (String split : network) {
            String[] split2 = split.split("\\ ");
            if (AdMostUtil.isClassAvailable(split2[0])) {
                arrayList.add(split2[1]);
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    static String[] getAvailableBidAdNetworks() {
        ArrayList arrayList = new ArrayList();
        for (String split : network) {
            String[] split2 = split.split("\\ ");
            if (split2.length > 2 && AdMostUtil.isClassAvailable(split2[2])) {
                arrayList.add(split2[1]);
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static String getBaseNetwork(String str) {
        for (Map.Entry next : childParentNetworkMap.entrySet()) {
            if (!str.equals("") && ((String) next.getKey()).equals(str)) {
                return (String) next.getValue();
            }
        }
        return null;
    }

    public static boolean hasBaseNetworkAdapter(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        if (!(str.equals(str2) || str.equals(getBaseNetwork(str2)))) {
            return false;
        }
        return isAdNetworkAvailable(str);
    }

    public static boolean isAdNetworkAvailable(String str) {
        String baseNetwork = getBaseNetwork(str);
        for (String str2 : availableAdNetworks) {
            if (str.equals(str2)) {
                return true;
            }
            if (baseNetwork != null && baseNetwork.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isBidAdNetworkAvailable(String str) {
        String baseNetwork = getBaseNetwork(str);
        for (String str2 : availableBidAdNetworks) {
            if (str.equals(str2)) {
                return true;
            }
            if (baseNetwork != null && baseNetwork.equals(str2)) {
                return true;
            }
        }
        return false;
    }
}
