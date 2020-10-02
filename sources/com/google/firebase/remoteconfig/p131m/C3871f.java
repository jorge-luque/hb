package com.google.firebase.remoteconfig.p131m;

import com.google.protobuf.C4013g;
import com.google.protobuf.C4018k;
import com.google.protobuf.C4023n;
import com.google.protobuf.C4058x;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.IOException;

/* renamed from: com.google.firebase.remoteconfig.m.f */
/* compiled from: com.google.firebase:firebase-config@@19.1.4 */
public final class C3871f extends C4023n<C3871f, C3872a> implements C3873g {
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final C3871f f10690e;

    /* renamed from: f */
    private static volatile C4058x<C3871f> f10691f;

    /* renamed from: a */
    private int f10692a;

    /* renamed from: b */
    private int f10693b;

    /* renamed from: c */
    private boolean f10694c;

    /* renamed from: d */
    private long f10695d;

    /* renamed from: com.google.firebase.remoteconfig.m.f$a */
    /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
    public static final class C3872a extends C4023n.C4025b<C3871f, C3872a> implements C3873g {
        /* synthetic */ C3872a(C3864a aVar) {
            this();
        }

        private C3872a() {
            super(C3871f.f10690e);
        }
    }

    static {
        C3871f fVar = new C3871f();
        f10690e = fVar;
        fVar.makeImmutable();
    }

    private C3871f() {
    }

    public static C3871f getDefaultInstance() {
        return f10690e;
    }

    public static C4058x<C3871f> parser() {
        return f10690e.getParserForType();
    }

    /* renamed from: a */
    public boolean mo27617a() {
        return (this.f10692a & 2) == 2;
    }

    /* renamed from: b */
    public boolean mo27618b() {
        return (this.f10692a & 1) == 1;
    }

    /* renamed from: c */
    public boolean mo27619c() {
        return (this.f10692a & 4) == 4;
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(C4023n.C4035k kVar, Object obj, Object obj2) {
        switch (C3864a.f10678a[kVar.ordinal()]) {
            case 1:
                return new C3871f();
            case 2:
                return f10690e;
            case 3:
                return null;
            case 4:
                return new C3872a((C3864a) null);
            case 5:
                C4023n.C4036l lVar = (C4023n.C4036l) obj;
                C3871f fVar = (C3871f) obj2;
                this.f10693b = lVar.mo28215a(mo27618b(), this.f10693b, fVar.mo27618b(), fVar.f10693b);
                this.f10694c = lVar.mo28223a(mo27617a(), this.f10694c, fVar.mo27617a(), fVar.f10694c);
                this.f10695d = lVar.mo28216a(mo27619c(), this.f10695d, fVar.mo27619c(), fVar.f10695d);
                if (lVar == C4023n.C4034j.f10839a) {
                    this.f10692a |= fVar.f10692a;
                }
                return this;
            case 6:
                C4013g gVar = (C4013g) obj;
                C4018k kVar2 = (C4018k) obj2;
                boolean z = false;
                while (!z) {
                    try {
                        int q = gVar.mo28155q();
                        if (q != 0) {
                            if (q == 8) {
                                this.f10692a |= 1;
                                this.f10693b = gVar.mo28145g();
                            } else if (q == 16) {
                                this.f10692a |= 2;
                                this.f10694c = gVar.mo28137b();
                            } else if (q == 25) {
                                this.f10692a |= 4;
                                this.f10695d = gVar.mo28144f();
                            } else if (!parseUnknownField(q, gVar)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        e.mo28001a(this);
                        throw new RuntimeException(e);
                    } catch (IOException e2) {
                        InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException(e2.getMessage());
                        invalidProtocolBufferException.mo28001a(this);
                        throw new RuntimeException(invalidProtocolBufferException);
                    }
                }
                break;
            case 7:
                break;
            case 8:
                if (f10691f == null) {
                    synchronized (C3871f.class) {
                        if (f10691f == null) {
                            f10691f = new C4023n.C4026c(f10690e);
                        }
                    }
                }
                return f10691f;
            default:
                throw new UnsupportedOperationException();
        }
        return f10690e;
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if ((this.f10692a & 1) == 1) {
            i2 = 0 + CodedOutputStream.m13141g(1, this.f10693b);
        }
        if ((this.f10692a & 2) == 2) {
            i2 += CodedOutputStream.m13125b(2, this.f10694c);
        }
        if ((this.f10692a & 4) == 4) {
            i2 += CodedOutputStream.m13131d(3, this.f10695d);
        }
        int b = i2 + this.unknownFields.mo28087b();
        this.memoizedSerializedSize = b;
        return b;
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if ((this.f10692a & 1) == 1) {
            codedOutputStream.mo27977c(1, this.f10693b);
        }
        if ((this.f10692a & 2) == 2) {
            codedOutputStream.mo27970a(2, this.f10694c);
        }
        if ((this.f10692a & 4) == 4) {
            codedOutputStream.mo27966a(3, this.f10695d);
        }
        this.unknownFields.mo28084a(codedOutputStream);
    }
}
