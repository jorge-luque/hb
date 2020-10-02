package com.crashlytics.android.ndk;

import android.content.res.AssetManager;
import android.util.Log;
import com.crashlytics.android.BuildConfig;

class JniNativeApi implements NativeApi {
    static final boolean libcrashlyticsLoaded;

    static {
        boolean z;
        try {
            System.loadLibrary(BuildConfig.ARTIFACT_ID);
            z = true;
        } catch (UnsatisfiedLinkError e) {
            Log.e("CrashlyticsNdk", "libcrashlytics could not be loaded. This APK may not have been compiled for this device's architecture. NDK crashes will not be reported to Crashlytics:\n" + e.getLocalizedMessage());
            z = false;
        }
        libcrashlyticsLoaded = z;
    }

    JniNativeApi() {
    }

    private native boolean nativeInit(String str, Object obj);

    public boolean initialize(String str, AssetManager assetManager) {
        return libcrashlyticsLoaded && nativeInit(str, assetManager);
    }
}
