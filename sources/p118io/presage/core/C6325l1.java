package p118io.presage.core;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/* renamed from: io.presage.core.l1 */
public class C6325l1 {
    public static final String IIIIIIII = C6285b1.IIIIIIII;
    public static final String IIIIIIIl = C6285b1.IIIIIIIl;
    public static final String IIIIIIlI = C6285b1.IIIIIIlI;
    public static final String IIIIIIll = C6347r.IIIIIIII;

    public static final long IIIIIIII() {
        return System.currentTimeMillis();
    }

    public static String IIIIIIII(long j) {
        return new SimpleDateFormat(IIIIIIlI, Locale.US).format(Long.valueOf(j));
    }

    public static String IIIIIIIl() {
        String format = new SimpleDateFormat(IIIIIIIl, Locale.US).format(Calendar.getInstance(TimeZone.getTimeZone(IIIIIIII), Locale.getDefault()).getTime());
        return format.substring(0, 3) + IIIIIIll + format.substring(3, 5);
    }
}
