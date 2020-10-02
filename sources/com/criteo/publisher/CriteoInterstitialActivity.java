package com.criteo.publisher;

import android.app.Activity;
import android.content.ComponentName;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.criteo.publisher.p057p.C2499a;
import com.criteo.publisher.p057p.C2502c;
import com.loopj.android.http.C4250c;
import java.lang.ref.WeakReference;

public class CriteoInterstitialActivity extends Activity {

    /* renamed from: a */
    private WebView f7648a;

    /* renamed from: b */
    private ResultReceiver f7649b;

    /* renamed from: c */
    private ImageButton f7650c;

    /* renamed from: d */
    private FrameLayout f7651d;

    /* renamed from: e */
    private ComponentName f7652e;

    /* renamed from: com.criteo.publisher.CriteoInterstitialActivity$a */
    class C2315a implements View.OnClickListener {
        C2315a() {
        }

        public void onClick(View view) {
            CriteoInterstitialActivity.this.m8937b();
        }
    }

    /* renamed from: com.criteo.publisher.CriteoInterstitialActivity$b */
    private static class C2316b implements C2502c {

        /* renamed from: a */
        private final WeakReference<CriteoInterstitialActivity> f7654a;

        /* synthetic */ C2316b(WeakReference weakReference, C2315a aVar) {
            this(weakReference);
        }

        /* renamed from: a */
        public void mo10106a() {
            CriteoInterstitialActivity criteoInterstitialActivity = (CriteoInterstitialActivity) this.f7654a.get();
            if (criteoInterstitialActivity != null) {
                criteoInterstitialActivity.m8937b();
            }
        }

        /* renamed from: b */
        public void mo10107b() {
            CriteoInterstitialActivity criteoInterstitialActivity = (CriteoInterstitialActivity) this.f7654a.get();
            if (criteoInterstitialActivity != null) {
                criteoInterstitialActivity.m8934a();
            }
        }

        private C2316b(WeakReference<CriteoInterstitialActivity> weakReference) {
            this.f7654a = weakReference;
        }
    }

    /* renamed from: c */
    private void m8939c() {
        this.f7648a.getSettings().setJavaScriptEnabled(true);
        this.f7648a.setWebViewClient(new C2499a(new C2316b(new WeakReference(this), (C2315a) null), this.f7652e));
    }

    public void onBackPressed() {
        m8937b();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2317R.layout.activity_criteo_interstitial);
        this.f7651d = (FrameLayout) findViewById(C2317R.C2319id.AdLayout);
        WebView webView = new WebView(getApplicationContext());
        this.f7648a = webView;
        this.f7651d.addView(webView, 0);
        this.f7650c = (ImageButton) findViewById(C2317R.C2319id.closeButton);
        Bundle extras = getIntent().getExtras();
        if (!(extras == null || extras.getString("webviewdata") == null)) {
            String string = extras.getString("webviewdata");
            this.f7649b = (ResultReceiver) extras.getParcelable("resultreceiver");
            this.f7652e = (ComponentName) extras.getParcelable("callingactivity");
            m8939c();
            m8936a(string);
        }
        this.f7650c.setOnClickListener(new C2315a());
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f7651d.removeAllViews();
        this.f7648a.setWebViewClient((WebViewClient) null);
        this.f7648a.destroy();
        this.f7648a = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8934a() {
        Bundle bundle = new Bundle();
        bundle.putInt("Action", 202);
        this.f7649b.send(100, bundle);
        finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m8937b() {
        Bundle bundle = new Bundle();
        bundle.putInt("Action", 201);
        this.f7649b.send(100, bundle);
        finish();
    }

    /* renamed from: a */
    private void m8936a(String str) {
        this.f7648a.loadDataWithBaseURL("https://criteo.com", str, "text/html", C4250c.DEFAULT_CHARSET, "about:blank");
    }
}
