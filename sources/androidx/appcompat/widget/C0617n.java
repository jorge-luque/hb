package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: androidx.appcompat.widget.n */
/* compiled from: AppCompatTextViewAutoSizeHelper */
class C0617n {

    /* renamed from: k */
    private static final RectF f1524k = new RectF();

    /* renamed from: l */
    private static ConcurrentHashMap<String, Method> f1525l = new ConcurrentHashMap<>();

    /* renamed from: m */
    private static ConcurrentHashMap<String, Field> f1526m = new ConcurrentHashMap<>();

    /* renamed from: a */
    private int f1527a = 0;

    /* renamed from: b */
    private boolean f1528b = false;

    /* renamed from: c */
    private float f1529c = -1.0f;

    /* renamed from: d */
    private float f1530d = -1.0f;

    /* renamed from: e */
    private float f1531e = -1.0f;

    /* renamed from: f */
    private int[] f1532f = new int[0];

    /* renamed from: g */
    private boolean f1533g = false;

    /* renamed from: h */
    private TextPaint f1534h;

    /* renamed from: i */
    private final TextView f1535i;

    /* renamed from: j */
    private final Context f1536j;

    C0617n(TextView textView) {
        this.f1535i = textView;
        this.f1536j = textView.getContext();
    }

    /* renamed from: h */
    private void m1754h() {
        this.f1527a = 0;
        this.f1530d = -1.0f;
        this.f1531e = -1.0f;
        this.f1529c = -1.0f;
        this.f1532f = new int[0];
        this.f1528b = false;
    }

    /* renamed from: i */
    private boolean m1755i() {
        if (!m1757k() || this.f1527a != 1) {
            this.f1528b = false;
        } else {
            if (!this.f1533g || this.f1532f.length == 0) {
                int floor = ((int) Math.floor((double) ((this.f1531e - this.f1530d) / this.f1529c))) + 1;
                int[] iArr = new int[floor];
                for (int i = 0; i < floor; i++) {
                    iArr[i] = Math.round(this.f1530d + (((float) i) * this.f1529c));
                }
                this.f1532f = m1749a(iArr);
            }
            this.f1528b = true;
        }
        return this.f1528b;
    }

    /* renamed from: j */
    private boolean m1756j() {
        int length = this.f1532f.length;
        boolean z = length > 0;
        this.f1533g = z;
        if (z) {
            this.f1527a = 1;
            int[] iArr = this.f1532f;
            this.f1530d = (float) iArr[0];
            this.f1531e = (float) iArr[length - 1];
            this.f1529c = -1.0f;
        }
        return this.f1533g;
    }

    /* renamed from: k */
    private boolean m1757k() {
        return !(this.f1535i instanceof AppCompatEditText);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3540a(AttributeSet attributeSet, int i) {
        int resourceId;
        TypedArray obtainStyledAttributes = this.f1536j.obtainStyledAttributes(attributeSet, R$styleable.AppCompatTextView, i, 0);
        if (obtainStyledAttributes.hasValue(R$styleable.AppCompatTextView_autoSizeTextType)) {
            this.f1527a = obtainStyledAttributes.getInt(R$styleable.AppCompatTextView_autoSizeTextType, 0);
        }
        float dimension = obtainStyledAttributes.hasValue(R$styleable.AppCompatTextView_autoSizeStepGranularity) ? obtainStyledAttributes.getDimension(R$styleable.AppCompatTextView_autoSizeStepGranularity, -1.0f) : -1.0f;
        float dimension2 = obtainStyledAttributes.hasValue(R$styleable.AppCompatTextView_autoSizeMinTextSize) ? obtainStyledAttributes.getDimension(R$styleable.AppCompatTextView_autoSizeMinTextSize, -1.0f) : -1.0f;
        float dimension3 = obtainStyledAttributes.hasValue(R$styleable.AppCompatTextView_autoSizeMaxTextSize) ? obtainStyledAttributes.getDimension(R$styleable.AppCompatTextView_autoSizeMaxTextSize, -1.0f) : -1.0f;
        if (obtainStyledAttributes.hasValue(R$styleable.AppCompatTextView_autoSizePresetSizes) && (resourceId = obtainStyledAttributes.getResourceId(R$styleable.AppCompatTextView_autoSizePresetSizes, 0)) > 0) {
            TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            m1747a(obtainTypedArray);
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes.recycle();
        if (!m1757k()) {
            this.f1527a = 0;
        } else if (this.f1527a == 1) {
            if (!this.f1533g) {
                DisplayMetrics displayMetrics = this.f1536j.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                m1746a(dimension2, dimension3, dimension);
            }
            m1755i();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo3543b(int i) {
        if (!m1757k()) {
            return;
        }
        if (i == 0) {
            m1754h();
        } else if (i == 1) {
            DisplayMetrics displayMetrics = this.f1536j.getResources().getDisplayMetrics();
            m1746a(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (m1755i()) {
                mo3536a();
            }
        } else {
            throw new IllegalArgumentException("Unknown auto-size text type: " + i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo3544c() {
        return Math.round(this.f1530d);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo3545d() {
        return Math.round(this.f1529c);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public int[] mo3546e() {
        return this.f1532f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public int mo3547f() {
        return this.f1527a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo3548g() {
        return m1757k() && this.f1527a != 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo3542b() {
        return Math.round(this.f1531e);
    }

    /* renamed from: b */
    private StaticLayout m1751b(CharSequence charSequence, Layout.Alignment alignment, int i, int i2) {
        TextDirectionHeuristic textDirectionHeuristic;
        StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), this.f1534h, i);
        StaticLayout.Builder hyphenationFrequency = obtain.setAlignment(alignment).setLineSpacing(this.f1535i.getLineSpacingExtra(), this.f1535i.getLineSpacingMultiplier()).setIncludePad(this.f1535i.getIncludeFontPadding()).setBreakStrategy(this.f1535i.getBreakStrategy()).setHyphenationFrequency(this.f1535i.getHyphenationFrequency());
        if (i2 == -1) {
            i2 = Integer.MAX_VALUE;
        }
        hyphenationFrequency.setMaxLines(i2);
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                textDirectionHeuristic = this.f1535i.getTextDirectionHeuristic();
            } else {
                textDirectionHeuristic = (TextDirectionHeuristic) m1752b((Object) this.f1535i, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR);
            }
            obtain.setTextDirection(textDirectionHeuristic);
        } catch (ClassCastException unused) {
            Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
        }
        return obtain.build();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3539a(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        if (m1757k()) {
            DisplayMetrics displayMetrics = this.f1536j.getResources().getDisplayMetrics();
            m1746a(TypedValue.applyDimension(i4, (float) i, displayMetrics), TypedValue.applyDimension(i4, (float) i2, displayMetrics), TypedValue.applyDimension(i4, (float) i3, displayMetrics));
            if (m1755i()) {
                mo3536a();
            }
        }
    }

    /* renamed from: b */
    private StaticLayout m1750b(CharSequence charSequence, Layout.Alignment alignment, int i) {
        return new StaticLayout(charSequence, this.f1534h, i, alignment, this.f1535i.getLineSpacingMultiplier(), this.f1535i.getLineSpacingExtra(), this.f1535i.getIncludeFontPadding());
    }

    /* renamed from: b */
    private static <T> T m1752b(Object obj, String str, T t) {
        try {
            return m1753b(str).invoke(obj, new Object[0]);
        } catch (Exception e) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e);
            return t;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3541a(int[] iArr, int i) throws IllegalArgumentException {
        if (m1757k()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f1536j.getResources().getDisplayMetrics();
                    for (int i2 = 0; i2 < length; i2++) {
                        iArr2[i2] = Math.round(TypedValue.applyDimension(i, (float) iArr[i2], displayMetrics));
                    }
                }
                this.f1532f = m1749a(iArr2);
                if (!m1756j()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f1533g = false;
            }
            if (m1755i()) {
                mo3536a();
            }
        }
    }

    /* renamed from: b */
    private static Method m1753b(String str) {
        try {
            Method method = f1525l.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                method.setAccessible(true);
                f1525l.put(str, method);
            }
            return method;
        } catch (Exception e) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e);
            return null;
        }
    }

    /* renamed from: a */
    private void m1747a(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                iArr[i] = typedArray.getDimensionPixelSize(i, -1);
            }
            this.f1532f = m1749a(iArr);
            m1756j();
        }
    }

    /* renamed from: a */
    private int[] m1749a(int[] iArr) {
        if (r0 == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            if (i > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i)) < 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        if (r0 == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr2[i2] = ((Integer) arrayList.get(i2)).intValue();
        }
        return iArr2;
    }

    /* renamed from: a */
    private void m1746a(float f, float f2, float f3) throws IllegalArgumentException {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f + "px) is less or equal to (0px)");
        } else if (f2 <= f) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f2 + "px) is less or equal to minimum auto-size text size (" + f + "px)");
        } else if (f3 > 0.0f) {
            this.f1527a = 1;
            this.f1530d = f;
            this.f1531e = f2;
            this.f1529c = f3;
            this.f1533g = false;
        } else {
            throw new IllegalArgumentException("The auto-size step granularity (" + f3 + "px) is less or equal to (0px)");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3536a() {
        boolean z;
        int i;
        if (mo3548g()) {
            if (this.f1528b) {
                if (this.f1535i.getMeasuredHeight() > 0 && this.f1535i.getMeasuredWidth() > 0) {
                    if (Build.VERSION.SDK_INT >= 29) {
                        z = this.f1535i.isHorizontallyScrollable();
                    } else {
                        z = ((Boolean) m1752b((Object) this.f1535i, "getHorizontallyScrolling", false)).booleanValue();
                    }
                    if (z) {
                        i = 1048576;
                    } else {
                        i = (this.f1535i.getMeasuredWidth() - this.f1535i.getTotalPaddingLeft()) - this.f1535i.getTotalPaddingRight();
                    }
                    int height = (this.f1535i.getHeight() - this.f1535i.getCompoundPaddingBottom()) - this.f1535i.getCompoundPaddingTop();
                    if (i > 0 && height > 0) {
                        synchronized (f1524k) {
                            f1524k.setEmpty();
                            f1524k.right = (float) i;
                            f1524k.bottom = (float) height;
                            float a = (float) m1741a(f1524k);
                            if (a != this.f1535i.getTextSize()) {
                                mo3538a(0, a);
                            }
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            this.f1528b = true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3538a(int i, float f) {
        Resources resources;
        Context context = this.f1536j;
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        m1745a(TypedValue.applyDimension(i, f, resources.getDisplayMetrics()));
    }

    /* renamed from: a */
    private void m1745a(float f) {
        if (f != this.f1535i.getPaint().getTextSize()) {
            this.f1535i.getPaint().setTextSize(f);
            boolean isInLayout = Build.VERSION.SDK_INT >= 18 ? this.f1535i.isInLayout() : false;
            if (this.f1535i.getLayout() != null) {
                this.f1528b = false;
                try {
                    Method b = m1753b("nullLayouts");
                    if (b != null) {
                        b.invoke(this.f1535i, new Object[0]);
                    }
                } catch (Exception e) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e);
                }
                if (!isInLayout) {
                    this.f1535i.requestLayout();
                } else {
                    this.f1535i.forceLayout();
                }
                this.f1535i.invalidate();
            }
        }
    }

    /* renamed from: a */
    private int m1741a(RectF rectF) {
        int length = this.f1532f.length;
        if (length != 0) {
            int i = length - 1;
            int i2 = 1;
            int i3 = 0;
            while (i2 <= i) {
                int i4 = (i2 + i) / 2;
                if (m1748a(this.f1532f[i4], rectF)) {
                    int i5 = i4 + 1;
                    i3 = i2;
                    i2 = i5;
                } else {
                    i3 = i4 - 1;
                    i = i3;
                }
            }
            return this.f1532f[i3];
        }
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3537a(int i) {
        TextPaint textPaint = this.f1534h;
        if (textPaint == null) {
            this.f1534h = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f1534h.set(this.f1535i.getPaint());
        this.f1534h.setTextSize((float) i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public StaticLayout mo3535a(CharSequence charSequence, Layout.Alignment alignment, int i, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 23) {
            return m1751b(charSequence, alignment, i, i2);
        }
        if (i3 >= 16) {
            return m1750b(charSequence, alignment, i);
        }
        return m1742a(charSequence, alignment, i);
    }

    /* renamed from: a */
    private boolean m1748a(int i, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.f1535i.getText();
        TransformationMethod transformationMethod = this.f1535i.getTransformationMethod();
        if (!(transformationMethod == null || (transformation = transformationMethod.getTransformation(text, this.f1535i)) == null)) {
            text = transformation;
        }
        int maxLines = Build.VERSION.SDK_INT >= 16 ? this.f1535i.getMaxLines() : -1;
        mo3537a(i);
        StaticLayout a = mo3535a(text, (Layout.Alignment) m1752b((Object) this.f1535i, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), maxLines);
        return (maxLines == -1 || (a.getLineCount() <= maxLines && a.getLineEnd(a.getLineCount() - 1) == text.length())) && ((float) a.getHeight()) <= rectF.bottom;
    }

    /* renamed from: a */
    private StaticLayout m1742a(CharSequence charSequence, Layout.Alignment alignment, int i) {
        return new StaticLayout(charSequence, this.f1534h, i, alignment, ((Float) m1743a((Object) this.f1535i, "mSpacingMult", Float.valueOf(1.0f))).floatValue(), ((Float) m1743a((Object) this.f1535i, "mSpacingAdd", Float.valueOf(0.0f))).floatValue(), ((Boolean) m1743a((Object) this.f1535i, "mIncludePad", true)).booleanValue());
    }

    /* renamed from: a */
    private static <T> T m1743a(Object obj, String str, T t) {
        try {
            Field a = m1744a(str);
            if (a == null) {
                return t;
            }
            return a.get(obj);
        } catch (IllegalAccessException e) {
            Log.w("ACTVAutoSizeHelper", "Failed to access TextView#" + str + " member", e);
            return t;
        }
    }

    /* renamed from: a */
    private static Field m1744a(String str) {
        try {
            Field field = f1526m.get(str);
            if (field == null && (field = TextView.class.getDeclaredField(str)) != null) {
                field.setAccessible(true);
                f1526m.put(str, field);
            }
            return field;
        } catch (NoSuchFieldException e) {
            Log.w("ACTVAutoSizeHelper", "Failed to access TextView#" + str + " member", e);
            return null;
        }
    }
}
