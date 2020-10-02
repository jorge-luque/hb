package p093e.p101c.p102a.p103a.p104i;

import java.util.concurrent.Executor;
import p188f.p189a.C5913b;
import p188f.p189a.C5915d;

/* renamed from: e.c.a.a.i.j */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final class C3403j implements C5913b<Executor> {

    /* renamed from: a */
    private static final C3403j f9489a = new C3403j();

    /* renamed from: a */
    public static C3403j m11335a() {
        return f9489a;
    }

    /* renamed from: b */
    public static Executor m11336b() {
        Executor a = C3402i.m11334a();
        C5915d.m18981a(a, "Cannot return null from a non-@Nullable @Provides method");
        return a;
    }

    public Executor get() {
        return m11336b();
    }
}
