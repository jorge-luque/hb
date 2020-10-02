package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.p006a.p007a.C0383a;
import androidx.core.content.p017c.C0780f;

/* renamed from: androidx.appcompat.widget.g0 */
/* compiled from: TintTypedArray */
public class C0598g0 {

    /* renamed from: a */
    private final Context f1443a;

    /* renamed from: b */
    private final TypedArray f1444b;

    /* renamed from: c */
    private TypedValue f1445c;

    private C0598g0(Context context, TypedArray typedArray) {
        this.f1443a = context;
        this.f1444b = typedArray;
    }

    /* renamed from: a */
    public static C0598g0 m1609a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new C0598g0(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    /* renamed from: b */
    public Drawable mo3437b(int i) {
        int resourceId;
        if (!this.f1444b.hasValue(i) || (resourceId = this.f1444b.getResourceId(i, 0)) == 0) {
            return this.f1444b.getDrawable(i);
        }
        return C0383a.m323c(this.f1443a, resourceId);
    }

    /* renamed from: c */
    public Drawable mo3439c(int i) {
        int resourceId;
        if (!this.f1444b.hasValue(i) || (resourceId = this.f1444b.getResourceId(i, 0)) == 0) {
            return null;
        }
        return C0596g.m1590b().mo3422a(this.f1443a, resourceId, true);
    }

    /* renamed from: d */
    public String mo3441d(int i) {
        return this.f1444b.getString(i);
    }

    /* renamed from: e */
    public CharSequence mo3443e(int i) {
        return this.f1444b.getText(i);
    }

    /* renamed from: f */
    public int mo3444f(int i, int i2) {
        return this.f1444b.getLayoutDimension(i, i2);
    }

    /* renamed from: g */
    public int mo3446g(int i, int i2) {
        return this.f1444b.getResourceId(i, i2);
    }

    /* renamed from: a */
    public static C0598g0 m1610a(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new C0598g0(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    /* renamed from: d */
    public int mo3440d(int i, int i2) {
        return this.f1444b.getInt(i, i2);
    }

    /* renamed from: e */
    public int mo3442e(int i, int i2) {
        return this.f1444b.getInteger(i, i2);
    }

    /* renamed from: f */
    public CharSequence[] mo3445f(int i) {
        return this.f1444b.getTextArray(i);
    }

    /* renamed from: g */
    public boolean mo3447g(int i) {
        return this.f1444b.hasValue(i);
    }

    /* renamed from: a */
    public static C0598g0 m1608a(Context context, int i, int[] iArr) {
        return new C0598g0(context, context.obtainStyledAttributes(i, iArr));
    }

    /* renamed from: c */
    public int mo3438c(int i, int i2) {
        return this.f1444b.getDimensionPixelSize(i, i2);
    }

    /* renamed from: a */
    public Typeface mo3433a(int i, int i2, C0780f.C0781a aVar) {
        int resourceId = this.f1444b.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f1445c == null) {
            this.f1445c = new TypedValue();
        }
        return C0780f.m2460a(this.f1443a, resourceId, this.f1445c, i2, aVar);
    }

    /* renamed from: b */
    public int mo3436b(int i, int i2) {
        return this.f1444b.getDimensionPixelOffset(i, i2);
    }

    /* renamed from: a */
    public boolean mo3435a(int i, boolean z) {
        return this.f1444b.getBoolean(i, z);
    }

    /* renamed from: a */
    public float mo3430a(int i, float f) {
        return this.f1444b.getFloat(i, f);
    }

    /* renamed from: a */
    public int mo3431a(int i, int i2) {
        return this.f1444b.getColor(i, i2);
    }

    /* renamed from: a */
    public ColorStateList mo3432a(int i) {
        int resourceId;
        ColorStateList b;
        if (!this.f1444b.hasValue(i) || (resourceId = this.f1444b.getResourceId(i, 0)) == 0 || (b = C0383a.m322b(this.f1443a, resourceId)) == null) {
            return this.f1444b.getColorStateList(i);
        }
        return b;
    }

    /* renamed from: a */
    public void mo3434a() {
        this.f1444b.recycle();
    }
}
