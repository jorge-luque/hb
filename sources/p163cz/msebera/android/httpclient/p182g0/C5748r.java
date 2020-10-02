package p163cz.msebera.android.httpclient.p182g0;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p163cz.msebera.android.httpclient.C5691d;
import p163cz.msebera.android.httpclient.C5730g;

/* renamed from: cz.msebera.android.httpclient.g0.r */
/* compiled from: HeaderGroup */
public class C5748r implements Cloneable, Serializable {
    private static final long serialVersionUID = 2608834160639271617L;

    /* renamed from: a */
    private final C5691d[] f14847a = new C5691d[0];

    /* renamed from: b */
    private final List<C5691d> f14848b = new ArrayList(16);

    /* renamed from: a */
    public void mo33391a() {
        this.f14848b.clear();
    }

    /* renamed from: b */
    public void mo33396b(C5691d dVar) {
        if (dVar != null) {
            this.f14848b.remove(dVar);
        }
    }

    /* renamed from: c */
    public void mo33399c(C5691d dVar) {
        if (dVar != null) {
            for (int i = 0; i < this.f14848b.size(); i++) {
                if (this.f14848b.get(i).getName().equalsIgnoreCase(dVar.getName())) {
                    this.f14848b.set(i, dVar);
                    return;
                }
            }
            this.f14848b.add(dVar);
        }
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /* renamed from: d */
    public C5730g mo33402d(String str) {
        return new C5742l(this.f14848b, str);
    }

    public String toString() {
        return this.f14848b.toString();
    }

    /* renamed from: a */
    public void mo33392a(C5691d dVar) {
        if (dVar != null) {
            this.f14848b.add(dVar);
        }
    }

    /* renamed from: b */
    public C5691d mo33395b(String str) {
        for (int i = 0; i < this.f14848b.size(); i++) {
            C5691d dVar = this.f14848b.get(i);
            if (dVar.getName().equalsIgnoreCase(str)) {
                return dVar;
            }
        }
        return null;
    }

    /* renamed from: a */
    public void mo33393a(C5691d[] dVarArr) {
        mo33391a();
        if (dVarArr != null) {
            Collections.addAll(this.f14848b, dVarArr);
        }
    }

    /* renamed from: a */
    public boolean mo33394a(String str) {
        for (int i = 0; i < this.f14848b.size(); i++) {
            if (this.f14848b.get(i).getName().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public C5691d[] mo33397b() {
        List<C5691d> list = this.f14848b;
        return (C5691d[]) list.toArray(new C5691d[list.size()]);
    }

    /* renamed from: c */
    public C5691d[] mo33400c(String str) {
        ArrayList arrayList = null;
        for (int i = 0; i < this.f14848b.size(); i++) {
            C5691d dVar = this.f14848b.get(i);
            if (dVar.getName().equalsIgnoreCase(str)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(dVar);
            }
        }
        return arrayList != null ? (C5691d[]) arrayList.toArray(new C5691d[arrayList.size()]) : this.f14847a;
    }

    /* renamed from: c */
    public C5730g mo33398c() {
        return new C5742l(this.f14848b, (String) null);
    }
}
