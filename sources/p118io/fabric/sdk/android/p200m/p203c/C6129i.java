package p118io.fabric.sdk.android.p200m.p203c;

import android.content.Context;
import p118io.fabric.sdk.android.p200m.p202b.C6090i;

/* renamed from: io.fabric.sdk.android.m.c.i */
/* compiled from: TimeBasedFileRollOverRunnable */
public class C6129i implements Runnable {

    /* renamed from: a */
    private final Context f16108a;

    /* renamed from: b */
    private final C6125e f16109b;

    public C6129i(Context context, C6125e eVar) {
        this.f16108a = context;
        this.f16109b = eVar;
    }

    public void run() {
        try {
            C6090i.m19746c(this.f16108a, "Performing time based file roll over.");
            if (!this.f16109b.rollFileOver()) {
                this.f16109b.cancelTimeBasedFileRollOver();
            }
        } catch (Exception e) {
            C6090i.m19731a(this.f16108a, "Failed to roll over file", (Throwable) e);
        }
    }
}
