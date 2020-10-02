package com.tapjoy.internal;

import com.tapjoy.TJGetCurrencyBalanceListener;

public class TJGetCurrencyBalanceListenerNative implements TJGetCurrencyBalanceListener {

    /* renamed from: a */
    private final long f13290a;

    private TJGetCurrencyBalanceListenerNative(long j) {
        if (j != 0) {
            this.f13290a = j;
            return;
        }
        throw new IllegalArgumentException();
    }

    @C3135ft
    static Object create(long j) {
        return new TJGetCurrencyBalanceListenerNative(j);
    }

    private static native void onGetCurrencyBalanceResponseFailureNative(long j, String str);

    private static native void onGetCurrencyBalanceResponseNative(long j, String str, int i);

    public void onGetCurrencyBalanceResponse(String str, int i) {
        onGetCurrencyBalanceResponseNative(this.f13290a, str, i);
    }

    public void onGetCurrencyBalanceResponseFailure(String str) {
        onGetCurrencyBalanceResponseFailureNative(this.f13290a, str);
    }
}
