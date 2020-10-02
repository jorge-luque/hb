package bolts;

import android.net.Uri;
import java.util.Collections;
import java.util.List;

/* renamed from: bolts.b */
/* compiled from: AppLink */
public class C1159b {

    /* renamed from: a */
    private Uri f3190a;

    /* renamed from: b */
    private Uri f3191b;

    /* renamed from: bolts.b$a */
    /* compiled from: AppLink */
    public static class C1160a {

        /* renamed from: a */
        private final Uri f3192a;

        public C1160a(String str, String str2, Uri uri, String str3) {
            this.f3192a = uri;
        }
    }

    public C1159b(Uri uri, List<C1160a> list, Uri uri2) {
        this.f3190a = uri;
        if (list == null) {
            Collections.emptyList();
        }
        this.f3191b = uri2;
    }
}
