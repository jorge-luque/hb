package com.applovin.impl.sdk.p052d;

import android.content.Context;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;

/* renamed from: com.applovin.impl.sdk.d.a */
public abstract class C1864a implements Runnable {

    /* renamed from: a */
    private final String f6216a;
    /* access modifiers changed from: protected */

    /* renamed from: b */
    public final C1941j f6217b;

    /* renamed from: c */
    private final C1977q f6218c;

    /* renamed from: d */
    private final Context f6219d;

    /* renamed from: e */
    private final boolean f6220e;

    public C1864a(String str, C1941j jVar) {
        this(str, jVar, false);
    }

    public C1864a(String str, C1941j jVar, boolean z) {
        this.f6216a = str;
        this.f6217b = jVar;
        this.f6218c = jVar.mo8602v();
        this.f6219d = jVar.mo8527E();
        this.f6220e = z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8405a(String str) {
        this.f6218c.mo8742b(this.f6216a, str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8406a(String str, Throwable th) {
        this.f6218c.mo8743b(this.f6216a, str, th);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo8407b(String str) {
        this.f6218c.mo8744c(this.f6216a, str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo8408c(String str) {
        this.f6218c.mo8745d(this.f6216a, str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public C1941j mo8409d() {
        return this.f6217b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo8410d(String str) {
        this.f6218c.mo8746e(this.f6216a, str);
    }

    /* renamed from: e */
    public String mo8411e() {
        return this.f6216a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public Context mo8412f() {
        return this.f6219d;
    }

    /* renamed from: g */
    public boolean mo8413g() {
        return this.f6220e;
    }
}
