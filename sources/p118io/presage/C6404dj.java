package p118io.presage;

import com.loopj.android.http.C4250c;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* renamed from: io.presage.dj */
public final class C6404dj {

    /* renamed from: a */
    public static final C6404dj f16988a = new C6404dj();

    private C6404dj() {
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    public static byte[] m21260a(String str) throws Exception {
        if (str.length() == 0) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            Charset forName = Charset.forName(C4250c.DEFAULT_CHARSET);
            C6514hl.m21414a((Object) forName, "Charset.forName(charsetName)");
            byte[] bytes = str.getBytes(forName);
            C6514hl.m21414a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
            gZIPOutputStream.write(bytes);
            C6401dg.m21255a(gZIPOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            C6514hl.m21414a((Object) byteArray, "obj.toByteArray()");
            return byteArray;
        } catch (Throwable th) {
            C6401dg.m21255a(gZIPOutputStream);
            throw th;
        }
    }

    /* renamed from: a */
    public static String m21259a(byte[] bArr) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new GZIPInputStream(new ByteArrayInputStream(bArr)), C4250c.DEFAULT_CHARSET));
        try {
            return C6479gd.m21371a(bufferedReader);
        } finally {
            C6401dg.m21255a(bufferedReader);
        }
    }
}
