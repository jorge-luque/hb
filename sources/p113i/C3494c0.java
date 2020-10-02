package p113i;

import java.net.InetSocketAddress;
import java.net.Proxy;
import javax.annotation.Nullable;

/* renamed from: i.c0 */
/* compiled from: Route */
public final class C3494c0 {

    /* renamed from: a */
    final C3479a f9675a;

    /* renamed from: b */
    final Proxy f9676b;

    /* renamed from: c */
    final InetSocketAddress f9677c;

    public C3494c0(C3479a aVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (aVar == null) {
            throw new NullPointerException("address == null");
        } else if (proxy == null) {
            throw new NullPointerException("proxy == null");
        } else if (inetSocketAddress != null) {
            this.f9675a = aVar;
            this.f9676b = proxy;
            this.f9677c = inetSocketAddress;
        } else {
            throw new NullPointerException("inetSocketAddress == null");
        }
    }

    /* renamed from: a */
    public C3479a mo19340a() {
        return this.f9675a;
    }

    /* renamed from: b */
    public Proxy mo19341b() {
        return this.f9676b;
    }

    /* renamed from: c */
    public boolean mo19342c() {
        return this.f9675a.f9605i != null && this.f9676b.type() == Proxy.Type.HTTP;
    }

    /* renamed from: d */
    public InetSocketAddress mo19343d() {
        return this.f9677c;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof C3494c0) {
            C3494c0 c0Var = (C3494c0) obj;
            return c0Var.f9675a.equals(this.f9675a) && c0Var.f9676b.equals(this.f9676b) && c0Var.f9677c.equals(this.f9677c);
        }
    }

    public int hashCode() {
        return ((((527 + this.f9675a.hashCode()) * 31) + this.f9676b.hashCode()) * 31) + this.f9677c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f9677c + "}";
    }
}
