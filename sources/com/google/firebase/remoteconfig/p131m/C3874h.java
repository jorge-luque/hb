package com.google.firebase.remoteconfig.p131m;

import com.google.protobuf.C4013g;
import com.google.protobuf.C4018k;
import com.google.protobuf.C4023n;
import com.google.protobuf.C4038p;
import com.google.protobuf.C4054u;
import com.google.protobuf.C4058x;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.IOException;
import java.util.List;

/* renamed from: com.google.firebase.remoteconfig.m.h */
/* compiled from: com.google.firebase:firebase-config@@19.1.4 */
public final class C3874h extends C4023n<C3874h, C3875a> implements C3876i {
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final C3874h f10696d;

    /* renamed from: e */
    private static volatile C4058x<C3874h> f10697e;

    /* renamed from: a */
    private int f10698a;

    /* renamed from: b */
    private String f10699b = "";

    /* renamed from: c */
    private C4038p.C4046h<C3868d> f10700c = C4023n.emptyProtobufList();

    /* renamed from: com.google.firebase.remoteconfig.m.h$a */
    /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
    public static final class C3875a extends C4023n.C4025b<C3874h, C3875a> implements C3876i {
        /* synthetic */ C3875a(C3864a aVar) {
            this();
        }

        private C3875a() {
            super(C3874h.f10696d);
        }
    }

    static {
        C3874h hVar = new C3874h();
        f10696d = hVar;
        hVar.makeImmutable();
    }

    private C3874h() {
    }

    public static C4058x<C3874h> parser() {
        return f10696d.getParserForType();
    }

    /* renamed from: a */
    public List<C3868d> mo27620a() {
        return this.f10700c;
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(C4023n.C4035k kVar, Object obj, Object obj2) {
        switch (C3864a.f10678a[kVar.ordinal()]) {
            case 1:
                return new C3874h();
            case 2:
                return f10696d;
            case 3:
                this.f10700c.mo28079t();
                return null;
            case 4:
                return new C3875a((C3864a) null);
            case 5:
                C4023n.C4036l lVar = (C4023n.C4036l) obj;
                C3874h hVar = (C3874h) obj2;
                this.f10699b = lVar.mo28222a(hasNamespace(), this.f10699b, hVar.hasNamespace(), hVar.f10699b);
                this.f10700c = lVar.mo28220a(this.f10700c, hVar.f10700c);
                if (lVar == C4023n.C4034j.f10839a) {
                    this.f10698a |= hVar.f10698a;
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
                                this.f10698a = 1 | this.f10698a;
                                this.f10699b = o;
                            } else if (q == 18) {
                                if (!this.f10700c.mo28080v()) {
                                    this.f10700c = C4023n.mutableCopy(this.f10700c);
                                }
                                this.f10700c.add((C3868d) gVar.mo28133a(C3868d.parser(), kVar2));
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
                if (f10697e == null) {
                    synchronized (C3874h.class) {
                        if (f10697e == null) {
                            f10697e = new C4023n.C4026c(f10696d);
                        }
                    }
                }
                return f10697e;
            default:
                throw new UnsupportedOperationException();
        }
        return f10696d;
    }

    public String getNamespace() {
        return this.f10699b;
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int b = (this.f10698a & 1) == 1 ? CodedOutputStream.m13124b(1, getNamespace()) + 0 : 0;
        for (int i2 = 0; i2 < this.f10700c.size(); i2++) {
            b += CodedOutputStream.m13123b(2, (C4054u) this.f10700c.get(i2));
        }
        int b2 = b + this.unknownFields.mo28087b();
        this.memoizedSerializedSize = b2;
        return b2;
    }

    public boolean hasNamespace() {
        return (this.f10698a & 1) == 1;
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if ((this.f10698a & 1) == 1) {
            codedOutputStream.mo27969a(1, getNamespace());
        }
        for (int i = 0; i < this.f10700c.size(); i++) {
            codedOutputStream.mo27968a(2, (C4054u) this.f10700c.get(i));
        }
        this.unknownFields.mo28084a(codedOutputStream);
    }
}
