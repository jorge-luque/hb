package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzom {
    private int size;
    private long[] zzbhe;

    public zzom() {
        this(32);
    }

    public final void add(long j) {
        int i = this.size;
        long[] jArr = this.zzbhe;
        if (i == jArr.length) {
            this.zzbhe = Arrays.copyOf(jArr, i << 1);
        }
        long[] jArr2 = this.zzbhe;
        int i2 = this.size;
        this.size = i2 + 1;
        jArr2[i2] = j;
    }

    public final long get(int i) {
        if (i >= 0 && i < this.size) {
            return this.zzbhe[i];
        }
        int i2 = this.size;
        StringBuilder sb = new StringBuilder(46);
        sb.append("Invalid index ");
        sb.append(i);
        sb.append(", size is ");
        sb.append(i2);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public final int size() {
        return this.size;
    }

    private zzom(int i) {
        this.zzbhe = new long[32];
    }
}
