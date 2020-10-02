package com.qumpara.offerwall.sdk.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class QumparaDateUtil {
    private static final Collection<String> DEFAULT_PATTERNS = Arrays.asList(new String[]{PATTERN_ASCTIME, PATTERN_RFC1036, PATTERN_RFC1123});
    private static final Date DEFAULT_TWO_DIGIT_YEAR_START;
    private static final TimeZone GMT = TimeZone.getTimeZone("GMT");
    public static final String PATTERN_ASCTIME = "EEE MMM d HH:mm:ss yyyy";
    public static final String PATTERN_RFC1036 = "EEEE, dd-MMM-yy HH:mm:ss zzz";
    public static final String PATTERN_RFC1123 = "EEE, dd MMM yyyy HH:mm:ss zzz";

    static {
        Calendar instance = Calendar.getInstance();
        instance.set(2000, 0, 1, 0, 0);
        DEFAULT_TWO_DIGIT_YEAR_START = instance.getTime();
    }

    private QumparaDateUtil() {
    }

    public static String formatDate(Date date) {
        return formatDate(date, PATTERN_RFC1123);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:4|5|6|(2:8|9)|10|11|(2:13|14)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x003b */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0041 A[Catch:{ Exception -> 0x004e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long getDateFromHeader(java.net.HttpURLConnection r5, java.lang.String r6) {
        /*
            r0 = -1
            if (r6 == 0) goto L_0x004e
            int r2 = r6.length()
            r3 = 1
            if (r2 >= r3) goto L_0x000c
            goto L_0x004e
        L_0x000c:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r4 = 0
            java.lang.String r4 = r6.substring(r4, r3)
            java.lang.String r4 = r4.toUpperCase()
            r2.append(r4)
            java.lang.String r3 = r6.substring(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = r5.getHeaderField(r6)     // Catch:{ Exception -> 0x003b }
            if (r3 == 0) goto L_0x003b
            java.lang.String r6 = r5.getHeaderField(r6)     // Catch:{ Exception -> 0x003b }
            java.util.Date r6 = parseDate(r6)     // Catch:{ Exception -> 0x003b }
            long r5 = r6.getTime()     // Catch:{ Exception -> 0x003b }
            return r5
        L_0x003b:
            java.lang.String r6 = r5.getHeaderField(r2)     // Catch:{ Exception -> 0x004e }
            if (r6 == 0) goto L_0x004e
            java.lang.String r5 = r5.getHeaderField(r2)     // Catch:{ Exception -> 0x004e }
            java.util.Date r5 = parseDate(r5)     // Catch:{ Exception -> 0x004e }
            long r5 = r5.getTime()     // Catch:{ Exception -> 0x004e }
            return r5
        L_0x004e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qumpara.offerwall.sdk.core.QumparaDateUtil.getDateFromHeader(java.net.HttpURLConnection, java.lang.String):long");
    }

    public static Date parseDate(String str) {
        return parseDate(str, (Collection<String>) null, (Date) null);
    }

    public static String formatDate(Date date, String str) {
        if (date == null) {
            throw new IllegalArgumentException("date is null");
        } else if (str != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
            simpleDateFormat.setTimeZone(GMT);
            return simpleDateFormat.format(date);
        } else {
            throw new IllegalArgumentException("pattern is null");
        }
    }

    public static Date parseDate(String str, Collection<String> collection) {
        return parseDate(str, collection, (Date) null);
    }

    public static Date parseDate(String str, Collection<String> collection, Date date) {
        if (str != null) {
            if (collection == null) {
                collection = DEFAULT_PATTERNS;
            }
            if (date == null) {
                date = DEFAULT_TWO_DIGIT_YEAR_START;
            }
            if (str.length() > 1 && str.startsWith("'") && str.endsWith("'")) {
                str = str.substring(1, str.length() - 1);
            }
            SimpleDateFormat simpleDateFormat = null;
            for (String next : collection) {
                if (simpleDateFormat == null) {
                    simpleDateFormat = new SimpleDateFormat(next, Locale.US);
                    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                    simpleDateFormat.set2DigitYearStart(date);
                } else {
                    simpleDateFormat.applyPattern(next);
                }
                try {
                    return simpleDateFormat.parse(str);
                } catch (ParseException unused) {
                }
            }
            throw new RuntimeException("Unable to parse the date " + str);
        }
        throw new IllegalArgumentException("dateValue is null");
    }
}
