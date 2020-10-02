package androidx.lifecycle;

/* renamed from: androidx.lifecycle.r */
/* compiled from: ViewModelProvider */
public class C0983r {

    /* renamed from: a */
    private final C0984a f2536a;

    /* renamed from: b */
    private final C0986s f2537b;

    /* renamed from: androidx.lifecycle.r$a */
    /* compiled from: ViewModelProvider */
    public interface C0984a {
        /* renamed from: a */
        <T extends C0982q> T mo4916a(Class<T> cls);
    }

    /* renamed from: androidx.lifecycle.r$b */
    /* compiled from: ViewModelProvider */
    static abstract class C0985b implements C0984a {
        C0985b() {
        }

        /* renamed from: a */
        public <T extends C0982q> T mo4916a(Class<T> cls) {
            throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
        }

        /* renamed from: a */
        public abstract <T extends C0982q> T mo5017a(String str, Class<T> cls);
    }

    public C0983r(C0986s sVar, C0984a aVar) {
        this.f2536a = aVar;
        this.f2537b = sVar;
    }

    /* renamed from: a */
    public <T extends C0982q> T mo5015a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return mo5016a("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    /* renamed from: a */
    public <T extends C0982q> T mo5016a(String str, Class<T> cls) {
        T t;
        T a = this.f2537b.mo5018a(str);
        if (cls.isInstance(a)) {
            return a;
        }
        C0984a aVar = this.f2536a;
        if (aVar instanceof C0985b) {
            t = ((C0985b) aVar).mo5017a(str, cls);
        } else {
            t = aVar.mo4916a(cls);
        }
        this.f2537b.mo5020a(str, t);
        return t;
    }
}
