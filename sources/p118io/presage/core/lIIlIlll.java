package p118io.presage.core;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;

/* renamed from: io.presage.core.lIIlIlll */
public class lIIlIlll {
    public Context IIIIIIII;
    public Handler IIIIIIIl;
    public lIIlIIll IIIIIIlI;
    public int IIIIIIll;
    public long IIIIIlII;

    /* renamed from: io.presage.core.lIIlIlll$IIIIIIII */
    public class IIIIIIII implements Runnable {
        public IIIIIIII() {
        }

        public void run() {
            lIIlIlll.this.IIIIIIII();
        }
    }

    public lIIlIlll(Context context, lIIlIIll liiliill) {
        if (liiliill == null) {
            throw new lIIlIlIl();
        } else if (liiliill.IIIIIIII != null) {
            this.IIIIIIII = context;
            this.IIIIIIIl = new Handler(Looper.getMainLooper());
            this.IIIIIIlI = liiliill;
            this.IIIIIIll = 0;
        } else {
            throw new lIIlIlIl();
        }
    }

    public void IIIIIIII() {
        this.IIIIIIll--;
        lIIlIIll liiliill = this.IIIIIIlI;
        if (liiliill != null && liiliill.IIIIIIIl == 1 && this.IIIIIIll == 0) {
            long currentTimeMillis = liiliill.IIIIIlIl - (System.currentTimeMillis() - this.IIIIIlII);
            long j = this.IIIIIIlI.IIIIIlIl;
            if (currentTimeMillis <= 0) {
                ((NotificationManager) this.IIIIIIII.getSystemService("notification")).cancel(879824);
                return;
            }
            this.IIIIIIll++;
            this.IIIIIIIl.postDelayed(new IIIIIIII(), currentTimeMillis);
        }
    }
}
