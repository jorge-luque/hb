package com.qumpara.offerwall.sdk.core;

import android.content.Context;
import android.os.AsyncTask;
import com.loopj.android.http.C4250c;
import com.qumpara.offerwall.sdk.core.QumparaOfferwallModels;
import com.qumpara.offerwall.sdk.listener.QumparaResponseListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import org.json.JSONObject;

public class QumparaGenericRequest<T> extends AsyncTask<String, Integer, T> {
    private static final String TAG = "QUMPARA_OFFERWALL";
    private String host;
    private RequestType requestType;
    private QumparaResponseListener<T> responseListener;
    private int timeOut;

    /* renamed from: com.qumpara.offerwall.sdk.core.QumparaGenericRequest$2 */
    static /* synthetic */ class C47502 {

        /* renamed from: $SwitchMap$com$qumpara$offerwall$sdk$core$QumparaGenericRequest$RequestType */
        static final /* synthetic */ int[] f12875x7ee07d27;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.qumpara.offerwall.sdk.core.QumparaGenericRequest$RequestType[] r0 = com.qumpara.offerwall.sdk.core.QumparaGenericRequest.RequestType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f12875x7ee07d27 = r0
                com.qumpara.offerwall.sdk.core.QumparaGenericRequest$RequestType r1 = com.qumpara.offerwall.sdk.core.QumparaGenericRequest.RequestType.GET_OFFERWALL_REQUEST     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f12875x7ee07d27     // Catch:{ NoSuchFieldError -> 0x001d }
                com.qumpara.offerwall.sdk.core.QumparaGenericRequest$RequestType r1 = com.qumpara.offerwall.sdk.core.QumparaGenericRequest.RequestType.GET_OFFERWALL_ITEM_DETAIL_REQUEST     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f12875x7ee07d27     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.qumpara.offerwall.sdk.core.QumparaGenericRequest$RequestType r1 = com.qumpara.offerwall.sdk.core.QumparaGenericRequest.RequestType.POST_OFFERWALL_SEND_ENGAGEMENT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f12875x7ee07d27     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.qumpara.offerwall.sdk.core.QumparaGenericRequest$RequestType r1 = com.qumpara.offerwall.sdk.core.QumparaGenericRequest.RequestType.POST_OFFERWALL_REDEEM_CODE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f12875x7ee07d27     // Catch:{ NoSuchFieldError -> 0x003e }
                com.qumpara.offerwall.sdk.core.QumparaGenericRequest$RequestType r1 = com.qumpara.offerwall.sdk.core.QumparaGenericRequest.RequestType.POST_OFFERWALL_SPEND_VIRTUAL_CURRENCY     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f12875x7ee07d27     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.qumpara.offerwall.sdk.core.QumparaGenericRequest$RequestType r1 = com.qumpara.offerwall.sdk.core.QumparaGenericRequest.RequestType.POST_OFFERWALL_COUNT_DATA     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qumpara.offerwall.sdk.core.QumparaGenericRequest.C47502.<clinit>():void");
        }
    }

    private static class QumparaOfferwallException extends Exception {
        public QumparaOfferwallException() {
        }

        public QumparaOfferwallException(String str) {
            super(str);
        }
    }

    public enum RequestType {
        GET_OFFERWALL_REQUEST,
        GET_OFFERWALL_ITEM_DETAIL_REQUEST,
        POST_OFFERWALL_SEND_ENGAGEMENT,
        POST_OFFERWALL_REDEEM_CODE,
        POST_OFFERWALL_SPEND_VIRTUAL_CURRENCY,
        POST_OFFERWALL_COUNT_DATA
    }

    public QumparaGenericRequest(RequestType requestType2, QumparaResponseListener<T> qumparaResponseListener) {
        this.requestType = requestType2;
        this.timeOut = getTimeoutValue(requestType2);
        this.host = getHost(requestType2);
        this.responseListener = qumparaResponseListener;
    }

    private String getHost(RequestType requestType2) {
        switch (C47502.f12875x7ee07d27[requestType2.ordinal()]) {
            case 1:
            case 2:
                return QumparaOfferwallUtil.QUMPARA_BASE + QumparaOfferwallUtil.QUMPARA_SUFFIX_GET_CAMPAIGNS;
            case 3:
                return QumparaOfferwallUtil.QUMPARA_BASE + QumparaOfferwallUtil.QUMPARA_SUFFIX_POST_ENGAGE;
            case 4:
                return QumparaOfferwallUtil.QUMPARA_BASE + QumparaOfferwallUtil.QUMPARA_SUFFIX_POST_REDEEM;
            case 5:
                return QumparaOfferwallUtil.QUMPARA_BASE + QumparaOfferwallUtil.QUMPARA_SUFFIX_POST_SPEND_VIRTUAL_CURRENCY;
            case 6:
                return "http://ow-api.fisicek.com/v1/count";
            default:
                return "";
        }
    }

    private int getTimeoutValue(RequestType requestType2) {
        int i = C47502.f12875x7ee07d27[requestType2.ordinal()];
        return 15000;
    }

    /* JADX WARNING: type inference failed for: r4v3, types: [java.net.URLConnection] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01e9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.json.JSONObject makeGetRequest(com.qumpara.offerwall.sdk.core.QumparaGenericRequest.RequestType r17, com.qumpara.offerwall.sdk.core.QumparaOfferwallResponseCache r18, java.lang.String... r19) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            r2 = r19
            java.lang.String r3 = "UTF-8"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Qumpara "
            r4.append(r5)
            java.lang.String r5 = r17.name()
            r4.append(r5)
            java.lang.String r5 = " request is being sent to the server."
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.qumpara.offerwall.sdk.core.QumparaOfferwallLog.m16490i(r4)
            java.lang.String r8 = "Error: No fill error."
            r4 = 100
            r9 = 0
            if (r2 != 0) goto L_0x0037
            com.qumpara.offerwall.sdk.core.QumparaOfferwallModels$QumparaOfferwallError r0 = new com.qumpara.offerwall.sdk.core.QumparaOfferwallModels$QumparaOfferwallError     // Catch:{ Exception -> 0x01c3, all -> 0x01c1 }
            java.lang.String r2 = "GET_OFFERWALL_REQUEST parameters null"
            r0.<init>(r4, r2)     // Catch:{ Exception -> 0x01c3, all -> 0x01c1 }
            r1.onError(r0)     // Catch:{ Exception -> 0x01c3, all -> 0x01c1 }
            return r9
        L_0x0037:
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x01c3, all -> 0x01c1 }
            com.qumpara.offerwall.sdk.core.QumparaGenericRequest$RequestType r7 = com.qumpara.offerwall.sdk.core.QumparaGenericRequest.RequestType.GET_OFFERWALL_REQUEST     // Catch:{ Exception -> 0x01c3, all -> 0x01c1 }
            r10 = 1
            r11 = 0
            if (r0 != r7) goto L_0x0068
            int r7 = r2.length     // Catch:{ Exception -> 0x01c3, all -> 0x01c1 }
            if (r7 == r10) goto L_0x004f
            com.qumpara.offerwall.sdk.core.QumparaOfferwallModels$QumparaOfferwallError r0 = new com.qumpara.offerwall.sdk.core.QumparaOfferwallModels$QumparaOfferwallError     // Catch:{ Exception -> 0x01c3, all -> 0x01c1 }
            java.lang.String r2 = "GET_OFFERWALL_REQUEST parameter error"
            r0.<init>(r4, r2)     // Catch:{ Exception -> 0x01c3, all -> 0x01c1 }
            r1.onError(r0)     // Catch:{ Exception -> 0x01c3, all -> 0x01c1 }
            return r9
        L_0x004f:
            java.net.URL r7 = new java.net.URL     // Catch:{ Exception -> 0x01c3, all -> 0x01c1 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01c3, all -> 0x01c1 }
            r10.<init>()     // Catch:{ Exception -> 0x01c3, all -> 0x01c1 }
            java.lang.String r12 = r1.host     // Catch:{ Exception -> 0x01c3, all -> 0x01c1 }
            r10.append(r12)     // Catch:{ Exception -> 0x01c3, all -> 0x01c1 }
            r12 = r2[r11]     // Catch:{ Exception -> 0x01c3, all -> 0x01c1 }
            r10.append(r12)     // Catch:{ Exception -> 0x01c3, all -> 0x01c1 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x01c3, all -> 0x01c1 }
            r7.<init>(r10)     // Catch:{ Exception -> 0x01c3, all -> 0x01c1 }
            goto L_0x009f
        L_0x0068:
            com.qumpara.offerwall.sdk.core.QumparaGenericRequest$RequestType r7 = com.qumpara.offerwall.sdk.core.QumparaGenericRequest.RequestType.GET_OFFERWALL_ITEM_DETAIL_REQUEST     // Catch:{ Exception -> 0x01c3, all -> 0x01c1 }
            if (r0 != r7) goto L_0x009e
            int r7 = r2.length     // Catch:{ Exception -> 0x01c3, all -> 0x01c1 }
            r12 = 2
            if (r7 == r12) goto L_0x007b
            com.qumpara.offerwall.sdk.core.QumparaOfferwallModels$QumparaOfferwallError r0 = new com.qumpara.offerwall.sdk.core.QumparaOfferwallModels$QumparaOfferwallError     // Catch:{ Exception -> 0x01c3, all -> 0x01c1 }
            java.lang.String r2 = "GET_OFFERWALL_ITEM_DETAIL_REQUEST parameter error"
            r0.<init>(r4, r2)     // Catch:{ Exception -> 0x01c3, all -> 0x01c1 }
            r1.onError(r0)     // Catch:{ Exception -> 0x01c3, all -> 0x01c1 }
            return r9
        L_0x007b:
            java.net.URL r7 = new java.net.URL     // Catch:{ Exception -> 0x01c3, all -> 0x01c1 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01c3, all -> 0x01c1 }
            r12.<init>()     // Catch:{ Exception -> 0x01c3, all -> 0x01c1 }
            java.lang.String r13 = r1.host     // Catch:{ Exception -> 0x01c3, all -> 0x01c1 }
            r12.append(r13)     // Catch:{ Exception -> 0x01c3, all -> 0x01c1 }
            r13 = r2[r11]     // Catch:{ Exception -> 0x01c3, all -> 0x01c1 }
            r12.append(r13)     // Catch:{ Exception -> 0x01c3, all -> 0x01c1 }
            java.lang.String r13 = "/id/"
            r12.append(r13)     // Catch:{ Exception -> 0x01c3, all -> 0x01c1 }
            r10 = r2[r10]     // Catch:{ Exception -> 0x01c3, all -> 0x01c1 }
            r12.append(r10)     // Catch:{ Exception -> 0x01c3, all -> 0x01c1 }
            java.lang.String r10 = r12.toString()     // Catch:{ Exception -> 0x01c3, all -> 0x01c1 }
            r7.<init>(r10)     // Catch:{ Exception -> 0x01c3, all -> 0x01c1 }
            goto L_0x009f
        L_0x009e:
            r7 = r9
        L_0x009f:
            if (r7 != 0) goto L_0x00ac
            com.qumpara.offerwall.sdk.core.QumparaOfferwallModels$QumparaOfferwallError r0 = new com.qumpara.offerwall.sdk.core.QumparaOfferwallModels$QumparaOfferwallError     // Catch:{ Exception -> 0x01c3, all -> 0x01c1 }
            java.lang.String r2 = "URL is null"
            r0.<init>(r4, r2)     // Catch:{ Exception -> 0x01c3, all -> 0x01c1 }
            r1.onError(r0)     // Catch:{ Exception -> 0x01c3, all -> 0x01c1 }
            return r9
        L_0x00ac:
            java.net.URLConnection r4 = r7.openConnection()     // Catch:{ Exception -> 0x01c3, all -> 0x01c1 }
            r10 = r4
            java.net.HttpURLConnection r10 = (java.net.HttpURLConnection) r10     // Catch:{ Exception -> 0x01c3, all -> 0x01c1 }
            int r4 = r1.timeOut     // Catch:{ Exception -> 0x01bf }
            r10.setConnectTimeout(r4)     // Catch:{ Exception -> 0x01bf }
            int r4 = r1.timeOut     // Catch:{ Exception -> 0x01bf }
            r10.setReadTimeout(r4)     // Catch:{ Exception -> 0x01bf }
            java.lang.String r4 = "Accept-Charset"
            r10.setRequestProperty(r4, r3)     // Catch:{ Exception -> 0x01bf }
            java.lang.String r4 = "Content-Language"
            java.lang.String r7 = "tr-TR"
            r10.setRequestProperty(r4, r7)     // Catch:{ Exception -> 0x01bf }
            java.lang.String r4 = "GET"
            r10.setRequestMethod(r4)     // Catch:{ Exception -> 0x01bf }
            int r4 = r10.getResponseCode()     // Catch:{ Exception -> 0x01bf }
            r7 = 200(0xc8, float:2.8E-43)
            if (r4 != r7) goto L_0x0184
            java.io.BufferedInputStream r4 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x01bf }
            java.io.InputStream r5 = r10.getInputStream()     // Catch:{ Exception -> 0x01bf }
            r4.<init>(r5)     // Catch:{ Exception -> 0x01bf }
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ Exception -> 0x01bf }
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x01bf }
            r6.<init>(r4, r3)     // Catch:{ Exception -> 0x01bf }
            r5.<init>(r6)     // Catch:{ Exception -> 0x01bf }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01bf }
            r3.<init>()     // Catch:{ Exception -> 0x01bf }
        L_0x00ee:
            java.lang.String r6 = r5.readLine()     // Catch:{ Exception -> 0x01bf }
            if (r6 == 0) goto L_0x00f8
            r3.append(r6)     // Catch:{ Exception -> 0x01bf }
            goto L_0x00ee
        L_0x00f8:
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x01bf }
            r4.close()     // Catch:{ Exception -> 0x01bf }
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ Exception -> 0x01bf }
            r12.<init>(r3)     // Catch:{ Exception -> 0x01bf }
            com.qumpara.offerwall.sdk.core.QumparaGenericRequest$RequestType r3 = com.qumpara.offerwall.sdk.core.QumparaGenericRequest.RequestType.GET_OFFERWALL_REQUEST     // Catch:{ Exception -> 0x01bf }
            if (r0 != r3) goto L_0x011d
            java.lang.String r3 = "campaigns"
            org.json.JSONArray r3 = r12.optJSONArray(r3)     // Catch:{ Exception -> 0x01bf }
            if (r3 == 0) goto L_0x0117
            int r3 = r3.length()     // Catch:{ Exception -> 0x01bf }
            if (r3 <= 0) goto L_0x0117
            goto L_0x011d
        L_0x0117:
            com.qumpara.offerwall.sdk.core.QumparaGenericRequest$QumparaOfferwallException r0 = new com.qumpara.offerwall.sdk.core.QumparaGenericRequest$QumparaOfferwallException     // Catch:{ Exception -> 0x01bf }
            r0.<init>(r8)     // Catch:{ Exception -> 0x01bf }
            throw r0     // Catch:{ Exception -> 0x01bf }
        L_0x011d:
            int r13 = com.qumpara.offerwall.sdk.core.QumparaOfferwallResponseCache.getCacheDurationFromHeader(r10)     // Catch:{ Exception -> 0x01bf }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x01bf }
            int r5 = r13 * 1000
            long r5 = (long) r5     // Catch:{ Exception -> 0x01bf }
            long r14 = r3 + r5
            if (r13 <= 0) goto L_0x0139
            java.lang.String r2 = com.qumpara.offerwall.sdk.core.QumparaOfferwallResponseCache.getCacheKey(r0, r2)     // Catch:{ Exception -> 0x01bf }
            r3 = r12
            r4 = r17
            r5 = r13
            r6 = r14
            boolean r11 = com.qumpara.offerwall.sdk.core.QumparaOfferwallResponseCache.putToCache(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x01bf }
        L_0x0139:
            if (r11 == 0) goto L_0x0161
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01bf }
            r2.<init>()     // Catch:{ Exception -> 0x01bf }
            java.lang.String r3 = "Qumpara Offerwall "
            r2.append(r3)     // Catch:{ Exception -> 0x01bf }
            java.lang.String r0 = r17.name()     // Catch:{ Exception -> 0x01bf }
            r2.append(r0)     // Catch:{ Exception -> 0x01bf }
            java.lang.String r0 = " request has recently made and the response is cached. It will expire after "
            r2.append(r0)     // Catch:{ Exception -> 0x01bf }
            r2.append(r13)     // Catch:{ Exception -> 0x01bf }
            java.lang.String r0 = " s."
            r2.append(r0)     // Catch:{ Exception -> 0x01bf }
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x01bf }
            com.qumpara.offerwall.sdk.core.QumparaOfferwallLog.m16490i(r0)     // Catch:{ Exception -> 0x01bf }
            goto L_0x017e
        L_0x0161:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01bf }
            r2.<init>()     // Catch:{ Exception -> 0x01bf }
            java.lang.String r3 = "ERROR: Qumpara Offerwall "
            r2.append(r3)     // Catch:{ Exception -> 0x01bf }
            java.lang.String r0 = r17.name()     // Catch:{ Exception -> 0x01bf }
            r2.append(r0)     // Catch:{ Exception -> 0x01bf }
            java.lang.String r0 = " request has recently made and the response is not cached."
            r2.append(r0)     // Catch:{ Exception -> 0x01bf }
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x01bf }
            com.qumpara.offerwall.sdk.core.QumparaOfferwallLog.m16490i(r0)     // Catch:{ Exception -> 0x01bf }
        L_0x017e:
            if (r10 == 0) goto L_0x0183
            r10.disconnect()
        L_0x0183:
            return r12
        L_0x0184:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01bf }
            r0.<init>()     // Catch:{ Exception -> 0x01bf }
            java.lang.String r2 = "Response Time:"
            r0.append(r2)     // Catch:{ Exception -> 0x01bf }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x01bf }
            long r2 = r2 - r5
            r0.append(r2)     // Catch:{ Exception -> 0x01bf }
            java.lang.String r2 = " ms. HTTP Error Code: "
            r0.append(r2)     // Catch:{ Exception -> 0x01bf }
            int r2 = r10.getResponseCode()     // Catch:{ Exception -> 0x01bf }
            r0.append(r2)     // Catch:{ Exception -> 0x01bf }
            java.lang.String r2 = " "
            r0.append(r2)     // Catch:{ Exception -> 0x01bf }
            java.net.URL r2 = r10.getURL()     // Catch:{ Exception -> 0x01bf }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x01bf }
            r0.append(r2)     // Catch:{ Exception -> 0x01bf }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x01bf }
            com.qumpara.offerwall.sdk.core.QumparaOfferwallLog.m16485d(r0)     // Catch:{ Exception -> 0x01bf }
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ Exception -> 0x01bf }
            r0.<init>()     // Catch:{ Exception -> 0x01bf }
            throw r0     // Catch:{ Exception -> 0x01bf }
        L_0x01bf:
            r0 = move-exception
            goto L_0x01c5
        L_0x01c1:
            r0 = move-exception
            goto L_0x01e7
        L_0x01c3:
            r0 = move-exception
            r10 = r9
        L_0x01c5:
            boolean r0 = r0 instanceof com.qumpara.offerwall.sdk.core.QumparaGenericRequest.QumparaOfferwallException     // Catch:{ all -> 0x01e5 }
            if (r0 != 0) goto L_0x01d5
            if (r18 == 0) goto L_0x01d5
            org.json.JSONObject r0 = r18.getJsonObject()     // Catch:{ all -> 0x01e5 }
            if (r10 == 0) goto L_0x01d4
            r10.disconnect()
        L_0x01d4:
            return r0
        L_0x01d5:
            com.qumpara.offerwall.sdk.core.QumparaOfferwallModels$QumparaOfferwallError r0 = new com.qumpara.offerwall.sdk.core.QumparaOfferwallModels$QumparaOfferwallError     // Catch:{ all -> 0x01e5 }
            r2 = 1000(0x3e8, float:1.401E-42)
            r0.<init>(r2, r8)     // Catch:{ all -> 0x01e5 }
            r1.onError(r0)     // Catch:{ all -> 0x01e5 }
            if (r10 == 0) goto L_0x01e4
            r10.disconnect()
        L_0x01e4:
            return r9
        L_0x01e5:
            r0 = move-exception
            r9 = r10
        L_0x01e7:
            if (r9 == 0) goto L_0x01ec
            r9.disconnect()
        L_0x01ec:
            goto L_0x01ee
        L_0x01ed:
            throw r0
        L_0x01ee:
            goto L_0x01ed
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qumpara.offerwall.sdk.core.QumparaGenericRequest.makeGetRequest(com.qumpara.offerwall.sdk.core.QumparaGenericRequest$RequestType, com.qumpara.offerwall.sdk.core.QumparaOfferwallResponseCache, java.lang.String[]):org.json.JSONObject");
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0127  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.json.JSONObject makePostRequest(com.qumpara.offerwall.sdk.core.QumparaGenericRequest.RequestType r9, java.lang.String... r10) {
        /*
            r8 = this;
            java.lang.String r0 = "UTF-8"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Qumpara "
            r1.append(r2)
            java.lang.String r2 = r9.name()
            r1.append(r2)
            java.lang.String r2 = " request is being sent to the server."
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.qumpara.offerwall.sdk.core.QumparaOfferwallLog.m16490i(r1)
            r1 = 0
            r2 = 0
            r10 = r10[r1]     // Catch:{ Exception -> 0x010a, all -> 0x0108 }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x010a, all -> 0x0108 }
            java.net.URL r5 = new java.net.URL     // Catch:{ Exception -> 0x010a, all -> 0x0108 }
            java.lang.String r6 = r8.host     // Catch:{ Exception -> 0x010a, all -> 0x0108 }
            r5.<init>(r6)     // Catch:{ Exception -> 0x010a, all -> 0x0108 }
            java.net.URLConnection r5 = r5.openConnection()     // Catch:{ Exception -> 0x010a, all -> 0x0108 }
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ Exception -> 0x010a, all -> 0x0108 }
            int r6 = r8.timeOut     // Catch:{ Exception -> 0x0106 }
            r5.setConnectTimeout(r6)     // Catch:{ Exception -> 0x0106 }
            int r6 = r8.timeOut     // Catch:{ Exception -> 0x0106 }
            r5.setReadTimeout(r6)     // Catch:{ Exception -> 0x0106 }
            java.lang.String r6 = "POST"
            r5.setRequestMethod(r6)     // Catch:{ Exception -> 0x0106 }
            java.lang.String r6 = "Content-Type"
            java.lang.String r7 = "application/json"
            r5.setRequestProperty(r6, r7)     // Catch:{ Exception -> 0x0106 }
            java.lang.String r6 = "Accept-Charset"
            r5.setRequestProperty(r6, r0)     // Catch:{ Exception -> 0x0106 }
            java.lang.String r6 = "Content-Length"
            byte[] r7 = r10.getBytes()     // Catch:{ Exception -> 0x0106 }
            int r7 = r7.length     // Catch:{ Exception -> 0x0106 }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x0106 }
            r5.setRequestProperty(r6, r7)     // Catch:{ Exception -> 0x0106 }
            java.lang.String r6 = "Accept-Language"
            java.util.Locale r7 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x006f }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x006f }
            java.lang.String r7 = r7.toLowerCase()     // Catch:{ Exception -> 0x006f }
            r5.setRequestProperty(r6, r7)     // Catch:{ Exception -> 0x006f }
            goto L_0x0073
        L_0x006f:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ Exception -> 0x0106 }
        L_0x0073:
            r5.setUseCaches(r1)     // Catch:{ Exception -> 0x0106 }
            r1 = 1
            r5.setDoInput(r1)     // Catch:{ Exception -> 0x0106 }
            r5.setDoOutput(r1)     // Catch:{ Exception -> 0x0106 }
            java.io.DataOutputStream r1 = new java.io.DataOutputStream     // Catch:{ Exception -> 0x0106 }
            java.io.OutputStream r6 = r5.getOutputStream()     // Catch:{ Exception -> 0x0106 }
            r1.<init>(r6)     // Catch:{ Exception -> 0x0106 }
            byte[] r10 = r10.getBytes(r0)     // Catch:{ Exception -> 0x0106 }
            r1.write(r10)     // Catch:{ Exception -> 0x0106 }
            r1.flush()     // Catch:{ Exception -> 0x0106 }
            r1.close()     // Catch:{ Exception -> 0x0106 }
            int r10 = r5.getResponseCode()     // Catch:{ Exception -> 0x0106 }
            r0 = 200(0xc8, float:2.8E-43)
            if (r10 == r0) goto L_0x00da
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0106 }
            r9.<init>()     // Catch:{ Exception -> 0x0106 }
            java.lang.String r10 = "Response Time:"
            r9.append(r10)     // Catch:{ Exception -> 0x0106 }
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0106 }
            long r0 = r0 - r3
            r9.append(r0)     // Catch:{ Exception -> 0x0106 }
            java.lang.String r10 = " ms. HTTP Error Code: "
            r9.append(r10)     // Catch:{ Exception -> 0x0106 }
            int r10 = r5.getResponseCode()     // Catch:{ Exception -> 0x0106 }
            r9.append(r10)     // Catch:{ Exception -> 0x0106 }
            java.lang.String r10 = " "
            r9.append(r10)     // Catch:{ Exception -> 0x0106 }
            java.net.URL r10 = r5.getURL()     // Catch:{ Exception -> 0x0106 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x0106 }
            r9.append(r10)     // Catch:{ Exception -> 0x0106 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0106 }
            com.qumpara.offerwall.sdk.core.QumparaOfferwallLog.m16485d(r9)     // Catch:{ Exception -> 0x0106 }
            org.json.JSONObject r9 = r8.readHttpErrorBody(r5)     // Catch:{ Exception -> 0x0106 }
            if (r5 == 0) goto L_0x00d9
            r5.disconnect()
        L_0x00d9:
            return r9
        L_0x00da:
            java.io.InputStream r10 = r5.getInputStream()     // Catch:{ Exception -> 0x0106 }
            java.lang.String r10 = r8.read(r10)     // Catch:{ Exception -> 0x0106 }
            com.qumpara.offerwall.sdk.core.QumparaGenericRequest$RequestType r0 = com.qumpara.offerwall.sdk.core.QumparaGenericRequest.RequestType.POST_OFFERWALL_COUNT_DATA     // Catch:{ Exception -> 0x0106 }
            if (r9 != r0) goto L_0x00fb
            java.lang.String r9 = "OK"
            boolean r9 = r10.contains(r9)     // Catch:{ Exception -> 0x0106 }
            if (r9 == 0) goto L_0x00fb
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x0106 }
            java.lang.String r10 = "{\"resp\":\"ok\"}"
            r9.<init>(r10)     // Catch:{ Exception -> 0x0106 }
            if (r5 == 0) goto L_0x00fa
            r5.disconnect()
        L_0x00fa:
            return r9
        L_0x00fb:
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x0106 }
            r9.<init>(r10)     // Catch:{ Exception -> 0x0106 }
            if (r5 == 0) goto L_0x0105
            r5.disconnect()
        L_0x0105:
            return r9
        L_0x0106:
            r9 = move-exception
            goto L_0x010c
        L_0x0108:
            r9 = move-exception
            goto L_0x0125
        L_0x010a:
            r9 = move-exception
            r5 = r2
        L_0x010c:
            r9.printStackTrace()     // Catch:{ all -> 0x0123 }
            com.qumpara.offerwall.sdk.core.QumparaOfferwallModels$QumparaOfferwallError r10 = new com.qumpara.offerwall.sdk.core.QumparaOfferwallModels$QumparaOfferwallError     // Catch:{ all -> 0x0123 }
            r0 = 100
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x0123 }
            r10.<init>(r0, r9)     // Catch:{ all -> 0x0123 }
            r8.onError(r10)     // Catch:{ all -> 0x0123 }
            if (r5 == 0) goto L_0x0122
            r5.disconnect()
        L_0x0122:
            return r2
        L_0x0123:
            r9 = move-exception
            r2 = r5
        L_0x0125:
            if (r2 == 0) goto L_0x012a
            r2.disconnect()
        L_0x012a:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qumpara.offerwall.sdk.core.QumparaGenericRequest.makePostRequest(com.qumpara.offerwall.sdk.core.QumparaGenericRequest$RequestType, java.lang.String[]):org.json.JSONObject");
    }

    private void onError(QumparaOfferwallModels.QumparaOfferwallError qumparaOfferwallError) {
        QumparaResponseListener<T> qumparaResponseListener = this.responseListener;
        if (qumparaResponseListener != null) {
            qumparaResponseListener.onError(qumparaOfferwallError);
        }
    }

    private JSONObject processGetRequest(final RequestType requestType2, final String... strArr) {
        C47491 r2;
        final QumparaOfferwallResponseCache fromCache = QumparaOfferwallResponseCache.getFromCache(requestType2, strArr);
        JSONObject jSONObject = null;
        if (fromCache == null || fromCache.getStatus() == -1) {
            return makeGetRequest(requestType2, (QumparaOfferwallResponseCache) null, strArr);
        }
        try {
            jSONObject = fromCache.getJsonObject();
            long expireAt = fromCache.getExpireAt() - System.currentTimeMillis();
            QumparaOfferwallLog.m16490i("Qumpara " + requestType2.name() + " request retrieved from cache. Cache will expire after " + (expireAt / 1000) + " s.");
            if (fromCache.getStatus() == 0) {
                r2 = new Runnable() {
                    public void run() {
                        QumparaOfferwallLog.m16490i("Response from cache(status 0). Request was send to the server for fast response ");
                        JSONObject unused = QumparaGenericRequest.this.makeGetRequest(requestType2, fromCache, strArr);
                    }
                };
                AsyncTask.execute(r2);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (fromCache.getStatus() == 0) {
                r2 = new Runnable() {
                    public void run() {
                        QumparaOfferwallLog.m16490i("Response from cache(status 0). Request was send to the server for fast response ");
                        JSONObject unused = QumparaGenericRequest.this.makeGetRequest(requestType2, fromCache, strArr);
                    }
                };
            }
        } catch (Throwable th) {
            if (fromCache.getStatus() == 0) {
                AsyncTask.execute(new Runnable() {
                    public void run() {
                        QumparaOfferwallLog.m16490i("Response from cache(status 0). Request was send to the server for fast response ");
                        JSONObject unused = QumparaGenericRequest.this.makeGetRequest(requestType2, fromCache, strArr);
                    }
                });
            }
            throw th;
        }
        return jSONObject;
    }

    private JSONObject processPostRequest(RequestType requestType2, String... strArr) {
        return makePostRequest(requestType2, strArr);
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

    /* renamed from: go */
    public void mo30065go(Context context, String... strArr) {
        if (QumparaOfferwallPreferences.getInstance(context).getExecutor() != null) {
            executeOnExecutor(QumparaOfferwallPreferences.getInstance(context).getExecutor(), strArr);
        } else {
            execute(strArr);
        }
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(T t) {
        QumparaResponseListener<T> qumparaResponseListener = this.responseListener;
        if (!(qumparaResponseListener == null || t == null)) {
            qumparaResponseListener.onResponse(t);
        }
        this.responseListener = null;
    }

    /* access modifiers changed from: package-private */
    public JSONObject readHttpErrorBody(HttpURLConnection httpURLConnection) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new BufferedInputStream(httpURLConnection.getErrorStream()), C4250c.DEFAULT_CHARSET));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    QumparaOfferwallLog.m16490i(this.requestType.name() + " : " + sb.toString());
                    JSONObject optJSONObject = new JSONObject(sb.toString()).optJSONObject("error");
                    onError(new QumparaOfferwallModels.QumparaOfferwallError(optJSONObject.optInt("code", 100), optJSONObject.optString("message", "Error: Local SDK error.")));
                    return null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            onError(new QumparaOfferwallModels.QumparaOfferwallError(100, e.getMessage()));
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public T doInBackground(String... strArr) {
        switch (C47502.f12875x7ee07d27[this.requestType.ordinal()]) {
            case 1:
                return processGetRequest(RequestType.GET_OFFERWALL_REQUEST, strArr);
            case 2:
                return processGetRequest(RequestType.GET_OFFERWALL_ITEM_DETAIL_REQUEST, strArr);
            case 3:
                return processPostRequest(RequestType.POST_OFFERWALL_SEND_ENGAGEMENT, strArr);
            case 4:
                return processPostRequest(RequestType.POST_OFFERWALL_REDEEM_CODE, strArr);
            case 5:
                return processPostRequest(RequestType.POST_OFFERWALL_SPEND_VIRTUAL_CURRENCY, strArr);
            case 6:
                return processPostRequest(RequestType.POST_OFFERWALL_COUNT_DATA, strArr);
            default:
                return null;
        }
    }
}
