package com.google.protobuf;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: com.google.protobuf.f */
/* compiled from: ByteString */
public abstract class C3995f implements Iterable<Byte>, Serializable {

    /* renamed from: b */
    public static final C3995f f10759b = new C4003h(C4038p.f10853b);

    /* renamed from: c */
    private static final C3999d f10760c;

    /* renamed from: a */
    private int f10761a = 0;

    /* renamed from: com.google.protobuf.f$a */
    /* compiled from: ByteString */
    class C3996a implements C4000e {

        /* renamed from: a */
        private int f10762a = 0;

        /* renamed from: b */
        private final int f10763b = C3995f.this.size();

        C3996a() {
        }

        public boolean hasNext() {
            return this.f10762a < this.f10763b;
        }

        public byte nextByte() {
            try {
                C3995f fVar = C3995f.this;
                int i = this.f10762a;
                this.f10762a = i + 1;
                return fVar.mo28114d(i);
            } catch (IndexOutOfBoundsException e) {
                throw new NoSuchElementException(e.getMessage());
            }
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Byte next() {
            return Byte.valueOf(nextByte());
        }
    }

    /* renamed from: com.google.protobuf.f$b */
    /* compiled from: ByteString */
    private static final class C3997b implements C3999d {
        private C3997b() {
        }

        /* renamed from: a */
        public byte[] mo28126a(byte[] bArr, int i, int i2) {
            return Arrays.copyOfRange(bArr, i, i2 + i);
        }

        /* synthetic */ C3997b(C3996a aVar) {
            this();
        }
    }

    /* renamed from: com.google.protobuf.f$c */
    /* compiled from: ByteString */
    private static final class C3998c extends C4003h {
        private static final long serialVersionUID = 1;

        /* renamed from: e */
        private final int f10765e;

        /* renamed from: f */
        private final int f10766f;

        C3998c(byte[] bArr, int i, int i2) {
            super(bArr);
            C3995f.m13323b(i, i + i2, bArr.length);
            this.f10765e = i;
            this.f10766f = i2;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException {
            throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo28109a(byte[] bArr, int i, int i2, int i3) {
            System.arraycopy(this.f10769d, mo28127f() + i, bArr, i2, i3);
        }

        /* renamed from: d */
        public byte mo28114d(int i) {
            C3995f.m13325b(i, size());
            return this.f10769d[this.f10765e + i];
        }

        /* access modifiers changed from: protected */
        /* renamed from: f */
        public int mo28127f() {
            return this.f10765e;
        }

        public int size() {
            return this.f10766f;
        }

        /* access modifiers changed from: package-private */
        public Object writeReplace() {
            return C3995f.m13321a(mo28115d());
        }
    }

    /* renamed from: com.google.protobuf.f$d */
    /* compiled from: ByteString */
    private interface C3999d {
        /* renamed from: a */
        byte[] mo28126a(byte[] bArr, int i, int i2);
    }

    /* renamed from: com.google.protobuf.f$e */
    /* compiled from: ByteString */
    public interface C4000e extends Iterator<Byte> {
    }

    /* renamed from: com.google.protobuf.f$f */
    /* compiled from: ByteString */
    static final class C4001f {

        /* renamed from: a */
        private final CodedOutputStream f10767a;

        /* renamed from: b */
        private final byte[] f10768b;

        /* synthetic */ C4001f(int i, C3996a aVar) {
            this(i);
        }

        /* renamed from: a */
        public C3995f mo28129a() {
            this.f10767a.mo27963a();
            return new C4003h(this.f10768b);
        }

        /* renamed from: b */
        public CodedOutputStream mo28130b() {
            return this.f10767a;
        }

        private C4001f(int i) {
            byte[] bArr = new byte[i];
            this.f10768b = bArr;
            this.f10767a = CodedOutputStream.m13121a(bArr);
        }
    }

    /* renamed from: com.google.protobuf.f$g */
    /* compiled from: ByteString */
    static abstract class C4002g extends C3995f {
        C4002g() {
        }

        public /* bridge */ /* synthetic */ Iterator iterator() {
            return C3995f.super.iterator();
        }
    }

    /* renamed from: com.google.protobuf.f$h */
    /* compiled from: ByteString */
    private static class C4003h extends C4002g {
        private static final long serialVersionUID = 1;

        /* renamed from: d */
        protected final byte[] f10769d;

        C4003h(byte[] bArr) {
            this.f10769d = bArr;
        }

        /* renamed from: a */
        public final C3995f mo28106a(int i, int i2) {
            int b = C3995f.m13323b(i, i2, size());
            if (b == 0) {
                return C3995f.f10759b;
            }
            return new C3998c(this.f10769d, mo28127f() + i, b);
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public final String mo28112b(Charset charset) {
            return new String(this.f10769d, mo28127f(), size(), charset);
        }

        /* renamed from: d */
        public byte mo28114d(int i) {
            return this.f10769d[i];
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C3995f) || size() != ((C3995f) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof C4003h)) {
                return obj.equals(this);
            }
            C4003h hVar = (C4003h) obj;
            int c = mo28113c();
            int c2 = hVar.mo28113c();
            if (c == 0 || c2 == 0 || c == c2) {
                return mo28131a((C3995f) hVar, 0, size());
            }
            return false;
        }

        /* access modifiers changed from: protected */
        /* renamed from: f */
        public int mo28127f() {
            return 0;
        }

        public int size() {
            return this.f10769d.length;
        }

        /* renamed from: b */
        public final C4013g mo28111b() {
            return C4013g.m13367a(this.f10769d, mo28127f(), size(), true);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo28109a(byte[] bArr, int i, int i2, int i3) {
            System.arraycopy(this.f10769d, i, bArr, i2, i3);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public final void mo28108a(C3989e eVar) throws IOException {
            eVar.mo27988a(this.f10769d, mo28127f(), size());
        }

        /* renamed from: a */
        public final boolean mo28110a() {
            int f = mo28127f();
            return C3990e0.m13306c(this.f10769d, f, size() + f);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public final boolean mo28131a(C3995f fVar, int i, int i2) {
            if (i2 <= fVar.size()) {
                int i3 = i + i2;
                if (i3 > fVar.size()) {
                    throw new IllegalArgumentException("Ran off end of other: " + i + ", " + i2 + ", " + fVar.size());
                } else if (!(fVar instanceof C4003h)) {
                    return fVar.mo28106a(i, i3).equals(mo28106a(0, i2));
                } else {
                    C4003h hVar = (C4003h) fVar;
                    byte[] bArr = this.f10769d;
                    byte[] bArr2 = hVar.f10769d;
                    int f = mo28127f() + i2;
                    int f2 = mo28127f();
                    int f3 = hVar.mo28127f() + i;
                    while (f2 < f) {
                        if (bArr[f2] != bArr2[f3]) {
                            return false;
                        }
                        f2++;
                        f3++;
                    }
                    return true;
                }
            } else {
                throw new IllegalArgumentException("Length too large: " + i2 + size());
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final int mo28105a(int i, int i2, int i3) {
            return C4038p.m13498a(i, this.f10769d, mo28127f() + i2, i3);
        }
    }

    /* renamed from: com.google.protobuf.f$i */
    /* compiled from: ByteString */
    private static final class C4004i implements C3999d {
        private C4004i() {
        }

        /* renamed from: a */
        public byte[] mo28126a(byte[] bArr, int i, int i2) {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            return bArr2;
        }

        /* synthetic */ C4004i(C3996a aVar) {
            this();
        }
    }

    static {
        Class<C3995f> cls = C3995f.class;
        boolean z = true;
        try {
            Class.forName("android.content.Context");
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        f10760c = z ? new C4004i((C3996a) null) : new C3997b((C3996a) null);
    }

    C3995f() {
    }

    /* renamed from: a */
    public static C3995f m13322a(byte[] bArr, int i, int i2) {
        return new C4003h(f10760c.mo28126a(bArr, i, i2));
    }

    /* renamed from: b */
    static C3995f m13324b(byte[] bArr, int i, int i2) {
        return new C3998c(bArr, i, i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract int mo28105a(int i, int i2, int i3);

    /* renamed from: a */
    public abstract C3995f mo28106a(int i, int i2);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo28108a(C3989e eVar) throws IOException;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo28109a(byte[] bArr, int i, int i2, int i3);

    /* renamed from: a */
    public abstract boolean mo28110a();

    /* renamed from: b */
    public abstract C4013g mo28111b();

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract String mo28112b(Charset charset);

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final int mo28113c() {
        return this.f10761a;
    }

    /* renamed from: d */
    public abstract byte mo28114d(int i);

    /* renamed from: d */
    public final byte[] mo28115d() {
        int size = size();
        if (size == 0) {
            return C4038p.f10853b;
        }
        byte[] bArr = new byte[size];
        mo28109a(bArr, 0, 0, size);
        return bArr;
    }

    /* renamed from: e */
    public final String mo28116e() {
        return mo28107a(C4038p.f10852a);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.f10761a;
        if (i == 0) {
            int size = size();
            i = mo28105a(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.f10761a = i;
        }
        return i;
    }

    public abstract int size();

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
    }

    /* renamed from: a */
    static C3995f m13321a(byte[] bArr) {
        return new C4003h(bArr);
    }

    /* renamed from: b */
    static void m13325b(int i, int i2) {
        if (((i2 - (i + 1)) | i) >= 0) {
            return;
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + i2);
    }

    /* renamed from: e */
    static C4001f m13326e(int i) {
        return new C4001f(i, (C3996a) null);
    }

    public final C4000e iterator() {
        return new C3996a();
    }

    /* renamed from: a */
    public static C3995f m13320a(String str) {
        return new C4003h(str.getBytes(C4038p.f10852a));
    }

    /* renamed from: b */
    static int m13323b(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i + " < 0");
        } else if (i2 < i) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i + ", " + i2);
        } else {
            throw new IndexOutOfBoundsException("End index: " + i2 + " >= " + i3);
        }
    }

    /* renamed from: a */
    public final String mo28107a(Charset charset) {
        return size() == 0 ? "" : mo28112b(charset);
    }
}
