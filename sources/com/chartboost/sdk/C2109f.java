package com.chartboost.sdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;
import com.chartboost.sdk.Libraries.C2076e;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.C2088c;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Tracking.C2098a;
import java.util.IdentityHashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.f */
public abstract class C2109f {

    /* renamed from: a */
    public final Handler f7067a;

    /* renamed from: b */
    public final C2102d f7068b;

    /* renamed from: c */
    public boolean f7069c = false;

    /* renamed from: d */
    private boolean f7070d;

    /* renamed from: e */
    protected JSONObject f7071e;

    /* renamed from: f */
    private C2111b f7072f;

    /* renamed from: g */
    public final C2088c f7073g;

    /* renamed from: h */
    protected int f7074h;

    /* renamed from: i */
    public final Map<View, Runnable> f7075i = new IdentityHashMap();

    /* renamed from: j */
    protected boolean f7076j = true;

    /* renamed from: k */
    protected boolean f7077k = true;

    /* renamed from: com.chartboost.sdk.f$a */
    class C2110a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ boolean f7078a;

        /* renamed from: b */
        final /* synthetic */ View f7079b;

        C2110a(boolean z, View view) {
            this.f7078a = z;
            this.f7079b = view;
        }

        public void run() {
            if (!this.f7078a) {
                this.f7079b.setVisibility(8);
                this.f7079b.setClickable(false);
            }
            synchronized (C2109f.this.f7075i) {
                C2109f.this.f7075i.remove(this.f7079b);
            }
        }
    }

    /* renamed from: com.chartboost.sdk.f$c */
    public interface C2113c {
    }

    public C2109f(C2088c cVar, Handler handler, C2102d dVar) {
        this.f7067a = handler;
        this.f7068b = dVar;
        this.f7073g = cVar;
        this.f7072f = null;
        this.f7074h = CBUtility.m8174e();
        this.f7070d = false;
    }

    /* renamed from: b */
    public static boolean m8376b(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 4;
    }

    /* renamed from: a */
    public CBError.CBImpressionError mo9232a(RelativeLayout relativeLayout) {
        if (this.f7072f != null) {
            return null;
        }
        if (relativeLayout == null || relativeLayout.getContext() == null) {
            return CBError.CBImpressionError.ERROR_CREATING_VIEW;
        }
        this.f7072f = mo9233a(relativeLayout.getContext());
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract C2111b mo9233a(Context context);

    /* renamed from: c */
    public void mo9243c() {
        C2111b bVar = this.f7072f;
        if (bVar != null) {
            bVar.mo9256a();
        }
        this.f7072f = null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo9244d() {
        this.f7073g.mo9135l();
    }

    /* renamed from: e */
    public JSONObject mo9245e() {
        return this.f7071e;
    }

    /* renamed from: f */
    public int mo9246f() {
        return this.f7074h;
    }

    /* renamed from: g */
    public float mo9247g() {
        return 0.0f;
    }

    /* renamed from: h */
    public float mo9248h() {
        return 0.0f;
    }

    /* renamed from: i */
    public C2111b mo9249i() {
        return this.f7072f;
    }

    /* renamed from: j */
    public boolean mo9250j() {
        return false;
    }

    /* renamed from: k */
    public void mo9251k() {
        this.f7069c = true;
    }

    /* renamed from: l */
    public void mo9252l() {
        if (this.f7069c) {
            this.f7069c = false;
        }
        C2111b i = mo9249i();
        if (i == null) {
            return;
        }
        if (i.f7086f == null || CBUtility.m8174e() != i.f7086f.intValue()) {
            i.mo9259a(false);
        }
    }

    /* renamed from: m */
    public void mo9253m() {
        mo9244d();
    }

    /* renamed from: n */
    public CBError.CBImpressionError mo9254n() {
        Activity d = this.f7068b.mo9198d();
        if (d == null) {
            this.f7072f = null;
            return CBError.CBImpressionError.NO_HOST_ACTIVITY;
        } else if (!this.f7077k && !this.f7076j) {
            return CBError.CBImpressionError.WRONG_ORIENTATION;
        } else {
            if (this.f7072f == null) {
                this.f7072f = mo9233a((Context) d);
            }
            if (this.f7073g.f6938r.f6896b != 0 || this.f7072f.mo9260a(d)) {
                return null;
            }
            this.f7072f = null;
            return CBError.CBImpressionError.ERROR_CREATING_VIEW;
        }
    }

    /* renamed from: com.chartboost.sdk.f$b */
    public abstract class C2111b extends RelativeLayout {

        /* renamed from: a */
        private boolean f7081a = false;

        /* renamed from: b */
        private int f7082b = -1;

        /* renamed from: c */
        private int f7083c = -1;

        /* renamed from: d */
        private int f7084d = -1;

        /* renamed from: e */
        private int f7085e = -1;

        /* renamed from: f */
        Integer f7086f = null;

        /* renamed from: com.chartboost.sdk.f$b$a */
        class C2112a implements Runnable {
            C2112a() {
            }

            public void run() {
                C2111b.this.requestLayout();
            }
        }

        public C2111b(Context context) {
            super(context);
            setFocusableInTouchMode(true);
            requestFocus();
        }

        /* renamed from: b */
        private boolean m8400b(int i, int i2) {
            Integer num;
            C2088c cVar = C2109f.this.f7073g;
            boolean z = true;
            if (cVar != null && cVar.f6938r.f6896b == 1) {
                return true;
            }
            if (this.f7081a) {
                return false;
            }
            int e = CBUtility.m8174e();
            if (this.f7082b == i && this.f7083c == i2 && (num = this.f7086f) != null && num.intValue() == e) {
                return true;
            }
            this.f7081a = true;
            try {
                if (C2109f.this.f7076j && CBUtility.m8171b(e)) {
                    C2109f.this.f7074h = e;
                } else if (C2109f.this.f7077k && CBUtility.m8166a(e)) {
                    C2109f.this.f7074h = e;
                }
                mo9257a(i, i2);
                post(new C2112a());
                this.f7082b = i;
                this.f7083c = i2;
                this.f7086f = Integer.valueOf(e);
            } catch (Exception e2) {
                CBLogging.m8153a("CBViewProtocol", "Exception raised while layouting Subviews", e2);
                C2098a.m8288a((Class) getClass(), "tryLayout", e2);
                z = false;
            }
            this.f7081a = false;
            return z;
        }

        /* renamed from: a */
        public void mo9256a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract void mo9257a(int i, int i2);

        /* renamed from: a */
        public final void mo9259a(boolean z) {
            if (z) {
                this.f7086f = null;
            }
            mo9260a((Activity) getContext());
        }

        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            synchronized (C2109f.this.f7075i) {
                for (Runnable removeCallbacks : C2109f.this.f7075i.values()) {
                    C2109f.this.f7067a.removeCallbacks(removeCallbacks);
                }
                C2109f.this.f7075i.clear();
            }
        }

        /* access modifiers changed from: protected */
        public void onSizeChanged(int i, int i2, int i3, int i4) {
            C2088c cVar;
            super.onSizeChanged(i, i2, i3, i4);
            this.f7084d = i;
            this.f7085e = i2;
            if (this.f7082b != -1 && this.f7083c != -1 && (cVar = C2109f.this.f7073g) != null && cVar.f6938r.f6896b == 0) {
                mo9261b();
            }
        }

        /* renamed from: a */
        public boolean mo9260a(Activity activity) {
            int i;
            int i2;
            if (this.f7084d == -1 || this.f7085e == -1) {
                try {
                    i2 = getWidth();
                    i = getHeight();
                    if (i2 == 0 || i == 0) {
                        View findViewById = activity.getWindow().findViewById(16908290);
                        if (findViewById == null) {
                            findViewById = activity.getWindow().getDecorView();
                        }
                        int width = findViewById.getWidth();
                        i = findViewById.getHeight();
                        i2 = width;
                    }
                } catch (Exception unused) {
                    i2 = 0;
                    i = 0;
                }
                if (i2 == 0 || i == 0) {
                    DisplayMetrics displayMetrics = new DisplayMetrics();
                    activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                    int i3 = displayMetrics.widthPixels;
                    i = displayMetrics.heightPixels;
                    i2 = i3;
                }
                this.f7084d = i2;
                this.f7085e = i;
            }
            return m8400b(this.f7084d, this.f7085e);
        }

        /* renamed from: a */
        public final void mo9258a(View view) {
            int i = 200;
            if (200 == getId()) {
                i = 201;
            }
            View findViewById = findViewById(i);
            while (findViewById != null) {
                i++;
                findViewById = findViewById(i);
            }
            view.setId(i);
            view.setSaveEnabled(false);
        }

        /* renamed from: b */
        public final void mo9261b() {
            mo9259a(false);
        }
    }

    /* renamed from: b */
    public boolean mo9242b(JSONObject jSONObject) {
        JSONObject a = C2076e.m8185a(jSONObject, "assets");
        this.f7071e = a;
        if (a != null) {
            return true;
        }
        this.f7071e = new JSONObject();
        CBLogging.m8154b("CBViewProtocol", "Media got from the response is null or empty");
        mo9236a(CBError.CBImpressionError.INVALID_RESPONSE);
        return false;
    }

    /* renamed from: a */
    public void mo9236a(CBError.CBImpressionError cBImpressionError) {
        this.f7073g.mo9120a(cBImpressionError);
    }

    /* renamed from: a */
    public void mo9234a() {
        if (!this.f7070d) {
            this.f7070d = true;
            this.f7073g.mo9134k();
        }
    }

    /* renamed from: b */
    public void mo9241b() {
        mo9243c();
        synchronized (this.f7075i) {
            for (Runnable removeCallbacks : this.f7075i.values()) {
                this.f7067a.removeCallbacks(removeCallbacks);
            }
            this.f7075i.clear();
        }
    }

    /* renamed from: a */
    public boolean mo9240a(JSONObject jSONObject) {
        return this.f7073g.mo9123a(jSONObject);
    }

    /* renamed from: a */
    public boolean mo9239a(String str, JSONObject jSONObject) {
        return this.f7073g.mo9125b(str, jSONObject);
    }

    /* renamed from: a */
    public void mo9237a(boolean z, View view) {
        mo9238a(z, view, true);
    }

    /* renamed from: a */
    public void mo9238a(boolean z, View view, boolean z2) {
        int i = 8;
        if ((z && view.getVisibility() == 0) || (!z && view.getVisibility() == 8)) {
            synchronized (this.f7075i) {
                if (!this.f7075i.containsKey(view)) {
                    return;
                }
            }
        }
        if (!z2) {
            if (z) {
                i = 0;
            }
            view.setVisibility(i);
            view.setClickable(z);
            return;
        }
        C2110a aVar = new C2110a(z, view);
        C2088c cVar = this.f7073g;
        int i2 = cVar.f6938r.f6896b;
        cVar.f6931k.f7058a.mo9474a(z, view, 500);
        mo9235a(view, (Runnable) aVar, 500);
    }

    /* renamed from: a */
    public void mo9235a(View view, Runnable runnable, long j) {
        synchronized (this.f7075i) {
            Runnable runnable2 = this.f7075i.get(view);
            if (runnable2 != null) {
                this.f7067a.removeCallbacks(runnable2);
            }
            this.f7075i.put(view, runnable);
        }
        this.f7067a.postDelayed(runnable, j);
    }

    /* renamed from: a */
    public static int m8375a(String str) {
        if (str != null) {
            if (!str.startsWith("#")) {
                try {
                    return Color.parseColor(str);
                } catch (IllegalArgumentException unused) {
                    str = "#" + str;
                }
            }
            if (str.length() == 4 || str.length() == 5) {
                StringBuilder sb = new StringBuilder((str.length() * 2) + 1);
                sb.append("#");
                int i = 0;
                while (i < str.length() - 1) {
                    i++;
                    sb.append(str.charAt(i));
                    sb.append(str.charAt(i));
                }
                str = sb.toString();
            }
            try {
                return Color.parseColor(str);
            } catch (IllegalArgumentException e) {
                CBLogging.m8157c("CBViewProtocol", "error parsing color " + str, e);
            }
        }
        return 0;
    }
}
