package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.content.C0768a;
import androidx.core.graphics.drawable.C0857a;
import androidx.core.p014b.p015a.C0749b;
import androidx.core.p020f.C0800b;

/* renamed from: androidx.appcompat.view.menu.a */
/* compiled from: ActionMenuItem */
public class C0470a implements C0749b {

    /* renamed from: a */
    private final int f744a;

    /* renamed from: b */
    private final int f745b;

    /* renamed from: c */
    private final int f746c;

    /* renamed from: d */
    private CharSequence f747d;

    /* renamed from: e */
    private CharSequence f748e;

    /* renamed from: f */
    private Intent f749f;

    /* renamed from: g */
    private char f750g;

    /* renamed from: h */
    private int f751h = CodedOutputStream.DEFAULT_BUFFER_SIZE;

    /* renamed from: i */
    private char f752i;

    /* renamed from: j */
    private int f753j = CodedOutputStream.DEFAULT_BUFFER_SIZE;

    /* renamed from: k */
    private Drawable f754k;

    /* renamed from: l */
    private Context f755l;

    /* renamed from: m */
    private CharSequence f756m;

    /* renamed from: n */
    private CharSequence f757n;

    /* renamed from: o */
    private ColorStateList f758o = null;

    /* renamed from: p */
    private PorterDuff.Mode f759p = null;

    /* renamed from: q */
    private boolean f760q = false;

    /* renamed from: r */
    private boolean f761r = false;

    /* renamed from: s */
    private int f762s = 16;

    public C0470a(Context context, int i, int i2, int i3, int i4, CharSequence charSequence) {
        this.f755l = context;
        this.f744a = i2;
        this.f745b = i;
        this.f746c = i4;
        this.f747d = charSequence;
    }

    /* renamed from: b */
    private void m831b() {
        if (this.f754k == null) {
            return;
        }
        if (this.f760q || this.f761r) {
            Drawable h = C0857a.m2818h(this.f754k);
            this.f754k = h;
            Drawable mutate = h.mutate();
            this.f754k = mutate;
            if (this.f760q) {
                C0857a.m2804a(mutate, this.f758o);
            }
            if (this.f761r) {
                C0857a.m2807a(this.f754k, this.f759p);
            }
        }
    }

    /* renamed from: a */
    public C0749b mo2395a(C0800b bVar) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public C0800b mo2396a() {
        return null;
    }

    public boolean collapseActionView() {
        return false;
    }

    public boolean expandActionView() {
        return false;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    public View getActionView() {
        return null;
    }

    public int getAlphabeticModifiers() {
        return this.f753j;
    }

    public char getAlphabeticShortcut() {
        return this.f752i;
    }

    public CharSequence getContentDescription() {
        return this.f756m;
    }

    public int getGroupId() {
        return this.f745b;
    }

    public Drawable getIcon() {
        return this.f754k;
    }

    public ColorStateList getIconTintList() {
        return this.f758o;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f759p;
    }

    public Intent getIntent() {
        return this.f749f;
    }

    public int getItemId() {
        return this.f744a;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    public int getNumericModifiers() {
        return this.f751h;
    }

    public char getNumericShortcut() {
        return this.f750g;
    }

    public int getOrder() {
        return this.f746c;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public CharSequence getTitle() {
        return this.f747d;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f748e;
        return charSequence != null ? charSequence : this.f747d;
    }

    public CharSequence getTooltipText() {
        return this.f757n;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isActionViewExpanded() {
        return false;
    }

    public boolean isCheckable() {
        return (this.f762s & 1) != 0;
    }

    public boolean isChecked() {
        return (this.f762s & 2) != 0;
    }

    public boolean isEnabled() {
        return (this.f762s & 16) != 0;
    }

    public boolean isVisible() {
        return (this.f762s & 8) == 0;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setAlphabeticShortcut(char c) {
        this.f752i = Character.toLowerCase(c);
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.f762s = z | (this.f762s & true) ? 1 : 0;
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.f762s = (z ? 2 : 0) | (this.f762s & -3);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.f762s = (z ? 16 : 0) | (this.f762s & -17);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f754k = drawable;
        m831b();
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f758o = colorStateList;
        this.f760q = true;
        m831b();
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f759p = mode;
        this.f761r = true;
        m831b();
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f749f = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        this.f750g = c;
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f750g = c;
        this.f752i = Character.toLowerCase(c2);
        return this;
    }

    public void setShowAsAction(int i) {
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f747d = charSequence;
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f748e = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean z) {
        int i = 8;
        int i2 = this.f762s & 8;
        if (z) {
            i = 0;
        }
        this.f762s = i2 | i;
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c, int i) {
        this.f752i = Character.toLowerCase(c);
        this.f753j = KeyEvent.normalizeMetaState(i);
        return this;
    }

    public C0749b setContentDescription(CharSequence charSequence) {
        this.f756m = charSequence;
        return this;
    }

    public MenuItem setNumericShortcut(char c, int i) {
        this.f750g = c;
        this.f751h = KeyEvent.normalizeMetaState(i);
        return this;
    }

    public C0749b setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    public MenuItem setTitle(int i) {
        this.f747d = this.f755l.getResources().getString(i);
        return this;
    }

    public C0749b setTooltipText(CharSequence charSequence) {
        this.f757n = charSequence;
        return this;
    }

    public C0749b setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setIcon(int i) {
        this.f754k = C0768a.m2411c(this.f755l, i);
        m831b();
        return this;
    }

    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.f750g = c;
        this.f751h = KeyEvent.normalizeMetaState(i);
        this.f752i = Character.toLowerCase(c2);
        this.f753j = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    public C0749b setActionView(int i) {
        throw new UnsupportedOperationException();
    }
}
