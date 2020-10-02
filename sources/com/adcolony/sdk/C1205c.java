package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.VideoView;
import com.adcolony.sdk.C1439u;
import com.iab.omid.library.adcolony.adsession.AdSession;
import com.iab.omid.library.adcolony.adsession.FriendlyObstructionPurpose;
import com.tapjoy.TJAdUnitConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.adcolony.sdk.c */
class C1205c extends FrameLayout {

    /* renamed from: A */
    VideoView f3354A;

    /* renamed from: a */
    private HashMap<Integer, C1364l0> f3355a;

    /* renamed from: b */
    private HashMap<Integer, C1342j0> f3356b;

    /* renamed from: c */
    private HashMap<Integer, C1379m0> f3357c;

    /* renamed from: d */
    private HashMap<Integer, C1396n> f3358d;

    /* renamed from: e */
    private HashMap<Integer, C1432q> f3359e;

    /* renamed from: f */
    private HashMap<Integer, Boolean> f3360f;

    /* renamed from: g */
    private HashMap<Integer, View> f3361g;

    /* renamed from: h */
    private int f3362h;

    /* renamed from: i */
    private int f3363i;

    /* renamed from: j */
    private int f3364j;

    /* renamed from: k */
    private int f3365k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public String f3366l;

    /* renamed from: m */
    boolean f3367m;

    /* renamed from: n */
    boolean f3368n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public float f3369o = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public double f3370p = 0.0d;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public long f3371q = 0;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public int f3372r = 0;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public int f3373s = 0;

    /* renamed from: t */
    private ArrayList<C1458z> f3374t;

    /* renamed from: u */
    private ArrayList<String> f3375u;

    /* renamed from: v */
    private boolean f3376v;

    /* renamed from: w */
    private boolean f3377w;

    /* renamed from: x */
    private boolean f3378x;

    /* renamed from: y */
    private AdSession f3379y;

    /* renamed from: z */
    Context f3380z;

    /* renamed from: com.adcolony.sdk.c$a */
    class C1206a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Runnable f3381a;

        C1206a(Runnable runnable) {
            this.f3381a = runnable;
        }

        public void run() {
            while (!C1205c.this.f3367m) {
                C1359k0.m5309a(this.f3381a);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    /* renamed from: com.adcolony.sdk.c$b */
    class C1207b implements C1458z {
        C1207b() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            if (C1205c.this.mo6425i(xVar)) {
                C1205c cVar = C1205c.this;
                cVar.mo6403a((View) cVar.mo6411c(xVar), FriendlyObstructionPurpose.OTHER);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.c$c */
    class C1208c implements C1458z {
        C1208c() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            if (C1205c.this.mo6425i(xVar)) {
                C1205c.this.mo6421g(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.c$d */
    class C1209d implements C1458z {

        /* renamed from: com.adcolony.sdk.c$d$a */
        class C1210a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C1454x f3386a;

            C1210a(C1454x xVar) {
                this.f3386a = xVar;
            }

            public void run() {
                C1205c cVar = C1205c.this;
                cVar.mo6403a((View) cVar.mo6414d(this.f3386a), FriendlyObstructionPurpose.OTHER);
            }
        }

        C1209d() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            if (C1205c.this.mo6425i(xVar)) {
                C1359k0.m5309a((Runnable) new C1210a(xVar));
            }
        }
    }

    /* renamed from: com.adcolony.sdk.c$e */
    class C1211e implements C1458z {

        /* renamed from: com.adcolony.sdk.c$e$a */
        class C1212a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C1454x f3389a;

            C1212a(C1454x xVar) {
                this.f3389a = xVar;
            }

            public void run() {
                C1205c.this.mo6423h(this.f3389a);
            }
        }

        C1211e() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            if (C1205c.this.mo6425i(xVar)) {
                C1359k0.m5309a((Runnable) new C1212a(xVar));
            }
        }
    }

    /* renamed from: com.adcolony.sdk.c$f */
    class C1213f implements C1458z {
        C1213f() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            if (C1205c.this.mo6425i(xVar)) {
                C1205c cVar = C1205c.this;
                cVar.mo6403a(cVar.mo6407b(xVar), FriendlyObstructionPurpose.OTHER);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.c$g */
    class C1214g implements C1458z {
        C1214g() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            if (C1205c.this.mo6425i(xVar)) {
                C1205c.this.mo6419f(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.c$h */
    class C1215h implements C1458z {
        C1215h() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            if (C1205c.this.mo6425i(xVar)) {
                C1205c cVar = C1205c.this;
                cVar.mo6403a((View) cVar.mo6399a(xVar), FriendlyObstructionPurpose.OTHER);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.c$i */
    class C1216i implements C1458z {
        C1216i() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            if (C1205c.this.mo6425i(xVar)) {
                C1205c.this.mo6417e(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.c$j */
    class C1217j implements Runnable {

        /* renamed from: a */
        final /* synthetic */ boolean f3395a;

        C1217j(boolean z) {
            this.f3395a = z;
        }

        public void run() {
            C1379m0 m0Var;
            double d;
            if (C1205c.this.f3371q == 0) {
                long unused = C1205c.this.f3371q = System.currentTimeMillis();
            }
            View view = (View) C1205c.this.getParent();
            AdColonyAdView adColonyAdView = C1199a.m4880c().mo6530b().mo6458b().get(C1205c.this.f3366l);
            if (adColonyAdView == null) {
                m0Var = null;
            } else {
                m0Var = adColonyAdView.getWebView();
            }
            C1379m0 m0Var2 = m0Var;
            Context b = C1199a.m4878b();
            boolean z = true;
            float a = C1410o0.m5515a(view, b, true, this.f3395a, true, adColonyAdView != null);
            if (b == null) {
                d = 0.0d;
            } else {
                d = C1359k0.m5294a(C1359k0.m5300a(b));
            }
            int a2 = C1359k0.m5297a((View) m0Var2);
            int b2 = C1359k0.m5314b((View) m0Var2);
            if (a2 == C1205c.this.f3372r && b2 == C1205c.this.f3373s) {
                z = false;
            }
            if (z) {
                int unused2 = C1205c.this.f3372r = a2;
                int unused3 = C1205c.this.f3373s = b2;
                C1205c.this.m4905a(a2, b2, m0Var2);
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (C1205c.this.f3371q + 200 < currentTimeMillis) {
                long unused4 = C1205c.this.f3371q = currentTimeMillis;
                if (!(C1205c.this.f3369o == a && C1205c.this.f3370p == d && !z)) {
                    C1205c.this.m4904a(a, d);
                }
                float unused5 = C1205c.this.f3369o = a;
                double unused6 = C1205c.this.f3370p = d;
            }
        }
    }

    private C1205c(Context context) {
        super(context);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo6421g(C1454x xVar) {
        int f = C1437s.m5611f(xVar.mo6830b(), "id");
        View remove = this.f3361g.remove(Integer.valueOf(f));
        C1364l0 remove2 = this.f3355a.remove(Integer.valueOf(f));
        if (remove == null || remove2 == null) {
            C1222d b = C1199a.m4880c().mo6530b();
            String c = xVar.mo6833c();
            b.mo6457a(c, "" + f);
            return false;
        }
        if (remove2.mo6681c()) {
            remove2.mo6687j();
        }
        remove2.mo6679a();
        removeView(remove2);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public boolean mo6423h(C1454x xVar) {
        int f = C1437s.m5611f(xVar.mo6830b(), "id");
        C1290h c = C1199a.m4880c();
        View remove = this.f3361g.remove(Integer.valueOf(f));
        C1379m0 remove2 = this.f3357c.remove(Integer.valueOf(f));
        if (remove2 == null || remove == null) {
            C1222d b = c.mo6530b();
            String c2 = xVar.mo6833c();
            b.mo6457a(c2, "" + f);
            return false;
        }
        c.mo6548n().mo6835a(remove2.mo6390d());
        removeView(remove2);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public boolean mo6425i(C1454x xVar) {
        JSONObject b = xVar.mo6830b();
        return C1437s.m5611f(b, "container_id") == this.f3364j && C1437s.m5613h(b, "ad_session_id").equals(this.f3366l);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo6427j(C1454x xVar) {
        int i;
        this.f3355a = new HashMap<>();
        this.f3356b = new HashMap<>();
        this.f3357c = new HashMap<>();
        this.f3358d = new HashMap<>();
        this.f3359e = new HashMap<>();
        this.f3360f = new HashMap<>();
        this.f3361g = new HashMap<>();
        this.f3374t = new ArrayList<>();
        this.f3375u = new ArrayList<>();
        JSONObject b = xVar.mo6830b();
        if (C1437s.m5608d(b, TJAdUnitConstants.String.TRANSPARENT)) {
            setBackgroundColor(0);
        }
        this.f3364j = C1437s.m5611f(b, "id");
        this.f3362h = C1437s.m5611f(b, "width");
        this.f3363i = C1437s.m5611f(b, "height");
        this.f3365k = C1437s.m5611f(b, "module_id");
        this.f3368n = C1437s.m5608d(b, "viewability_enabled");
        this.f3376v = this.f3364j == 1;
        C1290h c = C1199a.m4880c();
        if (this.f3362h == 0 && this.f3363i == 0) {
            this.f3362h = c.mo6542h().mo6634r();
            if (c.mo6552r().getMultiWindowEnabled()) {
                i = c.mo6542h().mo6633q() - C1359k0.m5327e(C1199a.m4878b());
            } else {
                i = c.mo6542h().mo6633q();
            }
            this.f3363i = i;
        } else {
            setLayoutParams(new FrameLayout.LayoutParams(this.f3362h, this.f3363i));
        }
        this.f3374t.add(C1199a.m4873a("VideoView.create", (C1458z) new C1207b(), true));
        this.f3374t.add(C1199a.m4873a("VideoView.destroy", (C1458z) new C1208c(), true));
        this.f3374t.add(C1199a.m4873a("WebView.create", (C1458z) new C1209d(), true));
        this.f3374t.add(C1199a.m4873a("WebView.destroy", (C1458z) new C1211e(), true));
        this.f3374t.add(C1199a.m4873a("TextView.create", (C1458z) new C1213f(), true));
        this.f3374t.add(C1199a.m4873a("TextView.destroy", (C1458z) new C1214g(), true));
        this.f3374t.add(C1199a.m4873a("ImageView.create", (C1458z) new C1215h(), true));
        this.f3374t.add(C1199a.m4873a("ImageView.destroy", (C1458z) new C1216i(), true));
        this.f3375u.add("VideoView.create");
        this.f3375u.add("VideoView.destroy");
        this.f3375u.add("WebView.create");
        this.f3375u.add("WebView.destroy");
        this.f3375u.add("TextView.create");
        this.f3375u.add("TextView.destroy");
        this.f3375u.add("ImageView.create");
        this.f3375u.add("ImageView.destroy");
        VideoView videoView = new VideoView(this.f3380z);
        this.f3354A = videoView;
        videoView.setVisibility(8);
        addView(this.f3354A);
        setClipToPadding(false);
        if (this.f3368n) {
            m4908a(C1437s.m5608d(xVar.mo6830b(), "advanced_viewability"));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public int mo6428k() {
        return this.f3365k;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public HashMap<Integer, C1342j0> mo6429l() {
        return this.f3356b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public HashMap<Integer, C1364l0> mo6430m() {
        return this.f3355a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public HashMap<Integer, C1379m0> mo6431n() {
        return this.f3357c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public boolean mo6432o() {
        return this.f3377w;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        int action = motionEvent.getAction() & 255;
        if (action != 0 && action != 1 && action != 3 && action != 2 && action != 5 && action != 6) {
            return false;
        }
        C1290h c = C1199a.m4880c();
        C1222d b = c.mo6530b();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        JSONObject b2 = C1437s.m5599b();
        C1437s.m5602b(b2, "view_id", -1);
        C1437s.m5592a(b2, "ad_session_id", this.f3366l);
        C1437s.m5602b(b2, "container_x", x);
        C1437s.m5602b(b2, "container_y", y);
        C1437s.m5602b(b2, "view_x", x);
        C1437s.m5602b(b2, "view_y", y);
        C1437s.m5602b(b2, "id", this.f3364j);
        if (action == 0) {
            new C1454x("AdContainer.on_touch_began", this.f3365k, b2).mo6834d();
        } else if (action == 1) {
            if (!this.f3376v) {
                c.mo6521a(b.mo6458b().get(this.f3366l));
            }
            new C1454x("AdContainer.on_touch_ended", this.f3365k, b2).mo6834d();
        } else if (action == 2) {
            new C1454x("AdContainer.on_touch_moved", this.f3365k, b2).mo6834d();
        } else if (action == 3) {
            new C1454x("AdContainer.on_touch_cancelled", this.f3365k, b2).mo6834d();
        } else if (action == 5) {
            int action2 = (motionEvent.getAction() & 65280) >> 8;
            C1437s.m5602b(b2, "container_x", (int) motionEvent2.getX(action2));
            C1437s.m5602b(b2, "container_y", (int) motionEvent2.getY(action2));
            C1437s.m5602b(b2, "view_x", (int) motionEvent2.getX(action2));
            C1437s.m5602b(b2, "view_y", (int) motionEvent2.getY(action2));
            new C1454x("AdContainer.on_touch_began", this.f3365k, b2).mo6834d();
        } else if (action == 6) {
            int action3 = (motionEvent.getAction() & 65280) >> 8;
            C1437s.m5602b(b2, "container_x", (int) motionEvent2.getX(action3));
            C1437s.m5602b(b2, "container_y", (int) motionEvent2.getY(action3));
            C1437s.m5602b(b2, "view_x", (int) motionEvent2.getX(action3));
            C1437s.m5602b(b2, "view_y", (int) motionEvent2.getY(action3));
            C1437s.m5602b(b2, "x", (int) motionEvent2.getX(action3));
            C1437s.m5602b(b2, "y", (int) motionEvent2.getY(action3));
            if (!this.f3376v) {
                c.mo6521a(b.mo6458b().get(this.f3366l));
            }
            new C1454x("AdContainer.on_touch_ended", this.f3365k, b2).mo6834d();
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public boolean mo6435p() {
        return this.f3376v;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public boolean mo6436q() {
        return this.f3378x;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public void mo6437r() {
        JSONObject b = C1437s.m5599b();
        C1437s.m5592a(b, "id", this.f3366l);
        new C1454x("AdSession.on_error", this.f3365k, b).mo6834d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C1364l0 mo6411c(C1454x xVar) {
        int f = C1437s.m5611f(xVar.mo6830b(), "id");
        C1364l0 l0Var = new C1364l0(this.f3380z, xVar, f, this);
        l0Var.mo6682d();
        this.f3355a.put(Integer.valueOf(f), l0Var);
        this.f3361g.put(Integer.valueOf(f), l0Var);
        return l0Var;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public C1379m0 mo6414d(C1454x xVar) {
        C1379m0 m0Var;
        JSONObject b = xVar.mo6830b();
        int f = C1437s.m5611f(b, "id");
        boolean d = C1437s.m5608d(b, "is_module");
        C1290h c = C1199a.m4880c();
        if (d) {
            m0Var = c.mo6557x().get(Integer.valueOf(C1437s.m5611f(b, "module_id")));
            if (m0Var == null) {
                new C1439u.C1440a().mo6801a("Module WebView created with invalid id").mo6803a(C1439u.f4516i);
                return null;
            }
            m0Var.mo6710a(xVar, f, this);
        } else {
            try {
                m0Var = new C1379m0(this.f3380z, xVar, f, c.mo6548n().mo6844d(), this);
            } catch (RuntimeException e) {
                C1439u.C1440a aVar = new C1439u.C1440a();
                aVar.mo6801a(e.toString() + ": during WebView initialization.").mo6801a(" Disabling AdColony.").mo6803a(C1439u.f4516i);
                AdColony.disable();
                return null;
            }
        }
        this.f3357c.put(Integer.valueOf(f), m0Var);
        this.f3361g.put(Integer.valueOf(f), m0Var);
        JSONObject b2 = C1437s.m5599b();
        C1437s.m5602b(b2, "module_id", m0Var.mo6390d());
        C1437s.m5602b(b2, "mraid_module_id", m0Var.mo6389c());
        xVar.mo6829a(b2).mo6834d();
        return m0Var;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo6417e(C1454x xVar) {
        int f = C1437s.m5611f(xVar.mo6830b(), "id");
        View remove = this.f3361g.remove(Integer.valueOf(f));
        C1432q remove2 = this.f3359e.remove(Integer.valueOf(f));
        if (remove == null || remove2 == null) {
            C1222d b = C1199a.m4880c().mo6530b();
            String c = xVar.mo6833c();
            b.mo6457a(c, "" + f);
            return false;
        }
        removeView(remove2);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean mo6419f(C1454x xVar) {
        TextView textView;
        int f = C1437s.m5611f(xVar.mo6830b(), "id");
        View remove = this.f3361g.remove(Integer.valueOf(f));
        if (this.f3360f.remove(Integer.valueOf(f)).booleanValue()) {
            textView = this.f3358d.remove(Integer.valueOf(f));
        } else {
            textView = this.f3356b.remove(Integer.valueOf(f));
        }
        if (remove == null || textView == null) {
            C1222d b = C1199a.m4880c().mo6530b();
            String c = xVar.mo6833c();
            b.mo6457a(c, "" + f);
            return false;
        }
        removeView(textView);
        return true;
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"InlinedApi"})
    /* renamed from: b */
    public View mo6407b(C1454x xVar) {
        JSONObject b = xVar.mo6830b();
        int f = C1437s.m5611f(b, "id");
        if (C1437s.m5608d(b, "editable")) {
            C1396n nVar = new C1396n(this.f3380z, xVar, f, this);
            nVar.mo6760a();
            this.f3358d.put(Integer.valueOf(f), nVar);
            this.f3361g.put(Integer.valueOf(f), nVar);
            this.f3360f.put(Integer.valueOf(f), Boolean.TRUE);
            return nVar;
        } else if (!C1437s.m5608d(b, "button")) {
            C1342j0 j0Var = new C1342j0(this.f3380z, xVar, f, this);
            j0Var.mo6650a();
            this.f3356b.put(Integer.valueOf(f), j0Var);
            this.f3361g.put(Integer.valueOf(f), j0Var);
            this.f3360f.put(Integer.valueOf(f), Boolean.FALSE);
            return j0Var;
        } else {
            C1342j0 j0Var2 = new C1342j0(this.f3380z, 16974145, xVar, f, this);
            j0Var2.mo6650a();
            this.f3356b.put(Integer.valueOf(f), j0Var2);
            this.f3361g.put(Integer.valueOf(f), j0Var2);
            this.f3360f.put(Integer.valueOf(f), Boolean.FALSE);
            return j0Var2;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public ArrayList<C1458z> mo6424i() {
        return this.f3374t;
    }

    C1205c(Context context, String str) {
        super(context);
        this.f3380z = context;
        this.f3366l = str;
        setBackgroundColor(-16777216);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo6410c() {
        return this.f3364j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public HashMap<Integer, View> mo6416e() {
        return this.f3361g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1432q mo6399a(C1454x xVar) {
        int f = C1437s.m5611f(xVar.mo6830b(), "id");
        C1432q qVar = new C1432q(this.f3380z, xVar, f, this);
        qVar.mo6790a();
        this.f3359e.put(Integer.valueOf(f), qVar);
        this.f3361g.put(Integer.valueOf(f), qVar);
        return qVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo6412c(boolean z) {
        this.f3378x = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public HashMap<Integer, C1432q> mo6422h() {
        return this.f3359e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public HashMap<Integer, C1396n> mo6418f() {
        return this.f3358d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public HashMap<Integer, Boolean> mo6420g() {
        return this.f3360f;
    }

    /* renamed from: a */
    private void m4908a(boolean z) {
        new Thread(new C1206a(new C1217j(z))).start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m4905a(int i, int i2, C1379m0 m0Var) {
        float n = C1199a.m4880c().mo6542h().mo6630n();
        if (m0Var != null) {
            JSONObject b = C1437s.m5599b();
            C1437s.m5602b(b, "app_orientation", C1359k0.m5331f(C1359k0.m5332g()));
            C1437s.m5602b(b, "width", (int) (((float) m0Var.mo6720j()) / n));
            C1437s.m5602b(b, "height", (int) (((float) m0Var.mo6719i()) / n));
            C1437s.m5602b(b, "x", i);
            C1437s.m5602b(b, "y", i2);
            C1437s.m5592a(b, "ad_session_id", this.f3366l);
            new C1454x("MRAID.on_size_change", this.f3365k, b).mo6834d();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo6406b() {
        return this.f3363i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo6408b(int i) {
        this.f3362h = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo6409b(boolean z) {
        this.f3376v = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo6413d() {
        return this.f3362h;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m4904a(float f, double d) {
        JSONObject b = C1437s.m5599b();
        C1437s.m5602b(b, "id", this.f3364j);
        C1437s.m5592a(b, "ad_session_id", this.f3366l);
        C1437s.m5590a(b, "exposure", (double) f);
        C1437s.m5590a(b, "volume", d);
        new C1454x("AdContainer.on_exposure_change", this.f3365k, b).mo6834d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo6415d(boolean z) {
        this.f3377w = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo6400a() {
        return this.f3366l;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6401a(int i) {
        this.f3363i = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6404a(AdSession adSession) {
        this.f3379y = adSession;
        mo6405a((Map) this.f3361g);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6405a(Map map) {
        if (this.f3379y != null && map != null) {
            for (Map.Entry value : map.entrySet()) {
                mo6403a((View) value.getValue(), FriendlyObstructionPurpose.OTHER);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6403a(View view, FriendlyObstructionPurpose friendlyObstructionPurpose) {
        AdSession adSession = this.f3379y;
        if (adSession != null && view != null) {
            try {
                adSession.addFriendlyObstruction(view, friendlyObstructionPurpose, (String) null);
            } catch (RuntimeException unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6402a(View view) {
        AdSession adSession = this.f3379y;
        if (adSession != null && view != null) {
            try {
                adSession.removeFriendlyObstruction(view);
            } catch (RuntimeException unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public ArrayList<String> mo6426j() {
        return this.f3375u;
    }
}
