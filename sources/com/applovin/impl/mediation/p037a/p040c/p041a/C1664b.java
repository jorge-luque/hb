package com.applovin.impl.mediation.p037a.p040c.p041a;

import android.content.Context;
import com.applovin.impl.mediation.p037a.p038a.C1649c;
import com.applovin.impl.mediation.p037a.p038a.C1651d;
import com.applovin.impl.mediation.p037a.p038a.C1655g;
import com.applovin.impl.mediation.p037a.p040c.C1658a;
import com.applovin.impl.mediation.p037a.p040c.p041a.p042a.C1663a;
import com.applovin.impl.sdk.C1941j;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.mediation.a.c.a.b */
public class C1664b extends C1658a {

    /* renamed from: c */
    private final AtomicBoolean f5203c = new AtomicBoolean();

    /* renamed from: d */
    private final C1649c f5204d = new C1655g("INCOMPLETE INTEGRATIONS");

    /* renamed from: e */
    private final C1649c f5205e = new C1655g("COMPLETED INTEGRATIONS");

    /* renamed from: f */
    private final C1649c f5206f = new C1655g("MISSING INTEGRATIONS");

    /* renamed from: g */
    private final C1649c f5207g = new C1655g("");

    /* renamed from: h */
    private C1666a f5208h;

    /* renamed from: com.applovin.impl.mediation.a.c.a.b$a */
    public interface C1666a {
        /* renamed from: a */
        void mo7694a(C1651d dVar);
    }

    public C1664b(Context context) {
        super(context);
    }

    /* renamed from: b */
    private List<C1649c> m6353b(List<C1651d> list, C1941j jVar) {
        jVar.mo8602v().mo8742b("MediationDebuggerListAdapter", "Updating networks...");
        ArrayList arrayList = new ArrayList(list.size());
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (C1651d next : list) {
            C1663a aVar = new C1663a(next, this.f5188a);
            if (next.mo7652a() == C1651d.C1652a.INCOMPLETE_INTEGRATION || next.mo7652a() == C1651d.C1652a.INVALID_INTEGRATION) {
                arrayList2.add(aVar);
            } else if (next.mo7652a() == C1651d.C1652a.COMPLETE) {
                arrayList3.add(aVar);
            } else if (next.mo7652a() == C1651d.C1652a.MISSING) {
                arrayList4.add(aVar);
            }
        }
        if (arrayList2.size() > 0) {
            arrayList.add(this.f5204d);
            arrayList.addAll(arrayList2);
        }
        if (arrayList3.size() > 0) {
            arrayList.add(this.f5205e);
            arrayList.addAll(arrayList3);
        }
        if (arrayList4.size() > 0) {
            arrayList.add(this.f5206f);
            arrayList.addAll(arrayList4);
        }
        arrayList.add(this.f5207g);
        return arrayList;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7679a(C1649c cVar) {
        if (this.f5208h != null && (cVar instanceof C1663a)) {
            this.f5208h.mo7694a(((C1663a) cVar).mo7695k());
        }
    }

    /* renamed from: a */
    public void mo7697a(C1666a aVar) {
        this.f5208h = aVar;
    }

    /* renamed from: a */
    public void mo7698a(List<C1651d> list, C1941j jVar) {
        if (list != null && this.f5203c.compareAndSet(false, true)) {
            this.f5189b.addAll(m6353b(list, jVar));
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                C1664b.this.notifyDataSetChanged();
            }
        });
    }

    /* renamed from: a */
    public boolean mo7699a() {
        return this.f5203c.get();
    }

    public String toString() {
        return "MediationDebuggerListAdapter{isInitialized=" + this.f5203c.get() + ", listItems=" + this.f5189b + "}";
    }
}
