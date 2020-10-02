package com.tapjoy.internal;

import android.view.animation.Animation;

/* renamed from: com.tapjoy.internal.ad */
public class C4879ad {

    /* renamed from: a */
    protected final Animation f13317a;

    /* renamed from: com.tapjoy.internal.ad$1 */
    public static /* synthetic */ class C48801 {

        /* renamed from: a */
        public static final /* synthetic */ int[] f13318a;

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0017 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001f */
        static {
            /*
                int[] r0 = com.tapjoy.internal.C4879ad.C4881a.m16665a()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f13318a = r0
                r1 = 1
                int r2 = com.tapjoy.internal.C4879ad.C4881a.f13319a     // Catch:{ NoSuchFieldError -> 0x000f }
                int r2 = r2 - r1
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = f13318a     // Catch:{ NoSuchFieldError -> 0x0017 }
                int r2 = com.tapjoy.internal.C4879ad.C4881a.f13320b     // Catch:{ NoSuchFieldError -> 0x0017 }
                int r2 = r2 - r1
                r3 = 2
                r0[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0017 }
            L_0x0017:
                int[] r0 = f13318a     // Catch:{ NoSuchFieldError -> 0x001f }
                int r2 = com.tapjoy.internal.C4879ad.C4881a.f13321c     // Catch:{ NoSuchFieldError -> 0x001f }
                int r2 = r2 - r1
                r3 = 3
                r0[r2] = r3     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f13318a     // Catch:{ NoSuchFieldError -> 0x0027 }
                int r2 = com.tapjoy.internal.C4879ad.C4881a.f13322d     // Catch:{ NoSuchFieldError -> 0x0027 }
                int r2 = r2 - r1
                r1 = 4
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0027 }
            L_0x0027:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C4879ad.C48801.<clinit>():void");
        }
    }

    /* renamed from: com.tapjoy.internal.ad$a */
    public enum C4881a {
        ;
        

        /* renamed from: a */
        public static final int f13319a = 1;

        /* renamed from: b */
        public static final int f13320b = 2;

        /* renamed from: c */
        public static final int f13321c = 3;

        /* renamed from: d */
        public static final int f13322d = 4;

        static {
            f13323e = new int[]{1, 2, 3, 4};
        }

        /* renamed from: a */
        public static int[] m16665a() {
            return (int[]) f13323e.clone();
        }
    }

    public C4879ad(Animation animation) {
        this.f13317a = animation;
        animation.setDuration(400);
    }

    /* renamed from: a */
    public Animation mo30908a() {
        return this.f13317a;
    }

    /* renamed from: b */
    public final C4879ad mo30909b() {
        this.f13317a.setDuration(600);
        return this;
    }
}
