package com.tapjoy.internal;

import android.graphics.Point;
import android.os.SystemClock;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import com.vungle.warren.model.VisionDataDBAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* renamed from: com.tapjoy.internal.hu */
public final class C3159hu extends C3158hq {

    /* renamed from: n */
    public static final C4911bi f8805n = new C4911bi() {
        /* renamed from: a */
        public final /* synthetic */ Object mo18614a(C3126bn bnVar) {
            return new C3159hu(bnVar);
        }
    };
    @Nullable

    /* renamed from: a */
    public C5178hx f8806a;
    @Nullable

    /* renamed from: b */
    public C5178hx f8807b;

    /* renamed from: c */
    public C5178hx f8808c;
    @Nullable

    /* renamed from: d */
    public Point f8809d;
    @Nullable

    /* renamed from: e */
    public C5178hx f8810e;
    @Nullable

    /* renamed from: f */
    public C5178hx f8811f;

    /* renamed from: g */
    public String f8812g;
    @Nullable

    /* renamed from: h */
    public C3143gl f8813h;

    /* renamed from: i */
    public ArrayList f8814i = new ArrayList();

    /* renamed from: j */
    public ArrayList f8815j = new ArrayList();

    /* renamed from: k */
    public Map f8816k;

    /* renamed from: l */
    public long f8817l;
    @Nullable

    /* renamed from: m */
    public C5174hv f8818m;

    public C3159hu() {
    }

    /* renamed from: a */
    public final boolean mo18612a() {
        return (this.f8808c == null || this.f8806a == null || this.f8810e == null) ? false : true;
    }

    /* renamed from: b */
    public final boolean mo18613b() {
        return (this.f8808c == null || this.f8807b == null || this.f8811f == null) ? false : true;
    }

    C3159hu(C3126bn bnVar) {
        bnVar.mo18492h();
        String str = null;
        String str2 = null;
        while (bnVar.mo18494j()) {
            String l = bnVar.mo18496l();
            if ("frame".equals(l)) {
                bnVar.mo18492h();
                while (bnVar.mo18494j()) {
                    String l2 = bnVar.mo18496l();
                    if (TJAdUnitConstants.String.PORTRAIT.equals(l2)) {
                        this.f8806a = (C5178hx) C5178hx.f14183e.mo18614a(bnVar);
                    } else if (TJAdUnitConstants.String.LANDSCAPE.equals(l2)) {
                        this.f8807b = (C5178hx) C5178hx.f14183e.mo18614a(bnVar);
                    } else if ("close_button".equals(l2)) {
                        this.f8808c = (C5178hx) C5178hx.f14183e.mo18614a(bnVar);
                    } else if ("close_button_offset".equals(l2)) {
                        this.f8809d = (Point) C4912bj.f13377a.mo18614a(bnVar);
                    } else {
                        bnVar.mo18503s();
                    }
                }
                bnVar.mo18493i();
            } else if (VisionDataDBAdapter.VisionDataColumns.COLUMN_CREATIVE.equals(l)) {
                bnVar.mo18492h();
                while (bnVar.mo18494j()) {
                    String l3 = bnVar.mo18496l();
                    if (TJAdUnitConstants.String.PORTRAIT.equals(l3)) {
                        this.f8810e = (C5178hx) C5178hx.f14183e.mo18614a(bnVar);
                    } else if (TJAdUnitConstants.String.LANDSCAPE.equals(l3)) {
                        this.f8811f = (C5178hx) C5178hx.f14183e.mo18614a(bnVar);
                    } else {
                        bnVar.mo18503s();
                    }
                }
                bnVar.mo18493i();
            } else if ("url".equals(l)) {
                this.f8812g = bnVar.mo18481b();
            } else if (C3157ho.m10406a(l)) {
                this.f8813h = C3157ho.m10405a(l, bnVar);
            } else if ("mappings".equals(l)) {
                bnVar.mo18492h();
                while (bnVar.mo18494j()) {
                    String l4 = bnVar.mo18496l();
                    if (TJAdUnitConstants.String.PORTRAIT.equals(l4)) {
                        bnVar.mo18478a((List) this.f8814i, C5168hs.f14156h);
                    } else if (TJAdUnitConstants.String.LANDSCAPE.equals(l4)) {
                        bnVar.mo18478a((List) this.f8815j, C5168hs.f14156h);
                    } else {
                        bnVar.mo18503s();
                    }
                }
                bnVar.mo18493i();
            } else if ("meta".equals(l)) {
                this.f8816k = bnVar.mo18484d();
            } else if ("ttl".equals(l)) {
                this.f8817l = SystemClock.elapsedRealtime() + ((long) (bnVar.mo18500p() * 1000.0d));
            } else if ("no_more_today".equals(l)) {
                this.f8818m = (C5174hv) C5174hv.f14176d.mo18614a(bnVar);
            } else if ("ad_content".equals(l)) {
                str = bnVar.mo18481b();
            } else if (TapjoyConstants.TJC_REDIRECT_URL.equals(l)) {
                str2 = bnVar.mo18481b();
            } else {
                bnVar.mo18503s();
            }
        }
        bnVar.mo18493i();
        if (this.f8812g == null) {
            this.f8812g = "";
        }
        ArrayList arrayList = this.f8814i;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                C5168hs hsVar = (C5168hs) it.next();
                if (hsVar.f14162f == null) {
                    hsVar.f14162f = str;
                }
                if (hsVar.f14161e == null) {
                    hsVar.f14161e = str2;
                }
            }
        }
        ArrayList arrayList2 = this.f8815j;
        if (arrayList2 != null) {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                C5168hs hsVar2 = (C5168hs) it2.next();
                if (hsVar2.f14162f == null) {
                    hsVar2.f14162f = str;
                }
                if (hsVar2.f14161e == null) {
                    hsVar2.f14161e = str2;
                }
            }
        }
    }
}
