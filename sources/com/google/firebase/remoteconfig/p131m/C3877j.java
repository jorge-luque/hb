package com.google.firebase.remoteconfig.p131m;

import com.google.firebase.remoteconfig.p131m.C3865b;
import com.google.firebase.remoteconfig.p131m.C3871f;
import com.google.protobuf.C4013g;
import com.google.protobuf.C4018k;
import com.google.protobuf.C4023n;
import com.google.protobuf.C4038p;
import com.google.protobuf.C4054u;
import com.google.protobuf.C4058x;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.google.firebase.remoteconfig.m.j */
/* compiled from: com.google.firebase:firebase-config@@19.1.4 */
public final class C3877j extends C4023n<C3877j, C3878a> implements C3879k {
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static final C3877j f10701g;

    /* renamed from: h */
    private static volatile C4058x<C3877j> f10702h;

    /* renamed from: a */
    private int f10703a;

    /* renamed from: b */
    private C3865b f10704b;

    /* renamed from: c */
    private C3865b f10705c;

    /* renamed from: d */
    private C3865b f10706d;

    /* renamed from: e */
    private C3871f f10707e;

    /* renamed from: f */
    private C4038p.C4046h<C3880l> f10708f = C4023n.emptyProtobufList();

    /* renamed from: com.google.firebase.remoteconfig.m.j$a */
    /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
    public static final class C3878a extends C4023n.C4025b<C3877j, C3878a> implements C3879k {
        /* synthetic */ C3878a(C3864a aVar) {
            this();
        }

        private C3878a() {
            super(C3877j.f10701g);
        }
    }

    static {
        C3877j jVar = new C3877j();
        f10701g = jVar;
        jVar.makeImmutable();
    }

    private C3877j() {
    }

    public static C3877j parseFrom(InputStream inputStream) throws IOException {
        return (C3877j) C4023n.parseFrom(f10701g, inputStream);
    }

    /* renamed from: a */
    public C3865b mo27623a() {
        C3865b bVar = this.f10705c;
        return bVar == null ? C3865b.getDefaultInstance() : bVar;
    }

    /* renamed from: b */
    public C3865b mo27624b() {
        C3865b bVar = this.f10706d;
        return bVar == null ? C3865b.getDefaultInstance() : bVar;
    }

    /* renamed from: c */
    public C3865b mo27625c() {
        C3865b bVar = this.f10704b;
        return bVar == null ? C3865b.getDefaultInstance() : bVar;
    }

    /* renamed from: d */
    public C3871f mo27626d() {
        C3871f fVar = this.f10707e;
        return fVar == null ? C3871f.getDefaultInstance() : fVar;
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(C4023n.C4035k kVar, Object obj, Object obj2) {
        switch (C3864a.f10678a[kVar.ordinal()]) {
            case 1:
                return new C3877j();
            case 2:
                return f10701g;
            case 3:
                this.f10708f.mo28079t();
                return null;
            case 4:
                return new C3878a((C3864a) null);
            case 5:
                C4023n.C4036l lVar = (C4023n.C4036l) obj;
                C3877j jVar = (C3877j) obj2;
                this.f10704b = (C3865b) lVar.mo28221a(this.f10704b, jVar.f10704b);
                this.f10705c = (C3865b) lVar.mo28221a(this.f10705c, jVar.f10705c);
                this.f10706d = (C3865b) lVar.mo28221a(this.f10706d, jVar.f10706d);
                this.f10707e = (C3871f) lVar.mo28221a(this.f10707e, jVar.f10707e);
                this.f10708f = lVar.mo28220a(this.f10708f, jVar.f10708f);
                if (lVar == C4023n.C4034j.f10839a) {
                    this.f10703a |= jVar.f10703a;
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
                                C3865b.C3866a aVar = (this.f10703a & 1) == 1 ? (C3865b.C3866a) this.f10704b.toBuilder() : null;
                                C3865b bVar = (C3865b) gVar.mo28133a(C3865b.parser(), kVar2);
                                this.f10704b = bVar;
                                if (aVar != null) {
                                    aVar.mergeFrom(bVar);
                                    this.f10704b = (C3865b) aVar.buildPartial();
                                }
                                this.f10703a |= 1;
                            } else if (q == 18) {
                                C3865b.C3866a aVar2 = (this.f10703a & 2) == 2 ? (C3865b.C3866a) this.f10705c.toBuilder() : null;
                                C3865b bVar2 = (C3865b) gVar.mo28133a(C3865b.parser(), kVar2);
                                this.f10705c = bVar2;
                                if (aVar2 != null) {
                                    aVar2.mergeFrom(bVar2);
                                    this.f10705c = (C3865b) aVar2.buildPartial();
                                }
                                this.f10703a |= 2;
                            } else if (q == 26) {
                                C3865b.C3866a aVar3 = (this.f10703a & 4) == 4 ? (C3865b.C3866a) this.f10706d.toBuilder() : null;
                                C3865b bVar3 = (C3865b) gVar.mo28133a(C3865b.parser(), kVar2);
                                this.f10706d = bVar3;
                                if (aVar3 != null) {
                                    aVar3.mergeFrom(bVar3);
                                    this.f10706d = (C3865b) aVar3.buildPartial();
                                }
                                this.f10703a |= 4;
                            } else if (q == 34) {
                                C3871f.C3872a aVar4 = (this.f10703a & 8) == 8 ? (C3871f.C3872a) this.f10707e.toBuilder() : null;
                                C3871f fVar = (C3871f) gVar.mo28133a(C3871f.parser(), kVar2);
                                this.f10707e = fVar;
                                if (aVar4 != null) {
                                    aVar4.mergeFrom(fVar);
                                    this.f10707e = (C3871f) aVar4.buildPartial();
                                }
                                this.f10703a |= 8;
                            } else if (q == 42) {
                                if (!this.f10708f.mo28080v()) {
                                    this.f10708f = C4023n.mutableCopy(this.f10708f);
                                }
                                this.f10708f.add((C3880l) gVar.mo28133a(C3880l.parser(), kVar2));
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
                if (f10702h == null) {
                    synchronized (C3877j.class) {
                        if (f10702h == null) {
                            f10702h = new C4023n.C4026c(f10701g);
                        }
                    }
                }
                return f10702h;
            default:
                throw new UnsupportedOperationException();
        }
        return f10701g;
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int b = (this.f10703a & 1) == 1 ? CodedOutputStream.m13123b(1, (C4054u) mo27625c()) + 0 : 0;
        if ((this.f10703a & 2) == 2) {
            b += CodedOutputStream.m13123b(2, (C4054u) mo27623a());
        }
        if ((this.f10703a & 4) == 4) {
            b += CodedOutputStream.m13123b(3, (C4054u) mo27624b());
        }
        if ((this.f10703a & 8) == 8) {
            b += CodedOutputStream.m13123b(4, (C4054u) mo27626d());
        }
        for (int i2 = 0; i2 < this.f10708f.size(); i2++) {
            b += CodedOutputStream.m13123b(5, (C4054u) this.f10708f.get(i2));
        }
        int b2 = b + this.unknownFields.mo28087b();
        this.memoizedSerializedSize = b2;
        return b2;
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if ((this.f10703a & 1) == 1) {
            codedOutputStream.mo27968a(1, (C4054u) mo27625c());
        }
        if ((this.f10703a & 2) == 2) {
            codedOutputStream.mo27968a(2, (C4054u) mo27623a());
        }
        if ((this.f10703a & 4) == 4) {
            codedOutputStream.mo27968a(3, (C4054u) mo27624b());
        }
        if ((this.f10703a & 8) == 8) {
            codedOutputStream.mo27968a(4, (C4054u) mo27626d());
        }
        for (int i = 0; i < this.f10708f.size(); i++) {
            codedOutputStream.mo27968a(5, (C4054u) this.f10708f.get(i));
        }
        this.unknownFields.mo28084a(codedOutputStream);
    }
}
