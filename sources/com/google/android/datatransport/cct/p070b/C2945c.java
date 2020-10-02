package com.google.android.datatransport.cct.p070b;

import com.applovin.sdk.AppLovinEventTypes;
import com.google.firebase.encoders.C3670b;
import com.google.firebase.encoders.C3671c;
import com.google.firebase.encoders.EncodingException;
import com.tapjoy.TapjoyConstants;
import java.io.IOException;

/* renamed from: com.google.android.datatransport.cct.b.c */
/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
public final class C2945c implements C3670b<C2946d> {
    /* renamed from: a */
    public void mo12866a(Object obj, Object obj2) throws EncodingException, IOException {
        C2946d dVar = (C2946d) obj;
        C3671c cVar = (C3671c) obj2;
        if (dVar.mo12876i() != Integer.MIN_VALUE) {
            cVar.mo27271a("sdkVersion", dVar.mo12876i());
        }
        if (dVar.mo12872f() != null) {
            cVar.mo27273a("model", (Object) dVar.mo12872f());
        }
        if (dVar.mo12869d() != null) {
            cVar.mo27273a("hardware", (Object) dVar.mo12869d());
        }
        if (dVar.mo12867b() != null) {
            cVar.mo27273a(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX, (Object) dVar.mo12867b());
        }
        if (dVar.mo12874h() != null) {
            cVar.mo27273a(AppLovinEventTypes.USER_VIEWED_PRODUCT, (Object) dVar.mo12874h());
        }
        if (dVar.mo12873g() != null) {
            cVar.mo27273a("osBuild", (Object) dVar.mo12873g());
        }
        if (dVar.mo12870e() != null) {
            cVar.mo27273a("manufacturer", (Object) dVar.mo12870e());
        }
        if (dVar.mo12868c() != null) {
            cVar.mo27273a("fingerprint", (Object) dVar.mo12868c());
        }
    }
}
