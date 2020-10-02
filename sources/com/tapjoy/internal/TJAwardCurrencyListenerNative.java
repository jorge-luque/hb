package com.tapjoy.internal;

import com.tapjoy.TJAwardCurrencyListener;

public class TJAwardCurrencyListenerNative implements TJAwardCurrencyListener {

    /* renamed from: a */
    private final long f13287a;

    private TJAwardCurrencyListenerNative(long j) {
        if (j != 0) {
            this.f13287a = j;
            return;
        }
        throw new IllegalArgumentException();
    }

    @C3135ft
    static Object create(long j) {
        return new TJAwardCurrencyListenerNative(j);
    }

    private static native void onAwardCurrencyResponseFailureNative(long j, String str);

    private static native void onAwardCurrencyResponseNative(long j, String str, int i);

    public void onAwardCurrencyResponse(String str, int i) {
        onAwardCurrencyResponseNative(this.f13287a, str, i);
    }

    public void onAwardCurrencyResponseFailure(String str) {
        onAwardCurrencyResponseFailureNative(this.f13287a, str);
    }
}
