package androidx.fragment.app;

import androidx.lifecycle.C0965e;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* renamed from: androidx.fragment.app.k */
/* compiled from: FragmentTransaction */
public abstract class C0937k {

    /* renamed from: a */
    ArrayList<C0938a> f2400a = new ArrayList<>();

    /* renamed from: b */
    int f2401b;

    /* renamed from: c */
    int f2402c;

    /* renamed from: d */
    int f2403d;

    /* renamed from: e */
    int f2404e;

    /* renamed from: f */
    int f2405f;

    /* renamed from: g */
    int f2406g;

    /* renamed from: h */
    boolean f2407h;

    /* renamed from: i */
    String f2408i;

    /* renamed from: j */
    int f2409j;

    /* renamed from: k */
    CharSequence f2410k;

    /* renamed from: l */
    int f2411l;

    /* renamed from: m */
    CharSequence f2412m;

    /* renamed from: n */
    ArrayList<String> f2413n;

    /* renamed from: o */
    ArrayList<String> f2414o;

    /* renamed from: p */
    boolean f2415p = false;

    /* renamed from: q */
    ArrayList<Runnable> f2416q;

    /* renamed from: androidx.fragment.app.k$a */
    /* compiled from: FragmentTransaction */
    static final class C0938a {

        /* renamed from: a */
        int f2417a;

        /* renamed from: b */
        Fragment f2418b;

        /* renamed from: c */
        int f2419c;

        /* renamed from: d */
        int f2420d;

        /* renamed from: e */
        int f2421e;

        /* renamed from: f */
        int f2422f;

        /* renamed from: g */
        C0965e.C0967b f2423g;

        /* renamed from: h */
        C0965e.C0967b f2424h;

        C0938a() {
        }

        C0938a(int i, Fragment fragment) {
            this.f2417a = i;
            this.f2418b = fragment;
            C0965e.C0967b bVar = C0965e.C0967b.RESUMED;
            this.f2423g = bVar;
            this.f2424h = bVar;
        }
    }

    /* renamed from: a */
    public abstract int mo4664a();

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4919a(C0938a aVar) {
        this.f2400a.add(aVar);
        aVar.f2419c = this.f2401b;
        aVar.f2420d = this.f2402c;
        aVar.f2421e = this.f2403d;
        aVar.f2422f = this.f2404e;
    }

    /* renamed from: b */
    public abstract int mo4675b();

    /* renamed from: c */
    public abstract void mo4679c();

    /* renamed from: d */
    public C0937k mo4920d() {
        if (!this.f2407h) {
            return this;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    /* renamed from: a */
    public C0937k mo4918a(Fragment fragment, String str) {
        mo4669a(0, fragment, str, 1);
        return this;
    }

    /* renamed from: a */
    public C0937k mo4917a(int i, Fragment fragment, String str) {
        mo4669a(i, fragment, str, 1);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4669a(int i, Fragment fragment, String str, int i2) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str2 = fragment.mTag;
            if (str2 == null || str.equals(str2)) {
                fragment.mTag = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
        }
        if (i != 0) {
            if (i != -1) {
                int i3 = fragment.mFragmentId;
                if (i3 == 0 || i3 == i) {
                    fragment.mFragmentId = i;
                    fragment.mContainerId = i;
                } else {
                    throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i);
                }
            } else {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
        }
        mo4919a(new C0938a(i2, fragment));
    }

    /* renamed from: a */
    public C0937k mo4667a(Fragment fragment) {
        mo4919a(new C0938a(3, fragment));
        return this;
    }
}
