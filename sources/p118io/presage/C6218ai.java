package p118io.presage;

import android.os.Looper;

/* renamed from: io.presage.ai */
public final class C6218ai {
    /* renamed from: a */
    public static final boolean m20782a(Throwable th) {
        return (th instanceof C6410dp) || (th instanceof Salers);
    }

    /* renamed from: a */
    public static final void m20781a(String str) {
        if (C6514hl.m21416a((Object) Looper.myLooper(), (Object) Looper.getMainLooper())) {
            new IllegalStateException(str + " cannot be called from the main thread");
        }
    }
}
