package p118io.fabric.sdk.android.p200m.p205e;

import com.facebook.share.internal.ShareConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import p118io.fabric.sdk.android.C6059c;
import p118io.fabric.sdk.android.C6069h;
import p118io.fabric.sdk.android.C6072k;
import p118io.fabric.sdk.android.p200m.p202b.C6078a;
import p118io.fabric.sdk.android.p200m.p202b.C6090i;
import p118io.fabric.sdk.android.services.network.C6199c;
import p118io.fabric.sdk.android.services.network.C6200d;
import p118io.fabric.sdk.android.services.network.HttpRequest;

/* renamed from: io.fabric.sdk.android.m.e.l */
/* compiled from: DefaultSettingsSpiCall */
class C6145l extends C6078a implements C6159x {
    public C6145l(C6069h hVar, String str, String str2, C6200d dVar) {
        this(hVar, str, str2, dVar, C6199c.GET);
    }

    /* renamed from: b */
    private Map<String, String> m19897b(C6158w wVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("build_version", wVar.f16188h);
        hashMap.put("display_version", wVar.f16187g);
        hashMap.put(ShareConstants.FEED_SOURCE_PARAM, Integer.toString(wVar.f16189i));
        String str = wVar.f16190j;
        if (str != null) {
            hashMap.put("icon_hash", str);
        }
        String str2 = wVar.f16186f;
        if (!C6090i.m19743b(str2)) {
            hashMap.put("instance", str2);
        }
        return hashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: io.fabric.sdk.android.services.network.HttpRequest} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v2, types: [org.json.JSONObject] */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0087  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.json.JSONObject mo34256a(p118io.fabric.sdk.android.p200m.p205e.C6158w r9) {
        /*
            r8 = this;
            java.lang.String r0 = "X-REQUEST-ID"
            java.lang.String r1 = "Settings request ID: "
            java.lang.String r2 = "Fabric"
            r3 = 0
            java.util.Map r4 = r8.m19897b(r9)     // Catch:{ HttpRequestException -> 0x006b, all -> 0x0069 }
            io.fabric.sdk.android.services.network.HttpRequest r5 = r8.getHttpRequest(r4)     // Catch:{ HttpRequestException -> 0x006b, all -> 0x0069 }
            r8.m19894a(r5, r9)     // Catch:{ HttpRequestException -> 0x0067 }
            io.fabric.sdk.android.k r9 = p118io.fabric.sdk.android.C6059c.m19630f()     // Catch:{ HttpRequestException -> 0x0067 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ HttpRequestException -> 0x0067 }
            r6.<init>()     // Catch:{ HttpRequestException -> 0x0067 }
            java.lang.String r7 = "Requesting settings from "
            r6.append(r7)     // Catch:{ HttpRequestException -> 0x0067 }
            java.lang.String r7 = r8.getUrl()     // Catch:{ HttpRequestException -> 0x0067 }
            r6.append(r7)     // Catch:{ HttpRequestException -> 0x0067 }
            java.lang.String r6 = r6.toString()     // Catch:{ HttpRequestException -> 0x0067 }
            r9.mo34093d(r2, r6)     // Catch:{ HttpRequestException -> 0x0067 }
            io.fabric.sdk.android.k r9 = p118io.fabric.sdk.android.C6059c.m19630f()     // Catch:{ HttpRequestException -> 0x0067 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ HttpRequestException -> 0x0067 }
            r6.<init>()     // Catch:{ HttpRequestException -> 0x0067 }
            java.lang.String r7 = "Settings query params were: "
            r6.append(r7)     // Catch:{ HttpRequestException -> 0x0067 }
            r6.append(r4)     // Catch:{ HttpRequestException -> 0x0067 }
            java.lang.String r4 = r6.toString()     // Catch:{ HttpRequestException -> 0x0067 }
            r9.mo34093d(r2, r4)     // Catch:{ HttpRequestException -> 0x0067 }
            org.json.JSONObject r3 = r8.mo34257a((p118io.fabric.sdk.android.services.network.HttpRequest) r5)     // Catch:{ HttpRequestException -> 0x0067 }
            if (r5 == 0) goto L_0x0082
            io.fabric.sdk.android.k r9 = p118io.fabric.sdk.android.C6059c.m19630f()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
        L_0x0055:
            r4.append(r1)
            java.lang.String r0 = r5.mo34343c((java.lang.String) r0)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r9.mo34093d(r2, r0)
            goto L_0x0082
        L_0x0067:
            r9 = move-exception
            goto L_0x006d
        L_0x0069:
            r9 = move-exception
            goto L_0x0085
        L_0x006b:
            r9 = move-exception
            r5 = r3
        L_0x006d:
            io.fabric.sdk.android.k r4 = p118io.fabric.sdk.android.C6059c.m19630f()     // Catch:{ all -> 0x0083 }
            java.lang.String r6 = "Settings request failed."
            r4.mo34090b(r2, r6, r9)     // Catch:{ all -> 0x0083 }
            if (r5 == 0) goto L_0x0082
            io.fabric.sdk.android.k r9 = p118io.fabric.sdk.android.C6059c.m19630f()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            goto L_0x0055
        L_0x0082:
            return r3
        L_0x0083:
            r9 = move-exception
            r3 = r5
        L_0x0085:
            if (r3 == 0) goto L_0x00a1
            io.fabric.sdk.android.k r4 = p118io.fabric.sdk.android.C6059c.m19630f()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r1)
            java.lang.String r0 = r3.mo34343c((java.lang.String) r0)
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            r4.mo34093d(r2, r0)
        L_0x00a1:
            goto L_0x00a3
        L_0x00a2:
            throw r9
        L_0x00a3:
            goto L_0x00a2
        */
        throw new UnsupportedOperationException("Method not decompiled: p118io.fabric.sdk.android.p200m.p205e.C6145l.mo34256a(io.fabric.sdk.android.m.e.w):org.json.JSONObject");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo34258a(int i) {
        return i == 200 || i == 201 || i == 202 || i == 203;
    }

    C6145l(C6069h hVar, String str, String str2, C6200d dVar, C6199c cVar) {
        super(hVar, str, str2, dVar, cVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public JSONObject mo34257a(HttpRequest httpRequest) {
        int g = httpRequest.mo34351g();
        C6072k f = C6059c.m19630f();
        f.mo34093d("Fabric", "Settings result was: " + g);
        if (mo34258a(g)) {
            return m19895a(httpRequest.mo34335a());
        }
        C6072k f2 = C6059c.m19630f();
        f2.mo34089b("Fabric", "Failed to retrieve settings from " + getUrl());
        return null;
    }

    /* renamed from: a */
    private JSONObject m19895a(String str) {
        try {
            return new JSONObject(str);
        } catch (Exception e) {
            C6072k f = C6059c.m19630f();
            f.mo34092c("Fabric", "Failed to parse settings JSON from " + getUrl(), e);
            C6072k f2 = C6059c.m19630f();
            f2.mo34093d("Fabric", "Settings response " + str);
            return null;
        }
    }

    /* renamed from: a */
    private HttpRequest m19894a(HttpRequest httpRequest, C6158w wVar) {
        m19896a(httpRequest, C6078a.HEADER_API_KEY, wVar.f16181a);
        m19896a(httpRequest, C6078a.HEADER_CLIENT_TYPE, "android");
        m19896a(httpRequest, C6078a.HEADER_CLIENT_VERSION, this.kit.getVersion());
        m19896a(httpRequest, C6078a.HEADER_ACCEPT, C6078a.ACCEPT_JSON_VALUE);
        m19896a(httpRequest, "X-CRASHLYTICS-DEVICE-MODEL", wVar.f16182b);
        m19896a(httpRequest, "X-CRASHLYTICS-OS-BUILD-VERSION", wVar.f16183c);
        m19896a(httpRequest, "X-CRASHLYTICS-OS-DISPLAY-VERSION", wVar.f16184d);
        m19896a(httpRequest, "X-CRASHLYTICS-INSTALLATION-ID", wVar.f16185e);
        return httpRequest;
    }

    /* renamed from: a */
    private void m19896a(HttpRequest httpRequest, String str, String str2) {
        if (str2 != null) {
            httpRequest.mo34341c(str, str2);
        }
    }
}
