package p118io.fabric.sdk.android.services.network;

import com.facebook.internal.Utility;
import com.loopj.android.http.C4250c;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.GZIPInputStream;

/* renamed from: io.fabric.sdk.android.services.network.HttpRequest */
public class HttpRequest {

    /* renamed from: k */
    private static C6192c f16239k = C6192c.f16255a;

    /* renamed from: a */
    private HttpURLConnection f16240a = null;

    /* renamed from: b */
    public final URL f16241b;

    /* renamed from: c */
    private final String f16242c;

    /* renamed from: d */
    private C6195e f16243d;

    /* renamed from: e */
    private boolean f16244e;

    /* renamed from: f */
    private boolean f16245f = true;

    /* renamed from: g */
    private boolean f16246g = false;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f16247h = Utility.DEFAULT_STREAM_BUFFER_SIZE;

    /* renamed from: i */
    private String f16248i;

    /* renamed from: j */
    private int f16249j;

    /* renamed from: io.fabric.sdk.android.services.network.HttpRequest$HttpRequestException */
    public static class HttpRequestException extends RuntimeException {
        private static final long serialVersionUID = -1170466989781746231L;

        protected HttpRequestException(IOException iOException) {
            super(iOException);
        }

        public IOException getCause() {
            return (IOException) super.getCause();
        }
    }

    /* renamed from: io.fabric.sdk.android.services.network.HttpRequest$a */
    class C6190a extends C6191b<HttpRequest> {

        /* renamed from: c */
        final /* synthetic */ InputStream f16250c;

        /* renamed from: d */
        final /* synthetic */ OutputStream f16251d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C6190a(Closeable closeable, boolean z, InputStream inputStream, OutputStream outputStream) {
            super(closeable, z);
            this.f16250c = inputStream;
            this.f16251d = outputStream;
        }

        /* renamed from: b */
        public HttpRequest m20006b() throws IOException {
            byte[] bArr = new byte[HttpRequest.this.f16247h];
            while (true) {
                int read = this.f16250c.read(bArr);
                if (read == -1) {
                    return HttpRequest.this;
                }
                this.f16251d.write(bArr, 0, read);
            }
        }
    }

    /* renamed from: io.fabric.sdk.android.services.network.HttpRequest$b */
    protected static abstract class C6191b<V> extends C6194d<V> {

        /* renamed from: a */
        private final Closeable f16253a;

        /* renamed from: b */
        private final boolean f16254b;

        protected C6191b(Closeable closeable, boolean z) {
            this.f16253a = closeable;
            this.f16254b = z;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo34363a() throws IOException {
            Closeable closeable = this.f16253a;
            if (closeable instanceof Flushable) {
                ((Flushable) closeable).flush();
            }
            if (this.f16254b) {
                try {
                    this.f16253a.close();
                } catch (IOException unused) {
                }
            } else {
                this.f16253a.close();
            }
        }
    }

    /* renamed from: io.fabric.sdk.android.services.network.HttpRequest$c */
    public interface C6192c {

        /* renamed from: a */
        public static final C6192c f16255a = new C6193a();

        /* renamed from: io.fabric.sdk.android.services.network.HttpRequest$c$a */
        static class C6193a implements C6192c {
            C6193a() {
            }

            /* renamed from: a */
            public HttpURLConnection mo34364a(URL url) throws IOException {
                return (HttpURLConnection) url.openConnection();
            }

            /* renamed from: a */
            public HttpURLConnection mo34365a(URL url, Proxy proxy) throws IOException {
                return (HttpURLConnection) url.openConnection(proxy);
            }
        }

        /* renamed from: a */
        HttpURLConnection mo34364a(URL url) throws IOException;

        /* renamed from: a */
        HttpURLConnection mo34365a(URL url, Proxy proxy) throws IOException;
    }

    /* renamed from: io.fabric.sdk.android.services.network.HttpRequest$d */
    protected static abstract class C6194d<V> implements Callable<V> {
        protected C6194d() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract void mo34363a() throws IOException;

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public abstract V mo34362b() throws HttpRequestException, IOException;

        public V call() throws HttpRequestException {
            boolean z;
            Throwable th;
            try {
                V b = mo34362b();
                try {
                    mo34363a();
                    return b;
                } catch (IOException e) {
                    throw new HttpRequestException(e);
                }
            } catch (HttpRequestException e2) {
                throw e2;
            } catch (IOException e3) {
                throw new HttpRequestException(e3);
            } catch (Throwable th2) {
                th = th2;
                z = true;
                mo34363a();
                throw th;
            }
        }
    }

    /* renamed from: io.fabric.sdk.android.services.network.HttpRequest$e */
    public static class C6195e extends BufferedOutputStream {

        /* renamed from: a */
        private final CharsetEncoder f16256a;

        public C6195e(OutputStream outputStream, String str, int i) {
            super(outputStream, i);
            this.f16256a = Charset.forName(HttpRequest.m19964f(str)).newEncoder();
        }

        /* renamed from: a */
        public C6195e mo34367a(String str) throws IOException {
            ByteBuffer encode = this.f16256a.encode(CharBuffer.wrap(str));
            super.write(encode.array(), 0, encode.limit());
            return this;
        }
    }

    public HttpRequest(CharSequence charSequence, String str) throws HttpRequestException {
        try {
            this.f16241b = new URL(charSequence.toString());
            this.f16242c = str;
        } catch (MalformedURLException e) {
            throw new HttpRequestException(e);
        }
    }

    /* renamed from: b */
    private static StringBuilder m19958b(String str, StringBuilder sb) {
        if (str.indexOf(58) + 2 == str.lastIndexOf(47)) {
            sb.append('/');
        }
        return sb;
    }

    /* renamed from: c */
    public static String m19959c(CharSequence charSequence) throws HttpRequestException {
        int i;
        try {
            URL url = new URL(charSequence.toString());
            String host = url.getHost();
            int port = url.getPort();
            if (port != -1) {
                host = host + ':' + Integer.toString(port);
            }
            try {
                String aSCIIString = new URI(url.getProtocol(), host, url.getPath(), url.getQuery(), url.getRef()).toASCIIString();
                int indexOf = aSCIIString.indexOf(63);
                if (indexOf <= 0 || (i = indexOf + 1) >= aSCIIString.length()) {
                    return aSCIIString;
                }
                return aSCIIString.substring(0, i) + aSCIIString.substring(i).replace("+", "%2B").replace("#", "%23");
            } catch (URISyntaxException e) {
                IOException iOException = new IOException("Parsing URI failed");
                iOException.initCause(e);
                throw new HttpRequestException(iOException);
            }
        } catch (IOException e2) {
            throw new HttpRequestException(e2);
        }
    }

    /* renamed from: d */
    public static HttpRequest m19960d(CharSequence charSequence) throws HttpRequestException {
        return new HttpRequest(charSequence, "GET");
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public static String m19964f(String str) {
        return (str == null || str.length() <= 0) ? C4250c.DEFAULT_CHARSET : str;
    }

    /* renamed from: p */
    private HttpURLConnection m19965p() {
        HttpURLConnection httpURLConnection;
        try {
            if (this.f16248i != null) {
                httpURLConnection = f16239k.mo34365a(this.f16241b, m19966q());
            } else {
                httpURLConnection = f16239k.mo34364a(this.f16241b);
            }
            httpURLConnection.setRequestMethod(this.f16242c);
            return httpURLConnection;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    /* renamed from: q */
    private Proxy m19966q() {
        return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(this.f16248i, this.f16249j));
    }

    /* renamed from: g */
    public int mo34351g() throws HttpRequestException {
        try {
            mo34347e();
            return mo34354j().getResponseCode();
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    /* renamed from: h */
    public String mo34352h() {
        return mo34343c("Content-Encoding");
    }

    /* renamed from: i */
    public int mo34353i() {
        return mo34344d("Content-Length");
    }

    /* renamed from: j */
    public HttpURLConnection mo34354j() {
        if (this.f16240a == null) {
            this.f16240a = m19965p();
        }
        return this.f16240a;
    }

    /* renamed from: k */
    public String mo34355k() {
        return mo34354j().getRequestMethod();
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public HttpRequest mo34356l() throws IOException {
        if (this.f16243d != null) {
            return this;
        }
        mo34354j().setDoOutput(true);
        this.f16243d = new C6195e(mo34354j().getOutputStream(), mo34340b(mo34354j().getRequestProperty("Content-Type"), "charset"), this.f16247h);
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public HttpRequest mo34357m() throws IOException {
        if (!this.f16244e) {
            this.f16244e = true;
            mo34337b("multipart/form-data; boundary=00content0boundary00");
            mo34356l();
            this.f16243d.mo34367a("--00content0boundary00\r\n");
        } else {
            this.f16243d.mo34367a("\r\n--00content0boundary00\r\n");
        }
        return this;
    }

    /* renamed from: n */
    public InputStream mo34358n() throws HttpRequestException {
        InputStream inputStream;
        if (mo34351g() < 400) {
            try {
                inputStream = mo34354j().getInputStream();
            } catch (IOException e) {
                throw new HttpRequestException(e);
            }
        } else {
            inputStream = mo34354j().getErrorStream();
            if (inputStream == null) {
                try {
                    inputStream = mo34354j().getInputStream();
                } catch (IOException e2) {
                    throw new HttpRequestException(e2);
                }
            }
        }
        if (!this.f16246g || !"gzip".equals(mo34352h())) {
            return inputStream;
        }
        try {
            return new GZIPInputStream(inputStream);
        } catch (IOException e3) {
            throw new HttpRequestException(e3);
        }
    }

    /* renamed from: o */
    public URL mo34359o() {
        return mo34354j().getURL();
    }

    public String toString() {
        return mo34355k() + ' ' + mo34359o();
    }

    /* renamed from: a */
    private static StringBuilder m19955a(String str, StringBuilder sb) {
        int indexOf = str.indexOf(63);
        int length = sb.length() - 1;
        if (indexOf == -1) {
            sb.append('?');
        } else if (indexOf < length && str.charAt(length) != '&') {
            sb.append('&');
        }
        return sb;
    }

    /* renamed from: e */
    public static HttpRequest m19961e(CharSequence charSequence) throws HttpRequestException {
        return new HttpRequest(charSequence, "POST");
    }

    /* renamed from: f */
    public static HttpRequest m19963f(CharSequence charSequence) throws HttpRequestException {
        return new HttpRequest(charSequence, "PUT");
    }

    /* renamed from: d */
    public int mo34344d(String str) throws HttpRequestException {
        return mo34322a(str, -1);
    }

    /* renamed from: b */
    public static HttpRequest m19957b(CharSequence charSequence, Map<?, ?> map, boolean z) {
        String a = m19954a(charSequence, map);
        if (z) {
            a = m19959c((CharSequence) a);
        }
        return m19961e((CharSequence) a);
    }

    /* renamed from: d */
    public String mo34346d(String str, String str2) {
        return mo34340b(mo34343c(str), str2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public HttpRequest mo34347e() throws IOException {
        C6195e eVar = this.f16243d;
        if (eVar == null) {
            return this;
        }
        if (this.f16244e) {
            eVar.mo34367a("\r\n--00content0boundary00--\r\n");
        }
        if (this.f16245f) {
            try {
                this.f16243d.close();
            } catch (IOException unused) {
            }
        } else {
            this.f16243d.close();
        }
        this.f16243d = null;
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public HttpRequest mo34349f() throws HttpRequestException {
        try {
            mo34347e();
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    /* renamed from: d */
    public String mo34345d() {
        return mo34346d("Content-Type", "charset");
    }

    /* renamed from: b */
    public static HttpRequest m19956b(CharSequence charSequence) throws HttpRequestException {
        return new HttpRequest(charSequence, "DELETE");
    }

    /* renamed from: f */
    public HttpRequest mo34350f(String str, String str2) throws HttpRequestException {
        mo34325a((CharSequence) str);
        mo34325a((CharSequence) ": ");
        mo34325a((CharSequence) str2);
        mo34325a((CharSequence) "\r\n");
        return this;
    }

    /* renamed from: b */
    public BufferedInputStream mo34339b() throws HttpRequestException {
        return new BufferedInputStream(mo34358n(), this.f16247h);
    }

    /* renamed from: a */
    public static String m19954a(CharSequence charSequence, Map<?, ?> map) {
        String charSequence2 = charSequence.toString();
        if (map == null || map.isEmpty()) {
            return charSequence2;
        }
        StringBuilder sb = new StringBuilder(charSequence2);
        m19958b(charSequence2, sb);
        m19955a(charSequence2, sb);
        Iterator<Map.Entry<?, ?>> it = map.entrySet().iterator();
        Map.Entry next = it.next();
        sb.append(next.getKey().toString());
        sb.append('=');
        Object value = next.getValue();
        if (value != null) {
            sb.append(value);
        }
        while (it.hasNext()) {
            sb.append('&');
            Map.Entry next2 = it.next();
            sb.append(next2.getKey().toString());
            sb.append('=');
            Object value2 = next2.getValue();
            if (value2 != null) {
                sb.append(value2);
            }
        }
        return sb.toString();
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006f A[EDGE_INSN: B:30:0x006f->B:29:0x006f ?: BREAK  , SYNTHETIC] */
    /* renamed from: b */
    protected java.lang.String mo34340b(java.lang.String r9, java.lang.String r10) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L_0x006f
            int r1 = r9.length()
            if (r1 != 0) goto L_0x000a
            goto L_0x006f
        L_0x000a:
            int r1 = r9.length()
            r2 = 59
            int r3 = r9.indexOf(r2)
            r4 = 1
            int r3 = r3 + r4
            if (r3 == 0) goto L_0x006f
            if (r3 != r1) goto L_0x001b
            goto L_0x006f
        L_0x001b:
            int r5 = r9.indexOf(r2, r3)
            r6 = -1
            if (r5 != r6) goto L_0x0023
        L_0x0022:
            r5 = r1
        L_0x0023:
            if (r3 >= r5) goto L_0x006f
            r7 = 61
            int r7 = r9.indexOf(r7, r3)
            if (r7 == r6) goto L_0x0066
            if (r7 >= r5) goto L_0x0066
            java.lang.String r3 = r9.substring(r3, r7)
            java.lang.String r3 = r3.trim()
            boolean r3 = r10.equals(r3)
            if (r3 == 0) goto L_0x0066
            int r7 = r7 + 1
            java.lang.String r3 = r9.substring(r7, r5)
            java.lang.String r3 = r3.trim()
            int r7 = r3.length()
            if (r7 == 0) goto L_0x0066
            r9 = 2
            if (r7 <= r9) goto L_0x0065
            r9 = 0
            char r9 = r3.charAt(r9)
            r10 = 34
            if (r10 != r9) goto L_0x0065
            int r7 = r7 - r4
            char r9 = r3.charAt(r7)
            if (r10 != r9) goto L_0x0065
            java.lang.String r9 = r3.substring(r4, r7)
            return r9
        L_0x0065:
            return r3
        L_0x0066:
            int r3 = r5 + 1
            int r5 = r9.indexOf(r2, r3)
            if (r5 != r6) goto L_0x0023
            goto L_0x0022
        L_0x006f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p118io.fabric.sdk.android.services.network.HttpRequest.mo34340b(java.lang.String, java.lang.String):java.lang.String");
    }

    /* renamed from: e */
    public HttpRequest mo34348e(String str, String str2) {
        mo34329a(str, (String) null, str2);
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public ByteArrayOutputStream mo34342c() {
        int i = mo34353i();
        if (i > 0) {
            return new ByteArrayOutputStream(i);
        }
        return new ByteArrayOutputStream();
    }

    /* renamed from: b */
    public HttpRequest mo34337b(String str) {
        mo34327a(str, (String) null);
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public HttpRequest mo34338b(String str, String str2, String str3) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("form-data; name=\"");
        sb.append(str);
        if (str2 != null) {
            sb.append("\"; filename=\"");
            sb.append(str2);
        }
        sb.append('\"');
        mo34350f("Content-Disposition", sb.toString());
        if (str3 != null) {
            mo34350f("Content-Type", str3);
        }
        mo34325a((CharSequence) "\r\n");
        return this;
    }

    /* renamed from: c */
    public HttpRequest mo34341c(String str, String str2) {
        mo34354j().setRequestProperty(str, str2);
        return this;
    }

    /* renamed from: c */
    public String mo34343c(String str) throws HttpRequestException {
        mo34349f();
        return mo34354j().getHeaderField(str);
    }

    /* renamed from: a */
    public static HttpRequest m19953a(CharSequence charSequence, Map<?, ?> map, boolean z) {
        String a = m19954a(charSequence, map);
        if (z) {
            a = m19959c((CharSequence) a);
        }
        return m19960d((CharSequence) a);
    }

    /* renamed from: a */
    public String mo34336a(String str) throws HttpRequestException {
        ByteArrayOutputStream c = mo34342c();
        try {
            mo34324a((InputStream) mo34339b(), (OutputStream) c);
            return c.toString(m19964f(str));
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    /* renamed from: a */
    public String mo34335a() throws HttpRequestException {
        return mo34336a(mo34345d());
    }

    /* renamed from: a */
    public HttpRequest mo34323a(int i) {
        mo34354j().setConnectTimeout(i);
        return this;
    }

    /* renamed from: a */
    public HttpRequest mo34333a(Map.Entry<String, String> entry) {
        mo34341c(entry.getKey(), entry.getValue());
        return this;
    }

    /* renamed from: a */
    public int mo34322a(String str, int i) throws HttpRequestException {
        mo34349f();
        return mo34354j().getHeaderFieldInt(str, i);
    }

    /* renamed from: a */
    public HttpRequest mo34334a(boolean z) {
        mo34354j().setUseCaches(z);
        return this;
    }

    /* renamed from: a */
    public HttpRequest mo34327a(String str, String str2) {
        if (str2 == null || str2.length() <= 0) {
            mo34341c("Content-Type", str);
            return this;
        }
        mo34341c("Content-Type", str + "; charset=" + str2);
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public HttpRequest mo34324a(InputStream inputStream, OutputStream outputStream) throws IOException {
        return (HttpRequest) new C6190a(inputStream, this.f16245f, inputStream, outputStream).call();
    }

    /* renamed from: a */
    public HttpRequest mo34329a(String str, String str2, String str3) throws HttpRequestException {
        mo34332a(str, str2, (String) null, str3);
        return this;
    }

    /* renamed from: a */
    public HttpRequest mo34332a(String str, String str2, String str3, String str4) throws HttpRequestException {
        try {
            mo34357m();
            mo34338b(str, str2, str3);
            this.f16243d.mo34367a(str4);
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    /* renamed from: a */
    public HttpRequest mo34326a(String str, Number number) throws HttpRequestException {
        mo34328a(str, (String) null, number);
        return this;
    }

    /* renamed from: a */
    public HttpRequest mo34328a(String str, String str2, Number number) throws HttpRequestException {
        mo34329a(str, str2, number != null ? number.toString() : null);
        return this;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0023 A[SYNTHETIC, Splitter:B:19:0x0023] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p118io.fabric.sdk.android.services.network.HttpRequest mo34330a(java.lang.String r4, java.lang.String r5, java.lang.String r6, java.io.File r7) throws p118io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException {
        /*
            r3 = this;
            r0 = 0
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x001a }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ IOException -> 0x001a }
            r2.<init>(r7)     // Catch:{ IOException -> 0x001a }
            r1.<init>(r2)     // Catch:{ IOException -> 0x001a }
            r3.mo34331a((java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6, (java.io.InputStream) r1)     // Catch:{ IOException -> 0x0015, all -> 0x0012 }
            r1.close()     // Catch:{ IOException -> 0x0011 }
        L_0x0011:
            return r3
        L_0x0012:
            r4 = move-exception
            r0 = r1
            goto L_0x0021
        L_0x0015:
            r4 = move-exception
            r0 = r1
            goto L_0x001b
        L_0x0018:
            r4 = move-exception
            goto L_0x0021
        L_0x001a:
            r4 = move-exception
        L_0x001b:
            io.fabric.sdk.android.services.network.HttpRequest$HttpRequestException r5 = new io.fabric.sdk.android.services.network.HttpRequest$HttpRequestException     // Catch:{ all -> 0x0018 }
            r5.<init>(r4)     // Catch:{ all -> 0x0018 }
            throw r5     // Catch:{ all -> 0x0018 }
        L_0x0021:
            if (r0 == 0) goto L_0x0026
            r0.close()     // Catch:{ IOException -> 0x0026 }
        L_0x0026:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p118io.fabric.sdk.android.services.network.HttpRequest.mo34330a(java.lang.String, java.lang.String, java.lang.String, java.io.File):io.fabric.sdk.android.services.network.HttpRequest");
    }

    /* renamed from: a */
    public HttpRequest mo34331a(String str, String str2, String str3, InputStream inputStream) throws HttpRequestException {
        try {
            mo34357m();
            mo34338b(str, str2, str3);
            mo34324a(inputStream, (OutputStream) this.f16243d);
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    /* renamed from: a */
    public HttpRequest mo34325a(CharSequence charSequence) throws HttpRequestException {
        try {
            mo34356l();
            this.f16243d.mo34367a(charSequence.toString());
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }
}
