package com.google.firebase.iid;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.LibraryVersion;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.C3764h;
import com.google.firebase.installations.C3768l;
import com.google.firebase.p073h.C3687h;
import com.google.firebase.p124e.C3666c;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* renamed from: com.google.firebase.iid.d1 */
/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
public final class C3700d1 {

    /* renamed from: a */
    private final FirebaseApp f10304a;

    /* renamed from: b */
    private final C3731q f10305b;

    /* renamed from: c */
    private final C3743w f10306c;

    /* renamed from: d */
    private final Executor f10307d;

    /* renamed from: e */
    private final C3687h f10308e;

    /* renamed from: f */
    private final C3666c f10309f;

    /* renamed from: g */
    private final C3764h f10310g;

    public C3700d1(FirebaseApp firebaseApp, C3731q qVar, Executor executor, C3687h hVar, C3666c cVar, C3764h hVar2) {
        this(firebaseApp, qVar, executor, new C3743w(firebaseApp.mo27170a(), qVar), hVar, cVar, hVar2);
    }

    /* renamed from: a */
    public final Task<String> mo27318a(String str, String str2, String str3) {
        return m12582b(m12579a(str, str2, str3, new Bundle()));
    }

    /* renamed from: b */
    public final Task<Void> mo27320b(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf(str3);
        bundle.putString("gcm.topic", valueOf.length() != 0 ? "/topics/".concat(valueOf) : new String("/topics/"));
        String valueOf2 = String.valueOf(str3);
        return m12578a(m12582b(m12579a(str, str2, valueOf2.length() != 0 ? "/topics/".concat(valueOf2) : new String("/topics/"), bundle)));
    }

    /* renamed from: c */
    public final Task<Void> mo27321c(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf(str3);
        bundle.putString("gcm.topic", valueOf.length() != 0 ? "/topics/".concat(valueOf) : new String("/topics/"));
        bundle.putString("delete", "1");
        String valueOf2 = String.valueOf(str3);
        return m12578a(m12582b(m12579a(str, str2, valueOf2.length() != 0 ? "/topics/".concat(valueOf2) : new String("/topics/"), bundle)));
    }

    private C3700d1(FirebaseApp firebaseApp, C3731q qVar, Executor executor, C3743w wVar, C3687h hVar, C3666c cVar, C3764h hVar2) {
        this.f10304a = firebaseApp;
        this.f10305b = qVar;
        this.f10306c = wVar;
        this.f10307d = executor;
        this.f10308e = hVar;
        this.f10309f = cVar;
        this.f10310g = hVar2;
    }

    /* renamed from: a */
    private final Task<Bundle> m12579a(String str, String str2, String str3, Bundle bundle) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f10307d.execute(new C3698c1(this, str, str2, str3, bundle, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    /* renamed from: b */
    private final Bundle m12581b(String str, String str2, String str3, Bundle bundle) {
        bundle.putString("scope", str3);
        bundle.putString("sender", str2);
        bundle.putString("subtype", str2);
        bundle.putString("appid", str);
        bundle.putString("gmp_app_id", this.f10304a.mo27173c().mo27208b());
        bundle.putString("gmsv", Integer.toString(this.f10305b.mo27365e()));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", this.f10305b.mo27363c());
        bundle.putString("app_ver_name", this.f10305b.mo27364d());
        bundle.putString("firebase-app-name-hash", m12580a());
        try {
            String a = ((C3768l) Tasks.await(this.f10310g.mo27402a(false))).mo27387a();
            if (!TextUtils.isEmpty(a)) {
                bundle.putString("Goog-Firebase-Installations-Auth", a);
            } else {
                Log.w("FirebaseInstanceId", "FIS auth token is empty");
            }
        } catch (InterruptedException | ExecutionException e) {
            Log.e("FirebaseInstanceId", "Failed to get FIS auth token", e);
        }
        String version = LibraryVersion.getInstance().getVersion("firebase-iid");
        if ("UNKNOWN".equals(version)) {
            int i = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
            StringBuilder sb = new StringBuilder(19);
            sb.append("unknown_");
            sb.append(i);
            version = sb.toString();
        }
        String valueOf = String.valueOf(version);
        bundle.putString("cliv", valueOf.length() != 0 ? "fiid-".concat(valueOf) : new String("fiid-"));
        C3666c.C3667a a2 = this.f10309f.mo27265a("fire-iid");
        if (a2 != C3666c.C3667a.NONE) {
            bundle.putString("Firebase-Client-Log-Type", Integer.toString(a2.mo27266a()));
            bundle.putString("Firebase-Client", this.f10308e.mo27287a());
        }
        return bundle;
    }

    /* renamed from: a */
    private final String m12580a() {
        try {
            return Base64.encodeToString(MessageDigest.getInstance("SHA-1").digest(this.f10304a.mo27172b().getBytes()), 11);
        } catch (NoSuchAlgorithmException unused) {
            return "[HASH-ERROR]";
        }
    }

    /* renamed from: a */
    private static <T> Task<Void> m12578a(Task<T> task) {
        return task.continueWith(C3736s0.m12634a(), C3706f1.f10326a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo27319a(String str, String str2, String str3, Bundle bundle, TaskCompletionSource taskCompletionSource) {
        try {
            m12581b(str, str2, str3, bundle);
            taskCompletionSource.setResult(this.f10306c.mo27372a(bundle));
        } catch (IOException e) {
            taskCompletionSource.setException(e);
        }
    }

    /* renamed from: b */
    private final Task<String> m12582b(Task<Bundle> task) {
        return task.continueWith(this.f10307d, new C3703e1(this));
    }
}
