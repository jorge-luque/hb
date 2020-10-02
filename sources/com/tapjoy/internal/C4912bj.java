package com.tapjoy.internal;

import android.graphics.Point;
import android.graphics.Rect;
import com.tapjoy.TJAdUnitConstants;

/* renamed from: com.tapjoy.internal.bj */
public final class C4912bj {

    /* renamed from: a */
    public static final C4911bi f13377a = new C4911bi() {
        /* renamed from: a */
        public final /* synthetic */ Object mo18614a(C3126bn bnVar) {
            Point point = new Point();
            bnVar.mo18492h();
            while (bnVar.mo18494j()) {
                String l = bnVar.mo18496l();
                if ("x".equals(l)) {
                    point.x = bnVar.mo18502r();
                } else if ("y".equals(l)) {
                    point.y = bnVar.mo18502r();
                } else {
                    bnVar.mo18503s();
                }
            }
            bnVar.mo18493i();
            return point;
        }
    };

    /* renamed from: b */
    public static final C4911bi f13378b = new C4911bi() {
        /* renamed from: a */
        public final /* synthetic */ Object mo18614a(C3126bn bnVar) {
            Rect rect = new Rect();
            int i = C49153.f13379a[bnVar.mo18495k().ordinal()];
            if (i == 1) {
                bnVar.mo18490f();
                rect.left = bnVar.mo18502r();
                rect.top = bnVar.mo18502r();
                rect.right = bnVar.mo18502r();
                rect.bottom = bnVar.mo18502r();
                while (bnVar.mo18494j()) {
                    bnVar.mo18503s();
                }
                bnVar.mo18491g();
            } else if (i == 2) {
                bnVar.mo18492h();
                while (bnVar.mo18494j()) {
                    String l = bnVar.mo18496l();
                    if ("left".equals(l)) {
                        rect.left = bnVar.mo18502r();
                    } else if ("top".equals(l)) {
                        rect.top = bnVar.mo18502r();
                    } else if (TJAdUnitConstants.String.RIGHT.equals(l)) {
                        rect.right = bnVar.mo18502r();
                    } else if (TJAdUnitConstants.String.BOTTOM.equals(l)) {
                        rect.bottom = bnVar.mo18502r();
                    } else {
                        bnVar.mo18503s();
                    }
                }
                bnVar.mo18493i();
            } else {
                throw new IllegalStateException("Unexpected token: " + bnVar.mo18495k());
            }
            return rect;
        }
    };

    /* renamed from: com.tapjoy.internal.bj$3 */
    static /* synthetic */ class C49153 {

        /* renamed from: a */
        static final /* synthetic */ int[] f13379a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.tapjoy.internal.bs[] r0 = com.tapjoy.internal.C4923bs.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f13379a = r0
                com.tapjoy.internal.bs r1 = com.tapjoy.internal.C4923bs.BEGIN_ARRAY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f13379a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tapjoy.internal.bs r1 = com.tapjoy.internal.C4923bs.BEGIN_OBJECT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C4912bj.C49153.<clinit>():void");
        }
    }
}
