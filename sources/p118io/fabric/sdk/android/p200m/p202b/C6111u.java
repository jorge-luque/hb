package p118io.fabric.sdk.android.p200m.p202b;

import android.support.p004v4.media.session.PlaybackStateCompat;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: io.fabric.sdk.android.m.b.u */
/* compiled from: QueueFile */
public class C6111u implements Closeable {

    /* renamed from: g */
    private static final Logger f16079g = Logger.getLogger(C6111u.class.getName());
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final RandomAccessFile f16080a;

    /* renamed from: b */
    int f16081b;

    /* renamed from: c */
    private int f16082c;

    /* renamed from: d */
    private C6113b f16083d;

    /* renamed from: e */
    private C6113b f16084e;

    /* renamed from: f */
    private final byte[] f16085f = new byte[16];

    /* renamed from: io.fabric.sdk.android.m.b.u$a */
    /* compiled from: QueueFile */
    class C6112a implements C6115d {

        /* renamed from: a */
        boolean f16086a = true;

        /* renamed from: b */
        final /* synthetic */ StringBuilder f16087b;

        C6112a(StringBuilder sb) {
            this.f16087b = sb;
        }

        public void read(InputStream inputStream, int i) throws IOException {
            if (this.f16086a) {
                this.f16086a = false;
            } else {
                this.f16087b.append(", ");
            }
            this.f16087b.append(i);
        }
    }

    /* renamed from: io.fabric.sdk.android.m.b.u$b */
    /* compiled from: QueueFile */
    static class C6113b {

        /* renamed from: c */
        static final C6113b f16089c = new C6113b(0, 0);

        /* renamed from: a */
        final int f16090a;

        /* renamed from: b */
        final int f16091b;

        C6113b(int i, int i2) {
            this.f16090a = i;
            this.f16091b = i2;
        }

        public String toString() {
            return C6113b.class.getSimpleName() + "[position = " + this.f16090a + ", length = " + this.f16091b + "]";
        }
    }

    /* renamed from: io.fabric.sdk.android.m.b.u$c */
    /* compiled from: QueueFile */
    private final class C6114c extends InputStream {

        /* renamed from: a */
        private int f16092a;

        /* renamed from: b */
        private int f16093b;

        /* synthetic */ C6114c(C6111u uVar, C6113b bVar, C6112a aVar) {
            this(bVar);
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            Object unused = C6111u.m19818b(bArr, "buffer");
            if ((i | i2) < 0 || i2 > bArr.length - i) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i3 = this.f16093b;
            if (i3 <= 0) {
                return -1;
            }
            if (i2 > i3) {
                i2 = i3;
            }
            C6111u.this.m19812a(this.f16092a, bArr, i, i2);
            this.f16092a = C6111u.this.m19822i(this.f16092a + i2);
            this.f16093b -= i2;
            return i2;
        }

        private C6114c(C6113b bVar) {
            this.f16092a = C6111u.this.m19822i(bVar.f16090a + 4);
            this.f16093b = bVar.f16091b;
        }

        public int read() throws IOException {
            if (this.f16093b == 0) {
                return -1;
            }
            C6111u.this.f16080a.seek((long) this.f16092a);
            int read = C6111u.this.f16080a.read();
            this.f16092a = C6111u.this.m19822i(this.f16092a + 1);
            this.f16093b--;
            return read;
        }
    }

    /* renamed from: io.fabric.sdk.android.m.b.u$d */
    /* compiled from: QueueFile */
    public interface C6115d {
        void read(InputStream inputStream, int i) throws IOException;
    }

    public C6111u(File file) throws IOException {
        if (!file.exists()) {
            m19814a(file);
        }
        this.f16080a = m19817b(file);
        m19823w();
    }

    /* renamed from: b */
    private static void m19820b(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >> 24);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }

    /* renamed from: c */
    private void m19821c(int i) throws IOException {
        this.f16080a.setLength((long) i);
        this.f16080a.getChannel().force(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public int m19822i(int i) {
        int i2 = this.f16081b;
        return i < i2 ? i : (i + 16) - i2;
    }

    /* renamed from: w */
    private void m19823w() throws IOException {
        this.f16080a.seek(0);
        this.f16080a.readFully(this.f16085f);
        int a = m19807a(this.f16085f, 0);
        this.f16081b = a;
        if (((long) a) <= this.f16080a.length()) {
            this.f16082c = m19807a(this.f16085f, 4);
            int a2 = m19807a(this.f16085f, 8);
            int a3 = m19807a(this.f16085f, 12);
            this.f16083d = m19816b(a2);
            this.f16084e = m19816b(a3);
            return;
        }
        throw new IOException("File is truncated. Expected length: " + this.f16081b + ", Actual length: " + this.f16080a.length());
    }

    /* renamed from: x */
    private int m19824x() {
        return this.f16081b - mo34211v();
    }

    public synchronized void close() throws IOException {
        this.f16080a.close();
    }

    /* renamed from: d */
    public synchronized void mo34207d() throws IOException {
        m19811a((int) CodedOutputStream.DEFAULT_BUFFER_SIZE, 0, 0, 0);
        this.f16082c = 0;
        this.f16083d = C6113b.f16089c;
        this.f16084e = C6113b.f16089c;
        if (this.f16081b > 4096) {
            m19821c(CodedOutputStream.DEFAULT_BUFFER_SIZE);
        }
        this.f16081b = CodedOutputStream.DEFAULT_BUFFER_SIZE;
    }

    /* renamed from: t */
    public synchronized boolean mo34208t() {
        return this.f16082c == 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(C6111u.class.getSimpleName());
        sb.append('[');
        sb.append("fileLength=");
        sb.append(this.f16081b);
        sb.append(", size=");
        sb.append(this.f16082c);
        sb.append(", first=");
        sb.append(this.f16083d);
        sb.append(", last=");
        sb.append(this.f16084e);
        sb.append(", element lengths=[");
        try {
            mo34202a((C6115d) new C6112a(sb));
        } catch (IOException e) {
            f16079g.log(Level.WARNING, "read error", e);
        }
        sb.append("]]");
        return sb.toString();
    }

    /* renamed from: u */
    public synchronized void mo34210u() throws IOException {
        if (mo34208t()) {
            throw new NoSuchElementException();
        } else if (this.f16082c == 1) {
            mo34207d();
        } else {
            int i = m19822i(this.f16083d.f16090a + 4 + this.f16083d.f16091b);
            m19812a(i, this.f16085f, 0, 4);
            int a = m19807a(this.f16085f, 0);
            m19811a(this.f16081b, this.f16082c - 1, i, this.f16084e.f16090a);
            this.f16082c--;
            this.f16083d = new C6113b(i, a);
        }
    }

    /* renamed from: v */
    public int mo34211v() {
        if (this.f16082c == 0) {
            return 16;
        }
        C6113b bVar = this.f16084e;
        int i = bVar.f16090a;
        int i2 = this.f16083d.f16090a;
        if (i >= i2) {
            return (i - i2) + 4 + bVar.f16091b + 16;
        }
        return (((i + 4) + bVar.f16091b) + this.f16081b) - i2;
    }

    /* renamed from: a */
    private static void m19815a(byte[] bArr, int... iArr) {
        int i = 0;
        for (int b : iArr) {
            m19820b(bArr, i, b);
            i += 4;
        }
    }

    /* renamed from: b */
    private C6113b m19816b(int i) throws IOException {
        if (i == 0) {
            return C6113b.f16089c;
        }
        this.f16080a.seek((long) i);
        return new C6113b(i, this.f16080a.readInt());
    }

    /* renamed from: a */
    private static int m19807a(byte[] bArr, int i) {
        return ((bArr[i] & 255) << 24) + ((bArr[i + 1] & 255) << 16) + ((bArr[i + 2] & 255) << 8) + (bArr[i + 3] & 255);
    }

    /* renamed from: a */
    private void m19811a(int i, int i2, int i3, int i4) throws IOException {
        m19815a(this.f16085f, i, i2, i3, i4);
        this.f16080a.seek(0);
        this.f16080a.write(this.f16085f);
    }

    /* renamed from: b */
    private static RandomAccessFile m19817b(File file) throws FileNotFoundException {
        return new RandomAccessFile(file, "rwd");
    }

    /* renamed from: b */
    private void m19819b(int i, byte[] bArr, int i2, int i3) throws IOException {
        int i4 = m19822i(i);
        int i5 = i4 + i3;
        int i6 = this.f16081b;
        if (i5 <= i6) {
            this.f16080a.seek((long) i4);
            this.f16080a.write(bArr, i2, i3);
            return;
        }
        int i7 = i6 - i4;
        this.f16080a.seek((long) i4);
        this.f16080a.write(bArr, i2, i7);
        this.f16080a.seek(16);
        this.f16080a.write(bArr, i2 + i7, i3 - i7);
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    private static void m19814a(File file) throws IOException {
        File file2 = new File(file.getPath() + ".tmp");
        RandomAccessFile b = m19817b(file2);
        try {
            b.setLength(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
            b.seek(0);
            byte[] bArr = new byte[16];
            m19815a(bArr, 4096, 0, 0, 0);
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

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static <T> T m19818b(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19812a(int i, byte[] bArr, int i2, int i3) throws IOException {
        int i4 = m19822i(i);
        int i5 = i4 + i3;
        int i6 = this.f16081b;
        if (i5 <= i6) {
            this.f16080a.seek((long) i4);
            this.f16080a.readFully(bArr, i2, i3);
            return;
        }
        int i7 = i6 - i4;
        this.f16080a.seek((long) i4);
        this.f16080a.readFully(bArr, i2, i7);
        this.f16080a.seek(16);
        this.f16080a.readFully(bArr, i2 + i7, i3 - i7);
    }

    /* renamed from: a */
    public void mo34203a(byte[] bArr) throws IOException {
        mo34204a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public synchronized void mo34204a(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        m19818b(bArr, "buffer");
        if ((i | i2) < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        m19810a(i2);
        boolean t = mo34208t();
        if (t) {
            i3 = 16;
        } else {
            i3 = m19822i(this.f16084e.f16090a + 4 + this.f16084e.f16091b);
        }
        C6113b bVar = new C6113b(i3, i2);
        m19820b(this.f16085f, 0, i2);
        m19819b(bVar.f16090a, this.f16085f, 0, 4);
        m19819b(bVar.f16090a + 4, bArr, i, i2);
        m19811a(this.f16081b, this.f16082c + 1, t ? bVar.f16090a : this.f16083d.f16090a, bVar.f16090a);
        this.f16084e = bVar;
        this.f16082c++;
        if (t) {
            this.f16083d = bVar;
        }
    }

    /* renamed from: a */
    private void m19810a(int i) throws IOException {
        int i2 = i + 4;
        int x = m19824x();
        if (x < i2) {
            int i3 = this.f16081b;
            do {
                x += i3;
                i3 <<= 1;
            } while (x < i2);
            m19821c(i3);
            C6113b bVar = this.f16084e;
            int i4 = m19822i(bVar.f16090a + 4 + bVar.f16091b);
            if (i4 < this.f16083d.f16090a) {
                FileChannel channel = this.f16080a.getChannel();
                channel.position((long) this.f16081b);
                long j = (long) (i4 - 4);
                if (channel.transferTo(16, j, channel) != j) {
                    throw new AssertionError("Copied insufficient number of bytes!");
                }
            }
            int i5 = this.f16084e.f16090a;
            int i6 = this.f16083d.f16090a;
            if (i5 < i6) {
                int i7 = (this.f16081b + i5) - 16;
                m19811a(i3, this.f16082c, i6, i7);
                this.f16084e = new C6113b(i7, this.f16084e.f16091b);
            } else {
                m19811a(i3, this.f16082c, i6, i5);
            }
            this.f16081b = i3;
        }
    }

    /* renamed from: a */
    public synchronized void mo34202a(C6115d dVar) throws IOException {
        int i = this.f16083d.f16090a;
        for (int i2 = 0; i2 < this.f16082c; i2++) {
            C6113b b = m19816b(i);
            dVar.read(new C6114c(this, b, (C6112a) null), b.f16091b);
            i = m19822i(b.f16090a + 4 + b.f16091b);
        }
    }

    /* renamed from: a */
    public boolean mo34205a(int i, int i2) {
        return (mo34211v() + 4) + i <= i2;
    }
}
