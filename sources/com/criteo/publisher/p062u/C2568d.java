package com.criteo.publisher.p062u;

import admost.sdk.base.AdMostAdClassName;
import com.criteo.publisher.model.AdUnit;
import com.criteo.publisher.model.BannerAdUnit;
import com.criteo.publisher.model.C2465w;
import com.criteo.publisher.p054a0.C2342q;

/* renamed from: com.criteo.publisher.u.d */
public class C2568d implements C2567c {
    /* renamed from: a */
    public boolean mo10605a(Object obj) {
        return obj.getClass().getName().equals("com.mopub.mobileads.MoPubView") || obj.getClass().getName().equals(AdMostAdClassName.MOPUB_INTERSTITIAL);
    }

    /* renamed from: a */
    public void mo10604a(Object obj, AdUnit adUnit, C2465w wVar) {
        if (mo10605a(obj)) {
            StringBuilder sb = new StringBuilder();
            Object a = C2342q.m8999a(obj, "getKeywords", new Object[0]);
            if (a != null) {
                sb.append(a);
                sb.append(",");
            }
            sb.append("crt_cpm");
            sb.append(":");
            sb.append(wVar.mo10401a());
            sb.append(",");
            sb.append("crt_displayUrl");
            sb.append(":");
            sb.append(wVar.mo10406c());
            if (adUnit instanceof BannerAdUnit) {
                sb.append(",");
                sb.append("crt_size");
                sb.append(":");
                sb.append(wVar.mo10413i());
                sb.append("x");
                sb.append(wVar.mo10407d());
            }
            C2342q.m8999a(obj, "setKeywords", sb.toString());
        }
    }
}
