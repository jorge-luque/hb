package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.content.C0768a;
import androidx.core.p014b.p015a.C0748a;
import androidx.core.p020f.C0800b;
import androidx.core.p020f.C0848u;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: androidx.appcompat.view.menu.g */
/* compiled from: MenuBuilder */
public class C0482g implements C0748a {

    /* renamed from: A */
    private static final int[] f828A = {1, 4, 5, 3, 2, 0};

    /* renamed from: a */
    private final Context f829a;

    /* renamed from: b */
    private final Resources f830b;

    /* renamed from: c */
    private boolean f831c;

    /* renamed from: d */
    private boolean f832d;

    /* renamed from: e */
    private C0483a f833e;

    /* renamed from: f */
    private ArrayList<C0486i> f834f;

    /* renamed from: g */
    private ArrayList<C0486i> f835g;

    /* renamed from: h */
    private boolean f836h;

    /* renamed from: i */
    private ArrayList<C0486i> f837i;

    /* renamed from: j */
    private ArrayList<C0486i> f838j;

    /* renamed from: k */
    private boolean f839k;

    /* renamed from: l */
    private int f840l = 0;

    /* renamed from: m */
    private ContextMenu.ContextMenuInfo f841m;

    /* renamed from: n */
    CharSequence f842n;

    /* renamed from: o */
    Drawable f843o;

    /* renamed from: p */
    View f844p;

    /* renamed from: q */
    private boolean f845q = false;

    /* renamed from: r */
    private boolean f846r = false;

    /* renamed from: s */
    private boolean f847s = false;

    /* renamed from: t */
    private boolean f848t = false;

    /* renamed from: u */
    private boolean f849u = false;

    /* renamed from: v */
    private ArrayList<C0486i> f850v = new ArrayList<>();

    /* renamed from: w */
    private CopyOnWriteArrayList<WeakReference<C0497m>> f851w = new CopyOnWriteArrayList<>();

    /* renamed from: x */
    private C0486i f852x;

    /* renamed from: y */
    private boolean f853y = false;

    /* renamed from: z */
    private boolean f854z;

    /* renamed from: androidx.appcompat.view.menu.g$a */
    /* compiled from: MenuBuilder */
    public interface C0483a {
        /* renamed from: a */
        void mo2052a(C0482g gVar);

        /* renamed from: a */
        boolean mo2055a(C0482g gVar, MenuItem menuItem);
    }

    /* renamed from: androidx.appcompat.view.menu.g$b */
    /* compiled from: MenuBuilder */
    public interface C0484b {
        /* renamed from: a */
        boolean mo2383a(C0486i iVar);
    }

    public C0482g(Context context) {
        this.f829a = context;
        this.f830b = context.getResources();
        this.f834f = new ArrayList<>();
        this.f835g = new ArrayList<>();
        this.f836h = true;
        this.f837i = new ArrayList<>();
        this.f838j = new ArrayList<>();
        this.f839k = true;
        m901e(true);
    }

    /* renamed from: d */
    private void m900d(boolean z) {
        if (!this.f851w.isEmpty()) {
            mo2579s();
            Iterator<WeakReference<C0497m>> it = this.f851w.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                C0497m mVar = (C0497m) next.get();
                if (mVar == null) {
                    this.f851w.remove(next);
                } else {
                    mVar.mo2460a(z);
                }
            }
            mo2576r();
        }
    }

    /* renamed from: e */
    private void m901e(boolean z) {
        boolean z2 = true;
        if (!z || this.f830b.getConfiguration().keyboard == 1 || !C0848u.m2762d(ViewConfiguration.get(this.f829a), this.f829a)) {
            z2 = false;
        }
        this.f832d = z2;
    }

    /* renamed from: f */
    private static int m902f(int i) {
        int i2 = (-65536 & i) >> 16;
        if (i2 >= 0) {
            int[] iArr = f828A;
            if (i2 < iArr.length) {
                return (i & 65535) | (iArr[i2] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    /* renamed from: a */
    public void mo2523a(C0497m mVar) {
        mo2524a(mVar, this.f829a);
    }

    public MenuItem add(CharSequence charSequence) {
        return mo2514a(0, 0, 0, charSequence);
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        int i5;
        PackageManager packageManager = this.f829a.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i6 = 0; i6 < size; i6++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i6);
            int i7 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i7 < 0 ? intent : intentArr[i7]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent3 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && (i5 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i5] = intent3;
            }
        }
        return size;
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    /* renamed from: b */
    public void mo2543b(C0497m mVar) {
        Iterator<WeakReference<C0497m>> it = this.f851w.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            C0497m mVar2 = (C0497m) next.get();
            if (mVar2 == null || mVar2 == mVar) {
                this.f851w.remove(next);
            }
        }
    }

    /* renamed from: c */
    public C0482g mo2546c(int i) {
        this.f840l = i;
        return this;
    }

    public void clear() {
        C0486i iVar = this.f852x;
        if (iVar != null) {
            mo2530a(iVar);
        }
        this.f834f.clear();
        mo2544b(true);
    }

    public void clearHeader() {
        this.f843o = null;
        this.f842n = null;
        this.f844p = null;
        mo2544b(false);
    }

    public void close() {
        mo2526a(true);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public String mo2554d() {
        return "android:menu:actionviewstates";
    }

    public MenuItem findItem(int i) {
        MenuItem findItem;
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            C0486i iVar = this.f834f.get(i2);
            if (iVar.getItemId() == i) {
                return iVar;
            }
            if (iVar.hasSubMenu() && (findItem = iVar.getSubMenu().findItem(i)) != null) {
                return findItem;
            }
        }
        return null;
    }

    /* renamed from: g */
    public Drawable mo2560g() {
        return this.f843o;
    }

    public MenuItem getItem(int i) {
        return this.f834f.get(i);
    }

    /* renamed from: h */
    public CharSequence mo2562h() {
        return this.f842n;
    }

    public boolean hasVisibleItems() {
        if (this.f854z) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.f834f.get(i).isVisible()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: i */
    public View mo2564i() {
        return this.f844p;
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return mo2518a(i, keyEvent) != null;
    }

    /* renamed from: j */
    public ArrayList<C0486i> mo2566j() {
        mo2541b();
        return this.f838j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public boolean mo2567k() {
        return this.f848t;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public Resources mo2568l() {
        return this.f830b;
    }

    /* renamed from: m */
    public C0482g mo2569m() {
        return this;
    }

    /* renamed from: n */
    public ArrayList<C0486i> mo2570n() {
        if (!this.f836h) {
            return this.f835g;
        }
        this.f835g.clear();
        int size = this.f834f.size();
        for (int i = 0; i < size; i++) {
            C0486i iVar = this.f834f.get(i);
            if (iVar.isVisible()) {
                this.f835g.add(iVar);
            }
        }
        this.f836h = false;
        this.f839k = true;
        return this.f835g;
    }

    /* renamed from: o */
    public boolean mo2571o() {
        return this.f853y;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public boolean mo2572p() {
        return this.f831c;
    }

    public boolean performIdentifierAction(int i, int i2) {
        return mo2527a(findItem(i), i2);
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        C0486i a = mo2518a(i, keyEvent);
        boolean a2 = a != null ? mo2527a((MenuItem) a, i2) : false;
        if ((i2 & 2) != 0) {
            mo2526a(true);
        }
        return a2;
    }

    /* renamed from: q */
    public boolean mo2575q() {
        return this.f832d;
    }

    /* renamed from: r */
    public void mo2576r() {
        this.f845q = false;
        if (this.f846r) {
            this.f846r = false;
            mo2544b(this.f847s);
        }
    }

    public void removeGroup(int i) {
        int a = mo2512a(i);
        if (a >= 0) {
            int size = this.f834f.size() - a;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= size || this.f834f.get(a).getGroupId() != i) {
                    mo2544b(true);
                } else {
                    m898a(a, false);
                    i2 = i3;
                }
            }
            mo2544b(true);
        }
    }

    public void removeItem(int i) {
        m898a(mo2540b(i), true);
    }

    /* renamed from: s */
    public void mo2579s() {
        if (!this.f845q) {
            this.f845q = true;
            this.f846r = false;
            this.f847s = false;
        }
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.f834f.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0486i iVar = this.f834f.get(i2);
            if (iVar.getGroupId() == i) {
                iVar.mo2598c(z2);
                iVar.setCheckable(z);
            }
        }
    }

    public void setGroupDividerEnabled(boolean z) {
        this.f853y = z;
    }

    public void setGroupEnabled(int i, boolean z) {
        int size = this.f834f.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0486i iVar = this.f834f.get(i2);
            if (iVar.getGroupId() == i) {
                iVar.setEnabled(z);
            }
        }
    }

    public void setGroupVisible(int i, boolean z) {
        int size = this.f834f.size();
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            C0486i iVar = this.f834f.get(i2);
            if (iVar.getGroupId() == i && iVar.mo2602e(z)) {
                z2 = true;
            }
        }
        if (z2) {
            mo2544b(true);
        }
    }

    public void setQwertyMode(boolean z) {
        this.f831c = z;
        mo2544b(false);
    }

    public int size() {
        return this.f834f.size();
    }

    /* renamed from: a */
    public void mo2524a(C0497m mVar, Context context) {
        this.f851w.add(new WeakReference(mVar));
        mVar.mo2455a(context, this);
        this.f839k = true;
    }

    public MenuItem add(int i) {
        return mo2514a(0, 0, 0, this.f830b.getString(i));
    }

    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, (CharSequence) this.f830b.getString(i));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo2548c(C0486i iVar) {
        this.f839k = true;
        mo2544b(true);
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return mo2514a(i, i2, i3, charSequence);
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        C0486i iVar = (C0486i) mo2514a(i, i2, i3, charSequence);
        C0506r rVar = new C0506r(this.f829a, this, iVar);
        iVar.mo2593a(rVar);
        return rVar;
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return mo2514a(i, i2, i3, this.f830b.getString(i4));
    }

    /* renamed from: b */
    public void mo2542b(Bundle bundle) {
        int size = size();
        SparseArray sparseArray = null;
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (!(actionView == null || actionView.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((C0506r) item.getSubMenu()).mo2542b(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(mo2554d(), sparseArray);
        }
    }

    /* renamed from: c */
    public ArrayList<C0486i> mo2547c() {
        mo2541b();
        return this.f837i;
    }

    /* renamed from: f */
    public C0486i mo2558f() {
        return this.f852x;
    }

    /* renamed from: a */
    private boolean m899a(C0506r rVar, C0497m mVar) {
        boolean z = false;
        if (this.f851w.isEmpty()) {
            return false;
        }
        if (mVar != null) {
            z = mVar.mo2464a(rVar);
        }
        Iterator<WeakReference<C0497m>> it = this.f851w.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            C0497m mVar2 = (C0497m) next.get();
            if (mVar2 == null) {
                this.f851w.remove(next);
            } else if (!z) {
                z = mVar2.mo2464a(rVar);
            }
        }
        return z;
    }

    /* renamed from: e */
    public Context mo2556e() {
        return this.f829a;
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, (CharSequence) this.f830b.getString(i4));
    }

    /* renamed from: c */
    public void mo2549c(boolean z) {
        this.f854z = z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public C0482g mo2557e(int i) {
        m897a(i, (CharSequence) null, 0, (Drawable) null, (View) null);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo2555d(C0486i iVar) {
        this.f836h = true;
        mo2544b(true);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public C0482g mo2553d(int i) {
        m897a(0, (CharSequence) null, i, (Drawable) null, (View) null);
        return this;
    }

    /* renamed from: a */
    public void mo2520a(Bundle bundle) {
        MenuItem findItem;
        if (bundle != null) {
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(mo2554d());
            int size = size();
            for (int i = 0; i < size; i++) {
                MenuItem item = getItem(i);
                View actionView = item.getActionView();
                if (!(actionView == null || actionView.getId() == -1)) {
                    actionView.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((C0506r) item.getSubMenu()).mo2520a(bundle);
                }
            }
            int i2 = bundle.getInt("android:menu:expandedactionview");
            if (i2 > 0 && (findItem = findItem(i2)) != null) {
                findItem.expandActionView();
            }
        }
    }

    /* renamed from: b */
    public int mo2540b(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f834f.get(i2).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: b */
    public void mo2544b(boolean z) {
        if (!this.f845q) {
            if (z) {
                this.f836h = true;
                this.f839k = true;
            }
            m900d(z);
            return;
        }
        this.f846r = true;
        if (z) {
            this.f847s = true;
        }
    }

    /* renamed from: a */
    public void mo2522a(C0483a aVar) {
        this.f833e = aVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public MenuItem mo2514a(int i, int i2, int i3, CharSequence charSequence) {
        int f = m902f(i3);
        C0486i a = m896a(i, i2, i3, f, charSequence, this.f840l);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.f841m;
        if (contextMenuInfo != null) {
            a.mo2592a(contextMenuInfo);
        }
        ArrayList<C0486i> arrayList = this.f834f;
        arrayList.add(m895a(arrayList, f), a);
        mo2544b(true);
        return a;
    }

    /* renamed from: b */
    public void mo2541b() {
        ArrayList<C0486i> n = mo2570n();
        if (this.f839k) {
            Iterator<WeakReference<C0497m>> it = this.f851w.iterator();
            boolean z = false;
            while (it.hasNext()) {
                WeakReference next = it.next();
                C0497m mVar = (C0497m) next.get();
                if (mVar == null) {
                    this.f851w.remove(next);
                } else {
                    z |= mVar.mo2479b();
                }
            }
            if (z) {
                this.f837i.clear();
                this.f838j.clear();
                int size = n.size();
                for (int i = 0; i < size; i++) {
                    C0486i iVar = n.get(i);
                    if (iVar.mo2604g()) {
                        this.f837i.add(iVar);
                    } else {
                        this.f838j.add(iVar);
                    }
                }
            } else {
                this.f837i.clear();
                this.f838j.clear();
                this.f838j.addAll(mo2570n());
            }
            this.f839k = false;
        }
    }

    /* renamed from: a */
    private C0486i m896a(int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        return new C0486i(this, i, i2, i3, i4, charSequence, i5);
    }

    /* renamed from: a */
    private void m898a(int i, boolean z) {
        if (i >= 0 && i < this.f834f.size()) {
            this.f834f.remove(i);
            if (z) {
                mo2544b(true);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2521a(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f834f.size();
        mo2579s();
        for (int i = 0; i < size; i++) {
            C0486i iVar = this.f834f.get(i);
            if (iVar.getGroupId() == groupId && iVar.mo2617h() && iVar.isCheckable()) {
                iVar.mo2596b(iVar == menuItem);
            }
        }
        mo2576r();
    }

    /* renamed from: b */
    public boolean mo2545b(C0486i iVar) {
        boolean z = false;
        if (this.f851w.isEmpty()) {
            return false;
        }
        mo2579s();
        Iterator<WeakReference<C0497m>> it = this.f851w.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            C0497m mVar = (C0497m) next.get();
            if (mVar == null) {
                this.f851w.remove(next);
            } else {
                z = mVar.mo2466b(this, iVar);
                if (z) {
                    break;
                }
            }
        }
        mo2576r();
        if (z) {
            this.f852x = iVar;
        }
        return z;
    }

    /* renamed from: a */
    public int mo2512a(int i) {
        return mo2513a(i, 0);
    }

    /* renamed from: a */
    public int mo2513a(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        while (i2 < size) {
            if (this.f834f.get(i2).getGroupId() == i) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo2529a(C0482g gVar, MenuItem menuItem) {
        C0483a aVar = this.f833e;
        return aVar != null && aVar.mo2055a(gVar, menuItem);
    }

    /* renamed from: a */
    public void mo2519a() {
        C0483a aVar = this.f833e;
        if (aVar != null) {
            aVar.mo2052a(this);
        }
    }

    /* renamed from: a */
    private static int m895a(ArrayList<C0486i> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).mo2595b() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2525a(List<C0486i> list, int i, KeyEvent keyEvent) {
        boolean p = mo2572p();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.f834f.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0486i iVar = this.f834f.get(i2);
                if (iVar.hasSubMenu()) {
                    ((C0482g) iVar.getSubMenu()).mo2525a(list, i, keyEvent);
                }
                char alphabeticShortcut = p ? iVar.getAlphabeticShortcut() : iVar.getNumericShortcut();
                if (((modifiers & 69647) == ((p ? iVar.getAlphabeticModifiers() : iVar.getNumericModifiers()) & 69647)) && alphabeticShortcut != 0) {
                    char[] cArr = keyData.meta;
                    if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (p && alphabeticShortcut == 8 && i == 67)) && iVar.isEnabled()) {
                        list.add(iVar);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0486i mo2518a(int i, KeyEvent keyEvent) {
        char c;
        ArrayList<C0486i> arrayList = this.f850v;
        arrayList.clear();
        mo2525a((List<C0486i>) arrayList, i, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean p = mo2572p();
        for (int i2 = 0; i2 < size; i2++) {
            C0486i iVar = arrayList.get(i2);
            if (p) {
                c = iVar.getAlphabeticShortcut();
            } else {
                c = iVar.getNumericShortcut();
            }
            if ((c == keyData.meta[0] && (metaState & 2) == 0) || ((c == keyData.meta[2] && (metaState & 2) != 0) || (p && c == 8 && i == 67))) {
                return iVar;
            }
        }
        return null;
    }

    /* renamed from: a */
    public boolean mo2527a(MenuItem menuItem, int i) {
        return mo2528a(menuItem, (C0497m) null, i);
    }

    /* renamed from: a */
    public boolean mo2528a(MenuItem menuItem, C0497m mVar, int i) {
        C0486i iVar = (C0486i) menuItem;
        if (iVar == null || !iVar.isEnabled()) {
            return false;
        }
        boolean f = iVar.mo2603f();
        C0800b a = iVar.mo2396a();
        boolean z = a != null && a.mo2702a();
        if (iVar.mo2601e()) {
            f |= iVar.expandActionView();
            if (f) {
                mo2526a(true);
            }
        } else if (iVar.hasSubMenu() || z) {
            if ((i & 4) == 0) {
                mo2526a(false);
            }
            if (!iVar.hasSubMenu()) {
                iVar.mo2593a(new C0506r(mo2556e(), this, iVar));
            }
            C0506r rVar = (C0506r) iVar.getSubMenu();
            if (z) {
                a.mo2701a((SubMenu) rVar);
            }
            f |= m899a(rVar, mVar);
            if (!f) {
                mo2526a(true);
            }
        } else if ((i & 1) == 0) {
            mo2526a(true);
        }
        return f;
    }

    /* renamed from: a */
    public final void mo2526a(boolean z) {
        if (!this.f849u) {
            this.f849u = true;
            Iterator<WeakReference<C0497m>> it = this.f851w.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                C0497m mVar = (C0497m) next.get();
                if (mVar == null) {
                    this.f851w.remove(next);
                } else {
                    mVar.mo2457a(this, z);
                }
            }
            this.f849u = false;
        }
    }

    /* renamed from: a */
    private void m897a(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources l = mo2568l();
        if (view != null) {
            this.f844p = view;
            this.f842n = null;
            this.f843o = null;
        } else {
            if (i > 0) {
                this.f842n = l.getText(i);
            } else if (charSequence != null) {
                this.f842n = charSequence;
            }
            if (i2 > 0) {
                this.f843o = C0768a.m2411c(mo2556e(), i2);
            } else if (drawable != null) {
                this.f843o = drawable;
            }
            this.f844p = null;
        }
        mo2544b(false);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0482g mo2517a(CharSequence charSequence) {
        m897a(0, charSequence, 0, (Drawable) null, (View) null);
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0482g mo2515a(Drawable drawable) {
        m897a(0, (CharSequence) null, 0, drawable, (View) null);
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0482g mo2516a(View view) {
        m897a(0, (CharSequence) null, 0, (Drawable) null, view);
        return this;
    }

    /* renamed from: a */
    public boolean mo2530a(C0486i iVar) {
        boolean z = false;
        if (!this.f851w.isEmpty() && this.f852x == iVar) {
            mo2579s();
            Iterator<WeakReference<C0497m>> it = this.f851w.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                C0497m mVar = (C0497m) next.get();
                if (mVar == null) {
                    this.f851w.remove(next);
                } else {
                    z = mVar.mo2463a(this, iVar);
                    if (z) {
                        break;
                    }
                }
            }
            mo2576r();
            if (z) {
                this.f852x = null;
            }
        }
        return z;
    }
}
