package com.ogury.p159cm;

import java.util.Iterator;

/* renamed from: com.ogury.cm.baaca */
public final class baaca {
    /* renamed from: a */
    private static <T, A extends Appendable> A m15241a(baabc<? extends T> baabc, A a, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, accac<? super T, ? extends CharSequence> accac) {
        accbb.m15218b(baabc, "receiver$0");
        accbb.m15218b(a, "buffer");
        accbb.m15218b(charSequence, "separator");
        accbb.m15218b(charSequence2, "prefix");
        accbb.m15218b(charSequence3, "postfix");
        accbb.m15218b(charSequence4, "truncated");
        a.append(charSequence2);
        Iterator<? extends T> a2 = baabc.mo29561a();
        int i2 = 0;
        while (a2.hasNext()) {
            Object next = a2.next();
            i2++;
            if (i2 > 1) {
                a.append(charSequence);
            }
            baacc.m15247a((Appendable) a, next, (accac) null);
        }
        a.append(charSequence3);
        return a;
    }

    /* renamed from: a */
    public static /* synthetic */ String m15242a(baabc baabc, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, accac accac, int i2, Object obj) {
        accbb.m15218b(baabc, "receiver$0");
        accbb.m15218b(charSequence, "separator");
        accbb.m15218b("", "prefix");
        accbb.m15218b("", "postfix");
        accbb.m15218b("...", "truncated");
        String sb = ((StringBuilder) m15241a(baabc, new StringBuilder(), charSequence, "", "", -1, "...", (accac) null)).toString();
        accbb.m15215a((Object) sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }
}
