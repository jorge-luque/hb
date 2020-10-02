package p163cz.msebera.android.httpclient.impl.client;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import p163cz.msebera.android.httpclient.C5567c;
import p163cz.msebera.android.httpclient.C5691d;
import p163cz.msebera.android.httpclient.C5896l;
import p163cz.msebera.android.httpclient.C5901q;
import p163cz.msebera.android.httpclient.auth.C5547a;
import p163cz.msebera.android.httpclient.auth.C5549c;
import p163cz.msebera.android.httpclient.auth.C5551e;
import p163cz.msebera.android.httpclient.auth.C5554g;
import p163cz.msebera.android.httpclient.auth.C5559l;
import p163cz.msebera.android.httpclient.auth.MalformedChallengeException;
import p163cz.msebera.android.httpclient.client.C5575a;
import p163cz.msebera.android.httpclient.client.C5577c;
import p163cz.msebera.android.httpclient.client.C5581g;
import p163cz.msebera.android.httpclient.client.p167m.C5587a;
import p163cz.msebera.android.httpclient.client.p171q.C5606a;
import p163cz.msebera.android.httpclient.p165b0.C5564a;
import p163cz.msebera.android.httpclient.p177d0.C5695b;
import p163cz.msebera.android.httpclient.p186j0.C5874d;
import p163cz.msebera.android.httpclient.p186j0.C5875e;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5889d;

/* renamed from: cz.msebera.android.httpclient.impl.client.c */
/* compiled from: AuthenticationStrategyImpl */
abstract class C5782c implements C5577c {

    /* renamed from: d */
    private static final List<String> f14921d = Collections.unmodifiableList(Arrays.asList(new String[]{"Negotiate", "Kerberos", "NTLM", "Digest", "Basic"}));

    /* renamed from: a */
    public C5695b f14922a = new C5695b(getClass());

    /* renamed from: b */
    private final int f14923b;

    /* renamed from: c */
    private final String f14924c;

    C5782c(int i, String str) {
        this.f14923b = i;
        this.f14924c = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract Collection<String> mo33492a(C5587a aVar);

    /* renamed from: a */
    public Map<String, C5691d> mo32913a(C5896l lVar, C5901q qVar, C5875e eVar) throws MalformedChallengeException {
        C5889d dVar;
        int i;
        C5886a.m18894a(qVar, "HTTP response");
        C5691d[] headers = qVar.getHeaders(this.f14924c);
        HashMap hashMap = new HashMap(headers.length);
        for (C5691d dVar2 : headers) {
            if (dVar2 instanceof C5567c) {
                C5567c cVar = (C5567c) dVar2;
                dVar = cVar.mo32887a();
                i = cVar.mo32888c();
            } else {
                String value = dVar2.getValue();
                if (value != null) {
                    dVar = new C5889d(value.length());
                    dVar.mo33670a(value);
                    i = 0;
                } else {
                    throw new MalformedChallengeException("Header value is null");
                }
            }
            while (i < dVar.length() && C5874d.m18865a(dVar.charAt(i))) {
                i++;
            }
            int i2 = i;
            while (i2 < dVar.length() && !C5874d.m18865a(dVar.charAt(i2))) {
                i2++;
            }
            hashMap.put(dVar.mo33665a(i, i2).toLowerCase(Locale.ROOT), dVar2);
        }
        return hashMap;
    }

    /* renamed from: b */
    public boolean mo32917b(C5896l lVar, C5901q qVar, C5875e eVar) {
        C5886a.m18894a(qVar, "HTTP response");
        return qVar.mo33335a().mo33371a() == this.f14923b;
    }

    /* renamed from: b */
    public void mo32916b(C5896l lVar, C5549c cVar, C5875e eVar) {
        C5886a.m18894a(lVar, "Host");
        C5886a.m18894a(cVar, "Auth scheme");
        C5886a.m18894a(eVar, "HTTP context");
        C5606a a = C5606a.m17839a(eVar);
        if (mo33493a(cVar)) {
            C5575a e = a.mo32975e();
            if (e == null) {
                e = new C5783d();
                a.mo32974a(e);
            }
            if (this.f14922a.mo33168a()) {
                C5695b bVar = this.f14922a;
                bVar.mo33166a("Caching '" + cVar.mo32842d() + "' auth scheme for " + lVar);
            }
            e.mo32908a(lVar, cVar);
        }
    }

    /* renamed from: a */
    public Queue<C5547a> mo32914a(Map<String, C5691d> map, C5896l lVar, C5901q qVar, C5875e eVar) throws MalformedChallengeException {
        C5886a.m18894a(map, "Map of auth challenges");
        C5886a.m18894a(lVar, "Host");
        C5886a.m18894a(qVar, "HTTP response");
        C5886a.m18894a(eVar, "HTTP context");
        C5606a a = C5606a.m17839a(eVar);
        LinkedList linkedList = new LinkedList();
        C5564a<C5551e> f = a.mo32976f();
        if (f == null) {
            this.f14922a.mo33166a("Auth scheme registry not set in the context");
            return linkedList;
        }
        C5581g k = a.mo32981k();
        if (k == null) {
            this.f14922a.mo33166a("Credentials provider not set in the context");
            return linkedList;
        }
        Collection<String> a2 = mo33492a(a.mo32984n());
        if (a2 == null) {
            a2 = f14921d;
        }
        if (this.f14922a.mo33168a()) {
            C5695b bVar = this.f14922a;
            bVar.mo33166a("Authentication schemes in the order of preference: " + a2);
        }
        for (String str : a2) {
            C5691d dVar = map.get(str.toLowerCase(Locale.ROOT));
            if (dVar != null) {
                C5551e a3 = f.mo32846a(str);
                if (a3 != null) {
                    C5549c a4 = a3.mo32844a(eVar);
                    a4.mo32839a(dVar);
                    C5559l a5 = k.mo32925a(new C5554g(lVar.mo33685b(), lVar.mo33686c(), a4.mo32838a(), a4.mo32842d()));
                    if (a5 != null) {
                        linkedList.add(new C5547a(a4, a5));
                    }
                } else if (this.f14922a.mo33175d()) {
                    C5695b bVar2 = this.f14922a;
                    bVar2.mo33174d("Authentication scheme " + str + " not supported");
                }
            } else if (this.f14922a.mo33168a()) {
                C5695b bVar3 = this.f14922a;
                bVar3.mo33166a("Challenge for " + str + " authentication scheme not available");
            }
        }
        return linkedList;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo33493a(C5549c cVar) {
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
    public void mo32915a(C5896l lVar, C5549c cVar, C5875e eVar) {
        C5886a.m18894a(lVar, "Host");
        C5886a.m18894a(eVar, "HTTP context");
        C5575a e = C5606a.m17839a(eVar).mo32975e();
        if (e != null) {
            if (this.f14922a.mo33168a()) {
                C5695b bVar = this.f14922a;
                bVar.mo33166a("Clearing cached auth scheme for " + lVar);
            }
            e.mo32907a(lVar);
        }
    }
}
