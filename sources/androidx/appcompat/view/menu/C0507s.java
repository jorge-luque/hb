package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.p014b.p015a.C0750c;

/* renamed from: androidx.appcompat.view.menu.s */
/* compiled from: SubMenuWrapperICS */
class C0507s extends C0501o implements SubMenu {

    /* renamed from: e */
    private final C0750c f941e;

    C0507s(Context context, C0750c cVar) {
        super(context, cVar);
        this.f941e = cVar;
    }

    public void clearHeader() {
        this.f941e.clearHeader();
    }

    public MenuItem getItem() {
        return mo2467a(this.f941e.getItem());
    }

    public SubMenu setHeaderIcon(int i) {
        this.f941e.setHeaderIcon(i);
        return this;
    }

    public SubMenu setHeaderTitle(int i) {
        this.f941e.setHeaderTitle(i);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        this.f941e.setHeaderView(view);
        return this;
    }

    public SubMenu setIcon(int i) {
        this.f941e.setIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        this.f941e.setHeaderIcon(drawable);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        this.f941e.setHeaderTitle(charSequence);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        this.f941e.setIcon(drawable);
        return this;
    }
}
