package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.widget.LinearLayout;
import androidx.appcompat.R$string;
import androidx.appcompat.p006a.p007a.C0383a;
import androidx.appcompat.view.menu.C0499n;
import androidx.core.graphics.drawable.C0857a;
import androidx.core.p014b.p015a.C0749b;
import androidx.core.p020f.C0800b;

/* renamed from: androidx.appcompat.view.menu.i */
/* compiled from: MenuItemImpl */
public final class C0486i implements C0749b {

    /* renamed from: A */
    private View f859A;

    /* renamed from: B */
    private C0800b f860B;

    /* renamed from: C */
    private MenuItem.OnActionExpandListener f861C;

    /* renamed from: D */
    private boolean f862D = false;

    /* renamed from: E */
    private ContextMenu.ContextMenuInfo f863E;

    /* renamed from: a */
    private final int f864a;

    /* renamed from: b */
    private final int f865b;

    /* renamed from: c */
    private final int f866c;

    /* renamed from: d */
    private final int f867d;

    /* renamed from: e */
    private CharSequence f868e;

    /* renamed from: f */
    private CharSequence f869f;

    /* renamed from: g */
    private Intent f870g;

    /* renamed from: h */
    private char f871h;

    /* renamed from: i */
    private int f872i = CodedOutputStream.DEFAULT_BUFFER_SIZE;

    /* renamed from: j */
    private char f873j;

    /* renamed from: k */
    private int f874k = CodedOutputStream.DEFAULT_BUFFER_SIZE;

    /* renamed from: l */
    private Drawable f875l;

    /* renamed from: m */
    private int f876m = 0;

    /* renamed from: n */
    C0482g f877n;

    /* renamed from: o */
    private C0506r f878o;

    /* renamed from: p */
    private Runnable f879p;

    /* renamed from: q */
    private MenuItem.OnMenuItemClickListener f880q;

    /* renamed from: r */
    private CharSequence f881r;

    /* renamed from: s */
    private CharSequence f882s;

    /* renamed from: t */
    private ColorStateList f883t = null;

    /* renamed from: u */
    private PorterDuff.Mode f884u = null;

    /* renamed from: v */
    private boolean f885v = false;

    /* renamed from: w */
    private boolean f886w = false;

    /* renamed from: x */
    private boolean f887x = false;

    /* renamed from: y */
    private int f888y = 16;

    /* renamed from: z */
    private int f889z = 0;

    /* renamed from: androidx.appcompat.view.menu.i$a */
    /* compiled from: MenuItemImpl */
    class C0487a implements C0800b.C0802b {
        C0487a() {
        }

        public void onActionProviderVisibilityChanged(boolean z) {
            C0486i iVar = C0486i.this;
            iVar.f877n.mo2555d(iVar);
        }
    }

    C0486i(C0482g gVar, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.f877n = gVar;
        this.f864a = i2;
        this.f865b = i;
        this.f866c = i3;
        this.f867d = i4;
        this.f868e = charSequence;
        this.f889z = i5;
    }

    /* renamed from: a */
    private static void m959a(StringBuilder sb, int i, int i2, String str) {
        if ((i & i2) == i2) {
            sb.append(str);
        }
    }

    /* renamed from: b */
    public int mo2595b() {
        return this.f867d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public char mo2597c() {
        return this.f877n.mo2572p() ? this.f873j : this.f871h;
    }

    public boolean collapseActionView() {
        if ((this.f889z & 8) == 0) {
            return false;
        }
        if (this.f859A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f861C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f877n.mo2530a(this);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public String mo2599d() {
        char c = mo2597c();
        if (c == 0) {
            return "";
        }
        Resources resources = this.f877n.mo2556e().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.f877n.mo2556e()).hasPermanentMenuKey()) {
            sb.append(resources.getString(R$string.abc_prepend_shortcut_label));
        }
        int i = this.f877n.mo2572p() ? this.f874k : this.f872i;
        m959a(sb, i, 65536, resources.getString(R$string.abc_menu_meta_shortcut_label));
        m959a(sb, i, CodedOutputStream.DEFAULT_BUFFER_SIZE, resources.getString(R$string.abc_menu_ctrl_shortcut_label));
        m959a(sb, i, 2, resources.getString(R$string.abc_menu_alt_shortcut_label));
        m959a(sb, i, 1, resources.getString(R$string.abc_menu_shift_shortcut_label));
        m959a(sb, i, 4, resources.getString(R$string.abc_menu_sym_shortcut_label));
        m959a(sb, i, 8, resources.getString(R$string.abc_menu_function_shortcut_label));
        if (c == 8) {
            sb.append(resources.getString(R$string.abc_menu_delete_shortcut_label));
        } else if (c == 10) {
            sb.append(resources.getString(R$string.abc_menu_enter_shortcut_label));
        } else if (c != ' ') {
            sb.append(c);
        } else {
            sb.append(resources.getString(R$string.abc_menu_space_shortcut_label));
        }
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo2602e(boolean z) {
        int i = this.f888y;
        int i2 = (z ? 0 : 8) | (i & -9);
        this.f888y = i2;
        if (i != i2) {
            return true;
        }
        return false;
    }

    public boolean expandActionView() {
        if (!mo2601e()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f861C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f877n.mo2545b(this);
        }
        return false;
    }

    /* renamed from: f */
    public boolean mo2603f() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f880q;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        C0482g gVar = this.f877n;
        if (gVar.mo2529a(gVar, (MenuItem) this)) {
            return true;
        }
        Runnable runnable = this.f879p;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.f870g != null) {
            try {
                this.f877n.mo2556e().startActivity(this.f870g);
                return true;
            } catch (ActivityNotFoundException e) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
            }
        }
        C0800b bVar = this.f860B;
        if (bVar == null || !bVar.mo2704d()) {
            return false;
        }
        return true;
    }

    /* renamed from: g */
    public boolean mo2604g() {
        return (this.f888y & 32) == 32;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public View getActionView() {
        View view = this.f859A;
        if (view != null) {
            return view;
        }
        C0800b bVar = this.f860B;
        if (bVar == null) {
            return null;
        }
        View a = bVar.mo2705a((MenuItem) this);
        this.f859A = a;
        return a;
    }

    public int getAlphabeticModifiers() {
        return this.f874k;
    }

    public char getAlphabeticShortcut() {
        return this.f873j;
    }

    public CharSequence getContentDescription() {
        return this.f881r;
    }

    public int getGroupId() {
        return this.f865b;
    }

    public Drawable getIcon() {
        Drawable drawable = this.f875l;
        if (drawable != null) {
            return m958a(drawable);
        }
        if (this.f876m == 0) {
            return null;
        }
        Drawable c = C0383a.m323c(this.f877n.mo2556e(), this.f876m);
        this.f876m = 0;
        this.f875l = c;
        return m958a(c);
    }

    public ColorStateList getIconTintList() {
        return this.f883t;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f884u;
    }

    public Intent getIntent() {
        return this.f870g;
    }

    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f864a;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f863E;
    }

    public int getNumericModifiers() {
        return this.f872i;
    }

    public char getNumericShortcut() {
        return this.f871h;
    }

    public int getOrder() {
        return this.f866c;
    }

    public SubMenu getSubMenu() {
        return this.f878o;
    }

    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.f868e;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f869f;
        if (charSequence == null) {
            charSequence = this.f868e;
        }
        return (Build.VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    public CharSequence getTooltipText() {
        return this.f882s;
    }

    /* renamed from: h */
    public boolean mo2617h() {
        return (this.f888y & 4) != 0;
    }

    public boolean hasSubMenu() {
        return this.f878o != null;
    }

    /* renamed from: i */
    public boolean mo2619i() {
        return (this.f889z & 1) == 1;
    }

    public boolean isActionViewExpanded() {
        return this.f862D;
    }

    public boolean isCheckable() {
        return (this.f888y & 1) == 1;
    }

    public boolean isChecked() {
        return (this.f888y & 2) == 2;
    }

    public boolean isEnabled() {
        return (this.f888y & 16) != 0;
    }

    public boolean isVisible() {
        C0800b bVar = this.f860B;
        if (bVar == null || !bVar.mo2708e()) {
            if ((this.f888y & 8) == 0) {
                return true;
            }
            return false;
        } else if ((this.f888y & 8) != 0 || !this.f860B.mo2707b()) {
            return false;
        } else {
            return true;
        }
    }

    /* renamed from: j */
    public boolean mo2624j() {
        return (this.f889z & 2) == 2;
    }

    /* renamed from: k */
    public boolean mo2625k() {
        return this.f877n.mo2567k();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public boolean mo2626l() {
        return this.f877n.mo2575q() && mo2597c() != 0;
    }

    /* renamed from: m */
    public boolean mo2627m() {
        return (this.f889z & 4) == 4;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public MenuItem setAlphabeticShortcut(char c) {
        if (this.f873j == c) {
            return this;
        }
        this.f873j = Character.toLowerCase(c);
        this.f877n.mo2544b(false);
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        int i = this.f888y;
        boolean z2 = z | (i & true);
        this.f888y = z2 ? 1 : 0;
        if (i != z2) {
            this.f877n.mo2544b(false);
        }
        return this;
    }

    public MenuItem setChecked(boolean z) {
        if ((this.f888y & 4) != 0) {
            this.f877n.mo2521a((MenuItem) this);
        } else {
            mo2596b(z);
        }
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.f888y |= 16;
        } else {
            this.f888y &= -17;
        }
        this.f877n.mo2544b(false);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f876m = 0;
        this.f875l = drawable;
        this.f887x = true;
        this.f877n.mo2544b(false);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f883t = colorStateList;
        this.f885v = true;
        this.f887x = true;
        this.f877n.mo2544b(false);
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f884u = mode;
        this.f886w = true;
        this.f887x = true;
        this.f877n.mo2544b(false);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f870g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        if (this.f871h == c) {
            return this;
        }
        this.f871h = c;
        this.f877n.mo2544b(false);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f861C = onActionExpandListener;
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f880q = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f871h = c;
        this.f873j = Character.toLowerCase(c2);
        this.f877n.mo2544b(false);
        return this;
    }

    public void setShowAsAction(int i) {
        int i2 = i & 3;
        if (i2 == 0 || i2 == 1 || i2 == 2) {
            this.f889z = i;
            this.f877n.mo2548c(this);
            return;
        }
        throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f868e = charSequence;
        this.f877n.mo2544b(false);
        C0506r rVar = this.f878o;
        if (rVar != null) {
            rVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f869f = charSequence;
        this.f877n.mo2544b(false);
        return this;
    }

    public MenuItem setVisible(boolean z) {
        if (mo2602e(z)) {
            this.f877n.mo2555d(this);
        }
        return this;
    }

    public String toString() {
        CharSequence charSequence = this.f868e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    /* renamed from: a */
    public void mo2593a(C0506r rVar) {
        this.f878o = rVar;
        rVar.setHeaderTitle(getTitle());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo2596b(boolean z) {
        int i = this.f888y;
        int i2 = (z ? 2 : 0) | (i & -3);
        this.f888y = i2;
        if (i != i2) {
            this.f877n.mo2544b(false);
        }
    }

    /* renamed from: c */
    public void mo2598c(boolean z) {
        this.f888y = (z ? 4 : 0) | (this.f888y & -5);
    }

    public C0749b setContentDescription(CharSequence charSequence) {
        this.f881r = charSequence;
        this.f877n.mo2544b(false);
        return this;
    }

    public C0749b setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    public C0749b setTooltipText(CharSequence charSequence) {
        this.f882s = charSequence;
        this.f877n.mo2544b(false);
        return this;
    }

    /* renamed from: e */
    public boolean mo2601e() {
        C0800b bVar;
        if ((this.f889z & 8) == 0) {
            return false;
        }
        if (this.f859A == null && (bVar = this.f860B) != null) {
            this.f859A = bVar.mo2705a((MenuItem) this);
        }
        if (this.f859A != null) {
            return true;
        }
        return false;
    }

    public C0749b setActionView(View view) {
        int i;
        this.f859A = view;
        this.f860B = null;
        if (view != null && view.getId() == -1 && (i = this.f864a) > 0) {
            view.setId(i);
        }
        this.f877n.mo2548c(this);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public CharSequence mo2591a(C0499n.C0500a aVar) {
        if (aVar == null || !aVar.mo2370c()) {
            return getTitle();
        }
        return getTitleCondensed();
    }

    public MenuItem setAlphabeticShortcut(char c, int i) {
        if (this.f873j == c && this.f874k == i) {
            return this;
        }
        this.f873j = Character.toLowerCase(c);
        this.f874k = KeyEvent.normalizeMetaState(i);
        this.f877n.mo2544b(false);
        return this;
    }

    public MenuItem setNumericShortcut(char c, int i) {
        if (this.f871h == c && this.f872i == i) {
            return this;
        }
        this.f871h = c;
        this.f872i = KeyEvent.normalizeMetaState(i);
        this.f877n.mo2544b(false);
        return this;
    }

    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.f871h = c;
        this.f872i = KeyEvent.normalizeMetaState(i);
        this.f873j = Character.toLowerCase(c2);
        this.f874k = KeyEvent.normalizeMetaState(i2);
        this.f877n.mo2544b(false);
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f875l = null;
        this.f876m = i;
        this.f887x = true;
        this.f877n.mo2544b(false);
        return this;
    }

    public MenuItem setTitle(int i) {
        setTitle((CharSequence) this.f877n.mo2556e().getString(i));
        return this;
    }

    /* renamed from: a */
    private Drawable m958a(Drawable drawable) {
        if (drawable != null && this.f887x && (this.f885v || this.f886w)) {
            drawable = C0857a.m2818h(drawable).mutate();
            if (this.f885v) {
                C0857a.m2804a(drawable, this.f883t);
            }
            if (this.f886w) {
                C0857a.m2807a(drawable, this.f884u);
            }
            this.f887x = false;
        }
        return drawable;
    }

    public C0749b setActionView(int i) {
        Context e = this.f877n.mo2556e();
        setActionView(LayoutInflater.from(e).inflate(i, new LinearLayout(e), false));
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2592a(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.f863E = contextMenuInfo;
    }

    /* renamed from: a */
    public C0800b mo2396a() {
        return this.f860B;
    }

    /* renamed from: a */
    public C0749b mo2395a(C0800b bVar) {
        C0800b bVar2 = this.f860B;
        if (bVar2 != null) {
            bVar2.mo4098f();
        }
        this.f859A = null;
        this.f860B = bVar;
        this.f877n.mo2544b(true);
        C0800b bVar3 = this.f860B;
        if (bVar3 != null) {
            bVar3.mo2706a((C0800b.C0802b) new C0487a());
        }
        return this;
    }

    /* renamed from: a */
    public void mo2594a(boolean z) {
        this.f862D = z;
        this.f877n.mo2544b(false);
    }

    /* renamed from: d */
    public void mo2600d(boolean z) {
        if (z) {
            this.f888y |= 32;
        } else {
            this.f888y &= -33;
        }
    }
}
