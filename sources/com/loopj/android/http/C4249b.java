package com.loopj.android.http;

import com.facebook.share.internal.ShareConstants;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.atomic.AtomicBoolean;
import p163cz.msebera.android.httpclient.C5691d;
import p163cz.msebera.android.httpclient.client.p169o.C5594c;
import p163cz.msebera.android.httpclient.client.p169o.C5600i;
import p163cz.msebera.android.httpclient.impl.client.C5780a;
import p163cz.msebera.android.httpclient.p186j0.C5875e;

/* renamed from: com.loopj.android.http.b */
/* compiled from: AsyncHttpRequest */
public class C4249b implements Runnable {

    /* renamed from: a */
    private final C5780a f11395a;

    /* renamed from: b */
    private final C5875e f11396b;

    /* renamed from: c */
    private final C5600i f11397c;

    /* renamed from: d */
    private final C4264n f11398d;

    /* renamed from: e */
    private final AtomicBoolean f11399e = new AtomicBoolean();

    /* renamed from: f */
    private int f11400f;

    /* renamed from: g */
    private boolean f11401g;

    /* renamed from: h */
    private volatile boolean f11402h;

    /* renamed from: i */
    private boolean f11403i;

    public C4249b(C5780a aVar, C5875e eVar, C5600i iVar, C4264n nVar) {
        C4266p.m14397a(aVar, "client");
        this.f11395a = aVar;
        C4266p.m14397a(eVar, "context");
        this.f11396b = eVar;
        C4266p.m14397a(iVar, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        this.f11397c = iVar;
        C4266p.m14397a(nVar, "responseHandler");
        this.f11398d = nVar;
    }

    /* renamed from: c */
    private void m14357c() throws IOException {
        if (!mo28851a()) {
            if (this.f11397c.getURI().getScheme() != null) {
                C4264n nVar = this.f11398d;
                if (nVar instanceof C4260k) {
                    ((C4260k) nVar).mo28918a(this.f11397c);
                }
                C5594c a = this.f11395a.mo33498a(this.f11397c, this.f11396b);
                if (!mo28851a()) {
                    C4264n nVar2 = this.f11398d;
                    nVar2.onPreProcessResponse(nVar2, a);
                    if (!mo28851a()) {
                        this.f11398d.sendResponseMessage(a);
                        if (!mo28851a()) {
                            C4264n nVar3 = this.f11398d;
                            nVar3.onPostProcessResponse(nVar3, a);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            throw new MalformedURLException("No valid URI scheme was provided");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0081 A[Catch:{ Exception -> 0x000f }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0009 A[SYNTHETIC] */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m14358d() throws java.io.IOException {
        /*
            r7 = this;
            cz.msebera.android.httpclient.impl.client.a r0 = r7.f11395a
            cz.msebera.android.httpclient.client.h r0 = r0.mo33476o0()
            r1 = 1
            r2 = 0
            r3 = 1
        L_0x0009:
            if (r3 == 0) goto L_0x00ac
            r7.m14357c()     // Catch:{ UnknownHostException -> 0x004d, NullPointerException -> 0x0026, IOException -> 0x0012 }
            return
        L_0x000f:
            r0 = move-exception
            goto L_0x0089
        L_0x0012:
            r2 = move-exception
            boolean r3 = r7.mo28851a()     // Catch:{ Exception -> 0x000f }
            if (r3 == 0) goto L_0x001a
            return
        L_0x001a:
            int r3 = r7.f11400f     // Catch:{ Exception -> 0x000f }
            int r3 = r3 + r1
            r7.f11400f = r3     // Catch:{ Exception -> 0x000f }
            cz.msebera.android.httpclient.j0.e r4 = r7.f11396b     // Catch:{ Exception -> 0x000f }
            boolean r3 = r0.mo28925a(r2, r3, r4)     // Catch:{ Exception -> 0x000f }
            goto L_0x007f
        L_0x0026:
            r2 = move-exception
            java.io.IOException r3 = new java.io.IOException     // Catch:{ Exception -> 0x000f }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x000f }
            r4.<init>()     // Catch:{ Exception -> 0x000f }
            java.lang.String r5 = "NPE in HttpClient: "
            r4.append(r5)     // Catch:{ Exception -> 0x000f }
            java.lang.String r2 = r2.getMessage()     // Catch:{ Exception -> 0x000f }
            r4.append(r2)     // Catch:{ Exception -> 0x000f }
            java.lang.String r2 = r4.toString()     // Catch:{ Exception -> 0x000f }
            r3.<init>(r2)     // Catch:{ Exception -> 0x000f }
            int r2 = r7.f11400f     // Catch:{ Exception -> 0x000f }
            int r2 = r2 + r1
            r7.f11400f = r2     // Catch:{ Exception -> 0x000f }
            cz.msebera.android.httpclient.j0.e r4 = r7.f11396b     // Catch:{ Exception -> 0x000f }
            boolean r2 = r0.mo28925a(r3, r2, r4)     // Catch:{ Exception -> 0x000f }
            goto L_0x007c
        L_0x004d:
            r2 = move-exception
            java.io.IOException r3 = new java.io.IOException     // Catch:{ Exception -> 0x000f }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x000f }
            r4.<init>()     // Catch:{ Exception -> 0x000f }
            java.lang.String r5 = "UnknownHostException exception: "
            r4.append(r5)     // Catch:{ Exception -> 0x000f }
            java.lang.String r5 = r2.getMessage()     // Catch:{ Exception -> 0x000f }
            r4.append(r5)     // Catch:{ Exception -> 0x000f }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x000f }
            r3.<init>(r4)     // Catch:{ Exception -> 0x000f }
            int r4 = r7.f11400f     // Catch:{ Exception -> 0x000f }
            if (r4 <= 0) goto L_0x007b
            int r4 = r7.f11400f     // Catch:{ Exception -> 0x000f }
            int r4 = r4 + r1
            r7.f11400f = r4     // Catch:{ Exception -> 0x000f }
            cz.msebera.android.httpclient.j0.e r5 = r7.f11396b     // Catch:{ Exception -> 0x000f }
            boolean r2 = r0.mo28925a(r2, r4, r5)     // Catch:{ Exception -> 0x000f }
            if (r2 == 0) goto L_0x007b
            r2 = 1
            goto L_0x007c
        L_0x007b:
            r2 = 0
        L_0x007c:
            r6 = r3
            r3 = r2
            r2 = r6
        L_0x007f:
            if (r3 == 0) goto L_0x0009
            com.loopj.android.http.n r4 = r7.f11398d     // Catch:{ Exception -> 0x000f }
            int r5 = r7.f11400f     // Catch:{ Exception -> 0x000f }
            r4.sendRetryMessage(r5)     // Catch:{ Exception -> 0x000f }
            goto L_0x0009
        L_0x0089:
            com.loopj.android.http.h r1 = com.loopj.android.http.C4244a.f11381j
            java.lang.String r2 = "AsyncHttpRequest"
            java.lang.String r3 = "Unhandled exception origin cause"
            r1.mo28908b(r2, r3, r0)
            java.io.IOException r2 = new java.io.IOException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Unhandled exception: "
            r1.append(r3)
            java.lang.String r0 = r0.getMessage()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r2.<init>(r0)
        L_0x00ac:
            goto L_0x00ae
        L_0x00ad:
            throw r2
        L_0x00ae:
            goto L_0x00ad
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loopj.android.http.C4249b.m14358d():void");
    }

    /* renamed from: e */
    private synchronized void m14359e() {
        if (!this.f11402h && this.f11399e.get() && !this.f11401g) {
            this.f11401g = true;
            this.f11398d.sendCancelMessage();
        }
    }

    /* renamed from: a */
    public void mo28850a(C4249b bVar) {
    }

    /* renamed from: a */
    public boolean mo28851a() {
        boolean z = this.f11399e.get();
        if (z) {
            m14359e();
        }
        return z;
    }

    /* renamed from: b */
    public void mo28853b(C4249b bVar) {
    }

    /* renamed from: b */
    public boolean mo28854b() {
        return mo28851a() || this.f11402h;
    }

    public void run() {
        if (!mo28851a()) {
            if (!this.f11403i) {
                this.f11403i = true;
                mo28853b(this);
            }
            if (!mo28851a()) {
                this.f11398d.sendStartMessage();
                if (!mo28851a()) {
                    try {
                        m14358d();
                    } catch (IOException e) {
                        if (!mo28851a()) {
                            this.f11398d.sendFailureMessage(0, (C5691d[]) null, (byte[]) null, e);
                        } else {
                            C4244a.f11381j.mo28908b("AsyncHttpRequest", "makeRequestWithRetries returned error", e);
                        }
                    }
                    if (!mo28851a()) {
                        this.f11398d.sendFinishMessage();
                        if (!mo28851a()) {
                            mo28850a(this);
                            this.f11402h = true;
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public boolean mo28852a(boolean z) {
        this.f11399e.set(true);
        this.f11397c.abort();
        return mo28851a();
    }
}
