package com.google.protobuf;

import com.google.android.gms.games.Notifications;
import com.ogury.p159cm.OguryChoiceManager;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/* renamed from: com.google.protobuf.g */
/* compiled from: CodedInputStream */
public final class C4013g {

    /* renamed from: a */
    private final byte[] f10802a;

    /* renamed from: b */
    private final boolean f10803b;

    /* renamed from: c */
    private int f10804c;

    /* renamed from: d */
    private int f10805d;

    /* renamed from: e */
    private int f10806e;

    /* renamed from: f */
    private final InputStream f10807f;

    /* renamed from: g */
    private int f10808g;

    /* renamed from: h */
    private boolean f10809h = false;

    /* renamed from: i */
    private int f10810i;

    /* renamed from: j */
    private int f10811j = Integer.MAX_VALUE;

    /* renamed from: k */
    private int f10812k;

    /* renamed from: l */
    private int f10813l = 100;

    /* renamed from: m */
    private int f10814m = 67108864;

    /* renamed from: n */
    private C4014a f10815n = null;

    /* renamed from: com.google.protobuf.g$a */
    /* compiled from: CodedInputStream */
    private interface C4014a {
        /* renamed from: a */
        void mo28157a();
    }

    private C4013g(byte[] bArr, int i, int i2, boolean z) {
        this.f10802a = bArr;
        this.f10804c = i2 + i;
        this.f10806e = i;
        this.f10810i = -i;
        this.f10807f = null;
        this.f10803b = z;
    }

    /* renamed from: a */
    public static C4013g m13364a(InputStream inputStream) {
        return new C4013g(inputStream, CodedOutputStream.DEFAULT_BUFFER_SIZE);
    }

    /* renamed from: i */
    private boolean m13371i(int i) throws IOException {
        int i2 = this.f10806e;
        if (i2 + i <= this.f10804c) {
            throw new IllegalStateException("refillBuffer() called when " + i + " bytes were already available in buffer");
        } else if (this.f10810i + i2 + i > this.f10811j) {
            return false;
        } else {
            C4014a aVar = this.f10815n;
            if (aVar != null) {
                aVar.mo28157a();
            }
            if (this.f10807f != null) {
                int i3 = this.f10806e;
                if (i3 > 0) {
                    int i4 = this.f10804c;
                    if (i4 > i3) {
                        byte[] bArr = this.f10802a;
                        System.arraycopy(bArr, i3, bArr, 0, i4 - i3);
                    }
                    this.f10810i += i3;
                    this.f10804c -= i3;
                    this.f10806e = 0;
                }
                InputStream inputStream = this.f10807f;
                byte[] bArr2 = this.f10802a;
                int i5 = this.f10804c;
                int read = inputStream.read(bArr2, i5, bArr2.length - i5);
                if (read == 0 || read < -1 || read > this.f10802a.length) {
                    throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + read + "\nThe InputStream implementation is buggy.");
                } else if (read > 0) {
                    this.f10804c += read;
                    if ((this.f10810i + i) - this.f10814m <= 0) {
                        m13372s();
                        if (this.f10804c >= i) {
                            return true;
                        }
                        return m13371i(i);
                    }
                    throw InvalidProtocolBufferException.m13217h();
                }
            }
            return false;
        }
    }

    /* renamed from: s */
    private void m13372s() {
        int i = this.f10804c + this.f10805d;
        this.f10804c = i;
        int i2 = this.f10810i + i;
        int i3 = this.f10811j;
        if (i2 > i3) {
            int i4 = i2 - i3;
            this.f10805d = i4;
            this.f10804c = i - i4;
            return;
        }
        this.f10805d = 0;
    }

    /* renamed from: t */
    private void m13373t() throws IOException {
        int i = this.f10804c;
        int i2 = this.f10806e;
        if (i - i2 >= 10) {
            byte[] bArr = this.f10802a;
            int i3 = 0;
            while (i3 < 10) {
                int i4 = i2 + 1;
                if (bArr[i2] >= 0) {
                    this.f10806e = i4;
                    return;
                } else {
                    i3++;
                    i2 = i4;
                }
            }
        }
        m13374u();
    }

    /* renamed from: u */
    private void m13374u() throws IOException {
        int i = 0;
        while (i < 10) {
            if (mo28147i() < 0) {
                i++;
            } else {
                return;
            }
        }
        throw InvalidProtocolBufferException.m13214e();
    }

    /* renamed from: b */
    public boolean mo28137b() throws IOException {
        return mo28151m() != 0;
    }

    /* renamed from: c */
    public C3995f mo28139c() throws IOException {
        C3995f fVar;
        int l = mo28150l();
        int i = this.f10804c;
        int i2 = this.f10806e;
        if (l <= i - i2 && l > 0) {
            if (!this.f10803b || !this.f10809h) {
                fVar = C3995f.m13322a(this.f10802a, this.f10806e, l);
            } else {
                fVar = C3995f.m13324b(this.f10802a, i2, l);
            }
            this.f10806e += l;
            return fVar;
        } else if (l == 0) {
            return C3995f.f10759b;
        } else {
            return C3995f.m13321a(m13368f(l));
        }
    }

    /* renamed from: d */
    public boolean mo28141d(int i) throws IOException {
        int b = C4005f0.m13359b(i);
        if (b == 0) {
            m13373t();
            return true;
        } else if (b == 1) {
            mo28143e(8);
            return true;
        } else if (b == 2) {
            mo28143e(mo28150l());
            return true;
        } else if (b == 3) {
            mo28156r();
            mo28134a(C4005f0.m13358a(C4005f0.m13357a(i), 4));
            return true;
        } else if (b == 4) {
            return false;
        } else {
            if (b == 5) {
                mo28143e(4);
                return true;
            }
            throw InvalidProtocolBufferException.m13213d();
        }
    }

    /* renamed from: e */
    public int mo28142e() throws IOException {
        return mo28148j();
    }

    /* renamed from: f */
    public long mo28144f() throws IOException {
        return mo28149k();
    }

    /* renamed from: g */
    public int mo28145g() throws IOException {
        return mo28150l();
    }

    /* renamed from: h */
    public long mo28146h() throws IOException {
        return mo28151m();
    }

    /* renamed from: j */
    public int mo28148j() throws IOException {
        int i = this.f10806e;
        if (this.f10804c - i < 4) {
            m13369g(4);
            i = this.f10806e;
        }
        byte[] bArr = this.f10802a;
        this.f10806e = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    /* renamed from: k */
    public long mo28149k() throws IOException {
        int i = this.f10806e;
        if (this.f10804c - i < 8) {
            m13369g(8);
            i = this.f10806e;
        }
        byte[] bArr = this.f10802a;
        this.f10806e = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0068, code lost:
        if (r2[r3] < 0) goto L_0x006a;
     */
    /* renamed from: l */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int mo28150l() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.f10806e
            int r1 = r5.f10804c
            if (r1 != r0) goto L_0x0007
            goto L_0x006a
        L_0x0007:
            byte[] r2 = r5.f10802a
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0012
            r5.f10806e = r3
            return r0
        L_0x0012:
            int r1 = r1 - r3
            r4 = 9
            if (r1 >= r4) goto L_0x0018
            goto L_0x006a
        L_0x0018:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0024
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            goto L_0x0070
        L_0x0024:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x0031
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L_0x002f:
            r1 = r3
            goto L_0x0070
        L_0x0031:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x003f
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L_0x0070
        L_0x003f:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L_0x002f
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0070
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002f
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0070
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002f
            int r1 = r3 + 1
            byte r2 = r2[r3]
            if (r2 >= 0) goto L_0x0070
        L_0x006a:
            long r0 = r5.mo28152n()
            int r1 = (int) r0
            return r1
        L_0x0070:
            r5.f10806e = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C4013g.mo28150l():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b4, code lost:
        if (((long) r2[r0]) < 0) goto L_0x00b6;
     */
    /* renamed from: m */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long mo28151m() throws java.io.IOException {
        /*
            r11 = this;
            int r0 = r11.f10806e
            int r1 = r11.f10804c
            if (r1 != r0) goto L_0x0008
            goto L_0x00b6
        L_0x0008:
            byte[] r2 = r11.f10802a
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0014
            r11.f10806e = r3
            long r0 = (long) r0
            return r0
        L_0x0014:
            int r1 = r1 - r3
            r4 = 9
            if (r1 >= r4) goto L_0x001b
            goto L_0x00b6
        L_0x001b:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0029
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
        L_0x0026:
            long r2 = (long) r0
            goto L_0x00bd
        L_0x0029:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x003a
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            long r0 = (long) r0
            r9 = r0
            r1 = r3
            r2 = r9
            goto L_0x00bd
        L_0x003a:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0048
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L_0x0026
        L_0x0048:
            long r3 = (long) r0
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r5 = (long) r1
            r1 = 28
            long r5 = r5 << r1
            long r3 = r3 ^ r5
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x005f
            r1 = 266354560(0xfe03f80, double:1.315966377E-315)
        L_0x005b:
            long r1 = r1 ^ r3
            r2 = r1
            r1 = r0
            goto L_0x00bd
        L_0x005f:
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            r0 = 35
            long r7 = r7 << r0
            long r3 = r3 ^ r7
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0074
            r5 = -34093383808(0xfffffff80fe03f80, double:NaN)
        L_0x0071:
            long r3 = r3 ^ r5
        L_0x0072:
            r2 = r3
            goto L_0x00bd
        L_0x0074:
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r7 = (long) r1
            r1 = 42
            long r7 = r7 << r1
            long r3 = r3 ^ r7
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x0087
            r1 = 4363953127296(0x3f80fe03f80, double:2.1560793202584E-311)
            goto L_0x005b
        L_0x0087:
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            r0 = 49
            long r7 = r7 << r0
            long r3 = r3 ^ r7
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x009a
            r5 = -558586000294016(0xfffe03f80fe03f80, double:NaN)
            goto L_0x0071
        L_0x009a:
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r7 = (long) r1
            r1 = 56
            long r7 = r7 << r1
            long r3 = r3 ^ r7
            r7 = 71499008037633920(0xfe03f80fe03f80, double:6.838959413692434E-304)
            long r3 = r3 ^ r7
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto L_0x00bb
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0072
        L_0x00b6:
            long r0 = r11.mo28152n()
            return r0
        L_0x00bb:
            r1 = r0
            goto L_0x0072
        L_0x00bd:
            r11.f10806e = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C4013g.mo28151m():long");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public long mo28152n() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte i2 = mo28147i();
            j |= ((long) (i2 & Byte.MAX_VALUE)) << i;
            if ((i2 & 128) == 0) {
                return j;
            }
        }
        throw InvalidProtocolBufferException.m13214e();
    }

    /* renamed from: o */
    public String mo28153o() throws IOException {
        int l = mo28150l();
        if (l <= this.f10804c - this.f10806e && l > 0) {
            String str = new String(this.f10802a, this.f10806e, l, C4038p.f10852a);
            this.f10806e += l;
            return str;
        } else if (l == 0) {
            return "";
        } else {
            if (l > this.f10804c) {
                return new String(m13368f(l), C4038p.f10852a);
            }
            m13369g(l);
            String str2 = new String(this.f10802a, this.f10806e, l, C4038p.f10852a);
            this.f10806e += l;
            return str2;
        }
    }

    /* renamed from: p */
    public String mo28154p() throws IOException {
        byte[] bArr;
        int l = mo28150l();
        int i = this.f10806e;
        if (l <= this.f10804c - i && l > 0) {
            bArr = this.f10802a;
            this.f10806e = i + l;
        } else if (l == 0) {
            return "";
        } else {
            if (l <= this.f10804c) {
                m13369g(l);
                bArr = this.f10802a;
                this.f10806e = l + 0;
            } else {
                bArr = m13368f(l);
            }
            i = 0;
        }
        if (C3990e0.m13306c(bArr, i, i + l)) {
            return new String(bArr, i, l, C4038p.f10852a);
        }
        throw InvalidProtocolBufferException.m13212c();
    }

    /* renamed from: q */
    public int mo28155q() throws IOException {
        if (mo28135a()) {
            this.f10808g = 0;
            return 0;
        }
        int l = mo28150l();
        this.f10808g = l;
        if (C4005f0.m13357a(l) != 0) {
            return this.f10808g;
        }
        throw InvalidProtocolBufferException.m13211b();
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* renamed from: r */
    public void mo28156r() throws java.io.IOException {
        /*
            r1 = this;
        L_0x0000:
            int r0 = r1.mo28155q()
            if (r0 == 0) goto L_0x000c
            boolean r0 = r1.mo28141d(r0)
            if (r0 != 0) goto L_0x0000
        L_0x000c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C4013g.mo28156r():void");
    }

    /* renamed from: a */
    public static C4013g m13365a(byte[] bArr) {
        return m13366a(bArr, 0, bArr.length);
    }

    /* renamed from: f */
    private byte[] m13368f(int i) throws IOException {
        if (i > 0) {
            int i2 = this.f10810i;
            int i3 = this.f10806e;
            int i4 = i2 + i3 + i;
            if (i4 <= this.f10814m) {
                int i5 = this.f10811j;
                if (i4 <= i5) {
                    InputStream inputStream = this.f10807f;
                    if (inputStream != null) {
                        int i6 = this.f10804c;
                        int i7 = i6 - i3;
                        this.f10810i = i2 + i6;
                        this.f10806e = 0;
                        this.f10804c = 0;
                        int i8 = i - i7;
                        if (i8 < 4096 || i8 <= inputStream.available()) {
                            byte[] bArr = new byte[i];
                            System.arraycopy(this.f10802a, i3, bArr, 0, i7);
                            while (i7 < i) {
                                int read = this.f10807f.read(bArr, i7, i - i7);
                                if (read != -1) {
                                    this.f10810i += read;
                                    i7 += read;
                                } else {
                                    throw InvalidProtocolBufferException.m13218i();
                                }
                            }
                            return bArr;
                        }
                        ArrayList<byte[]> arrayList = new ArrayList<>();
                        while (i8 > 0) {
                            int min = Math.min(i8, CodedOutputStream.DEFAULT_BUFFER_SIZE);
                            byte[] bArr2 = new byte[min];
                            int i9 = 0;
                            while (i9 < min) {
                                int read2 = this.f10807f.read(bArr2, i9, min - i9);
                                if (read2 != -1) {
                                    this.f10810i += read2;
                                    i9 += read2;
                                } else {
                                    throw InvalidProtocolBufferException.m13218i();
                                }
                            }
                            i8 -= min;
                            arrayList.add(bArr2);
                        }
                        byte[] bArr3 = new byte[i];
                        System.arraycopy(this.f10802a, i3, bArr3, 0, i7);
                        for (byte[] bArr4 : arrayList) {
                            System.arraycopy(bArr4, 0, bArr3, i7, bArr4.length);
                            i7 += bArr4.length;
                        }
                        return bArr3;
                    }
                    throw InvalidProtocolBufferException.m13218i();
                }
                mo28143e((i5 - i2) - i3);
                throw InvalidProtocolBufferException.m13218i();
            }
            throw InvalidProtocolBufferException.m13217h();
        } else if (i == 0) {
            return C4038p.f10853b;
        } else {
            throw InvalidProtocolBufferException.m13215f();
        }
    }

    /* renamed from: g */
    private void m13369g(int i) throws IOException {
        if (!m13371i(i)) {
            throw InvalidProtocolBufferException.m13218i();
        }
    }

    /* renamed from: h */
    private void m13370h(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.f10810i;
            int i3 = this.f10806e;
            int i4 = i2 + i3 + i;
            int i5 = this.f10811j;
            if (i4 <= i5) {
                int i6 = this.f10804c;
                int i7 = i6 - i3;
                this.f10806e = i6;
                m13369g(1);
                while (true) {
                    int i8 = i - i7;
                    int i9 = this.f10804c;
                    if (i8 > i9) {
                        i7 += i9;
                        this.f10806e = i9;
                        m13369g(1);
                    } else {
                        this.f10806e = i8;
                        return;
                    }
                }
            } else {
                mo28143e((i5 - i2) - i3);
                throw InvalidProtocolBufferException.m13218i();
            }
        } else {
            throw InvalidProtocolBufferException.m13215f();
        }
    }

    /* renamed from: b */
    public void mo28136b(int i) {
        this.f10811j = i;
        m13372s();
    }

    /* renamed from: e */
    public void mo28143e(int i) throws IOException {
        int i2 = this.f10804c;
        int i3 = this.f10806e;
        if (i > i2 - i3 || i < 0) {
            m13370h(i);
        } else {
            this.f10806e = i3 + i;
        }
    }

    /* renamed from: a */
    public static C4013g m13366a(byte[] bArr, int i, int i2) {
        return m13367a(bArr, i, i2, false);
    }

    /* renamed from: a */
    static C4013g m13367a(byte[] bArr, int i, int i2, boolean z) {
        C4013g gVar = new C4013g(bArr, i, i2, z);
        try {
            gVar.mo28138c(i2);
            return gVar;
        } catch (InvalidProtocolBufferException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* renamed from: a */
    public void mo28134a(int i) throws InvalidProtocolBufferException {
        if (this.f10808g != i) {
            throw InvalidProtocolBufferException.m13210a();
        }
    }

    /* renamed from: a */
    public <T extends C4054u> T mo28133a(C4058x<T> xVar, C4018k kVar) throws IOException {
        int l = mo28150l();
        if (this.f10812k < this.f10813l) {
            int c = mo28138c(l);
            this.f10812k++;
            T t = (C4054u) xVar.mo28214a(this, kVar);
            mo28134a(0);
            this.f10812k--;
            mo28136b(c);
            return t;
        }
        throw InvalidProtocolBufferException.m13216g();
    }

    /* renamed from: c */
    public int mo28138c(int i) throws InvalidProtocolBufferException {
        if (i >= 0) {
            int i2 = i + this.f10810i + this.f10806e;
            int i3 = this.f10811j;
            if (i2 <= i3) {
                this.f10811j = i2;
                m13372s();
                return i3;
            }
            throw InvalidProtocolBufferException.m13218i();
        }
        throw InvalidProtocolBufferException.m13215f();
    }

    /* renamed from: d */
    public int mo28140d() throws IOException {
        return mo28150l();
    }

    private C4013g(InputStream inputStream, int i) {
        this.f10802a = new byte[i];
        this.f10806e = 0;
        this.f10810i = 0;
        this.f10807f = inputStream;
        this.f10803b = false;
    }

    /* renamed from: a */
    public static int m13363a(int i, InputStream inputStream) throws IOException {
        if ((i & OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE) == 0) {
            return i;
        }
        int i2 = i & Notifications.NOTIFICATION_TYPES_ALL;
        int i3 = 7;
        while (i3 < 32) {
            int read = inputStream.read();
            if (read != -1) {
                i2 |= (read & Notifications.NOTIFICATION_TYPES_ALL) << i3;
                if ((read & OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE) == 0) {
                    return i2;
                }
                i3 += 7;
            } else {
                throw InvalidProtocolBufferException.m13218i();
            }
        }
        while (i3 < 64) {
            int read2 = inputStream.read();
            if (read2 == -1) {
                throw InvalidProtocolBufferException.m13218i();
            } else if ((read2 & OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE) == 0) {
                return i2;
            } else {
                i3 += 7;
            }
        }
        throw InvalidProtocolBufferException.m13214e();
    }

    /* renamed from: i */
    public byte mo28147i() throws IOException {
        if (this.f10806e == this.f10804c) {
            m13369g(1);
        }
        byte[] bArr = this.f10802a;
        int i = this.f10806e;
        this.f10806e = i + 1;
        return bArr[i];
    }

    /* renamed from: a */
    public boolean mo28135a() throws IOException {
        return this.f10806e == this.f10804c && !m13371i(1);
    }
}
