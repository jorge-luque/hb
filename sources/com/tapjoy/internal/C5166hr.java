package com.tapjoy.internal;

import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.tapjoy.internal.hr */
public final class C5166hr extends C3158hq {

    /* renamed from: d */
    public static final C4911bi f14152d = new C4911bi() {
        /* renamed from: a */
        public final /* synthetic */ Object mo18614a(C3126bn bnVar) {
            return new C5166hr(bnVar);
        }
    };

    /* renamed from: a */
    public ArrayList f14153a = new ArrayList();

    /* renamed from: b */
    public Map f14154b;

    /* renamed from: c */
    public float f14155c;

    public C5166hr(C3126bn bnVar) {
        bnVar.mo18492h();
        String str = null;
        String str2 = null;
        while (bnVar.mo18494j()) {
            String l = bnVar.mo18496l();
            if ("layouts".equals(l)) {
                bnVar.mo18478a((List) this.f14153a, C5185ia.f14209d);
            } else if ("meta".equals(l)) {
                this.f14154b = bnVar.mo18484d();
            } else if ("max_show_time".equals(l)) {
                this.f14155c = (float) bnVar.mo18500p();
            } else if ("ad_content".equals(l)) {
                str = bnVar.mo18481b();
            } else if (TapjoyConstants.TJC_REDIRECT_URL.equals(l)) {
                str2 = bnVar.mo18481b();
            } else {
                bnVar.mo18503s();
            }
        }
        bnVar.mo18493i();
        ArrayList arrayList = this.f14153a;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ArrayList arrayList2 = ((C5185ia) it.next()).f14212c;
                if (arrayList2 != null) {
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        C5182hz hzVar = (C5182hz) it2.next();
                        if (hzVar.f14203i == null) {
                            hzVar.f14203i = str;
                        }
                        if (hzVar.f14202h == null) {
                            hzVar.f14202h = str2;
                        }
                    }
                }
            }
        }
    }
}
