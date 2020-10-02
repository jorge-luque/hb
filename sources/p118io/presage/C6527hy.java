package p118io.presage;

/* renamed from: io.presage.hy */
public class C6527hy implements C6520hr, Iterable<Integer> {

    /* renamed from: a */
    public static final CamembertauCalvados f17055a = new CamembertauCalvados((byte) 0);

    /* renamed from: b */
    private final int f17056b;

    /* renamed from: c */
    private final int f17057c;

    /* renamed from: d */
    private final int f17058d = 1;

    /* renamed from: io.presage.hy$CamembertauCalvados */
    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        public /* synthetic */ CamembertauCalvados(byte b) {
            this();
        }
    }

    public C6527hy(int i, int i2) {
        this.f17056b = i;
        this.f17057c = C6469fu.m21355a(i, i2);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public C6461fm iterator() {
        return new C6528hz(this.f17056b, this.f17057c, this.f17058d);
    }

    /* renamed from: a */
    public final int mo35529a() {
        return this.f17056b;
    }

    /* renamed from: b */
    public final int mo35530b() {
        return this.f17057c;
    }

    /* renamed from: c */
    public final int mo35531c() {
        return this.f17058d;
    }

    /* renamed from: d */
    public boolean mo35532d() {
        return this.f17058d > 0 ? this.f17056b > this.f17057c : this.f17056b < this.f17057c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C6527hy)) {
            return false;
        }
        if (mo35532d() && ((C6527hy) obj).mo35532d()) {
            return true;
        }
        C6527hy hyVar = (C6527hy) obj;
        return this.f17056b == hyVar.f17056b && this.f17057c == hyVar.f17057c && this.f17058d == hyVar.f17058d;
    }

    public int hashCode() {
        if (mo35532d()) {
            return -1;
        }
        return (((this.f17056b * 31) + this.f17057c) * 31) + this.f17058d;
    }

    public String toString() {
        StringBuilder sb;
        int i;
        if (this.f17058d > 0) {
            sb = new StringBuilder();
            sb.append(this.f17056b);
            sb.append("..");
            sb.append(this.f17057c);
            sb.append(" step ");
            i = this.f17058d;
        } else {
            sb = new StringBuilder();
            sb.append(this.f17056b);
            sb.append(" downTo ");
            sb.append(this.f17057c);
            sb.append(" step ");
            i = -this.f17058d;
        }
        sb.append(i);
        return sb.toString();
    }
}
