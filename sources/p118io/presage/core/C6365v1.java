package p118io.presage.core;

/* renamed from: io.presage.core.v1 */
public class C6365v1 implements C6357t1 {
    public byte[] IIIIIIII;

    public void IIIIIIII(byte[] bArr) {
        this.IIIIIIII = bArr;
    }

    public byte[] IIIIIIIl(byte[] bArr) {
        return IIIIIIll(bArr);
    }

    public byte[] IIIIIIlI(byte[] bArr) {
        return IIIIIIll(bArr);
    }

    public final byte[] IIIIIIll(byte[] bArr) {
        if (this.IIIIIIII != null) {
            byte[] bArr2 = new byte[bArr.length];
            for (int i = 0; i < bArr.length; i++) {
                byte b = bArr[i];
                byte[] bArr3 = this.IIIIIIII;
                bArr2[i] = (byte) (b ^ bArr3[i % bArr3.length]);
            }
            return bArr2;
        }
        throw new C6349r1();
    }
}
