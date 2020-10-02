package p118io.presage.core;

import android.content.Context;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* renamed from: io.presage.core.IlIIIlll */
public abstract class IlIIIlll extends IIllllll {
    public long IIIIlllI = 15;
    public Runnable IIIIllll;
    public ScheduledFuture<?> IIIlIIII;

    /* renamed from: io.presage.core.IlIIIlll$IIIIIIII */
    public class IIIIIIII implements Runnable {
        public IIIIIIII() {
        }

        public void run() {
            IlIIIlll ilIIIlll = IlIIIlll.this;
            if (ilIIIlll.IIIIIlll) {
                IIlllllI iIlllllI = ilIIIlll.IIIIllII;
                if (iIlllllI == null || iIlllllI.IIIIIIII.isShutdown()) {
                    IlIIIlll ilIIIlll2 = IlIIIlll.this;
                    ilIIIlll2.IIIIIIII(new IIlllIII(), 0);
                    ilIIIlll2.IIIIIIII(0);
                    return;
                }
                IlIIIlll ilIIIlll3 = IlIIIlll.this;
                ilIIIlll3.IIIlIIII = ilIIIlll3.IIIIllII.schedule(ilIIIlll3.IIIIllll, ilIIIlll3.IIIIlIlI, TimeUnit.SECONDS);
                synchronized (IlIIIlll.this.IIIIIIll()) {
                    IlIIIlll.this.IIIIlIlI();
                    IlIIIlll.this.IIIIllII.IIIIIIIl();
                }
            }
        }
    }

    public IlIIIlll(Context context, int i, long j, long j2) {
        super(context, i, j, j2);
        if (j2 == 0) {
            this.IIIIlIlI = 15;
        }
        this.IIIIlIlI = Math.max(this.IIIIlIlI, this.IIIIIIIl);
    }

    public final void IIIIIlIl() {
        this.IIIIllll = new IIIIIIII();
        IIlllllI iIlllllI = this.IIIIllII;
        if (iIlllllI == null || iIlllllI.IIIIIIII.isShutdown()) {
            IIIIIIII(new IIlllIII(), 0);
            IIIIIIII(0);
            return;
        }
        this.IIIlIIII = this.IIIIllII.schedule(this.IIIIllll, this.IIIIlIlI, TimeUnit.SECONDS);
        IIIIlIlI();
    }

    public final void IIIIIllI() {
        ScheduledFuture<?> scheduledFuture = this.IIIlIIII;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.IIIIllII.IIIIIIIl();
        }
        IIIIlIIl();
    }

    public abstract void IIIIlIIl();

    public abstract void IIIIlIlI();
}
