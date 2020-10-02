package p118io.presage;

import com.facebook.internal.Utility;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

/* renamed from: io.presage.gd */
public final class C6479gd {
    /* renamed from: a */
    public static final String m21371a(Reader reader) {
        StringWriter stringWriter = new StringWriter();
        long unused = m21370a(reader, stringWriter);
        String stringWriter2 = stringWriter.toString();
        C6514hl.m21414a((Object) stringWriter2, "buffer.toString()");
        return stringWriter2;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static long m21370a(Reader reader, Writer writer) {
        char[] cArr = new char[Utility.DEFAULT_STREAM_BUFFER_SIZE];
        int read = reader.read(cArr);
        long j = 0;
        while (read >= 0) {
            writer.write(cArr, 0, read);
            j += (long) read;
            read = reader.read(cArr);
        }
        return j;
    }
}
