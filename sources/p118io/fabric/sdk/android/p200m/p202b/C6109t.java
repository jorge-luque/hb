package p118io.fabric.sdk.android.p200m.p202b;

import android.content.Context;
import p118io.fabric.sdk.android.C6059c;
import p118io.fabric.sdk.android.p200m.p201a.C6075b;
import p118io.fabric.sdk.android.p200m.p201a.C6077d;

/* renamed from: io.fabric.sdk.android.m.b.t */
/* compiled from: InstallerPackageNameProvider */
public class C6109t {

    /* renamed from: a */
    private final C6077d<String> f16077a = new C6110a(this);

    /* renamed from: b */
    private final C6075b<String> f16078b = new C6075b<>();

    /* renamed from: io.fabric.sdk.android.m.b.t$a */
    /* compiled from: InstallerPackageNameProvider */
    class C6110a implements C6077d<String> {
        C6110a(C6109t tVar) {
        }

        public String load(Context context) throws Exception {
            String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
            return installerPackageName == null ? "" : installerPackageName;
        }
    }

    /* renamed from: a */
    public String mo34201a(Context context) {
        try {
            String a = this.f16078b.mo34145a(context, this.f16077a);
            if ("".equals(a)) {
                return null;
            }
            return a;
        } catch (Exception e) {
            C6059c.m19630f().mo34090b("Fabric", "Failed to determine installer package name", e);
            return null;
        }
    }
}
