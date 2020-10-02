package p118io.presage.core;

import android.content.Context;
import java.io.File;
import java.io.OutputStream;
import java.io.PrintStream;
import p118io.presage.core.C6337o1;
import p118io.presage.core.lIlIIlIl;
import p118io.presage.core.lIlIIlll;

/* renamed from: io.presage.core.lIlIllIl */
public class lIlIllIl extends lIlIIlll {
    public static final String IIIIllIl = C6284b0.IIIIIIII;
    public static final String IIIIlllI = C6284b0.IIIIIIIl;
    public final String IIIIIlII = C6379z.IIIIIIII;
    public final String IIIIIlIl = C6379z.IIIIIIIl;
    public final String IIIIIllI = C6379z.IIIIIlII;
    public final String IIIIIlll = C6379z.IIIIIlIl;
    public final String IIIIlIII = C6379z.IIIIIlll;
    public final String IIIIlIIl = C6379z.IIIIlIII;
    public final String IIIIlIlI = C6379z.IIIIlIIl;
    public final String IIIIlIll = C6379z.IIIIlIlI;
    public final String IIIIllII = C6379z.IIIIlIll;

    /* renamed from: io.presage.core.lIlIllIl$IIIIIIII */
    public class IIIIIIII implements C6337o1.IIIIIIlI {
        public final /* synthetic */ IIllllII IIIIIIII;
        public final /* synthetic */ boolean IIIIIIIl;
        public final /* synthetic */ lIlIIlll.IIIIIIII IIIIIIlI;

        /* renamed from: io.presage.core.lIlIllIl$IIIIIIII$IIIIIIII  reason: collision with other inner class name */
        public class C6860IIIIIIII implements Runnable {
            public final /* synthetic */ C6333n1 IIIIIIII;

            public C6860IIIIIIII(C6333n1 n1Var) {
                this.IIIIIIII = n1Var;
            }

            public void run() {
                Thread.currentThread().getName();
                String IIIIIIII2 = lIlIllIl.this.IIIIIIII(this.IIIIIIII.IIIIIIII);
                PrintStream printStream = new PrintStream(lIlIllIl.this.IIIIIIlI);
                StringBuilder IIIIIIII3 = IIIIIIII.IIIIIIII(IIIIIIII.IIIIIIII(new StringBuilder(), lIlIllIl.this.IIIIIlII, "\r\n", printStream), lIlIllIl.this.IIIIIllI, "\r\n", printStream);
                IIIIIIII3.append(lIlIllIl.this.IIIIlIII);
                IIIIIIII3.append(IIIIIIII2.length());
                IIIIIIII3.append("\r\n");
                printStream.print(IIIIIIII3.toString());
                StringBuilder IIIIIIII4 = IIIIIIII.IIIIIIII(IIIIIIII.IIIIIIII(IIIIIIII.IIIIIIII(new StringBuilder(), lIlIllIl.this.IIIIlIlI, "\r\n", printStream), lIlIllIl.this.IIIIlIll, "\r\n", printStream), lIlIllIl.this.IIIIllII, "\r\n", printStream);
                IIIIIIII4.append(lIlIllIl.this.IIIIIlll);
                IIIIIIII4.append("\r\n");
                printStream.print(IIIIIIII4.toString());
                printStream.print("\r\n");
                printStream.print(IIIIIIII2);
                printStream.close();
                IIIIIIII.this.IIIIIIII.IIIIIIIl();
                IIIIIIII iiiiiiii = IIIIIIII.this;
                if (iiiiiiii.IIIIIIIl) {
                    IIIIlIll.IIIIIIII((IIlllIll) iiiiiiii.IIIIIIII);
                }
                lIlIIlll.IIIIIIII iiiiiiii2 = IIIIIIII.this.IIIIIIlI;
                if (iiiiiiii2 != null) {
                    ((lIlIIlIl.IIIIIIII.C6858IIIIIIII) iiiiiiii2).IIIIIIII();
                }
            }
        }

        /* renamed from: io.presage.core.lIlIllIl$IIIIIIII$IIIIIIIl */
        public class IIIIIIIl implements Runnable {
            public IIIIIIIl() {
            }

            public void run() {
                Thread.currentThread().getName();
                PrintStream printStream = new PrintStream(lIlIllIl.this.IIIIIIlI);
                StringBuilder IIIIIIII2 = IIIIIIII.IIIIIIII(IIIIIIII.IIIIIIII(new StringBuilder(), lIlIllIl.this.IIIIIlIl, "\r\n", printStream), lIlIllIl.this.IIIIlIIl, "\r\n", printStream);
                IIIIIIII2.append(lIlIllIl.this.IIIIIlll);
                IIIIIIII2.append("\r\n");
                printStream.print(IIIIIIII2.toString());
                printStream.print("\r\n");
                printStream.close();
                IIIIIIII.this.IIIIIIII.IIIIIIIl();
                IIIIIIII iiiiiiii = IIIIIIII.this;
                if (iiiiiiii.IIIIIIIl) {
                    IIIIlIll.IIIIIIII((IIlllIll) iiiiiiii.IIIIIIII);
                }
                lIlIIlll.IIIIIIII iiiiiiii2 = IIIIIIII.this.IIIIIIlI;
                if (iiiiiiii2 != null) {
                    ((lIlIIlIl.IIIIIIII.C6858IIIIIIII) iiiiiiii2).IIIIIIII();
                }
            }
        }

        public IIIIIIII(IIllllII iIllllII, boolean z, lIlIIlll.IIIIIIII iiiiiiii) {
            this.IIIIIIII = iIllllII;
            this.IIIIIIIl = z;
            this.IIIIIIlI = iiiiiiii;
        }

        public void IIIIIIII(C6337o1 o1Var, C6333n1 n1Var) {
            Thread.currentThread().getName();
            this.IIIIIIII.execute(new C6860IIIIIIII(n1Var));
        }

        public void IIIIIIII(C6337o1 o1Var, Exception exc, int i) {
            Thread.currentThread().getName();
            this.IIIIIIII.execute(new IIIIIIIl());
        }
    }

    public lIlIllIl(Context context, lIIIlllI liiillli, OutputStream outputStream, File file) {
        super(context, liiillli, outputStream, file);
    }

    public final String IIIIIIII(String str) {
        try {
            return new String(new C6353s1().IIIIIIII(0).IIIIIIlI(new C6377y1().IIIIIIII(1).IIIIIIII(IIIIllIl.getBytes()).getBytes()).IIIIIIII(2).IIIIIIII(1).IIIIIIlI(IIIIlllI.getBytes()).IIIIIIIl(str.getBytes()));
        } catch (Exception e) {
            lIIIIlIl.IIIIIIII(e, 1);
            return null;
        }
    }

    public void IIIIIIII() {
    }

    public void IIIIIIII(IIllllII iIllllII, boolean z, lIlIIlll.IIIIIIII iiiiiiii) {
        Thread.currentThread().getName();
        new C6337o1(this.IIIIIIII).IIIIIIII(iIllllII, z, new IIIIIIII(iIllllII, z, iiiiiiii));
    }

    public void IIIIIIII(File file) {
    }
}
