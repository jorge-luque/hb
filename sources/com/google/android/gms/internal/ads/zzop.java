package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzop {
    private byte[] data;
    private int zzbhi;
    private int zzbhj;
    private int zzbhk;

    public zzop() {
    }

    public final int zzbe(int i) {
        int i2;
        int i3;
        byte b;
        byte b2;
        boolean z = false;
        if (i == 0) {
            return 0;
        }
        int i4 = i / 8;
        byte b3 = 0;
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = this.zzbhj;
            if (i6 != 0) {
                byte[] bArr = this.data;
                int i7 = this.zzbhi;
                b2 = ((bArr[i7 + 1] & 255) >>> (8 - i6)) | ((bArr[i7] & 255) << i6);
            } else {
                b2 = this.data[this.zzbhi];
            }
            i -= 8;
            b3 |= (255 & b2) << i;
            this.zzbhi++;
        }
        if (i > 0) {
            int i8 = this.zzbhj + i;
            byte b4 = (byte) (255 >> (8 - i));
            if (i8 > 8) {
                byte[] bArr2 = this.data;
                int i9 = this.zzbhi;
                b = (b4 & (((bArr2[i9 + 1] & 255) >> (16 - i8)) | ((bArr2[i9] & 255) << (i8 - 8)))) | b3;
                this.zzbhi = i9 + 1;
            } else {
                byte[] bArr3 = this.data;
                int i10 = this.zzbhi;
                b = (b4 & ((bArr3[i10] & 255) >> (8 - i8))) | b3;
                if (i8 == 8) {
                    this.zzbhi = i10 + 1;
                }
            }
            b3 = b;
            this.zzbhj = i8 % 8;
        }
        int i11 = this.zzbhi;
        if (i11 >= 0 && (i2 = this.zzbhj) >= 0 && i2 < 8 && (i11 < (i3 = this.zzbhk) || (i11 == i3 && i2 == 0))) {
            z = true;
        }
        zzoh.checkState(z);
        return b3;
    }

    public zzop(byte[] bArr) {
        this(bArr, bArr.length);
    }

    private zzop(byte[] bArr, int i) {
        this.data = bArr;
        this.zzbhk = i;
    }
}
