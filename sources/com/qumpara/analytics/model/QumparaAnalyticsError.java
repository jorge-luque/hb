package com.qumpara.analytics.model;

public class QumparaAnalyticsError {
    private int code;
    private String message;

    public QumparaAnalyticsError() {
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public String toString() {
        return "QumparaAnalyticsError{code=" + this.code + ", message='" + this.message + '\'' + '}';
    }

    public QumparaAnalyticsError(int i, String str) {
        this.message = str;
        this.code = i;
    }
}
