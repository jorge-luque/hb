package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* renamed from: androidx.appcompat.widget.f0 */
/* compiled from: TintResources */
class C0595f0 extends C0640x {

    /* renamed from: b */
    private final WeakReference<Context> f1433b;

    public C0595f0(Context context, Resources resources) {
        super(resources);
        this.f1433b = new WeakReference<>(context);
    }

    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        Drawable drawable = super.getDrawable(i);
        Context context = (Context) this.f1433b.get();
        if (!(drawable == null || context == null)) {
            C0633w.m1854a().mo3585a(context, i, drawable);
        }
        return drawable;
    }
}
