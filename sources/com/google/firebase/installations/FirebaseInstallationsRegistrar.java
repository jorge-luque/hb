package com.google.firebase.installations;

import androidx.annotation.Keep;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.C3634d;
import com.google.firebase.components.C3637e;
import com.google.firebase.components.C3642g;
import com.google.firebase.components.C3643h;
import com.google.firebase.components.C3652n;
import com.google.firebase.p073h.C3686g;
import com.google.firebase.p073h.C3687h;
import com.google.firebase.p124e.C3666c;
import java.util.Arrays;
import java.util.List;

@Keep
/* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
public class FirebaseInstallationsRegistrar implements C3643h {
    static /* synthetic */ C3764h lambda$getComponents$0(C3637e eVar) {
        return new C3761g((FirebaseApp) eVar.mo27220a(FirebaseApp.class), (C3687h) eVar.mo27220a(C3687h.class), (C3666c) eVar.mo27220a(C3666c.class));
    }

    public List<C3634d<?>> getComponents() {
        C3634d.C3636b<C3764h> a = C3634d.m12372a(C3764h.class);
        a.mo27232a(C3652n.m12430b(FirebaseApp.class));
        a.mo27232a(C3652n.m12430b(C3666c.class));
        a.mo27232a(C3652n.m12430b(C3687h.class));
        a.mo27231a((C3642g<C3764h>) C3765i.m12692a());
        return Arrays.asList(new C3634d[]{a.mo27233b(), C3686g.m12520a("fire-installations", "16.3.0")});
    }
}
