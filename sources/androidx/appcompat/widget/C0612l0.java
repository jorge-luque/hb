package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.ref.WeakReference;

/* renamed from: androidx.appcompat.widget.l0 */
/* compiled from: VectorEnabledTintResources */
public class C0612l0 extends Resources {

    /* renamed from: b */
    private static boolean f1503b = false;

    /* renamed from: a */
    private final WeakReference<Context> f1504a;

    public C0612l0(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f1504a = new WeakReference<>(context);
    }

    /* renamed from: b */
    public static boolean m1707b() {
        return m1706a() && Build.VERSION.SDK_INT <= 20;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final Drawable mo3509a(int i) {
        return super.getDrawable(i);
    }

    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        Context context = (Context) this.f1504a.get();
        if (context != null) {
            return C0633w.m1854a().mo3582a(context, this, i);
        }
        return super.getDrawable(i);
    }

    /* renamed from: a */
    public static boolean m1706a() {
        return f1503b;
    }
}
