package com.crashlytics.android.core;

import android.content.Context;
import p118io.fabric.sdk.android.p200m.p202b.C6090i;

class ResourceUnityVersionProvider implements UnityVersionProvider {
    private final Context context;
    private final UnityVersionProvider fallback;
    private boolean hasRead = false;
    private String unityVersion;

    public ResourceUnityVersionProvider(Context context2, UnityVersionProvider unityVersionProvider) {
        this.context = context2;
        this.fallback = unityVersionProvider;
    }

    public String getUnityVersion() {
        if (!this.hasRead) {
            this.unityVersion = C6090i.m19760o(this.context);
            this.hasRead = true;
        }
        String str = this.unityVersion;
        if (str != null) {
            return str;
        }
        UnityVersionProvider unityVersionProvider = this.fallback;
        if (unityVersionProvider != null) {
            return unityVersionProvider.getUnityVersion();
        }
        return null;
    }
}
