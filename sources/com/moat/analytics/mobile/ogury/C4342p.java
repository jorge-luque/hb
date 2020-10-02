package com.moat.analytics.mobile.ogury;

import com.moat.analytics.mobile.ogury.C4315e;
import com.moat.analytics.mobile.ogury.C4346q;
import com.moat.analytics.mobile.ogury.base.asserts.Asserts;
import com.moat.analytics.mobile.ogury.base.functional.Optional;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.moat.analytics.mobile.ogury.p */
class C4342p<T> implements InvocationHandler {
    /* access modifiers changed from: private */

    /* renamed from: ˋ */
    public static final Object[] f11619 = new Object[0];

    /* renamed from: ʼ */
    private T f11620;

    /* renamed from: ˊ */
    private final C4344b<T> f11621;

    /* renamed from: ˎ */
    private final Class<T> f11622;

    /* renamed from: ˏ */
    private boolean f11623;

    /* renamed from: ॱ */
    private final LinkedList<C4342p<T>.d> f11624 = new LinkedList<>();

    /* renamed from: com.moat.analytics.mobile.ogury.p$b */
    interface C4344b<T> {
        /* renamed from: ˏ */
        Optional<T> mo29084() throws C4332l;
    }

    /* renamed from: com.moat.analytics.mobile.ogury.p$d */
    class C4345d {

        /* renamed from: ˊ */
        private final LinkedList<Object> f11626;
        /* access modifiers changed from: private */

        /* renamed from: ˎ */
        public final WeakReference[] f11627;
        /* access modifiers changed from: private */

        /* renamed from: ˏ */
        public final Method f11628;

        /* synthetic */ C4345d(C4342p pVar, Method method, Object[] objArr, byte b) {
            this(method, objArr);
        }

        private C4345d(Method method, Object... objArr) {
            this.f11626 = new LinkedList<>();
            objArr = objArr == null ? C4342p.f11619 : objArr;
            WeakReference[] weakReferenceArr = new WeakReference[objArr.length];
            int length = objArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                Object obj = objArr[i];
                if ((obj instanceof Map) || (obj instanceof Integer) || (obj instanceof Double)) {
                    this.f11626.add(obj);
                }
                weakReferenceArr[i2] = new WeakReference(obj);
                i++;
                i2++;
            }
            this.f11627 = weakReferenceArr;
            this.f11628 = method;
        }
    }

    private C4342p(C4344b<T> bVar, Class<T> cls) throws C4332l {
        Asserts.checkNotNull(bVar);
        Asserts.checkNotNull(cls);
        this.f11621 = bVar;
        this.f11622 = cls;
        C4346q.m14542().mo29181((C4346q.C4350b) new C4346q.C4350b() {
            /* renamed from: ˋ */
            public final void mo29162() throws C4332l {
                C4342p.this.m14533();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: ˊ */
    public void m14533() throws C4332l {
        if (!this.f11623) {
            try {
                this.f11620 = this.f11621.mo29084().orElse(null);
            } catch (Exception e) {
                C4315e.C43161.m14445("OnOffTrackerProxy", this, "Could not create instance", e);
                C4332l.m14509(e);
            }
            this.f11623 = true;
        }
        if (this.f11620 != null) {
            Iterator<C4342p<T>.d> it = this.f11624.iterator();
            while (it.hasNext()) {
                C4345d next = it.next();
                try {
                    Object[] objArr = new Object[next.f11627.length];
                    WeakReference[] r3 = next.f11627;
                    int length = r3.length;
                    int i = 0;
                    int i2 = 0;
                    while (i < length) {
                        objArr[i2] = r3[i].get();
                        i++;
                        i2++;
                    }
                    next.f11628.invoke(this.f11620, objArr);
                } catch (Exception e2) {
                    C4332l.m14509(e2);
                }
            }
            this.f11624.clear();
        }
    }

    /* renamed from: ˋ */
    static <T> T m14534(C4344b<T> bVar, Class<T> cls) throws C4332l {
        ClassLoader classLoader = cls.getClassLoader();
        C4342p pVar = new C4342p(bVar, cls);
        return Proxy.newProxyInstance(classLoader, new Class[]{cls}, pVar);
    }

    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        try {
            Class<?> declaringClass = method.getDeclaringClass();
            C4346q r0 = C4346q.m14542();
            if (Object.class.equals(declaringClass)) {
                String name = method.getName();
                if ("getClass".equals(name)) {
                    return this.f11622;
                }
                if (!"toString".equals(name)) {
                    return method.invoke(this, objArr);
                }
                Object invoke = method.invoke(this, objArr);
                return String.valueOf(invoke).replace(C4342p.class.getName(), this.f11622.getName());
            } else if (!this.f11623 || this.f11620 != null) {
                if (r0.f11640 == C4346q.C4354e.f11657) {
                    m14533();
                    if (this.f11620 != null) {
                        return method.invoke(this.f11620, objArr);
                    }
                }
                if (r0.f11640 == C4346q.C4354e.f11656 && (!this.f11623 || this.f11620 != null)) {
                    if (this.f11624.size() >= 15) {
                        this.f11624.remove(5);
                    }
                    this.f11624.add(new C4345d(this, method, objArr, (byte) 0));
                }
                return m14535(method);
            } else {
                this.f11624.clear();
                return m14535(method);
            }
        } catch (Exception e) {
            C4332l.m14509(e);
            return m14535(method);
        }
    }

    /* renamed from: ˏ */
    private static Object m14535(Method method) {
        try {
            if (Boolean.TYPE.equals(method.getReturnType())) {
                return Boolean.TRUE;
            }
            return null;
        } catch (Exception e) {
            C4332l.m14509(e);
            return null;
        }
    }
}
