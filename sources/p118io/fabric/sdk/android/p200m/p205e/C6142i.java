package p118io.fabric.sdk.android.p200m.p205e;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import org.json.JSONObject;
import p118io.fabric.sdk.android.C6059c;
import p118io.fabric.sdk.android.C6069h;
import p118io.fabric.sdk.android.p200m.p202b.C6090i;
import p118io.fabric.sdk.android.p200m.p204d.C6131b;

/* renamed from: io.fabric.sdk.android.m.e.i */
/* compiled from: DefaultCachedSettingsIo */
class C6142i implements C6140g {

    /* renamed from: a */
    private final C6069h f16140a;

    public C6142i(C6069h hVar) {
        this.f16140a = hVar;
    }

    /* renamed from: a */
    public JSONObject mo34247a() {
        FileInputStream fileInputStream;
        JSONObject jSONObject;
        C6059c.m19630f().mo34093d("Fabric", "Reading cached settings...");
        FileInputStream fileInputStream2 = null;
        try {
            File file = new File(new C6131b(this.f16140a).mo34239a(), "com.crashlytics.settings.json");
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    jSONObject = new JSONObject(C6090i.m19741b((InputStream) fileInputStream));
                    fileInputStream2 = fileInputStream;
                } catch (Exception e) {
                    e = e;
                    try {
                        C6059c.m19630f().mo34090b("Fabric", "Failed to fetch cached settings", e);
                        C6090i.m19733a((Closeable) fileInputStream, "Error while closing settings cache file.");
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        C6090i.m19733a((Closeable) fileInputStream, "Error while closing settings cache file.");
                        throw th;
                    }
                }
            } else {
                C6059c.m19630f().mo34093d("Fabric", "No cached settings found.");
                jSONObject = null;
            }
            C6090i.m19733a((Closeable) fileInputStream2, "Error while closing settings cache file.");
            return jSONObject;
        } catch (Exception e2) {
            e = e2;
            fileInputStream = null;
            C6059c.m19630f().mo34090b("Fabric", "Failed to fetch cached settings", e);
            C6090i.m19733a((Closeable) fileInputStream, "Error while closing settings cache file.");
            return null;
        } catch (Throwable th2) {
            fileInputStream = null;
            th = th2;
            C6090i.m19733a((Closeable) fileInputStream, "Error while closing settings cache file.");
            throw th;
        }
    }

    /* renamed from: a */
    public void mo34248a(long j, JSONObject jSONObject) {
        C6059c.m19630f().mo34093d("Fabric", "Writing settings to cache file...");
        if (jSONObject != null) {
            FileWriter fileWriter = null;
            try {
                jSONObject.put("expires_at", j);
                FileWriter fileWriter2 = new FileWriter(new File(new C6131b(this.f16140a).mo34239a(), "com.crashlytics.settings.json"));
                try {
                    fileWriter2.write(jSONObject.toString());
                    fileWriter2.flush();
                    C6090i.m19733a((Closeable) fileWriter2, "Failed to close settings writer.");
                } catch (Exception e) {
                    e = e;
                    fileWriter = fileWriter2;
                    try {
                        C6059c.m19630f().mo34090b("Fabric", "Failed to cache settings", e);
                        C6090i.m19733a((Closeable) fileWriter, "Failed to close settings writer.");
                    } catch (Throwable th) {
                        th = th;
                        C6090i.m19733a((Closeable) fileWriter, "Failed to close settings writer.");
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileWriter = fileWriter2;
                    C6090i.m19733a((Closeable) fileWriter, "Failed to close settings writer.");
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                C6059c.m19630f().mo34090b("Fabric", "Failed to cache settings", e);
                C6090i.m19733a((Closeable) fileWriter, "Failed to close settings writer.");
            }
        }
    }
}
