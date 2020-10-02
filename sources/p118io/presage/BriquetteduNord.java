package p118io.presage;

import android.graphics.Rect;

/* renamed from: io.presage.BriquetteduNord */
public final class BriquetteduNord {

    /* renamed from: a */
    public static final CamembertauCalvados f16400a = new CamembertauCalvados((byte) 0);

    /* renamed from: b */
    private final Rect f16401b;

    /* renamed from: c */
    private final Rect f16402c;

    /* renamed from: d */
    private final float f16403d;

    /* renamed from: io.presage.BriquetteduNord$CamembertauCalvados */
    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        public /* synthetic */ CamembertauCalvados(byte b) {
            this();
        }
    }

    public BriquetteduNord(Rect rect, Rect rect2, float f) {
        this.f16401b = rect;
        this.f16402c = rect2;
        this.f16403d = f;
    }

    /* renamed from: d */
    private final boolean m20248d() {
        Rect rect = this.f16401b;
        int i = rect.left;
        int i2 = this.f16402c.left;
        if (i < i2) {
            rect.right += i2 - i;
            rect.left = i2;
        }
        return m20252h();
    }

    /* renamed from: e */
    private final boolean m20249e() {
        Rect rect = this.f16401b;
        int i = rect.top;
        int i2 = this.f16402c.top;
        if (i < i2) {
            rect.bottom += i2 - i;
            rect.top = i2;
        }
        return m20252h();
    }

    /* renamed from: f */
    private final boolean m20250f() {
        Rect rect = this.f16401b;
        int i = rect.right;
        int i2 = this.f16402c.right;
        if (i > i2) {
            int i3 = i - i2;
            rect.left -= i3;
            rect.right = i - i3;
        }
        return m20252h();
    }

    /* renamed from: g */
    private final boolean m20251g() {
        Rect rect = this.f16401b;
        int i = rect.bottom;
        int i2 = this.f16402c.bottom;
        if (i > i2) {
            int i3 = i - i2;
            rect.top -= i3;
            rect.bottom = i - i3;
        }
        return m20252h();
    }

    /* renamed from: h */
    private final boolean m20252h() {
        return mo34465c() >= this.f16403d;
    }

    /* renamed from: i */
    private final void m20253i() {
        if (this.f16401b.width() > this.f16402c.width()) {
            int a = m20245a((float) this.f16401b.width(), (float) this.f16402c.width());
            Rect rect = this.f16401b;
            int i = rect.right;
            int a2 = i - m20246a(i, a);
            Rect rect2 = this.f16401b;
            rect.right = a2 - rect2.left;
            int i2 = rect2.bottom;
            rect2.bottom = i2 - m20246a(i2, a);
            this.f16401b.left = this.f16402c.left;
        }
    }

    /* renamed from: j */
    private final void m20254j() {
        if (this.f16401b.height() > this.f16402c.height()) {
            int a = m20245a((float) this.f16401b.height(), (float) this.f16402c.height());
            Rect rect = this.f16401b;
            int i = rect.bottom;
            int a2 = i - m20246a(i, a);
            Rect rect2 = this.f16401b;
            rect.bottom = a2 - rect2.top;
            int i2 = rect2.right;
            rect2.right = i2 - m20246a(i2, a);
            this.f16401b.top = this.f16402c.top;
        }
    }

    /* renamed from: a */
    public final boolean mo34463a() {
        return m20248d() || m20249e() || m20250f() || m20251g();
    }

    /* renamed from: b */
    public final void mo34464b() {
        m20253i();
        m20254j();
    }

    /* renamed from: c */
    public final float mo34465c() {
        Rect a = m20247a(this.f16401b, this.f16402c);
        if (a == null) {
            return 0.0f;
        }
        return ((float) (a.width() * a.height())) / ((float) (this.f16401b.width() * this.f16401b.height()));
    }

    /* renamed from: a */
    private static int m20245a(float f, float f2) {
        return C6526hx.m21433a(((f - f2) / f) * 100.0f);
    }

    /* renamed from: a */
    private static int m20246a(int i, int i2) {
        return (i * i2) / 100;
    }

    /* renamed from: a */
    private static Rect m20247a(Rect rect, Rect rect2) {
        Rect rect3 = new Rect(rect);
        if (!rect3.intersect(rect2)) {
            return null;
        }
        return rect3;
    }
}
