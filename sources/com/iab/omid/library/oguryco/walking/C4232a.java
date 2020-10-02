package com.iab.omid.library.oguryco.walking;

import android.view.View;
import android.view.ViewParent;
import com.iab.omid.library.oguryco.adsession.C4199a;
import com.iab.omid.library.oguryco.p150b.C4201a;
import com.iab.omid.library.oguryco.p150b.C4205c;
import com.iab.omid.library.oguryco.p152d.C4222f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/* renamed from: com.iab.omid.library.oguryco.walking.a */
public class C4232a {

    /* renamed from: a */
    private final HashMap<View, String> f11356a = new HashMap<>();

    /* renamed from: b */
    private final HashMap<View, C4233a> f11357b = new HashMap<>();

    /* renamed from: c */
    private final HashMap<String, View> f11358c = new HashMap<>();

    /* renamed from: d */
    private final HashSet<View> f11359d = new HashSet<>();

    /* renamed from: e */
    private final HashSet<String> f11360e = new HashSet<>();

    /* renamed from: f */
    private final HashSet<String> f11361f = new HashSet<>();

    /* renamed from: g */
    private final HashMap<String, String> f11362g = new HashMap<>();

    /* renamed from: h */
    private boolean f11363h;

    /* renamed from: com.iab.omid.library.oguryco.walking.a$a */
    public static class C4233a {

        /* renamed from: a */
        private final C4205c f11364a;

        /* renamed from: b */
        private final ArrayList<String> f11365b = new ArrayList<>();

        public C4233a(C4205c cVar, String str) {
            this.f11364a = cVar;
            mo28812a(str);
        }

        /* renamed from: a */
        public C4205c mo28811a() {
            return this.f11364a;
        }

        /* renamed from: a */
        public void mo28812a(String str) {
            this.f11365b.add(str);
        }

        /* renamed from: b */
        public ArrayList<String> mo28813b() {
            return this.f11365b;
        }
    }

    /* renamed from: a */
    private void m14293a(C4199a aVar) {
        for (C4205c a : aVar.mo28659a()) {
            m14294a(a, aVar);
        }
    }

    /* renamed from: a */
    private void m14294a(C4205c cVar, C4199a aVar) {
        View view = (View) cVar.mo28731a().get();
        if (view != null) {
            C4233a aVar2 = this.f11357b.get(view);
            if (aVar2 != null) {
                aVar2.mo28812a(aVar.getAdSessionId());
            } else {
                this.f11357b.put(view, new C4233a(cVar, aVar.getAdSessionId()));
            }
        }
    }

    /* renamed from: d */
    private String m14295d(View view) {
        if (!view.hasWindowFocus()) {
            return "noWindowFocus";
        }
        HashSet hashSet = new HashSet();
        while (view != null) {
            String e = C4222f.m14244e(view);
            if (e != null) {
                return e;
            }
            hashSet.add(view);
            ViewParent parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        this.f11359d.addAll(hashSet);
        return null;
    }

    /* renamed from: a */
    public String mo28801a(View view) {
        if (this.f11356a.size() == 0) {
            return null;
        }
        String str = this.f11356a.get(view);
        if (str != null) {
            this.f11356a.remove(view);
        }
        return str;
    }

    /* renamed from: a */
    public String mo28802a(String str) {
        return this.f11362g.get(str);
    }

    /* renamed from: a */
    public HashSet<String> mo28803a() {
        return this.f11360e;
    }

    /* renamed from: b */
    public View mo28804b(String str) {
        return this.f11358c.get(str);
    }

    /* renamed from: b */
    public C4233a mo28805b(View view) {
        C4233a aVar = this.f11357b.get(view);
        if (aVar != null) {
            this.f11357b.remove(view);
        }
        return aVar;
    }

    /* renamed from: b */
    public HashSet<String> mo28806b() {
        return this.f11361f;
    }

    /* renamed from: c */
    public C4243c mo28807c(View view) {
        return this.f11359d.contains(view) ? C4243c.PARENT_VIEW : this.f11363h ? C4243c.OBSTRUCTION_VIEW : C4243c.UNDERLYING_VIEW;
    }

    /* renamed from: c */
    public void mo28808c() {
        C4201a a = C4201a.m14135a();
        if (a != null) {
            for (C4199a next : a.mo28721c()) {
                View d = next.mo28663d();
                if (next.mo28664e()) {
                    String adSessionId = next.getAdSessionId();
                    if (d != null) {
                        String d2 = m14295d(d);
                        if (d2 == null) {
                            this.f11360e.add(adSessionId);
                            this.f11356a.put(d, adSessionId);
                            m14293a(next);
                        } else {
                            this.f11361f.add(adSessionId);
                            this.f11358c.put(adSessionId, d);
                            this.f11362g.put(adSessionId, d2);
                        }
                    } else {
                        this.f11361f.add(adSessionId);
                        this.f11362g.put(adSessionId, "noAdView");
                    }
                }
            }
        }
    }

    /* renamed from: d */
    public void mo28809d() {
        this.f11356a.clear();
        this.f11357b.clear();
        this.f11358c.clear();
        this.f11359d.clear();
        this.f11360e.clear();
        this.f11361f.clear();
        this.f11362g.clear();
        this.f11363h = false;
    }

    /* renamed from: e */
    public void mo28810e() {
        this.f11363h = true;
    }
}
