package p163cz.msebera.android.httpclient.p182g0;

/* renamed from: cz.msebera.android.httpclient.g0.v */
/* compiled from: ParserCursor */
public class C5752v {

    /* renamed from: a */
    private final int f14849a;

    /* renamed from: b */
    private final int f14850b;

    /* renamed from: c */
    private int f14851c;

    public C5752v(int i, int i2) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("Lower bound cannot be negative");
        } else if (i <= i2) {
            this.f14849a = i;
            this.f14850b = i2;
            this.f14851c = i;
        } else {
            throw new IndexOutOfBoundsException("Lower bound cannot be greater then upper bound");
        }
    }

    /* renamed from: a */
    public void mo33404a(int i) {
        if (i < this.f14849a) {
            throw new IndexOutOfBoundsException("pos: " + i + " < lowerBound: " + this.f14849a);
        } else if (i <= this.f14850b) {
            this.f14851c = i;
        } else {
            throw new IndexOutOfBoundsException("pos: " + i + " > upperBound: " + this.f14850b);
        }
    }

    /* renamed from: b */
    public int mo33406b() {
        return this.f14851c;
    }

    /* renamed from: c */
    public int mo33407c() {
        return this.f14850b;
    }

    public String toString() {
        return '[' + Integer.toString(this.f14849a) + '>' + Integer.toString(this.f14851c) + '>' + Integer.toString(this.f14850b) + ']';
    }

    /* renamed from: a */
    public boolean mo33405a() {
        return this.f14851c >= this.f14850b;
    }
}
