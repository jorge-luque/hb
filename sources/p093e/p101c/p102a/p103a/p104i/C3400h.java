package p093e.p101c.p102a.p103a.p104i;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import p093e.p101c.p102a.p103a.p104i.C3385a;

/* renamed from: e.c.a.a.i.h */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public abstract class C3400h {

    /* renamed from: e.c.a.a.i.h$a */
    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    public static abstract class C3401a {
        /* renamed from: a */
        public abstract C3401a mo19162a(long j);

        /* renamed from: a */
        public abstract C3401a mo19163a(C3399g gVar);

        /* renamed from: a */
        public abstract C3401a mo19164a(Integer num);

        /* renamed from: a */
        public abstract C3401a mo19165a(String str);

        /* renamed from: a */
        public final C3401a mo19209a(String str, String str2) {
            mo19169b().put(str, str2);
            return this;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract C3401a mo19166a(Map<String, String> map);

        /* renamed from: a */
        public abstract C3400h mo19167a();

        /* renamed from: b */
        public abstract C3401a mo19168b(long j);

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public abstract Map<String, String> mo19169b();

        /* renamed from: a */
        public final C3401a mo19208a(String str, long j) {
            mo19169b().put(str, String.valueOf(j));
            return this;
        }

        /* renamed from: a */
        public final C3401a mo19207a(String str, int i) {
            mo19169b().put(str, String.valueOf(i));
            return this;
        }
    }

    /* renamed from: i */
    public static C3401a m11311i() {
        C3385a.C3387b bVar = new C3385a.C3387b();
        bVar.mo19166a((Map<String, String>) new HashMap());
        return bVar;
    }

    /* renamed from: a */
    public final String mo19202a(String str) {
        String str2 = mo19153a().get(str);
        return str2 == null ? "" : str2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract Map<String, String> mo19153a();

    /* renamed from: b */
    public final int mo19203b(String str) {
        String str2 = mo19153a().get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.valueOf(str2).intValue();
    }

    /* renamed from: b */
    public abstract Integer mo19154b();

    /* renamed from: c */
    public final long mo19204c(String str) {
        String str2 = mo19153a().get(str);
        if (str2 == null) {
            return 0;
        }
        return Long.valueOf(str2).longValue();
    }

    /* renamed from: c */
    public abstract C3399g mo19155c();

    /* renamed from: d */
    public abstract long mo19156d();

    /* renamed from: e */
    public final Map<String, String> mo19205e() {
        return Collections.unmodifiableMap(mo19153a());
    }

    /* renamed from: f */
    public abstract String mo19158f();

    /* renamed from: g */
    public abstract long mo19159g();

    /* renamed from: h */
    public C3401a mo19206h() {
        C3385a.C3387b bVar = new C3385a.C3387b();
        bVar.mo19165a(mo19158f());
        bVar.mo19164a(mo19154b());
        bVar.mo19163a(mo19155c());
        bVar.mo19162a(mo19156d());
        bVar.mo19168b(mo19159g());
        bVar.mo19166a((Map<String, String>) new HashMap(mo19153a()));
        return bVar;
    }
}
