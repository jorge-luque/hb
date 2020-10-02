package com.google.firebase.remoteconfig.p131m;

import com.google.protobuf.C4013g;
import com.google.protobuf.C4018k;
import com.google.protobuf.C4023n;
import com.google.protobuf.C4058x;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.IOException;

/* renamed from: com.google.firebase.remoteconfig.m.l */
/* compiled from: com.google.firebase:firebase-config@@19.1.4 */
public final class C3880l extends C4023n<C3880l, C3881a> implements C3882m {
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final C3880l f10709e;

    /* renamed from: f */
    private static volatile C4058x<C3880l> f10710f;

    /* renamed from: a */
    private int f10711a;

    /* renamed from: b */
    private int f10712b;

    /* renamed from: c */
    private long f10713c;

    /* renamed from: d */
    private String f10714d = "";

    /* renamed from: com.google.firebase.remoteconfig.m.l$a */
    /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
    public static final class C3881a extends C4023n.C4025b<C3880l, C3881a> implements C3882m {
        /* synthetic */ C3881a(C3864a aVar) {
            this();
        }

        private C3881a() {
            super(C3880l.f10709e);
        }
    }

    static {
        C3880l lVar = new C3880l();
        f10709e = lVar;
        lVar.makeImmutable();
    }

    private C3880l() {
    }

    public static C4058x<C3880l> parser() {
        return f10709e.getParserForType();
    }

    /* renamed from: a */
    public boolean mo27627a() {
        return (this.f10711a & 2) == 2;
    }

    /* renamed from: b */
    public boolean mo27628b() {
        return (this.f10711a & 1) == 1;
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(C4023n.C4035k kVar, Object obj, Object obj2) {
        switch (C3864a.f10678a[kVar.ordinal()]) {
            case 1:
                return new C3880l();
            case 2:
                return f10709e;
            case 3:
                return null;
            case 4:
                return new C3881a((C3864a) null);
            case 5:
                C4023n.C4036l lVar = (C4023n.C4036l) obj;
                C3880l lVar2 = (C3880l) obj2;
                this.f10712b = lVar.mo28215a(mo27628b(), this.f10712b, lVar2.mo27628b(), lVar2.f10712b);
                this.f10713c = lVar.mo28216a(mo27627a(), this.f10713c, lVar2.mo27627a(), lVar2.f10713c);
                this.f10714d = lVar.mo28222a(hasNamespace(), this.f10714d, lVar2.hasNamespace(), lVar2.f10714d);
                if (lVar == C4023n.C4034j.f10839a) {
                    this.f10711a |= lVar2.f10711a;
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
                                this.f10711a |= 1;
                                this.f10712b = gVar.mo28145g();
                            } else if (q == 17) {
                                this.f10711a |= 2;
                                this.f10713c = gVar.mo28144f();
                            } else if (q == 26) {
                                String o = gVar.mo28153o();
                                this.f10711a |= 4;
                                this.f10714d = o;
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
                if (f10710f == null) {
                    synchronized (C3880l.class) {
                        if (f10710f == null) {
                            f10710f = new C4023n.C4026c(f10709e);
                        }
                    }
                }
                return f10710f;
            default:
                throw new UnsupportedOperationException();
        }
        return f10709e;
    }

    public String getNamespace() {
        return this.f10714d;
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if ((this.f10711a & 1) == 1) {
            i2 = 0 + CodedOutputStream.m13141g(1, this.f10712b);
        }
        if ((this.f10711a & 2) == 2) {
            i2 += CodedOutputStream.m13131d(2, this.f10713c);
        }
        if ((this.f10711a & 4) == 4) {
            i2 += CodedOutputStream.m13124b(3, getNamespace());
        }
        int b = i2 + this.unknownFields.mo28087b();
        this.memoizedSerializedSize = b;
        return b;
    }

    public boolean hasNamespace() {
        return (this.f10711a & 4) == 4;
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if ((this.f10711a & 1) == 1) {
            codedOutputStream.mo27977c(1, this.f10712b);
        }
        if ((this.f10711a & 2) == 2) {
            codedOutputStream.mo27966a(2, this.f10713c);
        }
        if ((this.f10711a & 4) == 4) {
            codedOutputStream.mo27969a(3, getNamespace());
        }
        this.unknownFields.mo28084a(codedOutputStream);
    }
}
