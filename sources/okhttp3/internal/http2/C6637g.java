package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.http2.C6618c;
import p113i.p114e0.C3500c;
import p119j.C3577c;
import p119j.C3580e;
import p119j.C3581f;
import p119j.C3586u;
import p119j.C3587v;

/* renamed from: okhttp3.internal.http2.g */
/* compiled from: Http2Reader */
final class C6637g implements Closeable {

    /* renamed from: e */
    static final Logger f17431e = Logger.getLogger(C6621d.class.getName());

    /* renamed from: a */
    private final C3580e f17432a;

    /* renamed from: b */
    private final C6638a f17433b;

    /* renamed from: c */
    private final boolean f17434c;

    /* renamed from: d */
    final C6618c.C6619a f17435d;

    /* renamed from: okhttp3.internal.http2.g$a */
    /* compiled from: Http2Reader */
    static final class C6638a implements C3586u {

        /* renamed from: a */
        private final C3580e f17436a;

        /* renamed from: b */
        int f17437b;

        /* renamed from: c */
        byte f17438c;

        /* renamed from: d */
        int f17439d;

        /* renamed from: e */
        int f17440e;

        /* renamed from: f */
        short f17441f;

        C6638a(C3580e eVar) {
            this.f17436a = eVar;
        }

        /* renamed from: d */
        private void m21852d() throws IOException {
            int i = this.f17439d;
            int a = C6637g.m21838a(this.f17436a);
            this.f17440e = a;
            this.f17437b = a;
            byte readByte = (byte) (this.f17436a.readByte() & 255);
            this.f17438c = (byte) (this.f17436a.readByte() & 255);
            if (C6637g.f17431e.isLoggable(Level.FINE)) {
                C6637g.f17431e.fine(C6621d.m21773a(true, this.f17439d, this.f17437b, readByte, this.f17438c));
            }
            int readInt = this.f17436a.readInt() & Integer.MAX_VALUE;
            this.f17439d = readInt;
            if (readByte != 9) {
                C6621d.m21774b("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
                throw null;
            } else if (readInt != i) {
                C6621d.m21774b("TYPE_CONTINUATION streamId changed", new Object[0]);
                throw null;
            }
        }

        public void close() throws IOException {
        }

        public long read(C3577c cVar, long j) throws IOException {
            while (true) {
                int i = this.f17440e;
                if (i == 0) {
                    this.f17436a.skip((long) this.f17441f);
                    this.f17441f = 0;
                    if ((this.f17438c & 4) != 0) {
                        return -1;
                    }
                    m21852d();
                } else {
                    long read = this.f17436a.read(cVar, Math.min(j, (long) i));
                    if (read == -1) {
                        return -1;
                    }
                    this.f17440e = (int) (((long) this.f17440e) - read);
                    return read;
                }
            }
        }

        public C3587v timeout() {
            return this.f17436a.timeout();
        }
    }

    /* renamed from: okhttp3.internal.http2.g$b */
    /* compiled from: Http2Reader */
    interface C6639b {
        /* renamed from: a */
        void mo35709a();

        /* renamed from: a */
        void mo35710a(int i, int i2, int i3, boolean z);

        /* renamed from: a */
        void mo35711a(int i, int i2, List<C6616b> list) throws IOException;

        /* renamed from: a */
        void mo35712a(int i, long j);

        /* renamed from: a */
        void mo35713a(int i, C6615a aVar);

        /* renamed from: a */
        void mo35714a(int i, C6615a aVar, C3581f fVar);

        /* renamed from: a */
        void mo35715a(boolean z, int i, int i2);

        /* renamed from: a */
        void mo35716a(boolean z, int i, int i2, List<C6616b> list);

        /* renamed from: a */
        void mo35717a(boolean z, int i, C3580e eVar, int i2) throws IOException;

        /* renamed from: a */
        void mo35718a(boolean z, C6645l lVar);
    }

    C6637g(C3580e eVar, boolean z) {
        this.f17432a = eVar;
        this.f17434c = z;
        C6638a aVar = new C6638a(eVar);
        this.f17433b = aVar;
        this.f17435d = new C6618c.C6619a(CodedOutputStream.DEFAULT_BUFFER_SIZE, aVar);
    }

    /* renamed from: b */
    private void m21842b(C6639b bVar, int i, byte b, int i2) throws IOException {
        if (i < 8) {
            C6621d.m21774b("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
            throw null;
        } else if (i2 == 0) {
            int readInt = this.f17432a.readInt();
            int readInt2 = this.f17432a.readInt();
            int i3 = i - 8;
            C6615a a = C6615a.m21741a(readInt2);
            if (a != null) {
                C3581f fVar = C3581f.f10035e;
                if (i3 > 0) {
                    fVar = this.f17432a.mo19712h((long) i3);
                }
                bVar.mo35714a(readInt, a, fVar);
                return;
            }
            C6621d.m21774b("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
            throw null;
        } else {
            C6621d.m21774b("TYPE_GOAWAY streamId != 0", new Object[0]);
            throw null;
        }
    }

    /* renamed from: c */
    private void m21843c(C6639b bVar, int i, byte b, int i2) throws IOException {
        short s = 0;
        if (i2 != 0) {
            boolean z = (b & 1) != 0;
            if ((b & 8) != 0) {
                s = (short) (this.f17432a.readByte() & 255);
            }
            if ((b & 32) != 0) {
                m21840a(bVar, i2);
                i -= 5;
            }
            bVar.mo35716a(z, i2, -1, m21839a(m21837a(i, b, s), s, b, i2));
            return;
        }
        C6621d.m21774b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        throw null;
    }

    /* renamed from: d */
    private void m21844d(C6639b bVar, int i, byte b, int i2) throws IOException {
        boolean z = false;
        if (i != 8) {
            C6621d.m21774b("TYPE_PING length != 8: %s", Integer.valueOf(i));
            throw null;
        } else if (i2 == 0) {
            int readInt = this.f17432a.readInt();
            int readInt2 = this.f17432a.readInt();
            if ((b & 1) != 0) {
                z = true;
            }
            bVar.mo35715a(z, readInt, readInt2);
        } else {
            C6621d.m21774b("TYPE_PING streamId != 0", new Object[0]);
            throw null;
        }
    }

    /* renamed from: e */
    private void m21845e(C6639b bVar, int i, byte b, int i2) throws IOException {
        if (i != 5) {
            C6621d.m21774b("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
            throw null;
        } else if (i2 != 0) {
            m21840a(bVar, i2);
        } else {
            C6621d.m21774b("TYPE_PRIORITY streamId == 0", new Object[0]);
            throw null;
        }
    }

    /* renamed from: f */
    private void m21846f(C6639b bVar, int i, byte b, int i2) throws IOException {
        short s = 0;
        if (i2 != 0) {
            if ((b & 8) != 0) {
                s = (short) (this.f17432a.readByte() & 255);
            }
            bVar.mo35711a(i2, this.f17432a.readInt() & Integer.MAX_VALUE, m21839a(m21837a(i - 4, b, s), s, b, i2));
            return;
        }
        C6621d.m21774b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        throw null;
    }

    /* renamed from: g */
    private void m21847g(C6639b bVar, int i, byte b, int i2) throws IOException {
        if (i != 4) {
            C6621d.m21774b("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
            throw null;
        } else if (i2 != 0) {
            int readInt = this.f17432a.readInt();
            C6615a a = C6615a.m21741a(readInt);
            if (a != null) {
                bVar.mo35713a(i2, a);
                return;
            }
            C6621d.m21774b("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt));
            throw null;
        } else {
            C6621d.m21774b("TYPE_RST_STREAM streamId == 0", new Object[0]);
            throw null;
        }
    }

    /* renamed from: h */
    private void m21848h(C6639b bVar, int i, byte b, int i2) throws IOException {
        if (i2 != 0) {
            C6621d.m21774b("TYPE_SETTINGS streamId != 0", new Object[0]);
            throw null;
        } else if ((b & 1) != 0) {
            if (i == 0) {
                bVar.mo35709a();
            } else {
                C6621d.m21774b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                throw null;
            }
        } else if (i % 6 == 0) {
            C6645l lVar = new C6645l();
            for (int i3 = 0; i3 < i; i3 += 6) {
                short readShort = this.f17432a.readShort() & 65535;
                int readInt = this.f17432a.readInt();
                if (readShort != 2) {
                    if (readShort == 3) {
                        readShort = 4;
                    } else if (readShort == 4) {
                        readShort = 7;
                        if (readInt < 0) {
                            C6621d.m21774b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                            throw null;
                        }
                    } else if (readShort == 5 && (readInt < 16384 || readInt > 16777215)) {
                        C6621d.m21774b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt));
                        throw null;
                    }
                } else if (!(readInt == 0 || readInt == 1)) {
                    C6621d.m21774b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                    throw null;
                }
                lVar.mo35746a(readShort, readInt);
            }
            bVar.mo35718a(false, lVar);
        } else {
            C6621d.m21774b("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
            throw null;
        }
    }

    /* renamed from: i */
    private void m21849i(C6639b bVar, int i, byte b, int i2) throws IOException {
        if (i == 4) {
            long readInt = ((long) this.f17432a.readInt()) & 2147483647L;
            if (readInt != 0) {
                bVar.mo35712a(i2, readInt);
                return;
            }
            C6621d.m21774b("windowSizeIncrement was 0", Long.valueOf(readInt));
            throw null;
        }
        C6621d.m21774b("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
        throw null;
    }

    /* renamed from: a */
    public void mo35719a(C6639b bVar) throws IOException {
        if (!this.f17434c) {
            C3581f h = this.f17432a.mo19712h((long) C6621d.f17356a.mo19759f());
            if (f17431e.isLoggable(Level.FINE)) {
                f17431e.fine(C3500c.m11639a("<< CONNECTION %s", h.mo19752b()));
            }
            if (!C6621d.f17356a.equals(h)) {
                C6621d.m21774b("Expected a connection header but was %s", h.mo19763i());
                throw null;
            }
        } else if (!mo35720a(true, bVar)) {
            C6621d.m21774b("Required SETTINGS preface not received", new Object[0]);
            throw null;
        }
    }

    public void close() throws IOException {
        this.f17432a.close();
    }

    /* renamed from: a */
    public boolean mo35720a(boolean z, C6639b bVar) throws IOException {
        try {
            this.f17432a.mo19718l(9);
            int a = m21838a(this.f17432a);
            if (a < 0 || a > 16384) {
                C6621d.m21774b("FRAME_SIZE_ERROR: %s", Integer.valueOf(a));
                throw null;
            }
            byte readByte = (byte) (this.f17432a.readByte() & 255);
            if (!z || readByte == 4) {
                byte readByte2 = (byte) (this.f17432a.readByte() & 255);
                int readInt = this.f17432a.readInt() & Integer.MAX_VALUE;
                if (f17431e.isLoggable(Level.FINE)) {
                    f17431e.fine(C6621d.m21773a(true, readInt, a, readByte, readByte2));
                }
                switch (readByte) {
                    case 0:
                        m21841a(bVar, a, readByte2, readInt);
                        break;
                    case 1:
                        m21843c(bVar, a, readByte2, readInt);
                        break;
                    case 2:
                        m21845e(bVar, a, readByte2, readInt);
                        break;
                    case 3:
                        m21847g(bVar, a, readByte2, readInt);
                        break;
                    case 4:
                        m21848h(bVar, a, readByte2, readInt);
                        break;
                    case 5:
                        m21846f(bVar, a, readByte2, readInt);
                        break;
                    case 6:
                        m21844d(bVar, a, readByte2, readInt);
                        break;
                    case 7:
                        m21842b(bVar, a, readByte2, readInt);
                        break;
                    case 8:
                        m21849i(bVar, a, readByte2, readInt);
                        break;
                    default:
                        this.f17432a.skip((long) a);
                        break;
                }
                return true;
            }
            C6621d.m21774b("Expected a SETTINGS frame but was %s", Byte.valueOf(readByte));
            throw null;
        } catch (IOException unused) {
            return false;
        }
    }

    /* renamed from: a */
    private List<C6616b> m21839a(int i, short s, byte b, int i2) throws IOException {
        C6638a aVar = this.f17433b;
        aVar.f17440e = i;
        aVar.f17437b = i;
        aVar.f17441f = s;
        aVar.f17438c = b;
        aVar.f17439d = i2;
        this.f17435d.mo35678c();
        return this.f17435d.mo35676a();
    }

    /* renamed from: a */
    private void m21841a(C6639b bVar, int i, byte b, int i2) throws IOException {
        short s = 0;
        if (i2 != 0) {
            boolean z = true;
            boolean z2 = (b & 1) != 0;
            if ((b & 32) == 0) {
                z = false;
            }
            if (!z) {
                if ((b & 8) != 0) {
                    s = (short) (this.f17432a.readByte() & 255);
                }
                bVar.mo35717a(z2, i2, this.f17432a, m21837a(i, b, s));
                this.f17432a.skip((long) s);
                return;
            }
            C6621d.m21774b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
            throw null;
        }
        C6621d.m21774b("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        throw null;
    }

    /* renamed from: a */
    private void m21840a(C6639b bVar, int i) throws IOException {
        int readInt = this.f17432a.readInt();
        bVar.mo35710a(i, readInt & Integer.MAX_VALUE, (this.f17432a.readByte() & 255) + 1, (Integer.MIN_VALUE & readInt) != 0);
    }

    /* renamed from: a */
    static int m21838a(C3580e eVar) throws IOException {
        return (eVar.readByte() & 255) | ((eVar.readByte() & 255) << 16) | ((eVar.readByte() & 255) << 8);
    }

    /* renamed from: a */
    static int m21837a(int i, byte b, short s) throws IOException {
        if ((b & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        C6621d.m21774b("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
        throw null;
    }
}
