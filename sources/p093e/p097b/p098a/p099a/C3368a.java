package p093e.p097b.p098a.p099a;

import android.content.Context;
import android.os.RemoteException;

/* renamed from: e.b.a.a.a */
/* compiled from: InstallReferrerClient */
public abstract class C3368a {

    /* renamed from: e.b.a.a.a$b */
    /* compiled from: InstallReferrerClient */
    public static final class C3370b {

        /* renamed from: a */
        private final Context f9430a;

        /* renamed from: a */
        public C3368a mo19132a() {
            Context context = this.f9430a;
            if (context != null) {
                return new C3371b(context);
            }
            throw new IllegalArgumentException("Please provide a valid Context.");
        }

        private C3370b(Context context) {
            this.f9430a = context;
        }
    }

    /* renamed from: a */
    public static C3370b m11242a(Context context) {
        return new C3370b(context);
    }

    /* renamed from: a */
    public abstract C3375d mo19130a() throws RemoteException;

    /* renamed from: a */
    public abstract void mo19131a(C3374c cVar);
}
