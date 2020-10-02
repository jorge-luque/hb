package p119j;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;

/* renamed from: j.d */
/* compiled from: BufferedSink */
public interface C3579d extends C3585t, WritableByteChannel {
    /* renamed from: C */
    C3577c mo19678C();

    /* renamed from: F */
    C3579d mo19679F() throws IOException;

    /* renamed from: J */
    C3579d mo19682J() throws IOException;

    /* renamed from: a */
    long mo19692a(C3586u uVar) throws IOException;

    /* renamed from: a */
    C3579d mo19694a(C3581f fVar) throws IOException;

    /* renamed from: e */
    C3579d mo19708e(String str) throws IOException;

    void flush() throws IOException;

    /* renamed from: g */
    C3579d mo19710g(int i) throws IOException;

    /* renamed from: j */
    C3579d mo19716j(long j) throws IOException;

    /* renamed from: m */
    C3579d mo19719m(long j) throws IOException;

    C3579d write(byte[] bArr) throws IOException;

    C3579d write(byte[] bArr, int i, int i2) throws IOException;

    C3579d writeByte(int i) throws IOException;

    C3579d writeInt(int i) throws IOException;

    C3579d writeShort(int i) throws IOException;
}
