package com.tapjoy.internal;

import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* renamed from: com.tapjoy.internal.fn */
public final class C5087fn {

    /* renamed from: com.tapjoy.internal.fn$a */
    static class C5088a implements InvocationHandler {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final Object f13927a;

        /* renamed from: b */
        private final Thread f13928b;

        /* renamed from: c */
        private final Looper f13929c;

        public C5088a(Object obj, Thread thread, Looper looper) {
            this.f13927a = obj;
            this.f13928b = thread;
            this.f13929c = looper;
        }

        public final Object invoke(Object obj, final Method method, final Object[] objArr) {
            if (this.f13928b == Thread.currentThread()) {
                return method.invoke(this.f13927a, objArr);
            }
            if (method.getReturnType().equals(Void.TYPE)) {
                C50891 r4 = new Runnable() {
                    public final void run() {
                        try {
                            method.invoke(C5088a.this.f13927a, objArr);
                        } catch (IllegalArgumentException e) {
                            throw C3167jr.m10437a(e);
                        } catch (IllegalAccessException e2) {
                            throw C3167jr.m10437a(e2);
                        } catch (InvocationTargetException e3) {
                            throw C3167jr.m10437a(e3);
                        }
                    }
                };
                if (this.f13929c != null && new Handler(this.f13929c).post(r4)) {
                    return null;
                }
                if (this.f13928b == C5129gr.m17304b() && C5129gr.f14031a.mo30981a(r4)) {
                    return null;
                }
                Looper mainLooper = Looper.getMainLooper();
                if (mainLooper == null || !new Handler(mainLooper).post(r4)) {
                    return method.invoke(this.f13927a, objArr);
                }
                return null;
            }
            throw new UnsupportedOperationException("method not return void: " + method.getName());
        }
    }

    /* renamed from: a */
    public static Object m17200a(Object obj, Class cls) {
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new C5088a(obj, Thread.currentThread(), Looper.myLooper()));
    }
}
