package com.crashlytics.android.core;

import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;
import p118io.fabric.sdk.android.C6059c;
import p118io.fabric.sdk.android.p200m.p205e.C6155t;

class CrashlyticsUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    private final CrashListener crashListener;
    private final Thread.UncaughtExceptionHandler defaultHandler;
    private final boolean firebaseCrashlyticsClientFlag;
    private final AtomicBoolean isHandlingException = new AtomicBoolean(false);
    private final SettingsDataProvider settingsDataProvider;

    interface CrashListener {
        void onUncaughtException(SettingsDataProvider settingsDataProvider, Thread thread, Throwable th, boolean z);
    }

    interface SettingsDataProvider {
        C6155t getSettingsData();
    }

    public CrashlyticsUncaughtExceptionHandler(CrashListener crashListener2, SettingsDataProvider settingsDataProvider2, boolean z, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.crashListener = crashListener2;
        this.settingsDataProvider = settingsDataProvider2;
        this.firebaseCrashlyticsClientFlag = z;
        this.defaultHandler = uncaughtExceptionHandler;
    }

    /* access modifiers changed from: package-private */
    public boolean isHandlingException() {
        return this.isHandlingException.get();
    }

    public void uncaughtException(Thread thread, Throwable th) {
        this.isHandlingException.set(true);
        try {
            this.crashListener.onUncaughtException(this.settingsDataProvider, thread, th, this.firebaseCrashlyticsClientFlag);
        } catch (Exception e) {
            C6059c.m19630f().mo34090b(CrashlyticsCore.TAG, "An error occurred in the uncaught exception handler", e);
        } catch (Throwable th2) {
            C6059c.m19630f().mo34093d(CrashlyticsCore.TAG, "Crashlytics completed exception processing. Invoking default exception handler.");
            this.defaultHandler.uncaughtException(thread, th);
            this.isHandlingException.set(false);
            throw th2;
        }
        C6059c.m19630f().mo34093d(CrashlyticsCore.TAG, "Crashlytics completed exception processing. Invoking default exception handler.");
        this.defaultHandler.uncaughtException(thread, th);
        this.isHandlingException.set(false);
    }
}
