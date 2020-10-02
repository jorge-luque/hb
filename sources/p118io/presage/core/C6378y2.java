package p118io.presage.core;

import android.content.Context;
import android.graphics.Bitmap;

/* renamed from: io.presage.core.y2 */
public class C6378y2 {
    public static C6378y2 IIIIIlII;
    public Context IIIIIIII;
    public Bitmap IIIIIIIl;
    public Bitmap IIIIIIlI;
    public Bitmap IIIIIIll;

    public C6378y2(Context context) {
        this.IIIIIIII = context;
    }

    public static C6378y2 IIIIIIII(Context context) {
        if (IIIIIlII == null) {
            IIIIIlII = new C6378y2(context);
        }
        return IIIIIlII;
    }
}
