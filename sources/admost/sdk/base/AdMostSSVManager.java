package admost.sdk.base;

import admost.sdk.base.AdMostGenericRequest;
import admost.sdk.listener.AdmostResponseListener;
import admost.sdk.model.AdMostServerException;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class AdMostSSVManager {
    private static final String REWARDED_STATUS_COMPLETE_SENT = "complete_sent";
    private static final String REWARDED_STATUS_ERROR = "data_error";
    private static final String REWARDED_STATUS_SHOWN = "shown";
    private static final String REWARDED_STATUS_SHOW_SENT = "show_sent";
    private static AdMostSSVManager instance;
    private static final Object lock = new Object();
    private int completeRequestCount = 0;
    private final Object completeRequestLock = new Object();
    /* access modifiers changed from: private */
    public int showRequestCount = 0;
    private final Object showRequestLock = new Object();
    /* access modifiers changed from: private */
    public ConcurrentHashMap<String, String> ssvDataMap = new ConcurrentHashMap<>();

    interface RequestListener {
        void onComplete();
    }

    private AdMostSSVManager() {
        try {
            JSONObject jSONObject = new JSONObject(AdMostPreferences.getInstance().getSSVData());
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                this.ssvDataMap.put(next, ((JSONObject) jSONObject.get(next)).toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    static /* synthetic */ int access$110(AdMostSSVManager adMostSSVManager) {
        int i = adMostSSVManager.showRequestCount;
        adMostSSVManager.showRequestCount = i - 1;
        return i;
    }

    static /* synthetic */ int access$310(AdMostSSVManager adMostSSVManager) {
        int i = adMostSSVManager.completeRequestCount;
        adMostSSVManager.completeRequestCount = i - 1;
        return i;
    }

    public static AdMostSSVManager getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new AdMostSSVManager();
                }
            }
        }
        return instance;
    }

    /* access modifiers changed from: private */
    public void keepData(String str, String str2) {
        this.ssvDataMap.put(str, str2);
        AdMostPreferences.getInstance().setSSVData(str, str2);
    }

    /* access modifiers changed from: private */
    public void sendCompletedRequest() {
        ConcurrentHashMap<String, String> concurrentHashMap;
        if (this.completeRequestCount <= 0 && (concurrentHashMap = this.ssvDataMap) != null && concurrentHashMap.size() > 0) {
            synchronized (this.completeRequestLock) {
                String verifier = AdMost.getInstance().getConfiguration().getVerifier();
                try {
                    for (String str : this.ssvDataMap.keySet()) {
                        final JSONObject jSONObject = new JSONObject(this.ssvDataMap.get(str));
                        if (jSONObject.getString("status").equals(REWARDED_STATUS_SHOW_SENT) && jSONObject.has("completeTimestamp")) {
                            this.completeRequestCount++;
                            new AdMostGenericRequest(AdMostGenericRequest.RequestType.SSV_COMPLETE, "", new AdmostResponseListener<JSONObject>() {
                                public void onError(String str, Exception exc) {
                                    AdMostSSVManager.access$310(AdMostSSVManager.this);
                                    if (exc instanceof AdMostServerException) {
                                        int i = ((AdMostServerException) exc).ServerResponseCode;
                                        if (i == 400 || i == 406) {
                                            try {
                                                AdMostPreferences.getInstance().removeSSVData(jSONObject.getString("adUniqueId"));
                                                jSONObject.put("status", AdMostSSVManager.REWARDED_STATUS_ERROR);
                                                AdMostSSVManager.this.ssvDataMap.put(jSONObject.getString("adUniqueId"), jSONObject.toString());
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }
                                }

                                public void onResponse(JSONObject jSONObject) {
                                    try {
                                        jSONObject.put("status", AdMostSSVManager.REWARDED_STATUS_COMPLETE_SENT);
                                        AdMostSSVManager.this.ssvDataMap.put(jSONObject.getString("adUniqueId"), jSONObject.toString());
                                        AdMostPreferences.getInstance().removeSSVData(jSONObject.getString("adUniqueId"));
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    AdMostSSVManager.access$310(AdMostSSVManager.this);
                                }
                            }).mo611go("{\"data\" : \"" + AdMostUtil.encrypt(String.format(Locale.ENGLISH, "{\"adUniqueId\": \"%s\", \"completeTimestamp\": %d,\"sendTimestamp\": %d}", new Object[]{jSONObject.getString("adUniqueId"), Long.valueOf(jSONObject.getLong("completeTimestamp")), Long.valueOf(AdMostAnalyticsManager.getInstance().getCurrentTimeFromServer() / 1000)}), verifier.substring(0, 16), AdMostUtil.getAlphaNumericString16(), true) + "\"}");
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void sendShowRequest(final RequestListener requestListener) {
        ConcurrentHashMap<String, String> concurrentHashMap;
        if (this.showRequestCount <= 0 && (concurrentHashMap = this.ssvDataMap) != null && concurrentHashMap.size() > 0) {
            synchronized (this.showRequestLock) {
                String verifier = AdMost.getInstance().getConfiguration().getVerifier();
                try {
                    for (String str : this.ssvDataMap.keySet()) {
                        final JSONObject jSONObject = new JSONObject(this.ssvDataMap.get(str));
                        if (jSONObject.getString("status").equals(REWARDED_STATUS_SHOWN)) {
                            jSONObject.put("sendTimestamp", AdMostAnalyticsManager.getInstance().getCurrentTimeFromServer() / 1000);
                            JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
                            jSONObject2.remove("status");
                            jSONObject2.remove("completeTimestamp");
                            this.showRequestCount++;
                            new AdMostGenericRequest(AdMostGenericRequest.RequestType.SSV_SHOW, "", new AdmostResponseListener<JSONObject>() {
                                public void onError(String str, Exception exc) {
                                    RequestListener requestListener;
                                    AdMostSSVManager.access$110(AdMostSSVManager.this);
                                    if (AdMostSSVManager.this.showRequestCount == 0 && (requestListener = requestListener) != null) {
                                        requestListener.onComplete();
                                    }
                                    if (exc instanceof AdMostServerException) {
                                        int i = ((AdMostServerException) exc).ServerResponseCode;
                                        if (i == 400 || i == 406) {
                                            try {
                                                AdMostPreferences.getInstance().removeSSVData(jSONObject.getString("adUniqueId"));
                                                jSONObject.put("status", AdMostSSVManager.REWARDED_STATUS_ERROR);
                                                AdMostSSVManager.this.ssvDataMap.put(jSONObject.getString("adUniqueId"), jSONObject.toString());
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }
                                }

                                public void onResponse(JSONObject jSONObject) {
                                    RequestListener requestListener;
                                    try {
                                        jSONObject.put("status", AdMostSSVManager.REWARDED_STATUS_SHOW_SENT);
                                        AdMostSSVManager.this.keepData(jSONObject.getString("adUniqueId"), jSONObject.toString());
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    AdMostSSVManager.access$110(AdMostSSVManager.this);
                                    if (AdMostSSVManager.this.showRequestCount == 0 && (requestListener = requestListener) != null) {
                                        requestListener.onComplete();
                                    }
                                }
                            }).mo611go("{\"data\" : \"" + AdMostUtil.encrypt(jSONObject2.toString(), verifier.substring(0, 16), AdMostUtil.getAlphaNumericString16(), true) + "\"}");
                        } else if (!jSONObject.has("completeTimestamp") && jSONObject.optLong("showTimestamp", 0) + 86400 < AdMostAnalyticsManager.getInstance().getCurrentTimeFromServer() / 1000) {
                            AdMostPreferences.getInstance().removeSSVData(jSONObject.getString("adUniqueId"));
                        }
                    }
                    if (this.showRequestCount == 0 && requestListener != null) {
                        requestListener.onComplete();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else if (requestListener != null) {
            requestListener.onComplete();
        }
    }

    public void rewardedCompleted(String str) {
        String verifier = AdMost.getInstance().getConfiguration().getVerifier();
        if (str != null && str.length() > 0 && verifier != null && verifier.length() >= 16) {
            try {
                if (this.ssvDataMap.containsKey(str)) {
                    JSONObject jSONObject = new JSONObject(this.ssvDataMap.get(str));
                    jSONObject.put("completeTimestamp", AdMostAnalyticsManager.getInstance().getCurrentTimeFromServer() / 1000);
                    keepData(str, jSONObject.toString());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            sendCompletedRequest();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0083 A[Catch:{ Exception -> 0x0098 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0088 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String rewardedShown(admost.sdk.model.AdMostBannerResponseBase r9, admost.sdk.model.AdMostBannerResponseItem r10, java.util.Hashtable<java.lang.String, java.lang.Object> r11, java.lang.String r12) {
        /*
            r8 = this;
            admost.sdk.base.AdMost r0 = admost.sdk.base.AdMost.getInstance()
            admost.sdk.base.AdMostConfiguration r0 = r0.getConfiguration()
            java.lang.String r0 = r0.getVerifier()
            java.lang.String r1 = ""
            if (r9 == 0) goto L_0x0120
            boolean r9 = r9.SSVEnabled
            if (r9 == 0) goto L_0x0120
            if (r10 == 0) goto L_0x0120
            if (r0 == 0) goto L_0x0120
            int r9 = r0.length()
            r0 = 16
            if (r9 >= r0) goto L_0x0022
            goto L_0x0120
        L_0x0022:
            admost.sdk.base.AdMost r9 = admost.sdk.base.AdMost.getInstance()
            java.lang.String r9 = r9.getUserId()
            if (r9 == 0) goto L_0x011b
            boolean r0 = r9.equals(r1)
            if (r0 == 0) goto L_0x0034
            goto L_0x011b
        L_0x0034:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            if (r11 == 0) goto L_0x009c
            int r2 = r11.size()
            if (r2 <= 0) goto L_0x009c
            java.util.Set r11 = r11.entrySet()     // Catch:{ Exception -> 0x0098 }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ Exception -> 0x0098 }
        L_0x0049:
            boolean r2 = r11.hasNext()     // Catch:{ Exception -> 0x0098 }
            if (r2 == 0) goto L_0x009c
            java.lang.Object r2 = r11.next()     // Catch:{ Exception -> 0x0098 }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ Exception -> 0x0098 }
            java.lang.Object r3 = r2.getValue()     // Catch:{ Exception -> 0x0098 }
            if (r3 == 0) goto L_0x007c
            boolean r4 = r3 instanceof java.lang.String     // Catch:{ Exception -> 0x0098 }
            if (r4 == 0) goto L_0x0068
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0098 }
            java.lang.String r4 = "UTF8"
            java.lang.String r3 = java.net.URLEncoder.encode(r3, r4)     // Catch:{ Exception -> 0x0098 }
            goto L_0x007d
        L_0x0068:
            boolean r4 = r3 instanceof java.lang.Integer     // Catch:{ Exception -> 0x0098 }
            if (r4 == 0) goto L_0x007c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0098 }
            r4.<init>()     // Catch:{ Exception -> 0x0098 }
            r4.append(r3)     // Catch:{ Exception -> 0x0098 }
            r4.append(r1)     // Catch:{ Exception -> 0x0098 }
            java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x0098 }
            goto L_0x007d
        L_0x007c:
            r3 = r1
        L_0x007d:
            int r4 = r0.length()     // Catch:{ Exception -> 0x0098 }
            if (r4 <= 0) goto L_0x0088
            java.lang.String r4 = "&"
            r0.append(r4)     // Catch:{ Exception -> 0x0098 }
        L_0x0088:
            java.lang.Object r2 = r2.getKey()     // Catch:{ Exception -> 0x0098 }
            r0.append(r2)     // Catch:{ Exception -> 0x0098 }
            java.lang.String r2 = "="
            r0.append(r2)     // Catch:{ Exception -> 0x0098 }
            r0.append(r3)     // Catch:{ Exception -> 0x0098 }
            goto L_0x0049
        L_0x0098:
            r11 = move-exception
            r11.printStackTrace()
        L_0x009c:
            java.util.UUID r11 = java.util.UUID.randomUUID()
            java.lang.String r11 = r11.toString()
            java.util.Locale r1 = java.util.Locale.ENGLISH
            r2 = 11
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            admost.sdk.base.AdMostAnalyticsManager r4 = admost.sdk.base.AdMostAnalyticsManager.getInstance()
            long r4 = r4.getCurrentTimeFromServer()
            r6 = 1000(0x3e8, double:4.94E-321)
            long r4 = r4 / r6
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r2[r3] = r4
            r3 = 1
            admost.sdk.base.AdMostAnalyticsManager r4 = admost.sdk.base.AdMostAnalyticsManager.getInstance()
            long r4 = r4.getCurrentTimeFromServer()
            long r4 = r4 / r6
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r2[r3] = r4
            r3 = 2
            r2[r3] = r9
            r9 = 3
            admost.sdk.base.AdMostAnalyticsManager r3 = admost.sdk.base.AdMostAnalyticsManager.getInstance()
            java.lang.String r3 = r3.getUserId()
            r2[r9] = r3
            r9 = 4
            java.lang.String r3 = r10.Network
            r2[r9] = r3
            r9 = 5
            r2[r9] = r11
            r9 = 6
            admost.sdk.base.AdMost r3 = admost.sdk.base.AdMost.getInstance()
            java.lang.String r3 = r3.getAppId()
            r2[r9] = r3
            r9 = 7
            java.lang.String r10 = r10.ZoneId
            r2[r9] = r10
            r9 = 8
            java.lang.String r10 = r0.toString()
            r2[r9] = r10
            r9 = 9
            java.lang.String r10 = "shown"
            r2[r9] = r10
            r9 = 10
            r2[r9] = r12
            java.lang.String r9 = "{\"showTimestamp\": %d, \"sendTimestamp\": %d,\"appUserId\": \"%s\", \"adMostUserId\": \"%s\", \"network\": \"%s\", \"adUniqueId\": \"%s\", \"appId\": \"%s\", \"zoneId\": \"%s\", \"customData\": \"%s\", \"status\": \"%s\", \"ssvServer\": \"%s\"}"
            java.lang.String r9 = java.lang.String.format(r1, r9, r2)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r10 = r8.ssvDataMap
            r10.put(r11, r9)
            admost.sdk.base.AdMostPreferences r10 = admost.sdk.base.AdMostPreferences.getInstance()
            r10.setSSVData(r11, r9)
            r9 = 0
            r8.sendShowRequest(r9)
            return r11
        L_0x011b:
            java.lang.String r9 = "You have to set Application User Id first for Server Side Callbacks..! Use the following method first : AdMost.getInstance().setUserId(\"APPLICATION_USER_ID\");"
            admost.sdk.base.AdMostLog.m296e(r9)
        L_0x0120:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: admost.sdk.base.AdMostSSVManager.rewardedShown(admost.sdk.model.AdMostBannerResponseBase, admost.sdk.model.AdMostBannerResponseItem, java.util.Hashtable, java.lang.String):java.lang.String");
    }

    /* access modifiers changed from: package-private */
    public void sendAll() {
        ConcurrentHashMap<String, String> concurrentHashMap = this.ssvDataMap;
        if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
            sendShowRequest(new RequestListener() {
                public void onComplete() {
                    AdMostSSVManager.this.sendCompletedRequest();
                }
            });
        }
    }
}
