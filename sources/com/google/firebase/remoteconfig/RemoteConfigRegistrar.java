package com.google.firebase.remoteconfig;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.FirebaseApp;
import com.google.firebase.abt.component.C3617a;
import com.google.firebase.analytics.p122a.C3619a;
import com.google.firebase.components.C3634d;
import com.google.firebase.components.C3637e;
import com.google.firebase.components.C3642g;
import com.google.firebase.components.C3643h;
import com.google.firebase.components.C3652n;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.p073h.C3686g;
import java.util.Arrays;
import java.util.List;

@Keep
/* compiled from: com.google.firebase:firebase-config@@19.1.4 */
public class RemoteConfigRegistrar implements C3643h {
    static /* synthetic */ C3862k lambda$getComponents$0(C3637e eVar) {
        return new C3862k((Context) eVar.mo27220a(Context.class), (FirebaseApp) eVar.mo27220a(FirebaseApp.class), (FirebaseInstanceId) eVar.mo27220a(FirebaseInstanceId.class), ((C3617a) eVar.mo27220a(C3617a.class)).mo27191b("frc"), (C3619a) eVar.mo27220a(C3619a.class));
    }

    public List<C3634d<?>> getComponents() {
        C3634d.C3636b<C3862k> a = C3634d.m12372a(C3862k.class);
        a.mo27232a(C3652n.m12430b(Context.class));
        a.mo27232a(C3652n.m12430b(FirebaseApp.class));
        a.mo27232a(C3652n.m12430b(FirebaseInstanceId.class));
        a.mo27232a(C3652n.m12430b(C3617a.class));
        a.mo27232a(C3652n.m12429a(C3619a.class));
        a.mo27231a((C3642g<C3862k>) C3863l.m13096a());
        a.mo27234c();
        return Arrays.asList(new C3634d[]{a.mo27233b(), C3686g.m12520a("fire-rc", "19.1.4")});
    }
}
