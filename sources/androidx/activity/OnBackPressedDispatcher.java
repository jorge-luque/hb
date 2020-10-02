package androidx.activity;

import androidx.lifecycle.C0965e;
import androidx.lifecycle.C0968f;
import androidx.lifecycle.C0970h;
import java.util.ArrayDeque;
import java.util.Iterator;

public final class OnBackPressedDispatcher {

    /* renamed from: a */
    private final Runnable f268a;

    /* renamed from: b */
    final ArrayDeque<C0381b> f269b = new ArrayDeque<>();

    private class LifecycleOnBackPressedCancellable implements C0968f, C0380a {

        /* renamed from: a */
        private final C0965e f270a;

        /* renamed from: b */
        private final C0381b f271b;

        /* renamed from: c */
        private C0380a f272c;

        LifecycleOnBackPressedCancellable(C0965e eVar, C0381b bVar) {
            this.f270a = eVar;
            this.f271b = bVar;
            eVar.mo4996a(this);
        }

        /* renamed from: a */
        public void mo1895a(C0970h hVar, C0965e.C0966a aVar) {
            if (aVar == C0965e.C0966a.ON_START) {
                this.f272c = OnBackPressedDispatcher.this.mo1897a(this.f271b);
            } else if (aVar == C0965e.C0966a.ON_STOP) {
                C0380a aVar2 = this.f272c;
                if (aVar2 != null) {
                    aVar2.cancel();
                }
            } else if (aVar == C0965e.C0966a.ON_DESTROY) {
                cancel();
            }
        }

        public void cancel() {
            this.f270a.mo4997b(this);
            this.f271b.mo1904b(this);
            C0380a aVar = this.f272c;
            if (aVar != null) {
                aVar.cancel();
                this.f272c = null;
            }
        }
    }

    /* renamed from: androidx.activity.OnBackPressedDispatcher$a */
    private class C0379a implements C0380a {

        /* renamed from: a */
        private final C0381b f274a;

        C0379a(C0381b bVar) {
            this.f274a = bVar;
        }

        public void cancel() {
            OnBackPressedDispatcher.this.f269b.remove(this.f274a);
            this.f274a.mo1904b(this);
        }
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.f268a = runnable;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0380a mo1897a(C0381b bVar) {
        this.f269b.add(bVar);
        C0379a aVar = new C0379a(bVar);
        bVar.mo1902a((C0380a) aVar);
        return aVar;
    }

    /* renamed from: a */
    public void mo1899a(C0970h hVar, C0381b bVar) {
        C0965e lifecycle = hVar.getLifecycle();
        if (lifecycle.mo4995a() != C0965e.C0967b.DESTROYED) {
            bVar.mo1902a((C0380a) new LifecycleOnBackPressedCancellable(lifecycle, bVar));
        }
    }

    /* renamed from: a */
    public void mo1898a() {
        Iterator<C0381b> descendingIterator = this.f269b.descendingIterator();
        while (descendingIterator.hasNext()) {
            C0381b next = descendingIterator.next();
            if (next.mo1905b()) {
                next.mo1901a();
                return;
            }
        }
        Runnable runnable = this.f268a;
        if (runnable != null) {
            runnable.run();
        }
    }
}
