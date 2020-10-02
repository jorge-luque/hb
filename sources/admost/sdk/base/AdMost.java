package admost.sdk.base;

import admost.sdk.AdMostManager;
import admost.sdk.BuildConfig;
import admost.sdk.interfaces.AdMostAdNetworkInitInterface;
import admost.sdk.listener.AdMostIAPCallback;
import admost.sdk.listener.AdMostIAPListener;
import admost.sdk.listener.AdMostInitListener;
import admost.sdk.listener.AdMostVirtualCurrencyListener;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONException;
import org.json.JSONObject;
import p118io.fabric.sdk.android.p200m.p203c.C6120b;

public class AdMost {
    public static final int AD_ERROR_CONNECTION = 500;
    public static final int AD_ERROR_FAILED_TO_SHOW = 305;
    public static final int AD_ERROR_FREQ_CAP = 300;
    public static final int AD_ERROR_FREQ_CAP_ON_SHOWN = 301;
    public static final int AD_ERROR_INCOMPATIBLE_APP_ZONE_ID = 402;
    public static final int AD_ERROR_NOT_CACHABLE = 403;
    public static final int AD_ERROR_NO_FILL = 400;
    public static final int AD_ERROR_TAG_PASSIVE = 302;
    public static final int AD_ERROR_TOO_MANY_REQUEST = 501;
    public static final int AD_ERROR_WATERFALL_EMPTY = 401;
    public static final int AD_ERROR_ZONE_PASSIVE = 303;
    public static final int AD_ERROR_ZONE_TIMEOUT = 304;
    public static final int AD_STATUS_CHANGE_FREQ_CAP_ENDED = 1;
    public static final String CONSENT_ZONE_CCPA = "CCPA";
    public static final String CONSENT_ZONE_GDPR = "GDPR";
    public static final String CONSENT_ZONE_NONE = "None";
    public static final String CONTENT_URL = "ADMOST_CONTENT_URL";
    private static final String ERROR_IMAGE_LOADER_INIT = "Please add Volley library to your project";
    private static final String ERROR_INIT_CONFIG_WITH_NULL = "AdMost configuration can not be initialized with null";
    private static final String ERROR_LAUNCHER_ACTIVITY = "Please set Launcher Activity with AdMost configuration";
    public static final String ERROR_NOT_INIT = "AdMost must be init with configuration before using";
    private static final String ERROR_SDK_VERSION = "AdMost requires Android 2.3 (Gingerbread - API Version 9) or later";
    public static final int GENDER_FEMALE = 1;
    public static final int GENDER_MALE = 0;
    public static final int GENDER_UNKNOWN = -1;
    protected static final String INIT_STEP_CONFIGURATION = "CONFIGURATION";
    protected static final String INIT_STEP_EXPERIMENT = "EXPERIMENT";
    private static final String WARNING_RE_INIT_CONFIG = "Try to initialize AdMost which had already been initialized before";
    private static volatile AdMost instance;
    private AdMostConfiguration configuration;
    private boolean configurationInitCompleted = false;
    private boolean experimentInitCompleted = false;
    private Observer initObserverForAdjustUserId;
    /* access modifiers changed from: private */
    public Observer initObserverForApplicationUserId;
    /* access modifiers changed from: private */
    public Observer initObserverForClientCampaignId;
    /* access modifiers changed from: private */
    public Observer initObserverSpendVirtualCurrency;
    /* access modifiers changed from: private */
    public Observer initRequestObserver;
    private boolean isInitCompleted;
    private boolean isOnForeGround;
    private String mAdjustUserId = "notSet";
    /* access modifiers changed from: private */
    public String mApplicationUserId = "notSet";
    private AdMostIAPCallback mIAPCallback;
    /* access modifiers changed from: private */
    public AdMostIAPListener mIAPListener;
    /* access modifiers changed from: private */
    public AdMostInitListener mInitListener;
    /* access modifiers changed from: private */
    public boolean mPurchaseWaitingInit;
    /* access modifiers changed from: private */
    public Observer testSuiteInitObserver;
    /* access modifiers changed from: private */
    public Observer trackPurchaseInitObserver;

    public static class AdMostInitErrorCodes {
        public static int INAPPROPRIATE_SDK_VERSION = 300;
        public static int INVALID_LAUNCHER_ACTIVITY = 301;
        public static int NULL_CONFIGURATION = 302;
        public static int VOLLEY_LIB_NOT_FOUND = 303;
    }

    @Deprecated
    public interface GDPRListener {
        void isGDPRApplicable(boolean z);
    }

    public interface PrivacyConsentListener {
        void isPrivacyConsentRequired(String str);
    }

    protected AdMost() {
    }

    private void checkConfiguration() {
        if (this.configuration == null) {
            throw new IllegalStateException(ERROR_NOT_INIT);
        }
    }

    public static AdMost getInstance() {
        if (instance == null) {
            synchronized (AdMost.class) {
                if (instance == null) {
                    instance = new AdMost();
                }
            }
        }
        return instance;
    }

    public void clearIAPCallback() {
        this.mIAPCallback = null;
    }

    public void dispatchLocalHits() {
        AdMostImpressionManager.getInstance().sendImpression();
    }

    public Activity getActivity() {
        checkConfiguration();
        return this.configuration.activity;
    }

    public int getAge() {
        checkConfiguration();
        return this.configuration.getAge();
    }

    public String getAppId() {
        checkConfiguration();
        return this.configuration.getAppId();
    }

    public AdMostConfiguration getConfiguration() {
        return this.configuration;
    }

    public Context getContext() {
        checkConfiguration();
        return this.configuration.activity.getApplicationContext();
    }

    public String getCountry() {
        try {
            return AdMostPreferences.getInstance().getCountry();
        } catch (Exception unused) {
            return null;
        }
    }

    public ThreadPoolExecutor getExecutor() {
        checkConfiguration();
        return this.configuration.executor;
    }

    public int getGender() {
        checkConfiguration();
        return this.configuration.getGender();
    }

    /* access modifiers changed from: package-private */
    public AdMostIAPCallback getIAPCallback() {
        return this.mIAPCallback;
    }

    /* access modifiers changed from: package-private */
    public AdMostIAPListener getIAPListener() {
        return this.mIAPListener;
    }

    /* access modifiers changed from: package-private */
    public int getImpressionSendPeriod() {
        AdMostConfiguration adMostConfiguration = this.configuration;
        int impressionSendPeriod = adMostConfiguration == null ? 120 : adMostConfiguration.getImpressionSendPeriod();
        if (impressionSendPeriod <= 5) {
            return 120;
        }
        return impressionSendPeriod;
    }

    public String getInterests() {
        checkConfiguration();
        return this.configuration.getInterests();
    }

    public String getUserDataJSON() {
        return AdMostUserDataManager.getInstance().getUserData();
    }

    public String getUserId() {
        if (!isInitStarted()) {
            return "";
        }
        return AdMostAnalyticsManager.getInstance().getApplicationUserId();
    }

    public String getVersion() {
        return getVersion(getContext());
    }

    /* access modifiers changed from: protected */
    public String getVersion(Context context) {
        return BuildConfig.VERSION_NAME;
    }

    public synchronized void init(AdMostConfiguration adMostConfiguration) {
        if (Build.VERSION.SDK_INT < 9) {
            if (this.mInitListener != null) {
                this.mInitListener.onInitFailed(AdMostInitErrorCodes.INAPPROPRIATE_SDK_VERSION);
            }
            throw new IllegalArgumentException(ERROR_SDK_VERSION);
        } else if (adMostConfiguration == null) {
            if (this.mInitListener != null) {
                this.mInitListener.onInitFailed(AdMostInitErrorCodes.NULL_CONFIGURATION);
            }
            throw new IllegalArgumentException(ERROR_INIT_CONFIG_WITH_NULL);
        } else if (!AdMostUtil.isClassAvailable("com.android.volley.toolbox.ImageLoader")) {
            if (this.mInitListener != null) {
                this.mInitListener.onInitFailed(AdMostInitErrorCodes.VOLLEY_LIB_NOT_FOUND);
            }
            throw new IllegalArgumentException(ERROR_IMAGE_LOADER_INIT);
        } else if (this.configuration == null) {
            this.configuration = adMostConfiguration;
            AdMostPreferences.newInstance(getContext());
            AdMostLog.setLogEnabledFromOldValue();
            this.configuration.makeInitRequest();
            if (getActivity() == null || (getActivity() instanceof Activity)) {
                if (!AdMostLocation.isStarted() && (AdMostUtil.isPermissionGranted(getContext(), "android.permission.ACCESS_COARSE_LOCATION") || AdMostUtil.isPermissionGranted(getContext(), "android.permission.ACCESS_FINE_LOCATION"))) {
                    AdMostLocation.newInstance(getContext());
                }
                AdMostManager.getInstance().start();
                AdMostImpressionManager.getInstance().start(getContext());
                onResumeActivity(getActivity());
                this.configuration.arrangeAdMostAppLifecycleCallbacks(false);
            } else {
                if (this.mInitListener != null) {
                    this.mInitListener.onInitFailed(AdMostInitErrorCodes.INVALID_LAUNCHER_ACTIVITY);
                }
                throw new IllegalArgumentException(ERROR_LAUNCHER_ACTIVITY);
            }
        } else {
            AdMostLog.m303w(WARNING_RE_INIT_CONFIG);
            AdMostBannerZoneCacheManager.getInstance().startAllCacheRequests();
        }
    }

    /* access modifiers changed from: package-private */
    public void initCompleted(String str) {
        if (str.equals(INIT_STEP_CONFIGURATION)) {
            this.configurationInitCompleted = true;
        } else if (str.equals(INIT_STEP_EXPERIMENT)) {
            this.experimentInitCompleted = true;
        }
        if (this.experimentInitCompleted && this.configurationInitCompleted) {
            int isNetworkAvailable = AdMostUtil.isNetworkAvailable(getContext());
            if (isNetworkAvailable == 1) {
                this.configuration.initForce();
            }
            if (isNetworkAvailable == 1 || (isNetworkAvailable == -2 && AdMostUtil.isNetworkAvailable(getContext()) == 1)) {
                this.configuration.initDefault();
            }
            this.isInitCompleted = true;
            AdMostInitObservable.getInstance().onReceive(1, false);
        }
    }

    public boolean isInitCompleted() {
        return this.isInitCompleted;
    }

    public boolean isInitStarted() {
        return this.configuration != null;
    }

    public boolean isOnForeGround() {
        return this.isOnForeGround;
    }

    public boolean isSoundMuted(String str) {
        checkConfiguration();
        return this.configuration.isSoundMuted(str);
    }

    public boolean isStopped() {
        return !AdMostManager.getInstance().admanagerStarted;
    }

    public boolean isTagPassive(String str) {
        checkConfiguration();
        return this.configuration.isTagPassive(str);
    }

    public boolean isUserChild() {
        checkConfiguration();
        return this.configuration.isUserChild();
    }

    public void onBackPressed(Activity activity) {
        Iterator<Map.Entry<String, AdMostAdNetworkInitInterface>> it = AdMostAdNetworkManager.getInstance().adNetworkInitAdapters.entrySet().iterator();
        while (true) {
            boolean z = true;
            while (true) {
                if (it.hasNext()) {
                    Map.Entry next = it.next();
                    if (!z || !((AdMostAdNetworkInitInterface) next.getValue()).onBackPressed(activity)) {
                        z = false;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void onDestroy(Activity activity) {
        if (Build.VERSION.SDK_INT < 14) {
            checkConfiguration();
            onDestroyActivity(activity);
        }
    }

    /* access modifiers changed from: package-private */
    public void onDestroyActivity(Activity activity) {
        for (Map.Entry<String, AdMostAdNetworkInitInterface> value : AdMostAdNetworkManager.getInstance().adNetworkInitAdapters.entrySet()) {
            ((AdMostAdNetworkInitInterface) value.getValue()).onDestroy(activity);
        }
    }

    public void onPause(Activity activity) {
        if (Build.VERSION.SDK_INT < 14) {
            checkConfiguration();
            onPauseActivity(activity);
        }
    }

    /* access modifiers changed from: package-private */
    public void onPauseActivity(Activity activity) {
        for (Map.Entry<String, AdMostAdNetworkInitInterface> value : AdMostAdNetworkManager.getInstance().adNetworkInitAdapters.entrySet()) {
            ((AdMostAdNetworkInitInterface) value.getValue()).onPause(activity);
        }
        AdMostManager.getInstance().pauseAllBanners();
        this.isOnForeGround = false;
        AdMostAnalyticsManager.getInstance().setSessionData(this.isOnForeGround);
    }

    public void onResume(Activity activity) {
        if (Build.VERSION.SDK_INT < 14) {
            checkConfiguration();
            onResumeActivity(activity);
        }
    }

    /* access modifiers changed from: package-private */
    public void onResumeActivity(Activity activity) {
        for (Map.Entry<String, AdMostAdNetworkInitInterface> value : AdMostAdNetworkManager.getInstance().adNetworkInitAdapters.entrySet()) {
            ((AdMostAdNetworkInitInterface) value.getValue()).onResume(activity);
        }
        AdMostManager.getInstance().resumeAllBanners();
        AdMostManager.getInstance().setTopActivityHash(activity);
        this.isOnForeGround = true;
        AdMostAnalyticsManager.getInstance().setSessionData(this.isOnForeGround);
    }

    public void onStart(Activity activity) {
        if (Build.VERSION.SDK_INT < 14) {
            checkConfiguration();
            onStartActivity(activity);
        }
    }

    /* access modifiers changed from: package-private */
    public void onStartActivity(Activity activity) {
        for (Map.Entry<String, AdMostAdNetworkInitInterface> value : AdMostAdNetworkManager.getInstance().adNetworkInitAdapters.entrySet()) {
            ((AdMostAdNetworkInitInterface) value.getValue()).onStart(activity);
        }
        AdMostManager.getInstance().start();
    }

    public void onStop(Activity activity) {
        if (Build.VERSION.SDK_INT < 14) {
            checkConfiguration();
            onStopActivity(activity);
        }
    }

    /* access modifiers changed from: package-private */
    public void onStopActivity(Activity activity) {
        for (Map.Entry<String, AdMostAdNetworkInitInterface> value : AdMostAdNetworkManager.getInstance().adNetworkInitAdapters.entrySet()) {
            ((AdMostAdNetworkInitInterface) value.getValue()).onStop(activity);
        }
    }

    @Deprecated
    public void setAdjustUserId(String str) {
    }

    public void setClientCampaignId(final String str) {
        if (str != null && !str.equals("")) {
            if (!getInstance().isInitCompleted()) {
                this.initObserverForClientCampaignId = new Observer() {
                    public void update(Observable observable, Object obj) {
                        if (((Integer) ((Object[]) obj)[0]).intValue() == 1) {
                            AdMostPreferences.getInstance().requestClientCampaignId(str);
                            InstallReferrerReceiver.trackCampaign();
                            AdMostInitObservable.getInstance().deleteObserver(AdMost.this.initObserverForClientCampaignId);
                            Observer unused = AdMost.this.initObserverForClientCampaignId = null;
                        }
                    }
                };
                AdMostInitObservable.getInstance().addObserver(this.initObserverForClientCampaignId);
                return;
            }
            AdMostPreferences.getInstance().requestClientCampaignId(str);
            InstallReferrerReceiver.trackCampaign();
        }
    }

    @Deprecated
    public void setGDPRListener(Context context, final GDPRListener gDPRListener) {
        if (context == null) {
            AdMostLog.allError("ERROR: context is null for setGDPRListener!");
            return;
        }
        if (context instanceof Activity) {
            context = context.getApplicationContext();
        }
        if (gDPRListener == null) {
            AdMostLog.allError("GDPRListener can not be null!");
            return;
        }
        C016910 r0 = new PrivacyConsentListener() {
            public void isPrivacyConsentRequired(String str) {
                GDPRListener gDPRListener = gDPRListener;
                if (gDPRListener != null) {
                    gDPRListener.isGDPRApplicable(str != null && str.equals("GDPR"));
                }
            }
        };
        if (!AdMostPreferences.isStarted()) {
            AdMostPreferences.newInstance(context, r0);
            return;
        }
        AdMostPreferences newInstance = AdMostPreferences.newInstance(context);
        String country = newInstance.getCountry();
        if (country == null || country.equals("")) {
            newInstance.setConsentListener(r0);
        } else {
            gDPRListener.isGDPRApplicable(AdMostUtil.isInEU(newInstance));
        }
    }

    public void setPrivacyConsentListener(Context context, PrivacyConsentListener privacyConsentListener) {
        if (context == null) {
            AdMostLog.allError("ERROR: context is null for PrivacyConsentListener!");
            return;
        }
        if (context instanceof Activity) {
            context = context.getApplicationContext();
        }
        if (privacyConsentListener == null) {
            AdMostLog.allError("PrivacyConsentListener can not be null!");
        } else if (!AdMostPreferences.isStarted()) {
            AdMostPreferences.newInstance(context, privacyConsentListener);
        } else {
            AdMostPreferences newInstance = AdMostPreferences.newInstance(context);
            String country = newInstance.getCountry();
            if (country == null || country.equals("")) {
                newInstance.setConsentListener(privacyConsentListener);
            } else {
                privacyConsentListener.isPrivacyConsentRequired(AdMostUtil.isInEU(newInstance) ? "GDPR" : AdMostUtil.isInCCPA(newInstance) ? "CCPA" : CONSENT_ZONE_NONE);
            }
        }
    }

    public void setUserId(String str) {
        if (!this.mApplicationUserId.equals("notSet")) {
            this.mApplicationUserId = str;
            return;
        }
        this.mApplicationUserId = str;
        if (!getInstance().isInitCompleted()) {
            this.initObserverForApplicationUserId = new Observer() {
                public void update(Observable observable, Object obj) {
                    if (((Integer) ((Object[]) obj)[0]).intValue() == 1) {
                        AdMostAnalyticsManager.getInstance().setApplicationUserId(AdMost.this.mApplicationUserId);
                        String unused = AdMost.this.mApplicationUserId = "notSet";
                        AdMostInitObservable.getInstance().deleteObserver(AdMost.this.initObserverForApplicationUserId);
                        Observer unused2 = AdMost.this.initObserverForApplicationUserId = null;
                    }
                }
            };
            AdMostInitObservable.getInstance().addObserver(this.initObserverForApplicationUserId);
            return;
        }
        AdMostAnalyticsManager.getInstance().setApplicationUserId(str);
        this.mApplicationUserId = "notSet";
    }

    public void spendVirtualCurrency(final AdMostVirtualCurrencyListener adMostVirtualCurrencyListener) {
        if (!getInstance().isInitCompleted()) {
            this.initObserverSpendVirtualCurrency = new Observer() {
                public void update(Observable observable, Object obj) {
                    if (((Integer) ((Object[]) obj)[0]).intValue() == 1) {
                        AdMost.this.spendVirtualCurrency(adMostVirtualCurrencyListener);
                        AdMostInitObservable.getInstance().deleteObserver(AdMost.this.initObserverSpendVirtualCurrency);
                        Observer unused = AdMost.this.initObserverSpendVirtualCurrency = null;
                    }
                }
            };
            AdMostInitObservable.getInstance().addObserver(this.initObserverSpendVirtualCurrency);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, AdMostAdNetworkInitInterface> key : AdMostAdNetworkManager.getInstance().adNetworkInitAdapters.entrySet()) {
            arrayList.add((String) key.getKey());
        }
        try {
            Iterator<String> keys = new JSONObject(AdMostPreferences.getInstance().getOfferWallNetworks()).keys();
            while (keys.hasNext()) {
                String next = keys.next();
                AdMostPreferences.getInstance().removeOfferWallNetwork(next);
                if (!arrayList.contains(next)) {
                    arrayList.add(next);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                AdMostAdNetworkManager.getInstance().spendOfferwallCurrency((String) it.next(), adMostVirtualCurrencyListener);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            AdMostPreferences.getInstance().spendOfferwallReward((String) null, adMostVirtualCurrencyListener);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void startTestSuite() {
        startTestSuite((String[]) null);
    }

    public void stop() {
        checkConfiguration();
        AdMostManager.getInstance().stop();
    }

    public long timeWaitForAdNetworksInitiation() {
        AdMostConfiguration adMostConfiguration = this.configuration;
        if (adMostConfiguration != null) {
            return adMostConfiguration.timeWaitForAdNetworksInitiation();
        }
        return 0;
    }

    public void trackIAP(String str, String str2, String str3, String[] strArr, boolean z) {
        if (this.mPurchaseWaitingInit) {
            AdMostLog.m303w("There is an ongoing purchase, please wait to send a new one..!");
        } else if (isInitCompleted()) {
            AdMostAnalyticsManager.getInstance().sendIAP(str, str2, str3, strArr, z);
        } else {
            this.mPurchaseWaitingInit = true;
            final String str4 = str;
            final String str5 = str2;
            final String str6 = str3;
            final String[] strArr2 = strArr;
            final boolean z2 = z;
            this.trackPurchaseInitObserver = new Observer() {
                public void update(Observable observable, Object obj) {
                    if (((Integer) ((Object[]) obj)[0]).intValue() == 1) {
                        AdMost.this.getActivity().runOnUiThread(new Runnable() {
                            public void run() {
                                AdMostAnalyticsManager instance = AdMostAnalyticsManager.getInstance();
                                C01723 r1 = C01723.this;
                                instance.sendIAP(str4, str5, str6, strArr2, z2);
                                AdMostInitObservable.getInstance().deleteObserver(AdMost.this.trackPurchaseInitObserver);
                                Observer unused = AdMost.this.trackPurchaseInitObserver = null;
                                boolean unused2 = AdMost.this.mPurchaseWaitingInit = false;
                            }
                        });
                    }
                }
            };
            AdMostInitObservable.getInstance().addObserver(this.trackPurchaseInitObserver);
        }
    }

    @Deprecated
    public void trackPurchase(String str, String str2, String str3, AdMostIAPCallback adMostIAPCallback, boolean z) {
        if (isInitCompleted()) {
            this.mIAPCallback = adMostIAPCallback;
            AdMostAnalyticsManager.getInstance().trackPurchase(str, str2, str3, z, "");
            return;
        }
        AdMostLog.m303w("Tracking purchase is only available if AdMost initialization succeed.");
    }

    @Deprecated
    public void trackPurchaseAmazon(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, AdMostIAPCallback adMostIAPCallback, boolean z) {
        if (isInitCompleted()) {
            this.mIAPCallback = adMostIAPCallback;
            AdMostAnalyticsManager.getInstance().trackPurchaseAmazon(jSONObject, jSONObject2, jSONObject3, z, "");
            return;
        }
        AdMostLog.m303w("Tracking purchase is only available if AdMost initialization succeed.");
    }

    public void startTestSuite(final String[] strArr) {
        if (getInstance().isInitCompleted() && AdMostLog.isEnabled()) {
            getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    Intent intent = new Intent(AdMost.this.getActivity(), AdMostTestSuiteActivity.class);
                    intent.putExtra("ZONE", strArr);
                    AdMost.this.getActivity().startActivity(intent);
                }
            });
        } else if (AdMostLog.isEnabled()) {
            this.testSuiteInitObserver = new Observer() {
                public void update(Observable observable, Object obj) {
                    if (((Integer) ((Object[]) obj)[0]).intValue() == 1) {
                        AdMost.this.getActivity().runOnUiThread(new Runnable() {
                            public void run() {
                                Intent intent = new Intent(AdMost.this.getActivity(), AdMostTestSuiteActivity.class);
                                intent.putExtra("ZONE", strArr);
                                AdMost.this.getActivity().startActivity(intent);
                                AdMostInitObservable.getInstance().deleteObserver(AdMost.this.testSuiteInitObserver);
                                Observer unused = AdMost.this.testSuiteInitObserver = null;
                            }
                        });
                    }
                }
            };
            AdMostInitObservable.getInstance().addObserver(this.testSuiteInitObserver);
        }
    }

    @Deprecated
    public void trackPurchase(String str, String str2, String str3, AdMostIAPCallback adMostIAPCallback) {
        trackPurchase(str, str2, str3, adMostIAPCallback, false);
    }

    public String trackPurchaseAmazon(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, AdMostIAPListener adMostIAPListener, boolean z) {
        if (this.mPurchaseWaitingInit) {
            AdMostLog.m303w("There is an ongoing purchase, please wait to send a new one..!");
            return "";
        }
        String str = AdMostAnalyticsManager.getRandomExtention() + C6120b.ROLL_OVER_FILE_NAME_SEPARATOR + System.currentTimeMillis();
        if (isInitCompleted()) {
            this.mIAPListener = adMostIAPListener;
            AdMostAnalyticsManager.getInstance().trackPurchaseAmazon(jSONObject, jSONObject2, jSONObject3, z, str);
        } else {
            final AdMostIAPListener adMostIAPListener2 = adMostIAPListener;
            this.mPurchaseWaitingInit = true;
            final JSONObject jSONObject4 = jSONObject;
            final JSONObject jSONObject5 = jSONObject2;
            final JSONObject jSONObject6 = jSONObject3;
            final boolean z2 = z;
            final String str2 = str;
            this.trackPurchaseInitObserver = new Observer() {
                public void update(Observable observable, Object obj) {
                    if (((Integer) ((Object[]) obj)[0]).intValue() == 1) {
                        AdMost.this.getActivity().runOnUiThread(new Runnable() {
                            public void run() {
                                C01744 r0 = C01744.this;
                                AdMostIAPListener unused = AdMost.this.mIAPListener = adMostIAPListener2;
                                AdMostAnalyticsManager instance = AdMostAnalyticsManager.getInstance();
                                C01744 r02 = C01744.this;
                                instance.trackPurchaseAmazon(jSONObject4, jSONObject5, jSONObject6, z2, str2);
                                AdMostInitObservable.getInstance().deleteObserver(AdMost.this.trackPurchaseInitObserver);
                                Observer unused2 = AdMost.this.trackPurchaseInitObserver = null;
                                boolean unused3 = AdMost.this.mPurchaseWaitingInit = false;
                            }
                        });
                    }
                }
            };
            AdMostInitObservable.getInstance().addObserver(this.trackPurchaseInitObserver);
        }
        return str;
    }

    public String trackPurchase(String str, String str2, String str3, AdMostIAPListener adMostIAPListener, boolean z) {
        if (this.mPurchaseWaitingInit) {
            AdMostLog.m303w("There is an ongoing purchase, please wait to send a new one..!");
            return "";
        }
        String str4 = AdMostAnalyticsManager.getRandomExtention() + C6120b.ROLL_OVER_FILE_NAME_SEPARATOR + System.currentTimeMillis();
        if (isInitCompleted()) {
            this.mIAPListener = adMostIAPListener;
            AdMostAnalyticsManager.getInstance().trackPurchase(str, str2, str3, z, str4);
        } else {
            final AdMostIAPListener adMostIAPListener2 = adMostIAPListener;
            this.mPurchaseWaitingInit = true;
            final String str5 = str;
            final String str6 = str2;
            final String str7 = str3;
            final boolean z2 = z;
            final String str8 = str4;
            this.trackPurchaseInitObserver = new Observer() {
                public void update(Observable observable, Object obj) {
                    if (((Integer) ((Object[]) obj)[0]).intValue() == 1) {
                        AdMost.this.getActivity().runOnUiThread(new Runnable() {
                            public void run() {
                                C01702 r0 = C01702.this;
                                AdMostIAPListener unused = AdMost.this.mIAPListener = adMostIAPListener2;
                                AdMostAnalyticsManager instance = AdMostAnalyticsManager.getInstance();
                                C01702 r02 = C01702.this;
                                instance.trackPurchase(str5, str6, str7, z2, str8);
                                AdMostInitObservable.getInstance().deleteObserver(AdMost.this.trackPurchaseInitObserver);
                                Observer unused2 = AdMost.this.trackPurchaseInitObserver = null;
                                boolean unused3 = AdMost.this.mPurchaseWaitingInit = false;
                            }
                        });
                    }
                }
            };
            AdMostInitObservable.getInstance().addObserver(this.trackPurchaseInitObserver);
        }
        return str4;
    }

    public void trackPurchase(String str, String str2, String str3) {
        trackPurchase(str, str2, str3, (AdMostIAPListener) null, false);
    }

    public String trackPurchase(String str, String str2, String str3, AdMostIAPListener adMostIAPListener) {
        return trackPurchase(str, str2, str3, adMostIAPListener, false);
    }

    public void init(AdMostConfiguration adMostConfiguration, AdMostInitListener adMostInitListener) {
        if (adMostInitListener != null) {
            this.mInitListener = adMostInitListener;
            if (getInstance().isInitCompleted()) {
                this.mInitListener.onInitCompleted();
            } else {
                this.initRequestObserver = new Observer() {
                    public void update(Observable observable, Object obj) {
                        if (((Integer) ((Object[]) obj)[0]).intValue() == 1) {
                            AdMost.this.getActivity().runOnUiThread(new Runnable() {
                                public void run() {
                                    if (AdMost.this.mInitListener != null) {
                                        AdMost.this.mInitListener.onInitCompleted();
                                    }
                                    AdMostInitObservable.getInstance().deleteObserver(AdMost.this.initRequestObserver);
                                    Observer unused = AdMost.this.initRequestObserver = null;
                                }
                            });
                        }
                    }
                };
                AdMostInitObservable.getInstance().addObserver(this.initRequestObserver);
            }
        }
        init(adMostConfiguration);
    }
}
