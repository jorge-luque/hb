package com.iab.omid.library.adcolony.walking;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.iab.omid.library.adcolony.p145c.C4160a;
import com.iab.omid.library.adcolony.p145c.C4162b;
import com.iab.omid.library.adcolony.p146d.C4166b;
import com.iab.omid.library.adcolony.p146d.C4169d;
import com.iab.omid.library.adcolony.p146d.C4171f;
import com.iab.omid.library.adcolony.walking.C4181a;
import com.iab.omid.library.adcolony.walking.p148a.C4187c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class TreeWalker implements C4160a.C4161a {

    /* renamed from: g */
    private static TreeWalker f11223g = new TreeWalker();

    /* renamed from: h */
    private static Handler f11224h = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static Handler f11225i = null;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static final Runnable f11226j = new C4179b();
    /* access modifiers changed from: private */

    /* renamed from: k */
    public static final Runnable f11227k = new C4180c();

    /* renamed from: a */
    private List<TreeWalkerTimeLogger> f11228a = new ArrayList();

    /* renamed from: b */
    private int f11229b;

    /* renamed from: c */
    private C4162b f11230c = new C4162b();

    /* renamed from: d */
    private C4181a f11231d = new C4181a();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C4191b f11232e = new C4191b(new C4187c());

    /* renamed from: f */
    private long f11233f;

    public interface TreeWalkerNanoTimeLogger extends TreeWalkerTimeLogger {
        void onTreeProcessedNano(int i, long j);
    }

    public interface TreeWalkerTimeLogger {
        void onTreeProcessed(int i, long j);
    }

    /* renamed from: com.iab.omid.library.adcolony.walking.TreeWalker$a */
    class C4178a implements Runnable {
        C4178a() {
        }

        public void run() {
            TreeWalker.this.f11232e.mo28614a();
        }
    }

    /* renamed from: com.iab.omid.library.adcolony.walking.TreeWalker$b */
    static class C4179b implements Runnable {
        C4179b() {
        }

        public void run() {
            TreeWalker.getInstance().m14054h();
        }
    }

    /* renamed from: com.iab.omid.library.adcolony.walking.TreeWalker$c */
    static class C4180c implements Runnable {
        C4180c() {
        }

        public void run() {
            if (TreeWalker.f11225i != null) {
                TreeWalker.f11225i.post(TreeWalker.f11226j);
                TreeWalker.f11225i.postDelayed(TreeWalker.f11227k, 200);
            }
        }
    }

    TreeWalker() {
    }

    /* renamed from: a */
    private void m14045a(long j) {
        if (this.f11228a.size() > 0) {
            for (TreeWalkerTimeLogger next : this.f11228a) {
                next.onTreeProcessed(this.f11229b, TimeUnit.NANOSECONDS.toMillis(j));
                if (next instanceof TreeWalkerNanoTimeLogger) {
                    ((TreeWalkerNanoTimeLogger) next).onTreeProcessedNano(this.f11229b, j);
                }
            }
        }
    }

    /* renamed from: a */
    private void m14046a(View view, C4160a aVar, JSONObject jSONObject, C4192c cVar) {
        aVar.mo28545a(view, jSONObject, this, cVar == C4192c.PARENT_VIEW);
    }

    /* renamed from: a */
    private void m14047a(String str, View view, JSONObject jSONObject) {
        C4160a b = this.f11230c.mo28548b();
        String a = this.f11231d.mo28588a(str);
        if (a != null) {
            JSONObject a2 = b.mo28544a(view);
            C4166b.m13984a(a2, str);
            C4166b.m13989b(a2, a);
            C4166b.m13986a(jSONObject, a2);
        }
    }

    /* renamed from: a */
    private boolean m14048a(View view, JSONObject jSONObject) {
        String a = this.f11231d.mo28587a(view);
        if (a == null) {
            return false;
        }
        C4166b.m13984a(jSONObject, a);
        this.f11231d.mo28596e();
        return true;
    }

    /* renamed from: b */
    private void m14049b(View view, JSONObject jSONObject) {
        C4181a.C4182a b = this.f11231d.mo28591b(view);
        if (b != null) {
            C4166b.m13983a(jSONObject, b);
        }
    }

    public static TreeWalker getInstance() {
        return f11223g;
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m14054h() {
        m14055i();
        mo28580d();
        m14056j();
    }

    /* renamed from: i */
    private void m14055i() {
        this.f11229b = 0;
        this.f11233f = C4169d.m13997a();
    }

    /* renamed from: j */
    private void m14056j() {
        m14045a(C4169d.m13997a() - this.f11233f);
    }

    /* renamed from: k */
    private void m14057k() {
        if (f11225i == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            f11225i = handler;
            handler.post(f11226j);
            f11225i.postDelayed(f11227k, 200);
        }
    }

    /* renamed from: l */
    private void m14058l() {
        Handler handler = f11225i;
        if (handler != null) {
            handler.removeCallbacks(f11227k);
            f11225i = null;
        }
    }

    /* renamed from: a */
    public void mo28576a() {
        m14057k();
    }

    /* renamed from: a */
    public void mo28546a(View view, C4160a aVar, JSONObject jSONObject) {
        C4192c c;
        if (C4171f.m14014d(view) && (c = this.f11231d.mo28593c(view)) != C4192c.UNDERLYING_VIEW) {
            JSONObject a = aVar.mo28544a(view);
            C4166b.m13986a(jSONObject, a);
            if (!m14048a(view, a)) {
                m14049b(view, a);
                m14046a(view, aVar, a, c);
            }
            this.f11229b++;
        }
    }

    public void addTimeLogger(TreeWalkerTimeLogger treeWalkerTimeLogger) {
        if (!this.f11228a.contains(treeWalkerTimeLogger)) {
            this.f11228a.add(treeWalkerTimeLogger);
        }
    }

    /* renamed from: b */
    public void mo28578b() {
        mo28579c();
        this.f11228a.clear();
        f11224h.post(new C4178a());
    }

    /* renamed from: c */
    public void mo28579c() {
        m14058l();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo28580d() {
        this.f11231d.mo28594c();
        long a = C4169d.m13997a();
        C4160a a2 = this.f11230c.mo28547a();
        if (this.f11231d.mo28592b().size() > 0) {
            Iterator<String> it = this.f11231d.mo28592b().iterator();
            while (it.hasNext()) {
                String next = it.next();
                JSONObject a3 = a2.mo28544a((View) null);
                m14047a(next, this.f11231d.mo28590b(next), a3);
                C4166b.m13982a(a3);
                HashSet hashSet = new HashSet();
                hashSet.add(next);
                this.f11232e.mo28616b(a3, hashSet, a);
            }
        }
        if (this.f11231d.mo28589a().size() > 0) {
            JSONObject a4 = a2.mo28544a((View) null);
            m14046a((View) null, a2, a4, C4192c.PARENT_VIEW);
            C4166b.m13982a(a4);
            this.f11232e.mo28615a(a4, this.f11231d.mo28589a(), a);
        } else {
            this.f11232e.mo28614a();
        }
        this.f11231d.mo28595d();
    }

    public void removeTimeLogger(TreeWalkerTimeLogger treeWalkerTimeLogger) {
        if (this.f11228a.contains(treeWalkerTimeLogger)) {
            this.f11228a.remove(treeWalkerTimeLogger);
        }
    }
}
