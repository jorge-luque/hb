package com.tapjoy;

import com.qumpara.offerwall.sdk.core.QumparaOfferwallModels;
import com.tapjoy.internal.C5081fj;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class TapjoyURLConnection {
    public static final int TYPE_GET = 0;
    public static final int TYPE_POST = 1;

    public String getContentLength(String str) {
        String str2;
        try {
            String replaceAll = str.replaceAll(" ", "%20");
            TapjoyLog.m16649d("TapjoyURLConnection", "requestURL: " + replaceAll);
            HttpURLConnection httpURLConnection = (HttpURLConnection) C5081fj.m17187a(new URL(replaceAll));
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(QumparaOfferwallModels.OfferwallStatus.VIRTUAL_CURRENCY_MIN_INTERVAL);
            str2 = httpURLConnection.getHeaderField("content-length");
        } catch (Exception e) {
            TapjoyLog.m16651e("TapjoyURLConnection", "Exception: " + e.toString());
            str2 = null;
        }
        TapjoyLog.m16649d("TapjoyURLConnection", "content-length: " + str2);
        return str2;
    }

    public TapjoyHttpURLResponse getRedirectFromURL(String str) {
        return getResponseFromURL(str, "", 0, true, (Map) null, (String) null, (String) null);
    }

    public TapjoyHttpURLResponse getResponseFromURL(String str, Map map) {
        return getResponseFromURL(str, TapjoyUtil.convertURLParams(map, false), 0);
    }

    public TapjoyHttpURLResponse getResponseFromURL(String str, Map map, int i) {
        return getResponseFromURL(str, TapjoyUtil.convertURLParams(map, false), i);
    }

    public TapjoyHttpURLResponse getResponseFromURL(String str) {
        return getResponseFromURL(str, "", 0);
    }

    public TapjoyHttpURLResponse getResponseFromURL(String str, String str2) {
        return getResponseFromURL(str, str2, 0);
    }

    public TapjoyHttpURLResponse getResponseFromURL(String str, String str2, int i) {
        return getResponseFromURL(str, str2, i, false, (Map) null, (String) null, (String) null);
    }

    public TapjoyHttpURLResponse getResponseFromURL(String str, Map map, Map map2, Map map3) {
        return getResponseFromURL(str, map != null ? TapjoyUtil.convertURLParams(map, false) : "", 1, false, map2, "application/x-www-form-urlencoded", TapjoyUtil.convertURLParams(map3, false));
    }

    public TapjoyHttpURLResponse getResponseFromURL(String str, Map map, Map map2, String str2) {
        return getResponseFromURL(str, map != null ? TapjoyUtil.convertURLParams(map, false) : "", 1, false, map2, "application/json;charset=utf-8", str2);
    }

    /* JADX WARNING: type inference failed for: r5v0 */
    /* JADX WARNING: type inference failed for: r5v1, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r5v2 */
    /* JADX WARNING: type inference failed for: r5v3, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r5v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x016c A[SYNTHETIC, Splitter:B:47:0x016c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.tapjoy.TapjoyHttpURLResponse getResponseFromURL(java.lang.String r8, java.lang.String r9, int r10, boolean r11, java.util.Map r12, java.lang.String r13, java.lang.String r14) {
        /*
            r7 = this;
            java.lang.String r0 = "Exception: "
            java.lang.String r1 = "TapjoyURLConnection"
            com.tapjoy.TapjoyHttpURLResponse r2 = new com.tapjoy.TapjoyHttpURLResponse
            r2.<init>()
            r3 = 10
            r4 = 0
            r5 = 0
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0154 }
            r6.<init>()     // Catch:{ Exception -> 0x0154 }
            r6.append(r8)     // Catch:{ Exception -> 0x0154 }
            r6.append(r9)     // Catch:{ Exception -> 0x0154 }
            java.lang.String r8 = r6.toString()     // Catch:{ Exception -> 0x0154 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0154 }
            java.lang.String r6 = "http "
            r9.<init>(r6)     // Catch:{ Exception -> 0x0154 }
            if (r10 != 0) goto L_0x0028
            java.lang.String r6 = "get"
            goto L_0x002a
        L_0x0028:
            java.lang.String r6 = "post"
        L_0x002a:
            r9.append(r6)     // Catch:{ Exception -> 0x0154 }
            java.lang.String r6 = ": "
            r9.append(r6)     // Catch:{ Exception -> 0x0154 }
            r9.append(r8)     // Catch:{ Exception -> 0x0154 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0154 }
            com.tapjoy.TapjoyLog.m16652i(r1, r9)     // Catch:{ Exception -> 0x0154 }
            java.net.URL r9 = new java.net.URL     // Catch:{ Exception -> 0x0154 }
            r9.<init>(r8)     // Catch:{ Exception -> 0x0154 }
            java.net.URLConnection r8 = com.tapjoy.internal.C5081fj.m17187a(r9)     // Catch:{ Exception -> 0x0154 }
            java.net.HttpURLConnection r8 = (java.net.HttpURLConnection) r8     // Catch:{ Exception -> 0x0154 }
            if (r11 == 0) goto L_0x004c
            r8.setInstanceFollowRedirects(r4)     // Catch:{ Exception -> 0x0150 }
        L_0x004c:
            r9 = 15000(0x3a98, float:2.102E-41)
            r8.setConnectTimeout(r9)     // Catch:{ Exception -> 0x0150 }
            r9 = 30000(0x7530, float:4.2039E-41)
            r8.setReadTimeout(r9)     // Catch:{ Exception -> 0x0150 }
            if (r12 == 0) goto L_0x007c
            java.util.Set r9 = r12.entrySet()     // Catch:{ Exception -> 0x0150 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ Exception -> 0x0150 }
        L_0x0060:
            boolean r12 = r9.hasNext()     // Catch:{ Exception -> 0x0150 }
            if (r12 == 0) goto L_0x007c
            java.lang.Object r12 = r9.next()     // Catch:{ Exception -> 0x0150 }
            java.util.Map$Entry r12 = (java.util.Map.Entry) r12     // Catch:{ Exception -> 0x0150 }
            java.lang.Object r6 = r12.getKey()     // Catch:{ Exception -> 0x0150 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0150 }
            java.lang.Object r12 = r12.getValue()     // Catch:{ Exception -> 0x0150 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ Exception -> 0x0150 }
            r8.setRequestProperty(r6, r12)     // Catch:{ Exception -> 0x0150 }
            goto L_0x0060
        L_0x007c:
            r9 = 1
            if (r10 != r9) goto L_0x00c4
            java.lang.String r10 = "POST"
            r8.setRequestMethod(r10)     // Catch:{ Exception -> 0x0150 }
            if (r14 == 0) goto L_0x00c4
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0150 }
            java.lang.String r12 = "Content-Type: "
            r10.<init>(r12)     // Catch:{ Exception -> 0x0150 }
            r10.append(r13)     // Catch:{ Exception -> 0x0150 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x0150 }
            com.tapjoy.TapjoyLog.m16652i(r1, r10)     // Catch:{ Exception -> 0x0150 }
            java.lang.String r10 = "Content:"
            com.tapjoy.TapjoyLog.m16652i(r1, r10)     // Catch:{ Exception -> 0x0150 }
            com.tapjoy.TapjoyLog.m16652i(r1, r14)     // Catch:{ Exception -> 0x0150 }
            java.lang.String r10 = "Content-Type"
            r8.setRequestProperty(r10, r13)     // Catch:{ Exception -> 0x0150 }
            java.lang.String r10 = "Connection"
            java.lang.String r12 = "close"
            r8.setRequestProperty(r10, r12)     // Catch:{ Exception -> 0x0150 }
            r8.setDoOutput(r9)     // Catch:{ Exception -> 0x0150 }
            int r9 = r14.length()     // Catch:{ Exception -> 0x0150 }
            r8.setFixedLengthStreamingMode(r9)     // Catch:{ Exception -> 0x0150 }
            java.io.OutputStreamWriter r9 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x0150 }
            java.io.OutputStream r10 = r8.getOutputStream()     // Catch:{ Exception -> 0x0150 }
            r9.<init>(r10)     // Catch:{ Exception -> 0x0150 }
            r9.write(r14)     // Catch:{ Exception -> 0x0150 }
            r9.close()     // Catch:{ Exception -> 0x0150 }
        L_0x00c4:
            r8.connect()     // Catch:{ Exception -> 0x0150 }
            int r9 = r8.getResponseCode()     // Catch:{ Exception -> 0x0150 }
            r2.statusCode = r9     // Catch:{ Exception -> 0x0150 }
            java.util.Map r9 = r8.getHeaderFields()     // Catch:{ Exception -> 0x0150 }
            r2.headerFields = r9     // Catch:{ Exception -> 0x0150 }
            long r9 = r8.getDate()     // Catch:{ Exception -> 0x0150 }
            r2.date = r9     // Catch:{ Exception -> 0x0150 }
            long r9 = r8.getExpiration()     // Catch:{ Exception -> 0x0150 }
            r2.expires = r9     // Catch:{ Exception -> 0x0150 }
            if (r11 != 0) goto L_0x00ef
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0150 }
            java.io.InputStreamReader r9 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0150 }
            java.io.InputStream r10 = r8.getInputStream()     // Catch:{ Exception -> 0x0150 }
            r9.<init>(r10)     // Catch:{ Exception -> 0x0150 }
            r5.<init>(r9)     // Catch:{ Exception -> 0x0150 }
        L_0x00ef:
            if (r11 != 0) goto L_0x0115
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0150 }
            r9.<init>()     // Catch:{ Exception -> 0x0150 }
        L_0x00f6:
            java.lang.String r10 = r5.readLine()     // Catch:{ Exception -> 0x0150 }
            if (r10 == 0) goto L_0x010f
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0150 }
            r11.<init>()     // Catch:{ Exception -> 0x0150 }
            r11.append(r10)     // Catch:{ Exception -> 0x0150 }
            r11.append(r3)     // Catch:{ Exception -> 0x0150 }
            java.lang.String r10 = r11.toString()     // Catch:{ Exception -> 0x0150 }
            r9.append(r10)     // Catch:{ Exception -> 0x0150 }
            goto L_0x00f6
        L_0x010f:
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0150 }
            r2.response = r9     // Catch:{ Exception -> 0x0150 }
        L_0x0115:
            int r9 = r2.statusCode     // Catch:{ Exception -> 0x0150 }
            r10 = 302(0x12e, float:4.23E-43)
            if (r9 != r10) goto L_0x0123
            java.lang.String r9 = "Location"
            java.lang.String r9 = r8.getHeaderField(r9)     // Catch:{ Exception -> 0x0150 }
            r2.redirectURL = r9     // Catch:{ Exception -> 0x0150 }
        L_0x0123:
            java.lang.String r9 = "content-length"
            java.lang.String r9 = r8.getHeaderField(r9)     // Catch:{ Exception -> 0x0150 }
            if (r9 == 0) goto L_0x014a
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ Exception -> 0x0136 }
            int r9 = r9.intValue()     // Catch:{ Exception -> 0x0136 }
            r2.contentLength = r9     // Catch:{ Exception -> 0x0136 }
            goto L_0x014a
        L_0x0136:
            r9 = move-exception
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0150 }
            r10.<init>(r0)     // Catch:{ Exception -> 0x0150 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0150 }
            r10.append(r9)     // Catch:{ Exception -> 0x0150 }
            java.lang.String r9 = r10.toString()     // Catch:{ Exception -> 0x0150 }
            com.tapjoy.TapjoyLog.m16651e((java.lang.String) r1, (java.lang.String) r9)     // Catch:{ Exception -> 0x0150 }
        L_0x014a:
            if (r5 == 0) goto L_0x01b9
            r5.close()     // Catch:{ Exception -> 0x0150 }
            goto L_0x01b9
        L_0x0150:
            r9 = move-exception
            r5 = r8
            r8 = r9
            goto L_0x0155
        L_0x0154:
            r8 = move-exception
        L_0x0155:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r0)
            java.lang.String r8 = r8.toString()
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            com.tapjoy.TapjoyLog.m16651e((java.lang.String) r1, (java.lang.String) r8)
            r2.statusCode = r4
            if (r5 == 0) goto L_0x01b9
            java.lang.String r8 = r2.response     // Catch:{ Exception -> 0x01a3 }
            if (r8 != 0) goto L_0x01b9
            java.io.BufferedReader r8 = new java.io.BufferedReader     // Catch:{ Exception -> 0x01a3 }
            java.io.InputStreamReader r9 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x01a3 }
            java.io.InputStream r10 = r5.getErrorStream()     // Catch:{ Exception -> 0x01a3 }
            r9.<init>(r10)     // Catch:{ Exception -> 0x01a3 }
            r8.<init>(r9)     // Catch:{ Exception -> 0x01a3 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01a3 }
            r9.<init>()     // Catch:{ Exception -> 0x01a3 }
        L_0x0183:
            java.lang.String r10 = r8.readLine()     // Catch:{ Exception -> 0x01a3 }
            if (r10 == 0) goto L_0x019c
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01a3 }
            r11.<init>()     // Catch:{ Exception -> 0x01a3 }
            r11.append(r10)     // Catch:{ Exception -> 0x01a3 }
            r11.append(r3)     // Catch:{ Exception -> 0x01a3 }
            java.lang.String r10 = r11.toString()     // Catch:{ Exception -> 0x01a3 }
            r9.append(r10)     // Catch:{ Exception -> 0x01a3 }
            goto L_0x0183
        L_0x019c:
            java.lang.String r8 = r9.toString()     // Catch:{ Exception -> 0x01a3 }
            r2.response = r8     // Catch:{ Exception -> 0x01a3 }
            goto L_0x01b9
        L_0x01a3:
            r8 = move-exception
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "Exception trying to get error code/content: "
            r9.<init>(r10)
            java.lang.String r8 = r8.toString()
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            com.tapjoy.TapjoyLog.m16651e((java.lang.String) r1, (java.lang.String) r8)
        L_0x01b9:
            java.lang.String r8 = "--------------------"
            com.tapjoy.TapjoyLog.m16652i(r1, r8)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "response status: "
            r9.<init>(r10)
            int r10 = r2.statusCode
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            com.tapjoy.TapjoyLog.m16652i(r1, r9)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "response size: "
            r9.<init>(r10)
            int r10 = r2.contentLength
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            com.tapjoy.TapjoyLog.m16652i(r1, r9)
            java.lang.String r9 = r2.redirectURL
            if (r9 == 0) goto L_0x0201
            int r9 = r9.length()
            if (r9 <= 0) goto L_0x0201
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "redirectURL: "
            r9.<init>(r10)
            java.lang.String r10 = r2.redirectURL
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            com.tapjoy.TapjoyLog.m16652i(r1, r9)
        L_0x0201:
            com.tapjoy.TapjoyLog.m16652i(r1, r8)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.TapjoyURLConnection.getResponseFromURL(java.lang.String, java.lang.String, int, boolean, java.util.Map, java.lang.String, java.lang.String):com.tapjoy.TapjoyHttpURLResponse");
    }
}
