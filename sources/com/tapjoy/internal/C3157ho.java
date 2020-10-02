package com.tapjoy.internal;

import java.util.Arrays;
import javax.annotation.Nullable;

/* renamed from: com.tapjoy.internal.ho */
abstract class C3157ho implements C3143gl {

    /* renamed from: a */
    private static final String[] f8804a;

    static {
        String[] strArr = {"reward", "purchase", "custom_action"};
        f8804a = strArr;
        Arrays.sort(strArr);
    }

    C3157ho() {
    }

    /* renamed from: a */
    public final void mo18537a(C5124gm gmVar) {
        if (this instanceof C5127gp) {
            C5127gp gpVar = (C5127gp) this;
            gmVar.mo30549a(gpVar.mo31305a(), gpVar.mo31306b());
        } else if (this instanceof C5128gq) {
            C5128gq gqVar = (C5128gq) this;
            gmVar.mo30550a(gqVar.mo31307a(), gqVar.mo31308b(), gqVar.mo31309c(), gqVar.mo31310d());
        }
    }

    /* renamed from: a */
    public static boolean m10406a(String str) {
        return Arrays.binarySearch(f8804a, str) >= 0;
    }

    @Nullable
    /* renamed from: a */
    public static C3157ho m10405a(String str, C3126bn bnVar) {
        if ("reward".equals(str)) {
            return (C3157ho) bnVar.mo18477a(C5180hy.f14189a);
        }
        if ("purchase".equals(str)) {
            return (C3157ho) bnVar.mo18477a(C5176hw.f14180a);
        }
        return null;
    }
}
