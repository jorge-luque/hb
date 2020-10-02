package com.crashlytics.android.answers;

import java.io.File;
import java.util.List;
import p118io.fabric.sdk.android.p200m.p203c.C6126f;
import p118io.fabric.sdk.android.services.concurrency.p206m.C6186b;
import p118io.fabric.sdk.android.services.concurrency.p206m.C6187c;
import p118io.fabric.sdk.android.services.concurrency.p206m.C6189e;

class AnswersRetryFilesSender implements C6126f {
    private static final int BACKOFF_MS = 1000;
    private static final int BACKOFF_POWER = 8;
    private static final double JITTER_PERCENT = 0.1d;
    private static final int MAX_RETRIES = 5;
    private final SessionAnalyticsFilesSender filesSender;
    private final RetryManager retryManager;

    AnswersRetryFilesSender(SessionAnalyticsFilesSender sessionAnalyticsFilesSender, RetryManager retryManager2) {
        this.filesSender = sessionAnalyticsFilesSender;
        this.retryManager = retryManager2;
    }

    public static AnswersRetryFilesSender build(SessionAnalyticsFilesSender sessionAnalyticsFilesSender) {
        return new AnswersRetryFilesSender(sessionAnalyticsFilesSender, new RetryManager(new C6189e(new RandomBackoff(new C6187c(1000, 8), 0.1d), new C6186b(5))));
    }

    public boolean send(List<File> list) {
        long nanoTime = System.nanoTime();
        if (this.retryManager.canRetry(nanoTime)) {
            if (this.filesSender.send(list)) {
                this.retryManager.reset();
                return true;
            }
            this.retryManager.recordRetry(nanoTime);
        }
        return false;
    }
}
