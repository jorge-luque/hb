package com.google.android.datatransport.cct.p070b;

import com.google.firebase.encoders.C3670b;
import com.google.firebase.encoders.C3671c;
import com.google.firebase.encoders.EncodingException;
import java.io.IOException;

/* renamed from: com.google.android.datatransport.cct.b.q */
/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
public final class C2972q implements C3670b<C2953g> {
    /* renamed from: a */
    public void mo12866a(Object obj, Object obj2) throws EncodingException, IOException {
        C2953g gVar = (C2953g) obj;
        C3671c cVar = (C3671c) obj2;
        cVar.mo27272a("eventTimeMs", gVar.mo12890a()).mo27272a("eventUptimeMs", gVar.mo12891b()).mo27272a("timezoneOffsetSeconds", gVar.mo12892c());
        if (gVar.mo12896f() != null) {
            cVar.mo27273a("sourceExtension", (Object) gVar.mo12896f());
        }
        if (gVar.mo12897g() != null) {
            cVar.mo27273a("sourceExtensionJsonProto3", (Object) gVar.mo12897g());
        }
        if (gVar.mo12893d() != Integer.MIN_VALUE) {
            cVar.mo27271a("eventCode", gVar.mo12893d());
        }
        if (gVar.mo12894e() != null) {
            cVar.mo27273a("networkConnectionInfo", (Object) gVar.mo12894e());
        }
    }
}
