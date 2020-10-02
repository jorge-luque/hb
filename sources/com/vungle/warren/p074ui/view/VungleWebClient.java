package com.vungle.warren.p074ui.view;

import android.annotation.TargetApi;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebViewRenderProcess;
import android.webkit.WebViewRenderProcessClient;
import com.google.gson.JsonObject;
import com.vungle.warren.model.Advertisement;
import com.vungle.warren.model.Placement;
import com.vungle.warren.p074ui.view.WebViewAPI;

/* renamed from: com.vungle.warren.ui.view.VungleWebClient */
public class VungleWebClient extends WebViewClient implements WebViewAPI {
    public static final String TAG = VungleWebClient.class.getSimpleName();
    private WebViewAPI.MRAIDDelegate MRAIDDelegate;
    private Advertisement advertisement;
    private boolean collectConsent;
    private WebViewAPI.WebClientErrorHandler errorHandler;
    private String gdprAccept;
    private String gdprBody;
    private String gdprDeny;
    private String gdprTitle;
    private Boolean isViewable;
    private WebView loadedWebView;
    private Placement placement;
    private boolean ready;

    /* renamed from: com.vungle.warren.ui.view.VungleWebClient$VungleWebViewRenderProcessClient */
    static class VungleWebViewRenderProcessClient extends WebViewRenderProcessClient {
        WebViewAPI.WebClientErrorHandler errorHandler;

        VungleWebViewRenderProcessClient(WebViewAPI.WebClientErrorHandler webClientErrorHandler) {
            this.errorHandler = webClientErrorHandler;
        }

        public void onRenderProcessResponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
        }

        public void onRenderProcessUnresponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
            String str = VungleWebClient.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("onRenderProcessUnresponsive(Title = ");
            sb.append(webView.getTitle());
            sb.append(", URL = ");
            sb.append(webView.getOriginalUrl());
            sb.append(", (webViewRenderProcess != null) = ");
            sb.append(webViewRenderProcess != null);
            Log.w(str, sb.toString());
            WebViewAPI.WebClientErrorHandler webClientErrorHandler = this.errorHandler;
            if (webClientErrorHandler != null) {
                webClientErrorHandler.onRenderProcessUnresponsive(webView, webViewRenderProcess);
            }
        }
    }

    public VungleWebClient(Advertisement advertisement2, Placement placement2) {
        this.advertisement = advertisement2;
        this.placement = placement2;
    }

    public void notifyPropertiesChange(boolean z) {
        if (this.loadedWebView != null) {
            JsonObject jsonObject = new JsonObject();
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.addProperty("width", (Number) Integer.valueOf(this.loadedWebView.getWidth()));
            jsonObject2.addProperty("height", (Number) Integer.valueOf(this.loadedWebView.getHeight()));
            JsonObject jsonObject3 = new JsonObject();
            jsonObject3.addProperty("x", (Number) 0);
            jsonObject3.addProperty("y", (Number) 0);
            jsonObject3.addProperty("width", (Number) Integer.valueOf(this.loadedWebView.getWidth()));
            jsonObject3.addProperty("height", (Number) Integer.valueOf(this.loadedWebView.getHeight()));
            JsonObject jsonObject4 = new JsonObject();
            jsonObject4.addProperty("sms", (Boolean) false);
            jsonObject4.addProperty("tel", (Boolean) false);
            jsonObject4.addProperty("calendar", (Boolean) false);
            jsonObject4.addProperty("storePicture", (Boolean) false);
            jsonObject4.addProperty("inlineVideo", (Boolean) false);
            jsonObject.add("maxSize", jsonObject2);
            jsonObject.add("screenSize", jsonObject2);
            jsonObject.add("defaultPosition", jsonObject3);
            jsonObject.add("currentPosition", jsonObject3);
            jsonObject.add("supports", jsonObject4);
            jsonObject.addProperty("placementType", this.advertisement.getTemplateType());
            Boolean bool = this.isViewable;
            if (bool != null) {
                jsonObject.addProperty("isViewable", bool);
            }
            jsonObject.addProperty("os", "android");
            jsonObject.addProperty("osVersion", Integer.toString(Build.VERSION.SDK_INT));
            jsonObject.addProperty("incentivized", Boolean.valueOf(this.placement.isIncentivized()));
            jsonObject.addProperty("enableBackImmediately", Boolean.valueOf(this.advertisement.getShowCloseDelay(this.placement.isIncentivized()) == 0));
            jsonObject.addProperty("version", "1.0");
            if (this.collectConsent) {
                jsonObject.addProperty("consentRequired", (Boolean) true);
                jsonObject.addProperty("consentTitleText", this.gdprTitle);
                jsonObject.addProperty("consentBodyText", this.gdprBody);
                jsonObject.addProperty("consentAcceptButtonText", this.gdprAccept);
                jsonObject.addProperty("consentDenyButtonText", this.gdprDeny);
            } else {
                jsonObject.addProperty("consentRequired", (Boolean) false);
            }
            "loadJsjavascript:window.vungle.mraidBridge.notifyPropertiesChange(" + jsonObject + "," + z + ")";
            this.loadedWebView.loadUrl("javascript:window.vungle.mraidBridge.notifyPropertiesChange(" + jsonObject + "," + z + ")");
        }
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        int adType = this.advertisement.getAdType();
        if (adType == 0) {
            webView.loadUrl("javascript:function actionClicked(action){Android.performAction(action);};");
        } else if (adType == 1) {
            this.loadedWebView = webView;
            webView.setVisibility(0);
            notifyPropertiesChange(true);
        } else {
            throw new IllegalArgumentException("Unknown Client Type!");
        }
        if (Build.VERSION.SDK_INT >= 29) {
            webView.setWebViewRenderProcessClient(new VungleWebViewRenderProcessClient(this.errorHandler));
        }
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        if (Build.VERSION.SDK_INT < 23) {
            Log.e(TAG, "Error desc " + str);
            Log.e(TAG, "Error for URL " + str2);
            String str3 = str2 + " " + str;
            WebViewAPI.WebClientErrorHandler webClientErrorHandler = this.errorHandler;
            if (webClientErrorHandler != null) {
                webClientErrorHandler.onReceivedError(str3);
            }
        }
    }

    @TargetApi(26)
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        String str = TAG;
        Log.w(str, "onRenderProcessGone url: " + webView.getUrl() + ",  did crash: " + renderProcessGoneDetail.didCrash());
        this.loadedWebView = null;
        WebViewAPI.WebClientErrorHandler webClientErrorHandler = this.errorHandler;
        if (webClientErrorHandler != null) {
            return webClientErrorHandler.onWebRenderingProcessGone(webView, renderProcessGoneDetail.didCrash());
        }
        return super.onRenderProcessGone(webView, renderProcessGoneDetail);
    }

    public void setAdVisibility(boolean z) {
        this.isViewable = Boolean.valueOf(z);
        notifyPropertiesChange(false);
    }

    public void setConsentStatus(boolean z, String str, String str2, String str3, String str4) {
        this.collectConsent = z;
        this.gdprTitle = str;
        this.gdprBody = str2;
        this.gdprAccept = str3;
        this.gdprDeny = str4;
    }

    public void setErrorHandler(WebViewAPI.WebClientErrorHandler webClientErrorHandler) {
        this.errorHandler = webClientErrorHandler;
    }

    public void setMRAIDDelegate(WebViewAPI.MRAIDDelegate mRAIDDelegate) {
        this.MRAIDDelegate = mRAIDDelegate;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        "MRAID Command " + str;
        if (TextUtils.isEmpty(str)) {
            Log.e(TAG, "Invalid URL ");
            return false;
        }
        Uri parse = Uri.parse(str);
        if (parse.getScheme() != null) {
            String scheme = parse.getScheme();
            if (scheme.equals("mraid")) {
                String host = parse.getHost();
                if (host == null) {
                    return false;
                }
                if ("propertiesChangeCompleted".equals(host) && !this.ready) {
                    webView.loadUrl("javascript:window.vungle.mraidBridge.notifyReadyEvent(" + this.advertisement.createMRAIDArgs() + ")");
                    this.ready = true;
                } else if (this.MRAIDDelegate != null) {
                    JsonObject jsonObject = new JsonObject();
                    for (String next : parse.getQueryParameterNames()) {
                        jsonObject.addProperty(next, parse.getQueryParameter(next));
                    }
                    if (this.MRAIDDelegate.processCommand(host, jsonObject)) {
                        webView.loadUrl("javascript:window.vungle.mraidBridge.notifyCommandComplete()");
                    }
                }
                return true;
            } else if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                "Open URL" + str;
                if (this.MRAIDDelegate != null) {
                    JsonObject jsonObject2 = new JsonObject();
                    jsonObject2.addProperty("url", str);
                    this.MRAIDDelegate.processCommand("openNonMraid", jsonObject2);
                }
                return true;
            }
        }
        return false;
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if (Build.VERSION.SDK_INT >= 23) {
            Log.e(TAG, "Error desc " + webResourceError.getDescription().toString());
            Log.e(TAG, "Error for URL " + webResourceRequest.getUrl().toString());
            String str = webResourceRequest.getUrl().toString() + " " + webResourceError.getDescription().toString();
            WebViewAPI.WebClientErrorHandler webClientErrorHandler = this.errorHandler;
            if (webClientErrorHandler != null) {
                webClientErrorHandler.onReceivedError(str);
            }
        }
    }
}
