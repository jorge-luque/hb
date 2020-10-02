package androidx.core.p020f;

import android.view.View;
import android.view.ViewParent;

/* renamed from: androidx.core.f.l */
/* compiled from: NestedScrollingChildHelper */
public class C0831l {

    /* renamed from: a */
    private ViewParent f2036a;

    /* renamed from: b */
    private ViewParent f2037b;

    /* renamed from: c */
    private final View f2038c;

    /* renamed from: d */
    private boolean f2039d;

    /* renamed from: e */
    private int[] f2040e;

    public C0831l(View view) {
        this.f2038c = view;
    }

    /* renamed from: d */
    private ViewParent m2649d(int i) {
        if (i == 0) {
            return this.f2036a;
        }
        if (i != 1) {
            return null;
        }
        return this.f2037b;
    }

    /* renamed from: a */
    public void mo4176a(boolean z) {
        if (this.f2039d) {
            C0839t.m2684C(this.f2038c);
        }
        this.f2039d = z;
    }

    /* renamed from: b */
    public boolean mo4185b() {
        return this.f2039d;
    }

    /* renamed from: c */
    public void mo4187c() {
        mo4188c(0);
    }

    /* renamed from: b */
    public boolean mo4186b(int i) {
        return mo4181a(i, 0);
    }

    /* renamed from: c */
    public void mo4188c(int i) {
        ViewParent d = m2649d(i);
        if (d != null) {
            C0850w.m2764a(d, this.f2038c, i);
            m2647a(i, (ViewParent) null);
        }
    }

    /* renamed from: b */
    private boolean m2648b(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        ViewParent d;
        int i6;
        int i7;
        int[] iArr3;
        int[] iArr4 = iArr;
        if (!mo4185b() || (d = m2649d(i5)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            if (iArr4 != null) {
                iArr4[0] = 0;
                iArr4[1] = 0;
            }
            return false;
        }
        if (iArr4 != null) {
            this.f2038c.getLocationInWindow(iArr4);
            i7 = iArr4[0];
            i6 = iArr4[1];
        } else {
            i7 = 0;
            i6 = 0;
        }
        if (iArr2 == null) {
            int[] d2 = m2650d();
            d2[0] = 0;
            d2[1] = 0;
            iArr3 = d2;
        } else {
            iArr3 = iArr2;
        }
        C0850w.m2765a(d, this.f2038c, i, i2, i3, i4, i5, iArr3);
        if (iArr4 != null) {
            this.f2038c.getLocationInWindow(iArr4);
            iArr4[0] = iArr4[0] - i7;
            iArr4[1] = iArr4[1] - i6;
        }
        return true;
    }

    /* renamed from: d */
    private int[] m2650d() {
        if (this.f2040e == null) {
            this.f2040e = new int[2];
        }
        return this.f2040e;
    }

    /* renamed from: a */
    public boolean mo4177a() {
        return mo4180a(0);
    }

    /* renamed from: a */
    public boolean mo4180a(int i) {
        return m2649d(i) != null;
    }

    /* renamed from: a */
    public boolean mo4181a(int i, int i2) {
        if (mo4180a(i2)) {
            return true;
        }
        if (!mo4185b()) {
            return false;
        }
        View view = this.f2038c;
        for (ViewParent parent = this.f2038c.getParent(); parent != null; parent = parent.getParent()) {
            if (C0850w.m2770b(parent, view, this.f2038c, i, i2)) {
                m2647a(i2, parent);
                C0850w.m2767a(parent, view, this.f2038c, i, i2);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo4182a(int i, int i2, int i3, int i4, int[] iArr) {
        return m2648b(i, i2, i3, i4, iArr, 0, (int[]) null);
    }

    /* renamed from: a */
    public void mo4175a(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        m2648b(i, i2, i3, i4, iArr, i5, iArr2);
    }

    /* renamed from: a */
    public boolean mo4183a(int i, int i2, int[] iArr, int[] iArr2) {
        return mo4184a(i, i2, iArr, iArr2, 0);
    }

    /* renamed from: a */
    public boolean mo4184a(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        ViewParent d;
        int i4;
        int i5;
        if (!mo4185b() || (d = m2649d(i3)) == null) {
            return false;
        }
        if (i != 0 || i2 != 0) {
            if (iArr2 != null) {
                this.f2038c.getLocationInWindow(iArr2);
                i5 = iArr2[0];
                i4 = iArr2[1];
            } else {
                i5 = 0;
                i4 = 0;
            }
            if (iArr == null) {
                iArr = m2650d();
            }
            iArr[0] = 0;
            iArr[1] = 0;
            C0850w.m2766a(d, this.f2038c, i, i2, iArr, i3);
            if (iArr2 != null) {
                this.f2038c.getLocationInWindow(iArr2);
                iArr2[0] = iArr2[0] - i5;
                iArr2[1] = iArr2[1] - i4;
            }
            if (iArr[0] == 0 && iArr[1] == 0) {
                return false;
            }
            return true;
        } else if (iArr2 == null) {
            return false;
        } else {
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
    }

    /* renamed from: a */
    public boolean mo4179a(float f, float f2, boolean z) {
        ViewParent d;
        if (!mo4185b() || (d = m2649d(0)) == null) {
            return false;
        }
        return C0850w.m2769a(d, this.f2038c, f, f2, z);
    }

    /* renamed from: a */
    public boolean mo4178a(float f, float f2) {
        ViewParent d;
        if (!mo4185b() || (d = m2649d(0)) == null) {
            return false;
        }
        return C0850w.m2768a(d, this.f2038c, f, f2);
    }

    /* renamed from: a */
    private void m2647a(int i, ViewParent viewParent) {
        if (i == 0) {
            this.f2036a = viewParent;
        } else if (i == 1) {
            this.f2037b = viewParent;
        }
    }
}
