package com.ogury.crashreport;

import com.loopj.android.http.C4250c;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import p118io.fabric.sdk.android.p200m.p202b.C6078a;

/* compiled from: CrashApi.kt */
public final class ansicpg1252 {

    /* renamed from: a */
    public static final ansicpg1252 f12190a = new ansicpg1252();

    private ansicpg1252() {
    }

    /* renamed from: a */
    public static int m15278a(String str, String str2) {
        tx7920.m15333b(str, "crashJson");
        tx7920.m15333b(str2, "url");
        URLConnection openConnection = new URL(str2).openConnection();
        if (openConnection != null) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setReadTimeout(C6078a.DEFAULT_TIMEOUT);
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            httpURLConnection.setRequestProperty(C6078a.HEADER_ACCEPT, C6078a.ACCEPT_JSON_VALUE);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, C4250c.DEFAULT_CHARSET));
            bufferedWriter.write(str);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            httpURLConnection.connect();
            return httpURLConnection.getResponseCode();
        }
        throw new margl1440("null cannot be cast to non-null type java.net.HttpURLConnection");
    }
}
