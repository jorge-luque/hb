package admost.sdk.base;

import admost.sdk.listener.AdmostResponseListener;
import admost.sdk.model.AdMostBiddingException;
import admost.sdk.model.AdMostServerException;
import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
import p118io.fabric.sdk.android.p200m.p202b.C6078a;

public class AdMostGenericRequest<T> extends AsyncTask<String, Integer, T> {
    private static final Object cacheLock = new Object();
    private static final ConcurrentHashMap<String, AdmostResponseCache> httpResponseCacheMap = new ConcurrentHashMap<>();
    private String host;
    private RequestType requestType;
    private AdmostResponseListener<T> responseListener;
    private int timeOut;
    private String zoneId;

    /* renamed from: admost.sdk.base.AdMostGenericRequest$2 */
    static /* synthetic */ class C02052 {
        static final /* synthetic */ int[] $SwitchMap$admost$sdk$base$AdMostGenericRequest$RequestType;

        /* JADX WARNING: Can't wrap try/catch for region: R(42:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|42) */
        /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00d8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00e4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                admost.sdk.base.AdMostGenericRequest$RequestType[] r0 = admost.sdk.base.AdMostGenericRequest.RequestType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$admost$sdk$base$AdMostGenericRequest$RequestType = r0
                admost.sdk.base.AdMostGenericRequest$RequestType r1 = admost.sdk.base.AdMostGenericRequest.RequestType.COUNTRY_RESPONSE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$admost$sdk$base$AdMostGenericRequest$RequestType     // Catch:{ NoSuchFieldError -> 0x001d }
                admost.sdk.base.AdMostGenericRequest$RequestType r1 = admost.sdk.base.AdMostGenericRequest.RequestType.ZONE_RESPONSE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$admost$sdk$base$AdMostGenericRequest$RequestType     // Catch:{ NoSuchFieldError -> 0x0028 }
                admost.sdk.base.AdMostGenericRequest$RequestType r1 = admost.sdk.base.AdMostGenericRequest.RequestType.SEND_IMPRESSION     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$admost$sdk$base$AdMostGenericRequest$RequestType     // Catch:{ NoSuchFieldError -> 0x0033 }
                admost.sdk.base.AdMostGenericRequest$RequestType r1 = admost.sdk.base.AdMostGenericRequest.RequestType.SEND_UNKNOWN_HOST_IMPRESSION     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$admost$sdk$base$AdMostGenericRequest$RequestType     // Catch:{ NoSuchFieldError -> 0x003e }
                admost.sdk.base.AdMostGenericRequest$RequestType r1 = admost.sdk.base.AdMostGenericRequest.RequestType.REGISTER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$admost$sdk$base$AdMostGenericRequest$RequestType     // Catch:{ NoSuchFieldError -> 0x0049 }
                admost.sdk.base.AdMostGenericRequest$RequestType r1 = admost.sdk.base.AdMostGenericRequest.RequestType.HOST_UPDATE_USER     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$admost$sdk$base$AdMostGenericRequest$RequestType     // Catch:{ NoSuchFieldError -> 0x0054 }
                admost.sdk.base.AdMostGenericRequest$RequestType r1 = admost.sdk.base.AdMostGenericRequest.RequestType.IAP_TRACK     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$admost$sdk$base$AdMostGenericRequest$RequestType     // Catch:{ NoSuchFieldError -> 0x0060 }
                admost.sdk.base.AdMostGenericRequest$RequestType r1 = admost.sdk.base.AdMostGenericRequest.RequestType.IAP_SEND     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$admost$sdk$base$AdMostGenericRequest$RequestType     // Catch:{ NoSuchFieldError -> 0x006c }
                admost.sdk.base.AdMostGenericRequest$RequestType r1 = admost.sdk.base.AdMostGenericRequest.RequestType.CAMPAIGN_TRACK     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$admost$sdk$base$AdMostGenericRequest$RequestType     // Catch:{ NoSuchFieldError -> 0x0078 }
                admost.sdk.base.AdMostGenericRequest$RequestType r1 = admost.sdk.base.AdMostGenericRequest.RequestType.INIT_RESPONSE     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$admost$sdk$base$AdMostGenericRequest$RequestType     // Catch:{ NoSuchFieldError -> 0x0084 }
                admost.sdk.base.AdMostGenericRequest$RequestType r1 = admost.sdk.base.AdMostGenericRequest.RequestType.GET_ZONES     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$admost$sdk$base$AdMostGenericRequest$RequestType     // Catch:{ NoSuchFieldError -> 0x0090 }
                admost.sdk.base.AdMostGenericRequest$RequestType r1 = admost.sdk.base.AdMostGenericRequest.RequestType.SSV_SHOW     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$admost$sdk$base$AdMostGenericRequest$RequestType     // Catch:{ NoSuchFieldError -> 0x009c }
                admost.sdk.base.AdMostGenericRequest$RequestType r1 = admost.sdk.base.AdMostGenericRequest.RequestType.SSV_COMPLETE     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$admost$sdk$base$AdMostGenericRequest$RequestType     // Catch:{ NoSuchFieldError -> 0x00a8 }
                admost.sdk.base.AdMostGenericRequest$RequestType r1 = admost.sdk.base.AdMostGenericRequest.RequestType.TEST_USER_DATA     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = $SwitchMap$admost$sdk$base$AdMostGenericRequest$RequestType     // Catch:{ NoSuchFieldError -> 0x00b4 }
                admost.sdk.base.AdMostGenericRequest$RequestType r1 = admost.sdk.base.AdMostGenericRequest.RequestType.TIMING_STATS     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = $SwitchMap$admost$sdk$base$AdMostGenericRequest$RequestType     // Catch:{ NoSuchFieldError -> 0x00c0 }
                admost.sdk.base.AdMostGenericRequest$RequestType r1 = admost.sdk.base.AdMostGenericRequest.RequestType.BIDDING_DEBUG_DATA     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = $SwitchMap$admost$sdk$base$AdMostGenericRequest$RequestType     // Catch:{ NoSuchFieldError -> 0x00cc }
                admost.sdk.base.AdMostGenericRequest$RequestType r1 = admost.sdk.base.AdMostGenericRequest.RequestType.EXPERIMENT     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r0 = $SwitchMap$admost$sdk$base$AdMostGenericRequest$RequestType     // Catch:{ NoSuchFieldError -> 0x00d8 }
                admost.sdk.base.AdMostGenericRequest$RequestType r1 = admost.sdk.base.AdMostGenericRequest.RequestType.BIDDING_REQUEST     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                int[] r0 = $SwitchMap$admost$sdk$base$AdMostGenericRequest$RequestType     // Catch:{ NoSuchFieldError -> 0x00e4 }
                admost.sdk.base.AdMostGenericRequest$RequestType r1 = admost.sdk.base.AdMostGenericRequest.RequestType.BIDDING_WIN_LOSS_REQUEST     // Catch:{ NoSuchFieldError -> 0x00e4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e4 }
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e4 }
            L_0x00e4:
                int[] r0 = $SwitchMap$admost$sdk$base$AdMostGenericRequest$RequestType     // Catch:{ NoSuchFieldError -> 0x00f0 }
                admost.sdk.base.AdMostGenericRequest$RequestType r1 = admost.sdk.base.AdMostGenericRequest.RequestType.CP_RESPONSE     // Catch:{ NoSuchFieldError -> 0x00f0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f0 }
                r2 = 20
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f0 }
            L_0x00f0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: admost.sdk.base.AdMostGenericRequest.C02052.<clinit>():void");
        }
    }

    public enum RequestType {
        ZONE_RESPONSE,
        CP_RESPONSE,
        COUNTRY_RESPONSE,
        INIT_RESPONSE,
        GET_ZONES,
        SEND_UNKNOWN_HOST_IMPRESSION,
        SEND_IMPRESSION,
        REGISTER,
        HOST_UPDATE_USER,
        IAP_TRACK,
        IAP_SEND,
        CAMPAIGN_TRACK,
        SSV_SHOW,
        SSV_COMPLETE,
        TEST_USER_DATA,
        EXPERIMENT,
        BIDDING_REQUEST,
        BIDDING_WIN_LOSS_REQUEST,
        BIDDING_DEBUG_DATA,
        TIMING_STATS
    }

    public AdMostGenericRequest(RequestType requestType2, String str, AdmostResponseListener<T> admostResponseListener) {
        this.requestType = requestType2;
        this.timeOut = getTimeoutValue(requestType2);
        this.host = getHost(requestType2, str);
        this.responseListener = admostResponseListener;
        this.zoneId = str;
    }

    private int getCacheDuration(HttpURLConnection httpURLConnection) {
        try {
            String headerField = httpURLConnection.getHeaderField("Cache-Control");
            if (headerField.equals("")) {
                return 0;
            }
            String[] split = headerField.split(",");
            int i = 0;
            while (true) {
                if (i >= split.length) {
                    break;
                }
                String trim = split[i].trim();
                if (!trim.equals("no-cache")) {
                    if (!trim.equals("no-store")) {
                        if (!trim.startsWith("max-age=")) {
                            if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                                break;
                            }
                            i++;
                        } else {
                            try {
                                return Integer.parseInt(trim.substring(8));
                            } catch (Exception unused) {
                                return 0;
                            }
                        }
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            return 0;
        } catch (Exception unused2) {
        }
    }

    public static AdmostResponseCache getFromCache(RequestType requestType2, String str) {
        AdmostResponseCache admostResponseCache;
        try {
            synchronized (cacheLock) {
                if (httpResponseCacheMap.containsKey(str)) {
                    admostResponseCache = httpResponseCacheMap.get(str);
                } else {
                    if (AdMostPreferences.getInstance() == null) {
                        AdMostPreferences.newInstance(AdMost.getInstance().getContext().getApplicationContext());
                    }
                    AdmostResponseCache responseCacheFromPrefs = AdMostPreferences.getInstance().getResponseCacheFromPrefs(str);
                    if (responseCacheFromPrefs != null) {
                        httpResponseCacheMap.put(str, responseCacheFromPrefs);
                    }
                    admostResponseCache = responseCacheFromPrefs;
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (admostResponseCache == null) {
                return null;
            }
            if (admostResponseCache.getExpireAt() < currentTimeMillis) {
                admostResponseCache.setStatus(-1);
                return admostResponseCache;
            }
            admostResponseCache.setStatus(1);
            if (C02052.$SwitchMap$admost$sdk$base$AdMostGenericRequest$RequestType[requestType2.ordinal()] == 2 && admostResponseCache.getExpireAt() - currentTimeMillis < 60000) {
                admostResponseCache.setStatus(0);
            }
            return admostResponseCache;
        } catch (Exception unused) {
            return null;
        }
    }

    private String getHost(RequestType requestType2, String str) {
        switch (C02052.$SwitchMap$admost$sdk$base$AdMostGenericRequest$RequestType[requestType2.ordinal()]) {
            case 1:
                return getSecureURLScheme("med-api.admost.com/v4/country", false);
            case 2:
                return getSecureURLScheme(String.format("cdn-api.admost.com/v4.5/zone/%s/country/%s/version/%s?pkg=%s&exp=%s&group=%s", new Object[]{str, AdMostPreferences.getInstance().getCountry(), AdMost.getInstance().getVersion(), AdMost.getInstance().getContext().getPackageName(), AdMostExperimentManager.getInstance().getCurrentExperiment(), AdMostExperimentManager.getInstance().getCurrentGroup()}), false);
            case 3:
                return getSecureURLScheme(String.format("med-api.admost.com/v4.5/count/%s/version/1.5", new Object[]{AdMost.getInstance().getAppId()}), true);
            case 4:
                return "http://" + String.format("195.244.38.37/v4.5/count/%s/version/1.5", new Object[]{AdMost.getInstance().getAppId()});
            case 5:
                return getSecureURLScheme(String.format("med-api.admost.com/v4.4/register/%s?pkg=%s", new Object[]{AdMost.getInstance().getAppId(), AdMost.getInstance().getContext().getPackageName()}), true);
            case 6:
                return getSecureURLScheme(String.format("med-api.admost.com/v4.4/update/%s?pkg=%s", new Object[]{str, AdMost.getInstance().getContext().getPackageName()}), true);
            case 7:
                return getSecureURLScheme(String.format("med-api.admost.com/v4/track_iap/%s", new Object[]{AdMost.getInstance().getAppId()}), true);
            case 8:
                return getSecureURLScheme(String.format("med-api.admost.com/v4.5/send_iap/%s", new Object[]{AdMost.getInstance().getAppId()}), true);
            case 9:
                return getSecureURLScheme(String.format("med-api.admost.com/v4.4/campaign/track/%s?pkg=%s", new Object[]{AdMost.getInstance().getAppId(), AdMost.getInstance().getContext().getPackageName()}), true);
            case 10:
                return getSecureURLScheme(String.format("cdn-api.admost.com/v4.3/init/%s/version/%s?pkg=%s", new Object[]{AdMost.getInstance().getAppId(), AdMost.getInstance().getVersion(), AdMost.getInstance().getContext().getPackageName()}), false);
            case 11:
                return "http://" + String.format("med-api.admost.com/v4.1/zones/%s", new Object[]{AdMost.getInstance().getAppId()});
            case 12:
                return getSecureURLScheme(String.format("ssv.admost.com/v2/show/%s", new Object[]{AdMost.getInstance().getAppId()}), true);
            case 13:
                return getSecureURLScheme(String.format("ssv.admost.com/v2/complete/%s", new Object[]{AdMost.getInstance().getAppId()}), true);
            case 14:
                return "http://med-api.admost.com/v4.2/debug/user_data";
            case 15:
                return getSecureURLScheme("statistic.admost.com/v1/ad/timing", true);
            case 16:
                return getSecureURLScheme("med-api.admost.com/v4.5/debug/bid_data", true);
            case 17:
                return getSecureURLScheme(String.format("cdn-api.admost.com/v4.3/experiment/%s/group/%s/app/%s", new Object[]{AdMostExperimentManager.getInstance().getCurrentExperiment(), AdMostExperimentManager.getInstance().getCurrentGroup(), AdMost.getInstance().getAppId()}), false);
            case 18:
            case 19:
                return str;
            default:
                return "";
        }
    }

    private String getSecureURLScheme(String str, boolean z) {
        try {
            if (AdMost.getInstance().getConfiguration() != null) {
                if (AdMost.getInstance().getConfiguration().useHttps()) {
                    if (z) {
                        if (AdMost.getInstance().getConfiguration().medApiHttps()) {
                        }
                    }
                }
                return "http://" + str;
            }
            return "https://" + str;
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    private int getTimeoutValue(RequestType requestType2) {
        int i = C02052.$SwitchMap$admost$sdk$base$AdMostGenericRequest$RequestType[requestType2.ordinal()];
        if (i == 1 || i == 2 || i == 20) {
            return 5000;
        }
        return C6078a.DEFAULT_TIMEOUT;
    }

    private void onError(String str, Exception exc) {
        AdmostResponseListener<T> admostResponseListener = this.responseListener;
        if (admostResponseListener != null) {
            admostResponseListener.onError(str, exc);
            if (!(exc instanceof AdMostServerException) && !(exc instanceof AdMostBiddingException)) {
                AdMostLog.m298e(this.host + " " + str, exc, true);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0143, code lost:
        if (r4 != null) goto L_0x0145;
     */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x014d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.json.JSONObject processAnalyticsRequest(java.lang.String... r9) {
        /*
            r8 = this;
            java.lang.String r0 = " : "
            java.lang.String r1 = "UTF-8"
            r2 = 0
            r9 = r9[r2]
            r3 = 0
            java.net.URL r4 = new java.net.URL     // Catch:{ Exception -> 0x013b, all -> 0x0139 }
            java.lang.String r5 = r8.host     // Catch:{ Exception -> 0x013b, all -> 0x0139 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x013b, all -> 0x0139 }
            java.net.URLConnection r4 = r4.openConnection()     // Catch:{ Exception -> 0x013b, all -> 0x0139 }
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ Exception -> 0x013b, all -> 0x0139 }
            int r5 = r8.timeOut     // Catch:{ Exception -> 0x0137 }
            r4.setConnectTimeout(r5)     // Catch:{ Exception -> 0x0137 }
            int r5 = r8.timeOut     // Catch:{ Exception -> 0x0137 }
            r4.setReadTimeout(r5)     // Catch:{ Exception -> 0x0137 }
            java.lang.String r5 = "POST"
            r4.setRequestMethod(r5)     // Catch:{ Exception -> 0x0137 }
            java.lang.String r5 = "Content-Type"
            java.lang.String r6 = "application/x-www-form-urlencoded"
            r4.setRequestProperty(r5, r6)     // Catch:{ Exception -> 0x0137 }
            java.lang.String r5 = "Accept-Charset"
            r4.setRequestProperty(r5, r1)     // Catch:{ Exception -> 0x0137 }
            java.lang.String r5 = "Content-Length"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0137 }
            r6.<init>()     // Catch:{ Exception -> 0x0137 }
            java.lang.String r7 = ""
            r6.append(r7)     // Catch:{ Exception -> 0x0137 }
            byte[] r7 = r9.getBytes()     // Catch:{ Exception -> 0x0137 }
            int r7 = r7.length     // Catch:{ Exception -> 0x0137 }
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ Exception -> 0x0137 }
            r6.append(r7)     // Catch:{ Exception -> 0x0137 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0137 }
            r4.setRequestProperty(r5, r6)     // Catch:{ Exception -> 0x0137 }
            java.lang.String r5 = "Accept-Language"
            java.util.Locale r6 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x0061 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0061 }
            java.lang.String r6 = r6.toLowerCase()     // Catch:{ Exception -> 0x0061 }
            r4.setRequestProperty(r5, r6)     // Catch:{ Exception -> 0x0061 }
            goto L_0x0065
        L_0x0061:
            r5 = move-exception
            r5.printStackTrace()     // Catch:{ Exception -> 0x0137 }
        L_0x0065:
            r4.setUseCaches(r2)     // Catch:{ Exception -> 0x0137 }
            r2 = 1
            r4.setDoInput(r2)     // Catch:{ Exception -> 0x0137 }
            r4.setDoOutput(r2)     // Catch:{ Exception -> 0x0137 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0137 }
            r2.<init>()     // Catch:{ Exception -> 0x0137 }
            admost.sdk.base.AdMostGenericRequest$RequestType r5 = r8.requestType     // Catch:{ Exception -> 0x0137 }
            java.lang.String r5 = r5.name()     // Catch:{ Exception -> 0x0137 }
            r2.append(r5)     // Catch:{ Exception -> 0x0137 }
            r2.append(r0)     // Catch:{ Exception -> 0x0137 }
            r2.append(r9)     // Catch:{ Exception -> 0x0137 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0137 }
            admost.sdk.base.AdMostLog.m294d(r2)     // Catch:{ Exception -> 0x0137 }
            java.io.DataOutputStream r2 = new java.io.DataOutputStream     // Catch:{ Exception -> 0x0137 }
            java.io.OutputStream r5 = r4.getOutputStream()     // Catch:{ Exception -> 0x0137 }
            r2.<init>(r5)     // Catch:{ Exception -> 0x0137 }
            byte[] r5 = r9.getBytes(r1)     // Catch:{ Exception -> 0x0137 }
            r2.write(r5)     // Catch:{ Exception -> 0x0137 }
            r2.flush()     // Catch:{ Exception -> 0x0137 }
            r2.close()     // Catch:{ Exception -> 0x0137 }
            int r2 = r4.getResponseCode()     // Catch:{ Exception -> 0x0137 }
            r5 = 200(0xc8, float:2.8E-43)
            if (r2 == r5) goto L_0x00e5
            int r0 = r4.getResponseCode()     // Catch:{ Exception -> 0x0137 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0137 }
            r2.<init>()     // Catch:{ Exception -> 0x0137 }
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x00ce }
            java.io.InputStream r6 = r4.getErrorStream()     // Catch:{ Exception -> 0x00ce }
            r5.<init>(r6)     // Catch:{ Exception -> 0x00ce }
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00ce }
            java.io.InputStreamReader r7 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00ce }
            r7.<init>(r5, r1)     // Catch:{ Exception -> 0x00ce }
            r6.<init>(r7)     // Catch:{ Exception -> 0x00ce }
        L_0x00c4:
            java.lang.String r1 = r6.readLine()     // Catch:{ Exception -> 0x00ce }
            if (r1 == 0) goto L_0x00d2
            r2.append(r1)     // Catch:{ Exception -> 0x00ce }
            goto L_0x00c4
        L_0x00ce:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ Exception -> 0x0137 }
        L_0x00d2:
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x0137 }
            admost.sdk.model.AdMostServerException r5 = new admost.sdk.model.AdMostServerException     // Catch:{ Exception -> 0x0137 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0137 }
            r5.<init>(r0, r2)     // Catch:{ Exception -> 0x0137 }
            r8.onError(r1, r5)     // Catch:{ Exception -> 0x0137 }
            if (r4 == 0) goto L_0x0148
            goto L_0x0145
        L_0x00e5:
            java.io.InputStream r1 = r4.getInputStream()     // Catch:{ Exception -> 0x0137 }
            java.lang.String r1 = r8.read(r1)     // Catch:{ Exception -> 0x0137 }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x0137 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0137 }
            boolean r5 = admost.sdk.base.AdMostLog.isIsHTTPLoggingEnabled()     // Catch:{ Exception -> 0x0137 }
            if (r5 == 0) goto L_0x0116
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0137 }
            r1.<init>()     // Catch:{ Exception -> 0x0137 }
            admost.sdk.base.AdMostGenericRequest$RequestType r5 = r8.requestType     // Catch:{ Exception -> 0x0137 }
            java.lang.String r5 = r5.name()     // Catch:{ Exception -> 0x0137 }
            r1.append(r5)     // Catch:{ Exception -> 0x0137 }
            r1.append(r0)     // Catch:{ Exception -> 0x0137 }
            java.lang.String r0 = r8.host     // Catch:{ Exception -> 0x0137 }
            r1.append(r0)     // Catch:{ Exception -> 0x0137 }
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x0137 }
            admost.sdk.base.AdMostLog.json((org.json.JSONObject) r2, (java.lang.String) r0)     // Catch:{ Exception -> 0x0137 }
            goto L_0x0131
        L_0x0116:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0137 }
            r5.<init>()     // Catch:{ Exception -> 0x0137 }
            admost.sdk.base.AdMostGenericRequest$RequestType r6 = r8.requestType     // Catch:{ Exception -> 0x0137 }
            java.lang.String r6 = r6.name()     // Catch:{ Exception -> 0x0137 }
            r5.append(r6)     // Catch:{ Exception -> 0x0137 }
            r5.append(r0)     // Catch:{ Exception -> 0x0137 }
            r5.append(r1)     // Catch:{ Exception -> 0x0137 }
            java.lang.String r0 = r5.toString()     // Catch:{ Exception -> 0x0137 }
            admost.sdk.base.AdMostLog.m294d(r0)     // Catch:{ Exception -> 0x0137 }
        L_0x0131:
            if (r4 == 0) goto L_0x0136
            r4.disconnect()
        L_0x0136:
            return r2
        L_0x0137:
            r0 = move-exception
            goto L_0x013d
        L_0x0139:
            r9 = move-exception
            goto L_0x014b
        L_0x013b:
            r0 = move-exception
            r4 = r3
        L_0x013d:
            r0.printStackTrace()     // Catch:{ all -> 0x0149 }
            r8.onError(r9, r0)     // Catch:{ all -> 0x0149 }
            if (r4 == 0) goto L_0x0148
        L_0x0145:
            r4.disconnect()
        L_0x0148:
            return r3
        L_0x0149:
            r9 = move-exception
            r3 = r4
        L_0x014b:
            if (r3 == 0) goto L_0x0150
            r3.disconnect()
        L_0x0150:
            goto L_0x0152
        L_0x0151:
            throw r9
        L_0x0152:
            goto L_0x0151
        */
        throw new UnsupportedOperationException("Method not decompiled: admost.sdk.base.AdMostGenericRequest.processAnalyticsRequest(java.lang.String[]):org.json.JSONObject");
    }

    /* JADX WARNING: type inference failed for: r0v6, types: [java.net.URLConnection] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01a0  */
    /* JADX WARNING: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.json.JSONObject processBiddingRequest(java.lang.String... r17) {
        /*
            r16 = this;
            r1 = r16
            java.lang.String r2 = "x-fb-an-request-id"
            java.lang.String r3 = "x-fb-debug"
            java.lang.String r4 = "x-adc-requestid"
            java.lang.String r5 = "x-fb-an-errors"
            java.lang.String r6 = "FACEBOOK"
            java.lang.String r7 = " : "
            java.lang.String r8 = "UTF-8"
            r9 = 0
            r10 = r17[r9]
            r11 = 1
            r12 = r17[r11]
            java.net.URL r0 = new java.net.URL     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            java.lang.String r14 = r1.host     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            r0.<init>(r14)     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            java.net.URLConnection r0 = r0.openConnection()     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            r14 = r0
            java.net.HttpURLConnection r14 = (java.net.HttpURLConnection) r14     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            int r0 = r1.timeOut     // Catch:{ Exception -> 0x0188 }
            r14.setConnectTimeout(r0)     // Catch:{ Exception -> 0x0188 }
            int r0 = r1.timeOut     // Catch:{ Exception -> 0x0188 }
            r14.setReadTimeout(r0)     // Catch:{ Exception -> 0x0188 }
            java.lang.String r0 = "POST"
            r14.setRequestMethod(r0)     // Catch:{ Exception -> 0x0188 }
            java.lang.String r0 = "Content-Type"
            java.lang.String r15 = "application/json; charset=utf-8"
            r14.setRequestProperty(r0, r15)     // Catch:{ Exception -> 0x0188 }
            java.lang.String r0 = "Accept-Charset"
            r14.setRequestProperty(r0, r8)     // Catch:{ Exception -> 0x0188 }
            boolean r0 = r6.equals(r10)     // Catch:{ Exception -> 0x0188 }
            if (r0 == 0) goto L_0x004d
            r0 = 2
            r0 = r17[r0]     // Catch:{ Exception -> 0x0188 }
            java.lang.String r15 = "X-FB-Pool-Routing-Token"
            r14.setRequestProperty(r15, r0)     // Catch:{ Exception -> 0x0188 }
        L_0x004d:
            java.lang.String r0 = "Content-Length"
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0188 }
            r15.<init>()     // Catch:{ Exception -> 0x0188 }
            java.lang.String r13 = ""
            r15.append(r13)     // Catch:{ Exception -> 0x0188 }
            byte[] r13 = r12.getBytes()     // Catch:{ Exception -> 0x0188 }
            int r13 = r13.length     // Catch:{ Exception -> 0x0188 }
            java.lang.String r13 = java.lang.Integer.toString(r13)     // Catch:{ Exception -> 0x0188 }
            r15.append(r13)     // Catch:{ Exception -> 0x0188 }
            java.lang.String r13 = r15.toString()     // Catch:{ Exception -> 0x0188 }
            r14.setRequestProperty(r0, r13)     // Catch:{ Exception -> 0x0188 }
            java.lang.String r0 = "Accept-Language"
            java.util.Locale r13 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x007e }
            java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x007e }
            java.lang.String r13 = r13.toLowerCase()     // Catch:{ Exception -> 0x007e }
            r14.setRequestProperty(r0, r13)     // Catch:{ Exception -> 0x007e }
            goto L_0x0082
        L_0x007e:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Exception -> 0x0188 }
        L_0x0082:
            r14.setUseCaches(r9)     // Catch:{ Exception -> 0x0188 }
            r14.setDoInput(r11)     // Catch:{ Exception -> 0x0188 }
            r14.setDoOutput(r11)     // Catch:{ Exception -> 0x0188 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0188 }
            r0.<init>()     // Catch:{ Exception -> 0x0188 }
            admost.sdk.base.AdMostGenericRequest$RequestType r9 = r1.requestType     // Catch:{ Exception -> 0x0188 }
            java.lang.String r9 = r9.name()     // Catch:{ Exception -> 0x0188 }
            r0.append(r9)     // Catch:{ Exception -> 0x0188 }
            r0.append(r7)     // Catch:{ Exception -> 0x0188 }
            r0.append(r12)     // Catch:{ Exception -> 0x0188 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0188 }
            admost.sdk.base.AdMostLog.m294d(r0)     // Catch:{ Exception -> 0x0188 }
            java.io.DataOutputStream r0 = new java.io.DataOutputStream     // Catch:{ Exception -> 0x0188 }
            java.io.OutputStream r9 = r14.getOutputStream()     // Catch:{ Exception -> 0x0188 }
            r0.<init>(r9)     // Catch:{ Exception -> 0x0188 }
            byte[] r9 = r12.getBytes(r8)     // Catch:{ Exception -> 0x0188 }
            r0.write(r9)     // Catch:{ Exception -> 0x0188 }
            r0.flush()     // Catch:{ Exception -> 0x0188 }
            r0.close()     // Catch:{ Exception -> 0x0188 }
            int r0 = r14.getResponseCode()     // Catch:{ Exception -> 0x0188 }
            r9 = 200(0xc8, float:2.8E-43)
            if (r0 == r9) goto L_0x0136
            int r7 = r14.getResponseCode()     // Catch:{ Exception -> 0x0188 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0188 }
            r9.<init>()     // Catch:{ Exception -> 0x0188 }
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x00ea }
            java.io.InputStream r11 = r14.getErrorStream()     // Catch:{ Exception -> 0x00ea }
            r0.<init>(r11)     // Catch:{ Exception -> 0x00ea }
            java.io.BufferedReader r11 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00ea }
            java.io.InputStreamReader r13 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00ea }
            r13.<init>(r0, r8)     // Catch:{ Exception -> 0x00ea }
            r11.<init>(r13)     // Catch:{ Exception -> 0x00ea }
        L_0x00e0:
            java.lang.String r0 = r11.readLine()     // Catch:{ Exception -> 0x00ea }
            if (r0 == 0) goto L_0x00ee
            r9.append(r0)     // Catch:{ Exception -> 0x00ea }
            goto L_0x00e0
        L_0x00ea:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Exception -> 0x0188 }
        L_0x00ee:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0188 }
            r0.<init>()     // Catch:{ Exception -> 0x0188 }
            java.lang.String r8 = "err-data"
            java.lang.String r11 = r9.toString()     // Catch:{ Exception -> 0x0188 }
            r0.put(r8, r11)     // Catch:{ Exception -> 0x0188 }
            boolean r6 = r6.equals(r10)     // Catch:{ Exception -> 0x0188 }
            if (r6 == 0) goto L_0x0118
            java.lang.String r4 = r14.getHeaderField(r5)     // Catch:{ Exception -> 0x0188 }
            r0.put(r5, r4)     // Catch:{ Exception -> 0x0188 }
            java.lang.String r4 = r14.getHeaderField(r3)     // Catch:{ Exception -> 0x0188 }
            r0.put(r3, r4)     // Catch:{ Exception -> 0x0188 }
            java.lang.String r3 = r14.getHeaderField(r2)     // Catch:{ Exception -> 0x0188 }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x0188 }
            goto L_0x0127
        L_0x0118:
            java.lang.String r2 = "ADCOLONY"
            boolean r2 = r2.equals(r10)     // Catch:{ Exception -> 0x0188 }
            if (r2 == 0) goto L_0x0127
            java.lang.String r2 = r14.getHeaderField(r4)     // Catch:{ Exception -> 0x0188 }
            r0.put(r4, r2)     // Catch:{ Exception -> 0x0188 }
        L_0x0127:
            java.lang.String r2 = r9.toString()     // Catch:{ Exception -> 0x0188 }
            admost.sdk.model.AdMostBiddingException r3 = new admost.sdk.model.AdMostBiddingException     // Catch:{ Exception -> 0x0188 }
            r3.<init>(r7, r0)     // Catch:{ Exception -> 0x0188 }
            r1.onError(r2, r3)     // Catch:{ Exception -> 0x0188 }
            if (r14 == 0) goto L_0x019a
            goto L_0x0197
        L_0x0136:
            java.io.InputStream r0 = r14.getInputStream()     // Catch:{ Exception -> 0x0188 }
            java.lang.String r0 = r1.read(r0)     // Catch:{ Exception -> 0x0188 }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x0188 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0188 }
            boolean r3 = admost.sdk.base.AdMostLog.isIsHTTPLoggingEnabled()     // Catch:{ Exception -> 0x0188 }
            if (r3 == 0) goto L_0x0167
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0188 }
            r0.<init>()     // Catch:{ Exception -> 0x0188 }
            admost.sdk.base.AdMostGenericRequest$RequestType r3 = r1.requestType     // Catch:{ Exception -> 0x0188 }
            java.lang.String r3 = r3.name()     // Catch:{ Exception -> 0x0188 }
            r0.append(r3)     // Catch:{ Exception -> 0x0188 }
            r0.append(r7)     // Catch:{ Exception -> 0x0188 }
            java.lang.String r3 = r1.host     // Catch:{ Exception -> 0x0188 }
            r0.append(r3)     // Catch:{ Exception -> 0x0188 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0188 }
            admost.sdk.base.AdMostLog.json((org.json.JSONObject) r2, (java.lang.String) r0)     // Catch:{ Exception -> 0x0188 }
            goto L_0x0182
        L_0x0167:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0188 }
            r3.<init>()     // Catch:{ Exception -> 0x0188 }
            admost.sdk.base.AdMostGenericRequest$RequestType r4 = r1.requestType     // Catch:{ Exception -> 0x0188 }
            java.lang.String r4 = r4.name()     // Catch:{ Exception -> 0x0188 }
            r3.append(r4)     // Catch:{ Exception -> 0x0188 }
            r3.append(r7)     // Catch:{ Exception -> 0x0188 }
            r3.append(r0)     // Catch:{ Exception -> 0x0188 }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x0188 }
            admost.sdk.base.AdMostLog.m294d(r0)     // Catch:{ Exception -> 0x0188 }
        L_0x0182:
            if (r14 == 0) goto L_0x0187
            r14.disconnect()
        L_0x0187:
            return r2
        L_0x0188:
            r0 = move-exception
            goto L_0x018f
        L_0x018a:
            r0 = move-exception
            r13 = 0
            goto L_0x019e
        L_0x018d:
            r0 = move-exception
            r14 = 0
        L_0x018f:
            r0.printStackTrace()     // Catch:{ all -> 0x019c }
            r1.onError(r12, r0)     // Catch:{ all -> 0x019c }
            if (r14 == 0) goto L_0x019a
        L_0x0197:
            r14.disconnect()
        L_0x019a:
            r2 = 0
            return r2
        L_0x019c:
            r0 = move-exception
            r13 = r14
        L_0x019e:
            if (r13 == 0) goto L_0x01a3
            r13.disconnect()
        L_0x01a3:
            goto L_0x01a5
        L_0x01a4:
            throw r0
        L_0x01a5:
            goto L_0x01a4
        */
        throw new UnsupportedOperationException("Method not decompiled: admost.sdk.base.AdMostGenericRequest.processBiddingRequest(java.lang.String[]):org.json.JSONObject");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00e4 A[Catch:{ Exception -> 0x0177 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ea A[Catch:{ Exception -> 0x0177 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0136 A[Catch:{ Exception -> 0x0177 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0156 A[Catch:{ Exception -> 0x0177 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0185  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x018d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.json.JSONObject processBiddingWinLossRequest(java.lang.String... r10) {
        /*
            r9 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = "UTF-8"
            r2 = 0
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x017b, all -> 0x0179 }
            java.net.URL r5 = new java.net.URL     // Catch:{ Exception -> 0x017b, all -> 0x0179 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x017b, all -> 0x0179 }
            r6.<init>()     // Catch:{ Exception -> 0x017b, all -> 0x0179 }
            java.lang.String r7 = r9.host     // Catch:{ Exception -> 0x017b, all -> 0x0179 }
            r6.append(r7)     // Catch:{ Exception -> 0x017b, all -> 0x0179 }
            r7 = 0
            r10 = r10[r7]     // Catch:{ Exception -> 0x017b, all -> 0x0179 }
            r6.append(r10)     // Catch:{ Exception -> 0x017b, all -> 0x0179 }
            java.lang.String r10 = r6.toString()     // Catch:{ Exception -> 0x017b, all -> 0x0179 }
            r5.<init>(r10)     // Catch:{ Exception -> 0x017b, all -> 0x0179 }
            java.net.URLConnection r10 = r5.openConnection()     // Catch:{ Exception -> 0x017b, all -> 0x0179 }
            java.net.HttpURLConnection r10 = (java.net.HttpURLConnection) r10     // Catch:{ Exception -> 0x017b, all -> 0x0179 }
            int r6 = r9.timeOut     // Catch:{ Exception -> 0x0177 }
            r10.setConnectTimeout(r6)     // Catch:{ Exception -> 0x0177 }
            int r6 = r9.timeOut     // Catch:{ Exception -> 0x0177 }
            r10.setReadTimeout(r6)     // Catch:{ Exception -> 0x0177 }
            java.lang.String r6 = "Accept-Charset"
            r10.setRequestProperty(r6, r1)     // Catch:{ Exception -> 0x0177 }
            java.lang.String r6 = "Content-Language"
            java.lang.String r7 = "tr-TR"
            r10.setRequestProperty(r6, r7)     // Catch:{ Exception -> 0x0177 }
            int r6 = r10.getResponseCode()     // Catch:{ Exception -> 0x0177 }
            r7 = 204(0xcc, float:2.86E-43)
            if (r6 != r7) goto L_0x0056
            java.lang.String r1 = "biddingWinLossRequest no content response : 204"
            admost.sdk.base.AdMostLog.m299i(r1)     // Catch:{ Exception -> 0x0177 }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x0177 }
            r1.<init>()     // Catch:{ Exception -> 0x0177 }
            if (r10 == 0) goto L_0x0055
            r10.disconnect()
        L_0x0055:
            return r1
        L_0x0056:
            r7 = 200(0xc8, float:2.8E-43)
            java.lang.String r8 = " : "
            if (r6 == r7) goto L_0x00f0
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0177 }
            r5.<init>()     // Catch:{ Exception -> 0x0177 }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0177 }
            long r6 = r6 - r3
            r5.append(r6)     // Catch:{ Exception -> 0x0177 }
            java.lang.String r3 = " ms Error:"
            r5.append(r3)     // Catch:{ Exception -> 0x0177 }
            int r3 = r10.getResponseCode()     // Catch:{ Exception -> 0x0177 }
            r5.append(r3)     // Catch:{ Exception -> 0x0177 }
            java.lang.String r3 = " "
            r5.append(r3)     // Catch:{ Exception -> 0x0177 }
            java.net.URL r3 = r10.getURL()     // Catch:{ Exception -> 0x0177 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0177 }
            r5.append(r3)     // Catch:{ Exception -> 0x0177 }
            java.lang.String r3 = r5.toString()     // Catch:{ Exception -> 0x0177 }
            admost.sdk.base.AdMostLog.m303w(r3)     // Catch:{ Exception -> 0x0177 }
            java.io.BufferedInputStream r4 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x00dd }
            java.io.InputStream r5 = r10.getErrorStream()     // Catch:{ Exception -> 0x00dd }
            r4.<init>(r5)     // Catch:{ Exception -> 0x00dd }
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00dd }
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00dd }
            r6.<init>(r4, r1)     // Catch:{ Exception -> 0x00dd }
            r5.<init>(r6)     // Catch:{ Exception -> 0x00dd }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00dd }
            r1.<init>()     // Catch:{ Exception -> 0x00dd }
        L_0x00a4:
            java.lang.String r4 = r5.readLine()     // Catch:{ Exception -> 0x00dd }
            if (r4 == 0) goto L_0x00ae
            r1.append(r4)     // Catch:{ Exception -> 0x00dd }
            goto L_0x00a4
        L_0x00ae:
            admost.sdk.model.AdMostServerException r4 = new admost.sdk.model.AdMostServerException     // Catch:{ Exception -> 0x00dd }
            int r5 = r10.getResponseCode()     // Catch:{ Exception -> 0x00dd }
            java.lang.String r6 = r1.toString()     // Catch:{ Exception -> 0x00dd }
            r4.<init>(r5, r6)     // Catch:{ Exception -> 0x00dd }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00db }
            r5.<init>()     // Catch:{ Exception -> 0x00db }
            admost.sdk.base.AdMostGenericRequest$RequestType r6 = r9.requestType     // Catch:{ Exception -> 0x00db }
            java.lang.String r6 = r6.name()     // Catch:{ Exception -> 0x00db }
            r5.append(r6)     // Catch:{ Exception -> 0x00db }
            r5.append(r8)     // Catch:{ Exception -> 0x00db }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x00db }
            r5.append(r1)     // Catch:{ Exception -> 0x00db }
            java.lang.String r1 = r5.toString()     // Catch:{ Exception -> 0x00db }
            admost.sdk.base.AdMostLog.m303w(r1)     // Catch:{ Exception -> 0x00db }
            goto L_0x00e2
        L_0x00db:
            r1 = move-exception
            goto L_0x00df
        L_0x00dd:
            r1 = move-exception
            r4 = r2
        L_0x00df:
            r1.printStackTrace()     // Catch:{ Exception -> 0x0177 }
        L_0x00e2:
            if (r4 == 0) goto L_0x00ea
            java.lang.Exception r1 = new java.lang.Exception     // Catch:{ Exception -> 0x0177 }
            r1.<init>(r3, r4)     // Catch:{ Exception -> 0x0177 }
            throw r1     // Catch:{ Exception -> 0x0177 }
        L_0x00ea:
            java.lang.Exception r1 = new java.lang.Exception     // Catch:{ Exception -> 0x0177 }
            r1.<init>(r3)     // Catch:{ Exception -> 0x0177 }
            throw r1     // Catch:{ Exception -> 0x0177 }
        L_0x00f0:
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0177 }
            java.io.InputStream r4 = r10.getInputStream()     // Catch:{ Exception -> 0x0177 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0177 }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0177 }
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0177 }
            r6.<init>(r3, r1)     // Catch:{ Exception -> 0x0177 }
            r4.<init>(r6)     // Catch:{ Exception -> 0x0177 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0177 }
            r1.<init>()     // Catch:{ Exception -> 0x0177 }
        L_0x0108:
            java.lang.String r6 = r4.readLine()     // Catch:{ Exception -> 0x0177 }
            if (r6 == 0) goto L_0x0112
            r1.append(r6)     // Catch:{ Exception -> 0x0177 }
            goto L_0x0108
        L_0x0112:
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0177 }
            r3.close()     // Catch:{ Exception -> 0x0177 }
            r9.getCacheDuration(r10)     // Catch:{ Exception -> 0x0177 }
            if (r1 == 0) goto L_0x012b
            boolean r3 = r1.equals(r0)     // Catch:{ Exception -> 0x0177 }
            if (r3 == 0) goto L_0x0125
            goto L_0x012b
        L_0x0125:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x0177 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x0177 }
            goto L_0x0130
        L_0x012b:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x0177 }
            r3.<init>()     // Catch:{ Exception -> 0x0177 }
        L_0x0130:
            boolean r4 = admost.sdk.base.AdMostLog.isIsHTTPLoggingEnabled()     // Catch:{ Exception -> 0x0177 }
            if (r4 == 0) goto L_0x0156
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0177 }
            r1.<init>()     // Catch:{ Exception -> 0x0177 }
            admost.sdk.base.AdMostGenericRequest$RequestType r4 = r9.requestType     // Catch:{ Exception -> 0x0177 }
            java.lang.String r4 = r4.name()     // Catch:{ Exception -> 0x0177 }
            r1.append(r4)     // Catch:{ Exception -> 0x0177 }
            r1.append(r8)     // Catch:{ Exception -> 0x0177 }
            java.lang.String r4 = r5.toString()     // Catch:{ Exception -> 0x0177 }
            r1.append(r4)     // Catch:{ Exception -> 0x0177 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0177 }
            admost.sdk.base.AdMostLog.json((org.json.JSONObject) r3, (java.lang.String) r1)     // Catch:{ Exception -> 0x0177 }
            goto L_0x0171
        L_0x0156:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0177 }
            r4.<init>()     // Catch:{ Exception -> 0x0177 }
            admost.sdk.base.AdMostGenericRequest$RequestType r5 = r9.requestType     // Catch:{ Exception -> 0x0177 }
            java.lang.String r5 = r5.name()     // Catch:{ Exception -> 0x0177 }
            r4.append(r5)     // Catch:{ Exception -> 0x0177 }
            r4.append(r8)     // Catch:{ Exception -> 0x0177 }
            r4.append(r1)     // Catch:{ Exception -> 0x0177 }
            java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x0177 }
            admost.sdk.base.AdMostLog.m299i(r1)     // Catch:{ Exception -> 0x0177 }
        L_0x0171:
            if (r10 == 0) goto L_0x0176
            r10.disconnect()
        L_0x0176:
            return r3
        L_0x0177:
            r1 = move-exception
            goto L_0x017d
        L_0x0179:
            r0 = move-exception
            goto L_0x018b
        L_0x017b:
            r1 = move-exception
            r10 = r2
        L_0x017d:
            r1.printStackTrace()     // Catch:{ all -> 0x0189 }
            r9.onError(r0, r1)     // Catch:{ all -> 0x0189 }
            if (r10 == 0) goto L_0x0188
            r10.disconnect()
        L_0x0188:
            return r2
        L_0x0189:
            r0 = move-exception
            r2 = r10
        L_0x018b:
            if (r2 == 0) goto L_0x0190
            r2.disconnect()
        L_0x0190:
            goto L_0x0192
        L_0x0191:
            throw r0
        L_0x0192:
            goto L_0x0191
        */
        throw new UnsupportedOperationException("Method not decompiled: admost.sdk.base.AdMostGenericRequest.processBiddingWinLossRequest(java.lang.String[]):org.json.JSONObject");
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0143  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String processCPRequest(java.lang.String... r9) {
        /*
            r8 = this;
            java.lang.String r0 = " : "
            java.lang.String r1 = "UTF-8"
            r2 = 0
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x012f, all -> 0x012d }
            java.net.URL r5 = new java.net.URL     // Catch:{ Exception -> 0x012f, all -> 0x012d }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012f, all -> 0x012d }
            r6.<init>()     // Catch:{ Exception -> 0x012f, all -> 0x012d }
            java.lang.String r7 = r8.host     // Catch:{ Exception -> 0x012f, all -> 0x012d }
            r6.append(r7)     // Catch:{ Exception -> 0x012f, all -> 0x012d }
            r7 = 0
            r9 = r9[r7]     // Catch:{ Exception -> 0x012f, all -> 0x012d }
            r6.append(r9)     // Catch:{ Exception -> 0x012f, all -> 0x012d }
            java.lang.String r9 = r6.toString()     // Catch:{ Exception -> 0x012f, all -> 0x012d }
            r5.<init>(r9)     // Catch:{ Exception -> 0x012f, all -> 0x012d }
            java.net.URLConnection r9 = r5.openConnection()     // Catch:{ Exception -> 0x012f, all -> 0x012d }
            java.net.HttpURLConnection r9 = (java.net.HttpURLConnection) r9     // Catch:{ Exception -> 0x012f, all -> 0x012d }
            int r6 = r8.timeOut     // Catch:{ Exception -> 0x012b }
            r9.setConnectTimeout(r6)     // Catch:{ Exception -> 0x012b }
            int r6 = r8.timeOut     // Catch:{ Exception -> 0x012b }
            r9.setReadTimeout(r6)     // Catch:{ Exception -> 0x012b }
            java.lang.String r6 = "Accept-Charset"
            r9.setRequestProperty(r6, r1)     // Catch:{ Exception -> 0x012b }
            java.lang.String r6 = "Content-Language"
            java.lang.String r7 = "tr-TR"
            r9.setRequestProperty(r6, r7)     // Catch:{ Exception -> 0x012b }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012b }
            r6.<init>()     // Catch:{ Exception -> 0x012b }
            admost.sdk.base.AdMostGenericRequest$RequestType r7 = r8.requestType     // Catch:{ Exception -> 0x012b }
            java.lang.String r7 = r7.name()     // Catch:{ Exception -> 0x012b }
            r6.append(r7)     // Catch:{ Exception -> 0x012b }
            r6.append(r0)     // Catch:{ Exception -> 0x012b }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x012b }
            r6.append(r5)     // Catch:{ Exception -> 0x012b }
            java.lang.String r5 = r6.toString()     // Catch:{ Exception -> 0x012b }
            admost.sdk.base.AdMostLog.m294d(r5)     // Catch:{ Exception -> 0x012b }
            int r5 = r9.getResponseCode()     // Catch:{ Exception -> 0x012b }
            r6 = 200(0xc8, float:2.8E-43)
            if (r5 == r6) goto L_0x00e1
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012b }
            r5.<init>()     // Catch:{ Exception -> 0x012b }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x012b }
            long r6 = r6 - r3
            r5.append(r6)     // Catch:{ Exception -> 0x012b }
            java.lang.String r3 = " ms Error:"
            r5.append(r3)     // Catch:{ Exception -> 0x012b }
            int r3 = r9.getResponseCode()     // Catch:{ Exception -> 0x012b }
            r5.append(r3)     // Catch:{ Exception -> 0x012b }
            java.lang.String r3 = " "
            r5.append(r3)     // Catch:{ Exception -> 0x012b }
            java.net.URL r3 = r9.getURL()     // Catch:{ Exception -> 0x012b }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x012b }
            r5.append(r3)     // Catch:{ Exception -> 0x012b }
            java.lang.String r3 = r5.toString()     // Catch:{ Exception -> 0x012b }
            admost.sdk.base.AdMostLog.m303w(r3)     // Catch:{ Exception -> 0x012b }
            java.io.BufferedInputStream r4 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x00d7 }
            java.io.InputStream r5 = r9.getErrorStream()     // Catch:{ Exception -> 0x00d7 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x00d7 }
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00d7 }
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00d7 }
            r6.<init>(r4, r1)     // Catch:{ Exception -> 0x00d7 }
            r5.<init>(r6)     // Catch:{ Exception -> 0x00d7 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d7 }
            r1.<init>()     // Catch:{ Exception -> 0x00d7 }
        L_0x00ad:
            java.lang.String r4 = r5.readLine()     // Catch:{ Exception -> 0x00d7 }
            if (r4 == 0) goto L_0x00b7
            r1.append(r4)     // Catch:{ Exception -> 0x00d7 }
            goto L_0x00ad
        L_0x00b7:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d7 }
            r4.<init>()     // Catch:{ Exception -> 0x00d7 }
            admost.sdk.base.AdMostGenericRequest$RequestType r5 = r8.requestType     // Catch:{ Exception -> 0x00d7 }
            java.lang.String r5 = r5.name()     // Catch:{ Exception -> 0x00d7 }
            r4.append(r5)     // Catch:{ Exception -> 0x00d7 }
            r4.append(r0)     // Catch:{ Exception -> 0x00d7 }
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x00d7 }
            r4.append(r0)     // Catch:{ Exception -> 0x00d7 }
            java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x00d7 }
            admost.sdk.base.AdMostLog.m303w(r0)     // Catch:{ Exception -> 0x00d7 }
            goto L_0x00db
        L_0x00d7:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Exception -> 0x012b }
        L_0x00db:
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ Exception -> 0x012b }
            r0.<init>(r3)     // Catch:{ Exception -> 0x012b }
            throw r0     // Catch:{ Exception -> 0x012b }
        L_0x00e1:
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x012b }
            java.io.InputStream r4 = r9.getInputStream()     // Catch:{ Exception -> 0x012b }
            r3.<init>(r4)     // Catch:{ Exception -> 0x012b }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ Exception -> 0x012b }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x012b }
            r5.<init>(r3, r1)     // Catch:{ Exception -> 0x012b }
            r4.<init>(r5)     // Catch:{ Exception -> 0x012b }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012b }
            r1.<init>()     // Catch:{ Exception -> 0x012b }
        L_0x00f9:
            java.lang.String r5 = r4.readLine()     // Catch:{ Exception -> 0x012b }
            if (r5 == 0) goto L_0x0103
            r1.append(r5)     // Catch:{ Exception -> 0x012b }
            goto L_0x00f9
        L_0x0103:
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x012b }
            r3.close()     // Catch:{ Exception -> 0x012b }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012b }
            r3.<init>()     // Catch:{ Exception -> 0x012b }
            admost.sdk.base.AdMostGenericRequest$RequestType r4 = r8.requestType     // Catch:{ Exception -> 0x012b }
            java.lang.String r4 = r4.name()     // Catch:{ Exception -> 0x012b }
            r3.append(r4)     // Catch:{ Exception -> 0x012b }
            r3.append(r0)     // Catch:{ Exception -> 0x012b }
            r3.append(r1)     // Catch:{ Exception -> 0x012b }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x012b }
            admost.sdk.base.AdMostLog.m294d(r0)     // Catch:{ Exception -> 0x012b }
            if (r9 == 0) goto L_0x012a
            r9.disconnect()
        L_0x012a:
            return r1
        L_0x012b:
            r0 = move-exception
            goto L_0x0131
        L_0x012d:
            r0 = move-exception
            goto L_0x0141
        L_0x012f:
            r0 = move-exception
            r9 = r2
        L_0x0131:
            r0.printStackTrace()     // Catch:{ all -> 0x013f }
            java.lang.String r1 = ""
            r8.onError(r1, r0)     // Catch:{ all -> 0x013f }
            if (r9 == 0) goto L_0x013e
            r9.disconnect()
        L_0x013e:
            return r2
        L_0x013f:
            r0 = move-exception
            r2 = r9
        L_0x0141:
            if (r2 == 0) goto L_0x0146
            r2.disconnect()
        L_0x0146:
            goto L_0x0148
        L_0x0147:
            throw r0
        L_0x0148:
            goto L_0x0147
        */
        throw new UnsupportedOperationException("Method not decompiled: admost.sdk.base.AdMostGenericRequest.processCPRequest(java.lang.String[]):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0078  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.json.JSONObject processCountryRequest() {
        /*
            r6 = this;
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x0065, all -> 0x0060 }
            java.lang.String r2 = r6.host     // Catch:{ Exception -> 0x0065, all -> 0x0060 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0065, all -> 0x0060 }
            java.net.URLConnection r1 = r1.openConnection()     // Catch:{ Exception -> 0x0065, all -> 0x0060 }
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ Exception -> 0x0065, all -> 0x0060 }
            int r2 = r6.timeOut     // Catch:{ Exception -> 0x005e }
            r1.setConnectTimeout(r2)     // Catch:{ Exception -> 0x005e }
            int r2 = r6.timeOut     // Catch:{ Exception -> 0x005e }
            r1.setReadTimeout(r2)     // Catch:{ Exception -> 0x005e }
            java.lang.String r2 = "Accept-Charset"
            java.lang.String r3 = "UTF-8"
            r1.setRequestProperty(r2, r3)     // Catch:{ Exception -> 0x005e }
            java.io.InputStream r2 = r1.getInputStream()     // Catch:{ Exception -> 0x005e }
            java.lang.String r2 = r6.read(r2)     // Catch:{ Exception -> 0x005e }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x005e }
            r3.<init>(r2)     // Catch:{ Exception -> 0x005e }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x005e }
            r2.<init>()     // Catch:{ Exception -> 0x005e }
            admost.sdk.base.AdMostGenericRequest$RequestType r4 = r6.requestType     // Catch:{ Exception -> 0x005e }
            java.lang.String r4 = r4.name()     // Catch:{ Exception -> 0x005e }
            r2.append(r4)     // Catch:{ Exception -> 0x005e }
            java.lang.String r4 = " : "
            r2.append(r4)     // Catch:{ Exception -> 0x005e }
            java.lang.String r4 = r6.host     // Catch:{ Exception -> 0x005e }
            r2.append(r4)     // Catch:{ Exception -> 0x005e }
            java.lang.String r4 = " response : "
            r2.append(r4)     // Catch:{ Exception -> 0x005e }
            r4 = 2
            java.lang.String r4 = r3.toString(r4)     // Catch:{ Exception -> 0x005e }
            r2.append(r4)     // Catch:{ Exception -> 0x005e }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x005e }
            admost.sdk.base.AdMostLog.all(r2)     // Catch:{ Exception -> 0x005e }
            if (r1 == 0) goto L_0x005d
            r1.disconnect()
        L_0x005d:
            return r3
        L_0x005e:
            r2 = move-exception
            goto L_0x0067
        L_0x0060:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x0076
        L_0x0065:
            r2 = move-exception
            r1 = r0
        L_0x0067:
            r2.printStackTrace()     // Catch:{ all -> 0x0075 }
            java.lang.String r3 = ""
            r6.onError(r3, r2)     // Catch:{ all -> 0x0075 }
            if (r1 == 0) goto L_0x0074
            r1.disconnect()
        L_0x0074:
            return r0
        L_0x0075:
            r0 = move-exception
        L_0x0076:
            if (r1 == 0) goto L_0x007b
            r1.disconnect()
        L_0x007b:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: admost.sdk.base.AdMostGenericRequest.processCountryRequest():org.json.JSONObject");
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0138 A[Catch:{ Exception -> 0x0224 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x013e A[Catch:{ Exception -> 0x0224 }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01c7 A[Catch:{ Exception -> 0x0224 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01e7 A[Catch:{ Exception -> 0x0224 }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0214 A[Catch:{ Exception -> 0x0224 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0220  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0232  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x023a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.json.JSONObject processGenericRequest(java.lang.String... r12) {
        /*
            r11 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = "UTF-8"
            admost.sdk.base.AdMostGenericRequest$RequestType r2 = r11.requestType
            admost.sdk.base.AdMostGenericRequest$RequestType r3 = admost.sdk.base.AdMostGenericRequest.RequestType.INIT_RESPONSE
            java.lang.String r4 = "EXPERIMENT"
            java.lang.String r5 = "INIT"
            if (r2 != r3) goto L_0x003a
            admost.sdk.base.AdmostResponseCache r2 = getFromCache(r3, r5)
            if (r2 == 0) goto L_0x006c
            long r6 = r2.getExpireAt()
            long r8 = java.lang.System.currentTimeMillis()
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r3 <= 0) goto L_0x006c
            boolean r12 = admost.sdk.base.AdMostLog.isIsHTTPLoggingEnabled()
            java.lang.String r0 = "Admost initialized from cache"
            if (r12 == 0) goto L_0x0032
            org.json.JSONObject r12 = r2.getJsonObject()
            java.util.logging.Level r1 = java.util.logging.Level.INFO
            admost.sdk.base.AdMostLog.json(r12, r0, r1)
            goto L_0x0035
        L_0x0032:
            admost.sdk.base.AdMostLog.m299i(r0)
        L_0x0035:
            org.json.JSONObject r12 = r2.getJsonObject()
            return r12
        L_0x003a:
            admost.sdk.base.AdMostGenericRequest$RequestType r3 = admost.sdk.base.AdMostGenericRequest.RequestType.EXPERIMENT
            if (r2 != r3) goto L_0x006c
            admost.sdk.base.AdmostResponseCache r2 = getFromCache(r3, r4)
            if (r2 == 0) goto L_0x006c
            long r6 = r2.getExpireAt()
            long r8 = java.lang.System.currentTimeMillis()
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r3 <= 0) goto L_0x006c
            boolean r12 = admost.sdk.base.AdMostLog.isIsHTTPLoggingEnabled()
            if (r12 == 0) goto L_0x0062
            org.json.JSONObject r12 = r2.getJsonObject()
            java.util.logging.Level r0 = java.util.logging.Level.INFO
            java.lang.String r1 = "Admost experiment got from cache"
            admost.sdk.base.AdMostLog.json(r12, r1, r0)
            goto L_0x0067
        L_0x0062:
            java.lang.String r12 = "Admost experiment from cache"
            admost.sdk.base.AdMostLog.m299i(r12)
        L_0x0067:
            org.json.JSONObject r12 = r2.getJsonObject()
            return r12
        L_0x006c:
            r2 = 0
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0228, all -> 0x0226 }
            java.net.URL r3 = new java.net.URL     // Catch:{ Exception -> 0x0228, all -> 0x0226 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0228, all -> 0x0226 }
            r8.<init>()     // Catch:{ Exception -> 0x0228, all -> 0x0226 }
            java.lang.String r9 = r11.host     // Catch:{ Exception -> 0x0228, all -> 0x0226 }
            r8.append(r9)     // Catch:{ Exception -> 0x0228, all -> 0x0226 }
            r9 = 0
            r12 = r12[r9]     // Catch:{ Exception -> 0x0228, all -> 0x0226 }
            r8.append(r12)     // Catch:{ Exception -> 0x0228, all -> 0x0226 }
            java.lang.String r12 = r8.toString()     // Catch:{ Exception -> 0x0228, all -> 0x0226 }
            r3.<init>(r12)     // Catch:{ Exception -> 0x0228, all -> 0x0226 }
            java.net.URLConnection r12 = r3.openConnection()     // Catch:{ Exception -> 0x0228, all -> 0x0226 }
            java.net.HttpURLConnection r12 = (java.net.HttpURLConnection) r12     // Catch:{ Exception -> 0x0228, all -> 0x0226 }
            int r8 = r11.timeOut     // Catch:{ Exception -> 0x0224 }
            r12.setConnectTimeout(r8)     // Catch:{ Exception -> 0x0224 }
            int r8 = r11.timeOut     // Catch:{ Exception -> 0x0224 }
            r12.setReadTimeout(r8)     // Catch:{ Exception -> 0x0224 }
            java.lang.String r8 = "Accept-Charset"
            r12.setRequestProperty(r8, r1)     // Catch:{ Exception -> 0x0224 }
            java.lang.String r8 = "Content-Language"
            java.lang.String r9 = "tr-TR"
            r12.setRequestProperty(r8, r9)     // Catch:{ Exception -> 0x0224 }
            int r8 = r12.getResponseCode()     // Catch:{ Exception -> 0x0224 }
            r9 = 200(0xc8, float:2.8E-43)
            java.lang.String r10 = " : "
            if (r8 == r9) goto L_0x0144
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0224 }
            r3.<init>()     // Catch:{ Exception -> 0x0224 }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0224 }
            long r4 = r4 - r6
            r3.append(r4)     // Catch:{ Exception -> 0x0224 }
            java.lang.String r4 = " ms Error:"
            r3.append(r4)     // Catch:{ Exception -> 0x0224 }
            int r4 = r12.getResponseCode()     // Catch:{ Exception -> 0x0224 }
            r3.append(r4)     // Catch:{ Exception -> 0x0224 }
            java.lang.String r4 = " "
            r3.append(r4)     // Catch:{ Exception -> 0x0224 }
            java.net.URL r4 = r12.getURL()     // Catch:{ Exception -> 0x0224 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0224 }
            r3.append(r4)     // Catch:{ Exception -> 0x0224 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0224 }
            admost.sdk.base.AdMostLog.m303w(r3)     // Catch:{ Exception -> 0x0224 }
            java.io.BufferedInputStream r4 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0131 }
            java.io.InputStream r5 = r12.getErrorStream()     // Catch:{ Exception -> 0x0131 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0131 }
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0131 }
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0131 }
            r6.<init>(r4, r1)     // Catch:{ Exception -> 0x0131 }
            r5.<init>(r6)     // Catch:{ Exception -> 0x0131 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0131 }
            r1.<init>()     // Catch:{ Exception -> 0x0131 }
        L_0x00f8:
            java.lang.String r4 = r5.readLine()     // Catch:{ Exception -> 0x0131 }
            if (r4 == 0) goto L_0x0102
            r1.append(r4)     // Catch:{ Exception -> 0x0131 }
            goto L_0x00f8
        L_0x0102:
            admost.sdk.model.AdMostServerException r4 = new admost.sdk.model.AdMostServerException     // Catch:{ Exception -> 0x0131 }
            int r5 = r12.getResponseCode()     // Catch:{ Exception -> 0x0131 }
            java.lang.String r6 = r1.toString()     // Catch:{ Exception -> 0x0131 }
            r4.<init>(r5, r6)     // Catch:{ Exception -> 0x0131 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012f }
            r5.<init>()     // Catch:{ Exception -> 0x012f }
            admost.sdk.base.AdMostGenericRequest$RequestType r6 = r11.requestType     // Catch:{ Exception -> 0x012f }
            java.lang.String r6 = r6.name()     // Catch:{ Exception -> 0x012f }
            r5.append(r6)     // Catch:{ Exception -> 0x012f }
            r5.append(r10)     // Catch:{ Exception -> 0x012f }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x012f }
            r5.append(r1)     // Catch:{ Exception -> 0x012f }
            java.lang.String r1 = r5.toString()     // Catch:{ Exception -> 0x012f }
            admost.sdk.base.AdMostLog.m303w(r1)     // Catch:{ Exception -> 0x012f }
            goto L_0x0136
        L_0x012f:
            r1 = move-exception
            goto L_0x0133
        L_0x0131:
            r1 = move-exception
            r4 = r2
        L_0x0133:
            r1.printStackTrace()     // Catch:{ Exception -> 0x0224 }
        L_0x0136:
            if (r4 == 0) goto L_0x013e
            java.lang.Exception r1 = new java.lang.Exception     // Catch:{ Exception -> 0x0224 }
            r1.<init>(r3, r4)     // Catch:{ Exception -> 0x0224 }
            throw r1     // Catch:{ Exception -> 0x0224 }
        L_0x013e:
            java.lang.Exception r1 = new java.lang.Exception     // Catch:{ Exception -> 0x0224 }
            r1.<init>(r3)     // Catch:{ Exception -> 0x0224 }
            throw r1     // Catch:{ Exception -> 0x0224 }
        L_0x0144:
            admost.sdk.base.AdMostGenericRequest$RequestType r6 = r11.requestType     // Catch:{ Exception -> 0x0224 }
            admost.sdk.base.AdMostGenericRequest$RequestType r7 = admost.sdk.base.AdMostGenericRequest.RequestType.INIT_RESPONSE     // Catch:{ Exception -> 0x0224 }
            if (r6 != r7) goto L_0x0163
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0224 }
            r6.<init>()     // Catch:{ Exception -> 0x0224 }
            java.lang.String r7 = "Init Request: "
            r6.append(r7)     // Catch:{ Exception -> 0x0224 }
            java.lang.String r7 = r3.toString()     // Catch:{ Exception -> 0x0224 }
            r6.append(r7)     // Catch:{ Exception -> 0x0224 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0224 }
            admost.sdk.base.AdMostLog.m299i(r6)     // Catch:{ Exception -> 0x0224 }
            goto L_0x0181
        L_0x0163:
            admost.sdk.base.AdMostGenericRequest$RequestType r6 = r11.requestType     // Catch:{ Exception -> 0x0224 }
            admost.sdk.base.AdMostGenericRequest$RequestType r7 = admost.sdk.base.AdMostGenericRequest.RequestType.EXPERIMENT     // Catch:{ Exception -> 0x0224 }
            if (r6 != r7) goto L_0x0181
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0224 }
            r6.<init>()     // Catch:{ Exception -> 0x0224 }
            java.lang.String r7 = "Experiment: "
            r6.append(r7)     // Catch:{ Exception -> 0x0224 }
            java.lang.String r7 = r3.toString()     // Catch:{ Exception -> 0x0224 }
            r6.append(r7)     // Catch:{ Exception -> 0x0224 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0224 }
            admost.sdk.base.AdMostLog.m299i(r6)     // Catch:{ Exception -> 0x0224 }
        L_0x0181:
            java.io.BufferedInputStream r6 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0224 }
            java.io.InputStream r7 = r12.getInputStream()     // Catch:{ Exception -> 0x0224 }
            r6.<init>(r7)     // Catch:{ Exception -> 0x0224 }
            java.io.BufferedReader r7 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0224 }
            java.io.InputStreamReader r8 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0224 }
            r8.<init>(r6, r1)     // Catch:{ Exception -> 0x0224 }
            r7.<init>(r8)     // Catch:{ Exception -> 0x0224 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0224 }
            r1.<init>()     // Catch:{ Exception -> 0x0224 }
        L_0x0199:
            java.lang.String r8 = r7.readLine()     // Catch:{ Exception -> 0x0224 }
            if (r8 == 0) goto L_0x01a3
            r1.append(r8)     // Catch:{ Exception -> 0x0224 }
            goto L_0x0199
        L_0x01a3:
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0224 }
            r6.close()     // Catch:{ Exception -> 0x0224 }
            r11.getCacheDuration(r12)     // Catch:{ Exception -> 0x0224 }
            if (r1 == 0) goto L_0x01bc
            boolean r6 = r1.equals(r0)     // Catch:{ Exception -> 0x0224 }
            if (r6 == 0) goto L_0x01b6
            goto L_0x01bc
        L_0x01b6:
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Exception -> 0x0224 }
            r6.<init>(r1)     // Catch:{ Exception -> 0x0224 }
            goto L_0x01c1
        L_0x01bc:
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Exception -> 0x0224 }
            r6.<init>()     // Catch:{ Exception -> 0x0224 }
        L_0x01c1:
            boolean r7 = admost.sdk.base.AdMostLog.isIsHTTPLoggingEnabled()     // Catch:{ Exception -> 0x0224 }
            if (r7 == 0) goto L_0x01e7
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0224 }
            r1.<init>()     // Catch:{ Exception -> 0x0224 }
            admost.sdk.base.AdMostGenericRequest$RequestType r7 = r11.requestType     // Catch:{ Exception -> 0x0224 }
            java.lang.String r7 = r7.name()     // Catch:{ Exception -> 0x0224 }
            r1.append(r7)     // Catch:{ Exception -> 0x0224 }
            r1.append(r10)     // Catch:{ Exception -> 0x0224 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0224 }
            r1.append(r3)     // Catch:{ Exception -> 0x0224 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0224 }
            admost.sdk.base.AdMostLog.json((org.json.JSONObject) r6, (java.lang.String) r1)     // Catch:{ Exception -> 0x0224 }
            goto L_0x0202
        L_0x01e7:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0224 }
            r3.<init>()     // Catch:{ Exception -> 0x0224 }
            admost.sdk.base.AdMostGenericRequest$RequestType r7 = r11.requestType     // Catch:{ Exception -> 0x0224 }
            java.lang.String r7 = r7.name()     // Catch:{ Exception -> 0x0224 }
            r3.append(r7)     // Catch:{ Exception -> 0x0224 }
            r3.append(r10)     // Catch:{ Exception -> 0x0224 }
            r3.append(r1)     // Catch:{ Exception -> 0x0224 }
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x0224 }
            admost.sdk.base.AdMostLog.m299i(r1)     // Catch:{ Exception -> 0x0224 }
        L_0x0202:
            admost.sdk.base.AdMostGenericRequest$RequestType r1 = r11.requestType     // Catch:{ Exception -> 0x0224 }
            admost.sdk.base.AdMostGenericRequest$RequestType r3 = admost.sdk.base.AdMostGenericRequest.RequestType.INIT_RESPONSE     // Catch:{ Exception -> 0x0224 }
            if (r1 == r3) goto L_0x020e
            admost.sdk.base.AdMostGenericRequest$RequestType r1 = r11.requestType     // Catch:{ Exception -> 0x0224 }
            admost.sdk.base.AdMostGenericRequest$RequestType r3 = admost.sdk.base.AdMostGenericRequest.RequestType.EXPERIMENT     // Catch:{ Exception -> 0x0224 }
            if (r1 != r3) goto L_0x021e
        L_0x020e:
            admost.sdk.base.AdMostGenericRequest$RequestType r1 = r11.requestType     // Catch:{ Exception -> 0x0224 }
            admost.sdk.base.AdMostGenericRequest$RequestType r3 = admost.sdk.base.AdMostGenericRequest.RequestType.INIT_RESPONSE     // Catch:{ Exception -> 0x0224 }
            if (r1 != r3) goto L_0x0215
            r4 = r5
        L_0x0215:
            admost.sdk.base.AdMostGenericRequest$RequestType r1 = r11.requestType     // Catch:{ Exception -> 0x0224 }
            int r3 = r11.getCacheDuration(r12)     // Catch:{ Exception -> 0x0224 }
            r11.putToCache(r4, r6, r1, r3)     // Catch:{ Exception -> 0x0224 }
        L_0x021e:
            if (r12 == 0) goto L_0x0223
            r12.disconnect()
        L_0x0223:
            return r6
        L_0x0224:
            r1 = move-exception
            goto L_0x022a
        L_0x0226:
            r0 = move-exception
            goto L_0x0238
        L_0x0228:
            r1 = move-exception
            r12 = r2
        L_0x022a:
            r1.printStackTrace()     // Catch:{ all -> 0x0236 }
            r11.onError(r0, r1)     // Catch:{ all -> 0x0236 }
            if (r12 == 0) goto L_0x0235
            r12.disconnect()
        L_0x0235:
            return r2
        L_0x0236:
            r0 = move-exception
            r2 = r12
        L_0x0238:
            if (r2 == 0) goto L_0x023d
            r2.disconnect()
        L_0x023d:
            goto L_0x023f
        L_0x023e:
            throw r0
        L_0x023f:
            goto L_0x023e
        */
        throw new UnsupportedOperationException("Method not decompiled: admost.sdk.base.AdMostGenericRequest.processGenericRequest(java.lang.String[]):org.json.JSONObject");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0143, code lost:
        if (r4 != null) goto L_0x0145;
     */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x014d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.json.JSONObject processSSVRequest(java.lang.String... r9) {
        /*
            r8 = this;
            java.lang.String r0 = " : "
            java.lang.String r1 = "UTF-8"
            r2 = 0
            r9 = r9[r2]
            r3 = 0
            java.net.URL r4 = new java.net.URL     // Catch:{ Exception -> 0x013b, all -> 0x0139 }
            java.lang.String r5 = r8.host     // Catch:{ Exception -> 0x013b, all -> 0x0139 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x013b, all -> 0x0139 }
            java.net.URLConnection r4 = r4.openConnection()     // Catch:{ Exception -> 0x013b, all -> 0x0139 }
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ Exception -> 0x013b, all -> 0x0139 }
            int r5 = r8.timeOut     // Catch:{ Exception -> 0x0137 }
            r4.setConnectTimeout(r5)     // Catch:{ Exception -> 0x0137 }
            int r5 = r8.timeOut     // Catch:{ Exception -> 0x0137 }
            r4.setReadTimeout(r5)     // Catch:{ Exception -> 0x0137 }
            java.lang.String r5 = "POST"
            r4.setRequestMethod(r5)     // Catch:{ Exception -> 0x0137 }
            java.lang.String r5 = "Content-Type"
            java.lang.String r6 = "application/json"
            r4.setRequestProperty(r5, r6)     // Catch:{ Exception -> 0x0137 }
            java.lang.String r5 = "Accept-Charset"
            r4.setRequestProperty(r5, r1)     // Catch:{ Exception -> 0x0137 }
            java.lang.String r5 = "Content-Length"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0137 }
            r6.<init>()     // Catch:{ Exception -> 0x0137 }
            java.lang.String r7 = ""
            r6.append(r7)     // Catch:{ Exception -> 0x0137 }
            byte[] r7 = r9.getBytes()     // Catch:{ Exception -> 0x0137 }
            int r7 = r7.length     // Catch:{ Exception -> 0x0137 }
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ Exception -> 0x0137 }
            r6.append(r7)     // Catch:{ Exception -> 0x0137 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0137 }
            r4.setRequestProperty(r5, r6)     // Catch:{ Exception -> 0x0137 }
            java.lang.String r5 = "Accept-Language"
            java.util.Locale r6 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x0061 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0061 }
            java.lang.String r6 = r6.toLowerCase()     // Catch:{ Exception -> 0x0061 }
            r4.setRequestProperty(r5, r6)     // Catch:{ Exception -> 0x0061 }
            goto L_0x0065
        L_0x0061:
            r5 = move-exception
            r5.printStackTrace()     // Catch:{ Exception -> 0x0137 }
        L_0x0065:
            r4.setUseCaches(r2)     // Catch:{ Exception -> 0x0137 }
            r2 = 1
            r4.setDoInput(r2)     // Catch:{ Exception -> 0x0137 }
            r4.setDoOutput(r2)     // Catch:{ Exception -> 0x0137 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0137 }
            r2.<init>()     // Catch:{ Exception -> 0x0137 }
            admost.sdk.base.AdMostGenericRequest$RequestType r5 = r8.requestType     // Catch:{ Exception -> 0x0137 }
            java.lang.String r5 = r5.name()     // Catch:{ Exception -> 0x0137 }
            r2.append(r5)     // Catch:{ Exception -> 0x0137 }
            r2.append(r0)     // Catch:{ Exception -> 0x0137 }
            r2.append(r9)     // Catch:{ Exception -> 0x0137 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0137 }
            admost.sdk.base.AdMostLog.m294d(r2)     // Catch:{ Exception -> 0x0137 }
            java.io.DataOutputStream r2 = new java.io.DataOutputStream     // Catch:{ Exception -> 0x0137 }
            java.io.OutputStream r5 = r4.getOutputStream()     // Catch:{ Exception -> 0x0137 }
            r2.<init>(r5)     // Catch:{ Exception -> 0x0137 }
            byte[] r5 = r9.getBytes(r1)     // Catch:{ Exception -> 0x0137 }
            r2.write(r5)     // Catch:{ Exception -> 0x0137 }
            r2.flush()     // Catch:{ Exception -> 0x0137 }
            r2.close()     // Catch:{ Exception -> 0x0137 }
            int r2 = r4.getResponseCode()     // Catch:{ Exception -> 0x0137 }
            r5 = 200(0xc8, float:2.8E-43)
            if (r2 == r5) goto L_0x00e5
            int r0 = r4.getResponseCode()     // Catch:{ Exception -> 0x0137 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0137 }
            r2.<init>()     // Catch:{ Exception -> 0x0137 }
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x00ce }
            java.io.InputStream r6 = r4.getErrorStream()     // Catch:{ Exception -> 0x00ce }
            r5.<init>(r6)     // Catch:{ Exception -> 0x00ce }
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00ce }
            java.io.InputStreamReader r7 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00ce }
            r7.<init>(r5, r1)     // Catch:{ Exception -> 0x00ce }
            r6.<init>(r7)     // Catch:{ Exception -> 0x00ce }
        L_0x00c4:
            java.lang.String r1 = r6.readLine()     // Catch:{ Exception -> 0x00ce }
            if (r1 == 0) goto L_0x00d2
            r2.append(r1)     // Catch:{ Exception -> 0x00ce }
            goto L_0x00c4
        L_0x00ce:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ Exception -> 0x0137 }
        L_0x00d2:
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x0137 }
            admost.sdk.model.AdMostServerException r5 = new admost.sdk.model.AdMostServerException     // Catch:{ Exception -> 0x0137 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0137 }
            r5.<init>(r0, r2)     // Catch:{ Exception -> 0x0137 }
            r8.onError(r1, r5)     // Catch:{ Exception -> 0x0137 }
            if (r4 == 0) goto L_0x0148
            goto L_0x0145
        L_0x00e5:
            java.io.InputStream r1 = r4.getInputStream()     // Catch:{ Exception -> 0x0137 }
            java.lang.String r1 = r8.read(r1)     // Catch:{ Exception -> 0x0137 }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x0137 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0137 }
            boolean r5 = admost.sdk.base.AdMostLog.isIsHTTPLoggingEnabled()     // Catch:{ Exception -> 0x0137 }
            if (r5 == 0) goto L_0x0116
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0137 }
            r1.<init>()     // Catch:{ Exception -> 0x0137 }
            admost.sdk.base.AdMostGenericRequest$RequestType r5 = r8.requestType     // Catch:{ Exception -> 0x0137 }
            java.lang.String r5 = r5.name()     // Catch:{ Exception -> 0x0137 }
            r1.append(r5)     // Catch:{ Exception -> 0x0137 }
            r1.append(r0)     // Catch:{ Exception -> 0x0137 }
            java.lang.String r0 = r8.host     // Catch:{ Exception -> 0x0137 }
            r1.append(r0)     // Catch:{ Exception -> 0x0137 }
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x0137 }
            admost.sdk.base.AdMostLog.json((org.json.JSONObject) r2, (java.lang.String) r0)     // Catch:{ Exception -> 0x0137 }
            goto L_0x0131
        L_0x0116:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0137 }
            r5.<init>()     // Catch:{ Exception -> 0x0137 }
            admost.sdk.base.AdMostGenericRequest$RequestType r6 = r8.requestType     // Catch:{ Exception -> 0x0137 }
            java.lang.String r6 = r6.name()     // Catch:{ Exception -> 0x0137 }
            r5.append(r6)     // Catch:{ Exception -> 0x0137 }
            r5.append(r0)     // Catch:{ Exception -> 0x0137 }
            r5.append(r1)     // Catch:{ Exception -> 0x0137 }
            java.lang.String r0 = r5.toString()     // Catch:{ Exception -> 0x0137 }
            admost.sdk.base.AdMostLog.m294d(r0)     // Catch:{ Exception -> 0x0137 }
        L_0x0131:
            if (r4 == 0) goto L_0x0136
            r4.disconnect()
        L_0x0136:
            return r2
        L_0x0137:
            r0 = move-exception
            goto L_0x013d
        L_0x0139:
            r9 = move-exception
            goto L_0x014b
        L_0x013b:
            r0 = move-exception
            r4 = r3
        L_0x013d:
            r0.printStackTrace()     // Catch:{ all -> 0x0149 }
            r8.onError(r9, r0)     // Catch:{ all -> 0x0149 }
            if (r4 == 0) goto L_0x0148
        L_0x0145:
            r4.disconnect()
        L_0x0148:
            return r3
        L_0x0149:
            r9 = move-exception
            r3 = r4
        L_0x014b:
            if (r3 == 0) goto L_0x0150
            r3.disconnect()
        L_0x0150:
            goto L_0x0152
        L_0x0151:
            throw r9
        L_0x0152:
            goto L_0x0151
        */
        throw new UnsupportedOperationException("Method not decompiled: admost.sdk.base.AdMostGenericRequest.processSSVRequest(java.lang.String[]):org.json.JSONObject");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:20|21) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r0 = admost.sdk.base.AdMostWaterfallStrategyManager.getInstance().getBannerResponseObject(r2.getJsonObject(), false, r8);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x007d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private admost.sdk.model.AdMostBannerResponseBase processZoneRequest(java.lang.String... r8) {
        /*
            r7 = this;
            r0 = 0
            if (r8 == 0) goto L_0x0017
            int r1 = r8.length
            if (r1 <= 0) goto L_0x0017
            r1 = r8[r0]
            java.lang.String r2 = "test"
            boolean r1 = r1.equalsIgnoreCase(r2)
            r8 = r8[r0]
            java.lang.String r2 = "forCache"
            boolean r8 = r8.equalsIgnoreCase(r2)
            goto L_0x0019
        L_0x0017:
            r8 = 0
            r1 = 0
        L_0x0019:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "ZONE*"
            r2.append(r3)
            java.lang.String r3 = r7.zoneId
            r2.append(r3)
            java.lang.String r3 = "*EXP*"
            r2.append(r3)
            admost.sdk.base.AdMostExperimentManager r3 = admost.sdk.base.AdMostExperimentManager.getInstance()
            java.lang.String r3 = r3.getCurrentExperiment()
            r2.append(r3)
            java.lang.String r3 = "*GROUP*"
            r2.append(r3)
            admost.sdk.base.AdMostExperimentManager r3 = admost.sdk.base.AdMostExperimentManager.getInstance()
            java.lang.String r3 = r3.getCurrentGroup()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            admost.sdk.base.AdMostGenericRequest$RequestType r3 = admost.sdk.base.AdMostGenericRequest.RequestType.ZONE_RESPONSE
            admost.sdk.base.AdmostResponseCache r2 = getFromCache(r3, r2)
            if (r2 == 0) goto L_0x00e8
            int r3 = r2.getStatus()
            r4 = -1
            if (r3 == r4) goto L_0x00e8
            r3 = 0
            r4 = 120(0x78, float:1.68E-43)
            if (r1 != 0) goto L_0x0070
            admost.sdk.base.AdMostWaterfallStrategyManager r5 = admost.sdk.base.AdMostWaterfallStrategyManager.getInstance()     // Catch:{ Exception -> 0x006e }
            org.json.JSONObject r6 = r2.getJsonObject()     // Catch:{ Exception -> 0x006e }
            admost.sdk.model.AdMostBannerResponseBase r0 = r5.getBannerResponseObject(r6, r0, r8)     // Catch:{ Exception -> 0x006e }
        L_0x006c:
            r3 = r0
            goto L_0x008a
        L_0x006e:
            r0 = move-exception
            goto L_0x00bd
        L_0x0070:
            admost.sdk.model.AdMostTestSuiteBannerResponse r5 = new admost.sdk.model.AdMostTestSuiteBannerResponse     // Catch:{ Exception -> 0x007d }
            org.json.JSONObject r6 = r2.getJsonObject()     // Catch:{ Exception -> 0x007d }
            r5.<init>(r6, r0, r8)     // Catch:{ Exception -> 0x007d }
            r3 = r5
            goto L_0x008a
        L_0x007b:
            r0 = move-exception
            goto L_0x00d3
        L_0x007d:
            admost.sdk.base.AdMostWaterfallStrategyManager r5 = admost.sdk.base.AdMostWaterfallStrategyManager.getInstance()     // Catch:{ Exception -> 0x006e }
            org.json.JSONObject r6 = r2.getJsonObject()     // Catch:{ Exception -> 0x006e }
            admost.sdk.model.AdMostBannerResponseBase r0 = r5.getBannerResponseObject(r6, r0, r8)     // Catch:{ Exception -> 0x006e }
            goto L_0x006c
        L_0x008a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x006e }
            r0.<init>()     // Catch:{ Exception -> 0x006e }
            java.lang.String r5 = "Admost Zone Request retrieved from cache: zoneId "
            r0.append(r5)     // Catch:{ Exception -> 0x006e }
            java.lang.String r5 = r7.zoneId     // Catch:{ Exception -> 0x006e }
            r0.append(r5)     // Catch:{ Exception -> 0x006e }
            java.lang.String r5 = " , Test Suite active: "
            r0.append(r5)     // Catch:{ Exception -> 0x006e }
            r0.append(r1)     // Catch:{ Exception -> 0x006e }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x006e }
            admost.sdk.base.AdMostLog.m294d(r0)     // Catch:{ Exception -> 0x006e }
            int r0 = r2.getStatus()
            if (r0 != 0) goto L_0x00d2
            int r0 = r2.getCacheDuration()
            if (r0 <= r4) goto L_0x00d2
            admost.sdk.base.AdMostGenericRequest$1 r0 = new admost.sdk.base.AdMostGenericRequest$1
            r0.<init>(r2, r1, r8)
        L_0x00b9:
            android.os.AsyncTask.execute(r0)
            goto L_0x00d2
        L_0x00bd:
            r0.printStackTrace()     // Catch:{ all -> 0x007b }
            int r0 = r2.getStatus()
            if (r0 != 0) goto L_0x00d2
            int r0 = r2.getCacheDuration()
            if (r0 <= r4) goto L_0x00d2
            admost.sdk.base.AdMostGenericRequest$1 r0 = new admost.sdk.base.AdMostGenericRequest$1
            r0.<init>(r2, r1, r8)
            goto L_0x00b9
        L_0x00d2:
            return r3
        L_0x00d3:
            int r3 = r2.getStatus()
            if (r3 != 0) goto L_0x00e7
            int r3 = r2.getCacheDuration()
            if (r3 <= r4) goto L_0x00e7
            admost.sdk.base.AdMostGenericRequest$1 r3 = new admost.sdk.base.AdMostGenericRequest$1
            r3.<init>(r2, r1, r8)
            android.os.AsyncTask.execute(r3)
        L_0x00e7:
            throw r0
        L_0x00e8:
            if (r2 != 0) goto L_0x00eb
            r0 = 1
        L_0x00eb:
            admost.sdk.model.AdMostBannerResponseBase r8 = r7.requestAndParse(r2, r1, r0, r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: admost.sdk.base.AdMostGenericRequest.processZoneRequest(java.lang.String[]):admost.sdk.model.AdMostBannerResponseBase");
    }

    private boolean putToCache(String str, JSONObject jSONObject, RequestType requestType2, int i) {
        if (str.equals("") || jSONObject == null || jSONObject.length() <= 0) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        int i2 = C02052.$SwitchMap$admost$sdk$base$AdMostGenericRequest$RequestType[requestType2.ordinal()];
        if (i2 != 2 && i2 != 10 && i2 != 17) {
            return false;
        }
        AdmostResponseCache admostResponseCache = new AdmostResponseCache(jSONObject, currentTimeMillis + ((long) (i * 1000)), requestType2, i);
        synchronized (cacheLock) {
            httpResponseCacheMap.put(str, admostResponseCache);
        }
        AdMostPreferences.getInstance().setResponseCache(str, admostResponseCache);
        return true;
    }

    private String read(InputStream inputStream) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    stringBuffer.append(readLine);
                    stringBuffer.append(13);
                } else {
                    bufferedReader.close();
                    return stringBuffer.toString();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00e8 A[SYNTHETIC, Splitter:B:28:0x00e8] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0112  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public admost.sdk.model.AdMostBannerResponseBase requestAndParse(admost.sdk.base.AdmostResponseCache r9, boolean r10, boolean r11, boolean r12) {
        /*
            r8 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "ZONE*"
            r0.append(r1)
            java.lang.String r1 = r8.zoneId
            r0.append(r1)
            java.lang.String r1 = "*EXP*"
            r0.append(r1)
            admost.sdk.base.AdMostExperimentManager r1 = admost.sdk.base.AdMostExperimentManager.getInstance()
            java.lang.String r1 = r1.getCurrentExperiment()
            r0.append(r1)
            java.lang.String r1 = "*GROUP*"
            r0.append(r1)
            admost.sdk.base.AdMostExperimentManager r1 = admost.sdk.base.AdMostExperimentManager.getInstance()
            java.lang.String r1 = r1.getCurrentGroup()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = 0
            java.net.URL r2 = new java.net.URL     // Catch:{ Exception -> 0x00df, all -> 0x00dd }
            java.lang.String r3 = r8.host     // Catch:{ Exception -> 0x00df, all -> 0x00dd }
            r2.<init>(r3)     // Catch:{ Exception -> 0x00df, all -> 0x00dd }
            java.net.URLConnection r2 = r2.openConnection()     // Catch:{ Exception -> 0x00df, all -> 0x00dd }
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ Exception -> 0x00df, all -> 0x00dd }
            int r3 = r8.timeOut     // Catch:{ Exception -> 0x00db }
            r2.setConnectTimeout(r3)     // Catch:{ Exception -> 0x00db }
            int r3 = r8.timeOut     // Catch:{ Exception -> 0x00db }
            r2.setReadTimeout(r3)     // Catch:{ Exception -> 0x00db }
            java.lang.String r3 = "Accept-Charset"
            java.lang.String r4 = "UTF-8"
            r2.setRequestProperty(r3, r4)     // Catch:{ Exception -> 0x00db }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00db }
            r3.<init>()     // Catch:{ Exception -> 0x00db }
            java.lang.String r4 = "Zone Request: "
            r3.append(r4)     // Catch:{ Exception -> 0x00db }
            java.net.URL r4 = r2.getURL()     // Catch:{ Exception -> 0x00db }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00db }
            r3.append(r4)     // Catch:{ Exception -> 0x00db }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00db }
            admost.sdk.base.AdMostLog.m294d(r3)     // Catch:{ Exception -> 0x00db }
            java.io.InputStream r3 = r2.getInputStream()     // Catch:{ Exception -> 0x00db }
            java.lang.String r3 = r8.read(r3)     // Catch:{ Exception -> 0x00db }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x00db }
            r4.<init>(r3)     // Catch:{ Exception -> 0x00db }
            boolean r5 = admost.sdk.base.AdMostLog.isIsHTTPLoggingEnabled()     // Catch:{ Exception -> 0x00db }
            java.lang.String r6 = " : "
            if (r5 == 0) goto L_0x00a1
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00db }
            r3.<init>()     // Catch:{ Exception -> 0x00db }
            admost.sdk.base.AdMostGenericRequest$RequestType r5 = r8.requestType     // Catch:{ Exception -> 0x00db }
            java.lang.String r5 = r5.name()     // Catch:{ Exception -> 0x00db }
            r3.append(r5)     // Catch:{ Exception -> 0x00db }
            r3.append(r6)     // Catch:{ Exception -> 0x00db }
            java.lang.String r5 = r8.host     // Catch:{ Exception -> 0x00db }
            r3.append(r5)     // Catch:{ Exception -> 0x00db }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00db }
            admost.sdk.base.AdMostLog.json((org.json.JSONObject) r4, (java.lang.String) r3)     // Catch:{ Exception -> 0x00db }
            goto L_0x00b8
        L_0x00a1:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00db }
            r5.<init>()     // Catch:{ Exception -> 0x00db }
            admost.sdk.base.AdMostGenericRequest$RequestType r7 = r8.requestType     // Catch:{ Exception -> 0x00db }
            r5.append(r7)     // Catch:{ Exception -> 0x00db }
            r5.append(r6)     // Catch:{ Exception -> 0x00db }
            r5.append(r3)     // Catch:{ Exception -> 0x00db }
            java.lang.String r3 = r5.toString()     // Catch:{ Exception -> 0x00db }
            admost.sdk.base.AdMostLog.m294d(r3)     // Catch:{ Exception -> 0x00db }
        L_0x00b8:
            int r3 = r8.getCacheDuration(r2)     // Catch:{ Exception -> 0x00db }
            if (r3 == 0) goto L_0x00c5
            int r3 = r8.getCacheDuration(r2)     // Catch:{ Exception -> 0x00db }
            int r3 = r3 + 60
            goto L_0x00c6
        L_0x00c5:
            r3 = 0
        L_0x00c6:
            if (r10 != 0) goto L_0x00cd
            admost.sdk.base.AdMostGenericRequest$RequestType r5 = admost.sdk.base.AdMostGenericRequest.RequestType.ZONE_RESPONSE     // Catch:{ Exception -> 0x00db }
            r8.putToCache(r0, r4, r5, r3)     // Catch:{ Exception -> 0x00db }
        L_0x00cd:
            admost.sdk.base.AdMostWaterfallStrategyManager r0 = admost.sdk.base.AdMostWaterfallStrategyManager.getInstance()     // Catch:{ Exception -> 0x00db }
            admost.sdk.model.AdMostBannerResponseBase r9 = r0.getBannerResponseObject(r4, r11, r12)     // Catch:{ Exception -> 0x00db }
            if (r2 == 0) goto L_0x00da
            r2.disconnect()
        L_0x00da:
            return r9
        L_0x00db:
            goto L_0x00e0
        L_0x00dd:
            r9 = move-exception
            goto L_0x0110
        L_0x00df:
            r2 = r1
        L_0x00e0:
            if (r9 != 0) goto L_0x00e8
            if (r2 == 0) goto L_0x00e7
            r2.disconnect()
        L_0x00e7:
            return r1
        L_0x00e8:
            org.json.JSONObject r9 = r9.getJsonObject()     // Catch:{ all -> 0x010e }
            if (r10 != 0) goto L_0x00fc
            admost.sdk.base.AdMostWaterfallStrategyManager r10 = admost.sdk.base.AdMostWaterfallStrategyManager.getInstance()     // Catch:{ Exception -> 0x0107 }
            admost.sdk.model.AdMostBannerResponseBase r9 = r10.getBannerResponseObject(r9, r11, r12)     // Catch:{ Exception -> 0x0107 }
            if (r2 == 0) goto L_0x00fb
            r2.disconnect()
        L_0x00fb:
            return r9
        L_0x00fc:
            admost.sdk.model.AdMostTestSuiteBannerResponse r10 = new admost.sdk.model.AdMostTestSuiteBannerResponse     // Catch:{ Exception -> 0x0107 }
            r10.<init>(r9, r11, r12)     // Catch:{ Exception -> 0x0107 }
            if (r2 == 0) goto L_0x0106
            r2.disconnect()
        L_0x0106:
            return r10
        L_0x0107:
            if (r2 == 0) goto L_0x010d
            r2.disconnect()
        L_0x010d:
            return r1
        L_0x010e:
            r9 = move-exception
            r1 = r2
        L_0x0110:
            if (r1 == 0) goto L_0x0115
            r1.disconnect()
        L_0x0115:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: admost.sdk.base.AdMostGenericRequest.requestAndParse(admost.sdk.base.AdmostResponseCache, boolean, boolean, boolean):admost.sdk.model.AdMostBannerResponseBase");
    }

    /* renamed from: go */
    public void mo611go(String... strArr) {
        try {
            if (AdMost.getInstance().isInitStarted()) {
                executeOnExecutor(AdMost.getInstance().getExecutor(), strArr);
            } else {
                execute(strArr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(T t) {
        AdmostResponseListener<T> admostResponseListener;
        if (!(t == null || (admostResponseListener = this.responseListener) == null)) {
            admostResponseListener.onResponse(t);
        }
        this.responseListener = null;
    }

    /* access modifiers changed from: protected */
    public T doInBackground(String... strArr) {
        switch (C02052.$SwitchMap$admost$sdk$base$AdMostGenericRequest$RequestType[this.requestType.ordinal()]) {
            case 1:
                return processCountryRequest();
            case 2:
                return processZoneRequest(strArr);
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 14:
            case 15:
            case 16:
                return processAnalyticsRequest(strArr);
            case 10:
                return processGenericRequest(strArr);
            case 11:
            case 19:
                return processBiddingWinLossRequest(strArr);
            case 12:
            case 13:
                return processSSVRequest(strArr);
            case 17:
                return processGenericRequest(strArr);
            case 18:
                return processBiddingRequest(strArr);
            case 20:
                return processCPRequest(strArr);
            default:
                return null;
        }
    }
}
