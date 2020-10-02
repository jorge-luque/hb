package p118io.presage.core;

import android.content.Context;
import java.io.File;
import java.io.OutputStream;
import java.io.PrintStream;
import p118io.presage.core.lIlIIlIl;
import p118io.presage.core.lIlIIlll;

/* renamed from: io.presage.core.lIlIlIll */
public class lIlIlIll extends lIlIIlll {
    public final String IIIIIlII = C6379z.IIIIIIII;
    public final String IIIIIlIl = C6379z.IIIIIlII;
    public final String IIIIIllI = C6379z.IIIIIllI;
    public final String IIIIIlll = C6379z.IIIIlIII;
    public final String IIIIlIII = C6379z.IIIIlIIl;
    public final String IIIIlIIl = C6379z.IIIIlIlI;
    public final String IIIIlIlI = C6379z.IIIIlIll;

    public lIlIlIll(Context context, lIIIlllI liiillli, OutputStream outputStream, File file) {
        super(context, liiillli, outputStream, file);
    }

    public void IIIIIIII() {
    }

    public void IIIIIIII(IIllllII iIllllII, boolean z, lIlIIlll.IIIIIIII iiiiiiii) {
        Thread.currentThread().getName();
        PrintStream printStream = new PrintStream(this.IIIIIIlI);
        StringBuilder IIIIIIII = IIIIIIII.IIIIIIII(IIIIIIII.IIIIIIII(IIIIIIII.IIIIIIII(IIIIIIII.IIIIIIII(IIIIIIII.IIIIIIII(IIIIIIII.IIIIIIII(new StringBuilder(), this.IIIIIlII, " \r\n", printStream), this.IIIIIlIl, "\r\n", printStream), this.IIIIIllI, "\r\n", printStream), this.IIIIIlll, "\r\n", printStream), this.IIIIlIII, "\r\n", printStream), this.IIIIlIIl, "\r\n", printStream);
        IIIIIIII.append(this.IIIIlIlI);
        IIIIIIII.append("\r\n");
        printStream.print(IIIIIIII.toString());
        printStream.print("\r\n");
        printStream.close();
        if (iiiiiiii != null) {
            ((lIlIIlIl.IIIIIIII.C6858IIIIIIII) iiiiiiii).IIIIIIII();
        }
    }

    public void IIIIIIII(File file) {
    }
}
