package com.chartboost.sdk.impl;

import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.impl.y1 */
public class C2235y1 implements Runnable {

    /* renamed from: a */
    private final C2219v1 f7546a;

    /* renamed from: b */
    private final C2228x1 f7547b;

    /* renamed from: c */
    private final int f7548c;

    /* renamed from: d */
    private final JSONObject f7549d;

    /* renamed from: e */
    private final String f7550e;

    C2235y1(C2219v1 v1Var, C2228x1 x1Var, int i, String str, JSONObject jSONObject) {
        this.f7546a = v1Var;
        this.f7547b = x1Var;
        this.f7548c = i;
        this.f7550e = str;
        this.f7549d = jSONObject;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:28|29) */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:35|36) */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:22|23|107) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:45|46|47|48|93) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:79|80|81|82|119) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:83|84|85|86|99) */
    /* JADX WARNING: Code restructure failed: missing block: B:107:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        com.chartboost.sdk.Libraries.CBLogging.m8154b("NativeBridgeCommand", "Cannot find video file name");
        r14.f7547b.mo9573g("Parsing exception unknown field for video replay");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        com.chartboost.sdk.Libraries.CBLogging.m8154b("NativeBridgeCommand", "Cannot find video file name");
        r14.f7547b.mo9573g("Parsing exception unknown field for video play");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        com.chartboost.sdk.Libraries.CBLogging.m8154b("NativeBridgeCommand", "Cannot find video file name");
        r14.f7547b.mo9573g("Parsing exception unknown field for video pause");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0076 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x0097 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00be */
    /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x012e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:81:0x0213 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:85:0x023f */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:24:0x0082=Splitter:B:24:0x0082, B:81:0x0213=Splitter:B:81:0x0213, B:31:0x00a9=Splitter:B:31:0x00a9, B:17:0x005b=Splitter:B:17:0x005b, B:47:0x012e=Splitter:B:47:0x012e, B:85:0x023f=Splitter:B:85:0x023f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r14 = this;
            java.lang.String r0 = "http://"
            java.lang.String r1 = "Exception while opening a browser view with MRAID url"
            java.lang.String r2 = "ActivityNotFoundException occured when opening a url in a browser"
            java.lang.String r3 = "Exception occured while parsing the message for webview debug track event"
            int r4 = r14.f7548c     // Catch:{ Exception -> 0x0256 }
            r5 = 1148846080(0x447a0000, float:1000.0)
            java.lang.String r6 = ""
            java.lang.String r7 = "Cannot find duration parameter for the video"
            java.lang.String r8 = "duration"
            r9 = 0
            java.lang.String r10 = "Cannot find video file name"
            java.lang.String r11 = "name"
            java.lang.String r12 = "message"
            java.lang.String r13 = "NativeBridgeCommand"
            switch(r4) {
                case 0: goto L_0x0250;
                case 1: goto L_0x024a;
                case 2: goto L_0x021c;
                case 3: goto L_0x01f5;
                case 4: goto L_0x01ca;
                case 5: goto L_0x0141;
                case 6: goto L_0x013a;
                case 7: goto L_0x010a;
                case 8: goto L_0x00e2;
                case 9: goto L_0x00d0;
                case 10: goto L_0x00a9;
                case 11: goto L_0x0082;
                case 12: goto L_0x005b;
                case 13: goto L_0x0030;
                case 14: goto L_0x0020;
                default: goto L_0x001e;
            }
        L_0x001e:
            goto L_0x0274
        L_0x0020:
            com.chartboost.sdk.impl.x1 r0 = r14.f7547b     // Catch:{ Exception -> 0x0029 }
            org.json.JSONObject r1 = r14.f7549d     // Catch:{ Exception -> 0x0029 }
            r0.mo9568c((org.json.JSONObject) r1)     // Catch:{ Exception -> 0x0029 }
            goto L_0x0274
        L_0x0029:
            java.lang.String r0 = "Invalid set orientation command"
            com.chartboost.sdk.Libraries.CBLogging.m8154b(r13, r0)     // Catch:{ Exception -> 0x0256 }
            goto L_0x0274
        L_0x0030:
            org.json.JSONObject r0 = r14.f7549d     // Catch:{ Exception -> 0x004f }
            java.lang.String r0 = r0.getString(r12)     // Catch:{ Exception -> 0x004f }
            java.lang.Class<com.chartboost.sdk.impl.w1> r1 = com.chartboost.sdk.impl.C2223w1.class
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004f }
            r1.<init>()     // Catch:{ Exception -> 0x004f }
            java.lang.String r2 = "JS->Native Warning message: "
            r1.append(r2)     // Catch:{ Exception -> 0x004f }
            r1.append(r0)     // Catch:{ Exception -> 0x004f }
            r1.toString()     // Catch:{ Exception -> 0x004f }
            com.chartboost.sdk.impl.x1 r1 = r14.f7547b     // Catch:{ Exception -> 0x004f }
            r1.mo9573g(r0)     // Catch:{ Exception -> 0x004f }
            goto L_0x0274
        L_0x004f:
            java.lang.String r0 = "Warning message is empty"
            com.chartboost.sdk.Libraries.CBLogging.m8154b(r13, r0)     // Catch:{ Exception -> 0x0256 }
            com.chartboost.sdk.impl.x1 r0 = r14.f7547b     // Catch:{ Exception -> 0x0256 }
            r0.mo9573g(r6)     // Catch:{ Exception -> 0x0256 }
            goto L_0x0274
        L_0x005b:
            org.json.JSONObject r0 = r14.f7549d     // Catch:{ Exception -> 0x0076 }
            java.lang.String r0 = r0.getString(r11)     // Catch:{ Exception -> 0x0076 }
            com.chartboost.sdk.impl.x r1 = com.chartboost.sdk.impl.C2224x.m8805e()     // Catch:{ Exception -> 0x0076 }
            boolean r1 = r1.mo9549a((java.lang.CharSequence) r0)     // Catch:{ Exception -> 0x0076 }
            if (r1 != 0) goto L_0x006f
            com.chartboost.sdk.impl.x1 r1 = r14.f7547b     // Catch:{ Exception -> 0x0076 }
            r1.f7521p = r0     // Catch:{ Exception -> 0x0076 }
        L_0x006f:
            com.chartboost.sdk.impl.x1 r0 = r14.f7547b     // Catch:{ Exception -> 0x0076 }
            r0.mo9584y()     // Catch:{ Exception -> 0x0076 }
            goto L_0x0274
        L_0x0076:
            com.chartboost.sdk.Libraries.CBLogging.m8154b(r13, r10)     // Catch:{ Exception -> 0x0256 }
            com.chartboost.sdk.impl.x1 r0 = r14.f7547b     // Catch:{ Exception -> 0x0256 }
            java.lang.String r1 = "Parsing exception unknown field for video replay"
            r0.mo9573g(r1)     // Catch:{ Exception -> 0x0256 }
            goto L_0x0274
        L_0x0082:
            org.json.JSONObject r0 = r14.f7549d     // Catch:{ Exception -> 0x0097 }
            java.lang.String r0 = r0.getString(r11)     // Catch:{ Exception -> 0x0097 }
            com.chartboost.sdk.impl.x r1 = com.chartboost.sdk.impl.C2224x.m8805e()     // Catch:{ Exception -> 0x0097 }
            boolean r1 = r1.mo9549a((java.lang.CharSequence) r0)     // Catch:{ Exception -> 0x0097 }
            if (r1 != 0) goto L_0x00a1
            com.chartboost.sdk.impl.x1 r1 = r14.f7547b     // Catch:{ Exception -> 0x0097 }
            r1.f7521p = r0     // Catch:{ Exception -> 0x0097 }
            goto L_0x00a1
        L_0x0097:
            com.chartboost.sdk.Libraries.CBLogging.m8154b(r13, r10)     // Catch:{ Exception -> 0x0256 }
            com.chartboost.sdk.impl.x1 r0 = r14.f7547b     // Catch:{ Exception -> 0x0256 }
            java.lang.String r1 = "Parsing exception unknown field for video play"
            r0.mo9573g(r1)     // Catch:{ Exception -> 0x0256 }
        L_0x00a1:
            com.chartboost.sdk.impl.x1 r0 = r14.f7547b     // Catch:{ Exception -> 0x0256 }
            r1 = 2
            r0.mo9564b((int) r1)     // Catch:{ Exception -> 0x0256 }
            goto L_0x0274
        L_0x00a9:
            org.json.JSONObject r0 = r14.f7549d     // Catch:{ Exception -> 0x00be }
            java.lang.String r0 = r0.getString(r11)     // Catch:{ Exception -> 0x00be }
            com.chartboost.sdk.impl.x r1 = com.chartboost.sdk.impl.C2224x.m8805e()     // Catch:{ Exception -> 0x00be }
            boolean r1 = r1.mo9549a((java.lang.CharSequence) r0)     // Catch:{ Exception -> 0x00be }
            if (r1 != 0) goto L_0x00c8
            com.chartboost.sdk.impl.x1 r1 = r14.f7547b     // Catch:{ Exception -> 0x00be }
            r1.f7521p = r0     // Catch:{ Exception -> 0x00be }
            goto L_0x00c8
        L_0x00be:
            com.chartboost.sdk.Libraries.CBLogging.m8154b(r13, r10)     // Catch:{ Exception -> 0x0256 }
            com.chartboost.sdk.impl.x1 r0 = r14.f7547b     // Catch:{ Exception -> 0x0256 }
            java.lang.String r1 = "Parsing exception unknown field for video pause"
            r0.mo9573g(r1)     // Catch:{ Exception -> 0x0256 }
        L_0x00c8:
            com.chartboost.sdk.impl.x1 r0 = r14.f7547b     // Catch:{ Exception -> 0x0256 }
            r1 = 3
            r0.mo9564b((int) r1)     // Catch:{ Exception -> 0x0256 }
            goto L_0x0274
        L_0x00d0:
            com.chartboost.sdk.impl.v1 r0 = r14.f7546a     // Catch:{ Exception -> 0x0256 }
            r0.onHideCustomView()     // Catch:{ Exception -> 0x0256 }
            com.chartboost.sdk.impl.x1 r0 = r14.f7547b     // Catch:{ Exception -> 0x0256 }
            r1 = 1
            r0.mo9564b((int) r1)     // Catch:{ Exception -> 0x0256 }
            com.chartboost.sdk.impl.x1 r0 = r14.f7547b     // Catch:{ Exception -> 0x0256 }
            r0.mo9582w()     // Catch:{ Exception -> 0x0256 }
            goto L_0x0274
        L_0x00e2:
            org.json.JSONObject r0 = r14.f7549d     // Catch:{ Exception -> 0x0103 }
            java.lang.String r1 = "event"
            java.lang.String r0 = r0.getString(r1)     // Catch:{ Exception -> 0x0103 }
            com.chartboost.sdk.impl.x1 r1 = r14.f7547b     // Catch:{ Exception -> 0x0103 }
            r1.mo9572f(r0)     // Catch:{ Exception -> 0x0103 }
            java.lang.Class<com.chartboost.sdk.impl.w1> r1 = com.chartboost.sdk.impl.C2223w1.class
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0103 }
            r1.<init>()     // Catch:{ Exception -> 0x0103 }
            java.lang.String r2 = "JS->Native Track VAST event message: "
            r1.append(r2)     // Catch:{ Exception -> 0x0103 }
            r1.append(r0)     // Catch:{ Exception -> 0x0103 }
            r1.toString()     // Catch:{ Exception -> 0x0103 }
            goto L_0x0274
        L_0x0103:
            java.lang.String r0 = "Exception occured while parsing the message for webview tracking VAST events"
            com.chartboost.sdk.Libraries.CBLogging.m8154b(r13, r0)     // Catch:{ Exception -> 0x0256 }
            goto L_0x0274
        L_0x010a:
            org.json.JSONObject r0 = r14.f7549d     // Catch:{ Exception -> 0x012e }
            double r0 = r0.getDouble(r8)     // Catch:{ Exception -> 0x012e }
            float r0 = (float) r0     // Catch:{ Exception -> 0x012e }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012e }
            r1.<init>()     // Catch:{ Exception -> 0x012e }
            java.lang.String r2 = "######### JS->Native Video total player duration"
            r1.append(r2)     // Catch:{ Exception -> 0x012e }
            float r0 = r0 * r5
            r1.append(r0)     // Catch:{ Exception -> 0x012e }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x012e }
            com.chartboost.sdk.Libraries.CBLogging.m8152a(r13, r1)     // Catch:{ Exception -> 0x012e }
            com.chartboost.sdk.impl.x1 r1 = r14.f7547b     // Catch:{ Exception -> 0x012e }
            r1.mo9563b((float) r0)     // Catch:{ Exception -> 0x012e }
            goto L_0x0274
        L_0x012e:
            com.chartboost.sdk.impl.x1 r0 = r14.f7547b     // Catch:{ Exception -> 0x0256 }
            java.lang.String r1 = "Parsing exception unknown field for total player duration"
            r0.mo9573g(r1)     // Catch:{ Exception -> 0x0256 }
            com.chartboost.sdk.Libraries.CBLogging.m8154b(r13, r7)     // Catch:{ Exception -> 0x0256 }
            goto L_0x0274
        L_0x013a:
            com.chartboost.sdk.impl.x1 r0 = r14.f7547b     // Catch:{ Exception -> 0x0256 }
            r0.mo9581v()     // Catch:{ Exception -> 0x0256 }
            goto L_0x0274
        L_0x0141:
            org.json.JSONObject r3 = r14.f7549d     // Catch:{ ActivityNotFoundException -> 0x01bd, Exception -> 0x01b0 }
            java.lang.String r4 = "url"
            java.lang.String r3 = r3.getString(r4)     // Catch:{ ActivityNotFoundException -> 0x01bd, Exception -> 0x01b0 }
            boolean r4 = r3.startsWith(r0)     // Catch:{ ActivityNotFoundException -> 0x01bd, Exception -> 0x01b0 }
            if (r4 != 0) goto L_0x0166
            java.lang.String r4 = "https://"
            boolean r4 = r3.startsWith(r4)     // Catch:{ ActivityNotFoundException -> 0x01bd, Exception -> 0x01b0 }
            if (r4 != 0) goto L_0x0166
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ ActivityNotFoundException -> 0x01bd, Exception -> 0x01b0 }
            r4.<init>()     // Catch:{ ActivityNotFoundException -> 0x01bd, Exception -> 0x01b0 }
            r4.append(r0)     // Catch:{ ActivityNotFoundException -> 0x01bd, Exception -> 0x01b0 }
            r4.append(r3)     // Catch:{ ActivityNotFoundException -> 0x01bd, Exception -> 0x01b0 }
            java.lang.String r3 = r4.toString()     // Catch:{ ActivityNotFoundException -> 0x01bd, Exception -> 0x01b0 }
        L_0x0166:
            com.chartboost.sdk.impl.x1 r0 = r14.f7547b     // Catch:{ ActivityNotFoundException -> 0x01bd, Exception -> 0x01b0 }
            boolean r0 = r0.mo9239a((java.lang.String) r3, (org.json.JSONObject) r9)     // Catch:{ ActivityNotFoundException -> 0x01bd, Exception -> 0x01b0 }
            if (r0 != 0) goto L_0x0274
            android.content.Intent r0 = new android.content.Intent     // Catch:{ ActivityNotFoundException -> 0x01bd, Exception -> 0x01b0 }
            java.lang.String r4 = "android.intent.action.VIEW"
            android.net.Uri r5 = android.net.Uri.parse(r3)     // Catch:{ ActivityNotFoundException -> 0x01bd, Exception -> 0x01b0 }
            r0.<init>(r4, r5)     // Catch:{ ActivityNotFoundException -> 0x01bd, Exception -> 0x01b0 }
            com.chartboost.sdk.impl.x1 r4 = r14.f7547b     // Catch:{ ActivityNotFoundException -> 0x01bd, Exception -> 0x01b0 }
            com.chartboost.sdk.impl.x1$d r4 = r4.mo9249i()     // Catch:{ ActivityNotFoundException -> 0x01bd, Exception -> 0x01b0 }
            if (r4 == 0) goto L_0x0274
            android.content.Context r4 = r4.getContext()     // Catch:{ ActivityNotFoundException -> 0x01bd, Exception -> 0x01b0 }
            if (r4 == 0) goto L_0x0274
            android.content.pm.PackageManager r5 = r4.getPackageManager()     // Catch:{ ActivityNotFoundException -> 0x01bd, Exception -> 0x01b0 }
            android.content.ComponentName r5 = r0.resolveActivity(r5)     // Catch:{ ActivityNotFoundException -> 0x01bd, Exception -> 0x01b0 }
            if (r5 == 0) goto L_0x0274
            r4.startActivity(r0)     // Catch:{ ActivityNotFoundException -> 0x01bd, Exception -> 0x01b0 }
            java.lang.Class<com.chartboost.sdk.impl.w1> r0 = com.chartboost.sdk.impl.C2223w1.class
            java.lang.String r0 = r0.getName()     // Catch:{ ActivityNotFoundException -> 0x01bd, Exception -> 0x01b0 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ ActivityNotFoundException -> 0x01bd, Exception -> 0x01b0 }
            r4.<init>()     // Catch:{ ActivityNotFoundException -> 0x01bd, Exception -> 0x01b0 }
            java.lang.String r5 = "JS->Native Track MRAID openUrl: "
            r4.append(r5)     // Catch:{ ActivityNotFoundException -> 0x01bd, Exception -> 0x01b0 }
            r4.append(r3)     // Catch:{ ActivityNotFoundException -> 0x01bd, Exception -> 0x01b0 }
            java.lang.String r3 = r4.toString()     // Catch:{ ActivityNotFoundException -> 0x01bd, Exception -> 0x01b0 }
            com.chartboost.sdk.Libraries.CBLogging.m8152a(r0, r3)     // Catch:{ ActivityNotFoundException -> 0x01bd, Exception -> 0x01b0 }
            goto L_0x0274
        L_0x01b0:
            r0 = move-exception
            java.lang.Class r2 = r14.getClass()     // Catch:{ Exception -> 0x0256 }
            com.chartboost.sdk.Tracking.C2098a.m8288a((java.lang.Class) r2, (java.lang.String) r1, (java.lang.Exception) r0)     // Catch:{ Exception -> 0x0256 }
            com.chartboost.sdk.Libraries.CBLogging.m8154b(r13, r1)     // Catch:{ Exception -> 0x0256 }
            goto L_0x0274
        L_0x01bd:
            r0 = move-exception
            java.lang.Class r1 = r14.getClass()     // Catch:{ Exception -> 0x0256 }
            com.chartboost.sdk.Tracking.C2098a.m8288a((java.lang.Class) r1, (java.lang.String) r2, (java.lang.Exception) r0)     // Catch:{ Exception -> 0x0256 }
            com.chartboost.sdk.Libraries.CBLogging.m8154b(r13, r2)     // Catch:{ Exception -> 0x0256 }
            goto L_0x0274
        L_0x01ca:
            org.json.JSONObject r0 = r14.f7549d     // Catch:{ Exception -> 0x01e9 }
            java.lang.String r0 = r0.getString(r12)     // Catch:{ Exception -> 0x01e9 }
            java.lang.Class<com.chartboost.sdk.impl.w1> r1 = com.chartboost.sdk.impl.C2223w1.class
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01e9 }
            r1.<init>()     // Catch:{ Exception -> 0x01e9 }
            java.lang.String r2 = "JS->Native Error message: "
            r1.append(r2)     // Catch:{ Exception -> 0x01e9 }
            r1.append(r0)     // Catch:{ Exception -> 0x01e9 }
            r1.toString()     // Catch:{ Exception -> 0x01e9 }
            com.chartboost.sdk.impl.x1 r1 = r14.f7547b     // Catch:{ Exception -> 0x01e9 }
            r1.mo9567c((java.lang.String) r0)     // Catch:{ Exception -> 0x01e9 }
            goto L_0x0274
        L_0x01e9:
            java.lang.String r0 = "Error message is empty"
            com.chartboost.sdk.Libraries.CBLogging.m8154b(r13, r0)     // Catch:{ Exception -> 0x0256 }
            com.chartboost.sdk.impl.x1 r0 = r14.f7547b     // Catch:{ Exception -> 0x0256 }
            r0.mo9567c((java.lang.String) r6)     // Catch:{ Exception -> 0x0256 }
            goto L_0x0274
        L_0x01f5:
            org.json.JSONObject r0 = r14.f7549d     // Catch:{ Exception -> 0x0213 }
            java.lang.String r0 = r0.getString(r12)     // Catch:{ Exception -> 0x0213 }
            java.lang.Class<com.chartboost.sdk.impl.w1> r1 = com.chartboost.sdk.impl.C2223w1.class
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0213 }
            r1.<init>()     // Catch:{ Exception -> 0x0213 }
            java.lang.String r2 = "JS->Native Debug message: "
            r1.append(r2)     // Catch:{ Exception -> 0x0213 }
            r1.append(r0)     // Catch:{ Exception -> 0x0213 }
            r1.toString()     // Catch:{ Exception -> 0x0213 }
            com.chartboost.sdk.impl.x1 r1 = r14.f7547b     // Catch:{ Exception -> 0x0213 }
            r1.mo9571e(r0)     // Catch:{ Exception -> 0x0213 }
            goto L_0x0274
        L_0x0213:
            com.chartboost.sdk.Libraries.CBLogging.m8154b(r13, r3)     // Catch:{ Exception -> 0x0256 }
            com.chartboost.sdk.impl.x1 r0 = r14.f7547b     // Catch:{ Exception -> 0x0256 }
            r0.mo9571e(r3)     // Catch:{ Exception -> 0x0256 }
            goto L_0x0274
        L_0x021c:
            org.json.JSONObject r0 = r14.f7549d     // Catch:{ Exception -> 0x023f }
            double r0 = r0.getDouble(r8)     // Catch:{ Exception -> 0x023f }
            float r0 = (float) r0     // Catch:{ Exception -> 0x023f }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x023f }
            r1.<init>()     // Catch:{ Exception -> 0x023f }
            java.lang.String r2 = "######### JS->Native Video current player duration"
            r1.append(r2)     // Catch:{ Exception -> 0x023f }
            float r0 = r0 * r5
            r1.append(r0)     // Catch:{ Exception -> 0x023f }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x023f }
            com.chartboost.sdk.Libraries.CBLogging.m8152a(r13, r1)     // Catch:{ Exception -> 0x023f }
            com.chartboost.sdk.impl.x1 r1 = r14.f7547b     // Catch:{ Exception -> 0x023f }
            r1.mo9562a((float) r0)     // Catch:{ Exception -> 0x023f }
            goto L_0x0274
        L_0x023f:
            com.chartboost.sdk.impl.x1 r0 = r14.f7547b     // Catch:{ Exception -> 0x0256 }
            java.lang.String r1 = "Parsing exception unknown field for current player duration"
            r0.mo9573g(r1)     // Catch:{ Exception -> 0x0256 }
            com.chartboost.sdk.Libraries.CBLogging.m8154b(r13, r7)     // Catch:{ Exception -> 0x0256 }
            goto L_0x0274
        L_0x024a:
            com.chartboost.sdk.impl.x1 r0 = r14.f7547b     // Catch:{ Exception -> 0x0256 }
            r0.mo9234a()     // Catch:{ Exception -> 0x0256 }
            goto L_0x0274
        L_0x0250:
            com.chartboost.sdk.impl.x1 r0 = r14.f7547b     // Catch:{ Exception -> 0x0256 }
            r0.mo9240a((org.json.JSONObject) r9)     // Catch:{ Exception -> 0x0256 }
            goto L_0x0274
        L_0x0256:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "run("
            r1.append(r2)
            java.lang.String r2 = r14.f7550e
            r1.append(r2)
            java.lang.String r2 = ")"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.Class<com.chartboost.sdk.impl.y1> r2 = com.chartboost.sdk.impl.C2235y1.class
            com.chartboost.sdk.Tracking.C2098a.m8288a((java.lang.Class) r2, (java.lang.String) r1, (java.lang.Exception) r0)
        L_0x0274:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.C2235y1.run():void");
    }
}
