package com.miniclip.p155ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.MailTo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.loopj.android.http.C4250c;
import com.miniclip.framework.Miniclip;
import com.miniclip.framework.ThreadingContext;
import com.miniclip.mcprime.C4277R;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;

/* renamed from: com.miniclip.ui.HTMLDialog */
public class HTMLDialog extends Dialog {
    static final FrameLayout.LayoutParams FILL = new FrameLayout.LayoutParams(-1, -1);
    /* access modifiers changed from: private */
    public boolean _isWebViewAttached;
    /* access modifiers changed from: private */
    public boolean _wasWebviewDismissed;
    private String mBaseURL = "";
    /* access modifiers changed from: private */
    public FrameLayout mContent;
    /* access modifiers changed from: private */
    public ImageView mCrossImage;
    private String mHtml;
    private int mIsInternalURL = 1;
    private WebView mWebView;
    /* access modifiers changed from: private */
    public LinearLayout mWebViewContainer;
    /* access modifiers changed from: private */
    public long mWebpageID;

    /* renamed from: com.miniclip.ui.HTMLDialog$a */
    class C4298a implements View.OnClickListener {
        C4298a() {
        }

        public void onClick(View view) {
            HTMLDialog hTMLDialog = HTMLDialog.this;
            hTMLDialog.handleBackButtonPressNative(hTMLDialog.mWebpageID);
            HTMLDialog.this.dismiss();
            boolean unused = HTMLDialog.this._isWebViewAttached = false;
            boolean unused2 = HTMLDialog.this._wasWebviewDismissed = true;
        }
    }

    /* renamed from: com.miniclip.ui.HTMLDialog$b */
    class C4299b extends WebViewClient {

        /* renamed from: com.miniclip.ui.HTMLDialog$b$a */
        class C4300a implements Runnable {
            C4300a() {
            }

            public void run() {
                HTMLDialog hTMLDialog = HTMLDialog.this;
                hTMLDialog.dismissLoadingPopupNative(hTMLDialog.mWebpageID);
            }
        }

        C4299b() {
        }

        public void onPageFinished(WebView webView, String str) {
            if (!HTMLDialog.this._isWebViewAttached && !HTMLDialog.this._wasWebviewDismissed) {
                HTMLDialog.this.mContent.addView(HTMLDialog.this.mWebViewContainer);
                HTMLDialog.this.mContent.addView(HTMLDialog.this.mCrossImage, new ViewGroup.LayoutParams(-2, -2));
                boolean unused = HTMLDialog.this._isWebViewAttached = true;
                Miniclip.queueEvent(ThreadingContext.Main, new C4300a());
            }
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str != null && str.startsWith("market:")) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                Iterator<ResolveInfo> it = Miniclip.getActivity().getPackageManager().queryIntentActivities(intent, 0).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ResolveInfo next = it.next();
                    if (next.activityInfo.applicationInfo.packageName.equals("com.android.vending")) {
                        ActivityInfo activityInfo = next.activityInfo;
                        ComponentName componentName = new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name);
                        intent.setFlags(270532608);
                        intent.setComponent(componentName);
                        Miniclip.getActivity().startActivity(intent);
                        break;
                    }
                }
                return true;
            } else if (!str.startsWith("mailto:")) {
                return false;
            } else {
                Activity activity = Miniclip.getActivity();
                MailTo parse = MailTo.parse(str);
                Intent access$400 = HTMLDialog.this.newEmailIntent(activity, parse.getTo(), parse.getSubject(), parse.getBody(), parse.getCc());
                if (!activity.getPackageManager().queryIntentActivities(access$400, 0).isEmpty()) {
                    activity.startActivity(access$400);
                }
                return true;
            }
        }
    }

    /* renamed from: com.miniclip.ui.HTMLDialog$c */
    static class C4301c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f11465a;

        /* renamed from: b */
        final /* synthetic */ byte[] f11466b;

        /* renamed from: c */
        final /* synthetic */ int f11467c;

        /* renamed from: d */
        final /* synthetic */ long f11468d;

        C4301c(String str, byte[] bArr, int i, long j) {
            this.f11465a = str;
            this.f11466b = bArr;
            this.f11467c = i;
            this.f11468d = j;
        }

        public void run() {
            new HTMLDialog(this.f11465a, this.f11466b, this.f11467c, this.f11468d).show();
        }
    }

    public HTMLDialog(String str, byte[] bArr, int i, long j) {
        super(Miniclip.getActivity(), 16973840);
        try {
            this.mHtml = new String(bArr, C4250c.DEFAULT_CHARSET);
            this.mBaseURL = str;
            this.mWebpageID = j;
            this.mIsInternalURL = i;
            setCanceledOnTouchOutside(false);
        } catch (UnsupportedEncodingException unused) {
            Log.w("Webpage", "Html source code not in UTF encoding");
        }
    }

    private void createCrossImage() {
        int i;
        ImageView imageView = new ImageView(getContext());
        this.mCrossImage = imageView;
        imageView.setOnClickListener(new C4298a());
        if (useSmallCloseButtonNative()) {
            i = C4277R.C4278drawable.close_webpage_small;
        } else {
            i = C4277R.C4278drawable.close_webpage_big;
        }
        this.mCrossImage.setImageDrawable(getContext().getResources().getDrawable(i));
        this.mCrossImage.setVisibility(0);
        this.mCrossImage.setId(C4277R.C4279id.close_webpage_clickable);
    }

    /* access modifiers changed from: private */
    public native void dismissLoadingPopupNative(long j);

    /* access modifiers changed from: private */
    public native void handleBackButtonPressNative(long j);

    /* access modifiers changed from: private */
    public Intent newEmailIntent(Context context, String str, String str2, String str3, String str4) {
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra("android.intent.extra.EMAIL", new String[]{str});
        intent.putExtra("android.intent.extra.TEXT", str3);
        intent.putExtra("android.intent.extra.SUBJECT", str2);
        intent.putExtra("android.intent.extra.CC", str4);
        return intent;
    }

    private void setSystemUiVisibility() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 14) {
            int i2 = 2;
            if (i >= 16) {
                i2 = 1798;
                if (i >= 19) {
                    i2 = 5894;
                }
            }
            getWindow().getDecorView().setSystemUiVisibility(i2);
        }
    }

    private void setUpWebView(int i) {
        this.mWebViewContainer = new LinearLayout(getContext());
        WebView webView = new WebView(getContext());
        this.mWebView = webView;
        webView.setId(C4277R.C4279id.webview_with_webpage);
        this.mWebView.setVerticalScrollBarEnabled(true);
        this.mWebView.setHorizontalScrollBarEnabled(false);
        this.mWebView.setWebViewClient(new WebViewClient());
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.getSettings().setDomStorageEnabled(true);
        this.mWebView.getSettings().setDefaultTextEncodingName("utf-8");
        this.mWebView.getSettings().setLoadWithOverviewMode(true);
        this.mWebView.getSettings().setUseWideViewPort(true);
        this.mWebView.getSettings().setBuiltInZoomControls(true);
        if (Build.VERSION.SDK_INT >= 11) {
            this.mWebView.getSettings().setDisplayZoomControls(false);
        }
        this._wasWebviewDismissed = false;
        this.mWebView.setWebViewClient(new C4299b());
        if (this.mIsInternalURL == 0) {
            this.mWebView.loadUrl(this.mHtml);
        } else {
            this.mWebView.loadDataWithBaseURL(this.mBaseURL, this.mHtml, "text/html", (String) null, (String) null);
        }
        this.mWebView.setScrollContainer(true);
        this.mWebView.setLayoutParams(FILL);
        this.mContent.setBackgroundColor(0);
        this.mWebView.setVisibility(0);
        this.mWebViewContainer.addView(this.mWebView);
        this._isWebViewAttached = false;
    }

    public static void showHTMLDialog(String str, byte[] bArr, int i, long j) {
        Miniclip.queueEvent(ThreadingContext.AndroidUi, new C4301c(str, bArr, i, j));
    }

    private native boolean useSmallCloseButtonNative();

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContent = new FrameLayout(getContext());
        createCrossImage();
        setUpWebView(this.mCrossImage.getDrawable().getIntrinsicWidth() / 2);
        addContentView(this.mContent, new ViewGroup.LayoutParams(-1, -1));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            handleBackButtonPressNative(this.mWebpageID);
            dismiss();
            this._isWebViewAttached = false;
            this._wasWebviewDismissed = true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            setSystemUiVisibility();
        }
    }

    public void show() {
        getWindow().setFlags(8, 8);
        setSystemUiVisibility();
        super.show();
        getWindow().clearFlags(8);
    }
}
