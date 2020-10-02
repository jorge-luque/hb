package com.tapjoy;

import android.app.Activity;
import android.content.Context;
import android.opengl.GLSurfaceView;
import com.tapjoy.internal.C5032er;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public final class Tapjoy {
    public static final String INTENT_EXTRA_PUSH_PAYLOAD = "com.tapjoy.PUSH_PAYLOAD";

    public static void actionComplete(String str) {
        C5032er.m17003a().mo31180e(str);
    }

    public static void addUserTag(String str) {
        C5032er.m17003a().mo31174c(str);
    }

    public static void awardCurrency(int i, TJAwardCurrencyListener tJAwardCurrencyListener) {
        C5032er.m17003a().mo31139a(i, tJAwardCurrencyListener);
    }

    @Deprecated
    public static void belowConsentAge(boolean z) {
        C5032er.m17003a().mo31178d(z);
    }

    public static void clearUserTags() {
        C5032er.m17003a().mo31184g();
    }

    public static boolean connect(Context context, String str) {
        return C5032er.m17003a().mo31162a(context, str);
    }

    public static void endSession() {
        C5032er.m17003a().mo31179e();
    }

    public static void getCurrencyBalance(TJGetCurrencyBalanceListener tJGetCurrencyBalanceListener) {
        C5032er.m17003a().mo31146a(tJGetCurrencyBalanceListener);
    }

    @Deprecated
    public static float getCurrencyMultiplier() {
        return C5032er.m17003a().mo31172c();
    }

    public static String getCustomParameter() {
        return C5032er.m17003a().mo31192l();
    }

    public static TJPlacement getLimitedPlacement(String str, TJPlacementListener tJPlacementListener) {
        return C5032er.m17003a().mo31165b(str, tJPlacementListener);
    }

    public static TJPlacement getPlacement(String str, TJPlacementListener tJPlacementListener) {
        return C5032er.m17003a().mo31136a(str, tJPlacementListener);
    }

    public static TJPrivacyPolicy getPrivacyPolicy() {
        return C5032er.m17003a().mo31193m();
    }

    public static String getSupportURL() {
        return C5032er.m17003a().mo31183g((String) null);
    }

    public static Set getUserTags() {
        return C5032er.m17003a().mo31181f();
    }

    public static String getUserToken() {
        return C5032er.m17003a().mo31191k();
    }

    public static String getVersion() {
        return C5032er.m17003a().mo31166b();
    }

    public static boolean isConnected() {
        return C5032er.m17003a().mo31188i();
    }

    public static boolean isLimitedConnected() {
        return C5032er.m17003a().mo31190j();
    }

    public static boolean isPushNotificationDisabled() {
        return C5032er.m17003a().mo31186h();
    }

    public static synchronized boolean limitedConnect(Context context, String str, TJConnectListener tJConnectListener) {
        boolean a;
        synchronized (Tapjoy.class) {
            a = C5032er.m17003a().mo31163a(context, str, tJConnectListener);
        }
        return a;
    }

    public static void loadSharedLibrary() {
        try {
            System.loadLibrary("tapjoy");
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    public static void onActivityStart(Activity activity) {
        C5032er.m17003a().mo31168b(activity);
    }

    public static void onActivityStop(Activity activity) {
        C5032er.m17003a().mo31173c(activity);
    }

    public static void removeUserTag(String str) {
        C5032er.m17003a().mo31177d(str);
    }

    public static void setActivity(Activity activity) {
        C5032er.m17003a().mo31142a(activity);
    }

    public static void setAppDataVersion(String str) {
        C5032er.m17003a().mo31169b(str);
    }

    @Deprecated
    public static void setCurrencyMultiplier(float f) {
        C5032er.m17003a().mo31137a(f);
    }

    public static void setCustomParameter(String str) {
        C5032er.m17003a().mo31189j(str);
    }

    public static void setDebugEnabled(boolean z) {
        C5032er.m17003a().mo31161a(z);
    }

    public static void setDeviceToken(String str) {
        C5032er.m17003a().mo31187i(str);
    }

    public static void setEarnedCurrencyListener(TJEarnedCurrencyListener tJEarnedCurrencyListener) {
        C5032er.m17003a().mo31145a(tJEarnedCurrencyListener);
    }

    public static void setGLSurfaceView(GLSurfaceView gLSurfaceView) {
        C5032er.m17003a().mo31144a(gLSurfaceView);
    }

    public static void setGcmSender(String str) {
        C5032er.m17003a().mo31182f(str);
    }

    public static void setPushNotificationDisabled(boolean z) {
        C5032er.m17003a().mo31171b(z);
    }

    public static void setReceiveRemoteNotification(Context context, Map map) {
        C5032er.m17003a().mo31143a(context, map);
    }

    public static void setUserCohortVariable(int i, String str) {
        C5032er.m17003a().mo31141a(i, str);
    }

    @Deprecated
    public static void setUserConsent(String str) {
        C5032er.m17003a().mo31185h(str);
    }

    public static void setUserFriendCount(int i) {
        C5032er.m17003a().mo31167b(i);
    }

    public static void setUserID(String str) {
        setUserID(str, (TJSetUserIDListener) null);
    }

    public static void setUserLevel(int i) {
        C5032er.m17003a().mo31138a(i);
    }

    public static void setUserTags(Set set) {
        C5032er.m17003a().mo31160a(set);
    }

    public static void setVideoListener(TJVideoListener tJVideoListener) {
        C5032er.m17003a().mo31147a(tJVideoListener);
    }

    public static void spendCurrency(int i, TJSpendCurrencyListener tJSpendCurrencyListener) {
        C5032er.m17003a().mo31140a(i, tJSpendCurrencyListener);
    }

    public static void startSession() {
        C5032er.m17003a().mo31176d();
    }

    @Deprecated
    public static void subjectToGDPR(boolean z) {
        C5032er.m17003a().mo31175c(z);
    }

    public static void trackEvent(String str) {
        C5032er.m17003a().mo31148a(str);
    }

    public static void trackPurchase(String str, String str2, double d, String str3) {
        C5032er.m17003a().mo31152a(str, str2, d, str3);
    }

    public static boolean connect(Context context, String str, Hashtable hashtable) {
        return C5032er.m17003a().mo31164a(context, str, hashtable, (TJConnectListener) null);
    }

    public static String getSupportURL(String str) {
        return C5032er.m17003a().mo31183g(str);
    }

    public static void setUserID(String str, TJSetUserIDListener tJSetUserIDListener) {
        C5032er.m17003a().mo31150a(str, tJSetUserIDListener);
    }

    public static void trackEvent(String str, long j) {
        C5032er.m17003a().mo31149a(str, j);
    }

    public static void trackPurchase(String str, String str2, String str3, String str4) {
        C5032er.m17003a().mo31154a(str, str2, str3, str4);
    }

    public static synchronized boolean connect(Context context, String str, Hashtable hashtable, TJConnectListener tJConnectListener) {
        boolean a;
        synchronized (Tapjoy.class) {
            a = C5032er.m17003a().mo31164a(context, str, hashtable, tJConnectListener);
        }
        return a;
    }

    public static void trackEvent(String str, String str2, long j) {
        C5032er.m17003a().mo31153a(str, str2, j);
    }

    @Deprecated
    public static void trackPurchase(String str, String str2) {
        C5032er.m17003a().mo31151a(str, str2);
    }

    public static void trackEvent(String str, String str2, String str3, String str4) {
        C5032er.m17003a().mo31170b(str, str2, str3, str4);
    }

    public static void trackEvent(String str, String str2, String str3, String str4, long j) {
        C5032er.m17003a().mo31155a(str, str2, str3, str4, j);
    }

    public static void trackEvent(String str, String str2, String str3, String str4, String str5, long j) {
        C5032er.m17003a().mo31156a(str, str2, str3, str4, str5, j);
    }

    public static void trackEvent(String str, String str2, String str3, String str4, String str5, long j, String str6, long j2) {
        C5032er.m17003a().mo31157a(str, str2, str3, str4, str5, j, str6, j2);
    }

    public static void trackEvent(String str, String str2, String str3, String str4, String str5, long j, String str6, long j2, String str7, long j3) {
        C5032er.m17003a().mo31158a(str, str2, str3, str4, str5, j, str6, j2, str7, j3);
    }

    public static void trackEvent(String str, String str2, String str3, String str4, Map map) {
        C5032er.m17003a().mo31159a(str, str2, str3, str4, map);
    }
}
