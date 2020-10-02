package p113i;

import java.io.IOException;

/* renamed from: i.w */
/* compiled from: Protocol */
public enum C5972w {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");
    

    /* renamed from: a */
    private final String f15260a;

    static {
        HTTP_1_0 = new C5972w("HTTP_1_0", 0, "http/1.0");
        HTTP_1_1 = new C5972w("HTTP_1_1", 1, "http/1.1");
        SPDY_3 = new C5972w("SPDY_3", 2, "spdy/3.1");
        HTTP_2 = new C5972w("HTTP_2", 3, "h2");
        H2_PRIOR_KNOWLEDGE = new C5972w("H2_PRIOR_KNOWLEDGE", 4, "h2_prior_knowledge");
        QUIC = new C5972w("QUIC", 5, "quic");
    }

    private C5972w(String str) {
        this.f15260a = str;
    }

    /* renamed from: a */
    public static C5972w m19139a(String str) throws IOException {
        if (str.equals(HTTP_1_0.f15260a)) {
            return HTTP_1_0;
        }
        if (str.equals(HTTP_1_1.f15260a)) {
            return HTTP_1_1;
        }
        if (str.equals(H2_PRIOR_KNOWLEDGE.f15260a)) {
            return H2_PRIOR_KNOWLEDGE;
        }
        if (str.equals(HTTP_2.f15260a)) {
            return HTTP_2;
        }
        if (str.equals(SPDY_3.f15260a)) {
            return SPDY_3;
        }
        if (str.equals(QUIC.f15260a)) {
            return QUIC;
        }
        throw new IOException("Unexpected protocol: " + str);
    }

    public String toString() {
        return this.f15260a;
    }
}
