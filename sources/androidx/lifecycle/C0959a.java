package androidx.lifecycle;

import androidx.lifecycle.C0965e;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: androidx.lifecycle.a */
/* compiled from: ClassesInfoCache */
class C0959a {

    /* renamed from: c */
    static C0959a f2508c = new C0959a();

    /* renamed from: a */
    private final Map<Class, C0960a> f2509a = new HashMap();

    /* renamed from: b */
    private final Map<Class, Boolean> f2510b = new HashMap();

    /* renamed from: androidx.lifecycle.a$b */
    /* compiled from: ClassesInfoCache */
    static class C0961b {

        /* renamed from: a */
        final int f2513a;

        /* renamed from: b */
        final Method f2514b;

        C0961b(int i, Method method) {
            this.f2513a = i;
            this.f2514b = method;
            method.setAccessible(true);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo4985a(C0970h hVar, C0965e.C0966a aVar, Object obj) {
            try {
                int i = this.f2513a;
                if (i == 0) {
                    this.f2514b.invoke(obj, new Object[0]);
                } else if (i == 1) {
                    this.f2514b.invoke(obj, new Object[]{hVar});
                } else if (i == 2) {
                    this.f2514b.invoke(obj, new Object[]{hVar, aVar});
                }
            } catch (InvocationTargetException e) {
                throw new RuntimeException("Failed to call observer method", e.getCause());
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || C0961b.class != obj.getClass()) {
                return false;
            }
            C0961b bVar = (C0961b) obj;
            if (this.f2513a != bVar.f2513a || !this.f2514b.getName().equals(bVar.f2514b.getName())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.f2513a * 31) + this.f2514b.getName().hashCode();
        }
    }

    C0959a() {
    }

    /* renamed from: c */
    private Method[] m3440c(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0960a mo4982a(Class cls) {
        C0960a aVar = this.f2509a.get(cls);
        if (aVar != null) {
            return aVar;
        }
        return m3438a(cls, (Method[]) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo4983b(Class cls) {
        Boolean bool = this.f2510b.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] c = m3440c(cls);
        for (Method annotation : c) {
            if (((C0979o) annotation.getAnnotation(C0979o.class)) != null) {
                m3438a(cls, c);
                return true;
            }
        }
        this.f2510b.put(cls, false);
        return false;
    }

    /* renamed from: androidx.lifecycle.a$a */
    /* compiled from: ClassesInfoCache */
    static class C0960a {

        /* renamed from: a */
        final Map<C0965e.C0966a, List<C0961b>> f2511a = new HashMap();

        /* renamed from: b */
        final Map<C0961b, C0965e.C0966a> f2512b;

        C0960a(Map<C0961b, C0965e.C0966a> map) {
            this.f2512b = map;
            for (Map.Entry next : map.entrySet()) {
                C0965e.C0966a aVar = (C0965e.C0966a) next.getValue();
                List list = this.f2511a.get(aVar);
                if (list == null) {
                    list = new ArrayList();
                    this.f2511a.put(aVar, list);
                }
                list.add(next.getKey());
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo4984a(C0970h hVar, C0965e.C0966a aVar, Object obj) {
            m3443a(this.f2511a.get(aVar), hVar, aVar, obj);
            m3443a(this.f2511a.get(C0965e.C0966a.ON_ANY), hVar, aVar, obj);
        }

        /* renamed from: a */
        private static void m3443a(List<C0961b> list, C0970h hVar, C0965e.C0966a aVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).mo4985a(hVar, aVar, obj);
                }
            }
        }
    }

    /* renamed from: a */
    private void m3439a(Map<C0961b, C0965e.C0966a> map, C0961b bVar, C0965e.C0966a aVar, Class cls) {
        C0965e.C0966a aVar2 = map.get(bVar);
        if (aVar2 != null && aVar != aVar2) {
            Method method = bVar.f2514b;
            throw new IllegalArgumentException("Method " + method.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + aVar2 + ", new value " + aVar);
        } else if (aVar2 == null) {
            map.put(bVar, aVar);
        }
    }

    /* renamed from: a */
    private C0960a m3438a(Class cls, Method[] methodArr) {
        int i;
        C0960a a;
        Class superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (!(superclass == null || (a = mo4982a(superclass)) == null)) {
            hashMap.putAll(a.f2512b);
        }
        for (Class a2 : cls.getInterfaces()) {
            for (Map.Entry next : mo4982a(a2).f2512b.entrySet()) {
                m3439a(hashMap, (C0961b) next.getKey(), (C0965e.C0966a) next.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = m3440c(cls);
        }
        boolean z = false;
        for (Method method : methodArr) {
            C0979o oVar = (C0979o) method.getAnnotation(C0979o.class);
            if (oVar != null) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else if (parameterTypes[0].isAssignableFrom(C0970h.class)) {
                    i = 1;
                } else {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                }
                C0965e.C0966a value = oVar.value();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(C0965e.C0966a.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    } else if (value == C0965e.C0966a.ON_ANY) {
                        i = 2;
                    } else {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                }
                if (parameterTypes.length <= 2) {
                    m3439a(hashMap, new C0961b(i, method), value, cls);
                    z = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        C0960a aVar = new C0960a(hashMap);
        this.f2509a.put(cls, aVar);
        this.f2510b.put(cls, Boolean.valueOf(z));
        return aVar;
    }
}
