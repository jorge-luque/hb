package androidx.core.p020f;

import android.os.Build;
import android.view.WindowInsets;
import androidx.core.p019e.C0790c;

/* renamed from: androidx.core.f.b0 */
/* compiled from: WindowInsetsCompat */
public class C0803b0 {

    /* renamed from: a */
    private final Object f2009a;

    C0803b0(Object obj) {
        this.f2009a = obj;
    }

    /* renamed from: a */
    public int mo4099a() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f2009a).getSystemWindowInsetBottom();
        }
        return 0;
    }

    /* renamed from: b */
    public int mo4101b() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f2009a).getSystemWindowInsetLeft();
        }
        return 0;
    }

    /* renamed from: c */
    public int mo4102c() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f2009a).getSystemWindowInsetRight();
        }
        return 0;
    }

    /* renamed from: d */
    public int mo4103d() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f2009a).getSystemWindowInsetTop();
        }
        return 0;
    }

    /* renamed from: e */
    public boolean mo4104e() {
        if (Build.VERSION.SDK_INT >= 21) {
            return ((WindowInsets) this.f2009a).isConsumed();
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0803b0)) {
            return false;
        }
        return C0790c.m2494a(this.f2009a, ((C0803b0) obj).f2009a);
    }

    /* renamed from: f */
    public WindowInsets mo4106f() {
        return (WindowInsets) this.f2009a;
    }

    public int hashCode() {
        Object obj = this.f2009a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    /* renamed from: a */
    public C0803b0 mo4100a(int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 20) {
            return new C0803b0(((WindowInsets) this.f2009a).replaceSystemWindowInsets(i, i2, i3, i4));
        }
        return null;
    }

    /* renamed from: a */
    public static C0803b0 m2537a(WindowInsets windowInsets) {
        windowInsets.getClass();
        return new C0803b0(windowInsets);
    }
}
