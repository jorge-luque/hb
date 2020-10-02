package p163cz.msebera.android.httpclient.impl.client;

import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import p163cz.msebera.android.httpclient.C5691d;
import p163cz.msebera.android.httpclient.C5896l;
import p163cz.msebera.android.httpclient.C5901q;
import p163cz.msebera.android.httpclient.auth.AuthenticationException;
import p163cz.msebera.android.httpclient.auth.C5547a;
import p163cz.msebera.android.httpclient.auth.C5549c;
import p163cz.msebera.android.httpclient.auth.C5554g;
import p163cz.msebera.android.httpclient.auth.C5559l;
import p163cz.msebera.android.httpclient.auth.MalformedChallengeException;
import p163cz.msebera.android.httpclient.client.C5575a;
import p163cz.msebera.android.httpclient.client.C5576b;
import p163cz.msebera.android.httpclient.client.C5577c;
import p163cz.msebera.android.httpclient.client.C5581g;
import p163cz.msebera.android.httpclient.p177d0.C5695b;
import p163cz.msebera.android.httpclient.p186j0.C5875e;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.client.b */
/* compiled from: AuthenticationStrategyAdaptor */
class C5781b implements C5577c {

    /* renamed from: a */
    public C5695b f14919a;

    /* renamed from: b */
    private final C5576b f14920b;

    /* renamed from: a */
    public Map<String, C5691d> mo32913a(C5896l lVar, C5901q qVar, C5875e eVar) throws MalformedChallengeException {
        return this.f14920b.mo32911a(qVar, eVar);
    }

    /* renamed from: b */
    public boolean mo32917b(C5896l lVar, C5901q qVar, C5875e eVar) {
        return this.f14920b.mo32912b(qVar, eVar);
    }

    /* renamed from: a */
    public Queue<C5547a> mo32914a(Map<String, C5691d> map, C5896l lVar, C5901q qVar, C5875e eVar) throws MalformedChallengeException {
        C5886a.m18894a(map, "Map of auth challenges");
        C5886a.m18894a(lVar, "Host");
        C5886a.m18894a(qVar, "HTTP response");
        C5886a.m18894a(eVar, "HTTP context");
        LinkedList linkedList = new LinkedList();
        C5581g gVar = (C5581g) eVar.mo33533a("http.auth.credentials-provider");
        if (gVar == null) {
            this.f14919a.mo33166a("Credentials provider not set in the context");
            return linkedList;
        }
        try {
            C5549c a = this.f14920b.mo32910a(map, qVar, eVar);
            a.mo32839a(map.get(a.mo32842d().toLowerCase(Locale.ROOT)));
            C5559l a2 = gVar.mo32925a(new C5554g(lVar.mo33685b(), lVar.mo33686c(), a.mo32838a(), a.mo32842d()));
            if (a2 != null) {
                linkedList.add(new C5547a(a, a2));
            }
            return linkedList;
        } catch (AuthenticationException e) {
            if (this.f14919a.mo33175d()) {
                this.f14919a.mo33170b(e.getMessage(), e);
            }
            return linkedList;
        }
    }

    /* renamed from: b */
    public void mo32916b(C5896l lVar, C5549c cVar, C5875e eVar) {
        C5575a aVar = (C5575a) eVar.mo33533a("http.auth.auth-cache");
        if (m18458a(cVar)) {
            if (aVar == null) {
                aVar = new C5783d();
                eVar.mo33535a("http.auth.auth-cache", aVar);
            }
            if (this.f14919a.mo33168a()) {
                C5695b bVar = this.f14919a;
                bVar.mo33166a("Caching '" + cVar.mo32842d() + "' auth scheme for " + lVar);
            }
            aVar.mo32908a(lVar, cVar);
        }
    }

    /* renamed from: a */
    public void mo32915a(C5896l lVar, C5549c cVar, C5875e eVar) {
        C5575a aVar = (C5575a) eVar.mo33533a("http.auth.auth-cache");
        if (aVar != null) {
            if (this.f14919a.mo33168a()) {
                C5695b bVar = this.f14919a;
                bVar.mo33166a("Removing from cache '" + cVar.mo32842d() + "' auth scheme for " + lVar);
            }
            aVar.mo32907a(lVar);
        }
    }

    /* renamed from: a */
    private boolean m18458a(C5549c cVar) {
        if (cVar == null || !cVar.mo32841c()) {
            return false;
        }
        String d = cVar.mo32842d();
        if (d.equalsIgnoreCase("Basic") || d.equalsIgnoreCase("Digest")) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public C5576b mo33491a() {
        return this.f14920b;
    }
}
