package p093e.p101c.p102a.p103a;

/* renamed from: e.c.a.a.a */
/* compiled from: com.google.android.datatransport:transport-api@@2.2.0 */
final class C3377a<T> extends C3379c<T> {

    /* renamed from: a */
    private final Integer f9438a;

    /* renamed from: b */
    private final T f9439b;

    /* renamed from: c */
    private final C3380d f9440c;

    C3377a(Integer num, T t, C3380d dVar) {
        this.f9438a = num;
        if (t != null) {
            this.f9439b = t;
            if (dVar != null) {
                this.f9440c = dVar;
                return;
            }
            throw new NullPointerException("Null priority");
        }
        throw new NullPointerException("Null payload");
    }

    /* renamed from: a */
    public Integer mo19139a() {
        return this.f9438a;
    }

    /* renamed from: b */
    public T mo19140b() {
        return this.f9439b;
    }

    /* renamed from: c */
    public C3380d mo19141c() {
        return this.f9440c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C3379c)) {
            return false;
        }
        C3379c cVar = (C3379c) obj;
        Integer num = this.f9438a;
        if (num != null ? num.equals(cVar.mo19139a()) : cVar.mo19139a() == null) {
            if (!this.f9439b.equals(cVar.mo19140b()) || !this.f9440c.equals(cVar.mo19141c())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.f9438a;
        return (((((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003) ^ this.f9439b.hashCode()) * 1000003) ^ this.f9440c.hashCode();
    }

    public String toString() {
        return "Event{code=" + this.f9438a + ", payload=" + this.f9439b + ", priority=" + this.f9440c + "}";
    }
}
