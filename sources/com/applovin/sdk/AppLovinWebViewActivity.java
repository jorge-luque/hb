package com.applovin.sdk;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.utils.C2025o;
import java.util.Set;

public class AppLovinWebViewActivity extends Activity {
    public static final String EVENT_DISMISSED_VIA_BACK_BUTTON = "dismissed_via_back_button";
    public static final String INTENT_EXTRA_KEY_IMMERSIVE_MODE_ON = "immersive_mode_on";
    public static final String INTENT_EXTRA_KEY_SDK_KEY = "sdk_key";

    /* renamed from: a */
    private String f6809a;

    /* renamed from: b */
    private WebView f6810b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public EventListener f6811c;

    public interface EventListener {
        void onReceivedEvent(String str);
    }

    public void loadUrl(String str, EventListener eventListener) {
        this.f6811c = eventListener;
        WebView webView = this.f6810b;
        if (webView == null) {
            this.f6809a = str;
        } else {
            webView.loadUrl(str);
        }
    }

    public void onBackPressed() {
        EventListener eventListener = this.f6811c;
        if (eventListener != null) {
            eventListener.onReceivedEvent(EVENT_DISMISSED_VIA_BACK_BUTTON);
        }
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra(INTENT_EXTRA_KEY_SDK_KEY);
        if (!TextUtils.isEmpty(stringExtra)) {
            final AppLovinSdk instance = AppLovinSdk.getInstance(stringExtra, new AppLovinSdkSettings(), getApplicationContext());
            WebView webView = new WebView(this);
            this.f6810b = webView;
            setContentView(webView);
            WebSettings settings = this.f6810b.getSettings();
            settings.setSupportMultipleWindows(false);
            settings.setJavaScriptEnabled(true);
            this.f6810b.setVerticalScrollBarEnabled(true);
            this.f6810b.setHorizontalScrollBarEnabled(true);
            this.f6810b.setScrollBarStyle(33554432);
            this.f6810b.setWebViewClient(new WebViewClient() {
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    Uri parse = Uri.parse(str);
                    String scheme = parse.getScheme();
                    String host = parse.getHost();
                    String path = parse.getPath();
                    C1977q logger = instance.getLogger();
                    logger.mo8742b("AppLovinWebViewActivity", "Handling url load: " + str);
                    if (!"applovin".equalsIgnoreCase(scheme) || !"com.applovin.sdk".equalsIgnoreCase(host) || AppLovinWebViewActivity.this.f6811c == null) {
                        return super.shouldOverrideUrlLoading(webView, str);
                    }
                    if (!path.endsWith("webview_event")) {
                        return true;
                    }
                    Set<String> queryParameterNames = parse.getQueryParameterNames();
                    String str2 = queryParameterNames.isEmpty() ? "" : (String) queryParameterNames.toArray()[0];
                    if (C2025o.m7963b(str2)) {
                        String queryParameter = parse.getQueryParameter(str2);
                        C1977q logger2 = instance.getLogger();
                        logger2.mo8742b("AppLovinWebViewActivity", "Parsed WebView event parameter name: " + str2 + " and value: " + queryParameter);
                        AppLovinWebViewActivity.this.f6811c.onReceivedEvent(queryParameter);
                        return true;
                    }
                    instance.getLogger().mo8746e("AppLovinWebViewActivity", "Failed to parse WebView event parameter");
                    return true;
                }
            });
            if (getIntent().getBooleanExtra(INTENT_EXTRA_KEY_IMMERSIVE_MODE_ON, false)) {
                getWindow().getDecorView().setSystemUiVisibility(5894);
            }
            if (C2025o.m7963b(this.f6809a)) {
                this.f6810b.loadUrl(this.f6809a);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("No SDK key specified");
    }
}
