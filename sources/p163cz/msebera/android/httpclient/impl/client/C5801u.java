package p163cz.msebera.android.httpclient.impl.client;

import java.net.URI;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: cz.msebera.android.httpclient.impl.client.u */
/* compiled from: RedirectLocations */
public class C5801u extends AbstractList<Object> {

    /* renamed from: a */
    private final Set<URI> f14966a = new HashSet();

    /* renamed from: b */
    private final List<URI> f14967b = new ArrayList();

    /* renamed from: a */
    public void mo33518a(URI uri) {
        this.f14966a.add(uri);
        this.f14967b.add(uri);
    }

    public void add(int i, Object obj) {
        URI uri = (URI) obj;
        this.f14967b.add(i, uri);
        this.f14966a.add(uri);
    }

    /* renamed from: b */
    public boolean mo33520b(URI uri) {
        return this.f14966a.contains(uri);
    }

    public boolean contains(Object obj) {
        return this.f14966a.contains(obj);
    }

    public Object set(int i, Object obj) {
        URI uri = (URI) obj;
        URI uri2 = this.f14967b.set(i, uri);
        this.f14966a.remove(uri2);
        this.f14966a.add(uri);
        if (this.f14967b.size() != this.f14966a.size()) {
            this.f14966a.addAll(this.f14967b);
        }
        return uri2;
    }

    public int size() {
        return this.f14967b.size();
    }

    public URI get(int i) {
        return this.f14967b.get(i);
    }

    public URI remove(int i) {
        URI remove = this.f14967b.remove(i);
        this.f14966a.remove(remove);
        if (this.f14967b.size() != this.f14966a.size()) {
            this.f14966a.addAll(this.f14967b);
        }
        return remove;
    }
}
