package p118io.presage;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* renamed from: io.presage.TommeCrayeuse */
public final class TommeCrayeuse {

    /* renamed from: a */
    public static final TommeCrayeuse f16704a = new TommeCrayeuse();

    private TommeCrayeuse() {
    }

    /* renamed from: a */
    public static String m20711a(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            C6514hl.m21414a((Object) instance, "MessageDigest.getInstance(\"MD5\")");
            Charset forName = Charset.forName("US-ASCII");
            C6514hl.m21414a((Object) forName, "Charset.forName(\"US-ASCII\")");
            byte[] bytes = str.getBytes(forName);
            C6514hl.m21414a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
            instance.update(bytes, 0, str.length());
            byte[] digest = instance.digest();
            BigInteger bigInteger = new BigInteger(1, digest);
            C6518hp hpVar = C6518hp.f17054a;
            String format = String.format("%0" + (digest.length << 1) + "x", Arrays.copyOf(new Object[]{bigInteger}, 1));
            C6514hl.m21414a((Object) format, "java.lang.String.format(format, *args)");
            return format;
        } catch (NoSuchAlgorithmException e) {
            Laguiole laguiole = Laguiole.f16541a;
            Laguiole.m20426a(e);
            return "";
        }
    }
}
