package okhttp3.internal.connection;

import java.io.IOException;
import p113i.C3480a0;
import p113i.C3542v;
import p113i.C3548y;
import p113i.C5970t;
import p113i.p114e0.p116f.C5942g;

/* renamed from: okhttp3.internal.connection.a */
/* compiled from: ConnectInterceptor */
public final class C6608a implements C5970t {

    /* renamed from: a */
    public final C3542v f17283a;

    public C6608a(C3542v vVar) {
        this.f17283a = vVar;
    }

    public C3480a0 intercept(C5970t.C5971a aVar) throws IOException {
        C5942g gVar = (C5942g) aVar;
        C3548y d = gVar.mo33734d();
        C6613f i = gVar.mo33739i();
        return gVar.mo33731a(d, i, i.mo35658a(this.f17283a, aVar, !d.mo19605e().equals("GET")), i.mo35665c());
    }
}
