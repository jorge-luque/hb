package p118io.presage;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Map;

/* renamed from: io.presage.dm */
public final class C6407dm implements C6400df {

    /* renamed from: a */
    private final C6411dq f16990a;

    /* renamed from: b */
    private final C6402dh f16991b;

    public C6407dm(C6411dq dqVar, C6402dh dhVar) {
        this.f16990a = dqVar;
        this.f16991b = dhVar;
    }

    /* renamed from: b */
    private final void m21266b(HttpURLConnection httpURLConnection) {
        for (Map.Entry next : this.f16990a.mo35376d().mo34587a().entrySet()) {
            httpURLConnection.setRequestProperty((String) next.getKey(), (String) next.getValue());
        }
    }

    /* renamed from: c */
    private final void m21267c(HttpURLConnection httpURLConnection) {
        byte[] bArr;
        if (this.f16990a.mo35375c().length() > 0) {
            OutputStream outputStream = null;
            try {
                outputStream = httpURLConnection.getOutputStream();
                if (C6406dl.m21262a(this.f16990a.mo35376d())) {
                    C6404dj djVar = C6404dj.f16988a;
                    bArr = C6404dj.m21260a(this.f16990a.mo35375c());
                } else {
                    String c = this.f16990a.mo35375c();
                    Charset charset = C6548is.f17074a;
                    if (c != null) {
                        bArr = c.getBytes(charset);
                        C6514hl.m21414a((Object) bArr, "(this as java.lang.String).getBytes(charset)");
                    } else {
                        throw new C6434em("null cannot be cast to non-null type java.lang.String");
                    }
                }
                outputStream.write(bArr);
            } finally {
                if (outputStream != null) {
                    C6401dg.m21255a(outputStream);
                }
            }
        }
    }

    /* renamed from: a */
    public final C6412dr mo35367a() {
        try {
            HttpURLConnection a = m21265a(new URL(this.f16990a.mo35373a()));
            m21266b(a);
            m21267c(a);
            int responseCode = a.getResponseCode();
            if (C6408dn.m21269a(responseCode)) {
                return m21264a(a);
            }
            return new C6403di(new C6410dp(responseCode));
        } catch (Exception e) {
            return new C6403di(e);
        }
    }

    /* renamed from: a */
    private static C6413ds m21264a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection.getContentLength() == 0) {
            return new C6413ds("");
        }
        InputStream inputStream = httpURLConnection.getInputStream();
        C6514hl.m21414a((Object) inputStream, "inputStream");
        byte[] a = C6471fw.m21360a(inputStream);
        inputStream.close();
        String headerField = httpURLConnection.getHeaderField("content-encoding");
        if (headerField != null) {
            Locale locale = Locale.US;
            C6514hl.m21414a((Object) locale, "Locale.US");
            String lowerCase = headerField.toLowerCase(locale);
            C6514hl.m21414a((Object) lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            if (C6514hl.m21416a((Object) lowerCase, (Object) "gzip")) {
                C6404dj djVar = C6404dj.f16988a;
                return new C6413ds(C6404dj.m21259a(a));
            }
        }
        return new C6413ds(new String(a, C6548is.f17074a));
    }

    /* renamed from: a */
    private final HttpURLConnection m21265a(URL url) throws IOException {
        URLConnection openConnection = url.openConnection();
        if (openConnection != null) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setRequestProperty("Connection", "close");
            httpURLConnection.setReadTimeout(this.f16991b.mo34588a());
            httpURLConnection.setConnectTimeout(this.f16991b.mo34589b());
            httpURLConnection.setRequestMethod(this.f16990a.mo35374b());
            httpURLConnection.setDoOutput(this.f16990a.mo35375c().length() > 0);
            return httpURLConnection;
        }
        throw new C6434em("null cannot be cast to non-null type java.net.HttpURLConnection");
    }
}
