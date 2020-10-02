package com.google.firebase.remoteconfig.internal;

import android.content.Context;
import com.loopj.android.http.C4250c;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.firebase.remoteconfig.internal.n */
/* compiled from: com.google.firebase:firebase-config@@19.1.4 */
public class C3101n {

    /* renamed from: c */
    private static final Map<String, C3101n> f8642c = new HashMap();

    /* renamed from: a */
    private final Context f8643a;

    /* renamed from: b */
    private final String f8644b;

    private C3101n(Context context, String str) {
        this.f8643a = context;
        this.f8644b = str;
    }

    /* renamed from: a */
    public synchronized Void mo18336a(C3845f fVar) throws IOException {
        FileOutputStream openFileOutput = this.f8643a.openFileOutput(this.f8644b, 0);
        try {
            openFileOutput.write(fVar.toString().getBytes(C4250c.DEFAULT_CHARSET));
        } finally {
            openFileOutput.close();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo18337b() {
        return this.f8644b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002a, code lost:
        return r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0033 A[SYNTHETIC, Splitter:B:15:0x0033] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x003a A[Catch:{ FileNotFoundException | JSONException -> 0x0037, all -> 0x002d }] */
    @javax.annotation.Nullable
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.google.firebase.remoteconfig.internal.C3845f mo18338c() throws java.io.IOException {
        /*
            r6 = this;
            monitor-enter(r6)
            r0 = 0
            android.content.Context r1 = r6.f8643a     // Catch:{ FileNotFoundException | JSONException -> 0x0037, all -> 0x002d }
            java.lang.String r2 = r6.f8644b     // Catch:{ FileNotFoundException | JSONException -> 0x0037, all -> 0x002d }
            java.io.FileInputStream r1 = r1.openFileInput(r2)     // Catch:{ FileNotFoundException | JSONException -> 0x0037, all -> 0x002d }
            int r2 = r1.available()     // Catch:{ FileNotFoundException | JSONException -> 0x0038, all -> 0x002b }
            byte[] r3 = new byte[r2]     // Catch:{ FileNotFoundException | JSONException -> 0x0038, all -> 0x002b }
            r4 = 0
            r1.read(r3, r4, r2)     // Catch:{ FileNotFoundException | JSONException -> 0x0038, all -> 0x002b }
            java.lang.String r2 = new java.lang.String     // Catch:{ FileNotFoundException | JSONException -> 0x0038, all -> 0x002b }
            java.lang.String r4 = "UTF-8"
            r2.<init>(r3, r4)     // Catch:{ FileNotFoundException | JSONException -> 0x0038, all -> 0x002b }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ FileNotFoundException | JSONException -> 0x0038, all -> 0x002b }
            r3.<init>(r2)     // Catch:{ FileNotFoundException | JSONException -> 0x0038, all -> 0x002b }
            com.google.firebase.remoteconfig.internal.f r0 = com.google.firebase.remoteconfig.internal.C3845f.m13001a(r3)     // Catch:{ FileNotFoundException | JSONException -> 0x0038, all -> 0x002b }
            if (r1 == 0) goto L_0x0029
            r1.close()     // Catch:{ all -> 0x003e }
        L_0x0029:
            monitor-exit(r6)
            return r0
        L_0x002b:
            r0 = move-exception
            goto L_0x0031
        L_0x002d:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L_0x0031:
            if (r1 == 0) goto L_0x0036
            r1.close()     // Catch:{ all -> 0x003e }
        L_0x0036:
            throw r0     // Catch:{ all -> 0x003e }
        L_0x0037:
            r1 = r0
        L_0x0038:
            if (r1 == 0) goto L_0x0041
            r1.close()     // Catch:{ all -> 0x003e }
            goto L_0x0041
        L_0x003e:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        L_0x0041:
            monitor-exit(r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.internal.C3101n.mo18338c():com.google.firebase.remoteconfig.internal.f");
    }

    /* renamed from: a */
    public synchronized Void mo18335a() {
        this.f8643a.deleteFile(this.f8644b);
        return null;
    }

    /* renamed from: a */
    public static synchronized C3101n m10167a(Context context, String str) {
        C3101n nVar;
        synchronized (C3101n.class) {
            if (!f8642c.containsKey(str)) {
                f8642c.put(str, new C3101n(context, str));
            }
            nVar = f8642c.get(str);
        }
        return nVar;
    }
}
