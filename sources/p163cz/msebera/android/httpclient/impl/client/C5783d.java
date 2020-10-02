package p163cz.msebera.android.httpclient.impl.client;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import p163cz.msebera.android.httpclient.C5896l;
import p163cz.msebera.android.httpclient.auth.C5549c;
import p163cz.msebera.android.httpclient.client.C5575a;
import p163cz.msebera.android.httpclient.conn.C5638p;
import p163cz.msebera.android.httpclient.conn.UnsupportedSchemeException;
import p163cz.msebera.android.httpclient.impl.conn.C5814i;
import p163cz.msebera.android.httpclient.p177d0.C5695b;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.impl.client.d */
/* compiled from: BasicAuthCache */
public class C5783d implements C5575a {

    /* renamed from: a */
    public C5695b f14925a;

    /* renamed from: b */
    private final Map<C5896l, byte[]> f14926b;

    /* renamed from: c */
    private final C5638p f14927c;

    public C5783d(C5638p pVar) {
        this.f14925a = new C5695b(C5783d.class);
        this.f14926b = new ConcurrentHashMap();
        this.f14927c = pVar == null ? C5814i.f15010a : pVar;
    }

    /* renamed from: a */
    public void mo32908a(C5896l lVar, C5549c cVar) {
        C5886a.m18894a(lVar, "HTTP host");
        if (cVar != null) {
            if (cVar instanceof Serializable) {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                    objectOutputStream.writeObject(cVar);
                    objectOutputStream.close();
                    this.f14926b.put(mo33494c(lVar), byteArrayOutputStream.toByteArray());
                } catch (IOException e) {
                    if (this.f14925a.mo33175d()) {
                        this.f14925a.mo33170b("Unexpected I/O error while serializing auth scheme", e);
                    }
                }
            } else if (this.f14925a.mo33168a()) {
                C5695b bVar = this.f14925a;
                bVar.mo33166a("Auth scheme " + cVar.getClass() + " is not serializable");
            }
        }
    }

    /* renamed from: b */
    public C5549c mo32909b(C5896l lVar) {
        C5886a.m18894a(lVar, "HTTP host");
        byte[] bArr = this.f14926b.get(mo33494c(lVar));
        if (bArr != null) {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bArr));
                C5549c cVar = (C5549c) objectInputStream.readObject();
                objectInputStream.close();
                return cVar;
            } catch (IOException e) {
                if (this.f14925a.mo33175d()) {
                    this.f14925a.mo33170b("Unexpected I/O error while de-serializing auth scheme", e);
                }
            } catch (ClassNotFoundException e2) {
                if (this.f14925a.mo33175d()) {
                    this.f14925a.mo33170b("Unexpected error while de-serializing auth scheme", e2);
                }
                return null;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public C5896l mo33494c(C5896l lVar) {
        if (lVar.mo33686c() <= 0) {
            try {
                return new C5896l(lVar.mo33685b(), this.f14927c.mo33046a(lVar), lVar.mo33688d());
            } catch (UnsupportedSchemeException unused) {
            }
        }
        return lVar;
    }

    public String toString() {
        return this.f14926b.toString();
    }

    public C5783d() {
        this((C5638p) null);
    }

    /* renamed from: a */
    public void mo32907a(C5896l lVar) {
        C5886a.m18894a(lVar, "HTTP host");
        this.f14926b.remove(mo33494c(lVar));
    }
}
