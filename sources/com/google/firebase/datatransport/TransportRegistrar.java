package com.google.firebase.datatransport;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.components.C3634d;
import com.google.firebase.components.C3642g;
import com.google.firebase.components.C3643h;
import com.google.firebase.components.C3652n;
import java.util.Collections;
import java.util.List;
import p093e.p101c.p102a.p103a.C3383g;

@Keep
/* compiled from: com.google.firebase:firebase-datatransport@@17.0.3 */
public class TransportRegistrar implements C3643h {
    public List<C3634d<?>> getComponents() {
        C3634d.C3636b<C3383g> a = C3634d.m12372a(C3383g.class);
        a.mo27232a(C3652n.m12430b(Context.class));
        a.mo27231a((C3642g<C3383g>) C3663a.m12456a());
        return Collections.singletonList(a.mo27233b());
    }
}
