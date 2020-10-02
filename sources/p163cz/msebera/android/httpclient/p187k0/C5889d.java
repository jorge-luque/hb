package p163cz.msebera.android.httpclient.p187k0;

import java.io.Serializable;
import java.nio.CharBuffer;
import p163cz.msebera.android.httpclient.p186j0.C5874d;

/* renamed from: cz.msebera.android.httpclient.k0.d */
/* compiled from: CharArrayBuffer */
public final class C5889d implements CharSequence, Serializable {
    private static final long serialVersionUID = -6208952725094867135L;

    /* renamed from: a */
    private char[] f15116a;

    /* renamed from: b */
    private int f15117b;

    public C5889d(int i) {
        C5886a.m18891a(i, "Buffer capacity");
        this.f15116a = new char[i];
    }

    /* renamed from: c */
    private void m18916c(int i) {
        char[] cArr = new char[Math.max(this.f15116a.length << 1, i)];
        System.arraycopy(this.f15116a, 0, cArr, 0, this.f15117b);
        this.f15116a = cArr;
    }

    /* renamed from: a */
    public void mo33672a(char[] cArr, int i, int i2) {
        int i3;
        if (cArr != null) {
            if (i < 0 || i > cArr.length || i2 < 0 || (i3 = i + i2) < 0 || i3 > cArr.length) {
                throw new IndexOutOfBoundsException("off: " + i + " len: " + i2 + " b.length: " + cArr.length);
            } else if (i2 != 0) {
                int i4 = this.f15117b + i2;
                if (i4 > this.f15116a.length) {
                    m18916c(i4);
                }
                System.arraycopy(cArr, i, this.f15116a, this.f15117b, i2);
                this.f15117b = i4;
            }
        }
    }

    /* renamed from: b */
    public void mo33676b() {
        this.f15117b = 0;
    }

    public char charAt(int i) {
        return this.f15116a[i];
    }

    public int length() {
        return this.f15117b;
    }

    public CharSequence subSequence(int i, int i2) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("Negative beginIndex: " + i);
        } else if (i2 > this.f15117b) {
            throw new IndexOutOfBoundsException("endIndex: " + i2 + " > length: " + this.f15117b);
        } else if (i <= i2) {
            return CharBuffer.wrap(this.f15116a, i, i2);
        } else {
            throw new IndexOutOfBoundsException("beginIndex: " + i + " > endIndex: " + i2);
        }
    }

    public String toString() {
        return new String(this.f15116a, 0, this.f15117b);
    }

    /* renamed from: b */
    public int mo33674b(int i) {
        return mo33664a(i, 0, this.f15117b);
    }

    /* renamed from: b */
    public String mo33675b(int i, int i2) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("Negative beginIndex: " + i);
        } else if (i2 > this.f15117b) {
            throw new IndexOutOfBoundsException("endIndex: " + i2 + " > length: " + this.f15117b);
        } else if (i <= i2) {
            while (i < i2 && C5874d.m18865a(this.f15116a[i])) {
                i++;
            }
            while (i2 > i && C5874d.m18865a(this.f15116a[i2 - 1])) {
                i2--;
            }
            return new String(this.f15116a, i, i2 - i);
        } else {
            throw new IndexOutOfBoundsException("beginIndex: " + i + " > endIndex: " + i2);
        }
    }

    /* renamed from: c */
    public boolean mo33677c() {
        return this.f15117b == 0;
    }

    /* renamed from: a */
    public void mo33670a(String str) {
        if (str == null) {
            str = "null";
        }
        int length = str.length();
        int i = this.f15117b + length;
        if (i > this.f15116a.length) {
            m18916c(i);
        }
        str.getChars(0, length, this.f15116a, this.f15117b);
        this.f15117b = i;
    }

    /* renamed from: a */
    public void mo33669a(C5889d dVar, int i, int i2) {
        if (dVar != null) {
            mo33672a(dVar.f15116a, i, i2);
        }
    }

    /* renamed from: a */
    public void mo33666a(char c) {
        int i = this.f15117b + 1;
        if (i > this.f15116a.length) {
            m18916c(i);
        }
        this.f15116a[this.f15117b] = c;
        this.f15117b = i;
    }

    /* renamed from: a */
    public void mo33671a(byte[] bArr, int i, int i2) {
        int i3;
        if (bArr != null) {
            if (i < 0 || i > bArr.length || i2 < 0 || (i3 = i + i2) < 0 || i3 > bArr.length) {
                throw new IndexOutOfBoundsException("off: " + i + " len: " + i2 + " b.length: " + bArr.length);
            } else if (i2 != 0) {
                int i4 = this.f15117b;
                int i5 = i2 + i4;
                if (i5 > this.f15116a.length) {
                    m18916c(i5);
                }
                while (i4 < i5) {
                    this.f15116a[i4] = (char) (bArr[i] & 255);
                    i++;
                    i4++;
                }
                this.f15117b = i5;
            }
        }
    }

    /* renamed from: a */
    public void mo33668a(C5888c cVar, int i, int i2) {
        if (cVar != null) {
            mo33671a(cVar.mo33656a(), i, i2);
        }
    }

    /* renamed from: a */
    public char[] mo33673a() {
        return this.f15116a;
    }

    /* renamed from: a */
    public void mo33667a(int i) {
        if (i > 0) {
            int length = this.f15116a.length;
            int i2 = this.f15117b;
            if (i > length - i2) {
                m18916c(i2 + i);
            }
        }
    }

    /* renamed from: a */
    public int mo33664a(int i, int i2, int i3) {
        if (i2 < 0) {
            i2 = 0;
        }
        int i4 = this.f15117b;
        if (i3 > i4) {
            i3 = i4;
        }
        if (i2 > i3) {
            return -1;
        }
        while (i2 < i3) {
            if (this.f15116a[i2] == i) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    /* renamed from: a */
    public String mo33665a(int i, int i2) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("Negative beginIndex: " + i);
        } else if (i2 > this.f15117b) {
            throw new IndexOutOfBoundsException("endIndex: " + i2 + " > length: " + this.f15117b);
        } else if (i <= i2) {
            return new String(this.f15116a, i, i2 - i);
        } else {
            throw new IndexOutOfBoundsException("beginIndex: " + i + " > endIndex: " + i2);
        }
    }
}
