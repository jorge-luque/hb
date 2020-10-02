package com.chartboost.sdk.impl;

import java.io.Serializable;
import java.io.Writer;

/* renamed from: com.chartboost.sdk.impl.c2 */
public class C2130c2 extends Writer implements Serializable {

    /* renamed from: a */
    private final StringBuilder f7133a;

    public C2130c2(int i) {
        this.f7133a = new StringBuilder(i);
    }

    public void close() {
    }

    public void flush() {
    }

    public String toString() {
        return this.f7133a.toString();
    }

    public void write(String str) {
        if (str != null) {
            this.f7133a.append(str);
        }
    }

    public void write(char[] cArr, int i, int i2) {
        if (cArr != null) {
            this.f7133a.append(cArr, i, i2);
        }
    }

    public Writer append(char c) {
        this.f7133a.append(c);
        return this;
    }

    public Writer append(CharSequence charSequence) {
        this.f7133a.append(charSequence);
        return this;
    }

    public Writer append(CharSequence charSequence, int i, int i2) {
        this.f7133a.append(charSequence, i, i2);
        return this;
    }
}
