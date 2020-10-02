package com.vungle.warren;

import android.util.Log;
import com.vungle.warren.VungleApiClient;

public class Plugin {
    private static final String TAG = "Plugin";

    public static void addWrapperInfo(VungleApiClient.WrapperFramework wrapperFramework, String str) {
        if (wrapperFramework == null || wrapperFramework == VungleApiClient.WrapperFramework.none) {
            Log.e(TAG, "Wrapper is null or is not none");
        } else {
            VungleApiClient.WRAPPER_FRAMEWORK_SELECTED = wrapperFramework;
            VungleApiClient.HEADER_UA += ";" + wrapperFramework;
            if (str == null || str.isEmpty()) {
                Log.e(TAG, "Wrapper framework version is empty");
            } else {
                VungleApiClient.HEADER_UA += "/" + str;
            }
        }
        if (Vungle.isInitialized()) {
            Log.w(TAG, "VUNGLE WARNING: SDK already initialized, wou should set wrapper info before");
        }
    }
}
