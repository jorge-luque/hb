package com.moat.analytics.mobile.vng;

import com.moat.analytics.mobile.vng.C4424w;
import com.moat.analytics.mobile.vng.p156a.p157a.C4373a;
import com.moat.analytics.mobile.vng.p156a.p158b.C4374a;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.moat.analytics.mobile.vng.x */
class C4434x<T> implements InvocationHandler {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Object[] f11884a = new Object[0];

    /* renamed from: b */
    private final C4436a<T> f11885b;

    /* renamed from: c */
    private final Class<T> f11886c;

    /* renamed from: d */
    private final LinkedList<C4434x<T>.C1155b> f11887d = new LinkedList<>();

    /* renamed from: e */
    private boolean f11888e;

    /* renamed from: f */
    private T f11889f;

    /* renamed from: com.moat.analytics.mobile.vng.x$a */
    interface C4436a<T> {
        /* renamed from: a */
        C4374a<T> mo29234a();
    }

    /* renamed from: com.moat.analytics.mobile.vng.x$b */
    private class C4437b {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final WeakReference[] f11892b;

        /* renamed from: c */
        private final LinkedList<Object> f11893c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public final Method f11894d;

        private C4437b(Method method, Object... objArr) {
            this.f11893c = new LinkedList<>();
            objArr = objArr == null ? C4434x.f11884a : objArr;
            WeakReference[] weakReferenceArr = new WeakReference[objArr.length];
            int length = objArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                Object obj = objArr[i];
                if ((obj instanceof Map) || (obj instanceof Integer) || (obj instanceof Double)) {
                    this.f11893c.add(obj);
                }
                weakReferenceArr[i2] = new WeakReference(obj);
                i++;
                i2++;
            }
            this.f11892b = weakReferenceArr;
            this.f11894d = method;
        }
    }

    C4434x(C4436a<T> aVar, Class<T> cls) {
        C4373a.m14623a(aVar);
        C4373a.m14623a(cls);
        this.f11885b = aVar;
        this.f11886c = cls;
        C4424w.m14808a().mo29340a((C4424w.C4430b) new C4424w.C4430b() {
            /* renamed from: b */
            public void mo29327b() {
                C4434x.this.m14836c();
            }

            /* renamed from: c */
            public void mo29328c() {
            }
        });
    }

    /* renamed from: a */
    static <T> T m14829a(C4436a<T> aVar, Class<T> cls) {
        ClassLoader classLoader = cls.getClassLoader();
        C4434x xVar = new C4434x(aVar, cls);
        return Proxy.newProxyInstance(classLoader, new Class[]{cls}, xVar);
    }

    /* renamed from: a */
    private Object m14830a(Method method) {
        try {
            return Boolean.TYPE.equals(method.getReturnType()) ? true : null;
        } catch (Exception e) {
            C4403n.m14758a(e);
            return null;
        }
    }

    /* renamed from: a */
    private Object m14831a(Method method, Object[] objArr) {
        Class<?> declaringClass = method.getDeclaringClass();
        C4424w a = C4424w.m14808a();
        if (Object.class.equals(declaringClass)) {
            String name = method.getName();
            if ("getClass".equals(name)) {
                return this.f11886c;
            }
            boolean equals = "toString".equals(name);
            Object invoke = method.invoke(this, objArr);
            if (!equals) {
                return invoke;
            }
            String name2 = C4434x.class.getName();
            String name3 = this.f11886c.getName();
            return (invoke + "").replace(name2, name3);
        } else if (!this.f11888e || this.f11889f != null) {
            if (a.f11856a == C4424w.C4432d.ON) {
                m14836c();
                T t = this.f11889f;
                if (t != null) {
                    return method.invoke(t, objArr);
                }
            }
            if (a.f11856a == C4424w.C4432d.OFF && (!this.f11888e || this.f11889f != null)) {
                m14835b(method, objArr);
            }
            return m14830a(method);
        } else {
            this.f11887d.clear();
            return m14830a(method);
        }
    }

    /* renamed from: b */
    private void m14834b() {
        if (!this.f11888e) {
            try {
                this.f11889f = this.f11885b.mo29234a().mo29252c(null);
            } catch (Exception e) {
                C4409p.m14774a("OnOffTrackerProxy", (Object) this, "Could not create instance", (Throwable) e);
                C4403n.m14758a(e);
            }
            this.f11888e = true;
        }
    }

    /* renamed from: b */
    private void m14835b(Method method, Object[] objArr) {
        if (this.f11887d.size() >= 15) {
            this.f11887d.remove(5);
        }
        this.f11887d.add(new C4437b(method, objArr));
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m14836c() {
        m14834b();
        if (this.f11889f != null) {
            Iterator it = this.f11887d.iterator();
            while (it.hasNext()) {
                C4437b bVar = (C4437b) it.next();
                try {
                    Object[] objArr = new Object[bVar.f11892b.length];
                    WeakReference[] a = bVar.f11892b;
                    int length = a.length;
                    int i = 0;
                    int i2 = 0;
                    while (i < length) {
                        objArr[i2] = a[i].get();
                        i++;
                        i2++;
                    }
                    bVar.f11894d.invoke(this.f11889f, objArr);
                } catch (Exception e) {
                    C4403n.m14758a(e);
                }
            }
            this.f11887d.clear();
        }
    }

    public Object invoke(Object obj, Method method, Object[] objArr) {
        try {
            return m14831a(method, objArr);
        } catch (Exception e) {
            C4403n.m14758a(e);
            return m14830a(method);
        }
    }
}
