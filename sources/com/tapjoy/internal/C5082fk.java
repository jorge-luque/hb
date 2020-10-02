package com.tapjoy.internal;

import android.net.Uri;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.nio.charset.Charset;
import java.util.Map;

/* renamed from: com.tapjoy.internal.fk */
public final class C5082fk {
    /* renamed from: a */
    public static String m17188a(Map map) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Map.Entry entry : map.entrySet()) {
            if (z) {
                z = false;
            } else {
                sb.append("&");
            }
            Object key = entry.getKey();
            if (key != null) {
                sb.append(Uri.encode(key.toString()));
            }
            sb.append("=");
            Object value = entry.getValue();
            if (value != null) {
                sb.append(Uri.encode(value.toString()));
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static void m17189a(HttpURLConnection httpURLConnection, String str, String str2, Charset charset) {
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("Content-Type", str);
        byte[] bytes = str2.getBytes(charset);
        httpURLConnection.setFixedLengthStreamingMode(bytes.length);
        OutputStream outputStream = httpURLConnection.getOutputStream();
        try {
            outputStream.write(bytes);
        } finally {
            outputStream.close();
        }
    }
}
