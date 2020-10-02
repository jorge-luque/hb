package com.ogury.p159cm;

import android.content.Context;
import com.ogury.p159cm.babac;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.ogury.cm.baacc */
public class baacc {
    /* renamed from: a */
    public static /* synthetic */ String m15246a(String str, String str2, String str3, boolean z, int i, Object obj) {
        accbb.m15218b(str, "receiver$0");
        accbb.m15218b(str2, "oldValue");
        accbb.m15218b(str3, "newValue");
        String[] strArr = {str2};
        accbb.m15218b(str, "receiver$0");
        accbb.m15218b(strArr, "delimiters");
        accbb.m15218b(strArr, "receiver$0");
        List asList = Arrays.asList(strArr);
        accbb.m15215a((Object) asList, "ArraysUtilJVM.asList(this)");
        babab babab = new babab(str, 0, 0, new babac.aaaaa(asList, false));
        babac.aaaab aaaab = new babac.aaaab(str);
        accbb.m15218b(babab, "receiver$0");
        accbb.m15218b(aaaab, "transform");
        return baaca.m15242a(new baacb(babab, aaaab), str3, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (accac) null, 62, (Object) null);
    }

    /* renamed from: a */
    public static <T> void m15247a(Appendable appendable, T t, accac<? super T, ? extends CharSequence> accac) {
        accbb.m15218b(appendable, "receiver$0");
        if (t != null ? t instanceof CharSequence : true) {
            appendable.append((CharSequence) t);
        } else if (t instanceof Character) {
            appendable.append(((Character) t).charValue());
        } else {
            appendable.append(String.valueOf(t));
        }
    }

    /* renamed from: a */
    public static boolean m15248a(char c, char c2, boolean z) {
        if (c == c2) {
            return true;
        }
        if (!z) {
            return false;
        }
        return Character.toUpperCase(c) == Character.toUpperCase(c2) || Character.toLowerCase(c) == Character.toLowerCase(c2);
    }

    /* renamed from: a */
    public static boolean m15249a(Context context) {
        accbb.m15218b(context, "context");
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    /* renamed from: a */
    public static boolean m15250a(CharSequence charSequence) {
        boolean z;
        boolean z2;
        accbb.m15218b(charSequence, "receiver$0");
        if (charSequence.length() != 0) {
            accbb.m15218b(charSequence, "receiver$0");
            Iterator it = new baabb(0, charSequence.length() - 1).iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                char charAt = charSequence.charAt(((acbbc) it).mo29532a());
                if (Character.isWhitespace(charAt) || Character.isSpaceChar(charAt)) {
                    z2 = true;
                    continue;
                } else {
                    z2 = false;
                    continue;
                }
                if (!z2) {
                    z = false;
                    break;
                }
            }
            return z;
        }
    }

    /* renamed from: a */
    public static boolean m15251a(String str, int i, String str2, int i2, int i3, boolean z) {
        accbb.m15218b(str, "receiver$0");
        accbb.m15218b(str2, "other");
        return !z ? str.regionMatches(0, str2, i2, i3) : str.regionMatches(z, 0, str2, i2, i3);
    }

    /* renamed from: a */
    public static /* synthetic */ boolean m15252a(String str, String str2, boolean z, int i, Object obj) {
        accbb.m15218b(str, "receiver$0");
        accbb.m15218b(str2, "prefix");
        return str.startsWith(str2);
    }
}
