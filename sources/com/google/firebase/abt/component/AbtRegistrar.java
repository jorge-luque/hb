package com.google.firebase.abt.component;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.analytics.p122a.C3619a;
import com.google.firebase.components.C3634d;
import com.google.firebase.components.C3637e;
import com.google.firebase.components.C3642g;
import com.google.firebase.components.C3643h;
import com.google.firebase.components.C3652n;
import com.google.firebase.p073h.C3686g;
import java.util.Arrays;
import java.util.List;

@Keep
/* compiled from: com.google.firebase:firebase-abt@@19.0.1 */
public class AbtRegistrar implements C3643h {
    static /* synthetic */ C3617a lambda$getComponents$0(C3637e eVar) {
        return new C3617a((Context) eVar.mo27220a(Context.class), (C3619a) eVar.mo27220a(C3619a.class));
    }

    public List<C3634d<?>> getComponents() {
        C3634d.C3636b<C3617a> a = C3634d.m12372a(C3617a.class);
        a.mo27232a(C3652n.m12430b(Context.class));
        a.mo27232a(C3652n.m12429a(C3619a.class));
        a.mo27231a((C3642g<C3617a>) C3618b.m12333a());
        return Arrays.asList(new C3634d[]{a.mo27233b(), C3686g.m12520a("fire-abt", "19.0.1")});
    }
}
