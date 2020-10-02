package com.ogury.p159cm;

import java.util.NoSuchElementException;

/* renamed from: com.ogury.cm.baaba */
public final class baaba extends acbbc {

    /* renamed from: a */
    private final int f12155a;

    /* renamed from: b */
    private boolean f12156b;

    /* renamed from: c */
    private int f12157c;

    /* renamed from: d */
    private final int f12158d;

    public baaba(int i, int i2, int i3) {
        this.f12158d = i3;
        this.f12155a = i2;
        boolean z = true;
        if (i3 <= 0 ? i < i2 : i > i2) {
            z = false;
        }
        this.f12156b = z;
        this.f12157c = !z ? this.f12155a : i;
    }

    /* renamed from: a */
    public final int mo29532a() {
        int i = this.f12157c;
        if (i != this.f12155a) {
            this.f12157c = this.f12158d + i;
        } else if (this.f12156b) {
            this.f12156b = false;
        } else {
            throw new NoSuchElementException();
        }
        return i;
    }

    public final boolean hasNext() {
        return this.f12156b;
    }
}
