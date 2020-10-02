package com.tapjoy.internal;

import com.tapjoy.TJSpendCurrencyListener;

public class TJSpendCurrencyListenerNative implements TJSpendCurrencyListener {

    /* renamed from: a */
    private final long f13292a;

    private TJSpendCurrencyListenerNative(long j) {
        if (j != 0) {
            this.f13292a = j;
            return;
        }
        throw new IllegalArgumentException();
    }

    @C3135ft
    static Object create(long j) {
        return new TJSpendCurrencyListenerNative(j);
    }

    private static native void onSpendCurrencyResponseFailureNative(long j, String str);

    private static native void onSpendCurrencyResponseNative(long j, String str, int i);

    public void onSpendCurrencyResponse(String str, int i) {
        onSpendCurrencyResponseNative(this.f13292a, str, i);
    }

    public void onSpendCurrencyResponseFailure(String str) {
        onSpendCurrencyResponseFailureNative(this.f13292a, str);
    }
}
