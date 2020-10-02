package com.criteo.publisher.model;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.criteo.publisher.p054a0.C2332j;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.criteo.publisher.model.q */
public class C2456q {
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final String f7913e = "q";

    /* renamed from: a */
    private final Context f7914a;

    /* renamed from: b */
    private final Executor f7915b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C2332j<String> f7916c = new C2332j<>();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final AtomicBoolean f7917d = new AtomicBoolean(false);

    /* renamed from: com.criteo.publisher.model.q$a */
    class C2457a implements Runnable {
        C2457a() {
        }

        public void run() {
            if (C2456q.this.f7917d.compareAndSet(false, true)) {
                C2456q.this.f7916c.mo10145a(C2456q.this.mo10388c());
            }
        }
    }

    /* renamed from: com.criteo.publisher.model.q$b */
    class C2458b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Runnable f7919a;

        C2458b(C2456q qVar, Runnable runnable) {
            this.f7919a = runnable;
        }

        public void run() {
            try {
                this.f7919a.run();
            } catch (Throwable th) {
                Log.e(C2456q.f7913e, "Internal error while setting user-agent.", th);
            }
        }
    }

    public C2456q(Context context, Executor executor) {
        this.f7914a = context;
        this.f7915b = executor;
    }

    /* renamed from: e */
    private static String m9291e() {
        String str;
        try {
            str = System.getProperty("http.agent");
        } catch (Throwable th) {
            Log.e(f7913e, "Unable to retrieve system user-agent.", th);
            str = null;
        }
        return str != null ? str : "";
    }

    /* renamed from: f */
    private String m9292f() {
        WebView webView = new WebView(this.f7914a);
        String userAgentString = webView.getSettings().getUserAgentString();
        webView.destroy();
        return userAgentString;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo10388c() {
        String str;
        try {
            str = m9292f();
        } catch (Throwable unused) {
            str = null;
        }
        return TextUtils.isEmpty(str) ? m9291e() : str;
    }

    /* renamed from: a */
    public Future<String> mo10295a() {
        mo10296b();
        return this.f7916c;
    }

    /* renamed from: b */
    public void mo10296b() {
        m9288a((Runnable) new C2457a());
    }

    /* renamed from: a */
    private void m9288a(Runnable runnable) {
        this.f7915b.execute(new C2458b(this, runnable));
    }
}
