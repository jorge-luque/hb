package com.criteo.publisher.p062u;

import com.criteo.publisher.model.AdUnit;
import com.criteo.publisher.model.BannerAdUnit;
import com.criteo.publisher.model.C2465w;
import java.util.Map;

/* renamed from: com.criteo.publisher.u.e */
public class C2569e implements C2567c {
    /* renamed from: a */
    public boolean mo10605a(Object obj) {
        return obj instanceof Map;
    }

    /* renamed from: a */
    public void mo10604a(Object obj, AdUnit adUnit, C2465w wVar) {
        if (mo10605a(obj)) {
            Map map = (Map) obj;
            map.put("crt_displayUrl", wVar.mo10406c());
            map.put("crt_cpm", wVar.mo10401a());
            if (adUnit instanceof BannerAdUnit) {
                map.put("crt_size", wVar.mo10413i() + "x" + wVar.mo10407d());
            }
        }
    }
}
