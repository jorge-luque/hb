package com.moat.analytics.mobile.ogury;

import com.loopj.android.http.C4250c;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* renamed from: com.moat.analytics.mobile.ogury.k */
final class C4330k {
    C4330k() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0045, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0050, code lost:
        return com.moat.analytics.mobile.ogury.base.functional.Optional.empty();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0051, code lost:
        if (r0 != null) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0056, code lost:
        throw r3;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0047 */
    /* renamed from: ˋ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.moat.analytics.mobile.ogury.base.functional.Optional<java.lang.String> m14504(java.lang.String r3) {
        /*
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ IOException -> 0x0047 }
            r1.<init>(r3)     // Catch:{ IOException -> 0x0047 }
            java.net.URLConnection r3 = r1.openConnection()     // Catch:{ IOException -> 0x0047 }
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ IOException -> 0x0047 }
            r1 = 0
            r3.setUseCaches(r1)     // Catch:{ IOException -> 0x0047 }
            r1 = 10000(0x2710, float:1.4013E-41)
            r3.setReadTimeout(r1)     // Catch:{ IOException -> 0x0047 }
            r1 = 15000(0x3a98, float:2.102E-41)
            r3.setConnectTimeout(r1)     // Catch:{ IOException -> 0x0047 }
            java.lang.String r1 = "GET"
            r3.setRequestMethod(r1)     // Catch:{ IOException -> 0x0047 }
            r1 = 1
            r3.setDoInput(r1)     // Catch:{ IOException -> 0x0047 }
            r3.connect()     // Catch:{ IOException -> 0x0047 }
            int r1 = r3.getResponseCode()     // Catch:{ IOException -> 0x0047 }
            r2 = 400(0x190, float:5.6E-43)
            if (r1 < r2) goto L_0x0033
            com.moat.analytics.mobile.ogury.base.functional.Optional r3 = com.moat.analytics.mobile.ogury.base.functional.Optional.empty()     // Catch:{ IOException -> 0x0047 }
            return r3
        L_0x0033:
            java.io.InputStream r0 = r3.getInputStream()     // Catch:{ IOException -> 0x0047 }
            java.lang.String r3 = m14505(r0)     // Catch:{ IOException -> 0x0047 }
            com.moat.analytics.mobile.ogury.base.functional.Optional r3 = com.moat.analytics.mobile.ogury.base.functional.Optional.m14414of(r3)     // Catch:{ IOException -> 0x0047 }
            if (r0 == 0) goto L_0x0044
            r0.close()     // Catch:{ IOException -> 0x0044 }
        L_0x0044:
            return r3
        L_0x0045:
            r3 = move-exception
            goto L_0x0051
        L_0x0047:
            com.moat.analytics.mobile.ogury.base.functional.Optional r3 = com.moat.analytics.mobile.ogury.base.functional.Optional.empty()     // Catch:{ all -> 0x0045 }
            if (r0 == 0) goto L_0x0050
            r0.close()     // Catch:{ IOException -> 0x0050 }
        L_0x0050:
            return r3
        L_0x0051:
            if (r0 == 0) goto L_0x0056
            r0.close()     // Catch:{ IOException -> 0x0056 }
        L_0x0056:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moat.analytics.mobile.ogury.C4330k.m14504(java.lang.String):com.moat.analytics.mobile.ogury.base.functional.Optional");
    }

    /* renamed from: ˏ */
    private static String m14505(InputStream inputStream) throws IOException {
        char[] cArr = new char[256];
        StringBuilder sb = new StringBuilder();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, C4250c.DEFAULT_CHARSET);
        int i = 0;
        do {
            int read = inputStreamReader.read(cArr, 0, 256);
            if (read <= 0) {
                break;
            }
            i += read;
            sb.append(cArr, 0, read);
        } while (i < 1024);
        return sb.toString();
    }
}
