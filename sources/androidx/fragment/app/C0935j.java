package androidx.fragment.app;

import androidx.lifecycle.C0982q;
import androidx.lifecycle.C0983r;
import androidx.lifecycle.C0986s;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: androidx.fragment.app.j */
/* compiled from: FragmentManagerViewModel */
class C0935j extends C0982q {

    /* renamed from: h */
    private static final C0983r.C0984a f2393h = new C0936a();

    /* renamed from: b */
    private final HashSet<Fragment> f2394b = new HashSet<>();

    /* renamed from: c */
    private final HashMap<String, C0935j> f2395c = new HashMap<>();

    /* renamed from: d */
    private final HashMap<String, C0986s> f2396d = new HashMap<>();

    /* renamed from: e */
    private final boolean f2397e;

    /* renamed from: f */
    private boolean f2398f = false;

    /* renamed from: g */
    private boolean f2399g = false;

    /* renamed from: androidx.fragment.app.j$a */
    /* compiled from: FragmentManagerViewModel */
    static class C0936a implements C0983r.C0984a {
        C0936a() {
        }

        /* renamed from: a */
        public <T extends C0982q> T mo4916a(Class<T> cls) {
            return new C0935j(true);
        }
    }

    C0935j(boolean z) {
        this.f2397e = z;
    }

    /* renamed from: a */
    static C0935j m3317a(C0986s sVar) {
        return (C0935j) new C0983r(sVar, f2393h).mo5015a(C0935j.class);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo4905b() {
        if (C0920i.f2328H) {
            "onCleared called for " + this;
        }
        this.f2398f = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public Collection<Fragment> mo4908c() {
        return this.f2394b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo4910d() {
        return this.f2398f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo4911e(Fragment fragment) {
        return this.f2394b.remove(fragment);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0935j.class != obj.getClass()) {
            return false;
        }
        C0935j jVar = (C0935j) obj;
        if (!this.f2394b.equals(jVar.f2394b) || !this.f2395c.equals(jVar.f2395c) || !this.f2396d.equals(jVar.f2396d)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean mo4913f(Fragment fragment) {
        if (!this.f2394b.contains(fragment)) {
            return true;
        }
        if (this.f2397e) {
            return this.f2398f;
        }
        return !this.f2399g;
    }

    public int hashCode() {
        return (((this.f2394b.hashCode() * 31) + this.f2395c.hashCode()) * 31) + this.f2396d.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<Fragment> it = this.f2394b.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.f2395c.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.f2396d.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C0935j mo4907c(Fragment fragment) {
        C0935j jVar = this.f2395c.get(fragment.mWho);
        if (jVar != null) {
            return jVar;
        }
        C0935j jVar2 = new C0935j(this.f2397e);
        this.f2395c.put(fragment.mWho, jVar2);
        return jVar2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public C0986s mo4909d(Fragment fragment) {
        C0986s sVar = this.f2396d.get(fragment.mWho);
        if (sVar != null) {
            return sVar;
        }
        C0986s sVar2 = new C0986s();
        this.f2396d.put(fragment.mWho, sVar2);
        return sVar2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo4904a(Fragment fragment) {
        return this.f2394b.add(fragment);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo4906b(Fragment fragment) {
        if (C0920i.f2328H) {
            "Clearing non-config state for " + fragment;
        }
        C0935j jVar = this.f2395c.get(fragment.mWho);
        if (jVar != null) {
            jVar.mo4905b();
            this.f2395c.remove(fragment.mWho);
        }
        C0986s sVar = this.f2396d.get(fragment.mWho);
        if (sVar != null) {
            sVar.mo5019a();
            this.f2396d.remove(fragment.mWho);
        }
    }
}
