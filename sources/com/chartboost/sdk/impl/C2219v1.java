package com.chartboost.sdk.impl;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.chartboost.sdk.Libraries.CBLogging;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.impl.v1 */
public class C2219v1 extends WebChromeClient {

    /* renamed from: a */
    private View f7476a;

    /* renamed from: b */
    private ViewGroup f7477b;

    /* renamed from: c */
    private boolean f7478c = false;

    /* renamed from: d */
    private FrameLayout f7479d;

    /* renamed from: e */
    private WebChromeClient.CustomViewCallback f7480e;

    /* renamed from: f */
    private C2220a f7481f;

    /* renamed from: g */
    private final C2228x1 f7482g;

    /* renamed from: h */
    private final Handler f7483h;

    /* renamed from: com.chartboost.sdk.impl.v1$a */
    public interface C2220a {
        /* renamed from: a */
        void mo9531a(boolean z);
    }

    public C2219v1(View view, ViewGroup viewGroup, View view2, C2223w1 w1Var, C2228x1 x1Var, Handler handler) {
        this.f7476a = view;
        this.f7477b = viewGroup;
        this.f7482g = x1Var;
        this.f7483h = handler;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String mo9525a(org.json.JSONObject r18, java.lang.String r19) {
        /*
            r17 = this;
            r6 = r17
            r4 = r19
            int r0 = r19.hashCode()
            r5 = 6
            r7 = 5
            r8 = 10
            r9 = 12
            r10 = 2
            r11 = 1
            r12 = 9
            r13 = 4
            r14 = 3
            r15 = 14
            r16 = 7
            r1 = 0
            switch(r0) {
                case -2012425132: goto L_0x00fd;
                case -1757019252: goto L_0x00f2;
                case -1554056650: goto L_0x00e8;
                case -1263203643: goto L_0x00dd;
                case -1086137328: goto L_0x00d3;
                case -715147645: goto L_0x00c8;
                case -640720077: goto L_0x00be;
                case 3529469: goto L_0x00b3;
                case 94750088: goto L_0x00a9;
                case 94756344: goto L_0x009f;
                case 95458899: goto L_0x0093;
                case 96784904: goto L_0x0087;
                case 133423073: goto L_0x007b;
                case 160987616: goto L_0x0070;
                case 937504109: goto L_0x0064;
                case 939594121: goto L_0x0059;
                case 1000390722: goto L_0x004e;
                case 1082777163: goto L_0x0042;
                case 1124446108: goto L_0x0036;
                case 1270488759: goto L_0x002a;
                case 1880941391: goto L_0x001e;
                default: goto L_0x001c;
            }
        L_0x001c:
            goto L_0x0108
        L_0x001e:
            java.lang.String r0 = "getMaxSize"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0108
            r0 = 15
            goto L_0x0109
        L_0x002a:
            java.lang.String r0 = "tracking"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0108
            r0 = 13
            goto L_0x0109
        L_0x0036:
            java.lang.String r0 = "warning"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0108
            r0 = 11
            goto L_0x0109
        L_0x0042:
            java.lang.String r0 = "totalVideoDuration"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0108
            r0 = 8
            goto L_0x0109
        L_0x004e:
            java.lang.String r0 = "videoReplay"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0108
            r0 = 6
            goto L_0x0109
        L_0x0059:
            java.lang.String r0 = "videoPaused"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0108
            r0 = 5
            goto L_0x0109
        L_0x0064:
            java.lang.String r0 = "getOrientationProperties"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0108
            r0 = 19
            goto L_0x0109
        L_0x0070:
            java.lang.String r0 = "getParameters"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0108
            r0 = 0
            goto L_0x0109
        L_0x007b:
            java.lang.String r0 = "setOrientationProperties"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0108
            r0 = 20
            goto L_0x0109
        L_0x0087:
            java.lang.String r0 = "error"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0108
            r0 = 10
            goto L_0x0109
        L_0x0093:
            java.lang.String r0 = "debug"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0108
            r0 = 12
            goto L_0x0109
        L_0x009f:
            java.lang.String r0 = "close"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0108
            r0 = 2
            goto L_0x0109
        L_0x00a9:
            java.lang.String r0 = "click"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0108
            r0 = 1
            goto L_0x0109
        L_0x00b3:
            java.lang.String r0 = "show"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0108
            r0 = 9
            goto L_0x0109
        L_0x00be:
            java.lang.String r0 = "videoPlaying"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0108
            r0 = 4
            goto L_0x0109
        L_0x00c8:
            java.lang.String r0 = "getScreenSize"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0108
            r0 = 16
            goto L_0x0109
        L_0x00d3:
            java.lang.String r0 = "videoCompleted"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0108
            r0 = 3
            goto L_0x0109
        L_0x00dd:
            java.lang.String r0 = "openUrl"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0108
            r0 = 14
            goto L_0x0109
        L_0x00e8:
            java.lang.String r0 = "currentVideoDuration"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0108
            r0 = 7
            goto L_0x0109
        L_0x00f2:
            java.lang.String r0 = "getCurrentPosition"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0108
            r0 = 17
            goto L_0x0109
        L_0x00fd:
            java.lang.String r0 = "getDefaultPosition"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0108
            r0 = 18
            goto L_0x0109
        L_0x0108:
            r0 = -1
        L_0x0109:
            java.lang.String r2 = " callback triggered."
            java.lang.String r3 = "JavaScript to native "
            switch(r0) {
                case 0: goto L_0x0204;
                case 1: goto L_0x01db;
                case 2: goto L_0x01d9;
                case 3: goto L_0x01d6;
                case 4: goto L_0x01d3;
                case 5: goto L_0x01d0;
                case 6: goto L_0x01cd;
                case 7: goto L_0x01cb;
                case 8: goto L_0x01c9;
                case 9: goto L_0x01dc;
                case 10: goto L_0x01c5;
                case 11: goto L_0x01c0;
                case 12: goto L_0x01be;
                case 13: goto L_0x01bb;
                case 14: goto L_0x01b9;
                case 15: goto L_0x01a1;
                case 16: goto L_0x0189;
                case 17: goto L_0x0171;
                case 18: goto L_0x0159;
                case 19: goto L_0x0141;
                case 20: goto L_0x012c;
                default: goto L_0x0110;
            }
        L_0x0110:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
            r0.append(r4)
            java.lang.String r1 = " callback not recognized."
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "CBWebChromeClient"
            android.util.Log.e(r1, r0)
            java.lang.String r0 = "Function name not recognized."
            return r0
        L_0x012c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
            r0.append(r4)
            r0.append(r2)
            r0.toString()
            r5 = 14
            goto L_0x01dc
        L_0x0141:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
            r0.append(r4)
            r0.append(r2)
            r0.toString()
            com.chartboost.sdk.impl.x1 r0 = r6.f7482g
            java.lang.String r0 = r0.mo9579t()
            return r0
        L_0x0159:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
            r0.append(r4)
            r0.append(r2)
            r0.toString()
            com.chartboost.sdk.impl.x1 r0 = r6.f7482g
            java.lang.String r0 = r0.mo9577r()
            return r0
        L_0x0171:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
            r0.append(r4)
            r0.append(r2)
            r0.toString()
            com.chartboost.sdk.impl.x1 r0 = r6.f7482g
            java.lang.String r0 = r0.mo9576q()
            return r0
        L_0x0189:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
            r0.append(r4)
            r0.append(r2)
            r0.toString()
            com.chartboost.sdk.impl.x1 r0 = r6.f7482g
            java.lang.String r0 = r0.mo9580u()
            return r0
        L_0x01a1:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
            r0.append(r4)
            r0.append(r2)
            r0.toString()
            com.chartboost.sdk.impl.x1 r0 = r6.f7482g
            java.lang.String r0 = r0.mo9578s()
            return r0
        L_0x01b9:
            r5 = 5
            goto L_0x01dc
        L_0x01bb:
            r5 = 8
            goto L_0x01dc
        L_0x01be:
            r5 = 3
            goto L_0x01dc
        L_0x01c0:
            java.lang.Class<com.chartboost.sdk.impl.w1> r0 = com.chartboost.sdk.impl.C2223w1.class
            r5 = 13
            goto L_0x01dc
        L_0x01c5:
            java.lang.Class<com.chartboost.sdk.impl.w1> r0 = com.chartboost.sdk.impl.C2223w1.class
            r5 = 4
            goto L_0x01dc
        L_0x01c9:
            r5 = 7
            goto L_0x01dc
        L_0x01cb:
            r5 = 2
            goto L_0x01dc
        L_0x01cd:
            r5 = 12
            goto L_0x01dc
        L_0x01d0:
            r5 = 10
            goto L_0x01dc
        L_0x01d3:
            r5 = 11
            goto L_0x01dc
        L_0x01d6:
            r5 = 9
            goto L_0x01dc
        L_0x01d9:
            r5 = 1
            goto L_0x01dc
        L_0x01db:
            r5 = 0
        L_0x01dc:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
            r0.append(r4)
            r0.append(r2)
            r0.toString()
            com.chartboost.sdk.impl.y1 r7 = new com.chartboost.sdk.impl.y1
            com.chartboost.sdk.impl.x1 r2 = r6.f7482g
            r0 = r7
            r1 = r17
            r3 = r5
            r4 = r19
            r5 = r18
            r0.<init>(r1, r2, r3, r4, r5)
            android.os.Handler r0 = r6.f7483h
            r0.post(r7)
            java.lang.String r0 = "Native function successfully called."
            return r0
        L_0x0204:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
            r0.append(r4)
            r0.append(r2)
            r0.toString()
            com.chartboost.sdk.impl.x1 r0 = r6.f7482g
            com.chartboost.sdk.Model.c r0 = r0.f7073g
            if (r0 == 0) goto L_0x028c
            com.chartboost.sdk.Model.a r0 = r0.f6938r
            if (r0 == 0) goto L_0x028c
            com.chartboost.sdk.Libraries.e$a[] r1 = new com.chartboost.sdk.Libraries.C2076e.C2077a[r1]
            org.json.JSONObject r1 = com.chartboost.sdk.Libraries.C2076e.m8186a(r1)
            java.util.Map<java.lang.String, java.lang.String> r2 = r0.f6898d
            java.util.Set r2 = r2.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x022f:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0249
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r3 = r3.getValue()
            com.chartboost.sdk.Libraries.C2076e.m8187a(r1, r4, r3)
            goto L_0x022f
        L_0x0249:
            java.util.Map<java.lang.String, com.chartboost.sdk.Model.b> r0 = r0.f6897c
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0253:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0287
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getValue()
            com.chartboost.sdk.Model.b r3 = (com.chartboost.sdk.Model.C2087b) r3
            java.lang.Object r2 = r2.getKey()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r3.f6914a
            r4.append(r5)
            java.lang.String r5 = "/"
            r4.append(r5)
            java.lang.String r3 = r3.f6915b
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            com.chartboost.sdk.Libraries.C2076e.m8187a(r1, r2, r3)
            goto L_0x0253
        L_0x0287:
            java.lang.String r0 = r1.toString()
            return r0
        L_0x028c:
            java.lang.String r0 = "{}"
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.C2219v1.mo9525a(org.json.JSONObject, java.lang.String):java.lang.String");
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        Class<C2219v1> cls = C2219v1.class;
        "Chartboost Webview:" + consoleMessage.message() + " -- From line " + consoleMessage.lineNumber() + " of " + consoleMessage.sourceId();
        return true;
    }

    public void onHideCustomView() {
        if (this.f7478c) {
            this.f7477b.setVisibility(4);
            this.f7477b.removeView(this.f7479d);
            this.f7476a.setVisibility(0);
            WebChromeClient.CustomViewCallback customViewCallback = this.f7480e;
            if (customViewCallback != null && !customViewCallback.getClass().getName().contains(".chromium.")) {
                this.f7480e.onCustomViewHidden();
            }
            this.f7478c = false;
            this.f7479d = null;
            this.f7480e = null;
            C2220a aVar = this.f7481f;
            if (aVar != null) {
                aVar.mo9531a(false);
            }
        }
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        try {
            JSONObject jSONObject = new JSONObject(str2);
            jsPromptResult.confirm(mo9525a(jSONObject.getJSONObject("eventArgs"), jSONObject.getString("eventType")));
            return true;
        } catch (JSONException unused) {
            CBLogging.m8154b("CBWebChromeClient", "Exception caught parsing the function name from js to native");
            return true;
        }
    }

    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        if (view instanceof FrameLayout) {
            this.f7478c = true;
            this.f7479d = (FrameLayout) view;
            this.f7480e = customViewCallback;
            this.f7476a.setVisibility(4);
            this.f7477b.addView(this.f7479d, new ViewGroup.LayoutParams(-1, -1));
            this.f7477b.setVisibility(0);
            C2220a aVar = this.f7481f;
            if (aVar != null) {
                aVar.mo9531a(true);
            }
        }
    }

    public void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        onShowCustomView(view, customViewCallback);
    }
}
