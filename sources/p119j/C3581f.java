package p119j;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.annotation.Nullable;

/* renamed from: j.f */
/* compiled from: ByteString */
public class C3581f implements Serializable, Comparable<C3581f> {

    /* renamed from: d */
    static final char[] f10034d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: e */
    public static final C3581f f10035e = m12174a(new byte[0]);
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    final byte[] f10036a;

    /* renamed from: b */
    transient int f10037b;

    /* renamed from: c */
    transient String f10038c;

    C3581f(byte[] bArr) {
        this.f10036a = bArr;
    }

    /* renamed from: a */
    public static C3581f m12174a(byte... bArr) {
        if (bArr != null) {
            return new C3581f((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    /* renamed from: d */
    public static C3581f m12177d(String str) {
        if (str != null) {
            C3581f fVar = new C3581f(str.getBytes(C6597w.f17172a));
            fVar.f10038c = str;
            return fVar;
        }
        throw new IllegalArgumentException("s == null");
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        C3581f a = m12172a((InputStream) objectInputStream, objectInputStream.readInt());
        try {
            Field declaredField = C3581f.class.getDeclaredField("a");
            declaredField.setAccessible(true);
            declaredField.set(this, a.f10036a);
        } catch (NoSuchFieldException unused) {
            throw new AssertionError();
        } catch (IllegalAccessException unused2) {
            throw new AssertionError();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.f10036a.length);
        objectOutputStream.write(this.f10036a);
    }

    /* renamed from: b */
    public String mo19752b() {
        byte[] bArr = this.f10036a;
        char[] cArr = new char[(bArr.length * 2)];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = f10034d;
            cArr[i] = cArr2[(b >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    /* renamed from: c */
    public C3581f mo19754c() {
        return m12176c("MD5");
    }

    /* renamed from: e */
    public C3581f mo19757e() {
        return m12176c("SHA-256");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C3581f) {
            C3581f fVar = (C3581f) obj;
            int f = fVar.mo19759f();
            byte[] bArr = this.f10036a;
            if (f != bArr.length || !fVar.mo19751a(0, bArr, 0, bArr.length)) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public int mo19759f() {
        return this.f10036a.length;
    }

    /* renamed from: g */
    public C3581f mo19760g() {
        int i = 0;
        while (true) {
            byte[] bArr = this.f10036a;
            if (i >= bArr.length) {
                return this;
            }
            byte b = bArr[i];
            if (b < 65 || b > 90) {
                i++;
            } else {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i] = (byte) (b + 32);
                for (int i2 = i + 1; i2 < bArr2.length; i2++) {
                    byte b2 = bArr2[i2];
                    if (b2 >= 65 && b2 <= 90) {
                        bArr2[i2] = (byte) (b2 + 32);
                    }
                }
                return new C3581f(bArr2);
            }
        }
    }

    /* renamed from: h */
    public byte[] mo19761h() {
        return (byte[]) this.f10036a.clone();
    }

    public int hashCode() {
        int i = this.f10037b;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.f10036a);
        this.f10037b = hashCode;
        return hashCode;
    }

    /* renamed from: i */
    public String mo19763i() {
        String str = this.f10038c;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.f10036a, C6597w.f17172a);
        this.f10038c = str2;
        return str2;
    }

    public String toString() {
        if (this.f10036a.length == 0) {
            return "[size=0]";
        }
        String i = mo19763i();
        int a = m12171a(i, 64);
        if (a != -1) {
            String replace = i.substring(0, a).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
            if (a < i.length()) {
                return "[size=" + this.f10036a.length + " text=" + replace + "…]";
            }
            return "[text=" + replace + "]";
        } else if (this.f10036a.length <= 64) {
            return "[hex=" + mo19752b() + "]";
        } else {
            return "[size=" + this.f10036a.length + " hex=" + mo19747a(0, 64).mo19752b() + "…]";
        }
    }

    /* renamed from: c */
    private C3581f m12176c(String str) {
        try {
            return m12174a(MessageDigest.getInstance(str).digest(this.f10036a));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: a */
    public String mo19748a() {
        return C6581b.m21582a(this.f10036a);
    }

    @Nullable
    /* renamed from: a */
    public static C3581f m12173a(String str) {
        if (str != null) {
            byte[] a = C6581b.m21584a(str);
            if (a != null) {
                return new C3581f(a);
            }
            return null;
        }
        throw new IllegalArgumentException("base64 == null");
    }

    /* renamed from: d */
    public C3581f mo19756d() {
        return m12176c("SHA-1");
    }

    /* renamed from: b */
    public static C3581f m12175b(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        } else if (str.length() % 2 == 0) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) ((m12170a(str.charAt(i2)) << 4) + m12170a(str.charAt(i2 + 1)));
            }
            return m12174a(bArr);
        } else {
            throw new IllegalArgumentException("Unexpected hex string: " + str);
        }
    }

    /* renamed from: a */
    private static int m12170a(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        char c2 = 'a';
        if (c < 'a' || c > 'f') {
            c2 = 'A';
            if (c < 'A' || c > 'F') {
                throw new IllegalArgumentException("Unexpected hex digit: " + c);
            }
        }
        return (c - c2) + 10;
    }

    /* renamed from: a */
    public static C3581f m12172a(InputStream inputStream, int i) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (i >= 0) {
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (i2 < i) {
                int read = inputStream.read(bArr, i2, i - i2);
                if (read != -1) {
                    i2 += read;
                } else {
                    throw new EOFException();
                }
            }
            return new C3581f(bArr);
        } else {
            throw new IllegalArgumentException("byteCount < 0: " + i);
        }
    }

    /* renamed from: a */
    public C3581f mo19747a(int i, int i2) {
        if (i >= 0) {
            byte[] bArr = this.f10036a;
            if (i2 <= bArr.length) {
                int i3 = i2 - i;
                if (i3 < 0) {
                    throw new IllegalArgumentException("endIndex < beginIndex");
                } else if (i == 0 && i2 == bArr.length) {
                    return this;
                } else {
                    byte[] bArr2 = new byte[i3];
                    System.arraycopy(this.f10036a, i, bArr2, 0, i3);
                    return new C3581f(bArr2);
                }
            } else {
                throw new IllegalArgumentException("endIndex > length(" + this.f10036a.length + ")");
            }
        } else {
            throw new IllegalArgumentException("beginIndex < 0");
        }
    }

    /* renamed from: b */
    public final boolean mo19753b(C3581f fVar) {
        return mo19750a(0, fVar, 0, fVar.mo19759f());
    }

    /* renamed from: a */
    public byte mo19745a(int i) {
        return this.f10036a[i];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo19749a(C3577c cVar) {
        byte[] bArr = this.f10036a;
        cVar.write(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public boolean mo19750a(int i, C3581f fVar, int i2, int i3) {
        return fVar.mo19751a(i2, this.f10036a, i, i3);
    }

    /* renamed from: a */
    public boolean mo19751a(int i, byte[] bArr, int i2, int i3) {
        if (i >= 0) {
            byte[] bArr2 = this.f10036a;
            return i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && C6597w.m21675a(bArr2, i, bArr, i2, i3);
        }
    }

    /* renamed from: a */
    public int compareTo(C3581f fVar) {
        int f = mo19759f();
        int f2 = fVar.mo19759f();
        int min = Math.min(f, f2);
        int i = 0;
        while (i < min) {
            byte a = mo19745a(i) & 255;
            byte a2 = fVar.mo19745a(i) & 255;
            if (a == a2) {
                i++;
            } else if (a < a2) {
                return -1;
            } else {
                return 1;
            }
        }
        if (f == f2) {
            return 0;
        }
        if (f < f2) {
            return -1;
        }
        return 1;
    }

    /* renamed from: a */
    static int m12171a(String str, int i) {
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            if (i3 == i) {
                return i2;
            }
            int codePointAt = str.codePointAt(i2);
            if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                return -1;
            }
            i3++;
            i2 += Character.charCount(codePointAt);
        }
        return str.length();
    }
}
