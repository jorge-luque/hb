package com.squareup.tape;

import android.support.p004v4.media.session.PlaybackStateCompat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: com.squareup.tape.d */
/* compiled from: QueueFile */
public class C4811d {

    /* renamed from: g */
    private static final Logger f12888g = Logger.getLogger(C4811d.class.getName());

    /* renamed from: h */
    private static final byte[] f12889h = new byte[CodedOutputStream.DEFAULT_BUFFER_SIZE];

    /* renamed from: a */
    final RandomAccessFile f12890a;

    /* renamed from: b */
    int f12891b;

    /* renamed from: c */
    private int f12892c;

    /* renamed from: d */
    private C4813b f12893d;

    /* renamed from: e */
    private C4813b f12894e;

    /* renamed from: f */
    private final byte[] f12895f = new byte[16];

    /* renamed from: com.squareup.tape.d$a */
    /* compiled from: QueueFile */
    class C4812a implements C4815d {

        /* renamed from: a */
        boolean f12896a = true;

        /* renamed from: b */
        final /* synthetic */ StringBuilder f12897b;

        C4812a(C4811d dVar, StringBuilder sb) {
            this.f12897b = sb;
        }

        public void read(InputStream inputStream, int i) throws IOException {
            if (this.f12896a) {
                this.f12896a = false;
            } else {
                this.f12897b.append(", ");
            }
            this.f12897b.append(i);
        }
    }

    /* renamed from: com.squareup.tape.d$b */
    /* compiled from: QueueFile */
    static class C4813b {

        /* renamed from: c */
        static final C4813b f12898c = new C4813b(0, 0);

        /* renamed from: a */
        final int f12899a;

        /* renamed from: b */
        final int f12900b;

        C4813b(int i, int i2) {
            this.f12899a = i;
            this.f12900b = i2;
        }

        public String toString() {
            return C4813b.class.getSimpleName() + "[" + "position = " + this.f12899a + ", length = " + this.f12900b + "]";
        }
    }

    /* renamed from: com.squareup.tape.d$c */
    /* compiled from: QueueFile */
    private final class C4814c extends InputStream {

        /* renamed from: a */
        private int f12901a;

        /* renamed from: b */
        private int f12902b;

        /* synthetic */ C4814c(C4811d dVar, C4813b bVar, C4812a aVar) {
            this(bVar);
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            Object unused = C4811d.m16511b(bArr, "buffer");
            if ((i | i2) < 0 || i2 > bArr.length - i) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i3 = this.f12902b;
            if (i3 <= 0) {
                return -1;
            }
            if (i2 > i3) {
                i2 = i3;
            }
            C4811d.this.m16505a(this.f12901a, bArr, i, i2);
            this.f12901a = C4811d.this.m16515d(this.f12901a + i2);
            this.f12902b -= i2;
            return i2;
        }

        private C4814c(C4813b bVar) {
            this.f12901a = C4811d.this.m16515d(bVar.f12899a + 4);
            this.f12902b = bVar.f12900b;
        }

        public int read() throws IOException {
            if (this.f12902b == 0) {
                return -1;
            }
            C4811d.this.f12890a.seek((long) this.f12901a);
            int read = C4811d.this.f12890a.read();
            this.f12901a = C4811d.this.m16515d(this.f12901a + 1);
            this.f12902b--;
            return read;
        }
    }

    /* renamed from: com.squareup.tape.d$d */
    /* compiled from: QueueFile */
    public interface C4815d {
        void read(InputStream inputStream, int i) throws IOException;
    }

    public C4811d(File file) throws IOException {
        if (!file.exists()) {
            m16507a(file);
        }
        this.f12890a = m16510b(file);
        m16516e();
    }

    /* renamed from: b */
    private static void m16513b(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >> 24);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }

    /* renamed from: c */
    private void m16514c(int i) throws IOException {
        this.f12890a.setLength((long) i);
        this.f12890a.getChannel().force(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public int m16515d(int i) {
        int i2 = this.f12891b;
        return i < i2 ? i : (i + 16) - i2;
    }

    /* renamed from: e */
    private void m16516e() throws IOException {
        this.f12890a.seek(0);
        this.f12890a.readFully(this.f12895f);
        int a = m16500a(this.f12895f, 0);
        this.f12891b = a;
        if (((long) a) > this.f12890a.length()) {
            throw new IOException("File is truncated. Expected length: " + this.f12891b + ", Actual length: " + this.f12890a.length());
        } else if (this.f12891b != 0) {
            this.f12892c = m16500a(this.f12895f, 4);
            int a2 = m16500a(this.f12895f, 8);
            int a3 = m16500a(this.f12895f, 12);
            this.f12893d = m16509b(a2);
            this.f12894e = m16509b(a3);
        } else {
            throw new IOException("File is corrupt; length stored in header is 0.");
        }
    }

    /* renamed from: f */
    private int m16517f() {
        return this.f12891b - m16518g();
    }

    /* renamed from: g */
    private int m16518g() {
        if (this.f12892c == 0) {
            return 16;
        }
        C4813b bVar = this.f12894e;
        int i = bVar.f12899a;
        int i2 = this.f12893d.f12899a;
        if (i >= i2) {
            return (i - i2) + 4 + bVar.f12900b + 16;
        }
        return (((i + 4) + bVar.f12900b) + this.f12891b) - i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(C4811d.class.getSimpleName());
        sb.append('[');
        sb.append("fileLength=");
        sb.append(this.f12891b);
        sb.append(", size=");
        sb.append(this.f12892c);
        sb.append(", first=");
        sb.append(this.f12893d);
        sb.append(", last=");
        sb.append(this.f12894e);
        sb.append(", element lengths=[");
        try {
            mo30533a((C4815d) new C4812a(this, sb));
        } catch (IOException e) {
            f12888g.log(Level.WARNING, "read error", e);
        }
        sb.append("]]");
        return sb.toString();
    }

    /* renamed from: d */
    public synchronized void mo30537d() throws IOException {
        if (mo30535b()) {
            throw new NoSuchElementException();
        } else if (this.f12892c == 1) {
            mo30532a();
        } else {
            int i = this.f12893d.f12900b + 4;
            m16503a(this.f12893d.f12899a, i);
            int d = m16515d(this.f12893d.f12899a + i);
            m16505a(d, this.f12895f, 0, 4);
            int a = m16500a(this.f12895f, 0);
            m16504a(this.f12891b, this.f12892c - 1, d, this.f12894e.f12899a);
            this.f12892c--;
            this.f12893d = new C4813b(d, a);
        }
    }

    /* renamed from: c */
    public synchronized byte[] mo30536c() throws IOException {
        if (mo30535b()) {
            return null;
        }
        int i = this.f12893d.f12900b;
        byte[] bArr = new byte[i];
        m16505a(this.f12893d.f12899a + 4, bArr, 0, i);
        return bArr;
    }

    /* renamed from: a */
    private static void m16508a(byte[] bArr, int... iArr) {
        int i = 0;
        for (int b : iArr) {
            m16513b(bArr, i, b);
            i += 4;
        }
    }

    /* renamed from: b */
    private C4813b m16509b(int i) throws IOException {
        if (i == 0) {
            return C4813b.f12898c;
        }
        m16505a(i, this.f12895f, 0, 4);
        return new C4813b(i, m16500a(this.f12895f, 0));
    }

    /* renamed from: a */
    private static int m16500a(byte[] bArr, int i) {
        return ((bArr[i] & 255) << 24) + ((bArr[i + 1] & 255) << 16) + ((bArr[i + 2] & 255) << 8) + (bArr[i + 3] & 255);
    }

    /* renamed from: a */
    private void m16504a(int i, int i2, int i3, int i4) throws IOException {
        m16508a(this.f12895f, i, i2, i3, i4);
        this.f12890a.seek(0);
        this.f12890a.write(this.f12895f);
    }

    /* renamed from: b */
    private static RandomAccessFile m16510b(File file) throws FileNotFoundException {
        return new RandomAccessFile(file, "rwd");
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    private static void m16507a(File file) throws IOException {
        File file2 = new File(file.getPath() + ".tmp");
        RandomAccessFile b = m16510b(file2);
        try {
            b.setLength(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
            b.seek(0);
            byte[] bArr = new byte[16];
            m16508a(bArr, 4096, 0, 0, 0);
            b.write(bArr);
            b.close();
            if (!file2.renameTo(file)) {
                throw new IOException("Rename failed!");
            }
        } catch (Throwable th) {
            b.close();
            throw th;
        }
    }

    /* renamed from: b */
    private void m16512b(int i, byte[] bArr, int i2, int i3) throws IOException {
        int d = m16515d(i);
        int i4 = d + i3;
        int i5 = this.f12891b;
        if (i4 <= i5) {
            this.f12890a.seek((long) d);
            this.f12890a.write(bArr, i2, i3);
            return;
        }
        int i6 = i5 - d;
        this.f12890a.seek((long) d);
        this.f12890a.write(bArr, i2, i6);
        this.f12890a.seek(16);
        this.f12890a.write(bArr, i2 + i6, i3 - i6);
    }

    /* renamed from: b */
    public synchronized boolean mo30535b() {
        return this.f12892c == 0;
    }

    /* renamed from: a */
    private void m16503a(int i, int i2) throws IOException {
        while (i2 > 0) {
            int min = Math.min(i2, f12889h.length);
            m16512b(i, f12889h, 0, min);
            i2 -= min;
            i += min;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static <T> T m16511b(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16505a(int i, byte[] bArr, int i2, int i3) throws IOException {
        int d = m16515d(i);
        int i4 = d + i3;
        int i5 = this.f12891b;
        if (i4 <= i5) {
            this.f12890a.seek((long) d);
            this.f12890a.readFully(bArr, i2, i3);
            return;
        }
        int i6 = i5 - d;
        this.f12890a.seek((long) d);
        this.f12890a.readFully(bArr, i2, i6);
        this.f12890a.seek(16);
        this.f12890a.readFully(bArr, i2 + i6, i3 - i6);
    }

    /* renamed from: a */
    public synchronized void mo30534a(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        m16511b(bArr, "buffer");
        if ((i | i2) < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        m16502a(i2);
        boolean b = mo30535b();
        if (b) {
            i3 = 16;
        } else {
            i3 = m16515d(this.f12894e.f12899a + 4 + this.f12894e.f12900b);
        }
        C4813b bVar = new C4813b(i3, i2);
        m16513b(this.f12895f, 0, i2);
        m16512b(bVar.f12899a, this.f12895f, 0, 4);
        m16512b(bVar.f12899a + 4, bArr, i, i2);
        m16504a(this.f12891b, this.f12892c + 1, b ? bVar.f12899a : this.f12893d.f12899a, bVar.f12899a);
        this.f12894e = bVar;
        this.f12892c++;
        if (b) {
            this.f12893d = bVar;
        }
    }

    /* renamed from: a */
    private void m16502a(int i) throws IOException {
        int i2 = i + 4;
        int f = m16517f();
        if (f < i2) {
            int i3 = this.f12891b;
            do {
                f += i3;
                i3 <<= 1;
            } while (f < i2);
            m16514c(i3);
            C4813b bVar = this.f12894e;
            int d = m16515d(bVar.f12899a + 4 + bVar.f12900b);
            if (d <= this.f12893d.f12899a) {
                FileChannel channel = this.f12890a.getChannel();
                channel.position((long) this.f12891b);
                int i4 = d - 16;
                long j = (long) i4;
                if (channel.transferTo(16, j, channel) == j) {
                    m16503a(16, i4);
                } else {
                    throw new AssertionError("Copied insufficient number of bytes!");
                }
            }
            int i5 = this.f12894e.f12899a;
            int i6 = this.f12893d.f12899a;
            if (i5 < i6) {
                int i7 = (this.f12891b + i5) - 16;
                m16504a(i3, this.f12892c, i6, i7);
                this.f12894e = new C4813b(i7, this.f12894e.f12900b);
            } else {
                m16504a(i3, this.f12892c, i6, i5);
            }
            this.f12891b = i3;
        }
    }

    /* renamed from: a */
    public synchronized void mo30533a(C4815d dVar) throws IOException {
        int i = this.f12893d.f12899a;
        for (int i2 = 0; i2 < this.f12892c; i2++) {
            C4813b b = m16509b(i);
            dVar.read(new C4814c(this, b, (C4812a) null), b.f12900b);
            i = m16515d(b.f12899a + 4 + b.f12900b);
        }
    }

    /* renamed from: a */
    public synchronized void mo30532a() throws IOException {
        this.f12890a.seek(0);
        this.f12890a.write(f12889h);
        m16504a((int) CodedOutputStream.DEFAULT_BUFFER_SIZE, 0, 0, 0);
        this.f12892c = 0;
        this.f12893d = C4813b.f12898c;
        this.f12894e = C4813b.f12898c;
        if (this.f12891b > 4096) {
            m16514c(CodedOutputStream.DEFAULT_BUFFER_SIZE);
        }
        this.f12891b = CodedOutputStream.DEFAULT_BUFFER_SIZE;
    }
}
