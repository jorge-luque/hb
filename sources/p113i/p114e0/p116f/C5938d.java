package p113i.p114e0.p116f;

import com.qumpara.offerwall.sdk.core.QumparaDateUtil;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import p113i.p114e0.C3500c;

/* renamed from: i.e0.f.d */
/* compiled from: HttpDate */
public final class C5938d {

    /* renamed from: a */
    private static final ThreadLocal<DateFormat> f15179a = new C5939a();

    /* renamed from: b */
    private static final String[] f15180b;

    /* renamed from: c */
    private static final DateFormat[] f15181c;

    /* renamed from: i.e0.f.d$a */
    /* compiled from: HttpDate */
    class C5939a extends ThreadLocal<DateFormat> {
        C5939a() {
        }

        /* access modifiers changed from: protected */
        public DateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(C3500c.f9714n);
            return simpleDateFormat;
        }
    }

    static {
        String[] strArr = {QumparaDateUtil.PATTERN_RFC1123, QumparaDateUtil.PATTERN_RFC1036, QumparaDateUtil.PATTERN_ASCTIME, "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
        f15180b = strArr;
        f15181c = new DateFormat[strArr.length];
    }

    /* renamed from: a */
    public static Date m19025a(String str) {
        if (str.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date parse = f15179a.get().parse(str, parsePosition);
        if (parsePosition.getIndex() == str.length()) {
            return parse;
        }
        synchronized (f15180b) {
            int length = f15180b.length;
            for (int i = 0; i < length; i++) {
                DateFormat dateFormat = f15181c[i];
                if (dateFormat == null) {
                    dateFormat = new SimpleDateFormat(f15180b[i], Locale.US);
                    dateFormat.setTimeZone(C3500c.f9714n);
                    f15181c[i] = dateFormat;
                }
                parsePosition.setIndex(0);
                Date parse2 = dateFormat.parse(str, parsePosition);
                if (parsePosition.getIndex() != 0) {
                    return parse2;
                }
            }
            return null;
        }
    }

    /* renamed from: a */
    public static String m19024a(Date date) {
        return f15179a.get().format(date);
    }
}
