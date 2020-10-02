package com.google.firebase.analytics.p122a;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.C3614a;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.internal.C3626b;
import com.google.firebase.analytics.p122a.C3619a;
import com.google.firebase.p123d.C3659a;
import com.google.firebase.p123d.C3662d;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.google.firebase.analytics.a.b */
/* compiled from: com.google.android.gms:play-services-measurement-api@@17.4.1 */
public class C3621b implements C3619a {

    /* renamed from: b */
    private static volatile C3619a f10154b;
    @VisibleForTesting

    /* renamed from: a */
    private final AppMeasurement f10155a;

    private C3621b(AppMeasurement appMeasurement) {
        Preconditions.checkNotNull(appMeasurement);
        this.f10155a = appMeasurement;
        new ConcurrentHashMap();
    }

    @KeepForSdk
    /* renamed from: a */
    public static C3619a m12340a(FirebaseApp firebaseApp, Context context, C3662d dVar) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(dVar);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (f10154b == null) {
            synchronized (C3621b.class) {
                if (f10154b == null) {
                    Bundle bundle = new Bundle(1);
                    if (firebaseApp.mo27175e()) {
                        dVar.mo27261a(C3614a.class, C3623d.f10157a, C3622c.f10156a);
                        bundle.putBoolean("dataCollectionDefaultEnabled", firebaseApp.isDataCollectionDefaultEnabled());
                    }
                    f10154b = new C3621b(AppMeasurement.zza(context, bundle));
                }
            }
        }
        return f10154b;
    }

    @KeepForSdk
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        if (str2 == null || C3626b.m12350a(str2, bundle)) {
            this.f10155a.clearConditionalUserProperty(str, str2, bundle);
        }
    }

    @KeepForSdk
    public List<C3619a.C3620a> getConditionalUserProperties(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        for (AppMeasurement.ConditionalUserProperty a : this.f10155a.getConditionalUserProperties(str, str2)) {
            arrayList.add(C3626b.m12347a(a));
        }
        return arrayList;
    }

    @KeepForSdk
    public int getMaxUserProperties(String str) {
        return this.f10155a.getMaxUserProperties(str);
    }

    @KeepForSdk
    public void logEvent(String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (C3626b.m12349a(str) && C3626b.m12350a(str2, bundle) && C3626b.m12352a(str, str2, bundle)) {
            C3626b.m12354b(str, str2, bundle);
            this.f10155a.logEventInternal(str, str2, bundle);
        }
    }

    @KeepForSdk
    /* renamed from: a */
    public void mo27199a(String str, String str2, Object obj) {
        if (C3626b.m12349a(str) && C3626b.m12351a(str, str2)) {
            this.f10155a.setUserPropertyInternal(str, str2, obj);
        }
    }

    @KeepForSdk
    /* renamed from: a */
    public Map<String, Object> mo27197a(boolean z) {
        return this.f10155a.getUserProperties(z);
    }

    @KeepForSdk
    /* renamed from: a */
    public void mo27198a(C3619a.C3620a aVar) {
        if (C3626b.m12348a(aVar)) {
            this.f10155a.setConditionalUserProperty(C3626b.m12353b(aVar));
        }
    }

    /* renamed from: a */
    static final /* synthetic */ void m12341a(C3659a aVar) {
        boolean z = ((C3614a) aVar.mo27262a()).f10119a;
        synchronized (C3621b.class) {
            ((C3621b) f10154b).f10155a.zza(z);
        }
    }
}
