package admost.adserver.videocache;

import admost.adserver.videocache.p001q.C0086b;
import android.text.TextUtils;
import com.facebook.internal.Utility;
import com.loopj.android.http.C4250c;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: admost.adserver.videocache.e */
/* compiled from: HttpProxyCache */
class C0065e extends C0078l {

    /* renamed from: i */
    private final C0072h f180i;

    /* renamed from: j */
    private final C0086b f181j;

    /* renamed from: k */
    private C0062b f182k;

    /* renamed from: l */
    private AtomicBoolean f183l = new AtomicBoolean(false);

    /* renamed from: m */
    private final Object f184m = new Object();

    public C0065e(C0072h hVar, C0086b bVar) {
        super(hVar, bVar);
        this.f181j = bVar;
        this.f180i = hVar;
    }

    /* renamed from: b */
    private String m176b(C0064d dVar) throws IOException, ProxyCacheException {
        String a = this.f180i.mo130a();
        boolean z = !TextUtils.isEmpty(a);
        long available = this.f181j.mo107a() ? this.f181j.available() : this.f180i.length();
        boolean z2 = available >= 0;
        long j = dVar.f179c ? available - dVar.f178b : available;
        boolean z3 = z2 && dVar.f179c;
        StringBuilder sb = new StringBuilder();
        sb.append(dVar.f179c ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n");
        sb.append("Accept-Ranges: bytes\n");
        String str = "";
        sb.append(z2 ? m173a("Content-Length: %d\n", Long.valueOf(j)) : str);
        sb.append(z3 ? m173a("Content-Range: bytes %d-%d/%d\n", Long.valueOf(dVar.f178b), Long.valueOf(available - 1), Long.valueOf(available)) : str);
        if (z) {
            str = m173a("Content-Type: %s\n", a);
        }
        sb.append(str);
        sb.append("\n");
        return sb.toString();
    }

    /* renamed from: a */
    public void mo114a(C0062b bVar) {
        this.f182k = bVar;
    }

    /* renamed from: a */
    public void mo115a(C0064d dVar, Socket socket) throws IOException, ProxyCacheException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(m176b(dVar).getBytes(C4250c.DEFAULT_CHARSET));
        long j = dVar.f178b;
        if (m175a(dVar)) {
            "Video served from cache: " + dVar.f177a;
            m174a((OutputStream) bufferedOutputStream, j);
            return;
        }
        "Video is being downloaded: " + dVar.f177a;
        m177b(bufferedOutputStream, j);
    }

    /* renamed from: a */
    private boolean m175a(C0064d dVar) throws ProxyCacheException {
        long length = this.f180i.length();
        boolean z = length > 0;
        long available = this.f181j.available();
        if (!z || !dVar.f179c || ((float) dVar.f178b) <= ((float) available) + (((float) length) * 0.2f)) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private void m174a(OutputStream outputStream, long j) throws ProxyCacheException, IOException {
        byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
        while (true) {
            int a = mo143a(bArr, j, Utility.DEFAULT_STREAM_BUFFER_SIZE);
            if (a != -1) {
                outputStream.write(bArr, 0, a);
                j += (long) a;
            } else {
                outputStream.flush();
                return;
            }
        }
    }

    /* renamed from: b */
    private void m177b(OutputStream outputStream, long j) throws ProxyCacheException, IOException {
        C0072h hVar = new C0072h(this.f180i);
        try {
            hVar.mo131a((long) ((int) j));
            byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
            while (true) {
                int read = hVar.read(bArr);
                if (read != -1) {
                    outputStream.write(bArr, 0, read);
                } else {
                    outputStream.flush();
                    return;
                }
            }
        } finally {
            hVar.close();
        }
    }

    /* renamed from: a */
    private String m173a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo113a(int i) {
        if (this.f182k != null) {
            synchronized (this.f184m) {
                this.f182k.mo53a(this.f181j.f236b, this.f180i.mo132b(), i);
                if (i >= 100 && this.f183l.compareAndSet(false, true)) {
                    this.f182k.mo54a(this.f180i.mo132b());
                }
            }
        }
    }
}
