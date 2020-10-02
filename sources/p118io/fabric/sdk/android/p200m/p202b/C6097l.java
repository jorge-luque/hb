package p118io.fabric.sdk.android.p200m.p202b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: io.fabric.sdk.android.m.b.l */
/* compiled from: DataCollectionArbiter */
public class C6097l {

    /* renamed from: f */
    private static C6097l f16034f;

    /* renamed from: g */
    private static Object f16035g = new Object();

    /* renamed from: a */
    private final SharedPreferences f16036a;

    /* renamed from: b */
    private volatile boolean f16037b;

    /* renamed from: c */
    private volatile boolean f16038c;

    /* renamed from: d */
    private final C6104p f16039d;

    /* renamed from: e */
    private boolean f16040e = false;

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002f, code lost:
        r1 = r1.getApplicationInfo(r7.getPackageName(), com.ogury.p159cm.OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0066  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private C6097l(android.content.Context r7) {
        /*
            r6 = this;
            r6.<init>()
            r0 = 0
            r6.f16040e = r0
            if (r7 == 0) goto L_0x006a
            java.lang.String r1 = "com.google.firebase.crashlytics.prefs"
            android.content.SharedPreferences r1 = r7.getSharedPreferences(r1, r0)
            r6.f16036a = r1
            io.fabric.sdk.android.m.b.p r1 = p118io.fabric.sdk.android.p200m.p202b.C6105q.m19778a(r7)
            r6.f16039d = r1
            android.content.SharedPreferences r1 = r6.f16036a
            java.lang.String r2 = "firebase_crashlytics_collection_enabled"
            boolean r1 = r1.contains(r2)
            r3 = 1
            if (r1 == 0) goto L_0x0029
            android.content.SharedPreferences r1 = r6.f16036a
            boolean r1 = r1.getBoolean(r2, r3)
        L_0x0027:
            r2 = 1
            goto L_0x005c
        L_0x0029:
            android.content.pm.PackageManager r1 = r7.getPackageManager()     // Catch:{ NameNotFoundException -> 0x004e }
            if (r1 == 0) goto L_0x005a
            java.lang.String r4 = r7.getPackageName()     // Catch:{ NameNotFoundException -> 0x004e }
            r5 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r1 = r1.getApplicationInfo(r4, r5)     // Catch:{ NameNotFoundException -> 0x004e }
            if (r1 == 0) goto L_0x005a
            android.os.Bundle r4 = r1.metaData     // Catch:{ NameNotFoundException -> 0x004e }
            if (r4 == 0) goto L_0x005a
            android.os.Bundle r4 = r1.metaData     // Catch:{ NameNotFoundException -> 0x004e }
            boolean r4 = r4.containsKey(r2)     // Catch:{ NameNotFoundException -> 0x004e }
            if (r4 == 0) goto L_0x005a
            android.os.Bundle r1 = r1.metaData     // Catch:{ NameNotFoundException -> 0x004e }
            boolean r1 = r1.getBoolean(r2)     // Catch:{ NameNotFoundException -> 0x004e }
            goto L_0x0027
        L_0x004e:
            r1 = move-exception
            io.fabric.sdk.android.k r2 = p118io.fabric.sdk.android.C6059c.m19630f()
            java.lang.String r4 = "Fabric"
            java.lang.String r5 = "Unable to get PackageManager. Falling through"
            r2.mo34092c(r4, r5, r1)
        L_0x005a:
            r1 = 1
            r2 = 0
        L_0x005c:
            r6.f16038c = r1
            r6.f16037b = r2
            java.lang.String r7 = p118io.fabric.sdk.android.p200m.p202b.C6090i.m19760o(r7)
            if (r7 == 0) goto L_0x0067
            r0 = 1
        L_0x0067:
            r6.f16040e = r0
            return
        L_0x006a:
            java.lang.RuntimeException r7 = new java.lang.RuntimeException
            java.lang.String r0 = "null context"
            r7.<init>(r0)
            goto L_0x0073
        L_0x0072:
            throw r7
        L_0x0073:
            goto L_0x0072
        */
        throw new UnsupportedOperationException("Method not decompiled: p118io.fabric.sdk.android.p200m.p202b.C6097l.<init>(android.content.Context):void");
    }

    /* renamed from: a */
    public static C6097l m19766a(Context context) {
        C6097l lVar;
        synchronized (f16035g) {
            if (f16034f == null) {
                f16034f = new C6097l(context);
            }
            lVar = f16034f;
        }
        return lVar;
    }

    /* renamed from: b */
    public boolean mo34178b() {
        return this.f16038c;
    }

    /* renamed from: a */
    public boolean mo34177a() {
        if (this.f16040e && this.f16037b) {
            return this.f16038c;
        }
        C6104p pVar = this.f16039d;
        if (pVar != null) {
            return pVar.mo34182a();
        }
        return true;
    }

    @SuppressLint({"CommitPrefEdits", "ApplySharedPref"})
    /* renamed from: a */
    public void mo34176a(boolean z) {
        this.f16038c = z;
        this.f16037b = true;
        this.f16036a.edit().putBoolean("firebase_crashlytics_collection_enabled", z).commit();
    }
}
