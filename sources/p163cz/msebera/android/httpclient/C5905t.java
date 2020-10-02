package p163cz.msebera.android.httpclient;

import java.io.Serializable;

/* renamed from: cz.msebera.android.httpclient.t */
/* compiled from: HttpVersion */
public final class C5905t extends C5907v implements Serializable {

    /* renamed from: d */
    public static final C5905t f15128d = new C5905t(0, 9);

    /* renamed from: e */
    public static final C5905t f15129e = new C5905t(1, 0);

    /* renamed from: f */
    public static final C5905t f15130f = new C5905t(1, 1);
    private static final long serialVersionUID = -5856653513894415344L;

    public C5905t(int i, int i2) {
        super("HTTP", i, i2);
    }

    /* renamed from: a */
    public C5907v mo33695a(int i, int i2) {
        if (i == this.f15132b && i2 == this.f15133c) {
            return this;
        }
        if (i == 1) {
            if (i2 == 0) {
                return f15129e;
            }
            if (i2 == 1) {
                return f15130f;
            }
        }
        if (i == 0 && i2 == 9) {
            return f15128d;
        }
        return new C5905t(i, i2);
    }
}
