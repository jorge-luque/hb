package p118io.presage.core;

import android.content.Context;
import java.io.File;
import java.io.OutputStream;

/* renamed from: io.presage.core.lIlIIlll */
public abstract class lIlIIlll {
    public Context IIIIIIII;
    public lIIIlllI IIIIIIIl;
    public OutputStream IIIIIIlI;
    public File IIIIIIll;

    /* renamed from: io.presage.core.lIlIIlll$IIIIIIII */
    public interface IIIIIIII {
    }

    public lIlIIlll(Context context, lIIIlllI liiillli, OutputStream outputStream, File file) {
        this.IIIIIIII = context;
        this.IIIIIIIl = liiillli;
        this.IIIIIIlI = outputStream;
        this.IIIIIIll = file;
    }

    public abstract void IIIIIIII();

    public abstract void IIIIIIII(IIllllII iIllllII, boolean z, IIIIIIII iiiiiiii);

    public abstract void IIIIIIII(File file);
}
