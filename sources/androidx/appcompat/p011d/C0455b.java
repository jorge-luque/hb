package androidx.appcompat.p011d;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* renamed from: androidx.appcompat.d.b */
/* compiled from: ActionMode */
public abstract class C0455b {

    /* renamed from: a */
    private Object f643a;

    /* renamed from: b */
    private boolean f644b;

    /* renamed from: androidx.appcompat.d.b$a */
    /* compiled from: ActionMode */
    public interface C0456a {
        /* renamed from: a */
        void mo2090a(C0455b bVar);

        /* renamed from: a */
        boolean mo2091a(C0455b bVar, Menu menu);

        /* renamed from: a */
        boolean mo2092a(C0455b bVar, MenuItem menuItem);

        /* renamed from: b */
        boolean mo2093b(C0455b bVar, Menu menu);
    }

    /* renamed from: a */
    public abstract void mo2150a();

    /* renamed from: a */
    public abstract void mo2151a(int i);

    /* renamed from: a */
    public abstract void mo2152a(View view);

    /* renamed from: a */
    public abstract void mo2153a(CharSequence charSequence);

    /* renamed from: a */
    public void mo2298a(Object obj) {
        this.f643a = obj;
    }

    /* renamed from: b */
    public abstract View mo2155b();

    /* renamed from: b */
    public abstract void mo2156b(int i);

    /* renamed from: b */
    public abstract void mo2157b(CharSequence charSequence);

    /* renamed from: c */
    public abstract Menu mo2158c();

    /* renamed from: d */
    public abstract MenuInflater mo2159d();

    /* renamed from: e */
    public abstract CharSequence mo2160e();

    /* renamed from: f */
    public Object mo2299f() {
        return this.f643a;
    }

    /* renamed from: g */
    public abstract CharSequence mo2161g();

    /* renamed from: h */
    public boolean mo2300h() {
        return this.f644b;
    }

    /* renamed from: i */
    public abstract void mo2162i();

    /* renamed from: j */
    public abstract boolean mo2163j();

    /* renamed from: a */
    public void mo2154a(boolean z) {
        this.f644b = z;
    }
}
