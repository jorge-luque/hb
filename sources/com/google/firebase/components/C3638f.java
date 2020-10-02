package com.google.firebase.components;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import com.ogury.p159cm.OguryChoiceManager;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.firebase.components.f */
/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
public final class C3638f<T> {

    /* renamed from: a */
    private final T f10195a;

    /* renamed from: b */
    private final C3641c<T> f10196b;

    /* renamed from: com.google.firebase.components.f$b */
    /* compiled from: com.google.firebase:firebase-components@@16.0.0 */
    private static class C3640b implements C3641c<Context> {

        /* renamed from: a */
        private final Class<? extends Service> f10197a;

        /* renamed from: b */
        private Bundle m12402b(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("ComponentDiscovery", "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, this.f10197a), OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
                if (serviceInfo != null) {
                    return serviceInfo.metaData;
                }
                Log.w("ComponentDiscovery", this.f10197a + " has no service info.");
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("ComponentDiscovery", "Application info not found.");
                return null;
            }
        }

        private C3640b(Class<? extends Service> cls) {
            this.f10197a = cls;
        }

        /* renamed from: a */
        public List<String> mo27239a(Context context) {
            Bundle b = m12402b(context);
            if (b == null) {
                Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (String str : b.keySet()) {
                if ("com.google.firebase.components.ComponentRegistrar".equals(b.get(str)) && str.startsWith("com.google.firebase.components:")) {
                    arrayList.add(str.substring(31));
                }
            }
            return arrayList;
        }
    }

    /* renamed from: com.google.firebase.components.f$c */
    /* compiled from: com.google.firebase:firebase-components@@16.0.0 */
    interface C3641c<T> {
        /* renamed from: a */
        List<String> mo27239a(T t);
    }

    C3638f(T t, C3641c<T> cVar) {
        this.f10195a = t;
        this.f10196b = cVar;
    }

    /* renamed from: a */
    public static C3638f<Context> m12399a(Context context, Class<? extends Service> cls) {
        return new C3638f<>(context, new C3640b(cls));
    }

    /* renamed from: a */
    public List<C3643h> mo27237a() {
        return m12400a(this.f10196b.mo27239a(this.f10195a));
    }

    /* renamed from: a */
    private static List<C3643h> m12400a(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String next : list) {
            try {
                Class<?> cls = Class.forName(next);
                if (!C3643h.class.isAssignableFrom(cls)) {
                    Log.w("ComponentDiscovery", String.format("Class %s is not an instance of %s", new Object[]{next, "com.google.firebase.components.ComponentRegistrar"}));
                } else {
                    arrayList.add((C3643h) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                }
            } catch (ClassNotFoundException e) {
                Log.w("ComponentDiscovery", String.format("Class %s is not an found.", new Object[]{next}), e);
            } catch (IllegalAccessException e2) {
                Log.w("ComponentDiscovery", String.format("Could not instantiate %s.", new Object[]{next}), e2);
            } catch (InstantiationException e3) {
                Log.w("ComponentDiscovery", String.format("Could not instantiate %s.", new Object[]{next}), e3);
            } catch (NoSuchMethodException e4) {
                Log.w("ComponentDiscovery", String.format("Could not instantiate %s", new Object[]{next}), e4);
            } catch (InvocationTargetException e5) {
                Log.w("ComponentDiscovery", String.format("Could not instantiate %s", new Object[]{next}), e5);
            }
        }
        return arrayList;
    }
}
