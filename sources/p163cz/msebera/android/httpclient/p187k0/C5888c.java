package p163cz.msebera.android.httpclient.p187k0;

import java.io.Serializable;

/* renamed from: cz.msebera.android.httpclient.k0.c */
/* compiled from: ByteArrayBuffer */
public final class C5888c implements Serializable {
    private static final long serialVersionUID = 4359112959524048036L;

    /* renamed from: a */
    private byte[] f15114a;

    /* renamed from: b */
    private int f15115b;

    public C5888c(int i) {
        C5886a.m18891a(i, "Buffer capacity");
        this.f15114a = new byte[i];
    }

    /* renamed from: c */
    private void m18903c(int i) {
        byte[] bArr = new byte[Math.max(this.f15114a.length << 1, i)];
        System.arraycopy(this.f15114a, 0, bArr, 0, this.f15115b);
        this.f15114a = bArr;
    }

    /* renamed from: a */
    public void mo33654a(byte[] bArr, int i, int i2) {
        int i3;
        if (bArr != null) {
            if (i < 0 || i > bArr.length || i2 < 0 || (i3 = i + i2) < 0 || i3 > bArr.length) {
                throw new IndexOutOfBoundsException("off: " + i + " len: " + i2 + " b.length: " + bArr.length);
            } else if (i2 != 0) {
                int i4 = this.f15115b + i2;
                if (i4 > this.f15114a.length) {
                    m18903c(i4);
                }
                System.arraycopy(bArr, i, this.f15114a, this.f15115b, i2);
                this.f15115b = i4;
            }
        }
    }

    /* renamed from: b */
    public int mo33658b(int i) {
        return this.f15114a[i];
    }

    /* renamed from: d */
    public boolean mo33660d() {
        return this.f15115b == 0;
    }

    /* renamed from: e */
    public boolean mo33661e() {
        return this.f15115b == this.f15114a.length;
    }

    /* renamed from: f */
    public int mo33662f() {
        return this.f15115b;
    }

    /* renamed from: g */
    public byte[] mo33663g() {
        int i = this.f15115b;
        byte[] bArr = new byte[i];
        if (i > 0) {
            System.arraycopy(this.f15114a, 0, bArr, 0, i);
        }
        return bArr;
    }

    /* renamed from: b */
    public int mo33657b() {
        return this.f15114a.length;
    }

    /* renamed from: c */
    public void mo33659c() {
        this.f15115b = 0;
    }

    /* renamed from: a */
    public void mo33652a(int i) {
        int i2 = this.f15115b + 1;
        if (i2 > this.f15114a.length) {
            m18903c(i2);
        }
        this.f15114a[this.f15115b] = (byte) i;
        this.f15115b = i2;
    }

    /* renamed from: a */
    public void mo33655a(char[] cArr, int i, int i2) {
        int i3;
        if (cArr != null) {
            if (i < 0 || i > cArr.length || i2 < 0 || (i3 = i + i2) < 0 || i3 > cArr.length) {
                throw new IndexOutOfBoundsException("off: " + i + " len: " + i2 + " b.length: " + cArr.length);
            } else if (i2 != 0) {
                int i4 = this.f15115b;
                int i5 = i2 + i4;
                if (i5 > this.f15114a.length) {
                    m18903c(i5);
                }
                while (i4 < i5) {
                    this.f15114a[i4] = (byte) cArr[i];
                    i++;
                    i4++;
                }
                this.f15115b = i5;
            }
        }
    }

    /* renamed from: a */
    public void mo33653a(C5889d dVar, int i, int i2) {
        if (dVar != null) {
            mo33655a(dVar.mo33673a(), i, i2);
        }
    }

    /* renamed from: a */
    public byte[] mo33656a() {
        return this.f15114a;
    }
}
