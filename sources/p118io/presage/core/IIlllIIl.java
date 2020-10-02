package p118io.presage.core;

import android.os.Process;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: io.presage.core.IIlllIIl */
public class IIlllIIl {
    public static final String IIIIIllI = lllIlIII.IIIIIIII;
    public static final String IIIIIlll = lllIlIII.IIIIIIIl;
    public static final String IIIIlIII = lllIlIII.IIIIIIlI;
    public static final String IIIIlIIl = lllIlIII.IIIIIIll;
    public static final String IIIIlIlI = lllIlIII.IIIIIlII;
    public static final String IIIIlIll = lllIlIII.IIIIIlIl;
    public final ThreadGroup IIIIIIII = new ThreadGroup(IIIIIllI);
    public final IIlllllI IIIIIIIl = new IIlllllI(Executors.newScheduledThreadPool(5, new IIIIIIII(this.IIIIIIII, IIIIIlll)));
    public final IIllllII IIIIIIlI = new IIllllII(Executors.newSingleThreadExecutor(new IIIIIIII(this.IIIIIIII, IIIIlIII)));
    public final IIllllII IIIIIIll = new IIllllII(Executors.newFixedThreadPool(2, new IIIIIIII(this.IIIIIIII, IIIIlIIl)));
    public final IIllllII IIIIIlII = new IIllllII(Executors.newSingleThreadExecutor(new IIIIIIII(this.IIIIIIII, IIIIlIlI)));
    public final IIllllII IIIIIlIl = new IIllllII(Executors.newFixedThreadPool(5, new IIIIIIII(this.IIIIIIII, IIIIlIll)));

    /* renamed from: io.presage.core.IIlllIIl$IIIIIIII */
    public static class IIIIIIII implements ThreadFactory {
        public static final AtomicInteger IIIIIIll = new AtomicInteger(1);
        public final ThreadGroup IIIIIIII;
        public final AtomicInteger IIIIIIIl = new AtomicInteger(1);
        public final String IIIIIIlI;

        /* renamed from: io.presage.core.IIlllIIl$IIIIIIII$IIIIIIII  reason: collision with other inner class name */
        public class C6853IIIIIIII implements Thread.UncaughtExceptionHandler {
            public C6853IIIIIIII(IIIIIIII iiiiiiii) {
            }

            public void uncaughtException(Thread thread, Throwable th) {
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                thread.getId();
                thread.getName();
                stringWriter.toString();
                lIIIIlIl.IIIIIIII(new Exception(th), 1);
                Process.killProcess(Process.myPid());
                System.exit(10);
            }
        }

        public IIIIIIII(ThreadGroup threadGroup, String str) {
            SecurityManager securityManager = System.getSecurityManager();
            this.IIIIIIII = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.IIIIIIlI = threadGroup.getName() + "-" + IIIIIIll.getAndIncrement() + "-" + str + "-";
        }

        public Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.IIIIIIII;
            Thread thread = new Thread(threadGroup, runnable, this.IIIIIIlI + this.IIIIIIIl.getAndIncrement(), 0);
            thread.setUncaughtExceptionHandler(new C6853IIIIIIII(this));
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    public void IIIIIIII() {
        this.IIIIIIIl.IIIIIIII.isTerminated();
        this.IIIIIIlI.IIIIIIII.isTerminated();
        this.IIIIIIll.IIIIIIII.isTerminated();
        this.IIIIIlII.IIIIIIII.isTerminated();
        this.IIIIIlIl.IIIIIIII.isTerminated();
        IIIIlIll.IIIIIIII((IIlllIll) this.IIIIIIIl);
        IIIIlIll.IIIIIIII((IIlllIll) this.IIIIIIlI);
        IIIIlIll.IIIIIIII((IIlllIll) this.IIIIIIll);
        IIIIlIll.IIIIIIII((IIlllIll) this.IIIIIlII);
        IIIIlIll.IIIIIIII((IIlllIll) this.IIIIIlIl);
        ThreadGroup threadGroup = this.IIIIIIII;
        if (threadGroup != null) {
            threadGroup.interrupt();
        }
    }
}
