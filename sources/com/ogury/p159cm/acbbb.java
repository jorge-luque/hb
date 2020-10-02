package com.ogury.p159cm;

import android.content.Context;
import com.ogury.p159cm.ConsentActivity;
import java.io.Closeable;

/* renamed from: com.ogury.cm.acbbb */
public final class acbbb {
    /* renamed from: a */
    public static int m15198a(Integer[] numArr) {
        accbb.m15218b(numArr, "receiver$0");
        int i = 0;
        for (Integer intValue : numArr) {
            i += intValue.intValue();
        }
        return i;
    }

    /* renamed from: a */
    private static <T, A extends Appendable> A m15199a(T[] tArr, A a, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, accac<? super T, ? extends CharSequence> accac) {
        accbb.m15218b(tArr, "receiver$0");
        accbb.m15218b(a, "buffer");
        accbb.m15218b(charSequence, "separator");
        accbb.m15218b(charSequence2, "prefix");
        accbb.m15218b(charSequence3, "postfix");
        accbb.m15218b(charSequence4, "truncated");
        a.append(charSequence2);
        int i2 = 0;
        for (T t : tArr) {
            i2++;
            if (i2 > 1) {
                a.append(charSequence);
            }
            baacc.m15247a((Appendable) a, t, (accac) null);
        }
        a.append(charSequence3);
        return a;
    }

    /* renamed from: a */
    public static /* synthetic */ String m15200a(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, accac accac, int i2, Object obj) {
        accbb.m15218b(objArr, "receiver$0");
        accbb.m15218b(", ", "separator");
        accbb.m15218b(charSequence2, "prefix");
        accbb.m15218b(charSequence3, "postfix");
        accbb.m15218b("...", "truncated");
        String sb = ((StringBuilder) m15199a(objArr, new StringBuilder(), ", ", charSequence2, charSequence3, -1, "...", (accac) null)).toString();
        accbb.m15215a((Object) sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    /* renamed from: a */
    public static void m15201a(Closeable closeable, Throwable th) {
        if (th == null) {
            closeable.close();
            return;
        }
        try {
            closeable.close();
        } catch (Throwable th2) {
            accbb.m15218b(th, "receiver$0");
            accbb.m15218b(th2, "exception");
            acbcc.f12140a.mo29537a(th, th2);
        }
    }

    /* renamed from: a */
    public static boolean m15202a(Context context) {
        accbb.m15218b(context, "context");
        return ConsentActivity.aaaaa.m14885b(context);
    }
}
