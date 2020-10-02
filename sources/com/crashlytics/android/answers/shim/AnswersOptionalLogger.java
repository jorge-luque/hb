package com.crashlytics.android.answers.shim;

public class AnswersOptionalLogger {
    private static final String TAG = "AnswersOptionalLogger";
    private static final KitEventLogger logger;

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0011  */
    static {
        /*
            com.crashlytics.android.answers.shim.AnswersKitEventLogger r0 = com.crashlytics.android.answers.shim.AnswersKitEventLogger.create()     // Catch:{ IllegalStateException | NoClassDefFoundError -> 0x000d, all -> 0x0005 }
            goto L_0x000e
        L_0x0005:
            r0 = move-exception
            java.lang.String r1 = "AnswersOptionalLogger"
            java.lang.String r2 = "Unexpected error creating AnswersKitEventLogger"
            android.util.Log.w(r1, r2, r0)
        L_0x000d:
            r0 = 0
        L_0x000e:
            if (r0 == 0) goto L_0x0011
            goto L_0x0015
        L_0x0011:
            com.crashlytics.android.answers.shim.KitEventLogger r0 = com.crashlytics.android.answers.shim.NoopKitEventLogger.create()
        L_0x0015:
            logger = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.answers.shim.AnswersOptionalLogger.<clinit>():void");
    }

    public static KitEventLogger get() {
        return logger;
    }
}
