package p118io.presage.core;

import android.content.Context;
import android.os.Build;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Pattern;

/* renamed from: io.presage.core.IllIIIII */
public class IllIIIII extends IlIIIlll {
    public static final String IIIlIIlI = C6289c1.IIIIIIII;
    public static final String IIIlIIll = C6289c1.IIIIIlIl;
    public static final String IIIlIlII = C6289c1.IIIIIllI;
    public static final String IIIlIlIl = C6289c1.IIIIIIll;
    public static final String IIIlIllI = llllIIlI.IIIIIIII;
    public ArrayList<IIlIlllI> IIIlIIIl = new ArrayList<>();

    /* renamed from: io.presage.core.IllIIIII$IIIIIIII */
    public class IIIIIIII implements FilenameFilter {
        public IIIIIIII(IllIIIII illIIIII) {
        }

        public boolean accept(File file, String str) {
            return Pattern.compile(C6289c1.IIIIIlII).matcher(str).matches();
        }
    }

    /* renamed from: io.presage.core.IllIIIII$IIIIIIIl */
    public class IIIIIIIl implements Comparator<IIlIlllI> {
        public IIIIIIIl(IllIIIII illIIIII) {
        }

        public int compare(Object obj, Object obj2) {
            int i = (((IIlIlllI) obj).IIIIllII > ((IIlIlllI) obj2).IIIIllII ? 1 : (((IIlIlllI) obj).IIIIllII == ((IIlIlllI) obj2).IIIIllII ? 0 : -1));
            if (i == 0) {
                return 0;
            }
            return i > 0 ? -1 : 1;
        }
    }

    public IllIIIII(Context context, int i, long j, long j2) {
        super(context, i, j, j2);
    }

    public int IIIIIIII() {
        return 16;
    }

    public final ArrayList<IIlIlllI> IIIIIIII(ArrayList<IIlIlllI> arrayList) {
        DataOutputStream dataOutputStream;
        if (!IIIIIlII()) {
            if (this.IIIlIIIl == null) {
                arrayList = new ArrayList<>();
            }
            File file = null;
            try {
                file = IIIIIIII(IIIlIllI);
                if (!file.exists() || (file.exists() && file.canWrite())) {
                    dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
                    dataOutputStream.writeShort(2);
                    for (int i = 0; i < this.IIIlIIIl.size(); i++) {
                        IIlIlllI iIlIlllI = this.IIIlIIIl.get(i);
                        if (iIlIlllI != null) {
                            dataOutputStream.writeBoolean(true);
                            dataOutputStream.writeInt(iIlIlllI.IIIIIIII);
                            dataOutputStream.writeUTF(iIlIlllI.IIIIIIIl);
                            dataOutputStream.writeInt(iIlIlllI.IIIIIIlI);
                            dataOutputStream.writeUTF(iIlIlllI.IIIIIIll);
                            dataOutputStream.writeInt(iIlIlllI.IIIIIlII);
                            dataOutputStream.writeLong(iIlIlllI.IIIIIlIl);
                            dataOutputStream.writeLong(iIlIlllI.IIIIIllI);
                            dataOutputStream.writeLong(iIlIlllI.IIIIIlll);
                            dataOutputStream.writeLong(iIlIlllI.IIIIlIII);
                            dataOutputStream.writeLong(iIlIlllI.IIIIlIIl);
                            dataOutputStream.writeLong(iIlIlllI.IIIIlIlI);
                            dataOutputStream.writeLong(iIlIlllI.IIIIlIll);
                            dataOutputStream.writeLong(iIlIlllI.IIIIllII);
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
            return arrayList;
        }
        throw new lIlllIII();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r9 = r9.split("\\s+");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004e, code lost:
        if (r9.length <= 1) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0050, code lost:
        r9 = java.lang.Integer.parseInt(r9[1]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0059, code lost:
        return r9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int IIIIIIIl(int r9) {
        /*
            r8 = this;
            r0 = -1
            r1 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x006b }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x006b }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ Exception -> 0x006b }
            java.lang.String r5 = p118io.presage.core.C6289c1.IIIIIIIl     // Catch:{ Exception -> 0x006b }
            r6 = 1
            java.lang.Object[] r7 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x006b }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ Exception -> 0x006b }
            r7[r1] = r9     // Catch:{ Exception -> 0x006b }
            java.lang.String r9 = java.lang.String.format(r5, r7)     // Catch:{ Exception -> 0x006b }
            r4.<init>(r9)     // Catch:{ Exception -> 0x006b }
            r3.<init>(r4)     // Catch:{ Exception -> 0x006b }
            r2.<init>(r3)     // Catch:{ Exception -> 0x006b }
            java.lang.String r9 = r2.readLine()     // Catch:{ all -> 0x0066 }
            if (r9 == 0) goto L_0x0062
            boolean r9 = r9.isEmpty()     // Catch:{ all -> 0x0066 }
            if (r9 == 0) goto L_0x002d
            goto L_0x0062
        L_0x002d:
            java.lang.String r9 = r2.readLine()     // Catch:{ all -> 0x0066 }
            if (r9 == 0) goto L_0x005e
            int r3 = r9.length()     // Catch:{ all -> 0x0066 }
            r4 = 5
            if (r3 < r4) goto L_0x002d
            r3 = 4
            java.lang.String r3 = r9.substring(r1, r3)     // Catch:{ all -> 0x0066 }
            java.lang.String r4 = p118io.presage.core.C6289c1.IIIIIIlI     // Catch:{ all -> 0x0066 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0066 }
            if (r3 == 0) goto L_0x002d
            java.lang.String r3 = "\\s+"
            java.lang.String[] r9 = r9.split(r3)     // Catch:{ NumberFormatException -> 0x005a }
            int r3 = r9.length     // Catch:{ NumberFormatException -> 0x005a }
            if (r3 <= r6) goto L_0x005a
            r9 = r9[r6]     // Catch:{ NumberFormatException -> 0x005a }
            int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ NumberFormatException -> 0x005a }
            r2.close()     // Catch:{ Exception -> 0x006b }
            return r9
        L_0x005a:
            r2.close()     // Catch:{ Exception -> 0x006b }
            return r0
        L_0x005e:
            r2.close()     // Catch:{ Exception -> 0x006b }
            goto L_0x006f
        L_0x0062:
            r2.close()     // Catch:{ Exception -> 0x006b }
            return r0
        L_0x0066:
            r9 = move-exception
            r2.close()     // Catch:{ Exception -> 0x006b }
            throw r9     // Catch:{ Exception -> 0x006b }
        L_0x006b:
            r9 = move-exception
            r8.IIIIIIII(r9, r1)
        L_0x006f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p118io.presage.core.IllIIIII.IIIIIIIl(int):int");
    }

    public Object IIIIIIll() {
        return IllIIIII.class;
    }

    public void IIIIlIIl() {
        this.IIIlIIIl.clear();
    }

    public void IIIIlIlI() {
        if (Build.VERSION.SDK_INT > 23) {
            IIIIIIII(0);
            return;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList<IIlIlllI> IIIIlIll = IIIIlIll();
            Collections.sort(IIIIlIll, new IIIIIIIl(this));
            if (this.IIIlIIIl.isEmpty()) {
                this.IIIlIIIl = IIIIllII();
            }
            if (this.IIIlIIIl.isEmpty()) {
                this.IIIlIIIl = IIIIlIll;
            } else if (!IIIIlIll.isEmpty() && this.IIIlIIIl != null && !this.IIIlIIIl.isEmpty()) {
                if (IIIIlIll.get(0).IIIIIIII == this.IIIlIIIl.get(0).IIIIIIII && IIIIlIll.get(0).IIIIIIIl.equals(this.IIIlIIIl.get(0).IIIIIIIl)) {
                    this.IIIlIIIl.get(0).IIIIIlIl = IIIIlIll.get(0).IIIIIlIl;
                } else if (this.IIIlIIIl.get(0).IIIIllII != 0) {
                    IIIIIIII((IIIlIIlI) new IIllIllI(currentTimeMillis, this.IIIlIIIl.get(0).IIIIIIII, this.IIIlIIIl.get(0).IIIIIIIl, this.IIIlIIIl.get(0).IIIIIIlI, this.IIIlIIIl.get(0).IIIIIIll, this.IIIlIIIl.get(0).IIIIIlII, this.IIIlIIIl.get(0).IIIIIlIl, this.IIIlIIIl.get(0).IIIIlIll, currentTimeMillis));
                }
            }
            this.IIIlIIIl = IIIIIIII(IIIIlIll);
        } catch (lIlllIII unused) {
            IIIIIIII(0);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0195, code lost:
        if (r9 == false) goto L_0x0198;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01c6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.ArrayList<p118io.presage.core.IIlIlllI> IIIIlIll() {
        /*
            r38 = this;
            r1 = r38
            java.lang.String r2 = ""
            java.lang.String r3 = "\\s+"
            android.content.Context r0 = r1.IIIIIIlI
            java.util.HashSet r4 = p118io.presage.core.IIIIlIll.IIIIIIll(r0)
            java.io.File r0 = new java.io.File
            java.lang.String r5 = IIIlIlII
            r0.<init>(r5)
            r5 = 0
            r6 = 1
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ NumberFormatException -> 0x003a, FileNotFoundException -> 0x0038, Exception -> 0x0033 }
            r7.<init>(r0)     // Catch:{ NumberFormatException -> 0x003a, FileNotFoundException -> 0x0038, Exception -> 0x0033 }
            byte[] r0 = p118io.presage.core.IIIIlIll.IIIIIIII((java.io.InputStream) r7, (boolean) r6)     // Catch:{ NumberFormatException -> 0x003a, FileNotFoundException -> 0x0038, Exception -> 0x0033 }
            java.lang.String r7 = new java.lang.String     // Catch:{ NumberFormatException -> 0x003a, FileNotFoundException -> 0x0038, Exception -> 0x0033 }
            r7.<init>(r0)     // Catch:{ NumberFormatException -> 0x003a, FileNotFoundException -> 0x0038, Exception -> 0x0033 }
            java.lang.String[] r0 = r7.split(r3)     // Catch:{ NumberFormatException -> 0x003a, FileNotFoundException -> 0x0038, Exception -> 0x0033 }
            r0 = r0[r5]     // Catch:{ NumberFormatException -> 0x003a, FileNotFoundException -> 0x0038, Exception -> 0x0033 }
            java.lang.String r0 = r0.trim()     // Catch:{ NumberFormatException -> 0x003a, FileNotFoundException -> 0x0038, Exception -> 0x0033 }
            float r0 = java.lang.Float.parseFloat(r0)     // Catch:{ NumberFormatException -> 0x003a, FileNotFoundException -> 0x0038, Exception -> 0x0033 }
            long r7 = (long) r0
            goto L_0x0040
        L_0x0033:
            r0 = move-exception
            r1.IIIIIIII(r0, r6)
            goto L_0x003e
        L_0x0038:
            r0 = move-exception
            goto L_0x003b
        L_0x003a:
            r0 = move-exception
        L_0x003b:
            r1.IIIIIIII(r0, r5)
        L_0x003e:
            r7 = -1
        L_0x0040:
            java.io.File r15 = new java.io.File
            java.lang.String r0 = IIIlIIlI
            r15.<init>(r0)
            io.presage.core.IllIIIII$IIIIIIII r0 = new io.presage.core.IllIIIII$IIIIIIII
            r0.<init>(r1)
            java.lang.String[] r14 = r15.list(r0)
            long r31 = java.lang.System.currentTimeMillis()
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            int r12 = r14.length
            r11 = 0
        L_0x005b:
            if (r11 >= r12) goto L_0x01bd
            r9 = r14[r11]
            java.io.File r10 = new java.io.File
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = r15.getAbsolutePath()
            r0.append(r5)
            java.lang.String r5 = java.io.File.separator
            r0.append(r5)
            r0.append(r9)
            java.lang.String r5 = java.io.File.separator
            r0.append(r5)
            java.lang.String r5 = IIIlIIll
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            r10.<init>(r0)
            boolean r0 = r10.exists()     // Catch:{ NumberFormatException -> 0x01a1, FileNotFoundException -> 0x019d, IOException -> 0x0180, Exception -> 0x0174 }
            if (r0 != 0) goto L_0x0099
        L_0x008c:
            r33 = r2
        L_0x008e:
            r35 = r11
            r36 = r12
            r2 = r13
            r5 = r14
            r37 = r15
        L_0x0096:
            r9 = 0
            goto L_0x01b0
        L_0x0099:
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ NumberFormatException -> 0x01a1, FileNotFoundException -> 0x019d, IOException -> 0x0180, Exception -> 0x0174 }
            r0.<init>(r10)     // Catch:{ NumberFormatException -> 0x01a1, FileNotFoundException -> 0x019d, IOException -> 0x0180, Exception -> 0x0174 }
            byte[] r0 = p118io.presage.core.IIIIlIll.IIIIIIII((java.io.InputStream) r0, (boolean) r6)     // Catch:{ NumberFormatException -> 0x01a1, FileNotFoundException -> 0x019d, IOException -> 0x0180, Exception -> 0x0174 }
            java.lang.String r5 = "(\\d+)\\s+(\\(.*\\))\\s+(.*)"
            java.util.regex.Pattern r5 = java.util.regex.Pattern.compile(r5)     // Catch:{ NumberFormatException -> 0x01a1, FileNotFoundException -> 0x019d, IOException -> 0x0180, Exception -> 0x0174 }
            java.lang.String r9 = new java.lang.String     // Catch:{ NumberFormatException -> 0x01a1, FileNotFoundException -> 0x019d, IOException -> 0x0180, Exception -> 0x0174 }
            r9.<init>(r0)     // Catch:{ NumberFormatException -> 0x01a1, FileNotFoundException -> 0x019d, IOException -> 0x0180, Exception -> 0x0174 }
            java.util.regex.Matcher r0 = r5.matcher(r9)     // Catch:{ NumberFormatException -> 0x01a1, FileNotFoundException -> 0x019d, IOException -> 0x0180, Exception -> 0x0174 }
            r5 = 0
            r9 = 0
            r16 = 0
        L_0x00b5:
            boolean r10 = r0.find()     // Catch:{ NumberFormatException -> 0x01a1, FileNotFoundException -> 0x019d, IOException -> 0x0180, Exception -> 0x0174 }
            if (r10 == 0) goto L_0x00d6
            java.lang.String r5 = r0.group(r6)     // Catch:{ NumberFormatException -> 0x01a1, FileNotFoundException -> 0x019d, IOException -> 0x0180, Exception -> 0x0174 }
            java.lang.String r16 = r5.trim()     // Catch:{ NumberFormatException -> 0x01a1, FileNotFoundException -> 0x019d, IOException -> 0x0180, Exception -> 0x0174 }
            r5 = 2
            java.lang.String r5 = r0.group(r5)     // Catch:{ NumberFormatException -> 0x01a1, FileNotFoundException -> 0x019d, IOException -> 0x0180, Exception -> 0x0174 }
            java.lang.String r5 = r5.trim()     // Catch:{ NumberFormatException -> 0x01a1, FileNotFoundException -> 0x019d, IOException -> 0x0180, Exception -> 0x0174 }
            r9 = 3
            java.lang.String r9 = r0.group(r9)     // Catch:{ NumberFormatException -> 0x01a1, FileNotFoundException -> 0x019d, IOException -> 0x0180, Exception -> 0x0174 }
            java.lang.String r9 = r9.trim()     // Catch:{ NumberFormatException -> 0x01a1, FileNotFoundException -> 0x019d, IOException -> 0x0180, Exception -> 0x0174 }
            goto L_0x00b5
        L_0x00d6:
            if (r16 == 0) goto L_0x008c
            if (r5 == 0) goto L_0x008c
            if (r9 == 0) goto L_0x008c
            int r10 = java.lang.Integer.parseInt(r16)     // Catch:{ NumberFormatException -> 0x01a1, FileNotFoundException -> 0x019d, IOException -> 0x0180, Exception -> 0x0174 }
            java.lang.String r0 = "("
            java.lang.String r0 = r5.replace(r0, r2)     // Catch:{ NumberFormatException -> 0x01a1, FileNotFoundException -> 0x019d, IOException -> 0x0180, Exception -> 0x0174 }
            java.lang.String r5 = ")"
            java.lang.String r0 = r0.replace(r5, r2)     // Catch:{ NumberFormatException -> 0x01a1, FileNotFoundException -> 0x019d, IOException -> 0x0180, Exception -> 0x0174 }
            java.lang.String[] r5 = r9.split(r3)     // Catch:{ NumberFormatException -> 0x01a1, FileNotFoundException -> 0x019d, IOException -> 0x0180, Exception -> 0x0174 }
            int r9 = r5.length     // Catch:{ NumberFormatException -> 0x01a1, FileNotFoundException -> 0x019d, IOException -> 0x0180, Exception -> 0x0174 }
            r33 = r2
            r2 = 15
            if (r9 <= r2) goto L_0x008e
            r9 = r5[r6]     // Catch:{ NumberFormatException -> 0x0172, FileNotFoundException -> 0x0170, IOException -> 0x016e, Exception -> 0x016c }
            int r16 = java.lang.Integer.parseInt(r9)     // Catch:{ NumberFormatException -> 0x0172, FileNotFoundException -> 0x0170, IOException -> 0x016e, Exception -> 0x016c }
            r9 = 9
            r9 = r5[r9]     // Catch:{ NumberFormatException -> 0x0172, FileNotFoundException -> 0x0170, IOException -> 0x016e, Exception -> 0x016c }
            long r17 = java.lang.Long.parseLong(r9)     // Catch:{ NumberFormatException -> 0x0172, FileNotFoundException -> 0x0170, IOException -> 0x016e, Exception -> 0x016c }
            r9 = 10
            r9 = r5[r9]     // Catch:{ NumberFormatException -> 0x0172, FileNotFoundException -> 0x0170, IOException -> 0x016e, Exception -> 0x016c }
            long r19 = java.lang.Long.parseLong(r9)     // Catch:{ NumberFormatException -> 0x0172, FileNotFoundException -> 0x0170, IOException -> 0x016e, Exception -> 0x016c }
            r9 = 11
            r9 = r5[r9]     // Catch:{ NumberFormatException -> 0x0172, FileNotFoundException -> 0x0170, IOException -> 0x016e, Exception -> 0x016c }
            long r21 = java.lang.Long.parseLong(r9)     // Catch:{ NumberFormatException -> 0x0172, FileNotFoundException -> 0x0170, IOException -> 0x016e, Exception -> 0x016c }
            r9 = 12
            r9 = r5[r9]     // Catch:{ NumberFormatException -> 0x0172, FileNotFoundException -> 0x0170, IOException -> 0x016e, Exception -> 0x016c }
            long r23 = java.lang.Long.parseLong(r9)     // Catch:{ NumberFormatException -> 0x0172, FileNotFoundException -> 0x0170, IOException -> 0x016e, Exception -> 0x016c }
            r2 = r5[r2]     // Catch:{ NumberFormatException -> 0x0172, FileNotFoundException -> 0x0170, IOException -> 0x016e, Exception -> 0x016c }
            long r25 = java.lang.Long.parseLong(r2)     // Catch:{ NumberFormatException -> 0x0172, FileNotFoundException -> 0x0170, IOException -> 0x016e, Exception -> 0x016c }
            int r2 = r1.IIIIIIIl(r10)     // Catch:{ NumberFormatException -> 0x0172, FileNotFoundException -> 0x0170, IOException -> 0x016e, Exception -> 0x016c }
            android.content.Context r5 = r1.IIIIIIlI     // Catch:{ NumberFormatException -> 0x0172, FileNotFoundException -> 0x0170, IOException -> 0x016e, Exception -> 0x016c }
            android.content.pm.PackageManager r5 = r5.getPackageManager()     // Catch:{ NumberFormatException -> 0x0172, FileNotFoundException -> 0x0170, IOException -> 0x016e, Exception -> 0x016c }
            java.lang.String r5 = r5.getNameForUid(r2)     // Catch:{ NumberFormatException -> 0x0172, FileNotFoundException -> 0x0170, IOException -> 0x016e, Exception -> 0x016c }
            if (r5 == 0) goto L_0x008e
            boolean r9 = r4.contains(r5)     // Catch:{ NumberFormatException -> 0x0172, FileNotFoundException -> 0x0170, IOException -> 0x016e, Exception -> 0x016c }
            if (r9 == 0) goto L_0x008e
            io.presage.core.IIlIlllI r9 = new io.presage.core.IIlIlllI     // Catch:{ NumberFormatException -> 0x0172, FileNotFoundException -> 0x0170, IOException -> 0x016e, Exception -> 0x016c }
            r29 = 0
            r34 = r9
            r35 = r11
            r11 = r0
            r36 = r12
            r12 = r2
            r2 = r13
            r13 = r5
            r5 = r14
            r14 = r16
            r37 = r15
            r15 = r17
            r17 = r19
            r19 = r21
            r21 = r23
            r23 = r25
            r25 = r7
            r27 = r31
            r9.<init>(r10, r11, r12, r13, r14, r15, r17, r19, r21, r23, r25, r27, r29)     // Catch:{ NumberFormatException -> 0x016a, FileNotFoundException -> 0x0168, IOException -> 0x0166, Exception -> 0x0164 }
            r0 = r34
            r2.add(r0)     // Catch:{ NumberFormatException -> 0x016a, FileNotFoundException -> 0x0168, IOException -> 0x0166, Exception -> 0x0164 }
            goto L_0x0096
        L_0x0164:
            r0 = move-exception
            goto L_0x0198
        L_0x0166:
            r0 = move-exception
            goto L_0x018b
        L_0x0168:
            r0 = move-exception
            goto L_0x01ac
        L_0x016a:
            r0 = move-exception
            goto L_0x01ac
        L_0x016c:
            r0 = move-exception
            goto L_0x0177
        L_0x016e:
            r0 = move-exception
            goto L_0x0183
        L_0x0170:
            r0 = move-exception
            goto L_0x01a4
        L_0x0172:
            r0 = move-exception
            goto L_0x01a4
        L_0x0174:
            r0 = move-exception
            r33 = r2
        L_0x0177:
            r35 = r11
            r36 = r12
            r2 = r13
            r5 = r14
            r37 = r15
            goto L_0x0198
        L_0x0180:
            r0 = move-exception
            r33 = r2
        L_0x0183:
            r35 = r11
            r36 = r12
            r2 = r13
            r5 = r14
            r37 = r15
        L_0x018b:
            java.lang.String r9 = r0.getMessage()
            java.lang.String r10 = IIIlIlIl
            boolean r9 = r9.contains(r10)
            if (r9 == 0) goto L_0x0198
            goto L_0x01ac
        L_0x0198:
            r1.IIIIIIII(r0, r6)
            goto L_0x0096
        L_0x019d:
            r0 = move-exception
            r33 = r2
            goto L_0x01a4
        L_0x01a1:
            r0 = move-exception
            r33 = r2
        L_0x01a4:
            r35 = r11
            r36 = r12
            r2 = r13
            r5 = r14
            r37 = r15
        L_0x01ac:
            r9 = 0
            r1.IIIIIIII(r0, r9)
        L_0x01b0:
            int r11 = r35 + 1
            r13 = r2
            r14 = r5
            r2 = r33
            r12 = r36
            r15 = r37
            r5 = 0
            goto L_0x005b
        L_0x01bd:
            r2 = r13
            r9 = 0
            r0 = 0
        L_0x01c0:
            int r3 = r2.size()
            if (r0 >= r3) goto L_0x020a
            java.util.ArrayList<io.presage.core.IIlIlllI> r3 = r1.IIIlIIIl
            if (r3 != 0) goto L_0x01d5
            java.lang.Object r3 = r2.get(r0)
            io.presage.core.IIlIlllI r3 = (p118io.presage.core.IIlIlllI) r3
            r4 = 0
            r3.IIIIIIII(r4)
            goto L_0x0207
        L_0x01d5:
            r4 = 0
            r3 = 0
        L_0x01d7:
            java.util.ArrayList<io.presage.core.IIlIlllI> r5 = r1.IIIlIIIl
            int r5 = r5.size()
            if (r3 >= r5) goto L_0x0207
            java.util.ArrayList<io.presage.core.IIlIlllI> r5 = r1.IIIlIIIl
            java.lang.Object r5 = r5.get(r3)
            io.presage.core.IIlIlllI r5 = (p118io.presage.core.IIlIlllI) r5
            int r5 = r5.IIIIIIII
            java.lang.Object r6 = r2.get(r0)
            io.presage.core.IIlIlllI r6 = (p118io.presage.core.IIlIlllI) r6
            int r6 = r6.IIIIIIII
            if (r5 != r6) goto L_0x0204
            java.lang.Object r5 = r2.get(r0)
            io.presage.core.IIlIlllI r5 = (p118io.presage.core.IIlIlllI) r5
            java.util.ArrayList<io.presage.core.IIlIlllI> r6 = r1.IIIlIIIl
            java.lang.Object r6 = r6.get(r3)
            io.presage.core.IIlIlllI r6 = (p118io.presage.core.IIlIlllI) r6
            r5.IIIIIIII(r6)
        L_0x0204:
            int r3 = r3 + 1
            goto L_0x01d7
        L_0x0207:
            int r0 = r0 + 1
            goto L_0x01c0
        L_0x020a:
            io.presage.core.IllIIIII$IIIIIIIl r0 = new io.presage.core.IllIIIII$IIIIIIIl
            r0.<init>(r1)
            java.util.Collections.sort(r2, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p118io.presage.core.IllIIIII.IIIIlIll():java.util.ArrayList");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00dc, code lost:
        if (r5 == null) goto L_0x00f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00eb, code lost:
        if (r5 == null) goto L_0x00f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ed, code lost:
        p118io.presage.core.C6313i1.IIIIIIII(r5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.ArrayList<p118io.presage.core.IIlIlllI> IIIIllII() {
        /*
            r31 = this;
            r1 = r31
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r3 = 1
            r4 = 0
            r5 = 0
            java.lang.String r0 = IIIlIllI     // Catch:{ EOFException -> 0x00e4, FileNotFoundException -> 0x00df, IOException -> 0x00d5 }
            java.io.File r5 = r1.IIIIIIII((java.lang.String) r0)     // Catch:{ EOFException -> 0x00e4, FileNotFoundException -> 0x00df, IOException -> 0x00d5 }
            boolean r0 = r5.exists()     // Catch:{ EOFException -> 0x00e4, FileNotFoundException -> 0x00df, IOException -> 0x00d5 }
            if (r0 == 0) goto L_0x00d4
            long r6 = r5.length()     // Catch:{ EOFException -> 0x00e4, FileNotFoundException -> 0x00df, IOException -> 0x00d5 }
            r8 = 0
            int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r0 == 0) goto L_0x00d4
            boolean r0 = r5.canRead()     // Catch:{ EOFException -> 0x00e4, FileNotFoundException -> 0x00df, IOException -> 0x00d5 }
            if (r0 != 0) goto L_0x0028
            goto L_0x00d4
        L_0x0028:
            java.io.DataInputStream r6 = new java.io.DataInputStream     // Catch:{ EOFException -> 0x00e4, FileNotFoundException -> 0x00df, IOException -> 0x00d5 }
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ EOFException -> 0x00e4, FileNotFoundException -> 0x00df, IOException -> 0x00d5 }
            r0.<init>(r5)     // Catch:{ EOFException -> 0x00e4, FileNotFoundException -> 0x00df, IOException -> 0x00d5 }
            r6.<init>(r0)     // Catch:{ EOFException -> 0x00e4, FileNotFoundException -> 0x00df, IOException -> 0x00d5 }
            short r0 = r6.readShort()     // Catch:{ all -> 0x00cf }
            if (r0 == r3) goto L_0x0081
            r7 = 2
            if (r0 == r7) goto L_0x003d
            goto L_0x00cb
        L_0x003d:
            boolean r0 = r6.readBoolean()     // Catch:{ all -> 0x00cf }
            if (r0 == 0) goto L_0x00cb
            int r8 = r6.readInt()     // Catch:{ all -> 0x00cf }
            java.lang.String r9 = r6.readUTF()     // Catch:{ all -> 0x00cf }
            int r10 = r6.readInt()     // Catch:{ all -> 0x00cf }
            java.lang.String r11 = r6.readUTF()     // Catch:{ all -> 0x00cf }
            int r12 = r6.readInt()     // Catch:{ all -> 0x00cf }
            long r13 = r6.readLong()     // Catch:{ all -> 0x00cf }
            long r15 = r6.readLong()     // Catch:{ all -> 0x00cf }
            long r17 = r6.readLong()     // Catch:{ all -> 0x00cf }
            long r19 = r6.readLong()     // Catch:{ all -> 0x00cf }
            long r21 = r6.readLong()     // Catch:{ all -> 0x00cf }
            long r23 = r6.readLong()     // Catch:{ all -> 0x00cf }
            long r25 = r6.readLong()     // Catch:{ all -> 0x00cf }
            long r27 = r6.readLong()     // Catch:{ all -> 0x00cf }
            io.presage.core.IIlIlllI r0 = new io.presage.core.IIlIlllI     // Catch:{ all -> 0x00cf }
            r7 = r0
            r7.<init>(r8, r9, r10, r11, r12, r13, r15, r17, r19, r21, r23, r25, r27)     // Catch:{ all -> 0x00cf }
            r2.add(r0)     // Catch:{ all -> 0x00cf }
            goto L_0x003d
        L_0x0081:
            int r0 = r6.readInt()     // Catch:{ all -> 0x00cf }
            r7 = 0
        L_0x0086:
            if (r7 >= r0) goto L_0x00cb
            int r9 = r6.readInt()     // Catch:{ all -> 0x00cf }
            java.lang.String r10 = r6.readUTF()     // Catch:{ all -> 0x00cf }
            int r11 = r6.readInt()     // Catch:{ all -> 0x00cf }
            java.lang.String r12 = r6.readUTF()     // Catch:{ all -> 0x00cf }
            int r13 = r6.readInt()     // Catch:{ all -> 0x00cf }
            long r14 = r6.readLong()     // Catch:{ all -> 0x00cf }
            long r16 = r6.readLong()     // Catch:{ all -> 0x00cf }
            long r18 = r6.readLong()     // Catch:{ all -> 0x00cf }
            long r20 = r6.readLong()     // Catch:{ all -> 0x00cf }
            long r22 = r6.readLong()     // Catch:{ all -> 0x00cf }
            long r24 = r6.readLong()     // Catch:{ all -> 0x00cf }
            long r26 = r6.readLong()     // Catch:{ all -> 0x00cf }
            long r28 = r6.readLong()     // Catch:{ all -> 0x00cf }
            io.presage.core.IIlIlllI r8 = new io.presage.core.IIlIlllI     // Catch:{ all -> 0x00cf }
            r30 = r8
            r8 = r30
            r8.<init>(r9, r10, r11, r12, r13, r14, r16, r18, r20, r22, r24, r26, r28)     // Catch:{ all -> 0x00cf }
            r2.add(r8)     // Catch:{ all -> 0x00cf }
            int r7 = r7 + 1
            goto L_0x0086
        L_0x00cb:
            r6.close()     // Catch:{ EOFException -> 0x00e4, FileNotFoundException -> 0x00df, IOException -> 0x00d5 }
            goto L_0x00f0
        L_0x00cf:
            r0 = move-exception
            r6.close()     // Catch:{ EOFException -> 0x00e4, FileNotFoundException -> 0x00df, IOException -> 0x00d5 }
            throw r0     // Catch:{ EOFException -> 0x00e4, FileNotFoundException -> 0x00df, IOException -> 0x00d5 }
        L_0x00d4:
            return r2
        L_0x00d5:
            r0 = move-exception
            r1.IIIIIIII(r0, r3)
            r2.clear()
            if (r5 == 0) goto L_0x00f0
            goto L_0x00ed
        L_0x00df:
            r0 = move-exception
            r1.IIIIIIII(r0, r4)
            goto L_0x00f0
        L_0x00e4:
            r0 = move-exception
            r1.IIIIIIII(r0, r4)
            r2.clear()
            if (r5 == 0) goto L_0x00f0
        L_0x00ed:
            p118io.presage.core.C6313i1.IIIIIIII(r5)
        L_0x00f0:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p118io.presage.core.IllIIIII.IIIIllII():java.util.ArrayList");
    }
}
