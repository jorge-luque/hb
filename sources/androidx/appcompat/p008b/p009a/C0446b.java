package androidx.appcompat.p008b.p009a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;
import androidx.core.graphics.drawable.C0857a;

/* renamed from: androidx.appcompat.b.a.b */
/* compiled from: DrawableContainer */
class C0446b extends Drawable implements Drawable.Callback {

    /* renamed from: a */
    private C0449c f588a;

    /* renamed from: b */
    private Rect f589b;

    /* renamed from: c */
    private Drawable f590c;

    /* renamed from: d */
    private Drawable f591d;

    /* renamed from: e */
    private int f592e = 255;

    /* renamed from: f */
    private boolean f593f;

    /* renamed from: g */
    private int f594g = -1;

    /* renamed from: h */
    private boolean f595h;

    /* renamed from: i */
    private Runnable f596i;

    /* renamed from: j */
    private long f597j;

    /* renamed from: k */
    private long f598k;

    /* renamed from: l */
    private C0448b f599l;

    /* renamed from: androidx.appcompat.b.a.b$a */
    /* compiled from: DrawableContainer */
    class C0447a implements Runnable {
        C0447a() {
        }

        public void run() {
            C0446b.this.mo2191a(true);
            C0446b.this.invalidateSelf();
        }
    }

    /* renamed from: androidx.appcompat.b.a.b$b */
    /* compiled from: DrawableContainer */
    static class C0448b implements Drawable.Callback {

        /* renamed from: a */
        private Drawable.Callback f601a;

        C0448b() {
        }

        /* renamed from: a */
        public C0448b mo2226a(Drawable.Callback callback) {
            this.f601a = callback;
            return this;
        }

        public void invalidateDrawable(Drawable drawable) {
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            Drawable.Callback callback = this.f601a;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j);
            }
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Drawable.Callback callback = this.f601a;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }

        /* renamed from: a */
        public Drawable.Callback mo2225a() {
            Drawable.Callback callback = this.f601a;
            this.f601a = null;
            return callback;
        }
    }

    /* renamed from: androidx.appcompat.b.a.b$c */
    /* compiled from: DrawableContainer */
    static abstract class C0449c extends Drawable.ConstantState {

        /* renamed from: A */
        int f602A;

        /* renamed from: B */
        int f603B;

        /* renamed from: C */
        boolean f604C;

        /* renamed from: D */
        ColorFilter f605D;

        /* renamed from: E */
        boolean f606E;

        /* renamed from: F */
        ColorStateList f607F;

        /* renamed from: G */
        PorterDuff.Mode f608G;

        /* renamed from: H */
        boolean f609H;

        /* renamed from: I */
        boolean f610I;

        /* renamed from: a */
        final C0446b f611a;

        /* renamed from: b */
        Resources f612b;

        /* renamed from: c */
        int f613c = 160;

        /* renamed from: d */
        int f614d;

        /* renamed from: e */
        int f615e;

        /* renamed from: f */
        SparseArray<Drawable.ConstantState> f616f;

        /* renamed from: g */
        Drawable[] f617g;

        /* renamed from: h */
        int f618h;

        /* renamed from: i */
        boolean f619i;

        /* renamed from: j */
        boolean f620j;

        /* renamed from: k */
        Rect f621k;

        /* renamed from: l */
        boolean f622l;

        /* renamed from: m */
        boolean f623m;

        /* renamed from: n */
        int f624n;

        /* renamed from: o */
        int f625o;

        /* renamed from: p */
        int f626p;

        /* renamed from: q */
        int f627q;

        /* renamed from: r */
        boolean f628r;

        /* renamed from: s */
        int f629s;

        /* renamed from: t */
        boolean f630t;

        /* renamed from: u */
        boolean f631u;

        /* renamed from: v */
        boolean f632v;

        /* renamed from: w */
        boolean f633w;

        /* renamed from: x */
        boolean f634x;

        /* renamed from: y */
        boolean f635y;

        /* renamed from: z */
        int f636z;

        C0449c(C0449c cVar, C0446b bVar, Resources resources) {
            Resources resources2;
            this.f619i = false;
            this.f622l = false;
            this.f634x = true;
            this.f602A = 0;
            this.f603B = 0;
            this.f611a = bVar;
            if (resources != null) {
                resources2 = resources;
            } else {
                resources2 = cVar != null ? cVar.f612b : null;
            }
            this.f612b = resources2;
            int a = C0446b.m673a(resources, cVar != null ? cVar.f613c : 0);
            this.f613c = a;
            if (cVar != null) {
                this.f614d = cVar.f614d;
                this.f615e = cVar.f615e;
                this.f632v = true;
                this.f633w = true;
                this.f619i = cVar.f619i;
                this.f622l = cVar.f622l;
                this.f634x = cVar.f634x;
                this.f635y = cVar.f635y;
                this.f636z = cVar.f636z;
                this.f602A = cVar.f602A;
                this.f603B = cVar.f603B;
                this.f604C = cVar.f604C;
                this.f605D = cVar.f605D;
                this.f606E = cVar.f606E;
                this.f607F = cVar.f607F;
                this.f608G = cVar.f608G;
                this.f609H = cVar.f609H;
                this.f610I = cVar.f610I;
                if (cVar.f613c == a) {
                    if (cVar.f620j) {
                        this.f621k = new Rect(cVar.f621k);
                        this.f620j = true;
                    }
                    if (cVar.f623m) {
                        this.f624n = cVar.f624n;
                        this.f625o = cVar.f625o;
                        this.f626p = cVar.f626p;
                        this.f627q = cVar.f627q;
                        this.f623m = true;
                    }
                }
                if (cVar.f628r) {
                    this.f629s = cVar.f629s;
                    this.f628r = true;
                }
                if (cVar.f630t) {
                    this.f631u = cVar.f631u;
                    this.f630t = true;
                }
                Drawable[] drawableArr = cVar.f617g;
                this.f617g = new Drawable[drawableArr.length];
                this.f618h = cVar.f618h;
                SparseArray<Drawable.ConstantState> sparseArray = cVar.f616f;
                if (sparseArray != null) {
                    this.f616f = sparseArray.clone();
                } else {
                    this.f616f = new SparseArray<>(this.f618h);
                }
                int i = this.f618h;
                for (int i2 = 0; i2 < i; i2++) {
                    if (drawableArr[i2] != null) {
                        Drawable.ConstantState constantState = drawableArr[i2].getConstantState();
                        if (constantState != null) {
                            this.f616f.put(i2, constantState);
                        } else {
                            this.f617g[i2] = drawableArr[i2];
                        }
                    }
                }
                return;
            }
            this.f617g = new Drawable[10];
            this.f618h = 0;
        }

        /* renamed from: b */
        private Drawable m684b(Drawable drawable) {
            if (Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(this.f636z);
            }
            Drawable mutate = drawable.mutate();
            mutate.setCallback(this.f611a);
            return mutate;
        }

        /* renamed from: n */
        private void m685n() {
            SparseArray<Drawable.ConstantState> sparseArray = this.f616f;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i = 0; i < size; i++) {
                    this.f617g[this.f616f.keyAt(i)] = m684b(this.f616f.valueAt(i).newDrawable(this.f612b));
                }
                this.f616f = null;
            }
        }

        /* renamed from: a */
        public final int mo2230a(Drawable drawable) {
            int i = this.f618h;
            if (i >= this.f617g.length) {
                mo2232a(i, i + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f611a);
            this.f617g[i] = drawable;
            this.f618h++;
            this.f615e = drawable.getChangingConfigurations() | this.f615e;
            mo2252k();
            this.f621k = null;
            this.f620j = false;
            this.f623m = false;
            this.f632v = false;
            return i;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public final int mo2241c() {
            return this.f617g.length;
        }

        public boolean canApplyTheme() {
            int i = this.f618h;
            Drawable[] drawableArr = this.f617g;
            for (int i2 = 0; i2 < i; i2++) {
                Drawable drawable = drawableArr[i2];
                if (drawable == null) {
                    Drawable.ConstantState constantState = this.f616f.get(i2);
                    if (constantState != null && constantState.canApplyTheme()) {
                        return true;
                    }
                } else if (drawable.canApplyTheme()) {
                    return true;
                }
            }
            return false;
        }

        /* renamed from: d */
        public final int mo2244d() {
            return this.f618h;
        }

        /* renamed from: e */
        public final int mo2245e() {
            if (!this.f623m) {
                mo2237b();
            }
            return this.f625o;
        }

        /* renamed from: f */
        public final int mo2246f() {
            if (!this.f623m) {
                mo2237b();
            }
            return this.f627q;
        }

        /* renamed from: g */
        public final int mo2247g() {
            if (!this.f623m) {
                mo2237b();
            }
            return this.f626p;
        }

        public int getChangingConfigurations() {
            return this.f614d | this.f615e;
        }

        /* renamed from: h */
        public final Rect mo2249h() {
            Rect rect = null;
            if (this.f619i) {
                return null;
            }
            if (this.f621k != null || this.f620j) {
                return this.f621k;
            }
            m685n();
            Rect rect2 = new Rect();
            int i = this.f618h;
            Drawable[] drawableArr = this.f617g;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2].getPadding(rect2)) {
                    if (rect == null) {
                        rect = new Rect(0, 0, 0, 0);
                    }
                    int i3 = rect2.left;
                    if (i3 > rect.left) {
                        rect.left = i3;
                    }
                    int i4 = rect2.top;
                    if (i4 > rect.top) {
                        rect.top = i4;
                    }
                    int i5 = rect2.right;
                    if (i5 > rect.right) {
                        rect.right = i5;
                    }
                    int i6 = rect2.bottom;
                    if (i6 > rect.bottom) {
                        rect.bottom = i6;
                    }
                }
            }
            this.f620j = true;
            this.f621k = rect;
            return rect;
        }

        /* renamed from: i */
        public final int mo2250i() {
            if (!this.f623m) {
                mo2237b();
            }
            return this.f624n;
        }

        /* renamed from: j */
        public final int mo2251j() {
            if (this.f628r) {
                return this.f629s;
            }
            m685n();
            int i = this.f618h;
            Drawable[] drawableArr = this.f617g;
            int opacity = i > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i2 = 1; i2 < i; i2++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i2].getOpacity());
            }
            this.f629s = opacity;
            this.f628r = true;
            return opacity;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: k */
        public void mo2252k() {
            this.f628r = false;
            this.f630t = false;
        }

        /* renamed from: l */
        public final boolean mo2253l() {
            return this.f622l;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: m */
        public abstract void mo2182m();

        /* renamed from: c */
        public final void mo2242c(int i) {
            this.f603B = i;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public final boolean mo2240b(int i, int i2) {
            int i3 = this.f618h;
            Drawable[] drawableArr = this.f617g;
            boolean z = false;
            for (int i4 = 0; i4 < i3; i4++) {
                if (drawableArr[i4] != null) {
                    boolean layoutDirection = Build.VERSION.SDK_INT >= 23 ? drawableArr[i4].setLayoutDirection(i) : false;
                    if (i4 == i2) {
                        z = layoutDirection;
                    }
                }
            }
            this.f636z = i;
            return z;
        }

        /* renamed from: b */
        public final void mo2239b(boolean z) {
            this.f619i = z;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void mo2237b() {
            this.f623m = true;
            m685n();
            int i = this.f618h;
            Drawable[] drawableArr = this.f617g;
            this.f625o = -1;
            this.f624n = -1;
            this.f627q = 0;
            this.f626p = 0;
            for (int i2 = 0; i2 < i; i2++) {
                Drawable drawable = drawableArr[i2];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.f624n) {
                    this.f624n = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.f625o) {
                    this.f625o = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.f626p) {
                    this.f626p = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.f627q) {
                    this.f627q = minimumHeight;
                }
            }
        }

        /* renamed from: a */
        public final Drawable mo2231a(int i) {
            int indexOfKey;
            Drawable drawable = this.f617g[i];
            if (drawable != null) {
                return drawable;
            }
            SparseArray<Drawable.ConstantState> sparseArray = this.f616f;
            if (sparseArray == null || (indexOfKey = sparseArray.indexOfKey(i)) < 0) {
                return null;
            }
            Drawable b = m684b(this.f616f.valueAt(indexOfKey).newDrawable(this.f612b));
            this.f617g[i] = b;
            this.f616f.removeAt(indexOfKey);
            if (this.f616f.size() == 0) {
                this.f616f = null;
            }
            return b;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public final void mo2234a(Resources resources) {
            if (resources != null) {
                this.f612b = resources;
                int a = C0446b.m673a(resources, this.f613c);
                int i = this.f613c;
                this.f613c = a;
                if (i != a) {
                    this.f623m = false;
                    this.f620j = false;
                }
            }
        }

        /* renamed from: b */
        public final void mo2238b(int i) {
            this.f602A = i;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public final void mo2233a(Resources.Theme theme) {
            if (theme != null) {
                m685n();
                int i = this.f618h;
                Drawable[] drawableArr = this.f617g;
                for (int i2 = 0; i2 < i; i2++) {
                    if (drawableArr[i2] != null && drawableArr[i2].canApplyTheme()) {
                        drawableArr[i2].applyTheme(theme);
                        this.f615e |= drawableArr[i2].getChangingConfigurations();
                    }
                }
                mo2234a(theme.getResources());
            }
        }

        /* renamed from: a */
        public final void mo2235a(boolean z) {
            this.f622l = z;
        }

        /* renamed from: a */
        public void mo2232a(int i, int i2) {
            Drawable[] drawableArr = new Drawable[i2];
            System.arraycopy(this.f617g, 0, drawableArr, 0, i);
            this.f617g = drawableArr;
        }

        /* renamed from: a */
        public synchronized boolean mo2236a() {
            if (this.f632v) {
                return this.f633w;
            }
            m685n();
            this.f632v = true;
            int i = this.f618h;
            Drawable[] drawableArr = this.f617g;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2].getConstantState() == null) {
                    this.f633w = false;
                    return false;
                }
            }
            this.f633w = true;
            return true;
        }
    }

    C0446b() {
    }

    /* renamed from: c */
    private boolean m675c() {
        if (!isAutoMirrored() || C0857a.m2814d(this) != 1) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0449c mo2165a() {
        throw null;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0073  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo2192a(int r10) {
        /*
            r9 = this;
            int r0 = r9.f594g
            r1 = 0
            if (r10 != r0) goto L_0x0006
            return r1
        L_0x0006:
            long r2 = android.os.SystemClock.uptimeMillis()
            androidx.appcompat.b.a.b$c r0 = r9.f588a
            int r0 = r0.f603B
            r4 = 0
            r5 = 0
            if (r0 <= 0) goto L_0x002e
            android.graphics.drawable.Drawable r0 = r9.f591d
            if (r0 == 0) goto L_0x001a
            r0.setVisible(r1, r1)
        L_0x001a:
            android.graphics.drawable.Drawable r0 = r9.f590c
            if (r0 == 0) goto L_0x0029
            r9.f591d = r0
            androidx.appcompat.b.a.b$c r0 = r9.f588a
            int r0 = r0.f603B
            long r0 = (long) r0
            long r0 = r0 + r2
            r9.f598k = r0
            goto L_0x0035
        L_0x0029:
            r9.f591d = r4
            r9.f598k = r5
            goto L_0x0035
        L_0x002e:
            android.graphics.drawable.Drawable r0 = r9.f590c
            if (r0 == 0) goto L_0x0035
            r0.setVisible(r1, r1)
        L_0x0035:
            if (r10 < 0) goto L_0x0055
            androidx.appcompat.b.a.b$c r0 = r9.f588a
            int r1 = r0.f618h
            if (r10 >= r1) goto L_0x0055
            android.graphics.drawable.Drawable r0 = r0.mo2231a((int) r10)
            r9.f590c = r0
            r9.f594g = r10
            if (r0 == 0) goto L_0x005a
            androidx.appcompat.b.a.b$c r10 = r9.f588a
            int r10 = r10.f602A
            if (r10 <= 0) goto L_0x0051
            long r7 = (long) r10
            long r2 = r2 + r7
            r9.f597j = r2
        L_0x0051:
            r9.m674a((android.graphics.drawable.Drawable) r0)
            goto L_0x005a
        L_0x0055:
            r9.f590c = r4
            r10 = -1
            r9.f594g = r10
        L_0x005a:
            long r0 = r9.f597j
            r10 = 1
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x0067
            long r0 = r9.f598k
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 == 0) goto L_0x0079
        L_0x0067:
            java.lang.Runnable r0 = r9.f596i
            if (r0 != 0) goto L_0x0073
            androidx.appcompat.b.a.b$a r0 = new androidx.appcompat.b.a.b$a
            r0.<init>()
            r9.f596i = r0
            goto L_0x0076
        L_0x0073:
            r9.unscheduleSelf(r0)
        L_0x0076:
            r9.mo2191a((boolean) r10)
        L_0x0079:
            r9.invalidateSelf()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.p008b.p009a.C0446b.mo2192a(int):boolean");
    }

    public void applyTheme(Resources.Theme theme) {
        this.f588a.mo2233a(theme);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo2194b() {
        return this.f594g;
    }

    public boolean canApplyTheme() {
        return this.f588a.canApplyTheme();
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.f590c;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f591d;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    public int getAlpha() {
        return this.f592e;
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f588a.getChangingConfigurations();
    }

    public final Drawable.ConstantState getConstantState() {
        if (!this.f588a.mo2236a()) {
            return null;
        }
        this.f588a.f614d = getChangingConfigurations();
        return this.f588a;
    }

    public Drawable getCurrent() {
        return this.f590c;
    }

    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.f589b;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    public int getIntrinsicHeight() {
        if (this.f588a.mo2253l()) {
            return this.f588a.mo2245e();
        }
        Drawable drawable = this.f590c;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    public int getIntrinsicWidth() {
        if (this.f588a.mo2253l()) {
            return this.f588a.mo2250i();
        }
        Drawable drawable = this.f590c;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    public int getMinimumHeight() {
        if (this.f588a.mo2253l()) {
            return this.f588a.mo2246f();
        }
        Drawable drawable = this.f590c;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    public int getMinimumWidth() {
        if (this.f588a.mo2253l()) {
            return this.f588a.mo2247g();
        }
        Drawable drawable = this.f590c;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    public int getOpacity() {
        Drawable drawable = this.f590c;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.f588a.mo2251j();
    }

    public void getOutline(Outline outline) {
        Drawable drawable = this.f590c;
        if (drawable != null) {
            drawable.getOutline(outline);
        }
    }

    public boolean getPadding(Rect rect) {
        boolean z;
        Rect h = this.f588a.mo2249h();
        if (h != null) {
            rect.set(h);
            z = (h.right | ((h.left | h.top) | h.bottom)) != 0;
        } else {
            Drawable drawable = this.f590c;
            if (drawable != null) {
                z = drawable.getPadding(rect);
            } else {
                z = super.getPadding(rect);
            }
        }
        if (m675c()) {
            int i = rect.left;
            rect.left = rect.right;
            rect.right = i;
        }
        return z;
    }

    public void invalidateDrawable(Drawable drawable) {
        C0449c cVar = this.f588a;
        if (cVar != null) {
            cVar.mo2252k();
        }
        if (drawable == this.f590c && getCallback() != null) {
            getCallback().invalidateDrawable(this);
        }
    }

    public boolean isAutoMirrored() {
        return this.f588a.f604C;
    }

    public void jumpToCurrentState() {
        boolean z;
        Drawable drawable = this.f591d;
        boolean z2 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f591d = null;
            z = true;
        } else {
            z = false;
        }
        Drawable drawable2 = this.f590c;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f593f) {
                this.f590c.setAlpha(this.f592e);
            }
        }
        if (this.f598k != 0) {
            this.f598k = 0;
            z = true;
        }
        if (this.f597j != 0) {
            this.f597j = 0;
        } else {
            z2 = z;
        }
        if (z2) {
            invalidateSelf();
        }
    }

    public Drawable mutate() {
        if (!this.f595h && super.mutate() == this) {
            C0449c a = mo2165a();
            a.mo2182m();
            mo2167a(a);
            this.f595h = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f591d;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f590c;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    public boolean onLayoutDirectionChanged(int i) {
        return this.f588a.mo2240b(i, mo2194b());
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        Drawable drawable = this.f591d;
        if (drawable != null) {
            return drawable.setLevel(i);
        }
        Drawable drawable2 = this.f590c;
        if (drawable2 != null) {
            return drawable2.setLevel(i);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f591d;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.f590c;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        if (drawable == this.f590c && getCallback() != null) {
            getCallback().scheduleDrawable(this, runnable, j);
        }
    }

    public void setAlpha(int i) {
        if (!this.f593f || this.f592e != i) {
            this.f593f = true;
            this.f592e = i;
            Drawable drawable = this.f590c;
            if (drawable == null) {
                return;
            }
            if (this.f597j == 0) {
                drawable.setAlpha(i);
            } else {
                mo2191a(false);
            }
        }
    }

    public void setAutoMirrored(boolean z) {
        C0449c cVar = this.f588a;
        if (cVar.f604C != z) {
            cVar.f604C = z;
            Drawable drawable = this.f590c;
            if (drawable != null) {
                C0857a.m2808a(drawable, z);
            }
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        C0449c cVar = this.f588a;
        cVar.f606E = true;
        if (cVar.f605D != colorFilter) {
            cVar.f605D = colorFilter;
            Drawable drawable = this.f590c;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    public void setDither(boolean z) {
        C0449c cVar = this.f588a;
        if (cVar.f634x != z) {
            cVar.f634x = z;
            Drawable drawable = this.f590c;
            if (drawable != null) {
                drawable.setDither(z);
            }
        }
    }

    public void setHotspot(float f, float f2) {
        Drawable drawable = this.f590c;
        if (drawable != null) {
            C0857a.m2802a(drawable, f, f2);
        }
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        Rect rect = this.f589b;
        if (rect == null) {
            this.f589b = new Rect(i, i2, i3, i4);
        } else {
            rect.set(i, i2, i3, i4);
        }
        Drawable drawable = this.f590c;
        if (drawable != null) {
            C0857a.m2803a(drawable, i, i2, i3, i4);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        C0449c cVar = this.f588a;
        cVar.f609H = true;
        if (cVar.f607F != colorStateList) {
            cVar.f607F = colorStateList;
            C0857a.m2804a(this.f590c, colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        C0449c cVar = this.f588a;
        cVar.f610I = true;
        if (cVar.f608G != mode) {
            cVar.f608G = mode;
            C0857a.m2807a(this.f590c, mode);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        Drawable drawable = this.f591d;
        if (drawable != null) {
            drawable.setVisible(z, z2);
        }
        Drawable drawable2 = this.f590c;
        if (drawable2 != null) {
            drawable2.setVisible(z, z2);
        }
        return visible;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable == this.f590c && getCallback() != null) {
            getCallback().unscheduleDrawable(this, runnable);
        }
    }

    /* renamed from: a */
    private void m674a(Drawable drawable) {
        if (this.f599l == null) {
            this.f599l = new C0448b();
        }
        C0448b bVar = this.f599l;
        bVar.mo2226a(drawable.getCallback());
        drawable.setCallback(bVar);
        try {
            if (this.f588a.f602A <= 0 && this.f593f) {
                drawable.setAlpha(this.f592e);
            }
            if (this.f588a.f606E) {
                drawable.setColorFilter(this.f588a.f605D);
            } else {
                if (this.f588a.f609H) {
                    C0857a.m2804a(drawable, this.f588a.f607F);
                }
                if (this.f588a.f610I) {
                    C0857a.m2807a(drawable, this.f588a.f608G);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f588a.f634x);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(getLayoutDirection());
            }
            if (Build.VERSION.SDK_INT >= 19) {
                drawable.setAutoMirrored(this.f588a.f604C);
            }
            Rect rect = this.f589b;
            if (Build.VERSION.SDK_INT >= 21 && rect != null) {
                drawable.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            drawable.setCallback(this.f599l.mo2225a());
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006a A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo2191a(boolean r14) {
        /*
            r13 = this;
            r0 = 1
            r13.f593f = r0
            long r1 = android.os.SystemClock.uptimeMillis()
            android.graphics.drawable.Drawable r3 = r13.f590c
            r4 = 255(0xff, double:1.26E-321)
            r6 = 0
            r7 = 0
            if (r3 == 0) goto L_0x0038
            long r9 = r13.f597j
            int r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r11 == 0) goto L_0x003a
            int r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r11 > 0) goto L_0x0022
            int r9 = r13.f592e
            r3.setAlpha(r9)
            r13.f597j = r7
            goto L_0x003a
        L_0x0022:
            long r9 = r9 - r1
            long r9 = r9 * r4
            int r10 = (int) r9
            androidx.appcompat.b.a.b$c r9 = r13.f588a
            int r9 = r9.f602A
            int r10 = r10 / r9
            int r9 = 255 - r10
            int r10 = r13.f592e
            int r9 = r9 * r10
            int r9 = r9 / 255
            r3.setAlpha(r9)
            r3 = 1
            goto L_0x003b
        L_0x0038:
            r13.f597j = r7
        L_0x003a:
            r3 = 0
        L_0x003b:
            android.graphics.drawable.Drawable r9 = r13.f591d
            if (r9 == 0) goto L_0x0065
            long r10 = r13.f598k
            int r12 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r12 == 0) goto L_0x0067
            int r12 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r12 > 0) goto L_0x0052
            r9.setVisible(r6, r6)
            r0 = 0
            r13.f591d = r0
            r13.f598k = r7
            goto L_0x0067
        L_0x0052:
            long r10 = r10 - r1
            long r10 = r10 * r4
            int r3 = (int) r10
            androidx.appcompat.b.a.b$c r4 = r13.f588a
            int r4 = r4.f603B
            int r3 = r3 / r4
            int r4 = r13.f592e
            int r3 = r3 * r4
            int r3 = r3 / 255
            r9.setAlpha(r3)
            goto L_0x0068
        L_0x0065:
            r13.f598k = r7
        L_0x0067:
            r0 = r3
        L_0x0068:
            if (r14 == 0) goto L_0x0074
            if (r0 == 0) goto L_0x0074
            java.lang.Runnable r14 = r13.f596i
            r3 = 16
            long r1 = r1 + r3
            r13.scheduleSelf(r14, r1)
        L_0x0074:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.p008b.p009a.C0446b.mo2191a(boolean):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo2190a(Resources resources) {
        this.f588a.mo2234a(resources);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2167a(C0449c cVar) {
        this.f588a = cVar;
        int i = this.f594g;
        if (i >= 0) {
            Drawable a = cVar.mo2231a(i);
            this.f590c = a;
            if (a != null) {
                m674a(a);
            }
        }
        this.f591d = null;
    }

    /* renamed from: a */
    static int m673a(Resources resources, int i) {
        if (resources != null) {
            i = resources.getDisplayMetrics().densityDpi;
        }
        if (i == 0) {
            return 160;
        }
        return i;
    }
}
