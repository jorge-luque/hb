package p163cz.msebera.android.httpclient.client.p171q;

import java.util.Queue;
import p163cz.msebera.android.httpclient.C5691d;
import p163cz.msebera.android.httpclient.C5899o;
import p163cz.msebera.android.httpclient.C5900p;
import p163cz.msebera.android.httpclient.auth.AuthenticationException;
import p163cz.msebera.android.httpclient.auth.C5547a;
import p163cz.msebera.android.httpclient.auth.C5549c;
import p163cz.msebera.android.httpclient.auth.C5555h;
import p163cz.msebera.android.httpclient.auth.C5558k;
import p163cz.msebera.android.httpclient.auth.C5559l;
import p163cz.msebera.android.httpclient.p177d0.C5695b;
import p163cz.msebera.android.httpclient.p186j0.C5875e;
import p163cz.msebera.android.httpclient.p187k0.C5887b;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.client.q.d */
/* compiled from: RequestAuthenticationBase */
abstract class C5609d implements C5900p {

    /* renamed from: a */
    final C5695b f14594a = new C5695b(getClass());

    /* renamed from: cz.msebera.android.httpclient.client.q.d$a */
    /* compiled from: RequestAuthenticationBase */
    static /* synthetic */ class C5610a {

        /* renamed from: a */
        static final /* synthetic */ int[] f14595a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                cz.msebera.android.httpclient.auth.b[] r0 = p163cz.msebera.android.httpclient.auth.C5548b.m17690a()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f14595a = r0
                cz.msebera.android.httpclient.auth.b r1 = p163cz.msebera.android.httpclient.auth.C5548b.FAILURE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f14595a     // Catch:{ NoSuchFieldError -> 0x001d }
                cz.msebera.android.httpclient.auth.b r1 = p163cz.msebera.android.httpclient.auth.C5548b.SUCCESS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f14595a     // Catch:{ NoSuchFieldError -> 0x0028 }
                cz.msebera.android.httpclient.auth.b r1 = p163cz.msebera.android.httpclient.auth.C5548b.CHALLENGED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p163cz.msebera.android.httpclient.client.p171q.C5609d.C5610a.<clinit>():void");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo32986a(C5555h hVar, C5899o oVar, C5875e eVar) {
        C5549c b = hVar.mo32858b();
        C5559l c = hVar.mo32859c();
        int i = C5610a.f14595a[hVar.mo32860d().ordinal()];
        if (i != 1) {
            if (i == 2) {
                m17857a(b);
                if (b.mo32840b()) {
                    return;
                }
            } else if (i == 3) {
                Queue<C5547a> a = hVar.mo32852a();
                if (a != null) {
                    while (!a.isEmpty()) {
                        C5547a remove = a.remove();
                        C5549c a2 = remove.mo32834a();
                        C5559l b2 = remove.mo32835b();
                        hVar.mo32855a(a2, b2);
                        if (this.f14594a.mo33168a()) {
                            C5695b bVar = this.f14594a;
                            bVar.mo33166a("Generating response to an authentication challenge using " + a2.mo32842d() + " scheme");
                        }
                        try {
                            oVar.mo33293a(m17856a(a2, b2, oVar, eVar));
                            return;
                        } catch (AuthenticationException e) {
                            if (this.f14594a.mo33175d()) {
                                C5695b bVar2 = this.f14594a;
                                bVar2.mo33174d(a2 + " authentication error: " + e.getMessage());
                            }
                        }
                    }
                    return;
                }
                m17857a(b);
            }
            if (b != null) {
                try {
                    oVar.mo33293a(m17856a(b, c, oVar, eVar));
                } catch (AuthenticationException e2) {
                    if (this.f14594a.mo33171b()) {
                        C5695b bVar3 = this.f14594a;
                        bVar3.mo33169b(b + " authentication error: " + e2.getMessage());
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m17857a(C5549c cVar) {
        C5887b.m18901a((Object) cVar, "Auth scheme");
    }

    /* renamed from: a */
    private C5691d m17856a(C5549c cVar, C5559l lVar, C5899o oVar, C5875e eVar) throws AuthenticationException {
        C5887b.m18901a((Object) cVar, "Auth scheme");
        if (cVar instanceof C5558k) {
            return ((C5558k) cVar).mo32867a(lVar, oVar, eVar);
        }
        return cVar.mo32837a(lVar, oVar);
    }
}
