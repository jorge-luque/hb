package p118io.presage.core;

import android.content.Context;

/* renamed from: io.presage.core.IllllllI */
public class IllllllI extends IIlllIlI<Void, byte[]> {
    public Context IIIIIIIl;
    public IIIlIIlI IIIIIIlI;
    public IIIIIIII IIIIIIll;

    /* renamed from: io.presage.core.IllllllI$IIIIIIII */
    public interface IIIIIIII {
        void IIIIIIII(IIIlIIlI iIIlIIlI, byte[] bArr);
    }

    public IllllllI(Context context, IIIlIIlI iIIlIIlI, IIIIIIII iiiiiiii) {
        this.IIIIIIIl = context;
        this.IIIIIIlI = iIIlIIlI;
        this.IIIIIIll = iiiiiiii;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object IIIIIIII(java.lang.Object[] r8) {
        /*
            r7 = this;
            java.lang.Void[] r8 = (java.lang.Void[]) r8
            io.presage.core.IIIlIIlI r8 = r7.IIIIIIlI
            io.presage.core.IlllllIl r0 = new io.presage.core.IlllllIl
            r0 = 2
            r1 = 0
            r2 = 1
            if (r8 != 0) goto L_0x000d
            goto L_0x00c6
        L_0x000d:
            int r3 = r8.IIIIIIII()     // Catch:{ IllIIIIl -> 0x00c6 }
            r4 = 1000(0x3e8, float:1.401E-42)
            if (r3 == r4) goto L_0x00bf
            if (r3 == r2) goto L_0x00b8
            if (r3 == r0) goto L_0x00b1
            r4 = 3
            if (r3 == r4) goto L_0x00aa
            r4 = 4
            if (r3 == r4) goto L_0x00a4
            r4 = 5
            if (r3 == r4) goto L_0x009e
            switch(r3) {
                case 8: goto L_0x0098;
                case 9: goto L_0x0092;
                case 10: goto L_0x008c;
                case 11: goto L_0x0086;
                case 12: goto L_0x0080;
                case 13: goto L_0x007a;
                case 14: goto L_0x0074;
                case 15: goto L_0x006e;
                case 16: goto L_0x0068;
                case 17: goto L_0x0062;
                case 18: goto L_0x005c;
                case 19: goto L_0x0056;
                case 20: goto L_0x0050;
                case 21: goto L_0x004a;
                case 22: goto L_0x0044;
                case 23: goto L_0x003e;
                case 24: goto L_0x0038;
                case 25: goto L_0x0032;
                case 26: goto L_0x0027;
                default: goto L_0x0025;
            }     // Catch:{ IllIIIIl -> 0x00c6 }
        L_0x0025:
            goto L_0x00c6
        L_0x0027:
            io.presage.core.IllIIlIl r3 = new io.presage.core.IllIIlIl     // Catch:{ IllIIIIl -> 0x00c6 }
            r3.<init>()     // Catch:{ IllIIIIl -> 0x00c6 }
        L_0x002c:
            org.json.JSONObject r8 = r3.IIIIIIII(r8)     // Catch:{ IllIIIIl -> 0x00c6 }
            goto L_0x00c7
        L_0x0032:
            io.presage.core.IllIlIII r3 = new io.presage.core.IllIlIII     // Catch:{ IllIIIIl -> 0x00c6 }
            r3.<init>()     // Catch:{ IllIIIIl -> 0x00c6 }
            goto L_0x002c
        L_0x0038:
            io.presage.core.IlllIlII r3 = new io.presage.core.IlllIlII     // Catch:{ IllIIIIl -> 0x00c6 }
            r3.<init>()     // Catch:{ IllIIIIl -> 0x00c6 }
            goto L_0x002c
        L_0x003e:
            io.presage.core.IllIllll r3 = new io.presage.core.IllIllll     // Catch:{ IllIIIIl -> 0x00c6 }
            r3.<init>()     // Catch:{ IllIIIIl -> 0x00c6 }
            goto L_0x002c
        L_0x0044:
            io.presage.core.IllllIII r3 = new io.presage.core.IllllIII     // Catch:{ IllIIIIl -> 0x00c6 }
            r3.<init>()     // Catch:{ IllIIIIl -> 0x00c6 }
            goto L_0x002c
        L_0x004a:
            io.presage.core.IllIllIl r3 = new io.presage.core.IllIllIl     // Catch:{ IllIIIIl -> 0x00c6 }
            r3.<init>()     // Catch:{ IllIIIIl -> 0x00c6 }
            goto L_0x002c
        L_0x0050:
            io.presage.core.IllIIllI r3 = new io.presage.core.IllIIllI     // Catch:{ IllIIIIl -> 0x00c6 }
            r3.<init>()     // Catch:{ IllIIIIl -> 0x00c6 }
            goto L_0x002c
        L_0x0056:
            io.presage.core.IllIlIIl r3 = new io.presage.core.IllIlIIl     // Catch:{ IllIIIIl -> 0x00c6 }
            r3.<init>()     // Catch:{ IllIIIIl -> 0x00c6 }
            goto L_0x002c
        L_0x005c:
            io.presage.core.IllIlIlI r3 = new io.presage.core.IllIlIlI     // Catch:{ IllIIIIl -> 0x00c6 }
            r3.<init>()     // Catch:{ IllIIIIl -> 0x00c6 }
            goto L_0x002c
        L_0x0062:
            io.presage.core.IllIIlII r3 = new io.presage.core.IllIIlII     // Catch:{ IllIIIIl -> 0x00c6 }
            r3.<init>()     // Catch:{ IllIIIIl -> 0x00c6 }
            goto L_0x002c
        L_0x0068:
            io.presage.core.IllllIll r3 = new io.presage.core.IllllIll     // Catch:{ IllIIIIl -> 0x00c6 }
            r3.<init>()     // Catch:{ IllIIIIl -> 0x00c6 }
            goto L_0x002c
        L_0x006e:
            io.presage.core.IlllIlIl r3 = new io.presage.core.IlllIlIl     // Catch:{ IllIIIIl -> 0x00c6 }
            r3.<init>()     // Catch:{ IllIIIIl -> 0x00c6 }
            goto L_0x002c
        L_0x0074:
            io.presage.core.IlllIIIl r3 = new io.presage.core.IlllIIIl     // Catch:{ IllIIIIl -> 0x00c6 }
            r3.<init>()     // Catch:{ IllIIIIl -> 0x00c6 }
            goto L_0x002c
        L_0x007a:
            io.presage.core.IlllIIlI r3 = new io.presage.core.IlllIIlI     // Catch:{ IllIIIIl -> 0x00c6 }
            r3.<init>()     // Catch:{ IllIIIIl -> 0x00c6 }
            goto L_0x002c
        L_0x0080:
            io.presage.core.IllIIlll r3 = new io.presage.core.IllIIlll     // Catch:{ IllIIIIl -> 0x00c6 }
            r3.<init>()     // Catch:{ IllIIIIl -> 0x00c6 }
            goto L_0x002c
        L_0x0086:
            io.presage.core.IllllIlI r3 = new io.presage.core.IllllIlI     // Catch:{ IllIIIIl -> 0x00c6 }
            r3.<init>()     // Catch:{ IllIIIIl -> 0x00c6 }
            goto L_0x002c
        L_0x008c:
            io.presage.core.IllllIIl r3 = new io.presage.core.IllllIIl     // Catch:{ IllIIIIl -> 0x00c6 }
            r3.<init>()     // Catch:{ IllIIIIl -> 0x00c6 }
            goto L_0x002c
        L_0x0092:
            io.presage.core.IlllIIll r3 = new io.presage.core.IlllIIll     // Catch:{ IllIIIIl -> 0x00c6 }
            r3.<init>()     // Catch:{ IllIIIIl -> 0x00c6 }
            goto L_0x002c
        L_0x0098:
            io.presage.core.IlllIIII r3 = new io.presage.core.IlllIIII     // Catch:{ IllIIIIl -> 0x00c6 }
            r3.<init>()     // Catch:{ IllIIIIl -> 0x00c6 }
            goto L_0x002c
        L_0x009e:
            io.presage.core.IllIlIll r3 = new io.presage.core.IllIlIll     // Catch:{ IllIIIIl -> 0x00c6 }
            r3.<init>()     // Catch:{ IllIIIIl -> 0x00c6 }
            goto L_0x002c
        L_0x00a4:
            io.presage.core.IlllIlll r3 = new io.presage.core.IlllIlll     // Catch:{ IllIIIIl -> 0x00c6 }
            r3.<init>()     // Catch:{ IllIIIIl -> 0x00c6 }
            goto L_0x002c
        L_0x00aa:
            io.presage.core.IlllIllI r3 = new io.presage.core.IlllIllI     // Catch:{ IllIIIIl -> 0x00c6 }
            r3.<init>()     // Catch:{ IllIIIIl -> 0x00c6 }
            goto L_0x002c
        L_0x00b1:
            io.presage.core.IllIllII r3 = new io.presage.core.IllIllII     // Catch:{ IllIIIIl -> 0x00c6 }
            r3.<init>()     // Catch:{ IllIIIIl -> 0x00c6 }
            goto L_0x002c
        L_0x00b8:
            io.presage.core.IllIlllI r3 = new io.presage.core.IllIlllI     // Catch:{ IllIIIIl -> 0x00c6 }
            r3.<init>()     // Catch:{ IllIIIIl -> 0x00c6 }
            goto L_0x002c
        L_0x00bf:
            io.presage.core.IlllllII r3 = new io.presage.core.IlllllII     // Catch:{ IllIIIIl -> 0x00c6 }
            r3.<init>()     // Catch:{ IllIIIIl -> 0x00c6 }
            goto L_0x002c
        L_0x00c6:
            r8 = r1
        L_0x00c7:
            if (r8 != 0) goto L_0x00cb
            goto L_0x013d
        L_0x00cb:
            java.lang.String r8 = r8.toString()
            java.lang.String r3 = p118io.presage.core.IlllllIl.IIIIIIlI
            java.lang.String r4 = "prod"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x00da
            goto L_0x0125
        L_0x00da:
            java.lang.String r3 = new java.lang.String     // Catch:{ Exception -> 0x0120 }
            io.presage.core.s1 r4 = new io.presage.core.s1     // Catch:{ Exception -> 0x0120 }
            r4.<init>()     // Catch:{ Exception -> 0x0120 }
            r5 = 0
            io.presage.core.s1 r4 = r4.IIIIIIII((int) r5)     // Catch:{ Exception -> 0x0120 }
            io.presage.core.y1 r5 = new io.presage.core.y1     // Catch:{ Exception -> 0x0120 }
            r5.<init>()     // Catch:{ Exception -> 0x0120 }
            io.presage.core.y1 r5 = r5.IIIIIIII((int) r2)     // Catch:{ Exception -> 0x0120 }
            java.lang.String r6 = p118io.presage.core.IlllllIl.IIIIIIII     // Catch:{ Exception -> 0x0120 }
            byte[] r6 = r6.getBytes()     // Catch:{ Exception -> 0x0120 }
            java.lang.String r5 = r5.IIIIIIII((byte[]) r6)     // Catch:{ Exception -> 0x0120 }
            byte[] r5 = r5.getBytes()     // Catch:{ Exception -> 0x0120 }
            io.presage.core.s1 r4 = r4.IIIIIIlI(r5)     // Catch:{ Exception -> 0x0120 }
            io.presage.core.s1 r0 = r4.IIIIIIII((int) r0)     // Catch:{ Exception -> 0x0120 }
            io.presage.core.s1 r0 = r0.IIIIIIII((int) r2)     // Catch:{ Exception -> 0x0120 }
            java.lang.String r4 = p118io.presage.core.IlllllIl.IIIIIIIl     // Catch:{ Exception -> 0x0120 }
            byte[] r4 = r4.getBytes()     // Catch:{ Exception -> 0x0120 }
            io.presage.core.s1 r0 = r0.IIIIIIlI(r4)     // Catch:{ Exception -> 0x0120 }
            byte[] r8 = r8.getBytes()     // Catch:{ Exception -> 0x0120 }
            byte[] r8 = r0.IIIIIIIl(r8)     // Catch:{ Exception -> 0x0120 }
            r3.<init>(r8)     // Catch:{ Exception -> 0x0120 }
            r8 = r3
            goto L_0x0125
        L_0x0120:
            r8 = move-exception
            p118io.presage.core.lIIIIlIl.IIIIIIII(r8, r2)
            r8 = r1
        L_0x0125:
            if (r8 != 0) goto L_0x0128
            goto L_0x013d
        L_0x0128:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r8)
            java.lang.String r8 = p118io.presage.core.C6347r.IIIIIIIl
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            byte[] r1 = r8.getBytes()
        L_0x013d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p118io.presage.core.IllllllI.IIIIIIII(java.lang.Object[]):java.lang.Object");
    }

    public void IIIIIIII(Object obj) {
        byte[] bArr = (byte[]) obj;
        IIIIIIII iiiiiiii = this.IIIIIIll;
        if (iiiiiiii != null) {
            iiiiiiii.IIIIIIII(this.IIIIIIlI, bArr);
        }
    }
}
