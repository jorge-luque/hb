package com.google.android.datatransport.cct.p070b;

import com.google.firebase.encoders.C3670b;
import com.google.firebase.encoders.C3671c;
import com.google.firebase.encoders.EncodingException;
import java.io.IOException;

/* renamed from: com.google.android.datatransport.cct.b.s */
/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
public final class C2975s implements C3670b<C2956h> {
    /* renamed from: a */
    public void mo12866a(Object obj, Object obj2) throws EncodingException, IOException {
        C2956h hVar = (C2956h) obj;
        C3671c cVar = (C3671c) obj2;
        cVar.mo27272a("requestTimeMs", hVar.mo12913f()).mo27272a("requestUptimeMs", hVar.mo12914g());
        if (hVar.mo12908b() != null) {
            cVar.mo27273a("clientInfo", (Object) hVar.mo12908b());
        }
        if (hVar.mo12911e() != null) {
            cVar.mo27273a("logSourceName", (Object) hVar.mo12911e());
        } else if (hVar.mo12910d() != Integer.MIN_VALUE) {
            cVar.mo27271a("logSource", hVar.mo12910d());
        } else {
            throw new EncodingException("Log request must have either LogSourceName or LogSource");
        }
        if (!hVar.mo12909c().isEmpty()) {
            cVar.mo27273a("logEvent", (Object) hVar.mo12909c());
        }
    }
}
