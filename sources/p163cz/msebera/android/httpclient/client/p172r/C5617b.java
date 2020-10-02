package p163cz.msebera.android.httpclient.client.p172r;

import com.qumpara.offerwall.sdk.core.QumparaDateUtil;
import java.lang.ref.SoftReference;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.client.r.b */
/* compiled from: DateUtils */
public final class C5617b {

    /* renamed from: a */
    private static final String[] f14599a = {QumparaDateUtil.PATTERN_RFC1123, "EEE, dd-MMM-yy HH:mm:ss zzz", QumparaDateUtil.PATTERN_ASCTIME};

    /* renamed from: b */
    private static final Date f14600b;

    /* renamed from: c */
    public static final TimeZone f14601c = TimeZone.getTimeZone("GMT");

    /* renamed from: cz.msebera.android.httpclient.client.r.b$a */
    /* compiled from: DateUtils */
    static final class C5618a {

        /* renamed from: a */
        private static final ThreadLocal<SoftReference<Map<String, SimpleDateFormat>>> f14602a = new C5619a();

        /* renamed from: cz.msebera.android.httpclient.client.r.b$a$a */
        /* compiled from: DateUtils */
        static class C5619a extends ThreadLocal<SoftReference<Map<String, SimpleDateFormat>>> {
            C5619a() {
            }

            /* access modifiers changed from: protected */
            public SoftReference<Map<String, SimpleDateFormat>> initialValue() {
                return new SoftReference<>(new HashMap());
            }
        }

        /* renamed from: a */
        public static SimpleDateFormat m17869a(String str) {
            Map map = (Map) f14602a.get().get();
            if (map == null) {
                map = new HashMap();
                f14602a.set(new SoftReference(map));
            }
            SimpleDateFormat simpleDateFormat = (SimpleDateFormat) map.get(str);
            if (simpleDateFormat != null) {
                return simpleDateFormat;
            }
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(str, Locale.US);
            simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("GMT"));
            map.put(str, simpleDateFormat2);
            return simpleDateFormat2;
        }
    }

    static {
        Calendar instance = Calendar.getInstance();
        instance.setTimeZone(f14601c);
        instance.set(2000, 0, 1, 0, 0, 0);
        instance.set(14, 0);
        f14600b = instance.getTime();
    }

    /* renamed from: a */
    public static Date m17867a(String str, String[] strArr) {
        return m17868a(str, strArr, (Date) null);
    }

    /* renamed from: a */
    public static Date m17868a(String str, String[] strArr, Date date) {
        C5886a.m18894a(str, "Date value");
        if (strArr == null) {
            strArr = f14599a;
        }
        if (date == null) {
            date = f14600b;
        }
        if (str.length() > 1 && str.startsWith("'") && str.endsWith("'")) {
            str = str.substring(1, str.length() - 1);
        }
        for (String a : strArr) {
            SimpleDateFormat a2 = C5618a.m17869a(a);
            a2.set2DigitYearStart(date);
            ParsePosition parsePosition = new ParsePosition(0);
            Date parse = a2.parse(str, parsePosition);
            if (parsePosition.getIndex() != 0) {
                return parse;
            }
        }
        return null;
    }
}
