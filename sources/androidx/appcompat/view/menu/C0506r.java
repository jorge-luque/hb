package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.C0482g;

/* renamed from: androidx.appcompat.view.menu.r */
/* compiled from: SubMenuBuilder */
public class C0506r extends C0482g implements SubMenu {

    /* renamed from: B */
    private C0482g f939B;

    /* renamed from: C */
    private C0486i f940C;

    public C0506r(Context context, C0482g gVar, C0486i iVar) {
        super(context);
        this.f939B = gVar;
        this.f940C = iVar;
    }

    /* renamed from: a */
    public void mo2522a(C0482g.C0483a aVar) {
        this.f939B.mo2522a(aVar);
    }

    /* renamed from: b */
    public boolean mo2545b(C0486i iVar) {
        return this.f939B.mo2545b(iVar);
    }

    /* renamed from: d */
    public String mo2554d() {
        C0486i iVar = this.f940C;
        int itemId = iVar != null ? iVar.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.mo2554d() + ":" + itemId;
    }

    public MenuItem getItem() {
        return this.f940C;
    }

    /* renamed from: m */
    public C0482g mo2569m() {
        return this.f939B.mo2569m();
    }

    /* renamed from: o */
    public boolean mo2571o() {
        return this.f939B.mo2571o();
    }

    /* renamed from: p */
    public boolean mo2572p() {
        return this.f939B.mo2572p();
    }

    /* renamed from: q */
    public boolean mo2575q() {
        return this.f939B.mo2575q();
    }

    public void setGroupDividerEnabled(boolean z) {
        this.f939B.setGroupDividerEnabled(z);
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        super.mo2515a(drawable);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        super.mo2517a(charSequence);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        super.mo2516a(view);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        this.f940C.setIcon(drawable);
        return this;
    }

    public void setQwertyMode(boolean z) {
        this.f939B.setQwertyMode(z);
    }

    /* renamed from: t */
    public Menu mo2767t() {
        return this.f939B;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo2529a(C0482g gVar, MenuItem menuItem) {
        return super.mo2529a(gVar, menuItem) || this.f939B.mo2529a(gVar, menuItem);
    }

    public SubMenu setHeaderIcon(int i) {
        super.mo2553d(i);
        return this;
    }

    public SubMenu setHeaderTitle(int i) {
        super.mo2557e(i);
        return this;
    }

    public SubMenu setIcon(int i) {
        this.f940C.setIcon(i);
        return this;
    }

    /* renamed from: a */
    public boolean mo2530a(C0486i iVar) {
        return this.f939B.mo2530a(iVar);
    }
}
