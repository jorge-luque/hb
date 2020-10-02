package admost.adserver.core;

import admost.adserver.core.C0051c;
import admost.adserver.videocache.C0062b;
import admost.adserver.videocache.C0066f;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.p004v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.applovin.sdk.AppLovinEventTypes;
import com.google.android.gms.drive.DriveFile;
import com.kokteyl.lib_admost.R$id;
import com.kokteyl.lib_admost.R$layout;
import com.kokteyl.lib_admost.R$string;
import com.loopj.android.http.C4250c;
import com.ogury.p159cm.OguryChoiceManager;
import com.tapjoy.TJAdUnitConstants;
import java.io.File;
import java.util.Locale;
import java.util.StringTokenizer;
import org.json.JSONException;
import org.json.JSONObject;
import p030c.p031a.p032a.C1180c;

public class AdMostInterstitialAdActivity extends Activity implements C0062b {

    /* renamed from: B */
    private static C0066f f63B;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public boolean f64A;

    /* renamed from: a */
    private ImageView f65a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public VideoView f66b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public TextView f67c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f68d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f69e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f70f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f71g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f72h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f73i = 1000;

    /* renamed from: j */
    private boolean f74j = false;

    /* renamed from: k */
    private boolean f75k = false;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public MediaPlayer f76l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public Handler f77m = new Handler();
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f78n = false;

    /* renamed from: o */
    private Runnable f79o;

    /* renamed from: p */
    private String f80p;

    /* renamed from: q */
    private String f81q;

    /* renamed from: r */
    private String f82r;

    /* renamed from: s */
    private String f83s;

    /* renamed from: t */
    private String f84t;

    /* renamed from: u */
    private String f85u;

    /* renamed from: v */
    private String f86v;

    /* renamed from: w */
    private String f87w;

    /* renamed from: x */
    private String f88x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public int f89y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public int f90z;

    /* renamed from: admost.adserver.core.AdMostInterstitialAdActivity$a */
    class C0024a implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ String f91a;

        /* renamed from: b */
        final /* synthetic */ JSONObject f92b;

        C0024a(String str, JSONObject jSONObject) {
            this.f91a = str;
            this.f92b = jSONObject;
        }

        public void onClick(View view) {
            if (this.f91a.length() <= 0) {
                return;
            }
            if (this.f92b.has("ClickType")) {
                try {
                    AdMostInterstitialAdActivity.this.m84b("");
                    int i = this.f92b.getInt("ClickType");
                    if (i == 1) {
                        AdMostInterstitialAdActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.f91a)));
                    } else if (i == 2) {
                        AdMostInterstitialAdActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.f91a)));
                    } else if (i == 3) {
                        AdMostInterstitialAdActivity adMostInterstitialAdActivity = AdMostInterstitialAdActivity.this;
                        adMostInterstitialAdActivity.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.f91a)));
                    } else if (i == 4) {
                        StringTokenizer stringTokenizer = new StringTokenizer(this.f91a, "|");
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse("smsto:"));
                        intent.setType("vnd.android-dir/mms-sms");
                        intent.putExtra("address", stringTokenizer.nextToken());
                        intent.putExtra("sms_body", stringTokenizer.nextToken());
                        AdMostInterstitialAdActivity.this.startActivity(intent);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    AdMostInterstitialAdActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.f91a)));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* renamed from: admost.adserver.core.AdMostInterstitialAdActivity$b */
    class C0025b implements View.OnClickListener {
        C0025b() {
        }

        public void onClick(View view) {
            AdMostInterstitialAdActivity.this.m87c();
        }
    }

    /* renamed from: admost.adserver.core.AdMostInterstitialAdActivity$c */
    class C0026c implements View.OnClickListener {
        C0026c() {
        }

        public void onClick(View view) {
            AdMostInterstitialAdActivity.this.m87c();
        }
    }

    /* renamed from: admost.adserver.core.AdMostInterstitialAdActivity$d */
    class C0027d implements Runnable {

        /* renamed from: a */
        AlertDialog f96a;

        /* renamed from: b */
        int f97b = 0;

        /* renamed from: c */
        final /* synthetic */ TextView f98c;

        /* renamed from: d */
        final /* synthetic */ ImageButton f99d;

        /* renamed from: admost.adserver.core.AdMostInterstitialAdActivity$d$a */
        class C0028a implements DialogInterface.OnClickListener {
            C0028a() {
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                C0050b.m130a().mo89a(4, AdMostInterstitialAdActivity.this.f68d, "");
                AdMostInterstitialAdActivity.this.finish();
            }
        }

        /* renamed from: admost.adserver.core.AdMostInterstitialAdActivity$d$b */
        class C0029b implements View.OnClickListener {
            C0029b() {
            }

            public void onClick(View view) {
                AdMostInterstitialAdActivity.this.m87c();
            }
        }

        C0027d(TextView textView, ImageButton imageButton) {
            this.f98c = textView;
            this.f99d = imageButton;
        }

        public void run() {
            if (AdMostInterstitialAdActivity.this.f78n && AdMostInterstitialAdActivity.this.f66b != null) {
                double currentPosition = (double) AdMostInterstitialAdActivity.this.f66b.getCurrentPosition();
                Double.isNaN(currentPosition);
                int ceil = (int) Math.ceil((currentPosition * 1.0d) / 1000.0d);
                if (AdMostInterstitialAdActivity.this.f72h == ceil) {
                    int i = this.f97b + 1;
                    this.f97b = i;
                    if (i >= 3) {
                        AlertDialog alertDialog = this.f96a;
                        if (alertDialog == null) {
                            AlertDialog.Builder a = AdMostInterstitialAdActivity.this.m70a((DialogInterface.OnClickListener) new C0028a());
                            if (a != null) {
                                this.f96a = a.show();
                            }
                        } else if (!alertDialog.isShowing()) {
                            this.f96a.show();
                        }
                        this.f97b = 0;
                    }
                } else {
                    this.f97b = 0;
                    AlertDialog alertDialog2 = this.f96a;
                    if (alertDialog2 != null) {
                        alertDialog2.dismiss();
                        this.f96a = null;
                    }
                }
                int unused = AdMostInterstitialAdActivity.this.f72h = ceil;
                AdMostInterstitialAdActivity adMostInterstitialAdActivity = AdMostInterstitialAdActivity.this;
                int unused2 = adMostInterstitialAdActivity.f73i = Math.max(0, adMostInterstitialAdActivity.f70f - AdMostInterstitialAdActivity.this.f72h);
                if (AdMostInterstitialAdActivity.this.f69e == 4 && AdMostInterstitialAdActivity.this.f72h >= AdMostInterstitialAdActivity.this.f70f) {
                    AdMostInterstitialAdActivity.this.m82b();
                }
                if (AdMostInterstitialAdActivity.this.f72h < AdMostInterstitialAdActivity.this.f70f && AdMostInterstitialAdActivity.this.f89y > 0 && AdMostInterstitialAdActivity.this.f72h < AdMostInterstitialAdActivity.this.f89y) {
                    TextView textView = this.f98c;
                    textView.setText((AdMostInterstitialAdActivity.this.f89y - AdMostInterstitialAdActivity.this.f72h) + "");
                    AdMostInterstitialAdActivity.this.f77m.postDelayed(this, 1000);
                } else if (AdMostInterstitialAdActivity.this.f72h < AdMostInterstitialAdActivity.this.f70f && AdMostInterstitialAdActivity.this.f90z > 0 && AdMostInterstitialAdActivity.this.f71g > AdMostInterstitialAdActivity.this.f72h) {
                    TextView textView2 = this.f98c;
                    textView2.setText((AdMostInterstitialAdActivity.this.f71g - AdMostInterstitialAdActivity.this.f72h) + "");
                    AdMostInterstitialAdActivity.this.f77m.postDelayed(this, 1000);
                } else if (AdMostInterstitialAdActivity.this.f73i > 0) {
                    TextView textView3 = this.f98c;
                    textView3.setText(AdMostInterstitialAdActivity.this.f73i + "");
                    AdMostInterstitialAdActivity.this.f77m.postDelayed(this, 1000);
                } else {
                    this.f98c.setText("X");
                    this.f99d.setOnClickListener(new C0029b());
                }
            }
        }
    }

    /* renamed from: admost.adserver.core.AdMostInterstitialAdActivity$e */
    class C0030e implements DialogInterface.OnClickListener {
        C0030e() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                dialogInterface.dismiss();
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: admost.adserver.core.AdMostInterstitialAdActivity$f */
    class C0031f implements DialogInterface.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ DialogInterface.OnClickListener f104a;

        C0031f(DialogInterface.OnClickListener onClickListener) {
            this.f104a = onClickListener;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            DialogInterface.OnClickListener onClickListener = this.f104a;
            if (onClickListener != null) {
                onClickListener.onClick(dialogInterface, -1);
            }
        }
    }

    /* renamed from: admost.adserver.core.AdMostInterstitialAdActivity$g */
    class C0032g implements View.OnTouchListener {
        C0032g() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return true;
            }
            if (AdMostInterstitialAdActivity.this.f64A) {
                AdMostInterstitialAdActivity.this.m101h();
                return true;
            }
            AdMostInterstitialAdActivity.this.m99g();
            return true;
        }
    }

    /* renamed from: admost.adserver.core.AdMostInterstitialAdActivity$h */
    class C0033h implements MediaPlayer.OnCompletionListener {
        C0033h() {
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            AdMostInterstitialAdActivity.this.m82b();
        }
    }

    /* renamed from: admost.adserver.core.AdMostInterstitialAdActivity$i */
    class C0034i implements MediaPlayer.OnErrorListener {
        C0034i() {
        }

        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            Log.w("ADMOST-VIDEO", "MediaPlayer onError: what=" + i + " ,extra=" + i2);
            return false;
        }
    }

    /* renamed from: admost.adserver.core.AdMostInterstitialAdActivity$j */
    class C0035j implements MediaPlayer.OnPreparedListener {

        /* renamed from: a */
        final /* synthetic */ int f109a;

        C0035j(int i) {
            this.f109a = i;
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            AdMostInterstitialAdActivity.this.f67c.setVisibility(8);
            MediaPlayer unused = AdMostInterstitialAdActivity.this.f76l = mediaPlayer;
            int unused2 = AdMostInterstitialAdActivity.this.f71g = mediaPlayer.getDuration() / 1000;
            AdMostInterstitialAdActivity adMostInterstitialAdActivity = AdMostInterstitialAdActivity.this;
            int n = adMostInterstitialAdActivity.f71g;
            int i = this.f109a;
            if (i <= 0) {
                i = AdMostInterstitialAdActivity.this.f71g;
            }
            int unused3 = adMostInterstitialAdActivity.f70f = Math.min(n, i);
            AdMostInterstitialAdActivity adMostInterstitialAdActivity2 = AdMostInterstitialAdActivity.this;
            int unused4 = adMostInterstitialAdActivity2.f89y = Math.min(adMostInterstitialAdActivity2.f89y, AdMostInterstitialAdActivity.this.f71g);
            int unused5 = AdMostInterstitialAdActivity.this.f90z = this.f109a;
            try {
                AdMostInterstitialAdActivity adMostInterstitialAdActivity3 = AdMostInterstitialAdActivity.this;
                Locale locale = Locale.ENGLISH;
                Object[] objArr = new Object[1];
                StringBuilder sb = new StringBuilder();
                sb.append(AdMostInterstitialAdActivity.this.f89y > 0 ? AdMostInterstitialAdActivity.this.f89y : AdMostInterstitialAdActivity.this.f71g);
                sb.append("");
                objArr[0] = sb.toString();
                adMostInterstitialAdActivity3.m79a(new JSONObject(String.format(locale, "{\"TSArc\": {\"TSArcDuration\": %s}}", objArr)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: admost.adserver.core.AdMostInterstitialAdActivity$k */
    class C0036k extends WebViewClient {
        C0036k() {
        }

        public void onPageFinished(WebView webView, String str) {
            ((ProgressBar) AdMostInterstitialAdActivity.this.findViewById(R$id.ad_progress)).setVisibility(8);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str == null) {
                return false;
            }
            try {
                if (str.startsWith("http")) {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    intent.setFlags(DriveFile.MODE_READ_ONLY);
                    webView.getContext().startActivity(intent);
                    return true;
                }
                if (str.startsWith("sms")) {
                    Intent intent2 = new Intent("android.intent.action.SENDTO", Uri.parse(str));
                    intent2.setFlags(DriveFile.MODE_READ_ONLY);
                    intent2.putExtra("sms_body", str.substring(str.lastIndexOf("body=") + 5));
                    webView.getContext().startActivity(intent2);
                    return true;
                }
                return false;
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: admost.adserver.core.AdMostInterstitialAdActivity$l */
    class C0037l implements View.OnTouchListener {
        C0037l() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return motionEvent.getAction() == 2;
        }
    }

    /* renamed from: admost.adserver.core.AdMostInterstitialAdActivity$m */
    class C0038m extends WebViewClient {

        /* renamed from: a */
        final /* synthetic */ JSONObject f113a;

        C0038m(JSONObject jSONObject) {
            this.f113a = jSONObject;
        }

        public void onPageFinished(WebView webView, String str) {
            ((ProgressBar) AdMostInterstitialAdActivity.this.findViewById(R$id.ad_progress)).setVisibility(8);
            AdMostInterstitialAdActivity.this.m79a(this.f113a);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str == null) {
                return false;
            }
            try {
                if (str.startsWith("http")) {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    intent.setFlags(DriveFile.MODE_READ_ONLY);
                    webView.getContext().startActivity(intent);
                    return true;
                }
                if (str.startsWith("sms")) {
                    Intent intent2 = new Intent("android.intent.action.SENDTO", Uri.parse(str));
                    intent2.setFlags(DriveFile.MODE_READ_ONLY);
                    intent2.putExtra("sms_body", str.substring(str.lastIndexOf("body=") + 5));
                    webView.getContext().startActivity(intent2);
                    return true;
                }
                return false;
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: admost.adserver.core.AdMostInterstitialAdActivity$n */
    class C0039n implements View.OnTouchListener {
        C0039n() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return motionEvent.getAction() == 2;
        }
    }

    /* renamed from: admost.adserver.core.AdMostInterstitialAdActivity$o */
    class C0040o implements ImageLoader.ImageListener {

        /* renamed from: a */
        final /* synthetic */ int f116a;

        /* renamed from: b */
        final /* synthetic */ int f117b;

        /* renamed from: admost.adserver.core.AdMostInterstitialAdActivity$o$a */
        class C0041a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ ImageLoader.ImageContainer f119a;

            C0041a(ImageLoader.ImageContainer imageContainer) {
                this.f119a = imageContainer;
            }

            public void run() {
                ((ProgressBar) AdMostInterstitialAdActivity.this.findViewById(R$id.ad_progress)).setVisibility(8);
                ((ImageButton) AdMostInterstitialAdActivity.this.findViewById(R$id.amr_ad_close)).setVisibility(0);
                ImageLoader.ImageContainer imageContainer = this.f119a;
                if (imageContainer != null && imageContainer.getBitmap() != null) {
                    AdMostInterstitialAdActivity adMostInterstitialAdActivity = AdMostInterstitialAdActivity.this;
                    Bitmap bitmap = this.f119a.getBitmap();
                    C0040o oVar = C0040o.this;
                    adMostInterstitialAdActivity.m77a(bitmap, oVar.f116a, oVar.f117b);
                }
            }
        }

        C0040o(int i, int i2) {
            this.f116a = i;
            this.f117b = i2;
        }

        public void onErrorResponse(VolleyError volleyError) {
        }

        public void onResponse(ImageLoader.ImageContainer imageContainer, boolean z) {
            new Handler().post(new C0041a(imageContainer));
        }
    }

    /* renamed from: admost.adserver.core.AdMostInterstitialAdActivity$p */
    public class C0042p {
        C0042p(Context context) {
        }

        @JavascriptInterface
        public void adClicked() {
            AdMostInterstitialAdActivity.this.m84b("");
        }

        @JavascriptInterface
        public void adClosed() {
            AdMostInterstitialAdActivity.this.m87c();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        this.f69e = getIntent().getIntExtra("MODE", -1);
        this.f68d = getIntent().getStringExtra("AD_PLACE_ID");
        int i = this.f69e;
        if (i == -1) {
            m87c();
        } else if (i == 0) {
            m107k();
        } else if (i == 1) {
            m105j();
        } else if (i == 3) {
            m102i();
        } else if (i == 4) {
            m108l();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        try {
            if (this.f66b != null) {
                this.f66b.stopPlayback();
            }
            C0066f a = m68a(getApplicationContext());
            if (a != null) {
                a.mo119a((C0062b) this);
                a.mo118a();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        if (this.f69e == 4) {
            if (!this.f75k) {
                return true;
            }
            if (this.f73i > 0 && this.f72h < this.f70f) {
                return true;
            }
        }
        m87c();
        return false;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f78n = false;
        m99g();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f78n = true;
        m101h();
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m99g() {
        try {
            if (this.f69e == 4) {
                if (this.f76l != null) {
                    this.f76l.pause();
                    this.f77m.removeCallbacks(this.f79o);
                }
                this.f64A = true;
                findViewById(R$id.amr_pauseIcon).setVisibility(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m101h() {
        try {
            if (this.f69e == 4) {
                if (this.f76l != null) {
                    this.f76l.start();
                    if (this.f79o != null) {
                        m111m();
                    }
                }
                this.f64A = false;
                findViewById(R$id.amr_pauseIcon).setVisibility(8);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: i */
    private void m102i() {
        try {
            getWindow().addFlags(OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS);
            String stringExtra = getIntent().getStringExtra("DATA");
            setContentView(R$layout.admost_interstitial_cp);
            WebView webView = (WebView) findViewById(R$id.webView1);
            WebSettings settings = webView.getSettings();
            settings.setCacheMode(2);
            settings.setJavaScriptEnabled(true);
            settings.setDomStorageEnabled(true);
            webView.setWebViewClient(new C0036k());
            webView.addJavascriptInterface(new C0042p(this), "AMRClient");
            webView.setVerticalScrollBarEnabled(false);
            webView.setHorizontalScrollBarEnabled(false);
            webView.setClickable(true);
            webView.setBackgroundColor(0);
            webView.loadDataWithBaseURL((String) null, stringExtra, "text/html", C4250c.DEFAULT_CHARSET, (String) null);
            webView.setOnTouchListener(new C0037l());
            m73a();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: j */
    private void m105j() {
        getWindow().addFlags(OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS);
        setContentView(R$layout.admost_interstitial);
        this.f65a = (ImageView) findViewById(R$id.ad_image);
        try {
            JSONObject jSONObject = new JSONObject(getIntent().getStringExtra("DATA"));
            m79a(jSONObject);
            int i = jSONObject.getInt("FrameSize");
            int i2 = jSONObject.getInt("DisplayTime");
            String string = jSONObject.getString("Link");
            String string2 = jSONObject.getString("Image");
            if (i > 0) {
                C0059g.m162a(getApplicationContext()).mo104a().get(string2, new C0040o(i, i2));
                this.f65a.setOnClickListener(new C0024a(string, jSONObject));
            }
            m73a();
            m85b(jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: k */
    private void m107k() {
        try {
            getWindow().addFlags(OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS);
            JSONObject jSONObject = new JSONObject(getIntent().getStringExtra("DATA"));
            String string = jSONObject.getString("Script");
            setContentView(R$layout.admost_interstitial_tag);
            WebView webView = (WebView) findViewById(R$id.webView1);
            WebSettings settings = webView.getSettings();
            settings.setCacheMode(2);
            settings.setJavaScriptEnabled(true);
            settings.setDomStorageEnabled(true);
            webView.setWebViewClient(new C0038m(jSONObject));
            webView.addJavascriptInterface(new C0042p(this), "AMRClient");
            webView.setVerticalScrollBarEnabled(false);
            webView.setHorizontalScrollBarEnabled(false);
            webView.setBackgroundColor(0);
            webView.loadDataWithBaseURL((String) null, "<head><style>body{margin:0;padding:0;}</style></head>" + string, "text/html", C4250c.DEFAULT_CHARSET, (String) null);
            webView.setOnTouchListener(new C0039n());
            m73a();
            m85b(jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: l */
    private void m108l() {
        getWindow().addFlags(OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS);
        setContentView(R$layout.admost_adserver_video);
        try {
            JSONObject jSONObject = new JSONObject(getIntent().getStringExtra("DATA"));
            String string = jSONObject.getString("Url");
            int optInt = jSONObject.optInt("SkippableAt", 1000);
            this.f85u = jSONObject.optString("ClickUrl", "");
            this.f88x = jSONObject.optString("ClickTag", "");
            String optString = jSONObject.optString("Orientation", TJAdUnitConstants.String.PORTRAIT);
            this.f80p = jSONObject.optString("ContentType", AppLovinEventTypes.USER_VIEWED_CONTENT);
            this.f81q = jSONObject.optString("CallToActionText", "INSTALL");
            this.f82r = jSONObject.optString("AppIconUrl", "");
            this.f83s = jSONObject.optString("AppDesc", "");
            this.f84t = jSONObject.optString("AppImageUrl", "");
            this.f86v = jSONObject.optString("EndCardOrientation", "");
            this.f87w = jSONObject.optString("AppName", "");
            this.f89y = jSONObject.optInt("StartCountingFrom", 0);
            setRequestedOrientation(optString.equals(TJAdUnitConstants.String.LANDSCAPE) ? 0 : 1);
            try {
                if (!optString.equals(TJAdUnitConstants.String.LANDSCAPE)) {
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    mediaMetadataRetriever.setDataSource(getApplicationContext(), Uri.parse(string));
                    int intValue = Integer.valueOf(mediaMetadataRetriever.extractMetadata(18)).intValue();
                    int intValue2 = Integer.valueOf(mediaMetadataRetriever.extractMetadata(19)).intValue();
                    mediaMetadataRetriever.release();
                    if (intValue > intValue2) {
                        findViewById(R$id.amr_ad_extra_layout).setVisibility(0);
                        ((TextView) findViewById(R$id.amr_ad_headline)).setText(this.f87w);
                        ((TextView) findViewById(R$id.amr_ad_body)).setText(this.f83s);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.f66b = (VideoView) findViewById(R$id.simpleVideoView);
            this.f67c = (TextView) findViewById(R$id.loading_video);
            m78a(this.f66b);
            C0066f a = m68a(getApplicationContext());
            String a2 = a.mo116a(string);
            a.mo120a((C0062b) this, string);
            this.f66b.setVideoPath(a2);
            this.f66b.setOnCompletionListener(m90d());
            this.f66b.setOnErrorListener(m93e());
            this.f66b.setOnPreparedListener(m71a(optInt));
            this.f66b.start();
            this.f67c.setVisibility(0);
            m73a();
            m85b(jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
            m97f();
        }
    }

    /* renamed from: m */
    private void m111m() {
        String str;
        ImageButton imageButton = (ImageButton) findViewById(R$id.amr_ad_close);
        TextView textView = (TextView) findViewById(R$id.amr_ad_close_text);
        imageButton.setVisibility(0);
        textView.setVisibility(0);
        if (this.f73i == 0) {
            str = "X";
        } else {
            str = this.f73i + "";
        }
        textView.setText(str);
        if (this.f73i == 0) {
            imageButton.setOnClickListener(new C0026c());
        }
        C0027d dVar = new C0027d(textView, imageButton);
        this.f79o = dVar;
        this.f77m.postDelayed(dVar, 1000);
    }

    /* renamed from: n */
    private void m113n() {
        Intent intent = new Intent(getApplicationContext(), AdMostVideoEndCardActivity.class);
        intent.setFlags(DriveFile.MODE_READ_ONLY);
        intent.putExtra("AD_PLACE_ID", this.f68d);
        intent.putExtra("AD_APP_DESC", this.f83s);
        intent.putExtra("AD_CALL_TO_ACTION_TEXT", this.f81q);
        intent.putExtra("AD_ICON_URL", this.f82r);
        intent.putExtra("AD_IMAGE_URL", this.f84t);
        intent.putExtra("AD_CLICK_URL", this.f85u);
        intent.putExtra("AD_ORIENTATION", this.f86v);
        intent.putExtra("AD_APP_NAME", this.f87w);
        intent.putExtra("AD_CLICK_MESSAGE", this.f88x);
        startActivity(intent);
    }

    /* renamed from: b */
    private void m85b(JSONObject jSONObject) {
        try {
            if (jSONObject.has("ThirdPartyImp")) {
                new C0051c(C0051c.C0053b.ADMOST_TRACKER, jSONObject.getString("ThirdPartyImp"), (C1180c) null).mo91a(getApplicationContext(), new String[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m87c() {
        String str;
        if (this.f69e != 4 || (str = this.f80p) == null || !str.toLowerCase().equals("install")) {
            C0050b.m130a().mo89a(4, this.f68d, "");
        } else {
            m113n();
        }
        finish();
    }

    /* renamed from: d */
    private MediaPlayer.OnCompletionListener m90d() {
        return new C0033h();
    }

    /* renamed from: e */
    private MediaPlayer.OnErrorListener m93e() {
        return new C0034i();
    }

    /* renamed from: f */
    private void m97f() {
        C0050b.m130a().mo89a(5, this.f68d, "");
        finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m82b() {
        if (!this.f74j) {
            findViewById(R$id.amr_ad_skip_text).setVisibility(0);
            findViewById(R$id.amr_ad_skip_text).bringToFront();
            findViewById(R$id.amr_ad_skip_text).setOnClickListener(new C0025b());
            C0050b.m130a().mo89a(3, this.f68d, "");
        }
        this.f74j = true;
    }

    /* renamed from: a */
    public static C0066f m68a(Context context) {
        if (f63B == null) {
            synchronized (C0066f.class) {
                f63B = new C0066f(context.getApplicationContext());
            }
        }
        return f63B;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m84b(String str) {
        C0050b.m130a().mo89a(2, this.f68d, str);
    }

    /* renamed from: a */
    private void m78a(VideoView videoView) {
        String str;
        String str2 = this.f85u;
        if ((str2 != null && str2.length() > 1) || ((str = this.f88x) != null && str.length() > 1)) {
            videoView.setOnTouchListener(new C0032g());
        }
    }

    /* renamed from: a */
    private MediaPlayer.OnPreparedListener m71a(int i) {
        return new C0035j(i);
    }

    /* renamed from: a */
    private void m73a() {
        C0050b.m130a().mo89a(6, this.f68d, "");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m77a(Bitmap bitmap, int i, int i2) {
        try {
            float f = getResources().getDisplayMetrics().density;
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int i3 = width / i;
            this.f65a.setMinimumWidth((int) (((float) i3) * f));
            this.f65a.setMinimumHeight((int) (((float) height) * f));
            AnimationDrawable animationDrawable = new AnimationDrawable();
            animationDrawable.setOneShot(false);
            for (int i4 = 0; i4 < i; i4++) {
                animationDrawable.addFrame(new BitmapDrawable(getResources(), Bitmap.createBitmap(bitmap, i4 * i3, 0, i3, height)), i2);
            }
            this.f65a.setImageDrawable(animationDrawable);
            animationDrawable.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m79a(JSONObject jSONObject) {
        if (!this.f75k) {
            this.f75k = true;
            int i = 0;
            if (jSONObject != null && jSONObject.has("TSArc")) {
                try {
                    i = jSONObject.getJSONObject("TSArc").optInt("TSArcDuration", 0);
                } catch (Exception unused) {
                }
            }
            this.f73i = i;
            m111m();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public AlertDialog.Builder m70a(DialogInterface.OnClickListener onClickListener) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(R$string.AdMost_video_connection_title));
            builder.setMessage(getString(R$string.AdMost_video_connection_explanation));
            builder.setNegativeButton(getString(R$string.AdMost_video_continue), new C0030e());
            builder.setPositiveButton(getString(R$string.AdMost_video_close), new C0031f(onClickListener));
            return builder;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public void mo54a(String str) {
        "Cache Status : onFileCached: url= " + str;
    }

    /* renamed from: a */
    public void mo53a(File file, String str, int i) {
        "Cache Status : onCacheProgress: " + str + " File Length: " + (file.length() / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) + " KB ,percent: %" + i;
    }
}
