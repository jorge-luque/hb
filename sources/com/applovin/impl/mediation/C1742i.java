package com.applovin.impl.mediation;

import android.text.TextUtils;
import com.applovin.impl.mediation.p045b.C1701e;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapters.MediationAdapterBase;
import com.applovin.sdk.AppLovinSdk;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.applovin.impl.mediation.i */
public class C1742i {

    /* renamed from: a */
    private final C1941j f5405a;

    /* renamed from: b */
    private final C1977q f5406b;

    /* renamed from: c */
    private final Object f5407c = new Object();

    /* renamed from: d */
    private final Map<String, Class<? extends MaxAdapter>> f5408d = new HashMap();

    /* renamed from: e */
    private final Set<String> f5409e = new HashSet();

    public C1742i(C1941j jVar) {
        if (jVar != null) {
            this.f5405a = jVar;
            this.f5406b = jVar.mo8602v();
            return;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    /* renamed from: a */
    private C1743j m6661a(C1701e eVar, Class<? extends MaxAdapter> cls) {
        try {
            C1743j jVar = new C1743j(eVar, (MediationAdapterBase) cls.getConstructor(new Class[]{AppLovinSdk.class}).newInstance(new Object[]{this.f5405a.mo8540S()}), this.f5405a);
            if (jVar.mo7904d()) {
                return jVar;
            }
            C1977q.m7751i("MediationAdapterManager", "Adapter is disabled after initialization: " + eVar);
            return null;
        } catch (Throwable th) {
            C1977q.m7747c("MediationAdapterManager", "Failed to load adapter: " + eVar, th);
            return null;
        }
    }

    /* renamed from: a */
    private Class<? extends MaxAdapter> m6662a(String str) {
        Class<MaxAdapter> cls = MaxAdapter.class;
        try {
            Class<?> cls2 = Class.forName(str);
            if (cls.isAssignableFrom(cls2)) {
                return cls2.asSubclass(cls);
            }
            C1977q.m7751i("MediationAdapterManager", str + " error: not an instance of '" + cls.getName() + "'.");
            return null;
        } catch (Throwable th) {
            C1977q.m7747c("MediationAdapterManager", "Failed to load: " + str, th);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1743j mo7893a(C1701e eVar) {
        Class<? extends MaxAdapter> cls;
        C1977q qVar;
        String str;
        if (eVar != null) {
            String E = eVar.mo7813E();
            String D = eVar.mo7812D();
            if (TextUtils.isEmpty(E)) {
                qVar = this.f5406b;
                str = "No adapter name provided for " + D + ", not loading the adapter ";
            } else if (TextUtils.isEmpty(D)) {
                qVar = this.f5406b;
                str = "Unable to find default classname for '" + E + "'";
            } else {
                synchronized (this.f5407c) {
                    if (!this.f5409e.contains(D)) {
                        if (this.f5408d.containsKey(D)) {
                            cls = this.f5408d.get(D);
                        } else {
                            cls = m6662a(D);
                            if (cls == null) {
                                this.f5409e.add(D);
                                return null;
                            }
                        }
                        C1743j a = m6661a(eVar, cls);
                        if (a != null) {
                            this.f5406b.mo8742b("MediationAdapterManager", "Loaded " + E);
                            this.f5408d.put(D, cls);
                            return a;
                        }
                        this.f5406b.mo8746e("MediationAdapterManager", "Failed to load " + E);
                        this.f5409e.add(D);
                        return null;
                    }
                    this.f5406b.mo8742b("MediationAdapterManager", "Not attempting to load " + E + " due to prior errors");
                    return null;
                }
            }
            qVar.mo8746e("MediationAdapterManager", str);
            return null;
        }
        throw new IllegalArgumentException("No adapter spec specified");
    }

    /* renamed from: a */
    public Collection<String> mo7894a() {
        Set unmodifiableSet;
        synchronized (this.f5407c) {
            HashSet hashSet = new HashSet(this.f5408d.size());
            for (Class<? extends MaxAdapter> name : this.f5408d.values()) {
                hashSet.add(name.getName());
            }
            unmodifiableSet = Collections.unmodifiableSet(hashSet);
        }
        return unmodifiableSet;
    }

    /* renamed from: b */
    public Collection<String> mo7895b() {
        Set<T> unmodifiableSet;
        synchronized (this.f5407c) {
            unmodifiableSet = Collections.unmodifiableSet(this.f5409e);
        }
        return unmodifiableSet;
    }
}
