package p093e.p094a.p095a;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Process;
import com.google.android.gms.drive.DriveFile;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import p093e.p094a.p095a.p096c1.C3280c;
import p093e.p094a.p095a.p096c1.C3286e;
import p093e.p094a.p095a.p096c1.C3290h;
import p093e.p094a.p095a.p096c1.C3292i;

/* renamed from: e.a.a.a */
/* compiled from: ActivityHandler */
public class C3236a implements C3360w {

    /* renamed from: r */
    private static long f9013r;

    /* renamed from: s */
    private static long f9014s;

    /* renamed from: t */
    private static long f9015t;

    /* renamed from: u */
    private static long f9016u;

    /* renamed from: v */
    private static long f9017v;

    /* renamed from: a */
    private C3286e f9018a = new C3280c("ActivityHandler");

    /* renamed from: b */
    private C3366z f9019b;

    /* renamed from: c */
    private C3294d f9020c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C3364y f9021d;

    /* renamed from: e */
    private C3290h f9022e;

    /* renamed from: f */
    private C3292i f9023f;

    /* renamed from: g */
    private C3292i f9024g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C3244d0 f9025h;

    /* renamed from: i */
    private String f9026i;

    /* renamed from: j */
    private String f9027j;

    /* renamed from: k */
    private C3345t f9028k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public C3301g f9029l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public C3299f f9030m;

    /* renamed from: n */
    private C3362x f9031n;

    /* renamed from: o */
    private C3277c0 f9032o;

    /* renamed from: p */
    private C3361w0 f9033p;

    /* renamed from: q */
    private C3295d0 f9034q;

    /* renamed from: e.a.a.a$a */
    /* compiled from: ActivityHandler */
    class C3237a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f9035a;

        /* renamed from: b */
        final /* synthetic */ long f9036b;

        /* renamed from: c */
        final /* synthetic */ long f9037c;

        C3237a(String str, long j, long j2) {
            this.f9035a = str;
            this.f9036b = j;
            this.f9037c = j2;
        }

        public void run() {
            C3236a.this.m10735b(this.f9035a, this.f9036b, this.f9037c);
        }
    }

    /* renamed from: e.a.a.a$a0 */
    /* compiled from: ActivityHandler */
    class C3238a0 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Uri f9039a;

        /* renamed from: b */
        final /* synthetic */ long f9040b;

        C3238a0(Uri uri, long j) {
            this.f9039a = uri;
            this.f9040b = j;
        }

        public void run() {
            C3236a.this.m10727b(this.f9039a, this.f9040b);
        }
    }

    /* renamed from: e.a.a.a$b */
    /* compiled from: ActivityHandler */
    class C3239b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C3348u f9042a;

        C3239b(C3348u uVar) {
            this.f9042a = uVar;
        }

        public void run() {
            C3236a.this.m10731b(this.f9042a);
        }
    }

    /* renamed from: e.a.a.a$b0 */
    /* compiled from: ActivityHandler */
    class C3240b0 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ boolean f9044a;

        C3240b0(boolean z) {
            this.f9044a = z;
        }

        public void run() {
            C3236a.this.m10743c(this.f9044a);
        }
    }

    /* renamed from: e.a.a.a$c */
    /* compiled from: ActivityHandler */
    class C3241c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C3359v0 f9046a;

        C3241c(C3359v0 v0Var) {
            this.f9046a = v0Var;
        }

        public void run() {
            C3236a.this.m10741c(this.f9046a);
        }
    }

    /* renamed from: e.a.a.a$c0 */
    /* compiled from: ActivityHandler */
    class C3242c0 implements Runnable {
        C3242c0() {
        }

        public void run() {
            C3236a.this.m10688D();
        }
    }

    /* renamed from: e.a.a.a$d */
    /* compiled from: ActivityHandler */
    class C3243d implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C3363x0 f9049a;

        C3243d(C3363x0 x0Var) {
            this.f9049a = x0Var;
        }

        public void run() {
            C3236a.this.m10733b(this.f9049a);
        }
    }

    /* renamed from: e.a.a.a$d0 */
    /* compiled from: ActivityHandler */
    public class C3244d0 {

        /* renamed from: a */
        boolean f9051a;

        /* renamed from: b */
        boolean f9052b;

        /* renamed from: c */
        boolean f9053c;

        /* renamed from: d */
        boolean f9054d;

        /* renamed from: e */
        boolean f9055e;

        /* renamed from: f */
        boolean f9056f;

        /* renamed from: g */
        boolean f9057g;

        /* renamed from: h */
        boolean f9058h;

        public C3244d0(C3236a aVar) {
        }

        /* renamed from: a */
        public boolean mo18916a() {
            return !this.f9058h;
        }

        /* renamed from: b */
        public boolean mo18917b() {
            return this.f9058h;
        }

        /* renamed from: c */
        public boolean mo18918c() {
            return !this.f9057g;
        }

        /* renamed from: d */
        public boolean mo18919d() {
            return this.f9051a;
        }

        /* renamed from: e */
        public boolean mo18920e() {
            return this.f9056f;
        }

        /* renamed from: f */
        public boolean mo18921f() {
            return this.f9053c;
        }

        /* renamed from: g */
        public boolean mo18922g() {
            return this.f9054d;
        }

        /* renamed from: h */
        public boolean mo18923h() {
            return !this.f9053c;
        }

        /* renamed from: i */
        public boolean mo18924i() {
            return !this.f9054d;
        }

        /* renamed from: j */
        public boolean mo18925j() {
            return this.f9052b;
        }

        /* renamed from: k */
        public boolean mo18926k() {
            return this.f9055e;
        }
    }

    /* renamed from: e.a.a.a$e */
    /* compiled from: ActivityHandler */
    class C3245e implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C3340r f9059a;

        C3245e(C3340r rVar) {
            this.f9059a = rVar;
        }

        public void run() {
            C3236a.this.m10730b(this.f9059a);
        }
    }

    /* renamed from: e.a.a.a$f */
    /* compiled from: ActivityHandler */
    class C3246f implements Runnable {
        C3246f() {
        }

        public void run() {
            C3236a.this.m10687C();
        }
    }

    /* renamed from: e.a.a.a$g */
    /* compiled from: ActivityHandler */
    class C3247g implements Runnable {
        C3247g() {
        }

        public void run() {
            C3236a.this.m10772v();
        }
    }

    /* renamed from: e.a.a.a$h */
    /* compiled from: ActivityHandler */
    class C3248h implements Runnable {

        /* renamed from: a */
        final /* synthetic */ boolean f9063a;

        /* renamed from: b */
        final /* synthetic */ String f9064b;

        C3248h(boolean z, String str) {
            this.f9063a = z;
            this.f9064b = str;
        }

        public void run() {
            if (!this.f9063a) {
                new C3365y0(C3236a.this.getContext()).mo19116a(this.f9064b);
            }
            if (!C3236a.this.f9025h.mo18916a()) {
                C3236a.this.m10734b(this.f9064b);
            }
        }
    }

    /* renamed from: e.a.a.a$i */
    /* compiled from: ActivityHandler */
    class C3249i implements Runnable {
        C3249i() {
        }

        public void run() {
            C3236a.this.m10770t();
        }
    }

    /* renamed from: e.a.a.a$j */
    /* compiled from: ActivityHandler */
    class C3250j implements Runnable {
        C3250j() {
        }

        public void run() {
            C3236a.this.m10771u();
        }
    }

    /* renamed from: e.a.a.a$k */
    /* compiled from: ActivityHandler */
    class C3251k implements Runnable {
        C3251k() {
        }

        public void run() {
            C3236a.this.m10769s();
        }
    }

    /* renamed from: e.a.a.a$l */
    /* compiled from: ActivityHandler */
    class C3252l implements Runnable {
        C3252l() {
        }

        public void run() {
            C3236a.this.m10759n();
        }
    }

    /* renamed from: e.a.a.a$m */
    /* compiled from: ActivityHandler */
    class C3253m implements C3272b0 {
        C3253m() {
        }

        /* renamed from: a */
        public void mo18935a(C3236a aVar) {
            aVar.m10747d(C3236a.this.f9029l.f9215x.booleanValue());
        }
    }

    /* renamed from: e.a.a.a$n */
    /* compiled from: ActivityHandler */
    class C3254n implements Runnable {
        C3254n() {
        }

        public void run() {
            C3236a.this.mo18893b();
        }
    }

    /* renamed from: e.a.a.a$o */
    /* compiled from: ActivityHandler */
    class C3255o implements Runnable {
        C3255o() {
        }

        public void run() {
            C3236a.this.mo18880a();
        }
    }

    /* renamed from: e.a.a.a$p */
    /* compiled from: ActivityHandler */
    class C3256p implements Runnable {
        C3256p() {
        }

        public void run() {
            C3236a.this.m10765q();
            C3236a.this.m10693I();
            C3236a.this.m10691G();
            C3236a.this.f9021d.mo19024e("Subsession start", new Object[0]);
            C3236a.this.m10692H();
        }
    }

    /* renamed from: e.a.a.a$q */
    /* compiled from: ActivityHandler */
    class C3257q implements Runnable {
        C3257q() {
        }

        public void run() {
            C3236a.this.mo18906m();
        }
    }

    /* renamed from: e.a.a.a$r */
    /* compiled from: ActivityHandler */
    class C3258r implements C3298e0 {
        C3258r() {
        }

        /* renamed from: a */
        public void mo18940a(String str, long j, long j2) {
            C3236a.this.mo18889a(str, j, j2);
        }
    }

    /* renamed from: e.a.a.a$s */
    /* compiled from: ActivityHandler */
    class C3259s implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C3348u f9076a;

        C3259s(C3348u uVar) {
            this.f9076a = uVar;
        }

        public void run() {
            if (C3236a.this.f9029l != null && C3236a.this.f9029l.f9204m != null) {
                C3236a.this.f9029l.f9204m.mo19046a(this.f9076a.mo19096b());
            }
        }
    }

    /* renamed from: e.a.a.a$t */
    /* compiled from: ActivityHandler */
    class C3260t implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C3348u f9078a;

        C3260t(C3348u uVar) {
            this.f9078a = uVar;
        }

        public void run() {
            if (C3236a.this.f9029l != null && C3236a.this.f9029l.f9205n != null) {
                C3236a.this.f9029l.f9205n.mo19034a(this.f9078a.mo19095a());
            }
        }
    }

    /* renamed from: e.a.a.a$u */
    /* compiled from: ActivityHandler */
    class C3261u implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C3363x0 f9080a;

        C3261u(C3363x0 x0Var) {
            this.f9080a = x0Var;
        }

        public void run() {
            if (C3236a.this.f9029l != null && C3236a.this.f9029l.f9206o != null) {
                C3236a.this.f9029l.f9206o.mo19050a(this.f9080a.mo19113b());
            }
        }
    }

    /* renamed from: e.a.a.a$v */
    /* compiled from: ActivityHandler */
    class C3262v implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C3363x0 f9082a;

        C3262v(C3363x0 x0Var) {
            this.f9082a = x0Var;
        }

        public void run() {
            if (C3236a.this.f9029l != null && C3236a.this.f9029l.f9207p != null) {
                C3236a.this.f9029l.f9207p.mo19048a(this.f9082a.mo19112a());
            }
        }
    }

    /* renamed from: e.a.a.a$w */
    /* compiled from: ActivityHandler */
    class C3263w implements Runnable {
        C3263w() {
        }

        public void run() {
            if (C3236a.this.f9029l != null && C3236a.this.f9029l.f9201j != null) {
                C3236a.this.f9029l.f9201j.mo19031a(C3236a.this.f9030m);
            }
        }
    }

    /* renamed from: e.a.a.a$x */
    /* compiled from: ActivityHandler */
    class C3264x implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Uri f9085a;

        /* renamed from: b */
        final /* synthetic */ Intent f9086b;

        C3264x(Uri uri, Intent intent) {
            this.f9085a = uri;
            this.f9086b = intent;
        }

        public void run() {
            if (C3236a.this.f9029l != null) {
                boolean z = true;
                if (C3236a.this.f9029l.f9208q != null) {
                    z = C3236a.this.f9029l.f9208q.mo19033a(this.f9085a);
                }
                if (z) {
                    C3236a.this.m10703a(this.f9086b, this.f9085a);
                }
            }
        }
    }

    /* renamed from: e.a.a.a$y */
    /* compiled from: ActivityHandler */
    class C3265y implements Runnable {
        C3265y() {
        }

        public void run() {
            C3236a.this.m10694J();
            C3236a.this.m10689E();
            C3236a.this.f9021d.mo19024e("Subsession end", new Object[0]);
            C3236a.this.m10768r();
        }
    }

    /* renamed from: e.a.a.a$z */
    /* compiled from: ActivityHandler */
    class C3266z implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C3303h f9089a;

        C3266z(C3303h hVar) {
            this.f9089a = hVar;
        }

        public void run() {
            if (C3236a.this.f9025h.mo18916a()) {
                C3236a.this.f9021d.mo19021b("Event tracked before first activity resumed.\nIf it was triggered in the Application class, it might timestamp or even send an install long before the user opens the app.\nPlease check https://github.com/adjust/android_sdk#can-i-trigger-an-event-at-application-launch for more information.", new Object[0]);
                C3236a.this.m10692H();
            }
            C3236a.this.m10740c(this.f9089a);
        }
    }

    private C3236a(C3301g gVar) {
        mo18882a(gVar);
        C3364y d = C3309k.m11002d();
        this.f9021d = d;
        d.mo19018a();
        C3244d0 d0Var = new C3244d0(this);
        this.f9025h = d0Var;
        Boolean bool = gVar.f9215x;
        d0Var.f9051a = bool != null ? bool.booleanValue() : true;
        C3244d0 d0Var2 = this.f9025h;
        d0Var2.f9052b = gVar.f9216y;
        d0Var2.f9053c = true;
        d0Var2.f9054d = false;
        d0Var2.f9055e = false;
        d0Var2.f9057g = false;
        d0Var2.f9058h = false;
        this.f9018a.submit(new C3247g());
    }

    /* renamed from: A */
    private void m10685A() {
        if (!this.f9020c.f9148c) {
            long currentTimeMillis = System.currentTimeMillis();
            C3294d dVar = this.f9020c;
            long j = currentTimeMillis - dVar.f9155j;
            if (j < 0) {
                this.f9021d.mo19022c("Time travel!", new Object[0]);
                this.f9020c.f9155j = currentTimeMillis;
                m10698N();
            } else if (j > f9016u) {
                m10701a(currentTimeMillis);
                m10761o();
            } else if (j > f9017v) {
                int i = dVar.f9152g + 1;
                dVar.f9152g = i;
                dVar.f9153h += j;
                dVar.f9155j = currentTimeMillis;
                this.f9021d.mo19024e("Started subsession %d of session %d", Integer.valueOf(i), Integer.valueOf(this.f9020c.f9151f));
                m10698N();
                this.f9034q.mo19009a();
            } else {
                this.f9021d.mo19024e("Time span since last activity too short for a new subsession", new Object[0]);
            }
        }
    }

    /* renamed from: B */
    private void m10686B() {
        this.f9031n.mo19064b();
        this.f9019b.mo19078b();
        this.f9032o.mo18983b();
    }

    /* access modifiers changed from: private */
    /* renamed from: C */
    public void m10687C() {
        if (this.f9025h.mo18924i()) {
            this.f9021d.mo19025f("Start delay expired or never configured", new Object[0]);
            return;
        }
        m10697M();
        this.f9025h.f9054d = false;
        this.f9024g.mo18999a();
        this.f9024g = null;
        m10696L();
    }

    /* access modifiers changed from: private */
    /* renamed from: D */
    public void m10688D() {
        if (m10773w() && !this.f9025h.mo18916a()) {
            this.f9032o.mo18984c();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: E */
    public void m10689E() {
        if (this.f9023f != null && m10695K() && this.f9023f.mo19001b() <= 0) {
            this.f9023f.mo19000a(f9015t);
        }
    }

    /* renamed from: F */
    private void m10690F() {
        m10696L();
        this.f9020c = new C3294d();
        this.f9025h.f9058h = true;
        long currentTimeMillis = System.currentTimeMillis();
        C3365y0 y0Var = new C3365y0(getContext());
        this.f9020c.f9159n = y0Var.mo19123e();
        if (this.f9025h.mo18919d()) {
            if (!y0Var.mo19121c()) {
                this.f9020c.f9151f = 1;
                m10725b(currentTimeMillis);
                m10718a(y0Var);
            } else {
                m10770t();
            }
        }
        this.f9020c.mo19003a(currentTimeMillis);
        this.f9020c.f9147b = this.f9025h.mo18919d();
        this.f9020c.f9157l = this.f9025h.mo18926k();
        m10698N();
        y0Var.mo19127i();
        y0Var.mo19126h();
        m10776z();
    }

    /* access modifiers changed from: private */
    /* renamed from: G */
    public void m10691G() {
        if (m10773w()) {
            this.f9022e.mo18996a();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: H */
    public void m10692H() {
        if (this.f9025h.mo18916a()) {
            m10690F();
        } else if (this.f9020c.f9147b) {
            m10696L();
            m10685A();
            m10763p();
            m10776z();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: I */
    public void m10693I() {
        C3292i iVar = this.f9023f;
        if (iVar != null) {
            iVar.mo18999a();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: J */
    public void m10694J() {
        this.f9022e.mo18997b();
    }

    /* renamed from: K */
    private boolean m10695K() {
        return m10750e(false);
    }

    /* renamed from: L */
    private void m10696L() {
        if (!m10695K()) {
            m10775y();
            return;
        }
        m10686B();
        if (!this.f9029l.f9199h || (this.f9025h.mo18920e() && this.f9025h.mo18918c())) {
            this.f9019b.mo19082e();
        }
    }

    /* renamed from: M */
    private void m10697M() {
        this.f9019b.mo19076a(this.f9033p);
        this.f9025h.f9055e = false;
        C3294d dVar = this.f9020c;
        if (dVar != null) {
            dVar.f9157l = false;
            m10698N();
        }
    }

    /* renamed from: N */
    private void m10698N() {
        synchronized (C3294d.class) {
            if (this.f9020c != null) {
                C3268a1.m10838a(this.f9020c, this.f9029l.f9194c, "AdjustIoActivityState", "Activity state");
            }
        }
    }

    /* renamed from: O */
    private void m10699O() {
        synchronized (C3299f.class) {
            if (this.f9030m != null) {
                C3268a1.m10838a(this.f9030m, this.f9029l.f9194c, "AdjustAttribution", "Attribution");
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: s */
    public void m10769s() {
        if (!m10773w()) {
            m10694J();
            return;
        }
        if (m10695K()) {
            this.f9019b.mo19082e();
        }
        if (m10744c(System.currentTimeMillis())) {
            m10698N();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: t */
    public void m10770t() {
        if (m10721a(this.f9020c) && m10773w()) {
            C3294d dVar = this.f9020c;
            if (!dVar.f9148c) {
                dVar.f9148c = true;
                m10698N();
                C3276c a = new C3321o0(this.f9029l, this.f9028k, this.f9020c, this.f9033p, System.currentTimeMillis()).mo19052a();
                this.f9019b.mo19073a(a);
                new C3365y0(getContext()).mo19126h();
                if (this.f9029l.f9199h) {
                    this.f9021d.mo19025f("Buffered event %s", a.mo18977m());
                    return;
                }
                this.f9019b.mo19082e();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: u */
    public void m10771u() {
        this.f9020c.f9148c = true;
        m10698N();
        this.f9019b.flush();
        m10747d(false);
    }

    /* access modifiers changed from: private */
    /* renamed from: v */
    public void m10772v() {
        Double d;
        f9016u = C3309k.m11006h();
        f9017v = C3309k.m11007i();
        f9013r = C3309k.m11008j();
        f9014s = C3309k.m11009k();
        f9015t = C3309k.m11008j();
        m10726b(this.f9029l.f9194c);
        m10702a(this.f9029l.f9194c);
        this.f9033p = new C3361w0();
        m10745d(this.f9029l.f9194c);
        m10748e(this.f9029l.f9194c);
        C3301g gVar = this.f9029l;
        if (gVar.f9215x != null) {
            if (gVar.f9211t == null) {
                gVar.f9211t = new ArrayList();
            }
            this.f9029l.f9211t.add(new C3253m());
        }
        if (this.f9025h.mo18917b()) {
            C3244d0 d0Var = this.f9025h;
            C3294d dVar = this.f9020c;
            d0Var.f9051a = dVar.f9147b;
            d0Var.f9055e = dVar.f9157l;
            d0Var.f9056f = false;
        } else {
            this.f9025h.f9056f = true;
        }
        m10738c(this.f9029l.f9194c);
        C3301g gVar2 = this.f9029l;
        this.f9028k = new C3345t(gVar2.f9194c, gVar2.f9198g);
        if (this.f9029l.f9199h) {
            this.f9021d.mo19025f("Event buffering is enabled", new Object[0]);
        }
        this.f9028k.mo19093b(this.f9029l.f9194c);
        if (this.f9028k.f9365a == null) {
            this.f9021d.mo19021b("Unable to get Google Play Services Advertising ID at start time", new Object[0]);
            C3345t tVar = this.f9028k;
            if (tVar.f9369e == null && tVar.f9370f == null && tVar.f9371g == null) {
                this.f9021d.mo19022c("Unable to get any device id's. Please check if Proguard is correctly set with Adjust SDK", new Object[0]);
            }
        } else {
            this.f9021d.mo19025f("Google Play Services Advertising ID read correctly at start time", new Object[0]);
        }
        String str = this.f9029l.f9200i;
        if (str != null) {
            this.f9021d.mo19025f("Default tracker: '%s'", str);
        }
        String str2 = this.f9029l.f9214w;
        if (str2 != null) {
            this.f9021d.mo19025f("Push token: '%s'", str2);
            if (this.f9025h.mo18917b()) {
                mo18890a(this.f9029l.f9214w, false);
            } else {
                new C3365y0(getContext()).mo19116a(this.f9029l.f9214w);
            }
        } else if (this.f9025h.mo18917b()) {
            mo18890a(new C3365y0(getContext()).mo19123e(), true);
        }
        if (this.f9025h.mo18917b() && new C3365y0(getContext()).mo19121c()) {
            mo18905l();
        }
        this.f9022e = new C3290h(new C3254n(), f9014s, f9013r, "Foreground timer");
        if (this.f9029l.f9209r) {
            this.f9021d.mo19025f("Send in background configured", new Object[0]);
            this.f9023f = new C3292i(new C3255o(), "Background timer");
        }
        if (this.f9025h.mo18916a() && (d = this.f9029l.f9210s) != null && d.doubleValue() > 0.0d) {
            this.f9021d.mo19025f("Delay start configured", new Object[0]);
            this.f9025h.f9054d = true;
            this.f9024g = new C3292i(new C3257q(), "Delay Start timer");
        }
        C3273b1.m10880a(this.f9029l.f9213v);
        C3301g gVar3 = this.f9029l;
        this.f9026i = gVar3.f9192a;
        this.f9027j = gVar3.f9193b;
        this.f9019b = C3309k.m10996a(this, gVar3.f9194c, m10750e(false));
        this.f9031n = C3309k.m10995a((C3360w) this, m10750e(false));
        this.f9032o = C3309k.m11000b(this, m10750e(true));
        if (m10774x()) {
            m10697M();
        }
        this.f9034q = new C3295d0(this.f9029l.f9194c, new C3258r());
        m10719a(this.f9029l.f9211t);
        m10688D();
    }

    /* renamed from: w */
    private boolean m10773w() {
        C3294d dVar = this.f9020c;
        if (dVar != null) {
            return dVar.f9147b;
        }
        return this.f9025h.mo18919d();
    }

    /* renamed from: x */
    private boolean m10774x() {
        C3294d dVar = this.f9020c;
        if (dVar != null) {
            return dVar.f9157l;
        }
        return this.f9025h.mo18926k();
    }

    /* renamed from: y */
    private void m10775y() {
        this.f9031n.mo19059a();
        this.f9019b.mo19072a();
        if (!m10750e(true)) {
            this.f9032o.mo18980a();
        } else {
            this.f9032o.mo18983b();
        }
    }

    /* renamed from: z */
    private void m10776z() {
        if (m10721a(this.f9020c)) {
            C3365y0 y0Var = new C3365y0(getContext());
            String b = y0Var.mo19118b();
            long a = y0Var.mo19114a();
            if (b != null && a != -1) {
                mo18881a(Uri.parse(b), a);
                y0Var.mo19125g();
            }
        }
    }

    public Context getContext() {
        return this.f9029l.f9194c;
    }

    public boolean isEnabled() {
        return m10773w();
    }

    public void onPause() {
        this.f9025h.f9053c = true;
        this.f9018a.submit(new C3265y());
    }

    public void onResume() {
        this.f9025h.f9053c = false;
        this.f9018a.submit(new C3256p());
    }

    /* renamed from: c */
    private void m10742c(String str) {
        if (str != null && !str.equals(this.f9020c.f9160o)) {
            this.f9020c.f9160o = str;
            m10698N();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m10759n() {
        if (m10695K()) {
            this.f9019b.mo19082e();
        }
    }

    /* renamed from: o */
    private void m10761o() {
        m10718a(new C3365y0(getContext()));
    }

    /* renamed from: p */
    private void m10763p() {
        if (m10721a(this.f9020c)) {
            if (this.f9025h.mo18920e() && this.f9025h.mo18918c()) {
                return;
            }
            if (this.f9030m == null || this.f9020c.f9149d) {
                this.f9031n.mo19065c();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public void m10765q() {
        if (!this.f9025h.mo18924i() && !m10774x()) {
            Double d = this.f9029l.f9210s;
            double doubleValue = d != null ? d.doubleValue() : 0.0d;
            long e = C3309k.m11003e();
            long j = (long) (1000.0d * doubleValue);
            if (j > e) {
                double d2 = (double) (e / 1000);
                this.f9021d.mo19021b("Delay start of %s seconds bigger than max allowed value of %s seconds", C3268a1.f9091a.format(doubleValue), C3268a1.f9091a.format(d2));
                doubleValue = d2;
            } else {
                e = j;
            }
            this.f9021d.mo19025f("Waiting %s seconds before starting first session", C3268a1.f9091a.format(doubleValue));
            this.f9024g.mo19000a(e);
            this.f9025h.f9055e = true;
            C3294d dVar = this.f9020c;
            if (dVar != null) {
                dVar.f9157l = true;
                m10698N();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public void m10768r() {
        if (!m10695K()) {
            m10775y();
        }
        if (m10744c(System.currentTimeMillis())) {
            m10698N();
        }
    }

    /* renamed from: d */
    public String mo18895d() {
        return this.f9027j;
    }

    /* renamed from: e */
    public C3361w0 mo18896e() {
        return this.f9033p;
    }

    /* renamed from: f */
    public C3345t mo18897f() {
        return this.f9028k;
    }

    /* renamed from: g */
    public C3294d mo18898g() {
        return this.f9020c;
    }

    /* renamed from: h */
    public String mo18900h() {
        C3294d dVar = this.f9020c;
        if (dVar == null) {
            return null;
        }
        return dVar.f9160o;
    }

    /* renamed from: i */
    public C3301g mo18901i() {
        return this.f9029l;
    }

    /* renamed from: j */
    public void mo18903j() {
        this.f9018a.submit(new C3242c0());
    }

    /* renamed from: k */
    public void mo18904k() {
        this.f9018a.submit(new C3250j());
    }

    /* renamed from: l */
    public void mo18905l() {
        this.f9018a.submit(new C3249i());
    }

    /* renamed from: m */
    public void mo18906m() {
        this.f9018a.submit(new C3246f());
    }

    /* renamed from: b */
    public static C3236a m10724b(C3301g gVar) {
        if (gVar == null) {
            C3309k.m11002d().mo19022c("AdjustConfig missing", new Object[0]);
            return null;
        } else if (!gVar.mo19017a()) {
            C3309k.m11002d().mo19022c("AdjustConfig not initialized correctly", new Object[0]);
            return null;
        } else {
            if (gVar.f9197f != null) {
                int myPid = Process.myPid();
                ActivityManager activityManager = (ActivityManager) gVar.f9194c.getSystemService("activity");
                if (activityManager != null) {
                    Iterator<ActivityManager.RunningAppProcessInfo> it = activityManager.getRunningAppProcesses().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ActivityManager.RunningAppProcessInfo next = it.next();
                        if (next.pid == myPid) {
                            if (!next.processName.equalsIgnoreCase(gVar.f9197f)) {
                                C3309k.m11002d().mo19025f("Skipping initialization in background process (%s)", next.processName);
                                return null;
                            }
                        }
                    }
                } else {
                    return null;
                }
            }
            return new C3236a(gVar);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m10747d(boolean z) {
        if (m10723a(m10773w(), z, "Adjust already enabled", "Adjust already disabled")) {
            if (!z || !this.f9020c.f9148c) {
                C3244d0 d0Var = this.f9025h;
                d0Var.f9051a = z;
                if (d0Var.mo18916a()) {
                    m10720a(!z, "Handlers will start as paused due to the SDK being disabled", "Handlers will still start as paused", "Handlers will start as active due to the SDK being enabled");
                    return;
                }
                this.f9020c.f9147b = z;
                m10698N();
                if (z) {
                    C3365y0 y0Var = new C3365y0(getContext());
                    if (y0Var.mo19121c()) {
                        m10770t();
                    }
                    if (!y0Var.mo19122d()) {
                        m10701a(System.currentTimeMillis());
                    }
                    m10718a(y0Var);
                }
                m10720a(!z, "Pausing handlers due to SDK being disabled", "Handlers remain paused", "Resuming handlers due to SDK being enabled");
                return;
            }
            this.f9021d.mo19022c("Re-enabling SDK not possible for forgotten user", new Object[0]);
        }
    }

    /* renamed from: e */
    private void m10748e(Context context) {
        try {
            this.f9033p.f9426b = (Map) C3268a1.m10825a(context, "AdjustSessionPartnerParameters", "Session Partner parameters", Map.class);
        } catch (Exception e) {
            this.f9021d.mo19022c("Failed to read %s file (%s)", "Session Partner parameters", e.getMessage());
            this.f9033p.f9426b = null;
        }
    }

    /* renamed from: c */
    public String mo18894c() {
        return this.f9026i;
    }

    /* renamed from: c */
    private void m10738c(Context context) {
        try {
            InputStream open = context.getAssets().open("adjust_config.properties");
            Properties properties = new Properties();
            properties.load(open);
            this.f9021d.mo19024e("adjust_config.properties file read and loaded", new Object[0]);
            String property = properties.getProperty("defaultTracker");
            if (property != null) {
                this.f9029l.f9200i = property;
            }
        } catch (Exception e) {
            this.f9021d.mo19023d("%s file not found in this app", e.getMessage());
        }
    }

    /* renamed from: e */
    private boolean m10750e(boolean z) {
        if (m10737b(z)) {
            return false;
        }
        if (this.f9029l.f9209r) {
            return true;
        }
        return this.f9025h.mo18923h();
    }

    /* renamed from: a */
    public void mo18882a(C3301g gVar) {
        this.f9029l = gVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m10740c(C3303h hVar) {
        if (m10721a(this.f9020c) && m10773w() && m10736b(hVar) && m10722a(hVar.f9228f) && !this.f9020c.f9148c) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f9020c.f9150e++;
            m10744c(currentTimeMillis);
            C3276c a = new C3321o0(this.f9029l, this.f9028k, this.f9020c, this.f9033p, currentTimeMillis).mo19053a(hVar, this.f9025h.mo18922g());
            this.f9019b.mo19073a(a);
            if (this.f9029l.f9199h) {
                this.f9021d.mo19025f("Buffered event %s", a.mo18977m());
            } else {
                this.f9019b.mo19082e();
            }
            if (this.f9029l.f9209r && this.f9025h.mo18921f()) {
                m10689E();
            }
            m10698N();
        }
    }

    /* renamed from: a */
    public void mo18883a(C3303h hVar) {
        this.f9018a.submit(new C3266z(hVar));
    }

    /* renamed from: a */
    public void mo18885a(C3346t0 t0Var) {
        if (t0Var instanceof C3363x0) {
            this.f9031n.mo19063a((C3363x0) t0Var);
        } else if (t0Var instanceof C3359v0) {
            C3359v0 v0Var = (C3359v0) t0Var;
            m10732b(v0Var);
            this.f9031n.mo19061a(v0Var);
        } else if (t0Var instanceof C3348u) {
            mo18886a((C3348u) t0Var);
        }
    }

    /* renamed from: b */
    public void mo18893b() {
        this.f9018a.submit(new C3251k());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m10731b(C3348u uVar) {
        m10742c(uVar.f9393c);
        Handler handler = new Handler(this.f9029l.f9194c.getMainLooper());
        if (uVar.f9391a && this.f9029l.f9204m != null) {
            this.f9021d.mo19023d("Launching success event tracking listener", new Object[0]);
            handler.post(new C3259s(uVar));
        } else if (!uVar.f9391a && this.f9029l.f9205n != null) {
            this.f9021d.mo19023d("Launching failed event tracking listener", new Object[0]);
            handler.post(new C3260t(uVar));
        }
    }

    /* renamed from: d */
    private void m10745d(Context context) {
        try {
            this.f9033p.f9425a = (Map) C3268a1.m10825a(context, "AdjustSessionCallbackParameters", "Session Callback parameters", Map.class);
        } catch (Exception e) {
            this.f9021d.mo19022c("Failed to read %s file (%s)", "Session Callback parameters", e.getMessage());
            this.f9033p.f9425a = null;
        }
    }

    /* renamed from: a */
    public void mo18881a(Uri uri, long j) {
        this.f9018a.submit(new C3238a0(uri, j));
    }

    /* renamed from: a */
    public boolean mo18892a(C3299f fVar) {
        if (fVar == null || fVar.equals(this.f9030m)) {
            return false;
        }
        this.f9030m = fVar;
        m10699O();
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m10733b(C3363x0 x0Var) {
        m10742c(x0Var.f9393c);
        Handler handler = new Handler(this.f9029l.f9194c.getMainLooper());
        if (mo18892a(x0Var.f9398h)) {
            m10705a(handler);
        }
        if (this.f9030m == null && !this.f9020c.f9149d) {
            this.f9031n.mo19065c();
        }
        if (x0Var.f9391a) {
            new C3365y0(getContext()).mo19128j();
        }
        m10717a(x0Var, handler);
        this.f9025h.f9057g = true;
    }

    /* renamed from: a */
    public void mo18891a(boolean z) {
        this.f9018a.submit(new C3240b0(z));
    }

    /* renamed from: a */
    public void mo18889a(String str, long j, long j2) {
        this.f9018a.submit(new C3237a(str, j, j2));
    }

    /* renamed from: a */
    public void mo18886a(C3348u uVar) {
        this.f9018a.submit(new C3239b(uVar));
    }

    /* renamed from: a */
    public void mo18887a(C3359v0 v0Var) {
        this.f9018a.submit(new C3241c(v0Var));
    }

    /* renamed from: a */
    public void mo18888a(C3363x0 x0Var) {
        this.f9018a.submit(new C3243d(x0Var));
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m10741c(C3359v0 v0Var) {
        m10742c(v0Var.f9393c);
        Handler handler = new Handler(this.f9029l.f9194c.getMainLooper());
        if (mo18892a(v0Var.f9398h)) {
            m10705a(handler);
        }
    }

    /* renamed from: a */
    public void mo18884a(C3340r rVar) {
        this.f9018a.submit(new C3245e(rVar));
    }

    /* renamed from: a */
    public void mo18890a(String str, boolean z) {
        this.f9018a.submit(new C3248h(z, str));
    }

    /* renamed from: a */
    public void mo18880a() {
        this.f9018a.submit(new C3252l());
    }

    /* renamed from: a */
    private void m10719a(List<C3272b0> list) {
        if (list != null) {
            for (C3272b0 a : list) {
                a.mo18935a(this);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m10743c(boolean z) {
        this.f9020c.f9149d = z;
        m10698N();
    }

    /* renamed from: a */
    private void m10701a(long j) {
        C3294d dVar = this.f9020c;
        dVar.f9151f++;
        dVar.f9156k = j - dVar.f9155j;
        m10725b(j);
        this.f9020c.mo19003a(j);
        m10698N();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m10730b(C3340r rVar) {
        m10742c(rVar.f9393c);
        Handler handler = new Handler(this.f9029l.f9194c.getMainLooper());
        if (mo18892a(rVar.f9398h)) {
            m10705a(handler);
        }
        m10704a(rVar.f9343i, handler);
    }

    /* renamed from: c */
    private boolean m10744c(long j) {
        if (!m10721a(this.f9020c)) {
            return false;
        }
        C3294d dVar = this.f9020c;
        long j2 = j - dVar.f9155j;
        if (j2 > f9016u) {
            return false;
        }
        dVar.f9155j = j;
        if (j2 < 0) {
            this.f9021d.mo19022c("Time travel!", new Object[0]);
            return true;
        }
        dVar.f9153h += j2;
        dVar.f9154i += j2;
        return true;
    }

    /* renamed from: a */
    private void m10717a(C3363x0 x0Var, Handler handler) {
        if (x0Var.f9391a && this.f9029l.f9206o != null) {
            this.f9021d.mo19023d("Launching success session tracking listener", new Object[0]);
            handler.post(new C3261u(x0Var));
        } else if (!x0Var.f9391a && this.f9029l.f9207p != null) {
            this.f9021d.mo19023d("Launching failed session tracking listener", new Object[0]);
            handler.post(new C3262v(x0Var));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m10735b(String str, long j, long j2) {
        if (m10773w() && str != null) {
            C3294d dVar = this.f9020c;
            if (j != dVar.f9161p || j2 != dVar.f9162q || !str.equals(dVar.f9163r)) {
                this.f9032o.mo18981a(C3324p0.m11056a(str, j, j2, this.f9020c, this.f9029l, this.f9028k, this.f9033p));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m10727b(Uri uri, long j) {
        if (m10773w()) {
            if (C3268a1.m10841a(uri)) {
                C3364y yVar = this.f9021d;
                yVar.mo19023d("Deep link (" + uri.toString() + ") processing skipped", new Object[0]);
                return;
            }
            C3276c a = C3324p0.m11055a(uri, j, this.f9020c, this.f9029l, this.f9028k, this.f9033p);
            if (a != null) {
                this.f9032o.mo18981a(a);
            }
        }
    }

    /* renamed from: a */
    private void m10705a(Handler handler) {
        if (this.f9029l.f9201j != null) {
            handler.post(new C3263w());
        }
    }

    /* renamed from: b */
    private void m10725b(long j) {
        this.f9019b.mo19073a(new C3321o0(this.f9029l, this.f9028k, this.f9020c, this.f9033p, j).mo19055a(this.f9025h.mo18922g()));
        this.f9019b.mo19082e();
    }

    /* renamed from: a */
    private void m10704a(Uri uri, Handler handler) {
        if (uri != null) {
            this.f9021d.mo19025f("Deferred deeplink received (%s)", uri);
            handler.post(new C3264x(uri, m10700a(uri)));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m10734b(String str) {
        if (m10721a(this.f9020c) && m10773w()) {
            C3294d dVar = this.f9020c;
            if (!dVar.f9148c && str != null && !str.equals(dVar.f9159n)) {
                this.f9020c.f9159n = str;
                m10698N();
                C3276c c = new C3321o0(this.f9029l, this.f9028k, this.f9020c, this.f9033p, System.currentTimeMillis()).mo19058c("push");
                this.f9019b.mo19073a(c);
                new C3365y0(getContext()).mo19127i();
                if (this.f9029l.f9199h) {
                    this.f9021d.mo19025f("Buffered event %s", c.mo18977m());
                    return;
                }
                this.f9019b.mo19082e();
            }
        }
    }

    /* renamed from: a */
    private Intent m10700a(Uri uri) {
        Intent intent;
        if (this.f9029l.f9203l == null) {
            intent = new Intent("android.intent.action.VIEW", uri);
        } else {
            C3301g gVar = this.f9029l;
            intent = new Intent("android.intent.action.VIEW", uri, gVar.f9194c, gVar.f9203l);
        }
        intent.setFlags(DriveFile.MODE_READ_ONLY);
        intent.setPackage(this.f9029l.f9194c.getPackageName());
        return intent;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10703a(Intent intent, Uri uri) {
        if (!(this.f9029l.f9194c.getPackageManager().queryIntentActivities(intent, 0).size() > 0)) {
            this.f9021d.mo19022c("Unable to open deferred deep link (%s)", uri);
            return;
        }
        this.f9021d.mo19025f("Open deferred deep link (%s)", uri);
        this.f9029l.f9194c.startActivity(intent);
    }

    /* renamed from: a */
    private void m10718a(C3365y0 y0Var) {
        String e = y0Var.mo19123e();
        if (e != null && !e.equals(this.f9020c.f9159n)) {
            mo18890a(e, true);
        }
        if (y0Var.mo19124f() != null) {
            mo18903j();
        }
        this.f9034q.mo19009a();
    }

    /* renamed from: b */
    private void m10726b(Context context) {
        try {
            this.f9030m = (C3299f) C3268a1.m10825a(context, "AdjustAttribution", "Attribution", C3299f.class);
        } catch (Exception e) {
            this.f9021d.mo19022c("Failed to read %s file (%s)", "Attribution", e.getMessage());
            this.f9030m = null;
        }
    }

    /* renamed from: a */
    private boolean m10723a(boolean z, boolean z2, String str, String str2) {
        if (z != z2) {
            return true;
        }
        if (z) {
            this.f9021d.mo19023d(str, new Object[0]);
        } else {
            this.f9021d.mo19023d(str2, new Object[0]);
        }
        return false;
    }

    /* renamed from: b */
    private boolean m10736b(C3303h hVar) {
        if (hVar == null) {
            this.f9021d.mo19022c("Event missing", new Object[0]);
            return false;
        } else if (hVar.mo19029a()) {
            return true;
        } else {
            this.f9021d.mo19022c("Event not initialized correctly", new Object[0]);
            return false;
        }
    }

    /* renamed from: a */
    private void m10720a(boolean z, String str, String str2, String str3) {
        if (z) {
            this.f9021d.mo19025f(str, new Object[0]);
        } else if (!m10737b(false)) {
            this.f9021d.mo19025f(str3, new Object[0]);
        } else if (m10737b(true)) {
            this.f9021d.mo19025f(str2, new Object[0]);
        } else {
            C3364y yVar = this.f9021d;
            yVar.mo19025f(str2 + ", except the Sdk Click Handler", new Object[0]);
        }
        m10696L();
    }

    /* renamed from: b */
    private boolean m10737b(boolean z) {
        if (z) {
            if (this.f9025h.mo18925j() || !m10773w()) {
                return true;
            }
            return false;
        } else if (this.f9025h.mo18925j() || !m10773w() || this.f9025h.mo18922g()) {
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: b */
    private void m10732b(C3359v0 v0Var) {
        if (v0Var.f9421i) {
            C3294d dVar = this.f9020c;
            dVar.f9161p = v0Var.f9422j;
            dVar.f9162q = v0Var.f9423k;
            dVar.f9163r = v0Var.f9424l;
            m10698N();
        }
    }

    /* renamed from: a */
    private void m10702a(Context context) {
        try {
            this.f9020c = (C3294d) C3268a1.m10825a(context, "AdjustIoActivityState", "Activity state", C3294d.class);
        } catch (Exception e) {
            this.f9021d.mo19022c("Failed to read %s file (%s)", "Activity state", e.getMessage());
            this.f9020c = null;
        }
        if (this.f9020c != null) {
            this.f9025h.f9058h = true;
        }
    }

    /* renamed from: a */
    private boolean m10722a(String str) {
        if (str != null && !str.isEmpty()) {
            if (this.f9020c.mo19005b(str)) {
                this.f9021d.mo19025f("Skipping duplicated order ID '%s'", str);
                return false;
            }
            this.f9020c.mo19004a(str);
            this.f9021d.mo19024e("Added order ID '%s'", str);
        }
        return true;
    }

    /* renamed from: a */
    private boolean m10721a(C3294d dVar) {
        if (!this.f9025h.mo18916a()) {
            return true;
        }
        this.f9021d.mo19022c("Sdk did not yet start", new Object[0]);
        return false;
    }
}
