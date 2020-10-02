package p118io.presage.core;

import android.content.Context;
import java.io.File;
import p118io.presage.core.C6313i1;
import p118io.presage.core.lIllIlII;

/* renamed from: io.presage.core.lIllIllI */
public class lIllIllI extends lIlIlIIl implements lIllIlII.IIIIIIlI {
    public lIlIlllI IIIIIIII;
    public lIllIlII IIIIIIIl;
    public File IIIIIIlI;
    public IIllllII IIIIIIll;
    public boolean IIIIIlII;

    public lIllIllI(Context context, File file, lIlIlllI lilillli) {
        super(context);
        this.IIIIIIII = lilillli;
        this.IIIIIIlI = file;
        this.IIIIIIIl = new lIllIlII(context, this);
    }

    public void IIIIIIII(lIllIlII lillilii) {
        Thread.currentThread().getName();
        try {
            C6313i1.IIIIIIII(this.IIIIIIll, this.IIIIIlII, this.IIIIIIlI, (C6313i1.IIIIIIII) null);
        } catch (IIlllIII unused) {
        }
    }
}
