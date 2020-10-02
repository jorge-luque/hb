package com.applovin.impl.mediation;

import com.applovin.impl.sdk.utils.C2025o;

/* renamed from: com.applovin.impl.mediation.e */
public class C1732e {
    public static final C1732e EMPTY = new C1732e(0);
    private final int errorCode;
    private final String errorMessage;

    public C1732e(int i) {
        this(i, "");
    }

    public C1732e(int i, String str) {
        this.errorCode = i;
        this.errorMessage = C2025o.m7964c(str);
    }

    public C1732e(String str) {
        this(-1, str);
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String toString() {
        return "MaxError{errorCode=" + getErrorCode() + ", errorMessage='" + getErrorMessage() + '\'' + '}';
    }
}
