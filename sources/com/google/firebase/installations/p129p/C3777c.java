package com.google.firebase.installations.p129p;

import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.p129p.C3779d;
import com.loopj.android.http.C4250c;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.firebase.installations.p.c */
/* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
public class C3777c {

    /* renamed from: a */
    private final File f10461a;

    /* renamed from: b */
    private final FirebaseApp f10462b;

    /* renamed from: com.google.firebase.installations.p.c$a */
    /* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
    public enum C3778a {
        ATTEMPT_MIGRATION,
        NOT_GENERATED,
        UNREGISTERED,
        REGISTERED,
        REGISTER_ERROR;

        /* renamed from: a */
        public static C3778a[] m12741a() {
            return (C3778a[]) f10468f.clone();
        }
    }

    public C3777c(FirebaseApp firebaseApp) {
        File filesDir = firebaseApp.mo27170a().getFilesDir();
        this.f10461a = new File(filesDir, "PersistedInstallation." + firebaseApp.mo27174d() + ".json");
        this.f10462b = firebaseApp;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x002c */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.json.JSONObject m12738b() {
        /*
            r6 = this;
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 16384(0x4000, float:2.2959E-41)
            byte[] r2 = new byte[r1]
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ IOException | JSONException -> 0x002d }
            java.io.File r4 = r6.f10461a     // Catch:{ IOException | JSONException -> 0x002d }
            r3.<init>(r4)     // Catch:{ IOException | JSONException -> 0x002d }
        L_0x0010:
            r4 = 0
            int r5 = r3.read(r2, r4, r1)     // Catch:{ all -> 0x0028 }
            if (r5 >= 0) goto L_0x0024
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x0028 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0028 }
            r1.<init>(r0)     // Catch:{ all -> 0x0028 }
            r3.close()     // Catch:{ IOException | JSONException -> 0x002d }
            return r1
        L_0x0024:
            r0.write(r2, r4, r5)     // Catch:{ all -> 0x0028 }
            goto L_0x0010
        L_0x0028:
            r0 = move-exception
            r3.close()     // Catch:{ all -> 0x002c }
        L_0x002c:
            throw r0     // Catch:{ IOException | JSONException -> 0x002d }
        L_0x002d:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.p129p.C3777c.m12738b():org.json.JSONObject");
    }

    /* renamed from: a */
    public C3779d mo27434a() {
        JSONObject b = m12738b();
        String optString = b.optString("Fid", (String) null);
        int optInt = b.optInt("Status", C3778a.ATTEMPT_MIGRATION.ordinal());
        String optString2 = b.optString("AuthToken", (String) null);
        String optString3 = b.optString("RefreshToken", (String) null);
        long optLong = b.optLong("TokenCreationEpochInSecs", 0);
        long optLong2 = b.optLong("ExpiresInSecs", 0);
        String optString4 = b.optString("FisError", (String) null);
        C3779d.C3780a p = C3779d.m12742p();
        p.mo27429b(optString);
        p.mo27425a(C3778a.m12741a()[optInt]);
        p.mo27426a(optString2);
        p.mo27431d(optString3);
        p.mo27428b(optLong);
        p.mo27424a(optLong2);
        p.mo27430c(optString4);
        return p.mo27427a();
    }

    /* renamed from: a */
    public C3779d mo27435a(C3779d dVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Fid", dVar.mo27415c());
            jSONObject.put("Status", dVar.mo27419f().ordinal());
            jSONObject.put("AuthToken", dVar.mo27413a());
            jSONObject.put("RefreshToken", dVar.mo27417e());
            jSONObject.put("TokenCreationEpochInSecs", dVar.mo27420g());
            jSONObject.put("ExpiresInSecs", dVar.mo27414b());
            jSONObject.put("FisError", dVar.mo27416d());
            File createTempFile = File.createTempFile("PersistedInstallation", "tmp", this.f10462b.mo27170a().getFilesDir());
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            fileOutputStream.write(jSONObject.toString().getBytes(C4250c.DEFAULT_CHARSET));
            fileOutputStream.close();
            if (createTempFile.renameTo(this.f10461a)) {
                return dVar;
            }
            throw new IOException("unable to rename the tmpfile to PersistedInstallation");
        } catch (IOException | JSONException unused) {
        }
    }
}
