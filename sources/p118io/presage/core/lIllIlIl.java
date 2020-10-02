package p118io.presage.core;

import android.content.Context;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import p118io.presage.core.C6313i1;
import p118io.presage.core.lIlIIlIl;
import p118io.presage.core.lIlIIlll;
import p118io.presage.core.lIllIlII;

/* renamed from: io.presage.core.lIllIlIl */
public class lIllIlIl extends lIlIIlll implements lIllIlII.IIIIIIlI {
    public final String IIIIIlII = C6379z.IIIIIIII;
    public final String IIIIIlIl = C6379z.IIIIIIll;
    public final String IIIIIllI = C6379z.IIIIIlII;
    public final String IIIIIlll = C6379z.IIIIIlIl;
    public final String IIIIlIII = C6379z.IIIIlIIl;
    public final String IIIIlIIl = C6379z.IIIIlIlI;
    public final String IIIIlIlI = C6379z.IIIIlIll;
    public lIllIlII IIIIlIll;
    public lIlIlllI IIIIllII;
    public File IIIIllIl;
    public IIllllII IIIIlllI;
    public boolean IIIIllll;

    public lIllIlIl(Context context, lIIIlllI liiillli, OutputStream outputStream, File file) {
        super(context, liiillli, outputStream, file);
    }

    public void IIIIIIII() {
        lIllIlII lillilii = this.IIIIlIll;
        if (lillilii != null) {
            lillilii.IIIIIIll();
        }
    }

    public void IIIIIIII(IIllllII iIllllII, boolean z, lIlIIlll.IIIIIIII iiiiiiii) {
        Thread.currentThread().getName();
        this.IIIIlllI = iIllllII;
        this.IIIIllll = z;
        this.IIIIllII = lIllIIII.IIIIIIII(this.IIIIIIIl.IIIIIIlI, true);
        PrintStream printStream = new PrintStream(this.IIIIIIlI);
        if (this.IIIIllII != null) {
            StringBuilder IIIIIIII = IIIIIIII.IIIIIIII(IIIIIIII.IIIIIIII(IIIIIIII.IIIIIIII(IIIIIIII.IIIIIIII(IIIIIIII.IIIIIIII(new StringBuilder(), this.IIIIIlII, " \r\n", printStream), this.IIIIIllI, "\r\n", printStream), this.IIIIIlll, "\r\n", printStream), this.IIIIlIII, "\r\n", printStream), this.IIIIlIIl, "\r\n", printStream);
            IIIIIIII.append(this.IIIIlIlI);
            IIIIIIII.append("\r\n");
            printStream.print(IIIIIIII.toString());
            printStream.print("\r\n");
            printStream.close();
            lIllIlII lillilii = new lIllIlII(this.IIIIIIII, this);
            this.IIIIlIll = lillilii;
            lillilii.IIIIIIII(iIllllII, this.IIIIllII);
            Thread.currentThread().getName();
            File file = new File(this.IIIIIIll, String.valueOf(1));
            if (file.exists() || file.mkdirs()) {
                IIIIIIII(file);
            }
        } else {
            StringBuilder IIIIIIII2 = IIIIIIII.IIIIIIII(IIIIIIII.IIIIIIII(new StringBuilder(), this.IIIIIlIl, " \r\n", printStream), this.IIIIIllI, "\r\n", printStream);
            IIIIIIII2.append(this.IIIIIlll);
            IIIIIIII2.append("\r\n");
            printStream.print(IIIIIIII2.toString());
            printStream.print("\r\n");
            printStream.close();
        }
        if (iiiiiiii != null) {
            ((lIlIIlIl.IIIIIIII.C6858IIIIIIII) iiiiiiii).IIIIIIII();
        }
    }

    public void IIIIIIII(lIllIlII lillilii) {
        Thread.currentThread().getName();
        try {
            C6313i1.IIIIIIII(this.IIIIlllI, this.IIIIllll, this.IIIIllIl, (C6313i1.IIIIIIII) null);
        } catch (IIlllIII unused) {
        }
    }

    public void IIIIIIII(File file) {
        Thread.currentThread().getName();
        if (this.IIIIllII != null) {
            try {
                File file2 = new File(file, String.valueOf(System.currentTimeMillis()));
                IIIIlIll.IIIIIIII(new ByteArrayInputStream(lIllIIII.IIIIIIII(this.IIIIllII).toString().getBytes()), new FileOutputStream(file2), true, true);
                this.IIIIllIl = file2;
            } catch (Exception unused) {
            }
        }
    }
}
