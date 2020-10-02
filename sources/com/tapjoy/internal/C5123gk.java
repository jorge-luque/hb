package com.tapjoy.internal;

import com.ogury.p159cm.OguryChoiceManager;

/* renamed from: com.tapjoy.internal.gk */
public final class C5123gk {

    /* renamed from: a */
    public long f14028a;

    /* renamed from: b */
    public long f14029b;

    /* renamed from: c */
    public long f14030c;

    /* renamed from: b */
    private static long m17279b(byte[] bArr, int i) {
        return ((m17278a(bArr, i) - 2208988800L) * 1000) + ((m17278a(bArr, i + 4) * 1000) / 4294967296L);
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo31304a(java.lang.String r20, int r21) {
        /*
            r19 = this;
            r1 = r19
            r0 = 0
            r2 = 0
            java.net.DatagramSocket r3 = new java.net.DatagramSocket     // Catch:{ Exception -> 0x00fe, all -> 0x00f6 }
            r3.<init>()     // Catch:{ Exception -> 0x00fe, all -> 0x00f6 }
            r2 = r21
            r3.setSoTimeout(r2)     // Catch:{ Exception -> 0x00f2, all -> 0x00ed }
            java.net.InetAddress r2 = java.net.InetAddress.getByName(r20)     // Catch:{ Exception -> 0x00f2, all -> 0x00ed }
            r4 = 48
            byte[] r5 = new byte[r4]     // Catch:{ Exception -> 0x00f2, all -> 0x00ed }
            java.net.DatagramPacket r6 = new java.net.DatagramPacket     // Catch:{ Exception -> 0x00f2, all -> 0x00ed }
            r7 = 123(0x7b, float:1.72E-43)
            r6.<init>(r5, r4, r2, r7)     // Catch:{ Exception -> 0x00f2, all -> 0x00ed }
            r2 = 27
            r5[r0] = r2     // Catch:{ Exception -> 0x00f2, all -> 0x00ed }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00f2, all -> 0x00ed }
            long r9 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x00f2, all -> 0x00ed }
            r11 = 1000(0x3e8, double:4.94E-321)
            long r13 = r7 / r11
            java.lang.Long.signum(r13)
            long r15 = r13 * r11
            long r15 = r7 - r15
            r17 = 2208988800(0x83aa7e80, double:1.091385478E-314)
            long r13 = r13 + r17
            r2 = 24
            long r11 = r13 >> r2
            int r12 = (int) r11
            byte r11 = (byte) r12
            r12 = 40
            r5[r12] = r11     // Catch:{ Exception -> 0x00f2, all -> 0x00ed }
            r11 = 41
            r17 = 16
            r18 = r3
            long r2 = r13 >> r17
            int r3 = (int) r2
            byte r2 = (byte) r3
            r5[r11] = r2     // Catch:{ Exception -> 0x00e9, all -> 0x00e4 }
            r2 = 42
            r3 = 8
            long r0 = r13 >> r3
            int r1 = (int) r0
            byte r0 = (byte) r1
            r5[r2] = r0     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            r0 = 43
            r1 = 0
            long r13 = r13 >> r1
            int r1 = (int) r13     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            byte r1 = (byte) r1     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            r5[r0] = r1     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            r0 = 4294967296(0x100000000, double:2.121995791E-314)
            long r15 = r15 * r0
            r0 = 1000(0x3e8, double:4.94E-321)
            long r15 = r15 / r0
            r0 = 44
            r1 = 24
            long r13 = r15 >> r1
            int r1 = (int) r13     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            byte r1 = (byte) r1     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            r5[r0] = r1     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            r0 = 45
            long r1 = r15 >> r17
            int r2 = (int) r1     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            byte r1 = (byte) r2     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            r5[r0] = r1     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            r0 = 46
            long r1 = r15 >> r3
            int r2 = (int) r1     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            byte r1 = (byte) r2     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            r5[r0] = r1     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            r0 = 47
            double r1 = java.lang.Math.random()     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            r13 = 4643176031446892544(0x406fe00000000000, double:255.0)
            double r1 = r1 * r13
            int r1 = (int) r1     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            byte r1 = (byte) r1     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            r5[r0] = r1     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            r1 = r18
            r1.send(r6)     // Catch:{ Exception -> 0x00da, all -> 0x00d6 }
            java.net.DatagramPacket r0 = new java.net.DatagramPacket     // Catch:{ Exception -> 0x00da, all -> 0x00d6 }
            r0.<init>(r5, r4)     // Catch:{ Exception -> 0x00da, all -> 0x00d6 }
            r1.receive(r0)     // Catch:{ Exception -> 0x00da, all -> 0x00d6 }
            long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x00da, all -> 0x00d6 }
            long r9 = r2 - r9
            long r7 = r7 + r9
            r0 = 24
            long r13 = m17279b(r5, r0)     // Catch:{ Exception -> 0x00da, all -> 0x00d6 }
            r0 = 32
            long r15 = m17279b(r5, r0)     // Catch:{ Exception -> 0x00da, all -> 0x00d6 }
            long r4 = m17279b(r5, r12)     // Catch:{ Exception -> 0x00da, all -> 0x00d6 }
            long r17 = r4 - r15
            long r9 = r9 - r17
            long r15 = r15 - r13
            long r4 = r4 - r7
            long r15 = r15 + r4
            r4 = 2
            long r15 = r15 / r4
            long r7 = r7 + r15
            r4 = r19
            r4.f14028a = r7     // Catch:{ Exception -> 0x00f4, all -> 0x00d4 }
            r4.f14029b = r2     // Catch:{ Exception -> 0x00f4, all -> 0x00d4 }
            r4.f14030c = r9     // Catch:{ Exception -> 0x00f4, all -> 0x00d4 }
            r1.close()
            r0 = 1
            return r0
        L_0x00d4:
            r0 = move-exception
            goto L_0x00f0
        L_0x00d6:
            r0 = move-exception
            r4 = r19
            goto L_0x00f0
        L_0x00da:
            r4 = r19
            goto L_0x00f4
        L_0x00dd:
            r0 = move-exception
            r4 = r19
            goto L_0x00e6
        L_0x00e1:
            r4 = r19
            goto L_0x00ea
        L_0x00e4:
            r0 = move-exception
            r4 = r1
        L_0x00e6:
            r1 = r18
            goto L_0x00f0
        L_0x00e9:
            r4 = r1
        L_0x00ea:
            r1 = r18
            goto L_0x00f4
        L_0x00ed:
            r0 = move-exception
            r4 = r1
            r1 = r3
        L_0x00f0:
            r2 = r1
            goto L_0x00f8
        L_0x00f2:
            r4 = r1
            r1 = r3
        L_0x00f4:
            r2 = r1
            goto L_0x00ff
        L_0x00f6:
            r0 = move-exception
            r4 = r1
        L_0x00f8:
            if (r2 == 0) goto L_0x00fd
            r2.close()
        L_0x00fd:
            throw r0
        L_0x00fe:
            r4 = r1
        L_0x00ff:
            if (r2 == 0) goto L_0x0104
            r2.close()
        L_0x0104:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C5123gk.mo31304a(java.lang.String, int):boolean");
    }

    /* renamed from: a */
    private static long m17278a(byte[] bArr, int i) {
        byte b = bArr[i];
        byte b2 = bArr[i + 1];
        byte b3 = bArr[i + 2];
        byte b4 = bArr[i + 3];
        byte b5 = b & true;
        int i2 = b;
        if (b5 == true) {
            i2 = (b & Byte.MAX_VALUE) + 128;
        }
        byte b6 = b2 & true;
        int i3 = b2;
        if (b6 == true) {
            i3 = (b2 & Byte.MAX_VALUE) + 128;
        }
        byte b7 = b3 & true;
        int i4 = b3;
        if (b7 == true) {
            i4 = (b3 & Byte.MAX_VALUE) + 128;
        }
        byte b8 = b4 & true;
        int i5 = b4;
        if (b8 == true) {
            i5 = (b4 & Byte.MAX_VALUE) + OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
        }
        return (((long) i2) << 24) + (((long) i3) << 16) + (((long) i4) << 8) + ((long) i5);
    }
}
