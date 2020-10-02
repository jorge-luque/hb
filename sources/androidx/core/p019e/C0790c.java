package androidx.core.p019e;

import android.os.Build;
import java.util.Arrays;

/* renamed from: androidx.core.e.c */
/* compiled from: ObjectsCompat */
public class C0790c {
    /* renamed from: a */
    public static boolean m2494a(Object obj, Object obj2) {
        if (Build.VERSION.SDK_INT >= 19) {
            return C1155b.m4760a(obj, obj2);
        }
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: a */
    public static int m2493a(Object... objArr) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Arrays.hashCode(objArr);
        }
        return Arrays.hashCode(objArr);
    }
}
