package com.facebook.appevents.codeless;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.codeless.ViewIndexingTrigger;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;
import p118io.fabric.sdk.android.p200m.p203c.C6120b;

public final class CodelessManager {
    /* access modifiers changed from: private */
    public static String deviceSessionID;
    /* access modifiers changed from: private */
    public static Boolean isAppIndexingEnabled = false;
    /* access modifiers changed from: private */
    public static volatile Boolean isCheckingSession = false;
    private static final AtomicBoolean isCodelessEnabled = new AtomicBoolean(true);
    private static SensorManager sensorManager;
    /* access modifiers changed from: private */
    public static ViewIndexer viewIndexer;
    private static final ViewIndexingTrigger viewIndexingTrigger = new ViewIndexingTrigger();

    /* access modifiers changed from: private */
    public static void checkCodelessSession(final String str) {
        if (!isCheckingSession.booleanValue()) {
            isCheckingSession = true;
            FacebookSdk.getExecutor().execute(new Runnable() {
                public void run() {
                    boolean z = true;
                    GraphRequest newPostRequest = GraphRequest.newPostRequest((AccessToken) null, String.format(Locale.US, "%s/app_indexing_session", new Object[]{str}), (JSONObject) null, (GraphRequest.Callback) null);
                    Bundle parameters = newPostRequest.getParameters();
                    if (parameters == null) {
                        parameters = new Bundle();
                    }
                    AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(FacebookSdk.getApplicationContext());
                    JSONArray jSONArray = new JSONArray();
                    String str = Build.MODEL;
                    if (str == null) {
                        str = "";
                    }
                    jSONArray.put(str);
                    if (attributionIdentifiers == null || attributionIdentifiers.getAndroidAdvertiserId() == null) {
                        jSONArray.put("");
                    } else {
                        jSONArray.put(attributionIdentifiers.getAndroidAdvertiserId());
                    }
                    String str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                    jSONArray.put(str2);
                    if (AppEventUtility.isEmulator()) {
                        str2 = "1";
                    }
                    jSONArray.put(str2);
                    Locale currentLocale = Utility.getCurrentLocale();
                    jSONArray.put(currentLocale.getLanguage() + C6120b.ROLL_OVER_FILE_NAME_SEPARATOR + currentLocale.getCountry());
                    String jSONArray2 = jSONArray.toString();
                    parameters.putString(Constants.DEVICE_SESSION_ID, CodelessManager.getCurrentDeviceSessionID());
                    parameters.putString(Constants.EXTINFO, jSONArray2);
                    newPostRequest.setParameters(parameters);
                    JSONObject jSONObject = newPostRequest.executeAndWait().getJSONObject();
                    if (jSONObject == null || !jSONObject.optBoolean(Constants.APP_INDEXING_ENABLED, false)) {
                        z = false;
                    }
                    Boolean unused = CodelessManager.isAppIndexingEnabled = Boolean.valueOf(z);
                    if (!CodelessManager.isAppIndexingEnabled.booleanValue()) {
                        String unused2 = CodelessManager.deviceSessionID = null;
                    } else if (CodelessManager.viewIndexer != null) {
                        CodelessManager.viewIndexer.schedule();
                    }
                    Boolean unused3 = CodelessManager.isCheckingSession = false;
                }
            });
        }
    }

    public static void disable() {
        isCodelessEnabled.set(false);
    }

    public static void enable() {
        isCodelessEnabled.set(true);
    }

    static String getCurrentDeviceSessionID() {
        if (deviceSessionID == null) {
            deviceSessionID = UUID.randomUUID().toString();
        }
        return deviceSessionID;
    }

    static boolean getIsAppIndexingEnabled() {
        return isAppIndexingEnabled.booleanValue();
    }

    public static void onActivityDestroyed(Activity activity) {
        CodelessMatcher.getInstance().destroy(activity);
    }

    public static void onActivityPaused(Activity activity) {
        if (isCodelessEnabled.get()) {
            CodelessMatcher.getInstance().remove(activity);
            ViewIndexer viewIndexer2 = viewIndexer;
            if (viewIndexer2 != null) {
                viewIndexer2.unschedule();
            }
            SensorManager sensorManager2 = sensorManager;
            if (sensorManager2 != null) {
                sensorManager2.unregisterListener(viewIndexingTrigger);
            }
        }
    }

    public static void onActivityResumed(Activity activity) {
        if (isCodelessEnabled.get()) {
            CodelessMatcher.getInstance().add(activity);
            Context applicationContext = activity.getApplicationContext();
            final String applicationId = FacebookSdk.getApplicationId();
            final FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(applicationId);
            if (appSettingsWithoutQuery != null && appSettingsWithoutQuery.getCodelessEventsEnabled()) {
                SensorManager sensorManager2 = (SensorManager) applicationContext.getSystemService("sensor");
                sensorManager = sensorManager2;
                if (sensorManager2 != null) {
                    Sensor defaultSensor = sensorManager2.getDefaultSensor(1);
                    viewIndexer = new ViewIndexer(activity);
                    viewIndexingTrigger.setOnShakeListener(new ViewIndexingTrigger.OnShakeListener() {
                        public void onShake() {
                            FetchedAppSettings fetchedAppSettings = appSettingsWithoutQuery;
                            boolean z = true;
                            boolean z2 = fetchedAppSettings != null && fetchedAppSettings.getCodelessEventsEnabled();
                            if (!FacebookSdk.getCodelessSetupEnabled()) {
                                z = false;
                            }
                            if (z2 && z) {
                                CodelessManager.checkCodelessSession(applicationId);
                            }
                        }
                    });
                    sensorManager.registerListener(viewIndexingTrigger, defaultSensor, 2);
                    if (appSettingsWithoutQuery != null && appSettingsWithoutQuery.getCodelessEventsEnabled()) {
                        viewIndexer.schedule();
                    }
                }
            }
        }
    }

    static void updateAppIndexing(Boolean bool) {
        isAppIndexingEnabled = bool;
    }
}
