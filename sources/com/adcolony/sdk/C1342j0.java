package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.FrameLayout;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.tapjoy.TJAdUnitConstants;
import org.json.JSONObject;

@SuppressLint({"AppCompatCustomView"})
/* renamed from: com.adcolony.sdk.j0 */
class C1342j0 extends Button {

    /* renamed from: A */
    private C1205c f4207A;

    /* renamed from: B */
    private C1454x f4208B;

    /* renamed from: a */
    private final int f4209a = 0;

    /* renamed from: b */
    private final int f4210b = 1;

    /* renamed from: c */
    private final int f4211c = 2;

    /* renamed from: d */
    private final int f4212d = 3;

    /* renamed from: e */
    private final int f4213e = 1;

    /* renamed from: f */
    private final int f4214f = 2;

    /* renamed from: g */
    private final int f4215g = 3;

    /* renamed from: h */
    private final int f4216h = 0;

    /* renamed from: i */
    private final int f4217i = 1;

    /* renamed from: j */
    private final int f4218j = 2;

    /* renamed from: k */
    private final int f4219k = 1;

    /* renamed from: l */
    private final int f4220l = 2;

    /* renamed from: m */
    private int f4221m;

    /* renamed from: n */
    private int f4222n;

    /* renamed from: o */
    private int f4223o;

    /* renamed from: p */
    private int f4224p;

    /* renamed from: q */
    private int f4225q;

    /* renamed from: r */
    private int f4226r;

    /* renamed from: s */
    private int f4227s;

    /* renamed from: t */
    private int f4228t;

    /* renamed from: u */
    private int f4229u;

    /* renamed from: v */
    private int f4230v;

    /* renamed from: w */
    private String f4231w;

    /* renamed from: x */
    private String f4232x;

    /* renamed from: y */
    private String f4233y;

    /* renamed from: z */
    private String f4234z;

    /* renamed from: com.adcolony.sdk.j0$a */
    class C1343a implements C1458z {
        C1343a() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            if (C1342j0.this.mo6653c(xVar)) {
                C1342j0.this.mo6651a(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.j0$b */
    class C1344b implements C1458z {
        C1344b() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            if (C1342j0.this.mo6653c(xVar)) {
                C1342j0.this.mo6661k(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.j0$c */
    class C1345c implements C1458z {
        C1345c() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            if (C1342j0.this.mo6653c(xVar)) {
                C1342j0.this.mo6655e(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.j0$d */
    class C1346d implements C1458z {
        C1346d() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            if (C1342j0.this.mo6653c(xVar)) {
                C1342j0.this.mo6656f(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.j0$e */
    class C1347e implements C1458z {
        C1347e() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            if (C1342j0.this.mo6653c(xVar)) {
                C1342j0.this.mo6654d(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.j0$f */
    class C1348f implements C1458z {
        C1348f() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            if (C1342j0.this.mo6653c(xVar)) {
                C1342j0.this.mo6660j(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.j0$g */
    class C1349g implements C1458z {
        C1349g() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            if (C1342j0.this.mo6653c(xVar)) {
                C1342j0.this.mo6657g(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.j0$h */
    class C1350h implements C1458z {
        C1350h() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            if (C1342j0.this.mo6653c(xVar)) {
                C1342j0.this.mo6658h(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.j0$i */
    class C1351i implements C1458z {
        C1351i() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            if (C1342j0.this.mo6653c(xVar)) {
                C1342j0.this.mo6652b(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.j0$j */
    class C1352j implements C1458z {
        C1352j() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            if (C1342j0.this.mo6653c(xVar)) {
                C1342j0.this.mo6659i(xVar);
            }
        }
    }

    private C1342j0(Context context) {
        super(context);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo6649a(boolean z, int i) {
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
    public void mo6651a(C1454x xVar) {
        JSONObject b = xVar.mo6830b();
        this.f4229u = C1437s.m5611f(b, "x");
        this.f4230v = C1437s.m5611f(b, "y");
        setGravity(mo6649a(true, this.f4229u) | mo6649a(false, this.f4230v));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo6652b(C1454x xVar) {
        JSONObject b = C1437s.m5599b();
        C1437s.m5592a(b, ViewHierarchyConstants.TEXT_KEY, getText().toString());
        xVar.mo6829a(b).mo6834d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo6653c(C1454x xVar) {
        JSONObject b = xVar.mo6830b();
        return C1437s.m5611f(b, "id") == this.f4221m && C1437s.m5611f(b, "container_id") == this.f4207A.mo6410c() && C1437s.m5613h(b, "ad_session_id").equals(this.f4207A.mo6400a());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo6654d(C1454x xVar) {
        String h = C1437s.m5613h(xVar.mo6830b(), "background_color");
        this.f4231w = h;
        setBackgroundColor(C1359k0.m5334h(h));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo6655e(C1454x xVar) {
        JSONObject b = xVar.mo6830b();
        this.f4222n = C1437s.m5611f(b, "x");
        this.f4223o = C1437s.m5611f(b, "y");
        this.f4224p = C1437s.m5611f(b, "width");
        this.f4225q = C1437s.m5611f(b, "height");
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.setMargins(this.f4222n, this.f4223o, 0, 0);
        layoutParams.width = this.f4224p;
        layoutParams.height = this.f4225q;
        setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo6656f(C1454x xVar) {
        String h = C1437s.m5613h(xVar.mo6830b(), "font_color");
        this.f4232x = h;
        setTextColor(C1359k0.m5334h(h));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo6657g(C1454x xVar) {
        int f = C1437s.m5611f(xVar.mo6830b(), ViewHierarchyConstants.TEXT_SIZE);
        this.f4228t = f;
        setTextSize((float) f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo6658h(C1454x xVar) {
        int f = C1437s.m5611f(xVar.mo6830b(), "font_style");
        this.f4226r = f;
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
    public void mo6659i(C1454x xVar) {
        String h = C1437s.m5613h(xVar.mo6830b(), ViewHierarchyConstants.TEXT_KEY);
        this.f4233y = h;
        setText(h);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo6660j(C1454x xVar) {
        int f = C1437s.m5611f(xVar.mo6830b(), "font_family");
        this.f4227s = f;
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
    public void mo6661k(C1454x xVar) {
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
        C1437s.m5602b(b2, "view_id", this.f4221m);
        C1437s.m5592a(b2, "ad_session_id", this.f4234z);
        C1437s.m5602b(b2, "container_x", this.f4222n + x);
        C1437s.m5602b(b2, "container_y", this.f4223o + y);
        C1437s.m5602b(b2, "view_x", x);
        C1437s.m5602b(b2, "view_y", y);
        C1437s.m5602b(b2, "id", this.f4207A.getId());
        if (action != 0) {
            int i = y;
            if (action == 1) {
                if (!this.f4207A.mo6435p()) {
                    c.mo6521a(b.mo6458b().get(this.f4234z));
                }
                if (x <= 0 || x >= getWidth() || i <= 0 || i >= getHeight()) {
                    new C1454x("AdContainer.on_touch_cancelled", this.f4207A.mo6428k(), b2).mo6834d();
                    return true;
                }
                new C1454x("AdContainer.on_touch_ended", this.f4207A.mo6428k(), b2).mo6834d();
                return true;
            } else if (action == 2) {
                new C1454x("AdContainer.on_touch_moved", this.f4207A.mo6428k(), b2).mo6834d();
                return true;
            } else if (action == 3) {
                new C1454x("AdContainer.on_touch_cancelled", this.f4207A.mo6428k(), b2).mo6834d();
                return true;
            } else if (action == 5) {
                int action2 = (motionEvent.getAction() & 65280) >> 8;
                C1437s.m5602b(b2, "container_x", ((int) motionEvent2.getX(action2)) + this.f4222n);
                C1437s.m5602b(b2, "container_y", ((int) motionEvent2.getY(action2)) + this.f4223o);
                C1437s.m5602b(b2, "view_x", (int) motionEvent2.getX(action2));
                C1437s.m5602b(b2, "view_y", (int) motionEvent2.getY(action2));
                new C1454x("AdContainer.on_touch_began", this.f4207A.mo6428k(), b2).mo6834d();
                return true;
            } else if (action != 6) {
                return true;
            } else {
                int action3 = (motionEvent.getAction() & 65280) >> 8;
                int x2 = (int) motionEvent2.getX(action3);
                int y2 = (int) motionEvent2.getY(action3);
                C1437s.m5602b(b2, "container_x", ((int) motionEvent2.getX(action3)) + this.f4222n);
                C1437s.m5602b(b2, "container_y", ((int) motionEvent2.getY(action3)) + this.f4223o);
                C1437s.m5602b(b2, "view_x", (int) motionEvent2.getX(action3));
                C1437s.m5602b(b2, "view_y", (int) motionEvent2.getY(action3));
                if (!this.f4207A.mo6435p()) {
                    c.mo6521a(b.mo6458b().get(this.f4234z));
                }
                if (x2 <= 0 || x2 >= getWidth() || y2 <= 0 || y2 >= getHeight()) {
                    new C1454x("AdContainer.on_touch_cancelled", this.f4207A.mo6428k(), b2).mo6834d();
                    return true;
                }
                new C1454x("AdContainer.on_touch_ended", this.f4207A.mo6428k(), b2).mo6834d();
                return true;
            }
        } else {
            new C1454x("AdContainer.on_touch_began", this.f4207A.mo6428k(), b2).mo6834d();
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6650a() {
        int i;
        int i2;
        JSONObject b = this.f4208B.mo6830b();
        this.f4234z = C1437s.m5613h(b, "ad_session_id");
        this.f4222n = C1437s.m5611f(b, "x");
        this.f4223o = C1437s.m5611f(b, "y");
        this.f4224p = C1437s.m5611f(b, "width");
        this.f4225q = C1437s.m5611f(b, "height");
        this.f4227s = C1437s.m5611f(b, "font_family");
        this.f4226r = C1437s.m5611f(b, "font_style");
        this.f4228t = C1437s.m5611f(b, ViewHierarchyConstants.TEXT_SIZE);
        this.f4231w = C1437s.m5613h(b, "background_color");
        this.f4232x = C1437s.m5613h(b, "font_color");
        this.f4233y = C1437s.m5613h(b, ViewHierarchyConstants.TEXT_KEY);
        this.f4229u = C1437s.m5611f(b, "align_x");
        this.f4230v = C1437s.m5611f(b, "align_y");
        C1290h c = C1199a.m4880c();
        if (this.f4233y.equals("")) {
            this.f4233y = "Learn More";
        }
        setVisibility(4);
        FrameLayout.LayoutParams layoutParams = C1437s.m5608d(b, "wrap_content") ? new FrameLayout.LayoutParams(-2, -2) : new FrameLayout.LayoutParams(this.f4224p, this.f4225q);
        layoutParams.gravity = 0;
        setText(this.f4233y);
        setTextSize((float) this.f4228t);
        if (C1437s.m5608d(b, "overlay")) {
            this.f4222n = 0;
            this.f4223o = 0;
            i2 = (int) (c.mo6542h().mo6630n() * 6.0f);
            i = (int) (c.mo6542h().mo6630n() * 6.0f);
            int n = (int) (c.mo6542h().mo6630n() * 4.0f);
            setPadding(n, n, n, n);
            layoutParams.gravity = 8388693;
        } else {
            i2 = 0;
            i = 0;
        }
        layoutParams.setMargins(this.f4222n, this.f4223o, i2, i);
        this.f4207A.addView(this, layoutParams);
        int i3 = this.f4227s;
        if (i3 == 0) {
            setTypeface(Typeface.DEFAULT);
        } else if (i3 == 1) {
            setTypeface(Typeface.SERIF);
        } else if (i3 == 2) {
            setTypeface(Typeface.SANS_SERIF);
        } else if (i3 == 3) {
            setTypeface(Typeface.MONOSPACE);
        }
        int i4 = this.f4226r;
        if (i4 == 0) {
            setTypeface(getTypeface(), 0);
        } else if (i4 == 1) {
            setTypeface(getTypeface(), 1);
        } else if (i4 == 2) {
            setTypeface(getTypeface(), 2);
        } else if (i4 == 3) {
            setTypeface(getTypeface(), 3);
        }
        setGravity(mo6649a(true, this.f4229u) | mo6649a(false, this.f4230v));
        if (!this.f4231w.equals("")) {
            setBackgroundColor(C1359k0.m5334h(this.f4231w));
        }
        if (!this.f4232x.equals("")) {
            setTextColor(C1359k0.m5334h(this.f4232x));
        }
        this.f4207A.mo6424i().add(C1199a.m4873a("TextView.set_visible", (C1458z) new C1344b(), true));
        this.f4207A.mo6424i().add(C1199a.m4873a("TextView.set_bounds", (C1458z) new C1345c(), true));
        this.f4207A.mo6424i().add(C1199a.m4873a("TextView.set_font_color", (C1458z) new C1346d(), true));
        this.f4207A.mo6424i().add(C1199a.m4873a("TextView.set_background_color", (C1458z) new C1347e(), true));
        this.f4207A.mo6424i().add(C1199a.m4873a("TextView.set_typeface", (C1458z) new C1348f(), true));
        this.f4207A.mo6424i().add(C1199a.m4873a("TextView.set_font_size", (C1458z) new C1349g(), true));
        this.f4207A.mo6424i().add(C1199a.m4873a("TextView.set_font_style", (C1458z) new C1350h(), true));
        this.f4207A.mo6424i().add(C1199a.m4873a("TextView.get_text", (C1458z) new C1351i(), true));
        this.f4207A.mo6424i().add(C1199a.m4873a("TextView.set_text", (C1458z) new C1352j(), true));
        this.f4207A.mo6424i().add(C1199a.m4873a("TextView.align", (C1458z) new C1343a(), true));
        this.f4207A.mo6426j().add("TextView.set_visible");
        this.f4207A.mo6426j().add("TextView.set_bounds");
        this.f4207A.mo6426j().add("TextView.set_font_color");
        this.f4207A.mo6426j().add("TextView.set_background_color");
        this.f4207A.mo6426j().add("TextView.set_typeface");
        this.f4207A.mo6426j().add("TextView.set_font_size");
        this.f4207A.mo6426j().add("TextView.set_font_style");
        this.f4207A.mo6426j().add("TextView.get_text");
        this.f4207A.mo6426j().add("TextView.set_text");
        this.f4207A.mo6426j().add("TextView.align");
    }

    C1342j0(Context context, C1454x xVar, int i, C1205c cVar) {
        super(context);
        this.f4221m = i;
        this.f4208B = xVar;
        this.f4207A = cVar;
    }

    C1342j0(Context context, int i, C1454x xVar, int i2, C1205c cVar) {
        super(context, (AttributeSet) null, i);
        this.f4221m = i2;
        this.f4208B = xVar;
        this.f4207A = cVar;
    }
}
