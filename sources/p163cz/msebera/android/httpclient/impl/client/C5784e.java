package p163cz.msebera.android.httpclient.impl.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import p163cz.msebera.android.httpclient.client.C5580f;
import p163cz.msebera.android.httpclient.cookie.C5679c;
import p163cz.msebera.android.httpclient.cookie.C5681e;

/* renamed from: cz.msebera.android.httpclient.impl.client.e */
/* compiled from: BasicCookieStore */
public class C5784e implements C5580f, Serializable {
    private static final long serialVersionUID = -7581093305228232025L;

    /* renamed from: a */
    private final TreeSet<C5679c> f14928a = new TreeSet<>(new C5681e());

    /* renamed from: a */
    public synchronized void mo32923a(C5679c cVar) {
        if (cVar != null) {
            this.f14928a.remove(cVar);
            if (!cVar.mo33125b(new Date())) {
                this.f14928a.add(cVar);
            }
        }
    }

    public synchronized String toString() {
        return this.f14928a.toString();
    }

    /* renamed from: a */
    public synchronized List<C5679c> mo32922a() {
        return new ArrayList(this.f14928a);
    }

    /* renamed from: a */
    public synchronized boolean mo32924a(Date date) {
        boolean z = false;
        if (date == null) {
            return false;
        }
        Iterator<C5679c> it = this.f14928a.iterator();
        while (it.hasNext()) {
            if (it.next().mo33125b(date)) {
                it.remove();
                z = true;
            }
        }
        return z;
    }
}
