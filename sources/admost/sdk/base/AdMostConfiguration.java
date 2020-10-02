package admost.sdk.base;

import admost.sdk.AdMostInstallReferrer;
import admost.sdk.base.AdMostAppLifecycle;
import admost.sdk.base.AdMostGenericRequest;
import admost.sdk.interfaces.AdMostAdNetworkInitInterface;
import admost.sdk.listener.AdmostResponseListener;
import admost.sdk.model.AdMostAdNetworkMeta;
import admost.sdk.model.AdMostReferrerObject;
import admost.sdk.model.AdMostServerException;
import admost.sdk.model.FloorPriceConfig;
import admost.sdk.model.RandomizerConfig;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.AnalyticsEvents;
import com.ogury.p159cm.OguryChoiceManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import org.json.JSONArray;
import org.json.JSONObject;
import p118io.fabric.sdk.android.p200m.p202b.C6078a;

public final class AdMostConfiguration {
    Activity activity;
    private LinkedHashMap<String, AdMostAdNetworkMeta> adNetworkMetaList;
    private boolean advertisingIdReady;
    private int age;
    private String appId;
    private AdMostBannerZoneCache[] cacheZones;
    final ThreadPoolExecutor executor;
    private FloorPriceConfig floorPriceConfig;
    private int gender;
    private boolean hasForceInit;
    private boolean hasInstallReferrerReceiver;
    private Handler initHandler;
    private InitParams initParams;
    private int initTryCount;
    private String interests;
    private boolean isChild;
    private boolean isHuaweiApp;
    final AdMostAppLifecycle lifecycleCallbacks;
    private boolean networkInitiatedOnInit;
    private boolean noAd;
    private String olderThanSixteen;
    private List<String> passiveTags;
    private RandomizerConfig randomizerConfig;
    /* access modifiers changed from: private */
    public ArrayList<BroadcastReceiver> referrerListeners;
    private boolean registerOrUpdateRequired;
    private String subjectToCCPA;
    private String subjectToGDPR;
    private Map<String, ArrayList<String>> testDevices;
    private boolean testSuiteWorking;
    private Set<String> testerEnabledNetworks;
    private ConcurrentHashMap<String, TesterMeta> testerIds;
    private TesterMeta testerMeta;
    private boolean useHttps;
    private String userConsent;

    public static class Builder {
        /* access modifiers changed from: private */
        public Activity activity;
        /* access modifiers changed from: private */
        public int age = 0;
        /* access modifiers changed from: private */
        public String appId;
        /* access modifiers changed from: private */
        public AdMostBannerZoneCache[] cacheZones;
        /* access modifiers changed from: private */
        public int gender = -1;
        /* access modifiers changed from: private */
        public String interests;
        /* access modifiers changed from: private */
        public boolean isChild = false;
        /* access modifiers changed from: private */
        public boolean isHttpLoggingEnabled;
        /* access modifiers changed from: private */
        public boolean isHuaweiApp;
        /* access modifiers changed from: private */
        public Level logLevel;
        /* access modifiers changed from: private */
        public boolean noAd;
        /* access modifiers changed from: private */
        public String olderThanSixteen = "-1";
        /* access modifiers changed from: private */
        public String subjectToCCPA = "-1";
        /* access modifiers changed from: private */
        public String subjectToGDPR = "-1";
        /* access modifiers changed from: private */
        public ConcurrentHashMap<String, ArrayList<String>> testDevices;
        /* access modifiers changed from: private */
        public Set<String> testerEnabledNetworks;
        /* access modifiers changed from: private */
        public boolean useHttps;
        /* access modifiers changed from: private */
        public String userConsent = "-1";

        public Builder(Activity activity2, String str) {
            this.activity = activity2;
            this.appId = str;
        }

        /* access modifiers changed from: private */
        public void clearGC() {
            this.activity = null;
            this.cacheZones = null;
            this.testDevices = null;
        }

        public void addTestDevice(String str, String... strArr) {
            if (this.testDevices == null) {
                this.testDevices = new ConcurrentHashMap<>();
            }
            this.testDevices.put(str, new ArrayList(Arrays.asList(strArr)));
        }

        public void age(int i) {
            this.age = i;
        }

        public AdMostConfiguration build() {
            AdMostConfiguration configuration = AdMost.getInstance().getConfiguration();
            if (configuration == null) {
                return new AdMostConfiguration(this);
            }
            configuration.arrangeAdMostAppLifecycleCallbacks(true);
            configuration.setActivity(this.activity);
            configuration.arrangeAdMostAppLifecycleCallbacks(false);
            clearGC();
            return configuration;
        }

        public void cacheZones(AdMostBannerZoneCache[] adMostBannerZoneCacheArr) {
            this.cacheZones = adMostBannerZoneCacheArr;
        }

        public void enableNoAd() {
            this.noAd = true;
        }

        public void enableOnlySubsetOfAdNetworksForTesters(Set<String> set) {
            if (this.testerEnabledNetworks == null) {
                this.testerEnabledNetworks = new HashSet();
            }
            if (set != null && set.size() > 0) {
                this.testerEnabledNetworks.addAll(set);
            }
        }

        public void gender(int i) {
            this.gender = i;
        }

        public void interests(String str) {
            this.interests = str;
        }

        public void isOlderThanSixteen(boolean z) {
            this.olderThanSixteen = z ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }

        public void logLevel(Level level) {
            this.logLevel = level;
        }

        public void setAsHuaweiApp() {
            this.isHuaweiApp = true;
        }

        public void setHttpLoggingEnabled(boolean z) {
            this.isHttpLoggingEnabled = z;
        }

        public void setSubjectToCCPA(boolean z) {
            this.subjectToCCPA = z ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }

        public void setSubjectToGDPR(boolean z) {
            this.subjectToGDPR = z ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }

        public void setUseHttps() {
            this.useHttps = true;
        }

        public void setUserChild(boolean z) {
            this.isChild = z;
        }

        public void setUserConsent(boolean z) {
            this.userConsent = z ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
    }

    public static class InitParams implements Cloneable {
        /* access modifiers changed from: private */
        public boolean adStatsEnabled;
        /* access modifiers changed from: private */
        public int adStatsPercentage;
        boolean adjustDisabled;
        boolean adminModeEnabled;
        /* access modifiers changed from: private */
        public boolean analyticsEnabled;
        boolean appsFlyerDisabled;
        int bidTimeout;
        boolean debugPurchaseForTesters;
        boolean disableAdStatusChanged;
        /* access modifiers changed from: private */
        public boolean forceServerCampaignId;
        boolean hasCampaign;
        boolean hasPolicy;
        boolean hasSubscription;
        int impressionSendPeriod;
        boolean returnOnFailToShowResponseOnFirstFail;
        /* access modifiers changed from: private */
        public boolean useMedApiHttps;
        boolean userDataEnabled;
        String verifier;

        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        /* access modifiers changed from: package-private */
        public void enrichWithExperimentJSON(JSONObject jSONObject) {
            if (jSONObject != null) {
                try {
                    JSONObject optJSONObject = jSONObject.optJSONObject("Meta");
                    if (optJSONObject != null && !optJSONObject.equals(JSONObject.NULL)) {
                        this.bidTimeout = optJSONObject.optInt("BidTimeout", this.bidTimeout);
                        this.returnOnFailToShowResponseOnFirstFail = optJSONObject.has("FailToShowOnFirstFail") ? optJSONObject.getBoolean("FailToShowOnFirstFail") : this.returnOnFailToShowResponseOnFirstFail;
                        this.impressionSendPeriod = optJSONObject.optInt("ImpressionSendPeriod", this.impressionSendPeriod);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void initialize(JSONObject jSONObject) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("Meta");
                if (optJSONObject != null && !optJSONObject.equals(JSONObject.NULL)) {
                    this.analyticsEnabled = optJSONObject.optBoolean("AnalyticsEnabled", false);
                    this.impressionSendPeriod = optJSONObject.optInt("ImpressionSendPeriod", 0);
                    this.bidTimeout = optJSONObject.optInt("BidTimeout", 2000);
                    this.returnOnFailToShowResponseOnFirstFail = optJSONObject.optBoolean("FailToShowOnFirstFail", false);
                    this.adminModeEnabled = optJSONObject.optBoolean("AdminMode", false);
                    this.debugPurchaseForTesters = optJSONObject.optBoolean("DebugPurchaseForTesters", false);
                    this.userDataEnabled = optJSONObject.optBoolean("UserDataEnabled", false);
                    this.adStatsEnabled = optJSONObject.optBoolean("AdStatsEnabled", false);
                    this.adStatsPercentage = optJSONObject.optInt("AdStatsPercentage", 0);
                    this.adjustDisabled = optJSONObject.optBoolean("AdjustDisabled", false);
                    this.appsFlyerDisabled = optJSONObject.optBoolean("AppsflyerDisabled", false);
                    this.disableAdStatusChanged = optJSONObject.optBoolean("DisableAdStatusChanged", false);
                    if (optJSONObject.has("UserDataMinSdkVersion")) {
                        int optInt = optJSONObject.optInt("UserDataMinSdkVersion", 0);
                        String[] split = AdMost.getInstance().getVersion().split("\\.");
                        if (split.length == 3) {
                            boolean z = this.userDataEnabled && ((Integer.parseInt(split[0]) * C6078a.DEFAULT_TIMEOUT) + (Integer.parseInt(split[1]) * 100)) + Integer.parseInt(split[2]) >= optInt;
                            this.userDataEnabled = z;
                            if (!z) {
                                AdMostPreferences.getInstance().setUserDataForManager("");
                            }
                        }
                    }
                    this.useMedApiHttps = optJSONObject.optBoolean("UseMedApiHttps", true);
                }
                this.hasCampaign = jSONObject.optBoolean("HasCampaign", false);
                this.hasSubscription = jSONObject.optBoolean("HasSubscription", false);
                this.verifier = jSONObject.optString("SV", (String) null);
                this.forceServerCampaignId = jSONObject.optBoolean("ForceServerCampaignId", false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static class TesterMeta {
        public boolean isAdNetworkLogsEnabled;
        public boolean isTestAdsEnabled;
        public boolean isTester;
        public boolean startTestSuiteOnLaunh;
    }

    /* access modifiers changed from: private */
    public void arrangeDebugMode(String str) {
        TesterMeta testerMeta2;
        if (this.testerIds.containsKey(str)) {
            this.testerMeta = this.testerIds.get(str);
        } else if (this.testerIds.containsKey(str.toUpperCase(Locale.ENGLISH))) {
            this.testerMeta = this.testerIds.get(str.toUpperCase(Locale.ENGLISH));
        }
        TesterMeta testerMeta3 = this.testerMeta;
        AdMostLog.setLogEnabled(testerMeta3 != null && testerMeta3.isTester);
        if (!this.testSuiteWorking && AdMostLog.isEnabled() && (testerMeta2 = this.testerMeta) != null && testerMeta2.startTestSuiteOnLaunh) {
            this.testSuiteWorking = true;
            AdMost.getInstance().startTestSuite();
        }
    }

    private void getAdvertisingId() {
        AdMostAdvertisingIdTask adMostAdvertisingIdTask;
        if (!showPersonalizedAdForGDPR() || !showPersonalizedAdForCCPA()) {
            if (this.userConsent.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO) && (this.subjectToGDPR.equals("1") || this.subjectToCCPA.equals("1"))) {
                AdMostPreferences.getInstance().setAdvId("");
            }
            if (this.registerOrUpdateRequired) {
                if (!AdMostAnalyticsManager.getInstance().register()) {
                    AdMostAnalyticsManager.getInstance().update();
                }
                this.registerOrUpdateRequired = false;
            }
            this.advertisingIdReady = true;
            InstallReferrerReceiver.trackCampaign(false);
            String userId = AdMostAnalyticsManager.getInstance().getUserId();
            if (!AdMostLog.isEnabled()) {
                AdMostLog.all("To enable AMR tester mode use this id : <" + userId + "> on AMR dashboard Manage Testers page!!");
            }
            arrangeDebugMode(userId);
            return;
        }
        final String advId = AdMostPreferences.getInstance().getAdvId();
        if (!advId.equals("")) {
            arrangeDebugMode(advId);
        }
        C01942 r1 = new AdmostResponseListener<JSONObject>() {
            public void onError(String str, Exception exc) {
                exc.printStackTrace();
                try {
                    String userId = AdMostAnalyticsManager.getInstance().getUserId();
                    if (!AdMostLog.isEnabled()) {
                        AdMostLog.all("To enable AMR tester mode use this id : <" + userId + "> on AMR dashboard Manage Testers page!");
                    }
                    AdMostConfiguration.this.arrangeDebugMode(userId);
                    AdMostConfiguration.this.updateUserInfo();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void onResponse(JSONObject jSONObject) {
                try {
                    String optString = jSONObject.optString("advId", "");
                    boolean optBoolean = jSONObject.optBoolean("isLimitAdTrackingEnabled");
                    String optString2 = jSONObject.optString("store");
                    if (optBoolean) {
                        AdMostPreferences.getInstance().setAdvId("");
                        optString = AdMostAnalyticsManager.getInstance().getUserId();
                    } else if (optString != null && !optString.equals("") && !advId.equals(optString)) {
                        AdMostPreferences.getInstance().setAdvId(optString);
                    } else if (optString == null || optString.equals("")) {
                        optString = AdMostAnalyticsManager.getInstance().getUserId();
                    }
                    if (!AdMostLog.isEnabled()) {
                        AdMostLog.all("To enable AMR tester mode use this id : " + optString + " ** store : " + optString2 + " ** isLimitAdTrackingEnabled : " + optBoolean);
                    } else {
                        AdMostLog.m299i("Advertising info used in AMR -- id : " + optString + " ** store : " + optString2 + " ** isLimitAdTrackingEnabled : " + optBoolean);
                    }
                    AdMostConfiguration.this.arrangeDebugMode(optString);
                    AdMostConfiguration.this.updateUserInfo();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        if (!this.isHuaweiApp || !AdMostUtil.isClassAvailable("com.huawei.hms.ads.identifier.AdvertisingIdClient") || !AdMostUtil.isClassAvailable("admost.sdk.networkadapter.AdMostHuaweiAdvertisingIdTask")) {
            adMostAdvertisingIdTask = new AdMostAdvertisingIdTask();
        } else {
            try {
                adMostAdvertisingIdTask = (AdMostAdvertisingIdTask) Class.forName("admost.sdk.networkadapter.AdMostHuaweiAdvertisingIdTask").newInstance();
            } catch (Exception e) {
                e.printStackTrace();
                adMostAdvertisingIdTask = new AdMostAdvertisingIdTask();
            }
        }
        adMostAdvertisingIdTask.setParameters(this.activity.getApplicationContext(), r1);
        adMostAdvertisingIdTask.execute(new Void[0]);
    }

    /* access modifiers changed from: private */
    public void initResponse(JSONObject jSONObject, boolean z) {
        boolean z2;
        this.testerIds = new ConcurrentHashMap<>();
        this.adNetworkMetaList = new LinkedHashMap<>();
        try {
            if (jSONObject.has("Networks") && jSONObject.get("Networks") != null && !jSONObject.get("Networks").equals(JSONObject.NULL)) {
                JSONArray jSONArray = jSONObject.getJSONArray("Networks");
                for (int i = 0; i < jSONArray.length(); i++) {
                    AdMostAdNetworkMeta adMostAdNetworkMeta = new AdMostAdNetworkMeta(jSONArray.getJSONObject(i));
                    if (!this.hasForceInit) {
                        if (!adMostAdNetworkMeta.isForceInit()) {
                            z2 = false;
                            this.hasForceInit = z2;
                            this.adNetworkMetaList.put(adMostAdNetworkMeta.getName(), adMostAdNetworkMeta);
                        }
                    }
                    z2 = true;
                    this.hasForceInit = z2;
                    this.adNetworkMetaList.put(adMostAdNetworkMeta.getName(), adMostAdNetworkMeta);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.initParams.initialize(jSONObject);
        try {
            if (jSONObject.has("Testers") && jSONObject.get("Testers") != null && !jSONObject.get("Testers").equals(JSONObject.NULL)) {
                JSONArray jSONArray2 = jSONObject.getJSONArray("Testers");
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i2);
                    String string = jSONObject2.getString("ID");
                    TesterMeta testerMeta2 = new TesterMeta();
                    testerMeta2.isTester = true;
                    testerMeta2.startTestSuiteOnLaunh = jSONObject2.optBoolean("IsAdmin", false);
                    testerMeta2.isAdNetworkLogsEnabled = jSONObject2.optBoolean("AdNetworkLogs", false);
                    testerMeta2.isTestAdsEnabled = jSONObject2.optBoolean("TestAds", false);
                    this.testerIds.put(string, testerMeta2);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            if (this.initParams.analyticsEnabled) {
                AdMostAnalyticsManager.getInstance().setAnalyticsDisabled(false);
                this.registerOrUpdateRequired = true;
            } else {
                AdMostAnalyticsManager.getInstance().setAnalyticsDisabled(true);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        try {
            if (jSONObject.has("RandomizerConfig")) {
                this.randomizerConfig = new RandomizerConfig(jSONObject.getJSONObject("RandomizerConfig"));
            } else {
                this.randomizerConfig = new RandomizerConfig(new JSONObject("{Params:[{\"P\":75,\"M\":10},{\"P\":50,\"M\":5}]}"));
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        try {
            if (jSONObject.has("FPConfig")) {
                this.floorPriceConfig = new FloorPriceConfig(jSONObject.getJSONObject("FPConfig"));
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        try {
            if (jSONObject.has("PassiveTags")) {
                JSONArray jSONArray3 = jSONObject.getJSONArray("PassiveTags");
                for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                    this.passiveTags.add(jSONArray3.optString(i3, ""));
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        try {
            if (!jSONObject.has("Experiment") || jSONObject.get("Experiment") == null || jSONObject.get("Experiment").equals(JSONObject.NULL)) {
                AdMostExperimentManager.getInstance().joinExperiment((JSONArray) null);
            } else {
                AdMostExperimentManager.getInstance().joinExperiment(jSONObject.getJSONArray("Experiment"));
            }
        } catch (Exception e7) {
            AdMostExperimentManager.getInstance().joinExperiment((JSONArray) null);
            e7.printStackTrace();
        }
        getAdvertisingId();
        if (z) {
            if (AdMostLog.isIsHTTPLoggingEnabled()) {
                AdMostLog.json(jSONObject, "Admost initialized from cache");
            } else {
                AdMostLog.m299i("Admost initialized from cache");
            }
        }
        if (this.noAd) {
            AdMostLog.m303w("None of the networks initialized...");
            setInitCompleted(false);
        } else {
            AdMostBannerZoneCache[] adMostBannerZoneCacheArr = this.cacheZones;
            if (adMostBannerZoneCacheArr != null && adMostBannerZoneCacheArr.length > 0) {
                AdMostBannerZoneCacheManager.getInstance().registerInit(this.cacheZones);
            }
            startNetworkInitProcess();
        }
        queryExistingSubscriptions();
    }

    /* access modifiers changed from: private */
    public void initializeFromCache() {
        if (this.activity != null || AdMost.getInstance().getActivity() != null) {
            AdmostResponseCache fromCache = AdMostGenericRequest.getFromCache(AdMostGenericRequest.RequestType.INIT_RESPONSE, "INIT");
            if (fromCache != null) {
                initResponse(fromCache.getJsonObject(), true);
            } else {
                scheduleDelayedTry();
            }
        }
    }

    private void queryExistingSubscriptions() {
        boolean z = this.initParams.hasSubscription;
    }

    private void scheduleDelayedTry() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            public void run() {
                AdMostLog.m299i("Initialization scheduled");
                AdMostConfiguration.this.makeInitRequest();
            }
        }, (long) (this.initTryCount * 5000));
    }

    private void setInitCompleted(boolean z) {
        this.networkInitiatedOnInit = z;
        AdMost.getInstance().initCompleted("CONFIGURATION");
    }

    private void setInstallReferrers() {
        AdMostInstallReferrer.getInstance().addObserver(new Observer() {
            public void update(Observable observable, Object obj) {
                StringBuilder sb = new StringBuilder();
                sb.append("Referrer Received = ");
                AdMostReferrerObject adMostReferrerObject = (AdMostReferrerObject) obj;
                sb.append(adMostReferrerObject.getReferrer());
                AdMostLog.m299i(sb.toString());
                if (AdMostConfiguration.this.referrerListeners != null) {
                    for (int i = 0; i < AdMostConfiguration.this.referrerListeners.size(); i++) {
                        ((BroadcastReceiver) AdMostConfiguration.this.referrerListeners.get(i)).onReceive(adMostReferrerObject.getContext(), adMostReferrerObject.getIntent());
                    }
                }
            }
        });
        if (AdMostUtil.isClassAvailable("com.android.installreferrer.api.InstallReferrerClient")) {
            this.hasInstallReferrerReceiver = true;
            new AdMostGoogleAdmostReferrerApi().setInstallReferrer();
        }
        try {
            ActivityInfo receiverInfo = this.activity.getApplicationContext().getPackageManager().getReceiverInfo(new ComponentName(this.activity.getApplicationContext(), InstallReferrerReceiver.class), OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
            if (receiverInfo != null) {
                this.hasInstallReferrerReceiver = true;
            }
            if (receiverInfo != null && receiverInfo.metaData != null) {
                if (receiverInfo.metaData.size() > 0) {
                    Bundle bundle = receiverInfo.metaData;
                    for (int i = 0; i < 5; i++) {
                        try {
                            String string = bundle.getString("admost.install.referrer." + i);
                            if (string != null) {
                                Class<?> cls = Class.forName(string);
                                if (cls.newInstance() instanceof BroadcastReceiver) {
                                    if (this.referrerListeners == null) {
                                        this.referrerListeners = new ArrayList<>();
                                    }
                                    this.referrerListeners.add((BroadcastReceiver) cls.newInstance());
                                }
                            }
                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        } catch (ClassNotFoundException e2) {
                            e2.printStackTrace();
                        } catch (IllegalAccessException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void startNetworkInitProcess() {
        setInitCompleted(this.hasForceInit);
        if (AdMostLog.isEnabled()) {
            AdMostLog.logAvailableNetworks();
        }
        AdMostLog.m299i("AdMost Version: [2.1.7]");
        AdMostLog.m299i("AdMost Application Id: [" + this.appId + "]");
        AdMostLog.m294d("AdMost Version Build: [45db3bc]");
    }

    /* access modifiers changed from: private */
    public void updateUserInfo() {
        if (this.registerOrUpdateRequired) {
            if (!AdMostAnalyticsManager.getInstance().register()) {
                AdMostAnalyticsManager.getInstance().update();
            }
            this.registerOrUpdateRequired = false;
        }
        this.advertisingIdReady = true;
        InstallReferrerReceiver.trackCampaign(false);
    }

    /* access modifiers changed from: package-private */
    @TargetApi(14)
    public void arrangeAdMostAppLifecycleCallbacks(boolean z) {
        if (Build.VERSION.SDK_INT >= 14) {
            AdMost.getInstance().getActivity().getApplication().unregisterActivityLifecycleCallbacks(this.lifecycleCallbacks);
            if (!z) {
                AdMost.getInstance().getActivity().getApplication().registerActivityLifecycleCallbacks(this.lifecycleCallbacks);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean debugPurchaseForTesters() {
        return this.initParams.debugPurchaseForTesters;
    }

    public boolean disableAdStatusChanged() {
        return this.initParams.disableAdStatusChanged;
    }

    /* access modifiers changed from: package-private */
    public AdMostAdNetworkMeta getAdNetworkMeta(String str) {
        LinkedHashMap<String, AdMostAdNetworkMeta> linkedHashMap;
        if (str == null || (linkedHashMap = this.adNetworkMetaList) == null || linkedHashMap.get(str) == null) {
            return null;
        }
        return this.adNetworkMetaList.get(str);
    }

    /* access modifiers changed from: package-private */
    public int getAge() {
        return this.age;
    }

    /* access modifiers changed from: package-private */
    public String getAppId() {
        return this.appId;
    }

    public JSONObject getBidConfig(String str) {
        AdMostAdNetworkMeta adNetworkMeta = AdMostExperimentManager.getInstance().getAdNetworkMeta(str, (String) null, false, false, AdMostAnalyticsManager.getInstance().isNewUser());
        if (adNetworkMeta != null) {
            return adNetworkMeta.getBidConfig();
        }
        return null;
    }

    public int getBidTimeout(String str, boolean z) {
        int i = AdMostExperimentManager.getInstance().getInitParams(str, z).bidTimeout;
        if (i <= 0) {
            return 2000;
        }
        return i;
    }

    public String getCCPAIABPrivacyString() {
        return AdMost.getInstance().getConfiguration().showPersonalizedAdForCCPA() ? "1-N-" : "1-Y-";
    }

    /* access modifiers changed from: package-private */
    public FloorPriceConfig getFloorPriceConfig() {
        return this.floorPriceConfig;
    }

    /* access modifiers changed from: package-private */
    public int getGender() {
        return this.gender;
    }

    /* access modifiers changed from: package-private */
    public int getImpressionSendPeriod() {
        return this.initParams.impressionSendPeriod;
    }

    public String[] getInitId(String str) {
        AdMostAdNetworkMeta adNetworkMeta = AdMostExperimentManager.getInstance().getAdNetworkMeta(str, (String) null, false, false, AdMostAnalyticsManager.getInstance().isNewUser());
        if (adNetworkMeta != null) {
            return adNetworkMeta.getInitIds();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public InitParams getInitParams() {
        return this.initParams;
    }

    /* access modifiers changed from: package-private */
    public String getInterests() {
        return this.interests;
    }

    public int getMaxRequestPerWaterfall(String str, String str2, boolean z, boolean z2) {
        AdMostAdNetworkMeta adNetworkMeta = AdMostExperimentManager.getInstance().getAdNetworkMeta(str, str2, z, z2, false);
        if (str == null) {
            return 0;
        }
        if (adNetworkMeta != null) {
            return adNetworkMeta.getMaxRequestCountPerWaterfall();
        }
        if (AdMostAdNetwork.hasBaseNetworkAdapter(AdMostAdNetwork.ADMOB, str)) {
            return 3;
        }
        return 0;
    }

    public RandomizerConfig getRandomizerConfig() {
        return this.randomizerConfig;
    }

    public ArrayList<String> getTestDeviceIds(String str) {
        if (this.testDevices == null) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        Map<String, ArrayList<String>> map = this.testDevices;
        if (map == null) {
            return arrayList;
        }
        for (Map.Entry next : map.entrySet()) {
            if (((String) next.getKey()).equals(str)) {
                return (ArrayList) next.getValue();
            }
        }
        return arrayList;
    }

    public String getUserConsent() {
        return this.userConsent;
    }

    /* access modifiers changed from: package-private */
    public String getUserConsentDescription() {
        String str = this.userConsent;
        if (str == null || str.equals("-1")) {
            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
        if (this.userConsent.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            return "Revoked";
        }
        return this.userConsent.equals("1") ? "Granted" : "Error";
    }

    /* access modifiers changed from: package-private */
    public String getVerifier() {
        return this.initParams.verifier;
    }

    /* access modifiers changed from: package-private */
    public boolean hasCampaign() {
        return this.initParams.hasCampaign;
    }

    /* access modifiers changed from: package-private */
    public boolean hasInstallReferrerReceiver() {
        return this.hasInstallReferrerReceiver;
    }

    /* access modifiers changed from: package-private */
    public boolean hasPolicy() {
        return this.initParams.hasPolicy;
    }

    /* access modifiers changed from: package-private */
    public void initDefault() {
    }

    /* access modifiers changed from: package-private */
    public void initForce() {
        LinkedHashMap<String, AdMostAdNetworkMeta> linkedHashMap = this.adNetworkMetaList;
        if (linkedHashMap != null && linkedHashMap.size() > 0) {
            for (String next : this.adNetworkMetaList.keySet()) {
                AdMostAdNetworkMeta adNetworkMeta = AdMostExperimentManager.getInstance().getAdNetworkMeta(next, (String) null, false, false, AdMostAnalyticsManager.getInstance().isNewUser());
                if (adNetworkMeta != null && adNetworkMeta.isForceInit()) {
                    initNetwork(next);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void initNetwork(final String str) {
        final AdMostAdNetworkInitInterface initAdapter = AdMostAdNetworkManager.getInstance().getInitAdapter(str);
        if (this.initHandler == null) {
            this.initHandler = new Handler(Looper.getMainLooper());
        }
        this.initHandler.post(new Runnable() {
            public void run() {
                String str;
                AdMostAdNetworkInitInterface adMostAdNetworkInitInterface = initAdapter;
                if (adMostAdNetworkInitInterface != null && !adMostAdNetworkInitInterface.hasInitializationError && adMostAdNetworkInitInterface.initRequired && !adMostAdNetworkInitInterface.isInitialized) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    if (AdMostAdNetwork.getBaseNetwork(str) == null) {
                        str = "";
                    } else {
                        str = "( " + AdMostAdNetwork.getBaseNetwork(str) + " )";
                    }
                    sb.append(str);
                    String sb2 = sb.toString();
                    if (initAdapter.getVersion().equals("not implemented") || initAdapter.getVersion().equals("")) {
                        AdMostLog.m299i(sb2 + " initialization started");
                    } else {
                        AdMostLog.m299i(sb2 + " version [" + initAdapter.getVersion() + "] initialization started");
                    }
                    initAdapter.initialize(AdMost.getInstance().getActivity(), AdMostConfiguration.this.getInitId(str));
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public boolean isAdNetworkForbiddenForUser(String str) {
        AdMostAdNetworkMeta adNetworkMeta = AdMostExperimentManager.getInstance().getAdNetworkMeta(str, (String) null, false, false, AdMostAnalyticsManager.getInstance().isNewUser());
        return adNetworkMeta != null && !adNetworkMeta.isGoogleCertified() && AdMost.getInstance().isUserChild();
    }

    /* access modifiers changed from: package-private */
    public boolean isAdNetworkLogsEnabled() {
        TesterMeta testerMeta2 = this.testerMeta;
        return testerMeta2 != null && testerMeta2.isAdNetworkLogsEnabled;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r1.testerEnabledNetworks;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isAdNetworkRestrictedForUser(java.lang.String r2) {
        /*
            r1 = this;
            boolean r0 = admost.sdk.base.AdMostLog.isEnabled()
            if (r0 == 0) goto L_0x0012
            java.util.Set<java.lang.String> r0 = r1.testerEnabledNetworks
            if (r0 == 0) goto L_0x0012
            boolean r2 = r0.contains(r2)
            if (r2 != 0) goto L_0x0012
            r2 = 1
            goto L_0x0013
        L_0x0012:
            r2 = 0
        L_0x0013:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: admost.sdk.base.AdMostConfiguration.isAdNetworkRestrictedForUser(java.lang.String):boolean");
    }

    /* access modifiers changed from: package-private */
    public boolean isAdStatsEnabled() {
        return this.appId.equals("c9ab73ca-ecb0-2e3a-3d00-56adc9ab3dca") || (this.initParams.adStatsEnabled && this.initParams.adStatsPercentage > AdMostPreferences.getInstance().getPercentile());
    }

    /* access modifiers changed from: package-private */
    public boolean isAdjustDisabled() {
        return this.initParams.adjustDisabled;
    }

    /* access modifiers changed from: package-private */
    public boolean isAdminModeEnabled() {
        return this.initParams.adminModeEnabled;
    }

    /* access modifiers changed from: package-private */
    public boolean isAdvertisingIdReady() {
        return this.advertisingIdReady;
    }

    /* access modifiers changed from: package-private */
    public boolean isAppsflyerDisabled() {
        return this.initParams.appsFlyerDisabled;
    }

    public boolean isCCPARequired() {
        return (this.subjectToCCPA.equals("1") || AdMostUtil.isInCCPA(AdMostPreferences.newInstance(AdMost.getInstance().getContext()))) && !this.subjectToCCPA.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO);
    }

    /* access modifiers changed from: package-private */
    public boolean isForceServerCampaignId() {
        return this.initParams.forceServerCampaignId;
    }

    public boolean isGDPRRequired() {
        return (this.subjectToGDPR.equals("1") || AdMostUtil.isInEU(AdMostPreferences.newInstance(AdMost.getInstance().getContext()))) && !this.subjectToGDPR.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO);
    }

    public boolean isShowConsentWindow(String str) {
        AdMostAdNetworkMeta adNetworkMeta = AdMostExperimentManager.getInstance().getAdNetworkMeta(str, (String) null, false, false, AdMostAnalyticsManager.getInstance().isNewUser());
        return adNetworkMeta != null && adNetworkMeta.isShowConsentWindow();
    }

    /* access modifiers changed from: package-private */
    public boolean isSoundMuted(String str) {
        AdMostAdNetworkMeta adNetworkMeta = AdMostExperimentManager.getInstance().getAdNetworkMeta(str, (String) null, false, false, AdMostAnalyticsManager.getInstance().isNewUser());
        return adNetworkMeta != null && adNetworkMeta.isSoundMuted();
    }

    /* access modifiers changed from: package-private */
    public boolean isTagPassive(String str) {
        List<String> list;
        if (str == null || str.equals("") || (list = this.passiveTags) == null || list.size() <= 0) {
            return false;
        }
        return this.passiveTags.contains(str);
    }

    public boolean isTestAdsEnabled() {
        TesterMeta testerMeta2 = this.testerMeta;
        return testerMeta2 != null && testerMeta2.isTestAdsEnabled;
    }

    /* access modifiers changed from: package-private */
    public boolean isUserChild() {
        return this.isChild;
    }

    /* access modifiers changed from: package-private */
    public boolean isUserDataEnabled() {
        return this.initParams.userDataEnabled;
    }

    /* access modifiers changed from: package-private */
    public void makeInitRequest() {
        this.initTryCount++;
        C01964 r0 = new AdmostResponseListener<JSONObject>() {
            public void onError(String str, Exception exc) {
                AdMostLog.all("ADMOST SDK Initialization error");
                if (exc != null) {
                    try {
                        if (exc.getCause() != null && (exc.getCause() instanceof AdMostServerException) && ((AdMostServerException) exc.getCause()).ServerResponseCode == 401) {
                            return;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                AdMostConfiguration.this.initializeFromCache();
            }

            public void onResponse(JSONObject jSONObject) {
                if (AdMostPreferences.getInstance() == null) {
                    AdMostPreferences.newInstance(AdMostConfiguration.this.activity.getApplicationContext());
                }
                if (jSONObject == null || jSONObject.length() <= 0) {
                    AdMostConfiguration.this.initializeFromCache();
                } else {
                    AdMostConfiguration.this.initResponse(jSONObject, false);
                }
            }
        };
        if (AdMostUtil.isNetworkAvailable(this.activity.getApplicationContext()) == 1) {
            new AdMostGenericRequest(AdMostGenericRequest.RequestType.INIT_RESPONSE, "", r0).mo611go("");
            return;
        }
        initializeFromCache();
    }

    /* access modifiers changed from: package-private */
    public boolean medApiHttps() {
        return this.initParams.useMedApiHttps;
    }

    public boolean returnOnFailToShowResponseOnFirstFail() {
        return this.initParams.returnOnFailToShowResponseOnFirstFail;
    }

    public void setActivity(Activity activity2) {
        this.activity = activity2;
    }

    public boolean showPersonalizedAdForCCPA() {
        boolean equals = this.subjectToCCPA.equals("-1");
        return (!equals && !this.subjectToCCPA.equals("1")) || this.userConsent.equals("1") || (equals && this.userConsent.equals("-1") && !AdMostUtil.isInCCPA(AdMostPreferences.newInstance(AdMost.getInstance().getContext())));
    }

    public boolean showPersonalizedAdForGDPR() {
        boolean equals = this.subjectToGDPR.equals("-1");
        return (!equals && !this.subjectToGDPR.equals("1")) || this.userConsent.equals("1") || (equals && this.userConsent.equals("-1") && !AdMostUtil.isInEU(AdMostPreferences.newInstance(AdMost.getInstance().getContext())));
    }

    /* access modifiers changed from: package-private */
    public long timeWaitForAdNetworksInitiation() {
        return this.networkInitiatedOnInit ? 1000 : 0;
    }

    public boolean useHttps() {
        return this.useHttps;
    }

    private AdMostConfiguration(Builder builder) {
        this.testerIds = new ConcurrentHashMap<>();
        this.adNetworkMetaList = new LinkedHashMap<>();
        this.passiveTags = new ArrayList();
        this.hasForceInit = false;
        this.initTryCount = 0;
        this.gender = -1;
        this.userConsent = "-1";
        this.subjectToGDPR = "-1";
        this.subjectToCCPA = "-1";
        this.isChild = false;
        this.olderThanSixteen = "-1";
        this.isHuaweiApp = false;
        this.initParams = new InitParams();
        this.lifecycleCallbacks = new AdMostAppLifecycle(new AdMostAppLifecycle.Listener() {
            public void onActivityDestroyed(Activity activity) {
                AdMost.getInstance().onDestroyActivity(activity);
            }

            public void onActivityPaused(Activity activity) {
                AdMost.getInstance().onPauseActivity(activity);
            }

            public void onActivityResumed(Activity activity) {
                AdMost.getInstance().onResumeActivity(activity);
            }

            public void onActivityStarted(Activity activity) {
                AdMost.getInstance().onStartActivity(activity);
            }

            public void onActivityStopped(Activity activity) {
                AdMost.getInstance().onStopActivity(activity);
            }
        });
        this.activity = builder.activity;
        this.executor = new ThreadPoolExecutor(10, 75, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(50));
        this.gender = builder.gender;
        this.age = builder.age;
        this.appId = builder.appId;
        this.interests = builder.interests;
        this.noAd = builder.noAd;
        this.useHttps = builder.useHttps;
        this.userConsent = builder.userConsent;
        this.subjectToGDPR = builder.subjectToGDPR;
        this.subjectToCCPA = builder.subjectToCCPA;
        this.cacheZones = builder.cacheZones;
        this.testDevices = builder.testDevices;
        this.isChild = builder.isChild;
        this.olderThanSixteen = builder.olderThanSixteen;
        this.isHuaweiApp = builder.isHuaweiApp;
        if (builder.testerEnabledNetworks != null) {
            this.testerEnabledNetworks = new HashSet();
            if (builder.testerEnabledNetworks.size() > 0) {
                this.testerEnabledNetworks.addAll(builder.testerEnabledNetworks);
            }
        }
        AdMostLog.setLogLevel(builder.logLevel);
        AdMostLog.setHTTPLogging(builder.isHttpLoggingEnabled);
        setInstallReferrers();
        builder.clearGC();
    }
}
