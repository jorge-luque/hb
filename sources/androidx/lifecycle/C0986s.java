package androidx.lifecycle;

import java.util.HashMap;

/* renamed from: androidx.lifecycle.s */
/* compiled from: ViewModelStore */
public class C0986s {

    /* renamed from: a */
    private final HashMap<String, C0982q> f2538a = new HashMap<>();

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo5020a(String str, C0982q qVar) {
        C0982q put = this.f2538a.put(str, qVar);
        if (put != null) {
            put.mo4905b();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final C0982q mo5018a(String str) {
        return this.f2538a.get(str);
    }

    /* renamed from: a */
    public final void mo5019a() {
        for (C0982q a : this.f2538a.values()) {
            a.mo5014a();
        }
        this.f2538a.clear();
    }
}
