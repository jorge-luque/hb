package com.criteo.publisher.p068z;

import android.util.Log;
import com.criteo.publisher.C2385g;
import com.criteo.publisher.CriteoErrorCode;
import com.criteo.publisher.CriteoInterstitialAdListener;

/* renamed from: com.criteo.publisher.z.c */
public class C2593c implements Runnable {

    /* renamed from: a */
    private final CriteoInterstitialAdListener f8172a;

    /* renamed from: b */
    private final C2385g f8173b;

    /* renamed from: com.criteo.publisher.z.c$a */
    static /* synthetic */ class C2594a {

        /* renamed from: a */
        static final /* synthetic */ int[] f8174a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.criteo.publisher.g[] r0 = com.criteo.publisher.C2385g.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8174a = r0
                com.criteo.publisher.g r1 = com.criteo.publisher.C2385g.VALID     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8174a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.criteo.publisher.g r1 = com.criteo.publisher.C2385g.INVALID     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.criteo.publisher.p068z.C2593c.C2594a.<clinit>():void");
        }
    }

    public C2593c(CriteoInterstitialAdListener criteoInterstitialAdListener, C2385g gVar) {
        this.f8172a = criteoInterstitialAdListener;
        this.f8173b = gVar;
    }

    /* renamed from: a */
    private void m9716a() {
        if (this.f8172a != null) {
            int i = C2594a.f8174a[this.f8173b.ordinal()];
            if (i == 1) {
                this.f8172a.onAdReceived();
            } else if (i == 2) {
                this.f8172a.onAdFailedToReceive(CriteoErrorCode.ERROR_CODE_NO_FILL);
            }
        }
    }

    public void run() {
        try {
            m9716a();
        } catch (Throwable th) {
            Log.e("Criteo.ILCT", "Internal ILCT PostExec error.", th);
        }
    }
}
