package p118io.presage.core;

import android.content.Context;
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* renamed from: io.presage.core.IlIlllIl */
public class IlIlllIl extends IlIlllll {
    public static final String IIIlIlII = C6372x0.IIIIIIII;

    public IlIlllIl(Context context, int i, long j, long j2) {
        super(context, i, j, j2);
    }

    public int IIIIIIII() {
        return 10;
    }

    public IIllIlIl IIIIIIII(long j, int i, String str, String str2, int i2, long j2, long j3) {
        return new IIllIIlI(j, i, str, str2, i2, j2, j3);
    }

    public String IIIIIIIl(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                long parseLong = Long.parseLong(str, 16);
                try {
                    return InetAddress.getByAddress(new byte[]{(byte) ((int) (parseLong & 255)), (byte) ((int) ((parseLong >> 8) & 255)), (byte) ((int) ((parseLong >> 16) & 255)), (byte) ((int) ((parseLong >> 24) & 255))}).getHostAddress();
                } catch (UnknownHostException unused) {
                    return str;
                }
            } catch (Exception unused2) {
            }
        }
        return null;
    }

    public Object IIIIIIll() {
        return IlIlllIl.class;
    }

    public File IIIIllII() {
        return new File(IIIlIlII);
    }
}
