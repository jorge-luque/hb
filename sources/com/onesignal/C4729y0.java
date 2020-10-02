package com.onesignal;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.onesignal.y0 */
/* compiled from: OSObservable */
class C4729y0<ObserverType, StateType> {

    /* renamed from: a */
    private String f12837a;

    /* renamed from: b */
    private List<Object> f12838b = new ArrayList();

    /* renamed from: c */
    private boolean f12839c;

    /* renamed from: com.onesignal.y0$a */
    /* compiled from: OSObservable */
    class C4730a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Method f12840a;

        /* renamed from: b */
        final /* synthetic */ Object f12841b;

        /* renamed from: c */
        final /* synthetic */ Object f12842c;

        C4730a(C4729y0 y0Var, Method method, Object obj, Object obj2) {
            this.f12840a = method;
            this.f12841b = obj;
            this.f12842c = obj2;
        }

        public void run() {
            try {
                this.f12840a.invoke(this.f12841b, new Object[]{this.f12842c});
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            }
        }
    }

    C4729y0(String str, boolean z) {
        this.f12837a = str;
        this.f12839c = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo30029a(ObserverType observertype) {
        this.f12838b.add(new WeakReference(observertype));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo30030b(ObserverType observertype) {
        this.f12838b.add(observertype);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo30031c(StateType statetype) {
        Iterator<Object> it = this.f12838b.iterator();
        boolean z = false;
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof WeakReference) {
                next = ((WeakReference) next).get();
            }
            if (next != null) {
                Class<?> cls = next.getClass();
                try {
                    Method declaredMethod = cls.getDeclaredMethod(this.f12837a, new Class[]{statetype.getClass()});
                    declaredMethod.setAccessible(true);
                    if (this.f12839c) {
                        C4536k1.m15622a((Runnable) new C4730a(this, declaredMethod, next, statetype));
                    } else {
                        try {
                            declaredMethod.invoke(next, new Object[]{statetype});
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e2) {
                            e2.printStackTrace();
                        }
                    }
                    z = true;
                } catch (NoSuchMethodException e3) {
                    e3.printStackTrace();
                }
            }
        }
        return z;
    }
}
