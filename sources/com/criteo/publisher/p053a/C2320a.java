package com.criteo.publisher.p053a;

import android.content.Context;
import android.os.AsyncTask;
import com.criteo.publisher.C2379c;
import com.criteo.publisher.C2387i;
import com.criteo.publisher.model.C2456q;
import com.criteo.publisher.p054a0.C2324d;
import com.criteo.publisher.p054a0.C2338m;
import com.criteo.publisher.p065x.C2573a;
import com.criteo.publisher.p065x.C2579d;
import com.criteo.publisher.p066y.C2580a;
import java.util.concurrent.Executor;

/* renamed from: com.criteo.publisher.a.a */
public class C2320a implements C2324d {

    /* renamed from: a */
    private C2573a f7662a;

    /* renamed from: b */
    private final Context f7663b;

    /* renamed from: c */
    private int f7664c = -1;

    /* renamed from: d */
    private long f7665d = 0;

    /* renamed from: e */
    private final C2338m f7666e;

    /* renamed from: f */
    private final C2379c f7667f;

    /* renamed from: g */
    private final C2579d f7668g;

    /* renamed from: h */
    private final C2580a f7669h;

    /* renamed from: i */
    private final C2456q f7670i;

    public C2320a(Context context, C2338m mVar, C2379c cVar, C2579d dVar, C2580a aVar, C2456q qVar) {
        this.f7663b = context;
        this.f7666e = mVar;
        this.f7667f = cVar;
        this.f7668g = dVar;
        this.f7669h = aVar;
        this.f7670i = qVar;
        this.f7662a = m8943e();
    }

    /* renamed from: a */
    private void m8942a(String str) {
        if (!m8944f()) {
            return;
        }
        if (this.f7664c <= 0 || this.f7667f.mo10237a() - this.f7665d >= ((long) (this.f7664c * 1000))) {
            if (this.f7662a.getStatus() == AsyncTask.Status.FINISHED) {
                this.f7662a = m8943e();
            }
            if (this.f7662a.getStatus() != AsyncTask.Status.RUNNING) {
                Executor N = C2387i.m9085U().mo10261N();
                this.f7662a.executeOnExecutor(N, new Object[]{str});
            }
        }
    }

    /* renamed from: e */
    private C2573a m8943e() {
        return new C2573a(this.f7663b, this, this.f7666e, this.f7668g, this.f7670i, this.f7669h);
    }

    /* renamed from: f */
    private boolean m8944f() {
        return this.f7669h.mo10634e() && this.f7669h.mo10635f();
    }

    /* renamed from: a */
    public void mo10110a() {
    }

    /* renamed from: b */
    public void mo10112b() {
        m8942a("Active");
    }

    /* renamed from: c */
    public void mo10113c() {
        m8942a("Inactive");
    }

    /* renamed from: d */
    public void mo10114d() {
        m8942a("Launch");
    }

    /* renamed from: a */
    public void mo10111a(int i) {
        this.f7664c = i;
        this.f7665d = this.f7667f.mo10237a();
    }
}
