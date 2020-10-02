package admost.adserver.ads;

import admost.adserver.core.C0049a;
import admost.adserver.core.C0051c;
import admost.adserver.core.C0055e;
import admost.adserver.core.C0059g;
import admost.sdk.AdMostManager;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.google.android.gms.drive.DriveFile;
import com.kokteyl.lib_admost.R$id;
import com.kokteyl.lib_admost.R$layout;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONObject;
import p030c.p031a.p032a.C1178a;
import p030c.p031a.p032a.C1180c;

public class AdMostBannerAd extends ImageView {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C1178a f0a;

    /* renamed from: b */
    private boolean f1b;

    /* renamed from: c */
    private String f2c;

    /* renamed from: d */
    private int f3d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Object f4e;

    /* renamed from: f */
    private AnimationDrawable f5f;

    /* renamed from: g */
    private Context f6g;

    /* renamed from: h */
    private WebView f7h;

    /* renamed from: admost.adserver.ads.AdMostBannerAd$a */
    class C0001a implements C1180c<JSONObject> {
        C0001a() {
        }

        /* renamed from: a */
        public void onResponse(JSONObject jSONObject) {
            if (jSONObject == null) {
                AdMostBannerAd.this.f0a.onFail(100);
                return;
            }
            try {
                if (jSONObject.optInt("Type", 0) != 1) {
                    AdMostBannerAd.this.f0a.onFail(100);
                    return;
                }
                Object unused = AdMostBannerAd.this.f4e = jSONObject;
                AdMostBannerAd.this.f0a.onReady();
            } catch (Exception e) {
                e.printStackTrace();
                AdMostBannerAd.this.f0a.onFail(101);
            }
        }

        public void onError(String str, Exception exc) {
            AdMostBannerAd.this.f0a.onFail(101);
        }
    }

    /* renamed from: admost.adserver.ads.AdMostBannerAd$b */
    class C0002b implements C1180c<String> {
        C0002b() {
        }

        /* renamed from: a */
        public void onResponse(String str) {
            if (str == null || str.startsWith("//NO_BANNER_FOUND")) {
                AdMostBannerAd.this.f0a.onFail(100);
                return;
            }
            try {
                Object unused = AdMostBannerAd.this.f4e = str;
                AdMostBannerAd.this.f0a.onReady();
            } catch (Exception e) {
                e.printStackTrace();
                AdMostBannerAd.this.f0a.onFail(101);
            }
        }

        public void onError(String str, Exception exc) {
            AdMostBannerAd.this.f0a.onFail(101);
        }
    }

    /* renamed from: admost.adserver.ads.AdMostBannerAd$c */
    class C0003c implements ImageLoader.ImageListener {

        /* renamed from: a */
        final /* synthetic */ int f10a;

        /* renamed from: b */
        final /* synthetic */ int f11b;

        /* renamed from: admost.adserver.ads.AdMostBannerAd$c$a */
        class C0004a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ ImageLoader.ImageContainer f13a;

            C0004a(ImageLoader.ImageContainer imageContainer) {
                this.f13a = imageContainer;
            }

            public void run() {
                ImageLoader.ImageContainer imageContainer = this.f13a;
                if (imageContainer != null && imageContainer.getBitmap() != null) {
                    AdMostBannerAd adMostBannerAd = AdMostBannerAd.this;
                    Bitmap bitmap = this.f13a.getBitmap();
                    C0003c cVar = C0003c.this;
                    adMostBannerAd.m4a(bitmap, cVar.f10a, cVar.f11b);
                }
            }
        }

        C0003c(int i, int i2) {
            this.f10a = i;
            this.f11b = i2;
        }

        public void onErrorResponse(VolleyError volleyError) {
        }

        public void onResponse(ImageLoader.ImageContainer imageContainer, boolean z) {
            new Handler().post(new C0004a(imageContainer));
        }
    }

    /* renamed from: admost.adserver.ads.AdMostBannerAd$d */
    class C0005d implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ View.OnClickListener f15a;

        /* renamed from: b */
        final /* synthetic */ String f16b;

        C0005d(View.OnClickListener onClickListener, String str) {
            this.f15a = onClickListener;
            this.f16b = str;
        }

        public void onClick(View view) {
            this.f15a.onClick(view);
            if (this.f16b.length() > 0) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.f16b));
                intent.setFlags(DriveFile.MODE_READ_ONLY);
                AdMostBannerAd.this.getContext().startActivity(intent);
            }
        }
    }

    /* renamed from: admost.adserver.ads.AdMostBannerAd$e */
    class C0006e extends WebViewClient {
        C0006e() {
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str == null) {
                return false;
            }
            try {
                if (str.startsWith("http")) {
                    AdMostBannerAd.this.f0a.onClicked();
                    webView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    return true;
                }
                if (str.startsWith("sms")) {
                    AdMostBannerAd.this.f0a.onClicked();
                    Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse(str));
                    intent.putExtra("sms_body", str.substring(str.lastIndexOf("body=") + 5));
                    webView.getContext().startActivity(intent);
                    return true;
                }
                return false;
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: admost.adserver.ads.AdMostBannerAd$f */
    class C0007f implements View.OnTouchListener {
        C0007f() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return motionEvent.getAction() == 2;
        }
    }

    /* renamed from: admost.adserver.ads.AdMostBannerAd$g */
    class C0008g implements View.OnClickListener {
        C0008g() {
        }

        public void onClick(View view) {
            AdMostBannerAd.this.f0a.onClicked();
        }
    }

    /* renamed from: admost.adserver.ads.AdMostBannerAd$h */
    class C0009h extends WebViewClient {
        C0009h() {
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
                    intent2.putExtra("sms_body", str.substring(str.lastIndexOf("body=") + 5));
                    intent2.setFlags(DriveFile.MODE_READ_ONLY);
                    webView.getContext().startActivity(intent2);
                    return true;
                }
                return false;
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: admost.adserver.ads.AdMostBannerAd$i */
    class C0010i implements View.OnTouchListener {
        C0010i() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return motionEvent.getAction() == 2;
        }
    }

    /* renamed from: admost.adserver.ads.AdMostBannerAd$j */
    public class C0011j {
        C0011j(Context context) {
        }

        @JavascriptInterface
        public void adClicked() {
            AdMostBannerAd.this.f0a.onClicked();
        }
    }

    public AdMostBannerAd(Context context) {
        super(context);
    }

    /* renamed from: c */
    private void m7c(String str) {
        new C0051c(C0051c.C0053b.ADMOST_ADSERVER_RESPONSE, "", new C0001a()).mo91a(this.f6g, str + "&ei=" + C0055e.m151a(this.f2c, "admostcrosspromo", C0055e.m154b()));
    }

    /* renamed from: d */
    private void m8d(String str) {
        new C0051c(C0051c.C0053b.CP_RESPONSE, "", new C0002b()).mo91a(this.f6g, str + "&nojs=1&ei=" + C0055e.m151a(this.f2c, "admostcrosspromo", C0055e.m154b()));
    }

    /* renamed from: b */
    public void mo7b(String str) {
        this.f1b = true;
        this.f2c = str;
    }

    public AdMostBannerAd(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* renamed from: b */
    public void mo6b() {
        WebView webView = this.f7h;
        if (webView != null) {
            if (Build.VERSION.SDK_INT >= 14) {
                webView.onPause();
            }
            this.f7h.pauseTimers();
        }
        AnimationDrawable animationDrawable = this.f5f;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
    }

    /* renamed from: a */
    public void mo3a(Context context, String str, Hashtable<String, Object> hashtable, int i, C1178a aVar) {
        String str2;
        this.f0a = aVar;
        this.f6g = context;
        this.f3d = i;
        StringBuilder sb = new StringBuilder("?k=" + str);
        sb.append("&uId=");
        sb.append(C0049a.m124a(context).mo88b());
        sb.append("&w=1");
        sb.append("&channel=3");
        sb.append("&device_model=");
        sb.append(C0055e.m148a());
        sb.append("&os_version=");
        sb.append(Build.VERSION.SDK_INT);
        sb.append("&gsm_op=");
        sb.append(C0055e.m157d(context));
        sb.append("&version=");
        sb.append(C0055e.m149a(context));
        sb.append(C0055e.m156c(context));
        if (hashtable != null && hashtable.size() > 0) {
            try {
                for (Map.Entry next : hashtable.entrySet()) {
                    Object value = next.getValue();
                    String str3 = "";
                    if (value != null) {
                        if (value instanceof String) {
                            str2 = URLEncoder.encode((String) value, "UTF8");
                        } else if (value instanceof Integer) {
                            str2 = value + str3;
                        }
                        str3 = str2;
                    }
                    sb.append("&");
                    sb.append(next.getKey());
                    sb.append("=");
                    sb.append(str3);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!this.f1b) {
            m7c(sb.toString());
        } else {
            m8d(sb.toString());
        }
    }

    /* renamed from: c */
    public void mo8c() {
        WebView webView = this.f7h;
        if (webView != null) {
            webView.resumeTimers();
            if (Build.VERSION.SDK_INT >= 14) {
                this.f7h.onResume();
            }
        }
        AnimationDrawable animationDrawable = this.f5f;
        if (animationDrawable != null) {
            animationDrawable.start();
        }
    }

    /* renamed from: b */
    private View m5b(WeakReference<Activity> weakReference) {
        try {
            JSONObject jSONObject = (JSONObject) this.f4e;
            if (jSONObject.has("Script")) {
                String string = jSONObject.getString("Script");
                ViewGroup viewGroup = (ViewGroup) ((LayoutInflater) ((Activity) weakReference.get()).getSystemService("layout_inflater")).inflate(R$layout.admost_admost_ad_banner, (ViewGroup) null);
                WebView webView = (WebView) viewGroup.findViewById(R$id.webView1);
                this.f7h = webView;
                if (this.f3d == 250) {
                    ((RelativeLayout.LayoutParams) webView.getLayoutParams()).width = C0055e.m144a(320);
                    ((RelativeLayout.LayoutParams) this.f7h.getLayoutParams()).height = C0055e.m144a((int) AdMostManager.AD_MEDIUM_RECTANGLE);
                } else if (this.f3d == 50) {
                    ((RelativeLayout.LayoutParams) webView.getLayoutParams()).width = C0055e.m144a(320);
                    ((RelativeLayout.LayoutParams) this.f7h.getLayoutParams()).height = C0055e.m144a(50);
                } else if (this.f3d == 90) {
                    ((RelativeLayout.LayoutParams) webView.getLayoutParams()).width = C0055e.m144a(320);
                }
                WebSettings settings = this.f7h.getSettings();
                settings.setCacheMode(2);
                settings.setJavaScriptEnabled(true);
                settings.setDomStorageEnabled(true);
                if (!jSONObject.has("call")) {
                    this.f7h.setWebViewClient(new C0006e());
                }
                this.f7h.setVerticalScrollBarEnabled(false);
                this.f7h.addJavascriptInterface(new C0011j((Context) weakReference.get()), "AMRClient");
                this.f7h.setHorizontalScrollBarEnabled(false);
                this.f7h.setBackgroundColor(0);
                WebView webView2 = this.f7h;
                webView2.loadData("<head><style>body{margin:0;padding:0;}</style></head>" + string, "text/html", (String) null);
                this.f7h.setOnTouchListener(new C0007f());
                try {
                    if (jSONObject.has("ThirdPartyImp")) {
                        new C0051c(C0051c.C0053b.ADMOST_TRACKER, jSONObject.getString("ThirdPartyImp"), (C1180c) null).mo91a(this.f6g, new String[0]);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return viewGroup;
            }
            mo5a(jSONObject, (View.OnClickListener) new C0008g());
            return this;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    private View m6c(WeakReference<Activity> weakReference) {
        try {
            String str = (String) this.f4e;
            ViewGroup viewGroup = (ViewGroup) ((LayoutInflater) ((Activity) weakReference.get()).getSystemService("layout_inflater")).inflate(R$layout.admost_admost_ad_banner, (ViewGroup) null);
            WebView webView = (WebView) viewGroup.findViewById(R$id.webView1);
            this.f7h = webView;
            if (this.f3d == 250) {
                ((RelativeLayout.LayoutParams) webView.getLayoutParams()).width = C0055e.m144a(320);
                ((RelativeLayout.LayoutParams) this.f7h.getLayoutParams()).height = C0055e.m144a((int) AdMostManager.AD_MEDIUM_RECTANGLE);
            } else if (this.f3d == 50) {
                ((RelativeLayout.LayoutParams) webView.getLayoutParams()).width = C0055e.m144a(320);
                ((RelativeLayout.LayoutParams) this.f7h.getLayoutParams()).height = C0055e.m144a(50);
            } else if (this.f3d == 90) {
                ((RelativeLayout.LayoutParams) webView.getLayoutParams()).width = C0055e.m144a(320);
            }
            WebSettings settings = this.f7h.getSettings();
            settings.setCacheMode(2);
            settings.setJavaScriptEnabled(true);
            settings.setDomStorageEnabled(true);
            this.f7h.setWebViewClient(new C0009h());
            this.f7h.setVerticalScrollBarEnabled(false);
            this.f7h.addJavascriptInterface(new C0011j((Context) weakReference.get()), "AMRClient");
            this.f7h.setHorizontalScrollBarEnabled(false);
            this.f7h.setBackgroundColor(0);
            this.f7h.loadData(str, "text/html", (String) null);
            this.f7h.setOnTouchListener(new C0010i());
            return viewGroup;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public void mo4a(String str) {
        this.f2c = str;
    }

    /* renamed from: a */
    public void mo5a(JSONObject jSONObject, View.OnClickListener onClickListener) {
        try {
            int i = jSONObject.getInt("FrameSize");
            int i2 = jSONObject.getInt("DisplayTime");
            String string = jSONObject.getString("Link");
            String string2 = jSONObject.getString("Image");
            if (i > 0) {
                C0059g.m162a(getContext()).mo104a().get(string2, new C0003c(i, i2));
                setOnClickListener(new C0005d(onClickListener, string));
            }
            try {
                if (jSONObject.has("ThirdPartyImp")) {
                    new C0051c(C0051c.C0053b.ADMOST_TRACKER, jSONObject.getString("ThirdPartyImp"), (C1180c) null).mo91a(getContext(), new String[0]);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m4a(Bitmap bitmap, int i, int i2) {
        try {
            float f = getContext().getResources().getDisplayMetrics().density;
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int i3 = width / i;
            setMinimumWidth((int) (((float) i3) * f));
            setMinimumHeight((int) (((float) height) * f));
            AnimationDrawable animationDrawable = new AnimationDrawable();
            this.f5f = animationDrawable;
            animationDrawable.setOneShot(false);
            for (int i4 = 0; i4 < i; i4++) {
                this.f5f.addFrame(new BitmapDrawable(getContext().getResources(), Bitmap.createBitmap(bitmap, i4 * i3, 0, i3, height)), i2);
            }
            setImageDrawable(this.f5f);
            this.f5f.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void mo2a() {
        setImageDrawable((Drawable) null);
        AnimationDrawable animationDrawable = this.f5f;
        if (animationDrawable != null) {
            animationDrawable.stop();
            this.f5f = null;
        }
    }

    /* renamed from: a */
    public View mo1a(WeakReference<Activity> weakReference) {
        if (!this.f1b) {
            return m5b(weakReference);
        }
        return m6c(weakReference);
    }
}
