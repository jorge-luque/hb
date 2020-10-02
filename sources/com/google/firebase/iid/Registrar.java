package com.google.firebase.iid;

import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.C3634d;
import com.google.firebase.components.C3642g;
import com.google.firebase.components.C3643h;
import com.google.firebase.components.C3652n;
import com.google.firebase.iid.p128b.C3693a;
import com.google.firebase.installations.C3764h;
import com.google.firebase.p073h.C3686g;
import com.google.firebase.p073h.C3687h;
import com.google.firebase.p123d.C3662d;
import com.google.firebase.p124e.C3666c;
import java.util.Arrays;
import java.util.List;

@KeepForSdk
@Keep
/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
public final class Registrar implements C3643h {

    /* renamed from: com.google.firebase.iid.Registrar$a */
    /* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
    private static class C3689a implements C3693a {
        public C3689a(FirebaseInstanceId firebaseInstanceId) {
        }
    }

    @Keep
    public final List<C3634d<?>> getComponents() {
        Class<FirebaseInstanceId> cls = FirebaseInstanceId.class;
        C3634d.C3636b<FirebaseInstanceId> a = C3634d.m12372a(cls);
        a.mo27232a(C3652n.m12430b(FirebaseApp.class));
        a.mo27232a(C3652n.m12430b(C3662d.class));
        a.mo27232a(C3652n.m12430b(C3687h.class));
        a.mo27232a(C3652n.m12430b(C3666c.class));
        a.mo27232a(C3652n.m12430b(C3764h.class));
        a.mo27231a((C3642g<FirebaseInstanceId>) C3735s.f10370a);
        a.mo27230a();
        C3634d<FirebaseInstanceId> b = a.mo27233b();
        C3634d.C3636b<C3693a> a2 = C3634d.m12372a(C3693a.class);
        a2.mo27232a(C3652n.m12430b(cls));
        a2.mo27231a((C3642g<C3693a>) C3737t.f10372a);
        return Arrays.asList(new C3634d[]{b, a2.mo27233b(), C3686g.m12520a("fire-iid", "20.1.7")});
    }
}
