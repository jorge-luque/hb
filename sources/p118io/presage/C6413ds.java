package p118io.presage;

/* renamed from: io.presage.ds */
public final class C6413ds extends C6412dr {

    /* renamed from: a */
    private final String f16998a;

    public C6413ds(String str) {
        super((byte) 0);
        this.f16998a = str;
    }

    /* renamed from: a */
    public final String mo35377a() {
        return this.f16998a;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof C6413ds) && C6514hl.m21416a((Object) this.f16998a, (Object) ((C6413ds) obj).f16998a);
        }
        return true;
    }

    public final int hashCode() {
        String str = this.f16998a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "SuccessResponse(responseBody=" + this.f16998a + ")";
    }
}
