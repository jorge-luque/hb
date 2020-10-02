package com.loopj.android.http;

import android.content.Context;
import com.facebook.internal.Utility;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.GZIPInputStream;
import p118io.fabric.sdk.android.p200m.p202b.C6078a;
import p163cz.msebera.android.httpclient.C5691d;
import p163cz.msebera.android.httpclient.C5696e;
import p163cz.msebera.android.httpclient.C5870j;
import p163cz.msebera.android.httpclient.C5896l;
import p163cz.msebera.android.httpclient.C5899o;
import p163cz.msebera.android.httpclient.C5900p;
import p163cz.msebera.android.httpclient.C5901q;
import p163cz.msebera.android.httpclient.C5903s;
import p163cz.msebera.android.httpclient.C5905t;
import p163cz.msebera.android.httpclient.C5907v;
import p163cz.msebera.android.httpclient.HttpException;
import p163cz.msebera.android.httpclient.auth.C5549c;
import p163cz.msebera.android.httpclient.auth.C5554g;
import p163cz.msebera.android.httpclient.auth.C5555h;
import p163cz.msebera.android.httpclient.auth.C5559l;
import p163cz.msebera.android.httpclient.client.C5581g;
import p163cz.msebera.android.httpclient.client.C5582h;
import p163cz.msebera.android.httpclient.client.C5583i;
import p163cz.msebera.android.httpclient.client.p169o.C5596e;
import p163cz.msebera.android.httpclient.client.p169o.C5598g;
import p163cz.msebera.android.httpclient.client.p169o.C5600i;
import p163cz.msebera.android.httpclient.conn.C5624b;
import p163cz.msebera.android.httpclient.conn.p173q.C5639a;
import p163cz.msebera.android.httpclient.conn.p173q.C5641b;
import p163cz.msebera.android.httpclient.conn.p173q.C5642c;
import p163cz.msebera.android.httpclient.conn.p175s.C5655d;
import p163cz.msebera.android.httpclient.conn.p175s.C5656e;
import p163cz.msebera.android.httpclient.conn.p175s.C5660i;
import p163cz.msebera.android.httpclient.conn.p175s.C5663l;
import p163cz.msebera.android.httpclient.conn.ssl.C5672h;
import p163cz.msebera.android.httpclient.impl.auth.C5765b;
import p163cz.msebera.android.httpclient.impl.client.C5790k;
import p163cz.msebera.android.httpclient.impl.conn.p185r.C5830g;
import p163cz.msebera.android.httpclient.p166c0.C5573f;
import p163cz.msebera.android.httpclient.p183h0.C5756b;
import p163cz.msebera.android.httpclient.p183h0.C5757c;
import p163cz.msebera.android.httpclient.p183h0.C5759e;
import p163cz.msebera.android.httpclient.p183h0.C5760f;
import p163cz.msebera.android.httpclient.p186j0.C5871a;
import p163cz.msebera.android.httpclient.p186j0.C5875e;
import p163cz.msebera.android.httpclient.p186j0.C5884n;

/* renamed from: com.loopj.android.http.a */
/* compiled from: AsyncHttpClient */
public class C4244a {

    /* renamed from: j */
    public static C4256h f11381j = new C4255g();

    /* renamed from: a */
    private final C5790k f11382a;

    /* renamed from: b */
    private final C5875e f11383b;

    /* renamed from: c */
    private final Map<Context, List<C4261l>> f11384c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Map<String, String> f11385d;

    /* renamed from: e */
    private int f11386e;

    /* renamed from: f */
    private int f11387f;

    /* renamed from: g */
    private int f11388g;

    /* renamed from: h */
    private ExecutorService f11389h;

    /* renamed from: i */
    private boolean f11390i;

    /* renamed from: com.loopj.android.http.a$a */
    /* compiled from: AsyncHttpClient */
    class C4245a implements C5900p {
        C4245a() {
        }

        /* renamed from: a */
        public void mo28845a(C5899o oVar, C5875e eVar) {
            if (!oVar.containsHeader("Accept-Encoding")) {
                oVar.addHeader("Accept-Encoding", "gzip");
            }
            for (String str : C4244a.this.f11385d.keySet()) {
                if (oVar.containsHeader(str)) {
                    C5691d firstHeader = oVar.getFirstHeader(str);
                    C4244a.f11381j.mo28910d("AsyncHttpClient", String.format("Headers were overwritten! (%s | %s) overwrites (%s | %s)", new Object[]{str, C4244a.this.f11385d.get(str), firstHeader.getName(), firstHeader.getValue()}));
                    oVar.mo33297b(firstHeader);
                }
                oVar.addHeader(str, (String) C4244a.this.f11385d.get(str));
            }
        }
    }

    /* renamed from: com.loopj.android.http.a$b */
    /* compiled from: AsyncHttpClient */
    class C4246b implements C5903s {
        C4246b(C4244a aVar) {
        }

        /* renamed from: a */
        public void mo28846a(C5901q qVar, C5875e eVar) {
            C5691d c;
            C5870j entity = qVar.getEntity();
            if (entity != null && (c = entity.mo32894c()) != null) {
                for (C5696e name : c.mo33162b()) {
                    if (name.getName().equalsIgnoreCase("gzip")) {
                        qVar.mo33337a(new C4248d(entity));
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: com.loopj.android.http.a$c */
    /* compiled from: AsyncHttpClient */
    class C4247c implements C5900p {
        C4247c(C4244a aVar) {
        }

        /* renamed from: a */
        public void mo28845a(C5899o oVar, C5875e eVar) throws HttpException, IOException {
            C5559l a;
            C5555h hVar = (C5555h) eVar.mo33533a("http.auth.target-scope");
            C5581g gVar = (C5581g) eVar.mo33533a("http.auth.credentials-provider");
            C5896l lVar = (C5896l) eVar.mo33533a("http.target_host");
            if (hVar.mo32858b() == null && (a = gVar.mo32925a(new C5554g(lVar.mo33685b(), lVar.mo33686c()))) != null) {
                hVar.mo32854a((C5549c) new C5765b());
                hVar.mo32856a(a);
            }
        }
    }

    /* renamed from: com.loopj.android.http.a$d */
    /* compiled from: AsyncHttpClient */
    private static class C4248d extends C5573f {

        /* renamed from: b */
        InputStream f11392b;

        /* renamed from: c */
        PushbackInputStream f11393c;

        /* renamed from: d */
        GZIPInputStream f11394d;

        public C4248d(C5870j jVar) {
            super(jVar);
        }

        /* renamed from: g */
        public void mo28847g() throws IOException {
            C4244a.m14334a(this.f11392b);
            C4244a.m14334a((InputStream) this.f11393c);
            C4244a.m14334a((InputStream) this.f11394d);
            super.mo28847g();
        }

        public InputStream getContent() throws IOException {
            this.f11392b = this.f14540a.getContent();
            PushbackInputStream pushbackInputStream = new PushbackInputStream(this.f11392b, 2);
            this.f11393c = pushbackInputStream;
            if (!C4244a.m14337a(pushbackInputStream)) {
                return this.f11393c;
            }
            GZIPInputStream gZIPInputStream = new GZIPInputStream(this.f11393c);
            this.f11394d = gZIPInputStream;
            return gZIPInputStream;
        }

        /* renamed from: h */
        public long mo28849h() {
            C5870j jVar = this.f14540a;
            if (jVar == null) {
                return 0;
            }
            return jVar.mo28849h();
        }
    }

    public C4244a() {
        this(false, 80, 443);
    }

    /* renamed from: b */
    public void mo28842b(int i) {
        if (i < 1000) {
            i = C6078a.DEFAULT_TIMEOUT;
        }
        this.f11388g = i;
        C5757c.m18341b(this.f11382a.mo33477p0(), this.f11388g);
    }

    /* renamed from: c */
    public void mo28844c(int i) {
        if (i < 1000) {
            i = C6078a.DEFAULT_TIMEOUT;
        }
        mo28837a(i);
        mo28842b(i);
    }

    public C4244a(boolean z, int i, int i2) {
        this(m14330a(z, i, i2));
    }

    /* renamed from: a */
    private static C5660i m14330a(boolean z, int i, int i2) {
        C5672h hVar;
        if (z) {
            f11381j.mo28910d("AsyncHttpClient", "Beware! Using the fix is insecure, as it doesn't verify SSL certificates.");
        }
        if (i < 1) {
            i = 80;
            f11381j.mo28910d("AsyncHttpClient", "Invalid HTTP port number specified, defaulting to 80");
        }
        if (i2 < 1) {
            i2 = 443;
            f11381j.mo28910d("AsyncHttpClient", "Invalid HTTPS port number specified, defaulting to 443");
        }
        if (z) {
            hVar = C4258j.m14384c();
        } else {
            hVar = C5672h.m18064b();
        }
        C5660i iVar = new C5660i();
        iVar.mo33093a(new C5656e("http", (C5663l) C5655d.m18013b(), i));
        iVar.mo33093a(new C5656e("https", (C5663l) hVar, i2));
        return iVar;
    }

    public C4244a(C5660i iVar) {
        this.f11386e = 10;
        this.f11387f = C6078a.DEFAULT_TIMEOUT;
        this.f11388g = C6078a.DEFAULT_TIMEOUT;
        boolean z = true;
        this.f11390i = true;
        C5756b bVar = new C5756b();
        C5639a.m17961a((C5759e) bVar, (long) this.f11387f);
        C5639a.m17962a((C5759e) bVar, (C5641b) new C5642c(this.f11386e));
        C5639a.m17960a((C5759e) bVar, 10);
        C5757c.m18341b(bVar, this.f11388g);
        C5757c.m18338a((C5759e) bVar, this.f11387f);
        C5757c.m18339a((C5759e) bVar, true);
        C5757c.m18342c(bVar, Utility.DEFAULT_STREAM_BUFFER_SIZE);
        C5760f.m18359a((C5759e) bVar, (C5907v) C5905t.f15130f);
        C5624b a = mo28835a(iVar, bVar);
        C4266p.m14398a(a == null ? false : z, "Custom implementation of #createConnectionManager(SchemeRegistry, BasicHttpParams) returned null");
        this.f11389h = mo28836a();
        this.f11384c = Collections.synchronizedMap(new WeakHashMap());
        this.f11385d = new HashMap();
        this.f11383b = new C5884n(new C5871a());
        C5790k kVar = new C5790k(a, bVar);
        this.f11382a = kVar;
        kVar.mo33456a((C5900p) new C4245a());
        this.f11382a.mo33458a((C5903s) new C4246b(this));
        this.f11382a.mo33457a(new C4247c(this), 0);
        this.f11382a.mo33454a((C5582h) new C4265o(5, 1500));
    }

    /* renamed from: b */
    public C4261l mo28840b(Context context, String str, C5691d[] dVarArr, C4263m mVar, C4264n nVar) {
        C5598g gVar = new C5598g(m14331a(this.f11390i, str, mVar));
        if (dVarArr != null) {
            gVar.mo33295a(dVarArr);
        }
        return mo28841b(this.f11382a, this.f11383b, gVar, (String) null, nVar, context);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C4261l mo28841b(C5790k kVar, C5875e eVar, C5600i iVar, String str, C4264n nVar, Context context) {
        List list;
        if (iVar == null) {
            throw new IllegalArgumentException("HttpUriRequest must not be null");
        } else if (nVar == null) {
            throw new IllegalArgumentException("ResponseHandler must not be null");
        } else if (!nVar.getUseSynchronousMode() || nVar.getUsePoolThread()) {
            if (str != null) {
                if (!(iVar instanceof C5596e) || ((C5596e) iVar).getEntity() == null || !iVar.containsHeader("Content-Type")) {
                    iVar.setHeader("Content-Type", str);
                } else {
                    f11381j.mo28903a("AsyncHttpClient", "Passed contentType will be ignored because HttpEntity sets content type");
                }
            }
            nVar.setRequestHeaders(iVar.getAllHeaders());
            nVar.setRequestURI(iVar.getURI());
            C4249b a = mo28831a(kVar, eVar, iVar, str, nVar, context);
            this.f11389h.submit(a);
            C4261l lVar = new C4261l(a);
            if (context != null) {
                synchronized (this.f11384c) {
                    list = this.f11384c.get(context);
                    if (list == null) {
                        list = Collections.synchronizedList(new LinkedList());
                        this.f11384c.put(context, list);
                    }
                }
                list.add(lVar);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (((C4261l) it.next()).mo28922c()) {
                        it.remove();
                    }
                }
            }
            return lVar;
        } else {
            throw new IllegalArgumentException("Synchronous ResponseHandler used in AsyncHttpClient. You should create your response handler in a looper thread or use SyncHttpClient instead.");
        }
    }

    /* renamed from: a */
    public static void m14336a(Class<?> cls) {
        if (cls != null) {
            C4265o.m14394a(cls);
        }
    }

    /* renamed from: a */
    public static String m14331a(boolean z, String str, C4263m mVar) {
        if (str == null) {
            return null;
        }
        if (z) {
            try {
                URL url = new URL(URLDecoder.decode(str, C4250c.DEFAULT_CHARSET));
                str = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef()).toASCIIString();
            } catch (Exception e) {
                f11381j.mo28908b("AsyncHttpClient", "getUrlWithQueryString encoding URL", e);
            }
        }
        if (mVar == null) {
            return str;
        }
        mVar.mo28924a();
        throw null;
    }

    /* renamed from: a */
    public static boolean m14337a(PushbackInputStream pushbackInputStream) throws IOException {
        if (pushbackInputStream == null) {
            return false;
        }
        byte[] bArr = new byte[2];
        int i = 0;
        while (i < 2) {
            try {
                int read = pushbackInputStream.read(bArr, i, 2 - i);
                if (read < 0) {
                    return false;
                }
                i += read;
            } finally {
                pushbackInputStream.unread(bArr, 0, i);
            }
        }
        pushbackInputStream.unread(bArr, 0, i);
        if (35615 == ((bArr[0] & 255) | ((bArr[1] << 8) & 65280))) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public static void m14334a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                f11381j.mo28904a("AsyncHttpClient", "Cannot close input stream", e);
            }
        }
    }

    /* renamed from: a */
    public static void m14335a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                f11381j.mo28904a("AsyncHttpClient", "Cannot close output stream", e);
            }
        }
    }

    /* renamed from: a */
    public static void m14333a(C5870j jVar) {
        if (jVar instanceof C5573f) {
            Field field = null;
            try {
                Field[] declaredFields = C5573f.class.getDeclaredFields();
                int length = declaredFields.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    Field field2 = declaredFields[i];
                    if (field2.getName().equals("wrappedEntity")) {
                        field = field2;
                        break;
                    }
                    i++;
                }
                if (field != null) {
                    field.setAccessible(true);
                    C5870j jVar2 = (C5870j) field.get(jVar);
                    if (jVar2 != null) {
                        jVar2.mo28847g();
                    }
                }
            } catch (Throwable th) {
                f11381j.mo28908b("AsyncHttpClient", "wrappedEntity consume", th);
            }
        }
    }

    /* renamed from: b */
    public void mo28843b(boolean z) {
        this.f11390i = z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public ExecutorService mo28836a() {
        return Executors.newCachedThreadPool();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C5624b mo28835a(C5660i iVar, C5756b bVar) {
        return new C5830g(bVar, iVar);
    }

    /* renamed from: a */
    public void mo28839a(boolean z, boolean z2, boolean z3) {
        this.f11382a.mo33477p0().mo33417a("http.protocol.reject-relative-redirect", !z2);
        this.f11382a.mo33477p0().mo33417a("http.protocol.allow-circular-redirects", z3);
        this.f11382a.mo33455a((C5583i) new C4257i(z));
    }

    /* renamed from: a */
    public void mo28838a(boolean z) {
        mo28839a(z, z, z);
    }

    /* renamed from: a */
    public void mo28837a(int i) {
        if (i < 1000) {
            i = C6078a.DEFAULT_TIMEOUT;
        }
        this.f11387f = i;
        C5759e p0 = this.f11382a.mo33477p0();
        C5639a.m17961a(p0, (long) this.f11387f);
        C5757c.m18338a(p0, this.f11387f);
    }

    /* renamed from: a */
    public C4261l mo28833a(Context context, String str, C4264n nVar) {
        return mo28832a(context, str, (C4263m) null, nVar);
    }

    /* renamed from: a */
    public C4261l mo28832a(Context context, String str, C4263m mVar, C4264n nVar) {
        return mo28841b(this.f11382a, this.f11383b, new C4254f(m14331a(this.f11390i, str, mVar)), (String) null, nVar, context);
    }

    /* renamed from: a */
    public C4261l mo28834a(Context context, String str, C5691d[] dVarArr, C4263m mVar, C4264n nVar) {
        C4254f fVar = new C4254f(m14331a(this.f11390i, str, mVar));
        if (dVarArr != null) {
            fVar.mo33295a(dVarArr);
        }
        return mo28841b(this.f11382a, this.f11383b, fVar, (String) null, nVar, context);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C4249b mo28831a(C5790k kVar, C5875e eVar, C5600i iVar, String str, C4264n nVar, Context context) {
        return new C4249b(kVar, eVar, iVar, nVar);
    }
}
