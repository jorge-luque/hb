package com.tapjoy.internal;

import android.graphics.Point;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tapjoy.TJAdUnitConstants;
import java.net.URL;

/* renamed from: com.tapjoy.internal.hv */
public final class C5174hv {

    /* renamed from: d */
    public static final C4911bi f14176d = new C4911bi() {
        /* renamed from: b */
        private static Point m17408b(C3126bn bnVar) {
            bnVar.mo18492h();
            Point point = null;
            while (bnVar.mo18494j()) {
                if ("offset".equals(bnVar.mo18496l())) {
                    bnVar.mo18492h();
                    int i = 0;
                    int i2 = 0;
                    while (bnVar.mo18494j()) {
                        String l = bnVar.mo18496l();
                        if ("x".equals(l)) {
                            i = bnVar.mo18502r();
                        } else if ("y".equals(l)) {
                            i2 = bnVar.mo18502r();
                        } else {
                            bnVar.mo18503s();
                        }
                    }
                    bnVar.mo18493i();
                    point = new Point(i, i2);
                } else {
                    bnVar.mo18503s();
                }
            }
            bnVar.mo18493i();
            return point;
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo18614a(C3126bn bnVar) {
            bnVar.mo18492h();
            C5178hx hxVar = null;
            Point point = null;
            Point point2 = null;
            while (bnVar.mo18494j()) {
                String l = bnVar.mo18496l();
                if (MessengerShareContentUtility.MEDIA_IMAGE.equals(l)) {
                    String m = bnVar.mo18497m();
                    if (!C3166jq.m10436c(m)) {
                        hxVar = new C5178hx(new URL(m));
                    }
                } else if (TJAdUnitConstants.String.LANDSCAPE.equals(l)) {
                    point = m17408b(bnVar);
                } else if (TJAdUnitConstants.String.PORTRAIT.equals(l)) {
                    point2 = m17408b(bnVar);
                } else {
                    bnVar.mo18503s();
                }
            }
            bnVar.mo18493i();
            return new C5174hv(hxVar, point, point2);
        }
    };

    /* renamed from: a */
    public final C5178hx f14177a;

    /* renamed from: b */
    public final Point f14178b;

    /* renamed from: c */
    public final Point f14179c;

    public C5174hv(C5178hx hxVar, Point point, Point point2) {
        this.f14177a = hxVar;
        this.f14178b = point;
        this.f14179c = point2;
    }
}
