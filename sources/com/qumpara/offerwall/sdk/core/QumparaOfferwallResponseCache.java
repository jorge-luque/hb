package com.qumpara.offerwall.sdk.core;

import com.qumpara.offerwall.sdk.core.QumparaGenericRequest;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class QumparaOfferwallResponseCache {
    private static final Object cacheLock = new Object();
    private static final ConcurrentHashMap<String, QumparaOfferwallResponseCache> httpResponseCacheMap = new ConcurrentHashMap<>();
    private int duration;
    private long expireAt;
    private JSONObject jsonObject;
    private QumparaGenericRequest.RequestType requestType;
    private int status = 1;

    QumparaOfferwallResponseCache(JSONObject jSONObject, long j, QumparaGenericRequest.RequestType requestType2, int i) {
        this.jsonObject = jSONObject;
        try {
            this.expireAt = j;
            this.requestType = requestType2;
            this.duration = i;
            jSONObject.put("expireAt", j);
            this.jsonObject.put("requestType", requestType2.name());
            this.jsonObject.put("status", 1);
            this.jsonObject.put("cacheDuration", i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(12:1|2|3|4|(1:6)(2:7|(1:9)(1:10))|(1:12)|13|14|(2:16|17)|18|19|(2:21|22)(1:25)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|(1:6)(2:7|(1:9)(1:10))|(1:12)|13|14|(2:16|17)|18|19|(2:21|22)(1:25)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0033 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x003e */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0039 A[Catch:{ Exception -> 0x003e }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044 A[Catch:{ Exception -> 0x0049 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int getCacheDurationFromHeader(java.net.HttpURLConnection r5) {
        /*
            java.lang.String r0 = "Cache-Control"
            java.lang.String r0 = r5.getHeaderField(r0)     // Catch:{ Exception -> 0x0049 }
            java.lang.String r1 = "cache-control"
            java.lang.String r1 = r5.getHeaderField(r1)     // Catch:{ Exception -> 0x0049 }
            java.lang.String r2 = "Cache-Duration"
            java.lang.String r2 = r5.getHeaderField(r2)     // Catch:{ Exception -> 0x0049 }
            java.lang.String r3 = "cache-duration"
            java.lang.String r5 = r5.getHeaderField(r3)     // Catch:{ Exception -> 0x0049 }
            boolean r3 = isNullOrEmpty(r0)     // Catch:{ Exception -> 0x0033 }
            r4 = -1
            if (r3 != 0) goto L_0x0024
            int r0 = getDurationFromCacheControl(r0)     // Catch:{ Exception -> 0x0033 }
            goto L_0x0030
        L_0x0024:
            boolean r0 = isNullOrEmpty(r1)     // Catch:{ Exception -> 0x0033 }
            if (r0 != 0) goto L_0x002f
            int r0 = getDurationFromCacheControl(r1)     // Catch:{ Exception -> 0x0033 }
            goto L_0x0030
        L_0x002f:
            r0 = -1
        L_0x0030:
            if (r0 == r4) goto L_0x0033
            return r0
        L_0x0033:
            boolean r0 = isNullOrEmpty(r2)     // Catch:{ Exception -> 0x003e }
            if (r0 != 0) goto L_0x003e
            int r5 = java.lang.Integer.parseInt(r2)     // Catch:{ Exception -> 0x003e }
            return r5
        L_0x003e:
            boolean r0 = isNullOrEmpty(r5)     // Catch:{ Exception -> 0x0049 }
            if (r0 != 0) goto L_0x0049
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ Exception -> 0x0049 }
            return r5
        L_0x0049:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qumpara.offerwall.sdk.core.QumparaOfferwallResponseCache.getCacheDurationFromHeader(java.net.HttpURLConnection):int");
    }

    static String getCacheKey(QumparaGenericRequest.RequestType requestType2, String... strArr) {
        StringBuilder sb = new StringBuilder(requestType2.name());
        for (String append : strArr) {
            sb.append(append);
        }
        return sb.toString();
    }

    static int getDurationFromCacheControl(String str) {
        try {
            String[] split = str.split(",");
            int i = 0;
            while (i < split.length) {
                String trim = split[i].trim();
                if (!trim.equalsIgnoreCase("no-cache")) {
                    if (!trim.equalsIgnoreCase("no-store")) {
                        if (!trim.startsWith("max-age=")) {
                            if (!trim.startsWith("Max-Age=")) {
                                i++;
                            }
                        }
                        return Integer.parseInt(trim.substring(8));
                    }
                }
                return 0;
            }
            return -1;
        } catch (Exception unused) {
            return -1;
        }
    }

    static QumparaOfferwallResponseCache getFromCache(QumparaGenericRequest.RequestType requestType2, String... strArr) {
        QumparaOfferwallResponseCache qumparaOfferwallResponseCache;
        try {
            String cacheKey = getCacheKey(requestType2, strArr);
            synchronized (cacheLock) {
                if (httpResponseCacheMap.containsKey(cacheKey)) {
                    qumparaOfferwallResponseCache = httpResponseCacheMap.get(cacheKey);
                } else {
                    QumparaOfferwallResponseCache responseCacheFromPrefs = QumparaOfferwallPreferences.getInstance(QumparaOfferwall.getContext()).getResponseCacheFromPrefs(cacheKey);
                    if (responseCacheFromPrefs != null) {
                        httpResponseCacheMap.put(cacheKey, responseCacheFromPrefs);
                    }
                    qumparaOfferwallResponseCache = responseCacheFromPrefs;
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (qumparaOfferwallResponseCache == null) {
                return null;
            }
            if (qumparaOfferwallResponseCache.getExpireAt() < currentTimeMillis) {
                qumparaOfferwallResponseCache.setStatus(-1);
            } else if (qumparaOfferwallResponseCache.getExpireAt() - currentTimeMillis < 5000) {
                qumparaOfferwallResponseCache.setStatus(0);
            } else {
                qumparaOfferwallResponseCache.setStatus(1);
            }
            return qumparaOfferwallResponseCache;
        } catch (Exception unused) {
            return null;
        }
    }

    static boolean isNullOrEmpty(String str) {
        return str == null || str.equals("");
    }

    static boolean putToCache(String str, JSONObject jSONObject, QumparaGenericRequest.RequestType requestType2, int i, long j) {
        if (str.equals("") || jSONObject == null || jSONObject.length() <= 0) {
            return false;
        }
        QumparaOfferwallResponseCache qumparaOfferwallResponseCache = new QumparaOfferwallResponseCache(jSONObject, j, requestType2, i);
        synchronized (cacheLock) {
            httpResponseCacheMap.put(str, qumparaOfferwallResponseCache);
        }
        QumparaOfferwallPreferences.getInstance(QumparaOfferwall.getContext()).setResponseCache(str, qumparaOfferwallResponseCache);
        return true;
    }

    /* access modifiers changed from: package-private */
    public int getCacheDuration() {
        return this.duration;
    }

    /* access modifiers changed from: package-private */
    public long getExpireAt() {
        return this.expireAt;
    }

    public JSONObject getJsonObject() {
        return this.jsonObject;
    }

    /* access modifiers changed from: package-private */
    public QumparaGenericRequest.RequestType getRequestType() {
        return this.requestType;
    }

    /* access modifiers changed from: package-private */
    public int getStatus() {
        return this.status;
    }

    /* access modifiers changed from: package-private */
    public void setStatus(int i) {
        this.status = i;
    }

    QumparaOfferwallResponseCache(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.jsonObject = jSONObject;
            this.expireAt = jSONObject.optLong("expireAt", 0);
            this.status = this.jsonObject.optInt("status", 1);
            this.requestType = QumparaGenericRequest.RequestType.valueOf(this.jsonObject.optString("requestType"));
            this.duration = this.jsonObject.optInt("cacheDuration", 0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
