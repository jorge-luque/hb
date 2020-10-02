package com.criteo.publisher.p068z;

import com.criteo.publisher.C2385g;
import com.criteo.publisher.CriteoBannerAdListener;
import com.criteo.publisher.CriteoBannerView;
import com.criteo.publisher.CriteoErrorCode;
import java.lang.ref.Reference;

/* renamed from: com.criteo.publisher.z.a */
public class C2590a implements Runnable {

    /* renamed from: a */
    private final CriteoBannerAdListener f8164a;

    /* renamed from: b */
    private final Reference<CriteoBannerView> f8165b;

    /* renamed from: c */
    private final C2385g f8166c;

    /* renamed from: com.criteo.publisher.z.a$a */
    static /* synthetic */ class C2591a {

        /* renamed from: a */
        static final /* synthetic */ int[] f8167a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.criteo.publisher.g[] r0 = com.criteo.publisher.C2385g.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8167a = r0
                com.criteo.publisher.g r1 = com.criteo.publisher.C2385g.INVALID     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8167a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.criteo.publisher.g r1 = com.criteo.publisher.C2385g.VALID     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f8167a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.criteo.publisher.g r1 = com.criteo.publisher.C2385g.CLICK     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f8167a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.criteo.publisher.g r1 = com.criteo.publisher.C2385g.CLOSE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.criteo.publisher.p068z.C2590a.C2591a.<clinit>():void");
        }
    }

    public C2590a(CriteoBannerAdListener criteoBannerAdListener, Reference<CriteoBannerView> reference, C2385g gVar) {
        this.f8164a = criteoBannerAdListener;
        this.f8165b = reference;
        this.f8166c = gVar;
    }

    public void run() {
        if (this.f8164a != null) {
            int i = C2591a.f8167a[this.f8166c.ordinal()];
            if (i == 1) {
                this.f8164a.onAdFailedToReceive(CriteoErrorCode.ERROR_CODE_NO_FILL);
            } else if (i == 2) {
                this.f8164a.onAdReceived(this.f8165b.get());
            } else if (i == 3) {
                this.f8164a.onAdClicked();
                this.f8164a.onAdLeftApplication();
                this.f8164a.onAdOpened();
            } else if (i == 4) {
                this.f8164a.onAdClosed();
            }
        }
    }
}
