package com.tapjoy.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tapjoy.TJContentActivity;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.TapjoyLog;
import com.tapjoy.internal.C5202io;
import java.util.Iterator;

/* renamed from: com.tapjoy.internal.gv */
public class C5135gv extends C3151hg {

    /* renamed from: h */
    private static final String f14036h = "gv";

    /* renamed from: i */
    private static C5135gv f14037i;

    /* renamed from: a */
    final String f14038a;

    /* renamed from: b */
    final C5166hr f14039b;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final C3145gz f14040j;

    /* renamed from: k */
    private boolean f14041k;

    /* renamed from: l */
    private boolean f14042l;

    /* renamed from: m */
    private long f14043m;

    /* renamed from: n */
    private Context f14044n;

    /* renamed from: o */
    private C5202io f14045o;

    /* renamed from: p */
    private Activity f14046p;

    /* renamed from: q */
    private C5143ha f14047q;

    /* renamed from: r */
    private Handler f14048r;

    /* renamed from: s */
    private Runnable f14049s;

    public C5135gv(C3145gz gzVar, String str, C5166hr hrVar, Context context) {
        this.f14040j = gzVar;
        this.f14038a = str;
        this.f14039b = hrVar;
        this.f14044n = context;
    }

    /* renamed from: a */
    public static void m17314a() {
        C5135gv gvVar = f14037i;
        if (gvVar != null) {
            C51361 r1 = new Runnable(gvVar) {

                /* renamed from: a */
                final /* synthetic */ C5135gv f14050a;

                {
                    this.f14050a = r1;
                }

                public final void run() {
                    C5135gv.m17316a(this.f14050a);
                }
            };
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper != null && mainLooper.getThread() == Thread.currentThread()) {
                r1.run();
            } else {
                C5269u.m17670a().post(r1);
            }
        }
    }

    /* renamed from: c */
    public final boolean mo18600c() {
        C5178hx hxVar;
        Iterator it = this.f14039b.f14153a.iterator();
        boolean z = true;
        while (it.hasNext()) {
            Iterator it2 = ((C5185ia) it.next()).f14212c.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z = true;
                    continue;
                    break;
                }
                C5182hz hzVar = (C5182hz) it2.next();
                C5178hx hxVar2 = hzVar.f14206l;
                if ((hxVar2 == null || hxVar2.mo31346a()) && ((hxVar = hzVar.f14207m) == null || hxVar.mo31346a())) {
                }
            }
            z = false;
            continue;
            if (!z) {
                return false;
            }
        }
        return z;
    }

    /* renamed from: b */
    public final void mo18599b() {
        Iterator it = this.f14039b.f14153a.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((C5185ia) it.next()).f14212c.iterator();
            while (it2.hasNext()) {
                C5182hz hzVar = (C5182hz) it2.next();
                C5178hx hxVar = hzVar.f14206l;
                if (hxVar != null) {
                    hxVar.mo31347b();
                }
                C5178hx hxVar2 = hzVar.f14207m;
                if (hxVar2 != null) {
                    hxVar2.mo31347b();
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo18598a(C5143ha haVar, C5100fw fwVar) {
        this.f14047q = haVar;
        Activity a = C5129gr.m17302a();
        this.f14046p = a;
        if (a != null && !a.isFinishing()) {
            try {
                m17315a(this.f14046p, haVar, fwVar);
                return;
            } catch (WindowManager.BadTokenException unused) {
            }
        }
        Activity a2 = C3120a.m10211a(this.f14044n);
        this.f14046p = a2;
        if (a2 != null && !a2.isFinishing()) {
            try {
                m17315a(this.f14046p, haVar, fwVar);
                return;
            } catch (WindowManager.BadTokenException unused2) {
            }
        }
        C5139gw.m17329b("Failed to show the content for \"{}\". No usable activity found.", this.f14038a);
        haVar.mo30545a(this.f14038a, this.f8791f, (C3143gl) null);
    }

    /* renamed from: a */
    private void m17315a(final Activity activity, final C5143ha haVar, C5100fw fwVar) {
        if (this.f14041k) {
            TapjoyLog.m16650e(f14036h, new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, "Content is already displayed"));
            return;
        }
        this.f14041k = true;
        this.f14042l = true;
        f14037i = this;
        this.f8792g = fwVar.f13955a;
        this.f14045o = new C5202io(activity, this.f14039b, new C5202io.C5205a() {
            /* renamed from: a */
            public final void mo31314a(C5182hz hzVar) {
                C5099fv fvVar;
                C5086fm fmVar;
                C5093fq fqVar = C5135gv.this.f8792g;
                if (!(!(fqVar instanceof C5099fv) || (fvVar = (C5099fv) fqVar) == null || (fmVar = fvVar.f13954c) == null)) {
                    fmVar.mo31256a();
                }
                C5135gv.this.f14040j.mo18548a(C5135gv.this.f14039b.f14154b, hzVar.f14205k);
                if (!C3166jq.m10436c(hzVar.f14202h)) {
                    C5135gv.this.f8790e.mo30698a(activity, hzVar.f14202h, C3166jq.m10435b(hzVar.f14203i));
                    C5135gv.this.f8789d = true;
                } else if (!C3166jq.m10436c(hzVar.f14201g)) {
                    C3151hg.m10393a((Context) activity, hzVar.f14201g);
                }
                haVar.mo30544a(C5135gv.this.f14038a, (C3143gl) null);
                if (hzVar.f14204j) {
                    C5135gv.m17316a(C5135gv.this);
                }
            }

            /* renamed from: a */
            public final void mo31313a() {
                C5135gv.m17316a(C5135gv.this);
            }
        });
        Window window = activity.getWindow();
        C5202io ioVar = this.f14045o;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        Window.Callback callback = window.getCallback();
        window.setCallback((Window.Callback) null);
        window.addContentView(ioVar, layoutParams);
        window.setCallback(callback);
        this.f14043m = SystemClock.elapsedRealtime();
        this.f14040j.mo18546a(this.f14039b.f14154b);
        fwVar.mo31263a();
        C5093fq fqVar = this.f8792g;
        if (fqVar != null) {
            fqVar.mo31259b();
        }
        haVar.mo30547c(this.f14038a);
        if (this.f14039b.f14155c > 0.0f) {
            this.f14048r = new Handler(Looper.getMainLooper());
            C51383 r5 = new Runnable() {
                public final void run() {
                    C5135gv.m17316a(C5135gv.this);
                }
            };
            this.f14049s = r5;
            this.f14048r.postDelayed(r5, (long) (this.f14039b.f14155c * 1000.0f));
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m17316a(C5135gv gvVar) {
        C5143ha haVar;
        if (gvVar.f14042l) {
            gvVar.f14042l = false;
            Handler handler = gvVar.f14048r;
            if (handler != null) {
                handler.removeCallbacks(gvVar.f14049s);
                gvVar.f14049s = null;
                gvVar.f14048r = null;
            }
            if (f14037i == gvVar) {
                f14037i = null;
            }
            gvVar.f14040j.mo18547a(gvVar.f14039b.f14154b, SystemClock.elapsedRealtime() - gvVar.f14043m);
            if (!gvVar.f8789d && (haVar = gvVar.f14047q) != null) {
                haVar.mo30545a(gvVar.f14038a, gvVar.f8791f, (C3143gl) null);
                gvVar.f14047q = null;
            }
            ViewGroup viewGroup = (ViewGroup) gvVar.f14045o.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(gvVar.f14045o);
            }
            gvVar.f14045o = null;
            Activity activity = gvVar.f14046p;
            if (activity instanceof TJContentActivity) {
                activity.finish();
            }
            gvVar.f14046p = null;
        }
    }
}
