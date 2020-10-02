package com.google.firebase.analytics.connector.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.p122a.C3619a;
import com.google.firebase.components.C3634d;
import com.google.firebase.components.C3642g;
import com.google.firebase.components.C3643h;
import com.google.firebase.components.C3652n;
import com.google.firebase.p073h.C3686g;
import com.google.firebase.p123d.C3662d;
import java.util.Arrays;
import java.util.List;

@KeepForSdk
@Keep
/* compiled from: com.google.android.gms:play-services-measurement-api@@17.4.1 */
public class AnalyticsConnectorRegistrar implements C3643h {
    @SuppressLint({"MissingPermission"})
    @Keep
    @KeepForSdk
    public List<C3634d<?>> getComponents() {
        C3634d.C3636b<C3619a> a = C3634d.m12372a(C3619a.class);
        a.mo27232a(C3652n.m12430b(FirebaseApp.class));
        a.mo27232a(C3652n.m12430b(Context.class));
        a.mo27232a(C3652n.m12430b(C3662d.class));
        a.mo27231a((C3642g<C3619a>) C3625a.f10159a);
        a.mo27234c();
        return Arrays.asList(new C3634d[]{a.mo27233b(), C3686g.m12520a("fire-analytics", "17.4.1")});
    }
}
