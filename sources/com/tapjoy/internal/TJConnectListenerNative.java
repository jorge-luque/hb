package com.tapjoy.internal;

import com.tapjoy.TJConnectListener;

public class TJConnectListenerNative implements TJConnectListener {

    /* renamed from: a */
    private final long f13288a;

    private TJConnectListenerNative(long j) {
        if (j != 0) {
            this.f13288a = j;
            return;
        }
        throw new IllegalArgumentException();
    }

    @C3135ft
    static Object create(long j) {
        return new TJConnectListenerNative(j);
    }

    private static native void onConnectFailureNative(long j);

    private static native void onConnectSuccessNative(long j);

    public void onConnectFailure() {
        onConnectFailureNative(this.f13288a);
    }

    public void onConnectSuccess() {
        onConnectSuccessNative(this.f13288a);
    }
}
