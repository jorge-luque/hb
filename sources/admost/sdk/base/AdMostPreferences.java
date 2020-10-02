package admost.sdk.base;

import admost.sdk.base.AdMost;
import admost.sdk.base.AdMostGenericRequest;
import admost.sdk.listener.AdMostVirtualCurrencyListener;
import admost.sdk.listener.AdmostResponseListener;
import admost.sdk.model.AdMostExperiment;
import admost.sdk.model.AdMostFrequencyCappingItem;
import admost.sdk.model.AdMostInAppPurchaseItem;
import admost.sdk.model.AdMostRandomizerBypassItem;
import admost.sdk.model.FpDefaultItem;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.appevents.AppEventsConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class AdMostPreferences {
    private static final Object gdprListenerLock = new Object();
    private static AdMostPreferences instance;
    private static final Object lock = new Object();
    private static final Object lockFBLog = new Object();
    private static final Object staticCampaignLock = new Object();
    private final String EMPTY_ARRAY = new JSONArray().toString();
    private final String EMPTY_STRING = new JSONObject().toString();
    private final String KEY_ADJUST_USER_ID = "KEY_ADJUST_USER_ID";
    private final String KEY_ADMOST_ID = "KEY_ID";
    private final String KEY_ADV_ID = "KEY_ADV_ID";
    private final String KEY_AD_CACHE_BANNER = "KEY_AD_CACHE_BANNER";
    private final String KEY_AD_CACHE_COUNTRY = "KEY_AD_CACHE_COUNTRY";
    private final String KEY_AD_CACHE_INIT_RESPONSE = "KEY_AD_CACHE_INIT_RESPONSE";
    private final String KEY_AD_CACHE_STATE = "KEY_AD_CACHE_STATE";
    private final String KEY_AD_FCAP_VALUES = "KEY_AD_FCAP_VALUES";
    private final String KEY_AD_NETWORK_DATA = "KEY_AD_NETWORK_DATA";
    private final String KEY_AD_NETWORK_GET_SYNONYM = "KEY_AD_NETWORK_GET_SYNONYM";
    private final String KEY_AD_NETWORK_INCREMENT_SYNONYM = "KEY_AD_NETWORK_INCREMENT_SYNONYM";
    private final String KEY_AD_STATE_REQUESTED_BEFORE = "KEY_AD_STATE_REQUESTED_BEFORE";
    private final String KEY_AD_USER_UPDATE_DATA = "KEY_AD_USER_UPDATE_DATA";
    private final String KEY_ALL_POLICIES = "KEY_ALL_POLICIES";
    private final String KEY_ANALYTICS_DISABLED = "KEY_ANALYTICS_DISABLED";
    private final String KEY_APPLICATION_USER_ID = "KEY_APPLICATION_USER_ID";
    private final String KEY_APPSFLYER_USER_ID = "KEY_APPSFLYER_USER_ID";
    private final String KEY_CONSENT_STATUS = "KEY_CONSENT_STATUS";
    private final String KEY_DELTA_TIME = "KEY_DELTA_TIME";
    private final String KEY_EXPERIMENT_GROUP = "KEY_EXPERIMENT_GROUP";
    private final String KEY_EXPERIMENT_TRIED_BEFORE = "KEY_EXPERIMENT_TRIED_BEFORE";
    private final String KEY_FB_BIDDING_DATA = "KEY_FB_BIDDING_DATA";
    private final String KEY_FIRST_SESSION_STARTED_AT = "KEY_FIRST_SESSION_STARTED_AT";
    private final String KEY_FP_DEFAULTS = "KEY_FP_DEFAULTS";
    private final String KEY_FP_ZONE_FILL_COUNTS = "KEY_FP_ZONE_FILL_COUNTS";
    private final String KEY_IAPS_DATA = "KEY_IAPS_DATA";
    private final String KEY_INSTALL_REFERRER = "KEY_INSTALL_REFERRER";
    private final String KEY_INSTALL_REFERRER_CAMPAIGN = "KEY_INSTALL_REFERRER_CAMPAIGN";
    private final String KEY_INSTALL_REFERRER_CAMPAIGN_SENT = "KEY_INSTALL_REFERRER_CAMPAIGN_SENT";
    private final String KEY_INSTALL_REFERRER_CLIENT_CAMPAIGN_ID = "KEY_INSTALL_REFERRER_CLIENT_CAMPAIGN_ID";
    private final String KEY_INSTALL_REFERRER_CLIENT_CAMPAIGN_ID_REQUESTED = "KEY_INSTALL_REFERRER_CLIENT_CAMPAIGN_ID_REQUESTED";
    private final String KEY_INSTALL_REFERRER_SERVER_CAMPAIGN_ID_OVERRIDE = "KEY_INSTALL_REFERRER_SERVER_CAMPAIGN_ID_OVERRIDE";
    private final String KEY_IS_LOG_ENABLED = "KEY_IS_LOG_ENABLED";
    private final String KEY_OFFERWALLSHOW_DATA = "KEY_OFFERWALLSHOW_DATA";
    private final String KEY_OFFERWALL_STORED_DATA = "KEY_OFFERWALL_STORED_DATA";
    private final String KEY_PERCENTILE = "KEY_PERCENTILE";
    private final String KEY_PERCENTILE_FOR_EXPERIMENT = "KEY_PERCENTILE_FOR_EXPERIMENT";
    private final String KEY_POLICY_ENABLED = "KEY_POLICY_ENABLED";
    private final String KEY_RANDOMIZER_BYPASS_VALUES = "KEY_RANDOMIZER_BYPASS_VALUES";
    private final String KEY_REGISTER_REQUEST_DONE = "KEY_REGISTER_REQUEST_DONE";
    private final String KEY_SESSION_DATA = "KEY_SESSION_DATA";
    private final String KEY_SESSION_PIECES_DATA = "KEY_SESSION_PIECES_DATA";
    private final String KEY_SESSION_PIECES_DATA_2ND = "KEY_SESSION_PIECES_DATA_2ND";
    private final String KEY_SESSION_PIECES_DATA_2ND_INDEX = "KEY_SESSION_PIECES_DATA_2ND_INDEX";
    private final String KEY_SESSION_PIECE_CONVERSION_DONE = "KEY_SESSION_PIECE_CONVERSION_DONE";
    private final String KEY_SSV_DATA = "KEY_SSV_DATA";
    private final String KEY_SUBSCRIPTION_QUERY_DONE = "KEY_SUBSCRIPTION_QUERY_DONE";
    private final String KEY_USER_DATA_FOR_MANAGER = "KEY_USER_DATA_FOR_MANAGER";
    private final String KEY_USER_ID = "KEY_USER_ID";
    private final String KEY_ZONE_IMPRESSION_DATA = "KEY_ZONE_IMPRESSION_DATA";
    private final String KEY_ZONE_LAST_ECPM = "KEY_ZONE_LAST_ECPM";
    private final String KEY_ZONE_NETWORK_REQUEST_DATA = "KEY_ZONE_NETWORK_REQUEST_DATA";
    private String advertId = null;
    private AdMost.PrivacyConsentListener consentListener;
    private String country;
    private SharedPreferences.Editor editor;
    private int experimentPercentile;
    private int percentile;
    private SharedPreferences preferences;
    private int sessionPieceIndex;
    private String state;
    private String storedCampaignId = "";

    private AdMostPreferences(Context context, AdMost.PrivacyConsentListener privacyConsentListener) {
        this.consentListener = privacyConsentListener;
        initPreferences(context);
    }

    /* access modifiers changed from: private */
    public AdMost.PrivacyConsentListener getConsentListener() {
        AdMost.PrivacyConsentListener privacyConsentListener;
        synchronized (gdprListenerLock) {
            privacyConsentListener = this.consentListener;
        }
        return privacyConsentListener;
    }

    private SharedPreferences.Editor getEditor() {
        if (this.editor == null) {
            this.editor = this.preferences.edit();
        }
        return this.editor;
    }

    public static AdMostPreferences getInstance() {
        AdMostPreferences adMostPreferences = instance;
        if (adMostPreferences != null) {
            return adMostPreferences;
        }
        if (AdMost.getInstance().getContext() != null) {
            return newInstance(AdMost.getInstance().getContext());
        }
        return null;
    }

    private void initPreferences(final Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(AdMostAdNetwork.ADMOST, 0);
        this.preferences = sharedPreferences;
        this.country = sharedPreferences.getString("KEY_AD_CACHE_COUNTRY", "");
        this.state = this.preferences.getString("KEY_AD_CACHE_STATE", "");
        boolean equals = this.preferences.getString("KEY_AD_STATE_REQUESTED_BEFORE", AppEventsConstants.EVENT_PARAM_VALUE_NO).equals("1");
        if (this.country.equals("") || !equals) {
            new AdMostGenericRequest(AdMostGenericRequest.RequestType.COUNTRY_RESPONSE, "", new AdmostResponseListener<JSONObject>() {
                public void onError(String str, Exception exc) {
                    String localeCountryCode = AdMostUtil.getLocaleCountryCode(context);
                    AdMostPreferences.this.setCountry(localeCountryCode);
                    AdMostCountryResponseObservable.getInstance().onReceive(localeCountryCode);
                    if (AdMostPreferences.this.getConsentListener() != null) {
                        AdMostPreferences newInstance = AdMostPreferences.newInstance(context);
                        AdMostPreferences.this.getConsentListener().isPrivacyConsentRequired(AdMostUtil.isInEU(newInstance) ? "GDPR" : AdMostUtil.isInCCPA(newInstance) ? "CCPA" : AdMost.CONSENT_ZONE_NONE);
                    }
                }

                public void onResponse(JSONObject jSONObject) {
                    String optString = jSONObject.optString("Country");
                    AdMostPreferences.this.setCountry(optString);
                    AdMostPreferences.this.setState(jSONObject.optString("State", ""));
                    AdMostCountryResponseObservable.getInstance().onReceive(optString);
                    if (AdMostPreferences.this.getConsentListener() != null) {
                        AdMostPreferences newInstance = AdMostPreferences.newInstance(context);
                        AdMostPreferences.this.getConsentListener().isPrivacyConsentRequired(AdMostUtil.isInEU(newInstance) ? "GDPR" : AdMostUtil.isInCCPA(newInstance) ? "CCPA" : AdMost.CONSENT_ZONE_NONE);
                    }
                }
            }).mo611go(new String[0]);
        } else if (getConsentListener() != null) {
            AdMostPreferences newInstance = newInstance(context);
            getConsentListener().isPrivacyConsentRequired(AdMostUtil.isInEU(newInstance) ? "GDPR" : AdMostUtil.isInCCPA(newInstance) ? "CCPA" : AdMost.CONSENT_ZONE_NONE);
        }
        this.percentile = this.preferences.getInt("KEY_PERCENTILE", -1);
        this.experimentPercentile = this.preferences.getInt("KEY_PERCENTILE_FOR_EXPERIMENT", -1);
        if (this.percentile == -1) {
            int nextInt = new Random().nextInt(100);
            this.percentile = nextInt;
            set("KEY_PERCENTILE", nextInt);
        }
        if (this.experimentPercentile == -1) {
            int nextInt2 = new Random().nextInt(100);
            this.experimentPercentile = nextInt2;
            set("KEY_PERCENTILE_FOR_EXPERIMENT", nextInt2);
        }
    }

    public static boolean isStarted() {
        return instance != null;
    }

    public static AdMostPreferences newInstance(Context context) {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new AdMostPreferences(context);
                }
            }
        }
        return instance;
    }

    private void set(String str, String str2) {
        getEditor().putString(str, str2);
        getEditor().apply();
    }

    @TargetApi(11)
    public void addFacebookBiddingLog(String str, String str2) {
        synchronized (lockFBLog) {
            JSONObject facebookBiddingLog = getFacebookBiddingLog();
            if (facebookBiddingLog == null) {
                facebookBiddingLog = new JSONObject();
            }
            if (facebookBiddingLog.length() > 20) {
                AdMostLog.m296e("Facebook bidding log exceeded the maximum number of log capacity ..!");
                return;
            }
            try {
                facebookBiddingLog.put(str, str2);
                set("KEY_FB_BIDDING_DATA", facebookBiddingLog.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: package-private */
    @TargetApi(11)
    public void addInAppPurchase(AdMostInAppPurchaseItem adMostInAppPurchaseItem) {
        Set inAppPurchases = getInAppPurchases();
        if (inAppPurchases == null) {
            inAppPurchases = new HashSet();
        }
        inAppPurchases.add(adMostInAppPurchaseItem.getPostData());
        AdMostLog.m299i("New In App Purchase added. Total [" + inAppPurchases.size() + "] IAP in Local Storage right now.");
        getEditor().putStringSet("KEY_IAPS_DATA", inAppPurchases);
        getEditor().apply();
    }

    /* access modifiers changed from: package-private */
    public void addSessionPiece2nd(AdMostAnalyticsSessionPiece adMostAnalyticsSessionPiece) {
        String str;
        try {
            getSessionPieceCurrentIndex();
            SharedPreferences sharedPreferences = this.preferences;
            StringBuilder sb = new StringBuilder();
            sb.append("KEY_SESSION_PIECES_DATA_2ND");
            String str2 = "";
            sb.append(this.sessionPieceIndex == 1 ? str2 : Integer.valueOf(this.sessionPieceIndex));
            String string = sharedPreferences.getString(sb.toString(), str2);
            if (string.length() <= 10000) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(string);
                sb2.append(string.length() <= 0 ? str2 : "*");
                sb2.append(adMostAnalyticsSessionPiece.toString2nd());
                str = sb2.toString();
            } else if (this.sessionPieceIndex >= 30) {
                AdMostLog.m294d("AdMostImpression session NOT KEPT sessionPieceIndex : " + this.sessionPieceIndex + " sessionPieces.length() : " + string.length());
                return;
            } else {
                setSessionPieceCurrentIndex(this.sessionPieceIndex + 1);
                str = adMostAnalyticsSessionPiece.toString2nd();
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("KEY_SESSION_PIECES_DATA_2ND");
            sb3.append(this.sessionPieceIndex == 1 ? str2 : Integer.valueOf(this.sessionPieceIndex));
            set(sb3.toString(), str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void addToExperimentsTriedBefore(ArrayList<AdMostExperiment> arrayList) {
        if (arrayList != null) {
            int i = 0;
            String str = "";
            while (i < arrayList.size()) {
                try {
                    str = str + arrayList.get(i).Meta.f253Id + "*";
                    i++;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            set("KEY_EXPERIMENT_TRIED_BEFORE", this.preferences.getString("KEY_EXPERIMENT_TRIED_BEFORE", "") + "*" + str);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean campaignAlreadySent() {
        return this.preferences.getBoolean("KEY_INSTALL_REFERRER_CAMPAIGN_SENT", false);
    }

    public void clearPreferences() {
        getEditor().clear();
        getEditor().apply();
    }

    /* access modifiers changed from: package-private */
    public JSONObject getAdNetworkDataForSending() throws Exception {
        int i = 1;
        int i2 = this.preferences.getInt("KEY_AD_NETWORK_GET_SYNONYM", 1);
        if (i2 == 1) {
            i = 2;
        }
        set("KEY_AD_NETWORK_INCREMENT_SYNONYM", i);
        return new JSONObject(this.preferences.getString("KEY_AD_NETWORK_DATA" + i2, this.EMPTY_STRING));
    }

    /* access modifiers changed from: package-private */
    public String getAdjustUserId() {
        return this.preferences.getString("KEY_ADJUST_USER_ID", "");
    }

    public String getAdvId() {
        String str = this.advertId;
        if (str != null) {
            return str;
        }
        return this.preferences.getString("KEY_ADV_ID", "");
    }

    /* access modifiers changed from: package-private */
    public JSONObject getAllPolicies() {
        try {
            String string = this.preferences.getString("KEY_ALL_POLICIES", "");
            if (string.length() > 0) {
                return new JSONObject(string);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public String getApplicationUserId() {
        return this.preferences.getString("KEY_APPLICATION_USER_ID", "");
    }

    /* access modifiers changed from: package-private */
    public String getAppsflyerUserId() {
        return this.preferences.getString("KEY_APPSFLYER_USER_ID", "");
    }

    /* access modifiers changed from: package-private */
    public String getCampaignId(boolean z) {
        if (this.storedCampaignId.length() > 1) {
            return this.storedCampaignId;
        }
        this.storedCampaignId = this.preferences.getString("KEY_INSTALL_REFERRER_CAMPAIGN", "");
        if (z) {
            AdMostLog.m294d("Install Referrer Campaign Id Get from Preferences and value is = [" + this.storedCampaignId + "]");
        }
        return this.storedCampaignId;
    }

    /* access modifiers changed from: package-private */
    public String getClientCampaignId() {
        String string;
        synchronized (staticCampaignLock) {
            string = this.preferences.getString("KEY_INSTALL_REFERRER_CLIENT_CAMPAIGN_ID", "");
        }
        return string;
    }

    /* access modifiers changed from: package-private */
    public String getConsentStatus() {
        return this.preferences.getString("KEY_CONSENT_STATUS", "-1");
    }

    public String getCountry() {
        return this.country;
    }

    /* access modifiers changed from: package-private */
    public JSONObject getCurrentAdNetworkData(String str) throws Exception {
        return new JSONObject(this.preferences.getString(str, this.EMPTY_STRING));
    }

    /* access modifiers changed from: package-private */
    public String getCurrentImpressionPreferenceKey() throws Exception {
        return "KEY_AD_NETWORK_DATA" + this.preferences.getInt("KEY_AD_NETWORK_INCREMENT_SYNONYM", 1);
    }

    /* access modifiers changed from: package-private */
    public long getDeltaTime() {
        return this.preferences.getLong("KEY_DELTA_TIME", 0);
    }

    public String getExperimentAndGroup() {
        return this.preferences.getString("KEY_EXPERIMENT_GROUP", "");
    }

    public int getExperimentPercentile() {
        return this.experimentPercentile;
    }

    /* access modifiers changed from: package-private */
    public ArrayList<String> getExperimentsTriedBefore() {
        try {
            String[] split = this.preferences.getString("KEY_EXPERIMENT_TRIED_BEFORE", "").split("\\*");
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.addAll(Arrays.asList(split));
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void getFCapValues(String str, AdMostFrequencyCappingItem adMostFrequencyCappingItem) {
        try {
            JSONObject jSONObject = new JSONObject(this.preferences.getString("KEY_AD_FCAP_VALUES", this.EMPTY_STRING));
            if (jSONObject.has(str)) {
                JSONObject optJSONObject = jSONObject.optJSONObject(str);
                adMostFrequencyCappingItem.DailyCount = optJSONObject.optInt("DailyCount", 0);
                adMostFrequencyCappingItem.HourlyCount = optJSONObject.optInt("HourlyCount", 0);
                adMostFrequencyCappingItem.FcapDayStartedAt = optJSONObject.optLong("FcapDayStartedAt", 0);
                adMostFrequencyCappingItem.FcapHourStartedAt = optJSONObject.optLong("FcapHourStartedAt", 0);
                adMostFrequencyCappingItem.LastImpressionTime = optJSONObject.optLong("LastImpressionTime", 0);
                adMostFrequencyCappingItem.ZoneDailyCount = optJSONObject.optInt("ZoneDailyCount", 0);
                adMostFrequencyCappingItem.ZoneHourlyCount = optJSONObject.optInt("ZoneHourlyCount", 0);
                adMostFrequencyCappingItem.ZoneFcapDayStartedAt = optJSONObject.optLong("ZoneFcapDayStartedAt", 0);
                adMostFrequencyCappingItem.ZoneFcapHourStartedAt = optJSONObject.optLong("ZoneFcapHourStartedAt", 0);
                adMostFrequencyCappingItem.ZoneLastImpressionTime = optJSONObject.optLong("ZoneLastImpressionTime", 0);
                adMostFrequencyCappingItem.NffcCount = optJSONObject.optInt("NffcCount", 0);
                adMostFrequencyCappingItem.NffcCapTime = optJSONObject.optInt("NffcCapTime", 0);
                adMostFrequencyCappingItem.NffcStartedAt = optJSONObject.optLong("NffcStartedAt", 0);
                AdMostLog.m294d("FCAP values getting from preferences with key : { " + str + " } and ZoneDailyCount is : [" + adMostFrequencyCappingItem.ZoneDailyCount + " ] and ZoneHourlyCount is : [ " + adMostFrequencyCappingItem.ZoneHourlyCount + " ]");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @TargetApi(11)
    public JSONObject getFacebookBiddingLog() {
        try {
            return new JSONObject(this.preferences.getString("KEY_FB_BIDDING_DATA", this.EMPTY_STRING));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public ConcurrentHashMap<String, Boolean> getFirstRequestForZoneNetwork() {
        ConcurrentHashMap<String, Boolean> concurrentHashMap = new ConcurrentHashMap<>();
        try {
            JSONObject jSONObject = new JSONObject(this.preferences.getString("KEY_ZONE_NETWORK_REQUEST_DATA", this.EMPTY_STRING));
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                concurrentHashMap.put(next, Boolean.valueOf(jSONObject.getString(next).equals("1")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return concurrentHashMap;
    }

    /* access modifiers changed from: package-private */
    public long getFirstSessionStartedAt() {
        return this.preferences.getLong("KEY_FIRST_SESSION_STARTED_AT", -1);
    }

    /* access modifiers changed from: package-private */
    public FpDefaultItem getFpDefaultForZone(String str) {
        try {
            JSONObject jSONObject = new JSONObject(this.preferences.getString("KEY_FP_DEFAULTS", this.EMPTY_STRING));
            if (jSONObject.has(str)) {
                return new FpDefaultItem(jSONObject.getJSONObject(str));
            }
            return new FpDefaultItem(new JSONObject(String.format(Locale.ENGLISH, "{\"placement\":\"%s\",\"status\":\"%s\",\"weight\":%d,\"time\":%d}", new Object[]{"", AdMostFloorPriceManager.FP_ZONE_NETWORK_STATUS_FIRST_REQUEST, 0, Long.valueOf(System.currentTimeMillis())})));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getGUID() {
        String string = this.preferences.getString("KEY_ID", "");
        if (string.length() >= 1) {
            return string;
        }
        String hexString = Long.toHexString(Math.abs(new Random().nextLong() % 10000000000L));
        set("KEY_ID", hexString);
        return hexString;
    }

    /* access modifiers changed from: package-private */
    @TargetApi(11)
    public Set<String> getInAppPurchases() {
        try {
            return this.preferences.getStringSet("KEY_IAPS_DATA", (Set) null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public String getInstallReferrer() {
        return this.preferences.getString("KEY_INSTALL_REFERRER", "");
    }

    /* access modifiers changed from: package-private */
    public int getLastEcpmForZone(String str) {
        try {
            return new JSONObject(this.preferences.getString("KEY_ZONE_LAST_ECPM", this.EMPTY_STRING)).optInt(str, 0);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    public String getOfferWallNetworks() {
        return this.preferences.getString("KEY_OFFERWALLSHOW_DATA", this.EMPTY_STRING);
    }

    public int getPercentile() {
        return this.percentile;
    }

    /* access modifiers changed from: package-private */
    public boolean getPolicyEnabled() {
        return this.preferences.getBoolean("KEY_POLICY_ENABLED", false);
    }

    /* access modifiers changed from: package-private */
    public void getRandomizerBypassValues(String str, AdMostRandomizerBypassItem adMostRandomizerBypassItem) {
        try {
            JSONObject jSONObject = new JSONObject(this.preferences.getString("KEY_RANDOMIZER_BYPASS_VALUES", this.EMPTY_STRING));
            if (jSONObject.has(str)) {
                JSONObject optJSONObject = jSONObject.optJSONObject(str);
                adMostRandomizerBypassItem.Count = optJSONObject.optInt("count", 0);
                adMostRandomizerBypassItem.StartedAt = optJSONObject.optLong("startedAt", 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public AdmostResponseCache getResponseCacheFromPrefs(String str) {
        try {
            String string = this.preferences.getString(str, "");
            if (string.length() > 0) {
                return new AdmostResponseCache(string);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public String getSSVData() {
        return this.preferences.getString("KEY_SSV_DATA", this.EMPTY_STRING);
    }

    /* access modifiers changed from: package-private */
    public int getSessionPieceCurrentIndex() {
        if (this.sessionPieceIndex <= 0) {
            this.sessionPieceIndex = this.preferences.getInt("KEY_SESSION_PIECES_DATA_2ND_INDEX", 1);
        }
        return this.sessionPieceIndex;
    }

    /* access modifiers changed from: package-private */
    public JSONArray getSessionPieces() {
        try {
            return new JSONArray(this.preferences.getString("KEY_SESSION_PIECES_DATA", this.EMPTY_ARRAY));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public String[] getSessionPieces2nd(int i) {
        try {
            SharedPreferences sharedPreferences = this.preferences;
            StringBuilder sb = new StringBuilder();
            sb.append("KEY_SESSION_PIECES_DATA_2ND");
            sb.append(i == 1 ? "" : Integer.valueOf(i));
            return sharedPreferences.getString(sb.toString(), "").split("\\*");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getState() {
        return this.state;
    }

    public String getUserDataForManager() {
        return this.preferences.getString("KEY_USER_DATA_FOR_MANAGER", "");
    }

    /* access modifiers changed from: package-private */
    public String getUserId() {
        return this.preferences.getString("KEY_USER_ID", "");
    }

    /* access modifiers changed from: package-private */
    public String getUserUpdateData() {
        return this.preferences.getString("KEY_AD_USER_UPDATE_DATA", "");
    }

    public int getZoneImpressionCount(String str) {
        try {
            return new JSONObject(this.preferences.getString("KEY_ZONE_IMPRESSION_DATA", this.EMPTY_STRING)).optInt(str, -1);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isAnalyticsDisabled() {
        return this.preferences.getBoolean("KEY_ANALYTICS_DISABLED", false);
    }

    /* access modifiers changed from: package-private */
    public boolean isClientCampaignIdRequested() {
        boolean z;
        synchronized (staticCampaignLock) {
            z = this.preferences.getBoolean("KEY_INSTALL_REFERRER_CLIENT_CAMPAIGN_ID_REQUESTED", false);
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public boolean isFirstRequestForZoneNetwork(String str) {
        try {
            JSONObject jSONObject = new JSONObject(this.preferences.getString("KEY_ZONE_NETWORK_REQUEST_DATA", this.EMPTY_STRING));
            if (!jSONObject.has(str) || jSONObject.getString(str).equals("1")) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isLogEnabled() {
        return this.preferences.getBoolean("KEY_IS_LOG_ENABLED", false);
    }

    /* access modifiers changed from: package-private */
    public boolean isServerCampaignIdOverrides() {
        boolean z;
        synchronized (staticCampaignLock) {
            z = this.preferences.getBoolean("KEY_INSTALL_REFERRER_SERVER_CAMPAIGN_ID_OVERRIDE", false);
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public boolean isSessionPieceConversionDone() {
        return this.preferences.getInt("KEY_SESSION_PIECE_CONVERSION_DONE", 0) == 1;
    }

    /* access modifiers changed from: package-private */
    public boolean isUserRegistered() {
        return this.preferences.getBoolean("KEY_REGISTER_REQUEST_DONE", false);
    }

    public void keepExperimentAndGroup(String str, String str2) {
        set("KEY_EXPERIMENT_GROUP", str + "*" + str2);
    }

    public void keepFirstRequestForZoneNetwork(String str, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject(this.preferences.getString("KEY_ZONE_NETWORK_REQUEST_DATA", this.EMPTY_STRING));
            jSONObject.put(str, z ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
            set("KEY_ZONE_NETWORK_REQUEST_DATA", jSONObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void keepOfferwallReward(String str, String str2, int i) {
        try {
            JSONObject jSONObject = new JSONObject(this.preferences.getString("KEY_OFFERWALL_STORED_DATA", this.EMPTY_STRING));
            String str3 = str + "*" + str2;
            jSONObject.put(str3, jSONObject.optInt(str3, 0) + i);
            set("KEY_OFFERWALL_STORED_DATA", jSONObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void keepZoneImpressionCount(String str, int i) {
        try {
            JSONObject jSONObject = new JSONObject(this.preferences.getString("KEY_ZONE_IMPRESSION_DATA", this.EMPTY_STRING));
            jSONObject.put(str, i);
            set("KEY_ZONE_IMPRESSION_DATA", jSONObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void overrideCampaignIdByClient() {
        synchronized (staticCampaignLock) {
            boolean isForceServerCampaignId = AdMost.getInstance().getConfiguration().isForceServerCampaignId();
            String clientCampaignId = getInstance().getClientCampaignId();
            set("KEY_INSTALL_REFERRER_SERVER_CAMPAIGN_ID_OVERRIDE", isForceServerCampaignId);
            if (!isForceServerCampaignId) {
                AdMostLog.m294d("Install Referrer Campaign Id (Static) Stored in Preferences and Stored value is = [" + clientCampaignId + "]");
                set("KEY_INSTALL_REFERRER_CAMPAIGN", clientCampaignId);
                this.storedCampaignId = clientCampaignId;
            } else {
                AdMostLog.allError("Static Campaign Id can not be set. Campaign ID is forced by server.");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void removeAdNetworkData() {
        try {
            set("KEY_AD_NETWORK_DATA" + this.preferences.getInt("KEY_AD_NETWORK_GET_SYNONYM", 1), new JSONObject().toString());
            set("KEY_AD_NETWORK_GET_SYNONYM", this.preferences.getInt("KEY_AD_NETWORK_INCREMENT_SYNONYM", 1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @TargetApi(11)
    public void removeFacebookBiddingLog(String str) {
        synchronized (lockFBLog) {
            JSONObject facebookBiddingLog = getFacebookBiddingLog();
            if (facebookBiddingLog == null) {
                facebookBiddingLog = new JSONObject();
            }
            try {
                facebookBiddingLog.remove(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
            set("KEY_FB_BIDDING_DATA", facebookBiddingLog.toString());
        }
    }

    /* access modifiers changed from: package-private */
    public void removeFirstRequestForZone(String str) {
        try {
            JSONArray names = new JSONObject(this.preferences.getString("KEY_ZONE_NETWORK_REQUEST_DATA", this.EMPTY_STRING)).names();
            for (int i = 0; i < names.length(); i++) {
                String string = names.getString(i);
                if (string.contains(str + "*")) {
                    keepFirstRequestForZoneNetwork(names.getString(i), true);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void removeFpDefaults() {
        set("KEY_FP_DEFAULTS", this.EMPTY_STRING);
    }

    /* access modifiers changed from: package-private */
    public void removeFpDefaultsForZone(String str) {
        try {
            JSONArray names = new JSONObject(this.preferences.getString("KEY_FP_DEFAULTS", this.EMPTY_STRING)).names();
            for (int i = 0; i < names.length(); i++) {
                String string = names.getString(i);
                if (string.contains(str + "*")) {
                    setFpDefaultForZone(names.getString(i), AdMostFloorPriceManager.FP_ZONE_NETWORK_STATUS_FIRST_REQUEST, "", 0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    @TargetApi(11)
    public void removeInAppPurchase(String str) {
        Set inAppPurchases = getInAppPurchases();
        if (inAppPurchases == null) {
            inAppPurchases = new HashSet();
        }
        try {
            inAppPurchases.remove(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        AdMostLog.m299i("In App Purchase removed. Total [" + inAppPurchases.size() + "] IAP in Local Storage right now.");
        getEditor().putStringSet("KEY_IAPS_DATA", inAppPurchases);
        getEditor().apply();
    }

    /* access modifiers changed from: package-private */
    public void removeItemFromPreferences(String str) {
        if (getEditor() != null) {
            getEditor().remove(str);
            getEditor().apply();
        }
    }

    public void removeOfferWallNetwork(String str) {
        try {
            JSONObject jSONObject = new JSONObject(this.preferences.getString("KEY_OFFERWALLSHOW_DATA", this.EMPTY_STRING));
            jSONObject.remove(str);
            set("KEY_OFFERWALLSHOW_DATA", jSONObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void removeSSVData(String str) {
        try {
            JSONObject jSONObject = new JSONObject(this.preferences.getString("KEY_SSV_DATA", this.EMPTY_STRING));
            jSONObject.remove(str);
            set("KEY_SSV_DATA", jSONObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void replaceSessionPieces2nd(String str, int i) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("KEY_SESSION_PIECES_DATA_2ND");
            sb.append(i == 1 ? "" : Integer.valueOf(i));
            set(sb.toString(), str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void requestClientCampaignId(String str) {
        synchronized (staticCampaignLock) {
            set("KEY_INSTALL_REFERRER_CLIENT_CAMPAIGN_ID", str);
            set("KEY_INSTALL_REFERRER_CLIENT_CAMPAIGN_ID_REQUESTED", true);
        }
    }

    /* access modifiers changed from: package-private */
    public void setAdjustUserId(String str) {
        set("KEY_ADJUST_USER_ID", str);
    }

    /* access modifiers changed from: package-private */
    public void setAdvId(String str) {
        set("KEY_ADV_ID", str);
        this.advertId = str;
    }

    /* access modifiers changed from: package-private */
    public void setAnalyticsDisabled(boolean z) {
        set("KEY_ANALYTICS_DISABLED", z);
    }

    /* access modifiers changed from: package-private */
    public void setApplicationUserId(String str) {
        set("KEY_APPLICATION_USER_ID", str);
    }

    /* access modifiers changed from: package-private */
    public void setAppsflyerUserId(String str) {
        set("KEY_APPSFLYER_USER_ID", str);
    }

    /* access modifiers changed from: package-private */
    public void setCampaignId(String str) {
        if (!isClientCampaignIdRequested() || isServerCampaignIdOverrides()) {
            set("KEY_INSTALL_REFERRER_CAMPAIGN", str);
            this.storedCampaignId = str;
        } else {
            try {
                AdMostLog.m294d("Install Referrer Campaign Id (Static) Stored in Preferences and Stored value is = [" + getInstance().getCampaignId(false) + "]");
            } catch (Exception unused) {
            }
        }
        set("KEY_INSTALL_REFERRER_CAMPAIGN_SENT", true);
    }

    /* access modifiers changed from: package-private */
    public void setConsentListener(AdMost.PrivacyConsentListener privacyConsentListener) {
        synchronized (gdprListenerLock) {
            this.consentListener = privacyConsentListener;
        }
    }

    /* access modifiers changed from: package-private */
    public void setConsentStatus(Boolean bool) {
        set("KEY_CONSENT_STATUS", bool.booleanValue() ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
    }

    /* access modifiers changed from: package-private */
    public void setCountry(String str) {
        this.country = str;
        set("KEY_AD_CACHE_COUNTRY", str);
    }

    /* access modifiers changed from: package-private */
    public void setDeltaTime(long j) {
        set("KEY_DELTA_TIME", j);
    }

    /* access modifiers changed from: package-private */
    public int setFPZoneFillCount(String str, boolean z) {
        int i;
        int i2 = 0;
        try {
            JSONObject jSONObject = new JSONObject(this.preferences.getString("KEY_FP_ZONE_FILL_COUNTS", this.EMPTY_STRING));
            if (z) {
                i = (jSONObject.has(str) ? jSONObject.getJSONObject(str).getInt("count") : 0) + 1;
            } else {
                i = 0;
            }
            try {
                jSONObject.put(str, new JSONObject(String.format(Locale.ENGLISH, "{\"count\":%d}", new Object[]{Integer.valueOf(i)})));
                set("KEY_FP_ZONE_FILL_COUNTS", jSONObject.toString());
                return i;
            } catch (Exception e) {
                e = e;
                i2 = i;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            return i2;
        }
    }

    /* access modifiers changed from: package-private */
    public void setFirstSessionStartedAt(long j) {
        set("KEY_FIRST_SESSION_STARTED_AT", j);
    }

    /* access modifiers changed from: package-private */
    public FpDefaultItem setFpDefaultForZone(String str, String str2, String str3, int i) {
        try {
            JSONObject jSONObject = new JSONObject(this.preferences.getString("KEY_FP_DEFAULTS", this.EMPTY_STRING));
            JSONObject jSONObject2 = new JSONObject(String.format(Locale.ENGLISH, "{\"placement\":\"%s\",\"status\":\"%s\",\"weight\":%d,\"time\":%d}", new Object[]{str3, str2, Integer.valueOf(i), Long.valueOf(System.currentTimeMillis())}));
            jSONObject.put(str, jSONObject2);
            set("KEY_FP_DEFAULTS", jSONObject.toString());
            return new FpDefaultItem(jSONObject2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void setInstallReferrer(String str) {
        AdMostLog.m294d("Install Referrer Stored in Preferences and Stored value is = [" + str + "]");
        set("KEY_INSTALL_REFERRER", str);
    }

    /* access modifiers changed from: package-private */
    public void setLastEcpmForZone(String str, int i) {
        try {
            JSONObject jSONObject = new JSONObject(this.preferences.getString("KEY_ZONE_LAST_ECPM", this.EMPTY_STRING));
            jSONObject.put(str, i);
            set("KEY_ZONE_LAST_ECPM", jSONObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void setLogEnabled(Boolean bool) {
        set("KEY_IS_LOG_ENABLED", bool.booleanValue());
    }

    public void setOfferWallNetwork(String str) {
        try {
            JSONObject jSONObject = new JSONObject(this.preferences.getString("KEY_OFFERWALLSHOW_DATA", this.EMPTY_STRING));
            jSONObject.put(str, "");
            set("KEY_OFFERWALLSHOW_DATA", jSONObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void setPolicies(JSONArray jSONArray, JSONArray jSONArray2) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"ZoneAdPolicies\":");
        String str = "[]";
        sb.append(jSONArray == null ? str : jSONArray.toString());
        sb.append(",\"TagAdPolicies\":");
        if (jSONArray2 != null) {
            str = jSONArray2.toString();
        }
        sb.append(str);
        sb.append("}");
        set("KEY_ALL_POLICIES", sb.toString());
    }

    /* access modifiers changed from: package-private */
    public void setPolicyEnabled(boolean z) {
        set("KEY_POLICY_ENABLED", z);
    }

    /* access modifiers changed from: package-private */
    public void setResponseCache(String str, AdmostResponseCache admostResponseCache) {
        if (getEditor() != null && admostResponseCache != null && admostResponseCache.getJsonObject() != null) {
            getEditor().putString(str, admostResponseCache.getJsonObject().toString());
            getEditor().apply();
        }
    }

    /* access modifiers changed from: package-private */
    public void setSSVData(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(this.preferences.getString("KEY_SSV_DATA", this.EMPTY_STRING));
            jSONObject.put(str, new JSONObject(str2));
            set("KEY_SSV_DATA", jSONObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void setSessionPieceConversionDone() {
        set("KEY_SESSION_PIECE_CONVERSION_DONE", 1);
    }

    /* access modifiers changed from: package-private */
    public void setSessionPieceCurrentIndex(int i) {
        this.sessionPieceIndex = i;
        set("KEY_SESSION_PIECES_DATA_2ND_INDEX", i);
    }

    /* access modifiers changed from: package-private */
    public void setState(String str) {
        this.state = str;
        set("KEY_AD_CACHE_STATE", str);
        set("KEY_AD_STATE_REQUESTED_BEFORE", "1");
    }

    /* access modifiers changed from: package-private */
    public void setSubscripitonQueryDone() {
        set("KEY_SUBSCRIPTION_QUERY_DONE", true);
    }

    /* access modifiers changed from: package-private */
    public void setUserDataForManager(String str) {
        set("KEY_USER_DATA_FOR_MANAGER", str);
    }

    /* access modifiers changed from: package-private */
    public void setUserId(String str) {
        set("KEY_USER_ID", str);
    }

    /* access modifiers changed from: package-private */
    public void setUserRegistered(boolean z) {
        set("KEY_REGISTER_REQUEST_DONE", z);
    }

    /* access modifiers changed from: package-private */
    public void setUserUpdateData(String str) {
        set("KEY_AD_USER_UPDATE_DATA", str);
    }

    public void spendOfferwallReward(String str, AdMostVirtualCurrencyListener adMostVirtualCurrencyListener) {
        try {
            JSONObject jSONObject = new JSONObject(this.preferences.getString("KEY_OFFERWALL_STORED_DATA", this.EMPTY_STRING));
            Iterator<String> keys = jSONObject.keys();
            String str2 = null;
            while (keys.hasNext()) {
                str2 = keys.next();
                String[] split = str2.split("\\*");
                if (split != null) {
                    if (split.length >= 1) {
                        if (str == null) {
                            str = split[0];
                        }
                        String str3 = "Coin";
                        if (split.length > 1) {
                            str3 = split[1];
                        }
                        if (split[0].equals(str) && (jSONObject.get(str2) instanceof Integer)) {
                            adMostVirtualCurrencyListener.onSuccess(str, str3, Double.valueOf(jSONObject.get(str2) + "").doubleValue());
                            jSONObject.remove(str2);
                        }
                    }
                }
            }
            if (str2 != null) {
                set("KEY_OFFERWALL_STORED_DATA", jSONObject.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void storeAdNetworkData(String str, String str2) throws Exception {
        set(str, str2);
    }

    /* access modifiers changed from: package-private */
    public void storeFCapValues(String str, AdMostFrequencyCappingItem adMostFrequencyCappingItem) {
        try {
            JSONObject jSONObject = new JSONObject(this.preferences.getString("KEY_AD_FCAP_VALUES", this.EMPTY_STRING));
            jSONObject.put(str, new JSONObject(String.format(Locale.ENGLISH, "{\"DailyCount\":%d,\"HourlyCount\":%d,\"FcapDayStartedAt\":%d,\"FcapHourStartedAt\":%d,\"LastImpressionTime\":%d,\"ZoneDailyCount\":%d,\"ZoneHourlyCount\":%d,\"ZoneFcapDayStartedAt\":%d,\"ZoneFcapHourStartedAt\":%d,\"NffcCount\":%d,\"NffcCapTime\":%d,\"NffcStartedAt\":%d,\"ZoneLastImpressionTime\":%d}", new Object[]{Integer.valueOf(adMostFrequencyCappingItem.DailyCount), Integer.valueOf(adMostFrequencyCappingItem.HourlyCount), Long.valueOf(adMostFrequencyCappingItem.FcapDayStartedAt), Long.valueOf(adMostFrequencyCappingItem.FcapHourStartedAt), Long.valueOf(adMostFrequencyCappingItem.LastImpressionTime), Integer.valueOf(adMostFrequencyCappingItem.ZoneDailyCount), Integer.valueOf(adMostFrequencyCappingItem.ZoneHourlyCount), Long.valueOf(adMostFrequencyCappingItem.ZoneFcapDayStartedAt), Long.valueOf(adMostFrequencyCappingItem.ZoneFcapHourStartedAt), Integer.valueOf(adMostFrequencyCappingItem.NffcCount), Integer.valueOf(adMostFrequencyCappingItem.NffcCapTime), Long.valueOf(adMostFrequencyCappingItem.NffcStartedAt), Long.valueOf(adMostFrequencyCappingItem.ZoneLastImpressionTime)})));
            set("KEY_AD_FCAP_VALUES", jSONObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void storeRandomizerBypassValues(String str, AdMostRandomizerBypassItem adMostRandomizerBypassItem) {
        try {
            JSONObject jSONObject = new JSONObject(this.preferences.getString("KEY_RANDOMIZER_BYPASS_VALUES", this.EMPTY_STRING));
            jSONObject.put(str, new JSONObject(String.format(Locale.ENGLISH, "{\"count\":%d,\"startedAt\":%d}", new Object[]{Integer.valueOf(adMostRandomizerBypassItem.Count), Long.valueOf(adMostRandomizerBypassItem.StartedAt)})));
            set("KEY_RANDOMIZER_BYPASS_VALUES", jSONObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean subscripitonQueryDone() {
        return this.preferences.getBoolean("KEY_SUBSCRIPTION_QUERY_DONE", false);
    }

    private void set(String str, int i) {
        getEditor().putInt(str, i);
        getEditor().apply();
    }

    private void set(String str, long j) {
        getEditor().putLong(str, j);
        getEditor().apply();
    }

    public static AdMostPreferences newInstance(Context context, AdMost.PrivacyConsentListener privacyConsentListener) {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new AdMostPreferences(context, privacyConsentListener);
                }
            }
        }
        return instance;
    }

    private void set(String str, boolean z) {
        getEditor().putBoolean(str, z);
        getEditor().apply();
    }

    private AdMostPreferences(Context context) {
        initPreferences(context);
    }
}
