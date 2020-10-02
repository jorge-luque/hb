package com.tapjoy.internal;

import com.tapjoy.TJEarnedCurrencyListener;

public class TJEarnedCurrencyListenerNative implements TJEarnedCurrencyListener {

    /* renamed from: a */
    private final long f13289a;

    private TJEarnedCurrencyListenerNative(long j) {
        if (j != 0) {
            this.f13289a = j;
            return;
        }
        throw new IllegalArgumentException();
    }

    @C3135ft
    static Object create(long j) {
        return new TJEarnedCurrencyListenerNative(j);
    }

    private static native void onEarnedCurrencyNative(long j, String str, int i);

    public void onEarnedCurrency(String str, int i) {
        onEarnedCurrencyNative(this.f13289a, str, i);
    }
}
