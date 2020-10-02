package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.tapjoy.TJAdUnitConstants;
import org.json.JSONObject;

@SuppressLint({"AppCompatCustomView"})
/* renamed from: com.adcolony.sdk.n */
class C1396n extends EditText {

    /* renamed from: A */
    private C1205c f4406A;

    /* renamed from: B */
    private C1454x f4407B;

    /* renamed from: a */
    private final int f4408a = 0;

    /* renamed from: b */
    private final int f4409b = 1;

    /* renamed from: c */
    private final int f4410c = 2;

    /* renamed from: d */
    private final int f4411d = 3;

    /* renamed from: e */
    private final int f4412e = 1;

    /* renamed from: f */
    private final int f4413f = 2;

    /* renamed from: g */
    private final int f4414g = 3;

    /* renamed from: h */
    private final int f4415h = 0;

    /* renamed from: i */
    private final int f4416i = 1;

    /* renamed from: j */
    private final int f4417j = 2;

    /* renamed from: k */
    private final int f4418k = 1;

    /* renamed from: l */
    private final int f4419l = 2;

    /* renamed from: m */
    private int f4420m;

    /* renamed from: n */
    private int f4421n;

    /* renamed from: o */
    private int f4422o;

    /* renamed from: p */
    private int f4423p;

    /* renamed from: q */
    private int f4424q;

    /* renamed from: r */
    private int f4425r;

    /* renamed from: s */
    private int f4426s;

    /* renamed from: t */
    private int f4427t;

    /* renamed from: u */
    private int f4428u;

    /* renamed from: v */
    private int f4429v;

    /* renamed from: w */
    private String f4430w;

    /* renamed from: x */
    private String f4431x;

    /* renamed from: y */
    private String f4432y;

    /* renamed from: z */
    private String f4433z;

    /* renamed from: com.adcolony.sdk.n$a */
    class C1397a implements C1458z {
        C1397a() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            if (C1396n.this.mo6763c(xVar)) {
                C1396n.this.mo6761a(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.n$b */
    class C1398b implements C1458z {
        C1398b() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            if (C1396n.this.mo6763c(xVar)) {
                C1396n.this.mo6771k(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.n$c */
    class C1399c implements C1458z {
        C1399c() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            if (C1396n.this.mo6763c(xVar)) {
                C1396n.this.mo6765e(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.n$d */
    class C1400d implements C1458z {
        C1400d() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            if (C1396n.this.mo6763c(xVar)) {
                C1396n.this.mo6766f(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.n$e */
    class C1401e implements C1458z {
        C1401e() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            if (C1396n.this.mo6763c(xVar)) {
                C1396n.this.mo6764d(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.n$f */
    class C1402f implements C1458z {
        C1402f() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            if (C1396n.this.mo6763c(xVar)) {
                C1396n.this.mo6770j(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.n$g */
    class C1403g implements C1458z {
        C1403g() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            if (C1396n.this.mo6763c(xVar)) {
                C1396n.this.mo6767g(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.n$h */
    class C1404h implements C1458z {
        C1404h() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            if (C1396n.this.mo6763c(xVar)) {
                C1396n.this.mo6768h(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.n$i */
    class C1405i implements C1458z {
        C1405i() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            if (C1396n.this.mo6763c(xVar)) {
                C1396n.this.mo6762b(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.n$j */
    class C1406j implements C1458z {
        C1406j() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            if (C1396n.this.mo6763c(xVar)) {
                C1396n.this.mo6769i(xVar);
            }
        }
    }

    private C1396n(Context context) {
        super(context);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo6759a(boolean z, int i) {
        if (i == 0) {
            return z ? 1 : 16;
        }
        if (i == 1) {
            return z ? 8388611 : 48;
        }
        if (i != 2) {
            return 17;
        }
        return z ? 8388613 : 80;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6761a(C1454x xVar) {
        JSONObject b = xVar.mo6830b();
        this.f4428u = C1437s.m5611f(b, "x");
        this.f4429v = C1437s.m5611f(b, "y");
        setGravity(mo6759a(true, this.f4428u) | mo6759a(false, this.f4429v));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo6762b(C1454x xVar) {
        JSONObject b = C1437s.m5599b();
        C1437s.m5592a(b, ViewHierarchyConstants.TEXT_KEY, getText().toString());
        xVar.mo6829a(b).mo6834d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo6763c(C1454x xVar) {
        JSONObject b = xVar.mo6830b();
        return C1437s.m5611f(b, "id") == this.f4420m && C1437s.m5611f(b, "container_id") == this.f4406A.mo6410c() && C1437s.m5613h(b, "ad_session_id").equals(this.f4406A.mo6400a());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo6764d(C1454x xVar) {
        String h = C1437s.m5613h(xVar.mo6830b(), "background_color");
        this.f4431x = h;
        setBackgroundColor(C1359k0.m5334h(h));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo6765e(C1454x xVar) {
        JSONObject b = xVar.mo6830b();
        this.f4421n = C1437s.m5611f(b, "x");
        this.f4422o = C1437s.m5611f(b, "y");
        this.f4423p = C1437s.m5611f(b, "width");
        this.f4424q = C1437s.m5611f(b, "height");
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.setMargins(this.f4421n, this.f4422o, 0, 0);
        layoutParams.width = this.f4423p;
        layoutParams.height = this.f4424q;
        setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo6766f(C1454x xVar) {
        String h = C1437s.m5613h(xVar.mo6830b(), "font_color");
        this.f4432y = h;
        setTextColor(C1359k0.m5334h(h));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo6767g(C1454x xVar) {
        int f = C1437s.m5611f(xVar.mo6830b(), ViewHierarchyConstants.TEXT_SIZE);
        this.f4427t = f;
        setTextSize((float) f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo6768h(C1454x xVar) {
        int f = C1437s.m5611f(xVar.mo6830b(), "font_style");
        this.f4425r = f;
        if (f == 0) {
            setTypeface(getTypeface(), 0);
        } else if (f == 1) {
            setTypeface(getTypeface(), 1);
        } else if (f == 2) {
            setTypeface(getTypeface(), 2);
        } else if (f == 3) {
            setTypeface(getTypeface(), 3);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo6769i(C1454x xVar) {
        String h = C1437s.m5613h(xVar.mo6830b(), ViewHierarchyConstants.TEXT_KEY);
        this.f4433z = h;
        setText(h);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo6770j(C1454x xVar) {
        int f = C1437s.m5611f(xVar.mo6830b(), "font_family");
        this.f4426s = f;
        if (f == 0) {
            setTypeface(Typeface.DEFAULT);
        } else if (f == 1) {
            setTypeface(Typeface.SERIF);
        } else if (f == 2) {
            setTypeface(Typeface.SANS_SERIF);
        } else if (f == 3) {
            setTypeface(Typeface.MONOSPACE);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public void mo6771k(C1454x xVar) {
        if (C1437s.m5608d(xVar.mo6830b(), TJAdUnitConstants.String.VISIBLE)) {
            setVisibility(0);
        } else {
            setVisibility(4);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        C1290h c = C1199a.m4880c();
        C1222d b = c.mo6530b();
        int action = motionEvent.getAction() & 255;
        if (action != 0 && action != 1 && action != 3 && action != 2 && action != 5 && action != 6) {
            return false;
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        JSONObject b2 = C1437s.m5599b();
        C1437s.m5602b(b2, "view_id", this.f4420m);
        C1437s.m5592a(b2, "ad_session_id", this.f4430w);
        C1437s.m5602b(b2, "container_x", this.f4421n + x);
        C1437s.m5602b(b2, "container_y", this.f4422o + y);
        C1437s.m5602b(b2, "view_x", x);
        C1437s.m5602b(b2, "view_y", y);
        C1437s.m5602b(b2, "id", this.f4406A.mo6410c());
        if (action == 0) {
            new C1454x("AdContainer.on_touch_began", this.f4406A.mo6428k(), b2).mo6834d();
        } else if (action == 1) {
            if (!this.f4406A.mo6435p()) {
                c.mo6521a(b.mo6458b().get(this.f4430w));
            }
            new C1454x("AdContainer.on_touch_ended", this.f4406A.mo6428k(), b2).mo6834d();
        } else if (action == 2) {
            new C1454x("AdContainer.on_touch_moved", this.f4406A.mo6428k(), b2).mo6834d();
        } else if (action == 3) {
            new C1454x("AdContainer.on_touch_cancelled", this.f4406A.mo6428k(), b2).mo6834d();
        } else if (action == 5) {
            int action2 = (motionEvent.getAction() & 65280) >> 8;
            C1437s.m5602b(b2, "container_x", ((int) motionEvent2.getX(action2)) + this.f4421n);
            C1437s.m5602b(b2, "container_y", ((int) motionEvent2.getY(action2)) + this.f4422o);
            C1437s.m5602b(b2, "view_x", (int) motionEvent2.getX(action2));
            C1437s.m5602b(b2, "view_y", (int) motionEvent2.getY(action2));
            new C1454x("AdContainer.on_touch_began", this.f4406A.mo6428k(), b2).mo6834d();
        } else if (action == 6) {
            int action3 = (motionEvent.getAction() & 65280) >> 8;
            C1437s.m5602b(b2, "container_x", ((int) motionEvent2.getX(action3)) + this.f4421n);
            C1437s.m5602b(b2, "container_y", ((int) motionEvent2.getY(action3)) + this.f4422o);
            C1437s.m5602b(b2, "view_x", (int) motionEvent2.getX(action3));
            C1437s.m5602b(b2, "view_y", (int) motionEvent2.getY(action3));
            if (!this.f4406A.mo6435p()) {
                c.mo6521a(b.mo6458b().get(this.f4430w));
            }
            new C1454x("AdContainer.on_touch_ended", this.f4406A.mo6428k(), b2).mo6834d();
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6760a() {
        JSONObject b = this.f4407B.mo6830b();
        this.f4430w = C1437s.m5613h(b, "ad_session_id");
        this.f4421n = C1437s.m5611f(b, "x");
        this.f4422o = C1437s.m5611f(b, "y");
        this.f4423p = C1437s.m5611f(b, "width");
        this.f4424q = C1437s.m5611f(b, "height");
        this.f4426s = C1437s.m5611f(b, "font_family");
        this.f4425r = C1437s.m5611f(b, "font_style");
        this.f4427t = C1437s.m5611f(b, ViewHierarchyConstants.TEXT_SIZE);
        this.f4431x = C1437s.m5613h(b, "background_color");
        this.f4432y = C1437s.m5613h(b, "font_color");
        this.f4433z = C1437s.m5613h(b, ViewHierarchyConstants.TEXT_KEY);
        this.f4428u = C1437s.m5611f(b, "align_x");
        this.f4429v = C1437s.m5611f(b, "align_y");
        setVisibility(4);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f4423p, this.f4424q);
        layoutParams.setMargins(this.f4421n, this.f4422o, 0, 0);
        layoutParams.gravity = 0;
        this.f4406A.addView(this, layoutParams);
        int i = this.f4426s;
        if (i == 0) {
            setTypeface(Typeface.DEFAULT);
        } else if (i == 1) {
            setTypeface(Typeface.SERIF);
        } else if (i == 2) {
            setTypeface(Typeface.SANS_SERIF);
        } else if (i == 3) {
            setTypeface(Typeface.MONOSPACE);
        }
        int i2 = this.f4425r;
        if (i2 == 0) {
            setTypeface(getTypeface(), 0);
        } else if (i2 == 1) {
            setTypeface(getTypeface(), 1);
        } else if (i2 == 2) {
            setTypeface(getTypeface(), 2);
        } else if (i2 == 3) {
            setTypeface(getTypeface(), 3);
        }
        setText(this.f4433z);
        setTextSize((float) this.f4427t);
        setGravity(mo6759a(true, this.f4428u) | mo6759a(false, this.f4429v));
        if (!this.f4431x.equals("")) {
            setBackgroundColor(C1359k0.m5334h(this.f4431x));
        }
        if (!this.f4432y.equals("")) {
            setTextColor(C1359k0.m5334h(this.f4432y));
        }
        this.f4406A.mo6424i().add(C1199a.m4873a("TextView.set_visible", (C1458z) new C1398b(), true));
        this.f4406A.mo6424i().add(C1199a.m4873a("TextView.set_bounds", (C1458z) new C1399c(), true));
        this.f4406A.mo6424i().add(C1199a.m4873a("TextView.set_font_color", (C1458z) new C1400d(), true));
        this.f4406A.mo6424i().add(C1199a.m4873a("TextView.set_background_color", (C1458z) new C1401e(), true));
        this.f4406A.mo6424i().add(C1199a.m4873a("TextView.set_typeface", (C1458z) new C1402f(), true));
        this.f4406A.mo6424i().add(C1199a.m4873a("TextView.set_font_size", (C1458z) new C1403g(), true));
        this.f4406A.mo6424i().add(C1199a.m4873a("TextView.set_font_style", (C1458z) new C1404h(), true));
        this.f4406A.mo6424i().add(C1199a.m4873a("TextView.get_text", (C1458z) new C1405i(), true));
        this.f4406A.mo6424i().add(C1199a.m4873a("TextView.set_text", (C1458z) new C1406j(), true));
        this.f4406A.mo6424i().add(C1199a.m4873a("TextView.align", (C1458z) new C1397a(), true));
        this.f4406A.mo6426j().add("TextView.set_visible");
        this.f4406A.mo6426j().add("TextView.set_bounds");
        this.f4406A.mo6426j().add("TextView.set_font_color");
        this.f4406A.mo6426j().add("TextView.set_background_color");
        this.f4406A.mo6426j().add("TextView.set_typeface");
        this.f4406A.mo6426j().add("TextView.set_font_size");
        this.f4406A.mo6426j().add("TextView.set_font_style");
        this.f4406A.mo6426j().add("TextView.get_text");
        this.f4406A.mo6426j().add("TextView.set_text");
        this.f4406A.mo6426j().add("TextView.align");
    }

    C1396n(Context context, C1454x xVar, int i, C1205c cVar) {
        super(context);
        this.f4420m = i;
        this.f4407B = xVar;
        this.f4406A = cVar;
    }
}
