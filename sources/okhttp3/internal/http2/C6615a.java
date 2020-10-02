package okhttp3.internal.http2;

/* renamed from: okhttp3.internal.http2.a */
/* compiled from: ErrorCode */
public enum C6615a {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8),
    COMPRESSION_ERROR(9),
    CONNECT_ERROR(10),
    ENHANCE_YOUR_CALM(11),
    INADEQUATE_SECURITY(12),
    HTTP_1_1_REQUIRED(13);
    

    /* renamed from: a */
    public final int f17327a;

    private C6615a(int i) {
        this.f17327a = i;
    }

    /* renamed from: a */
    public static C6615a[] m21742a() {
        return (C6615a[]) f17326m.clone();
    }

    /* renamed from: a */
    public static C6615a m21741a(int i) {
        for (C6615a aVar : m21742a()) {
            if (aVar.f17327a == i) {
                return aVar;
            }
        }
        return null;
    }
}
