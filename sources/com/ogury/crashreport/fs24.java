package com.ogury.crashreport;

import java.util.NoSuchElementException;

/* compiled from: ProgressionIterators.kt */
public final class fs24 extends tx720 {

    /* renamed from: a */
    private final int f12206a;

    /* renamed from: b */
    private boolean f12207b;

    /* renamed from: c */
    private int f12208c;

    /* renamed from: d */
    private final int f12209d;

    public fs24(int i, int i2, int i3) {
        this.f12209d = i3;
        this.f12206a = i2;
        boolean z = true;
        if (i3 <= 0 ? i < i2 : i > i2) {
            z = false;
        }
        this.f12207b = z;
        this.f12208c = !z ? this.f12206a : i;
    }

    /* renamed from: a */
    public final int mo29598a() {
        int i = this.f12208c;
        if (i != this.f12206a) {
            this.f12208c = this.f12209d + i;
        } else if (this.f12207b) {
            this.f12207b = false;
        } else {
            throw new NoSuchElementException();
        }
        return i;
    }

    public final boolean hasNext() {
        return this.f12207b;
    }
}
