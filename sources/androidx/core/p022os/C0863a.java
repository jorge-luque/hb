package androidx.core.p022os;

import android.os.Build;

/* renamed from: androidx.core.os.a */
/* compiled from: BuildCompat */
public class C0863a {
    /* renamed from: a */
    public static boolean m2830a() {
        if (Build.VERSION.CODENAME.length() != 1 || Build.VERSION.CODENAME.charAt(0) < 'R' || Build.VERSION.CODENAME.charAt(0) > 'Z') {
            return false;
        }
        return true;
    }
}
