package p163cz.msebera.android.httpclient.conn.p174r;

import java.net.InetAddress;
import p163cz.msebera.android.httpclient.C5896l;

/* renamed from: cz.msebera.android.httpclient.conn.r.e */
/* compiled from: RouteInfo */
public interface C5648e {

    /* renamed from: cz.msebera.android.httpclient.conn.r.e$a */
    /* compiled from: RouteInfo */
    public enum C5649a {
        PLAIN,
        LAYERED;

        static {
            PLAIN = new C5649a("PLAIN", 0);
            LAYERED = new C5649a("LAYERED", 1);
        }
    }

    /* renamed from: cz.msebera.android.httpclient.conn.r.e$b */
    /* compiled from: RouteInfo */
    public enum C5650b {
        PLAIN,
        TUNNELLED;

        static {
            PLAIN = new C5650b("PLAIN", 0);
            TUNNELLED = new C5650b("TUNNELLED", 1);
        }
    }

    /* renamed from: B */
    boolean mo33054B();

    /* renamed from: a */
    int mo33055a();

    /* renamed from: a */
    C5896l mo33056a(int i);

    /* renamed from: b */
    boolean mo33057b();

    /* renamed from: c */
    C5896l mo33058c();

    /* renamed from: d */
    InetAddress mo33060d();

    /* renamed from: e */
    C5896l mo33061e();

    /* renamed from: f */
    boolean mo33063f();
}
