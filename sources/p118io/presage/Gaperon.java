package p118io.presage;

import android.os.Handler;
import android.os.Looper;

/* renamed from: io.presage.Gaperon */
public final class Gaperon implements GorgonzolaPiccante {

    /* renamed from: a */
    private final Handler f16525a = new Handler(Looper.getMainLooper());

    /* renamed from: a */
    public final void mo34553a(Runnable runnable) {
        this.f16525a.post(runnable);
    }
}
