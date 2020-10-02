package com.crashlytics.android.core;

import com.crashlytics.android.core.Report;
import java.io.File;
import java.util.Map;
import p118io.fabric.sdk.android.C6059c;

class NativeSessionReport implements Report {
    private final File reportDirectory;

    public NativeSessionReport(File file) {
        this.reportDirectory = file;
    }

    public Map<String, String> getCustomHeaders() {
        return null;
    }

    public File getFile() {
        return null;
    }

    public String getFileName() {
        return null;
    }

    public File[] getFiles() {
        return this.reportDirectory.listFiles();
    }

    public String getIdentifier() {
        return this.reportDirectory.getName();
    }

    public Report.Type getType() {
        return Report.Type.NATIVE;
    }

    public void remove() {
        for (File file : getFiles()) {
            C6059c.m19630f().mo34093d(CrashlyticsCore.TAG, "Removing native report file at " + file.getPath());
            file.delete();
        }
        C6059c.m19630f().mo34093d(CrashlyticsCore.TAG, "Removing native report directory at " + this.reportDirectory);
        this.reportDirectory.delete();
    }
}
