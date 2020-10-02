package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.p011d.C0457c;
import androidx.core.p014b.p015a.C0749b;
import androidx.core.p020f.C0800b;
import java.lang.reflect.Method;

/* renamed from: androidx.appcompat.view.menu.j */
/* compiled from: MenuItemWrapperICS */
public class C0488j extends C0472c implements MenuItem {

    /* renamed from: d */
    private final C0749b f891d;

    /* renamed from: e */
    private Method f892e;

    /* renamed from: androidx.appcompat.view.menu.j$a */
    /* compiled from: MenuItemWrapperICS */
    private class C0489a extends C0800b {

        /* renamed from: c */
        final ActionProvider f893c;

        C0489a(Context context, ActionProvider actionProvider) {
            super(context);
            this.f893c = actionProvider;
        }

        /* renamed from: a */
        public boolean mo2702a() {
            return this.f893c.hasSubMenu();
        }

        /* renamed from: c */
        public View mo2703c() {
            return this.f893c.onCreateActionView();
        }

        /* renamed from: d */
        public boolean mo2704d() {
            return this.f893c.onPerformDefaultAction();
        }

        /* renamed from: a */
        public void mo2701a(SubMenu subMenu) {
            this.f893c.onPrepareSubMenu(C0488j.this.mo2468a(subMenu));
        }
    }

    /* renamed from: androidx.appcompat.view.menu.j$b */
    /* compiled from: MenuItemWrapperICS */
    private class C0490b extends C0489a implements ActionProvider.VisibilityListener {

        /* renamed from: e */
        private C0800b.C0802b f895e;

        C0490b(C0488j jVar, Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        /* renamed from: a */
        public View mo2705a(MenuItem menuItem) {
            return this.f893c.onCreateActionView(menuItem);
        }

        /* renamed from: b */
        public boolean mo2707b() {
            return this.f893c.isVisible();
        }

        /* renamed from: e */
        public boolean mo2708e() {
            return this.f893c.overridesItemVisibility();
        }

        public void onActionProviderVisibilityChanged(boolean z) {
            C0800b.C0802b bVar = this.f895e;
            if (bVar != null) {
                bVar.onActionProviderVisibilityChanged(z);
            }
        }

        /* renamed from: a */
        public void mo2706a(C0800b.C0802b bVar) {
            this.f895e = bVar;
            this.f893c.setVisibilityListener(bVar != null ? this : null);
        }
    }

    /* renamed from: androidx.appcompat.view.menu.j$c */
    /* compiled from: MenuItemWrapperICS */
    static class C0491c extends FrameLayout implements C0457c {

        /* renamed from: a */
        final CollapsibleActionView f896a;

        C0491c(View view) {
            super(view.getContext());
            this.f896a = (CollapsibleActionView) view;
            addView(view);
        }

        /* renamed from: a */
        public void mo2301a() {
            this.f896a.onActionViewExpanded();
        }

        /* renamed from: b */
        public void mo2302b() {
            this.f896a.onActionViewCollapsed();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public View mo2710c() {
            return (View) this.f896a;
        }
    }

    /* renamed from: androidx.appcompat.view.menu.j$d */
    /* compiled from: MenuItemWrapperICS */
    private class C0492d implements MenuItem.OnActionExpandListener {

        /* renamed from: a */
        private final MenuItem.OnActionExpandListener f897a;

        C0492d(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.f897a = onActionExpandListener;
        }

        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f897a.onMenuItemActionCollapse(C0488j.this.mo2467a(menuItem));
        }

        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f897a.onMenuItemActionExpand(C0488j.this.mo2467a(menuItem));
        }
    }

    /* renamed from: androidx.appcompat.view.menu.j$e */
    /* compiled from: MenuItemWrapperICS */
    private class C0493e implements MenuItem.OnMenuItemClickListener {

        /* renamed from: a */
        private final MenuItem.OnMenuItemClickListener f899a;

        C0493e(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.f899a = onMenuItemClickListener;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.f899a.onMenuItemClick(C0488j.this.mo2467a(menuItem));
        }
    }

    public C0488j(Context context, C0749b bVar) {
        super(context);
        if (bVar != null) {
            this.f891d = bVar;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    /* renamed from: a */
    public void mo2646a(boolean z) {
        try {
            if (this.f892e == null) {
                this.f892e = this.f891d.getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
            }
            this.f892e.invoke(this.f891d, new Object[]{Boolean.valueOf(z)});
        } catch (Exception e) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
        }
    }

    public boolean collapseActionView() {
        return this.f891d.collapseActionView();
    }

    public boolean expandActionView() {
        return this.f891d.expandActionView();
    }

    public ActionProvider getActionProvider() {
        C0800b a = this.f891d.mo2396a();
        if (a instanceof C0489a) {
            return ((C0489a) a).f893c;
        }
        return null;
    }

    public View getActionView() {
        View actionView = this.f891d.getActionView();
        return actionView instanceof C0491c ? ((C0491c) actionView).mo2710c() : actionView;
    }

    public int getAlphabeticModifiers() {
        return this.f891d.getAlphabeticModifiers();
    }

    public char getAlphabeticShortcut() {
        return this.f891d.getAlphabeticShortcut();
    }

    public CharSequence getContentDescription() {
        return this.f891d.getContentDescription();
    }

    public int getGroupId() {
        return this.f891d.getGroupId();
    }

    public Drawable getIcon() {
        return this.f891d.getIcon();
    }

    public ColorStateList getIconTintList() {
        return this.f891d.getIconTintList();
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f891d.getIconTintMode();
    }

    public Intent getIntent() {
        return this.f891d.getIntent();
    }

    public int getItemId() {
        return this.f891d.getItemId();
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f891d.getMenuInfo();
    }

    public int getNumericModifiers() {
        return this.f891d.getNumericModifiers();
    }

    public char getNumericShortcut() {
        return this.f891d.getNumericShortcut();
    }

    public int getOrder() {
        return this.f891d.getOrder();
    }

    public SubMenu getSubMenu() {
        return mo2468a(this.f891d.getSubMenu());
    }

    public CharSequence getTitle() {
        return this.f891d.getTitle();
    }

    public CharSequence getTitleCondensed() {
        return this.f891d.getTitleCondensed();
    }

    public CharSequence getTooltipText() {
        return this.f891d.getTooltipText();
    }

    public boolean hasSubMenu() {
        return this.f891d.hasSubMenu();
    }

    public boolean isActionViewExpanded() {
        return this.f891d.isActionViewExpanded();
    }

    public boolean isCheckable() {
        return this.f891d.isCheckable();
    }

    public boolean isChecked() {
        return this.f891d.isChecked();
    }

    public boolean isEnabled() {
        return this.f891d.isEnabled();
    }

    public boolean isVisible() {
        return this.f891d.isVisible();
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        C0800b bVar;
        if (Build.VERSION.SDK_INT >= 16) {
            bVar = new C0490b(this, this.f771a, actionProvider);
        } else {
            bVar = new C0489a(this.f771a, actionProvider);
        }
        C0749b bVar2 = this.f891d;
        if (actionProvider == null) {
            bVar = null;
        }
        bVar2.mo2395a(bVar);
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new C0491c(view);
        }
        this.f891d.setActionView(view);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c) {
        this.f891d.setAlphabeticShortcut(c);
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.f891d.setCheckable(z);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.f891d.setChecked(z);
        return this;
    }

    public MenuItem setContentDescription(CharSequence charSequence) {
        this.f891d.setContentDescription(charSequence);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.f891d.setEnabled(z);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f891d.setIcon(drawable);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f891d.setIconTintList(colorStateList);
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f891d.setIconTintMode(mode);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f891d.setIntent(intent);
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        this.f891d.setNumericShortcut(c);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f891d.setOnActionExpandListener(onActionExpandListener != null ? new C0492d(onActionExpandListener) : null);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f891d.setOnMenuItemClickListener(onMenuItemClickListener != null ? new C0493e(onMenuItemClickListener) : null);
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f891d.setShortcut(c, c2);
        return this;
    }

    public void setShowAsAction(int i) {
        this.f891d.setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i) {
        this.f891d.setShowAsActionFlags(i);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f891d.setTitle(charSequence);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f891d.setTitleCondensed(charSequence);
        return this;
    }

    public MenuItem setTooltipText(CharSequence charSequence) {
        this.f891d.setTooltipText(charSequence);
        return this;
    }

    public MenuItem setVisible(boolean z) {
        return this.f891d.setVisible(z);
    }

    public MenuItem setAlphabeticShortcut(char c, int i) {
        this.f891d.setAlphabeticShortcut(c, i);
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f891d.setIcon(i);
        return this;
    }

    public MenuItem setNumericShortcut(char c, int i) {
        this.f891d.setNumericShortcut(c, i);
        return this;
    }

    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.f891d.setShortcut(c, c2, i, i2);
        return this;
    }

    public MenuItem setTitle(int i) {
        this.f891d.setTitle(i);
        return this;
    }

    public MenuItem setActionView(int i) {
        this.f891d.setActionView(i);
        View actionView = this.f891d.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.f891d.setActionView((View) new C0491c(actionView));
        }
        return this;
    }
}
