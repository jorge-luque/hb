package com.crashlytics.android.ndk;

import android.content.Context;
import com.crashlytics.android.core.CrashlyticsNdkData;
import java.io.File;
import java.io.IOException;
import java.util.TreeSet;
import p118io.fabric.sdk.android.C6059c;

class BreakpadController implements NdkKitController {
    private final Context context;
    private final CrashFilesManager filesManager;
    private final NativeApi nativeApi;

    BreakpadController(Context context2, NativeApi nativeApi2, CrashFilesManager crashFilesManager) {
        this.context = context2;
        this.nativeApi = nativeApi2;
        this.filesManager = crashFilesManager;
    }

    public CrashlyticsNdkData getNativeData() throws IOException {
        TreeSet<File> allNativeDirectories = this.filesManager.getAllNativeDirectories();
        if (!allNativeDirectories.isEmpty()) {
            allNativeDirectories.pollFirst();
        }
        return new CrashlyticsNdkData(allNativeDirectories);
    }

    public boolean initialize() {
        File newNativeDirectory = this.filesManager.getNewNativeDirectory();
        if (newNativeDirectory == null) {
            return false;
        }
        try {
            return this.nativeApi.initialize(newNativeDirectory.getCanonicalPath(), this.context.getAssets());
        } catch (IOException e) {
            C6059c.m19630f().mo34090b("CrashlyticsNdk", "Error initializing CrashlyticsNdk", e);
            return false;
        }
    }
}
