package p118io.presage;

import java.util.NoSuchElementException;

/* renamed from: io.presage.hz */
public final class C6528hz extends C6461fm {

    /* renamed from: a */
    private final int f17059a;

    /* renamed from: b */
    private boolean f17060b;

    /* renamed from: c */
    private int f17061c;

    /* renamed from: d */
    private final int f17062d;

    public C6528hz(int i, int i2, int i3) {
        this.f17062d = i3;
        this.f17059a = i2;
        boolean z = true;
        if (i3 <= 0 ? i < i2 : i > i2) {
            z = false;
        }
        this.f17060b = z;
        this.f17061c = !z ? this.f17059a : i;
    }

    /* renamed from: a */
    public final int mo35491a() {
        int i = this.f17061c;
        if (i != this.f17059a) {
            this.f17061c = this.f17062d + i;
        } else if (this.f17060b) {
            this.f17060b = false;
        } else {
            throw new NoSuchElementException();
        }
        return i;
    }

    public final boolean hasNext() {
        return this.f17060b;
    }
}
