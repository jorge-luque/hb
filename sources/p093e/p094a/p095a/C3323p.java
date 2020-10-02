package p093e.p094a.p095a;

import android.content.Context;
import android.provider.Settings;
import com.tapjoy.TapjoyConstants;

/* renamed from: e.a.a.p */
/* compiled from: AndroidIdUtil */
public class C3323p {
    /* renamed from: a */
    public static String m11054a(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), TapjoyConstants.TJC_ANDROID_ID);
    }
}
