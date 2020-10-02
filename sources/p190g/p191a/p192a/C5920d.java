package p190g.p191a.p192a;

import com.google.protobuf.C4013g;
import com.google.protobuf.C4018k;
import com.google.protobuf.C4023n;
import com.google.protobuf.C4038p;
import com.google.protobuf.C4054u;
import com.google.protobuf.C4058x;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.IOException;

/* renamed from: g.a.a.d */
/* compiled from: com.google.firebase:firebase-abt@@19.0.1 */
public final class C5920d extends C4023n<C5920d, C5921a> implements C5924e {
    /* access modifiers changed from: private */

    /* renamed from: o */
    public static final C5920d f15142o;

    /* renamed from: p */
    private static volatile C4058x<C5920d> f15143p;

    /* renamed from: a */
    private int f15144a;

    /* renamed from: b */
    private String f15145b = "";

    /* renamed from: c */
    private String f15146c = "";

    /* renamed from: d */
    private long f15147d;

    /* renamed from: e */
    private String f15148e = "";

    /* renamed from: f */
    private long f15149f;

    /* renamed from: g */
    private long f15150g;

    /* renamed from: h */
    private String f15151h = "";

    /* renamed from: i */
    private String f15152i = "";

    /* renamed from: j */
    private String f15153j = "";

    /* renamed from: k */
    private String f15154k = "";

    /* renamed from: l */
    private String f15155l = "";

    /* renamed from: m */
    private int f15156m;

    /* renamed from: n */
    private C4038p.C4046h<C5917b> f15157n = C4023n.emptyProtobufList();

    /* renamed from: g.a.a.d$a */
    /* compiled from: com.google.firebase:firebase-abt@@19.0.1 */
    public static final class C5921a extends C4023n.C4025b<C5920d, C5921a> implements C5924e {
        /* synthetic */ C5921a(C5916a aVar) {
            this();
        }

        private C5921a() {
            super(C5920d.f15142o);
        }
    }

    /* renamed from: g.a.a.d$b */
    /* compiled from: com.google.firebase:firebase-abt@@19.0.1 */
    public enum C5922b implements C4038p.C4041c {
        POLICY_UNSPECIFIED(0),
        DISCARD_OLDEST(1),
        IGNORE_NEWEST(2),
        UNRECOGNIZED(-1);
        

        /* renamed from: a */
        private final int f15162a;

        /* renamed from: g.a.a.d$b$a */
        /* compiled from: com.google.firebase:firebase-abt@@19.0.1 */
        class C5923a implements C4038p.C4042d<C5922b> {
            C5923a() {
            }
        }

        static {
            POLICY_UNSPECIFIED = new C5922b("POLICY_UNSPECIFIED", 0, 0);
            DISCARD_OLDEST = new C5922b("DISCARD_OLDEST", 1, 1);
            IGNORE_NEWEST = new C5922b("IGNORE_NEWEST", 2, 2);
            UNRECOGNIZED = new C5922b("UNRECOGNIZED", 3, -1);
            new C5923a();
        }

        private C5922b(int i) {
            this.f15162a = i;
        }

        /* renamed from: a */
        public final int mo33718a() {
            return this.f15162a;
        }
    }

    static {
        C5920d dVar = new C5920d();
        f15142o = dVar;
        dVar.makeImmutable();
    }

    private C5920d() {
    }

    public static C5920d parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (C5920d) C4023n.parseFrom(f15142o, bArr);
    }

    /* renamed from: a */
    public String mo33707a() {
        return this.f15152i;
    }

    /* renamed from: b */
    public String mo33708b() {
        return this.f15153j;
    }

    /* renamed from: c */
    public String mo33709c() {
        return this.f15145b;
    }

    /* renamed from: d */
    public long mo33710d() {
        return this.f15147d;
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(C4023n.C4035k kVar, Object obj, Object obj2) {
        boolean z = false;
        switch (C5916a.f15138a[kVar.ordinal()]) {
            case 1:
                return new C5920d();
            case 2:
                return f15142o;
            case 3:
                this.f15157n.mo28079t();
                return null;
            case 4:
                return new C5921a((C5916a) null);
            case 5:
                C4023n.C4036l lVar = (C4023n.C4036l) obj;
                C5920d dVar = (C5920d) obj2;
                this.f15145b = lVar.mo28222a(!this.f15145b.isEmpty(), this.f15145b, !dVar.f15145b.isEmpty(), dVar.f15145b);
                this.f15146c = lVar.mo28222a(!this.f15146c.isEmpty(), this.f15146c, !dVar.f15146c.isEmpty(), dVar.f15146c);
                this.f15147d = lVar.mo28216a(this.f15147d != 0, this.f15147d, dVar.f15147d != 0, dVar.f15147d);
                this.f15148e = lVar.mo28222a(!this.f15148e.isEmpty(), this.f15148e, !dVar.f15148e.isEmpty(), dVar.f15148e);
                this.f15149f = lVar.mo28216a(this.f15149f != 0, this.f15149f, dVar.f15149f != 0, dVar.f15149f);
                this.f15150g = lVar.mo28216a(this.f15150g != 0, this.f15150g, dVar.f15150g != 0, dVar.f15150g);
                this.f15151h = lVar.mo28222a(!this.f15151h.isEmpty(), this.f15151h, !dVar.f15151h.isEmpty(), dVar.f15151h);
                this.f15152i = lVar.mo28222a(!this.f15152i.isEmpty(), this.f15152i, !dVar.f15152i.isEmpty(), dVar.f15152i);
                this.f15153j = lVar.mo28222a(!this.f15153j.isEmpty(), this.f15153j, !dVar.f15153j.isEmpty(), dVar.f15153j);
                this.f15154k = lVar.mo28222a(!this.f15154k.isEmpty(), this.f15154k, !dVar.f15154k.isEmpty(), dVar.f15154k);
                this.f15155l = lVar.mo28222a(!this.f15155l.isEmpty(), this.f15155l, !dVar.f15155l.isEmpty(), dVar.f15155l);
                boolean z2 = this.f15156m != 0;
                int i = this.f15156m;
                if (dVar.f15156m != 0) {
                    z = true;
                }
                this.f15156m = lVar.mo28215a(z2, i, z, dVar.f15156m);
                this.f15157n = lVar.mo28220a(this.f15157n, dVar.f15157n);
                if (lVar == C4023n.C4034j.f10839a) {
                    this.f15144a |= dVar.f15144a;
                }
                return this;
            case 6:
                C4013g gVar = (C4013g) obj;
                C4018k kVar2 = (C4018k) obj2;
                while (!z) {
                    try {
                        int q = gVar.mo28155q();
                        switch (q) {
                            case 0:
                                z = true;
                                break;
                            case 10:
                                this.f15145b = gVar.mo28154p();
                                break;
                            case 18:
                                this.f15146c = gVar.mo28154p();
                                break;
                            case 24:
                                this.f15147d = gVar.mo28146h();
                                break;
                            case 34:
                                this.f15148e = gVar.mo28154p();
                                break;
                            case 40:
                                this.f15149f = gVar.mo28146h();
                                break;
                            case 48:
                                this.f15150g = gVar.mo28146h();
                                break;
                            case 58:
                                this.f15151h = gVar.mo28154p();
                                break;
                            case 66:
                                this.f15152i = gVar.mo28154p();
                                break;
                            case 74:
                                this.f15153j = gVar.mo28154p();
                                break;
                            case 82:
                                this.f15154k = gVar.mo28154p();
                                break;
                            case 90:
                                this.f15155l = gVar.mo28154p();
                                break;
                            case 96:
                                this.f15156m = gVar.mo28140d();
                                break;
                            case 106:
                                if (!this.f15157n.mo28080v()) {
                                    this.f15157n = C4023n.mutableCopy(this.f15157n);
                                }
                                this.f15157n.add((C5917b) gVar.mo28133a(C5917b.parser(), kVar2));
                                break;
                            default:
                                if (gVar.mo28141d(q)) {
                                    break;
                                }
                                z = true;
                                break;
                        }
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
                if (f15143p == null) {
                    synchronized (C5920d.class) {
                        if (f15143p == null) {
                            f15143p = new C4023n.C4026c(f15142o);
                        }
                    }
                }
                return f15143p;
            default:
                throw new UnsupportedOperationException();
        }
        return f15142o;
    }

    /* renamed from: e */
    public String mo33711e() {
        return this.f15151h;
    }

    /* renamed from: f */
    public long mo33712f() {
        return this.f15150g;
    }

    /* renamed from: g */
    public String mo33713g() {
        return this.f15154k;
    }

    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int b = !this.f15145b.isEmpty() ? CodedOutputStream.m13124b(1, mo33709c()) + 0 : 0;
        if (!this.f15146c.isEmpty()) {
            b += CodedOutputStream.m13124b(2, mo33717k());
        }
        long j = this.f15147d;
        if (j != 0) {
            b += CodedOutputStream.m13135e(3, j);
        }
        if (!this.f15148e.isEmpty()) {
            b += CodedOutputStream.m13124b(4, mo33714h());
        }
        long j2 = this.f15149f;
        if (j2 != 0) {
            b += CodedOutputStream.m13135e(5, j2);
        }
        long j3 = this.f15150g;
        if (j3 != 0) {
            b += CodedOutputStream.m13135e(6, j3);
        }
        if (!this.f15151h.isEmpty()) {
            b += CodedOutputStream.m13124b(7, mo33711e());
        }
        if (!this.f15152i.isEmpty()) {
            b += CodedOutputStream.m13124b(8, mo33707a());
        }
        if (!this.f15153j.isEmpty()) {
            b += CodedOutputStream.m13124b(9, mo33708b());
        }
        if (!this.f15154k.isEmpty()) {
            b += CodedOutputStream.m13124b(10, mo33713g());
        }
        if (!this.f15155l.isEmpty()) {
            b += CodedOutputStream.m13124b(11, mo33716j());
        }
        if (this.f15156m != C5922b.POLICY_UNSPECIFIED.mo33718a()) {
            b += CodedOutputStream.m13134e(12, this.f15156m);
        }
        for (int i2 = 0; i2 < this.f15157n.size(); i2++) {
            b += CodedOutputStream.m13123b(13, (C4054u) this.f15157n.get(i2));
        }
        this.memoizedSerializedSize = b;
        return b;
    }

    /* renamed from: h */
    public String mo33714h() {
        return this.f15148e;
    }

    /* renamed from: i */
    public long mo33715i() {
        return this.f15149f;
    }

    /* renamed from: j */
    public String mo33716j() {
        return this.f15155l;
    }

    /* renamed from: k */
    public String mo33717k() {
        return this.f15146c;
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!this.f15145b.isEmpty()) {
            codedOutputStream.mo27969a(1, mo33709c());
        }
        if (!this.f15146c.isEmpty()) {
            codedOutputStream.mo27969a(2, mo33717k());
        }
        long j = this.f15147d;
        if (j != 0) {
            codedOutputStream.mo27975b(3, j);
        }
        if (!this.f15148e.isEmpty()) {
            codedOutputStream.mo27969a(4, mo33714h());
        }
        long j2 = this.f15149f;
        if (j2 != 0) {
            codedOutputStream.mo27975b(5, j2);
        }
        long j3 = this.f15150g;
        if (j3 != 0) {
            codedOutputStream.mo27975b(6, j3);
        }
        if (!this.f15151h.isEmpty()) {
            codedOutputStream.mo27969a(7, mo33711e());
        }
        if (!this.f15152i.isEmpty()) {
            codedOutputStream.mo27969a(8, mo33707a());
        }
        if (!this.f15153j.isEmpty()) {
            codedOutputStream.mo27969a(9, mo33708b());
        }
        if (!this.f15154k.isEmpty()) {
            codedOutputStream.mo27969a(10, mo33713g());
        }
        if (!this.f15155l.isEmpty()) {
            codedOutputStream.mo27969a(11, mo33716j());
        }
        if (this.f15156m != C5922b.POLICY_UNSPECIFIED.mo33718a()) {
            codedOutputStream.mo27965a(12, this.f15156m);
        }
        for (int i = 0; i < this.f15157n.size(); i++) {
            codedOutputStream.mo27968a(13, (C4054u) this.f15157n.get(i));
        }
    }
}
