package androidx.lifecycle;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: androidx.lifecycle.e */
/* compiled from: Lifecycle */
public abstract class C0965e {

    /* renamed from: androidx.lifecycle.e$a */
    /* compiled from: Lifecycle */
    public enum C0966a {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;

        /* renamed from: a */
        public static C0966a[] m3456a() {
            return (C0966a[]) $VALUES.clone();
        }
    }

    /* renamed from: androidx.lifecycle.e$b */
    /* compiled from: Lifecycle */
    public enum C0967b {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        /* renamed from: a */
        public static C0967b[] m3457a() {
            return (C0967b[]) f2520f.clone();
        }

        /* renamed from: a */
        public boolean mo4998a(C0967b bVar) {
            return compareTo(bVar) >= 0;
        }
    }

    public C0965e() {
        new AtomicReference();
    }

    /* renamed from: a */
    public abstract C0967b mo4995a();

    /* renamed from: a */
    public abstract void mo4996a(C0969g gVar);

    /* renamed from: b */
    public abstract void mo4997b(C0969g gVar);
}
