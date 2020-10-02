package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

/* renamed from: androidx.fragment.app.d */
/* compiled from: FragmentContainer */
public abstract class C0913d {
    /* renamed from: a */
    public abstract View mo4650a(int i);

    @Deprecated
    /* renamed from: a */
    public Fragment mo4748a(Context context, String str, Bundle bundle) {
        return Fragment.instantiate(context, str, bundle);
    }

    /* renamed from: a */
    public abstract boolean mo4651a();
}
