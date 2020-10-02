package p163cz.msebera.android.httpclient.impl.conn;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import p163cz.msebera.android.httpclient.C5896l;
import p163cz.msebera.android.httpclient.conn.C5626d;
import p163cz.msebera.android.httpclient.conn.C5630h;
import p163cz.msebera.android.httpclient.conn.C5637o;
import p163cz.msebera.android.httpclient.conn.p175s.C5656e;
import p163cz.msebera.android.httpclient.conn.p175s.C5657f;
import p163cz.msebera.android.httpclient.conn.p175s.C5660i;
import p163cz.msebera.android.httpclient.p177d0.C5695b;
import p163cz.msebera.android.httpclient.p183h0.C5757c;
import p163cz.msebera.android.httpclient.p183h0.C5759e;
import p163cz.msebera.android.httpclient.p186j0.C5875e;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5887b;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.conn.f */
/* compiled from: DefaultClientConnectionOperator */
public class C5811f implements C5626d {

    /* renamed from: a */
    public C5695b f15003a = new C5695b(C5811f.class);

    /* renamed from: b */
    protected final C5660i f15004b;

    /* renamed from: c */
    protected final C5630h f15005c;

    public C5811f(C5660i iVar) {
        C5886a.m18894a(iVar, "Scheme registry");
        this.f15004b = iVar;
        this.f15005c = new C5821p();
    }

    /* renamed from: a */
    public C5637o mo33014a() {
        return new C5810e();
    }

    /* renamed from: a */
    private C5660i m18594a(C5875e eVar) {
        C5660i iVar = (C5660i) eVar.mo33533a("http.scheme-registry");
        return iVar == null ? this.f15004b : iVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00cb A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo33016a(p163cz.msebera.android.httpclient.conn.C5637o r17, p163cz.msebera.android.httpclient.C5896l r18, java.net.InetAddress r19, p163cz.msebera.android.httpclient.p186j0.C5875e r20, p163cz.msebera.android.httpclient.p183h0.C5759e r21) throws java.io.IOException {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r21
            java.lang.String r0 = "Connection"
            p163cz.msebera.android.httpclient.p187k0.C5886a.m18894a(r2, (java.lang.String) r0)
            java.lang.String r0 = "Target host"
            p163cz.msebera.android.httpclient.p187k0.C5886a.m18894a(r3, (java.lang.String) r0)
            java.lang.String r0 = "HTTP parameters"
            p163cz.msebera.android.httpclient.p187k0.C5886a.m18894a(r6, (java.lang.String) r0)
            boolean r0 = r17.isOpen()
            r7 = 1
            r0 = r0 ^ r7
            java.lang.String r8 = "Connection must not be open"
            p163cz.msebera.android.httpclient.p187k0.C5887b.m18902a((boolean) r0, (java.lang.String) r8)
            cz.msebera.android.httpclient.conn.s.i r0 = r1.m18594a((p163cz.msebera.android.httpclient.p186j0.C5875e) r5)
            java.lang.String r8 = r18.mo33688d()
            cz.msebera.android.httpclient.conn.s.e r0 = r0.mo33096b(r8)
            cz.msebera.android.httpclient.conn.s.j r8 = r0.mo33087c()
            java.lang.String r9 = r18.mo33685b()
            java.net.InetAddress[] r9 = r1.mo33553a((java.lang.String) r9)
            int r10 = r18.mo33686c()
            int r10 = r0.mo33085a(r10)
            r11 = 0
            r12 = 0
        L_0x0048:
            int r0 = r9.length
            if (r12 >= r0) goto L_0x00d4
            r0 = r9[r12]
            int r13 = r9.length
            int r13 = r13 - r7
            if (r12 != r13) goto L_0x0053
            r13 = 1
            goto L_0x0054
        L_0x0053:
            r13 = 0
        L_0x0054:
            java.net.Socket r14 = r8.mo33080a((p163cz.msebera.android.httpclient.p183h0.C5759e) r6)
            r2.mo33043a(r14, r3)
            cz.msebera.android.httpclient.conn.k r15 = new cz.msebera.android.httpclient.conn.k
            r15.<init>(r3, r0, r10)
            r0 = 0
            if (r4 == 0) goto L_0x0068
            java.net.InetSocketAddress r0 = new java.net.InetSocketAddress
            r0.<init>(r4, r11)
        L_0x0068:
            cz.msebera.android.httpclient.d0.b r7 = r1.f15003a
            boolean r7 = r7.mo33168a()
            if (r7 == 0) goto L_0x0086
            cz.msebera.android.httpclient.d0.b r7 = r1.f15003a
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r4 = "Connecting to "
            r11.append(r4)
            r11.append(r15)
            java.lang.String r4 = r11.toString()
            r7.mo33166a(r4)
        L_0x0086:
            java.net.Socket r0 = r8.mo33082a(r14, r15, r0, r6)     // Catch:{ ConnectException -> 0x00a0, ConnectTimeoutException -> 0x009b }
            if (r14 == r0) goto L_0x0090
            r2.mo33043a(r0, r3)     // Catch:{ ConnectException -> 0x00a0, ConnectTimeoutException -> 0x009b }
            r14 = r0
        L_0x0090:
            r1.mo33552a(r14, r5, r6)     // Catch:{ ConnectException -> 0x00a0, ConnectTimeoutException -> 0x009b }
            boolean r0 = r8.mo33083a((java.net.Socket) r14)     // Catch:{ ConnectException -> 0x00a0, ConnectTimeoutException -> 0x009b }
            r2.mo33045b(r0, r6)     // Catch:{ ConnectException -> 0x00a0, ConnectTimeoutException -> 0x009b }
            return
        L_0x009b:
            r0 = move-exception
            if (r13 != 0) goto L_0x009f
            goto L_0x00a3
        L_0x009f:
            throw r0
        L_0x00a0:
            r0 = move-exception
            if (r13 != 0) goto L_0x00d3
        L_0x00a3:
            cz.msebera.android.httpclient.d0.b r0 = r1.f15003a
            boolean r0 = r0.mo33168a()
            if (r0 == 0) goto L_0x00cb
            cz.msebera.android.httpclient.d0.b r0 = r1.f15003a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r7 = "Connect to "
            r4.append(r7)
            r4.append(r15)
            java.lang.String r7 = " timed out. "
            r4.append(r7)
            java.lang.String r7 = "Connection will be retried using another IP address"
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            r0.mo33166a(r4)
        L_0x00cb:
            int r12 = r12 + 1
            r4 = r19
            r7 = 1
            r11 = 0
            goto L_0x0048
        L_0x00d3:
            throw r0
        L_0x00d4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p163cz.msebera.android.httpclient.impl.conn.C5811f.mo33016a(cz.msebera.android.httpclient.conn.o, cz.msebera.android.httpclient.l, java.net.InetAddress, cz.msebera.android.httpclient.j0.e, cz.msebera.android.httpclient.h0.e):void");
    }

    /* renamed from: a */
    public void mo33015a(C5637o oVar, C5896l lVar, C5875e eVar, C5759e eVar2) throws IOException {
        C5886a.m18894a(oVar, "Connection");
        C5886a.m18894a(lVar, "Target host");
        C5886a.m18894a(eVar2, "Parameters");
        C5887b.m18902a(oVar.isOpen(), "Connection must be open");
        C5656e b = m18594a(eVar).mo33096b(lVar.mo33688d());
        C5887b.m18902a(b.mo33087c() instanceof C5657f, "Socket factory must implement SchemeLayeredSocketFactory");
        C5657f fVar = (C5657f) b.mo33087c();
        Socket a = fVar.mo33092a(oVar.mo33042N(), lVar.mo33685b(), b.mo33085a(lVar.mo33686c()), eVar2);
        mo33552a(a, eVar, eVar2);
        oVar.mo33044a(a, lVar, fVar.mo33083a(a), eVar2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo33552a(Socket socket, C5875e eVar, C5759e eVar2) throws IOException {
        socket.setTcpNoDelay(C5757c.m18345e(eVar2));
        socket.setSoTimeout(C5757c.m18344d(eVar2));
        int b = C5757c.m18340b(eVar2);
        if (b >= 0) {
            socket.setSoLinger(b > 0, b);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public InetAddress[] mo33553a(String str) throws UnknownHostException {
        return this.f15005c.mo33020a(str);
    }
}
