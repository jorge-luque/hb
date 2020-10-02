package com.tapjoy.internal;

import android.graphics.PointF;
import com.tapjoy.TJAdUnitConstants;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tapjoy.internal.ia */
public final class C5185ia {

    /* renamed from: d */
    public static final C4911bi f14209d = new C4911bi() {
        /* renamed from: a */
        public final /* synthetic */ Object mo18614a(C3126bn bnVar) {
            return new C5185ia(bnVar);
        }
    };

    /* renamed from: a */
    public C4874aa f14210a = C4874aa.UNSPECIFIED;

    /* renamed from: b */
    public PointF f14211b;

    /* renamed from: c */
    public ArrayList f14212c = new ArrayList();

    public C5185ia(C3126bn bnVar) {
        bnVar.mo18492h();
        while (bnVar.mo18494j()) {
            String l = bnVar.mo18496l();
            if ("buttons".equals(l)) {
                if (bnVar.mo18495k() == C4923bs.BEGIN_ARRAY) {
                    bnVar.mo18478a((List) this.f14212c, C5182hz.f14194n);
                } else {
                    bnVar.mo18503s();
                }
            } else if ("window_aspect_ratio".equals(l)) {
                if (bnVar.mo18480a()) {
                    PointF pointF = new PointF();
                    bnVar.mo18492h();
                    while (bnVar.mo18494j()) {
                        String l2 = bnVar.mo18496l();
                        if ("width".equals(l2)) {
                            pointF.x = (float) bnVar.mo18500p();
                        } else if ("height".equals(l2)) {
                            pointF.y = (float) bnVar.mo18500p();
                        } else {
                            bnVar.mo18503s();
                        }
                    }
                    bnVar.mo18493i();
                    if (!(pointF.x == 0.0f || pointF.y == 0.0f)) {
                        this.f14211b = pointF;
                    }
                } else {
                    bnVar.mo18503s();
                }
            } else if ("orientation".equals(l)) {
                String m = bnVar.mo18497m();
                if (TJAdUnitConstants.String.LANDSCAPE.equals(m)) {
                    this.f14210a = C4874aa.LANDSCAPE;
                } else if (TJAdUnitConstants.String.PORTRAIT.equals(m)) {
                    this.f14210a = C4874aa.PORTRAIT;
                }
            } else {
                bnVar.mo18503s();
            }
        }
        bnVar.mo18493i();
    }
}
