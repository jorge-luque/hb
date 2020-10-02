package p118io.presage.core;

import android.content.Context;
import java.io.File;
import java.io.OutputStream;
import java.io.PrintStream;
import p118io.presage.core.lIlIIlIl;
import p118io.presage.core.lIlIIlll;

/* renamed from: io.presage.core.lIlIlIlI */
public class lIlIlIlI extends lIlIIlll {
    public final String IIIIIlII = C6379z.IIIIIIlI;
    public final String IIIIIlIl = C6379z.IIIIIlIl;

    public lIlIlIlI(Context context, lIIIlllI liiillli, OutputStream outputStream, File file) {
        super(context, liiillli, outputStream, file);
    }

    public void IIIIIIII() {
    }

    public void IIIIIIII(IIllllII iIllllII, boolean z, lIlIIlll.IIIIIIII iiiiiiii) {
        Thread.currentThread().getName();
        PrintStream printStream = new PrintStream(this.IIIIIIlI);
        StringBuilder IIIIIIII = IIIIIIII.IIIIIIII(new StringBuilder(), this.IIIIIlII, "\r\n", printStream);
        IIIIIIII.append(this.IIIIIlIl);
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
