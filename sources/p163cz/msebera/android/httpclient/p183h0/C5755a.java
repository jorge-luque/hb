package p163cz.msebera.android.httpclient.p183h0;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.h0.a */
/* compiled from: AbstractHttpParams */
public abstract class C5755a implements C5759e {
    protected C5755a() {
    }

    /* renamed from: a */
    public long mo33415a(String str, long j) {
        Object b = mo33425b(str);
        if (b == null) {
            return j;
        }
        return ((Long) b).longValue();
    }

    /* renamed from: b */
    public C5759e mo33420b(String str, long j) {
        mo33423a(str, (Object) Long.valueOf(j));
        return this;
    }

    /* renamed from: c */
    public boolean mo33422c(String str) {
        return mo33421b(str, false);
    }

    /* renamed from: b */
    public int mo33419b(String str, int i) {
        Object b = mo33425b(str);
        if (b == null) {
            return i;
        }
        return ((Integer) b).intValue();
    }

    /* renamed from: a */
    public C5759e mo33416a(String str, int i) {
        mo33423a(str, (Object) Integer.valueOf(i));
        return this;
    }

    /* renamed from: a */
    public C5759e mo33417a(String str, boolean z) {
        mo33423a(str, (Object) z ? Boolean.TRUE : Boolean.FALSE);
        return this;
    }

    /* renamed from: b */
    public boolean mo33421b(String str, boolean z) {
        Object b = mo33425b(str);
        if (b == null) {
            return z;
        }
        return ((Boolean) b).booleanValue();
    }

    /* renamed from: a */
    public boolean mo33418a(String str) {
        return !mo33421b(str, false);
    }
}
