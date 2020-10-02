package com.qumpara.analytics;

import android.os.AsyncTask;
import com.loopj.android.http.C4250c;
import com.qumpara.analytics.model.QumparaAnalyticsError;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import org.json.JSONObject;

public class QumparaAnalyticsRequest<T> extends AsyncTask<String, Integer, T> {
    private static final String EVENT_URL = "https://ow-api.fisicek.com/v2/events";
    private String host;
    private RequestType requestType;
    private QumparaAnalyticsResponseListener<T> responseListener;
    private int timeOut;

    /* renamed from: com.qumpara.analytics.QumparaAnalyticsRequest$1 */
    static /* synthetic */ class C47451 {

        /* renamed from: $SwitchMap$com$qumpara$analytics$QumparaAnalyticsRequest$RequestType */
        static final /* synthetic */ int[] f12872xe6e439db;

        static {
            int[] iArr = new int[RequestType.values().length];
            f12872xe6e439db = iArr;
            try {
                iArr[RequestType.POST_EVENT_DATA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public enum RequestType {
        POST_EVENT_DATA
    }

    public QumparaAnalyticsRequest(RequestType requestType2, QumparaAnalyticsResponseListener<T> qumparaAnalyticsResponseListener) {
        this.requestType = requestType2;
        this.timeOut = getTimeoutValue(requestType2);
        this.host = getHost(requestType2);
        this.responseListener = qumparaAnalyticsResponseListener;
    }

    private String getHost(RequestType requestType2) {
        return C47451.f12872xe6e439db[requestType2.ordinal()] != 1 ? "" : EVENT_URL;
    }

    private int getTimeoutValue(RequestType requestType2) {
        int i = C47451.f12872xe6e439db[requestType2.ordinal()];
        return 15000;
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x012f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.json.JSONObject makePostRequest(com.qumpara.analytics.QumparaAnalyticsRequest.RequestType r9, java.lang.String... r10) {
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
            r1.toString()
            r1 = 0
            r2 = 0
            r10 = r10[r1]     // Catch:{ Exception -> 0x0112, all -> 0x0110 }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0112, all -> 0x0110 }
            java.net.URL r5 = new java.net.URL     // Catch:{ Exception -> 0x0112, all -> 0x0110 }
            java.lang.String r6 = r8.host     // Catch:{ Exception -> 0x0112, all -> 0x0110 }
            r5.<init>(r6)     // Catch:{ Exception -> 0x0112, all -> 0x0110 }
            java.net.URLConnection r5 = r5.openConnection()     // Catch:{ Exception -> 0x0112, all -> 0x0110 }
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ Exception -> 0x0112, all -> 0x0110 }
            int r6 = r8.timeOut     // Catch:{ Exception -> 0x010e }
            r5.setConnectTimeout(r6)     // Catch:{ Exception -> 0x010e }
            int r6 = r8.timeOut     // Catch:{ Exception -> 0x010e }
            r5.setReadTimeout(r6)     // Catch:{ Exception -> 0x010e }
            java.lang.String r6 = "POST"
            r5.setRequestMethod(r6)     // Catch:{ Exception -> 0x010e }
            java.lang.String r6 = "Content-Type"
            java.lang.String r7 = "application/json"
            r5.setRequestProperty(r6, r7)     // Catch:{ Exception -> 0x010e }
            java.lang.String r6 = "Accept-Charset"
            r5.setRequestProperty(r6, r0)     // Catch:{ Exception -> 0x010e }
            java.lang.String r6 = "Content-Length"
            byte[] r7 = r10.getBytes()     // Catch:{ Exception -> 0x010e }
            int r7 = r7.length     // Catch:{ Exception -> 0x010e }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x010e }
            r5.setRequestProperty(r6, r7)     // Catch:{ Exception -> 0x010e }
            java.lang.String r6 = "Accept-Language"
            java.util.Locale r7 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x006b }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x006b }
            java.lang.String r7 = r7.toLowerCase()     // Catch:{ Exception -> 0x006b }
            r5.setRequestProperty(r6, r7)     // Catch:{ Exception -> 0x006b }
            goto L_0x006f
        L_0x006b:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ Exception -> 0x010e }
        L_0x006f:
            r5.setUseCaches(r1)     // Catch:{ Exception -> 0x010e }
            r1 = 1
            r5.setDoInput(r1)     // Catch:{ Exception -> 0x010e }
            r5.setDoOutput(r1)     // Catch:{ Exception -> 0x010e }
            java.io.DataOutputStream r1 = new java.io.DataOutputStream     // Catch:{ Exception -> 0x010e }
            java.io.OutputStream r6 = r5.getOutputStream()     // Catch:{ Exception -> 0x010e }
            r1.<init>(r6)     // Catch:{ Exception -> 0x010e }
            byte[] r10 = r10.getBytes(r0)     // Catch:{ Exception -> 0x010e }
            r1.write(r10)     // Catch:{ Exception -> 0x010e }
            r1.flush()     // Catch:{ Exception -> 0x010e }
            r1.close()     // Catch:{ Exception -> 0x010e }
            int r10 = r5.getResponseCode()     // Catch:{ Exception -> 0x010e }
            r0 = 200(0xc8, float:2.8E-43)
            if (r10 == r0) goto L_0x00ea
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010e }
            r9.<init>()     // Catch:{ Exception -> 0x010e }
            java.lang.String r10 = "Response Time:"
            r9.append(r10)     // Catch:{ Exception -> 0x010e }
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x010e }
            long r0 = r0 - r3
            r9.append(r0)     // Catch:{ Exception -> 0x010e }
            java.lang.String r10 = " ms. HTTP Error Code: "
            r9.append(r10)     // Catch:{ Exception -> 0x010e }
            int r10 = r5.getResponseCode()     // Catch:{ Exception -> 0x010e }
            r9.append(r10)     // Catch:{ Exception -> 0x010e }
            java.lang.String r10 = " "
            r9.append(r10)     // Catch:{ Exception -> 0x010e }
            java.net.URL r10 = r5.getURL()     // Catch:{ Exception -> 0x010e }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x010e }
            r9.append(r10)     // Catch:{ Exception -> 0x010e }
            r9.toString()     // Catch:{ Exception -> 0x010e }
            int r9 = r5.getResponseCode()     // Catch:{ Exception -> 0x010e }
            r10 = 400(0x190, float:5.6E-43)
            if (r9 == r10) goto L_0x00e0
            com.qumpara.analytics.model.QumparaAnalyticsError r9 = new com.qumpara.analytics.model.QumparaAnalyticsError     // Catch:{ Exception -> 0x010e }
            java.lang.String r0 = "BAD REQUEST"
            r9.<init>(r10, r0)     // Catch:{ Exception -> 0x010e }
            r8.onError(r9)     // Catch:{ Exception -> 0x010e }
            if (r5 == 0) goto L_0x00df
            r5.disconnect()
        L_0x00df:
            return r2
        L_0x00e0:
            org.json.JSONObject r9 = r8.readHttpErrorBody(r5)     // Catch:{ Exception -> 0x010e }
            if (r5 == 0) goto L_0x00e9
            r5.disconnect()
        L_0x00e9:
            return r9
        L_0x00ea:
            java.io.InputStream r10 = r5.getInputStream()     // Catch:{ Exception -> 0x010e }
            java.lang.String r10 = r8.read(r10)     // Catch:{ Exception -> 0x010e }
            com.qumpara.analytics.QumparaAnalyticsRequest$RequestType r0 = com.qumpara.analytics.QumparaAnalyticsRequest.RequestType.POST_EVENT_DATA     // Catch:{ Exception -> 0x010e }
            if (r9 != r0) goto L_0x0103
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x010e }
            java.lang.String r10 = "{\"resp\":\"ok\"}"
            r9.<init>(r10)     // Catch:{ Exception -> 0x010e }
            if (r5 == 0) goto L_0x0102
            r5.disconnect()
        L_0x0102:
            return r9
        L_0x0103:
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x010e }
            r9.<init>(r10)     // Catch:{ Exception -> 0x010e }
            if (r5 == 0) goto L_0x010d
            r5.disconnect()
        L_0x010d:
            return r9
        L_0x010e:
            r9 = move-exception
            goto L_0x0114
        L_0x0110:
            r9 = move-exception
            goto L_0x012d
        L_0x0112:
            r9 = move-exception
            r5 = r2
        L_0x0114:
            r9.printStackTrace()     // Catch:{ all -> 0x012b }
            com.qumpara.analytics.model.QumparaAnalyticsError r10 = new com.qumpara.analytics.model.QumparaAnalyticsError     // Catch:{ all -> 0x012b }
            r0 = 100
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x012b }
            r10.<init>(r0, r9)     // Catch:{ all -> 0x012b }
            r8.onError(r10)     // Catch:{ all -> 0x012b }
            if (r5 == 0) goto L_0x012a
            r5.disconnect()
        L_0x012a:
            return r2
        L_0x012b:
            r9 = move-exception
            r2 = r5
        L_0x012d:
            if (r2 == 0) goto L_0x0132
            r2.disconnect()
        L_0x0132:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qumpara.analytics.QumparaAnalyticsRequest.makePostRequest(com.qumpara.analytics.QumparaAnalyticsRequest$RequestType, java.lang.String[]):org.json.JSONObject");
    }

    private void onError(QumparaAnalyticsError qumparaAnalyticsError) {
        QumparaAnalyticsResponseListener<T> qumparaAnalyticsResponseListener = this.responseListener;
        if (qumparaAnalyticsResponseListener != null) {
            qumparaAnalyticsResponseListener.onError(qumparaAnalyticsError);
        }
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
    public void mo30057go(String... strArr) {
        try {
            if (QumparaAnalytics.getInstance().getExecutor() != null) {
                executeOnExecutor(QumparaAnalytics.getInstance().getExecutor(), strArr);
            } else {
                execute(strArr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(T t) {
        QumparaAnalyticsResponseListener<T> qumparaAnalyticsResponseListener = this.responseListener;
        if (!(qumparaAnalyticsResponseListener == null || t == null)) {
            qumparaAnalyticsResponseListener.onResponse(t);
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
                    this.requestType.name() + " : " + sb.toString();
                    JSONObject optJSONObject = new JSONObject(sb.toString()).optJSONObject("error");
                    onError(new QumparaAnalyticsError(optJSONObject.optInt("code", 100), optJSONObject.optString("message", "Error: Local SDK error.")));
                    return null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            onError(new QumparaAnalyticsError(100, e.getMessage()));
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public T doInBackground(String... strArr) {
        if (C47451.f12872xe6e439db[this.requestType.ordinal()] != 1) {
            return null;
        }
        return processPostRequest(RequestType.POST_EVENT_DATA, strArr);
    }
}
