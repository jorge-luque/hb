package androidx.core.content.p017c;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: androidx.core.content.c.g */
/* compiled from: TypedArrayUtils */
public class C0784g {
    /* renamed from: a */
    public static boolean m2476a(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    /* renamed from: b */
    public static int m2477b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        if (!m2476a(xmlPullParser, str)) {
            return i2;
        }
        return typedArray.getInt(i, i2);
    }

    /* renamed from: c */
    public static int m2479c(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        if (!m2476a(xmlPullParser, str)) {
            return i2;
        }
        return typedArray.getResourceId(i, i2);
    }

    /* renamed from: a */
    public static float m2468a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, float f) {
        if (!m2476a(xmlPullParser, str)) {
            return f;
        }
        return typedArray.getFloat(i, f);
    }

    /* renamed from: b */
    public static TypedValue m2478b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i) {
        if (!m2476a(xmlPullParser, str)) {
            return null;
        }
        return typedArray.peekValue(i);
    }

    /* renamed from: a */
    public static boolean m2475a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, boolean z) {
        if (!m2476a(xmlPullParser, str)) {
            return z;
        }
        return typedArray.getBoolean(i, z);
    }

    /* renamed from: a */
    public static int m2469a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        if (!m2476a(xmlPullParser, str)) {
            return i2;
        }
        return typedArray.getColor(i, i2);
    }

    /* renamed from: a */
    public static C0771b m2473a(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i, int i2) {
        if (m2476a(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i, typedValue);
            int i3 = typedValue.type;
            if (i3 >= 28 && i3 <= 31) {
                return C0771b.m2426b(typedValue.data);
            }
            C0771b b = C0771b.m2427b(typedArray.getResources(), typedArray.getResourceId(i, 0), theme);
            if (b != null) {
                return b;
            }
        }
        return C0771b.m2426b(i2);
    }

    /* renamed from: a */
    public static ColorStateList m2470a(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i) {
        if (!m2476a(xmlPullParser, str)) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i, typedValue);
        int i2 = typedValue.type;
        if (i2 == 2) {
            throw new UnsupportedOperationException("Failed to resolve attribute at index " + i + ": " + typedValue);
        } else if (i2 < 28 || i2 > 31) {
            return C0770a.m2418a(typedArray.getResources(), typedArray.getResourceId(i, 0), theme);
        } else {
            return m2471a(typedValue);
        }
    }

    /* renamed from: a */
    private static ColorStateList m2471a(TypedValue typedValue) {
        return ColorStateList.valueOf(typedValue.data);
    }

    /* renamed from: a */
    public static String m2474a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i) {
        if (!m2476a(xmlPullParser, str)) {
            return null;
        }
        return typedArray.getString(i);
    }

    /* renamed from: a */
    public static TypedArray m2472a(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
