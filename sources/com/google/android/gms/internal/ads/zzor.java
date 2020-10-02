package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzor {
    private byte[] data;
    private int zzbhi;
    private int zzbhj = 0;
    private int zzbhk;

    public zzor(byte[] bArr, int i, int i2) {
        this.data = bArr;
        this.zzbhi = i;
        this.zzbhk = i2;
        zziy();
    }

    private final boolean zzbg(int i) {
        if (2 > i || i >= this.zzbhk) {
            return false;
        }
        byte[] bArr = this.data;
        return bArr[i] == 3 && bArr[i + -2] == 0 && bArr[i - 1] == 0;
    }

    private final int zzix() {
        int i = 0;
        int i2 = 0;
        while (!zziu()) {
            i2++;
        }
        int i3 = (1 << i2) - 1;
        if (i2 > 0) {
            i = zzbe(i2);
        }
        return i3 + i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r3.zzbhj;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000c, code lost:
        r2 = r3.zzbhk;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zziy() {
        /*
            r3 = this;
            int r0 = r3.zzbhi
            if (r0 < 0) goto L_0x0016
            int r1 = r3.zzbhj
            if (r1 < 0) goto L_0x0016
            r2 = 8
            if (r1 >= r2) goto L_0x0016
            int r2 = r3.zzbhk
            if (r0 < r2) goto L_0x0014
            if (r0 != r2) goto L_0x0016
            if (r1 != 0) goto L_0x0016
        L_0x0014:
            r0 = 1
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            com.google.android.gms.internal.ads.zzoh.checkState(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzor.zziy():void");
    }

    public final int zzbe(int i) {
        byte b;
        byte b2;
        if (i == 0) {
            return 0;
        }
        int i2 = i / 8;
        byte b3 = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = zzbg(this.zzbhi + 1) ? this.zzbhi + 2 : this.zzbhi + 1;
            int i5 = this.zzbhj;
            if (i5 != 0) {
                byte[] bArr = this.data;
                b2 = ((bArr[i4] & 255) >>> (8 - i5)) | ((bArr[this.zzbhi] & 255) << i5);
            } else {
                b2 = this.data[this.zzbhi];
            }
            i -= 8;
            b3 |= (255 & b2) << i;
            this.zzbhi = i4;
        }
        if (i > 0) {
            int i6 = this.zzbhj + i;
            byte b4 = (byte) (255 >> (8 - i));
            int i7 = zzbg(this.zzbhi + 1) ? this.zzbhi + 2 : this.zzbhi + 1;
            if (i6 > 8) {
                byte[] bArr2 = this.data;
                b = (b4 & (((255 & bArr2[i7]) >> (16 - i6)) | ((bArr2[this.zzbhi] & 255) << (i6 - 8)))) | b3;
                this.zzbhi = i7;
            } else {
                b = (b4 & ((255 & this.data[this.zzbhi]) >> (8 - i6))) | b3;
                if (i6 == 8) {
                    this.zzbhi = i7;
                }
            }
            b3 = b;
            this.zzbhj = i6 % 8;
        }
        zziy();
        return b3;
    }

    public final void zzbf(int i) {
        int i2 = this.zzbhi;
        int i3 = (i / 8) + i2;
        this.zzbhi = i3;
        int i4 = this.zzbhj + (i % 8);
        this.zzbhj = i4;
        if (i4 > 7) {
            this.zzbhi = i3 + 1;
            this.zzbhj = i4 - 8;
        }
        while (true) {
            i2++;
            if (i2 > this.zzbhi) {
                zziy();
                return;
            } else if (zzbg(i2)) {
                this.zzbhi++;
                i2 += 2;
            }
        }
    }

    public final boolean zziu() {
        return zzbe(1) == 1;
    }

    public final int zziv() {
        return zzix();
    }

    public final int zziw() {
        int zzix = zzix();
        return (zzix % 2 == 0 ? -1 : 1) * ((zzix + 1) / 2);
    }
}
