package androidx.vectordrawable.p028a.p029a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.core.content.p017c.C0771b;
import androidx.core.content.p017c.C0784g;
import androidx.core.graphics.drawable.C0857a;
import androidx.core.p013a.C0681b;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p075d.p080b.C3191a;

/* renamed from: androidx.vectordrawable.a.a.i */
/* compiled from: VectorDrawableCompat */
public class C1142i extends C1141h {

    /* renamed from: j */
    static final PorterDuff.Mode f3104j = PorterDuff.Mode.SRC_IN;

    /* renamed from: b */
    private C1150h f3105b;

    /* renamed from: c */
    private PorterDuffColorFilter f3106c;

    /* renamed from: d */
    private ColorFilter f3107d;

    /* renamed from: e */
    private boolean f3108e;

    /* renamed from: f */
    private boolean f3109f;

    /* renamed from: g */
    private final float[] f3110g;

    /* renamed from: h */
    private final Matrix f3111h;

    /* renamed from: i */
    private final Rect f3112i;

    /* renamed from: androidx.vectordrawable.a.a.i$b */
    /* compiled from: VectorDrawableCompat */
    private static class C1144b extends C1148f {
        C1144b() {
        }

        /* renamed from: a */
        public void mo6066a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (C0784g.m2476a(xmlPullParser, "pathData")) {
                TypedArray a = C0784g.m2472a(resources, theme, attributeSet, C1130a.f3079d);
                m4669a(a, xmlPullParser);
                a.recycle();
            }
        }

        /* renamed from: b */
        public boolean mo6067b() {
            return true;
        }

        C1144b(C1144b bVar) {
            super(bVar);
        }

        /* renamed from: a */
        private void m4669a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f3139b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f3138a = C0681b.m2106a(string2);
            }
            this.f3140c = C0784g.m2477b(typedArray, xmlPullParser, "fillType", 2, 0);
        }
    }

    /* renamed from: androidx.vectordrawable.a.a.i$e */
    /* compiled from: VectorDrawableCompat */
    private static abstract class C1147e {
        private C1147e() {
        }

        /* renamed from: a */
        public boolean mo6069a() {
            return false;
        }

        /* renamed from: a */
        public boolean mo6070a(int[] iArr) {
            return false;
        }
    }

    /* renamed from: androidx.vectordrawable.a.a.i$h */
    /* compiled from: VectorDrawableCompat */
    private static class C1150h extends Drawable.ConstantState {

        /* renamed from: a */
        int f3159a;

        /* renamed from: b */
        C1149g f3160b;

        /* renamed from: c */
        ColorStateList f3161c;

        /* renamed from: d */
        PorterDuff.Mode f3162d;

        /* renamed from: e */
        boolean f3163e;

        /* renamed from: f */
        Bitmap f3164f;

        /* renamed from: g */
        ColorStateList f3165g;

        /* renamed from: h */
        PorterDuff.Mode f3166h;

        /* renamed from: i */
        int f3167i;

        /* renamed from: j */
        boolean f3168j;

        /* renamed from: k */
        boolean f3169k;

        /* renamed from: l */
        Paint f3170l;

        public C1150h(C1150h hVar) {
            this.f3161c = null;
            this.f3162d = C1142i.f3104j;
            if (hVar != null) {
                this.f3159a = hVar.f3159a;
                C1149g gVar = new C1149g(hVar.f3160b);
                this.f3160b = gVar;
                if (hVar.f3160b.f3147e != null) {
                    gVar.f3147e = new Paint(hVar.f3160b.f3147e);
                }
                if (hVar.f3160b.f3146d != null) {
                    this.f3160b.f3146d = new Paint(hVar.f3160b.f3146d);
                }
                this.f3161c = hVar.f3161c;
                this.f3162d = hVar.f3162d;
                this.f3163e = hVar.f3163e;
            }
        }

        /* renamed from: a */
        public void mo6116a(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f3164f, (Rect) null, rect, mo6115a(colorFilter));
        }

        /* renamed from: b */
        public boolean mo6121b() {
            return this.f3160b.getRootAlpha() < 255;
        }

        /* renamed from: c */
        public void mo6122c(int i, int i2) {
            this.f3164f.eraseColor(0);
            this.f3160b.mo6108a(new Canvas(this.f3164f), i, i2, (ColorFilter) null);
        }

        /* renamed from: d */
        public void mo6124d() {
            this.f3165g = this.f3161c;
            this.f3166h = this.f3162d;
            this.f3167i = this.f3160b.getRootAlpha();
            this.f3168j = this.f3163e;
            this.f3169k = false;
        }

        public int getChangingConfigurations() {
            return this.f3159a;
        }

        public Drawable newDrawable() {
            return new C1142i(this);
        }

        /* renamed from: b */
        public void mo6120b(int i, int i2) {
            if (this.f3164f == null || !mo6118a(i, i2)) {
                this.f3164f = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                this.f3169k = true;
            }
        }

        public Drawable newDrawable(Resources resources) {
            return new C1142i(this);
        }

        /* renamed from: a */
        public Paint mo6115a(ColorFilter colorFilter) {
            if (!mo6121b() && colorFilter == null) {
                return null;
            }
            if (this.f3170l == null) {
                Paint paint = new Paint();
                this.f3170l = paint;
                paint.setFilterBitmap(true);
            }
            this.f3170l.setAlpha(this.f3160b.getRootAlpha());
            this.f3170l.setColorFilter(colorFilter);
            return this.f3170l;
        }

        /* renamed from: c */
        public boolean mo6123c() {
            return this.f3160b.mo6109a();
        }

        /* renamed from: a */
        public boolean mo6118a(int i, int i2) {
            return i == this.f3164f.getWidth() && i2 == this.f3164f.getHeight();
        }

        /* renamed from: a */
        public boolean mo6117a() {
            return !this.f3169k && this.f3165g == this.f3161c && this.f3166h == this.f3162d && this.f3168j == this.f3163e && this.f3167i == this.f3160b.getRootAlpha();
        }

        public C1150h() {
            this.f3161c = null;
            this.f3162d = C1142i.f3104j;
            this.f3160b = new C1149g();
        }

        /* renamed from: a */
        public boolean mo6119a(int[] iArr) {
            boolean a = this.f3160b.mo6110a(iArr);
            this.f3169k |= a;
            return a;
        }
    }

    C1142i() {
        this.f3109f = true;
        this.f3110g = new float[9];
        this.f3111h = new Matrix();
        this.f3112i = new Rect();
        this.f3105b = new C1150h();
    }

    public static C1142i createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        C1142i iVar = new C1142i();
        iVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return iVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Object mo6041a(String str) {
        return this.f3105b.f3160b.f3158p.get(str);
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.f3103a;
        if (drawable == null) {
            return false;
        }
        C0857a.m2809a(drawable);
        return false;
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.f3103a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.f3112i);
        if (this.f3112i.width() > 0 && this.f3112i.height() > 0) {
            ColorFilter colorFilter = this.f3107d;
            if (colorFilter == null) {
                colorFilter = this.f3106c;
            }
            canvas.getMatrix(this.f3111h);
            this.f3111h.getValues(this.f3110g);
            float abs = Math.abs(this.f3110g[0]);
            float abs2 = Math.abs(this.f3110g[4]);
            float abs3 = Math.abs(this.f3110g[1]);
            float abs4 = Math.abs(this.f3110g[3]);
            if (!(abs3 == 0.0f && abs4 == 0.0f)) {
                abs = 1.0f;
                abs2 = 1.0f;
            }
            int min = Math.min(2048, (int) (((float) this.f3112i.width()) * abs));
            int min2 = Math.min(2048, (int) (((float) this.f3112i.height()) * abs2));
            if (min > 0 && min2 > 0) {
                int save = canvas.save();
                Rect rect = this.f3112i;
                canvas.translate((float) rect.left, (float) rect.top);
                if (m4665a()) {
                    canvas.translate((float) this.f3112i.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.f3112i.offsetTo(0, 0);
                this.f3105b.mo6120b(min, min2);
                if (!this.f3109f) {
                    this.f3105b.mo6122c(min, min2);
                } else if (!this.f3105b.mo6117a()) {
                    this.f3105b.mo6122c(min, min2);
                    this.f3105b.mo6124d();
                }
                this.f3105b.mo6116a(canvas, colorFilter, this.f3112i);
                canvas.restoreToCount(save);
            }
        }
    }

    public int getAlpha() {
        Drawable drawable = this.f3103a;
        if (drawable != null) {
            return C0857a.m2811b(drawable);
        }
        return this.f3105b.f3160b.getRootAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.f3103a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f3105b.getChangingConfigurations();
    }

    public ColorFilter getColorFilter() {
        Drawable drawable = this.f3103a;
        if (drawable != null) {
            return C0857a.m2813c(drawable);
        }
        return this.f3107d;
    }

    public Drawable.ConstantState getConstantState() {
        if (this.f3103a != null && Build.VERSION.SDK_INT >= 24) {
            return new C1151i(this.f3103a.getConstantState());
        }
        this.f3105b.f3159a = getChangingConfigurations();
        return this.f3105b;
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.f3103a;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return (int) this.f3105b.f3160b.f3152j;
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.f3103a;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return (int) this.f3105b.f3160b.f3151i;
    }

    public int getOpacity() {
        Drawable drawable = this.f3103a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.f3103a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, (Resources.Theme) null);
        }
    }

    public void invalidateSelf() {
        Drawable drawable = this.f3103a;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.f3103a;
        if (drawable != null) {
            return C0857a.m2815e(drawable);
        }
        return this.f3105b.f3163e;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
        r0 = r1.f3105b.f3161c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000f, code lost:
        r0 = r1.f3105b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isStateful() {
        /*
            r1 = this;
            android.graphics.drawable.Drawable r0 = r1.f3103a
            if (r0 == 0) goto L_0x0009
            boolean r0 = r0.isStateful()
            return r0
        L_0x0009:
            boolean r0 = super.isStateful()
            if (r0 != 0) goto L_0x0028
            androidx.vectordrawable.a.a.i$h r0 = r1.f3105b
            if (r0 == 0) goto L_0x0026
            boolean r0 = r0.mo6123c()
            if (r0 != 0) goto L_0x0028
            androidx.vectordrawable.a.a.i$h r0 = r1.f3105b
            android.content.res.ColorStateList r0 = r0.f3161c
            if (r0 == 0) goto L_0x0026
            boolean r0 = r0.isStateful()
            if (r0 == 0) goto L_0x0026
            goto L_0x0028
        L_0x0026:
            r0 = 0
            goto L_0x0029
        L_0x0028:
            r0 = 1
        L_0x0029:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.p028a.p029a.C1142i.isStateful():boolean");
    }

    public Drawable mutate() {
        Drawable drawable = this.f3103a;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f3108e && super.mutate() == this) {
            this.f3105b = new C1150h(this.f3105b);
            this.f3108e = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f3103a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        Drawable drawable = this.f3103a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        boolean z = false;
        C1150h hVar = this.f3105b;
        ColorStateList colorStateList = hVar.f3161c;
        if (!(colorStateList == null || (mode = hVar.f3162d) == null)) {
            this.f3106c = mo6040a(this.f3106c, colorStateList, mode);
            invalidateSelf();
            z = true;
        }
        if (!hVar.mo6123c() || !hVar.mo6119a(iArr)) {
            return z;
        }
        invalidateSelf();
        return true;
    }

    public void scheduleSelf(Runnable runnable, long j) {
        Drawable drawable = this.f3103a;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    public void setAlpha(int i) {
        Drawable drawable = this.f3103a;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else if (this.f3105b.f3160b.getRootAlpha() != i) {
            this.f3105b.f3160b.setRootAlpha(i);
            invalidateSelf();
        }
    }

    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f3103a;
        if (drawable != null) {
            C0857a.m2808a(drawable, z);
        } else {
            this.f3105b.f3163e = z;
        }
    }

    public void setTint(int i) {
        Drawable drawable = this.f3103a;
        if (drawable != null) {
            C0857a.m2812b(drawable, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f3103a;
        if (drawable != null) {
            C0857a.m2804a(drawable, colorStateList);
            return;
        }
        C1150h hVar = this.f3105b;
        if (hVar.f3161c != colorStateList) {
            hVar.f3161c = colorStateList;
            this.f3106c = mo6040a(this.f3106c, colorStateList, hVar.f3162d);
            invalidateSelf();
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f3103a;
        if (drawable != null) {
            C0857a.m2807a(drawable, mode);
            return;
        }
        C1150h hVar = this.f3105b;
        if (hVar.f3162d != mode) {
            hVar.f3162d = mode;
            this.f3106c = mo6040a(this.f3106c, hVar.f3161c, mode);
            invalidateSelf();
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f3103a;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f3103a;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    /* renamed from: androidx.vectordrawable.a.a.i$i */
    /* compiled from: VectorDrawableCompat */
    private static class C1151i extends Drawable.ConstantState {

        /* renamed from: a */
        private final Drawable.ConstantState f3171a;

        public C1151i(Drawable.ConstantState constantState) {
            this.f3171a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f3171a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f3171a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            C1142i iVar = new C1142i();
            iVar.f3103a = (VectorDrawable) this.f3171a.newDrawable();
            return iVar;
        }

        public Drawable newDrawable(Resources resources) {
            C1142i iVar = new C1142i();
            iVar.f3103a = (VectorDrawable) this.f3171a.newDrawable(resources);
            return iVar;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            C1142i iVar = new C1142i();
            iVar.f3103a = (VectorDrawable) this.f3171a.newDrawable(resources, theme);
            return iVar;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public PorterDuffColorFilter mo6040a(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f3103a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.f3107d = colorFilter;
        invalidateSelf();
    }

    /* renamed from: androidx.vectordrawable.a.a.i$c */
    /* compiled from: VectorDrawableCompat */
    private static class C1145c extends C1148f {

        /* renamed from: e */
        private int[] f3113e;

        /* renamed from: f */
        C0771b f3114f;

        /* renamed from: g */
        float f3115g = 0.0f;

        /* renamed from: h */
        C0771b f3116h;

        /* renamed from: i */
        float f3117i = 1.0f;

        /* renamed from: j */
        float f3118j = 1.0f;

        /* renamed from: k */
        float f3119k = 0.0f;

        /* renamed from: l */
        float f3120l = 1.0f;

        /* renamed from: m */
        float f3121m = 0.0f;

        /* renamed from: n */
        Paint.Cap f3122n = Paint.Cap.BUTT;

        /* renamed from: o */
        Paint.Join f3123o = Paint.Join.MITER;

        /* renamed from: p */
        float f3124p = 4.0f;

        C1145c() {
        }

        /* renamed from: a */
        private Paint.Cap m4672a(int i, Paint.Cap cap) {
            if (i == 0) {
                return Paint.Cap.BUTT;
            }
            if (i != 1) {
                return i != 2 ? cap : Paint.Cap.SQUARE;
            }
            return Paint.Cap.ROUND;
        }

        /* access modifiers changed from: package-private */
        public float getFillAlpha() {
            return this.f3118j;
        }

        /* access modifiers changed from: package-private */
        public int getFillColor() {
            return this.f3116h.mo4023a();
        }

        /* access modifiers changed from: package-private */
        public float getStrokeAlpha() {
            return this.f3117i;
        }

        /* access modifiers changed from: package-private */
        public int getStrokeColor() {
            return this.f3114f.mo4023a();
        }

        /* access modifiers changed from: package-private */
        public float getStrokeWidth() {
            return this.f3115g;
        }

        /* access modifiers changed from: package-private */
        public float getTrimPathEnd() {
            return this.f3120l;
        }

        /* access modifiers changed from: package-private */
        public float getTrimPathOffset() {
            return this.f3121m;
        }

        /* access modifiers changed from: package-private */
        public float getTrimPathStart() {
            return this.f3119k;
        }

        /* access modifiers changed from: package-private */
        public void setFillAlpha(float f) {
            this.f3118j = f;
        }

        /* access modifiers changed from: package-private */
        public void setFillColor(int i) {
            this.f3116h.mo4024a(i);
        }

        /* access modifiers changed from: package-private */
        public void setStrokeAlpha(float f) {
            this.f3117i = f;
        }

        /* access modifiers changed from: package-private */
        public void setStrokeColor(int i) {
            this.f3114f.mo4024a(i);
        }

        /* access modifiers changed from: package-private */
        public void setStrokeWidth(float f) {
            this.f3115g = f;
        }

        /* access modifiers changed from: package-private */
        public void setTrimPathEnd(float f) {
            this.f3120l = f;
        }

        /* access modifiers changed from: package-private */
        public void setTrimPathOffset(float f) {
            this.f3121m = f;
        }

        /* access modifiers changed from: package-private */
        public void setTrimPathStart(float f) {
            this.f3119k = f;
        }

        /* renamed from: a */
        private Paint.Join m4673a(int i, Paint.Join join) {
            if (i == 0) {
                return Paint.Join.MITER;
            }
            if (i != 1) {
                return i != 2 ? join : Paint.Join.BEVEL;
            }
            return Paint.Join.ROUND;
        }

        /* renamed from: a */
        public void mo6068a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray a = C0784g.m2472a(resources, theme, attributeSet, C1130a.f3078c);
            m4674a(a, xmlPullParser, theme);
            a.recycle();
        }

        /* renamed from: a */
        private void m4674a(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.f3113e = null;
            if (C0784g.m2476a(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f3139b = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f3138a = C0681b.m2106a(string2);
                }
                Resources.Theme theme2 = theme;
                this.f3116h = C0784g.m2473a(typedArray, xmlPullParser, theme2, "fillColor", 1, 0);
                this.f3118j = C0784g.m2468a(typedArray, xmlPullParser, "fillAlpha", 12, this.f3118j);
                this.f3122n = m4672a(C0784g.m2477b(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f3122n);
                this.f3123o = m4673a(C0784g.m2477b(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f3123o);
                this.f3124p = C0784g.m2468a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f3124p);
                this.f3114f = C0784g.m2473a(typedArray, xmlPullParser, theme2, "strokeColor", 3, 0);
                this.f3117i = C0784g.m2468a(typedArray, xmlPullParser, "strokeAlpha", 11, this.f3117i);
                this.f3115g = C0784g.m2468a(typedArray, xmlPullParser, "strokeWidth", 4, this.f3115g);
                this.f3120l = C0784g.m2468a(typedArray, xmlPullParser, "trimPathEnd", 6, this.f3120l);
                this.f3121m = C0784g.m2468a(typedArray, xmlPullParser, "trimPathOffset", 7, this.f3121m);
                this.f3119k = C0784g.m2468a(typedArray, xmlPullParser, "trimPathStart", 5, this.f3119k);
                this.f3140c = C0784g.m2477b(typedArray, xmlPullParser, "fillType", 13, this.f3140c);
            }
        }

        C1145c(C1145c cVar) {
            super(cVar);
            this.f3113e = cVar.f3113e;
            this.f3114f = cVar.f3114f;
            this.f3115g = cVar.f3115g;
            this.f3117i = cVar.f3117i;
            this.f3116h = cVar.f3116h;
            this.f3140c = cVar.f3140c;
            this.f3118j = cVar.f3118j;
            this.f3119k = cVar.f3119k;
            this.f3120l = cVar.f3120l;
            this.f3121m = cVar.f3121m;
            this.f3122n = cVar.f3122n;
            this.f3123o = cVar.f3123o;
            this.f3124p = cVar.f3124p;
        }

        /* renamed from: a */
        public boolean mo6069a() {
            return this.f3116h.mo4028d() || this.f3114f.mo4028d();
        }

        /* renamed from: a */
        public boolean mo6070a(int[] iArr) {
            return this.f3114f.mo4025a(iArr) | this.f3116h.mo4025a(iArr);
        }
    }

    /* renamed from: androidx.vectordrawable.a.a.i$d */
    /* compiled from: VectorDrawableCompat */
    private static class C1146d extends C1147e {

        /* renamed from: a */
        final Matrix f3125a = new Matrix();

        /* renamed from: b */
        final ArrayList<C1147e> f3126b = new ArrayList<>();

        /* renamed from: c */
        float f3127c = 0.0f;

        /* renamed from: d */
        private float f3128d = 0.0f;

        /* renamed from: e */
        private float f3129e = 0.0f;

        /* renamed from: f */
        private float f3130f = 1.0f;

        /* renamed from: g */
        private float f3131g = 1.0f;

        /* renamed from: h */
        private float f3132h = 0.0f;

        /* renamed from: i */
        private float f3133i = 0.0f;

        /* renamed from: j */
        final Matrix f3134j = new Matrix();

        /* renamed from: k */
        int f3135k;

        /* renamed from: l */
        private int[] f3136l;

        /* renamed from: m */
        private String f3137m = null;

        public C1146d(C1146d dVar, C3191a<String, Object> aVar) {
            super();
            C1148f fVar;
            this.f3127c = dVar.f3127c;
            this.f3128d = dVar.f3128d;
            this.f3129e = dVar.f3129e;
            this.f3130f = dVar.f3130f;
            this.f3131g = dVar.f3131g;
            this.f3132h = dVar.f3132h;
            this.f3133i = dVar.f3133i;
            this.f3136l = dVar.f3136l;
            String str = dVar.f3137m;
            this.f3137m = str;
            this.f3135k = dVar.f3135k;
            if (str != null) {
                aVar.put(str, this);
            }
            this.f3134j.set(dVar.f3134j);
            ArrayList<C1147e> arrayList = dVar.f3126b;
            for (int i = 0; i < arrayList.size(); i++) {
                C1147e eVar = arrayList.get(i);
                if (eVar instanceof C1146d) {
                    this.f3126b.add(new C1146d((C1146d) eVar, aVar));
                } else {
                    if (eVar instanceof C1145c) {
                        fVar = new C1145c((C1145c) eVar);
                    } else if (eVar instanceof C1144b) {
                        fVar = new C1144b((C1144b) eVar);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f3126b.add(fVar);
                    String str2 = fVar.f3139b;
                    if (str2 != null) {
                        aVar.put(str2, fVar);
                    }
                }
            }
        }

        /* renamed from: b */
        private void m4679b() {
            this.f3134j.reset();
            this.f3134j.postTranslate(-this.f3128d, -this.f3129e);
            this.f3134j.postScale(this.f3130f, this.f3131g);
            this.f3134j.postRotate(this.f3127c, 0.0f, 0.0f);
            this.f3134j.postTranslate(this.f3132h + this.f3128d, this.f3133i + this.f3129e);
        }

        /* renamed from: a */
        public void mo6087a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray a = C0784g.m2472a(resources, theme, attributeSet, C1130a.f3077b);
            m4678a(a, xmlPullParser);
            a.recycle();
        }

        public String getGroupName() {
            return this.f3137m;
        }

        public Matrix getLocalMatrix() {
            return this.f3134j;
        }

        public float getPivotX() {
            return this.f3128d;
        }

        public float getPivotY() {
            return this.f3129e;
        }

        public float getRotation() {
            return this.f3127c;
        }

        public float getScaleX() {
            return this.f3130f;
        }

        public float getScaleY() {
            return this.f3131g;
        }

        public float getTranslateX() {
            return this.f3132h;
        }

        public float getTranslateY() {
            return this.f3133i;
        }

        public void setPivotX(float f) {
            if (f != this.f3128d) {
                this.f3128d = f;
                m4679b();
            }
        }

        public void setPivotY(float f) {
            if (f != this.f3129e) {
                this.f3129e = f;
                m4679b();
            }
        }

        public void setRotation(float f) {
            if (f != this.f3127c) {
                this.f3127c = f;
                m4679b();
            }
        }

        public void setScaleX(float f) {
            if (f != this.f3130f) {
                this.f3130f = f;
                m4679b();
            }
        }

        public void setScaleY(float f) {
            if (f != this.f3131g) {
                this.f3131g = f;
                m4679b();
            }
        }

        public void setTranslateX(float f) {
            if (f != this.f3132h) {
                this.f3132h = f;
                m4679b();
            }
        }

        public void setTranslateY(float f) {
            if (f != this.f3133i) {
                this.f3133i = f;
                m4679b();
            }
        }

        /* renamed from: a */
        private void m4678a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f3136l = null;
            this.f3127c = C0784g.m2468a(typedArray, xmlPullParser, "rotation", 5, this.f3127c);
            this.f3128d = typedArray.getFloat(1, this.f3128d);
            this.f3129e = typedArray.getFloat(2, this.f3129e);
            this.f3130f = C0784g.m2468a(typedArray, xmlPullParser, "scaleX", 3, this.f3130f);
            this.f3131g = C0784g.m2468a(typedArray, xmlPullParser, "scaleY", 4, this.f3131g);
            this.f3132h = C0784g.m2468a(typedArray, xmlPullParser, "translateX", 6, this.f3132h);
            this.f3133i = C0784g.m2468a(typedArray, xmlPullParser, "translateY", 7, this.f3133i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f3137m = string;
            }
            m4679b();
        }

        /* renamed from: a */
        public boolean mo6069a() {
            for (int i = 0; i < this.f3126b.size(); i++) {
                if (this.f3126b.get(i).mo6069a()) {
                    return true;
                }
            }
            return false;
        }

        /* renamed from: a */
        public boolean mo6070a(int[] iArr) {
            boolean z = false;
            for (int i = 0; i < this.f3126b.size(); i++) {
                z |= this.f3126b.get(i).mo6070a(iArr);
            }
            return z;
        }

        public C1146d() {
            super();
        }
    }

    /* renamed from: androidx.vectordrawable.a.a.i$f */
    /* compiled from: VectorDrawableCompat */
    private static abstract class C1148f extends C1147e {

        /* renamed from: a */
        protected C0681b.C0683b[] f3138a = null;

        /* renamed from: b */
        String f3139b;

        /* renamed from: c */
        int f3140c = 0;

        /* renamed from: d */
        int f3141d;

        public C1148f() {
            super();
        }

        /* renamed from: a */
        public void mo6104a(Path path) {
            path.reset();
            C0681b.C0683b[] bVarArr = this.f3138a;
            if (bVarArr != null) {
                C0681b.C0683b.m2114a(bVarArr, path);
            }
        }

        /* renamed from: b */
        public boolean mo6067b() {
            return false;
        }

        public C0681b.C0683b[] getPathData() {
            return this.f3138a;
        }

        public String getPathName() {
            return this.f3139b;
        }

        public void setPathData(C0681b.C0683b[] bVarArr) {
            if (!C0681b.m2104a(this.f3138a, bVarArr)) {
                this.f3138a = C0681b.m2107a(bVarArr);
            } else {
                C0681b.m2109b(this.f3138a, bVarArr);
            }
        }

        public C1148f(C1148f fVar) {
            super();
            this.f3139b = fVar.f3139b;
            this.f3141d = fVar.f3141d;
            this.f3138a = C0681b.m2107a(fVar.f3138a);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036 A[Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0043 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003b A[Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0043 }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.vectordrawable.p028a.p029a.C1142i m4662a(android.content.res.Resources r6, int r7, android.content.res.Resources.Theme r8) {
        /*
            java.lang.String r0 = "parser error"
            java.lang.String r1 = "VectorDrawableCompat"
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 24
            if (r2 < r3) goto L_0x0021
            androidx.vectordrawable.a.a.i r0 = new androidx.vectordrawable.a.a.i
            r0.<init>()
            android.graphics.drawable.Drawable r6 = androidx.core.content.p017c.C0780f.m2463a(r6, r7, r8)
            r0.f3103a = r6
            androidx.vectordrawable.a.a.i$i r6 = new androidx.vectordrawable.a.a.i$i
            android.graphics.drawable.Drawable r7 = r0.f3103a
            android.graphics.drawable.Drawable$ConstantState r7 = r7.getConstantState()
            r6.<init>(r7)
            return r0
        L_0x0021:
            android.content.res.XmlResourceParser r7 = r6.getXml(r7)     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0043 }
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r7)     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0043 }
        L_0x0029:
            int r3 = r7.next()     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0043 }
            r4 = 2
            if (r3 == r4) goto L_0x0034
            r5 = 1
            if (r3 == r5) goto L_0x0034
            goto L_0x0029
        L_0x0034:
            if (r3 != r4) goto L_0x003b
            androidx.vectordrawable.a.a.i r6 = createFromXmlInner(r6, r7, r2, r8)     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0043 }
            return r6
        L_0x003b:
            org.xmlpull.v1.XmlPullParserException r6 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0043 }
            java.lang.String r7 = "No start tag found"
            r6.<init>(r7)     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0043 }
            throw r6     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0043 }
        L_0x0043:
            r6 = move-exception
            android.util.Log.e(r1, r0, r6)
            goto L_0x004c
        L_0x0048:
            r6 = move-exception
            android.util.Log.e(r1, r0, r6)
        L_0x004c:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.p028a.p029a.C1142i.m4662a(android.content.res.Resources, int, android.content.res.Resources$Theme):androidx.vectordrawable.a.a.i");
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f3103a;
        if (drawable != null) {
            C0857a.m2806a(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        C1150h hVar = this.f3105b;
        hVar.f3160b = new C1149g();
        TypedArray a = C0784g.m2472a(resources, theme, attributeSet, C1130a.f3076a);
        m4664a(a, xmlPullParser, theme);
        a.recycle();
        hVar.f3159a = getChangingConfigurations();
        hVar.f3169k = true;
        m4663a(resources, xmlPullParser, attributeSet, theme);
        this.f3106c = mo6040a(this.f3106c, hVar.f3161c, hVar.f3162d);
    }

    C1142i(C1150h hVar) {
        this.f3109f = true;
        this.f3110g = new float[9];
        this.f3111h = new Matrix();
        this.f3112i = new Rect();
        this.f3105b = hVar;
        this.f3106c = mo6040a(this.f3106c, hVar.f3161c, hVar.f3162d);
    }

    /* renamed from: androidx.vectordrawable.a.a.i$g */
    /* compiled from: VectorDrawableCompat */
    private static class C1149g {

        /* renamed from: q */
        private static final Matrix f3142q = new Matrix();

        /* renamed from: a */
        private final Path f3143a;

        /* renamed from: b */
        private final Path f3144b;

        /* renamed from: c */
        private final Matrix f3145c;

        /* renamed from: d */
        Paint f3146d;

        /* renamed from: e */
        Paint f3147e;

        /* renamed from: f */
        private PathMeasure f3148f;

        /* renamed from: g */
        private int f3149g;

        /* renamed from: h */
        final C1146d f3150h;

        /* renamed from: i */
        float f3151i;

        /* renamed from: j */
        float f3152j;

        /* renamed from: k */
        float f3153k;

        /* renamed from: l */
        float f3154l;

        /* renamed from: m */
        int f3155m;

        /* renamed from: n */
        String f3156n;

        /* renamed from: o */
        Boolean f3157o;

        /* renamed from: p */
        final C3191a<String, Object> f3158p;

        public C1149g() {
            this.f3145c = new Matrix();
            this.f3151i = 0.0f;
            this.f3152j = 0.0f;
            this.f3153k = 0.0f;
            this.f3154l = 0.0f;
            this.f3155m = 255;
            this.f3156n = null;
            this.f3157o = null;
            this.f3158p = new C3191a<>();
            this.f3150h = new C1146d();
            this.f3143a = new Path();
            this.f3144b = new Path();
        }

        /* renamed from: a */
        private static float m4687a(float f, float f2, float f3, float f4) {
            return (f * f4) - (f2 * f3);
        }

        /* renamed from: a */
        private void m4689a(C1146d dVar, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            dVar.f3125a.set(matrix);
            dVar.f3125a.preConcat(dVar.f3134j);
            canvas.save();
            for (int i3 = 0; i3 < dVar.f3126b.size(); i3++) {
                C1147e eVar = dVar.f3126b.get(i3);
                if (eVar instanceof C1146d) {
                    m4689a((C1146d) eVar, dVar.f3125a, canvas, i, i2, colorFilter);
                } else if (eVar instanceof C1148f) {
                    m4690a(dVar, (C1148f) eVar, canvas, i, i2, colorFilter);
                }
            }
            canvas.restore();
        }

        public float getAlpha() {
            return ((float) getRootAlpha()) / 255.0f;
        }

        public int getRootAlpha() {
            return this.f3155m;
        }

        public void setAlpha(float f) {
            setRootAlpha((int) (f * 255.0f));
        }

        public void setRootAlpha(int i) {
            this.f3155m = i;
        }

        /* renamed from: a */
        public void mo6108a(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            m4689a(this.f3150h, f3142q, canvas, i, i2, colorFilter);
        }

        public C1149g(C1149g gVar) {
            this.f3145c = new Matrix();
            this.f3151i = 0.0f;
            this.f3152j = 0.0f;
            this.f3153k = 0.0f;
            this.f3154l = 0.0f;
            this.f3155m = 255;
            this.f3156n = null;
            this.f3157o = null;
            C3191a<String, Object> aVar = new C3191a<>();
            this.f3158p = aVar;
            this.f3150h = new C1146d(gVar.f3150h, aVar);
            this.f3143a = new Path(gVar.f3143a);
            this.f3144b = new Path(gVar.f3144b);
            this.f3151i = gVar.f3151i;
            this.f3152j = gVar.f3152j;
            this.f3153k = gVar.f3153k;
            this.f3154l = gVar.f3154l;
            this.f3149g = gVar.f3149g;
            this.f3155m = gVar.f3155m;
            this.f3156n = gVar.f3156n;
            String str = gVar.f3156n;
            if (str != null) {
                this.f3158p.put(str, this);
            }
            this.f3157o = gVar.f3157o;
        }

        /* renamed from: a */
        private void m4690a(C1146d dVar, C1148f fVar, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            float f = ((float) i) / this.f3153k;
            float f2 = ((float) i2) / this.f3154l;
            float min = Math.min(f, f2);
            Matrix matrix = dVar.f3125a;
            this.f3145c.set(matrix);
            this.f3145c.postScale(f, f2);
            float a = m4688a(matrix);
            if (a != 0.0f) {
                fVar.mo6104a(this.f3143a);
                Path path = this.f3143a;
                this.f3144b.reset();
                if (fVar.mo6067b()) {
                    this.f3144b.setFillType(fVar.f3140c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                    this.f3144b.addPath(path, this.f3145c);
                    canvas.clipPath(this.f3144b);
                    return;
                }
                C1145c cVar = (C1145c) fVar;
                if (!(cVar.f3119k == 0.0f && cVar.f3120l == 1.0f)) {
                    float f3 = cVar.f3119k;
                    float f4 = cVar.f3121m;
                    float f5 = (f3 + f4) % 1.0f;
                    float f6 = (cVar.f3120l + f4) % 1.0f;
                    if (this.f3148f == null) {
                        this.f3148f = new PathMeasure();
                    }
                    this.f3148f.setPath(this.f3143a, false);
                    float length = this.f3148f.getLength();
                    float f7 = f5 * length;
                    float f8 = f6 * length;
                    path.reset();
                    if (f7 > f8) {
                        this.f3148f.getSegment(f7, length, path, true);
                        this.f3148f.getSegment(0.0f, f8, path, true);
                    } else {
                        this.f3148f.getSegment(f7, f8, path, true);
                    }
                    path.rLineTo(0.0f, 0.0f);
                }
                this.f3144b.addPath(path, this.f3145c);
                if (cVar.f3116h.mo4029e()) {
                    C0771b bVar = cVar.f3116h;
                    if (this.f3147e == null) {
                        Paint paint = new Paint(1);
                        this.f3147e = paint;
                        paint.setStyle(Paint.Style.FILL);
                    }
                    Paint paint2 = this.f3147e;
                    if (bVar.mo4027c()) {
                        Shader b = bVar.mo4026b();
                        b.setLocalMatrix(this.f3145c);
                        paint2.setShader(b);
                        paint2.setAlpha(Math.round(cVar.f3118j * 255.0f));
                    } else {
                        paint2.setShader((Shader) null);
                        paint2.setAlpha(255);
                        paint2.setColor(C1142i.m4660a(bVar.mo4023a(), cVar.f3118j));
                    }
                    paint2.setColorFilter(colorFilter);
                    this.f3144b.setFillType(cVar.f3140c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                    canvas.drawPath(this.f3144b, paint2);
                }
                if (cVar.f3114f.mo4029e()) {
                    C0771b bVar2 = cVar.f3114f;
                    if (this.f3146d == null) {
                        Paint paint3 = new Paint(1);
                        this.f3146d = paint3;
                        paint3.setStyle(Paint.Style.STROKE);
                    }
                    Paint paint4 = this.f3146d;
                    Paint.Join join = cVar.f3123o;
                    if (join != null) {
                        paint4.setStrokeJoin(join);
                    }
                    Paint.Cap cap = cVar.f3122n;
                    if (cap != null) {
                        paint4.setStrokeCap(cap);
                    }
                    paint4.setStrokeMiter(cVar.f3124p);
                    if (bVar2.mo4027c()) {
                        Shader b2 = bVar2.mo4026b();
                        b2.setLocalMatrix(this.f3145c);
                        paint4.setShader(b2);
                        paint4.setAlpha(Math.round(cVar.f3117i * 255.0f));
                    } else {
                        paint4.setShader((Shader) null);
                        paint4.setAlpha(255);
                        paint4.setColor(C1142i.m4660a(bVar2.mo4023a(), cVar.f3117i));
                    }
                    paint4.setColorFilter(colorFilter);
                    paint4.setStrokeWidth(cVar.f3115g * min * a);
                    canvas.drawPath(this.f3144b, paint4);
                }
            }
        }

        /* renamed from: a */
        private float m4688a(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float a = m4687a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max((float) Math.hypot((double) fArr[0], (double) fArr[1]), (float) Math.hypot((double) fArr[2], (double) fArr[3]));
            if (max > 0.0f) {
                return Math.abs(a) / max;
            }
            return 0.0f;
        }

        /* renamed from: a */
        public boolean mo6109a() {
            if (this.f3157o == null) {
                this.f3157o = Boolean.valueOf(this.f3150h.mo6069a());
            }
            return this.f3157o.booleanValue();
        }

        /* renamed from: a */
        public boolean mo6110a(int[] iArr) {
            return this.f3150h.mo6070a(iArr);
        }
    }

    /* renamed from: a */
    static int m4660a(int i, float f) {
        return (i & 16777215) | (((int) (((float) Color.alpha(i)) * f)) << 24);
    }

    /* renamed from: a */
    private static PorterDuff.Mode m4661a(int i, PorterDuff.Mode mode) {
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    /* renamed from: a */
    private void m4664a(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException {
        C1150h hVar = this.f3105b;
        C1149g gVar = hVar.f3160b;
        hVar.f3162d = m4661a(C0784g.m2477b(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList a = C0784g.m2470a(typedArray, xmlPullParser, theme, "tint", 1);
        if (a != null) {
            hVar.f3161c = a;
        }
        hVar.f3163e = C0784g.m2475a(typedArray, xmlPullParser, "autoMirrored", 5, hVar.f3163e);
        gVar.f3153k = C0784g.m2468a(typedArray, xmlPullParser, "viewportWidth", 7, gVar.f3153k);
        float a2 = C0784g.m2468a(typedArray, xmlPullParser, "viewportHeight", 8, gVar.f3154l);
        gVar.f3154l = a2;
        if (gVar.f3153k <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (a2 > 0.0f) {
            gVar.f3151i = typedArray.getDimension(3, gVar.f3151i);
            float dimension = typedArray.getDimension(2, gVar.f3152j);
            gVar.f3152j = dimension;
            if (gVar.f3151i <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (dimension > 0.0f) {
                gVar.setAlpha(C0784g.m2468a(typedArray, xmlPullParser, "alpha", 4, gVar.getAlpha()));
                String string = typedArray.getString(0);
                if (string != null) {
                    gVar.f3156n = string;
                    gVar.f3158p.put(string, gVar);
                }
            } else {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
            }
        } else {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
    }

    /* renamed from: a */
    private void m4663a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        C1150h hVar = this.f3105b;
        C1149g gVar = hVar.f3160b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(gVar.f3150h);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                C1146d dVar = (C1146d) arrayDeque.peek();
                if ("path".equals(name)) {
                    C1145c cVar = new C1145c();
                    cVar.mo6068a(resources, attributeSet, theme, xmlPullParser);
                    dVar.f3126b.add(cVar);
                    if (cVar.getPathName() != null) {
                        gVar.f3158p.put(cVar.getPathName(), cVar);
                    }
                    z = false;
                    hVar.f3159a = cVar.f3141d | hVar.f3159a;
                } else if ("clip-path".equals(name)) {
                    C1144b bVar = new C1144b();
                    bVar.mo6066a(resources, attributeSet, theme, xmlPullParser);
                    dVar.f3126b.add(bVar);
                    if (bVar.getPathName() != null) {
                        gVar.f3158p.put(bVar.getPathName(), bVar);
                    }
                    hVar.f3159a = bVar.f3141d | hVar.f3159a;
                } else if ("group".equals(name)) {
                    C1146d dVar2 = new C1146d();
                    dVar2.mo6087a(resources, attributeSet, theme, xmlPullParser);
                    dVar.f3126b.add(dVar2);
                    arrayDeque.push(dVar2);
                    if (dVar2.getGroupName() != null) {
                        gVar.f3158p.put(dVar2.getGroupName(), dVar2);
                    }
                    hVar.f3159a = dVar2.f3135k | hVar.f3159a;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z) {
            throw new XmlPullParserException("no path defined");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6042a(boolean z) {
        this.f3109f = z;
    }

    /* renamed from: a */
    private boolean m4665a() {
        if (Build.VERSION.SDK_INT < 17 || !isAutoMirrored() || C0857a.m2814d(this) != 1) {
            return false;
        }
        return true;
    }
}
