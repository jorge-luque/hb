package p118io.presage;

import com.ogury.crashreport.CrashReport;

/* renamed from: io.presage.Laguiole */
public final class Laguiole {

    /* renamed from: a */
    public static final Laguiole f16541a = new Laguiole();

    private Laguiole() {
    }

    /* renamed from: a */
    public static void m20426a(Throwable th) {
        try {
            CrashReport.logException(th);
        } catch (Throwable unused) {
        }
    }
}
