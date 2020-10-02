package com.iab.omid.library.adcolony.walking;

import android.view.View;
import android.view.ViewParent;
import com.iab.omid.library.adcolony.adsession.C4148a;
import com.iab.omid.library.adcolony.p144b.C4150a;
import com.iab.omid.library.adcolony.p144b.C4154c;
import com.iab.omid.library.adcolony.p146d.C4171f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/* renamed from: com.iab.omid.library.adcolony.walking.a */
public class C4181a {

    /* renamed from: a */
    private final HashMap<View, String> f11235a = new HashMap<>();

    /* renamed from: b */
    private final HashMap<View, C4182a> f11236b = new HashMap<>();

    /* renamed from: c */
    private final HashMap<String, View> f11237c = new HashMap<>();

    /* renamed from: d */
    private final HashSet<View> f11238d = new HashSet<>();

    /* renamed from: e */
    private final HashSet<String> f11239e = new HashSet<>();

    /* renamed from: f */
    private final HashSet<String> f11240f = new HashSet<>();

    /* renamed from: g */
    private final HashMap<String, String> f11241g = new HashMap<>();

    /* renamed from: h */
    private boolean f11242h;

    /* renamed from: com.iab.omid.library.adcolony.walking.a$a */
    public static class C4182a {

        /* renamed from: a */
        private final C4154c f11243a;

        /* renamed from: b */
        private final ArrayList<String> f11244b = new ArrayList<>();

        public C4182a(C4154c cVar, String str) {
            this.f11243a = cVar;
            mo28598a(str);
        }

        /* renamed from: a */
        public C4154c mo28597a() {
            return this.f11243a;
        }

        /* renamed from: a */
        public void mo28598a(String str) {
            this.f11244b.add(str);
        }

        /* renamed from: b */
        public ArrayList<String> mo28599b() {
            return this.f11244b;
        }
    }

    /* renamed from: a */
    private void m14064a(C4148a aVar) {
        for (C4154c a : aVar.mo28469a()) {
            m14065a(a, aVar);
        }
    }

    /* renamed from: a */
    private void m14065a(C4154c cVar, C4148a aVar) {
        View view = (View) cVar.mo28517a().get();
        if (view != null) {
            C4182a aVar2 = this.f11236b.get(view);
            if (aVar2 != null) {
                aVar2.mo28598a(aVar.getAdSessionId());
            } else {
                this.f11236b.put(view, new C4182a(cVar, aVar.getAdSessionId()));
            }
        }
    }

    /* renamed from: d */
    private String m14066d(View view) {
        if (!view.hasWindowFocus()) {
            return "noWindowFocus";
        }
        HashSet hashSet = new HashSet();
        while (view != null) {
            String e = C4171f.m14015e(view);
            if (e != null) {
                return e;
            }
            hashSet.add(view);
            ViewParent parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        this.f11238d.addAll(hashSet);
        return null;
    }

    /* renamed from: a */
    public String mo28587a(View view) {
        if (this.f11235a.size() == 0) {
            return null;
        }
        String str = this.f11235a.get(view);
        if (str != null) {
            this.f11235a.remove(view);
        }
        return str;
    }

    /* renamed from: a */
    public String mo28588a(String str) {
        return this.f11241g.get(str);
    }

    /* renamed from: a */
    public HashSet<String> mo28589a() {
        return this.f11239e;
    }

    /* renamed from: b */
    public View mo28590b(String str) {
        return this.f11237c.get(str);
    }

    /* renamed from: b */
    public C4182a mo28591b(View view) {
        C4182a aVar = this.f11236b.get(view);
        if (aVar != null) {
            this.f11236b.remove(view);
        }
        return aVar;
    }

    /* renamed from: b */
    public HashSet<String> mo28592b() {
        return this.f11240f;
    }

    /* renamed from: c */
    public C4192c mo28593c(View view) {
        return this.f11238d.contains(view) ? C4192c.PARENT_VIEW : this.f11242h ? C4192c.OBSTRUCTION_VIEW : C4192c.UNDERLYING_VIEW;
    }

    /* renamed from: c */
    public void mo28594c() {
        C4150a a = C4150a.m13906a();
        if (a != null) {
            for (C4148a next : a.mo28507c()) {
                View d = next.mo28473d();
                if (next.mo28474e()) {
                    String adSessionId = next.getAdSessionId();
                    if (d != null) {
                        String d2 = m14066d(d);
                        if (d2 == null) {
                            this.f11239e.add(adSessionId);
                            this.f11235a.put(d, adSessionId);
                            m14064a(next);
                        } else {
                            this.f11240f.add(adSessionId);
                            this.f11237c.put(adSessionId, d);
                            this.f11241g.put(adSessionId, d2);
                        }
                    } else {
                        this.f11240f.add(adSessionId);
                        this.f11241g.put(adSessionId, "noAdView");
                    }
                }
            }
        }
    }

    /* renamed from: d */
    public void mo28595d() {
        this.f11235a.clear();
        this.f11236b.clear();
        this.f11237c.clear();
        this.f11238d.clear();
        this.f11239e.clear();
        this.f11240f.clear();
        this.f11241g.clear();
        this.f11242h = false;
    }

    /* renamed from: e */
    public void mo28596e() {
        this.f11242h = true;
    }
}
