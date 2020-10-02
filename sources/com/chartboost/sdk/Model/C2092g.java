package com.chartboost.sdk.Model;

import android.content.SharedPreferences;
import com.chartboost.sdk.Libraries.C2074d;
import com.chartboost.sdk.Libraries.C2082i;
import com.chartboost.sdk.impl.C2222w0;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.Model.g */
public class C2092g {

    /* renamed from: a */
    public final C2074d f6970a;

    /* renamed from: b */
    public final C2222w0 f6971b;

    /* renamed from: c */
    public final AtomicReference<C2093h> f6972c;

    /* renamed from: d */
    public final SharedPreferences f6973d;

    /* renamed from: e */
    public final C2082i f6974e;

    /* renamed from: f */
    public final String f6975f;

    /* renamed from: g */
    public final String f6976g;

    /* renamed from: h */
    public final String f6977h;

    /* renamed from: i */
    public final String f6978i;

    /* renamed from: j */
    public String f6979j;

    /* renamed from: k */
    public String f6980k;

    /* renamed from: l */
    public final String f6981l;

    /* renamed from: m */
    public final Integer f6982m;

    /* renamed from: n */
    public final Integer f6983n;

    /* renamed from: o */
    public final Integer f6984o;

    /* renamed from: p */
    public final Integer f6985p;

    /* renamed from: q */
    public final String f6986q;

    /* renamed from: r */
    public final Float f6987r;

    /* renamed from: s */
    public final String f6988s;

    /* renamed from: t */
    public final String f6989t;

    /* renamed from: u */
    public final String f6990u;

    /* renamed from: v */
    public final JSONObject f6991v;

    /* renamed from: w */
    public final String f6992w;

    /* renamed from: x */
    public final boolean f6993x;

    /* renamed from: y */
    public final String f6994y;

    /* renamed from: z */
    public final Integer f6995z;

    /* JADX WARNING: Removed duplicated region for block: B:49:0x01a6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C2092g(android.content.Context r6, java.lang.String r7, com.chartboost.sdk.Libraries.C2074d r8, com.chartboost.sdk.impl.C2222w0 r9, java.util.concurrent.atomic.AtomicReference<com.chartboost.sdk.Model.C2093h> r10, android.content.SharedPreferences r11, com.chartboost.sdk.Libraries.C2082i r12) {
        /*
            r5 = this;
            java.lang.String r0 = "RequestBody"
            r5.<init>()
            r5.f6970a = r8
            r5.f6971b = r9
            r5.f6972c = r10
            r5.f6973d = r11
            r5.f6974e = r12
            r5.f6988s = r7
            java.lang.String r7 = android.os.Build.PRODUCT
            java.lang.String r8 = "sdk"
            boolean r7 = r8.equals(r7)
            if (r7 != 0) goto L_0x0037
            java.lang.String r7 = android.os.Build.PRODUCT
            java.lang.String r8 = "google_sdk"
            boolean r7 = r8.equals(r7)
            if (r7 != 0) goto L_0x0037
            java.lang.String r7 = android.os.Build.MANUFACTURER
            if (r7 == 0) goto L_0x0032
            java.lang.String r8 = "Genymotion"
            boolean r7 = r7.contains(r8)
            if (r7 == 0) goto L_0x0032
            goto L_0x0037
        L_0x0032:
            java.lang.String r7 = android.os.Build.MODEL
            r5.f6975f = r7
            goto L_0x003b
        L_0x0037:
            java.lang.String r7 = "Android Simulator"
            r5.f6975f = r7
        L_0x003b:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = android.os.Build.MANUFACTURER
            r7.append(r8)
            java.lang.String r8 = " "
            r7.append(r8)
            java.lang.String r8 = android.os.Build.MODEL
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r5.f6989t = r7
            java.lang.String r7 = com.chartboost.sdk.impl.C2169j1.m8622e(r6)
            r5.f6990u = r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Android "
            r7.append(r8)
            java.lang.String r8 = android.os.Build.VERSION.RELEASE
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r5.f6976g = r7
            java.util.Locale r7 = java.util.Locale.getDefault()
            java.lang.String r7 = r7.getCountry()
            r5.f6977h = r7
            java.util.Locale r7 = java.util.Locale.getDefault()
            java.lang.String r7 = r7.getLanguage()
            r5.f6978i = r7
            java.lang.String r7 = "8.0.3"
            r5.f6981l = r7
            android.content.res.Resources r7 = r6.getResources()
            android.util.DisplayMetrics r7 = r7.getDisplayMetrics()
            float r7 = r7.density
            java.lang.Float r7 = java.lang.Float.valueOf(r7)
            r5.f6987r = r7
            java.lang.String r7 = r6.getPackageName()     // Catch:{ Exception -> 0x00ad }
            android.content.pm.PackageManager r8 = r6.getPackageManager()     // Catch:{ Exception -> 0x00ad }
            r9 = 128(0x80, float:1.794E-43)
            android.content.pm.PackageInfo r8 = r8.getPackageInfo(r7, r9)     // Catch:{ Exception -> 0x00ad }
            java.lang.String r8 = r8.versionName     // Catch:{ Exception -> 0x00ad }
            r5.f6979j = r8     // Catch:{ Exception -> 0x00ad }
            r5.f6980k = r7     // Catch:{ Exception -> 0x00ad }
            goto L_0x00b3
        L_0x00ad:
            r7 = move-exception
            java.lang.String r8 = "Exception raised getting package mager object"
            com.chartboost.sdk.Libraries.CBLogging.m8153a(r0, r8, r7)
        L_0x00b3:
            java.lang.String r7 = "phone"
            java.lang.Object r7 = r6.getSystemService(r7)
            android.telephony.TelephonyManager r7 = (android.telephony.TelephonyManager) r7
            java.lang.String r8 = ""
            r9 = 0
            if (r7 == 0) goto L_0x0133
            int r10 = r7.getPhoneType()
            if (r10 == 0) goto L_0x0133
            int r10 = r7.getSimState()
            r11 = 5
            if (r10 != r11) goto L_0x0133
            r10 = 0
            java.lang.String r12 = r7.getSimOperator()     // Catch:{ Exception -> 0x00d3 }
            goto L_0x00dc
        L_0x00d3:
            r12 = move-exception
            java.lang.Class<com.chartboost.sdk.Chartboost> r1 = com.chartboost.sdk.Chartboost.class
            java.lang.String r2 = "Unable to retrieve sim operator information"
            com.chartboost.sdk.Tracking.C2098a.m8288a((java.lang.Class) r1, (java.lang.String) r2, (java.lang.Exception) r12)
            r12 = r10
        L_0x00dc:
            r1 = 3
            if (r12 == 0) goto L_0x00ee
            boolean r2 = android.text.TextUtils.isEmpty(r12)
            if (r2 != 0) goto L_0x00ee
            java.lang.String r10 = r12.substring(r9, r1)
            java.lang.String r12 = r12.substring(r1)
            goto L_0x00ef
        L_0x00ee:
            r12 = r10
        L_0x00ef:
            java.lang.String r2 = r7.getNetworkOperatorName()
            r5.f6992w = r2
            com.chartboost.sdk.Libraries.e$a[] r11 = new com.chartboost.sdk.Libraries.C2076e.C2077a[r11]
            java.lang.String r3 = "carrier-name"
            com.chartboost.sdk.Libraries.e$a r2 = com.chartboost.sdk.Libraries.C2076e.m8184a((java.lang.String) r3, (java.lang.Object) r2)
            r11[r9] = r2
            java.lang.String r2 = "mobile-country-code"
            com.chartboost.sdk.Libraries.e$a r10 = com.chartboost.sdk.Libraries.C2076e.m8184a((java.lang.String) r2, (java.lang.Object) r10)
            r2 = 1
            r11[r2] = r10
            java.lang.String r10 = "mobile-network-code"
            com.chartboost.sdk.Libraries.e$a r10 = com.chartboost.sdk.Libraries.C2076e.m8184a((java.lang.String) r10, (java.lang.Object) r12)
            r12 = 2
            r11[r12] = r10
            java.lang.String r10 = r7.getNetworkCountryIso()
            java.lang.String r12 = "iso-country-code"
            com.chartboost.sdk.Libraries.e$a r10 = com.chartboost.sdk.Libraries.C2076e.m8184a((java.lang.String) r12, (java.lang.Object) r10)
            r11[r1] = r10
            int r7 = r7.getPhoneType()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String r10 = "phone-type"
            com.chartboost.sdk.Libraries.e$a r7 = com.chartboost.sdk.Libraries.C2076e.m8184a((java.lang.String) r10, (java.lang.Object) r7)
            r10 = 4
            r11[r10] = r7
            org.json.JSONObject r7 = com.chartboost.sdk.Libraries.C2076e.m8186a(r11)
            goto L_0x013a
        L_0x0133:
            org.json.JSONObject r7 = new org.json.JSONObject
            r7.<init>()
            r5.f6992w = r8
        L_0x013a:
            r5.f6991v = r7
            boolean r7 = com.chartboost.sdk.Libraries.CBUtility.m8176g()
            r5.f6993x = r7
            java.lang.String r7 = com.chartboost.sdk.Libraries.CBUtility.m8173d()
            r5.f6994y = r7
            int r7 = com.chartboost.sdk.impl.C2169j1.m8619b(r6)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r5.f6995z = r7
            boolean r7 = r6 instanceof android.app.Activity     // Catch:{ Exception -> 0x0179 }
            if (r7 == 0) goto L_0x0177
            r7 = r6
            android.app.Activity r7 = (android.app.Activity) r7     // Catch:{ Exception -> 0x0179 }
            android.graphics.Rect r10 = new android.graphics.Rect     // Catch:{ Exception -> 0x0179 }
            r10.<init>()     // Catch:{ Exception -> 0x0179 }
            android.view.Window r7 = r7.getWindow()     // Catch:{ Exception -> 0x0179 }
            android.view.View r7 = r7.getDecorView()     // Catch:{ Exception -> 0x0179 }
            r7.getWindowVisibleDisplayFrame(r10)     // Catch:{ Exception -> 0x0179 }
            int r7 = r10.width()     // Catch:{ Exception -> 0x0179 }
            int r9 = r10.height()     // Catch:{ Exception -> 0x0175 }
            r4 = r9
            r9 = r7
            r7 = r4
            goto L_0x0182
        L_0x0175:
            r10 = move-exception
            goto L_0x017b
        L_0x0177:
            r7 = 0
            goto L_0x0182
        L_0x0179:
            r10 = move-exception
            r7 = 0
        L_0x017b:
            java.lang.String r11 = "Exception getting activity size"
            com.chartboost.sdk.Libraries.CBLogging.m8155b(r0, r11, r10)
            r9 = r7
            goto L_0x0177
        L_0x0182:
            com.chartboost.sdk.i r10 = com.chartboost.sdk.C2116i.m8407a()
            android.util.DisplayMetrics r11 = new android.util.DisplayMetrics
            r11.<init>()
            java.lang.Object r10 = r10.mo9266a(r11)
            android.util.DisplayMetrics r10 = (android.util.DisplayMetrics) r10
            android.content.res.Resources r11 = r6.getResources()
            android.util.DisplayMetrics r11 = r11.getDisplayMetrics()
            r10.setTo(r11)
            java.lang.String r11 = "window"
            java.lang.Object r6 = r6.getSystemService(r11)
            android.view.WindowManager r6 = (android.view.WindowManager) r6
            if (r6 == 0) goto L_0x01ad
            android.view.Display r6 = r6.getDefaultDisplay()
            r6.getRealMetrics(r10)
        L_0x01ad:
            int r6 = r10.widthPixels
            int r11 = r10.heightPixels
            java.lang.Integer r12 = java.lang.Integer.valueOf(r6)
            r5.f6984o = r12
            java.lang.Integer r12 = java.lang.Integer.valueOf(r11)
            r5.f6985p = r12
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r8)
            int r8 = r10.densityDpi
            r12.append(r8)
            java.lang.String r8 = r12.toString()
            r5.f6986q = r8
            if (r9 <= 0) goto L_0x01d5
            if (r9 > r6) goto L_0x01d5
            goto L_0x01d6
        L_0x01d5:
            r9 = r6
        L_0x01d6:
            if (r7 <= 0) goto L_0x01db
            if (r7 > r11) goto L_0x01db
            goto L_0x01dc
        L_0x01db:
            r7 = r11
        L_0x01dc:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r9)
            r5.f6982m = r6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)
            r5.f6983n = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.Model.C2092g.<init>(android.content.Context, java.lang.String, com.chartboost.sdk.Libraries.d, com.chartboost.sdk.impl.w0, java.util.concurrent.atomic.AtomicReference, android.content.SharedPreferences, com.chartboost.sdk.Libraries.i):void");
    }
}
