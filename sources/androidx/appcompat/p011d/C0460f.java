package androidx.appcompat.p011d;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.p011d.C0455b;
import androidx.appcompat.view.menu.C0488j;
import androidx.appcompat.view.menu.C0501o;
import androidx.core.p014b.p015a.C0748a;
import androidx.core.p014b.p015a.C0749b;
import java.util.ArrayList;
import p075d.p080b.C3204g;

/* renamed from: androidx.appcompat.d.f */
/* compiled from: SupportActionModeWrapper */
public class C0460f extends ActionMode {

    /* renamed from: a */
    final Context f656a;

    /* renamed from: b */
    final C0455b f657b;

    public C0460f(Context context, C0455b bVar) {
        this.f656a = context;
        this.f657b = bVar;
    }

    public void finish() {
        this.f657b.mo2150a();
    }

    public View getCustomView() {
        return this.f657b.mo2155b();
    }

    public Menu getMenu() {
        return new C0501o(this.f656a, (C0748a) this.f657b.mo2158c());
    }

    public MenuInflater getMenuInflater() {
        return this.f657b.mo2159d();
    }

    public CharSequence getSubtitle() {
        return this.f657b.mo2160e();
    }

    public Object getTag() {
        return this.f657b.mo2299f();
    }

    public CharSequence getTitle() {
        return this.f657b.mo2161g();
    }

    public boolean getTitleOptionalHint() {
        return this.f657b.mo2300h();
    }

    public void invalidate() {
        this.f657b.mo2162i();
    }

    public boolean isTitleOptional() {
        return this.f657b.mo2163j();
    }

    public void setCustomView(View view) {
        this.f657b.mo2152a(view);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f657b.mo2153a(charSequence);
    }

    public void setTag(Object obj) {
        this.f657b.mo2298a(obj);
    }

    public void setTitle(CharSequence charSequence) {
        this.f657b.mo2157b(charSequence);
    }

    public void setTitleOptionalHint(boolean z) {
        this.f657b.mo2154a(z);
    }

    public void setSubtitle(int i) {
        this.f657b.mo2151a(i);
    }

    public void setTitle(int i) {
        this.f657b.mo2156b(i);
    }

    /* renamed from: androidx.appcompat.d.f$a */
    /* compiled from: SupportActionModeWrapper */
    public static class C0461a implements C0455b.C0456a {

        /* renamed from: a */
        final ActionMode.Callback f658a;

        /* renamed from: b */
        final Context f659b;

        /* renamed from: c */
        final ArrayList<C0460f> f660c = new ArrayList<>();

        /* renamed from: d */
        final C3204g<Menu, Menu> f661d = new C3204g<>();

        public C0461a(Context context, ActionMode.Callback callback) {
            this.f659b = context;
            this.f658a = callback;
        }

        /* renamed from: a */
        public boolean mo2091a(C0455b bVar, Menu menu) {
            return this.f658a.onCreateActionMode(mo2328b(bVar), m768a(menu));
        }

        /* renamed from: b */
        public boolean mo2093b(C0455b bVar, Menu menu) {
            return this.f658a.onPrepareActionMode(mo2328b(bVar), m768a(menu));
        }

        /* renamed from: a */
        public boolean mo2092a(C0455b bVar, MenuItem menuItem) {
            return this.f658a.onActionItemClicked(mo2328b(bVar), new C0488j(this.f659b, (C0749b) menuItem));
        }

        /* renamed from: b */
        public ActionMode mo2328b(C0455b bVar) {
            int size = this.f660c.size();
            for (int i = 0; i < size; i++) {
                C0460f fVar = this.f660c.get(i);
                if (fVar != null && fVar.f657b == bVar) {
                    return fVar;
                }
            }
            C0460f fVar2 = new C0460f(this.f659b, bVar);
            this.f660c.add(fVar2);
            return fVar2;
        }

        /* renamed from: a */
        public void mo2090a(C0455b bVar) {
            this.f658a.onDestroyActionMode(mo2328b(bVar));
        }

        /* renamed from: a */
        private Menu m768a(Menu menu) {
            Menu menu2 = this.f661d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            C0501o oVar = new C0501o(this.f659b, (C0748a) menu);
            this.f661d.put(menu, oVar);
            return oVar;
        }
    }
}
