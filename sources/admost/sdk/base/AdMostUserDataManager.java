package admost.sdk.base;

import android.os.Build;
import com.loopj.android.http.C4250c;
import java.net.URLEncoder;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONObject;

public class AdMostUserDataManager {
    private static AdMostUserDataManager instance;
    private static final Object lock = new Object();
    private AdMostUserDataActivity activityData = new AdMostUserDataActivity((JSONObject) null);
    private AdMostUserDataAds adsData = new AdMostUserDataAds((JSONObject) null);
    private boolean dataChanged = false;
    private AdMostUserDataIAP iapData = new AdMostUserDataIAP((JSONObject) null);
    private boolean initialized;
    private boolean isUserDataEnabled;

    private static class AdMostUserDataAds {
        /* access modifiers changed from: private */
        public Hashtable<String, AdMostUserDataAdsDetail> adsDetailHashtable = new Hashtable<>();

        AdMostUserDataAds(JSONObject jSONObject) {
            if (jSONObject != null) {
                try {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        this.adsDetailHashtable.put(next, new AdMostUserDataAdsDetail(jSONObject.getJSONObject(next)));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public String toFormattedJSONString(int i) {
            StringBuilder sb = new StringBuilder();
            Hashtable<String, AdMostUserDataAdsDetail> hashtable = this.adsDetailHashtable;
            if (hashtable != null && hashtable.size() > 0) {
                for (String next : this.adsDetailHashtable.keySet()) {
                    sb.append(String.format(Locale.ENGLISH, "\"%s\" : %s,", new Object[]{next, this.adsDetailHashtable.get(next).toFormattedJSONString(i)}));
                }
            }
            String sb2 = sb.toString();
            Object[] objArr = new Object[1];
            objArr[0] = sb2.length() > 0 ? sb2.substring(0, sb2.length() - 1) : "";
            return String.format("{%s}", objArr);
        }

        /* access modifiers changed from: package-private */
        public String toJSONString() {
            StringBuilder sb = new StringBuilder();
            Hashtable<String, AdMostUserDataAdsDetail> hashtable = this.adsDetailHashtable;
            if (hashtable != null && hashtable.size() > 0) {
                for (String next : this.adsDetailHashtable.keySet()) {
                    sb.append(String.format(Locale.ENGLISH, "\"%s\" : %s,", new Object[]{next, this.adsDetailHashtable.get(next).toJSONString()}));
                }
            }
            String sb2 = sb.toString();
            Object[] objArr = new Object[1];
            objArr[0] = sb2.length() > 0 ? sb2.substring(0, sb2.length() - 1) : "";
            return String.format("{%s}", objArr);
        }

        private static class AdMostUserDataAdsDetail {
            private long clickCount;
            /* access modifiers changed from: private */
            public String lastDate;
            /* access modifiers changed from: private */
            public long lastDayViewCount;
            private long loadedAdCount;
            private long noFillCount;
            private long requestCount;
            private long totalECPMValue;
            private long viewCount;

            AdMostUserDataAdsDetail() {
                this.lastDate = "";
            }

            static /* synthetic */ long access$1314(AdMostUserDataAdsDetail adMostUserDataAdsDetail, long j) {
                long j2 = adMostUserDataAdsDetail.lastDayViewCount + j;
                adMostUserDataAdsDetail.lastDayViewCount = j2;
                return j2;
            }

            static /* synthetic */ long access$1414(AdMostUserDataAdsDetail adMostUserDataAdsDetail, long j) {
                long j2 = adMostUserDataAdsDetail.viewCount + j;
                adMostUserDataAdsDetail.viewCount = j2;
                return j2;
            }

            static /* synthetic */ long access$1514(AdMostUserDataAdsDetail adMostUserDataAdsDetail, long j) {
                long j2 = adMostUserDataAdsDetail.clickCount + j;
                adMostUserDataAdsDetail.clickCount = j2;
                return j2;
            }

            static /* synthetic */ long access$1614(AdMostUserDataAdsDetail adMostUserDataAdsDetail, long j) {
                long j2 = adMostUserDataAdsDetail.loadedAdCount + j;
                adMostUserDataAdsDetail.loadedAdCount = j2;
                return j2;
            }

            static /* synthetic */ long access$1714(AdMostUserDataAdsDetail adMostUserDataAdsDetail, long j) {
                long j2 = adMostUserDataAdsDetail.noFillCount + j;
                adMostUserDataAdsDetail.noFillCount = j2;
                return j2;
            }

            static /* synthetic */ long access$1814(AdMostUserDataAdsDetail adMostUserDataAdsDetail, long j) {
                long j2 = adMostUserDataAdsDetail.requestCount + j;
                adMostUserDataAdsDetail.requestCount = j2;
                return j2;
            }

            static /* synthetic */ long access$1918(AdMostUserDataAdsDetail adMostUserDataAdsDetail, double d) {
                double d2 = (double) adMostUserDataAdsDetail.totalECPMValue;
                Double.isNaN(d2);
                long j = (long) (d2 + d);
                adMostUserDataAdsDetail.totalECPMValue = j;
                return j;
            }

            /* access modifiers changed from: package-private */
            public String toFormattedJSONString(int i) {
                Locale locale = Locale.ENGLISH;
                Object[] objArr = new Object[8];
                double d = (double) this.viewCount;
                double d2 = 1.0d;
                Double.isNaN(d);
                double d3 = d * 1.0d;
                if (i != 0) {
                    double d4 = (double) i;
                    Double.isNaN(d4);
                    d2 = 1.0d * d4;
                }
                objArr[0] = Double.valueOf(d3 / d2);
                objArr[1] = Long.valueOf(this.lastDayViewCount);
                objArr[2] = Long.valueOf(this.totalECPMValue);
                objArr[3] = Long.valueOf(this.viewCount);
                objArr[4] = Long.valueOf(this.requestCount);
                objArr[5] = Long.valueOf(this.clickCount);
                objArr[6] = Long.valueOf(this.loadedAdCount);
                objArr[7] = Long.valueOf(this.noFillCount);
                return String.format(locale, "{\"DailyAverageViewCount\" : %f,\"LastDayViewCount\" : %d,\"TotalECPMValue\" : %d,\"TotalViewCount\" : %d,\"TotalRequestCount\" : %d,\"ClickCount\" : %d,\"TotalFillCount\" : %d,\"TotalNoFillCount\" : %d}", objArr);
            }

            /* access modifiers changed from: package-private */
            public String toJSONString() {
                return String.format(Locale.ENGLISH, "{\"lastDayViewCount\" : %d,\"lastDate\" : \"%s\",\"totalECPMValue\" : %d,\"loadedAdCount\" : %d,\"viewCount\" : %d,\"clickCount\" : %d,\"noFillCount\" : %d,\"requestCount\" : %d}", new Object[]{Long.valueOf(this.lastDayViewCount), this.lastDate, Long.valueOf(this.totalECPMValue), Long.valueOf(this.loadedAdCount), Long.valueOf(this.viewCount), Long.valueOf(this.clickCount), Long.valueOf(this.noFillCount), Long.valueOf(this.requestCount)});
            }

            AdMostUserDataAdsDetail(JSONObject jSONObject) {
                if (jSONObject != null) {
                    try {
                        this.lastDayViewCount = jSONObject.optLong("lastDayViewCount", 0);
                        this.lastDate = jSONObject.optString("lastDate", "");
                        this.totalECPMValue = jSONObject.optLong("totalECPMValue", 0);
                        this.loadedAdCount = jSONObject.optLong("loadedAdCount", 0);
                        this.viewCount = jSONObject.optLong("viewCount", 0);
                        this.clickCount = jSONObject.optLong("clickCount", 0);
                        this.noFillCount = jSONObject.optLong("noFillCount", 0);
                        this.requestCount = jSONObject.optLong("requestCount", 0);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private AdMostUserDataManager() {
        initialize();
    }

    private void clearOldActivityData() {
        if (this.activityData.dailySessions != null && this.activityData.dailySessions.size() > 0) {
            Iterator it = this.activityData.dailySessions.keySet().iterator();
            long currentTimeFromServer = AdMostAnalyticsManager.getInstance().getCurrentTimeFromServer();
            while (it.hasNext()) {
                try {
                    if (AdMostAnalyticsManager.getInstance().dateFormat.parse((String) it.next()).getTime() < currentTimeFromServer - 864000000) {
                        it.remove();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static AdMostUserDataManager getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new AdMostUserDataManager();
                }
            }
        }
        return instance;
    }

    private void initialize() {
        if (!this.initialized && AdMost.getInstance().isInitCompleted()) {
            this.isUserDataEnabled = AdMost.getInstance().getConfiguration().isUserDataEnabled();
            this.initialized = true;
            restoreData();
        }
    }

    private boolean isStateAvailable() {
        if (!this.initialized) {
            initialize();
        }
        return this.initialized && this.isUserDataEnabled;
    }

    private void restoreData() {
        String userDataForManager;
        if (isStateAvailable() && (userDataForManager = AdMostPreferences.getInstance().getUserDataForManager()) != null && userDataForManager.length() > 0) {
            try {
                JSONObject jSONObject = new JSONObject(userDataForManager);
                this.activityData = new AdMostUserDataActivity(jSONObject.getJSONObject("activityData"));
                this.iapData = new AdMostUserDataIAP(jSONObject.getJSONObject("iapData"));
                this.adsData = new AdMostUserDataAds(jSONObject.getJSONObject("adsData"));
            } catch (Exception e) {
                AdMostPreferences.getInstance().setUserDataForManager("");
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public String getUserData() {
        String str;
        int i;
        String str2;
        if (!isStateAvailable()) {
            return "{\"error\":\"IllegalState error : User data not enabled or SDK not initialized yet ..!\"}";
        }
        try {
            i = AdMost.getInstance().getContext().getPackageManager().getPackageInfo(AdMost.getInstance().getContext().getPackageName(), 0).versionCode;
            try {
                str = URLEncoder.encode(Build.BRAND, C4250c.DEFAULT_CHARSET);
                try {
                    str2 = URLEncoder.encode(Build.MODEL, C4250c.DEFAULT_CHARSET);
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    str2 = "";
                    Locale locale = Locale.ENGLISH;
                    return String.format(locale, "{\"UserId\" : \"%s\",\"AppId\" : \"%s\",\"MetaData\" : {\"InstalledAt\" : \"%s\",\"AppVersion\" : \"%s\",\"OSVersion\" : \"%s\",\"SDKVersion\" : \"%s\",\"Device\" : {\"Brand\" : \"%s\",\"Model\" : \"%s\"}},\"Activity\" : %s, \"IAP\" : %s,\"Ads\" : %s}", new Object[]{AdMostAnalyticsManager.getInstance().getUserId(), AdMost.getInstance().getAppId(), AdMostAnalyticsManager.getInstance().getInstallDate(), i + "", Build.VERSION.SDK_INT + "", AdMost.getInstance().getVersion(), str, str2, this.activityData.toFormattedJSONString(), this.iapData.toFormattedJSONString(), this.adsData.toFormattedJSONString(this.activityData.daysActive)});
                }
            } catch (Exception e2) {
                e = e2;
                str = "";
                e.printStackTrace();
                str2 = "";
                Locale locale2 = Locale.ENGLISH;
                return String.format(locale2, "{\"UserId\" : \"%s\",\"AppId\" : \"%s\",\"MetaData\" : {\"InstalledAt\" : \"%s\",\"AppVersion\" : \"%s\",\"OSVersion\" : \"%s\",\"SDKVersion\" : \"%s\",\"Device\" : {\"Brand\" : \"%s\",\"Model\" : \"%s\"}},\"Activity\" : %s, \"IAP\" : %s,\"Ads\" : %s}", new Object[]{AdMostAnalyticsManager.getInstance().getUserId(), AdMost.getInstance().getAppId(), AdMostAnalyticsManager.getInstance().getInstallDate(), i + "", Build.VERSION.SDK_INT + "", AdMost.getInstance().getVersion(), str, str2, this.activityData.toFormattedJSONString(), this.iapData.toFormattedJSONString(), this.adsData.toFormattedJSONString(this.activityData.daysActive)});
            }
        } catch (Exception e3) {
            e = e3;
            str = "";
            i = 0;
            e.printStackTrace();
            str2 = "";
            Locale locale22 = Locale.ENGLISH;
            return String.format(locale22, "{\"UserId\" : \"%s\",\"AppId\" : \"%s\",\"MetaData\" : {\"InstalledAt\" : \"%s\",\"AppVersion\" : \"%s\",\"OSVersion\" : \"%s\",\"SDKVersion\" : \"%s\",\"Device\" : {\"Brand\" : \"%s\",\"Model\" : \"%s\"}},\"Activity\" : %s, \"IAP\" : %s,\"Ads\" : %s}", new Object[]{AdMostAnalyticsManager.getInstance().getUserId(), AdMost.getInstance().getAppId(), AdMostAnalyticsManager.getInstance().getInstallDate(), i + "", Build.VERSION.SDK_INT + "", AdMost.getInstance().getVersion(), str, str2, this.activityData.toFormattedJSONString(), this.iapData.toFormattedJSONString(), this.adsData.toFormattedJSONString(this.activityData.daysActive)});
        }
        Locale locale222 = Locale.ENGLISH;
        return String.format(locale222, "{\"UserId\" : \"%s\",\"AppId\" : \"%s\",\"MetaData\" : {\"InstalledAt\" : \"%s\",\"AppVersion\" : \"%s\",\"OSVersion\" : \"%s\",\"SDKVersion\" : \"%s\",\"Device\" : {\"Brand\" : \"%s\",\"Model\" : \"%s\"}},\"Activity\" : %s, \"IAP\" : %s,\"Ads\" : %s}", new Object[]{AdMostAnalyticsManager.getInstance().getUserId(), AdMost.getInstance().getAppId(), AdMostAnalyticsManager.getInstance().getInstallDate(), i + "", Build.VERSION.SDK_INT + "", AdMost.getInstance().getVersion(), str, str2, this.activityData.toFormattedJSONString(), this.iapData.toFormattedJSONString(), this.adsData.toFormattedJSONString(this.activityData.daysActive)});
    }

    /* access modifiers changed from: package-private */
    public void setActivityData(String str, int i, int i2) {
        if (isStateAvailable()) {
            this.dataChanged = true;
            AdMostUserDataActivity.AdMostUserDataSession adMostUserDataSession = (AdMostUserDataActivity.AdMostUserDataSession) this.activityData.dailySessions.get(str);
            if (adMostUserDataSession == null) {
                AdMostUserDataActivity.access$112(this.activityData, 1);
                this.activityData.dailySessions.put(str, new AdMostUserDataActivity.AdMostUserDataSession(i, i2));
            } else {
                long unused = adMostUserDataSession.sessionLength = (long) i2;
                long unused2 = adMostUserDataSession.sessionCount = (long) i;
            }
            clearOldActivityData();
        }
    }

    /* access modifiers changed from: package-private */
    public void setAdsData(String str, double d, int i) {
        if (isStateAvailable() && str != null && !str.equals("")) {
            int i2 = 1;
            this.dataChanged = true;
            String format = AdMostAnalyticsManager.getInstance().dateFormat.format(Long.valueOf(AdMostAnalyticsManager.getInstance().getCurrentTimeFromServer()));
            AdMostUserDataAds.AdMostUserDataAdsDetail adMostUserDataAdsDetail = (AdMostUserDataAds.AdMostUserDataAdsDetail) this.adsData.adsDetailHashtable.get(str);
            if (adMostUserDataAdsDetail == null) {
                adMostUserDataAdsDetail = new AdMostUserDataAds.AdMostUserDataAdsDetail();
                this.adsData.adsDetailHashtable.put(str, adMostUserDataAdsDetail);
            }
            if (!format.equals(adMostUserDataAdsDetail.lastDate)) {
                String unused = adMostUserDataAdsDetail.lastDate = format;
                long unused2 = adMostUserDataAdsDetail.lastDayViewCount = 0;
            }
            AdMostUserDataAds.AdMostUserDataAdsDetail.access$1314(adMostUserDataAdsDetail, (long) (i == 2 ? 1 : 0));
            AdMostUserDataAds.AdMostUserDataAdsDetail.access$1414(adMostUserDataAdsDetail, (long) (i == 2 ? 1 : 0));
            AdMostUserDataAds.AdMostUserDataAdsDetail.access$1514(adMostUserDataAdsDetail, (long) (i == 4 ? 1 : 0));
            AdMostUserDataAds.AdMostUserDataAdsDetail.access$1614(adMostUserDataAdsDetail, (long) (i == 3 ? 1 : 0));
            AdMostUserDataAds.AdMostUserDataAdsDetail.access$1714(adMostUserDataAdsDetail, (long) (i == 5 ? 1 : 0));
            if (i != 1) {
                i2 = 0;
            }
            AdMostUserDataAds.AdMostUserDataAdsDetail.access$1814(adMostUserDataAdsDetail, (long) i2);
            if (i != 3) {
                d = 0.0d;
            }
            AdMostUserDataAds.AdMostUserDataAdsDetail.access$1918(adMostUserDataAdsDetail, d);
        }
    }

    /* access modifiers changed from: package-private */
    public void setIAPData(String str) {
        String str2 = "";
        if (isStateAvailable()) {
            this.dataChanged = true;
            long currentTimeFromServer = AdMostAnalyticsManager.getInstance().getCurrentTimeFromServer();
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("Currency");
                double d = jSONObject.getDouble("Amount");
                try {
                    JSONObject jSONObject2 = new JSONObject(jSONObject.getString("Receipt"));
                    String unused = this.iapData.lastTransactionIdentifier = jSONObject2.has("productId") ? jSONObject2.getString("productId") : str2;
                } catch (Exception e) {
                    e.printStackTrace();
                    try {
                        AdMostUserDataIAP adMostUserDataIAP = this.iapData;
                        if (jSONObject.has("Receipt")) {
                            str2 = jSONObject.getString("Receipt");
                        }
                        String unused2 = adMostUserDataIAP.lastTransactionIdentifier = str2;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                double unused3 = this.iapData.lastTransactionAmount = d;
                String unused4 = this.iapData.lastTransactionCurrency = string;
                long unused5 = this.iapData.lastTransactionDate = currentTimeFromServer;
                AdMostUserDataIAP.AdMostUserDataIAPDetail adMostUserDataIAPDetail = (AdMostUserDataIAP.AdMostUserDataIAPDetail) this.iapData.totalCurrencyTransactions.get(string);
                if (adMostUserDataIAPDetail == null) {
                    adMostUserDataIAPDetail = new AdMostUserDataIAP.AdMostUserDataIAPDetail(0, 0.0d);
                    this.iapData.totalCurrencyTransactions.put(string, adMostUserDataIAPDetail);
                }
                AdMostUserDataIAP.AdMostUserDataIAPDetail.access$912(adMostUserDataIAPDetail, 1);
                AdMostUserDataIAP.AdMostUserDataIAPDetail.access$1018(adMostUserDataIAPDetail, d);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public void storeData() {
        if (isStateAvailable() && this.dataChanged) {
            this.dataChanged = false;
            try {
                AdMostPreferences.getInstance().setUserDataForManager(new JSONObject(String.format(Locale.ENGLISH, "{\"activityData\":%s, \"iapData\":%s, \"adsData\":%s}", new Object[]{this.activityData.toJSONString(), this.iapData.toJSONString(), this.adsData.toJSONString()})).toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static class AdMostUserDataActivity {
        /* access modifiers changed from: private */
        public Hashtable<String, AdMostUserDataSession> dailySessions = new Hashtable<>();
        /* access modifiers changed from: private */
        public int daysActive;

        AdMostUserDataActivity(JSONObject jSONObject) {
            if (jSONObject != null) {
                try {
                    this.daysActive = jSONObject.optInt("daysActive", 0);
                    JSONObject jSONObject2 = jSONObject.getJSONObject("dailySessions");
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        this.dailySessions.put(next, new AdMostUserDataSession(jSONObject2.getJSONObject(next)));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        static /* synthetic */ int access$112(AdMostUserDataActivity adMostUserDataActivity, int i) {
            int i2 = adMostUserDataActivity.daysActive + i;
            adMostUserDataActivity.daysActive = i2;
            return i2;
        }

        /* access modifiers changed from: package-private */
        public String toFormattedJSONString() {
            Hashtable<String, AdMostUserDataSession> hashtable = this.dailySessions;
            if (hashtable == null || hashtable.size() <= 0) {
                Locale locale = Locale.ENGLISH;
                Object[] objArr = new Object[3];
                int i = this.daysActive;
                if (i == 0) {
                    i = 1;
                }
                objArr[0] = Integer.valueOf(i);
                objArr[1] = 0;
                objArr[2] = 0;
                return String.format(locale, "{\"DaysActive\": %d,\"DailyAverageSessionCount\": %d,\"DailyAverageSessionLength\": %d}", objArr);
            }
            long j = 0;
            long j2 = 0;
            for (String next : this.dailySessions.keySet()) {
                j += this.dailySessions.get(next).sessionLength;
                j2 += this.dailySessions.get(next).sessionCount;
            }
            Locale locale2 = Locale.ENGLISH;
            Object[] objArr2 = new Object[3];
            int i2 = this.daysActive;
            if (i2 == 0) {
                i2 = 1;
            }
            objArr2[0] = Integer.valueOf(i2);
            objArr2[1] = Long.valueOf(j2 / ((long) this.dailySessions.size()));
            objArr2[2] = Long.valueOf(j / ((long) this.dailySessions.size()));
            return String.format(locale2, "{\"DaysActive\": %d,\"DailyAverageSessionCount\": %d,\"DailyAverageSessionLength\": %d}", objArr2);
        }

        /* access modifiers changed from: package-private */
        public String toJSONString() {
            Hashtable<String, AdMostUserDataSession> hashtable = this.dailySessions;
            if (hashtable == null || hashtable.size() <= 0) {
                Locale locale = Locale.ENGLISH;
                Object[] objArr = new Object[2];
                int i = this.daysActive;
                if (i == 0) {
                    i = 1;
                }
                objArr[0] = Integer.valueOf(i);
                objArr[1] = "";
                return String.format(locale, "{\"daysActive\": %d,\"dailySessions\": {%s}}", objArr);
            }
            StringBuilder sb = new StringBuilder();
            for (String next : this.dailySessions.keySet()) {
                sb.append(String.format(Locale.ENGLISH, "\"%s\":%s,", new Object[]{next, this.dailySessions.get(next).toJSONString()}));
            }
            Locale locale2 = Locale.ENGLISH;
            Object[] objArr2 = new Object[2];
            int i2 = this.daysActive;
            if (i2 == 0) {
                i2 = 1;
            }
            objArr2[0] = Integer.valueOf(i2);
            objArr2[1] = sb.toString().substring(0, sb.length() - 1);
            return String.format(locale2, "{\"daysActive\": %d,\"dailySessions\": {%s}}", objArr2);
        }

        private static class AdMostUserDataSession {
            /* access modifiers changed from: private */
            public long sessionCount;
            /* access modifiers changed from: private */
            public long sessionLength;

            AdMostUserDataSession(JSONObject jSONObject) {
                if (jSONObject != null) {
                    try {
                        this.sessionCount = jSONObject.optLong("sessionCount", 0);
                        this.sessionLength = jSONObject.optLong("sessionLength", 0);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            /* access modifiers changed from: package-private */
            public String toJSONString() {
                return String.format(Locale.ENGLISH, "{\"sessionCount\":%d, \"sessionLength\":%d}", new Object[]{Long.valueOf(this.sessionCount), Long.valueOf(this.sessionLength)});
            }

            AdMostUserDataSession(int i, int i2) {
                this.sessionCount = (long) i;
                this.sessionLength = (long) i2;
            }
        }
    }

    private static class AdMostUserDataIAP {
        /* access modifiers changed from: private */
        public double lastTransactionAmount;
        /* access modifiers changed from: private */
        public String lastTransactionCurrency = "";
        /* access modifiers changed from: private */
        public long lastTransactionDate;
        /* access modifiers changed from: private */
        public String lastTransactionIdentifier = "";
        /* access modifiers changed from: private */
        public Hashtable<String, AdMostUserDataIAPDetail> totalCurrencyTransactions = new Hashtable<>();

        AdMostUserDataIAP(JSONObject jSONObject) {
            if (jSONObject != null) {
                try {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("LastTransaction");
                    this.lastTransactionDate = jSONObject2.optLong("date");
                    this.lastTransactionAmount = jSONObject2.optDouble("amount");
                    this.lastTransactionCurrency = jSONObject2.optString("currencyCode");
                    this.lastTransactionIdentifier = jSONObject2.optString("identifier");
                    JSONObject jSONObject3 = jSONObject.getJSONObject("TotalTransaction");
                    Iterator<String> keys = jSONObject3.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        this.totalCurrencyTransactions.put(next, new AdMostUserDataIAPDetail(jSONObject3.getJSONObject(next)));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public String toFormattedJSONString() {
            StringBuilder sb = new StringBuilder();
            Hashtable<String, AdMostUserDataIAPDetail> hashtable = this.totalCurrencyTransactions;
            if (hashtable != null && hashtable.size() > 0) {
                for (String next : this.totalCurrencyTransactions.keySet()) {
                    sb.append(String.format(Locale.ENGLISH, "{\"%s\" : %s},", new Object[]{next, this.totalCurrencyTransactions.get(next).toJSONString()}));
                }
            }
            String sb2 = sb.toString();
            Locale locale = Locale.ENGLISH;
            Object[] objArr = new Object[1];
            objArr[0] = sb2.length() > 0 ? sb2.substring(0, sb2.length() - 1) : "{}";
            return String.format("{%s,%s}", new Object[]{String.format(locale, "\"TotalTransaction\" : %s", objArr), this.lastTransactionDate > 0 ? String.format(Locale.ENGLISH, "\"LastTransaction\" : {\"amount\" : %f,\"currencyCode\" : \"%s\",\"identifier\" : %s,\"date\" : %d}", new Object[]{Double.valueOf(this.lastTransactionAmount), this.lastTransactionCurrency, JSONObject.quote(this.lastTransactionIdentifier), Long.valueOf(this.lastTransactionDate)}) : "\"LastTransaction\" : {}"});
        }

        /* access modifiers changed from: package-private */
        public String toJSONString() {
            return toFormattedJSONString();
        }

        private static class AdMostUserDataIAPDetail {
            private double amount;
            private int count;

            AdMostUserDataIAPDetail(JSONObject jSONObject) {
                if (jSONObject != null) {
                    try {
                        this.amount = jSONObject.optDouble("Amount", 0.0d);
                        this.count = jSONObject.optInt("Count", 0);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            static /* synthetic */ double access$1018(AdMostUserDataIAPDetail adMostUserDataIAPDetail, double d) {
                double d2 = adMostUserDataIAPDetail.amount + d;
                adMostUserDataIAPDetail.amount = d2;
                return d2;
            }

            static /* synthetic */ int access$912(AdMostUserDataIAPDetail adMostUserDataIAPDetail, int i) {
                int i2 = adMostUserDataIAPDetail.count + i;
                adMostUserDataIAPDetail.count = i2;
                return i2;
            }

            /* access modifiers changed from: package-private */
            public String toJSONString() {
                return String.format(Locale.ENGLISH, "{\"Amount\" : %f,\"Count\" : %d}", new Object[]{Double.valueOf(this.amount), Integer.valueOf(this.count)});
            }

            AdMostUserDataIAPDetail(int i, double d) {
                this.amount = d;
                this.count = i;
            }
        }
    }
}
