package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.core.p014b.p015a.C0749b;
import androidx.core.p014b.p015a.C0750c;
import java.util.Iterator;
import java.util.Map;
import p075d.p080b.C3191a;

/* renamed from: androidx.appcompat.view.menu.c */
/* compiled from: BaseMenuWrapper */
abstract class C0472c {

    /* renamed from: a */
    final Context f771a;

    /* renamed from: b */
    private Map<C0749b, MenuItem> f772b;

    /* renamed from: c */
    private Map<C0750c, SubMenu> f773c;

    C0472c(Context context) {
        this.f771a = context;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final MenuItem mo2467a(MenuItem menuItem) {
        if (!(menuItem instanceof C0749b)) {
            return menuItem;
        }
        C0749b bVar = (C0749b) menuItem;
        if (this.f772b == null) {
            this.f772b = new C3191a();
        }
        MenuItem menuItem2 = this.f772b.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        C0488j jVar = new C0488j(this.f771a, bVar);
        this.f772b.put(bVar, jVar);
        return jVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo2470b() {
        Map<C0749b, MenuItem> map = this.f772b;
        if (map != null) {
            map.clear();
        }
        Map<C0750c, SubMenu> map2 = this.f773c;
        if (map2 != null) {
            map2.clear();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo2471b(int i) {
        Map<C0749b, MenuItem> map = this.f772b;
        if (map != null) {
            Iterator<C0749b> it = map.keySet().iterator();
            while (it.hasNext()) {
                if (i == it.next().getItemId()) {
                    it.remove();
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final SubMenu mo2468a(SubMenu subMenu) {
        if (!(subMenu instanceof C0750c)) {
            return subMenu;
        }
        C0750c cVar = (C0750c) subMenu;
        if (this.f773c == null) {
            this.f773c = new C3191a();
        }
        SubMenu subMenu2 = this.f773c.get(cVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        C0507s sVar = new C0507s(this.f771a, cVar);
        this.f773c.put(cVar, sVar);
        return sVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo2469a(int i) {
        Map<C0749b, MenuItem> map = this.f772b;
        if (map != null) {
            Iterator<C0749b> it = map.keySet().iterator();
            while (it.hasNext()) {
                if (i == it.next().getGroupId()) {
                    it.remove();
                }
            }
        }
    }
}
