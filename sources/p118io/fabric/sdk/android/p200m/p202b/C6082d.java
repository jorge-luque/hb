package p118io.fabric.sdk.android.p200m.p202b;

import android.content.Context;
import p118io.fabric.sdk.android.C6059c;

/* renamed from: io.fabric.sdk.android.m.b.d */
/* compiled from: AdvertisingInfoReflectionStrategy */
class C6082d implements C6087f {

    /* renamed from: a */
    private final Context f16012a;

    public C6082d(Context context) {
        this.f16012a = context.getApplicationContext();
    }

    /* renamed from: b */
    private String m19700b() {
        try {
            return (String) Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("getId", new Class[0]).invoke(m19701c(), new Object[0]);
        } catch (Exception unused) {
            C6059c.m19630f().mo34086a("Fabric", "Could not call getId on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            return null;
        }
    }

    /* renamed from: c */
    private Object m19701c() {
        try {
            return Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", new Class[]{Context.class}).invoke((Object) null, new Object[]{this.f16012a});
        } catch (Exception unused) {
            C6059c.m19630f().mo34086a("Fabric", "Could not call getAdvertisingIdInfo on com.google.android.gms.ads.identifier.AdvertisingIdClient");
            return null;
        }
    }

    /* renamed from: d */
    private boolean m19702d() {
        try {
            return ((Boolean) Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(m19701c(), new Object[0])).booleanValue();
        } catch (Exception unused) {
            C6059c.m19630f().mo34086a("Fabric", "Could not call isLimitAdTrackingEnabled on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo34157a(Context context) {
        try {
            if (((Integer) Class.forName("com.google.android.gms.common.GooglePlayServicesUtil").getMethod("isGooglePlayServicesAvailable", new Class[]{Context.class}).invoke((Object) null, new Object[]{context})).intValue() == 0) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a */
    public C6079b mo34156a() {
        if (mo34157a(this.f16012a)) {
            return new C6079b(m19700b(), m19702d());
        }
        return null;
    }
}
