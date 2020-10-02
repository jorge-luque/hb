package p118io.presage.core;

import android.os.Process;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: io.presage.core.IIllllIl */
public class IIllllIl {
    public static final String IIIIIIll = lllIllII.IIIIIIII;
    public static final String IIIIIlII = lllIllII.IIIIIIIl;
    public static final String IIIIIlIl = lllIllII.IIIIIIlI;
    public static final String IIIIIllI = lllIllII.IIIIIIll;
    public static IIllllIl IIIIIlll;
    public IIllllII IIIIIIII;
    public IIllllII IIIIIIIl;
    public IIllllII IIIIIIlI;

    /* renamed from: io.presage.core.IIllllIl$IIIIIIII */
    public static class IIIIIIII implements ThreadFactory {
        public static final AtomicInteger IIIIIIll = new AtomicInteger(1);
        public final ThreadGroup IIIIIIII;
        public final AtomicInteger IIIIIIIl = new AtomicInteger(1);
        public final String IIIIIIlI;

        /* renamed from: io.presage.core.IIllllIl$IIIIIIII$IIIIIIII  reason: collision with other inner class name */
        public class C6854IIIIIIII implements Thread.UncaughtExceptionHandler {
            public C6854IIIIIIII(IIIIIIII iiiiiiii) {
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
            thread.setUncaughtExceptionHandler(new C6854IIIIIIII(this));
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    public static IIllllIl IIIIIIlI() {
        if (IIIIIlll == null) {
            IIIIIlll = new IIllllIl();
        }
        return IIIIIlll;
    }

    public IIllllII IIIIIIII() {
        IIllllII iIllllII = this.IIIIIIlI;
        if (iIllllII == null || iIllllII.IIIIIIII.isTerminated()) {
            this.IIIIIIlI = new IIllllII(Executors.newSingleThreadExecutor(new IIIIIIII(new ThreadGroup(IIIIIIll), IIIIIlII)));
        }
        return this.IIIIIIlI;
    }

    public IIllllII IIIIIIIl() {
        IIllllII iIllllII = this.IIIIIIII;
        if (iIllllII == null || iIllllII.IIIIIIII.isTerminated()) {
            this.IIIIIIII = new IIllllII(Executors.newFixedThreadPool(3, new IIIIIIII(new ThreadGroup(IIIIIIll), IIIIIllI)));
        }
        return this.IIIIIIII;
    }
}
