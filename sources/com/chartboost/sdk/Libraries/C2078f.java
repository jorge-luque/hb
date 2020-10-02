package com.chartboost.sdk.Libraries;

import android.content.Context;
import com.chartboost.sdk.C2242k;
import com.chartboost.sdk.Model.C2093h;
import com.chartboost.sdk.Tracking.C2098a;
import com.chartboost.sdk.impl.C2224x;
import com.chartboost.sdk.impl.C2238z1;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.Libraries.f */
public class C2078f {

    /* renamed from: a */
    private final AtomicReference<C2093h> f6863a;

    /* renamed from: b */
    private final C2079g f6864b;

    /* renamed from: c */
    private final AtomicReference<C2079g> f6865c;

    /* renamed from: d */
    private C2224x f6866d;

    public C2078f(C2224x xVar, Context context, AtomicReference<C2093h> atomicReference) {
        C2078f fVar = this;
        fVar.f6866d = xVar;
        fVar.f6864b = new C2079g(context.getCacheDir());
        fVar.f6865c = new AtomicReference<>();
        fVar.f6863a = atomicReference;
        try {
            File a = xVar.mo9547a();
            if (a != null) {
                fVar.f6865c.set(new C2079g(a));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        new File(fVar.f6864b.f6867a, "track");
        new File(fVar.f6864b.f6867a, "session");
        int i = 2;
        C2079g[] gVarArr = {fVar.f6864b, fVar.f6865c.get()};
        int i2 = 0;
        while (i2 < i) {
            C2079g gVar = gVarArr[i2];
            try {
                boolean z = gVar == fVar.f6864b;
                if (gVar != null && (z || mo9097e())) {
                    long currentTimeMillis = System.currentTimeMillis() - TimeUnit.DAYS.toMillis((long) atomicReference.get().f7021u);
                    File file = new File(gVar.f6867a, "templates");
                    if (file.exists()) {
                        File[] listFiles = file.listFiles();
                        if (listFiles != null) {
                            int length = listFiles.length;
                            int i3 = 0;
                            while (i3 < length) {
                                File file2 = listFiles[i3];
                                if (file2.isDirectory()) {
                                    File[] listFiles2 = file2.listFiles();
                                    if (listFiles2 != null) {
                                        int length2 = listFiles2.length;
                                        int i4 = 0;
                                        while (i4 < length2) {
                                            File file3 = listFiles2[i4];
                                            if ((z || file3.lastModified() < currentTimeMillis) && !file3.delete()) {
                                                CBLogging.m8154b("FileCache", "Unable to delete " + file3.getPath());
                                            }
                                            i4++;
                                            AtomicReference<C2093h> atomicReference2 = atomicReference;
                                        }
                                    }
                                    File[] listFiles3 = file2.listFiles();
                                    if (listFiles3 != null && listFiles3.length == 0 && !file2.delete()) {
                                        CBLogging.m8154b("FileCache", "Unable to delete " + file2.getPath());
                                    }
                                }
                                i3++;
                                AtomicReference<C2093h> atomicReference3 = atomicReference;
                            }
                        }
                    }
                    File file4 = new File(gVar.f6867a, ".adId");
                    if (file4.exists() && ((z || file4.lastModified() < currentTimeMillis) && !file4.delete())) {
                        CBLogging.m8154b("FileCache", "Unable to delete " + file4.getPath());
                    }
                }
            } catch (Exception e2) {
                CBLogging.m8153a("FileCache", "Exception while cleaning up templates directory at " + gVar.f6869c.getPath(), e2);
                e2.printStackTrace();
            }
            i2++;
            AtomicReference<C2093h> atomicReference4 = atomicReference;
            i = 2;
            fVar = this;
        }
    }

    /* renamed from: a */
    public String mo9090a(String str) {
        File file = new File(mo9089a().f6870d, str);
        if (file.exists()) {
            return file.getPath();
        }
        return null;
    }

    /* renamed from: b */
    public synchronized byte[] mo9093b(File file) {
        byte[] bArr;
        bArr = null;
        if (file == null) {
            return null;
        }
        try {
            bArr = C2238z1.m8891b(file);
        } catch (Exception e) {
            CBLogging.m8153a("FileCache", "Error loading cache from disk", e);
            C2098a.m8288a(C2078f.class, "readByteArrayFromDisk", e);
        }
        return bArr;
    }

    /* renamed from: c */
    public JSONArray mo9094c() {
        JSONArray jSONArray = new JSONArray();
        String[] list = mo9089a().f6870d.list();
        if (list != null) {
            for (String str : list) {
                if (!str.equals(".nomedia") && !str.endsWith(".tmp")) {
                    jSONArray.put(str);
                }
            }
        }
        return jSONArray;
    }

    /* renamed from: d */
    public JSONObject mo9096d() {
        String[] list;
        JSONObject jSONObject = new JSONObject();
        try {
            File file = mo9089a().f6867a;
            for (String next : this.f6863a.get().f7022v) {
                if (!next.equals("templates")) {
                    File file2 = new File(file, next);
                    JSONArray jSONArray = new JSONArray();
                    if (file2.exists() && (list = file2.list()) != null) {
                        for (String str : list) {
                            if (!str.equals(".nomedia") && !str.endsWith(".tmp")) {
                                jSONArray.put(str);
                            }
                        }
                    }
                    C2076e.m8187a(jSONObject, next, jSONArray);
                }
            }
        } catch (Exception e) {
            C2098a.m8288a(C2078f.class, "getWebViewCacheAssets", e);
        }
        return jSONObject;
    }

    /* renamed from: e */
    public boolean mo9097e() {
        try {
            String b = this.f6866d.mo9550b();
            if (b != null && b.equals("mounted") && !C2242k.f7613m) {
                return true;
            }
        } catch (Exception e) {
            C2098a.m8288a(C2078f.class, "isExternalStorageAvailable", e);
        }
        CBLogging.m8156c("FileCache", "External Storage unavailable");
        return false;
    }

    /* renamed from: a */
    public C2079g mo9089a() {
        if (mo9097e()) {
            C2079g gVar = this.f6865c.get();
            if (gVar == null) {
                try {
                    File a = this.f6866d.mo9547a();
                    if (a != null) {
                        this.f6865c.compareAndSet((Object) null, new C2079g(a));
                        gVar = this.f6865c.get();
                    }
                } catch (Exception e) {
                    C2098a.m8288a(C2078f.class, "currentLocations", e);
                }
            }
            if (gVar != null) {
                return gVar;
            }
        }
        return this.f6864b;
    }

    /* renamed from: b */
    public boolean mo9092b(String str) {
        if (mo9089a().f6868b == null || str == null) {
            return false;
        }
        return new File(mo9089a().f6868b, str).exists();
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0030 A[Catch:{ FileNotFoundException -> 0x0031, IOException -> 0x0028, all -> 0x0026 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x003f A[SYNTHETIC, Splitter:B:28:0x003f] */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo9095c(java.io.File r6) {
        /*
            r5 = this;
            java.lang.String r0 = "FileCache"
            r1 = 0
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch:{ FileNotFoundException -> 0x0031, IOException -> 0x0028 }
            java.lang.String r3 = "rw"
            r2.<init>(r6, r3)     // Catch:{ FileNotFoundException -> 0x0031, IOException -> 0x0028 }
            r3 = 0
            r2.seek(r3)     // Catch:{ FileNotFoundException -> 0x0023, IOException -> 0x0020, all -> 0x001d }
            int r6 = r2.read()     // Catch:{ FileNotFoundException -> 0x0023, IOException -> 0x0020, all -> 0x001d }
            r2.seek(r3)     // Catch:{ FileNotFoundException -> 0x0023, IOException -> 0x0020, all -> 0x001d }
            r2.write(r6)     // Catch:{ FileNotFoundException -> 0x0023, IOException -> 0x0020, all -> 0x001d }
            r2.close()     // Catch:{ IOException -> 0x003c }
            goto L_0x003c
        L_0x001d:
            r6 = move-exception
            r1 = r2
            goto L_0x003d
        L_0x0020:
            r6 = move-exception
            r1 = r2
            goto L_0x0029
        L_0x0023:
            r6 = move-exception
            r1 = r2
            goto L_0x0032
        L_0x0026:
            r6 = move-exception
            goto L_0x003d
        L_0x0028:
            r6 = move-exception
        L_0x0029:
            java.lang.String r2 = "IOException when attempting to touch file"
            com.chartboost.sdk.Libraries.CBLogging.m8153a(r0, r2, r6)     // Catch:{ all -> 0x0026 }
            if (r1 == 0) goto L_0x003c
            goto L_0x0039
        L_0x0031:
            r6 = move-exception
        L_0x0032:
            java.lang.String r2 = "File not found when attempting to touch"
            com.chartboost.sdk.Libraries.CBLogging.m8153a(r0, r2, r6)     // Catch:{ all -> 0x0026 }
            if (r1 == 0) goto L_0x003c
        L_0x0039:
            r1.close()     // Catch:{ IOException -> 0x003c }
        L_0x003c:
            return
        L_0x003d:
            if (r1 == 0) goto L_0x0042
            r1.close()     // Catch:{ IOException -> 0x0042 }
        L_0x0042:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.Libraries.C2078f.mo9095c(java.io.File):void");
    }

    /* renamed from: b */
    public JSONObject mo9091b() {
        JSONObject jSONObject = new JSONObject();
        C2079g gVar = this.f6865c.get();
        if (gVar != null) {
            C2076e.m8187a(jSONObject, ".chartboost-external-folder-size", Long.valueOf(mo9088a(gVar.f6867a)));
        }
        C2076e.m8187a(jSONObject, ".chartboost-internal-folder-size", Long.valueOf(mo9088a(this.f6864b.f6867a)));
        File file = mo9089a().f6867a;
        String[] list = file.list();
        if (list != null && list.length > 0) {
            for (String file2 : list) {
                File file3 = new File(file, file2);
                JSONObject jSONObject2 = new JSONObject();
                C2076e.m8187a(jSONObject2, file3.getName() + "-size", Long.valueOf(mo9088a(file3)));
                String[] list2 = file3.list();
                if (list2 != null) {
                    C2076e.m8187a(jSONObject2, "count", Integer.valueOf(list2.length));
                }
                C2076e.m8187a(jSONObject, file3.getName(), jSONObject2);
            }
        }
        return jSONObject;
    }

    /* renamed from: a */
    public long mo9088a(File file) {
        long j = 0;
        if (file != null) {
            try {
                if (file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles == null) {
                        return 0;
                    }
                    for (File a : listFiles) {
                        j += mo9088a(a);
                    }
                    return j;
                }
            } catch (Exception e) {
                C2098a.m8288a(C2078f.class, "getFolderSize", e);
                return 0;
            }
        }
        if (file != null) {
            return file.length();
        }
        return 0;
    }
}
