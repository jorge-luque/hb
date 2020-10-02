package com.google.firebase.remoteconfig.p131m;

import com.google.protobuf.C3995f;
import com.google.protobuf.C4013g;
import com.google.protobuf.C4018k;
import com.google.protobuf.C4023n;
import com.google.protobuf.C4058x;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.IOException;

/* renamed from: com.google.firebase.remoteconfig.m.d */
/* compiled from: com.google.firebase:firebase-config@@19.1.4 */
public final class C3868d extends C4023n<C3868d, C3869a> implements C3870e {
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final C3868d f10685d;

    /* renamed from: e */
    private static volatile C4058x<C3868d> f10686e;

    /* renamed from: a */
    private int f10687a;

    /* renamed from: b */
    private String f10688b = "";

    /* renamed from: c */
    private C3995f f10689c = C3995f.f10759b;

    /* renamed from: com.google.firebase.remoteconfig.m.d$a */
    /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
    public static final class C3869a extends C4023n.C4025b<C3868d, C3869a> implements C3870e {
        /* synthetic */ C3869a(C3864a aVar) {
            this();
        }

        private C3869a() {
            super(C3868d.f10685d);
        }
    }

    static {
        C3868d dVar = new C3868d();
        f10685d = dVar;
        dVar.makeImmutable();
    }

    private C3868d() {
    }

    public static C4058x<C3868d> parser() {
        return f10685d.getParserForType();
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(C4023n.C4035k kVar, Object obj, Object obj2) {
        switch (C3864a.f10678a[kVar.ordinal()]) {
            case 1:
                return new C3868d();
            case 2:
                return f10685d;
            case 3:
                return null;
            case 4:
                return new C3869a((C3864a) null);
            case 5:
                C4023n.C4036l lVar = (C4023n.C4036l) obj;
                C3868d dVar = (C3868d) obj2;
                this.f10688b = lVar.mo28222a(hasKey(), this.f10688b, dVar.hasKey(), dVar.f10688b);
                this.f10689c = lVar.mo28218a(hasValue(), this.f10689c, dVar.hasValue(), dVar.f10689c);
                if (lVar == C4023n.C4034j.f10839a) {
                    this.f10687a |= dVar.f10687a;
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
                            if (q == 10) {
                                String o = gVar.mo28153o();
                                this.f10687a = 1 | this.f10687a;
                                this.f10688b = o;
                            } else if (q == 18) {
                                this.f10687a |= 2;
                                this.f10689c = gVar.mo28139c();
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
                if (f10686e == null) {
                    synchronized (C3868d.class) {
                        if (f10686e == null) {
                            f10686e = new C4023n.C4026c(f10685d);
                        }
                    }
                }
                return f10686e;
            default:
                throw new UnsupportedOperationException();
        }
        return f10685d;
    }

    public String getKey() {
        return this.f10688b;
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if ((this.f10687a & 1) == 1) {
            i2 = 0 + CodedOutputStream.m13124b(1, getKey());
        }
        if ((this.f10687a & 2) == 2) {
            i2 += CodedOutputStream.m13122b(2, this.f10689c);
        }
        int b = i2 + this.unknownFields.mo28087b();
        this.memoizedSerializedSize = b;
        return b;
    }

    public C3995f getValue() {
        return this.f10689c;
    }

    public boolean hasKey() {
        return (this.f10687a & 1) == 1;
    }

    public boolean hasValue() {
        return (this.f10687a & 2) == 2;
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if ((this.f10687a & 1) == 1) {
            codedOutputStream.mo27969a(1, getKey());
        }
        if ((this.f10687a & 2) == 2) {
            codedOutputStream.mo27967a(2, this.f10689c);
        }
        this.unknownFields.mo28084a(codedOutputStream);
    }
}
