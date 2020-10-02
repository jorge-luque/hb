package com.crashlytics.android.ndk;

import com.crashlytics.android.core.CrashlyticsCore;
import com.crashlytics.android.core.CrashlyticsKitBinder;
import com.crashlytics.android.core.CrashlyticsNdkData;
import com.crashlytics.android.core.CrashlyticsNdkDataProvider;
import java.io.IOException;
import p118io.fabric.sdk.android.C6059c;
import p118io.fabric.sdk.android.C6069h;
import p118io.fabric.sdk.android.C6072k;
import p118io.fabric.sdk.android.p200m.p204d.C6131b;
import p118io.fabric.sdk.android.services.concurrency.UnmetDependencyException;

public class CrashlyticsNdk extends C6069h<Void> implements CrashlyticsNdkDataProvider {
    static final String TAG = "CrashlyticsNdk";
    private NdkKitController controller;
    private CrashlyticsNdkData crashlyticsNdkData;

    public static CrashlyticsNdk getInstance() {
        return (CrashlyticsNdk) C6059c.m19621a(CrashlyticsNdk.class);
    }

    public CrashlyticsNdkData getCrashlyticsNdkData() {
        return this.crashlyticsNdkData;
    }

    public String getIdentifier() {
        return "com.crashlytics.sdk.android.crashlytics-ndk";
    }

    public String getVersion() {
        return "2.1.1.36";
    }

    /* access modifiers changed from: protected */
    public boolean onPreExecute() {
        CrashlyticsCore crashlyticsCore = (CrashlyticsCore) C6059c.m19621a(CrashlyticsCore.class);
        if (crashlyticsCore != null) {
            return onPreExecute(new BreakpadController(getContext(), new JniNativeApi(), new NdkCrashFilesManager(new C6131b(this))), crashlyticsCore, new CrashlyticsKitBinder());
        }
        throw new UnmetDependencyException("CrashlyticsNdk requires Crashlytics");
    }

    /* access modifiers changed from: protected */
    public Void doInBackground() {
        try {
            this.crashlyticsNdkData = this.controller.getNativeData();
            return null;
        } catch (IOException e) {
            C6059c.m19630f().mo34090b(TAG, "Could not process ndk data; ", e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean onPreExecute(NdkKitController ndkKitController, CrashlyticsCore crashlyticsCore, CrashlyticsKitBinder crashlyticsKitBinder) {
        this.controller = ndkKitController;
        boolean initialize = ndkKitController.initialize();
        if (initialize) {
            crashlyticsKitBinder.bindCrashEventDataProvider(crashlyticsCore, this);
        }
        C6072k f = C6059c.m19630f();
        StringBuilder sb = new StringBuilder();
        sb.append("Crashlytics NDK initialization ");
        sb.append(initialize ? "successful" : "FAILED");
        f.mo34093d(TAG, sb.toString());
        return initialize;
    }
}
