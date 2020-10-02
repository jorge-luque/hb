package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.core.p014b.p015a.C0748a;

/* renamed from: androidx.appcompat.view.menu.o */
/* compiled from: MenuWrapperICS */
public class C0501o extends C0472c implements Menu {

    /* renamed from: d */
    private final C0748a f915d;

    public C0501o(Context context, C0748a aVar) {
        super(context);
        if (aVar != null) {
            this.f915d = aVar;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public MenuItem add(CharSequence charSequence) {
        return mo2467a(this.f915d.add(charSequence));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr;
        MenuItem[] menuItemArr3 = menuItemArr2 != null ? new MenuItem[menuItemArr2.length] : null;
        int addIntentOptions = this.f915d.addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr3);
        if (menuItemArr3 != null) {
            int length = menuItemArr3.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr2[i5] = mo2467a(menuItemArr3[i5]);
            }
        }
        return addIntentOptions;
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return mo2468a(this.f915d.addSubMenu(charSequence));
    }

    public void clear() {
        mo2470b();
        this.f915d.clear();
    }

    public void close() {
        this.f915d.close();
    }

    public MenuItem findItem(int i) {
        return mo2467a(this.f915d.findItem(i));
    }

    public MenuItem getItem(int i) {
        return mo2467a(this.f915d.getItem(i));
    }

    public boolean hasVisibleItems() {
        return this.f915d.hasVisibleItems();
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return this.f915d.isShortcutKey(i, keyEvent);
    }

    public boolean performIdentifierAction(int i, int i2) {
        return this.f915d.performIdentifierAction(i, i2);
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return this.f915d.performShortcut(i, keyEvent, i2);
    }

    public void removeGroup(int i) {
        mo2469a(i);
        this.f915d.removeGroup(i);
    }

    public void removeItem(int i) {
        mo2471b(i);
        this.f915d.removeItem(i);
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        this.f915d.setGroupCheckable(i, z, z2);
    }

    public void setGroupEnabled(int i, boolean z) {
        this.f915d.setGroupEnabled(i, z);
    }

    public void setGroupVisible(int i, boolean z) {
        this.f915d.setGroupVisible(i, z);
    }

    public void setQwertyMode(boolean z) {
        this.f915d.setQwertyMode(z);
    }

    public int size() {
        return this.f915d.size();
    }

    public MenuItem add(int i) {
        return mo2467a(this.f915d.add(i));
    }

    public SubMenu addSubMenu(int i) {
        return mo2468a(this.f915d.addSubMenu(i));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return mo2467a(this.f915d.add(i, i2, i3, charSequence));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return mo2468a(this.f915d.addSubMenu(i, i2, i3, charSequence));
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return mo2467a(this.f915d.add(i, i2, i3, i4));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return mo2468a(this.f915d.addSubMenu(i, i2, i3, i4));
    }
}
