package p118io.presage.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ChangedPackages;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import com.ogury.p159cm.OguryChoiceManager;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* renamed from: io.presage.core.IlIlIlll */
public class IlIlIlll extends IIllllll {
    public static final String IIIlIIII = lllIlIIl.IIIIIIII;
    public static final String IIIlIIIl = C6292d0.IIIIIIII;
    public BroadcastReceiver IIIIlllI;
    public IIIIIIIl IIIIllll = new IIIIIIIl(this);

    /* renamed from: io.presage.core.IlIlIlll$IIIIIIII */
    public class IIIIIIII extends BroadcastReceiver {

        /* renamed from: io.presage.core.IlIlIlll$IIIIIIII$IIIIIIII  reason: collision with other inner class name */
        public class C6856IIIIIIII implements Runnable {
            public C6856IIIIIIII() {
            }

            public void run() {
                IlIlIlll.this.IIIIlIIl();
            }
        }

        public IIIIIIII() {
        }

        public void onReceive(Context context, Intent intent) {
            IlIlIlll.this.IIIIIIII((Runnable) new C6856IIIIIIII());
        }
    }

    /* renamed from: io.presage.core.IlIlIlll$IIIIIIIl */
    public class IIIIIIIl {
        public int IIIIIIII;
        public int IIIIIIIl;
        public Map<String, IIlIIlII> IIIIIIlI;

        public IIIIIIIl(IlIlIlll ilIlIlll) {
            HashMap hashMap = new HashMap();
            this.IIIIIIII = 0;
            this.IIIIIIIl = 0;
            this.IIIIIIlI = hashMap;
        }

        public IIIIIIIl(IlIlIlll ilIlIlll, int i, int i2, Map<String, IIlIIlII> map) {
            this.IIIIIIII = i;
            this.IIIIIIIl = i2;
            this.IIIIIIlI = map;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0008, code lost:
            r0 = r1.IIIIIIlI;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean IIIIIIII() {
            /*
                r1 = this;
                int r0 = r1.IIIIIIII
                if (r0 != 0) goto L_0x0014
                int r0 = r1.IIIIIIIl
                if (r0 != 0) goto L_0x0014
                java.util.Map<java.lang.String, io.presage.core.IIlIIlII> r0 = r1.IIIIIIlI
                if (r0 == 0) goto L_0x0012
                boolean r0 = r0.isEmpty()
                if (r0 == 0) goto L_0x0014
            L_0x0012:
                r0 = 1
                goto L_0x0015
            L_0x0014:
                r0 = 0
            L_0x0015:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p118io.presage.core.IlIlIlll.IIIIIIIl.IIIIIIII():boolean");
        }

        public IIIIIIIl(IlIlIlll ilIlIlll, Map<String, IIlIIlII> map) {
            this.IIIIIIII = 0;
            this.IIIIIIIl = 0;
            this.IIIIIIlI = map;
        }
    }

    public IlIlIlll(Context context, int i, long j, long j2) {
        super(context, i, j, j2);
    }

    public int IIIIIIII() {
        return 9;
    }

    public IIlIlIlI IIIIIIII(IIIIIIIl iIIIIIIl, IIIIIIIl iIIIIIIl2) {
        HashSet hashSet;
        Map<String, IIlIIlII> map;
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        if (iIIIIIIl == null || iIIIIIIl2 == null || iIIIIIIl2.IIIIIIII()) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (iIIIIIIl2.IIIIIIII > iIIIIIIl.IIIIIIII) {
                iIIIIIIl.IIIIIIIl = 0;
            }
            ChangedPackages changedPackages = this.IIIIIIlI.getPackageManager().getChangedPackages(iIIIIIIl.IIIIIIIl);
            if (changedPackages == null) {
                iIIIIIIl2.IIIIIIIl = iIIIIIIl.IIIIIIIl;
                return null;
            }
            iIIIIIIl2.IIIIIIIl = changedPackages.getSequenceNumber();
            for (String next : changedPackages.getPackageNames()) {
                if (iIIIIIIl2.IIIIIIlI.containsKey(next)) {
                    IIlIIlII iIlIIlII = iIIIIIIl2.IIIIIIlI.get(next);
                    if (!iIIIIIIl.IIIIIIlI.containsKey(next) || iIlIIlII.IIIIIIlI == iIlIIlII.IIIIIIll) {
                        map = iIIIIIIl2.IIIIIIlI;
                        hashSet = hashSet2;
                    } else {
                        map = iIIIIIIl2.IIIIIIlI;
                        hashSet = hashSet3;
                    }
                    hashSet.add(map.get(next));
                } else {
                    hashSet4.add(next);
                }
            }
        } else {
            for (String next2 : iIIIIIIl2.IIIIIIlI.keySet()) {
                if (!iIIIIIIl.IIIIIIlI.containsKey(next2)) {
                    hashSet2.add(iIIIIIIl2.IIIIIIlI.get(next2));
                } else {
                    IIlIIlII iIlIIlII2 = iIIIIIIl2.IIIIIIlI.get(next2);
                    if (iIlIIlII2.IIIIIIll > iIIIIIIl.IIIIIIlI.get(next2).IIIIIIll) {
                        hashSet3.add(iIlIIlII2);
                    }
                }
            }
            for (String next3 : iIIIIIIl.IIIIIIlI.keySet()) {
                if (!iIIIIIIl2.IIIIIIlI.containsKey(next3)) {
                    hashSet4.add(next3);
                }
            }
        }
        if (!hashSet2.isEmpty() || !hashSet3.isEmpty() || !hashSet4.isEmpty()) {
            return new IIlIlIlI(C6325l1.IIIIIIII(), hashSet2, hashSet3, hashSet4);
        }
        return null;
    }

    public Object IIIIIIll() {
        return IlIlIlll.class;
    }

    public void IIIIIlIl() {
        BroadcastReceiver broadcastReceiver = this.IIIIlllI;
        if (broadcastReceiver != null) {
            try {
                this.IIIIIIlI.unregisterReceiver(broadcastReceiver);
            } catch (IllegalArgumentException unused) {
            }
            this.IIIIlllI = null;
        }
        this.IIIIlllI = new IIIIIIII();
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_CHANGED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme(IIIlIIIl);
        this.IIIIIIlI.registerReceiver(this.IIIIlllI, intentFilter);
        IIIIlIIl();
    }

    public void IIIIIllI() {
        BroadcastReceiver broadcastReceiver = this.IIIIlllI;
        if (broadcastReceiver != null) {
            try {
                this.IIIIIIlI.unregisterReceiver(broadcastReceiver);
            } catch (IllegalArgumentException unused) {
            }
            this.IIIIlllI = null;
        }
        this.IIIIllll = new IIIIIIIl(this);
    }

    public final void IIIIlIIl() {
        if (this.IIIIIlll) {
            try {
                if (this.IIIIllll.IIIIIIII()) {
                    this.IIIIllll = IIIIlIll();
                }
                IIIIIIIl IIIIlIlI = IIIIlIlI();
                IIlIlIlI IIIIIIII2 = IIIIIIII(this.IIIIllll, IIIIlIlI);
                if (IIIIIIII2 != null) {
                    IIIIIIII((IIIlIIlI) IIIIIIII2);
                }
                if (!IIIIlIlI.IIIIIIII()) {
                    this.IIIIllll = IIIIIIII(IIIIlIlI);
                }
            } catch (lIlllIII unused) {
                IIIIIIII(0);
            }
        }
    }

    public final IIIIIIIl IIIIlIlI() {
        int i = Build.VERSION.SDK_INT >= 26 ? Settings.Global.getInt(this.IIIIIIlI.getContentResolver(), "boot_count", -1) : -1;
        HashMap hashMap = new HashMap();
        HashSet<String> IIIIIIll = IIIIlIll.IIIIIIll(this.IIIIIIlI);
        if (!IIIIIIll.isEmpty()) {
            try {
                for (PackageInfo next : IIIIlIll.IIIIIIlI(this.IIIIIIlI)) {
                    try {
                        hashMap.put(next.packageName, new IIlIIlII(next, (this.IIIIIIlI.getPackageManager().getApplicationInfo(next.packageName, OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE).flags & 129) != 0, IIIIIIll.contains(this.IIIIIIlI.getPackageName())));
                    } catch (PackageManager.NameNotFoundException e) {
                        IIIIIIII(e, 0);
                    }
                }
                if (!hashMap.isEmpty()) {
                    return new IIIIIIIl(this, i, -1, hashMap);
                }
            } catch (Exception e2) {
                IIIIIIII(e2, 1);
            }
        }
        return new IIIIIIIl(this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00c9, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00cd, code lost:
        if (r4 != null) goto L_0x00dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00d0, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00d1, code lost:
        IIIIIIII(r0, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00d6, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00d7, code lost:
        IIIIIIII(r0, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00db, code lost:
        if (r4 != null) goto L_0x00dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00dd, code lost:
        p118io.presage.core.C6313i1.IIIIIIII(r4);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00d0 A[ExcHandler: FileNotFoundException (r0v2 'e' java.io.FileNotFoundException A[CUSTOM_DECLARE]), Splitter:B:1:0x0004] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00d6 A[ExcHandler: EOFException (r0v1 'e' java.io.EOFException A[CUSTOM_DECLARE]), PHI: r4 
      PHI: (r4v2 java.io.File) = (r4v0 java.io.File), (r4v4 java.io.File), (r4v4 java.io.File) binds: [B:1:0x0004, B:9:0x002a, B:22:0x00bd] A[DONT_GENERATE, DONT_INLINE], Splitter:B:1:0x0004] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final p118io.presage.core.IlIlIlll.IIIIIIIl IIIIlIll() {
        /*
            r24 = this;
            r1 = r24
            r2 = 1
            r4 = 0
            java.lang.String r0 = IIIlIIII     // Catch:{ EOFException -> 0x00d6, FileNotFoundException -> 0x00d0, IOException -> 0x00c9 }
            java.io.File r4 = r1.IIIIIIII((java.lang.String) r0)     // Catch:{ EOFException -> 0x00d6, FileNotFoundException -> 0x00d0, IOException -> 0x00c9 }
            boolean r0 = r4.exists()     // Catch:{ EOFException -> 0x00d6, FileNotFoundException -> 0x00d0, IOException -> 0x00c9 }
            if (r0 == 0) goto L_0x00e0
            long r5 = r4.length()     // Catch:{ EOFException -> 0x00d6, FileNotFoundException -> 0x00d0, IOException -> 0x00c9 }
            r7 = 0
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x00e0
            boolean r0 = r4.canRead()     // Catch:{ EOFException -> 0x00d6, FileNotFoundException -> 0x00d0, IOException -> 0x00c9 }
            if (r0 == 0) goto L_0x00e0
            java.io.DataInputStream r5 = new java.io.DataInputStream     // Catch:{ EOFException -> 0x00d6, FileNotFoundException -> 0x00d0, IOException -> 0x00c9 }
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ EOFException -> 0x00d6, FileNotFoundException -> 0x00d0, IOException -> 0x00c9 }
            r0.<init>(r4)     // Catch:{ EOFException -> 0x00d6, FileNotFoundException -> 0x00d0, IOException -> 0x00c9 }
            r5.<init>(r0)     // Catch:{ EOFException -> 0x00d6, FileNotFoundException -> 0x00d0, IOException -> 0x00c9 }
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x00c1 }
            r0.<init>()     // Catch:{ all -> 0x00c1 }
            short r6 = r5.readShort()     // Catch:{ all -> 0x00c1 }
            int r7 = r5.readInt()     // Catch:{ all -> 0x00c1 }
            int r8 = r5.readInt()     // Catch:{ all -> 0x00c1 }
            if (r6 == r2) goto L_0x0074
            r9 = 2
            if (r6 == r9) goto L_0x0042
            goto L_0x00b8
        L_0x0042:
            boolean r6 = r5.readBoolean()     // Catch:{ all -> 0x00c1 }
            if (r6 == 0) goto L_0x00b8
            java.lang.String r6 = r5.readUTF()     // Catch:{ all -> 0x00c1 }
            int r11 = r5.readInt()     // Catch:{ all -> 0x00c1 }
            long r12 = r5.readLong()     // Catch:{ all -> 0x00c1 }
            long r14 = r5.readLong()     // Catch:{ all -> 0x00c1 }
            boolean r16 = r5.readBoolean()     // Catch:{ all -> 0x00c1 }
            boolean r17 = r5.readBoolean()     // Catch:{ all -> 0x00c1 }
            java.lang.String r18 = r5.readUTF()     // Catch:{ all -> 0x00c1 }
            long r19 = r5.readLong()     // Catch:{ all -> 0x00c1 }
            io.presage.core.IIlIIlII r10 = new io.presage.core.IIlIIlII     // Catch:{ all -> 0x00c1 }
            r9 = r10
            r3 = r10
            r10 = r6
            r9.<init>(r10, r11, r12, r14, r16, r17, r18, r19)     // Catch:{ all -> 0x00c1 }
            r0.put(r6, r3)     // Catch:{ all -> 0x00c1 }
            goto L_0x0042
        L_0x0074:
            int r3 = r5.readInt()     // Catch:{ all -> 0x00c1 }
            r6 = 0
        L_0x0079:
            if (r6 >= r3) goto L_0x00b8
            java.lang.String r14 = r5.readUTF()     // Catch:{ all -> 0x00c1 }
            int r11 = r5.readInt()     // Catch:{ all -> 0x00c1 }
            long r12 = r5.readLong()     // Catch:{ all -> 0x00c1 }
            long r15 = r5.readLong()     // Catch:{ all -> 0x00c1 }
            boolean r17 = r5.readBoolean()     // Catch:{ all -> 0x00c1 }
            boolean r18 = r5.readBoolean()     // Catch:{ all -> 0x00c1 }
            java.lang.String r19 = r5.readUTF()     // Catch:{ all -> 0x00c1 }
            long r21 = r5.readLong()     // Catch:{ all -> 0x00c1 }
            io.presage.core.IIlIIlII r10 = new io.presage.core.IIlIIlII     // Catch:{ all -> 0x00c1 }
            r9 = r10
            r2 = r10
            r10 = r14
            r23 = r3
            r3 = r14
            r14 = r15
            r16 = r17
            r17 = r18
            r18 = r19
            r19 = r21
            r9.<init>(r10, r11, r12, r14, r16, r17, r18, r19)     // Catch:{ all -> 0x00c1 }
            r0.put(r3, r2)     // Catch:{ all -> 0x00c1 }
            int r6 = r6 + 1
            r3 = r23
            r2 = 1
            goto L_0x0079
        L_0x00b8:
            io.presage.core.IlIlIlll$IIIIIIIl r2 = new io.presage.core.IlIlIlll$IIIIIIIl     // Catch:{ all -> 0x00c1 }
            r2.<init>(r1, r7, r8, r0)     // Catch:{ all -> 0x00c1 }
            r5.close()     // Catch:{ EOFException -> 0x00d6, FileNotFoundException -> 0x00d0, IOException -> 0x00c6 }
            return r2
        L_0x00c1:
            r0 = move-exception
            r5.close()     // Catch:{ EOFException -> 0x00d6, FileNotFoundException -> 0x00d0, IOException -> 0x00c6 }
            throw r0     // Catch:{ EOFException -> 0x00d6, FileNotFoundException -> 0x00d0, IOException -> 0x00c6 }
        L_0x00c6:
            r0 = move-exception
            r2 = 1
            goto L_0x00ca
        L_0x00c9:
            r0 = move-exception
        L_0x00ca:
            r1.IIIIIIII(r0, r2)
            if (r4 == 0) goto L_0x00e0
            goto L_0x00dd
        L_0x00d0:
            r0 = move-exception
            r2 = 0
            r1.IIIIIIII(r0, r2)
            goto L_0x00e0
        L_0x00d6:
            r0 = move-exception
            r2 = 0
            r1.IIIIIIII(r0, r2)
            if (r4 == 0) goto L_0x00e0
        L_0x00dd:
            p118io.presage.core.C6313i1.IIIIIIII(r4)
        L_0x00e0:
            io.presage.core.IlIlIlll$IIIIIIIl r0 = new io.presage.core.IlIlIlll$IIIIIIIl
            io.presage.core.IlIlIlll$IIIIIIIl r2 = r24.IIIIlIlI()
            java.util.Map<java.lang.String, io.presage.core.IIlIIlII> r2 = r2.IIIIIIlI
            r0.<init>(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p118io.presage.core.IlIlIlll.IIIIlIll():io.presage.core.IlIlIlll$IIIIIIIl");
    }

    public final IIIIIIIl IIIIIIII(IIIIIIIl iIIIIIIl) {
        DataOutputStream dataOutputStream;
        if (!IIIIIlII()) {
            if (iIIIIIIl == null) {
                iIIIIIIl = new IIIIIIIl(this);
            }
            File file = null;
            try {
                file = IIIIIIII(IIIlIIII);
                if (!file.exists() || (file.exists() && file.canWrite())) {
                    dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
                    dataOutputStream.writeShort(2);
                    dataOutputStream.writeInt(iIIIIIIl.IIIIIIII);
                    dataOutputStream.writeInt(iIIIIIIl.IIIIIIIl);
                    for (String str : iIIIIIIl.IIIIIIlI.keySet()) {
                        IIlIIlII iIlIIlII = iIIIIIIl.IIIIIIlI.get(str);
                        if (iIlIIlII != null) {
                            dataOutputStream.writeBoolean(true);
                            dataOutputStream.writeUTF(iIlIIlII.IIIIIIII);
                            dataOutputStream.writeInt(iIlIIlII.IIIIIIIl);
                            dataOutputStream.writeLong(iIlIIlII.IIIIIIlI);
                            dataOutputStream.writeLong(iIlIIlII.IIIIIIll);
                            dataOutputStream.writeBoolean(iIlIIlII.IIIIIlII);
                            dataOutputStream.writeBoolean(iIlIIlII.IIIIIlIl);
                            dataOutputStream.writeUTF(iIlIIlII.IIIIIllI);
                            dataOutputStream.writeLong(iIlIIlII.IIIIIlll);
                            dataOutputStream.flush();
                        }
                    }
                    dataOutputStream.writeBoolean(false);
                    dataOutputStream.close();
                }
            } catch (FileNotFoundException e) {
                IIIIIIII(e, 0);
            } catch (IOException e2) {
                IIIIIIII(e2, 1);
                if (file != null) {
                    C6313i1.IIIIIIII(file);
                }
            } catch (Throwable th) {
                dataOutputStream.close();
                throw th;
            }
            return iIIIIIIl;
        }
        throw new lIlllIII();
    }
}
