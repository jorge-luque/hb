package p118io.fabric.sdk.android.p200m.p205e;

import android.content.Context;
import android.graphics.BitmapFactory;
import p118io.fabric.sdk.android.C6059c;
import p118io.fabric.sdk.android.C6072k;
import p118io.fabric.sdk.android.p200m.p202b.C6090i;

/* renamed from: io.fabric.sdk.android.m.e.n */
/* compiled from: IconRequest */
public class C6147n {

    /* renamed from: a */
    public final String f16153a;

    /* renamed from: b */
    public final int f16154b;

    /* renamed from: c */
    public final int f16155c;

    /* renamed from: d */
    public final int f16156d;

    public C6147n(String str, int i, int i2, int i3) {
        this.f16153a = str;
        this.f16154b = i;
        this.f16155c = i2;
        this.f16156d = i3;
    }

    /* renamed from: a */
    public static C6147n m19901a(Context context, String str) {
        if (str != null) {
            try {
                int d = C6090i.m19748d(context);
                C6072k f = C6059c.m19630f();
                f.mo34093d("Fabric", "App icon resource ID is " + d);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeResource(context.getResources(), d, options);
                return new C6147n(str, d, options.outWidth, options.outHeight);
            } catch (Exception e) {
                C6059c.m19630f().mo34090b("Fabric", "Failed to load icon", e);
            }
        }
        return null;
    }
}
