package p118io.presage.core;

import android.content.Context;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: io.presage.core.IlIlllll */
public abstract class IlIlllll extends IlIIIlll {
    public static final String IIIlIIlI = llllIIIl.IIIIIIII;
    public static final String IIIlIIll = C6347r.IIIIIIII;
    public ConcurrentHashMap<Integer, IIllIlII> IIIlIIIl = new ConcurrentHashMap<>();

    public IlIlllll(Context context, int i, long j, long j2) {
        super(context, i, j, j2);
    }

    public abstract IIllIlIl IIIIIIII(long j, int i, String str, String str2, int i2, long j2, long j3);

    public final void IIIIIIII(HashMap<Integer, IIllIlII> hashMap) {
        long currentTimeMillis = System.currentTimeMillis();
        for (Integer intValue : hashMap.keySet()) {
            IIllIlII iIllIlII = hashMap.get(Integer.valueOf(intValue.intValue()));
            if (iIllIlII != null) {
                IIIIIIII((IIIlIIlI) IIIIIIII(currentTimeMillis, iIllIlII.IIIIIIIl, iIllIlII.IIIIIIlI, iIllIlII.IIIIIIll, iIllIlII.IIIIIlII, iIllIlII.IIIIIlIl, iIllIlII.IIIIIllI));
            }
        }
    }

    public abstract String IIIIIIIl(String str);

    public final HashMap<Integer, IIllIlII> IIIIIIIl(HashMap<Integer, IIllIlII> hashMap) {
        DataOutputStream dataOutputStream;
        if (IIIIIlII()) {
            throw new lIlllIII();
        } else if (hashMap == null) {
            return new HashMap<>();
        } else {
            File file = null;
            try {
                file = IIIIIIII(IIIlIIlI);
                if (!file.exists() || (file.exists() && file.canWrite())) {
                    dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
                    dataOutputStream.writeShort(3);
                    for (Integer num : hashMap.keySet()) {
                        IIllIlII iIllIlII = hashMap.get(num);
                        if (iIllIlII != null) {
                            dataOutputStream.writeBoolean(true);
                            dataOutputStream.writeInt(iIllIlII.IIIIIIII);
                            dataOutputStream.writeInt(iIllIlII.IIIIIIIl);
                            dataOutputStream.writeUTF(iIllIlII.IIIIIIlI);
                            dataOutputStream.writeUTF(iIllIlII.IIIIIIll);
                            dataOutputStream.writeInt(iIllIlII.IIIIIlII);
                            dataOutputStream.writeLong(iIllIlII.IIIIIlIl);
                            dataOutputStream.writeLong(iIllIlII.IIIIIllI);
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
    }

    public void IIIIlIIl() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            HashMap hashMap = new HashMap(this.IIIlIIIl);
            for (Integer intValue : hashMap.keySet()) {
                IIllIlII iIllIlII = (IIllIlII) hashMap.get(Integer.valueOf(intValue.intValue()));
                if (iIllIlII != null) {
                    iIllIlII.IIIIIllI = currentTimeMillis;
                }
            }
            IIIIIIIl((HashMap<Integer, IIllIlII>) hashMap);
            this.IIIlIIIl.clear();
        } catch (lIlllIII unused) {
        }
    }

    public void IIIIlIlI() {
        try {
            if (this.IIIlIIIl.isEmpty()) {
                IIIIIIII(IIIIllIl());
                IIIIlllI();
            }
            HashMap<Integer, IIllIlII> IIIIlIll = IIIIlIll();
            HashMap hashMap = new HashMap(this.IIIlIIIl);
            IIIIIIII(hashMap, IIIIlIll);
            for (Integer intValue : IIIIlIll.keySet()) {
                int intValue2 = intValue.intValue();
                if (hashMap.containsKey(Integer.valueOf(intValue2))) {
                    IIllIlII iIllIlII = IIIIlIll.get(Integer.valueOf(intValue2));
                    IIllIlII iIllIlII2 = (IIllIlII) hashMap.get(Integer.valueOf(intValue2));
                    if (!(iIllIlII == null || iIllIlII2 == null)) {
                        iIllIlII.IIIIIlIl = iIllIlII2.IIIIIlIl;
                    }
                }
            }
            this.IIIlIIIl.clear();
            this.IIIlIIIl.putAll(IIIIIIIl(IIIIlIll));
        } catch (lIlllIII unused) {
            IIIIIIII(0);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00d2, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        IIIIIIII(r0, 1);
     */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d2 A[ExcHandler: Exception (r0v7 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:16:0x0040] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.HashMap<java.lang.Integer, p118io.presage.core.IIllIlII> IIIIlIll() {
        /*
            r19 = this;
            r1 = r19
            java.lang.String r2 = "\\s+"
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.io.File r0 = r19.IIIIllII()
            boolean r4 = r0.exists()
            if (r4 == 0) goto L_0x00ee
            boolean r4 = r0.canRead()
            if (r4 != 0) goto L_0x001b
            goto L_0x00ee
        L_0x001b:
            r4 = 0
            r5 = 1
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ FileNotFoundException -> 0x00ea, IOException -> 0x00e5 }
            java.io.InputStreamReader r7 = new java.io.InputStreamReader     // Catch:{ FileNotFoundException -> 0x00ea, IOException -> 0x00e5 }
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x00ea, IOException -> 0x00e5 }
            r8.<init>(r0)     // Catch:{ FileNotFoundException -> 0x00ea, IOException -> 0x00e5 }
            r7.<init>(r8)     // Catch:{ FileNotFoundException -> 0x00ea, IOException -> 0x00e5 }
            r6.<init>(r7)     // Catch:{ FileNotFoundException -> 0x00ea, IOException -> 0x00e5 }
            java.lang.String r0 = r6.readLine()     // Catch:{ all -> 0x00e0 }
            if (r0 == 0) goto L_0x00dc
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x00e0 }
            if (r0 == 0) goto L_0x003a
            goto L_0x00dc
        L_0x003a:
            java.lang.String r0 = r6.readLine()     // Catch:{ all -> 0x00e0 }
            if (r0 == 0) goto L_0x00d8
            java.lang.String r0 = r0.trim()     // Catch:{ NumberFormatException -> 0x003a, Exception -> 0x00d2 }
            r7 = 10
            java.lang.String[] r0 = r0.split(r2, r7)     // Catch:{ NumberFormatException -> 0x003a, Exception -> 0x00d2 }
            int r8 = r0.length     // Catch:{ NumberFormatException -> 0x003a, Exception -> 0x00d2 }
            if (r8 >= r7) goto L_0x004e
            goto L_0x003a
        L_0x004e:
            r7 = 2
            r8 = r0[r7]     // Catch:{ NumberFormatException -> 0x003a, Exception -> 0x00d2 }
            java.lang.String r8 = r8.trim()     // Catch:{ NumberFormatException -> 0x003a, Exception -> 0x00d2 }
            java.lang.String r9 = IIIlIIll     // Catch:{ NumberFormatException -> 0x003a, Exception -> 0x00d2 }
            java.lang.String[] r8 = r8.split(r9)     // Catch:{ NumberFormatException -> 0x003a, Exception -> 0x00d2 }
            int r9 = r8.length     // Catch:{ NumberFormatException -> 0x003a, Exception -> 0x00d2 }
            if (r9 == r7) goto L_0x005f
            goto L_0x003a
        L_0x005f:
            r7 = r8[r4]     // Catch:{ NumberFormatException -> 0x003a, Exception -> 0x00d2 }
            java.lang.String r13 = r1.IIIIIIIl((java.lang.String) r7)     // Catch:{ NumberFormatException -> 0x003a, Exception -> 0x00d2 }
            if (r13 != 0) goto L_0x0068
            goto L_0x003a
        L_0x0068:
            r7 = r8[r5]     // Catch:{ NumberFormatException -> 0x003a, Exception -> 0x00d2 }
            r8 = -1
            r9 = 16
            int r7 = java.lang.Integer.parseInt(r7, r9)     // Catch:{ NumberFormatException -> 0x0073, Exception -> 0x00d2 }
            r14 = r7
            goto L_0x0074
        L_0x0073:
            r14 = -1
        L_0x0074:
            if (r14 != r8) goto L_0x0077
            goto L_0x003a
        L_0x0077:
            r7 = 3
            r7 = r0[r7]     // Catch:{ NumberFormatException -> 0x003a, Exception -> 0x00d2 }
            java.lang.String r7 = r7.trim()     // Catch:{ NumberFormatException -> 0x003a, Exception -> 0x00d2 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7, r9)     // Catch:{ NumberFormatException -> 0x003a, Exception -> 0x00d2 }
            r7.intValue()     // Catch:{ NumberFormatException -> 0x003a, Exception -> 0x00d2 }
            r7 = 7
            r7 = r0[r7]     // Catch:{ NumberFormatException -> 0x003a, Exception -> 0x00d2 }
            java.lang.String r7 = r7.trim()     // Catch:{ NumberFormatException -> 0x003a, Exception -> 0x00d2 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ NumberFormatException -> 0x003a, Exception -> 0x00d2 }
            int r11 = r7.intValue()     // Catch:{ NumberFormatException -> 0x003a, Exception -> 0x00d2 }
            r7 = 9
            r0 = r0[r7]     // Catch:{ NumberFormatException -> 0x003a, Exception -> 0x00d2 }
            java.lang.String[] r0 = r0.split(r2)     // Catch:{ NumberFormatException -> 0x003a, Exception -> 0x00d2 }
            int r7 = r0.length     // Catch:{ NumberFormatException -> 0x003a, Exception -> 0x00d2 }
            if (r7 >= r5) goto L_0x00a0
            goto L_0x003a
        L_0x00a0:
            r0 = r0[r4]     // Catch:{ NumberFormatException -> 0x003a, Exception -> 0x00d2 }
            java.lang.String r0 = r0.trim()     // Catch:{ NumberFormatException -> 0x003a, Exception -> 0x00d2 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x003a, Exception -> 0x00d2 }
            int r0 = r0.intValue()     // Catch:{ NumberFormatException -> 0x003a, Exception -> 0x00d2 }
            android.content.Context r7 = r1.IIIIIIlI     // Catch:{ NumberFormatException -> 0x003a, Exception -> 0x00d2 }
            android.content.pm.PackageManager r7 = r7.getPackageManager()     // Catch:{ NumberFormatException -> 0x003a, Exception -> 0x00d2 }
            java.lang.String r12 = r7.getNameForUid(r11)     // Catch:{ NumberFormatException -> 0x003a, Exception -> 0x00d2 }
            if (r12 != 0) goto L_0x00bc
            goto L_0x003a
        L_0x00bc:
            io.presage.core.IIllIlII r7 = new io.presage.core.IIllIlII     // Catch:{ NumberFormatException -> 0x003a, Exception -> 0x00d2 }
            long r15 = java.lang.System.currentTimeMillis()     // Catch:{ NumberFormatException -> 0x003a, Exception -> 0x00d2 }
            r17 = -1
            r9 = r7
            r10 = r0
            r9.<init>(r10, r11, r12, r13, r14, r15, r17)     // Catch:{ NumberFormatException -> 0x003a, Exception -> 0x00d2 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x003a, Exception -> 0x00d2 }
            r3.put(r0, r7)     // Catch:{ NumberFormatException -> 0x003a, Exception -> 0x00d2 }
            goto L_0x003a
        L_0x00d2:
            r0 = move-exception
            r1.IIIIIIII(r0, r5)     // Catch:{ all -> 0x00e0 }
            goto L_0x003a
        L_0x00d8:
            r6.close()     // Catch:{ FileNotFoundException -> 0x00ea, IOException -> 0x00e5 }
            goto L_0x00ee
        L_0x00dc:
            r6.close()     // Catch:{ FileNotFoundException -> 0x00ea, IOException -> 0x00e5 }
            return r3
        L_0x00e0:
            r0 = move-exception
            r6.close()     // Catch:{ FileNotFoundException -> 0x00ea, IOException -> 0x00e5 }
            throw r0     // Catch:{ FileNotFoundException -> 0x00ea, IOException -> 0x00e5 }
        L_0x00e5:
            r0 = move-exception
            r1.IIIIIIII(r0, r5)
            goto L_0x00ee
        L_0x00ea:
            r0 = move-exception
            r1.IIIIIIII(r0, r4)
        L_0x00ee:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p118io.presage.core.IlIlllll.IIIIlIll():java.util.HashMap");
    }

    public abstract File IIIIllII();

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c6, code lost:
        if (r5 == null) goto L_0x00dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d7, code lost:
        if (r5 == null) goto L_0x00dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00d9, code lost:
        p118io.presage.core.C6313i1.IIIIIIII(r5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.HashMap<java.lang.Integer, p118io.presage.core.IIllIlII> IIIIllIl() {
        /*
            r27 = this;
            r1 = r27
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r4 = 1
            r5 = 0
            java.lang.String r0 = IIIlIIlI     // Catch:{ EOFException -> 0x00cf, FileNotFoundException -> 0x00c9, IOException -> 0x00bf }
            java.io.File r5 = r1.IIIIIIII((java.lang.String) r0)     // Catch:{ EOFException -> 0x00cf, FileNotFoundException -> 0x00c9, IOException -> 0x00bf }
            boolean r0 = r5.exists()     // Catch:{ EOFException -> 0x00cf, FileNotFoundException -> 0x00c9, IOException -> 0x00bf }
            if (r0 == 0) goto L_0x00be
            long r6 = r5.length()     // Catch:{ EOFException -> 0x00cf, FileNotFoundException -> 0x00c9, IOException -> 0x00bf }
            r8 = 0
            int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r0 == 0) goto L_0x00be
            boolean r0 = r5.canRead()     // Catch:{ EOFException -> 0x00cf, FileNotFoundException -> 0x00c9, IOException -> 0x00bf }
            if (r0 != 0) goto L_0x0027
            goto L_0x00be
        L_0x0027:
            java.io.DataInputStream r6 = new java.io.DataInputStream     // Catch:{ EOFException -> 0x00cf, FileNotFoundException -> 0x00c9, IOException -> 0x00bf }
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ EOFException -> 0x00cf, FileNotFoundException -> 0x00c9, IOException -> 0x00bf }
            r0.<init>(r5)     // Catch:{ EOFException -> 0x00cf, FileNotFoundException -> 0x00c9, IOException -> 0x00bf }
            r6.<init>(r0)     // Catch:{ EOFException -> 0x00cf, FileNotFoundException -> 0x00c9, IOException -> 0x00bf }
            short r0 = r6.readShort()     // Catch:{ all -> 0x00b9 }
            if (r0 == r4) goto L_0x0071
            r7 = 2
            if (r0 == r7) goto L_0x0071
            r7 = 3
            if (r0 == r7) goto L_0x003f
            goto L_0x00b5
        L_0x003f:
            boolean r0 = r6.readBoolean()     // Catch:{ all -> 0x00b9 }
            if (r0 == 0) goto L_0x00b5
            int r0 = r6.readInt()     // Catch:{ all -> 0x00b9 }
            int r9 = r6.readInt()     // Catch:{ all -> 0x00b9 }
            java.lang.String r10 = r6.readUTF()     // Catch:{ all -> 0x00b9 }
            java.lang.String r11 = r6.readUTF()     // Catch:{ all -> 0x00b9 }
            int r12 = r6.readInt()     // Catch:{ all -> 0x00b9 }
            long r13 = r6.readLong()     // Catch:{ all -> 0x00b9 }
            long r15 = r6.readLong()     // Catch:{ all -> 0x00b9 }
            io.presage.core.IIllIlII r8 = new io.presage.core.IIllIlII     // Catch:{ all -> 0x00b9 }
            r7 = r8
            r3 = r8
            r8 = r0
            r7.<init>(r8, r9, r10, r11, r12, r13, r15)     // Catch:{ all -> 0x00b9 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x00b9 }
            r2.put(r0, r3)     // Catch:{ all -> 0x00b9 }
            goto L_0x003f
        L_0x0071:
            int r3 = r6.readInt()     // Catch:{ all -> 0x00b9 }
            r7 = 0
        L_0x0076:
            if (r7 >= r3) goto L_0x00b5
            int r8 = r6.readInt()     // Catch:{ all -> 0x00b9 }
            int r19 = r6.readInt()     // Catch:{ all -> 0x00b9 }
            java.lang.String r20 = r6.readUTF()     // Catch:{ all -> 0x00b9 }
            java.lang.String r21 = r6.readUTF()     // Catch:{ all -> 0x00b9 }
            int r22 = r6.readInt()     // Catch:{ all -> 0x00b9 }
            long r23 = r6.readLong()     // Catch:{ all -> 0x00b9 }
            if (r0 != r4) goto L_0x009e
            io.presage.core.IIllIlII r9 = new io.presage.core.IIllIlII     // Catch:{ all -> 0x00b9 }
            r25 = -1
            r17 = r9
            r18 = r8
            r17.<init>(r18, r19, r20, r21, r22, r23, r25)     // Catch:{ all -> 0x00b9 }
            goto L_0x00ab
        L_0x009e:
            long r25 = r6.readLong()     // Catch:{ all -> 0x00b9 }
            io.presage.core.IIllIlII r9 = new io.presage.core.IIllIlII     // Catch:{ all -> 0x00b9 }
            r17 = r9
            r18 = r8
            r17.<init>(r18, r19, r20, r21, r22, r23, r25)     // Catch:{ all -> 0x00b9 }
        L_0x00ab:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x00b9 }
            r2.put(r8, r9)     // Catch:{ all -> 0x00b9 }
            int r7 = r7 + 1
            goto L_0x0076
        L_0x00b5:
            r6.close()     // Catch:{ EOFException -> 0x00cf, FileNotFoundException -> 0x00c9, IOException -> 0x00bf }
            goto L_0x00dc
        L_0x00b9:
            r0 = move-exception
            r6.close()     // Catch:{ EOFException -> 0x00cf, FileNotFoundException -> 0x00c9, IOException -> 0x00bf }
            throw r0     // Catch:{ EOFException -> 0x00cf, FileNotFoundException -> 0x00c9, IOException -> 0x00bf }
        L_0x00be:
            return r2
        L_0x00bf:
            r0 = move-exception
            r1.IIIIIIII(r0, r4)
            r2.clear()
            if (r5 == 0) goto L_0x00dc
            goto L_0x00d9
        L_0x00c9:
            r0 = move-exception
            r3 = 0
            r1.IIIIIIII(r0, r3)
            goto L_0x00dc
        L_0x00cf:
            r0 = move-exception
            r3 = 0
            r1.IIIIIIII(r0, r3)
            r2.clear()
            if (r5 == 0) goto L_0x00dc
        L_0x00d9:
            p118io.presage.core.C6313i1.IIIIIIII(r5)
        L_0x00dc:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p118io.presage.core.IlIlllll.IIIIllIl():java.util.HashMap");
    }

    public final void IIIIlllI() {
        DataOutputStream dataOutputStream;
        File file = null;
        try {
            file = IIIIIIII(IIIlIIlI);
            if (!file.exists() || (file.exists() && file.canWrite())) {
                dataOutputStream = new DataOutputStream(new FileOutputStream(file));
                dataOutputStream.writeShort(3);
                dataOutputStream.writeInt(0);
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
    }

    public final void IIIIIIII(HashMap<Integer, IIllIlII> hashMap, HashMap<Integer, IIllIlII> hashMap2) {
        HashMap<Integer, IIllIlII> hashMap3 = hashMap;
        HashMap<Integer, IIllIlII> hashMap4 = hashMap2;
        if (hashMap3 == null || hashMap4 == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        for (Integer next : hashMap.keySet()) {
            if (!hashMap4.containsKey(next)) {
                IIllIlII iIllIlII = hashMap3.get(next);
                if (iIllIlII != null) {
                    IIIIIIII((IIIlIIlI) IIIIIIII(currentTimeMillis, iIllIlII.IIIIIIIl, iIllIlII.IIIIIIlI, iIllIlII.IIIIIIll, iIllIlII.IIIIIlII, iIllIlII.IIIIIlIl, currentTimeMillis));
                }
            }
        }
    }
}
