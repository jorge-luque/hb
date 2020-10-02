package p118io.presage.core;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;

/* renamed from: io.presage.core.IIIIIllI */
public class IIIIIllI implements Thread.UncaughtExceptionHandler {
    public final /* synthetic */ Thread.UncaughtExceptionHandler IIIIIIII;
    public final /* synthetic */ IIIIIIll IIIIIIIl;

    public IIIIIllI(IIIIIIll iIIIIIll, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.IIIIIIIl = iIIIIIll;
        this.IIIIIIII = uncaughtExceptionHandler;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (!(this.IIIIIIIl.IIIIIIII(th) == null || this.IIIIIIIl.IIIIIIII(th).getStackTrace()[0] == null || !this.IIIIIIIl.IIIIIIII(th).getStackTrace()[0].getClassName().contains(IIIIIIll.IIIIIIlI))) {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            thread.getId();
            thread.getName();
            stringWriter.toString();
            lIIIIlIl.IIIIIIII(new Exception(th), 1);
        }
        this.IIIIIIII.uncaughtException(thread, th);
    }
}
