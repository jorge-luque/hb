package com.google.android.datatransport.cct.p070b;

import com.google.firebase.encoders.C3670b;
import com.google.firebase.encoders.C3671c;
import com.google.firebase.encoders.EncodingException;
import java.io.IOException;

/* renamed from: com.google.android.datatransport.cct.b.v */
/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
public final class C2981v implements C3670b<C2960j> {
    /* renamed from: a */
    public void mo12866a(Object obj, Object obj2) throws EncodingException, IOException {
        C2960j jVar = (C2960j) obj;
        C3671c cVar = (C3671c) obj2;
        if (jVar.mo12929b() != null) {
            cVar.mo27273a("mobileSubtype", (Object) jVar.mo12929b().name());
        }
        if (jVar.mo12930c() != null) {
            cVar.mo27273a("networkType", (Object) jVar.mo12930c().name());
        }
    }
}
