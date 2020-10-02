package androidx.appcompat.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import androidx.appcompat.p010c.C0453a;
import androidx.core.graphics.drawable.C0857a;
import androidx.core.p020f.C0839t;
import androidx.core.widget.C0879i;

public class SwitchCompat extends CompoundButton {

    /* renamed from: N */
    private static final Property<SwitchCompat, Float> f1250N = new C0562a(Float.class, "thumbPos");

    /* renamed from: O */
    private static final int[] f1251O = {16842912};

    /* renamed from: A */
    private int f1252A;

    /* renamed from: B */
    private int f1253B;

    /* renamed from: C */
    private int f1254C;

    /* renamed from: D */
    private int f1255D;

    /* renamed from: E */
    private int f1256E;

    /* renamed from: F */
    private final TextPaint f1257F = new TextPaint(1);

    /* renamed from: G */
    private ColorStateList f1258G;

    /* renamed from: H */
    private Layout f1259H;

    /* renamed from: I */
    private Layout f1260I;

    /* renamed from: J */
    private TransformationMethod f1261J;

    /* renamed from: K */
    ObjectAnimator f1262K;

    /* renamed from: L */
    private final C0613m f1263L;

    /* renamed from: M */
    private final Rect f1264M = new Rect();

    /* renamed from: a */
    private Drawable f1265a;

    /* renamed from: b */
    private ColorStateList f1266b = null;

    /* renamed from: c */
    private PorterDuff.Mode f1267c = null;

    /* renamed from: d */
    private boolean f1268d = false;

    /* renamed from: e */
    private boolean f1269e = false;

    /* renamed from: f */
    private Drawable f1270f;

    /* renamed from: g */
    private ColorStateList f1271g = null;

    /* renamed from: h */
    private PorterDuff.Mode f1272h = null;

    /* renamed from: i */
    private boolean f1273i = false;

    /* renamed from: j */
    private boolean f1274j = false;

    /* renamed from: k */
    private int f1275k;

    /* renamed from: l */
    private int f1276l;

    /* renamed from: m */
    private int f1277m;

    /* renamed from: n */
    private boolean f1278n;

    /* renamed from: o */
    private CharSequence f1279o;

    /* renamed from: p */
    private CharSequence f1280p;

    /* renamed from: q */
    private boolean f1281q;

    /* renamed from: r */
    private int f1282r;

    /* renamed from: s */
    private int f1283s;

    /* renamed from: t */
    private float f1284t;

    /* renamed from: u */
    private float f1285u;

    /* renamed from: v */
    private VelocityTracker f1286v = VelocityTracker.obtain();

    /* renamed from: w */
    private int f1287w;

    /* renamed from: x */
    float f1288x;

    /* renamed from: y */
    private int f1289y;

    /* renamed from: z */
    private int f1290z;

    /* renamed from: androidx.appcompat.widget.SwitchCompat$a */
    static class C0562a extends Property<SwitchCompat, Float> {
        C0562a(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.f1288x);
        }

        /* renamed from: a */
        public void set(SwitchCompat switchCompat, Float f) {
            switchCompat.mo3260a(f.floatValue());
        }
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = getResources();
        this.f1257F.density = resources.getDisplayMetrics().density;
        C0598g0 a = C0598g0.m1610a(context, attributeSet, R$styleable.SwitchCompat, i, 0);
        Drawable b = a.mo3437b(R$styleable.SwitchCompat_android_thumb);
        this.f1265a = b;
        if (b != null) {
            b.setCallback(this);
        }
        Drawable b2 = a.mo3437b(R$styleable.SwitchCompat_track);
        this.f1270f = b2;
        if (b2 != null) {
            b2.setCallback(this);
        }
        this.f1279o = a.mo3443e(R$styleable.SwitchCompat_android_textOn);
        this.f1280p = a.mo3443e(R$styleable.SwitchCompat_android_textOff);
        this.f1281q = a.mo3435a(R$styleable.SwitchCompat_showText, true);
        this.f1275k = a.mo3438c(R$styleable.SwitchCompat_thumbTextPadding, 0);
        this.f1276l = a.mo3438c(R$styleable.SwitchCompat_switchMinWidth, 0);
        this.f1277m = a.mo3438c(R$styleable.SwitchCompat_switchPadding, 0);
        this.f1278n = a.mo3435a(R$styleable.SwitchCompat_splitTrack, false);
        ColorStateList a2 = a.mo3432a(R$styleable.SwitchCompat_thumbTint);
        if (a2 != null) {
            this.f1266b = a2;
            this.f1268d = true;
        }
        PorterDuff.Mode a3 = C0621q.m1806a(a.mo3440d(R$styleable.SwitchCompat_thumbTintMode, -1), (PorterDuff.Mode) null);
        if (this.f1267c != a3) {
            this.f1267c = a3;
            this.f1269e = true;
        }
        if (this.f1268d || this.f1269e) {
            m1402a();
        }
        ColorStateList a4 = a.mo3432a(R$styleable.SwitchCompat_trackTint);
        if (a4 != null) {
            this.f1271g = a4;
            this.f1273i = true;
        }
        PorterDuff.Mode a5 = C0621q.m1806a(a.mo3440d(R$styleable.SwitchCompat_trackTintMode, -1), (PorterDuff.Mode) null);
        if (this.f1272h != a5) {
            this.f1272h = a5;
            this.f1274j = true;
        }
        if (this.f1273i || this.f1274j) {
            m1407b();
        }
        int g = a.mo3446g(R$styleable.SwitchCompat_switchTextAppearance, 0);
        if (g != 0) {
            mo3261a(context, g);
        }
        C0613m mVar = new C0613m(this);
        this.f1263L = mVar;
        mVar.mo3519a(attributeSet, i);
        a.mo3434a();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f1283s = viewConfiguration.getScaledTouchSlop();
        this.f1287w = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    /* renamed from: a */
    private static float m1400a(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    /* renamed from: b */
    private void m1407b() {
        if (this.f1270f == null) {
            return;
        }
        if (this.f1273i || this.f1274j) {
            Drawable mutate = C0857a.m2818h(this.f1270f).mutate();
            this.f1270f = mutate;
            if (this.f1273i) {
                C0857a.m2804a(mutate, this.f1271g);
            }
            if (this.f1274j) {
                C0857a.m2807a(this.f1270f, this.f1272h);
            }
            if (this.f1270f.isStateful()) {
                this.f1270f.setState(getDrawableState());
            }
        }
    }

    /* renamed from: c */
    private void m1409c() {
        ObjectAnimator objectAnimator = this.f1262K;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    /* renamed from: d */
    private boolean m1410d() {
        return this.f1288x > 0.5f;
    }

    /* renamed from: e */
    private int m1411e() {
        float f;
        if (C0616m0.m1739a(this)) {
            f = 1.0f - this.f1288x;
        } else {
            f = this.f1288x;
        }
        return (int) ((f * ((float) m1412f())) + 0.5f);
    }

    /* renamed from: f */
    private int m1412f() {
        Rect rect;
        Drawable drawable = this.f1270f;
        if (drawable == null) {
            return 0;
        }
        Rect rect2 = this.f1264M;
        drawable.getPadding(rect2);
        Drawable drawable2 = this.f1265a;
        if (drawable2 != null) {
            rect = C0621q.m1810d(drawable2);
        } else {
            rect = C0621q.f1539c;
        }
        return ((((this.f1289y - this.f1252A) - rect2.left) - rect2.right) - rect.left) - rect.right;
    }

    /* renamed from: a */
    public void mo3261a(Context context, int i) {
        C0598g0 a = C0598g0.m1608a(context, i, R$styleable.TextAppearance);
        ColorStateList a2 = a.mo3432a(R$styleable.TextAppearance_android_textColor);
        if (a2 != null) {
            this.f1258G = a2;
        } else {
            this.f1258G = getTextColors();
        }
        int c = a.mo3438c(R$styleable.TextAppearance_android_textSize, 0);
        if (c != 0) {
            float f = (float) c;
            if (f != this.f1257F.getTextSize()) {
                this.f1257F.setTextSize(f);
                requestLayout();
            }
        }
        m1403a(a.mo3440d(R$styleable.TextAppearance_android_typeface, -1), a.mo3440d(R$styleable.TextAppearance_android_textStyle, -1));
        if (a.mo3435a(R$styleable.TextAppearance_textAllCaps, false)) {
            this.f1261J = new C0453a(getContext());
        } else {
            this.f1261J = null;
        }
        a.mo3434a();
    }

    public void draw(Canvas canvas) {
        Rect rect;
        int i;
        int i2;
        Rect rect2 = this.f1264M;
        int i3 = this.f1253B;
        int i4 = this.f1254C;
        int i5 = this.f1255D;
        int i6 = this.f1256E;
        int e = m1411e() + i3;
        Drawable drawable = this.f1265a;
        if (drawable != null) {
            rect = C0621q.m1810d(drawable);
        } else {
            rect = C0621q.f1539c;
        }
        Drawable drawable2 = this.f1270f;
        if (drawable2 != null) {
            drawable2.getPadding(rect2);
            int i7 = rect2.left;
            e += i7;
            if (rect != null) {
                int i8 = rect.left;
                if (i8 > i7) {
                    i3 += i8 - i7;
                }
                int i9 = rect.top;
                int i10 = rect2.top;
                i = i9 > i10 ? (i9 - i10) + i4 : i4;
                int i11 = rect.right;
                int i12 = rect2.right;
                if (i11 > i12) {
                    i5 -= i11 - i12;
                }
                int i13 = rect.bottom;
                int i14 = rect2.bottom;
                if (i13 > i14) {
                    i2 = i6 - (i13 - i14);
                    this.f1270f.setBounds(i3, i, i5, i2);
                }
            } else {
                i = i4;
            }
            i2 = i6;
            this.f1270f.setBounds(i3, i, i5, i2);
        }
        Drawable drawable3 = this.f1265a;
        if (drawable3 != null) {
            drawable3.getPadding(rect2);
            int i15 = e - rect2.left;
            int i16 = e + this.f1252A + rect2.right;
            this.f1265a.setBounds(i15, i4, i16, i6);
            Drawable background = getBackground();
            if (background != null) {
                C0857a.m2803a(background, i15, i4, i16, i6);
            }
        }
        super.draw(canvas);
    }

    public void drawableHotspotChanged(float f, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(f, f2);
        }
        Drawable drawable = this.f1265a;
        if (drawable != null) {
            C0857a.m2802a(drawable, f, f2);
        }
        Drawable drawable2 = this.f1270f;
        if (drawable2 != null) {
            C0857a.m2802a(drawable2, f, f2);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f1265a;
        boolean z = false;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.f1270f;
        if (drawable2 != null && drawable2.isStateful()) {
            z |= drawable2.setState(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    public int getCompoundPaddingLeft() {
        if (!C0616m0.m1739a(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.f1289y;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.f1277m : compoundPaddingLeft;
    }

    public int getCompoundPaddingRight() {
        if (C0616m0.m1739a(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.f1289y;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.f1277m : compoundPaddingRight;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f1265a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f1270f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.f1262K;
        if (objectAnimator != null && objectAnimator.isStarted()) {
            this.f1262K.end();
            this.f1262K = null;
        }
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            CompoundButton.mergeDrawableStates(onCreateDrawableState, f1251O);
        }
        return onCreateDrawableState;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        Rect rect = this.f1264M;
        Drawable drawable = this.f1270f;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i2 = this.f1254C;
        int i3 = this.f1256E;
        int i4 = i2 + rect.top;
        int i5 = i3 - rect.bottom;
        Drawable drawable2 = this.f1265a;
        if (drawable != null) {
            if (!this.f1278n || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect d = C0621q.m1810d(drawable2);
                drawable2.copyBounds(rect);
                rect.left += d.left;
                rect.right -= d.right;
                int save = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        int save2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = m1410d() ? this.f1259H : this.f1260I;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.f1258G;
            if (colorStateList != null) {
                this.f1257F.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.f1257F.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                i = bounds.left + bounds.right;
            } else {
                i = getWidth();
            }
            canvas.translate((float) ((i / 2) - (layout.getWidth() / 2)), (float) (((i4 + i5) / 2) - (layout.getHeight() / 2)));
            layout.draw(canvas);
        }
        canvas.restoreToCount(save2);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        CharSequence charSequence = isChecked() ? this.f1279o : this.f1280p;
        if (!TextUtils.isEmpty(charSequence)) {
            CharSequence text = accessibilityNodeInfo.getText();
            if (TextUtils.isEmpty(text)) {
                accessibilityNodeInfo.setText(charSequence);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(text);
            sb.append(' ');
            sb.append(charSequence);
            accessibilityNodeInfo.setText(sb);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        super.onLayout(z, i, i2, i3, i4);
        int i11 = 0;
        if (this.f1265a != null) {
            Rect rect = this.f1264M;
            Drawable drawable = this.f1270f;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect d = C0621q.m1810d(this.f1265a);
            i5 = Math.max(0, d.left - rect.left);
            i11 = Math.max(0, d.right - rect.right);
        } else {
            i5 = 0;
        }
        if (C0616m0.m1739a(this)) {
            i7 = getPaddingLeft() + i5;
            i6 = ((this.f1289y + i7) - i5) - i11;
        } else {
            i6 = (getWidth() - getPaddingRight()) - i11;
            i7 = (i6 - this.f1289y) + i5 + i11;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            i10 = this.f1290z;
            i9 = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (i10 / 2);
        } else if (gravity != 80) {
            i9 = getPaddingTop();
            i10 = this.f1290z;
        } else {
            i8 = getHeight() - getPaddingBottom();
            i9 = i8 - this.f1290z;
            this.f1253B = i7;
            this.f1254C = i9;
            this.f1256E = i8;
            this.f1255D = i6;
        }
        i8 = i10 + i9;
        this.f1253B = i7;
        this.f1254C = i9;
        this.f1256E = i8;
        this.f1255D = i6;
    }

    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        if (this.f1281q) {
            if (this.f1259H == null) {
                this.f1259H = m1401a(this.f1279o);
            }
            if (this.f1260I == null) {
                this.f1260I = m1401a(this.f1280p);
            }
        }
        Rect rect = this.f1264M;
        Drawable drawable = this.f1265a;
        int i5 = 0;
        if (drawable != null) {
            drawable.getPadding(rect);
            i4 = (this.f1265a.getIntrinsicWidth() - rect.left) - rect.right;
            i3 = this.f1265a.getIntrinsicHeight();
        } else {
            i4 = 0;
            i3 = 0;
        }
        this.f1252A = Math.max(this.f1281q ? Math.max(this.f1259H.getWidth(), this.f1260I.getWidth()) + (this.f1275k * 2) : 0, i4);
        Drawable drawable2 = this.f1270f;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            i5 = this.f1270f.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i6 = rect.left;
        int i7 = rect.right;
        Drawable drawable3 = this.f1265a;
        if (drawable3 != null) {
            Rect d = C0621q.m1810d(drawable3);
            i6 = Math.max(i6, d.left);
            i7 = Math.max(i7, d.right);
        }
        int max = Math.max(this.f1276l, (this.f1252A * 2) + i6 + i7);
        int max2 = Math.max(i5, i3);
        this.f1289y = max;
        this.f1290z = max2;
        super.onMeasure(i, i2);
        if (getMeasuredHeight() < max2) {
            setMeasuredDimension(getMeasuredWidthAndState(), max2);
        }
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.f1279o : this.f1280p;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        if (r0 != 3) goto L_0x00b9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            android.view.VelocityTracker r0 = r6.f1286v
            r0.addMovement(r7)
            int r0 = r7.getActionMasked()
            r1 = 1
            if (r0 == 0) goto L_0x009f
            r2 = 2
            if (r0 == r1) goto L_0x008b
            if (r0 == r2) goto L_0x0016
            r3 = 3
            if (r0 == r3) goto L_0x008b
            goto L_0x00b9
        L_0x0016:
            int r0 = r6.f1282r
            if (r0 == r1) goto L_0x0057
            if (r0 == r2) goto L_0x001e
            goto L_0x00b9
        L_0x001e:
            float r7 = r7.getX()
            int r0 = r6.m1412f()
            float r2 = r6.f1284t
            float r2 = r7 - r2
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            if (r0 == 0) goto L_0x0032
            float r0 = (float) r0
            float r2 = r2 / r0
            goto L_0x003d
        L_0x0032:
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0039
            r2 = 1065353216(0x3f800000, float:1.0)
            goto L_0x003d
        L_0x0039:
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x003d:
            boolean r0 = androidx.appcompat.widget.C0616m0.m1739a(r6)
            if (r0 == 0) goto L_0x0044
            float r2 = -r2
        L_0x0044:
            float r0 = r6.f1288x
            float r0 = r0 + r2
            float r0 = m1400a(r0, r4, r3)
            float r2 = r6.f1288x
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x0056
            r6.f1284t = r7
            r6.mo3260a((float) r0)
        L_0x0056:
            return r1
        L_0x0057:
            float r0 = r7.getX()
            float r3 = r7.getY()
            float r4 = r6.f1284t
            float r4 = r0 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.f1283s
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L_0x007d
            float r4 = r6.f1285u
            float r4 = r3 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.f1283s
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x00b9
        L_0x007d:
            r6.f1282r = r2
            android.view.ViewParent r7 = r6.getParent()
            r7.requestDisallowInterceptTouchEvent(r1)
            r6.f1284t = r0
            r6.f1285u = r3
            return r1
        L_0x008b:
            int r0 = r6.f1282r
            if (r0 != r2) goto L_0x0096
            r6.m1408b(r7)
            super.onTouchEvent(r7)
            return r1
        L_0x0096:
            r0 = 0
            r6.f1282r = r0
            android.view.VelocityTracker r0 = r6.f1286v
            r0.clear()
            goto L_0x00b9
        L_0x009f:
            float r0 = r7.getX()
            float r2 = r7.getY()
            boolean r3 = r6.isEnabled()
            if (r3 == 0) goto L_0x00b9
            boolean r3 = r6.m1406a((float) r0, (float) r2)
            if (r3 == 0) goto L_0x00b9
            r6.f1282r = r1
            r6.f1284t = r0
            r6.f1285u = r2
        L_0x00b9:
            boolean r7 = super.onTouchEvent(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setChecked(boolean z) {
        super.setChecked(z);
        boolean isChecked = isChecked();
        if (getWindowToken() == null || !C0839t.m2736y(this)) {
            m1409c();
            mo3260a(isChecked ? 1.0f : 0.0f);
            return;
        }
        m1405a(isChecked);
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(C0879i.m2936a((TextView) this, callback));
    }

    public void toggle() {
        setChecked(!isChecked());
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f1265a || drawable == this.f1270f;
    }

    /* renamed from: b */
    private void m1408b(MotionEvent motionEvent) {
        this.f1282r = 0;
        boolean z = true;
        boolean z2 = motionEvent.getAction() == 1 && isEnabled();
        boolean isChecked = isChecked();
        if (z2) {
            this.f1286v.computeCurrentVelocity(1000);
            float xVelocity = this.f1286v.getXVelocity();
            if (Math.abs(xVelocity) <= ((float) this.f1287w)) {
                z = m1410d();
            } else if (!C0616m0.m1739a(this) ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
                z = false;
            }
        } else {
            z = isChecked;
        }
        if (z != isChecked) {
            playSoundEffect(0);
        }
        setChecked(z);
        m1404a(motionEvent);
    }

    /* renamed from: a */
    private void m1403a(int i, int i2) {
        Typeface typeface;
        if (i == 1) {
            typeface = Typeface.SANS_SERIF;
        } else if (i != 2) {
            typeface = i != 3 ? null : Typeface.MONOSPACE;
        } else {
            typeface = Typeface.SERIF;
        }
        mo3263a(typeface, i2);
    }

    /* renamed from: a */
    public void mo3263a(Typeface typeface, int i) {
        Typeface typeface2;
        float f = 0.0f;
        boolean z = false;
        if (i > 0) {
            if (typeface == null) {
                typeface2 = Typeface.defaultFromStyle(i);
            } else {
                typeface2 = Typeface.create(typeface, i);
            }
            mo3262a(typeface2);
            int style = ((typeface2 != null ? typeface2.getStyle() : 0) ^ -1) & i;
            TextPaint textPaint = this.f1257F;
            if ((style & 1) != 0) {
                z = true;
            }
            textPaint.setFakeBoldText(z);
            TextPaint textPaint2 = this.f1257F;
            if ((style & 2) != 0) {
                f = -0.25f;
            }
            textPaint2.setTextSkewX(f);
            return;
        }
        this.f1257F.setFakeBoldText(false);
        this.f1257F.setTextSkewX(0.0f);
        mo3262a(typeface);
    }

    /* renamed from: a */
    public void mo3262a(Typeface typeface) {
        if ((this.f1257F.getTypeface() != null && !this.f1257F.getTypeface().equals(typeface)) || (this.f1257F.getTypeface() == null && typeface != null)) {
            this.f1257F.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    /* renamed from: a */
    private void m1402a() {
        if (this.f1265a == null) {
            return;
        }
        if (this.f1268d || this.f1269e) {
            Drawable mutate = C0857a.m2818h(this.f1265a).mutate();
            this.f1265a = mutate;
            if (this.f1268d) {
                C0857a.m2804a(mutate, this.f1266b);
            }
            if (this.f1269e) {
                C0857a.m2807a(this.f1265a, this.f1267c);
            }
            if (this.f1265a.isStateful()) {
                this.f1265a.setState(getDrawableState());
            }
        }
    }

    /* renamed from: a */
    private Layout m1401a(CharSequence charSequence) {
        TransformationMethod transformationMethod = this.f1261J;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, this);
        }
        CharSequence charSequence2 = charSequence;
        TextPaint textPaint = this.f1257F;
        return new StaticLayout(charSequence2, textPaint, charSequence2 != null ? (int) Math.ceil((double) Layout.getDesiredWidth(charSequence2, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    /* renamed from: a */
    private boolean m1406a(float f, float f2) {
        if (this.f1265a == null) {
            return false;
        }
        int e = m1411e();
        this.f1265a.getPadding(this.f1264M);
        int i = this.f1254C;
        int i2 = this.f1283s;
        int i3 = i - i2;
        int i4 = (this.f1253B + e) - i2;
        Rect rect = this.f1264M;
        int i5 = this.f1252A + i4 + rect.left + rect.right + i2;
        int i6 = this.f1256E + i2;
        if (f <= ((float) i4) || f >= ((float) i5) || f2 <= ((float) i3) || f2 >= ((float) i6)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private void m1404a(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        super.onTouchEvent(obtain);
        obtain.recycle();
    }

    /* renamed from: a */
    private void m1405a(boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f1250N, new float[]{z ? 1.0f : 0.0f});
        this.f1262K = ofFloat;
        ofFloat.setDuration(250);
        if (Build.VERSION.SDK_INT >= 18) {
            this.f1262K.setAutoCancel(true);
        }
        this.f1262K.start();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3260a(float f) {
        this.f1288x = f;
        invalidate();
    }
}
