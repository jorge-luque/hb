package p093e.p094a.p095a;

import android.content.Context;
import java.util.List;

/* renamed from: e.a.a.g */
/* compiled from: AdjustConfig */
public class C3301g {

    /* renamed from: A */
    String f9191A;

    /* renamed from: a */
    String f9192a;

    /* renamed from: b */
    String f9193b;

    /* renamed from: c */
    Context f9194c;

    /* renamed from: d */
    String f9195d;

    /* renamed from: e */
    String f9196e;

    /* renamed from: f */
    String f9197f;

    /* renamed from: g */
    String f9198g;

    /* renamed from: h */
    boolean f9199h;

    /* renamed from: i */
    String f9200i;

    /* renamed from: j */
    C3306i0 f9201j;

    /* renamed from: k */
    Boolean f9202k;

    /* renamed from: l */
    Class f9203l;

    /* renamed from: m */
    C3315l0 f9204m;

    /* renamed from: n */
    C3310k0 f9205n;

    /* renamed from: o */
    C3319n0 f9206o;

    /* renamed from: p */
    C3317m0 f9207p;

    /* renamed from: q */
    C3308j0 f9208q;

    /* renamed from: r */
    boolean f9209r;

    /* renamed from: s */
    Double f9210s;

    /* renamed from: t */
    List<C3272b0> f9211t;

    /* renamed from: u */
    C3364y f9212u;

    /* renamed from: v */
    String f9213v;

    /* renamed from: w */
    String f9214w;

    /* renamed from: x */
    Boolean f9215x;

    /* renamed from: y */
    boolean f9216y;

    /* renamed from: z */
    String f9217z;

    public C3301g(Context context, String str, String str2) {
        m10965a(context, str, str2, false);
    }

    /* renamed from: a */
    private void m10965a(Context context, String str, String str2, boolean z) {
        this.f9212u = C3309k.m11002d();
        if (!z || !"production".equals(str2)) {
            m10966a(C3300f0.INFO, str2);
        } else {
            m10966a(C3300f0.SUPRESS, str2);
        }
        if (context != null) {
            context = context.getApplicationContext();
        }
        this.f9194c = context;
        this.f9195d = str;
        this.f9196e = str2;
        this.f9199h = false;
        this.f9209r = false;
    }

    /* renamed from: b */
    private boolean m10969b(String str) {
        if (str == null) {
            this.f9212u.mo19022c("Missing environment", new Object[0]);
            return false;
        } else if (str.equals("sandbox")) {
            this.f9212u.mo19020a("SANDBOX: Adjust is running in Sandbox mode. Use this setting for testing. Don't forget to set the environment to `production` before publishing!", new Object[0]);
            return true;
        } else if (str.equals("production")) {
            this.f9212u.mo19020a("PRODUCTION: Adjust is running in Production mode. Use this setting only for the build that you want to publish. Set the environment to `sandbox` if you want to test your app!", new Object[0]);
            return true;
        } else {
            this.f9212u.mo19022c("Unknown environment '%s'", str);
            return false;
        }
    }

    /* renamed from: a */
    public void mo19016a(C3306i0 i0Var) {
        this.f9201j = i0Var;
    }

    /* renamed from: a */
    public void mo19015a(long j, long j2, long j3, long j4, long j5) {
        this.f9217z = C3268a1.m10834a("%d", Long.valueOf(j));
        this.f9191A = C3268a1.m10834a("%d%d%d%d", Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5));
    }

    /* renamed from: a */
    public boolean mo19017a() {
        if (m10968a(this.f9195d) && m10969b(this.f9196e) && m10967a(this.f9194c)) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private void m10966a(C3300f0 f0Var, String str) {
        this.f9212u.mo19019a(f0Var, "production".equals(str));
    }

    /* renamed from: a */
    private boolean m10967a(Context context) {
        if (context == null) {
            this.f9212u.mo19022c("Missing context", new Object[0]);
            return false;
        } else if (C3268a1.m10840a(context, "android.permission.INTERNET")) {
            return true;
        } else {
            this.f9212u.mo19022c("Missing permission: INTERNET", new Object[0]);
            return false;
        }
    }

    /* renamed from: a */
    private boolean m10968a(String str) {
        if (str == null) {
            this.f9212u.mo19022c("Missing App Token", new Object[0]);
            return false;
        } else if (str.length() == 12) {
            return true;
        } else {
            this.f9212u.mo19022c("Malformed App Token '%s'", str);
            return false;
        }
    }
}
