package com.facebook.internal;

import com.facebook.FacebookSdk;
import p093e.p097b.p098a.p099a.C3368a;
import p093e.p097b.p098a.p099a.C3374c;

public class InstallReferrerUtil {
    private static final String IS_REFERRER_UPDATED = "is_referrer_updated";

    public interface Callback {
        void onReceiveReferrerUrl(String str);
    }

    private InstallReferrerUtil() {
    }

    private static boolean isUpdated() {
        return FacebookSdk.getApplicationContext().getSharedPreferences(FacebookSdk.APP_EVENT_PREFERENCES, 0).getBoolean(IS_REFERRER_UPDATED, false);
    }

    private static void tryConnectReferrerInfo(final Callback callback) {
        final C3368a a = C3368a.m11242a(FacebookSdk.getApplicationContext()).mo19132a();
        a.mo19131a((C3374c) new C3374c() {
            public void onInstallReferrerServiceDisconnected() {
            }

            public void onInstallReferrerSetupFinished(int i) {
                if (i == 0) {
                    try {
                        String b = a.mo19130a().mo19137b();
                        if (b != null && (b.contains("fb") || b.contains("facebook"))) {
                            callback.onReceiveReferrerUrl(b);
                        }
                        InstallReferrerUtil.updateReferrer();
                    } catch (Exception unused) {
                    }
                } else if (i == 2) {
                    InstallReferrerUtil.updateReferrer();
                }
            }
        });
    }

    public static void tryUpdateReferrerInfo(Callback callback) {
        if (!isUpdated()) {
            tryConnectReferrerInfo(callback);
        }
    }

    /* access modifiers changed from: private */
    public static void updateReferrer() {
        FacebookSdk.getApplicationContext().getSharedPreferences(FacebookSdk.APP_EVENT_PREFERENCES, 0).edit().putBoolean(IS_REFERRER_UPDATED, true).apply();
    }
}
