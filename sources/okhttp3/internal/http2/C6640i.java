package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.http2.C6618c;
import p113i.p114e0.C3500c;
import p119j.C3577c;
import p119j.C3579d;

/* renamed from: okhttp3.internal.http2.i */
/* compiled from: Http2Writer */
final class C6640i implements Closeable {

    /* renamed from: g */
    private static final Logger f17442g = Logger.getLogger(C6621d.class.getName());

    /* renamed from: a */
    private final C3579d f17443a;

    /* renamed from: b */
    private final boolean f17444b;

    /* renamed from: c */
    private final C3577c f17445c;

    /* renamed from: d */
    private int f17446d = 16384;

    /* renamed from: e */
    private boolean f17447e;

    /* renamed from: f */
    final C6618c.C6620b f17448f;

    C6640i(C3579d dVar, boolean z) {
        this.f17443a = dVar;
        this.f17444b = z;
        C3577c cVar = new C3577c();
        this.f17445c = cVar;
        this.f17448f = new C6618c.C6620b(cVar);
    }

    /* renamed from: a */
    public synchronized void mo35728a(C6645l lVar) throws IOException {
        if (!this.f17447e) {
            this.f17446d = lVar.mo35752c(this.f17446d);
            if (lVar.mo35749b() != -1) {
                this.f17448f.mo35679a(lVar.mo35749b());
            }
            mo35723a(0, 0, (byte) 4, (byte) 1);
            this.f17443a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: b */
    public synchronized void mo35733b(C6645l lVar) throws IOException {
        if (!this.f17447e) {
            int i = 0;
            mo35723a(0, lVar.mo35753d() * 6, (byte) 4, (byte) 0);
            while (i < 10) {
                if (lVar.mo35754d(i)) {
                    this.f17443a.writeShort(i == 4 ? 3 : i == 7 ? 4 : i);
                    this.f17443a.writeInt(lVar.mo35745a(i));
                }
                i++;
            }
            this.f17443a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void close() throws IOException {
        this.f17447e = true;
        this.f17443a.close();
    }

    /* renamed from: d */
    public synchronized void mo35735d() throws IOException {
        if (this.f17447e) {
            throw new IOException("closed");
        } else if (this.f17444b) {
            if (f17442g.isLoggable(Level.FINE)) {
                f17442g.fine(C3500c.m11639a(">> CONNECTION %s", C6621d.f17356a.mo19752b()));
            }
            this.f17443a.write(C6621d.f17356a.mo19761h());
            this.f17443a.flush();
        }
    }

    public synchronized void flush() throws IOException {
        if (!this.f17447e) {
            this.f17443a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: t */
    public int mo35737t() {
        return this.f17446d;
    }

    /* renamed from: a */
    public synchronized void mo35724a(int i, int i2, List<C6616b> list) throws IOException {
        if (!this.f17447e) {
            this.f17448f.mo35682a(list);
            long size = this.f17445c.size();
            int min = (int) Math.min((long) (this.f17446d - 4), size);
            long j = (long) min;
            mo35723a(i, min + 4, (byte) 5, size == j ? (byte) 4 : 0);
            this.f17443a.writeInt(i2 & Integer.MAX_VALUE);
            this.f17443a.mo19670a(this.f17445c, j);
            if (size > j) {
                m21864b(i, size - j);
            }
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: b */
    private void m21864b(int i, long j) throws IOException {
        while (j > 0) {
            int min = (int) Math.min((long) this.f17446d, j);
            long j2 = (long) min;
            j -= j2;
            mo35723a(i, min, (byte) 9, j == 0 ? (byte) 4 : 0);
            this.f17443a.mo19670a(this.f17445c, j2);
        }
    }

    /* renamed from: a */
    public synchronized void mo35730a(boolean z, int i, int i2, List<C6616b> list) throws IOException {
        if (!this.f17447e) {
            mo35732a(z, i, list);
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void mo35726a(int i, C6615a aVar) throws IOException {
        if (this.f17447e) {
            throw new IOException("closed");
        } else if (aVar.f17327a != -1) {
            mo35723a(i, 4, (byte) 3, (byte) 0);
            this.f17443a.writeInt(aVar.f17327a);
            this.f17443a.flush();
        } else {
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: a */
    public synchronized void mo35731a(boolean z, int i, C3577c cVar, int i2) throws IOException {
        if (!this.f17447e) {
            byte b = 0;
            if (z) {
                b = (byte) 1;
            }
            mo35722a(i, b, cVar, i2);
        } else {
            throw new IOException("closed");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo35722a(int i, byte b, C3577c cVar, int i2) throws IOException {
        mo35723a(i, i2, (byte) 0, b);
        if (i2 > 0) {
            this.f17443a.mo19670a(cVar, (long) i2);
        }
    }

    /* renamed from: a */
    public synchronized void mo35729a(boolean z, int i, int i2) throws IOException {
        if (!this.f17447e) {
            mo35723a(0, 8, (byte) 6, z ? (byte) 1 : 0);
            this.f17443a.writeInt(i);
            this.f17443a.writeInt(i2);
            this.f17443a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void mo35727a(int i, C6615a aVar, byte[] bArr) throws IOException {
        if (this.f17447e) {
            throw new IOException("closed");
        } else if (aVar.f17327a != -1) {
            mo35723a(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.f17443a.writeInt(i);
            this.f17443a.writeInt(aVar.f17327a);
            if (bArr.length > 0) {
                this.f17443a.write(bArr);
            }
            this.f17443a.flush();
        } else {
            C6621d.m21771a("errorCode.httpCode == -1", new Object[0]);
            throw null;
        }
    }

    /* renamed from: a */
    public synchronized void mo35725a(int i, long j) throws IOException {
        if (this.f17447e) {
            throw new IOException("closed");
        } else if (j == 0 || j > 2147483647L) {
            C6621d.m21771a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
            throw null;
        } else {
            mo35723a(i, 4, (byte) 8, (byte) 0);
            this.f17443a.writeInt((int) j);
            this.f17443a.flush();
        }
    }

    /* renamed from: a */
    public void mo35723a(int i, int i2, byte b, byte b2) throws IOException {
        if (f17442g.isLoggable(Level.FINE)) {
            f17442g.fine(C6621d.m21773a(false, i, i2, b, b2));
        }
        int i3 = this.f17446d;
        if (i2 > i3) {
            C6621d.m21771a("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i3), Integer.valueOf(i2));
            throw null;
        } else if ((Integer.MIN_VALUE & i) == 0) {
            m21863a(this.f17443a, i2);
            this.f17443a.writeByte(b & 255);
            this.f17443a.writeByte(b2 & 255);
            this.f17443a.writeInt(i & Integer.MAX_VALUE);
        } else {
            C6621d.m21771a("reserved bit set: %s", Integer.valueOf(i));
            throw null;
        }
    }

    /* renamed from: a */
    private static void m21863a(C3579d dVar, int i) throws IOException {
        dVar.writeByte((i >>> 16) & 255);
        dVar.writeByte((i >>> 8) & 255);
        dVar.writeByte(i & 255);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo35732a(boolean z, int i, List<C6616b> list) throws IOException {
        if (!this.f17447e) {
            this.f17448f.mo35682a(list);
            long size = this.f17445c.size();
            int min = (int) Math.min((long) this.f17446d, size);
            long j = (long) min;
            byte b = size == j ? (byte) 4 : 0;
            if (z) {
                b = (byte) (b | 1);
            }
            mo35723a(i, min, (byte) 1, b);
            this.f17443a.mo19670a(this.f17445c, j);
            if (size > j) {
                m21864b(i, size - j);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }
}
