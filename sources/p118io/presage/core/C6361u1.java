package p118io.presage.core;

/* renamed from: io.presage.core.u1 */
public class C6361u1 implements C6357t1 {
    public byte[] IIIIIIII;

    public static byte[] IIIIIIII(byte[] bArr, byte[] bArr2, boolean z) {
        try {
            int intValue = Integer.valueOf(new String(bArr2)).intValue();
            if (!z) {
                intValue = 26 - (intValue % 26);
            }
            byte[] bArr3 = new byte[bArr.length];
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i] >= 65 && bArr[i] <= 90) {
                    bArr3[i] = (byte) ((((bArr[i] + intValue) - 65) % 26) + 65);
                } else if (bArr[i] < 97 || bArr[i] > 122) {
                    bArr3[i] = bArr[i];
                } else {
                    bArr3[i] = (byte) ((((bArr[i] + intValue) - 97) % 26) + 97);
                }
            }
            return bArr3;
        } catch (Exception e) {
            throw new C6349r1(e);
        }
    }

    public void IIIIIIII(byte[] bArr) {
        this.IIIIIIII = bArr;
    }

    public byte[] IIIIIIIl(byte[] bArr) {
        return IIIIIIII(bArr, this.IIIIIIII, true);
    }

    public byte[] IIIIIIlI(byte[] bArr) {
        return IIIIIIII(bArr, this.IIIIIIII, false);
    }
}
