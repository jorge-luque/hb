package com.tapjoy.internal;

import com.ogury.p159cm.OguryChoiceManager;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* renamed from: com.tapjoy.internal.if */
public final class C5190if {

    /* renamed from: a */
    private final byte[] f14239a = new byte[256];

    /* renamed from: b */
    private ByteBuffer f14240b;

    /* renamed from: c */
    private C5189ie f14241c;

    /* renamed from: d */
    private int f14242d = 0;

    /* renamed from: b */
    private void m17430b() {
        boolean z = false;
        while (!z && !m17436h() && this.f14241c.f14228c <= Integer.MAX_VALUE) {
            int g = m17435g();
            if (g == 33) {
                int g2 = m17435g();
                if (g2 == 1) {
                    m17433e();
                } else if (g2 == 249) {
                    this.f14241c.f14229d = new C5188id();
                    m17435g();
                    int g3 = m17435g();
                    C5188id idVar = this.f14241c.f14229d;
                    int i = (g3 & 28) >> 2;
                    idVar.f14221g = i;
                    if (i == 0) {
                        idVar.f14221g = 1;
                    }
                    this.f14241c.f14229d.f14220f = (g3 & 1) != 0;
                    short s = this.f14240b.getShort();
                    if (s < 2) {
                        s = 10;
                    }
                    C5188id idVar2 = this.f14241c.f14229d;
                    idVar2.f14223i = s * 10;
                    idVar2.f14222h = m17435g();
                    m17435g();
                } else if (g2 == 254) {
                    m17433e();
                } else if (g2 != 255) {
                    m17433e();
                } else {
                    m17434f();
                    String str = "";
                    for (int i2 = 0; i2 < 11; i2++) {
                        str = str + ((char) this.f14239a[i2]);
                    }
                    if (str.equals("NETSCAPE2.0")) {
                        m17431c();
                    } else {
                        m17433e();
                    }
                }
            } else if (g == 44) {
                C5189ie ieVar = this.f14241c;
                if (ieVar.f14229d == null) {
                    ieVar.f14229d = new C5188id();
                }
                this.f14241c.f14229d.f14215a = this.f14240b.getShort();
                this.f14241c.f14229d.f14216b = this.f14240b.getShort();
                this.f14241c.f14229d.f14217c = this.f14240b.getShort();
                this.f14241c.f14229d.f14218d = this.f14240b.getShort();
                int g4 = m17435g();
                boolean z2 = (g4 & OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE) != 0;
                int pow = (int) Math.pow(2.0d, (double) ((g4 & 7) + 1));
                this.f14241c.f14229d.f14219e = (g4 & 64) != 0;
                if (z2) {
                    this.f14241c.f14229d.f14225k = m17429a(pow);
                } else {
                    this.f14241c.f14229d.f14225k = null;
                }
                this.f14241c.f14229d.f14224j = this.f14240b.position();
                m17435g();
                m17433e();
                if (!m17436h()) {
                    C5189ie ieVar2 = this.f14241c;
                    ieVar2.f14228c++;
                    ieVar2.f14230e.add(ieVar2.f14229d);
                }
            } else if (g != 59) {
                this.f14241c.f14227b = 1;
            } else {
                z = true;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m17431c() {
        /*
            r3 = this;
        L_0x0000:
            r3.m17434f()
            byte[] r0 = r3.f14239a
            r1 = 0
            byte r1 = r0[r1]
            r2 = 1
            if (r1 != r2) goto L_0x0020
            byte r1 = r0[r2]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r2 = 2
            byte r0 = r0[r2]
            r0 = r0 & 255(0xff, float:3.57E-43)
            com.tapjoy.internal.ie r2 = r3.f14241c
            int r0 = r0 << 8
            r0 = r0 | r1
            r2.f14238m = r0
            if (r0 != 0) goto L_0x0020
            r0 = -1
            r2.f14238m = r0
        L_0x0020:
            int r0 = r3.f14242d
            if (r0 <= 0) goto L_0x002a
            boolean r0 = r3.m17436h()
            if (r0 == 0) goto L_0x0000
        L_0x002a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C5190if.m17431c():void");
    }

    /* renamed from: d */
    private void m17432d() {
        boolean z = false;
        String str = "";
        for (int i = 0; i < 6; i++) {
            str = str + ((char) m17435g());
        }
        if (!str.startsWith("GIF")) {
            this.f14241c.f14227b = 1;
            return;
        }
        this.f14241c.f14231f = this.f14240b.getShort();
        this.f14241c.f14232g = this.f14240b.getShort();
        int g = m17435g();
        C5189ie ieVar = this.f14241c;
        if ((g & OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE) != 0) {
            z = true;
        }
        ieVar.f14233h = z;
        C5189ie ieVar2 = this.f14241c;
        ieVar2.f14234i = 2 << (g & 7);
        ieVar2.f14235j = m17435g();
        this.f14241c.f14236k = m17435g();
        if (this.f14241c.f14233h && !m17436h()) {
            C5189ie ieVar3 = this.f14241c;
            ieVar3.f14226a = m17429a(ieVar3.f14234i);
            C5189ie ieVar4 = this.f14241c;
            ieVar4.f14237l = ieVar4.f14226a[ieVar4.f14235j];
        }
    }

    /* renamed from: e */
    private void m17433e() {
        int g;
        do {
            try {
                g = m17435g();
                this.f14240b.position(this.f14240b.position() + g);
            } catch (IllegalArgumentException unused) {
                return;
            }
        } while (g > 0);
    }

    /* renamed from: f */
    private int m17434f() {
        int g = m17435g();
        this.f14242d = g;
        int i = 0;
        if (g > 0) {
            while (i < this.f14242d) {
                try {
                    int i2 = this.f14242d - i;
                    this.f14240b.get(this.f14239a, i, i2);
                    i += i2;
                } catch (Exception unused) {
                    this.f14241c.f14227b = 1;
                }
            }
        }
        return i;
    }

    /* renamed from: g */
    private int m17435g() {
        try {
            return this.f14240b.get() & 255;
        } catch (Exception unused) {
            this.f14241c.f14227b = 1;
            return 0;
        }
    }

    /* renamed from: h */
    private boolean m17436h() {
        return this.f14241c.f14227b != 0;
    }

    /* renamed from: a */
    public final C5190if mo31353a(byte[] bArr) {
        if (bArr != null) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            this.f14240b = null;
            Arrays.fill(this.f14239a, (byte) 0);
            this.f14241c = new C5189ie();
            this.f14242d = 0;
            ByteBuffer asReadOnlyBuffer = wrap.asReadOnlyBuffer();
            this.f14240b = asReadOnlyBuffer;
            asReadOnlyBuffer.position(0);
            this.f14240b.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.f14240b = null;
            this.f14241c.f14227b = 2;
        }
        return this;
    }

    /* renamed from: a */
    public final C5189ie mo31352a() {
        if (this.f14240b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        } else if (m17436h()) {
            return this.f14241c;
        } else {
            m17432d();
            if (!m17436h()) {
                m17430b();
                C5189ie ieVar = this.f14241c;
                if (ieVar.f14228c < 0) {
                    ieVar.f14227b = 1;
                }
            }
            return this.f14241c;
        }
    }

    /* renamed from: a */
    private int[] m17429a(int i) {
        byte[] bArr = new byte[(i * 3)];
        int[] iArr = null;
        try {
            this.f14240b.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = i3 + 1;
                int i5 = i4 + 1;
                int i6 = i5 + 1;
                int i7 = i2 + 1;
                iArr[i2] = ((bArr[i3] & 255) << 16) | -16777216 | ((bArr[i4] & 255) << 8) | (bArr[i5] & 255);
                i3 = i6;
                i2 = i7;
            }
        } catch (BufferUnderflowException unused) {
            this.f14241c.f14227b = 1;
        }
        return iArr;
    }
}
