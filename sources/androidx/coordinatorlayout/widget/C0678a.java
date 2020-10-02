package androidx.coordinatorlayout.widget;

import androidx.core.p019e.C0792e;
import androidx.core.p019e.C0793f;
import java.util.ArrayList;
import java.util.HashSet;
import p075d.p080b.C3204g;

/* renamed from: androidx.coordinatorlayout.widget.a */
/* compiled from: DirectedAcyclicGraph */
public final class C0678a<T> {

    /* renamed from: a */
    private final C0792e<ArrayList<T>> f1721a = new C0793f(10);

    /* renamed from: b */
    private final C3204g<T, ArrayList<T>> f1722b = new C3204g<>();

    /* renamed from: c */
    private final ArrayList<T> f1723c = new ArrayList<>();

    /* renamed from: d */
    private final HashSet<T> f1724d = new HashSet<>();

    /* renamed from: a */
    public void mo3817a(T t) {
        if (!this.f1722b.containsKey(t)) {
            this.f1722b.put(t, null);
        }
    }

    /* renamed from: b */
    public boolean mo3820b(T t) {
        return this.f1722b.containsKey(t);
    }

    /* renamed from: c */
    public boolean mo3821c(T t) {
        int size = this.f1722b.size();
        for (int i = 0; i < size; i++) {
            ArrayList d = this.f1722b.mo18808d(i);
            if (d != null && d.contains(t)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public ArrayList<T> mo3819b() {
        this.f1723c.clear();
        this.f1724d.clear();
        int size = this.f1722b.size();
        for (int i = 0; i < size; i++) {
            m2085a(this.f1722b.mo18803b(i), this.f1723c, this.f1724d);
        }
        return this.f1723c;
    }

    /* renamed from: a */
    public void mo3818a(T t, T t2) {
        if (!this.f1722b.containsKey(t) || !this.f1722b.containsKey(t2)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList arrayList = this.f1722b.get(t);
        if (arrayList == null) {
            arrayList = m2087c();
            this.f1722b.put(t, arrayList);
        }
        arrayList.add(t2);
    }

    /* renamed from: c */
    private ArrayList<T> m2087c() {
        ArrayList<T> a = this.f1721a.mo4075a();
        return a == null ? new ArrayList<>() : a;
    }

    /* renamed from: a */
    public void mo3816a() {
        int size = this.f1722b.size();
        for (int i = 0; i < size; i++) {
            ArrayList d = this.f1722b.mo18808d(i);
            if (d != null) {
                m2086a(d);
            }
        }
        this.f1722b.clear();
    }

    /* renamed from: a */
    private void m2085a(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (!arrayList.contains(t)) {
            if (!hashSet.contains(t)) {
                hashSet.add(t);
                ArrayList arrayList2 = this.f1722b.get(t);
                if (arrayList2 != null) {
                    int size = arrayList2.size();
                    for (int i = 0; i < size; i++) {
                        m2085a(arrayList2.get(i), arrayList, hashSet);
                    }
                }
                hashSet.remove(t);
                arrayList.add(t);
                return;
            }
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
    }

    /* renamed from: a */
    private void m2086a(ArrayList<T> arrayList) {
        arrayList.clear();
        this.f1721a.mo4076a(arrayList);
    }
}
