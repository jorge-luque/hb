package androidx.appcompat.p008b.p009a;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.p008b.p009a.C0446b;
import androidx.appcompat.p008b.p009a.C0451d;
import androidx.appcompat.resources.R$styleable;
import androidx.appcompat.widget.C0633w;
import androidx.core.content.p017c.C0784g;
import androidx.core.graphics.drawable.C0858b;
import androidx.vectordrawable.p028a.p029a.C1132c;
import androidx.vectordrawable.p028a.p029a.C1142i;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p075d.p080b.C3196d;
import p075d.p080b.C3205h;

@SuppressLint({"RestrictedAPI"})
/* renamed from: androidx.appcompat.b.a.a */
/* compiled from: AnimatedStateListDrawableCompat */
public class C0438a extends C0451d implements C0858b {

    /* renamed from: o */
    private C0441c f574o;

    /* renamed from: p */
    private C0445g f575p;

    /* renamed from: q */
    private int f576q;

    /* renamed from: r */
    private int f577r;

    /* renamed from: s */
    private boolean f578s;

    /* renamed from: androidx.appcompat.b.a.a$b */
    /* compiled from: AnimatedStateListDrawableCompat */
    private static class C0440b extends C0445g {

        /* renamed from: a */
        private final Animatable f579a;

        C0440b(Animatable animatable) {
            super();
            this.f579a = animatable;
        }

        /* renamed from: c */
        public void mo2173c() {
            this.f579a.start();
        }

        /* renamed from: d */
        public void mo2174d() {
            this.f579a.stop();
        }
    }

    /* renamed from: androidx.appcompat.b.a.a$c */
    /* compiled from: AnimatedStateListDrawableCompat */
    static class C0441c extends C0451d.C0452a {

        /* renamed from: K */
        C3196d<Long> f580K;

        /* renamed from: L */
        C3205h<Integer> f581L;

        C0441c(C0441c cVar, C0438a aVar, Resources resources) {
            super(cVar, aVar, resources);
            if (cVar != null) {
                this.f580K = cVar.f580K;
                this.f581L = cVar.f581L;
                return;
            }
            this.f580K = new C3196d<>();
            this.f581L = new C3205h<>();
        }

        /* renamed from: f */
        private static long m652f(int i, int i2) {
            return ((long) i2) | (((long) i) << 32);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo2175a(int i, int i2, Drawable drawable, boolean z) {
            int a = super.mo2230a(drawable);
            long f = m652f(i, i2);
            long j = z ? 8589934592L : 0;
            long j2 = (long) a;
            this.f580K.mo18709a(f, Long.valueOf(j2 | j));
            if (z) {
                this.f580K.mo18709a(m652f(i2, i), Long.valueOf(4294967296L | j2 | j));
            }
            return a;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public int mo2177b(int[] iArr) {
            int a = super.mo2289a(iArr);
            if (a >= 0) {
                return a;
            }
            return super.mo2289a(StateSet.WILD_CARD);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public int mo2178c(int i, int i2) {
            return (int) this.f580K.mo18712b(m652f(i, i2), -1L).longValue();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public int mo2179d(int i) {
            if (i < 0) {
                return 0;
            }
            return this.f581L.mo18827b(i, 0).intValue();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public boolean mo2181e(int i, int i2) {
            return (this.f580K.mo18712b(m652f(i, i2), -1L).longValue() & 8589934592L) != 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: m */
        public void mo2182m() {
            this.f580K = this.f580K.clone();
            this.f581L = this.f581L.clone();
        }

        public Drawable newDrawable() {
            return new C0438a(this, (Resources) null);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public boolean mo2180d(int i, int i2) {
            return (this.f580K.mo18712b(m652f(i, i2), -1L).longValue() & 4294967296L) != 0;
        }

        public Drawable newDrawable(Resources resources) {
            return new C0438a(this, resources);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo2176a(int[] iArr, Drawable drawable, int i) {
            int a = super.mo2290a(iArr, drawable);
            this.f581L.mo18829c(a, Integer.valueOf(i));
            return a;
        }
    }

    /* renamed from: androidx.appcompat.b.a.a$d */
    /* compiled from: AnimatedStateListDrawableCompat */
    private static class C0442d extends C0445g {

        /* renamed from: a */
        private final C1132c f582a;

        C0442d(C1132c cVar) {
            super();
            this.f582a = cVar;
        }

        /* renamed from: c */
        public void mo2173c() {
            this.f582a.start();
        }

        /* renamed from: d */
        public void mo2174d() {
            this.f582a.stop();
        }
    }

    /* renamed from: androidx.appcompat.b.a.a$e */
    /* compiled from: AnimatedStateListDrawableCompat */
    private static class C0443e extends C0445g {

        /* renamed from: a */
        private final ObjectAnimator f583a;

        /* renamed from: b */
        private final boolean f584b;

        C0443e(AnimationDrawable animationDrawable, boolean z, boolean z2) {
            super();
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i = z ? numberOfFrames - 1 : 0;
            int i2 = z ? 0 : numberOfFrames - 1;
            C0444f fVar = new C0444f(animationDrawable, z);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", new int[]{i, i2});
            if (Build.VERSION.SDK_INT >= 18) {
                ofInt.setAutoCancel(true);
            }
            ofInt.setDuration((long) fVar.mo2187a());
            ofInt.setInterpolator(fVar);
            this.f584b = z2;
            this.f583a = ofInt;
        }

        /* renamed from: a */
        public boolean mo2185a() {
            return this.f584b;
        }

        /* renamed from: b */
        public void mo2186b() {
            this.f583a.reverse();
        }

        /* renamed from: c */
        public void mo2173c() {
            this.f583a.start();
        }

        /* renamed from: d */
        public void mo2174d() {
            this.f583a.cancel();
        }
    }

    /* renamed from: androidx.appcompat.b.a.a$g */
    /* compiled from: AnimatedStateListDrawableCompat */
    private static abstract class C0445g {
        private C0445g() {
        }

        /* renamed from: a */
        public boolean mo2185a() {
            return false;
        }

        /* renamed from: b */
        public void mo2186b() {
        }

        /* renamed from: c */
        public abstract void mo2173c();

        /* renamed from: d */
        public abstract void mo2174d();
    }

    static {
        Class<C0438a> cls = C0438a.class;
    }

    public C0438a() {
        this((C0441c) null, (Resources) null);
    }

    /* renamed from: b */
    public static C0438a m639b(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            C0438a aVar = new C0438a();
            aVar.mo2166a(context, resources, xmlPullParser, attributeSet, theme);
            return aVar;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    /* renamed from: c */
    private void m641c() {
        onStateChange(getState());
    }

    /* renamed from: d */
    private int m643d(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray a = C0784g.m2472a(resources, theme, attributeSet, R$styleable.AnimatedStateListDrawableItem);
        int resourceId = a.getResourceId(R$styleable.AnimatedStateListDrawableItem_android_id, 0);
        int resourceId2 = a.getResourceId(R$styleable.AnimatedStateListDrawableItem_android_drawable, -1);
        Drawable a2 = resourceId2 > 0 ? C0633w.m1854a().mo3580a(context, resourceId2) : null;
        a.recycle();
        int[] a3 = mo2288a(attributeSet);
        if (a2 == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
            } else if (xmlPullParser.getName().equals("vector")) {
                a2 = C1142i.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            } else if (Build.VERSION.SDK_INT >= 21) {
                a2 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            } else {
                a2 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            }
        }
        if (a2 != null) {
            return this.f574o.mo2176a(a3, a2, resourceId);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
    }

    /* renamed from: e */
    private int m644e(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray a = C0784g.m2472a(resources, theme, attributeSet, R$styleable.AnimatedStateListDrawableTransition);
        int resourceId = a.getResourceId(R$styleable.AnimatedStateListDrawableTransition_android_fromId, -1);
        int resourceId2 = a.getResourceId(R$styleable.AnimatedStateListDrawableTransition_android_toId, -1);
        int resourceId3 = a.getResourceId(R$styleable.AnimatedStateListDrawableTransition_android_drawable, -1);
        Drawable a2 = resourceId3 > 0 ? C0633w.m1854a().mo3580a(context, resourceId3) : null;
        boolean z = a.getBoolean(R$styleable.AnimatedStateListDrawableTransition_android_reversible, false);
        a.recycle();
        if (a2 == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
            } else if (xmlPullParser.getName().equals("animated-vector")) {
                a2 = C1132c.m4629a(context, resources, xmlPullParser, attributeSet, theme);
            } else if (Build.VERSION.SDK_INT >= 21) {
                a2 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            } else {
                a2 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            }
        }
        if (a2 == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        } else if (resourceId != -1 && resourceId2 != -1) {
            return this.f574o.mo2175a(resourceId, resourceId2, a2, z);
        } else {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
        }
    }

    public boolean isStateful() {
        return true;
    }

    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        C0445g gVar = this.f575p;
        if (gVar != null) {
            gVar.mo2174d();
            this.f575p = null;
            mo2192a(this.f576q);
            this.f576q = -1;
            this.f577r = -1;
        }
    }

    public Drawable mutate() {
        if (!this.f578s) {
            super.mutate();
            if (this == this) {
                this.f574o.mo2182m();
                this.f578s = true;
            }
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        int b = this.f574o.mo2177b(iArr);
        boolean z = b != mo2194b() && (m640b(b) || mo2192a(b));
        Drawable current = getCurrent();
        return current != null ? z | current.setState(iArr) : z;
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (this.f575p != null && (visible || z2)) {
            if (z) {
                this.f575p.mo2173c();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    C0438a(C0441c cVar, Resources resources) {
        super((C0451d.C0452a) null);
        this.f576q = -1;
        this.f577r = -1;
        mo2167a((C0446b.C0449c) new C0441c(cVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    /* renamed from: c */
    private void m642c(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next != 1) {
                int depth2 = xmlPullParser.getDepth();
                if (depth2 < depth && next == 3) {
                    return;
                }
                if (next == 2 && depth2 <= depth) {
                    if (xmlPullParser.getName().equals("item")) {
                        m643d(context, resources, xmlPullParser, attributeSet, theme);
                    } else if (xmlPullParser.getName().equals("transition")) {
                        m644e(context, resources, xmlPullParser, attributeSet, theme);
                    }
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public void mo2166a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray a = C0784g.m2472a(resources, theme, attributeSet, R$styleable.AnimatedStateListDrawableCompat);
        setVisible(a.getBoolean(R$styleable.AnimatedStateListDrawableCompat_android_visible, true), true);
        m638a(a);
        mo2190a(resources);
        a.recycle();
        m642c(context, resources, xmlPullParser, attributeSet, theme);
        m641c();
    }

    /* renamed from: b */
    private boolean m640b(int i) {
        int i2;
        int c;
        C0445g gVar;
        C0445g gVar2 = this.f575p;
        if (gVar2 == null) {
            i2 = mo2194b();
        } else if (i == this.f576q) {
            return true;
        } else {
            if (i != this.f577r || !gVar2.mo2185a()) {
                i2 = this.f576q;
                gVar2.mo2174d();
            } else {
                gVar2.mo2186b();
                this.f576q = this.f577r;
                this.f577r = i;
                return true;
            }
        }
        this.f575p = null;
        this.f577r = -1;
        this.f576q = -1;
        C0441c cVar = this.f574o;
        int d = cVar.mo2179d(i2);
        int d2 = cVar.mo2179d(i);
        if (d2 == 0 || d == 0 || (c = cVar.mo2178c(d, d2)) < 0) {
            return false;
        }
        boolean e = cVar.mo2181e(d, d2);
        mo2192a(c);
        Drawable current = getCurrent();
        if (current instanceof AnimationDrawable) {
            gVar = new C0443e((AnimationDrawable) current, cVar.mo2180d(d, d2), e);
        } else if (current instanceof C1132c) {
            gVar = new C0442d((C1132c) current);
        } else {
            if (current instanceof Animatable) {
                gVar = new C0440b((Animatable) current);
            }
            return false;
        }
        gVar.mo2173c();
        this.f575p = gVar;
        this.f577r = i2;
        this.f576q = i;
        return true;
    }

    /* renamed from: androidx.appcompat.b.a.a$f */
    /* compiled from: AnimatedStateListDrawableCompat */
    private static class C0444f implements TimeInterpolator {

        /* renamed from: a */
        private int[] f585a;

        /* renamed from: b */
        private int f586b;

        /* renamed from: c */
        private int f587c;

        C0444f(AnimationDrawable animationDrawable, boolean z) {
            mo2188a(animationDrawable, z);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo2188a(AnimationDrawable animationDrawable, boolean z) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.f586b = numberOfFrames;
            int[] iArr = this.f585a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.f585a = new int[numberOfFrames];
            }
            int[] iArr2 = this.f585a;
            int i = 0;
            for (int i2 = 0; i2 < numberOfFrames; i2++) {
                int duration = animationDrawable.getDuration(z ? (numberOfFrames - i2) - 1 : i2);
                iArr2[i2] = duration;
                i += duration;
            }
            this.f587c = i;
            return i;
        }

        public float getInterpolation(float f) {
            int i = (int) ((f * ((float) this.f587c)) + 0.5f);
            int i2 = this.f586b;
            int[] iArr = this.f585a;
            int i3 = 0;
            while (i3 < i2 && i >= iArr[i3]) {
                i -= iArr[i3];
                i3++;
            }
            return (((float) i3) / ((float) i2)) + (i3 < i2 ? ((float) i) / ((float) this.f587c) : 0.0f);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo2187a() {
            return this.f587c;
        }
    }

    /* renamed from: a */
    private void m638a(TypedArray typedArray) {
        C0441c cVar = this.f574o;
        if (Build.VERSION.SDK_INT >= 21) {
            cVar.f614d |= typedArray.getChangingConfigurations();
        }
        cVar.mo2239b(typedArray.getBoolean(R$styleable.AnimatedStateListDrawableCompat_android_variablePadding, cVar.f619i));
        cVar.mo2235a(typedArray.getBoolean(R$styleable.AnimatedStateListDrawableCompat_android_constantSize, cVar.f622l));
        cVar.mo2238b(typedArray.getInt(R$styleable.AnimatedStateListDrawableCompat_android_enterFadeDuration, cVar.f602A));
        cVar.mo2242c(typedArray.getInt(R$styleable.AnimatedStateListDrawableCompat_android_exitFadeDuration, cVar.f603B));
        setDither(typedArray.getBoolean(R$styleable.AnimatedStateListDrawableCompat_android_dither, cVar.f634x));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0441c m647a() {
        return new C0441c(this.f574o, this, (Resources) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2167a(C0446b.C0449c cVar) {
        super.mo2167a(cVar);
        if (cVar instanceof C0441c) {
            this.f574o = (C0441c) cVar;
        }
    }
}
