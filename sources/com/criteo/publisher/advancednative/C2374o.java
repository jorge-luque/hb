package com.criteo.publisher.advancednative;

import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: com.criteo.publisher.advancednative.o */
public class C2374o {

    /* renamed from: a */
    private final C2372m f7760a;

    /* renamed from: b */
    private final Map<View, C2375a> f7761b = new WeakHashMap();

    /* renamed from: c */
    private final Object f7762c = new Object();

    public C2374o(C2372m mVar) {
        this.f7760a = mVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10229a(View view, C2373n nVar) {
        C2375a aVar;
        synchronized (this.f7762c) {
            aVar = this.f7761b.get(view);
            if (aVar == null) {
                aVar = m9040a(view);
                this.f7761b.put(view, aVar);
            }
        }
        aVar.mo10230a(nVar);
    }

    /* renamed from: com.criteo.publisher.advancednative.o$a */
    static class C2375a implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a */
        private final Reference<View> f7763a;

        /* renamed from: b */
        private final C2372m f7764b;

        /* renamed from: c */
        private volatile C2373n f7765c = null;

        C2375a(Reference<View> reference, C2372m mVar) {
            this.f7763a = reference;
            this.f7764b = mVar;
            m9042a();
        }

        /* renamed from: a */
        private void m9042a() {
            View view = this.f7763a.get();
            if (view != null) {
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.addOnPreDrawListener(this);
                }
            }
        }

        /* renamed from: b */
        private boolean m9043b() {
            View view = this.f7763a.get();
            if (view == null) {
                return false;
            }
            return this.f7764b.mo10228a(view);
        }

        /* renamed from: c */
        private void m9044c() {
            C2373n nVar = this.f7765c;
            if (nVar != null) {
                nVar.mo10226a();
            }
        }

        public boolean onPreDraw() {
            if (!m9043b()) {
                return true;
            }
            m9044c();
            return true;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo10230a(C2373n nVar) {
            this.f7765c = nVar;
        }
    }

    /* renamed from: a */
    private C2375a m9040a(View view) {
        return new C2375a(new WeakReference(view), this.f7760a);
    }
}
