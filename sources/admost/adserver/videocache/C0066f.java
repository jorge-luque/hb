package admost.adserver.videocache;

import admost.adserver.videocache.p001q.C0085a;
import admost.adserver.videocache.p001q.C0087c;
import admost.adserver.videocache.p001q.C0093f;
import admost.adserver.videocache.p001q.C0094g;
import admost.adserver.videocache.p002r.C0095a;
import admost.adserver.videocache.p002r.C0096b;
import admost.adserver.videocache.p003s.C0099c;
import admost.adserver.videocache.p003s.C0100d;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: admost.adserver.videocache.f */
/* compiled from: HttpProxyCacheServer */
public class C0066f {

    /* renamed from: a */
    private final Object f185a;

    /* renamed from: b */
    private final ExecutorService f186b;

    /* renamed from: c */
    private final Map<String, C0070g> f187c;

    /* renamed from: d */
    private final ServerSocket f188d;

    /* renamed from: e */
    private final int f189e;

    /* renamed from: f */
    private final Thread f190f;

    /* renamed from: g */
    private final C0063c f191g;

    /* renamed from: h */
    private final C0074j f192h;

    /* renamed from: admost.adserver.videocache.f$a */
    /* compiled from: HttpProxyCacheServer */
    public static final class C0067a {

        /* renamed from: a */
        private File f193a;

        /* renamed from: b */
        private C0087c f194b = new C0093f();

        /* renamed from: c */
        private C0085a f195c = new C0094g(536870912);

        /* renamed from: d */
        private C0099c f196d;

        /* renamed from: e */
        private C0096b f197e = new C0095a();

        public C0067a(Context context) {
            this.f196d = C0100d.m292a(context);
            this.f193a = C0084p.m261b(context);
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public C0063c m203a() {
            return new C0063c(this.f193a, this.f194b, this.f195c, this.f196d, this.f197e);
        }
    }

    /* renamed from: admost.adserver.videocache.f$b */
    /* compiled from: HttpProxyCacheServer */
    private final class C0068b implements Runnable {

        /* renamed from: a */
        private final Socket f198a;

        public C0068b(Socket socket) {
            this.f198a = socket;
        }

        public void run() {
            C0066f.this.m193d(this.f198a);
        }
    }

    /* renamed from: admost.adserver.videocache.f$c */
    /* compiled from: HttpProxyCacheServer */
    private final class C0069c implements Runnable {

        /* renamed from: a */
        private final CountDownLatch f200a;

        public C0069c(CountDownLatch countDownLatch) {
            this.f200a = countDownLatch;
        }

        public void run() {
            this.f200a.countDown();
            C0066f.this.m195e();
        }
    }

    public C0066f(Context context) {
        this(new C0067a(context).m203a());
    }

    /* renamed from: c */
    private boolean m190c() {
        return this.f192h.mo140a(3, 70);
    }

    /* renamed from: d */
    private File m191d(String str) {
        C0063c cVar = this.f191g;
        return new File(cVar.f170a, cVar.f171b.mo150a(str));
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m195e() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket accept = this.f188d.accept();
                "Accept new socket " + accept;
                this.f186b.submit(new C0068b(accept));
            } catch (IOException e) {
                m184a((Throwable) new ProxyCacheException("Error during waiting connection", e));
                return;
            }
        }
    }

    /* renamed from: b */
    public boolean mo121b(String str) {
        C0077k.m232a(str, "Url can't be null!");
        return m191d(str).exists();
    }

    private C0066f(C0063c cVar) {
        this.f185a = new Object();
        this.f186b = Executors.newFixedThreadPool(8);
        this.f187c = new ConcurrentHashMap();
        C0077k.m231a(cVar);
        this.f191g = cVar;
        try {
            ServerSocket serverSocket = new ServerSocket(0, 8, InetAddress.getByName("127.0.0.1"));
            this.f188d = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this.f189e = localPort;
            C0073i.m223a("127.0.0.1", localPort);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread = new Thread(new C0069c(countDownLatch));
            this.f190f = thread;
            thread.start();
            countDownLatch.await();
            this.f192h = new C0074j("127.0.0.1", this.f189e);
            "Proxy cache server started. Is it alive? " + m190c();
        } catch (IOException | InterruptedException e) {
            this.f186b.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e);
        }
    }

    /* renamed from: c */
    private String m188c(String str) {
        return String.format(Locale.US, "http://%s:%d/%s", new Object[]{"127.0.0.1", Integer.valueOf(this.f189e), C0081m.m256c(str)});
    }

    /* renamed from: b */
    private int m186b() {
        int i;
        synchronized (this.f185a) {
            i = 0;
            for (C0070g a : this.f187c.values()) {
                i += a.mo124a();
            }
        }
        return i;
    }

    /* renamed from: c */
    private void m189c(Socket socket) {
        try {
            if (!socket.isOutputShutdown()) {
                socket.shutdownOutput();
            }
        } catch (IOException e) {
            "Failed to close socket on proxy side: {}. It seems client have already closed connection." + e.getMessage();
        }
    }

    /* renamed from: a */
    public String mo116a(String str) {
        return mo117a(str, true);
    }

    /* renamed from: d */
    private void m192d() {
        synchronized (this.f185a) {
            for (C0070g b : this.f187c.values()) {
                b.mo127b();
            }
            this.f187c.clear();
        }
    }

    /* renamed from: a */
    public String mo117a(String str, boolean z) {
        if (!z || !mo121b(str)) {
            return m190c() ? m188c(str) : str;
        }
        File d = m191d(str);
        m183a(d);
        return Uri.fromFile(d).toString();
    }

    /* renamed from: e */
    private C0070g m194e(String str) throws ProxyCacheException {
        C0070g gVar;
        synchronized (this.f185a) {
            gVar = this.f187c.get(str);
            if (gVar == null) {
                gVar = new C0070g(str, this.f191g);
                this.f187c.put(str, gVar);
            }
        }
        return gVar;
    }

    /* renamed from: b */
    private void m187b(Socket socket) {
        try {
            if (!socket.isInputShutdown()) {
                socket.shutdownInput();
            }
        } catch (SocketException unused) {
        } catch (IOException e) {
            m184a((Throwable) new ProxyCacheException("Error closing socket input stream", e));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m193d(Socket socket) {
        StringBuilder sb;
        try {
            C0064d a = C0064d.m171a(socket.getInputStream());
            "Request to cache proxy:" + a;
            String b = C0081m.m255b(a.f177a);
            if (this.f192h.mo141a(b)) {
                this.f192h.mo139a(socket);
            } else {
                m194e(b).mo126a(a, socket);
            }
            m196e(socket);
            sb = new StringBuilder();
        } catch (SocketException unused) {
            m196e(socket);
            sb = new StringBuilder();
        } catch (ProxyCacheException | IOException e) {
            m184a((Throwable) new ProxyCacheException("Error processing request", e));
            m196e(socket);
            sb = new StringBuilder();
        } catch (Throwable th) {
            m196e(socket);
            "Opened connections: " + m186b();
            throw th;
        }
        sb.append("Opened connections: ");
        sb.append(m186b());
        sb.toString();
    }

    /* renamed from: a */
    public void mo120a(C0062b bVar, String str) {
        C0077k.m235a(bVar, str);
        synchronized (this.f185a) {
            try {
                m194e(str).mo125a(bVar);
            } catch (ProxyCacheException e) {
                Log.w("ADMOST-VIDEO", "Error registering cache listener", e);
            }
        }
    }

    /* renamed from: e */
    private void m196e(Socket socket) {
        m187b(socket);
        m189c(socket);
        m185a(socket);
    }

    /* renamed from: a */
    public void mo119a(C0062b bVar) {
        C0077k.m231a(bVar);
        synchronized (this.f185a) {
            for (C0070g b : this.f187c.values()) {
                b.mo128b(bVar);
            }
        }
    }

    /* renamed from: a */
    public void mo118a() {
        m192d();
        this.f191g.f173d.release();
        this.f190f.interrupt();
        try {
            if (!this.f188d.isClosed()) {
                this.f188d.close();
            }
        } catch (IOException e) {
            m184a((Throwable) new ProxyCacheException("Error shutting down proxy server", e));
        }
    }

    /* renamed from: a */
    private void m183a(File file) {
        try {
            this.f191g.f172c.mo149a(file);
        } catch (IOException e) {
            Log.w("ADMOST-VIDEO", "Error touching file " + file, e);
        }
    }

    /* renamed from: a */
    private void m185a(Socket socket) {
        try {
            if (!socket.isClosed()) {
                socket.close();
            }
        } catch (IOException e) {
            m184a((Throwable) new ProxyCacheException("Error closing socket", e));
        }
    }

    /* renamed from: a */
    private void m184a(Throwable th) {
        Log.w("ADMOST-VIDEO", "HttpProxyCacheServer error", th);
    }
}
