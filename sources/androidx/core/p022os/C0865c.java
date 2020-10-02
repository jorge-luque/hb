package androidx.core.p022os;

import android.content.Context;
import android.os.Build;
import android.os.UserManager;

/* renamed from: androidx.core.os.c */
/* compiled from: UserManagerCompat */
public class C0865c {
    /* renamed from: a */
    public static boolean m2833a(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return ((UserManager) context.getSystemService(UserManager.class)).isUserUnlocked();
        }
        return true;
    }
}
