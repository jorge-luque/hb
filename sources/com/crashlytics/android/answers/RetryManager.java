package com.crashlytics.android.answers;

import p118io.fabric.sdk.android.services.concurrency.p206m.C6189e;

class RetryManager {
    private static final long NANOSECONDS_IN_MS = 1000000;
    long lastRetry;
    private C6189e retryState;

    public RetryManager(C6189e eVar) {
        if (eVar != null) {
            this.retryState = eVar;
            return;
        }
        throw new NullPointerException("retryState must not be null");
    }

    public boolean canRetry(long j) {
        return j - this.lastRetry >= this.retryState.mo34319a() * NANOSECONDS_IN_MS;
    }

    public void recordRetry(long j) {
        this.lastRetry = j;
        this.retryState = this.retryState.mo34321c();
    }

    public void reset() {
        this.lastRetry = 0;
        this.retryState = this.retryState.mo34320b();
    }
}
