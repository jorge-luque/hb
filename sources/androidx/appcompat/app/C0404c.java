package androidx.appcompat.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.p011d.C0455b;
import androidx.appcompat.widget.C0612l0;
import androidx.core.app.C0696a;
import androidx.core.app.C0723g;
import androidx.core.app.C0746o;
import androidx.fragment.app.C0911c;

/* renamed from: androidx.appcompat.app.c */
/* compiled from: AppCompatActivity */
public class C0404c extends C0911c implements C0405d, C0746o.C0747a {

    /* renamed from: a */
    private C0406e f410a;

    /* renamed from: b */
    private Resources f411b;

    /* renamed from: a */
    public C0455b mo1985a(C0455b.C0456a aVar) {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo1986a(int i) {
    }

    /* renamed from: a */
    public void mo1988a(C0455b bVar) {
    }

    /* renamed from: a */
    public void mo1989a(C0746o oVar) {
        oVar.mo3978a((Activity) this);
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        mo1992b().mo2029a(view, layoutParams);
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        mo1992b().mo2025a(context);
    }

    /* renamed from: b */
    public void mo1993b(C0455b bVar) {
    }

    /* renamed from: b */
    public void mo1994b(C0746o oVar) {
    }

    /* renamed from: b */
    public boolean mo1995b(Intent intent) {
        return C0723g.m2239b((Activity) this, intent);
    }

    /* renamed from: c */
    public C0399a mo1996c() {
        return mo1992b().mo2035c();
    }

    public void closeOptionsMenu() {
        C0399a c = mo1996c();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (c == null || !c.mo1963e()) {
            super.closeOptionsMenu();
        }
    }

    @Deprecated
    /* renamed from: d */
    public void mo1998d() {
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        C0399a c = mo1996c();
        if (keyCode != 82 || c == null || !c.mo1959a(keyEvent)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    /* renamed from: e */
    public boolean mo2000e() {
        Intent a = mo1984a();
        if (a == null) {
            return false;
        }
        if (mo1995b(a)) {
            C0746o a2 = C0746o.m2348a((Context) this);
            mo1989a(a2);
            mo1994b(a2);
            a2.mo3981a();
            try {
                C0696a.m2190a(this);
                return true;
            } catch (IllegalStateException unused) {
                finish();
                return true;
            }
        } else {
            mo1987a(a);
            return true;
        }
    }

    public <T extends View> T findViewById(int i) {
        return mo1992b().mo2024a(i);
    }

    public MenuInflater getMenuInflater() {
        return mo1992b().mo2031b();
    }

    public Resources getResources() {
        if (this.f411b == null && C0612l0.m1707b()) {
            this.f411b = new C0612l0(this, super.getResources());
        }
        Resources resources = this.f411b;
        return resources == null ? super.getResources() : resources;
    }

    public void invalidateOptionsMenu() {
        mo1992b().mo2040e();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f411b != null) {
            this.f411b.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
        mo1992b().mo2026a(configuration);
    }

    public void onContentChanged() {
        mo1998d();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        C0406e b = mo1992b();
        b.mo2038d();
        b.mo2027a(bundle);
        super.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        mo1992b().mo2041f();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (m405a(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        C0399a c = mo1996c();
        if (menuItem.getItemId() != 16908332 || c == null || (c.mo1965g() & 4) == 0) {
            return false;
        }
        return mo2000e();
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    /* access modifiers changed from: protected */
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        mo1992b().mo2032b(bundle);
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        mo1992b().mo2042g();
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        mo1992b().mo2037c(bundle);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        mo1992b().mo2043h();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        mo1992b().mo2044i();
    }

    /* access modifiers changed from: protected */
    public void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        mo1992b().mo2030a(charSequence);
    }

    public void openOptionsMenu() {
        C0399a c = mo1996c();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (c == null || !c.mo1969k()) {
            super.openOptionsMenu();
        }
    }

    public void setContentView(int i) {
        mo1992b().mo2036c(i);
    }

    public void setTheme(int i) {
        super.setTheme(i);
        mo1992b().mo2039d(i);
    }

    public void supportInvalidateOptionsMenu() {
        mo1992b().mo2040e();
    }

    /* renamed from: a */
    public Intent mo1984a() {
        return C0723g.m2234a(this);
    }

    /* renamed from: b */
    public C0406e mo1992b() {
        if (this.f410a == null) {
            this.f410a = C0406e.m422a((Activity) this, (C0405d) this);
        }
        return this.f410a;
    }

    public void setContentView(View view) {
        mo1992b().mo2028a(view);
    }

    /* renamed from: a */
    public void mo1987a(Intent intent) {
        C0723g.m2236a((Activity) this, intent);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        mo1992b().mo2033b(view, layoutParams);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        r2 = getWindow();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m405a(int r2, android.view.KeyEvent r3) {
        /*
            r1 = this;
            int r2 = android.os.Build.VERSION.SDK_INT
            r0 = 26
            if (r2 >= r0) goto L_0x003e
            boolean r2 = r3.isCtrlPressed()
            if (r2 != 0) goto L_0x003e
            int r2 = r3.getMetaState()
            boolean r2 = android.view.KeyEvent.metaStateHasNoModifiers(r2)
            if (r2 != 0) goto L_0x003e
            int r2 = r3.getRepeatCount()
            if (r2 != 0) goto L_0x003e
            int r2 = r3.getKeyCode()
            boolean r2 = android.view.KeyEvent.isModifierKey(r2)
            if (r2 != 0) goto L_0x003e
            android.view.Window r2 = r1.getWindow()
            if (r2 == 0) goto L_0x003e
            android.view.View r0 = r2.getDecorView()
            if (r0 == 0) goto L_0x003e
            android.view.View r2 = r2.getDecorView()
            boolean r2 = r2.dispatchKeyShortcutEvent(r3)
            if (r2 == 0) goto L_0x003e
            r2 = 1
            return r2
        L_0x003e:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.C0404c.m405a(int, android.view.KeyEvent):boolean");
    }
}
