package com.adcolony.sdk;

import java.net.URL;

/* renamed from: com.adcolony.sdk.t */
class C1438t {

    /* renamed from: a */
    private URL f4509a;

    C1438t(URL url) {
        this.f4509a = url;
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0087  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int mo6796a(java.lang.String r7) throws java.io.IOException {
        /*
            r6 = this;
            r0 = 1
            r1 = 0
            r2 = 0
            java.net.URL r3 = r6.f4509a     // Catch:{ IOException -> 0x0072, all -> 0x006e }
            java.net.URLConnection r3 = r3.openConnection()     // Catch:{ IOException -> 0x0072, all -> 0x006e }
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ IOException -> 0x0072, all -> 0x006e }
            java.lang.String r4 = "POST"
            r3.setRequestMethod(r4)     // Catch:{ IOException -> 0x006c, all -> 0x006a }
            java.lang.String r4 = "Content-Encoding"
            java.lang.String r5 = "gzip"
            r3.setRequestProperty(r4, r5)     // Catch:{ IOException -> 0x006c, all -> 0x006a }
            java.lang.String r4 = "Content-Type"
            java.lang.String r5 = "application/json"
            r3.setRequestProperty(r4, r5)     // Catch:{ IOException -> 0x006c, all -> 0x006a }
            r3.setDoInput(r0)     // Catch:{ IOException -> 0x006c, all -> 0x006a }
            java.util.zip.GZIPOutputStream r4 = new java.util.zip.GZIPOutputStream     // Catch:{ IOException -> 0x006c, all -> 0x006a }
            java.io.OutputStream r5 = r3.getOutputStream()     // Catch:{ IOException -> 0x006c, all -> 0x006a }
            r4.<init>(r5)     // Catch:{ IOException -> 0x006c, all -> 0x006a }
            java.io.DataOutputStream r5 = new java.io.DataOutputStream     // Catch:{ IOException -> 0x0068, all -> 0x0066 }
            r5.<init>(r4)     // Catch:{ IOException -> 0x0068, all -> 0x0066 }
            java.lang.String r1 = "UTF-8"
            java.nio.charset.Charset r1 = java.nio.charset.Charset.forName(r1)     // Catch:{ IOException -> 0x0062, all -> 0x005e }
            byte[] r7 = r7.getBytes(r1)     // Catch:{ IOException -> 0x0062, all -> 0x005e }
            r5.write(r7)     // Catch:{ IOException -> 0x0062, all -> 0x005e }
            r5.close()     // Catch:{ IOException -> 0x0062, all -> 0x005e }
            int r7 = r3.getResponseCode()     // Catch:{ IOException -> 0x005c, all -> 0x0059 }
            r4.close()
            if (r3 == 0) goto L_0x0058
            java.io.InputStream r0 = r3.getInputStream()
            if (r0 == 0) goto L_0x0055
            java.io.InputStream r0 = r3.getInputStream()
            r0.close()
        L_0x0055:
            r3.disconnect()
        L_0x0058:
            return r7
        L_0x0059:
            r7 = move-exception
            r1 = r5
            goto L_0x0078
        L_0x005c:
            r7 = move-exception
            goto L_0x0064
        L_0x005e:
            r7 = move-exception
            r1 = r5
            r0 = 0
            goto L_0x0078
        L_0x0062:
            r7 = move-exception
            r0 = 0
        L_0x0064:
            r1 = r5
            goto L_0x0076
        L_0x0066:
            r7 = move-exception
            goto L_0x0079
        L_0x0068:
            r7 = move-exception
            goto L_0x0075
        L_0x006a:
            r7 = move-exception
            goto L_0x0070
        L_0x006c:
            r7 = move-exception
            goto L_0x0074
        L_0x006e:
            r7 = move-exception
            r3 = r1
        L_0x0070:
            r4 = r1
            goto L_0x0079
        L_0x0072:
            r7 = move-exception
            r3 = r1
        L_0x0074:
            r4 = r1
        L_0x0075:
            r0 = 0
        L_0x0076:
            throw r7     // Catch:{ all -> 0x0077 }
        L_0x0077:
            r7 = move-exception
        L_0x0078:
            r2 = r0
        L_0x0079:
            if (r1 == 0) goto L_0x0080
            if (r2 != 0) goto L_0x0080
            r1.close()
        L_0x0080:
            if (r4 == 0) goto L_0x0085
            r4.close()
        L_0x0085:
            if (r3 == 0) goto L_0x0097
            java.io.InputStream r0 = r3.getInputStream()
            if (r0 == 0) goto L_0x0094
            java.io.InputStream r0 = r3.getInputStream()
            r0.close()
        L_0x0094:
            r3.disconnect()
        L_0x0097:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.C1438t.mo6796a(java.lang.String):int");
    }
}
