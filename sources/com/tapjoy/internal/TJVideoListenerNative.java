package com.tapjoy.internal;

import com.tapjoy.TJVideoListener;

public class TJVideoListenerNative implements TJVideoListener {

    /* renamed from: a */
    private final long f13293a;

    private TJVideoListenerNative(long j) {
        if (j != 0) {
            this.f13293a = j;
            return;
        }
        throw new IllegalArgumentException();
    }

    @C3135ft
    static Object create(long j) {
        return new TJVideoListenerNative(j);
    }

    private static native void onVideoCompleteNative(long j);

    private static native void onVideoErrorNative(long j, int i);

    private static native void onVideoStartNative(long j);

    public void onVideoComplete() {
        onVideoCompleteNative(this.f13293a);
    }

    public void onVideoError(int i) {
        onVideoErrorNative(this.f13293a, i);
    }

    public void onVideoStart() {
        onVideoStartNative(this.f13293a);
    }
}
