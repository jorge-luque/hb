package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import androidx.appcompat.p008b.p009a.C0438a;
import androidx.appcompat.resources.R$drawable;
import androidx.core.content.C0768a;
import androidx.core.graphics.drawable.C0857a;
import androidx.vectordrawable.p028a.p029a.C1132c;
import androidx.vectordrawable.p028a.p029a.C1142i;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import p075d.p080b.C3191a;
import p075d.p080b.C3196d;
import p075d.p080b.C3197e;
import p075d.p080b.C3205h;

/* renamed from: androidx.appcompat.widget.w */
/* compiled from: ResourceManagerInternal */
public final class C0633w {

    /* renamed from: h */
    private static final PorterDuff.Mode f1574h = PorterDuff.Mode.SRC_IN;

    /* renamed from: i */
    private static C0633w f1575i;

    /* renamed from: j */
    private static final C0636c f1576j = new C0636c(6);

    /* renamed from: a */
    private WeakHashMap<Context, C3205h<ColorStateList>> f1577a;

    /* renamed from: b */
    private C3191a<String, C0637d> f1578b;

    /* renamed from: c */
    private C3205h<String> f1579c;

    /* renamed from: d */
    private final WeakHashMap<Context, C3196d<WeakReference<Drawable.ConstantState>>> f1580d = new WeakHashMap<>(0);

    /* renamed from: e */
    private TypedValue f1581e;

    /* renamed from: f */
    private boolean f1582f;

    /* renamed from: g */
    private C0638e f1583g;

    /* renamed from: androidx.appcompat.widget.w$a */
    /* compiled from: ResourceManagerInternal */
    static class C0634a implements C0637d {
        C0634a() {
        }

        /* renamed from: a */
        public Drawable mo3587a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return C0438a.m639b(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e);
                return null;
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.w$b */
    /* compiled from: ResourceManagerInternal */
    private static class C0635b implements C0637d {
        C0635b() {
        }

        /* renamed from: a */
        public Drawable mo3587a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return C1132c.m4629a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
                return null;
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.w$c */
    /* compiled from: ResourceManagerInternal */
    private static class C0636c extends C3197e<Integer, PorterDuffColorFilter> {
        public C0636c(int i) {
            super(i);
        }

        /* renamed from: b */
        private static int m1875b(int i, PorterDuff.Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public PorterDuffColorFilter mo3588a(int i, PorterDuff.Mode mode) {
            return (PorterDuffColorFilter) get(Integer.valueOf(m1875b(i, mode)));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public PorterDuffColorFilter mo3589a(int i, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) put(Integer.valueOf(m1875b(i, mode)), porterDuffColorFilter);
        }
    }

    /* renamed from: androidx.appcompat.widget.w$d */
    /* compiled from: ResourceManagerInternal */
    private interface C0637d {
        /* renamed from: a */
        Drawable mo3587a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    /* renamed from: androidx.appcompat.widget.w$e */
    /* compiled from: ResourceManagerInternal */
    interface C0638e {
        /* renamed from: a */
        ColorStateList mo3425a(Context context, int i);

        /* renamed from: a */
        PorterDuff.Mode mo3426a(int i);

        /* renamed from: a */
        Drawable mo3427a(C0633w wVar, Context context, int i);

        /* renamed from: a */
        boolean mo3428a(Context context, int i, Drawable drawable);

        /* renamed from: b */
        boolean mo3429b(Context context, int i, Drawable drawable);
    }

    /* renamed from: androidx.appcompat.widget.w$f */
    /* compiled from: ResourceManagerInternal */
    private static class C0639f implements C0637d {
        C0639f() {
        }

        /* renamed from: a */
        public Drawable mo3587a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return C1142i.createFromXmlInner(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
                return null;
            }
        }
    }

    /* renamed from: a */
    public static synchronized C0633w m1854a() {
        C0633w wVar;
        synchronized (C0633w.class) {
            if (f1575i == null) {
                C0633w wVar2 = new C0633w();
                f1575i = wVar2;
                m1857a(wVar2);
            }
            wVar = f1575i;
        }
        return wVar;
    }

    /* renamed from: c */
    private Drawable m1862c(Context context, int i) {
        Drawable drawable;
        if (this.f1581e == null) {
            this.f1581e = new TypedValue();
        }
        TypedValue typedValue = this.f1581e;
        context.getResources().getValue(i, typedValue, true);
        long a = m1849a(typedValue);
        Drawable a2 = m1853a(context, a);
        if (a2 != null) {
            return a2;
        }
        C0638e eVar = this.f1583g;
        if (eVar == null) {
            drawable = null;
        } else {
            drawable = eVar.mo3427a(this, context, i);
        }
        if (drawable != null) {
            drawable.setChangingConfigurations(typedValue.changingConfigurations);
            m1859a(context, a, drawable);
        }
        return drawable;
    }

    /* renamed from: d */
    private ColorStateList m1863d(Context context, int i) {
        C3205h hVar;
        WeakHashMap<Context, C3205h<ColorStateList>> weakHashMap = this.f1577a;
        if (weakHashMap == null || (hVar = weakHashMap.get(context)) == null) {
            return null;
        }
        return (ColorStateList) hVar.mo18822a(i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0073 A[Catch:{ Exception -> 0x00a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009a A[Catch:{ Exception -> 0x00a2 }] */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable m1864e(android.content.Context r11, int r12) {
        /*
            r10 = this;
            d.b.a<java.lang.String, androidx.appcompat.widget.w$d> r0 = r10.f1578b
            r1 = 0
            if (r0 == 0) goto L_0x00b2
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00b2
            d.b.h<java.lang.String> r0 = r10.f1579c
            java.lang.String r2 = "appcompat_skip_skip"
            if (r0 == 0) goto L_0x0028
            java.lang.Object r0 = r0.mo18822a(r12)
            java.lang.String r0 = (java.lang.String) r0
            boolean r3 = r2.equals(r0)
            if (r3 != 0) goto L_0x0027
            if (r0 == 0) goto L_0x002f
            d.b.a<java.lang.String, androidx.appcompat.widget.w$d> r3 = r10.f1578b
            java.lang.Object r0 = r3.get(r0)
            if (r0 != 0) goto L_0x002f
        L_0x0027:
            return r1
        L_0x0028:
            d.b.h r0 = new d.b.h
            r0.<init>()
            r10.f1579c = r0
        L_0x002f:
            android.util.TypedValue r0 = r10.f1581e
            if (r0 != 0) goto L_0x003a
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            r10.f1581e = r0
        L_0x003a:
            android.util.TypedValue r0 = r10.f1581e
            android.content.res.Resources r1 = r11.getResources()
            r3 = 1
            r1.getValue(r12, r0, r3)
            long r4 = m1849a((android.util.TypedValue) r0)
            android.graphics.drawable.Drawable r6 = r10.m1853a((android.content.Context) r11, (long) r4)
            if (r6 == 0) goto L_0x004f
            return r6
        L_0x004f:
            java.lang.CharSequence r7 = r0.string
            if (r7 == 0) goto L_0x00aa
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = ".xml"
            boolean r7 = r7.endsWith(r8)
            if (r7 == 0) goto L_0x00aa
            android.content.res.XmlResourceParser r1 = r1.getXml(r12)     // Catch:{ Exception -> 0x00a2 }
            android.util.AttributeSet r7 = android.util.Xml.asAttributeSet(r1)     // Catch:{ Exception -> 0x00a2 }
        L_0x0067:
            int r8 = r1.next()     // Catch:{ Exception -> 0x00a2 }
            r9 = 2
            if (r8 == r9) goto L_0x0071
            if (r8 == r3) goto L_0x0071
            goto L_0x0067
        L_0x0071:
            if (r8 != r9) goto L_0x009a
            java.lang.String r3 = r1.getName()     // Catch:{ Exception -> 0x00a2 }
            d.b.h<java.lang.String> r8 = r10.f1579c     // Catch:{ Exception -> 0x00a2 }
            r8.mo18824a(r12, r3)     // Catch:{ Exception -> 0x00a2 }
            d.b.a<java.lang.String, androidx.appcompat.widget.w$d> r8 = r10.f1578b     // Catch:{ Exception -> 0x00a2 }
            java.lang.Object r3 = r8.get(r3)     // Catch:{ Exception -> 0x00a2 }
            androidx.appcompat.widget.w$d r3 = (androidx.appcompat.widget.C0633w.C0637d) r3     // Catch:{ Exception -> 0x00a2 }
            if (r3 == 0) goto L_0x008f
            android.content.res.Resources$Theme r8 = r11.getTheme()     // Catch:{ Exception -> 0x00a2 }
            android.graphics.drawable.Drawable r1 = r3.mo3587a(r11, r1, r7, r8)     // Catch:{ Exception -> 0x00a2 }
            r6 = r1
        L_0x008f:
            if (r6 == 0) goto L_0x00aa
            int r0 = r0.changingConfigurations     // Catch:{ Exception -> 0x00a2 }
            r6.setChangingConfigurations(r0)     // Catch:{ Exception -> 0x00a2 }
            r10.m1859a((android.content.Context) r11, (long) r4, (android.graphics.drawable.Drawable) r6)     // Catch:{ Exception -> 0x00a2 }
            goto L_0x00aa
        L_0x009a:
            org.xmlpull.v1.XmlPullParserException r11 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r0 = "No start tag found"
            r11.<init>(r0)     // Catch:{ Exception -> 0x00a2 }
            throw r11     // Catch:{ Exception -> 0x00a2 }
        L_0x00a2:
            r11 = move-exception
            java.lang.String r0 = "ResourceManagerInternal"
            java.lang.String r1 = "Exception while inflating drawable"
            android.util.Log.e(r0, r1, r11)
        L_0x00aa:
            if (r6 != 0) goto L_0x00b1
            d.b.h<java.lang.String> r11 = r10.f1579c
            r11.mo18824a(r12, r2)
        L_0x00b1:
            return r6
        L_0x00b2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0633w.m1864e(android.content.Context, int):android.graphics.drawable.Drawable");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized ColorStateList mo3586b(Context context, int i) {
        ColorStateList d;
        d = m1863d(context, i);
        if (d == null) {
            d = this.f1583g == null ? null : this.f1583g.mo3425a(context, i);
            if (d != null) {
                m1855a(context, i, d);
            }
        }
        return d;
    }

    /* renamed from: a */
    private static void m1857a(C0633w wVar) {
        if (Build.VERSION.SDK_INT < 24) {
            wVar.m1858a("vector", (C0637d) new C0639f());
            wVar.m1858a("animated-vector", (C0637d) new C0635b());
            wVar.m1858a("animated-selector", (C0637d) new C0634a());
        }
    }

    /* renamed from: b */
    private void m1861b(Context context) {
        if (!this.f1582f) {
            this.f1582f = true;
            Drawable a = mo3580a(context, R$drawable.abc_vector_test);
            if (a == null || !m1860a(a)) {
                this.f1582f = false;
                throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
            }
        }
    }

    /* renamed from: a */
    public synchronized void mo3584a(C0638e eVar) {
        this.f1583g = eVar;
    }

    /* renamed from: a */
    public synchronized Drawable mo3580a(Context context, int i) {
        return mo3581a(context, i, false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized Drawable mo3581a(Context context, int i, boolean z) {
        Drawable e;
        m1861b(context);
        e = m1864e(context, i);
        if (e == null) {
            e = m1862c(context, i);
        }
        if (e == null) {
            e = C0768a.m2411c(context, i);
        }
        if (e != null) {
            e = m1852a(context, i, z, e);
        }
        if (e != null) {
            C0621q.m1808b(e);
        }
        return e;
    }

    /* renamed from: a */
    public synchronized void mo3583a(Context context) {
        C3196d dVar = this.f1580d.get(context);
        if (dVar != null) {
            dVar.mo18707a();
        }
    }

    /* renamed from: a */
    private static long m1849a(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    /* renamed from: a */
    private Drawable m1852a(Context context, int i, boolean z, Drawable drawable) {
        ColorStateList b = mo3586b(context, i);
        if (b != null) {
            if (C0621q.m1807a(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable h = C0857a.m2818h(drawable);
            C0857a.m2804a(h, b);
            PorterDuff.Mode a = mo3579a(i);
            if (a == null) {
                return h;
            }
            C0857a.m2807a(h, a);
            return h;
        }
        C0638e eVar = this.f1583g;
        if ((eVar == null || !eVar.mo3429b(context, i, drawable)) && !mo3585a(context, i, drawable) && z) {
            return null;
        }
        return drawable;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002c, code lost:
        return null;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized android.graphics.drawable.Drawable m1853a(android.content.Context r4, long r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.WeakHashMap<android.content.Context, d.b.d<java.lang.ref.WeakReference<android.graphics.drawable.Drawable$ConstantState>>> r0 = r3.f1580d     // Catch:{ all -> 0x002d }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x002d }
            d.b.d r0 = (p075d.p080b.C3196d) r0     // Catch:{ all -> 0x002d }
            r1 = 0
            if (r0 != 0) goto L_0x000e
            monitor-exit(r3)
            return r1
        L_0x000e:
            java.lang.Object r2 = r0.mo18711b((long) r5)     // Catch:{ all -> 0x002d }
            java.lang.ref.WeakReference r2 = (java.lang.ref.WeakReference) r2     // Catch:{ all -> 0x002d }
            if (r2 == 0) goto L_0x002b
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x002d }
            android.graphics.drawable.Drawable$ConstantState r2 = (android.graphics.drawable.Drawable.ConstantState) r2     // Catch:{ all -> 0x002d }
            if (r2 == 0) goto L_0x0028
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ all -> 0x002d }
            android.graphics.drawable.Drawable r4 = r2.newDrawable(r4)     // Catch:{ all -> 0x002d }
            monitor-exit(r3)
            return r4
        L_0x0028:
            r0.mo18708a((long) r5)     // Catch:{ all -> 0x002d }
        L_0x002b:
            monitor-exit(r3)
            return r1
        L_0x002d:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0633w.m1853a(android.content.Context, long):android.graphics.drawable.Drawable");
    }

    /* renamed from: a */
    private synchronized boolean m1859a(Context context, long j, Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        C3196d dVar = this.f1580d.get(context);
        if (dVar == null) {
            dVar = new C3196d();
            this.f1580d.put(context, dVar);
        }
        dVar.mo18716c(j, new WeakReference(constantState));
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized Drawable mo3582a(Context context, C0612l0 l0Var, int i) {
        Drawable e = m1864e(context, i);
        if (e == null) {
            e = l0Var.mo3509a(i);
        }
        if (e == null) {
            return null;
        }
        return m1852a(context, i, false, e);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo3585a(Context context, int i, Drawable drawable) {
        C0638e eVar = this.f1583g;
        return eVar != null && eVar.mo3428a(context, i, drawable);
    }

    /* renamed from: a */
    private void m1858a(String str, C0637d dVar) {
        if (this.f1578b == null) {
            this.f1578b = new C3191a<>();
        }
        this.f1578b.put(str, dVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public PorterDuff.Mode mo3579a(int i) {
        C0638e eVar = this.f1583g;
        if (eVar == null) {
            return null;
        }
        return eVar.mo3426a(i);
    }

    /* renamed from: a */
    private void m1855a(Context context, int i, ColorStateList colorStateList) {
        if (this.f1577a == null) {
            this.f1577a = new WeakHashMap<>();
        }
        C3205h hVar = this.f1577a.get(context);
        if (hVar == null) {
            hVar = new C3205h();
            this.f1577a.put(context, hVar);
        }
        hVar.mo18824a(i, colorStateList);
    }

    /* renamed from: a */
    static void m1856a(Drawable drawable, C0593e0 e0Var, int[] iArr) {
        if (!C0621q.m1807a(drawable) || drawable.mutate() == drawable) {
            if (e0Var.f1426d || e0Var.f1425c) {
                drawable.setColorFilter(m1851a(e0Var.f1426d ? e0Var.f1423a : null, e0Var.f1425c ? e0Var.f1424b : f1574h, iArr));
            } else {
                drawable.clearColorFilter();
            }
            if (Build.VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
            }
        }
    }

    /* renamed from: a */
    private static PorterDuffColorFilter m1851a(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return m1850a(colorStateList.getColorForState(iArr, 0), mode);
    }

    /* renamed from: a */
    public static synchronized PorterDuffColorFilter m1850a(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter a;
        synchronized (C0633w.class) {
            a = f1576j.mo3588a(i, mode);
            if (a == null) {
                a = new PorterDuffColorFilter(i, mode);
                f1576j.mo3589a(i, mode, a);
            }
        }
        return a;
    }

    /* renamed from: a */
    private static boolean m1860a(Drawable drawable) {
        return (drawable instanceof C1142i) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }
}
