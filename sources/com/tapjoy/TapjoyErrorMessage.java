package com.tapjoy;

public class TapjoyErrorMessage {

    /* renamed from: a */
    private ErrorType f13266a;

    /* renamed from: b */
    private String f13267b;

    public enum ErrorType {
        INTERNAL_ERROR,
        SDK_ERROR,
        SERVER_ERROR,
        INTEGRATION_ERROR,
        NETWORK_ERROR
    }

    public TapjoyErrorMessage(ErrorType errorType, String str) {
        this.f13266a = errorType;
        this.f13267b = str;
    }

    public ErrorType getType() {
        return this.f13266a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Type=" + this.f13266a.toString());
        sb.append(";Message=" + this.f13267b);
        return sb.toString();
    }
}
