package p118io.presage;

import com.facebook.internal.Utility;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: io.presage.fw */
public final class C6471fw {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public static long m21359a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
        int read = inputStream.read(bArr);
        long j = 0;
        while (read >= 0) {
            outputStream.write(bArr, 0, read);
            j += (long) read;
            read = inputStream.read(bArr);
        }
        return j;
    }

    /* renamed from: a */
    public static final byte[] m21360a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(Utility.DEFAULT_STREAM_BUFFER_SIZE, inputStream.available()));
        long unused = m21359a(inputStream, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        C6514hl.m21414a((Object) byteArray, "buffer.toByteArray()");
        return byteArray;
    }
}
