package com.applovin.impl.sdk.p052d;

import android.text.TextUtils;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.network.C1956a;
import com.applovin.impl.sdk.network.C1960b;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.p050b.C1842d;
import com.applovin.impl.sdk.p052d.C1907s;
import com.applovin.impl.sdk.utils.C2025o;
import com.applovin.sdk.AppLovinErrorCodes;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.sdk.d.y */
public abstract class C1921y<T> extends C1864a implements C1956a.C1959c<T> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1960b<T> f6350a;

    /* renamed from: c */
    private final C1956a.C1959c<T> f6351c;

    /* renamed from: d */
    protected C1956a.C1957a f6352d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C1907s.C1909a f6353e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C1841c<String> f6354f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public C1841c<String> f6355g;

    public C1921y(C1960b<T> bVar, C1941j jVar) {
        this(bVar, jVar, false);
    }

    public C1921y(C1960b<T> bVar, final C1941j jVar, boolean z) {
        super("TaskRepeatRequest", jVar, z);
        this.f6353e = C1907s.C1909a.BACKGROUND;
        this.f6354f = null;
        this.f6355g = null;
        if (bVar != null) {
            this.f6350a = bVar;
            this.f6352d = new C1956a.C1957a();
            this.f6351c = new C1956a.C1959c<T>() {
                /* renamed from: a */
                public void mo7627a(int i) {
                    C1841c cVar;
                    C1921y yVar;
                    boolean z = false;
                    boolean z2 = i < 200 || i >= 500;
                    boolean z3 = i == 429;
                    if (i != -103) {
                        z = true;
                    }
                    if (z && (z2 || z3)) {
                        String f = C1921y.this.f6350a.mo8650f();
                        if (C1921y.this.f6350a.mo8655j() > 0) {
                            C1921y yVar2 = C1921y.this;
                            yVar2.mo8408c("Unable to send request due to server failure (code " + i + "). " + C1921y.this.f6350a.mo8655j() + " attempts left, retrying in " + TimeUnit.MILLISECONDS.toSeconds((long) C1921y.this.f6350a.mo8657l()) + " seconds...");
                            int j = C1921y.this.f6350a.mo8655j() - 1;
                            C1921y.this.f6350a.mo8642a(j);
                            if (j == 0) {
                                C1921y yVar3 = C1921y.this;
                                yVar3.m7382c(yVar3.f6354f);
                                if (C2025o.m7963b(f) && f.length() >= 4) {
                                    C1921y.this.f6350a.mo8643a(f);
                                    C1921y yVar4 = C1921y.this;
                                    yVar4.mo8407b("Switching to backup endpoint " + f);
                                }
                            }
                            C1907s L = jVar.mo8533L();
                            C1921y yVar5 = C1921y.this;
                            L.mo8476a(yVar5, yVar5.f6353e, (long) C1921y.this.f6350a.mo8657l());
                            return;
                        }
                        if (f == null || !f.equals(C1921y.this.f6350a.mo8641a())) {
                            yVar = C1921y.this;
                            cVar = yVar.f6354f;
                        } else {
                            yVar = C1921y.this;
                            cVar = yVar.f6355g;
                        }
                        yVar.m7382c(cVar);
                    }
                    C1921y.this.mo7627a(i);
                }

                /* renamed from: a */
                public void mo7628a(T t, int i) {
                    C1921y.this.f6350a.mo8642a(0);
                    C1921y.this.mo7628a(t, i);
                }
            };
            return;
        }
        throw new IllegalArgumentException("No request specified");
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public <ST> void m7382c(C1841c<ST> cVar) {
        if (cVar != null) {
            C1842d D = mo8409d().mo8526D();
            D.mo8304a((C1841c<?>) cVar, (Object) cVar.mo8299b());
            D.mo8307b();
        }
    }

    /* renamed from: a */
    public abstract void mo7627a(int i);

    /* renamed from: a */
    public void mo8496a(C1841c<String> cVar) {
        this.f6354f = cVar;
    }

    /* renamed from: a */
    public void mo8497a(C1907s.C1909a aVar) {
        this.f6353e = aVar;
    }

    /* renamed from: a */
    public abstract void mo7628a(T t, int i);

    /* renamed from: b */
    public void mo8498b(C1841c<String> cVar) {
        this.f6355g = cVar;
    }

    public void run() {
        int i;
        C1956a K = mo8409d().mo8532K();
        if (!mo8409d().mo8582c() && !mo8409d().mo8583d()) {
            mo8410d("AppLovin SDK is disabled: please check your connection");
            C1977q.m7751i("AppLovinSdk", "AppLovin SDK is disabled: please check your connection");
            i = -22;
        } else if (!C2025o.m7963b(this.f6350a.mo8641a()) || this.f6350a.mo8641a().length() < 4) {
            mo8410d("Task has an invalid or null request endpoint.");
            i = AppLovinErrorCodes.INVALID_URL;
        } else {
            if (TextUtils.isEmpty(this.f6350a.mo8644b())) {
                this.f6350a.mo8645b(this.f6350a.mo8648e() != null ? "POST" : "GET");
            }
            K.mo8633a(this.f6350a, this.f6352d, this.f6351c);
            return;
        }
        mo7627a(i);
    }
}
