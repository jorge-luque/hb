package com.tapjoy.internal;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;

/* renamed from: com.tapjoy.internal.ek */
public final class C5022ek {

    /* renamed from: a */
    final C5211it f13603a;

    /* renamed from: b */
    private long f13604b = 0;

    /* renamed from: c */
    private long f13605c = Long.MAX_VALUE;

    /* renamed from: d */
    private int f13606d;

    /* renamed from: e */
    private int f13607e = 2;

    /* renamed from: f */
    private int f13608f = -1;

    /* renamed from: g */
    private long f13609g = -1;

    /* renamed from: h */
    private C5001eg f13610h;

    public C5022ek(C5211it itVar) {
        this.f13603a = itVar;
    }

    /* renamed from: i */
    private int m16963i() {
        int i;
        this.f13604b++;
        byte c = this.f13603a.mo31400c();
        if (c >= 0) {
            return c;
        }
        byte b = c & Byte.MAX_VALUE;
        this.f13604b++;
        byte c2 = this.f13603a.mo31400c();
        if (c2 >= 0) {
            i = c2 << 7;
        } else {
            b |= (c2 & Byte.MAX_VALUE) << 7;
            this.f13604b++;
            byte c3 = this.f13603a.mo31400c();
            if (c3 >= 0) {
                i = c3 << 14;
            } else {
                b |= (c3 & Byte.MAX_VALUE) << 14;
                this.f13604b++;
                byte c4 = this.f13603a.mo31400c();
                if (c4 >= 0) {
                    i = c4 << 21;
                } else {
                    byte b2 = b | ((c4 & Byte.MAX_VALUE) << 21);
                    this.f13604b++;
                    byte c5 = this.f13603a.mo31400c();
                    byte b3 = b2 | (c5 << 28);
                    if (c5 >= 0) {
                        return b3;
                    }
                    for (int i2 = 0; i2 < 5; i2++) {
                        this.f13604b++;
                        if (this.f13603a.mo31400c() >= 0) {
                            return b3;
                        }
                    }
                    throw new ProtocolException("Malformed VARINT");
                }
            }
        }
        return b | i;
    }

    /* renamed from: a */
    public final long mo31109a() {
        if (this.f13607e == 2) {
            int i = this.f13606d + 1;
            this.f13606d = i;
            if (i <= 65) {
                long j = this.f13609g;
                this.f13609g = -1;
                this.f13607e = 6;
                return j;
            }
            throw new IOException("Wire recursion limit exceeded");
        }
        throw new IllegalStateException("Unexpected call to beginMessage()");
    }

    /* renamed from: b */
    public final int mo31111b() {
        int i = this.f13607e;
        if (i == 7) {
            this.f13607e = 2;
            return this.f13608f;
        } else if (i == 6) {
            while (this.f13604b < this.f13605c && !this.f13603a.mo31399b()) {
                int i2 = m16963i();
                if (i2 != 0) {
                    int i3 = i2 >> 3;
                    this.f13608f = i3;
                    int i4 = i2 & 7;
                    if (i4 == 0) {
                        this.f13610h = C5001eg.VARINT;
                        this.f13607e = 0;
                        return i3;
                    } else if (i4 == 1) {
                        this.f13610h = C5001eg.FIXED64;
                        this.f13607e = 1;
                        return i3;
                    } else if (i4 == 2) {
                        this.f13610h = C5001eg.LENGTH_DELIMITED;
                        this.f13607e = 2;
                        int i5 = m16963i();
                        if (i5 < 0) {
                            throw new ProtocolException("Negative length: " + i5);
                        } else if (this.f13609g == -1) {
                            long j = this.f13605c;
                            this.f13609g = j;
                            long j2 = this.f13604b + ((long) i5);
                            this.f13605c = j2;
                            if (j2 <= j) {
                                return this.f13608f;
                            }
                            throw new EOFException();
                        } else {
                            throw new IllegalStateException();
                        }
                    } else if (i4 == 3) {
                        m16961a(i3);
                    } else if (i4 == 4) {
                        throw new ProtocolException("Unexpected end group");
                    } else if (i4 == 5) {
                        this.f13610h = C5001eg.FIXED32;
                        this.f13607e = 5;
                        return i3;
                    } else {
                        throw new ProtocolException("Unexpected field encoding: " + i4);
                    }
                } else {
                    throw new ProtocolException("Unexpected tag 0");
                }
            }
            return -1;
        } else {
            throw new IllegalStateException("Unexpected call to nextTag()");
        }
    }

    /* renamed from: c */
    public final C5001eg mo31112c() {
        return this.f13610h;
    }

    /* renamed from: d */
    public final int mo31113d() {
        int i = this.f13607e;
        if (i == 0 || i == 2) {
            int i2 = m16963i();
            m16962b(0);
            return i2;
        }
        throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.f13607e);
    }

    /* renamed from: e */
    public final long mo31114e() {
        int i = this.f13607e;
        if (i == 0 || i == 2) {
            long j = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                this.f13604b++;
                byte c = this.f13603a.mo31400c();
                j |= ((long) (c & Byte.MAX_VALUE)) << i2;
                if ((c & 128) == 0) {
                    m16962b(0);
                    return j;
                }
            }
            throw new ProtocolException("WireInput encountered a malformed varint");
        }
        throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.f13607e);
    }

    /* renamed from: f */
    public final int mo31115f() {
        int i = this.f13607e;
        if (i == 5 || i == 2) {
            this.f13603a.mo31392a(4);
            this.f13604b += 4;
            int e = this.f13603a.mo31408e();
            m16962b(5);
            return e;
        }
        throw new ProtocolException("Expected FIXED32 or LENGTH_DELIMITED but was " + this.f13607e);
    }

    /* renamed from: g */
    public final long mo31116g() {
        int i = this.f13607e;
        if (i == 1 || i == 2) {
            this.f13603a.mo31392a(8);
            this.f13604b += 8;
            long f = this.f13603a.mo31412f();
            m16962b(1);
            return f;
        }
        throw new ProtocolException("Expected FIXED64 or LENGTH_DELIMITED but was " + this.f13607e);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public final long mo31117h() {
        if (this.f13607e == 2) {
            long j = this.f13605c - this.f13604b;
            this.f13603a.mo31392a(j);
            this.f13607e = 6;
            this.f13604b = this.f13605c;
            this.f13605c = this.f13609g;
            this.f13609g = -1;
            return j;
        }
        throw new ProtocolException("Expected LENGTH_DELIMITED but was " + this.f13607e);
    }

    /* renamed from: a */
    public final void mo31110a(long j) {
        if (this.f13607e == 6) {
            int i = this.f13606d - 1;
            this.f13606d = i;
            if (i < 0 || this.f13609g != -1) {
                throw new IllegalStateException("No corresponding call to beginMessage()");
            } else if (this.f13604b == this.f13605c || i == 0) {
                this.f13605c = j;
            } else {
                throw new IOException("Expected to end at " + this.f13605c + " but was " + this.f13604b);
            }
        } else {
            throw new IllegalStateException("Unexpected call to endMessage()");
        }
    }

    /* renamed from: a */
    private void m16961a(int i) {
        while (this.f13604b < this.f13605c && !this.f13603a.mo31399b()) {
            int i2 = m16963i();
            if (i2 != 0) {
                int i3 = i2 >> 3;
                int i4 = i2 & 7;
                if (i4 == 0) {
                    this.f13607e = 0;
                    mo31114e();
                } else if (i4 == 1) {
                    this.f13607e = 1;
                    mo31116g();
                } else if (i4 == 2) {
                    long i5 = (long) m16963i();
                    this.f13604b += i5;
                    this.f13603a.mo31407d(i5);
                } else if (i4 == 3) {
                    m16961a(i3);
                } else if (i4 != 4) {
                    if (i4 == 5) {
                        this.f13607e = 5;
                        mo31115f();
                    } else {
                        throw new ProtocolException("Unexpected field encoding: " + i4);
                    }
                } else if (i3 != i) {
                    throw new ProtocolException("Unexpected end group");
                } else {
                    return;
                }
            } else {
                throw new ProtocolException("Unexpected tag 0");
            }
        }
        throw new EOFException();
    }

    /* renamed from: b */
    private void m16962b(int i) {
        if (this.f13607e == i) {
            this.f13607e = 6;
            return;
        }
        long j = this.f13604b;
        long j2 = this.f13605c;
        if (j > j2) {
            throw new IOException("Expected to end at " + this.f13605c + " but was " + this.f13604b);
        } else if (j == j2) {
            this.f13605c = this.f13609g;
            this.f13609g = -1;
            this.f13607e = 6;
        } else {
            this.f13607e = 7;
        }
    }
}
