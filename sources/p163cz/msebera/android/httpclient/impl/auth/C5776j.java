package p163cz.msebera.android.httpclient.impl.auth;

import p163cz.msebera.android.httpclient.C5691d;
import p163cz.msebera.android.httpclient.C5899o;
import p163cz.msebera.android.httpclient.auth.AuthenticationException;
import p163cz.msebera.android.httpclient.auth.C5559l;
import p163cz.msebera.android.httpclient.auth.C5560m;
import p163cz.msebera.android.httpclient.auth.InvalidCredentialsException;
import p163cz.msebera.android.httpclient.auth.MalformedChallengeException;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5889d;

/* renamed from: cz.msebera.android.httpclient.impl.auth.j */
/* compiled from: NTLMScheme */
public class C5776j extends C5764a {

    /* renamed from: b */
    private final C5772h f14887b;

    /* renamed from: c */
    private C5777a f14888c;

    /* renamed from: d */
    private String f14889d;

    /* renamed from: cz.msebera.android.httpclient.impl.auth.j$a */
    /* compiled from: NTLMScheme */
    enum C5777a {
        UNINITIATED,
        CHALLENGE_RECEIVED,
        MSG_TYPE1_GENERATED,
        MSG_TYPE2_RECEVIED,
        MSG_TYPE3_GENERATED,
        FAILED;

        static {
            UNINITIATED = new C5777a("UNINITIATED", 0);
            CHALLENGE_RECEIVED = new C5777a("CHALLENGE_RECEIVED", 1);
            MSG_TYPE1_GENERATED = new C5777a("MSG_TYPE1_GENERATED", 2);
            MSG_TYPE2_RECEVIED = new C5777a("MSG_TYPE2_RECEVIED", 3);
            MSG_TYPE3_GENERATED = new C5777a("MSG_TYPE3_GENERATED", 4);
            FAILED = new C5777a("FAILED", 5);
        }
    }

    public C5776j(C5772h hVar) {
        C5886a.m18894a(hVar, "NTLM engine");
        this.f14887b = hVar;
        this.f14888c = C5777a.UNINITIATED;
        this.f14889d = null;
    }

    /* renamed from: a */
    public String mo32838a() {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo33434a(C5889d dVar, int i, int i2) throws MalformedChallengeException {
        String b = dVar.mo33675b(i, i2);
        this.f14889d = b;
        if (b.isEmpty()) {
            if (this.f14888c == C5777a.UNINITIATED) {
                this.f14888c = C5777a.CHALLENGE_RECEIVED;
            } else {
                this.f14888c = C5777a.FAILED;
            }
        } else if (this.f14888c.compareTo(C5777a.MSG_TYPE1_GENERATED) < 0) {
            this.f14888c = C5777a.FAILED;
            throw new MalformedChallengeException("Out of sequence NTLM response message");
        } else if (this.f14888c == C5777a.MSG_TYPE1_GENERATED) {
            this.f14888c = C5777a.MSG_TYPE2_RECEVIED;
        }
    }

    /* renamed from: b */
    public boolean mo32840b() {
        return true;
    }

    /* renamed from: c */
    public boolean mo32841c() {
        C5777a aVar = this.f14888c;
        return aVar == C5777a.MSG_TYPE3_GENERATED || aVar == C5777a.FAILED;
    }

    /* renamed from: d */
    public String mo32842d() {
        return "ntlm";
    }

    public C5776j() {
        this(new C5773i());
    }

    /* renamed from: a */
    public C5691d mo32837a(C5559l lVar, C5899o oVar) throws AuthenticationException {
        try {
            C5560m mVar = (C5560m) lVar;
            C5777a aVar = this.f14888c;
            if (aVar == C5777a.FAILED) {
                throw new AuthenticationException("NTLM authentication failed");
            } else if (aVar == C5777a.CHALLENGE_RECEIVED) {
                mVar.mo32870c();
                throw null;
            } else if (aVar == C5777a.MSG_TYPE2_RECEVIED) {
                mVar.mo32871d();
                throw null;
            } else {
                throw new AuthenticationException("Unexpected state: " + this.f14888c);
            }
        } catch (ClassCastException unused) {
            throw new InvalidCredentialsException("Credentials cannot be used for NTLM authentication: " + lVar.getClass().getName());
        }
    }
}
