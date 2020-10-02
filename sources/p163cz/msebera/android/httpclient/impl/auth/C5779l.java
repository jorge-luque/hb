package p163cz.msebera.android.httpclient.impl.auth;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import p163cz.msebera.android.httpclient.C5563b;
import p163cz.msebera.android.httpclient.C5696e;
import p163cz.msebera.android.httpclient.C5899o;
import p163cz.msebera.android.httpclient.auth.MalformedChallengeException;
import p163cz.msebera.android.httpclient.p182g0.C5737g;
import p163cz.msebera.android.httpclient.p182g0.C5752v;
import p163cz.msebera.android.httpclient.p187k0.C5889d;
import p163cz.msebera.android.httpclient.p187k0.C5890e;

/* renamed from: cz.msebera.android.httpclient.impl.auth.l */
/* compiled from: RFC2617Scheme */
public abstract class C5779l extends C5764a implements Serializable {
    private static final long serialVersionUID = -2845454858205884623L;

    /* renamed from: b */
    private final Map<String, String> f14896b;

    /* renamed from: c */
    private transient Charset f14897c;

    public C5779l(Charset charset) {
        this.f14896b = new HashMap();
        this.f14897c = charset == null ? C5563b.f14521b : charset;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Charset a = C5890e.m18931a(objectInputStream.readUTF());
        this.f14897c = a;
        if (a == null) {
            this.f14897c = C5563b.f14521b;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeUTF(this.f14897c.name());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo33443a(C5899o oVar) {
        String str = (String) oVar.getParams().mo33425b("http.auth.credential-charset");
        return str == null ? mo33445f().name() : str;
    }

    /* renamed from: f */
    public Charset mo33445f() {
        Charset charset = this.f14897c;
        return charset != null ? charset : C5563b.f14521b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public Map<String, String> mo33446g() {
        return this.f14896b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo33434a(C5889d dVar, int i, int i2) throws MalformedChallengeException {
        C5696e[] a = C5737g.f14811b.mo33330a(dVar, new C5752v(i, dVar.length()));
        this.f14896b.clear();
        for (C5696e eVar : a) {
            this.f14896b.put(eVar.getName().toLowerCase(Locale.ROOT), eVar.getValue());
        }
    }

    public C5779l() {
        this(C5563b.f14521b);
    }

    /* renamed from: a */
    public String mo33444a(String str) {
        if (str == null) {
            return null;
        }
        return this.f14896b.get(str.toLowerCase(Locale.ROOT));
    }

    /* renamed from: a */
    public String mo32838a() {
        return mo33444a("realm");
    }
}
