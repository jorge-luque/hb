package com.google.android.datatransport.cct.p070b;

import com.google.firebase.encoders.C3670b;
import com.google.firebase.encoders.C3671c;
import com.google.firebase.encoders.EncodingException;
import java.io.IOException;

/* renamed from: com.google.android.datatransport.cct.b.n */
/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
public final class C2968n implements C3670b<C2950f> {
    /* renamed from: a */
    public void mo12866a(Object obj, Object obj2) throws EncodingException, IOException {
        C2950f fVar = (C2950f) obj;
        C3671c cVar = (C3671c) obj2;
        if (fVar.mo12883c() != null) {
            cVar.mo27273a("clientType", (Object) fVar.mo12883c().name());
        }
        if (fVar.mo12882b() != null) {
            cVar.mo27273a("androidClientInfo", (Object) fVar.mo12882b());
        }
    }
}
