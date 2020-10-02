package p118io.presage.core;

import android.content.Context;
import android.os.Build;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Iterator;
import p118io.presage.core.lIlIIlll;

/* renamed from: io.presage.core.lIlIIlIl */
public class lIlIIlIl {
    public static final String IIIIIllI = C6375y.IIIIIIII;
    public static final String IIIIIlll = C6375y.IIIIIIIl;
    public static final String IIIIlIII = C6375y.IIIIIIlI;
    public static final String IIIIlIIl = C6347r.IIIIIIII;
    public static final String IIIIlIlI = lllIIllI.IIIIIIII;
    public Context IIIIIIII;
    public boolean IIIIIIIl = false;
    public IIIIIIII IIIIIIlI;
    public IIllllII IIIIIIll;
    public boolean IIIIIlII;
    public lIlIlIII IIIIIlIl;

    public lIlIIlIl(Context context) {
        this.IIIIIIII = context;
    }

    public final File IIIIIIII() {
        return Build.VERSION.SDK_INT >= 21 ? new File(this.IIIIIIII.getNoBackupFilesDir(), IIIIlIlI) : new File(this.IIIIIIII.getFilesDir(), IIIIlIlI);
    }

    public void IIIIIIII(int i, lIlIlIII lililiii, IIllllII iIllllII, boolean z) {
        if (!this.IIIIIIIl) {
            Thread.currentThread().getName();
            this.IIIIIIIl = true;
            this.IIIIIlIl = lililiii;
            this.IIIIIIll = iIllllII;
            this.IIIIIlII = z;
            IIIIIIII iiiiiiii = new IIIIIIII(i, iIllllII, z);
            this.IIIIIIlI = iiiiiiii;
            this.IIIIIIll.execute(iiiiiiii);
        }
    }

    /* renamed from: io.presage.core.lIlIIlIl$IIIIIIII */
    public class IIIIIIII implements Runnable {
        public int IIIIIIII;
        public IIllllII IIIIIIIl;
        public boolean IIIIIIlI;
        public ServerSocket IIIIIIll;
        public boolean IIIIIlII;
        public ArrayList<lIlIIlll> IIIIIlIl = new ArrayList<>();
        public ArrayList<lIlIlIIl> IIIIIllI = new ArrayList<>();

        /* renamed from: io.presage.core.lIlIIlIl$IIIIIIII$IIIIIIII  reason: collision with other inner class name */
        public class C6858IIIIIIII implements lIlIIlll.IIIIIIII {
            public final /* synthetic */ InputStream IIIIIIII;
            public final /* synthetic */ OutputStream IIIIIIIl;
            public final /* synthetic */ Socket IIIIIIlI;

            public C6858IIIIIIII(IIIIIIII iiiiiiii, InputStream inputStream, OutputStream outputStream, Socket socket) {
                this.IIIIIIII = inputStream;
                this.IIIIIIIl = outputStream;
                this.IIIIIIlI = socket;
            }

            public void IIIIIIII() {
                try {
                    this.IIIIIIII.close();
                    this.IIIIIIIl.close();
                    this.IIIIIIlI.close();
                } catch (IOException unused) {
                }
            }
        }

        public IIIIIIII(int i, IIllllII iIllllII, boolean z) {
            this.IIIIIIII = i;
            this.IIIIIIIl = iIllllII;
            this.IIIIIIlI = z;
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x005e  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00df  */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x011b  */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x0128  */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x0148 A[RETURN] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final p118io.presage.core.lIIIlllI IIIIIIII(java.io.InputStream r14) {
            /*
                r13 = this;
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.getName()
                java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
                r0.<init>()
                int r1 = r14.read()
                r2 = 10
                r3 = 1
                r4 = -1
                r5 = 0
                r6 = 0
                r7 = 65
                if (r1 < r7) goto L_0x001e
                r7 = 90
                if (r1 <= r7) goto L_0x0026
            L_0x001e:
                r7 = 97
                if (r1 < r7) goto L_0x005b
                r7 = 122(0x7a, float:1.71E-43)
                if (r1 > r7) goto L_0x005b
            L_0x0026:
                r0.write(r1)
                int r1 = r14.read()
                if (r1 == r2) goto L_0x0032
                if (r1 == r4) goto L_0x0032
                goto L_0x0026
            L_0x0032:
                r0.close()
                java.lang.String r0 = r0.toString()
                java.lang.String r0 = r0.trim()
                java.lang.String r1 = " "
                java.lang.String[] r0 = r0.split(r1)
                int r1 = r0.length
                r7 = 3
                if (r1 == r7) goto L_0x0048
                goto L_0x005b
            L_0x0048:
                r1 = r0[r6]
                r1 = r0[r3]
                r1 = 2
                r7 = r0[r1]
                io.presage.core.lIIIllll r7 = new io.presage.core.lIIIllll
                r8 = r0[r6]
                r9 = r0[r3]
                r0 = r0[r1]
                r7.<init>(r8, r9, r0)
                goto L_0x005c
            L_0x005b:
                r7 = r5
            L_0x005c:
                if (r7 == 0) goto L_0x0148
                java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
                r0.<init>()
            L_0x0063:
                java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
                r1.<init>()
            L_0x0068:
                int r5 = r14.read()
                if (r5 == r2) goto L_0x0074
                if (r5 == r4) goto L_0x0074
                r1.write(r5)
                goto L_0x0068
            L_0x0074:
                r1.close()
                java.lang.String r1 = r1.toString()
                java.lang.String r1 = r1.trim()
                if (r1 == 0) goto L_0x00ad
                java.lang.String r5 = p118io.presage.core.lIlIIlIl.IIIIlIIl
                boolean r5 = r1.contains(r5)
                if (r5 == 0) goto L_0x00a3
                java.lang.String r5 = p118io.presage.core.lIlIIlIl.IIIIlIIl
                int r5 = r1.indexOf(r5)
                java.lang.String r8 = r1.substring(r6, r5)
                java.lang.String r8 = r8.trim()
                int r5 = r5 + r3
                java.lang.String r5 = r1.substring(r5)
                java.lang.String r5 = r5.trim()
                r0.put(r8, r5)
            L_0x00a3:
                java.lang.String r1 = r1.trim()
                boolean r1 = r1.isEmpty()
                if (r1 == 0) goto L_0x0063
            L_0x00ad:
                io.presage.core.lIlIIllI r1 = new io.presage.core.lIlIIllI
                r1.<init>(r13, r0)
                java.util.Map r0 = r1.IIIIIIII()
                java.util.Set r0 = r0.keySet()
                java.lang.String r2 = p118io.presage.core.lIlIIlIl.IIIIIllI
                boolean r0 = r0.contains(r2)
                r2 = 0
                if (r0 == 0) goto L_0x00d5
                java.util.Map r0 = r1.IIIIIIII()     // Catch:{ NumberFormatException -> 0x00d5 }
                java.lang.String r5 = p118io.presage.core.lIlIIlIl.IIIIIllI     // Catch:{ NumberFormatException -> 0x00d5 }
                java.lang.Object r0 = r0.get(r5)     // Catch:{ NumberFormatException -> 0x00d5 }
                java.lang.String r0 = (java.lang.String) r0     // Catch:{ NumberFormatException -> 0x00d5 }
                long r8 = java.lang.Long.parseLong(r0)     // Catch:{ NumberFormatException -> 0x00d5 }
                goto L_0x00d6
            L_0x00d5:
                r8 = r2
            L_0x00d6:
                java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
                r0.<init>()
                int r5 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
                if (r5 <= 0) goto L_0x00f5
                r5 = 2048(0x800, float:2.87E-42)
                byte[] r5 = new byte[r5]     // Catch:{ all -> 0x00f3 }
            L_0x00e3:
                int r10 = r14.read(r5)     // Catch:{ all -> 0x00f3 }
                if (r10 == r4) goto L_0x00f5
                long r11 = (long) r10     // Catch:{ all -> 0x00f3 }
                long r2 = r2 + r11
                r0.write(r5, r6, r10)     // Catch:{ all -> 0x00f3 }
                int r10 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
                if (r10 < 0) goto L_0x00e3
                goto L_0x00f5
            L_0x00f3:
                r14 = move-exception
                throw r14
            L_0x00f5:
                r0.close()
                byte[] r14 = r0.toByteArray()
                java.lang.String r0 = new java.lang.String
                r0.<init>(r14)
                java.lang.String r0 = r7.IIIIIIIl
                java.lang.String r2 = p118io.presage.core.lIlIIlIl.IIIIlIII
                boolean r0 = r0.contains(r2)
                if (r0 != 0) goto L_0x0128
                java.util.Map r0 = r1.IIIIIIII()
                java.util.Set r0 = r0.keySet()
                java.lang.String r2 = p118io.presage.core.lIlIIlIl.IIIIIlll
                boolean r0 = r0.contains(r2)
                if (r0 == 0) goto L_0x0128
                java.util.Map r0 = r1.IIIIIIII()
                java.lang.String r2 = p118io.presage.core.lIlIIlIl.IIIIIlll
                java.lang.Object r0 = r0.get(r2)
                java.lang.String r0 = (java.lang.String) r0
                goto L_0x012a
            L_0x0128:
                java.lang.String r0 = ""
            L_0x012a:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                r2.append(r0)
                java.lang.String r0 = r7.IIIIIIIl
                r2.append(r0)
                java.lang.String r0 = r2.toString()
                io.presage.core.lIIIlllI r2 = new io.presage.core.lIIIlllI
                java.lang.String r3 = r7.IIIIIIII
                java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream
                r4.<init>(r14)
                r2.<init>(r0, r3, r1, r4)
                return r2
            L_0x0148:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: p118io.presage.core.lIlIIlIl.IIIIIIII.IIIIIIII(java.io.InputStream):io.presage.core.lIIIlllI");
        }

        public void run() {
            Thread.currentThread().getName();
            IIllllII iIllllII = this.IIIIIIIl;
            boolean z = this.IIIIIIlI;
            Thread.currentThread().getName();
            lIlIIlIl liliilil = lIlIIlIl.this;
            ArrayList<lIlIlIIl> IIIIIIII2 = liliilil.IIIIIlIl.IIIIIIII(liliilil.IIIIIIII());
            this.IIIIIllI = IIIIIIII2;
            Iterator<lIlIlIIl> it = IIIIIIII2.iterator();
            while (it.hasNext()) {
                lIllIllI lillilli = (lIllIllI) it.next();
                lillilli.IIIIIIll = iIllllII;
                lillilli.IIIIIlII = z;
                lillilli.IIIIIIIl.IIIIIIII(iIllllII, lillilli.IIIIIIII);
            }
            try {
                ServerSocket serverSocket = new ServerSocket(this.IIIIIIII);
                this.IIIIIIll = serverSocket;
                serverSocket.setSoTimeout(0);
                this.IIIIIlII = false;
                while (!this.IIIIIlII && !this.IIIIIIll.isClosed()) {
                    Thread.currentThread().getName();
                    Socket accept = this.IIIIIIll.accept();
                    accept.setSoTimeout(1000);
                    if (!this.IIIIIlII) {
                        Thread.currentThread().getName();
                        InputStream inputStream = accept.getInputStream();
                        OutputStream outputStream = accept.getOutputStream();
                        lIIIlllI liiillli = null;
                        try {
                            liiillli = IIIIIIII(inputStream);
                        } catch (SocketTimeoutException e) {
                            e.getMessage();
                        }
                        lIlIIlll IIIIIIII3 = lIlIIlIl.this.IIIIIlIl.IIIIIIII(liiillli, outputStream, lIlIIlIl.this.IIIIIIII());
                        this.IIIIIlIl.add(IIIIIIII3);
                        IIIIIIII3.IIIIIIII(this.IIIIIIIl, this.IIIIIIlI, new C6858IIIIIIII(this, inputStream, outputStream, accept));
                    }
                }
            } catch (BindException e2) {
                e2.getMessage();
                IIIIIIII();
            } catch (SocketException e3) {
                e3.getMessage();
            } catch (IOException unused) {
                IIIIIIII();
            }
        }

        public void IIIIIIII() {
            Thread.currentThread().getName();
            this.IIIIIlII = true;
            try {
                if (this.IIIIIIll != null) {
                    this.IIIIIIll.close();
                }
                Iterator<lIlIIlll> it = this.IIIIIlIl.iterator();
                while (it.hasNext()) {
                    it.next().IIIIIIII();
                }
                Iterator<lIlIlIIl> it2 = this.IIIIIllI.iterator();
                while (it2.hasNext()) {
                    ((lIllIllI) it2.next()).IIIIIIIl.IIIIIIll();
                }
            } catch (IOException unused) {
            }
        }
    }
}
