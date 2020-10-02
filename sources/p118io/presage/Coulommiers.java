package p118io.presage;

import android.app.Activity;
import java.util.List;

/* renamed from: io.presage.Coulommiers */
public final class Coulommiers {
    /* renamed from: a */
    public static final String m20338a(Activity activity) {
        String a = m20339a((Object) activity);
        List b = C6562jf.m21523a((CharSequence) a, new char[]{'.'});
        if (b.size() <= 2) {
            return a;
        }
        return ((String) b.get(0)) + "." + ((String) b.get(1)) + ".";
    }

    /* renamed from: a */
    public static final String m20339a(Object obj) {
        String canonicalName = obj.getClass().getCanonicalName();
        if (canonicalName != null) {
            return canonicalName;
        }
        String name = obj.getClass().getName();
        C6514hl.m21414a((Object) name, "this.javaClass.name");
        return name;
    }
}
