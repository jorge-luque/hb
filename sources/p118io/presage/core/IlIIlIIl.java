package p118io.presage.core;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

/* renamed from: io.presage.core.IlIIlIIl */
public class IlIIlIIl extends IIllllll {
    public static final String IIIIlllI = lllIIIII.IIIIIIII;

    public IlIIlIIl(Context context, int i, long j, long j2) {
        super(context, i, j, j2);
    }

    public int IIIIIIII() {
        return 26;
    }

    public Object IIIIIIll() {
        return IlIIlIIl.class;
    }

    public void IIIIIlIl() {
        String str;
        File file = new File(this.IIIIIIlI.getFilesDir(), IIIIlllI);
        try {
            if (file.exists()) {
                str = new String(IIIIlIll.IIIIIIII((InputStream) new FileInputStream(file), true));
            } else {
                str = UUID.randomUUID().toString();
                IIIIlIll.IIIIIIII(str.getBytes(), (OutputStream) new FileOutputStream(file), true);
            }
        } catch (IOException unused) {
            str = null;
        }
        if (str != null && !str.isEmpty()) {
            IIIIIIII((IIIlIIlI) new IIIlIlII(C6325l1.IIIIIIII(), str));
        }
        IIIIIIII(0);
    }

    public void IIIIIllI() {
    }
}
