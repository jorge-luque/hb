package p118io.presage.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.File;
import java.io.FileNotFoundException;

/* renamed from: io.presage.core.IIllllll */
public abstract class IIllllll {
    public static final String IIIIllIl = lllIIlII.IIIIIIII;
    public IIIIIlII IIIIIIII;
    public long IIIIIIIl = 3;
    public Context IIIIIIlI;
    public File IIIIIIll;
    public SharedPreferences IIIIIlII;
    public SharedPreferences.Editor IIIIIlIl;
    public long IIIIIllI;
    public boolean IIIIIlll;
    public int IIIIlIII;
    public long IIIIlIIl;
    public long IIIIlIlI;
    public Handler IIIIlIll;
    public IIlllllI IIIIllII;

    /* renamed from: io.presage.core.IIllllll$IIIIIIII */
    public class IIIIIIII extends Handler {
        public IIIIIIII(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == -1) {
                lIIIIlIl.IIIIIIII((Exception) message.obj, message.arg1);
            } else if (i == 0) {
                IIllllll.this.IIIIIlll();
            } else if (i != 1) {
                message.obj.toString();
            } else {
                IIllllll iIllllll = IIllllll.this;
                IIIlIIlI iIIlIIlI = (IIIlIIlI) message.obj;
                if (iIllllll.IIIIIIII != null && iIIlIIlI != null) {
                    iIllllll.IIIIIIII();
                    C6325l1.IIIIIIII(iIIlIIlI.IIIIIIII);
                    ((IlIIIIlI) iIllllll.IIIIIIII).IIIIIIII(iIllllll, iIIlIIlI);
                }
            }
        }
    }

    /* renamed from: io.presage.core.IIllllll$IIIIIIIl */
    public class IIIIIIIl implements Runnable {
        public IIIIIIIl() {
        }

        /* JADX WARNING: CFG modification limit reached, blocks count: 118 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r3 = this;
                io.presage.core.IIllllll r0 = p118io.presage.core.IIllllll.this     // Catch:{ Exception -> 0x0025 }
                java.lang.Object r0 = r0.IIIIIIll()     // Catch:{ Exception -> 0x0025 }
                monitor-enter(r0)     // Catch:{ Exception -> 0x0025 }
                io.presage.core.IIllllll r1 = p118io.presage.core.IIllllll.this     // Catch:{ all -> 0x0023 }
                r1.IIIIIIII()     // Catch:{ all -> 0x0023 }
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0023 }
                r1.getName()     // Catch:{ all -> 0x0023 }
                io.presage.core.IIllllll r1 = p118io.presage.core.IIllllll.this     // Catch:{ all -> 0x0023 }
                r1.IIIIIlIl()     // Catch:{ all -> 0x0023 }
                monitor-exit(r0)     // Catch:{ all -> 0x0023 }
                io.presage.core.IIllllll r0 = p118io.presage.core.IIllllll.this     // Catch:{ Exception -> 0x0025 }
                io.presage.core.IIlllllI r0 = r0.IIIIllII     // Catch:{ Exception -> 0x0025 }
                r0.IIIIIIIl()     // Catch:{ Exception -> 0x0025 }
                goto L_0x0030
            L_0x0021:
                monitor-exit(r0)     // Catch:{ all -> 0x0023 }
                throw r1     // Catch:{ Exception -> 0x0025 }
            L_0x0023:
                r1 = move-exception
                goto L_0x0021
            L_0x0025:
                r0 = move-exception
                io.presage.core.IIllllll r1 = p118io.presage.core.IIllllll.this
                r2 = 1
                r1.IIIIIIII(r0, r2)
                r0 = 0
                r1.IIIIIIII((int) r0)
            L_0x0030:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p118io.presage.core.IIllllll.IIIIIIIl.run():void");
        }
    }

    /* renamed from: io.presage.core.IIllllll$IIIIIIlI */
    public class IIIIIIlI implements Runnable {
        public IIIIIIlI() {
        }

        public void run() {
            try {
                synchronized (IIllllll.this.IIIIIIll()) {
                    IIllllll.this.IIIIIllI();
                }
                IIllllll.this.IIIIllII.IIIIIIIl();
            } catch (Exception e) {
                IIllllll.this.IIIIIIII(e, 1);
            }
        }
    }

    /* renamed from: io.presage.core.IIllllll$IIIIIIll */
    public class IIIIIIll implements Runnable {
        public final /* synthetic */ Runnable IIIIIIII;

        public IIIIIIll(Runnable runnable) {
            this.IIIIIIII = runnable;
        }

        public void run() {
            try {
                synchronized (IIllllll.this.IIIIIIll()) {
                    this.IIIIIIII.run();
                }
                IIllllll.this.IIIIllII.IIIIIIIl();
            } catch (Exception e) {
                IIllllll.this.IIIIIIII(e, 1);
            }
        }
    }

    /* renamed from: io.presage.core.IIllllll$IIIIIlII */
    public interface IIIIIlII {
    }

    public IIllllll(Context context, int i, long j, long j2) {
        this.IIIIIIlI = context;
        this.IIIIlIII = i;
        long j3 = 0;
        this.IIIIlIIl = Math.min(Math.max(j, 0), 8760);
        this.IIIIlIlI = j2 != 0 ? Math.max(j2, this.IIIIIIIl) : j3;
        this.IIIIIlll = false;
        this.IIIIIllI = IIIIIIlI();
        this.IIIIlIll = new IIIIIIII(Looper.getMainLooper());
    }

    public abstract int IIIIIIII();

    public File IIIIIIII(String str) {
        if (str == null || str.isEmpty()) {
            throw new FileNotFoundException();
        }
        File file = this.IIIIIIll;
        if (file != null) {
            File file2 = new File(file, String.valueOf(IIIIIIII()));
            C6313i1.IIIIIIlI(file2);
            return new File(file2, str);
        }
        throw new FileNotFoundException();
    }

    public void IIIIIIII(IIIlIIlI iIIlIIlI) {
        if (this.IIIIIlll) {
            Message message = new Message();
            message.what = 1;
            message.obj = iIIlIIlI;
            if (this.IIIIlIll.sendMessage(message)) {
                IIIIIIII();
                Thread.currentThread().getName();
                IIIIIIII(iIIlIIlI.IIIIIIII);
            }
        }
    }

    public void IIIIIIII(Exception exc) {
        IIIIIIII(exc, 1);
    }

    public void IIIIIIII(Exception exc, int i) {
        Message message = new Message();
        message.what = -1;
        message.obj = exc;
        message.arg1 = i;
        this.IIIIlIll.sendMessage(message);
    }

    public final boolean IIIIIIII(int i) {
        Message message = new Message();
        message.what = i;
        return this.IIIIlIll.sendMessage(message);
    }

    public final SharedPreferences IIIIIIIl() {
        if (this.IIIIIlII == null) {
            this.IIIIIlII = this.IIIIIIlI.getSharedPreferences(IIIIllIl, 0);
        }
        return this.IIIIIlII;
    }

    public void IIIIIIIl(IIIlIIlI iIIlIIlI) {
        if (this.IIIIIlll) {
            Message message = new Message();
            message.what = 1;
            message.obj = iIIlIIlI;
            if (this.IIIIlIll.sendMessage(message)) {
                IIIIIIII();
                Thread.currentThread().getName();
                IIIIIIII(iIIlIIlI.IIIIIIII);
            }
            IIIIIIII(0);
        }
    }

    public final long IIIIIIlI() {
        if (this.IIIIIllI == 0) {
            if (this.IIIIIlII == null) {
                this.IIIIIlII = this.IIIIIIlI.getSharedPreferences(IIIIllIl, 0);
            }
            this.IIIIIllI = this.IIIIIlII.getLong(String.valueOf(IIIIIIII()), 0);
        }
        return this.IIIIIllI;
    }

    public abstract Object IIIIIIll();

    public boolean IIIIIlII() {
        try {
            C6313i1.IIIIIIlI(this.IIIIIIll);
            return C6313i1.IIIIIIIl(this.IIIIIIll) < 10485760;
        } catch (FileNotFoundException unused) {
            return true;
        }
    }

    public abstract void IIIIIlIl();

    public abstract void IIIIIllI();

    public void IIIIIlll() {
        if (this.IIIIIlll) {
            IIIIIIII();
            IIlllllI iIlllllI = this.IIIIllII;
            if (iIlllllI == null || iIlllllI.IIIIIIII.isShutdown()) {
                IIIIIIII(new IIlllIII(), 0);
            } else {
                this.IIIIllII.execute(new IIIIIIlI());
            }
            this.IIIIIlll = false;
            this.IIIIIIII = null;
        }
    }

    public void IIIIlIII() {
        IIIIIIII(0);
    }

    public void IIIIIIII(Runnable runnable) {
        IIIIIIII();
        IIlllllI iIlllllI = this.IIIIllII;
        if (iIlllllI == null || iIlllllI.IIIIIIII.isShutdown()) {
            IIIIIIII(new IIlllIII(), 0);
        } else {
            this.IIIIllII.execute(new IIIIIIll(runnable));
        }
    }

    public final void IIIIIIII(long j) {
        if (this.IIIIIlIl == null) {
            this.IIIIIlIl = IIIIIIIl().edit();
        }
        this.IIIIIlIl.putLong(String.valueOf(IIIIIIII()), j).commit();
        this.IIIIIllI = j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean IIIIIIII(p118io.presage.core.IIlllllI r11, java.io.File r12, p118io.presage.core.IIllllll.IIIIIlII r13) {
        /*
            r10 = this;
            if (r12 == 0) goto L_0x0065
            boolean r0 = r10.IIIIIlll
            r1 = 0
            if (r0 != 0) goto L_0x0064
            long r2 = r10.IIIIlIIl
            r4 = 0
            r0 = 1
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 > 0) goto L_0x0011
            goto L_0x0034
        L_0x0011:
            long r2 = r10.IIIIIIlI()
            long r4 = java.lang.System.currentTimeMillis()
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 > 0) goto L_0x0034
            long r2 = java.lang.System.currentTimeMillis()
            long r4 = r10.IIIIIIlI()
            long r6 = r10.IIIIlIIl
            r8 = 3600000(0x36ee80, double:1.7786363E-317)
            long r6 = r6 * r8
            long r6 = r6 + r4
            int r4 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r4 <= 0) goto L_0x0032
            goto L_0x0034
        L_0x0032:
            r2 = 0
            goto L_0x0035
        L_0x0034:
            r2 = 1
        L_0x0035:
            if (r2 != 0) goto L_0x0038
            goto L_0x0064
        L_0x0038:
            r10.IIIIIIII()
            r10.IIIIIlll = r0
            r10.IIIIIIll = r12
            r10.IIIIIIII = r13
            r10.IIIIllII = r11
            if (r11 == 0) goto L_0x0058
            java.util.concurrent.ExecutorService r11 = r11.IIIIIIII
            boolean r11 = r11.isShutdown()
            if (r11 != 0) goto L_0x0058
            io.presage.core.IIlllllI r11 = r10.IIIIllII
            io.presage.core.IIllllll$IIIIIIIl r12 = new io.presage.core.IIllllll$IIIIIIIl
            r12.<init>()
            r11.execute(r12)
            goto L_0x0063
        L_0x0058:
            io.presage.core.IIlllIII r11 = new io.presage.core.IIlllIII
            r11.<init>()
            r10.IIIIIIII(r11, r1)
            r10.IIIIIIII((int) r1)
        L_0x0063:
            return r0
        L_0x0064:
            return r1
        L_0x0065:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            r11.<init>()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: p118io.presage.core.IIllllll.IIIIIIII(io.presage.core.IIlllllI, java.io.File, io.presage.core.IIllllll$IIIIIlII):boolean");
    }
}
