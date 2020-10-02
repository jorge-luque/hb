package p118io.fabric.sdk.android.p200m.p202b;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.ogury.p159cm.OguryChoiceManager;
import p118io.fabric.sdk.android.C6059c;
import p118io.fabric.sdk.android.C6072k;

/* renamed from: io.fabric.sdk.android.m.b.g */
/* compiled from: ApiKey */
public class C6088g {
    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo34164a() {
        return "Fabric could not be initialized, API key missing from AndroidManifest.xml. Add the following tag to your Application element \n\t<meta-data android:name=\"io.fabric.ApiKey\" android:value=\"YOUR_API_KEY\"/>";
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo34165a(Context context) {
        return new C6106r().mo34183a(context);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo34166b(Context context) {
        String str = null;
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE).metaData;
            if (bundle == null) {
                return null;
            }
            String string = bundle.getString("io.fabric.ApiKey");
            try {
                if ("@string/twitter_consumer_secret".equals(string)) {
                    C6059c.m19630f().mo34093d("Fabric", "Ignoring bad default value for Fabric ApiKey set by FirebaseUI-Auth");
                } else {
                    str = string;
                }
                if (str != null) {
                    return str;
                }
                C6059c.m19630f().mo34093d("Fabric", "Falling back to Crashlytics key lookup from Manifest");
                return bundle.getString("com.crashlytics.ApiKey");
            } catch (Exception e) {
                e = e;
                str = string;
                C6072k f = C6059c.m19630f();
                f.mo34093d("Fabric", "Caught non-fatal exception while retrieving apiKey: " + e);
                return str;
            }
        } catch (Exception e2) {
            e = e2;
            C6072k f2 = C6059c.m19630f();
            f2.mo34093d("Fabric", "Caught non-fatal exception while retrieving apiKey: " + e);
            return str;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public String mo34167c(Context context) {
        int a = C6090i.m19716a(context, "io.fabric.ApiKey", "string");
        if (a == 0) {
            C6059c.m19630f().mo34093d("Fabric", "Falling back to Crashlytics key lookup from Strings");
            a = C6090i.m19716a(context, "com.crashlytics.ApiKey", "string");
        }
        if (a != 0) {
            return context.getResources().getString(a);
        }
        return null;
    }

    /* renamed from: d */
    public String mo34168d(Context context) {
        String b = mo34166b(context);
        if (TextUtils.isEmpty(b)) {
            b = mo34167c(context);
        }
        if (TextUtils.isEmpty(b)) {
            b = mo34165a(context);
        }
        if (TextUtils.isEmpty(b)) {
            mo34169e(context);
        }
        return b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo34169e(Context context) {
        if (C6059c.m19632h() || C6090i.m19755j(context)) {
            throw new IllegalArgumentException(mo34164a());
        }
        C6059c.m19630f().mo34089b("Fabric", mo34164a());
    }
}
