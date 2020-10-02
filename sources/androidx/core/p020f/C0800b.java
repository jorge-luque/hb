package androidx.core.p020f;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: androidx.core.f.b */
/* compiled from: ActionProvider */
public abstract class C0800b {

    /* renamed from: a */
    private C0801a f2007a;

    /* renamed from: b */
    private C0802b f2008b;

    /* renamed from: androidx.core.f.b$a */
    /* compiled from: ActionProvider */
    public interface C0801a {
        /* renamed from: b */
        void mo3368b(boolean z);
    }

    /* renamed from: androidx.core.f.b$b */
    /* compiled from: ActionProvider */
    public interface C0802b {
        void onActionProviderVisibilityChanged(boolean z);
    }

    public C0800b(Context context) {
    }

    /* renamed from: a */
    public View mo2705a(MenuItem menuItem) {
        return mo2703c();
    }

    /* renamed from: a */
    public void mo2701a(SubMenu subMenu) {
    }

    /* renamed from: a */
    public boolean mo2702a() {
        return false;
    }

    /* renamed from: b */
    public boolean mo2707b() {
        return true;
    }

    /* renamed from: c */
    public abstract View mo2703c();

    /* renamed from: d */
    public boolean mo2704d() {
        return false;
    }

    /* renamed from: e */
    public boolean mo2708e() {
        return false;
    }

    /* renamed from: f */
    public void mo4098f() {
        this.f2008b = null;
        this.f2007a = null;
    }

    /* renamed from: a */
    public void mo4097a(boolean z) {
        C0801a aVar = this.f2007a;
        if (aVar != null) {
            aVar.mo3368b(z);
        }
    }

    /* renamed from: a */
    public void mo4096a(C0801a aVar) {
        this.f2007a = aVar;
    }

    /* renamed from: a */
    public void mo2706a(C0802b bVar) {
        if (!(this.f2008b == null || bVar == null)) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f2008b = bVar;
    }
}
