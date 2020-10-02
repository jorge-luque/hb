package p118io.presage.core;

import android.content.Context;
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* renamed from: io.presage.core.IlIllllI */
public class IlIllllI extends IlIlllll {
    public static final String IIIlIlII = C6380z0.IIIIIIII;

    public IlIllllI(Context context, int i, long j, long j2) {
        super(context, i, j, j2);
    }

    public int IIIIIIII() {
        return 11;
    }

    public IIllIlIl IIIIIIII(long j, int i, String str, String str2, int i2, long j2, long j3) {
        return new IIllIIll(j, i, str, str2, i2, j2, j3);
    }

    public String IIIIIIIl(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        try {
            int length = str.length();
            byte[] bArr = new byte[(length / 2)];
            for (int i = 0; i < length; i += 2) {
                bArr[i / 2] = (byte) (Character.digit(str.charAt(i + 1), 16) + (Character.digit(str.charAt(i), 16) << 4));
            }
            return InetAddress.getByAddress(bArr).getHostAddress();
        } catch (UnknownHostException unused) {
            return str;
        }
    }

    public Object IIIIIIll() {
        return IlIllllI.class;
    }

    public File IIIIllII() {
        return new File(IIIlIlII);
    }
}
