package admost.adserver.videocache;

import android.util.Log;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: admost.adserver.videocache.j */
/* compiled from: Pinger */
class C0074j {

    /* renamed from: a */
    private final ExecutorService f219a = Executors.newSingleThreadExecutor();

    /* renamed from: b */
    private final String f220b;

    /* renamed from: c */
    private final int f221c;

    /* renamed from: admost.adserver.videocache.j$b */
    /* compiled from: Pinger */
    private class C0076b implements Callable<Boolean> {
        private C0076b() {
        }

        public Boolean call() throws Exception {
            return Boolean.valueOf(C0074j.this.m227c());
        }
    }

    C0074j(String str, int i) {
        C0077k.m231a(str);
        this.f220b = str;
        this.f221c = i;
    }

    /* renamed from: b */
    private String m226b() {
        return String.format(Locale.US, "http://%s:%d/%s", new Object[]{this.f220b, Integer.valueOf(this.f221c), "ping"});
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean m227c() throws ProxyCacheException {
        C0072h hVar = new C0072h(m226b());
        try {
            byte[] bytes = "ping ok".getBytes();
            hVar.mo131a(0);
            byte[] bArr = new byte[bytes.length];
            hVar.read(bArr);
            boolean equals = Arrays.equals(bytes, bArr);
            "Ping response: `" + new String(bArr) + "`, pinged? " + equals;
            return equals;
        } catch (ProxyCacheException e) {
            Log.w("ADMOST-VIDEO", "Error reading ping response", e);
            return false;
        } finally {
            hVar.close();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo140a(int i, int i2) {
        C0077k.m233a(i >= 1);
        C0077k.m233a(i2 > 0);
        int i3 = 0;
        while (i3 < i) {
            try {
                if (((Boolean) this.f219a.submit(new C0076b()).get((long) i2, TimeUnit.MILLISECONDS)).booleanValue()) {
                    return true;
                }
                i3++;
                i2 *= 2;
            } catch (TimeoutException unused) {
                Log.w("ADMOST-VIDEO", "Error pinging server (attempt: " + i3 + ", timeout: " + i2 + "). ");
            } catch (InterruptedException | ExecutionException e) {
                Log.w("ADMOST-VIDEO", "Error pinging server due to unexpected error", e);
            }
        }
        String format = String.format(Locale.US, "Error pinging server (attempts: %d, max timeout: %d). If you see this message, please, report at https://github.com/danikula/AndroidVideoCache/issues/134. Default proxies are: %s", new Object[]{Integer.valueOf(i3), Integer.valueOf(i2 / 2), m224a()});
        Log.w("ADMOST-VIDEO", format, new ProxyCacheException(format));
        return false;
    }

    /* renamed from: a */
    private List<Proxy> m224a() {
        try {
            return ProxySelector.getDefault().select(new URI(m226b()));
        } catch (URISyntaxException e) {
            throw new IllegalStateException(e);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo141a(String str) {
        return "ping".equals(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo139a(Socket socket) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("HTTP/1.1 200 OK\n\n".getBytes());
        outputStream.write("ping ok".getBytes());
    }
}
