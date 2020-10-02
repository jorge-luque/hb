package com.tapjoy;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tapjoy.TapjoyErrorMessage;
import java.util.concurrent.CountDownLatch;

@SuppressLint({"SetJavaScriptEnabled"})
public class TJEventOptimizer extends WebView {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static String f13047a = "TJEventOptimizer";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static TJEventOptimizer f13048b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static CountDownLatch f13049c;

    /* renamed from: d */
    private Context f13050d;

    /* renamed from: e */
    private TJAdUnitJSBridge f13051e;

    /* renamed from: com.tapjoy.TJEventOptimizer$a */
    class C4851a extends WebChromeClient {
        private C4851a() {
        }

        @TargetApi(8)
        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            String a = TJEventOptimizer.f13047a;
            TapjoyLog.m16649d(a, "JS CONSOLE: " + consoleMessage.message() + " -- From line " + consoleMessage.lineNumber() + " of " + consoleMessage.sourceId());
            return true;
        }

        /* synthetic */ C4851a(TJEventOptimizer tJEventOptimizer, byte b) {
            this();
        }
    }

    /* renamed from: com.tapjoy.TJEventOptimizer$b */
    class C4852b extends WebViewClient {
        private C4852b() {
        }

        public final void onPageFinished(WebView webView, String str) {
            TapjoyLog.m16649d(TJEventOptimizer.f13047a, "boostrap html loaded successfully");
        }

        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            TapjoyLog.m16650e(TJEventOptimizer.f13047a, new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SDK_ERROR, "Error encountered when instantiating a WebViewClient"));
        }

        /* synthetic */ C4852b(TJEventOptimizer tJEventOptimizer, byte b) {
            this();
        }
    }

    /* synthetic */ TJEventOptimizer(Context context, byte b) {
        this(context);
    }

    public static TJEventOptimizer getInstance() {
        return f13048b;
    }

    public static void init(final Context context) {
        TapjoyLog.m16649d(f13047a, "Initializing event optimizer");
        f13049c = new CountDownLatch(1);
        TapjoyUtil.runOnMainThread(new Runnable() {
            public final void run() {
                try {
                    TJEventOptimizer unused = TJEventOptimizer.f13048b = new TJEventOptimizer(context, (byte) 0);
                } catch (Exception e) {
                    TapjoyLog.m16654w(TJEventOptimizer.f13047a, e.getMessage());
                }
                TJEventOptimizer.f13049c.countDown();
            }
        });
        f13049c.await();
        if (f13048b == null) {
            throw new RuntimeException("Failed to init TJEventOptimizer");
        }
    }

    private TJEventOptimizer(Context context) {
        super(context);
        this.f13050d = context;
        this.f13051e = new TJAdUnitJSBridge(context, (WebView) this);
        getSettings().setJavaScriptEnabled(true);
        setWebViewClient(new C4852b(this, (byte) 0));
        setWebChromeClient(new C4851a(this, (byte) 0));
        loadUrl(TapjoyConnectCore.getHostURL() + TJAdUnitConstants.EVENTS_PROXY_PATH + TapjoyUtil.convertURLParams(TapjoyConnectCore.getGenericURLParams(), true));
    }
}
