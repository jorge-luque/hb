package com.crashlytics.android.core;

import java.io.File;
import java.io.IOException;
import p118io.fabric.sdk.android.C6059c;
import p118io.fabric.sdk.android.C6072k;
import p118io.fabric.sdk.android.p200m.p204d.C6130a;

class CrashlyticsFileMarker {
    private final C6130a fileStore;
    private final String markerName;

    public CrashlyticsFileMarker(String str, C6130a aVar) {
        this.markerName = str;
        this.fileStore = aVar;
    }

    private File getMarkerFile() {
        return new File(this.fileStore.mo34239a(), this.markerName);
    }

    public boolean create() {
        try {
            return getMarkerFile().createNewFile();
        } catch (IOException e) {
            C6072k f = C6059c.m19630f();
            f.mo34090b(CrashlyticsCore.TAG, "Error creating marker: " + this.markerName, e);
            return false;
        }
    }

    public boolean isPresent() {
        return getMarkerFile().exists();
    }

    public boolean remove() {
        return getMarkerFile().delete();
    }
}
