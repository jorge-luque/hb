package admost.adserver.videocache;

import admost.adserver.videocache.p001q.C0086b;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: admost.adserver.videocache.g */
/* compiled from: HttpProxyCacheServerClients */
final class C0070g {

    /* renamed from: a */
    private final AtomicInteger f202a = new AtomicInteger(0);

    /* renamed from: b */
    private final String f203b;

    /* renamed from: c */
    private volatile C0065e f204c;

    /* renamed from: d */
    private final List<C0062b> f205d = new CopyOnWriteArrayList();

    /* renamed from: e */
    private final C0062b f206e;

    /* renamed from: f */
    private final C0063c f207f;

    public C0070g(String str, C0063c cVar) {
        C0077k.m231a(str);
        this.f203b = str;
        C0077k.m231a(cVar);
        this.f207f = cVar;
        this.f206e = new C0071a(str, this.f205d);
    }

    /* renamed from: c */
    private synchronized void m205c() {
        if (this.f202a.decrementAndGet() <= 0) {
            this.f204c.mo144a();
            this.f204c = null;
        }
    }

    /* renamed from: d */
    private C0065e m206d() throws ProxyCacheException {
        String str = this.f203b;
        C0063c cVar = this.f207f;
        C0065e eVar = new C0065e(new C0072h(str, cVar.f173d, cVar.f174e), new C0086b(this.f207f.mo111a(this.f203b), this.f207f.f172c));
        eVar.mo114a(this.f206e);
        return eVar;
    }

    /* renamed from: e */
    private synchronized void m207e() throws ProxyCacheException {
        this.f204c = this.f204c == null ? m206d() : this.f204c;
    }

    /* renamed from: a */
    public void mo126a(C0064d dVar, Socket socket) throws ProxyCacheException, IOException {
        m207e();
        try {
            this.f202a.incrementAndGet();
            this.f204c.mo115a(dVar, socket);
        } finally {
            m205c();
        }
    }

    /* renamed from: b */
    public void mo128b(C0062b bVar) {
        this.f205d.remove(bVar);
    }

    /* renamed from: admost.adserver.videocache.g$a */
    /* compiled from: HttpProxyCacheServerClients */
    private static final class C0071a extends Handler implements C0062b {

        /* renamed from: a */
        private final String f208a;

        /* renamed from: b */
        private final List<C0062b> f209b;

        public C0071a(String str, List<C0062b> list) {
            super(Looper.getMainLooper());
            this.f208a = str;
            this.f209b = list;
        }

        /* renamed from: a */
        public void mo54a(String str) {
            for (C0062b a : this.f209b) {
                a.mo54a(str);
            }
        }

        public void handleMessage(Message message) {
            for (C0062b a : this.f209b) {
                a.mo53a((File) message.obj, this.f208a, message.arg1);
            }
        }

        /* renamed from: a */
        public void mo53a(File file, String str, int i) {
            Message obtainMessage = obtainMessage();
            obtainMessage.arg1 = i;
            obtainMessage.obj = file;
            sendMessage(obtainMessage);
        }
    }

    /* renamed from: b */
    public void mo127b() {
        this.f205d.clear();
        if (this.f204c != null) {
            this.f204c.mo114a((C0062b) null);
            this.f204c.mo144a();
            this.f204c = null;
        }
        this.f202a.set(0);
    }

    /* renamed from: a */
    public void mo125a(C0062b bVar) {
        this.f205d.add(bVar);
    }

    /* renamed from: a */
    public int mo124a() {
        return this.f202a.get();
    }
}
