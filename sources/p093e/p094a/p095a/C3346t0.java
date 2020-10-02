package p093e.p094a.p095a;

import org.json.JSONObject;

/* renamed from: e.a.a.t0 */
/* compiled from: ResponseData */
public class C3346t0 {

    /* renamed from: a */
    public boolean f9391a;

    /* renamed from: b */
    public boolean f9392b;

    /* renamed from: c */
    public String f9393c;

    /* renamed from: d */
    public String f9394d;

    /* renamed from: e */
    public String f9395e;

    /* renamed from: f */
    public JSONObject f9396f;

    /* renamed from: g */
    public C3367z0 f9397g;

    /* renamed from: h */
    public C3299f f9398h;

    /* renamed from: e.a.a.t0$a */
    /* compiled from: ResponseData */
    static /* synthetic */ class C3347a {

        /* renamed from: a */
        static final /* synthetic */ int[] f9399a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                e.a.a.b[] r0 = p093e.p094a.p095a.C3270b.m10869a()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f9399a = r0
                e.a.a.b r1 = p093e.p094a.p095a.C3270b.SESSION     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f9399a     // Catch:{ NoSuchFieldError -> 0x001d }
                e.a.a.b r1 = p093e.p094a.p095a.C3270b.CLICK     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f9399a     // Catch:{ NoSuchFieldError -> 0x0028 }
                e.a.a.b r1 = p093e.p094a.p095a.C3270b.ATTRIBUTION     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f9399a     // Catch:{ NoSuchFieldError -> 0x0033 }
                e.a.a.b r1 = p093e.p094a.p095a.C3270b.EVENT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p093e.p094a.p095a.C3346t0.C3347a.<clinit>():void");
        }
    }

    protected C3346t0() {
    }

    /* renamed from: a */
    public static C3346t0 m11150a(C3276c cVar) {
        C3346t0 t0Var;
        int i = C3347a.f9399a[cVar.mo18954a().ordinal()];
        if (i == 1) {
            t0Var = new C3363x0(cVar);
        } else if (i == 2) {
            return new C3359v0();
        } else {
            if (i == 3) {
                return new C3340r();
            }
            if (i != 4) {
                return new C3346t0();
            }
            t0Var = new C3348u(cVar);
        }
        return t0Var;
    }

    public String toString() {
        return C3268a1.m10834a("message:%s timestamp:%s json:%s", this.f9394d, this.f9395e, this.f9396f);
    }
}
