package p163cz.msebera.android.httpclient;

import p163cz.msebera.android.httpclient.p183h0.C5759e;

/* renamed from: cz.msebera.android.httpclient.n */
/* compiled from: HttpMessage */
public interface C5898n {
    /* renamed from: a */
    void mo33293a(C5691d dVar);

    @Deprecated
    /* renamed from: a */
    void mo33294a(C5759e eVar);

    /* renamed from: a */
    void mo33295a(C5691d[] dVarArr);

    void addHeader(String str, String str2);

    /* renamed from: b */
    void mo33297b(C5691d dVar);

    boolean containsHeader(String str);

    C5691d[] getAllHeaders();

    C5691d getFirstHeader(String str);

    C5691d[] getHeaders(String str);

    @Deprecated
    C5759e getParams();

    C5907v getProtocolVersion();

    C5730g headerIterator();

    C5730g headerIterator(String str);

    void removeHeaders(String str);

    void setHeader(String str, String str2);
}
