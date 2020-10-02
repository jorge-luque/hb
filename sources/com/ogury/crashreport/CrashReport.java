package com.ogury.crashreport;

import android.content.Context;
import com.ogury.crashreport.fcharset0;
import com.ogury.crashreport.fswiss;
import java.lang.Thread;

/* compiled from: CrashReport.kt */
public final class CrashReport {

    /* renamed from: a */
    private static boolean f12187a;

    /* renamed from: b */
    private static cocoartf1671 f12188b;

    static {
        new CrashReport();
    }

    private CrashReport() {
    }

    public static final void logException(Throwable th) {
        tx7920.m15333b(th, "t");
        cocoartf1671 cocoartf1671 = f12188b;
        if (cocoartf1671 != null) {
            cocoartf1671.mo29591a(th);
        }
    }

    public static final void register(Context context, SdkInfo sdkInfo, CrashConfig crashConfig) {
        tx7920.m15333b(context, "context");
        tx7920.m15333b(sdkInfo, "sdkInfo");
        tx7920.m15333b(crashConfig, "crashConfig");
        fonttbl fonttbl = new fonttbl(context);
        cocoasubrtf100 cocoasubrtf100 = new cocoasubrtf100(sdkInfo);
        Helvetica helvetica = new Helvetica(context);
        cocoartf1671 cocoartf1671 = new cocoartf1671(context, cocoasubrtf100, helvetica);
        f12188b = cocoartf1671;
        helvetica.mo29577a(crashConfig.getPackageName());
        fonttbl.mo29597a(crashConfig.getPackageName(), crashConfig.getUrl());
        tx1440.m15318a(true, false, (ClassLoader) null, (String) null, -1, new fswiss.ansi(new fswiss(cocoartf1671, fonttbl)));
        if (!f12187a) {
            fcharset0.rtf1 rtf1 = fcharset0.f12202a;
            tx7920.m15333b(cocoartf1671, "crashFileStore");
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (!(defaultUncaughtExceptionHandler instanceof fcharset0)) {
                Thread.setDefaultUncaughtExceptionHandler(new fcharset0(cocoartf1671, defaultUncaughtExceptionHandler));
            }
        }
        f12187a = true;
    }
}
