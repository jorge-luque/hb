package com.applovin.impl.sdk;

import com.applovin.impl.mediation.p045b.C1697a;
import com.applovin.impl.p033a.C1476a;
import com.applovin.impl.sdk.p049ad.C1827g;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.p050b.C1843e;
import com.applovin.impl.sdk.utils.C2029r;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.l */
public class C1952l {

    /* renamed from: a */
    private final Map<String, Thread> f6528a = new HashMap();

    /* renamed from: b */
    private final Object f6529b = new Object();

    /* renamed from: c */
    private final C1941j f6530c;

    public C1952l(C1941j jVar) {
        this.f6530c = jVar;
        if (((Boolean) jVar.mo8549a(C1841c.f6052eq)).booleanValue()) {
            m7566a("ltg-" + C2029r.m7996a(C1843e.f6094h, jVar)).start();
        }
    }

    /* renamed from: a */
    private static Thread m7566a(String str) {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(System.currentTimeMillis());
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
        }, str);
        thread.setDaemon(true);
        return thread;
    }

    /* renamed from: c */
    private String m7567c(Object obj) {
        if (obj instanceof C1697a) {
            C1697a aVar = (C1697a) obj;
            return aVar.getFormat().getLabel() + '-' + aVar.mo7814F() + '-' + aVar.mo7766b();
        } else if (!(obj instanceof C1827g)) {
            return null;
        } else {
            C1827g gVar = (C1827g) obj;
            int identityHashCode = System.identityHashCode(gVar);
            String str = obj instanceof C1476a ? "-VAST" : "";
            return "AL-" + gVar.getAdZone().mo8175b().getLabel() + "-" + gVar.getAdIdNumber() + "-" + identityHashCode + str;
        }
    }

    /* renamed from: a */
    public void mo8619a(Object obj) {
        String c = m7567c(obj);
        if (((Boolean) this.f6530c.mo8549a(C1841c.f6052eq)).booleanValue() && c != null) {
            synchronized (this.f6529b) {
                if (!this.f6528a.containsKey(c)) {
                    C1977q v = this.f6530c.mo8602v();
                    v.mo8742b("AppLovinSdk", "Creating ad debug thread with name: " + c);
                    Thread a = m7566a(c);
                    a.start();
                    this.f6528a.put(c, a);
                }
            }
        }
    }

    /* renamed from: b */
    public void mo8620b(Object obj) {
        String c = m7567c(obj);
        if (((Boolean) this.f6530c.mo8549a(C1841c.f6052eq)).booleanValue() && c != null) {
            synchronized (this.f6529b) {
                Thread thread = this.f6528a.get(c);
                if (thread != null) {
                    C1977q v = this.f6530c.mo8602v();
                    v.mo8742b("AppLovinSdk", "Destroying ad debug thread with name: " + c);
                    thread.interrupt();
                    this.f6528a.remove(c);
                }
            }
        }
    }
}
