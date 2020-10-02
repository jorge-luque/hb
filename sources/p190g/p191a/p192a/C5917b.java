package p190g.p191a.p192a;

import com.google.protobuf.C4013g;
import com.google.protobuf.C4018k;
import com.google.protobuf.C4023n;
import com.google.protobuf.C4058x;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.IOException;

/* renamed from: g.a.a.b */
/* compiled from: com.google.firebase:firebase-abt@@19.0.1 */
public final class C5917b extends C4023n<C5917b, C5918a> implements C5919c {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final C5917b f15139b;

    /* renamed from: c */
    private static volatile C4058x<C5917b> f15140c;

    /* renamed from: a */
    private String f15141a = "";

    /* renamed from: g.a.a.b$a */
    /* compiled from: com.google.firebase:firebase-abt@@19.0.1 */
    public static final class C5918a extends C4023n.C4025b<C5917b, C5918a> implements C5919c {
        /* synthetic */ C5918a(C5916a aVar) {
            this();
        }

        private C5918a() {
            super(C5917b.f15139b);
        }
    }

    static {
        C5917b bVar = new C5917b();
        f15139b = bVar;
        bVar.makeImmutable();
    }

    private C5917b() {
    }

    public static C4058x<C5917b> parser() {
        return f15139b.getParserForType();
    }

    /* renamed from: a */
    public String mo33706a() {
        return this.f15141a;
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(C4023n.C4035k kVar, Object obj, Object obj2) {
        switch (C5916a.f15138a[kVar.ordinal()]) {
            case 1:
                return new C5917b();
            case 2:
                return f15139b;
            case 3:
                return null;
            case 4:
                return new C5918a((C5916a) null);
            case 5:
                C5917b bVar = (C5917b) obj2;
                this.f15141a = ((C4023n.C4036l) obj).mo28222a(!this.f15141a.isEmpty(), this.f15141a, true ^ bVar.f15141a.isEmpty(), bVar.f15141a);
                C4023n.C4034j jVar = C4023n.C4034j.f10839a;
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
                                this.f15141a = gVar.mo28154p();
                            } else if (!gVar.mo28141d(q)) {
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
                if (f15140c == null) {
                    synchronized (C5917b.class) {
                        if (f15140c == null) {
                            f15140c = new C4023n.C4026c(f15139b);
                        }
                    }
                }
                return f15140c;
            default:
                throw new UnsupportedOperationException();
        }
        return f15139b;
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (!this.f15141a.isEmpty()) {
            i2 = 0 + CodedOutputStream.m13124b(1, mo33706a());
        }
        this.memoizedSerializedSize = i2;
        return i2;
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f15141a.isEmpty()) {
            codedOutputStream.mo27969a(1, mo33706a());
        }
    }
}
