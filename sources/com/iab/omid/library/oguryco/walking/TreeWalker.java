package com.iab.omid.library.oguryco.walking;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.iab.omid.library.oguryco.p151c.C4211a;
import com.iab.omid.library.oguryco.p151c.C4213b;
import com.iab.omid.library.oguryco.p152d.C4217b;
import com.iab.omid.library.oguryco.p152d.C4220d;
import com.iab.omid.library.oguryco.p152d.C4222f;
import com.iab.omid.library.oguryco.walking.C4232a;
import com.iab.omid.library.oguryco.walking.p154a.C4238c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class TreeWalker implements C4211a.C4212a {

    /* renamed from: a */
    private static TreeWalker f11344a = new TreeWalker();

    /* renamed from: b */
    private static Handler f11345b = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static Handler f11346c = null;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static final Runnable f11347j = new Runnable() {
        public final void run() {
            TreeWalker.getInstance().m14283h();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: k */
    public static final Runnable f11348k = new Runnable() {
        public final void run() {
            if (TreeWalker.f11346c != null) {
                TreeWalker.f11346c.post(TreeWalker.f11347j);
                TreeWalker.f11346c.postDelayed(TreeWalker.f11348k, 200);
            }
        }
    };

    /* renamed from: d */
    private List<TreeWalkerTimeLogger> f11349d = new ArrayList();

    /* renamed from: e */
    private int f11350e;

    /* renamed from: f */
    private C4213b f11351f = new C4213b();

    /* renamed from: g */
    private C4232a f11352g = new C4232a();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C4242b f11353h = new C4242b(new C4238c());

    /* renamed from: i */
    private long f11354i;

    public interface TreeWalkerNanoTimeLogger extends TreeWalkerTimeLogger {
        void onTreeProcessedNano(int i, long j);
    }

    public interface TreeWalkerTimeLogger {
        void onTreeProcessed(int i, long j);
    }

    TreeWalker() {
    }

    /* renamed from: a */
    private void m14274a(long j) {
        if (this.f11349d.size() > 0) {
            for (TreeWalkerTimeLogger next : this.f11349d) {
                next.onTreeProcessed(this.f11350e, TimeUnit.NANOSECONDS.toMillis(j));
                if (next instanceof TreeWalkerNanoTimeLogger) {
                    ((TreeWalkerNanoTimeLogger) next).onTreeProcessedNano(this.f11350e, j);
                }
            }
        }
    }

    /* renamed from: a */
    private void m14275a(View view, C4211a aVar, JSONObject jSONObject, C4243c cVar) {
        aVar.mo28759a(view, jSONObject, this, cVar == C4243c.PARENT_VIEW);
    }

    /* renamed from: a */
    private void m14276a(String str, View view, JSONObject jSONObject) {
        C4211a b = this.f11351f.mo28762b();
        String a = this.f11352g.mo28802a(str);
        if (a != null) {
            JSONObject a2 = b.mo28758a(view);
            C4217b.m14213a(a2, str);
            C4217b.m14218b(a2, a);
            C4217b.m14215a(jSONObject, a2);
        }
    }

    /* renamed from: a */
    private boolean m14277a(View view, JSONObject jSONObject) {
        String a = this.f11352g.mo28801a(view);
        if (a == null) {
            return false;
        }
        C4217b.m14213a(jSONObject, a);
        this.f11352g.mo28810e();
        return true;
    }

    /* renamed from: b */
    private void m14278b(View view, JSONObject jSONObject) {
        C4232a.C4233a b = this.f11352g.mo28805b(view);
        if (b != null) {
            C4217b.m14212a(jSONObject, b);
        }
    }

    public static TreeWalker getInstance() {
        return f11344a;
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m14283h() {
        m14284i();
        mo28794d();
        m14285j();
    }

    /* renamed from: i */
    private void m14284i() {
        this.f11350e = 0;
        this.f11354i = C4220d.m14226a();
    }

    /* renamed from: j */
    private void m14285j() {
        m14274a(C4220d.m14226a() - this.f11354i);
    }

    /* renamed from: k */
    private void m14286k() {
        if (f11346c == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            f11346c = handler;
            handler.post(f11347j);
            f11346c.postDelayed(f11348k, 200);
        }
    }

    /* renamed from: l */
    private void m14287l() {
        Handler handler = f11346c;
        if (handler != null) {
            handler.removeCallbacks(f11348k);
            f11346c = null;
        }
    }

    /* renamed from: a */
    public void mo28790a() {
        m14286k();
    }

    /* renamed from: a */
    public void mo28760a(View view, C4211a aVar, JSONObject jSONObject) {
        C4243c c;
        if (C4222f.m14243d(view) && (c = this.f11352g.mo28807c(view)) != C4243c.UNDERLYING_VIEW) {
            JSONObject a = aVar.mo28758a(view);
            C4217b.m14215a(jSONObject, a);
            if (!m14277a(view, a)) {
                m14278b(view, a);
                m14275a(view, aVar, a, c);
            }
            this.f11350e++;
        }
    }

    public void addTimeLogger(TreeWalkerTimeLogger treeWalkerTimeLogger) {
        if (!this.f11349d.contains(treeWalkerTimeLogger)) {
            this.f11349d.add(treeWalkerTimeLogger);
        }
    }

    /* renamed from: b */
    public void mo28792b() {
        mo28793c();
        this.f11349d.clear();
        f11345b.post(new Runnable() {
            public void run() {
                TreeWalker.this.f11353h.mo28828a();
            }
        });
    }

    /* renamed from: c */
    public void mo28793c() {
        m14287l();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo28794d() {
        this.f11352g.mo28808c();
        long a = C4220d.m14226a();
        C4211a a2 = this.f11351f.mo28761a();
        if (this.f11352g.mo28806b().size() > 0) {
            Iterator<String> it = this.f11352g.mo28806b().iterator();
            while (it.hasNext()) {
                String next = it.next();
                JSONObject a3 = a2.mo28758a((View) null);
                m14276a(next, this.f11352g.mo28804b(next), a3);
                C4217b.m14211a(a3);
                HashSet hashSet = new HashSet();
                hashSet.add(next);
                this.f11353h.mo28830b(a3, hashSet, a);
            }
        }
        if (this.f11352g.mo28803a().size() > 0) {
            JSONObject a4 = a2.mo28758a((View) null);
            m14275a((View) null, a2, a4, C4243c.PARENT_VIEW);
            C4217b.m14211a(a4);
            this.f11353h.mo28829a(a4, this.f11352g.mo28803a(), a);
        } else {
            this.f11353h.mo28828a();
        }
        this.f11352g.mo28809d();
    }

    public void removeTimeLogger(TreeWalkerTimeLogger treeWalkerTimeLogger) {
        if (this.f11349d.contains(treeWalkerTimeLogger)) {
            this.f11349d.remove(treeWalkerTimeLogger);
        }
    }
}
