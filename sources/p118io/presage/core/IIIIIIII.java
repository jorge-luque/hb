package p118io.presage.core;

import java.io.PrintStream;

/* renamed from: io.presage.core.IIIIIIII */
/* compiled from: outline */
public class IIIIIIII {
    public static String IIIIIIII(String str, String str2, String str3) {
        return IIIIlIll.IIIIIIII(str3, new llllIlII(str, str2));
    }

    public static StringBuilder IIIIIIII(StringBuilder sb, String str, String str2, PrintStream printStream) {
        sb.append(str);
        sb.append(str2);
        printStream.print(sb.toString());
        return new StringBuilder();
    }
}
