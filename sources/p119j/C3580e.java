package p119j;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* renamed from: j.e */
/* compiled from: BufferedSource */
public interface C3580e extends C3586u, ReadableByteChannel {
    /* renamed from: C */
    C3577c mo19678C();

    /* renamed from: G */
    byte[] mo19680G() throws IOException;

    /* renamed from: H */
    boolean mo19681H() throws IOException;

    /* renamed from: K */
    long mo19683K() throws IOException;

    /* renamed from: M */
    String mo19684M() throws IOException;

    /* renamed from: P */
    int mo19685P() throws IOException;

    /* renamed from: Q */
    short mo19686Q() throws IOException;

    /* renamed from: U */
    long mo19687U() throws IOException;

    /* renamed from: V */
    InputStream mo19688V();

    /* renamed from: a */
    long mo19689a(byte b) throws IOException;

    /* renamed from: a */
    long mo19691a(C3585t tVar) throws IOException;

    /* renamed from: a */
    String mo19700a(Charset charset) throws IOException;

    /* renamed from: a */
    boolean mo19701a(long j, C3581f fVar) throws IOException;

    /* renamed from: h */
    C3581f mo19712h(long j) throws IOException;

    /* renamed from: i */
    String mo19714i(long j) throws IOException;

    /* renamed from: k */
    byte[] mo19717k(long j) throws IOException;

    /* renamed from: l */
    void mo19718l(long j) throws IOException;

    byte readByte() throws IOException;

    void readFully(byte[] bArr) throws IOException;

    int readInt() throws IOException;

    short readShort() throws IOException;

    void skip(long j) throws IOException;
}
