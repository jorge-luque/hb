package com.qumpara.offerwall.sdk.img;

import android.content.Context;
import android.graphics.Bitmap;

public class WebImage implements FastImage {
    private static final int CONNECT_TIMEOUT = 8000;
    private static final int READ_TIMEOUT = 16000;
    private static WebImageCache webImageCache;
    private String url;

    public WebImage(String str) {
        this.url = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap getBitmapFromUrl(java.lang.String r5) {
        /*
            r4 = this;
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x0035, all -> 0x0033 }
            r1.<init>(r5)     // Catch:{ Exception -> 0x0035, all -> 0x0033 }
            java.net.URLConnection r5 = r1.openConnection()     // Catch:{ Exception -> 0x0035, all -> 0x0033 }
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ Exception -> 0x0035, all -> 0x0033 }
            r1 = 8000(0x1f40, float:1.121E-41)
            r5.setConnectTimeout(r1)     // Catch:{ Exception -> 0x0031 }
            r1 = 16000(0x3e80, float:2.2421E-41)
            r5.setReadTimeout(r1)     // Catch:{ Exception -> 0x0031 }
            r5.connect()     // Catch:{ Exception -> 0x0031 }
            java.lang.Object r1 = r5.getContent()     // Catch:{ Exception -> 0x0031 }
            java.io.InputStream r1 = (java.io.InputStream) r1     // Catch:{ Exception -> 0x0031 }
            int r2 = r5.getResponseCode()     // Catch:{ Exception -> 0x0031 }
            r3 = 200(0xc8, float:2.8E-43)
            if (r2 != r3) goto L_0x002b
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r1)     // Catch:{ Exception -> 0x0031 }
        L_0x002b:
            if (r5 == 0) goto L_0x0030
            r5.disconnect()
        L_0x0030:
            return r0
        L_0x0031:
            r1 = move-exception
            goto L_0x0037
        L_0x0033:
            r5 = r0
            goto L_0x0041
        L_0x0035:
            r1 = move-exception
            r5 = r0
        L_0x0037:
            r1.printStackTrace()     // Catch:{ all -> 0x0040 }
            if (r5 == 0) goto L_0x003f
            r5.disconnect()
        L_0x003f:
            return r0
        L_0x0040:
        L_0x0041:
            if (r5 == 0) goto L_0x0046
            r5.disconnect()
        L_0x0046:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qumpara.offerwall.sdk.img.WebImage.getBitmapFromUrl(java.lang.String):android.graphics.Bitmap");
    }

    public static void removeFromCache(String str) {
        WebImageCache webImageCache2 = webImageCache;
        if (webImageCache2 != null) {
            webImageCache2.remove(str);
        }
    }

    public Bitmap getBitmap(Context context) {
        if (webImageCache == null) {
            webImageCache = new WebImageCache(context);
        }
        Bitmap bitmap = null;
        String str = this.url;
        if (!(str == null || (bitmap = webImageCache.get(str)) != null || (bitmap = getBitmapFromUrl(this.url)) == null)) {
            webImageCache.put(this.url, bitmap);
        }
        return bitmap;
    }
}
