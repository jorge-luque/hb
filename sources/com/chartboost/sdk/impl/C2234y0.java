package com.chartboost.sdk.impl;

import com.chartboost.sdk.Libraries.C2078f;
import com.chartboost.sdk.Libraries.C2080h;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.chartboost.sdk.impl.y0 */
public class C2234y0 {

    /* renamed from: a */
    private final C2078f f7544a;

    /* renamed from: b */
    private final Map<String, C2080h.C2081a> f7545b = new HashMap();

    public C2234y0(C2078f fVar) {
        this.f7544a = fVar;
    }

    /* renamed from: b */
    private boolean m8874b(String str) {
        return this.f7544a.mo9092b(String.format("%s%s", new Object[]{str, ".png"}));
    }

    /* renamed from: a */
    public C2080h.C2081a mo9596a(String str) {
        if (!m8874b(str)) {
            this.f7545b.remove(str);
            return null;
        } else if (this.f7545b.containsKey(str)) {
            return this.f7545b.get(str);
        } else {
            C2080h.C2081a aVar = new C2080h.C2081a(str, new File(this.f7544a.mo9089a().f6868b, String.format("%s%s", new Object[]{str, ".png"})), this.f7544a);
            this.f7545b.put(str, aVar);
            return aVar;
        }
    }
}
