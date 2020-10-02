package p119j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* renamed from: j.n */
/* compiled from: Okio */
public final class C6589n {

    /* renamed from: a */
    static final Logger f17158a = Logger.getLogger(C6589n.class.getName());

    /* renamed from: j.n$d */
    /* compiled from: Okio */
    class C3582d extends C3573a {

        /* renamed from: k */
        final /* synthetic */ Socket f10039k;

        C3582d(Socket socket) {
            this.f10039k = socket;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public IOException mo19667b(@Nullable IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        /* access modifiers changed from: protected */
        /* renamed from: i */
        public void mo19594i() {
            try {
                this.f10039k.close();
            } catch (Exception e) {
                Logger logger = C6589n.f17158a;
                Level level = Level.WARNING;
                logger.log(level, "Failed to close timed out socket " + this.f10039k, e);
            } catch (AssertionError e2) {
                if (C6589n.m21618a(e2)) {
                    Logger logger2 = C6589n.f17158a;
                    Level level2 = Level.WARNING;
                    logger2.log(level2, "Failed to close timed out socket " + this.f10039k, e2);
                    return;
                }
                throw e2;
            }
        }
    }

    /* renamed from: j.n$a */
    /* compiled from: Okio */
    class C6590a implements C3585t {

        /* renamed from: a */
        final /* synthetic */ C3587v f17159a;

        /* renamed from: b */
        final /* synthetic */ OutputStream f17160b;

        C6590a(C3587v vVar, OutputStream outputStream) {
            this.f17159a = vVar;
            this.f17160b = outputStream;
        }

        /* renamed from: a */
        public void mo19670a(C3577c cVar, long j) throws IOException {
            C6597w.m21673a(cVar.f10032b, 0, j);
            while (j > 0) {
                this.f17159a.mo19777e();
                C3583q qVar = cVar.f10031a;
                int min = (int) Math.min(j, (long) (qVar.f10042c - qVar.f10041b));
                this.f17160b.write(qVar.f10040a, qVar.f10041b, min);
                int i = qVar.f10041b + min;
                qVar.f10041b = i;
                long j2 = (long) min;
                j -= j2;
                cVar.f10032b -= j2;
                if (i == qVar.f10042c) {
                    cVar.f10031a = qVar.mo19769b();
                    C3584r.m12203a(qVar);
                }
            }
        }

        public void close() throws IOException {
            this.f17160b.close();
        }

        public void flush() throws IOException {
            this.f17160b.flush();
        }

        public C3587v timeout() {
            return this.f17159a;
        }

        public String toString() {
            return "sink(" + this.f17160b + ")";
        }
    }

    /* renamed from: j.n$b */
    /* compiled from: Okio */
    class C6591b implements C3586u {

        /* renamed from: a */
        final /* synthetic */ C3587v f17161a;

        /* renamed from: b */
        final /* synthetic */ InputStream f17162b;

        C6591b(C3587v vVar, InputStream inputStream) {
            this.f17161a = vVar;
            this.f17162b = inputStream;
        }

        public void close() throws IOException {
            this.f17162b.close();
        }

        public long read(C3577c cVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (j == 0) {
                return 0;
            } else {
                try {
                    this.f17161a.mo19777e();
                    C3583q b = cVar.mo19703b(1);
                    int read = this.f17162b.read(b.f10040a, b.f10042c, (int) Math.min(j, (long) (8192 - b.f10042c)));
                    if (read == -1) {
                        return -1;
                    }
                    b.f10042c += read;
                    long j2 = (long) read;
                    cVar.f10032b += j2;
                    return j2;
                } catch (AssertionError e) {
                    if (C6589n.m21618a(e)) {
                        throw new IOException(e);
                    }
                    throw e;
                }
            }
        }

        public C3587v timeout() {
            return this.f17161a;
        }

        public String toString() {
            return "source(" + this.f17162b + ")";
        }
    }

    /* renamed from: j.n$c */
    /* compiled from: Okio */
    class C6592c implements C3585t {
        C6592c() {
        }

        /* renamed from: a */
        public void mo19670a(C3577c cVar, long j) throws IOException {
            cVar.skip(j);
        }

        public void close() throws IOException {
        }

        public void flush() throws IOException {
        }

        public C3587v timeout() {
            return C3587v.f10049d;
        }
    }

    private C6589n() {
    }

    /* renamed from: a */
    public static C3580e m21610a(C3586u uVar) {
        return new C6594p(uVar);
    }

    /* renamed from: b */
    public static C3585t m21619b(File file) throws FileNotFoundException {
        if (file != null) {
            return m21613a((OutputStream) new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    /* renamed from: c */
    public static C3586u m21622c(File file) throws FileNotFoundException {
        if (file != null) {
            return m21616a((InputStream) new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    /* renamed from: a */
    public static C3579d m21609a(C3585t tVar) {
        return new C6593o(tVar);
    }

    /* renamed from: a */
    public static C3585t m21613a(OutputStream outputStream) {
        return m21614a(outputStream, new C3587v());
    }

    /* renamed from: b */
    public static C3586u m21620b(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getInputStream() != null) {
            C3573a c = m21621c(socket);
            return c.mo19664a(m21617a(socket.getInputStream(), (C3587v) c));
        } else {
            throw new IOException("socket's input stream == null");
        }
    }

    /* renamed from: c */
    private static C3573a m21621c(Socket socket) {
        return new C3582d(socket);
    }

    /* renamed from: a */
    private static C3585t m21614a(OutputStream outputStream, C3587v vVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        } else if (vVar != null) {
            return new C6590a(vVar, outputStream);
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    /* renamed from: a */
    public static C3585t m21615a(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getOutputStream() != null) {
            C3573a c = m21621c(socket);
            return c.mo19663a(m21614a(socket.getOutputStream(), (C3587v) c));
        } else {
            throw new IOException("socket's output stream == null");
        }
    }

    /* renamed from: a */
    public static C3586u m21616a(InputStream inputStream) {
        return m21617a(inputStream, new C3587v());
    }

    /* renamed from: a */
    private static C3586u m21617a(InputStream inputStream, C3587v vVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (vVar != null) {
            return new C6591b(vVar, inputStream);
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    /* renamed from: a */
    public static C3585t m21612a(File file) throws FileNotFoundException {
        if (file != null) {
            return m21613a((OutputStream) new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }

    /* renamed from: a */
    public static C3585t m21611a() {
        return new C6592c();
    }

    /* renamed from: a */
    static boolean m21618a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
