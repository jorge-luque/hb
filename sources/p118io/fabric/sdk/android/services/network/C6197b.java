package p118io.fabric.sdk.android.services.network;

import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import p118io.fabric.sdk.android.C6058b;
import p118io.fabric.sdk.android.C6072k;

/* renamed from: io.fabric.sdk.android.services.network.b */
/* compiled from: DefaultHttpRequestFactory */
public class C6197b implements C6200d {

    /* renamed from: a */
    private final C6072k f16257a;

    /* renamed from: b */
    private C6202f f16258b;

    /* renamed from: c */
    private SSLSocketFactory f16259c;

    /* renamed from: d */
    private boolean f16260d;

    /* renamed from: io.fabric.sdk.android.services.network.b$a */
    /* compiled from: DefaultHttpRequestFactory */
    static /* synthetic */ class C6198a {

        /* renamed from: a */
        static final /* synthetic */ int[] f16261a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                io.fabric.sdk.android.services.network.c[] r0 = p118io.fabric.sdk.android.services.network.C6199c.m20024a()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f16261a = r0
                io.fabric.sdk.android.services.network.c r1 = p118io.fabric.sdk.android.services.network.C6199c.GET     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f16261a     // Catch:{ NoSuchFieldError -> 0x001d }
                io.fabric.sdk.android.services.network.c r1 = p118io.fabric.sdk.android.services.network.C6199c.POST     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f16261a     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.fabric.sdk.android.services.network.c r1 = p118io.fabric.sdk.android.services.network.C6199c.PUT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f16261a     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.fabric.sdk.android.services.network.c r1 = p118io.fabric.sdk.android.services.network.C6199c.DELETE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p118io.fabric.sdk.android.services.network.C6197b.C6198a.<clinit>():void");
        }
    }

    public C6197b() {
        this(new C6058b());
    }

    /* renamed from: b */
    private synchronized SSLSocketFactory m20019b() {
        SSLSocketFactory a;
        this.f16260d = true;
        try {
            a = C6201e.m20028a(this.f16258b);
            this.f16257a.mo34093d("Fabric", "Custom SSL pinning enabled");
        } catch (Exception e) {
            this.f16257a.mo34090b("Fabric", "Exception while validating pinned certs", e);
            return null;
        }
        return a;
    }

    /* renamed from: c */
    private synchronized void m20020c() {
        this.f16260d = false;
        this.f16259c = null;
    }

    /* renamed from: a */
    public void mo34370a(C6202f fVar) {
        if (this.f16258b != fVar) {
            this.f16258b = fVar;
            m20020c();
        }
    }

    public C6197b(C6072k kVar) {
        this.f16257a = kVar;
    }

    /* renamed from: a */
    public HttpRequest mo34368a(C6199c cVar, String str) {
        return mo34369a(cVar, str, Collections.emptyMap());
    }

    /* renamed from: a */
    public HttpRequest mo34369a(C6199c cVar, String str, Map<String, String> map) {
        HttpRequest httpRequest;
        SSLSocketFactory a;
        int i = C6198a.f16261a[cVar.ordinal()];
        if (i == 1) {
            httpRequest = HttpRequest.m19953a((CharSequence) str, (Map<?, ?>) map, true);
        } else if (i == 2) {
            httpRequest = HttpRequest.m19957b((CharSequence) str, (Map<?, ?>) map, true);
        } else if (i == 3) {
            httpRequest = HttpRequest.m19963f((CharSequence) str);
        } else if (i == 4) {
            httpRequest = HttpRequest.m19956b((CharSequence) str);
        } else {
            throw new IllegalArgumentException("Unsupported HTTP method!");
        }
        if (!(!m20018a(str) || this.f16258b == null || (a = m20017a()) == null)) {
            ((HttpsURLConnection) httpRequest.mo34354j()).setSSLSocketFactory(a);
        }
        return httpRequest;
    }

    /* renamed from: a */
    private boolean m20018a(String str) {
        return str != null && str.toLowerCase(Locale.US).startsWith("https");
    }

    /* renamed from: a */
    private synchronized SSLSocketFactory m20017a() {
        if (this.f16259c == null && !this.f16260d) {
            this.f16259c = m20019b();
        }
        return this.f16259c;
    }
}
