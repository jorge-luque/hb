package com.adcolony.sdk;

import com.adcolony.sdk.C1362l;
import com.adcolony.sdk.C1439u;
import com.facebook.GraphResponse;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* renamed from: com.adcolony.sdk.m */
class C1375m implements C1362l.C1363a {

    /* renamed from: a */
    private BlockingQueue<Runnable> f4338a = new LinkedBlockingQueue();

    /* renamed from: b */
    private ThreadPoolExecutor f4339b = new ThreadPoolExecutor(4, 16, 60, TimeUnit.SECONDS, this.f4338a);

    /* renamed from: c */
    private LinkedList<C1362l> f4340c = new LinkedList<>();

    /* renamed from: d */
    private String f4341d = C1199a.m4880c().mo6542h().mo6607G();

    /* renamed from: com.adcolony.sdk.m$a */
    class C1376a implements C1458z {
        C1376a() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            C1375m mVar = C1375m.this;
            mVar.mo6705a(new C1362l(xVar, mVar));
        }
    }

    /* renamed from: com.adcolony.sdk.m$b */
    class C1377b implements C1458z {
        C1377b() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            C1375m mVar = C1375m.this;
            mVar.mo6705a(new C1362l(xVar, mVar));
        }
    }

    /* renamed from: com.adcolony.sdk.m$c */
    class C1378c implements C1458z {
        C1378c() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            C1375m mVar = C1375m.this;
            mVar.mo6705a(new C1362l(xVar, mVar));
        }
    }

    C1375m() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6705a(C1362l lVar) {
        String str = this.f4341d;
        if (str == null || str.equals("")) {
            this.f4340c.push(lVar);
            return;
        }
        try {
            this.f4339b.execute(lVar);
        } catch (RejectedExecutionException unused) {
            C1439u.C1440a a = new C1439u.C1440a().mo6801a("RejectedExecutionException: ThreadPoolExecutor unable to ");
            a.mo6801a("execute download for url " + lVar.f4277m).mo6803a(C1439u.f4517j);
            mo6527a(lVar, lVar.mo6677b(), (Map<String, List<String>>) null);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo6707b() {
        C1199a.m4876a("WebServices.download", (C1458z) new C1376a());
        C1199a.m4876a("WebServices.get", (C1458z) new C1377b());
        C1199a.m4876a("WebServices.post", (C1458z) new C1378c());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6706a(String str) {
        this.f4341d = str;
        while (!this.f4340c.isEmpty()) {
            mo6705a(this.f4340c.removeLast());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6704a(int i) {
        this.f4339b.setCorePoolSize(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo6703a() {
        return this.f4339b.getCorePoolSize();
    }

    /* renamed from: a */
    public void mo6527a(C1362l lVar, C1454x xVar, Map<String, List<String>> map) {
        JSONObject b = C1437s.m5599b();
        C1437s.m5592a(b, "url", lVar.f4277m);
        C1437s.m5603b(b, GraphResponse.SUCCESS_KEY, lVar.f4279o);
        C1437s.m5602b(b, "status", lVar.f4281q);
        C1437s.m5592a(b, "body", lVar.f4278n);
        C1437s.m5602b(b, "size", lVar.f4280p);
        if (map != null) {
            JSONObject b2 = C1437s.m5599b();
            for (Map.Entry next : map.entrySet()) {
                String obj = ((List) next.getValue()).toString();
                String substring = obj.substring(1, obj.length() - 1);
                if (next.getKey() != null) {
                    C1437s.m5592a(b2, (String) next.getKey(), substring);
                }
            }
            C1437s.m5594a(b, "headers", b2);
        }
        xVar.mo6829a(b).mo6834d();
    }
}
