package com.vungle.warren;

import com.vungle.warren.error.VungleException;
import java.util.concurrent.ExecutorService;

class PlayAdCallbackWrapper implements PlayAdCallback {
    private final ExecutorService executorService;
    /* access modifiers changed from: private */
    public final PlayAdCallback playAdCallback;

    public PlayAdCallbackWrapper(ExecutorService executorService2, PlayAdCallback playAdCallback2) {
        this.playAdCallback = playAdCallback2;
        this.executorService = executorService2;
    }

    public void onAdClick(final String str) {
        if (this.playAdCallback != null) {
            this.executorService.execute(new Runnable() {
                public void run() {
                    PlayAdCallbackWrapper.this.playAdCallback.onAdClick(str);
                }
            });
        }
    }

    public void onAdEnd(final String str, final boolean z, final boolean z2) {
        if (this.playAdCallback != null) {
            this.executorService.execute(new Runnable() {
                public void run() {
                    PlayAdCallbackWrapper.this.playAdCallback.onAdEnd(str, z, z2);
                }
            });
        }
    }

    public void onAdLeftApplication(final String str) {
        if (this.playAdCallback != null) {
            this.executorService.execute(new Runnable() {
                public void run() {
                    PlayAdCallbackWrapper.this.playAdCallback.onAdLeftApplication(str);
                }
            });
        }
    }

    public void onAdRewarded(final String str) {
        if (this.playAdCallback != null) {
            this.executorService.execute(new Runnable() {
                public void run() {
                    PlayAdCallbackWrapper.this.playAdCallback.onAdRewarded(str);
                }
            });
        }
    }

    public void onAdStart(final String str) {
        if (this.playAdCallback != null) {
            this.executorService.execute(new Runnable() {
                public void run() {
                    PlayAdCallbackWrapper.this.playAdCallback.onAdStart(str);
                }
            });
        }
    }

    public void onError(final String str, final VungleException vungleException) {
        if (this.playAdCallback != null) {
            this.executorService.execute(new Runnable() {
                public void run() {
                    PlayAdCallbackWrapper.this.playAdCallback.onError(str, vungleException);
                }
            });
        }
    }

    public void onAdEnd(final String str) {
        if (this.playAdCallback != null) {
            this.executorService.execute(new Runnable() {
                public void run() {
                    PlayAdCallbackWrapper.this.playAdCallback.onAdEnd(str);
                }
            });
        }
    }
}
