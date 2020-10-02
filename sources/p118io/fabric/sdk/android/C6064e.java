package p118io.fabric.sdk.android;

import android.os.SystemClock;
import android.text.TextUtils;
import com.google.ads.AdRequest;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import p118io.fabric.sdk.android.p200m.p202b.C6090i;

/* renamed from: io.fabric.sdk.android.e */
/* compiled from: FabricKitsFinder */
class C6064e implements Callable<Map<String, C6071j>> {

    /* renamed from: a */
    final String f15987a;

    C6064e(String str) {
        this.f15987a = str;
    }

    /* renamed from: a */
    private C6071j m19648a(ZipEntry zipEntry, ZipFile zipFile) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        try {
            inputStream = zipFile.getInputStream(zipEntry);
            try {
                Properties properties = new Properties();
                properties.load(inputStream);
                String property = properties.getProperty("fabric-identifier");
                String property2 = properties.getProperty("fabric-version");
                String property3 = properties.getProperty("fabric-build-type");
                if (TextUtils.isEmpty(property) || TextUtils.isEmpty(property2)) {
                    throw new IllegalStateException("Invalid format of fabric file," + zipEntry.getName());
                }
                C6071j jVar = new C6071j(property, property2, property3);
                C6090i.m19732a((Closeable) inputStream);
                return jVar;
            } catch (IOException e) {
                e = e;
                try {
                    C6059c.m19630f().mo34090b("Fabric", "Error when parsing fabric properties " + zipEntry.getName(), e);
                    C6090i.m19732a((Closeable) inputStream);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    inputStream2 = inputStream;
                    C6090i.m19732a((Closeable) inputStream2);
                    throw th;
                }
            }
        } catch (IOException e2) {
            e = e2;
            inputStream = null;
            C6059c.m19630f().mo34090b("Fabric", "Error when parsing fabric properties " + zipEntry.getName(), e);
            C6090i.m19732a((Closeable) inputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            C6090i.m19732a((Closeable) inputStream2);
            throw th;
        }
    }

    /* renamed from: b */
    private Map<String, C6071j> m19649b() {
        HashMap hashMap = new HashMap();
        try {
            Class.forName("com.google.android.gms.ads.AdView");
            C6071j jVar = new C6071j("com.google.firebase.firebase-ads", AdRequest.VERSION, "binary");
            hashMap.put(jVar.mo34140b(), jVar);
            C6059c.m19630f().mo34091c("Fabric", "Found kit: com.google.firebase.firebase-ads");
        } catch (Exception unused) {
        }
        return hashMap;
    }

    /* renamed from: c */
    private Map<String, C6071j> m19650c() throws Exception {
        C6071j a;
        HashMap hashMap = new HashMap();
        ZipFile a2 = mo34119a();
        Enumeration<? extends ZipEntry> entries = a2.entries();
        while (entries.hasMoreElements()) {
            ZipEntry zipEntry = (ZipEntry) entries.nextElement();
            if (zipEntry.getName().startsWith("fabric/") && zipEntry.getName().length() > 7 && (a = m19648a(zipEntry, a2)) != null) {
                hashMap.put(a.mo34140b(), a);
                C6059c.m19630f().mo34091c("Fabric", String.format("Found kit:[%s] version:[%s]", new Object[]{a.mo34140b(), a.mo34141c()}));
            }
        }
        if (a2 != null) {
            try {
                a2.close();
            } catch (IOException unused) {
            }
        }
        return hashMap;
    }

    public Map<String, C6071j> call() throws Exception {
        HashMap hashMap = new HashMap();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        hashMap.putAll(m19649b());
        hashMap.putAll(m19650c());
        C6072k f = C6059c.m19630f();
        f.mo34091c("Fabric", "finish scanning in " + (SystemClock.elapsedRealtime() - elapsedRealtime));
        return hashMap;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public ZipFile mo34119a() throws IOException {
        return new ZipFile(this.f15987a);
    }
}
