package admost.adserver.videocache;

import admost.adserver.videocache.p001q.C0085a;
import admost.adserver.videocache.p001q.C0087c;
import admost.adserver.videocache.p002r.C0096b;
import admost.adserver.videocache.p003s.C0099c;
import java.io.File;

/* renamed from: admost.adserver.videocache.c */
/* compiled from: Config */
class C0063c {

    /* renamed from: a */
    public final File f170a;

    /* renamed from: b */
    public final C0087c f171b;

    /* renamed from: c */
    public final C0085a f172c;

    /* renamed from: d */
    public final C0099c f173d;

    /* renamed from: e */
    public final C0096b f174e;

    C0063c(File file, C0087c cVar, C0085a aVar, C0099c cVar2, C0096b bVar) {
        this.f170a = file;
        this.f171b = cVar;
        this.f172c = aVar;
        this.f173d = cVar2;
        this.f174e = bVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public File mo111a(String str) {
        return new File(this.f170a, this.f171b.mo150a(str));
    }
}
