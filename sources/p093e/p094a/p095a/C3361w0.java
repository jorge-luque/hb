package p093e.p094a.p095a;

import java.util.HashMap;
import java.util.Map;

/* renamed from: e.a.a.w0 */
/* compiled from: SessionParameters */
public class C3361w0 {

    /* renamed from: a */
    Map<String, String> f9425a;

    /* renamed from: b */
    Map<String, String> f9426b;

    /* renamed from: a */
    public C3361w0 mo19109a() {
        C3361w0 w0Var = new C3361w0();
        if (this.f9425a != null) {
            w0Var.f9425a = new HashMap(this.f9425a);
        }
        if (this.f9426b != null) {
            w0Var.f9426b = new HashMap(this.f9426b);
        }
        return w0Var;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || C3361w0.class != obj.getClass()) {
            return false;
        }
        C3361w0 w0Var = (C3361w0) obj;
        return C3268a1.m10847a((Object) this.f9425a, (Object) w0Var.f9425a) && C3268a1.m10847a((Object) this.f9426b, (Object) w0Var.f9426b);
    }

    public int hashCode() {
        return ((629 + C3268a1.m10822a((Object) this.f9425a)) * 37) + C3268a1.m10822a((Object) this.f9426b);
    }
}
