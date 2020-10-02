package com.ogury.crashreport;

/* compiled from: _ArraysJvm.kt */
class pard extends viewkind0 {
    /* renamed from: a */
    public static <T, A extends Appendable> A m15302a(T[] tArr, A a, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, tx7200<? super T, ? extends CharSequence> tx7200) {
        tx7920.m15333b(tArr, "receiver$0");
        tx7920.m15333b(a, "buffer");
        tx7920.m15333b(charSequence, "separator");
        tx7920.m15333b(charSequence2, "prefix");
        tx7920.m15333b(charSequence3, "postfix");
        tx7920.m15333b(charSequence4, "truncated");
        a.append(charSequence2);
        int i2 = 0;
        for (T t : tArr) {
            i2++;
            boolean z = true;
            if (i2 > 1) {
                a.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            tx7920.m15333b(a, "receiver$0");
            if (tx7200 != null) {
                a.append((CharSequence) tx7200.mo29618a());
            } else {
                if (t != null) {
                    z = t instanceof CharSequence;
                }
                if (z) {
                    a.append((CharSequence) t);
                } else if (t instanceof Character) {
                    a.append(((Character) t).charValue());
                } else {
                    a.append(String.valueOf(t));
                }
            }
        }
        if (i >= 0 && i2 > i) {
            a.append(charSequence4);
        }
        a.append(charSequence3);
        return a;
    }

    /* renamed from: a */
    public static /* synthetic */ String m15303a(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, tx7200 tx7200, int i2) {
        tx7920.m15333b(objArr, "receiver$0");
        tx7920.m15333b(charSequence, "separator");
        tx7920.m15333b("", "prefix");
        tx7920.m15333b("", "postfix");
        tx7920.m15333b("...", "truncated");
        String sb = ((StringBuilder) m15302a((T[]) objArr, new StringBuilder(), charSequence, (CharSequence) "", (CharSequence) "", -1, (CharSequence) "...", (tx7200) null)).toString();
        tx7920.m15330a((Object) sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }
}
