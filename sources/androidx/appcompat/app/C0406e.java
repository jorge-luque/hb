package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import p075d.p080b.C3193b;

/* renamed from: androidx.appcompat.app.e */
/* compiled from: AppCompatDelegate */
public abstract class C0406e {

    /* renamed from: a */
    private static int f412a = -100;

    /* renamed from: b */
    private static final C3193b<WeakReference<C0406e>> f413b = new C3193b<>();

    /* renamed from: c */
    private static final Object f414c = new Object();

    C0406e() {
    }

    /* renamed from: a */
    public static C0406e m422a(Activity activity, C0405d dVar) {
        return new C0407f(activity, dVar);
    }

    /* renamed from: b */
    static void m425b(C0406e eVar) {
        synchronized (f414c) {
            m426c(eVar);
        }
    }

    /* renamed from: c */
    private static void m426c(C0406e eVar) {
        synchronized (f414c) {
            Iterator<WeakReference<C0406e>> it = f413b.iterator();
            while (it.hasNext()) {
                C0406e eVar2 = (C0406e) it.next().get();
                if (eVar2 == eVar || eVar2 == null) {
                    it.remove();
                }
            }
        }
    }

    /* renamed from: j */
    public static int m427j() {
        return f412a;
    }

    /* renamed from: a */
    public int mo2023a() {
        return -100;
    }

    /* renamed from: a */
    public abstract <T extends View> T mo2024a(int i);

    /* renamed from: a */
    public void mo2025a(Context context) {
    }

    /* renamed from: a */
    public abstract void mo2026a(Configuration configuration);

    /* renamed from: a */
    public abstract void mo2027a(Bundle bundle);

    /* renamed from: a */
    public abstract void mo2028a(View view);

    /* renamed from: a */
    public abstract void mo2029a(View view, ViewGroup.LayoutParams layoutParams);

    /* renamed from: a */
    public abstract void mo2030a(CharSequence charSequence);

    /* renamed from: b */
    public abstract MenuInflater mo2031b();

    /* renamed from: b */
    public abstract void mo2032b(Bundle bundle);

    /* renamed from: b */
    public abstract void mo2033b(View view, ViewGroup.LayoutParams layoutParams);

    /* renamed from: b */
    public abstract boolean mo2034b(int i);

    /* renamed from: c */
    public abstract C0399a mo2035c();

    /* renamed from: c */
    public abstract void mo2036c(int i);

    /* renamed from: c */
    public abstract void mo2037c(Bundle bundle);

    /* renamed from: d */
    public abstract void mo2038d();

    /* renamed from: d */
    public void mo2039d(int i) {
    }

    /* renamed from: e */
    public abstract void mo2040e();

    /* renamed from: f */
    public abstract void mo2041f();

    /* renamed from: g */
    public abstract void mo2042g();

    /* renamed from: h */
    public abstract void mo2043h();

    /* renamed from: i */
    public abstract void mo2044i();

    /* renamed from: a */
    public static C0406e m423a(Dialog dialog, C0405d dVar) {
        return new C0407f(dialog, dVar);
    }

    /* renamed from: a */
    static void m424a(C0406e eVar) {
        synchronized (f414c) {
            m426c(eVar);
            f413b.add(new WeakReference(eVar));
        }
    }
}
