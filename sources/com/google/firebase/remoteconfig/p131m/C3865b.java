package com.google.firebase.remoteconfig.p131m;

import com.google.protobuf.C3995f;
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

/* renamed from: com.google.firebase.remoteconfig.m.b */
/* compiled from: com.google.firebase:firebase-config@@19.1.4 */
public final class C3865b extends C4023n<C3865b, C3866a> implements C3867c {
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final C3865b f10679e;

    /* renamed from: f */
    private static volatile C4058x<C3865b> f10680f;

    /* renamed from: a */
    private int f10681a;

    /* renamed from: b */
    private C4038p.C4046h<C3874h> f10682b = C4023n.emptyProtobufList();

    /* renamed from: c */
    private long f10683c;

    /* renamed from: d */
    private C4038p.C4046h<C3995f> f10684d = C4023n.emptyProtobufList();

    /* renamed from: com.google.firebase.remoteconfig.m.b$a */
    /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
    public static final class C3866a extends C4023n.C4025b<C3865b, C3866a> implements C3867c {
        /* synthetic */ C3866a(C3864a aVar) {
            this();
        }

        private C3866a() {
            super(C3865b.f10679e);
        }
    }

    static {
        C3865b bVar = new C3865b();
        f10679e = bVar;
        bVar.makeImmutable();
    }

    private C3865b() {
    }

    public static C3865b getDefaultInstance() {
        return f10679e;
    }

    public static C4058x<C3865b> parser() {
        return f10679e.getParserForType();
    }

    /* renamed from: a */
    public List<C3874h> mo27609a() {
        return this.f10682b;
    }

    /* renamed from: b */
    public long mo27610b() {
        return this.f10683c;
    }

    /* renamed from: c */
    public boolean mo27611c() {
        return (this.f10681a & 1) == 1;
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(C4023n.C4035k kVar, Object obj, Object obj2) {
        switch (C3864a.f10678a[kVar.ordinal()]) {
            case 1:
                return new C3865b();
            case 2:
                return f10679e;
            case 3:
                this.f10682b.mo28079t();
                this.f10684d.mo28079t();
                return null;
            case 4:
                return new C3866a((C3864a) null);
            case 5:
                C4023n.C4036l lVar = (C4023n.C4036l) obj;
                C3865b bVar = (C3865b) obj2;
                this.f10682b = lVar.mo28220a(this.f10682b, bVar.f10682b);
                this.f10683c = lVar.mo28216a(mo27611c(), this.f10683c, bVar.mo27611c(), bVar.f10683c);
                this.f10684d = lVar.mo28220a(this.f10684d, bVar.f10684d);
                if (lVar == C4023n.C4034j.f10839a) {
                    this.f10681a |= bVar.f10681a;
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
                                if (!this.f10682b.mo28080v()) {
                                    this.f10682b = C4023n.mutableCopy(this.f10682b);
                                }
                                this.f10682b.add((C3874h) gVar.mo28133a(C3874h.parser(), kVar2));
                            } else if (q == 17) {
                                this.f10681a |= 1;
                                this.f10683c = gVar.mo28144f();
                            } else if (q == 26) {
                                if (!this.f10684d.mo28080v()) {
                                    this.f10684d = C4023n.mutableCopy(this.f10684d);
                                }
                                this.f10684d.add(gVar.mo28139c());
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
                if (f10680f == null) {
                    synchronized (C3865b.class) {
                        if (f10680f == null) {
                            f10680f = new C4023n.C4026c(f10679e);
                        }
                    }
                }
                return f10680f;
            default:
                throw new UnsupportedOperationException();
        }
        return f10679e;
    }

    public List<C3995f> getExperimentPayloadList() {
        return this.f10684d;
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f10682b.size(); i3++) {
            i2 += CodedOutputStream.m13123b(1, (C4054u) this.f10682b.get(i3));
        }
        if ((this.f10681a & 1) == 1) {
            i2 += CodedOutputStream.m13131d(2, this.f10683c);
        }
        int i4 = 0;
        for (int i5 = 0; i5 < this.f10684d.size(); i5++) {
            i4 += CodedOutputStream.m13116a(this.f10684d.get(i5));
        }
        int size = i2 + i4 + (getExperimentPayloadList().size() * 1) + this.unknownFields.mo28087b();
        this.memoizedSerializedSize = size;
        return size;
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.f10682b.size(); i++) {
            codedOutputStream.mo27968a(1, (C4054u) this.f10682b.get(i));
        }
        if ((this.f10681a & 1) == 1) {
            codedOutputStream.mo27966a(2, this.f10683c);
        }
        for (int i2 = 0; i2 < this.f10684d.size(); i2++) {
            codedOutputStream.mo27967a(3, this.f10684d.get(i2));
        }
        this.unknownFields.mo28084a(codedOutputStream);
    }
}
