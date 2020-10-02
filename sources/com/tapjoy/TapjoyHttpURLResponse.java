package com.tapjoy;

import java.util.Map;

public class TapjoyHttpURLResponse {
    public int contentLength;
    public long date;
    public long expires;
    public Map headerFields;
    public String redirectURL;
    public String response;
    public int statusCode;

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r3 = (java.util.List) r0.get(r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getHeaderFieldAsString(java.lang.String r3) {
        /*
            r2 = this;
            java.util.Map r0 = r2.headerFields
            if (r0 == 0) goto L_0x001a
            java.lang.Object r3 = r0.get(r3)
            java.util.List r3 = (java.util.List) r3
            if (r3 == 0) goto L_0x001a
            r0 = 0
            java.lang.Object r1 = r3.get(r0)
            if (r1 == 0) goto L_0x001a
            java.lang.Object r3 = r3.get(r0)
            java.lang.String r3 = (java.lang.String) r3
            goto L_0x001c
        L_0x001a:
            java.lang.String r3 = ""
        L_0x001c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.TapjoyHttpURLResponse.getHeaderFieldAsString(java.lang.String):java.lang.String");
    }
}
