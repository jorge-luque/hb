package com.tapjoy.internal;

import android.graphics.Bitmap;
import android.os.Build;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* renamed from: com.tapjoy.internal.ic */
public class C3161ic {

    /* renamed from: d */
    private static final String f8819d = "ic";

    /* renamed from: a */
    int f8820a;

    /* renamed from: b */
    int f8821b;

    /* renamed from: c */
    C5189ie f8822c;

    /* renamed from: e */
    private int[] f8823e;

    /* renamed from: f */
    private final int[] f8824f;

    /* renamed from: g */
    private ByteBuffer f8825g;

    /* renamed from: h */
    private byte[] f8826h;
    @Nullable

    /* renamed from: i */
    private byte[] f8827i;

    /* renamed from: j */
    private int f8828j;

    /* renamed from: k */
    private int f8829k;

    /* renamed from: l */
    private C5190if f8830l;

    /* renamed from: m */
    private short[] f8831m;

    /* renamed from: n */
    private byte[] f8832n;

    /* renamed from: o */
    private byte[] f8833o;

    /* renamed from: p */
    private byte[] f8834p;

    /* renamed from: q */
    private int[] f8835q;

    /* renamed from: r */
    private C3162a f8836r;

    /* renamed from: s */
    private Bitmap f8837s;

    /* renamed from: t */
    private boolean f8838t;

    /* renamed from: u */
    private int f8839u;

    /* renamed from: v */
    private int f8840v;

    /* renamed from: w */
    private int f8841w;

    /* renamed from: x */
    private int f8842x;

    /* renamed from: y */
    private boolean f8843y;

    /* renamed from: com.tapjoy.internal.ic$a */
    interface C3162a {
        @Nonnull
        /* renamed from: a */
        Bitmap mo18617a(int i, int i2, Bitmap.Config config);

        /* renamed from: a */
        byte[] mo18618a(int i);

        /* renamed from: b */
        int[] mo18619b(int i);
    }

    C3161ic(C3162a aVar, C5189ie ieVar, ByteBuffer byteBuffer) {
        this(aVar, ieVar, byteBuffer, (byte) 0);
    }

    /* renamed from: b */
    private synchronized void m10415b(C5189ie ieVar, ByteBuffer byteBuffer) {
        int highestOneBit = Integer.highestOneBit(1);
        this.f8839u = 0;
        this.f8822c = ieVar;
        this.f8843y = false;
        this.f8820a = -1;
        this.f8821b = 0;
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f8825g = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.f8825g.order(ByteOrder.LITTLE_ENDIAN);
        this.f8838t = false;
        Iterator it = ieVar.f14230e.iterator();
        while (true) {
            if (it.hasNext()) {
                if (((C5188id) it.next()).f14221g == 3) {
                    this.f8838t = true;
                    break;
                }
            } else {
                break;
            }
        }
        this.f8840v = highestOneBit;
        this.f8842x = ieVar.f14231f / highestOneBit;
        this.f8841w = ieVar.f14232g / highestOneBit;
        this.f8834p = this.f8836r.mo18618a(ieVar.f14231f * ieVar.f14232g);
        this.f8835q = this.f8836r.mo18619b(this.f8842x * this.f8841w);
    }

    /* renamed from: c */
    private int m10416c() {
        try {
            m10414b();
            byte[] bArr = this.f8827i;
            int i = this.f8829k;
            this.f8829k = i + 1;
            return bArr[i] & 255;
        } catch (Exception unused) {
            this.f8839u = 1;
            return 0;
        }
    }

    /* renamed from: d */
    private int m10417d() {
        int c = m10416c();
        if (c > 0) {
            try {
                if (this.f8826h == null) {
                    this.f8826h = this.f8836r.mo18618a(255);
                }
                int i = this.f8828j - this.f8829k;
                if (i >= c) {
                    System.arraycopy(this.f8827i, this.f8829k, this.f8826h, 0, c);
                    this.f8829k += c;
                } else if (this.f8825g.remaining() + i >= c) {
                    System.arraycopy(this.f8827i, this.f8829k, this.f8826h, 0, i);
                    this.f8829k = this.f8828j;
                    m10414b();
                    int i2 = c - i;
                    System.arraycopy(this.f8827i, 0, this.f8826h, i, i2);
                    this.f8829k += i2;
                } else {
                    this.f8839u = 1;
                }
            } catch (Exception unused) {
                this.f8839u = 1;
            }
        }
        return c;
    }

    /* renamed from: e */
    private Bitmap m10418e() {
        Bitmap a = this.f8836r.mo18617a(this.f8842x, this.f8841w, this.f8843y ? Bitmap.Config.ARGB_4444 : Bitmap.Config.RGB_565);
        if (Build.VERSION.SDK_INT >= 12) {
            a.setHasAlpha(true);
        }
        return a;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v36, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x021e, code lost:
        r20 = r0;
        r23 = r2;
        r21 = r9;
        r8 = r25;
        r16 = r26;
        r2 = -1;
        r25 = r7;
        r7 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x03d5, code lost:
        return null;
     */
    /* JADX WARNING: Incorrect type for immutable var: ssa=short, code=int, for r4v29, types: [short] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0203 A[LOOP:4: B:115:0x0201->B:116:0x0203, LOOP_END] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized android.graphics.Bitmap mo18616a() {
        /*
            r29 = this;
            r1 = r29
            monitor-enter(r29)
            com.tapjoy.internal.ie r0 = r1.f8822c     // Catch:{ all -> 0x03d6 }
            int r0 = r0.f14228c     // Catch:{ all -> 0x03d6 }
            r2 = 1
            if (r0 <= 0) goto L_0x000e
            int r0 = r1.f8820a     // Catch:{ all -> 0x03d6 }
            if (r0 >= 0) goto L_0x0014
        L_0x000e:
            com.tapjoy.internal.ie r0 = r1.f8822c     // Catch:{ all -> 0x03d6 }
            int r0 = r0.f14228c     // Catch:{ all -> 0x03d6 }
            r1.f8839u = r2     // Catch:{ all -> 0x03d6 }
        L_0x0014:
            int r0 = r1.f8839u     // Catch:{ all -> 0x03d6 }
            r3 = 0
            if (r0 == r2) goto L_0x03d4
            int r0 = r1.f8839u     // Catch:{ all -> 0x03d6 }
            r4 = 2
            if (r0 != r4) goto L_0x0020
            goto L_0x03d4
        L_0x0020:
            r0 = 0
            r1.f8839u = r0     // Catch:{ all -> 0x03d6 }
            com.tapjoy.internal.ie r5 = r1.f8822c     // Catch:{ all -> 0x03d6 }
            java.util.List r5 = r5.f14230e     // Catch:{ all -> 0x03d6 }
            int r6 = r1.f8820a     // Catch:{ all -> 0x03d6 }
            java.lang.Object r5 = r5.get(r6)     // Catch:{ all -> 0x03d6 }
            com.tapjoy.internal.id r5 = (com.tapjoy.internal.C5188id) r5     // Catch:{ all -> 0x03d6 }
            int r6 = r1.f8820a     // Catch:{ all -> 0x03d6 }
            int r6 = r6 - r2
            if (r6 < 0) goto L_0x003f
            com.tapjoy.internal.ie r7 = r1.f8822c     // Catch:{ all -> 0x03d6 }
            java.util.List r7 = r7.f14230e     // Catch:{ all -> 0x03d6 }
            java.lang.Object r6 = r7.get(r6)     // Catch:{ all -> 0x03d6 }
            com.tapjoy.internal.id r6 = (com.tapjoy.internal.C5188id) r6     // Catch:{ all -> 0x03d6 }
            goto L_0x0040
        L_0x003f:
            r6 = r3
        L_0x0040:
            int[] r7 = r5.f14225k     // Catch:{ all -> 0x03d6 }
            if (r7 == 0) goto L_0x0047
            int[] r7 = r5.f14225k     // Catch:{ all -> 0x03d6 }
            goto L_0x004b
        L_0x0047:
            com.tapjoy.internal.ie r7 = r1.f8822c     // Catch:{ all -> 0x03d6 }
            int[] r7 = r7.f14226a     // Catch:{ all -> 0x03d6 }
        L_0x004b:
            r1.f8823e = r7     // Catch:{ all -> 0x03d6 }
            if (r7 != 0) goto L_0x0053
            r1.f8839u = r2     // Catch:{ all -> 0x03d6 }
            monitor-exit(r29)
            return r3
        L_0x0053:
            boolean r3 = r5.f14220f     // Catch:{ all -> 0x03d6 }
            if (r3 == 0) goto L_0x0065
            int[] r3 = r1.f8824f     // Catch:{ all -> 0x03d6 }
            int r8 = r7.length     // Catch:{ all -> 0x03d6 }
            java.lang.System.arraycopy(r7, r0, r3, r0, r8)     // Catch:{ all -> 0x03d6 }
            int[] r3 = r1.f8824f     // Catch:{ all -> 0x03d6 }
            r1.f8823e = r3     // Catch:{ all -> 0x03d6 }
            int r7 = r5.f14222h     // Catch:{ all -> 0x03d6 }
            r3[r7] = r0     // Catch:{ all -> 0x03d6 }
        L_0x0065:
            int[] r3 = r1.f8835q     // Catch:{ all -> 0x03d6 }
            if (r6 != 0) goto L_0x006c
            java.util.Arrays.fill(r3, r0)     // Catch:{ all -> 0x03d6 }
        L_0x006c:
            r7 = 3
            if (r6 == 0) goto L_0x00c9
            int r8 = r6.f14221g     // Catch:{ all -> 0x03d6 }
            if (r8 <= 0) goto L_0x00c9
            int r8 = r6.f14221g     // Catch:{ all -> 0x03d6 }
            if (r8 != r4) goto L_0x0097
            boolean r8 = r5.f14220f     // Catch:{ all -> 0x03d6 }
            if (r8 != 0) goto L_0x008c
            com.tapjoy.internal.ie r8 = r1.f8822c     // Catch:{ all -> 0x03d6 }
            int r8 = r8.f14237l     // Catch:{ all -> 0x03d6 }
            int[] r9 = r5.f14225k     // Catch:{ all -> 0x03d6 }
            if (r9 == 0) goto L_0x0093
            com.tapjoy.internal.ie r9 = r1.f8822c     // Catch:{ all -> 0x03d6 }
            int r9 = r9.f14235j     // Catch:{ all -> 0x03d6 }
            int r10 = r5.f14222h     // Catch:{ all -> 0x03d6 }
            if (r9 != r10) goto L_0x0093
            goto L_0x0092
        L_0x008c:
            int r8 = r1.f8820a     // Catch:{ all -> 0x03d6 }
            if (r8 != 0) goto L_0x0092
            r1.f8843y = r2     // Catch:{ all -> 0x03d6 }
        L_0x0092:
            r8 = 0
        L_0x0093:
            r1.m10413a(r3, r6, r8)     // Catch:{ all -> 0x03d6 }
            goto L_0x00c9
        L_0x0097:
            int r8 = r6.f14221g     // Catch:{ all -> 0x03d6 }
            if (r8 != r7) goto L_0x00c9
            android.graphics.Bitmap r8 = r1.f8837s     // Catch:{ all -> 0x03d6 }
            if (r8 != 0) goto L_0x00a3
            r1.m10413a(r3, r6, r0)     // Catch:{ all -> 0x03d6 }
            goto L_0x00c9
        L_0x00a3:
            int r8 = r6.f14218d     // Catch:{ all -> 0x03d6 }
            int r9 = r1.f8840v     // Catch:{ all -> 0x03d6 }
            int r15 = r8 / r9
            int r8 = r6.f14216b     // Catch:{ all -> 0x03d6 }
            int r9 = r1.f8840v     // Catch:{ all -> 0x03d6 }
            int r13 = r8 / r9
            int r8 = r6.f14217c     // Catch:{ all -> 0x03d6 }
            int r9 = r1.f8840v     // Catch:{ all -> 0x03d6 }
            int r14 = r8 / r9
            int r6 = r6.f14215a     // Catch:{ all -> 0x03d6 }
            int r8 = r1.f8840v     // Catch:{ all -> 0x03d6 }
            int r12 = r6 / r8
            int r6 = r1.f8842x     // Catch:{ all -> 0x03d6 }
            int r6 = r6 * r13
            int r10 = r6 + r12
            android.graphics.Bitmap r8 = r1.f8837s     // Catch:{ all -> 0x03d6 }
            int r11 = r1.f8842x     // Catch:{ all -> 0x03d6 }
            r9 = r3
            r8.getPixels(r9, r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x03d6 }
        L_0x00c9:
            r1.f8828j = r0     // Catch:{ all -> 0x03d6 }
            r1.f8829k = r0     // Catch:{ all -> 0x03d6 }
            if (r5 == 0) goto L_0x00d6
            java.nio.ByteBuffer r6 = r1.f8825g     // Catch:{ all -> 0x03d6 }
            int r8 = r5.f14224j     // Catch:{ all -> 0x03d6 }
            r6.position(r8)     // Catch:{ all -> 0x03d6 }
        L_0x00d6:
            if (r5 != 0) goto L_0x00e3
            com.tapjoy.internal.ie r6 = r1.f8822c     // Catch:{ all -> 0x03d6 }
            int r6 = r6.f14231f     // Catch:{ all -> 0x03d6 }
            com.tapjoy.internal.ie r8 = r1.f8822c     // Catch:{ all -> 0x03d6 }
            int r8 = r8.f14232g     // Catch:{ all -> 0x03d6 }
        L_0x00e0:
            int r6 = r6 * r8
            goto L_0x00e8
        L_0x00e3:
            int r6 = r5.f14217c     // Catch:{ all -> 0x03d6 }
            int r8 = r5.f14218d     // Catch:{ all -> 0x03d6 }
            goto L_0x00e0
        L_0x00e8:
            byte[] r8 = r1.f8834p     // Catch:{ all -> 0x03d6 }
            if (r8 == 0) goto L_0x00f1
            byte[] r8 = r1.f8834p     // Catch:{ all -> 0x03d6 }
            int r8 = r8.length     // Catch:{ all -> 0x03d6 }
            if (r8 >= r6) goto L_0x00f9
        L_0x00f1:
            com.tapjoy.internal.ic$a r8 = r1.f8836r     // Catch:{ all -> 0x03d6 }
            byte[] r8 = r8.mo18618a(r6)     // Catch:{ all -> 0x03d6 }
            r1.f8834p = r8     // Catch:{ all -> 0x03d6 }
        L_0x00f9:
            short[] r8 = r1.f8831m     // Catch:{ all -> 0x03d6 }
            r9 = 4096(0x1000, float:5.74E-42)
            if (r8 != 0) goto L_0x0103
            short[] r8 = new short[r9]     // Catch:{ all -> 0x03d6 }
            r1.f8831m = r8     // Catch:{ all -> 0x03d6 }
        L_0x0103:
            byte[] r8 = r1.f8832n     // Catch:{ all -> 0x03d6 }
            if (r8 != 0) goto L_0x010b
            byte[] r8 = new byte[r9]     // Catch:{ all -> 0x03d6 }
            r1.f8832n = r8     // Catch:{ all -> 0x03d6 }
        L_0x010b:
            byte[] r8 = r1.f8833o     // Catch:{ all -> 0x03d6 }
            if (r8 != 0) goto L_0x0115
            r8 = 4097(0x1001, float:5.741E-42)
            byte[] r8 = new byte[r8]     // Catch:{ all -> 0x03d6 }
            r1.f8833o = r8     // Catch:{ all -> 0x03d6 }
        L_0x0115:
            int r8 = r29.m10416c()     // Catch:{ all -> 0x03d6 }
            int r10 = r2 << r8
            int r11 = r10 + 1
            int r12 = r10 + 2
            int r8 = r8 + r2
            int r13 = r2 << r8
            int r13 = r13 - r2
            r14 = 0
        L_0x0124:
            if (r14 >= r10) goto L_0x0133
            short[] r15 = r1.f8831m     // Catch:{ all -> 0x03d6 }
            r15[r14] = r0     // Catch:{ all -> 0x03d6 }
            byte[] r15 = r1.f8832n     // Catch:{ all -> 0x03d6 }
            byte r2 = (byte) r14     // Catch:{ all -> 0x03d6 }
            r15[r14] = r2     // Catch:{ all -> 0x03d6 }
            int r14 = r14 + 1
            r2 = 1
            goto L_0x0124
        L_0x0133:
            r2 = -1
            r25 = r8
            r23 = r12
            r24 = r13
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = -1
            r21 = 0
            r22 = 0
        L_0x014a:
            r26 = 8
            if (r14 >= r6) goto L_0x0244
            if (r15 != 0) goto L_0x015c
            int r15 = r29.m10417d()     // Catch:{ all -> 0x03d6 }
            if (r15 > 0) goto L_0x015a
            r1.f8839u = r7     // Catch:{ all -> 0x03d6 }
            goto L_0x0244
        L_0x015a:
            r18 = 0
        L_0x015c:
            byte[] r4 = r1.f8826h     // Catch:{ all -> 0x03d6 }
            byte r4 = r4[r18]     // Catch:{ all -> 0x03d6 }
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r4 = r4 << r16
            int r17 = r17 + r4
            int r16 = r16 + 8
            int r18 = r18 + 1
            int r15 = r15 + r2
            r4 = r16
            r0 = r20
            r9 = r21
            r2 = r23
            r7 = r25
        L_0x0175:
            if (r4 < r7) goto L_0x0232
            r25 = r8
            r8 = r17 & r24
            int r17 = r17 >> r7
            int r4 = r4 - r7
            if (r8 != r10) goto L_0x0188
            r2 = r12
            r24 = r13
            r7 = r25
            r8 = r7
            r0 = -1
            goto L_0x0175
        L_0x0188:
            if (r8 <= r2) goto L_0x0191
            r26 = r4
            r4 = 3
            r1.f8839u = r4     // Catch:{ all -> 0x03d6 }
            goto L_0x021e
        L_0x0191:
            r26 = r4
            if (r8 == r11) goto L_0x021e
            r4 = -1
            if (r0 != r4) goto L_0x01ab
            byte[] r0 = r1.f8833o     // Catch:{ all -> 0x03d6 }
            int r9 = r22 + 1
            byte[] r4 = r1.f8832n     // Catch:{ all -> 0x03d6 }
            byte r4 = r4[r8]     // Catch:{ all -> 0x03d6 }
            r0[r22] = r4     // Catch:{ all -> 0x03d6 }
            r0 = r8
            r22 = r9
            r4 = r26
            r9 = r0
            r8 = r25
            goto L_0x0175
        L_0x01ab:
            if (r8 < r2) goto L_0x01b8
            byte[] r4 = r1.f8833o     // Catch:{ all -> 0x03d6 }
            int r27 = r22 + 1
            byte r9 = (byte) r9     // Catch:{ all -> 0x03d6 }
            r4[r22] = r9     // Catch:{ all -> 0x03d6 }
            r4 = r0
            r22 = r27
            goto L_0x01b9
        L_0x01b8:
            r4 = r8
        L_0x01b9:
            if (r4 < r10) goto L_0x01d0
            byte[] r9 = r1.f8833o     // Catch:{ all -> 0x03d6 }
            int r27 = r22 + 1
            r28 = r8
            byte[] r8 = r1.f8832n     // Catch:{ all -> 0x03d6 }
            byte r8 = r8[r4]     // Catch:{ all -> 0x03d6 }
            r9[r22] = r8     // Catch:{ all -> 0x03d6 }
            short[] r8 = r1.f8831m     // Catch:{ all -> 0x03d6 }
            short r4 = r8[r4]     // Catch:{ all -> 0x03d6 }
            r22 = r27
            r8 = r28
            goto L_0x01b9
        L_0x01d0:
            r28 = r8
            byte[] r8 = r1.f8832n     // Catch:{ all -> 0x03d6 }
            byte r4 = r8[r4]     // Catch:{ all -> 0x03d6 }
            r9 = r4 & 255(0xff, float:3.57E-43)
            byte[] r4 = r1.f8833o     // Catch:{ all -> 0x03d6 }
            int r8 = r22 + 1
            r27 = r8
            byte r8 = (byte) r9     // Catch:{ all -> 0x03d6 }
            r4[r22] = r8     // Catch:{ all -> 0x03d6 }
            r4 = 4096(0x1000, float:5.74E-42)
            if (r2 >= r4) goto L_0x01fd
            short[] r4 = r1.f8831m     // Catch:{ all -> 0x03d6 }
            short r0 = (short) r0     // Catch:{ all -> 0x03d6 }
            r4[r2] = r0     // Catch:{ all -> 0x03d6 }
            byte[] r0 = r1.f8832n     // Catch:{ all -> 0x03d6 }
            r0[r2] = r8     // Catch:{ all -> 0x03d6 }
            int r2 = r2 + 1
            r0 = r2 & r24
            if (r0 != 0) goto L_0x01fd
            r8 = 4096(0x1000, float:5.74E-42)
            if (r2 >= r8) goto L_0x01ff
            int r7 = r7 + 1
            int r24 = r24 + r2
            goto L_0x01ff
        L_0x01fd:
            r8 = 4096(0x1000, float:5.74E-42)
        L_0x01ff:
            r22 = r27
        L_0x0201:
            if (r22 <= 0) goto L_0x0216
            byte[] r0 = r1.f8834p     // Catch:{ all -> 0x03d6 }
            int r4 = r19 + 1
            byte[] r8 = r1.f8833o     // Catch:{ all -> 0x03d6 }
            int r22 = r22 + -1
            byte r8 = r8[r22]     // Catch:{ all -> 0x03d6 }
            r0[r19] = r8     // Catch:{ all -> 0x03d6 }
            int r14 = r14 + 1
            r19 = r4
            r8 = 4096(0x1000, float:5.74E-42)
            goto L_0x0201
        L_0x0216:
            r8 = r25
            r4 = r26
            r0 = r28
            goto L_0x0175
        L_0x021e:
            r20 = r0
            r23 = r2
            r21 = r9
            r8 = r25
            r16 = r26
            r0 = 0
            r2 = -1
            r4 = 2
            r9 = 4096(0x1000, float:5.74E-42)
            r25 = r7
            r7 = 3
            goto L_0x014a
        L_0x0232:
            r20 = r0
            r23 = r2
            r16 = r4
            r25 = r7
            r21 = r9
            r0 = 0
            r2 = -1
            r4 = 2
            r7 = 3
            r9 = 4096(0x1000, float:5.74E-42)
            goto L_0x014a
        L_0x0244:
            r0 = r19
        L_0x0246:
            if (r0 >= r6) goto L_0x0250
            byte[] r2 = r1.f8834p     // Catch:{ all -> 0x03d6 }
            r4 = 0
            r2[r0] = r4     // Catch:{ all -> 0x03d6 }
            int r0 = r0 + 1
            goto L_0x0246
        L_0x0250:
            r4 = 0
            int r0 = r5.f14218d     // Catch:{ all -> 0x03d6 }
            int r2 = r1.f8840v     // Catch:{ all -> 0x03d6 }
            int r0 = r0 / r2
            int r2 = r5.f14216b     // Catch:{ all -> 0x03d6 }
            int r6 = r1.f8840v     // Catch:{ all -> 0x03d6 }
            int r2 = r2 / r6
            int r6 = r5.f14217c     // Catch:{ all -> 0x03d6 }
            int r7 = r1.f8840v     // Catch:{ all -> 0x03d6 }
            int r6 = r6 / r7
            int r7 = r5.f14215a     // Catch:{ all -> 0x03d6 }
            int r8 = r1.f8840v     // Catch:{ all -> 0x03d6 }
            int r7 = r7 / r8
            int r8 = r1.f8820a     // Catch:{ all -> 0x03d6 }
            if (r8 != 0) goto L_0x026b
            r8 = 1
            goto L_0x026c
        L_0x026b:
            r8 = 0
        L_0x026c:
            r9 = 0
            r10 = 1
            r11 = 0
            r12 = 8
        L_0x0271:
            if (r11 >= r0) goto L_0x039a
            boolean r13 = r5.f14219e     // Catch:{ all -> 0x03d6 }
            if (r13 == 0) goto L_0x0293
            r13 = 4
            if (r9 < r0) goto L_0x028e
            int r10 = r10 + 1
            r14 = 2
            if (r10 == r14) goto L_0x028b
            r15 = 3
            if (r10 == r15) goto L_0x0288
            if (r10 == r13) goto L_0x0285
            goto L_0x0290
        L_0x0285:
            r9 = 1
            r12 = 2
            goto L_0x0290
        L_0x0288:
            r9 = 2
            r12 = 4
            goto L_0x0290
        L_0x028b:
            r15 = 3
            r9 = 4
            goto L_0x0290
        L_0x028e:
            r14 = 2
            r15 = 3
        L_0x0290:
            int r13 = r9 + r12
            goto L_0x0297
        L_0x0293:
            r14 = 2
            r15 = 3
            r13 = r9
            r9 = r11
        L_0x0297:
            int r9 = r9 + r2
            int r4 = r1.f8841w     // Catch:{ all -> 0x03d6 }
            if (r9 >= r4) goto L_0x0384
            int r4 = r1.f8842x     // Catch:{ all -> 0x03d6 }
            int r9 = r9 * r4
            int r4 = r9 + r7
            int r14 = r4 + r6
            int r15 = r1.f8842x     // Catch:{ all -> 0x03d6 }
            int r15 = r15 + r9
            if (r15 >= r14) goto L_0x02ac
            int r14 = r1.f8842x     // Catch:{ all -> 0x03d6 }
            int r14 = r14 + r9
        L_0x02ac:
            int r9 = r1.f8840v     // Catch:{ all -> 0x03d6 }
            int r9 = r9 * r11
            int r15 = r5.f14217c     // Catch:{ all -> 0x03d6 }
            int r9 = r9 * r15
            int r15 = r14 - r4
            r17 = r0
            int r0 = r1.f8840v     // Catch:{ all -> 0x03d6 }
            int r15 = r15 * r0
            int r15 = r15 + r9
        L_0x02bd:
            if (r4 >= r14) goto L_0x0386
            int r0 = r1.f8840v     // Catch:{ all -> 0x03d6 }
            r18 = r2
            r2 = 1
            if (r0 != r2) goto L_0x02d6
            byte[] r0 = r1.f8834p     // Catch:{ all -> 0x03d6 }
            byte r0 = r0[r9]     // Catch:{ all -> 0x03d6 }
            r0 = r0 & 255(0xff, float:3.57E-43)
            int[] r2 = r1.f8823e     // Catch:{ all -> 0x03d6 }
            r0 = r2[r0]     // Catch:{ all -> 0x03d6 }
            r25 = r6
            r27 = r7
            goto L_0x0369
        L_0x02d6:
            int r0 = r5.f14217c     // Catch:{ all -> 0x03d6 }
            r25 = r6
            r2 = r9
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r24 = 0
        L_0x02e5:
            int r6 = r1.f8840v     // Catch:{ all -> 0x03d6 }
            int r6 = r6 + r9
            if (r2 >= r6) goto L_0x031c
            byte[] r6 = r1.f8834p     // Catch:{ all -> 0x03d6 }
            int r6 = r6.length     // Catch:{ all -> 0x03d6 }
            if (r2 >= r6) goto L_0x031c
            if (r2 >= r15) goto L_0x031c
            byte[] r6 = r1.f8834p     // Catch:{ all -> 0x03d6 }
            byte r6 = r6[r2]     // Catch:{ all -> 0x03d6 }
            r6 = r6 & 255(0xff, float:3.57E-43)
            r27 = r7
            int[] r7 = r1.f8823e     // Catch:{ all -> 0x03d6 }
            r6 = r7[r6]     // Catch:{ all -> 0x03d6 }
            if (r6 == 0) goto L_0x0317
            int r7 = r6 >> 24
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r19 = r19 + r7
            int r7 = r6 >> 16
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r20 = r20 + r7
            int r7 = r6 >> 8
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r21 = r21 + r7
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r22 = r22 + r6
            int r24 = r24 + 1
        L_0x0317:
            int r2 = r2 + 1
            r7 = r27
            goto L_0x02e5
        L_0x031c:
            r27 = r7
            int r0 = r0 + r9
            r2 = r0
        L_0x0320:
            int r6 = r1.f8840v     // Catch:{ all -> 0x03d6 }
            int r6 = r6 + r0
            if (r2 >= r6) goto L_0x0353
            byte[] r6 = r1.f8834p     // Catch:{ all -> 0x03d6 }
            int r6 = r6.length     // Catch:{ all -> 0x03d6 }
            if (r2 >= r6) goto L_0x0353
            if (r2 >= r15) goto L_0x0353
            byte[] r6 = r1.f8834p     // Catch:{ all -> 0x03d6 }
            byte r6 = r6[r2]     // Catch:{ all -> 0x03d6 }
            r6 = r6 & 255(0xff, float:3.57E-43)
            int[] r7 = r1.f8823e     // Catch:{ all -> 0x03d6 }
            r6 = r7[r6]     // Catch:{ all -> 0x03d6 }
            if (r6 == 0) goto L_0x0350
            int r7 = r6 >> 24
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r19 = r19 + r7
            int r7 = r6 >> 16
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r20 = r20 + r7
            int r7 = r6 >> 8
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r21 = r21 + r7
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r22 = r22 + r6
            int r24 = r24 + 1
        L_0x0350:
            int r2 = r2 + 1
            goto L_0x0320
        L_0x0353:
            if (r24 != 0) goto L_0x0357
            r0 = 0
            goto L_0x0369
        L_0x0357:
            int r19 = r19 / r24
            int r0 = r19 << 24
            int r20 = r20 / r24
            int r2 = r20 << 16
            r0 = r0 | r2
            int r21 = r21 / r24
            int r2 = r21 << 8
            r0 = r0 | r2
            int r22 = r22 / r24
            r0 = r0 | r22
        L_0x0369:
            if (r0 == 0) goto L_0x036e
            r3[r4] = r0     // Catch:{ all -> 0x03d6 }
            goto L_0x0377
        L_0x036e:
            boolean r0 = r1.f8843y     // Catch:{ all -> 0x03d6 }
            if (r0 != 0) goto L_0x0377
            if (r8 == 0) goto L_0x0377
            r0 = 1
            r1.f8843y = r0     // Catch:{ all -> 0x03d6 }
        L_0x0377:
            int r0 = r1.f8840v     // Catch:{ all -> 0x03d6 }
            int r9 = r9 + r0
            int r4 = r4 + 1
            r2 = r18
            r6 = r25
            r7 = r27
            goto L_0x02bd
        L_0x0384:
            r17 = r0
        L_0x0386:
            r18 = r2
            r25 = r6
            r27 = r7
            int r11 = r11 + 1
            r9 = r13
            r0 = r17
            r2 = r18
            r6 = r25
            r7 = r27
            r4 = 0
            goto L_0x0271
        L_0x039a:
            boolean r0 = r1.f8838t     // Catch:{ all -> 0x03d6 }
            if (r0 == 0) goto L_0x03c0
            int r0 = r5.f14221g     // Catch:{ all -> 0x03d6 }
            if (r0 == 0) goto L_0x03a7
            int r0 = r5.f14221g     // Catch:{ all -> 0x03d6 }
            r2 = 1
            if (r0 != r2) goto L_0x03c0
        L_0x03a7:
            android.graphics.Bitmap r0 = r1.f8837s     // Catch:{ all -> 0x03d6 }
            if (r0 != 0) goto L_0x03b1
            android.graphics.Bitmap r0 = r29.m10418e()     // Catch:{ all -> 0x03d6 }
            r1.f8837s = r0     // Catch:{ all -> 0x03d6 }
        L_0x03b1:
            android.graphics.Bitmap r8 = r1.f8837s     // Catch:{ all -> 0x03d6 }
            r10 = 0
            int r11 = r1.f8842x     // Catch:{ all -> 0x03d6 }
            r12 = 0
            r13 = 0
            int r14 = r1.f8842x     // Catch:{ all -> 0x03d6 }
            int r15 = r1.f8841w     // Catch:{ all -> 0x03d6 }
            r9 = r3
            r8.setPixels(r9, r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x03d6 }
        L_0x03c0:
            android.graphics.Bitmap r0 = r29.m10418e()     // Catch:{ all -> 0x03d6 }
            r10 = 0
            int r11 = r1.f8842x     // Catch:{ all -> 0x03d6 }
            r12 = 0
            r13 = 0
            int r14 = r1.f8842x     // Catch:{ all -> 0x03d6 }
            int r15 = r1.f8841w     // Catch:{ all -> 0x03d6 }
            r8 = r0
            r9 = r3
            r8.setPixels(r9, r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x03d6 }
            monitor-exit(r29)
            return r0
        L_0x03d4:
            monitor-exit(r29)
            return r3
        L_0x03d6:
            r0 = move-exception
            monitor-exit(r29)
            goto L_0x03da
        L_0x03d9:
            throw r0
        L_0x03da:
            goto L_0x03d9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C3161ic.mo18616a():android.graphics.Bitmap");
    }

    private C3161ic(C3162a aVar, C5189ie ieVar, ByteBuffer byteBuffer, byte b) {
        this(aVar);
        m10415b(ieVar, byteBuffer);
    }

    private C3161ic(C3162a aVar) {
        this.f8824f = new int[256];
        this.f8828j = 0;
        this.f8829k = 0;
        this.f8836r = aVar;
        this.f8822c = new C5189ie();
    }

    C3161ic() {
        this(new C3163ih());
    }

    /* renamed from: b */
    private void m10414b() {
        if (this.f8828j <= this.f8829k) {
            if (this.f8827i == null) {
                this.f8827i = this.f8836r.mo18618a(16384);
            }
            this.f8829k = 0;
            int min = Math.min(this.f8825g.remaining(), 16384);
            this.f8828j = min;
            this.f8825g.get(this.f8827i, 0, min);
        }
    }

    /* renamed from: a */
    private synchronized void m10412a(C5189ie ieVar, byte[] bArr) {
        m10411a(ieVar, ByteBuffer.wrap(bArr));
    }

    /* renamed from: a */
    private synchronized void m10411a(C5189ie ieVar, ByteBuffer byteBuffer) {
        m10415b(ieVar, byteBuffer);
    }

    /* renamed from: a */
    private void m10413a(int[] iArr, C5188id idVar, int i) {
        int i2 = idVar.f14218d;
        int i3 = this.f8840v;
        int i4 = i2 / i3;
        int i5 = idVar.f14216b / i3;
        int i6 = idVar.f14217c / i3;
        int i7 = idVar.f14215a / i3;
        int i8 = this.f8842x;
        int i9 = (i5 * i8) + i7;
        int i10 = (i4 * i8) + i9;
        while (i9 < i10) {
            int i11 = i9 + i6;
            for (int i12 = i9; i12 < i11; i12++) {
                iArr[i12] = i;
            }
            i9 += this.f8842x;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized int mo18615a(byte[] bArr) {
        if (this.f8830l == null) {
            this.f8830l = new C5190if();
        }
        C5189ie a = this.f8830l.mo31353a(bArr).mo31352a();
        this.f8822c = a;
        if (bArr != null) {
            m10412a(a, bArr);
        }
        return this.f8839u;
    }
}
