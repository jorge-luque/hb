package p093e.p094a.p095a;

import android.content.Context;
import com.tapjoy.TapjoyConstants;
import java.util.List;

/* renamed from: e.a.a.l */
/* compiled from: AdjustInstance */
public class C3311l {

    /* renamed from: a */
    private String f9261a;

    /* renamed from: b */
    private Boolean f9262b = null;

    /* renamed from: c */
    private boolean f9263c = false;

    /* renamed from: d */
    private C3360w f9264d;

    /* renamed from: e */
    private List<C3272b0> f9265e;

    /* renamed from: f */
    private String f9266f;

    /* renamed from: g */
    private String f9267g;

    /* renamed from: e.a.a.l$a */
    /* compiled from: AdjustInstance */
    class C3312a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f9268a;

        C3312a(C3311l lVar, Context context) {
            this.f9268a = context;
        }

        public void run() {
            new C3365y0(this.f9268a).mo19129k();
        }
    }

    /* renamed from: e.a.a.l$b */
    /* compiled from: AdjustInstance */
    class C3313b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f9269a;

        /* renamed from: b */
        final /* synthetic */ String f9270b;

        /* renamed from: c */
        final /* synthetic */ long f9271c;

        C3313b(C3311l lVar, Context context, String str, long j) {
            this.f9269a = context;
            this.f9270b = str;
            this.f9271c = j;
        }

        public void run() {
            new C3365y0(this.f9269a).mo19120c(this.f9270b, this.f9271c);
        }
    }

    /* renamed from: e.a.a.l$c */
    /* compiled from: AdjustInstance */
    class C3314c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f9272a;

        /* renamed from: b */
        final /* synthetic */ String f9273b;

        C3314c(C3311l lVar, Context context, String str) {
            this.f9272a = context;
            this.f9273b = str;
        }

        public void run() {
            new C3365y0(this.f9272a).mo19116a(this.f9273b);
        }
    }

    /* renamed from: e */
    private boolean m11016e() {
        return m11014a((String) null);
    }

    /* renamed from: f */
    private boolean m11017f() {
        Boolean bool = this.f9262b;
        return bool == null || bool.booleanValue();
    }

    /* renamed from: a */
    public void mo19036a(C3301g gVar) {
        if (gVar == null) {
            C3309k.m11002d().mo19022c("AdjustConfig missing", new Object[0]);
        } else if (!gVar.mo19017a()) {
            C3309k.m11002d().mo19022c("AdjustConfig not initialized correctly", new Object[0]);
        } else if (this.f9264d != null) {
            C3309k.m11002d().mo19022c("Adjust already initialized", new Object[0]);
        } else {
            gVar.f9211t = this.f9265e;
            gVar.f9214w = this.f9261a;
            gVar.f9215x = this.f9262b;
            gVar.f9216y = this.f9263c;
            gVar.f9192a = this.f9266f;
            gVar.f9193b = this.f9267g;
            this.f9264d = C3309k.m10994a(gVar);
            m11012a(gVar.f9194c);
        }
    }

    /* renamed from: b */
    public boolean mo19040b() {
        if (!m11016e()) {
            return m11017f();
        }
        return this.f9264d.isEnabled();
    }

    /* renamed from: c */
    public void mo19041c() {
        if (m11016e()) {
            this.f9264d.onPause();
        }
    }

    /* renamed from: d */
    public void mo19042d() {
        if (m11016e()) {
            this.f9264d.onResume();
        }
    }

    /* renamed from: c */
    private void m11015c(String str, Context context) {
        C3268a1.m10839a((Runnable) new C3314c(this, context, str));
    }

    /* renamed from: b */
    public void mo19039b(String str, Context context) {
        m11015c(str, context);
        if (m11014a("push token") && this.f9264d.isEnabled()) {
            this.f9264d.mo18890a(str, true);
        }
    }

    /* renamed from: a */
    public void mo19037a(C3303h hVar) {
        if (m11016e()) {
            this.f9264d.mo18883a(hVar);
        }
    }

    /* renamed from: a */
    public void mo19038a(String str, Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        if (str != null && str.length() != 0) {
            m11013a(str, currentTimeMillis, context);
            if (m11014a(TapjoyConstants.TJC_REFERRER) && this.f9264d.isEnabled()) {
                this.f9264d.mo18903j();
            }
        }
    }

    /* renamed from: a */
    public String mo19035a() {
        if (!m11016e()) {
            return null;
        }
        return this.f9264d.mo18900h();
    }

    /* renamed from: a */
    private boolean m11014a(String str) {
        if (this.f9264d != null) {
            return true;
        }
        if (str != null) {
            C3309k.m11002d().mo19021b("Adjust not initialized, but %s saved for launch", str);
        } else {
            C3309k.m11002d().mo19022c("Adjust not initialized correctly", new Object[0]);
        }
        return false;
    }

    /* renamed from: a */
    private void m11013a(String str, long j, Context context) {
        C3268a1.m10839a((Runnable) new C3313b(this, context, str, j));
    }

    /* renamed from: a */
    private void m11012a(Context context) {
        C3268a1.m10839a((Runnable) new C3312a(this, context));
    }
}
