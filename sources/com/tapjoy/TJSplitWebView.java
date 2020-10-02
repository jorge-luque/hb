package com.tapjoy;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.drive.DriveFile;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.internal.C3166jq;
import java.util.Arrays;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

public class TJSplitWebView extends RelativeLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public TJWebView f13085a;

    /* renamed from: b */
    private C4861a f13086b;

    /* renamed from: c */
    private C4861a f13087c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f13088d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f13089e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f13090f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Uri f13091g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public HashSet f13092h;

    /* renamed from: i */
    private JSONObject f13093i;

    /* renamed from: j */
    private TJAdUnitJSBridge f13094j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public Context f13095k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public Boolean f13096l;

    /* renamed from: m */
    private RelativeLayout f13097m;

    /* renamed from: n */
    private FrameLayout f13098n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public ProgressBar f13099o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public TextView f13100p;

    /* renamed from: q */
    private TJImageButton f13101q;

    /* renamed from: r */
    private TJImageButton f13102r;

    /* renamed from: s */
    private String f13103s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public boolean f13104t;

    /* renamed from: u */
    private String f13105u;

    /* renamed from: v */
    private String f13106v;

    /* renamed from: w */
    private String f13107w;

    /* renamed from: com.tapjoy.TJSplitWebView$a */
    static class C4861a {

        /* renamed from: a */
        final double f13117a;

        /* renamed from: b */
        final double f13118b;

        /* renamed from: c */
        final double f13119c;

        /* renamed from: d */
        final double f13120d;

        /* renamed from: e */
        final float f13121e;

        C4861a(JSONObject jSONObject) {
            this.f13117a = jSONObject.optDouble("width", 0.0d);
            this.f13118b = jSONObject.optDouble("height", 0.0d);
            this.f13119c = jSONObject.optDouble("left", 0.0d);
            this.f13120d = jSONObject.optDouble("top", 0.0d);
            this.f13121e = (float) jSONObject.optDouble("cornerRadius", 0.0d);
        }
    }

    /* renamed from: com.tapjoy.TJSplitWebView$b */
    class C4862b extends WebViewClient {
        private C4862b() {
        }

        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (TJSplitWebView.this.f13096l.booleanValue()) {
                if (TJSplitWebView.this.f13099o != null) {
                    TJSplitWebView.this.f13099o.setProgress(0);
                    TJSplitWebView.this.f13099o.setVisibility(8);
                }
                TJSplitWebView.this.isFirstOrLastPage();
            }
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            if (TJSplitWebView.this.f13096l.booleanValue()) {
                TJSplitWebView.this.f13100p.setText(TapjoyUrlFormatter.getDomain(str));
                TJSplitWebView.this.f13099o.setVisibility(0);
            }
            TapjoyLog.m16649d("TJSplitWebView", "onPageStarted: " + str);
        }

        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            TapjoyLog.m16649d("TJSplitWebView", "onReceivedError: " + str2 + " firstUrl:" + TJSplitWebView.this.f13088d);
            if (TJSplitWebView.this.f13104t) {
                TJSplitWebView.this.showErrorDialog();
            } else if (str2.equals(TJSplitWebView.this.f13088d)) {
                TJSplitWebView.this.mo30770a();
            }
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            String h = TJSplitWebView.this.f13090f;
            Uri i = TJSplitWebView.this.f13091g;
            if (!(h == null || i == null || str == null || !str.startsWith(h))) {
                TJSplitWebView.this.f13095k.startActivity(new Intent("android.intent.action.VIEW", i));
                TJSplitWebView.this.mo30770a();
            }
            return super.shouldInterceptRequest(webView, str);
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            TapjoyLog.m16649d("TJSplitWebView", "shouldOverrideUrlLoading: " + str);
            Uri parse = Uri.parse(str);
            if (parse != null) {
                String host = parse.getHost();
                String scheme = parse.getScheme();
                if (!(scheme == null || host == null || ((!scheme.equals("http") && !scheme.equals("https")) || (TJSplitWebView.this.f13092h != null && TJSplitWebView.this.f13092h.contains(host))))) {
                    String unused = TJSplitWebView.this.f13089e = str;
                    return false;
                }
            }
            try {
                TJSplitWebView.this.f13095k.startActivity(new Intent("android.intent.action.VIEW", parse));
                if (TJSplitWebView.this.f13096l.booleanValue()) {
                    return true;
                }
                TJSplitWebView.this.mo30770a();
                return true;
            } catch (Exception e) {
                TapjoyLog.m16651e("TJSplitWebView", e.getMessage());
                return true;
            }
        }

        /* synthetic */ C4862b(TJSplitWebView tJSplitWebView, byte b) {
            this();
        }
    }

    @TargetApi(21)
    public TJSplitWebView(Context context, JSONObject jSONObject, TJAdUnitJSBridge tJAdUnitJSBridge) {
        super(context);
        this.f13094j = tJAdUnitJSBridge;
        this.f13095k = context;
        JSONObject optJSONObject = jSONObject.optJSONObject(TJAdUnitConstants.String.SPLIT_VIEW_LAYOUT);
        JSONArray optJSONArray = jSONObject.optJSONArray(TJAdUnitConstants.String.SPLIT_VIEW_EXIT_HOSTS);
        JSONObject optJSONObject2 = jSONObject.optJSONObject(TJAdUnitConstants.String.SPLIT_VIEW_ERROR_DIALOG_STRINGS);
        this.f13103s = jSONObject.optString(TJAdUnitConstants.String.SPLIT_VIEW_URL_FOR_EXTERNAL_OPEN);
        this.f13093i = jSONObject.optJSONObject(TJAdUnitConstants.String.SPLIT_VIEW_ANIMATION);
        setLayoutOption(optJSONObject);
        setExitHosts(optJSONArray);
        setErrorDialog(optJSONObject2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        TJWebView tJWebView = new TJWebView(this.f13095k);
        this.f13085a = tJWebView;
        tJWebView.setId(TapjoyUtil.generateViewId());
        this.f13085a.setBackgroundColor(-1);
        WebSettings settings = this.f13085a.getSettings();
        if (settings != null) {
            settings.setUseWideViewPort(true);
        }
        this.f13085a.setWebViewClient(new C4862b(this, (byte) 0));
        Boolean valueOf = Boolean.valueOf(jSONObject.optBoolean(TJAdUnitConstants.String.SPLIT_VIEW_SHOW_TOOLBAR));
        this.f13096l = valueOf;
        if (valueOf.booleanValue()) {
            addToolbar();
            addLineBreak();
            addProgressBar();
            this.f13085a.setWebChromeClient(new WebChromeClient() {
                public final void onProgressChanged(WebView webView, int i) {
                    super.onProgressChanged(webView, i);
                    TJSplitWebView.this.f13099o.setProgress(i);
                    TJSplitWebView.this.isFirstOrLastPage();
                }
            });
        }
        addView(this.f13085a, layoutParams);
    }

    @TargetApi(21)
    public void addLineBreak() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f13098n = frameLayout;
        frameLayout.setBackgroundColor(Color.parseColor("#dddddd"));
        addView(this.f13098n);
    }

    @TargetApi(21)
    public void addProgressBar() {
        ProgressBar progressBar = new ProgressBar(this.f13095k, (AttributeSet) null, 16842872);
        this.f13099o = progressBar;
        progressBar.setMax(100);
        this.f13099o.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#5d95ff")));
        this.f13099o.setProgressBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#dddddd")));
        addView(this.f13099o);
    }

    @TargetApi(21)
    public void addToolbar() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f13095k);
        this.f13097m = relativeLayout;
        relativeLayout.setId(TapjoyUtil.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) (new TapjoyDisplayMetricsUtil(getContext()).getScreenDensityScale() * 40.0f));
        layoutParams.addRule(6);
        this.f13097m.setBackgroundColor(-1);
        this.f13097m.setVisibility(0);
        setupToolbarUI();
        addView(this.f13097m, layoutParams);
    }

    public void animateOpen(ViewGroup viewGroup) {
        JSONObject jSONObject = this.f13093i;
        if (jSONObject != null && jSONObject.has(TJAdUnitConstants.String.ANIMATION_EVENT_ON_OPEN) && this.f13093i.optString(TJAdUnitConstants.String.ANIMATION_EVENT_ON_OPEN).equalsIgnoreCase(TJAdUnitConstants.String.ANIMATION_TYPE_SLIDE_UP)) {
            setY((float) viewGroup.getHeight());
            animate().translationY(0.0f);
        }
    }

    public void applyLayoutOption(JSONObject jSONObject) {
        setLayoutOption(jSONObject);
        m16598a(getWidth(), getHeight());
    }

    public String getLastUrl() {
        return this.f13089e;
    }

    public boolean goBack() {
        if (!this.f13085a.canGoBack()) {
            return false;
        }
        this.f13085a.goBack();
        return true;
    }

    public void isFirstOrLastPage() {
        this.f13101q.setEnabled(this.f13085a.canGoBack());
        this.f13102r.setEnabled(this.f13085a.canGoForward());
    }

    public void loadUrl(String str) {
        TJWebView tJWebView = this.f13085a;
        if (tJWebView != null) {
            this.f13088d = str;
            this.f13089e = str;
            tJWebView.loadUrl(str);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        m16598a(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        super.onMeasure(i, i2);
    }

    public void openInExternalBrowser() {
        Uri uri;
        if (C3166jq.m10436c(this.f13103s)) {
            uri = Uri.parse(this.f13085a.getUrl());
            if (uri == null) {
                uri = Uri.parse(getLastUrl());
            }
        } else {
            uri = Uri.parse(this.f13103s);
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(uri);
        intent.addFlags(DriveFile.MODE_READ_ONLY);
        if (this.f13085a.getContext() != null) {
            try {
                this.f13085a.getContext().startActivity(intent);
            } catch (Exception e) {
                TapjoyLog.m16649d("TJSplitWebView", e.getMessage());
            }
        }
    }

    public void setErrorDialog(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f13104t = true;
            this.f13105u = jSONObject.optString("description");
            this.f13106v = jSONObject.optString("close");
            this.f13107w = jSONObject.optString("reload");
        }
    }

    public void setExitHosts(JSONArray jSONArray) {
        if (jSONArray == null) {
            this.f13092h = null;
            return;
        }
        this.f13092h = new HashSet();
        for (int i = 0; i <= jSONArray.length(); i++) {
            String optString = jSONArray.optString(i);
            if (optString != null) {
                this.f13092h.add(optString);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setLayoutOption(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject(TJAdUnitConstants.String.LANDSCAPE);
            C4861a aVar = null;
            this.f13087c = optJSONObject != null ? new C4861a(optJSONObject) : null;
            JSONObject optJSONObject2 = jSONObject.optJSONObject(TJAdUnitConstants.String.PORTRAIT);
            if (optJSONObject2 != null) {
                aVar = new C4861a(optJSONObject2);
            }
            this.f13086b = aVar;
        }
    }

    public void setTrigger(String str, String str2) {
        this.f13090f = C3166jq.m10435b(str);
        this.f13091g = str2 != null ? Uri.parse(str2) : null;
    }

    public void setUserAgent(String str) {
        this.f13085a.getSettings().setUserAgentString(str);
    }

    @TargetApi(21)
    public void setupToolbarUI() {
        float screenDensityScale = new TapjoyDisplayMetricsUtil(getContext()).getScreenDensityScale();
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        TJImageButton tJImageButton = new TJImageButton(this.f13095k);
        this.f13101q = tJImageButton;
        tJImageButton.setId(TapjoyUtil.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        int i = (int) (10.0f * screenDensityScale);
        layoutParams.setMargins(i, i, i, i);
        int i2 = (int) (5.0f * screenDensityScale);
        this.f13101q.setPadding(i2, i, i, i);
        this.f13101q.setEnabledImageBitmap(TapjoyIcons.getBackEnabledImage(screenDensityScale));
        this.f13101q.setDisableImageBitmap(TapjoyIcons.getBackDisabledImage(screenDensityScale));
        this.f13101q.setBackgroundColor(0);
        this.f13101q.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (TJSplitWebView.this.f13085a.canGoBack()) {
                    TJSplitWebView.this.f13085a.goBack();
                }
            }
        });
        relativeLayout.addView(this.f13101q, layoutParams);
        this.f13102r = new TJImageButton(this.f13095k);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(15);
        layoutParams2.addRule(1, this.f13101q.getId());
        layoutParams2.setMargins(i, i, i, i);
        this.f13102r.setPadding(i, i, i2, i);
        this.f13102r.setEnabledImageBitmap(TapjoyIcons.getForwardEnabledImage(screenDensityScale));
        this.f13102r.setDisableImageBitmap(TapjoyIcons.getForwardDisabledImage(screenDensityScale));
        this.f13102r.setBackgroundColor(0);
        this.f13102r.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                TJSplitWebView.this.f13085a.goForward();
            }
        });
        relativeLayout.addView(this.f13102r, layoutParams2);
        ImageButton imageButton = new ImageButton(this.f13095k);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(15);
        layoutParams3.addRule(11);
        layoutParams3.setMargins(i, i, i, i);
        imageButton.setPadding(i2, i2, i2, i2);
        imageButton.setImageBitmap(TapjoyIcons.getCloseImage(screenDensityScale));
        imageButton.setBackgroundColor(0);
        imageButton.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                TJSplitWebView.this.mo30770a();
            }
        });
        relativeLayout.addView(imageButton, layoutParams3);
        TextView textView = new TextView(this.f13095k);
        this.f13100p = textView;
        textView.setId(TapjoyUtil.generateViewId());
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(13);
        this.f13100p.setMaxLines(1);
        this.f13100p.setMaxEms(200);
        this.f13100p.setTextAlignment(4);
        this.f13100p.setTextColor(Color.parseColor("#5d95ff"));
        this.f13100p.setBackgroundColor(0);
        this.f13100p.setEnabled(false);
        this.f13100p.setTypeface(Typeface.create("sans-serif-medium", 0));
        relativeLayout.addView(this.f13100p, layoutParams4);
        ImageButton imageButton2 = new ImageButton(this.f13095k);
        imageButton2.setId(TapjoyUtil.generateViewId());
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(1, this.f13100p.getId());
        layoutParams5.addRule(15);
        imageButton2.setPadding(i2, i2, i2, i2);
        imageButton2.setImageBitmap(TapjoyIcons.getOpenBrowserImage(screenDensityScale));
        imageButton2.setBackgroundColor(0);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                TJSplitWebView.this.openInExternalBrowser();
            }
        });
        relativeLayout.addView(imageButton2, layoutParams5);
        this.f13097m.addView(relativeLayout, new RelativeLayout.LayoutParams(-1, -2));
    }

    @TargetApi(21)
    public void showErrorDialog() {
        new AlertDialog.Builder(this.f13095k, 16974394).setMessage(this.f13105u).setPositiveButton(this.f13106v, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).setNegativeButton(this.f13107w, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                if (C3166jq.m10436c(TJSplitWebView.this.getLastUrl())) {
                    TJSplitWebView tJSplitWebView = TJSplitWebView.this;
                    tJSplitWebView.loadUrl(tJSplitWebView.f13088d);
                } else {
                    TJSplitWebView tJSplitWebView2 = TJSplitWebView.this;
                    tJSplitWebView2.loadUrl(tJSplitWebView2.getLastUrl());
                }
                dialogInterface.cancel();
            }
        }).create().show();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo30770a() {
        this.f13094j.dismissSplitView((JSONObject) null, (String) null);
    }

    /* renamed from: a */
    private void m16598a(int i, int i2) {
        C4861a aVar = i <= i2 ? this.f13086b : this.f13087c;
        if (aVar == null) {
            this.f13085a.setVisibility(4);
            return;
        }
        double d = (double) i;
        double d2 = aVar.f13117a;
        Double.isNaN(d);
        int i3 = (int) (d2 * d);
        double d3 = (double) i2;
        double d4 = aVar.f13118b;
        Double.isNaN(d3);
        int i4 = (int) (d4 * d3);
        if (i3 == 0 || i4 == 0) {
            this.f13085a.setVisibility(4);
            return;
        }
        double d5 = aVar.f13119c;
        Double.isNaN(d);
        int i5 = (int) (d * d5);
        double d6 = aVar.f13120d;
        Double.isNaN(d3);
        int i6 = (int) (d3 * d6);
        int i7 = (i - i3) - i5;
        int i8 = (i2 - i4) - i6;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f13085a.getLayoutParams();
        layoutParams.width = i3;
        layoutParams.height = i4;
        Boolean bool = this.f13096l;
        if (bool == null || !bool.booleanValue()) {
            layoutParams.setMargins(i5, i6, i7, i8);
        } else {
            float screenDensityScale = new TapjoyDisplayMetricsUtil(getContext()).getScreenDensityScale();
            int height = ((int) (40.0f * screenDensityScale)) + this.f13098n.getHeight();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f13097m.getLayoutParams();
            layoutParams2.setMargins(i5, i6, i7, i8);
            this.f13097m.setLayoutParams(layoutParams2);
            layoutParams.setMargins(i5, i6 + height, i7, i8);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i3, (int) screenDensityScale);
            layoutParams3.setMargins(i5, layoutParams.topMargin - this.f13099o.getHeight(), i7, i8);
            this.f13099o.setLayoutParams(layoutParams3);
            this.f13098n.setLayoutParams(layoutParams3);
        }
        this.f13085a.setLayoutParams(layoutParams);
        this.f13085a.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 21) {
            float f = aVar.f13121e;
            if (f > 0.0f) {
                float[] fArr = new float[8];
                final float f2 = f * getResources().getDisplayMetrics().density;
                Boolean bool2 = this.f13096l;
                if (bool2 == null || !bool2.booleanValue()) {
                    Arrays.fill(fArr, f2);
                    ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, (RectF) null, (float[]) null));
                    shapeDrawable.getPaint().setColor(-1);
                    this.f13085a.setBackground(shapeDrawable);
                    this.f13085a.setClipToOutline(true);
                    return;
                }
                this.f13097m.setOutlineProvider(new ViewOutlineProvider() {
                    public final void getOutline(View view, Outline outline) {
                        int width = view.getWidth();
                        float f = f2;
                        outline.setRoundRect(0, 0, width, (int) (((float) view.getHeight()) + f), f);
                    }
                });
                this.f13097m.setClipToOutline(true);
                return;
            }
            this.f13085a.setBackground((Drawable) null);
            this.f13085a.setClipToOutline(false);
            Boolean bool3 = this.f13096l;
            if (bool3 != null && bool3.booleanValue()) {
                this.f13097m.setClipToOutline(false);
            }
        }
    }
}
