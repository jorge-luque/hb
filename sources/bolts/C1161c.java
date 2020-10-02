package bolts;

import android.content.Intent;
import android.os.Bundle;

/* renamed from: bolts.c */
/* compiled from: AppLinks */
public final class C1161c {
    /* renamed from: a */
    public static Bundle m4764a(Intent intent) {
        return intent.getBundleExtra("al_applink_data");
    }

    /* renamed from: b */
    public static Bundle m4765b(Intent intent) {
        Bundle a = m4764a(intent);
        if (a == null) {
            return null;
        }
        return a.getBundle("extras");
    }
}
