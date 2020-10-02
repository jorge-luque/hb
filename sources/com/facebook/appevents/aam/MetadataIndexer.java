package com.facebook.appevents.aam;

import android.app.Activity;
import com.facebook.FacebookSdk;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import java.util.concurrent.atomic.AtomicBoolean;

public final class MetadataIndexer {
    private static final String TAG = "com.facebook.appevents.aam.MetadataIndexer";
    /* access modifiers changed from: private */
    public static final AtomicBoolean enabled = new AtomicBoolean(false);

    public static void enable() {
        try {
            FacebookSdk.getExecutor().execute(new Runnable() {
                public void run() {
                    if (!AttributionIdentifiers.isTrackingLimited(FacebookSdk.getApplicationContext())) {
                        MetadataIndexer.enabled.set(true);
                        MetadataIndexer.updateRules();
                    }
                }
            });
        } catch (Exception e) {
            Utility.logd(TAG, e);
        }
    }

    public static void onActivityResumed(Activity activity) {
        try {
            if (!enabled.get()) {
                return;
            }
            if (!MetadataRule.getRules().isEmpty()) {
                MetadataViewObserver.startTrackingActivity(activity);
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public static void updateRules() {
        String rawAamRules;
        FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
        if (queryAppSettings != null && (rawAamRules = queryAppSettings.getRawAamRules()) != null) {
            MetadataRule.updateRules(rawAamRules);
        }
    }
}
