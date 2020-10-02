package com.google.firebase.messaging;

import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.C3634d;
import com.google.firebase.components.C3642g;
import com.google.firebase.components.C3643h;
import com.google.firebase.components.C3652n;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.installations.C3764h;
import com.google.firebase.p073h.C3686g;
import com.google.firebase.p073h.C3687h;
import com.google.firebase.p124e.C3666c;
import java.util.Arrays;
import java.util.List;
import p093e.p101c.p102a.p103a.C3378b;
import p093e.p101c.p102a.p103a.C3379c;
import p093e.p101c.p102a.p103a.C3381e;
import p093e.p101c.p102a.p103a.C3382f;
import p093e.p101c.p102a.p103a.C3383g;

@KeepForSdk
@Keep
/* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
public class FirebaseMessagingRegistrar implements C3643h {

    /* renamed from: com.google.firebase.messaging.FirebaseMessagingRegistrar$a */
    /* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
    private static class C3794a<T> implements C3382f<T> {
        private C3794a() {
        }

        /* renamed from: a */
        public final void mo19150a(C3379c<T> cVar) {
        }
    }

    /* renamed from: com.google.firebase.messaging.FirebaseMessagingRegistrar$b */
    /* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
    public static class C3795b implements C3383g {
        /* renamed from: a */
        public final <T> C3382f<T> mo19151a(String str, Class<T> cls, C3378b bVar, C3381e<T, byte[]> eVar) {
            return new C3794a();
        }
    }

    @Keep
    public List<C3634d<?>> getComponents() {
        C3634d.C3636b<FirebaseMessaging> a = C3634d.m12372a(FirebaseMessaging.class);
        a.mo27232a(C3652n.m12430b(FirebaseApp.class));
        a.mo27232a(C3652n.m12430b(FirebaseInstanceId.class));
        a.mo27232a(C3652n.m12430b(C3687h.class));
        a.mo27232a(C3652n.m12430b(C3666c.class));
        a.mo27232a(C3652n.m12429a(C3383g.class));
        a.mo27232a(C3652n.m12430b(C3764h.class));
        a.mo27231a((C3642g<FirebaseMessaging>) C3817q.f10558a);
        a.mo27230a();
        return Arrays.asList(new C3634d[]{a.mo27233b(), C3686g.m12520a("fire-fcm", "20.1.7")});
    }
}
