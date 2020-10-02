package com.google.android.datatransport.runtime.backends;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import com.ogury.p159cm.OguryChoiceManager;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.datatransport.runtime.backends.k */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
class C3002k implements C2994e {

    /* renamed from: a */
    private final C3003a f8359a;

    /* renamed from: b */
    private final C3000i f8360b;

    /* renamed from: c */
    private final Map<String, C3005m> f8361c;

    C3002k(Context context, C3000i iVar) {
        this(new C3003a(context), iVar);
    }

    public synchronized C3005m get(String str) {
        if (this.f8361c.containsKey(str)) {
            return this.f8361c.get(str);
        }
        C2993d a = this.f8359a.mo12970a(str);
        if (a == null) {
            return null;
        }
        C3005m create = a.create(this.f8360b.mo12968a(str));
        this.f8361c.put(str, create);
        return create;
    }

    C3002k(C3003a aVar, C3000i iVar) {
        this.f8361c = new HashMap();
        this.f8359a = aVar;
        this.f8360b = iVar;
    }

    /* renamed from: com.google.android.datatransport.runtime.backends.k$a */
    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    static class C3003a {

        /* renamed from: a */
        private final Context f8362a;

        /* renamed from: b */
        private Map<String, String> f8363b = null;

        C3003a(Context context) {
            this.f8362a = context;
        }

        /* renamed from: b */
        private static Bundle m9881b(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("BackendRegistry", "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, TransportBackendDiscovery.class), OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
                if (serviceInfo != null) {
                    return serviceInfo.metaData;
                }
                Log.w("BackendRegistry", "TransportBackendDiscovery has no service info.");
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("BackendRegistry", "Application info not found.");
                return null;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C2993d mo12970a(String str) {
            String str2 = m9879a().get(str);
            if (str2 == null) {
                return null;
            }
            try {
                return (C2993d) Class.forName(str2).asSubclass(C2993d.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException e) {
                Log.w("BackendRegistry", String.format("Class %s is not found.", new Object[]{str2}), e);
                return null;
            } catch (IllegalAccessException e2) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s.", new Object[]{str2}), e2);
                return null;
            } catch (InstantiationException e3) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s.", new Object[]{str2}), e3);
                return null;
            } catch (NoSuchMethodException e4) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s", new Object[]{str2}), e4);
                return null;
            } catch (InvocationTargetException e5) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s", new Object[]{str2}), e5);
                return null;
            }
        }

        /* renamed from: a */
        private Map<String, String> m9879a() {
            if (this.f8363b == null) {
                this.f8363b = m9880a(this.f8362a);
            }
            return this.f8363b;
        }

        /* renamed from: a */
        private Map<String, String> m9880a(Context context) {
            Bundle b = m9881b(context);
            if (b == null) {
                Log.w("BackendRegistry", "Could not retrieve metadata, returning empty list of transport backends.");
                return Collections.emptyMap();
            }
            HashMap hashMap = new HashMap();
            for (String str : b.keySet()) {
                Object obj = b.get(str);
                if ((obj instanceof String) && str.startsWith("backend:")) {
                    for (String trim : ((String) obj).split(",", -1)) {
                        String trim2 = trim.trim();
                        if (!trim2.isEmpty()) {
                            hashMap.put(trim2, str.substring(8));
                        }
                    }
                }
            }
            return hashMap;
        }
    }
}
