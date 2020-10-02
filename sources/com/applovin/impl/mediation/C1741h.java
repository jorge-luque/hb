package com.applovin.impl.mediation;

import android.app.Activity;
import com.applovin.impl.mediation.p045b.C1701e;
import com.applovin.impl.mediation.p046c.C1708a;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.p052d.C1864a;
import com.applovin.impl.sdk.utils.C1993i;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.facebook.internal.AnalyticsEvents;
import java.util.LinkedHashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.h */
public class C1741h {

    /* renamed from: a */
    private final C1941j f5399a;

    /* renamed from: b */
    private final C1977q f5400b;

    /* renamed from: c */
    private final AtomicBoolean f5401c = new AtomicBoolean();

    /* renamed from: d */
    private final JSONArray f5402d = new JSONArray();

    /* renamed from: e */
    private final LinkedHashSet<String> f5403e = new LinkedHashSet<>();

    /* renamed from: f */
    private final Object f5404f = new Object();

    public C1741h(C1941j jVar) {
        this.f5399a = jVar;
        this.f5400b = jVar.mo8602v();
    }

    /* renamed from: a */
    public void mo7886a(Activity activity) {
        if (this.f5401c.compareAndSet(false, true)) {
            this.f5399a.mo8533L().mo8474a((C1864a) new C1708a(activity, this.f5399a));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7887a(C1701e eVar, long j, MaxAdapter.InitializationStatus initializationStatus, String str) {
        boolean z;
        if (initializationStatus != null && initializationStatus != MaxAdapter.InitializationStatus.INITIALIZING) {
            synchronized (this.f5404f) {
                z = !mo7890a(eVar);
                if (z) {
                    this.f5403e.add(eVar.mo7812D());
                    JSONObject jSONObject = new JSONObject();
                    C1993i.m7886a(jSONObject, "class", eVar.mo7812D(), this.f5399a);
                    C1993i.m7886a(jSONObject, "init_status", String.valueOf(initializationStatus.getCode()), this.f5399a);
                    C1993i.m7886a(jSONObject, AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE, JSONObject.quote(str), this.f5399a);
                    this.f5402d.put(jSONObject);
                }
            }
            if (z) {
                this.f5399a.mo8555a(eVar);
                this.f5399a.mo8605y().maybeScheduleAdapterInitializationPostback(eVar, j, initializationStatus, str);
                this.f5399a.mo8567ac().mo8506a(initializationStatus, eVar.mo7812D());
            }
        }
    }

    /* renamed from: a */
    public void mo7888a(C1701e eVar, Activity activity) {
        C1743j a = this.f5399a.mo8603w().mo7893a(eVar);
        if (a != null) {
            C1977q qVar = this.f5400b;
            qVar.mo8744c("MediationAdapterInitializationManager", "Initializing adapter " + eVar);
            a.mo7898a((MaxAdapterInitializationParameters) MaxAdapterParametersImpl.m6242a(eVar, activity.getApplicationContext()), activity);
        }
    }

    /* renamed from: a */
    public boolean mo7889a() {
        return this.f5401c.get();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo7890a(C1701e eVar) {
        boolean contains;
        synchronized (this.f5404f) {
            contains = this.f5403e.contains(eVar.mo7812D());
        }
        return contains;
    }

    /* renamed from: b */
    public LinkedHashSet<String> mo7891b() {
        LinkedHashSet<String> linkedHashSet;
        synchronized (this.f5404f) {
            linkedHashSet = this.f5403e;
        }
        return linkedHashSet;
    }

    /* renamed from: c */
    public JSONArray mo7892c() {
        JSONArray jSONArray;
        synchronized (this.f5404f) {
            jSONArray = this.f5402d;
        }
        return jSONArray;
    }
}
