package p118io.presage.core;

import android.content.Context;
import java.io.File;
import java.io.OutputStream;
import java.io.PrintStream;
import p118io.presage.core.C6337o1;
import p118io.presage.core.lIlIIlIl;
import p118io.presage.core.lIlIIlll;

/* renamed from: io.presage.core.lIlIllII */
public class lIlIllII extends lIlIIlll {
    public final String IIIIIlII = C6379z.IIIIIIII;
    public final String IIIIIlIl = C6379z.IIIIIIIl;
    public final String IIIIIllI = C6379z.IIIIIlII;
    public final String IIIIIlll = C6379z.IIIIIlIl;
    public final String IIIIlIII = C6379z.IIIIIlll;
    public final String IIIIlIIl = C6379z.IIIIlIII;
    public final String IIIIlIlI = C6379z.IIIIlIIl;
    public final String IIIIlIll = C6379z.IIIIlIlI;
    public final String IIIIllII = C6379z.IIIIlIll;

    /* renamed from: io.presage.core.lIlIllII$IIIIIIII */
    public class IIIIIIII implements C6337o1.IIIIIIlI {
        public final /* synthetic */ IIllllII IIIIIIII;
        public final /* synthetic */ boolean IIIIIIIl;
        public final /* synthetic */ lIlIIlll.IIIIIIII IIIIIIlI;

        /* renamed from: io.presage.core.lIlIllII$IIIIIIII$IIIIIIII  reason: collision with other inner class name */
        public class C6859IIIIIIII implements Runnable {
            public final /* synthetic */ C6333n1 IIIIIIII;

            public C6859IIIIIIII(C6333n1 n1Var) {
                this.IIIIIIII = n1Var;
            }

            public void run() {
                Thread.currentThread().getName();
                String str = this.IIIIIIII.IIIIIIII;
                PrintStream printStream = new PrintStream(lIlIllII.this.IIIIIIlI);
                StringBuilder IIIIIIII2 = IIIIIIII.IIIIIIII(IIIIIIII.IIIIIIII(new StringBuilder(), lIlIllII.this.IIIIIlII, "\r\n", printStream), lIlIllII.this.IIIIIllI, "\r\n", printStream);
                IIIIIIII2.append(lIlIllII.this.IIIIlIII);
                IIIIIIII2.append(str.length());
                IIIIIIII2.append("\r\n");
                printStream.print(IIIIIIII2.toString());
                StringBuilder IIIIIIII3 = IIIIIIII.IIIIIIII(IIIIIIII.IIIIIIII(IIIIIIII.IIIIIIII(new StringBuilder(), lIlIllII.this.IIIIIlll, "\r\n", printStream), lIlIllII.this.IIIIlIlI, "\r\n", printStream), lIlIllII.this.IIIIlIll, "\r\n", printStream);
                IIIIIIII3.append(lIlIllII.this.IIIIllII);
                IIIIIIII3.append("\r\n");
                printStream.print(IIIIIIII3.toString());
                printStream.print("\r\n");
                printStream.print(str);
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

        /* renamed from: io.presage.core.lIlIllII$IIIIIIII$IIIIIIIl */
        public class IIIIIIIl implements Runnable {
            public IIIIIIIl() {
            }

            public void run() {
                Thread.currentThread().getName();
                PrintStream printStream = new PrintStream(lIlIllII.this.IIIIIIlI);
                StringBuilder IIIIIIII2 = IIIIIIII.IIIIIIII(IIIIIIII.IIIIIIII(new StringBuilder(), lIlIllII.this.IIIIIlIl, "\r\n", printStream), lIlIllII.this.IIIIlIIl, "\r\n", printStream);
                IIIIIIII2.append(lIlIllII.this.IIIIIlll);
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
            this.IIIIIIII.execute(new C6859IIIIIIII(n1Var));
        }

        public void IIIIIIII(C6337o1 o1Var, Exception exc, int i) {
            Thread.currentThread().getName();
            this.IIIIIIII.execute(new IIIIIIIl());
        }
    }

    public lIlIllII(Context context, lIIIlllI liiillli, OutputStream outputStream, File file) {
        super(context, liiillli, outputStream, file);
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
