package p093e.p094a.p095a;

import android.content.Context;
import com.tapjoy.TapjoyConstants;
import java.io.IOException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import p093e.p094a.p095a.C3273b1;

/* renamed from: e.a.a.k */
/* compiled from: AdjustFactory */
public class C3309k {

    /* renamed from: a */
    private static C3366z f9243a = null;

    /* renamed from: b */
    private static C3267a0 f9244b = null;

    /* renamed from: c */
    private static C3362x f9245c = null;

    /* renamed from: d */
    private static C3360w f9246d = null;

    /* renamed from: e */
    private static C3364y f9247e = null;

    /* renamed from: f */
    private static HttpsURLConnection f9248f = null;

    /* renamed from: g */
    private static C3277c0 f9249g = null;

    /* renamed from: h */
    private static long f9250h = -1;

    /* renamed from: i */
    private static long f9251i = -1;

    /* renamed from: j */
    private static long f9252j = -1;

    /* renamed from: k */
    private static long f9253k = -1;

    /* renamed from: l */
    private static C3342s f9254l = null;

    /* renamed from: m */
    private static C3342s f9255m = null;

    /* renamed from: n */
    private static long f9256n = -1;

    /* renamed from: o */
    private static String f9257o = "https://app.adjust.com";

    /* renamed from: p */
    private static String f9258p = "https://gdpr.adjust.com";

    /* renamed from: q */
    private static C3273b1.C3275b f9259q = null;

    /* renamed from: r */
    private static boolean f9260r = true;

    /* renamed from: a */
    public static C3366z m10996a(C3360w wVar, Context context, boolean z) {
        C3366z zVar = f9243a;
        if (zVar == null) {
            return new C3332q0(wVar, context, z);
        }
        zVar.mo19077a(wVar, context, z);
        return f9243a;
    }

    /* renamed from: b */
    public static C3277c0 m11000b(C3360w wVar, boolean z) {
        C3277c0 c0Var = f9249g;
        if (c0Var == null) {
            return new C3349u0(wVar, z);
        }
        c0Var.mo18982a(wVar, z);
        return f9249g;
    }

    /* renamed from: c */
    public static String m11001c() {
        String str = f9258p;
        return str == null ? "https://gdpr.adjust.com" : str;
    }

    /* renamed from: d */
    public static C3364y m11002d() {
        if (f9247e == null) {
            f9247e = new C3302g0();
        }
        return f9247e;
    }

    /* renamed from: e */
    public static long m11003e() {
        long j = f9256n;
        return j == -1 ? TapjoyConstants.TIMER_INCREMENT : j;
    }

    /* renamed from: f */
    public static C3342s m11004f() {
        C3342s sVar = f9255m;
        return sVar == null ? C3342s.LONG_WAIT : sVar;
    }

    /* renamed from: g */
    public static C3342s m11005g() {
        C3342s sVar = f9254l;
        return sVar == null ? C3342s.SHORT_WAIT : sVar;
    }

    /* renamed from: h */
    public static long m11006h() {
        long j = f9252j;
        return j == -1 ? TapjoyConstants.SESSION_ID_INACTIVITY_TIME : j;
    }

    /* renamed from: i */
    public static long m11007i() {
        long j = f9253k;
        if (j == -1) {
            return 1000;
        }
        return j;
    }

    /* renamed from: j */
    public static long m11008j() {
        long j = f9250h;
        if (j == -1) {
            return 60000;
        }
        return j;
    }

    /* renamed from: k */
    public static long m11009k() {
        long j = f9251i;
        if (j == -1) {
            return 60000;
        }
        return j;
    }

    /* renamed from: l */
    public static boolean m11010l() {
        return f9260r;
    }

    /* renamed from: a */
    public static C3267a0 m10993a(C3360w wVar, C3366z zVar) {
        C3267a0 a0Var = f9244b;
        if (a0Var == null) {
            return new C3343s0(wVar, zVar);
        }
        a0Var.mo18950a(wVar, zVar);
        return f9244b;
    }

    /* renamed from: b */
    public static C3273b1.C3275b m10999b() {
        C3273b1.C3275b bVar = f9259q;
        return bVar == null ? new C3273b1.C3274a() : bVar;
    }

    /* renamed from: a */
    public static C3360w m10994a(C3301g gVar) {
        C3360w wVar = f9246d;
        if (wVar == null) {
            return C3236a.m10724b(gVar);
        }
        wVar.mo18882a(gVar);
        return f9246d;
    }

    /* renamed from: a */
    public static C3362x m10995a(C3360w wVar, boolean z) {
        C3362x xVar = f9245c;
        if (xVar == null) {
            return new C3325q(wVar, z);
        }
        xVar.mo19062a(wVar, z);
        return f9245c;
    }

    /* renamed from: a */
    public static HttpsURLConnection m10998a(URL url) throws IOException {
        HttpsURLConnection httpsURLConnection = f9248f;
        return httpsURLConnection == null ? (HttpsURLConnection) url.openConnection() : httpsURLConnection;
    }

    /* renamed from: a */
    public static String m10997a() {
        String str = f9257o;
        return str == null ? "https://app.adjust.com" : str;
    }
}
