package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* renamed from: androidx.appcompat.widget.d0 */
/* compiled from: TintContextWrapper */
public class C0591d0 extends ContextWrapper {

    /* renamed from: c */
    private static final Object f1413c = new Object();

    /* renamed from: d */
    private static ArrayList<WeakReference<C0591d0>> f1414d;

    /* renamed from: a */
    private final Resources f1415a;

    /* renamed from: b */
    private final Resources.Theme f1416b;

    private C0591d0(Context context) {
        super(context);
        if (C0612l0.m1707b()) {
            C0612l0 l0Var = new C0612l0(this, context.getResources());
            this.f1415a = l0Var;
            Resources.Theme newTheme = l0Var.newTheme();
            this.f1416b = newTheme;
            newTheme.setTo(context.getTheme());
            return;
        }
        this.f1415a = new C0595f0(this, context.getResources());
        this.f1416b = null;
    }

    /* renamed from: a */
    private static boolean m1567a(Context context) {
        if ((context instanceof C0591d0) || (context.getResources() instanceof C0595f0) || (context.getResources() instanceof C0612l0)) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 21 || C0612l0.m1707b()) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public static Context m1568b(Context context) {
        if (!m1567a(context)) {
            return context;
        }
        synchronized (f1413c) {
            if (f1414d == null) {
                f1414d = new ArrayList<>();
            } else {
                for (int size = f1414d.size() - 1; size >= 0; size--) {
                    WeakReference weakReference = f1414d.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        f1414d.remove(size);
                    }
                }
                for (int size2 = f1414d.size() - 1; size2 >= 0; size2--) {
                    WeakReference weakReference2 = f1414d.get(size2);
                    C0591d0 d0Var = weakReference2 != null ? (C0591d0) weakReference2.get() : null;
                    if (d0Var != null && d0Var.getBaseContext() == context) {
                        return d0Var;
                    }
                }
            }
            C0591d0 d0Var2 = new C0591d0(context);
            f1414d.add(new WeakReference(d0Var2));
            return d0Var2;
        }
    }

    public AssetManager getAssets() {
        return this.f1415a.getAssets();
    }

    public Resources getResources() {
        return this.f1415a;
    }

    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f1416b;
        return theme == null ? super.getTheme() : theme;
    }

    public void setTheme(int i) {
        Resources.Theme theme = this.f1416b;
        if (theme == null) {
            super.setTheme(i);
        } else {
            theme.applyStyle(i, true);
        }
    }
}
