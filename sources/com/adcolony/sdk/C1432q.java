package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tapjoy.TJAdUnitConstants;
import java.io.File;
import org.json.JSONObject;

@SuppressLint({"AppCompatCustomView"})
/* renamed from: com.adcolony.sdk.q */
class C1432q extends ImageView {

    /* renamed from: a */
    private int f4490a;

    /* renamed from: b */
    private int f4491b;

    /* renamed from: c */
    private int f4492c;

    /* renamed from: d */
    private int f4493d;

    /* renamed from: e */
    private int f4494e;

    /* renamed from: f */
    private boolean f4495f;

    /* renamed from: g */
    private boolean f4496g;

    /* renamed from: h */
    private boolean f4497h;

    /* renamed from: i */
    private String f4498i;

    /* renamed from: j */
    private String f4499j;

    /* renamed from: k */
    private C1454x f4500k;

    /* renamed from: l */
    private C1205c f4501l;

    /* renamed from: com.adcolony.sdk.q$a */
    class C1433a implements C1458z {
        C1433a() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            if (C1432q.this.m5563a(xVar)) {
                C1432q.this.m5569d(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.q$b */
    class C1434b implements C1458z {
        C1434b() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            if (C1432q.this.m5563a(xVar)) {
                C1432q.this.m5565b(xVar);
            }
        }
    }

    /* renamed from: com.adcolony.sdk.q$c */
    class C1435c implements C1458z {
        C1435c() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            if (C1432q.this.m5563a(xVar)) {
                C1432q.this.m5567c(xVar);
            }
        }
    }

    private C1432q(Context context) {
        super(context);
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
        C1437s.m5602b(b2, "view_id", this.f4490a);
        C1437s.m5592a(b2, "ad_session_id", this.f4499j);
        C1437s.m5602b(b2, "container_x", this.f4491b + x);
        C1437s.m5602b(b2, "container_y", this.f4492c + y);
        C1437s.m5602b(b2, "view_x", x);
        C1437s.m5602b(b2, "view_y", y);
        C1437s.m5602b(b2, "id", this.f4501l.getId());
        if (action != 0) {
            int i = y;
            if (action == 1) {
                if (!this.f4501l.mo6435p()) {
                    c.mo6521a(b.mo6458b().get(this.f4499j));
                }
                if (x <= 0 || x >= this.f4493d || i <= 0 || i >= this.f4494e) {
                    new C1454x("AdContainer.on_touch_cancelled", this.f4501l.mo6428k(), b2).mo6834d();
                    return true;
                }
                new C1454x("AdContainer.on_touch_ended", this.f4501l.mo6428k(), b2).mo6834d();
                return true;
            } else if (action == 2) {
                new C1454x("AdContainer.on_touch_moved", this.f4501l.mo6428k(), b2).mo6834d();
                return true;
            } else if (action == 3) {
                new C1454x("AdContainer.on_touch_cancelled", this.f4501l.mo6428k(), b2).mo6834d();
                return true;
            } else if (action == 5) {
                int action2 = (motionEvent.getAction() & 65280) >> 8;
                C1437s.m5602b(b2, "container_x", ((int) motionEvent2.getX(action2)) + this.f4491b);
                C1437s.m5602b(b2, "container_y", ((int) motionEvent2.getY(action2)) + this.f4492c);
                C1437s.m5602b(b2, "view_x", (int) motionEvent2.getX(action2));
                C1437s.m5602b(b2, "view_y", (int) motionEvent2.getY(action2));
                new C1454x("AdContainer.on_touch_began", this.f4501l.mo6428k(), b2).mo6834d();
                return true;
            } else if (action != 6) {
                return true;
            } else {
                int action3 = (motionEvent.getAction() & 65280) >> 8;
                int x2 = (int) motionEvent2.getX(action3);
                int y2 = (int) motionEvent2.getY(action3);
                C1437s.m5602b(b2, "container_x", ((int) motionEvent2.getX(action3)) + this.f4491b);
                C1437s.m5602b(b2, "container_y", ((int) motionEvent2.getY(action3)) + this.f4492c);
                C1437s.m5602b(b2, "view_x", (int) motionEvent2.getX(action3));
                C1437s.m5602b(b2, "view_y", (int) motionEvent2.getY(action3));
                if (!this.f4501l.mo6435p()) {
                    c.mo6521a(b.mo6458b().get(this.f4499j));
                }
                if (x2 <= 0 || x2 >= this.f4493d || y2 <= 0 || y2 >= this.f4494e) {
                    new C1454x("AdContainer.on_touch_cancelled", this.f4501l.mo6428k(), b2).mo6834d();
                    return true;
                }
                new C1454x("AdContainer.on_touch_ended", this.f4501l.mo6428k(), b2).mo6834d();
                return true;
            }
        } else {
            new C1454x("AdContainer.on_touch_began", this.f4501l.mo6428k(), b2).mo6834d();
            return true;
        }
    }

    C1432q(Context context, C1454x xVar, int i, C1205c cVar) {
        super(context);
        this.f4490a = i;
        this.f4500k = xVar;
        this.f4501l = cVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m5563a(C1454x xVar) {
        JSONObject b = xVar.mo6830b();
        return C1437s.m5611f(b, "id") == this.f4490a && C1437s.m5611f(b, "container_id") == this.f4501l.mo6410c() && C1437s.m5613h(b, "ad_session_id").equals(this.f4501l.mo6400a());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m5565b(C1454x xVar) {
        JSONObject b = xVar.mo6830b();
        this.f4491b = C1437s.m5611f(b, "x");
        this.f4492c = C1437s.m5611f(b, "y");
        this.f4493d = C1437s.m5611f(b, "width");
        this.f4494e = C1437s.m5611f(b, "height");
        if (this.f4495f) {
            float n = (((float) this.f4494e) * C1199a.m4880c().mo6542h().mo6630n()) / ((float) getDrawable().getIntrinsicHeight());
            this.f4494e = (int) (((float) getDrawable().getIntrinsicHeight()) * n);
            int intrinsicWidth = (int) (((float) getDrawable().getIntrinsicWidth()) * n);
            this.f4493d = intrinsicWidth;
            this.f4491b -= intrinsicWidth;
            this.f4492c -= this.f4494e;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.setMargins(this.f4491b, this.f4492c, 0, 0);
        layoutParams.width = this.f4493d;
        layoutParams.height = this.f4494e;
        setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m5567c(C1454x xVar) {
        this.f4498i = C1437s.m5613h(xVar.mo6830b(), "filepath");
        setImageURI(Uri.fromFile(new File(this.f4498i)));
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m5569d(C1454x xVar) {
        if (C1437s.m5608d(xVar.mo6830b(), TJAdUnitConstants.String.VISIBLE)) {
            setVisibility(0);
        } else {
            setVisibility(4);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6790a() {
        JSONObject b = this.f4500k.mo6830b();
        this.f4499j = C1437s.m5613h(b, "ad_session_id");
        this.f4491b = C1437s.m5611f(b, "x");
        this.f4492c = C1437s.m5611f(b, "y");
        this.f4493d = C1437s.m5611f(b, "width");
        this.f4494e = C1437s.m5611f(b, "height");
        this.f4498i = C1437s.m5613h(b, "filepath");
        this.f4495f = C1437s.m5608d(b, "dpi");
        this.f4496g = C1437s.m5608d(b, "invert_y");
        this.f4497h = C1437s.m5608d(b, "wrap_content");
        setImageURI(Uri.fromFile(new File(this.f4498i)));
        if (this.f4495f) {
            float n = (((float) this.f4494e) * C1199a.m4880c().mo6542h().mo6630n()) / ((float) getDrawable().getIntrinsicHeight());
            this.f4494e = (int) (((float) getDrawable().getIntrinsicHeight()) * n);
            int intrinsicWidth = (int) (((float) getDrawable().getIntrinsicWidth()) * n);
            this.f4493d = intrinsicWidth;
            this.f4491b -= intrinsicWidth;
            this.f4492c = this.f4496g ? this.f4492c + this.f4494e : this.f4492c - this.f4494e;
        }
        setVisibility(4);
        FrameLayout.LayoutParams layoutParams = this.f4497h ? new FrameLayout.LayoutParams(-2, -2) : new FrameLayout.LayoutParams(this.f4493d, this.f4494e);
        layoutParams.setMargins(this.f4491b, this.f4492c, 0, 0);
        layoutParams.gravity = 0;
        this.f4501l.addView(this, layoutParams);
        this.f4501l.mo6424i().add(C1199a.m4873a("ImageView.set_visible", (C1458z) new C1433a(), true));
        this.f4501l.mo6424i().add(C1199a.m4873a("ImageView.set_bounds", (C1458z) new C1434b(), true));
        this.f4501l.mo6424i().add(C1199a.m4873a("ImageView.set_image", (C1458z) new C1435c(), true));
        this.f4501l.mo6426j().add("ImageView.set_visible");
        this.f4501l.mo6426j().add("ImageView.set_bounds");
        this.f4501l.mo6426j().add("ImageView.set_image");
    }
}
