package com.crashlytics.android.answers;

import java.util.Random;
import p118io.fabric.sdk.android.services.concurrency.p206m.C6185a;

class RandomBackoff implements C6185a {
    final C6185a backoff;
    final double jitterPercent;
    final Random random;

    public RandomBackoff(C6185a aVar, double d) {
        this(aVar, d, new Random());
    }

    public long getDelayMillis(int i) {
        double randomJitter = randomJitter();
        double delayMillis = (double) this.backoff.getDelayMillis(i);
        Double.isNaN(delayMillis);
        return (long) (randomJitter * delayMillis);
    }

    /* access modifiers changed from: package-private */
    public double randomJitter() {
        double d = this.jitterPercent;
        double d2 = 1.0d - d;
        return d2 + (((d + 1.0d) - d2) * this.random.nextDouble());
    }

    public RandomBackoff(C6185a aVar, double d, Random random2) {
        if (d < 0.0d || d > 1.0d) {
            throw new IllegalArgumentException("jitterPercent must be between 0.0 and 1.0");
        } else if (aVar == null) {
            throw new NullPointerException("backoff must not be null");
        } else if (random2 != null) {
            this.backoff = aVar;
            this.jitterPercent = d;
            this.random = random2;
        } else {
            throw new NullPointerException("random must not be null");
        }
    }
}
