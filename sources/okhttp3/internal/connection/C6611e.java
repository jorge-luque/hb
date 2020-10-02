package okhttp3.internal.connection;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import p113i.C3479a;
import p113i.C3494c0;
import p113i.C3497e;
import p113i.C3532p;
import p113i.C3539s;
import p113i.p114e0.C3500c;

/* renamed from: okhttp3.internal.connection.e */
/* compiled from: RouteSelector */
public final class C6611e {

    /* renamed from: a */
    private final C3479a f17289a;

    /* renamed from: b */
    private final C6610d f17290b;

    /* renamed from: c */
    private final C3497e f17291c;

    /* renamed from: d */
    private final C3532p f17292d;

    /* renamed from: e */
    private List<Proxy> f17293e = Collections.emptyList();

    /* renamed from: f */
    private int f17294f;

    /* renamed from: g */
    private List<InetSocketAddress> f17295g = Collections.emptyList();

    /* renamed from: h */
    private final List<C3494c0> f17296h = new ArrayList();

    /* renamed from: okhttp3.internal.connection.e$a */
    /* compiled from: RouteSelector */
    public static final class C6612a {

        /* renamed from: a */
        private final List<C3494c0> f17297a;

        /* renamed from: b */
        private int f17298b = 0;

        C6612a(List<C3494c0> list) {
            this.f17297a = list;
        }

        /* renamed from: a */
        public List<C3494c0> mo35655a() {
            return new ArrayList(this.f17297a);
        }

        /* renamed from: b */
        public boolean mo35656b() {
            return this.f17298b < this.f17297a.size();
        }

        /* renamed from: c */
        public C3494c0 mo35657c() {
            if (mo35656b()) {
                List<C3494c0> list = this.f17297a;
                int i = this.f17298b;
                this.f17298b = i + 1;
                return list.get(i);
            }
            throw new NoSuchElementException();
        }
    }

    public C6611e(C3479a aVar, C6610d dVar, C3497e eVar, C3532p pVar) {
        this.f17289a = aVar;
        this.f17290b = dVar;
        this.f17291c = eVar;
        this.f17292d = pVar;
        m21713a(aVar.mo19272k(), aVar.mo19266f());
    }

    /* renamed from: c */
    private boolean m21715c() {
        return this.f17294f < this.f17293e.size();
    }

    /* renamed from: d */
    private Proxy m21716d() throws IOException {
        if (m21715c()) {
            List<Proxy> list = this.f17293e;
            int i = this.f17294f;
            this.f17294f = i + 1;
            Proxy proxy = list.get(i);
            m21714a(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f17289a.mo19272k().mo19525g() + "; exhausted proxy configurations: " + this.f17293e);
    }

    /* renamed from: a */
    public boolean mo35653a() {
        return m21715c() || !this.f17296h.isEmpty();
    }

    /* renamed from: b */
    public C6612a mo35654b() throws IOException {
        if (mo35653a()) {
            ArrayList arrayList = new ArrayList();
            while (m21715c()) {
                Proxy d = m21716d();
                int size = this.f17295g.size();
                for (int i = 0; i < size; i++) {
                    C3494c0 c0Var = new C3494c0(this.f17289a, d, this.f17295g.get(i));
                    if (this.f17290b.mo35651c(c0Var)) {
                        this.f17296h.add(c0Var);
                    } else {
                        arrayList.add(c0Var);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(this.f17296h);
                this.f17296h.clear();
            }
            return new C6612a(arrayList);
        }
        throw new NoSuchElementException();
    }

    /* renamed from: a */
    public void mo35652a(C3494c0 c0Var, IOException iOException) {
        if (!(c0Var.mo19341b().type() == Proxy.Type.DIRECT || this.f17289a.mo19268h() == null)) {
            this.f17289a.mo19268h().connectFailed(this.f17289a.mo19272k().mo19534o(), c0Var.mo19341b().address(), iOException);
        }
        this.f17290b.mo35650b(c0Var);
    }

    /* renamed from: a */
    private void m21713a(C3539s sVar, Proxy proxy) {
        List<Proxy> list;
        if (proxy != null) {
            this.f17293e = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.f17289a.mo19268h().select(sVar.mo19534o());
            if (select == null || select.isEmpty()) {
                list = C3500c.m11644a((T[]) new Proxy[]{Proxy.NO_PROXY});
            } else {
                list = C3500c.m11643a(select);
            }
            this.f17293e = list;
        }
        this.f17294f = 0;
    }

    /* renamed from: a */
    private void m21714a(Proxy proxy) throws IOException {
        String str;
        int i;
        this.f17295g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            str = this.f17289a.mo19272k().mo19525g();
            i = this.f17289a.mo19272k().mo19530k();
        } else {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                str = m21712a(inetSocketAddress);
                i = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
        }
        if (i < 1 || i > 65535) {
            throw new SocketException("No route to " + str + ":" + i + "; port is out of range");
        } else if (proxy.type() == Proxy.Type.SOCKS) {
            this.f17295g.add(InetSocketAddress.createUnresolved(str, i));
        } else {
            this.f17292d.mo19480a(this.f17291c, str);
            List<InetAddress> a = this.f17289a.mo19262c().mo33781a(str);
            if (!a.isEmpty()) {
                this.f17292d.mo19481a(this.f17291c, str, a);
                int size = a.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.f17295g.add(new InetSocketAddress(a.get(i2), i));
                }
                return;
            }
            throw new UnknownHostException(this.f17289a.mo19262c() + " returned no addresses for " + str);
        }
    }

    /* renamed from: a */
    static String m21712a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }
}
