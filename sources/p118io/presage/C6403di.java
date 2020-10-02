package p118io.presage;

/* renamed from: io.presage.di */
public final class C6403di extends C6412dr {

    /* renamed from: a */
    private final Throwable f16987a;

    public C6403di(Throwable th) {
        super((byte) 0);
        this.f16987a = th;
    }

    /* renamed from: a */
    public final Throwable mo35368a() {
        return this.f16987a;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof C6403di) && C6514hl.m21416a((Object) this.f16987a, (Object) ((C6403di) obj).f16987a);
        }
        return true;
    }

    public final int hashCode() {
        Throwable th = this.f16987a;
        if (th != null) {
            return th.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "ErrorResponse(exception=" + this.f16987a + ")";
    }
}
