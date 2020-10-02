package p118io.presage.core;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: io.presage.core.IIlllIll */
public abstract class IIlllIll {
    public ExecutorService IIIIIIII;
    public IIIIIIIl IIIIIIIl;
    public AtomicInteger IIIIIIlI = new AtomicInteger();

    /* renamed from: io.presage.core.IIlllIll$IIIIIIII */
    public class IIIIIIII implements IIIIIIIl {
        public IIIIIIII() {
        }
    }

    /* renamed from: io.presage.core.IIlllIll$IIIIIIIl */
    public interface IIIIIIIl {
    }

    public IIlllIll(ExecutorService executorService) {
        this.IIIIIIII = executorService;
    }

    public final void IIIIIIII() {
        IIIIIIIl iIIIIIIl = this.IIIIIIIl;
        if (iIIIIIIl != null) {
            IIIIIIII iiiiiiii = (IIIIIIII) iIIIIIIl;
            IIlllIll.this.IIIIIIlI.intValue();
            IIlllIll.this.IIIIIIII.shutdown();
        }
    }

    public void IIIIIIIl() {
        this.IIIIIIlI.decrementAndGet();
        this.IIIIIIlI.intValue();
        if (this.IIIIIIlI.intValue() == 0) {
            IIIIIIII();
        }
    }

    public void execute(Runnable runnable) {
        this.IIIIIIlI.incrementAndGet();
        this.IIIIIIlI.intValue();
        try {
            this.IIIIIIII.execute(runnable);
        } catch (Exception unused) {
            this.IIIIIIlI.decrementAndGet();
        }
    }

    public void shutdown() {
        this.IIIIIIlI.intValue();
        this.IIIIIIII.isShutdown();
        this.IIIIIIII.isTerminated();
        if (this.IIIIIIlI.intValue() == 0) {
            this.IIIIIIII.shutdown();
            return;
        }
        IIIIIIII iiiiiiii = new IIIIIIII();
        if (this.IIIIIIIl == null) {
            this.IIIIIIIl = iiiiiiii;
        }
        if (this.IIIIIIlI.intValue() == 0) {
            IIIIIIII();
        }
    }
}
