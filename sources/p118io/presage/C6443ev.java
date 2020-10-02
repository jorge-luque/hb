package p118io.presage;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/* renamed from: io.presage.ev */
class C6443ev extends C6442eu {
    /* renamed from: a */
    public static final <T> boolean m21309a(T[] tArr, T t) {
        return m21310b(tArr, t) >= 0;
    }

    /* renamed from: b */
    public static final <T> int m21310b(T[] tArr, T t) {
        int i = 0;
        if (t == null) {
            int length = tArr.length;
            while (i < length) {
                if (tArr[i] == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i < length2) {
            if (C6514hl.m21416a((Object) t, (Object) tArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* renamed from: c */
    public static final <T> List<T> m21312c(T[] tArr) {
        int length = tArr.length;
        if (length == 0) {
            return C6447ez.m21319a();
        }
        if (length != 1) {
            return m21313d(tArr);
        }
        return C6446ey.m21315a(tArr[0]);
    }

    /* renamed from: d */
    public static final <T> List<T> m21313d(T[] tArr) {
        return new ArrayList(C6447ez.m21318a(tArr));
    }

    /* renamed from: a */
    public static final char m21308a(char[] cArr) {
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        } else if (length == 1) {
            return cArr[0];
        } else {
            throw new IllegalArgumentException("Array has more than one element.");
        }
    }

    /* renamed from: b */
    public static final <T> T m21311b(T[] tArr) {
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }
}
