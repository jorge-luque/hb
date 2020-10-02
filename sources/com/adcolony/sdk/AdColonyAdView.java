package com.adcolony.sdk;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.adcolony.sdk.C1439u;
import com.facebook.GraphResponse;
import com.iab.omid.library.adcolony.adsession.FriendlyObstructionPurpose;
import java.io.File;
import org.json.JSONObject;

public class AdColonyAdView extends FrameLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C1205c f3263a = C1199a.m4880c().mo6530b().mo6460d().get(this.f3266d);

    /* renamed from: b */
    private AdColonyAdViewListener f3264b;

    /* renamed from: c */
    private AdColonyAdSize f3265c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f3266d;

    /* renamed from: e */
    private String f3267e;

    /* renamed from: f */
    private String f3268f;

    /* renamed from: g */
    private ImageView f3269g;

    /* renamed from: h */
    private C1218c0 f3270h;

    /* renamed from: i */
    private C1454x f3271i;

    /* renamed from: j */
    private boolean f3272j;

    /* renamed from: k */
    private boolean f3273k;

    /* renamed from: l */
    private boolean f3274l;

    /* renamed from: m */
    private boolean f3275m;

    /* renamed from: n */
    private boolean f3276n;

    /* renamed from: o */
    private int f3277o;

    /* renamed from: p */
    private int f3278p;

    /* renamed from: q */
    private int f3279q;

    /* renamed from: r */
    private int f3280r;

    /* renamed from: s */
    private int f3281s;

    /* renamed from: com.adcolony.sdk.AdColonyAdView$a */
    class C1196a implements Runnable {
        C1196a() {
        }

        public void run() {
            Context b = C1199a.m4878b();
            if (b instanceof AdColonyAdViewActivity) {
                ((AdColonyAdViewActivity) b).mo6251b();
            }
            C1222d b2 = C1199a.m4880c().mo6530b();
            b2.mo6458b().remove(AdColonyAdView.this.f3266d);
            b2.mo6454a(AdColonyAdView.this.f3263a);
            JSONObject b3 = C1437s.m5599b();
            C1437s.m5592a(b3, "id", AdColonyAdView.this.f3266d);
            new C1454x("AdSession.on_ad_view_destroyed", 1, b3).mo6834d();
        }
    }

    /* renamed from: com.adcolony.sdk.AdColonyAdView$b */
    class C1197b implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ Context f3283a;

        C1197b(Context context) {
            this.f3283a = context;
        }

        public void onClick(View view) {
            Context context = this.f3283a;
            if (context instanceof AdColonyAdViewActivity) {
                ((AdColonyAdViewActivity) context).mo6251b();
            }
        }
    }

    AdColonyAdView(Context context, C1454x xVar, AdColonyAdViewListener adColonyAdViewListener) {
        super(context);
        this.f3264b = adColonyAdViewListener;
        this.f3267e = adColonyAdViewListener.mo6265c();
        JSONObject b = xVar.mo6830b();
        this.f3266d = C1437s.m5613h(b, "id");
        this.f3268f = C1437s.m5613h(b, "close_button_filepath");
        this.f3272j = C1437s.m5608d(b, "trusted_demand_source");
        this.f3276n = C1437s.m5608d(b, "close_button_snap_to_webview");
        this.f3280r = C1437s.m5611f(b, "close_button_width");
        this.f3281s = C1437s.m5611f(b, "close_button_height");
        this.f3265c = adColonyAdViewListener.mo6260a();
        setLayoutParams(new FrameLayout.LayoutParams(this.f3263a.mo6413d(), this.f3263a.mo6406b()));
        setBackgroundColor(0);
        addView(this.f3263a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo6229c() {
        return this.f3273k;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo6230d() {
        if (this.f3270h != null) {
            getWebView().mo6718h();
        }
    }

    public boolean destroy() {
        if (this.f3273k) {
            new C1439u.C1440a().mo6801a("Ignoring duplicate call to destroy().").mo6803a(C1439u.f4514g);
            return false;
        }
        this.f3273k = true;
        C1218c0 c0Var = this.f3270h;
        if (!(c0Var == null || c0Var.mo6448c() == null)) {
            this.f3270h.mo6447b();
        }
        C1359k0.m5309a((Runnable) new C1196a());
        return true;
    }

    public AdColonyAdSize getAdSize() {
        return this.f3265c;
    }

    /* access modifiers changed from: package-private */
    public C1205c getContainer() {
        return this.f3263a;
    }

    public AdColonyAdViewListener getListener() {
        return this.f3264b;
    }

    /* access modifiers changed from: package-private */
    public C1218c0 getOmidManager() {
        return this.f3270h;
    }

    /* access modifiers changed from: package-private */
    public int getOrientation() {
        return this.f3277o;
    }

    /* access modifiers changed from: package-private */
    public boolean getTrustedDemandSource() {
        return this.f3272j;
    }

    /* access modifiers changed from: package-private */
    public boolean getUserInteraction() {
        return this.f3275m;
    }

    /* access modifiers changed from: package-private */
    public C1379m0 getWebView() {
        C1205c cVar = this.f3263a;
        if (cVar == null) {
            return null;
        }
        return cVar.mo6431n().get(2);
    }

    public String getZoneId() {
        return this.f3267e;
    }

    /* access modifiers changed from: package-private */
    public void setExpandMessage(C1454x xVar) {
        this.f3271i = xVar;
    }

    /* access modifiers changed from: package-private */
    public void setExpandedHeight(int i) {
        this.f3279q = (int) (((float) i) * C1199a.m4880c().mo6542h().mo6630n());
    }

    /* access modifiers changed from: package-private */
    public void setExpandedWidth(int i) {
        this.f3278p = (int) (((float) i) * C1199a.m4880c().mo6542h().mo6630n());
    }

    public void setListener(AdColonyAdViewListener adColonyAdViewListener) {
        this.f3264b = adColonyAdViewListener;
    }

    /* access modifiers changed from: package-private */
    public void setNoCloseButton(boolean z) {
        this.f3274l = this.f3272j && z;
    }

    /* access modifiers changed from: package-private */
    public void setOmidManager(C1218c0 c0Var) {
        this.f3270h = c0Var;
    }

    /* access modifiers changed from: package-private */
    public void setOrientation(int i) {
        this.f3277o = i;
    }

    /* access modifiers changed from: package-private */
    public void setUserInteraction(boolean z) {
        this.f3275m = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6227a() {
        if (this.f3272j || this.f3275m) {
            float n = C1199a.m4880c().mo6542h().mo6630n();
            this.f3263a.setLayoutParams(new FrameLayout.LayoutParams((int) (((float) this.f3265c.getWidth()) * n), (int) (((float) this.f3265c.getHeight()) * n)));
            C1379m0 webView = getWebView();
            if (webView != null) {
                C1454x xVar = new C1454x("WebView.set_bounds", 0);
                JSONObject b = C1437s.m5599b();
                C1437s.m5602b(b, "x", webView.mo6725o());
                C1437s.m5602b(b, "y", webView.mo6727p());
                C1437s.m5602b(b, "width", webView.mo6724n());
                C1437s.m5602b(b, "height", webView.mo6723m());
                xVar.mo6832b(b);
                webView.mo6708a(xVar);
                JSONObject b2 = C1437s.m5599b();
                C1437s.m5592a(b2, "ad_session_id", this.f3266d);
                new C1454x("MRAID.on_close", this.f3263a.mo6428k(), b2).mo6834d();
            }
            ImageView imageView = this.f3269g;
            if (imageView != null) {
                this.f3263a.removeView(imageView);
                this.f3263a.mo6402a((View) this.f3269g);
            }
            addView(this.f3263a);
            AdColonyAdViewListener adColonyAdViewListener = this.f3264b;
            if (adColonyAdViewListener != null) {
                adColonyAdViewListener.onClosed(this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo6228b() {
        if (this.f3272j || this.f3275m) {
            C1336j h = C1199a.m4880c().mo6542h();
            int r = h.mo6634r();
            int q = h.mo6633q();
            int i = this.f3278p;
            if (i <= 0) {
                i = r;
            }
            int i2 = this.f3279q;
            if (i2 <= 0) {
                i2 = q;
            }
            int i3 = (r - i) / 2;
            int i4 = (q - i2) / 2;
            this.f3263a.setLayoutParams(new FrameLayout.LayoutParams(r, q));
            C1379m0 webView = getWebView();
            if (webView != null) {
                C1454x xVar = new C1454x("WebView.set_bounds", 0);
                JSONObject b = C1437s.m5599b();
                C1437s.m5602b(b, "x", i3);
                C1437s.m5602b(b, "y", i4);
                C1437s.m5602b(b, "width", i);
                C1437s.m5602b(b, "height", i2);
                xVar.mo6832b(b);
                webView.mo6708a(xVar);
                float n = h.mo6630n();
                JSONObject b2 = C1437s.m5599b();
                C1437s.m5602b(b2, "app_orientation", C1359k0.m5331f(C1359k0.m5332g()));
                C1437s.m5602b(b2, "width", (int) (((float) i) / n));
                C1437s.m5602b(b2, "height", (int) (((float) i2) / n));
                C1437s.m5602b(b2, "x", C1359k0.m5297a((View) webView));
                C1437s.m5602b(b2, "y", C1359k0.m5314b((View) webView));
                C1437s.m5592a(b2, "ad_session_id", this.f3266d);
                new C1454x("MRAID.on_size_change", this.f3263a.mo6428k(), b2).mo6834d();
            }
            ImageView imageView = this.f3269g;
            if (imageView != null) {
                this.f3263a.removeView(imageView);
            }
            Context b3 = C1199a.m4878b();
            if (!(b3 == null || this.f3274l || webView == null)) {
                float n2 = C1199a.m4880c().mo6542h().mo6630n();
                int i5 = (int) (((float) this.f3280r) * n2);
                int i6 = (int) (((float) this.f3281s) * n2);
                if (this.f3276n) {
                    r = webView.mo6721k() + webView.mo6720j();
                }
                int l = this.f3276n ? webView.mo6722l() : 0;
                ImageView imageView2 = new ImageView(b3.getApplicationContext());
                this.f3269g = imageView2;
                imageView2.setImageURI(Uri.fromFile(new File(this.f3268f)));
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i5, i6);
                layoutParams.setMargins(r - i5, l, 0, 0);
                this.f3269g.setOnClickListener(new C1197b(b3));
                this.f3263a.addView(this.f3269g, layoutParams);
                this.f3263a.mo6403a((View) this.f3269g, FriendlyObstructionPurpose.CLOSE_AD);
            }
            if (this.f3271i != null) {
                JSONObject b4 = C1437s.m5599b();
                C1437s.m5603b(b4, GraphResponse.SUCCESS_KEY, true);
                this.f3271i.mo6829a(b4).mo6834d();
                this.f3271i = null;
            }
            return true;
        }
        if (this.f3271i != null) {
            JSONObject b5 = C1437s.m5599b();
            C1437s.m5603b(b5, GraphResponse.SUCCESS_KEY, false);
            this.f3271i.mo6829a(b5).mo6834d();
            this.f3271i = null;
        }
        return false;
    }
}
