package com.tapjoy.internal;

import admost.sdk.base.AdMostZonePlacementStatus;
import android.app.Activity;
import android.app.Notification;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Build;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tapjoy.TJAdUnit;
import com.tapjoy.TJAwardCurrencyListener;
import com.tapjoy.TJConnectListener;
import com.tapjoy.TJCurrency;
import com.tapjoy.TJEarnedCurrencyListener;
import com.tapjoy.TJGetCurrencyBalanceListener;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TJPlacementManager;
import com.tapjoy.TJPrivacyPolicy;
import com.tapjoy.TJSetUserIDListener;
import com.tapjoy.TJSpendCurrencyListener;
import com.tapjoy.TJVideoListener;
import com.tapjoy.TapjoyCache;
import com.tapjoy.TapjoyConnectCore;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.TapjoyLog;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* renamed from: com.tapjoy.internal.es */
class C5033es extends C5032er {

    /* renamed from: c */
    private boolean f13633c = false;

    /* renamed from: d */
    private String f13634d = "";
    /* access modifiers changed from: private */

    /* renamed from: e */
    public TJCurrency f13635e = null;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public TapjoyCache f13636f = null;

    C5033es() {
    }

    /* renamed from: b */
    public final TJPlacement mo31165b(String str, TJPlacementListener tJPlacementListener) {
        return TJPlacementManager.m16595b(str, "", "", tJPlacementListener);
    }

    /* renamed from: b */
    public final String mo31166b() {
        return "12.6.0";
    }

    /* renamed from: c */
    public final float mo31172c() {
        if (m17065l("getCurrencyMultiplier")) {
            return TapjoyConnectCore.getInstance().getCurrencyMultiplier();
        }
        return 1.0f;
    }

    /* renamed from: d */
    public final void mo31176d() {
        if (m17065l("startSession")) {
            if (Build.VERSION.SDK_INT >= 14) {
                C5083fl.m17192a();
            }
            TapjoyConnectCore.getInstance().appResume();
            C5125gn.m17283a();
        }
    }

    /* renamed from: e */
    public final void mo31180e(String str) {
        if (m17064k("actionComplete")) {
            TapjoyConnectCore.getInstance().actionComplete(str);
        }
    }

    /* renamed from: f */
    public final Set mo31181f() {
        return C3145gz.m10321a().mo18554c();
    }

    /* renamed from: g */
    public final void mo31184g() {
        C3145gz.m10321a().mo18549a((Set) null);
    }

    /* renamed from: h */
    public final boolean mo31186h() {
        C3145gz a = C3145gz.m10321a();
        if (!a.mo18557d("isPushNotificationDisabled")) {
            return false;
        }
        boolean f = a.f8762f.mo18595f();
        C5139gw.m17325a("isPushNotificationDisabled = {}", Boolean.valueOf(f));
        return f;
    }

    /* renamed from: i */
    public final boolean mo31188i() {
        return this.f13631a;
    }

    /* renamed from: j */
    public final void mo31189j(String str) {
        TapjoyConnectCore.setCustomParameter(str);
    }

    /* renamed from: k */
    public final String mo31191k() {
        return TapjoyConnectCore.getUserToken();
    }

    /* renamed from: l */
    public final String mo31192l() {
        return TapjoyConnectCore.getCustomParameter();
    }

    /* renamed from: m */
    public final TJPrivacyPolicy mo31193m() {
        return TJPrivacyPolicy.getInstance();
    }

    /* renamed from: k */
    private boolean m17064k(String str) {
        if (this.f13631a) {
            return true;
        }
        TapjoyLog.m16654w("TapjoyAPI", "Can not call " + str + " because Tapjoy SDK has not successfully connected.");
        return false;
    }

    /* renamed from: l */
    private boolean m17065l(String str) {
        if (this.f13633c) {
            return true;
        }
        String str2 = "Can not call " + str + " because Tapjoy SDK is not initialized.";
        this.f13634d = str2;
        TapjoyLog.m16650e("TapjoyAPI", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, str2));
        return false;
    }

    /* renamed from: b */
    public final void mo31170b(String str, String str2, String str3, String str4) {
        C5125gn.m17286a(str, str2, str3, str4, 0);
    }

    /* renamed from: f */
    public final void mo31182f(String str) {
        C3145gz a = C3145gz.m10321a();
        C5139gw.m17325a("setGcmSender({}) called", str);
        a.f8760d = C3166jq.m10434a(str);
        a.mo18551b();
    }

    /* renamed from: g */
    public final String mo31183g(String str) {
        if (m17064k("getSupportURL")) {
            return TapjoyConnectCore.getSupportURL(str);
        }
        return null;
    }

    /* renamed from: i */
    public final void mo31187i(String str) {
        C3145gz.m10321a().mo18545a(str);
    }

    /* renamed from: j */
    public final boolean mo31190j() {
        return this.f13632b;
    }

    /* renamed from: a */
    public final void mo31161a(boolean z) {
        TapjoyLog.setDebugEnabled(z);
    }

    /* renamed from: b */
    public final void mo31168b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 14) {
            C5083fl.m17192a();
        }
        C3145gz.m10321a().f8770n = true;
        C5125gn.m17284a(activity);
    }

    /* renamed from: c */
    public final void mo31173c(Activity activity) {
        if (Build.VERSION.SDK_INT >= 14) {
            C5083fl.m17192a();
        }
        C5125gn.m17289b(activity);
    }

    /* renamed from: e */
    public final void mo31179e() {
        if (m17065l("endSession")) {
            if (Build.VERSION.SDK_INT >= 14) {
                C5083fl.m17192a();
            }
            C3145gz.m10321a().f8770n = false;
            TapjoyConnectCore.getInstance().appPause();
            C5125gn.m17288b();
        }
    }

    /* renamed from: a */
    public final boolean mo31162a(Context context, String str) {
        return mo31164a(context, str, (Hashtable) null, (TJConnectListener) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004f, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0094, code lost:
        return true;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean mo31164a(final android.content.Context r3, java.lang.String r4, java.util.Hashtable r5, final com.tapjoy.TJConnectListener r6) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r5 == 0) goto L_0x0018
            java.lang.String r0 = "TJC_OPTION_ENABLE_LOGGING"
            java.lang.Object r0 = r5.get(r0)     // Catch:{ all -> 0x00c5 }
            if (r0 == 0) goto L_0x0018
            java.lang.String r1 = "true"
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00c5 }
            boolean r0 = r1.equals(r0)     // Catch:{ all -> 0x00c5 }
            com.tapjoy.TapjoyLog.setDebugEnabled(r0)     // Catch:{ all -> 0x00c5 }
        L_0x0018:
            java.lang.String r0 = "event"
            com.tapjoy.TapjoyConnectCore.setSDKType(r0)     // Catch:{ all -> 0x00c5 }
            r0 = 0
            if (r3 != 0) goto L_0x0035
            java.lang.String r3 = "TapjoyAPI"
            com.tapjoy.TapjoyErrorMessage r4 = new com.tapjoy.TapjoyErrorMessage     // Catch:{ all -> 0x00c5 }
            com.tapjoy.TapjoyErrorMessage$ErrorType r5 = com.tapjoy.TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR     // Catch:{ all -> 0x00c5 }
            java.lang.String r1 = "The application context is NULL"
            r4.<init>(r5, r1)     // Catch:{ all -> 0x00c5 }
            com.tapjoy.TapjoyLog.m16650e((java.lang.String) r3, (com.tapjoy.TapjoyErrorMessage) r4)     // Catch:{ all -> 0x00c5 }
            if (r6 == 0) goto L_0x0033
            r6.onConnectFailure()     // Catch:{ all -> 0x00c5 }
        L_0x0033:
            monitor-exit(r2)
            return r0
        L_0x0035:
            boolean r1 = com.tapjoy.internal.C3166jq.m10436c(r4)     // Catch:{ all -> 0x00c5 }
            if (r1 == 0) goto L_0x0050
            java.lang.String r3 = "TapjoyAPI"
            com.tapjoy.TapjoyErrorMessage r4 = new com.tapjoy.TapjoyErrorMessage     // Catch:{ all -> 0x00c5 }
            com.tapjoy.TapjoyErrorMessage$ErrorType r5 = com.tapjoy.TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR     // Catch:{ all -> 0x00c5 }
            java.lang.String r1 = "The SDK key is NULL. A valid SDK key is required to connect successfully to Tapjoy"
            r4.<init>(r5, r1)     // Catch:{ all -> 0x00c5 }
            com.tapjoy.TapjoyLog.m16650e((java.lang.String) r3, (com.tapjoy.TapjoyErrorMessage) r4)     // Catch:{ all -> 0x00c5 }
            if (r6 == 0) goto L_0x004e
            r6.onConnectFailure()     // Catch:{ all -> 0x00c5 }
        L_0x004e:
            monitor-exit(r2)
            return r0
        L_0x0050:
            com.tapjoy.FiveRocksIntegration.m16525a()     // Catch:{ all -> 0x00c5 }
            com.tapjoy.TapjoyAppSettings.init(r3)     // Catch:{ TapjoyIntegrationException -> 0x00ad, TapjoyException -> 0x0095 }
            com.tapjoy.internal.es$1 r1 = new com.tapjoy.internal.es$1     // Catch:{ TapjoyIntegrationException -> 0x00ad, TapjoyException -> 0x0095 }
            r1.<init>(r3, r6)     // Catch:{ TapjoyIntegrationException -> 0x00ad, TapjoyException -> 0x0095 }
            com.tapjoy.TapjoyConnectCore.requestTapjoyConnect(r3, r4, r5, r1)     // Catch:{ TapjoyIntegrationException -> 0x00ad, TapjoyException -> 0x0095 }
            r4 = 1
            r2.f13633c = r4     // Catch:{ all -> 0x00c5 }
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00c5 }
            r1 = 14
            if (r6 >= r1) goto L_0x006f
            java.lang.String r3 = "TapjoyAPI"
            java.lang.String r5 = "Automatic session tracking is not available on this device."
            com.tapjoy.TapjoyLog.m16652i(r3, r5)     // Catch:{ all -> 0x00c5 }
            goto L_0x0093
        L_0x006f:
            if (r5 == 0) goto L_0x0086
            java.lang.String r6 = "TJC_OPTION_DISABLE_AUTOMATIC_SESSION_TRACKING"
            java.lang.Object r5 = r5.get(r6)     // Catch:{ all -> 0x00c5 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x00c5 }
            if (r5 == 0) goto L_0x0086
            java.lang.String r6 = "true"
            boolean r5 = r5.equalsIgnoreCase(r6)     // Catch:{ all -> 0x00c5 }
            if (r5 == 0) goto L_0x0086
            r0 = 1
        L_0x0086:
            if (r0 != 0) goto L_0x008c
            com.tapjoy.internal.C5083fl.m17193a((android.content.Context) r3)     // Catch:{ all -> 0x00c5 }
            goto L_0x0093
        L_0x008c:
            java.lang.String r3 = "TapjoyAPI"
            java.lang.String r5 = "Automatic session tracking is disabled."
            com.tapjoy.TapjoyLog.m16652i(r3, r5)     // Catch:{ all -> 0x00c5 }
        L_0x0093:
            monitor-exit(r2)
            return r4
        L_0x0095:
            r3 = move-exception
            java.lang.String r4 = "TapjoyAPI"
            com.tapjoy.TapjoyErrorMessage r5 = new com.tapjoy.TapjoyErrorMessage     // Catch:{ all -> 0x00c5 }
            com.tapjoy.TapjoyErrorMessage$ErrorType r1 = com.tapjoy.TapjoyErrorMessage.ErrorType.SDK_ERROR     // Catch:{ all -> 0x00c5 }
            java.lang.String r3 = r3.getMessage()     // Catch:{ all -> 0x00c5 }
            r5.<init>(r1, r3)     // Catch:{ all -> 0x00c5 }
            com.tapjoy.TapjoyLog.m16650e((java.lang.String) r4, (com.tapjoy.TapjoyErrorMessage) r5)     // Catch:{ all -> 0x00c5 }
            if (r6 == 0) goto L_0x00ab
            r6.onConnectFailure()     // Catch:{ all -> 0x00c5 }
        L_0x00ab:
            monitor-exit(r2)
            return r0
        L_0x00ad:
            r3 = move-exception
            java.lang.String r4 = "TapjoyAPI"
            com.tapjoy.TapjoyErrorMessage r5 = new com.tapjoy.TapjoyErrorMessage     // Catch:{ all -> 0x00c5 }
            com.tapjoy.TapjoyErrorMessage$ErrorType r1 = com.tapjoy.TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR     // Catch:{ all -> 0x00c5 }
            java.lang.String r3 = r3.getMessage()     // Catch:{ all -> 0x00c5 }
            r5.<init>(r1, r3)     // Catch:{ all -> 0x00c5 }
            com.tapjoy.TapjoyLog.m16650e((java.lang.String) r4, (com.tapjoy.TapjoyErrorMessage) r5)     // Catch:{ all -> 0x00c5 }
            if (r6 == 0) goto L_0x00c3
            r6.onConnectFailure()     // Catch:{ all -> 0x00c5 }
        L_0x00c3:
            monitor-exit(r2)
            return r0
        L_0x00c5:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C5033es.mo31164a(android.content.Context, java.lang.String, java.util.Hashtable, com.tapjoy.TJConnectListener):boolean");
    }

    /* renamed from: h */
    public final void mo31185h(String str) {
        C5119ge.m17262a().mo31298a(str);
    }

    /* renamed from: c */
    public final void mo31174c(String str) {
        if (!C3166jq.m10436c(str)) {
            C3145gz a = C3145gz.m10321a();
            Set c = a.mo18554c();
            if (c.add(str)) {
                a.mo18549a(c);
            }
        }
    }

    /* renamed from: d */
    public final void mo31177d(String str) {
        if (!C3166jq.m10436c(str)) {
            C3145gz a = C3145gz.m10321a();
            Set c = a.mo18554c();
            if (c.remove(str)) {
                a.mo18549a(c);
            }
        }
    }

    /* renamed from: b */
    public final void mo31171b(boolean z) {
        String str;
        Object[] objArr;
        String str2;
        C3145gz a = C3145gz.m10321a();
        if (a.mo18557d("setPushNotificationDisabled")) {
            boolean a2 = a.f8762f.mo18587a(z);
            char c = 0;
            String str3 = "setPushNotificationDisabled({}) called, but it is already {}";
            if (a2) {
                objArr = new Object[1];
                str = Boolean.valueOf(z);
                str3 = "setPushNotificationDisabled({}) called";
            } else {
                Object[] objArr2 = new Object[2];
                objArr2[0] = Boolean.valueOf(z);
                str = z ? AdMostZonePlacementStatus.DISABLED : "enabled";
                objArr = objArr2;
                c = 1;
            }
            objArr[c] = str;
            C5139gw.m17325a(str3, objArr);
            if (a2 && a.f8767k && !C3166jq.m10436c(a.f8760d)) {
                if (a.f8771o != null) {
                    str2 = null;
                } else {
                    C3147hb b = C3147hb.m10351b(a.f8761e);
                    str2 = C3166jq.m10435b(b.f8850b.mo18573b(b.f8849a));
                }
                a.mo18545a(str2);
            }
        }
    }

    /* renamed from: c */
    public final void mo31175c(boolean z) {
        C5119ge.m17262a().mo31299a(z);
    }

    /* renamed from: d */
    public final void mo31178d(boolean z) {
        C5119ge.m17262a().mo31300b(z);
    }

    /* renamed from: b */
    public final void mo31167b(int i) {
        C3145gz a = C3145gz.m10321a();
        if (a.mo18557d("setUserFriendCount")) {
            C5139gw.m17325a("setUserFriendCount({}) called", Integer.valueOf(i));
            a.f8762f.mo18589b(i >= 0 ? Integer.valueOf(i) : null);
        }
    }

    /* renamed from: b */
    public final void mo31169b(String str) {
        C3145gz a = C3145gz.m10321a();
        if (a.mo18557d("setAppDataVersion")) {
            a.f8762f.mo18585a(C5134gu.m17311a(str));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0038, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        return false;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean mo31163a(final android.content.Context r4, java.lang.String r5, final com.tapjoy.TJConnectListener r6) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.String r0 = "event"
            com.tapjoy.TapjoyConnectCore.setSDKType(r0)     // Catch:{ all -> 0x0074 }
            r0 = 0
            if (r4 != 0) goto L_0x001e
            java.lang.String r4 = "TapjoyAPI"
            com.tapjoy.TapjoyErrorMessage r5 = new com.tapjoy.TapjoyErrorMessage     // Catch:{ all -> 0x0074 }
            com.tapjoy.TapjoyErrorMessage$ErrorType r1 = com.tapjoy.TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR     // Catch:{ all -> 0x0074 }
            java.lang.String r2 = "The application context is NULL"
            r5.<init>(r1, r2)     // Catch:{ all -> 0x0074 }
            com.tapjoy.TapjoyLog.m16650e((java.lang.String) r4, (com.tapjoy.TapjoyErrorMessage) r5)     // Catch:{ all -> 0x0074 }
            if (r6 == 0) goto L_0x001c
            r6.onConnectFailure()     // Catch:{ all -> 0x0074 }
        L_0x001c:
            monitor-exit(r3)
            return r0
        L_0x001e:
            boolean r1 = com.tapjoy.internal.C3166jq.m10436c(r5)     // Catch:{ all -> 0x0074 }
            if (r1 == 0) goto L_0x0039
            java.lang.String r4 = "TapjoyAPI"
            com.tapjoy.TapjoyErrorMessage r5 = new com.tapjoy.TapjoyErrorMessage     // Catch:{ all -> 0x0074 }
            com.tapjoy.TapjoyErrorMessage$ErrorType r1 = com.tapjoy.TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR     // Catch:{ all -> 0x0074 }
            java.lang.String r2 = "The limited SDK key is NULL. A valid limited SDK key is required to connect successfully to Tapjoy"
            r5.<init>(r1, r2)     // Catch:{ all -> 0x0074 }
            com.tapjoy.TapjoyLog.m16650e((java.lang.String) r4, (com.tapjoy.TapjoyErrorMessage) r5)     // Catch:{ all -> 0x0074 }
            if (r6 == 0) goto L_0x0037
            r6.onConnectFailure()     // Catch:{ all -> 0x0074 }
        L_0x0037:
            monitor-exit(r3)
            return r0
        L_0x0039:
            com.tapjoy.internal.es$2 r1 = new com.tapjoy.internal.es$2     // Catch:{ TapjoyIntegrationException -> 0x005c, TapjoyException -> 0x0044 }
            r1.<init>(r4, r6)     // Catch:{ TapjoyIntegrationException -> 0x005c, TapjoyException -> 0x0044 }
            com.tapjoy.TapjoyConnectCore.requestLimitedTapjoyConnect(r4, r5, r1)     // Catch:{ TapjoyIntegrationException -> 0x005c, TapjoyException -> 0x0044 }
            r4 = 1
            monitor-exit(r3)
            return r4
        L_0x0044:
            r4 = move-exception
            java.lang.String r5 = "TapjoyAPI"
            com.tapjoy.TapjoyErrorMessage r1 = new com.tapjoy.TapjoyErrorMessage     // Catch:{ all -> 0x0074 }
            com.tapjoy.TapjoyErrorMessage$ErrorType r2 = com.tapjoy.TapjoyErrorMessage.ErrorType.SDK_ERROR     // Catch:{ all -> 0x0074 }
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x0074 }
            r1.<init>(r2, r4)     // Catch:{ all -> 0x0074 }
            com.tapjoy.TapjoyLog.m16650e((java.lang.String) r5, (com.tapjoy.TapjoyErrorMessage) r1)     // Catch:{ all -> 0x0074 }
            if (r6 == 0) goto L_0x005a
            r6.onConnectFailure()     // Catch:{ all -> 0x0074 }
        L_0x005a:
            monitor-exit(r3)
            return r0
        L_0x005c:
            r4 = move-exception
            java.lang.String r5 = "TapjoyAPI"
            com.tapjoy.TapjoyErrorMessage r1 = new com.tapjoy.TapjoyErrorMessage     // Catch:{ all -> 0x0074 }
            com.tapjoy.TapjoyErrorMessage$ErrorType r2 = com.tapjoy.TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR     // Catch:{ all -> 0x0074 }
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x0074 }
            r1.<init>(r2, r4)     // Catch:{ all -> 0x0074 }
            com.tapjoy.TapjoyLog.m16650e((java.lang.String) r5, (com.tapjoy.TapjoyErrorMessage) r1)     // Catch:{ all -> 0x0074 }
            if (r6 == 0) goto L_0x0072
            r6.onConnectFailure()     // Catch:{ all -> 0x0074 }
        L_0x0072:
            monitor-exit(r3)
            return r0
        L_0x0074:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C5033es.mo31163a(android.content.Context, java.lang.String, com.tapjoy.TJConnectListener):boolean");
    }

    /* renamed from: a */
    public final TJPlacement mo31136a(String str, TJPlacementListener tJPlacementListener) {
        return TJPlacementManager.m16594a(str, "", "", tJPlacementListener);
    }

    /* renamed from: a */
    public final void mo31142a(Activity activity) {
        if (activity != null) {
            C3123b.m10218a(activity);
        } else {
            TapjoyLog.m16650e("TapjoyAPI", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, "Cannot set activity to NULL"));
        }
    }

    /* renamed from: a */
    public final void mo31137a(float f) {
        if (m17065l("setCurrencyMultiplier")) {
            TapjoyConnectCore.getInstance().setCurrencyMultiplier(f);
        }
    }

    /* renamed from: a */
    public final void mo31146a(TJGetCurrencyBalanceListener tJGetCurrencyBalanceListener) {
        if (this.f13635e != null && m17064k("getCurrencyBalance")) {
            this.f13635e.getCurrencyBalance(tJGetCurrencyBalanceListener);
        }
    }

    /* renamed from: a */
    public final void mo31140a(int i, TJSpendCurrencyListener tJSpendCurrencyListener) {
        if (this.f13635e != null && m17064k("spendCurrency")) {
            this.f13635e.spendCurrency(i, tJSpendCurrencyListener);
        }
    }

    /* renamed from: a */
    public final void mo31139a(int i, TJAwardCurrencyListener tJAwardCurrencyListener) {
        if (this.f13635e != null && m17064k("awardCurrency")) {
            this.f13635e.awardCurrency(i, tJAwardCurrencyListener);
        }
    }

    /* renamed from: a */
    public final void mo31145a(TJEarnedCurrencyListener tJEarnedCurrencyListener) {
        if (this.f13635e != null && m17064k("setEarnedCurrencyListener")) {
            this.f13635e.setEarnedCurrencyListener(tJEarnedCurrencyListener);
        }
    }

    /* renamed from: a */
    public final void mo31147a(TJVideoListener tJVideoListener) {
        if (m17065l("setVideoListener")) {
            TJAdUnit.f8647a = tJVideoListener;
        }
    }

    /* renamed from: a */
    public final void mo31154a(String str, String str2, String str3, String str4) {
        C5125gn.m17285a(str, str2, str3, str4);
    }

    /* renamed from: a */
    public final void mo31151a(String str, String str2) {
        C5125gn.m17285a(str, (String) null, (String) null, str2);
    }

    /* renamed from: a */
    public final void mo31148a(String str) {
        C5125gn.m17286a((String) null, str, (String) null, (String) null, 0);
    }

    /* renamed from: a */
    public final void mo31149a(String str, long j) {
        C5125gn.m17286a((String) null, str, (String) null, (String) null, j);
    }

    /* renamed from: a */
    public final void mo31153a(String str, String str2, long j) {
        C5125gn.m17286a(str, str2, (String) null, (String) null, j);
    }

    /* renamed from: a */
    public final void mo31155a(String str, String str2, String str3, String str4, long j) {
        C5125gn.m17286a(str, str2, str3, str4, j);
    }

    /* renamed from: a */
    public final void mo31156a(String str, String str2, String str3, String str4, String str5, long j) {
        C5125gn.m17287a(str, str2, str3, str4, str5, j, (String) null, 0, (String) null, 0);
    }

    /* renamed from: a */
    public final void mo31157a(String str, String str2, String str3, String str4, String str5, long j, String str6, long j2) {
        C5125gn.m17287a(str, str2, str3, str4, str5, j, str6, j2, (String) null, 0);
    }

    /* renamed from: a */
    public final void mo31158a(String str, String str2, String str3, String str4, String str5, long j, String str6, long j2, String str7, long j3) {
        C5125gn.m17287a(str, str2, str3, str4, str5, j, str6, j2, str7, j3);
    }

    /* renamed from: a */
    public final void mo31150a(String str, TJSetUserIDListener tJSetUserIDListener) {
        if (m17065l("setUserID")) {
            TapjoyConnectCore.setUserID(str, tJSetUserIDListener);
            C3145gz a = C3145gz.m10321a();
            if (a.mo18557d("setUserId")) {
                a.f8762f.mo18590b(C5134gu.m17311a(str));
            }
        } else if (tJSetUserIDListener != null) {
            tJSetUserIDListener.onSetUserIDFailure(this.f13634d);
        }
    }

    /* renamed from: a */
    public final void mo31160a(Set set) {
        C3145gz.m10321a().mo18549a(set);
    }

    /* renamed from: a */
    public final void mo31143a(Context context, Map map) {
        C3145gz a = C3145gz.m10321a();
        if (a.f8761e == null) {
            a.mo18552b(context);
        }
        C3147hb.m10351b(a.f8761e);
        Context context2 = a.f8761e;
        String str = (String) map.get("fiverocks");
        if (str == null) {
            return;
        }
        if (C3149hc.m10374a(context2).mo18595f()) {
            C3145gz.m10322a(context2).mo18553b(str);
            return;
        }
        String str2 = (String) map.get("title");
        String str3 = (String) map.get("message");
        if (str3 != null) {
            String str4 = (String) map.get("rich");
            String str5 = (String) map.get("sound");
            String str6 = (String) map.get(MessengerShareContentUtility.ATTACHMENT_PAYLOAD);
            String str7 = (String) map.get("always");
            boolean z = "true".equals(str7) || Boolean.TRUE.equals(str7);
            String str8 = (String) map.get("repeatable");
            boolean z2 = "true".equals(str8) || Boolean.TRUE.equals(str8);
            String str9 = (String) map.get("placement");
            int b = C3147hb.m10350b(map.get("nid"));
            String str10 = (String) map.get("channel_id");
            if (z || !C3145gz.m10322a(context2).mo18556d()) {
                Notification a2 = C3147hb.m10347a(context2, str, C3166jq.m10434a(str2), str3, C3147hb.m10349a((Object) str4), C3147hb.m10349a((Object) str5), str6, str9, b, str10);
                if (C3145gz.m10322a(context2).mo18550a(context2, str, z2)) {
                    C3147hb.m10348a(context2, b, a2);
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo31152a(String str, String str2, double d, String str3) {
        C3145gz a = C3145gz.m10321a();
        if (a.mo18555c("trackPurchase")) {
            String str4 = str;
            String a2 = C5134gu.m17312a(str, "trackPurchase", "productId");
            if (a2 != null) {
                String str5 = str2;
                String a3 = C5134gu.m17312a(str2, "trackPurchase", "currencyCode");
                if (a3 == null) {
                    return;
                }
                if (a3.length() != 3) {
                    C5139gw.m17324a("trackPurchase", "currencyCode", "invalid currency code");
                    return;
                }
                a.f8763g.mo18540a(a2, a3.toUpperCase(Locale.US), d, (String) null, (String) null, C5134gu.m17313b(str3));
                C5139gw.m17323a("trackPurchase called");
            }
        }
    }

    /* renamed from: a */
    public final void mo31159a(String str, String str2, String str3, String str4, Map map) {
        C3145gz a = C3145gz.m10321a();
        if (a.mo18555c("trackEvent") && !C3166jq.m10436c(str2)) {
            LinkedHashMap b = C5246ju.m17611b();
            if (map != null && map.size() > 0) {
                for (Map.Entry entry : map.entrySet()) {
                    Object key = entry.getKey();
                    if (key == null) {
                        if (C5139gw.f14055a) {
                            C3175x.m10466a("Tapjoy", "{}: {} must not be null", "trackEvent", "key in values map");
                            return;
                        }
                        return;
                    } else if (key instanceof String) {
                        String a2 = C5134gu.m17312a((String) key, "trackEvent", "key in values map");
                        if (a2 != null) {
                            Object value = entry.getValue();
                            if (value instanceof Number) {
                                b.put(a2, Long.valueOf(((Number) value).longValue()));
                            } else {
                                C5139gw.m17324a("trackEvent", "value in values map", "must be a long");
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
            }
            a.f8763g.mo18542a(str, str2, str3, str4, b);
            C5139gw.m17325a("trackEvent category:{}, name:{}, p1:{}, p2:{}, values:{} called", str, str2, str3, str4, b);
        }
    }

    /* renamed from: a */
    public final void mo31138a(int i) {
        C3145gz a = C3145gz.m10321a();
        if (a.mo18557d("setUserLevel")) {
            C5139gw.m17325a("setUserLevel({}) called", Integer.valueOf(i));
            a.f8762f.mo18584a(i >= 0 ? Integer.valueOf(i) : null);
        }
    }

    /* renamed from: a */
    public final void mo31141a(int i, String str) {
        C3145gz a = C3145gz.m10321a();
        if (a.mo18557d("setUserCohortVariable")) {
            boolean z = i > 0 && i <= 5;
            if (C5139gw.f14055a && !z) {
                C5139gw.m17328b("setCohortVariable: variableIndex is out of range");
            }
            if (z) {
                C5139gw.m17325a("setUserCohortVariable({}, {}) called", Integer.valueOf(i), str);
                a.f8762f.mo18583a(i, C5134gu.m17311a(str));
            }
        }
    }

    /* renamed from: a */
    public final void mo31144a(GLSurfaceView gLSurfaceView) {
        C3145gz.m10321a();
        C3145gz.m10324a(gLSurfaceView);
    }
}
