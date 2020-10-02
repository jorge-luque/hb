package p118io.presage;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import java.io.IOException;

/* renamed from: io.presage.a */
public final class C6209a {

    /* renamed from: a */
    public static final C6209a f16744a = new C6209a();

    private C6209a() {
    }

    /* renamed from: a */
    public static TrouduCru m20761a(Context context) throws Exception {
        m20762a();
        m20763b(context);
        VieuxLille vieuxLille = new VieuxLille();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (context.bindService(intent, vieuxLille, 1)) {
            try {
                C6236b bVar = new C6236b(vieuxLille.mo34727a());
                return new TrouduCru(bVar.mo34771a(), bVar.mo34773b());
            } finally {
                context.unbindService(vieuxLille);
            }
        } else {
            throw new IOException("Google Play connection failed");
        }
    }

    /* renamed from: b */
    private static void m20763b(Context context) {
        if (!(!m20764c(context))) {
            throw new IllegalStateException("Google play is not installed".toString());
        }
    }

    /* renamed from: c */
    private static boolean m20764c(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    /* renamed from: a */
    private static void m20762a() {
        if (!(!C6514hl.m21416a((Object) Looper.myLooper(), (Object) Looper.getMainLooper()))) {
            throw new IllegalStateException("Cannot be called from the main thread".toString());
        }
    }
}
