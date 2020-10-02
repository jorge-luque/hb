package p163cz.msebera.android.httpclient.impl.client;

import p163cz.msebera.android.httpclient.p183h0.C5755a;
import p163cz.msebera.android.httpclient.p183h0.C5759e;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.client.g */
/* compiled from: ClientParamsStack */
public class C5786g extends C5755a {

    /* renamed from: a */
    protected final C5759e f14930a;

    /* renamed from: b */
    protected final C5759e f14931b;

    /* renamed from: c */
    protected final C5759e f14932c;

    /* renamed from: d */
    protected final C5759e f14933d;

    public C5786g(C5759e eVar, C5759e eVar2, C5759e eVar3, C5759e eVar4) {
        this.f14930a = eVar;
        this.f14931b = eVar2;
        this.f14932c = eVar3;
        this.f14933d = eVar4;
    }

    /* renamed from: a */
    public C5759e mo33423a(String str, Object obj) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Setting parameters in a stack is not supported.");
    }

    /* renamed from: b */
    public Object mo33425b(String str) {
        C5759e eVar;
        C5759e eVar2;
        C5759e eVar3;
        C5886a.m18894a(str, "Parameter name");
        C5759e eVar4 = this.f14933d;
        Object b = eVar4 != null ? eVar4.mo33425b(str) : null;
        if (b == null && (eVar3 = this.f14932c) != null) {
            b = eVar3.mo33425b(str);
        }
        if (b == null && (eVar2 = this.f14931b) != null) {
            b = eVar2.mo33425b(str);
        }
        return (b != null || (eVar = this.f14930a) == null) ? b : eVar.mo33425b(str);
    }
}
