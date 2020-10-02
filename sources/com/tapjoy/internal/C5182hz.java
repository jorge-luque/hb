package com.tapjoy.internal;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;

/* renamed from: com.tapjoy.internal.hz */
public final class C5182hz {

    /* renamed from: n */
    public static final C4911bi f14194n = new C4911bi() {
        /* renamed from: a */
        public final /* synthetic */ Object mo18614a(C3126bn bnVar) {
            return new C5182hz(bnVar);
        }
    };

    /* renamed from: a */
    public C5187ib f14195a;

    /* renamed from: b */
    public C5187ib f14196b;

    /* renamed from: c */
    public C5187ib f14197c;

    /* renamed from: d */
    public C5187ib f14198d;

    /* renamed from: e */
    public int f14199e = 9;

    /* renamed from: f */
    public int f14200f = 10;

    /* renamed from: g */
    public String f14201g;

    /* renamed from: h */
    public String f14202h;

    /* renamed from: i */
    public String f14203i;

    /* renamed from: j */
    public boolean f14204j = false;

    /* renamed from: k */
    public String f14205k;

    /* renamed from: l */
    public C5178hx f14206l;

    /* renamed from: m */
    public C5178hx f14207m;

    public C5182hz(C3126bn bnVar) {
        bnVar.mo18492h();
        while (bnVar.mo18494j()) {
            String l = bnVar.mo18496l();
            if ("x".equals(l)) {
                this.f14195a = C5187ib.m17427a(bnVar.mo18497m());
            } else if ("y".equals(l)) {
                this.f14196b = C5187ib.m17427a(bnVar.mo18497m());
            } else if ("width".equals(l)) {
                this.f14197c = C5187ib.m17427a(bnVar.mo18497m());
            } else if ("height".equals(l)) {
                this.f14198d = C5187ib.m17427a(bnVar.mo18497m());
            } else if ("url".equals(l)) {
                this.f14201g = bnVar.mo18497m();
            } else if (TapjoyConstants.TJC_REDIRECT_URL.equals(l)) {
                this.f14202h = bnVar.mo18497m();
            } else if ("ad_content".equals(l)) {
                this.f14203i = bnVar.mo18497m();
            } else if (TapjoyConstants.TJC_FULLSCREEN_AD_DISMISS_URL.equals(l)) {
                this.f14204j = bnVar.mo18498n();
            } else if (AppMeasurementSdk.ConditionalUserProperty.VALUE.equals(l)) {
                this.f14205k = bnVar.mo18497m();
            } else if (MessengerShareContentUtility.MEDIA_IMAGE.equals(l)) {
                this.f14206l = (C5178hx) C5178hx.f14183e.mo18614a(bnVar);
            } else if ("image_clicked".equals(l)) {
                this.f14207m = (C5178hx) C5178hx.f14183e.mo18614a(bnVar);
            } else if ("align".equals(l)) {
                String m = bnVar.mo18497m();
                if ("left".equals(m)) {
                    this.f14199e = 9;
                } else if (TJAdUnitConstants.String.RIGHT.equals(m)) {
                    this.f14199e = 11;
                } else if ("center".equals(m)) {
                    this.f14199e = 14;
                } else {
                    bnVar.mo18503s();
                }
            } else if ("valign".equals(l)) {
                String m2 = bnVar.mo18497m();
                if ("top".equals(m2)) {
                    this.f14200f = 10;
                } else if ("middle".equals(m2)) {
                    this.f14200f = 15;
                } else if (TJAdUnitConstants.String.BOTTOM.equals(m2)) {
                    this.f14200f = 12;
                } else {
                    bnVar.mo18503s();
                }
            } else {
                bnVar.mo18503s();
            }
        }
        bnVar.mo18493i();
    }
}
