package com.crashlytics.android.core;

import android.os.AsyncTask;
import com.tapjoy.TapjoyAuctionFlags;
import p118io.fabric.sdk.android.C6059c;
import p118io.fabric.sdk.android.C6072k;

public class CrashTest {
    private void privateMethodThatThrowsException(String str) {
        throw new RuntimeException(str);
    }

    public void crashAsyncTask(final long j) {
        new AsyncTask<Void, Void, Void>() {
            /* access modifiers changed from: protected */
            public Void doInBackground(Void... voidArr) {
                try {
                    Thread.sleep(j);
                } catch (InterruptedException unused) {
                }
                CrashTest.this.throwRuntimeException("Background thread crash");
                return null;
            }
        }.execute(new Void[]{null});
    }

    public void indexOutOfBounds() {
        int i = new int[2][10];
        C6072k f = C6059c.m19630f();
        f.mo34093d(CrashlyticsCore.TAG, "Out of bounds value: " + i);
    }

    public int stackOverflow() {
        return stackOverflow() + ((int) Math.random());
    }

    public void throwFiveChainedExceptions() {
        try {
            privateMethodThatThrowsException("1");
        } catch (Exception e) {
            throw new RuntimeException(TapjoyAuctionFlags.AUCTION_TYPE_SECOND_PRICE, e);
        } catch (Exception e2) {
            try {
                throw new RuntimeException("3", e2);
            } catch (Exception e3) {
                try {
                    throw new RuntimeException("4", e3);
                } catch (Exception e4) {
                    throw new RuntimeException("5", e4);
                }
            }
        }
    }

    public void throwRuntimeException(String str) {
        throw new RuntimeException(str);
    }
}
