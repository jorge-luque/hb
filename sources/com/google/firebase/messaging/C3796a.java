package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.encoders.C3670b;
import com.google.firebase.encoders.C3671c;
import com.tapjoy.TapjoyConstants;
import java.io.IOException;

@KeepForSdk
/* renamed from: com.google.firebase.messaging.a */
/* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
final class C3796a {

    /* renamed from: a */
    private final String f10503a;

    /* renamed from: b */
    private final Intent f10504b;

    /* renamed from: com.google.firebase.messaging.a$a */
    /* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
    static final class C3797a {

        /* renamed from: a */
        private final C3796a f10505a;

        C3797a(C3796a aVar) {
            this.f10505a = (C3796a) Preconditions.checkNotNull(aVar);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public final C3796a mo27485a() {
            return this.f10505a;
        }
    }

    /* renamed from: com.google.firebase.messaging.a$b */
    /* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
    static class C3798b implements C3670b<C3796a> {
        C3798b() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo12866a(Object obj, Object obj2) throws IOException {
            C3796a aVar = (C3796a) obj;
            C3671c cVar = (C3671c) obj2;
            Intent a = aVar.mo27483a();
            cVar.mo27271a("ttl", C3821u.m12904f(a));
            cVar.mo27273a(TapjoyConstants.TJC_SDK_TYPE_DEFAULT, (Object) aVar.mo27484b());
            cVar.mo27273a("instanceId", (Object) C3821u.m12899c());
            cVar.mo27271a("priority", C3821u.m12911m(a));
            cVar.mo27273a("packageName", (Object) C3821u.m12897b());
            cVar.mo27273a("sdkPlatform", (Object) "ANDROID");
            cVar.mo27273a("messageType", (Object) C3821u.m12909k(a));
            String j = C3821u.m12908j(a);
            if (j != null) {
                cVar.mo27273a("messageId", (Object) j);
            }
            String l = C3821u.m12910l(a);
            if (l != null) {
                cVar.mo27273a("topic", (Object) l);
            }
            String g = C3821u.m12905g(a);
            if (g != null) {
                cVar.mo27273a("collapseKey", (Object) g);
            }
            if (C3821u.m12907i(a) != null) {
                cVar.mo27273a("analyticsLabel", (Object) C3821u.m12907i(a));
            }
            if (C3821u.m12906h(a) != null) {
                cVar.mo27273a("composerLabel", (Object) C3821u.m12906h(a));
            }
            String d = C3821u.m12901d();
            if (d != null) {
                cVar.mo27273a("projectNumber", (Object) d);
            }
        }
    }

    /* renamed from: com.google.firebase.messaging.a$c */
    /* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
    static final class C3799c implements C3670b<C3797a> {
        C3799c() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo12866a(Object obj, Object obj2) throws IOException {
            ((C3671c) obj2).mo27273a("messaging_client_event", (Object) ((C3797a) obj).mo27485a());
        }
    }

    C3796a(String str, Intent intent) {
        this.f10503a = Preconditions.checkNotEmpty(str, "evenType must be non-null");
        this.f10504b = (Intent) Preconditions.checkNotNull(intent, "intent must be non-null");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final Intent mo27483a() {
        return this.f10504b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final String mo27484b() {
        return this.f10503a;
    }
}
