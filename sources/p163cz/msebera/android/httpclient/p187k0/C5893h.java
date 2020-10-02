package p163cz.msebera.android.httpclient.p187k0;

/* renamed from: cz.msebera.android.httpclient.k0.h */
/* compiled from: LangUtils */
public final class C5893h {
    /* renamed from: a */
    public static int m18937a(int i, int i2) {
        return (i * 37) + i2;
    }

    /* renamed from: a */
    public static int m18939a(int i, boolean z) {
        return m18937a(i, z ? 1 : 0);
    }

    /* renamed from: a */
    public static int m18938a(int i, Object obj) {
        return m18937a(i, obj != null ? obj.hashCode() : 0);
    }

    /* renamed from: a */
    public static boolean m18940a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    /* renamed from: a */
    public static boolean m18941a(Object[] objArr, Object[] objArr2) {
        if (objArr == null) {
            return objArr2 == null;
        }
        if (objArr2 == null || objArr.length != objArr2.length) {
            return false;
        }
        for (int i = 0; i < objArr.length; i++) {
            if (!m18940a(objArr[i], objArr2[i])) {
                return false;
            }
        }
        return true;
    }
}
