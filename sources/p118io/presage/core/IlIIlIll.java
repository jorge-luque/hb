package p118io.presage.core;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.IBinder;
import android.os.Parcel;
import com.ogury.p159cm.OguryChoiceManager;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: io.presage.core.IlIIlIll */
public class IlIIlIll extends IlIIIlll {
    public static final String IIIlIIlI = llllllII.IIIIIIII;
    public static final String IIIlIIll = llllllII.IIIIIIIl;
    public static final String IIIlIlII = llllllII.IIIIIIlI;
    public static final String IIIlIlIl = lllIIIIl.IIIIIIII;
    public static IBinder IIIlIllI;
    public static String IIIlIlll;
    public HashMap<Integer, IIIlIllI> IIIlIIIl = new HashMap<>();

    public IlIIlIll(Context context, int i, long j, long j2) {
        super(context, i, j, j2);
    }

    public int IIIIIIII() {
        return 12;
    }

    public final long IIIIIIII(int i, int i2) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(IIIIllII());
            obtain.writeInt(i);
            obtain.writeInt(i2);
            if (IIIIllIl().transact(11, obtain, obtain2, 0)) {
                obtain2.readInt();
                return obtain2.readLong();
            }
            obtain.recycle();
            obtain2.recycle();
            return -1;
        } finally {
            obtain.recycle();
            obtain2.recycle();
        }
    }

    public final void IIIIIIII(HashMap<Integer, IIIlIllI> hashMap, HashMap<Integer, IIIlIllI> hashMap2) {
        if (hashMap != null && hashMap2 != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (Integer next : hashMap2.keySet()) {
                IIIlIllI iIIlIllI = hashMap2.get(next);
                if (!hashMap.containsKey(next)) {
                    if (iIIlIllI.IIIIIIlI <= 0 && iIIlIllI.IIIIIIll <= 0 && iIIlIllI.IIIIIlII <= 0 && iIIlIllI.IIIIIlIl <= 0) {
                    }
                } else if (hashMap.get(next).equals(iIIlIllI)) {
                }
                arrayList.add(iIIlIllI);
            }
            if (!arrayList.isEmpty()) {
                IIIIIIII((IIIlIIlI) new IIIlIlll(currentTimeMillis, arrayList));
            }
        }
    }

    public Object IIIIIIll() {
        return IlIIlIll.class;
    }

    public void IIIIlIIl() {
        this.IIIlIIIl.clear();
    }

    public void IIIIlIlI() {
        if (Build.VERSION.SDK_INT < 28) {
            IIIIIIII(0);
            return;
        }
        try {
            if (this.IIIlIIIl.isEmpty()) {
                this.IIIlIIIl = IIIIlllI();
            }
            HashMap<Integer, IIIlIllI> IIIIlIll = IIIIlIll();
            IIIIIIII(this.IIIlIIIl, IIIIlIll);
            this.IIIlIIIl = IIIIIIII(IIIIlIll);
        } catch (lIlllIII unused) {
            IIIIIIII(0);
        }
    }

    public final HashMap<Integer, IIIlIllI> IIIIlIll() {
        HashMap<Integer, IIIlIllI> hashMap = new HashMap<>();
        for (ApplicationInfo next : this.IIIIIIlI.getPackageManager().getInstalledApplications(OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE)) {
            try {
                hashMap.put(Integer.valueOf(next.uid), new IIIlIllI(next.uid, next.packageName, IIIIIIII(next.uid, 0), IIIIIIII(next.uid, 1), IIIIIIII(next.uid, 2), IIIIIIII(next.uid, 3)));
            } catch (Exception unused) {
            }
        }
        return hashMap;
    }

    public final String IIIIllII() {
        String str = IIIlIlll;
        if (str != null) {
            return str;
        }
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            if (IIIIllIl().transact(1598968902, obtain, obtain2, 0)) {
                String readString = obtain2.readString();
                IIIlIlll = readString;
                return readString;
            }
            obtain.recycle();
            obtain2.recycle();
            throw new Exception();
        } finally {
            obtain.recycle();
            obtain2.recycle();
        }
    }

    public final IBinder IIIIllIl() {
        IBinder iBinder = IIIlIllI;
        if (iBinder != null) {
            return iBinder;
        }
        IBinder iBinder2 = (IBinder) Class.forName(IIIlIIlI).getDeclaredMethod(IIIlIIll, new Class[]{String.class}).invoke((Object) null, new Object[]{IIIlIlII});
        IIIlIllI = iBinder2;
        return iBinder2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a8, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00af, code lost:
        if (r5 != null) goto L_0x00c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00b2, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b3, code lost:
        IIIIIIII(r0, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b8, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b9, code lost:
        IIIIIIII(r0, 0);
        r2.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c0, code lost:
        if (r5 != null) goto L_0x00c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c2, code lost:
        p118io.presage.core.C6313i1.IIIIIIII(r5);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b2 A[ExcHandler: FileNotFoundException (r0v1 'e' java.io.FileNotFoundException A[CUSTOM_DECLARE]), Splitter:B:1:0x0009] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b8 A[ExcHandler: EOFException (r0v0 'e' java.io.EOFException A[CUSTOM_DECLARE]), PHI: r5 
      PHI: (r5v2 java.io.File) = (r5v0 java.io.File), (r5v4 java.io.File), (r5v4 java.io.File) binds: [B:1:0x0009, B:10:0x0031, B:23:0x009b] A[DONT_GENERATE, DONT_INLINE], Splitter:B:1:0x0009] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.HashMap<java.lang.Integer, p118io.presage.core.IIIlIllI> IIIIlllI() {
        /*
            r19 = this;
            r1 = r19
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r3 = 1
            r5 = 0
            java.lang.String r0 = IIIlIlIl     // Catch:{ EOFException -> 0x00b8, FileNotFoundException -> 0x00b2, IOException -> 0x00a8 }
            java.io.File r5 = r1.IIIIIIII((java.lang.String) r0)     // Catch:{ EOFException -> 0x00b8, FileNotFoundException -> 0x00b2, IOException -> 0x00a8 }
            boolean r0 = r5.exists()     // Catch:{ EOFException -> 0x00b8, FileNotFoundException -> 0x00b2, IOException -> 0x00a8 }
            if (r0 == 0) goto L_0x00a7
            long r6 = r5.length()     // Catch:{ EOFException -> 0x00b8, FileNotFoundException -> 0x00b2, IOException -> 0x00a8 }
            r8 = 0
            int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r0 == 0) goto L_0x00a7
            boolean r0 = r5.canRead()     // Catch:{ EOFException -> 0x00b8, FileNotFoundException -> 0x00b2, IOException -> 0x00a8 }
            if (r0 != 0) goto L_0x0027
            goto L_0x00a7
        L_0x0027:
            java.io.DataInputStream r6 = new java.io.DataInputStream     // Catch:{ EOFException -> 0x00b8, FileNotFoundException -> 0x00b2, IOException -> 0x00a8 }
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ EOFException -> 0x00b8, FileNotFoundException -> 0x00b2, IOException -> 0x00a8 }
            r0.<init>(r5)     // Catch:{ EOFException -> 0x00b8, FileNotFoundException -> 0x00b2, IOException -> 0x00a8 }
            r6.<init>(r0)     // Catch:{ EOFException -> 0x00b8, FileNotFoundException -> 0x00b2, IOException -> 0x00a8 }
            short r0 = r6.readShort()     // Catch:{ all -> 0x009f }
            if (r0 == r3) goto L_0x006a
            r7 = 2
            if (r0 == r7) goto L_0x003b
            goto L_0x009b
        L_0x003b:
            boolean r0 = r6.readBoolean()     // Catch:{ all -> 0x009f }
            if (r0 == 0) goto L_0x009b
            int r8 = r6.readInt()     // Catch:{ all -> 0x009f }
            java.lang.String r9 = r6.readUTF()     // Catch:{ all -> 0x009f }
            long r10 = r6.readLong()     // Catch:{ all -> 0x009f }
            long r12 = r6.readLong()     // Catch:{ all -> 0x009f }
            long r14 = r6.readLong()     // Catch:{ all -> 0x009f }
            long r16 = r6.readLong()     // Catch:{ all -> 0x009f }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x009f }
            io.presage.core.IIIlIllI r7 = new io.presage.core.IIIlIllI     // Catch:{ all -> 0x009f }
            r18 = r7
            r7 = r18
            r7.<init>(r8, r9, r10, r12, r14, r16)     // Catch:{ all -> 0x009f }
            r2.put(r0, r7)     // Catch:{ all -> 0x009f }
            goto L_0x003b
        L_0x006a:
            int r0 = r6.readInt()     // Catch:{ all -> 0x009f }
            r7 = 0
        L_0x006f:
            if (r7 >= r0) goto L_0x009b
            int r9 = r6.readInt()     // Catch:{ all -> 0x009f }
            java.lang.String r10 = r6.readUTF()     // Catch:{ all -> 0x009f }
            long r11 = r6.readLong()     // Catch:{ all -> 0x009f }
            long r13 = r6.readLong()     // Catch:{ all -> 0x009f }
            long r15 = r6.readLong()     // Catch:{ all -> 0x009f }
            long r17 = r6.readLong()     // Catch:{ all -> 0x009f }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x009f }
            io.presage.core.IIIlIllI r4 = new io.presage.core.IIIlIllI     // Catch:{ all -> 0x009f }
            r3 = r8
            r8 = r4
            r8.<init>(r9, r10, r11, r13, r15, r17)     // Catch:{ all -> 0x009f }
            r2.put(r3, r4)     // Catch:{ all -> 0x009f }
            int r7 = r7 + 1
            r3 = 1
            goto L_0x006f
        L_0x009b:
            r6.close()     // Catch:{ EOFException -> 0x00b8, FileNotFoundException -> 0x00b2, IOException -> 0x00a4 }
            goto L_0x00c5
        L_0x009f:
            r0 = move-exception
            r6.close()     // Catch:{ EOFException -> 0x00b8, FileNotFoundException -> 0x00b2, IOException -> 0x00a4 }
            throw r0     // Catch:{ EOFException -> 0x00b8, FileNotFoundException -> 0x00b2, IOException -> 0x00a4 }
        L_0x00a4:
            r0 = move-exception
            r3 = 1
            goto L_0x00a9
        L_0x00a7:
            return r2
        L_0x00a8:
            r0 = move-exception
        L_0x00a9:
            r1.IIIIIIII(r0, r3)
            r2.clear()
            if (r5 == 0) goto L_0x00c5
            goto L_0x00c2
        L_0x00b2:
            r0 = move-exception
            r3 = 0
            r1.IIIIIIII(r0, r3)
            goto L_0x00c5
        L_0x00b8:
            r0 = move-exception
            r3 = 0
            r1.IIIIIIII(r0, r3)
            r2.clear()
            if (r5 == 0) goto L_0x00c5
        L_0x00c2:
            p118io.presage.core.C6313i1.IIIIIIII(r5)
        L_0x00c5:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p118io.presage.core.IlIIlIll.IIIIlllI():java.util.HashMap");
    }

    public final HashMap<Integer, IIIlIllI> IIIIIIII(HashMap<Integer, IIIlIllI> hashMap) {
        DataOutputStream dataOutputStream;
        if (!IIIIIlII()) {
            if (hashMap == null) {
                hashMap = new HashMap<>();
            }
            File file = null;
            try {
                file = IIIIIIII(IIIlIlIl);
                if (!file.exists() || (file.exists() && file.canWrite())) {
                    dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
                    dataOutputStream.writeShort(2);
                    for (Integer num : hashMap.keySet()) {
                        IIIlIllI iIIlIllI = hashMap.get(num);
                        if (iIIlIllI != null) {
                            dataOutputStream.writeBoolean(true);
                            dataOutputStream.writeInt(iIIlIllI.IIIIIIII);
                            dataOutputStream.writeUTF(iIIlIllI.IIIIIIIl);
                            dataOutputStream.writeLong(iIIlIllI.IIIIIIlI);
                            dataOutputStream.writeLong(iIIlIllI.IIIIIIll);
                            dataOutputStream.writeLong(iIIlIllI.IIIIIlII);
                            dataOutputStream.writeLong(iIIlIllI.IIIIIlIl);
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
            return hashMap;
        }
        throw new lIlllIII();
    }
}
