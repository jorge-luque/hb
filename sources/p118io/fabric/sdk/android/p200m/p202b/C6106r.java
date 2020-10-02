package p118io.fabric.sdk.android.p200m.p202b;

import android.content.Context;
import android.text.TextUtils;
import p118io.fabric.sdk.android.C6059c;

/* renamed from: io.fabric.sdk.android.m.b.r */
/* compiled from: FirebaseInfo */
public class C6106r {
    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo34183a(Context context) {
        int a = C6090i.m19716a(context, "google_app_id", "string");
        if (a == 0) {
            return null;
        }
        C6059c.m19630f().mo34093d("Fabric", "Generating Crashlytics ApiKey from google_app_id in Strings");
        return mo34184a(context.getResources().getString(a));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo34185b(Context context) {
        if (!TextUtils.isEmpty(new C6088g().mo34166b(context))) {
            return true;
        }
        return !TextUtils.isEmpty(new C6088g().mo34167c(context));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo34186c(Context context) {
        int a = C6090i.m19716a(context, "google_app_id", "string");
        if (a == 0) {
            return false;
        }
        return !TextUtils.isEmpty(context.getResources().getString(a));
    }

    /* renamed from: d */
    public boolean mo34187d(Context context) {
        int a = C6090i.m19716a(context, "io.fabric.auto_initialize", "bool");
        if (a == 0) {
            return false;
        }
        boolean z = context.getResources().getBoolean(a);
        if (z) {
            C6059c.m19630f().mo34093d("Fabric", "Found Fabric auto-initialization flag for joint Firebase/Fabric customers");
        }
        return z;
    }

    /* renamed from: e */
    public boolean mo34188e(Context context) {
        if (C6090i.m19737a(context, "com.crashlytics.useFirebaseAppId", false)) {
            return true;
        }
        if (!mo34186c(context) || mo34185b(context)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo34184a(String str) {
        return C6090i.m19749d(str).substring(0, 40);
    }
}
